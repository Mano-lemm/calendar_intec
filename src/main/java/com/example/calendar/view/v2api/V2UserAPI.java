package com.example.calendar.view.v2api;

import com.example.calendar.model.dtos.v2api.*;

public interface V2UserAPI {
    public UserPostResponse createUser(CreateUserRequest req);

    public UserPostResponse updateUser(UpdateUserRequest req);

    public UserPostResponse deleteUser(DeleteUserRequest req);

    public UserGetResponse readUser(ReadUserRequest req);
}
