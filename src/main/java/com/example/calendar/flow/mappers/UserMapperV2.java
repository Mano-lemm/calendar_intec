package com.example.calendar.flow.mappers;

import com.example.calendar.model.dtos.*;
import com.example.calendar.model.entities.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapperV2 {

    public static UserGetResponse toGetResponse(User owner) {
        return new UserGetResponse(owner.getName(), owner.getId());
    }

    public static User toEntity(CreateUserRequest req) {
        User user = new User();
        user.setName(req.getName());
        return user;
    }

    public static UserPostResponse toResponse(User user) {
        return new UserPostResponse(user.getId());
    }

    public static User toEntity(UpdateUserRequest req) {
        User user = new User();
        user.setName(req.getName());
        user.setId(req.getId());
        return user;
    }

    public static User toEntity(DeleteUserRequest req) {
        User user = new User();
        user.setId(req.getId());
        return user;
    }

    public static User toEntity(ReadUserRequest req) {
        User user = new User();
        user.setId(req.getId());
        return user;
    }

    public static User toEntity(LoginRequest req) {
        User user = new User();
        user.setName(req.getUsername());
        return user;
    }
}
