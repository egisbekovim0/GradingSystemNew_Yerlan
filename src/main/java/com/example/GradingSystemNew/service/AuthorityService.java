package com.example.GradingSystemNew.service;

import com.example.GradingSystemNew.module.security.Authority;


import java.util.Optional;

public interface AuthorityService {
    Optional<Authority> getById(Long id);

    Authority getByIdThrowException(Long id);
}
