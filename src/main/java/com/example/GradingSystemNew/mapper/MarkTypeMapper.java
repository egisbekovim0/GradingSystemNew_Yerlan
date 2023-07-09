package com.example.GradingSystemNew.mapper;

import com.example.GradingSystemNew.dto.response.MarkTypeDtoResponse;
import com.example.GradingSystemNew.module.MarkType;

public class MarkTypeMapper {

    public static MarkTypeDtoResponse markTypeToDto(MarkType markType) {
        MarkTypeDtoResponse markTypeDtoResponse = new MarkTypeDtoResponse();

        markTypeDtoResponse.setId(markType.getId());
        markTypeDtoResponse.setName(markType.getName());

        return markTypeDtoResponse;
    }
}
