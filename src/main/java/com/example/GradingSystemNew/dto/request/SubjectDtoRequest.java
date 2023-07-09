package com.example.GradingSystemNew.dto.request;

import com.sun.istack.NotNull;
import lombok.Getter;

@Getter
public class SubjectDtoRequest {
    @NotNull
    private String name;
}
