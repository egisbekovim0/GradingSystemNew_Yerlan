package com.example.GradingSystemNew.mapper;

import com.example.GradingSystemNew.dto.response.GroupDtoResponse;
import com.example.GradingSystemNew.dto.response.UserRoleDtoResponse;
import com.example.GradingSystemNew.module.Group;
import com.example.GradingSystemNew.module.security.UserRole;

public class UserRoleMapper {
    public static UserRoleDtoResponse userRoleToDo(UserRole userRole) {
        UserRoleDtoResponse userRoleDtoResponse = new UserRoleDtoResponse();

        userRoleDtoResponse.setId(userRoleDtoResponse.getId());

        userRoleDtoResponse.setRole(userRole.getRole());

        userRoleDtoResponse.setUser(userRole.getUser());

        userRoleDtoResponse.setAuthority(userRole.getAuthority());


        return userRoleDtoResponse;
    }
}
