package com.example.GradingSystemNew.service;

import com.example.GradingSystemNew.dto.request.TeacherDtoRequest;
import com.example.GradingSystemNew.exception.CustomExceptionMessage;
import com.example.GradingSystemNew.exception.custom.NotFoundException;
import com.example.GradingSystemNew.exception.custom.RepositoryCreateException;
import com.example.GradingSystemNew.exception.custom.RepositoryDeleteException;
import com.example.GradingSystemNew.exception.custom.RepositoryUpdateException;
import com.example.GradingSystemNew.module.Teacher;
import com.example.GradingSystemNew.module.security.User;
import com.example.GradingSystemNew.repository.MarkRepository;
import com.example.GradingSystemNew.repository.TeacherRepository;
import com.example.GradingSystemNew.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final MarkRepository markRepository;
    private final UserRepository userRepository;


    @Override
    public Optional<Teacher> getById(Long id) {
        return teacherRepository.findById(id);
    }

    @Override
    public Teacher getByIdThrowException(Long id) {
        return this.getById(id).orElseThrow(() -> new NotFoundException(CustomExceptionMessage.NOT_FOUND_EXCEPTION_MESSAGE));
    }

    @Override
    public void updateGrade(Long studentId, Long markId, int value) {

    }
    @Override
    public Teacher update(TeacherDtoRequest dtoRequest, Long id) {
        Teacher teacher = this.getByIdThrowException(id);

        try {
            teacher.setF_name(dtoRequest.getFName());
            teacher.setL_name(dtoRequest.getLName());
            return this.save(teacher);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RepositoryUpdateException(CustomExceptionMessage.UPDATE_EXCEPTION_MESSAGE);
        }
    }
    private Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher create(TeacherDtoRequest dtoRequest) {
        Teacher teacher = new Teacher();

        try {
            teacher.setF_name(dtoRequest.getFName());
            teacher.setL_name(dtoRequest.getLName());
            User user = userRepository.findById(dtoRequest.getUserId())
                    .orElseThrow(() -> new NotFoundException("Not found"));
            teacher.setUser(user);
            return this.save(teacher);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RepositoryCreateException(CustomExceptionMessage.CREATE_EXCEPTION_MESSAGE);
        }
    }


    @Override
    public void delete(Long id) {
        Teacher teacher = this.getByIdThrowException(id);
        try {
            teacherRepository.delete(teacher);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RepositoryDeleteException(CustomExceptionMessage.DELETE_EXCEPTION_MESSAGE);
        }
    }




}
