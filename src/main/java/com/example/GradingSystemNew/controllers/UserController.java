package com.example.GradingSystemNew.controllers;

import com.example.GradingSystemNew.dto.request.UserAuthorizationDtoRequest;
import com.example.GradingSystemNew.dto.request.UserRegistrationDtoRequest;
import com.example.GradingSystemNew.dto.response.UserDtoResponse;
import com.example.GradingSystemNew.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> registration(@Valid @RequestBody UserRegistrationDtoRequest dtoRequest){
        userService.registration(dtoRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/authorization")
    public ResponseEntity<UserDtoResponse> authorization(@Valid @RequestBody UserAuthorizationDtoRequest dtoRequest, HttpServletRequest request){
        return userService.authorization(dtoRequest, request);
    }

}
