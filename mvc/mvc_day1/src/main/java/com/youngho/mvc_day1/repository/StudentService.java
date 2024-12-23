package com.youngho.mvc_day1.repository;

import com.youngho.mvc_day1.dto.LoginDto;
import com.youngho.mvc_day1.dto.RegisterDto;
import com.youngho.mvc_day1.entity.Student;

public interface StudentService {
    boolean existStudent(String id);
    Student registerStudent(RegisterDto registerDto);
    Student getStudent(String studentId);
    boolean checkLogin(LoginDto loginDto);
}
