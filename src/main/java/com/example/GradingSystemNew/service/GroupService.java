package com.example.GradingSystemNew.service;

import com.example.GradingSystemNew.dto.request.GroupDtoRequest;
import com.example.GradingSystemNew.module.Group;
import com.example.GradingSystemNew.module.GroupSubject;

import java.util.List;
import java.util.Optional;

public interface GroupService {
    List<Group> getAll();
    Optional<Group> getById(Long id);

    Group getByIdThrowException(Long id);

    Group update(GroupDtoRequest dtoRequest, Long id);
    Group create(GroupDtoRequest dtoRequest);
    void delete(Long Id);
    List<GroupSubject> getGroupSubjects(Long Id);
}
