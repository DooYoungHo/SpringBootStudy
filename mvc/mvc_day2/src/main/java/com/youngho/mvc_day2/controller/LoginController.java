package com.youngho.mvc_day2.controller;

import com.youngho.mvc_day2.dto.LoginRequestDto;
import com.youngho.mvc_day2.repository.StudentRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final StudentRepository studentRepository;

    @GetMapping
    public ModelAndView loginPage(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();

        if (Objects.nonNull(cookies)) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equalsIgnoreCase("Login")) {
                    return new ModelAndView("redirect:/student/" + cookie.getValue());
                }
            }
        }

        return new ModelAndView("login");
    }

    @PostMapping
    public ModelAndView doLogin(@Valid @ModelAttribute LoginRequestDto loginRequestDto,
        HttpServletResponse response, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException("Bad Request");
        }

        if (studentRepository.matches(loginRequestDto)) {
            Cookie cookie = new Cookie("Login", loginRequestDto.id());
            cookie.setMaxAge(3600); // 1시간 설정
            cookie.setHttpOnly(true);
            cookie.setSecure(true);

            response.addCookie(cookie);
            return new ModelAndView("redirect:/student/" + loginRequestDto.id());
        }

        return new ModelAndView("redirect:/login");
    }
}
