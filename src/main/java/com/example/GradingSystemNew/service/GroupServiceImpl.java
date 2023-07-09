package com.example.GradingSystemNew.service;

import com.example.GradingSystemNew.dto.request.GroupDtoRequest;
import com.example.GradingSystemNew.exception.CustomExceptionMessage;
import com.example.GradingSystemNew.exception.custom.NotFoundException;
import com.example.GradingSystemNew.exception.custom.RepositoryCreateException;
import com.example.GradingSystemNew.exception.custom.RepositoryDeleteException;
import com.example.GradingSystemNew.exception.custom.RepositoryUpdateException;
import com.example.GradingSystemNew.module.Group;
import com.example.GradingSystemNew.module.GroupSubject;
import com.example.GradingSystemNew.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService{
    private final GroupRepository groupRepository;
    @Override
    public List<Group> getAll() {
        return groupRepository.findAll();
    }
    @Override
    public Optional<Group> getById(Long id) {
        return groupRepository.findById(id);
    }
    @Override
    public Group getByIdThrowException(Long id) {
        return this.getById(id).orElseThrow(() -> new NotFoundException(CustomExceptionMessage.NOT_FOUND_EXCEPTION_MESSAGE));
    }
    private Group save(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public Group update(GroupDtoRequest dtoRequest, Long id) {
        Group group = this.getByIdThrowException(id);

        try {
            group.setName(dtoRequest.getName());

            return this.save(group);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RepositoryUpdateException(CustomExceptionMessage.UPDATE_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public Group create(GroupDtoRequest dtoRequest) {
        Group group = new Group();

        try {
            group.setName(dtoRequest.getName());

            return this.save(group);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RepositoryCreateException(CustomExceptionMessage.CREATE_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public void delete(Long id) {
        Group group = this.getByIdThrowException(id);

        try {
            groupRepository.delete(group);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RepositoryDeleteException(CustomExceptionMessage.DELETE_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public List<GroupSubject> getGroupSubjects(Long id) {
        return null;
    }
}
