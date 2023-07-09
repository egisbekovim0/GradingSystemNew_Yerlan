package com.example.GradingSystemNew.dto.response;

import com.example.GradingSystemNew.dto.request.SubjectDtoRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupSubjectDtoResponse {

    private SubjectDtoResponse subject;

    private GroupDtoResponse group;

    private TeacherDtoResponse teacher;
}
