package com.youngho.mvc_day2.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.youngho.mvc_day2.entity.Student;
import com.youngho.mvc_day2.exception.StudentNotFoundException;
import com.youngho.mvc_day2.repository.StudentRepository;
import jakarta.servlet.http.Cookie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = StudentController.class)
class StudentControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private StudentRepository repository;

    @Test
    void getStudent_Success() throws Exception {
        // given
        String studentId = "test";
        Student mockStudent = new Student(
            "test",
            "1234",
            "테스트",
            "test@test.com",
            100,
            "This is Test");

        when(repository.getStudent(studentId)).thenReturn(mockStudent);

        // when & then
        mvc.perform(get("/student/{studentId}", studentId)
                .cookie(new Cookie("Login", studentId)))
            .andExpect(status().isOk())
            .andExpect(view().name("student"))
            .andExpect(model().attributeExists("student"))
            .andExpect(model().attribute("student", mockStudent));
    }

    @Test
    void getStudent_Failed() throws Exception {
        // given
        String studentId = "NotFound";

        when(repository.getStudent(studentId)).thenThrow(new StudentNotFoundException(studentId));

        // when & then
        mvc.perform(get("/student/{studentId}", studentId)
                .cookie(new Cookie("Login", studentId)))
            .andExpect(status().isNotFound());
    }
}
