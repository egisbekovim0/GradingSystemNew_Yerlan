package com.example.GradingSystemNew.repository;

import com.example.GradingSystemNew.module.MarkType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkTypeRepository extends JpaRepository<MarkType, Long> {
}
