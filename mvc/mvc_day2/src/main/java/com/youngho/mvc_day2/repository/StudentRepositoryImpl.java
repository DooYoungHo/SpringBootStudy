package com.youngho.mvc_day2.repository;

import com.youngho.mvc_day2.dto.StudentRequestDto;
import com.youngho.mvc_day2.entity.Student;
import com.youngho.mvc_day2.exception.StudentAlreadyExistsException;
import com.youngho.mvc_day2.exception.StudentNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private final Map<String, Student> studentMap = new HashMap<>();

    public StudentRepositoryImpl() {
        studentMap.put("test", new Student(
            "test",
            "1234",
            "테스트",
            "test@test.com",
            100,
            "This is Test"
        ));
    }

    @Override
    public boolean exists(String id) {
        return studentMap.containsKey(id);
    }

    @Override
    public Student getStudent(String id) {

        if (Objects.isNull(id) || id.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (!exists(id)) {
            throw new StudentNotFoundException("Student is Not Exists...!");
        }

        return studentMap.get(id);
    }

    @Override
    public void saveStudent(StudentRequestDto studentRequestDto) {

        if (exists(studentRequestDto.id())) {
            throw new StudentAlreadyExistsException("Student already exists...!");
        }

        // dto -> entity 변환
        Student student = new Student(
            studentRequestDto.id(),
            studentRequestDto.password(),
            studentRequestDto.name(),
            studentRequestDto.email(),
            studentRequestDto.score(),
            studentRequestDto.evaluation()
        );

        // entity 저장
        studentMap.put(student.getId(), student);
    }
}
