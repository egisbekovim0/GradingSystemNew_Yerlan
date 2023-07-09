package com.example.GradingSystemNew.repository;

import com.example.GradingSystemNew.module.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

}
