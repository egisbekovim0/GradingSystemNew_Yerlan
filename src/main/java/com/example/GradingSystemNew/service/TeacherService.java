package com.example.GradingSystemNew.service;

import com.example.GradingSystemNew.dto.request.TeacherDtoRequest;
import com.example.GradingSystemNew.module.Student;
import com.example.GradingSystemNew.module.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {

    Optional<Teacher> getById(Long id);

    Teacher getByIdThrowException(Long id);

    void updateGrade(Long studentId, Long markId, int value);

    Teacher update(TeacherDtoRequest dtoRequest, Long id);

    Teacher create(TeacherDtoRequest dtoRequest);

    void delete(Long id);
}
