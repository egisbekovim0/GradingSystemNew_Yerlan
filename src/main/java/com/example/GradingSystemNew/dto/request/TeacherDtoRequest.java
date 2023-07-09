package com.example.GradingSystemNew.dto.request;

import com.sun.istack.NotNull;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class TeacherDtoRequest {
    @NotNull
    private String fName;

    @NotNull
    private String lName;

    @NotBlank
    private Long userId;
}
