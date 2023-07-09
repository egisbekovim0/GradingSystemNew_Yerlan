package com.example.GradingSystemNew.mapper;

import com.example.GradingSystemNew.dto.response.GroupDtoResponse;
import com.example.GradingSystemNew.dto.response.StudentDtoResponse;
import com.example.GradingSystemNew.module.Group;
import com.example.GradingSystemNew.module.Student;

public class StudentMapper {
    public static StudentDtoResponse studentToDto(Student student) {
        StudentDtoResponse studentDtoResponse = new StudentDtoResponse();

        studentDtoResponse.setId(student.getId());

        studentDtoResponse.setF_name(student.getF_name());
        studentDtoResponse.setL_name(student.getL_name());
        studentDtoResponse.setUser(UserMapper.userToDo(student.getUser()));

        return studentDtoResponse;
    }
}
