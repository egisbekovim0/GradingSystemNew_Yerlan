package com.example.GradingSystemNew.dto.request;

import com.sun.istack.NotNull;
import lombok.Getter;

@Getter
public class AuthorityDtoRequest {
    @NotNull
    private String title;
}
