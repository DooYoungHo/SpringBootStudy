package com.youngho.mvc_day1.controller;

import com.youngho.mvc_day1.dto.LoginDto;
import com.youngho.mvc_day1.repository.StudentService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentLoginController {

    @Autowired
    private StudentService serviceImpl;

    @GetMapping("/login")
    public ModelAndView getLogin(@CookieValue(name = "SESSION", required = false) String sessionId) {
        if (Objects.isNull(sessionId)) {
            return new ModelAndView("/login");
        } else {
            return new ModelAndView("redirect:/student-view");
        }
    }

    @PostMapping("/login")
    public ModelAndView doLogin(@ModelAttribute LoginDto loginDto, HttpServletResponse response) {
        if (serviceImpl.checkLogin(loginDto)) {
            Cookie cookie = new Cookie("SESSION", loginDto.id());
            response.addCookie(cookie);
            return new ModelAndView("redirect:/student/" + loginDto.id());
        } else {
            return new ModelAndView("redirect:/login");
        }
    }
}
