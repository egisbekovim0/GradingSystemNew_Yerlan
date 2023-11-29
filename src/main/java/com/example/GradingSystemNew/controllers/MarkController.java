package com.example.GradingSystemNew.controllers;
import com.example.GradingSystemNew.dto.request.MarkDtoRequest;
import com.example.GradingSystemNew.dto.response.MarkDtoResponse;
import com.example.GradingSystemNew.exception.ExceptionHandling;
import com.example.GradingSystemNew.mapper.MarkMapper;
import com.example.GradingSystemNew.module.Mark;
import com.example.GradingSystemNew.service.MarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/mark")
@RequiredArgsConstructor
public class MarkController extends ExceptionHandling {
    private final MarkService markService;

    @GetMapping("/subjects/{studentId}/{subjectId}")
    public ResponseEntity<List<MarkDtoResponse>> getMarksByStudentAndSubject(
            @PathVariable Long studentId,
            @PathVariable Long subjectId
    ) {
        List<MarkDtoResponse> marks = markService.getMarksByStudentAndSubject(studentId, subjectId);
        return new ResponseEntity<>(marks, HttpStatus.OK);
    }
    @GetMapping("/marks/{studentId}")
    public ResponseEntity<List<MarkDtoResponse>> getMarksByStudentId(@PathVariable Long studentId) {
        List<Mark> marks = markService.getByStudentId(studentId);
        List<MarkDtoResponse> markDtoResponses = MarkMapper.marksToDto(marks);
        return new ResponseEntity<>(markDtoResponses, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<MarkDtoResponse> create(@Valid @RequestBody MarkDtoRequest dtoRequest) {
        Mark mark = markService.create(dtoRequest);

        MarkDtoResponse markDtoResponse = MarkMapper.markToDto(mark);

        return new ResponseEntity<>(markDtoResponse, HttpStatus.CREATED);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<MarkDtoResponse> update(@Valid @RequestBody MarkDtoRequest dtoRequest,
                                                   @PathVariable(name = "id") Long id) {
        Mark mark= markService.update(dtoRequest, id);

        MarkDtoResponse markDtoResponse = MarkMapper.markToDto(mark);

        return new ResponseEntity<>(markDtoResponse, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable(name = "id") Long id) {
        markService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
