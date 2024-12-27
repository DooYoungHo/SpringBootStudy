package com.youngho.mvc_day2.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.youngho.mvc_day2.dto.StudentRequestDto;
import com.youngho.mvc_day2.repository.StudentRepository;
import jakarta.servlet.http.Cookie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = StudentRegisterController.class)
class StudentRegisterControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private StudentRepository studentRepository;

    @Test
    void studentRegister_view() throws Exception {
        mvc.perform(get("/student/register")
                .cookie(new Cookie("Login", "test")))
            .andExpect(status().isOk())
            .andExpect(view().name("register"));
    }

    @Test
    void studentRegister_Success() throws Exception {
        // given
        StudentRequestDto studentRequestDto = new StudentRequestDto(
            "test2",
            "1234",
            "테스트",
            "test2@test.com",
            100,
            "test"
        );

        // when & then
        mvc.perform(post("/student/register")
            .flashAttr("studentRequestDto", studentRequestDto)
                .cookie(new Cookie("Login", "test")))
            .andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("/"));

        verify(studentRepository, times(1)).saveStudent(studentRequestDto);
    }

    @Test
    void studentRegister_Failed() throws Exception {
        // given
        StudentRequestDto studentRequestDto = new StudentRequestDto(
            null,
            null,
            null,
            null,
            100,
            null
        );

        mvc.perform(post("/student/register")
            .flashAttr("studentRequestDto", studentRequestDto)
                .cookie(new Cookie("Login", "test")))
            .andExpect(status().isOk())
            .andExpect(view().name("error"));
    }
}
