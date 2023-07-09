package com.example.GradingSystemNew.controllers;

import com.example.GradingSystemNew.dto.request.GroupDtoRequest;
import com.example.GradingSystemNew.dto.response.GroupDtoResponse;
import com.example.GradingSystemNew.exception.ExceptionHandling;
import com.example.GradingSystemNew.mapper.GroupMapper;
import com.example.GradingSystemNew.module.Group;
import com.example.GradingSystemNew.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/group")
@RequiredArgsConstructor
public class GroupController extends ExceptionHandling {
    private final GroupService groupService;


    @PostMapping("/create")
    public ResponseEntity<GroupDtoResponse> create(@Valid @RequestBody GroupDtoRequest dtoRequest) {
        Group group = groupService.create(dtoRequest);

        GroupDtoResponse groupDtoResponse = GroupMapper.groupToDto(group);

        return new ResponseEntity<>(groupDtoResponse, HttpStatus.CREATED);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<GroupDtoResponse> update(@Valid @RequestBody GroupDtoRequest dtoRequest,
                                                          @PathVariable(name = "id") Long id) {
        Group group = groupService.update(dtoRequest, id);

        GroupDtoResponse groupDtoResponse = GroupMapper.groupToDto(group);

        return new ResponseEntity<>(groupDtoResponse, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable(name = "id") Long id) {
        groupService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
