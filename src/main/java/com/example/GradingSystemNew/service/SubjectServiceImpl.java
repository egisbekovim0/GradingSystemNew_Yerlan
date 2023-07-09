package com.example.GradingSystemNew.service;

import com.example.GradingSystemNew.dto.request.SubjectDtoRequest;
import com.example.GradingSystemNew.exception.CustomExceptionMessage;
import com.example.GradingSystemNew.exception.custom.NotFoundException;
import com.example.GradingSystemNew.exception.custom.RepositoryCreateException;
import com.example.GradingSystemNew.exception.custom.RepositoryDeleteException;
import com.example.GradingSystemNew.exception.custom.RepositoryUpdateException;
import com.example.GradingSystemNew.module.Group;
import com.example.GradingSystemNew.module.GroupSubject;
import com.example.GradingSystemNew.module.Student;
import com.example.GradingSystemNew.module.Subject;
import com.example.GradingSystemNew.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class SubjectServiceImpl implements SubjectService{
    private final SubjectRepository subjectRepository;


    @Override
    public List<Subject> getAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Optional<Subject> getById(Long id) {
        return subjectRepository.findById(id);
    }

    @Override
    public Subject getByIdThrowException(Long id) {
        return this.getById(id).orElseThrow(() -> new NotFoundException(CustomExceptionMessage.NOT_FOUND_EXCEPTION_MESSAGE));
    }

    @Override
    public Subject update(SubjectDtoRequest dtoRequest, Long id) {
        Subject subject = this.getByIdThrowException(id);

        try {
            subject.setName(dtoRequest.getName());
            return this.save(subject);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RepositoryUpdateException(CustomExceptionMessage.UPDATE_EXCEPTION_MESSAGE);
        }
    }
    private Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public Subject create(SubjectDtoRequest dtoRequest) {
        Subject subject = new Subject();

        try {
            subject.setName(dtoRequest.getName());

            return this.save(subject);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RepositoryCreateException(CustomExceptionMessage.CREATE_EXCEPTION_MESSAGE);
        }
    }


    @Override
    public void delete(Long id) {
        Subject subject = this.getByIdThrowException(id);

        try {
            subjectRepository.delete(subject);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RepositoryDeleteException(CustomExceptionMessage.DELETE_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public List<GroupSubject> getGroupSubjects(Long Id) {
        return null;
    }
}
