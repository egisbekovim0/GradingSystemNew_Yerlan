package com.example.GradingSystemNew.controllers;
import com.example.GradingSystemNew.dto.request.GroupSubjectDtoRequest;
import com.example.GradingSystemNew.dto.response.GroupSubjectDtoResponse;
import com.example.GradingSystemNew.exception.ExceptionHandling;

import com.example.GradingSystemNew.mapper.GroupSubjectMapper;
import com.example.GradingSystemNew.module.GroupSubject;
import com.example.GradingSystemNew.service.GroupSubjectService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1/group-subject")
@RequiredArgsConstructor
public class GroupSubjectController extends ExceptionHandling {
    private final GroupSubjectService groupSubjectService;


    @GetMapping("/group-id/{id}")
    public ResponseEntity<List<GroupSubjectDtoResponse>> getAllByFootballPlayerId(@PathVariable(name = "id") Long id) {
        List<GroupSubjectDtoResponse> dtoResponseList = groupSubjectService.getAllBySubjectId(id)
                .stream().map(GroupSubjectMapper::groupSubjectToDto).collect(Collectors.toList());

        return new ResponseEntity<>(dtoResponseList, HttpStatus.OK);
    }


    @GetMapping("/subject-id/{id}")
    public ResponseEntity<List<GroupSubjectDtoResponse>> getAllByFootballClubId(@PathVariable(name = "id") Long id) {
        List<GroupSubjectDtoResponse> dtoResponseList = groupSubjectService.getAllByGroupId(id)
                .stream().map(GroupSubjectMapper::groupSubjectToDto).collect(Collectors.toList());

        return new ResponseEntity<>(dtoResponseList, HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<GroupSubjectDtoResponse> create(@Valid @RequestBody GroupSubjectDtoRequest dtoRequest) {
        GroupSubject groupSubject = groupSubjectService.create(dtoRequest);

        GroupSubjectDtoResponse dtoResponse = GroupSubjectMapper.groupSubjectToDto(groupSubject);

        return new ResponseEntity<>(dtoResponse, HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable(name = "id") Long id) {
        groupSubjectService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
