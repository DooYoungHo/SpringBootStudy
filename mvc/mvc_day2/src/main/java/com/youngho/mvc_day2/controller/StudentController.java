package com.youngho.mvc_day2.controller;

import com.youngho.mvc_day2.entity.Student;
import com.youngho.mvc_day2.exception.StudentNotFoundException;
import com.youngho.mvc_day2.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class StudentController {

    private final StudentRepository studentRepository;

    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void notFoundException() {

    }

    @GetMapping("/student/{studentId}")
    public ModelAndView getStudent(@PathVariable("studentId") String studentId) {

        ModelAndView mv = new ModelAndView("student");

        Student student = studentRepository.getStudent(studentId);

        mv.addObject("student", student);

        return mv;
    }
}