package com.youngho.mvc_day1.controller;

import com.youngho.mvc_day1.dto.RegisterDto;
import com.youngho.mvc_day1.entity.Student;
import com.youngho.mvc_day1.repository.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentRegisterController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/student/register")
    public ModelAndView doRegisterStudent(@ModelAttribute RegisterDto registerDto) {
        Student student = studentService.registerStudent(registerDto);

        return new ModelAndView("redirect:/student/" + student.getId());
    }

    @GetMapping("/student/register")
    public ModelAndView getRegisterStudent() {
        return new ModelAndView("student-register");
    }
}
