package com.example.GradingSystemNew.service;

import com.example.GradingSystemNew.dto.request.GroupSubjectDtoRequest;
import com.example.GradingSystemNew.exception.CustomExceptionMessage;
import com.example.GradingSystemNew.exception.custom.NotFoundException;
import com.example.GradingSystemNew.exception.custom.RepositoryDeleteException;
import com.example.GradingSystemNew.module.Group;
import com.example.GradingSystemNew.module.GroupSubject;
import com.example.GradingSystemNew.module.Subject;
import com.example.GradingSystemNew.module.Teacher;
import com.example.GradingSystemNew.repository.GroupSubjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class GroupSubjectServiceImpl implements GroupSubjectService {

    private final GroupSubjectRepository groupSubjectRepository;
    private final GroupService groupService;
    private final SubjectService subjectService;
    private final TeacherService teacherService;
    private GroupSubject save(GroupSubject groupSubject) {
        return groupSubjectRepository.save(groupSubject);
    }

    @Override
    public Optional<GroupSubject> getById(Long id) {
        return groupSubjectRepository.findById(id);
    }

    @Override
    public List<GroupSubject> getAllByGroupId(Long id) {
        return groupSubjectRepository.findAllByGroupId(id);
    }

    @Override
    public List<GroupSubject> getAllBySubjectId(Long id) {
        return groupSubjectRepository.findAllBySubjectId(id);
    }

    @Override
    public GroupSubject getByIdThrowException(Long id) {
        return this.getById(id).orElseThrow(() -> new NotFoundException(CustomExceptionMessage.NOT_FOUND_EXCEPTION_MESSAGE));
    }

    @Override
    public GroupSubject create(GroupSubjectDtoRequest dtoRequest) {
        try{
            GroupSubject groupSubject = new GroupSubject();
            Group group = groupService.getByIdThrowException(dtoRequest.getGroupId());
            Subject subject = subjectService.getByIdThrowException(dtoRequest.getSubjectId());
            Teacher teacher = teacherService.getByIdThrowException(dtoRequest.getTeacherId());

            groupSubject.setGroup(group);
            groupSubject.setSubject(subject);
            groupSubject.setTeacher(teacher);
            groupSubject.setTerm(dtoRequest.getTerm());
            groupSubject.setYear(dtoRequest.getYear());

            return this.save(groupSubject);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new RepositoryDeleteException(CustomExceptionMessage.DELETE_EXCEPTION_MESSAGE);
        }
    }



    @Override
    public void delete(Long id) {
        GroupSubject groupSubject = this.getByIdThrowException(id);
        try {
            groupSubjectRepository.delete(groupSubject);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RepositoryDeleteException(CustomExceptionMessage.DELETE_EXCEPTION_MESSAGE);
        }
    }
}



