package com.youngho.mvc_day1.controller;

import com.youngho.mvc_day1.entity.Student;
import com.youngho.mvc_day1.repository.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @ModelAttribute("login")
    public boolean checkSession(@CookieValue(value = "SESSION", required = false) String session) {
        return session != null;
    }

    @GetMapping(value = "/student/{studentId}", params = "!hideScore")
    public ModelAndView mainPage(@PathVariable("studentId") String studentId,
        @ModelAttribute("login") boolean isLogin) {

        if (!isLogin) {
            return new ModelAndView("redirect:/login");
        }

        Student student = studentService.getStudent(studentId);

        ModelAndView modelAndView = new ModelAndView("/student-view");

        modelAndView.addObject("student", student);

        return modelAndView;
    }

    @GetMapping(value = "/student/{studentId}", params = "hideScore")
    public ModelAndView hideScorePage(
        @RequestParam(value = "hideScore", required = false) String hideScore,
        @PathVariable("studentId") String studentId,
        @ModelAttribute("login") boolean isLogin) {

        if (!isLogin) {
            return new ModelAndView("redirect:/login");
        }

        ModelAndView modelAndView = new ModelAndView("/student-view");

        Student student = studentService.getStudent(studentId);

        modelAndView.addObject("student", student);
        if (hideScore.equalsIgnoreCase("yes")) {
            modelAndView.addObject("hideScore", "yes");
            return modelAndView;
        }

        return modelAndView;
    }
}
