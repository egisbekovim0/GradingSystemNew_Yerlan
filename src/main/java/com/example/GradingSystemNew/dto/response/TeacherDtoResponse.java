package com.example.GradingSystemNew.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherDtoResponse {
    private Long id;

    private String f_name;
    private String l_name;
    private UserDtoResponse user;
}
