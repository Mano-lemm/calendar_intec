package com.example.calendar.view.v2api;

import com.example.calendar.flow.services.V2API.UserServiceV2;
import com.example.calendar.model.dtos.v2api.*;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@RequestMapping("/api/v2/user")
public class UserControllerV2 implements V2UserAPI{
    private final UserServiceV2 us;

    public UserControllerV2(UserServiceV2 us){
        this.us = us;
    }

    @PostMapping("Create")
    @Override
    public UserPostResponse createUser(CreateUserRequest req) {
        return us.createUser(req);
    }

    @PostMapping("update")
    @Override
    public UserPostResponse updateUser(UpdateUserRequest req) {
        return us.updateUser(req);
    }

    @DeleteMapping("delete")
    @Override
    public UserPostResponse deleteUser(DeleteUserRequest req) {
        return us.deleteUser(req);
    }

    @GetMapping("get")
    @Override
    public UserGetResponse readUser(ReadUserRequest req) {
        return us.getUser(req);
    }
}
