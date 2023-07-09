package com.example.GradingSystemNew.controllers;

import com.example.GradingSystemNew.dto.request.GroupDtoRequest;
import com.example.GradingSystemNew.dto.request.MarkTypeDtoRequest;
import com.example.GradingSystemNew.dto.response.GroupDtoResponse;
import com.example.GradingSystemNew.dto.response.MarkDtoResponse;
import com.example.GradingSystemNew.dto.response.MarkTypeDtoResponse;
import com.example.GradingSystemNew.exception.ExceptionHandling;
import com.example.GradingSystemNew.mapper.GroupMapper;
import com.example.GradingSystemNew.mapper.MarkTypeMapper;
import com.example.GradingSystemNew.module.Group;
import com.example.GradingSystemNew.module.MarkType;
import com.example.GradingSystemNew.service.GroupService;
import com.example.GradingSystemNew.service.MarkTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/mark-type")
@RequiredArgsConstructor
public class MarkTypeController extends ExceptionHandling {
    private final MarkTypeService markTypeService;


    @PostMapping("/create")
    public ResponseEntity<MarkTypeDtoResponse> create(@Valid @RequestBody MarkTypeDtoRequest dtoRequest) {
        MarkType markType = markTypeService.create(dtoRequest);

        MarkTypeDtoResponse markTypeDtoResponse = MarkTypeMapper.markTypeToDto(markType);

        return new ResponseEntity<>(markTypeDtoResponse, HttpStatus.CREATED);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<MarkTypeDtoResponse> update(@Valid @RequestBody MarkTypeDtoRequest dtoRequest,
                                                   @PathVariable(name = "id") Long id) {
        MarkType markType = markTypeService.update(dtoRequest, id);

        MarkTypeDtoResponse markTypeDtoResponse = MarkTypeMapper.markTypeToDto(markType);

        return new ResponseEntity<>(markTypeDtoResponse, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable(name = "id") Long id) {
        markTypeService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
