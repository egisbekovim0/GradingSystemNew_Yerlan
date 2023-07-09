package com.example.GradingSystemNew.controllers;
import com.example.GradingSystemNew.dto.request.SubjectDtoRequest;
import com.example.GradingSystemNew.dto.response.SubjectDtoResponse;
import com.example.GradingSystemNew.exception.ExceptionHandling;
import com.example.GradingSystemNew.mapper.SubjectMapper;
import com.example.GradingSystemNew.module.Subject;
import com.example.GradingSystemNew.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/subject")
@RequiredArgsConstructor
public class SubjectController extends ExceptionHandling {
    private final SubjectService subjectService;

    @PostMapping("/create")
    public ResponseEntity<SubjectDtoResponse> create(@Valid @RequestBody SubjectDtoRequest dtoRequest) {
        Subject subject = subjectService.create(dtoRequest);

        SubjectDtoResponse subjectDtoResponse = SubjectMapper.subjectToDto(subject);

        return new ResponseEntity<>(subjectDtoResponse, HttpStatus.CREATED);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<SubjectDtoResponse> update(@Valid @RequestBody SubjectDtoRequest dtoRequest,
                                                   @PathVariable(name = "id") Long id) {
        Subject subject = subjectService.update(dtoRequest, id);

        SubjectDtoResponse subjectDtoResponse = SubjectMapper.subjectToDto(subject);

        return new ResponseEntity<>(subjectDtoResponse, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable(name = "id") Long id) {
        subjectService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
