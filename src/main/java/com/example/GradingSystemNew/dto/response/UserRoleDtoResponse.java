package com.example.GradingSystemNew.dto.response;

import com.example.GradingSystemNew.module.security.Authority;
import com.example.GradingSystemNew.module.security.Role;
import com.example.GradingSystemNew.module.security.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRoleDtoResponse {

    private Long id;
    private User user;

    private Role role;

    private Authority authority;


}
