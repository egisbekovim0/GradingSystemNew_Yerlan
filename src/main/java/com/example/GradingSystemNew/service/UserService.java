package com.example.GradingSystemNew.service;

import com.example.GradingSystemNew.dto.request.UserAuthorizationDtoRequest;
import com.example.GradingSystemNew.dto.request.UserRegistrationDtoRequest;
import com.example.GradingSystemNew.dto.response.UserDtoResponse;
import com.example.GradingSystemNew.module.Group;
import com.example.GradingSystemNew.module.security.User;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public interface UserService {
    void delete(Long userId);
    User registration(UserRegistrationDtoRequest dtoRequest);
    ResponseEntity<UserDtoResponse> authorization(UserAuthorizationDtoRequest dtoRequest, HttpServletRequest request);

    Optional<User> getByUsername(String username);

    User getByUsernameThrowException(String username);

    Optional<User> getById(Long id);

    User getByIdThrowException(Long id);

//    User registration(UserRegistrationDtoRequest dtoRequest);

//    ResponseEntity<UserDtoResponse> authorization(UserAuthorizationDtoRequest dtoRequest, HttpServletRequest request);
}
