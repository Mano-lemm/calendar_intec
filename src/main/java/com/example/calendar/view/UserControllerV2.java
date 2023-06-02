package com.example.calendar.view;

import com.example.calendar.flow.services.UserServiceV2;
import com.example.calendar.model.dtos.*;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@RequestMapping("/api/v2/user")
public class UserControllerV2 implements V2UserAPI{
    private final UserServiceV2 us;

    public UserControllerV2(UserServiceV2 us){
        this.us = us;
    }

    @PostMapping("create")
    @Override
    public UserPostResponse createUser(@RequestBody CreateUserRequest req) {
        return us.createUser(req);
    }

    @PostMapping("update")
    @Override
    public UserPostResponse updateUser(@RequestBody UpdateUserRequest req) {
        return us.updateUser(req);
    }

    @DeleteMapping("delete")
    @Override
    public UserPostResponse deleteUser(@RequestBody DeleteUserRequest req) {
        return us.deleteUser(req);
    }

    @GetMapping("get")
    @Override
    public UserGetResponse readUser(@RequestBody ReadUserRequest req) {
        return us.getUser(req);
    }

    @GetMapping("login")
    @Override
    public UserGetResponse loginUser(@RequestParam(name = "username") String name, @RequestParam("password") String password){
        return us.loginUser(new LoginRequest(name,password));
    }
}
