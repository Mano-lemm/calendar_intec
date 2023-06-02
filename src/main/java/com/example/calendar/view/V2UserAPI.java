package com.example.calendar.view;

import com.example.calendar.model.dtos.*;

@SuppressWarnings("unused")
public interface V2UserAPI {
    UserPostResponse createUser(CreateUserRequest req);

    UserPostResponse updateUser(UpdateUserRequest req);

    UserPostResponse deleteUser(DeleteUserRequest req);

    UserGetResponse readUser(ReadUserRequest req);

    UserGetResponse loginUser(String name, String password);
}
