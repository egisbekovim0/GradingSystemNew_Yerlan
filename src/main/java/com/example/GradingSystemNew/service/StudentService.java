package com.example.GradingSystemNew.service;

import com.example.GradingSystemNew.dto.request.StudentDtoRequest;
import com.example.GradingSystemNew.dto.request.SubjectDtoRequest;
import com.example.GradingSystemNew.module.Mark;
import com.example.GradingSystemNew.module.Student;
import com.example.GradingSystemNew.module.Subject;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAll();
    Optional<Student> getById(Long id);

    Student getByIdThrowException(Long id);


    Student update(StudentDtoRequest dtoRequest, Long id);

    Student create(StudentDtoRequest dtoRequest);

    void delete(Long id);

    void updateGrade(Long studentId, Long markId, int value);
}
