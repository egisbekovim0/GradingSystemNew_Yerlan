package com.example.GradingSystemNew.dto.request;

import com.sun.istack.NotNull;
import lombok.Getter;

@Getter
public class MarkDtoRequest {

    @NotNull
    private Long groupSubjectId;
    @NotNull
    private Long studentId;
    @NotNull
    private Long markTypeId;
    @NotNull
    private float mark;

}
