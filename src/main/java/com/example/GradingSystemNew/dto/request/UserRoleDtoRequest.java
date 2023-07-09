package com.example.GradingSystemNew.dto.request;

import com.sun.istack.NotNull;
import lombok.Getter;

@Getter
public class UserRoleDtoRequest {
    @NotNull
    private Long userId;
    @NotNull
    private Long roleId;

}
