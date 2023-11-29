package com.example.GradingSystemNew.service;

import com.example.GradingSystemNew.exception.CustomExceptionMessage;
import com.example.GradingSystemNew.exception.custom.NotFoundException;

import com.example.GradingSystemNew.module.security.Authority;
import com.example.GradingSystemNew.repository.AuthorityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@Log4j2
@RequiredArgsConstructor
public class AuthorityServiceImpl implements AuthorityService {
    private final AuthorityRepository authorityRepository;

    @Override
    public Optional<Authority> getById(Long id) {
        return authorityRepository.findById(id);
    }
    @Override
    public Authority getByIdThrowException(Long id) {
        return this.getById(id).orElseThrow(() -> new NotFoundException(CustomExceptionMessage.NOT_FOUND_EXCEPTION_MESSAGE));
    }
}
