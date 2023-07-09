package com.example.GradingSystemNew.mapper;

import com.example.GradingSystemNew.dto.response.SubjectDtoResponse;
import com.example.GradingSystemNew.module.Group;
import com.example.GradingSystemNew.module.Subject;

public class SubjectMapper {
    public static SubjectDtoResponse subjectToDto(Subject subject) {
        SubjectDtoResponse subjectDtoResponse = new SubjectDtoResponse();

        subjectDtoResponse.setId(subject.getId());

        subjectDtoResponse.setName(subject.getName());

        return subjectDtoResponse;
    }
}
