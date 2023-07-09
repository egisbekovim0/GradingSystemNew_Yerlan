package com.example.GradingSystemNew.mapper;

import com.example.GradingSystemNew.dto.response.GroupDtoResponse;
import com.example.GradingSystemNew.module.Group;

public class GroupMapper {
    public static GroupDtoResponse groupToDto(Group group) {
        GroupDtoResponse groupDtoResponse = new GroupDtoResponse();

        groupDtoResponse.setId(group.getId());

        groupDtoResponse.setName(group.getName());

        return groupDtoResponse;
    }
}
