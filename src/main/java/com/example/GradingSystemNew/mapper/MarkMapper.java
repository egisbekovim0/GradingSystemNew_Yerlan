package com.example.GradingSystemNew.mapper;

import com.example.GradingSystemNew.dto.response.*;
import com.example.GradingSystemNew.module.Group;
import com.example.GradingSystemNew.module.GroupSubject;
import com.example.GradingSystemNew.module.Mark;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MarkMapper {

    public static List<MarkDtoResponse> marksToDto(List<Mark> marks) {
        return marks.stream()
                .map(MarkMapper::markToDto)
                .collect(Collectors.toList());
    }
    public static MarkDtoResponse markToDto(Mark mark) {

        MarkDtoResponse markDtoResponse = new MarkDtoResponse();

        if (mark.getMarkType() != null) {
            markDtoResponse.setMarkType(MarkTypeMapper.markTypeToDto(mark.getMarkType()));
        }

        if (mark.getStudent() != null) {
            markDtoResponse.setStudent(StudentMapper.studentToDto(mark.getStudent()));
        }
        if (mark.getGroupSubject() != null) {
            markDtoResponse.setGroupSubject(GroupSubjectMapper.groupSubjectToDto(mark.getGroupSubject()));
        }
        markDtoResponse.setMark(mark.getMark());


        return markDtoResponse;
    }
}

//    public static MarkDtoResponse markToDto2(Mark mark){
//        GroupSubjectDtoResponse groupSubjectDtoResponse = GroupSubjectMapper.groupSubjectToDto(mark.getGroupSubject());
//        MarkTypeDtoResponse markTypeDtoResponse = MarkTypeMapper.markTypeToDto(mark.getMarkType());
//        StudentDtoResponse studentDtoResponse = StudentMapper.studentToDto(mark.getStudent());
//
//        MarkDtoResponse markDtoResponse = new MarkDtoResponse(groupSubjectDtoResponse,studentDtoResponse,  markTypeDtoResponse, mark.getMark());
//        return markDtoResponse;
//    }