package com.example.GradingSystemNew.mapper;

import com.example.GradingSystemNew.dto.response.GroupDtoResponse;
import com.example.GradingSystemNew.dto.response.RoleDtoResponse;
import com.example.GradingSystemNew.module.Group;
import com.example.GradingSystemNew.module.security.Role;

public class RoleMapper {
    public static RoleDtoResponse roleToDto(Role role) {
        RoleDtoResponse response = new RoleDtoResponse();

        response.setId(role.getId());

        response.setName(role.getName());

        return response;
    }
}