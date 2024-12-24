package com.youngho.mvc_day2.controller;

import com.youngho.mvc_day2.dto.StudentRequestDto;
import com.youngho.mvc_day2.repository.StudentRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class StudentRegisterController {

    private final StudentRepository studentRepository;

    @GetMapping("/student/register")
    public ModelAndView register() {
        return new ModelAndView("register");
    }

    @PostMapping("/student/register")
    public ModelAndView registerStudent(@Valid @ModelAttribute StudentRequestDto studentRequestDto,
        BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException();
        }

        studentRepository.saveStudent(studentRequestDto);

        return new ModelAndView("redirect:/");
    }
}
