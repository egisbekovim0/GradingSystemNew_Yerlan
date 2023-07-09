package com.example.GradingSystemNew.dto.response;

import com.example.GradingSystemNew.module.security.Role;
import com.example.GradingSystemNew.module.security.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRoleDtoResponse {
    private User user;

    private Role role;


}
