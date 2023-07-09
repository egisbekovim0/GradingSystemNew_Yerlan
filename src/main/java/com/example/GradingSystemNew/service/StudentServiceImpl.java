package com.example.GradingSystemNew.service;

import com.example.GradingSystemNew.dto.request.StudentDtoRequest;
import com.example.GradingSystemNew.dto.request.SubjectDtoRequest;
import com.example.GradingSystemNew.exception.CustomExceptionMessage;
import com.example.GradingSystemNew.exception.custom.NotFoundException;
import com.example.GradingSystemNew.exception.custom.RepositoryCreateException;
import com.example.GradingSystemNew.exception.custom.RepositoryDeleteException;
import com.example.GradingSystemNew.exception.custom.RepositoryUpdateException;
import com.example.GradingSystemNew.module.Student;
import com.example.GradingSystemNew.module.security.User;
import com.example.GradingSystemNew.repository.MarkRepository;
import com.example.GradingSystemNew.repository.StudentRepository;
import com.example.GradingSystemNew.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final MarkRepository markRepository;
    private final UserRepository userRepository;

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student getByIdThrowException(Long id) {
        return this.getById(id).orElseThrow(() -> new NotFoundException(CustomExceptionMessage.NOT_FOUND_EXCEPTION_MESSAGE));
    }

    @Override
    public void updateGrade(Long studentId, Long markId, int value) {

    }
    @Override
    public Student update(StudentDtoRequest dtoRequest, Long id) {
        Student student = this.getByIdThrowException(id);

        try {
            student.setF_name(dtoRequest.getFName());
            student.setL_name(dtoRequest.getLName());
            return this.save(student);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RepositoryUpdateException(CustomExceptionMessage.UPDATE_EXCEPTION_MESSAGE);
        }
    }
    private Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student create(StudentDtoRequest dtoRequest) {
        Student student = new Student();

        try {
            student.setF_name(dtoRequest.getFName());
            student.setL_name(dtoRequest.getLName());
            User user = userRepository.findById(dtoRequest.getUserId())
                    .orElseThrow(() -> new NotFoundException("Not found"));
            student.setUser(user);
            return this.save(student);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RepositoryCreateException(CustomExceptionMessage.CREATE_EXCEPTION_MESSAGE);
        }
    }


    @Override
    public void delete(Long id) {
        Student student = this.getByIdThrowException(id);
        try {
            studentRepository.delete(student);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RepositoryDeleteException(CustomExceptionMessage.DELETE_EXCEPTION_MESSAGE);
        }
    }


   

}
