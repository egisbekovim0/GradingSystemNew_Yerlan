package com.example.GradingSystemNew.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class UserRegistrationDtoRequest {
    @NotBlank(message = "Login must be shown")
    private String username;
    @NotBlank(message = "Password must be shown")
    private String password;
    @NotBlank(message = "Name must be shown")
    private String name;
}
