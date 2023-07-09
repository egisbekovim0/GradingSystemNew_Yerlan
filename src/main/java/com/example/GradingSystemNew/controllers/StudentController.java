package com.example.GradingSystemNew.controllers;

import com.example.GradingSystemNew.dto.request.StudentDtoRequest;
import com.example.GradingSystemNew.dto.request.SubjectDtoRequest;
import com.example.GradingSystemNew.dto.response.StudentDtoResponse;
import com.example.GradingSystemNew.dto.response.SubjectDtoResponse;
import com.example.GradingSystemNew.mapper.StudentMapper;
import com.example.GradingSystemNew.mapper.SubjectMapper;
import com.example.GradingSystemNew.module.Student;
import com.example.GradingSystemNew.module.Subject;
import com.example.GradingSystemNew.service.StudentService;
import com.example.GradingSystemNew.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<StudentDtoResponse> create(@Valid @RequestBody StudentDtoRequest dtoRequest) {
        Student student = studentService.create(dtoRequest);

        StudentDtoResponse studentDtoResponse = StudentMapper.studentToDto(student);

        return new ResponseEntity<>(studentDtoResponse, HttpStatus.CREATED);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<StudentDtoResponse> update(@Valid @RequestBody StudentDtoRequest dtoRequest,
                                                     @PathVariable(name = "id") Long id) {
        Student student = studentService.update(dtoRequest, id);

        StudentDtoResponse studentDtoResponse = StudentMapper.studentToDto(student);

        return new ResponseEntity<>(studentDtoResponse, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable(name = "id") Long id) {
        studentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
