package com.example.GradingSystemNew.dto.request;

import com.sun.istack.NotNull;
import lombok.Getter;

@Getter

public class MarkTypeDtoRequest {
    @NotNull
    private String name;

}
