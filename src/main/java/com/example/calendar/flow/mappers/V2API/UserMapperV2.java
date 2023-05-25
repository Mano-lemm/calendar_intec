package com.example.calendar.flow.mappers.V2API;

import com.example.calendar.model.dtos.v2api.*;
import com.example.calendar.model.entities.User;
import lombok.experimental.UtilityClass;

import java.security.SecureRandom;

@UtilityClass
public class UserMapperV2 {
    private static final SecureRandom rand = new SecureRandom();

    public static UserGetResponse toGetResponse(User owner) {
        UserGetResponse ugr = new UserGetResponse(owner.getName());
        return ugr;
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
}
