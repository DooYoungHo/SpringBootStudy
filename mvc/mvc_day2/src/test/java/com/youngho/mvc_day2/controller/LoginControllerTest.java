package com.youngho.mvc_day2.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.cookie;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.youngho.mvc_day2.dto.LoginRequestDto;
import com.youngho.mvc_day2.repository.StudentRepository;
import jakarta.servlet.http.Cookie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = LoginController.class)
class LoginControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private StudentRepository studentRepository;

    @Test
    void loginPage_NoCookie_ShouldReturnLoginPage() throws Exception {
        mvc.perform(get("/login"))
            .andExpect(status().isOk())
            .andExpect(view().name("login"));
    }

    @Test
    void loginPage_WithCookie_ShouldRedirectToStudentPage() throws Exception {
        Cookie loginCookie = new Cookie("Login", "test123");

        mvc.perform(get("/login").cookie(loginCookie))
            .andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("/student/test123"));
    }

    @Test
    void doLogin_ValidCredentials_ShouldSetCookieAndRedirect() throws Exception {
        // given
        LoginRequestDto validLogin = new LoginRequestDto("test123", "password");

        when(studentRepository.matches(validLogin)).thenReturn(true);

        // when & then
        mvc.perform(post("/login")
                .flashAttr("loginRequestDto", validLogin))
            .andExpect(cookie().exists("Login"))
            .andExpect(cookie().value("Login", "test123"))
            .andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("/student/test123"));
    }

    @Test
    void doLogin_InvalidCredentials_ShouldRedirectToLogin() throws Exception {
        // given
        LoginRequestDto invalidLogin = new LoginRequestDto("test123", "wrongPassword");

        when(studentRepository.matches(invalidLogin)).thenReturn(false);

        // when & then
        mvc.perform(post("/login")
                .flashAttr("loginRequestDto", invalidLogin))
            .andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("/login"));
    }

    @Test
    void doLogin_InvalidInput_ShouldThrowException() throws Exception {
        // given
        LoginRequestDto invalidInput = new LoginRequestDto("", "password");

        // when & then
        mvc.perform(post("/login")
                .flashAttr("loginRequestDto", invalidInput))
            .andExpect(status().isBadRequest());
    }
}
