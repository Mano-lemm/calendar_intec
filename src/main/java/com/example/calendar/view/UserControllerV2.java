package com.example.calendar.view;

import com.example.calendar.flow.exceptions.UserDoesNotExistException;
import com.example.calendar.flow.exceptions.UserPasswordIllegalException;
import com.example.calendar.flow.services.UserServiceV2;
import com.example.calendar.model.dtos.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
        try {
            return us.updateUser(req);
        } catch (UserDoesNotExistException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    String.format("User with id(%d) does not exist", req.id()),
                    e);
        }
    }

    @DeleteMapping("delete")
    @Override
    public UserPostResponse deleteUser(@RequestBody DeleteUserRequest req) {
        try {
            return us.deleteUser(req);
        } catch (UserDoesNotExistException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    String.format("User with id(%d) does not exist", req.id()),
                    e);
        } catch (UserPasswordIllegalException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Password did not match",
                    e);
        }
    }

    @GetMapping("get")
    @Override
    public UserGetResponse readUser(@RequestBody ReadUserRequest req) {
        try {
            return us.getUser(req);
        } catch (UserDoesNotExistException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    String.format("User with id(%d) does not exist", req.id()),
                    e);
        }
    }

    @GetMapping("login")
    @Override
    public UserGetResponse loginUser(@RequestParam(name = "username") String name, @RequestParam("password") String password){
        try {
            return us.loginUser(new LoginRequest(name,password));
        } catch (UserDoesNotExistException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    String.format("User with name(%s) does not exist", name),
                    e);
        } catch (UserPasswordIllegalException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Password did not match",
                    e);
        }
    }
}
