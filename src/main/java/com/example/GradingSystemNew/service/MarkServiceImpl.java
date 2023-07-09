package com.example.GradingSystemNew.service;

import com.example.GradingSystemNew.dto.request.MarkDtoRequest;
import com.example.GradingSystemNew.dto.request.MarkTypeDtoRequest;
import com.example.GradingSystemNew.dto.response.MarkDtoResponse;
import com.example.GradingSystemNew.exception.CustomExceptionMessage;
import com.example.GradingSystemNew.exception.custom.NotFoundException;
import com.example.GradingSystemNew.exception.custom.RepositoryCreateException;
import com.example.GradingSystemNew.exception.custom.RepositoryDeleteException;
import com.example.GradingSystemNew.exception.custom.RepositoryUpdateException;
import com.example.GradingSystemNew.mapper.MarkMapper;
import com.example.GradingSystemNew.mapper.MarkTypeMapper;
import com.example.GradingSystemNew.module.*;
import com.example.GradingSystemNew.repository.GroupSubjectRepository;
import com.example.GradingSystemNew.repository.MarkRepository;
import com.example.GradingSystemNew.repository.MarkTypeRepository;
import com.example.GradingSystemNew.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class MarkServiceImpl implements MarkService {
    private final MarkRepository markRepository;
    private final GroupSubjectService groupSubjectService;
    private final StudentService studentService;
    private final MarkTypeService markTypeService;


    @Override
    public List<Mark> getAll() {
        return markRepository.findAll();
    }
    @Override
    public Optional<Mark> getById(Long id) {
        return markRepository.findById(id);
    }
    @Override
    public Mark getByIdThrowException(Long id) {
        return this.getById(id).orElseThrow(() -> new NotFoundException(CustomExceptionMessage.NOT_FOUND_EXCEPTION_MESSAGE));
    }

    @Override
    public Mark update(MarkDtoRequest dtoRequest, Long id) {
        Mark mark = this.getByIdThrowException(id);

        try {
            mark.setMark(dtoRequest.getMark());
            return this.save(mark);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RepositoryUpdateException(CustomExceptionMessage.UPDATE_EXCEPTION_MESSAGE);
        }
    }
    @Override
    public List<Mark> getByStudentId(Long studentId) {
        return markRepository.findByStudentId(studentId);
    }

    private Mark save(Mark mark) {
        return markRepository.save(mark);
    }

    @Override
    public Mark create(MarkDtoRequest dtoRequest) {
        try{

            Mark mark = new Mark();
            GroupSubject groupSubject = groupSubjectService.getByIdThrowException(dtoRequest.getGroupSubjectId());
            Student student = studentService.getByIdThrowException(dtoRequest.getStudentId());
            MarkType markType = markTypeService.getByIdThrowException(dtoRequest.getMarkTypeId());

            mark.setGroupSubject(groupSubject);
            mark.setStudent(student);
            mark.setMarkType(markType);
            mark.setMark(dtoRequest.getMark());


            return this.save(mark);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RepositoryCreateException(CustomExceptionMessage.CREATE_EXCEPTION_MESSAGE);
        }
    }


    @Override
    public void delete(Long id) {
        Mark markType = this.getByIdThrowException(id);

        try {
            markRepository.delete(markType);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RepositoryDeleteException(CustomExceptionMessage.DELETE_EXCEPTION_MESSAGE);
        }
    }
    public List<MarkDtoResponse> getMarksByStudentAndSubject(Long studentId, Long subjectId) {
        List<Mark> marks = markRepository.findAllByStudentIdAndGroupSubjectId(studentId, subjectId);
        List<MarkDtoResponse> markDtoResponses = new ArrayList<>();

        for (Mark mark : marks) {
            MarkDtoResponse markDtoResponse = new MarkDtoResponse();
//            markDtoResponse.set(mark.getMark());
            markDtoResponse.setMarkType(MarkTypeMapper.markTypeToDto(mark.getMarkType()));
            markDtoResponses.add(markDtoResponse);
        }

        return markDtoResponses;
    }

}

