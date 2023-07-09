package com.example.GradingSystemNew.service;

import com.example.GradingSystemNew.dto.request.GroupDtoRequest;
import com.example.GradingSystemNew.dto.request.RoleDtoRequest;
import com.example.GradingSystemNew.module.Group;
import com.example.GradingSystemNew.module.security.Role;

public interface RoleService {
    Role create(RoleDtoRequest dtoRequest);
}
