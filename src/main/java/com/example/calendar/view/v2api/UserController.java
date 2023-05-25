package com.example.calendar.view.v2api;

import com.example.calendar.flow.services.V2API.UserService;
import com.example.calendar.model.dtos.v2api.*;

public class UserController implements V2UserAPI{
    private final UserService us;

    public UserController(UserService us){
        this.us = us;
    }

    @Override
    public UserPostResponse createUser(CreateUserRequest req) {
        return us.createUser(req);
    }

    @Override
    public UserPostResponse updateUser(UpdateUserRequest req) {
        return us.updateUser(req);
    }

    @Override
    public UserPostResponse deleteUser(DeleteUserRequest req) {
        return us.deleteUser(req);
    }

    @Override
    public UserGetResponse readUser(ReadUserRequest req) {
        return us.getUser(req);
    }
}
