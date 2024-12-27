package com.youngho.mvc_day2.repository;

import com.youngho.mvc_day2.dto.LoginRequestDto;
import com.youngho.mvc_day2.dto.StudentRequestDto;
import com.youngho.mvc_day2.entity.Student;

public interface StudentRepository {
    boolean matches(LoginRequestDto loginRequestDto);
    boolean exists(String id);  // 존재 여부 체크
    Student getStudent(String id);  // 학생 조회
    void saveStudent(StudentRequestDto studentRequestDto); // 학생 등록
}
