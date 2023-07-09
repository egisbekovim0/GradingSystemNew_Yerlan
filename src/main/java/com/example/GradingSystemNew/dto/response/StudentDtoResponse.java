package com.example.GradingSystemNew.dto.response;

import com.example.GradingSystemNew.module.security.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDtoResponse {
    private Long id;

    private String f_name;
    private String l_name;
    private UserDtoResponse user;
}
