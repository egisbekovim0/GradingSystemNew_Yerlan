package com.example.GradingSystemNew.service;

import com.example.GradingSystemNew.dto.request.RoleDtoRequest;
import com.example.GradingSystemNew.dto.request.UserRoleDtoRequest;
import com.example.GradingSystemNew.module.security.Role;
import com.example.GradingSystemNew.module.security.UserRole;

public interface UserRoleService {
    UserRole create(UserRoleDtoRequest dtoRequest);
}
