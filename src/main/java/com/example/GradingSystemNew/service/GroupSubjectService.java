package com.example.GradingSystemNew.service;

import com.example.GradingSystemNew.dto.request.GroupSubjectDtoRequest;
import com.example.GradingSystemNew.module.Group;
import com.example.GradingSystemNew.module.GroupSubject;
import com.example.GradingSystemNew.module.Subject;
import com.example.GradingSystemNew.module.Teacher;
import java.util.List;
import java.util.Optional;

public interface GroupSubjectService {

    Optional<GroupSubject> getById(Long id);

    List<GroupSubject> getAllByGroupId(Long id);

    List<GroupSubject> getAllBySubjectId(Long id);

    GroupSubject getByIdThrowException(Long id);
    GroupSubject create(GroupSubjectDtoRequest dtoRequest);
    void delete(Long id);
}

