package com.example.GradingSystemNew.mapper;

import com.example.GradingSystemNew.dto.response.GroupSubjectDtoResponse;
import com.example.GradingSystemNew.module.GroupSubject;

public class GroupSubjectMapper {
    public static GroupSubjectDtoResponse groupSubjectToDto(GroupSubject groupSubject) {
        GroupSubjectDtoResponse groupSubjectDtoResponse = new GroupSubjectDtoResponse();

        if (groupSubject.getSubject() != null) {
            groupSubjectDtoResponse.setSubject(SubjectMapper.subjectToDto(groupSubject.getSubject()));
        }

        if (groupSubject.getGroup() != null) {
            groupSubjectDtoResponse.setGroup(GroupMapper.groupToDto(groupSubject.getGroup()));
        }
        if (groupSubject.getTeacher() != null) {
            groupSubjectDtoResponse.setTeacher(TeacherMapper.teacherToDto(groupSubject.getTeacher()));
        }

        return groupSubjectDtoResponse;
    }
}
