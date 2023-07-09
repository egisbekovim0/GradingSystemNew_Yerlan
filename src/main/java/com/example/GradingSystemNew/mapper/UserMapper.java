package com.example.GradingSystemNew.mapper;

import com.example.GradingSystemNew.dto.response.UserDtoResponse;
import com.example.GradingSystemNew.module.security.User;

public class UserMapper {
    public static UserDtoResponse userToDo(User user){
        UserDtoResponse userDtoResponse = new UserDtoResponse();
        userDtoResponse.setUsername(user.getUsername());
        userDtoResponse.setName(user.getName());
        return userDtoResponse;
    }
}
