package com.example.GradingSystemNew.dto.request;


import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class StudentDtoRequest {
    @NotNull
    private String fName;

    @NotNull
    private String lName;

    @NotBlank
    private Long userId;
}
