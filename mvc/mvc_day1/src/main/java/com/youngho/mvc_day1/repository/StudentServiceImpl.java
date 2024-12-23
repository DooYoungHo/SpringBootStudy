package com.youngho.mvc_day1.repository;

import com.youngho.mvc_day1.dto.LoginDto;
import com.youngho.mvc_day1.dto.RegisterDto;
import com.youngho.mvc_day1.entity.Student;
import com.youngho.mvc_day1.exception.StudentAlreadyExistException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private final Map<String, Student> studentMap = new HashMap<>();

    @Override
    public boolean existStudent(String id) {
        return studentMap.containsKey(id);
    }

    @Override
    public Student registerStudent(RegisterDto registerDto) {

        if (existStudent(registerDto.id())) {
            throw new StudentAlreadyExistException();
        }

        Student registerStudent = new Student(
            registerDto.id(),
            registerDto.password(),
            registerDto.name(),
            registerDto.email(),
            registerDto.score(),
            registerDto.evaluation()
        );

        studentMap.put(registerDto.id(), registerStudent);

        return registerStudent;
    }

    @Override
    public Student getStudent(String studentId) {
        return studentMap.get(studentId);
    }

    @Override
    public boolean checkLogin(LoginDto loginDto) {
        Student student = studentMap.get(loginDto.id());

        return !Objects.isNull(student);
    }
}
