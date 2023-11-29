package com.example.GradingSystemNew.service;

import com.example.GradingSystemNew.dto.request.GroupDtoRequest;
import com.example.GradingSystemNew.dto.request.RoleDtoRequest;
import com.example.GradingSystemNew.module.Group;
import com.example.GradingSystemNew.module.security.Role;
import com.example.GradingSystemNew.module.security.User;

import java.util.Optional;

public interface RoleService {
    Role create(RoleDtoRequest dtoRequest);

    Optional<Role> getById(Long id);

    Role getByIdThrowException(Long id);
}
