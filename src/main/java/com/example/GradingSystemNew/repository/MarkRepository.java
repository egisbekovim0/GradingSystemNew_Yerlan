package com.example.GradingSystemNew.repository;

import com.example.GradingSystemNew.module.GroupSubject;
import com.example.GradingSystemNew.module.Mark;
import com.example.GradingSystemNew.module.MarkType;
import com.example.GradingSystemNew.module.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface MarkRepository extends JpaRepository<Mark, Long> {

    Optional<Mark> findByStudentAndGroupSubject(Student student, GroupSubject groupSubject);
    List<Mark> findAllByStudentIdAndGroupSubjectId(Long id, Long ig);

    List<Mark> findByStudentId(Long studentId);
}
