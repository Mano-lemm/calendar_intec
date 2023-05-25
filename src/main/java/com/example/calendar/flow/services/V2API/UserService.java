package com.example.calendar.flow.services.V2API;

import com.example.calendar.flow.exceptions.UserDoesNotExistException;
import com.example.calendar.flow.exceptions.UserPasswordDoesNotMatchException;
import com.example.calendar.flow.mappers.V2API.UserMapper;
import com.example.calendar.model.dtos.v2api.*;
import com.example.calendar.model.entities.User;
import com.example.calendar.model.repositories.TaskRepository;
import com.example.calendar.model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Value("${PASSWORD_PEPPER}")
    private String pepper;
    @Value("${PASSWORD_STR}")
    private Integer passwordStrength;
    private final UserRepository ur;
    private final TaskRepository tr;
    private final BCryptPasswordEncoder encoder;
    private final TaskService ts;

    public UserService(TaskService taskService, TaskRepository taskRepository, UserRepository userRepository, BCryptPasswordEncoder encoder){
        this.ur = userRepository;
        this.ts = taskService;
        this.tr = taskRepository;
        this.encoder = encoder;
    }

    public UserPostResponse createUser(CreateUserRequest req) {
        User user = UserMapper.toEntity(req);
        user.setPwdHashAndSalt(encoder.encode(req.getPassword() + pepper));
        user = ur.save(user);
        return UserMapper.toResponse(user);
    }

    public UserPostResponse updateUser(UpdateUserRequest req) {
        User updated = UserMapper.toEntity(req);
        User current = ur.findById(updated.getId()).orElseThrow(UserDoesNotExistException::new);
        if(!encoder.matches(req.getPassword(), current.getPwdHashAndSalt())){
            throw new UserPasswordDoesNotMatchException();
        }
        updated.setPwdHashAndSalt(current.getPwdHashAndSalt());
        ur.save(updated);
        return UserMapper.toResponse(updated);
    }

    public UserPostResponse deleteUser(DeleteUserRequest req) {
        User user = UserMapper.toEntity(req);
        User toDelete = ur.findById(user.getId()).orElseThrow(UserDoesNotExistException::new);
        ur.delete(toDelete);
        return UserMapper.toResponse(toDelete);
    }

    public UserGetResponse getUser(ReadUserRequest req) {
        User user = UserMapper.toEntity(req);
        user = ur.findById(user.getId()).orElseThrow(UserDoesNotExistException::new);
        return UserMapper.toGetResponse(user);
    }
}
