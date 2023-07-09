package com.example.GradingSystemNew.service;

import com.example.GradingSystemNew.dto.request.GroupDtoRequest;
import com.example.GradingSystemNew.dto.request.MarkTypeDtoRequest;
import com.example.GradingSystemNew.module.Group;
import com.example.GradingSystemNew.module.GroupSubject;
import com.example.GradingSystemNew.module.MarkType;

import java.util.List;
import java.util.Optional;

public interface MarkTypeService {
    List<MarkType> getAll();
    Optional<MarkType> getById(Long id);

    MarkType getByIdThrowException(Long id);

    MarkType update(MarkTypeDtoRequest dtoRequest, Long id);
    MarkType create(MarkTypeDtoRequest dtoRequest);
    void delete(Long Id);
}
