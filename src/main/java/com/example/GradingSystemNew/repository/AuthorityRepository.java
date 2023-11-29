package com.example.GradingSystemNew.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.GradingSystemNew.module.security.Authority;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
