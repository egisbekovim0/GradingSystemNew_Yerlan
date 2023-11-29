package com.example.GradingSystemNew.controllers;

import com.example.GradingSystemNew.dto.request.GroupDtoRequest;
import com.example.GradingSystemNew.dto.request.UserRoleDtoRequest;
import com.example.GradingSystemNew.dto.response.GroupDtoResponse;
import com.example.GradingSystemNew.dto.response.UserRoleDtoResponse;
import com.example.GradingSystemNew.mapper.GroupMapper;
import com.example.GradingSystemNew.mapper.UserRoleMapper;
import com.example.GradingSystemNew.module.Group;
import com.example.GradingSystemNew.module.security.UserRole;
import com.example.GradingSystemNew.service.GroupService;
import com.example.GradingSystemNew.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@RestController
@RequestMapping("/api/v1/user-role")
@RequiredArgsConstructor
public class UserRoleController {
    private final UserRoleService userRoleService;

    @PostMapping("/create")
    public ResponseEntity<UserRoleDtoResponse> create(@Valid @RequestBody UserRoleDtoRequest dtoRequest) {
        UserRole userRole = userRoleService.create(dtoRequest);

        UserRoleDtoResponse userRoleDtoResponse = UserRoleMapper.userRoleToDo(userRole);

        return new ResponseEntity<>(userRoleDtoResponse, HttpStatus.CREATED);
    }
}
