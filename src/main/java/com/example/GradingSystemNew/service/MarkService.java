package com.example.GradingSystemNew.service;

import com.example.GradingSystemNew.dto.request.GroupDtoRequest;
import com.example.GradingSystemNew.dto.request.MarkDtoRequest;
import com.example.GradingSystemNew.dto.response.MarkDtoResponse;
import com.example.GradingSystemNew.module.*;

import java.util.List;
import java.util.Optional;

public interface MarkService {
    List<Mark> getAll();
    Optional<Mark> getById(Long id);
    List<Mark> getByStudentId(Long studentId);


    Mark getByIdThrowException(Long id);

    Mark update(MarkDtoRequest dtoRequest, Long id);
    Mark create(MarkDtoRequest dtoRequest);
    void delete(Long Id);
    List<MarkDtoResponse> getMarksByStudentAndSubject(Long studentId, Long subjectId);

}
