package com.example.GradingSystemNew.dto.request;

import com.sun.istack.NotNull;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
@Getter
public class GroupSubjectDtoRequest {

    @NotNull
    private Long groupId;
    @NotNull
    private Long subjectId;
    @NotNull
    private Long teacherId;
    @NotNull
    private int term;
    @NotNull
    private int year;
//    @NotBlank(message = "Group id must be specified.")
//    private Long groupSubjectId;

//    @NotBlank(message = "Subject id must be specified.")
//    private Long subjectId;







}
