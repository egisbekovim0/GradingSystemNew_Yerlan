package com.example.GradingSystemNew.service;

import com.example.GradingSystemNew.dto.request.GroupDtoRequest;
import com.example.GradingSystemNew.dto.request.SubjectDtoRequest;
import com.example.GradingSystemNew.module.Group;
import com.example.GradingSystemNew.module.GroupSubject;
import com.example.GradingSystemNew.module.Student;
import com.example.GradingSystemNew.module.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectService {
    List<Subject> getAll();
    Optional<Subject> getById(Long id);

    Subject getByIdThrowException(Long id);

    Subject update(SubjectDtoRequest dtoRequest, Long id);
    Subject create(SubjectDtoRequest dtoRequest);
    void delete(Long Id);
    List<GroupSubject> getGroupSubjects(Long Id);
}
