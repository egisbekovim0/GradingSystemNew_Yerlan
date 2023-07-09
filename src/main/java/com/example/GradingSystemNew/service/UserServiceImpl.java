package com.example.GradingSystemNew.service;

import com.example.GradingSystemNew.dto.request.UserAuthorizationDtoRequest;
import com.example.GradingSystemNew.dto.request.UserRegistrationDtoRequest;
import com.example.GradingSystemNew.dto.response.UserDtoResponse;
import com.example.GradingSystemNew.exception.CustomExceptionMessage;
import com.example.GradingSystemNew.exception.custom.*;
import com.example.GradingSystemNew.mapper.UserMapper;
import com.example.GradingSystemNew.module.security.JWTTokenProvider;
import com.example.GradingSystemNew.module.security.User;
import com.example.GradingSystemNew.module.security.UserPrincipal;
import com.example.GradingSystemNew.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;


import java.util.Optional;

@Service

@RequiredArgsConstructor
@Log4j2

public class UserServiceImpl implements UserService, UserDetailsService {
    private final BCryptPasswordEncoder encoder;
    private final UserRepository userRepository;

    private final AuthenticationManager authenticationManager;
    private final JWTTokenProvider jwtTokenProvider;
    private final String USERNAME_ALREADY_EXIST = " This login is taken";
    private final String AUTHENTICATION_EXCEPTION = "Login or password is already taken";

    @Override
    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public void registration(UserRegistrationDtoRequest dtoRequest) {
        String username = dtoRequest.getUsername().toLowerCase().trim();
        String password = dtoRequest.getPassword().trim();

        Optional<User> user = this.getByUsername(username);
        if (user.isPresent()) throw new AlreadyExistException(this.USERNAME_ALREADY_EXIST);
        try {
            User createdUser = new User();

            createdUser.setUsername(username);

            createdUser.setPassword(encoder.encode(password));

            createdUser.setName(dtoRequest.getName());
            this.save(createdUser);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RepositoryCreateException(CustomExceptionMessage.CREATE_EXCEPTION_MESSAGE);
        }

    }

    private User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public ResponseEntity<UserDtoResponse> authorization(UserAuthorizationDtoRequest dtoRequest, HttpServletRequest request) {
        String username = dtoRequest.getUsername().toLowerCase().trim();
        String password = dtoRequest.getPassword().trim();

        this.authenticate(username, password);

        try {
            this.authenticate(username, password);
        }catch (Exception e){
            throw new CustomShowMessageException(this.AUTHENTICATION_EXCEPTION);
        }


        try {
            User user = this.getByUsernameThrowException(username);

            UserPrincipal userPrincipal = new UserPrincipal(user);

            String IP = jwtTokenProvider.getIpFromClient(request);

            HttpHeaders httpHeaders = this.JWTHeader(userPrincipal, IP);

            return new ResponseEntity<>(UserMapper.userToDo(user), httpHeaders, HttpStatus.OK);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new UnexpectedException(CustomExceptionMessage.UNEXPECTED_EXCEPTION_MESSAGE);
        }
    }

    private HttpHeaders JWTHeader(UserPrincipal userPrincipal, String IP){
        HttpHeaders httpHeaders = new HttpHeaders();
        String JWT = jwtTokenProvider.generateToken(userPrincipal, IP);

        httpHeaders.add(HttpHeaders.AUTHORIZATION, JWT);
        return httpHeaders;
    }

    private void authenticate(String username, String password){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    }

    @Override
    public Optional<User> getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User getByUsernameThrowException(String username) {
        return this.getByUsername(username).orElseThrow(() -> new NotFoundException(CustomExceptionMessage.NOT_FOUND_EXCEPTION_MESSAGE));
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.getByUsernameThrowException(username);
        return new UserPrincipal(user);
    }
}

