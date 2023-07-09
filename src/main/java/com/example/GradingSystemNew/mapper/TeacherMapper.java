package com.example.GradingSystemNew.mapper;

import com.example.GradingSystemNew.dto.response.GroupDtoResponse;
import com.example.GradingSystemNew.dto.response.StudentDtoResponse;
import com.example.GradingSystemNew.dto.response.TeacherDtoResponse;
import com.example.GradingSystemNew.module.Group;
import com.example.GradingSystemNew.module.Student;
import com.example.GradingSystemNew.module.Teacher;

public class TeacherMapper {
    public static TeacherDtoResponse teacherToDto(Teacher teacher) {
        TeacherDtoResponse teacherDtoResponse = new TeacherDtoResponse();

        teacherDtoResponse.setId(teacher.getId());

        teacherDtoResponse.setF_name(teacher.getF_name());
        teacherDtoResponse.setL_name(teacher.getL_name());
        teacherDtoResponse.setUser(UserMapper.userToDo(teacher.getUser()));

        return teacherDtoResponse;
    }
}
