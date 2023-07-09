package com.example.GradingSystemNew.repository;

import com.example.GradingSystemNew.module.GroupSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface GroupSubjectRepository extends JpaRepository<GroupSubject, Long> {
    List<GroupSubject> findAllByGroupId(Long id);

    List<GroupSubject> findAllBySubjectId(Long id);

}
