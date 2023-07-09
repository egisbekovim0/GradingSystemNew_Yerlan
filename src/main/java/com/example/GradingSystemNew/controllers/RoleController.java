package com.example.GradingSystemNew.controllers;

import com.example.GradingSystemNew.dto.request.GroupDtoRequest;
import com.example.GradingSystemNew.dto.request.RoleDtoRequest;
import com.example.GradingSystemNew.dto.response.GroupDtoResponse;
import com.example.GradingSystemNew.dto.response.RoleDtoResponse;
import com.example.GradingSystemNew.exception.ExceptionHandling;
import com.example.GradingSystemNew.mapper.GroupMapper;
import com.example.GradingSystemNew.mapper.RoleMapper;
import com.example.GradingSystemNew.module.Group;
import com.example.GradingSystemNew.module.security.Role;
import com.example.GradingSystemNew.service.GroupService;
import com.example.GradingSystemNew.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/role")
@RequiredArgsConstructor
public class RoleController extends ExceptionHandling {
    private final RoleService roleService;


    @PostMapping("/create")
    public ResponseEntity<RoleDtoResponse> create(@Valid @RequestBody RoleDtoRequest dtoRequest) {
        Role role = roleService.create(dtoRequest);

        RoleDtoResponse response = RoleMapper.roleToDto(role);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}