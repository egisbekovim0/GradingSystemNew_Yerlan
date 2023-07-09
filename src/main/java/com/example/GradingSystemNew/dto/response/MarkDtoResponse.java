package com.example.GradingSystemNew.dto.response;

import com.example.GradingSystemNew.module.MarkType;
import com.example.GradingSystemNew.module.Student;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarkDtoResponse {

    private GroupSubjectDtoResponse groupSubject;
    private StudentDtoResponse student;
    private MarkTypeDtoResponse markType;
    private float mark;
//    public MarkDtoResponse(GroupSubjectDtoResponse groupSubject, StudentDtoResponse student, MarkTypeDtoResponse markType, float mark) {
//        this.student = student;
//        this.groupSubject = groupSubject;
//        this.markType = markType;
//        this.mark = mark;
//    }
//    public MarkDtoResponse(){
//
//    }

}
