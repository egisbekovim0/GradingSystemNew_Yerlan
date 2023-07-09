package com.example.GradingSystemNew.service;

import com.example.GradingSystemNew.dto.request.MarkTypeDtoRequest;
import com.example.GradingSystemNew.dto.request.SubjectDtoRequest;
import com.example.GradingSystemNew.exception.CustomExceptionMessage;
import com.example.GradingSystemNew.exception.custom.NotFoundException;
import com.example.GradingSystemNew.exception.custom.RepositoryCreateException;
import com.example.GradingSystemNew.exception.custom.RepositoryDeleteException;
import com.example.GradingSystemNew.exception.custom.RepositoryUpdateException;
import com.example.GradingSystemNew.module.Group;
import com.example.GradingSystemNew.module.MarkType;
import com.example.GradingSystemNew.module.Subject;
import com.example.GradingSystemNew.repository.GroupRepository;
import com.example.GradingSystemNew.repository.MarkTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class MarkTypeServiceImpl implements MarkTypeService {

    private final MarkTypeRepository markTypeRepository;

    @Override
    public List<MarkType> getAll() {
        return markTypeRepository.findAll();
    }
    @Override
    public Optional<MarkType> getById(Long id) {
        return markTypeRepository.findById(id);
    }
    @Override
    public MarkType getByIdThrowException(Long id) {
        return this.getById(id).orElseThrow(() -> new NotFoundException(CustomExceptionMessage.NOT_FOUND_EXCEPTION_MESSAGE));
    }

    @Override
    public MarkType update(MarkTypeDtoRequest dtoRequest, Long id) {
        MarkType markType = this.getByIdThrowException(id);

        try {
            markType.setName(dtoRequest.getName());
            return this.save(markType);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RepositoryUpdateException(CustomExceptionMessage.UPDATE_EXCEPTION_MESSAGE);
        }
    }
    private MarkType save(MarkType markType) {
        return markTypeRepository.save(markType);
    }

    @Override
    public MarkType create(MarkTypeDtoRequest dtoRequest) {
        MarkType markType = new MarkType();

        try {
            markType.setName(dtoRequest.getName());

            return this.save(markType);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RepositoryCreateException(CustomExceptionMessage.CREATE_EXCEPTION_MESSAGE);
        }
    }


    @Override
    public void delete(Long id) {
        MarkType markType = this.getByIdThrowException(id);

        try {
            markTypeRepository.delete(markType);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RepositoryDeleteException(CustomExceptionMessage.DELETE_EXCEPTION_MESSAGE);
        }
    }
}

