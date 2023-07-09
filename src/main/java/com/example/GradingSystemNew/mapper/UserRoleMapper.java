package com.example.GradingSystemNew.mapper;

import com.example.GradingSystemNew.dto.response.GroupDtoResponse;
import com.example.GradingSystemNew.dto.response.UserRoleDtoResponse;
import com.example.GradingSystemNew.module.Group;
import com.example.GradingSystemNew.module.security.UserRole;

public class UserRoleMapper {
    public static UserRoleDtoResponse userRoleDtoResponse(UserRole userRole) {
        UserRoleDtoResponse userRoleDtoResponse = new UserRoleDtoResponse();

        userRoleDtoResponse.setRole(userRole.getRole());

        userRoleDtoResponse.setUser(userRole.getUser());

        return userRoleDtoResponse;
    }
}
