package com.example.GradingSystemNew.repository;

import com.example.GradingSystemNew.module.MarkType;
import com.example.GradingSystemNew.module.security.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
