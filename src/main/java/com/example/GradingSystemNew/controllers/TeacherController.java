package com.example.GradingSystemNew.controllers;

import com.example.GradingSystemNew.dto.request.StudentDtoRequest;
import com.example.GradingSystemNew.dto.request.SubjectDtoRequest;
import com.example.GradingSystemNew.dto.request.TeacherDtoRequest;
import com.example.GradingSystemNew.dto.response.StudentDtoResponse;
import com.example.GradingSystemNew.dto.response.SubjectDtoResponse;
import com.example.GradingSystemNew.dto.response.TeacherDtoResponse;
import com.example.GradingSystemNew.mapper.StudentMapper;
import com.example.GradingSystemNew.mapper.SubjectMapper;
import com.example.GradingSystemNew.mapper.TeacherMapper;
import com.example.GradingSystemNew.module.Student;
import com.example.GradingSystemNew.module.Subject;
import com.example.GradingSystemNew.module.Teacher;
import com.example.GradingSystemNew.service.StudentService;
import com.example.GradingSystemNew.service.SubjectService;
import com.example.GradingSystemNew.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @PostMapping("/create")
    public ResponseEntity<TeacherDtoResponse> create(@Valid @RequestBody TeacherDtoRequest dtoRequest) {
        Teacher teacher = teacherService.create(dtoRequest);

        TeacherDtoResponse teacherDtoResponse = TeacherMapper.teacherToDto(teacher);

        return new ResponseEntity<>(teacherDtoResponse, HttpStatus.CREATED);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<TeacherDtoResponse> update(@Valid @RequestBody TeacherDtoRequest dtoRequest,
                                                     @PathVariable(name = "id") Long id) {
        Teacher teacher = teacherService.update(dtoRequest, id);

        TeacherDtoResponse teacherDtoResponse = TeacherMapper.teacherToDto(teacher);

        return new ResponseEntity<>(teacherDtoResponse, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable(name = "id") Long id) {
        teacherService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
