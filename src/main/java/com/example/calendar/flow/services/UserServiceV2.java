package com.example.calendar.flow.services;

import com.example.calendar.flow.exceptions.UserDoesNotExistException;
import com.example.calendar.flow.exceptions.UserPasswordDoesNotMatchException;
import com.example.calendar.flow.exceptions.UserPasswordIllegalException;
import com.example.calendar.flow.mappers.UserMapperV2;
import com.example.calendar.model.dtos.*;
import com.example.calendar.model.entities.User;
import com.example.calendar.model.repositories.TaskRepository;
import com.example.calendar.model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceV2 {
    private String pepper;
    private final UserRepository ur;
    private final TaskRepository tr;
    private final BCryptPasswordEncoder encoder;

    public UserServiceV2(TaskRepository taskRepository, UserRepository userRepository, @Value("${PASSWORD_PEPPER}") String pepper){
        this.ur = userRepository;
        this.tr = taskRepository;
        this.pepper = pepper;
        this.encoder = new BCryptPasswordEncoder();
    }

    public UserPostResponse createUser(CreateUserRequest req) {
        User user = UserMapperV2.toEntity(req);
        user.setPwdHashAndSalt(encoder.encode(req.getPassword() + pepper));
        user = ur.save(user);
        return UserMapperV2.toResponse(user);
    }

    public UserPostResponse updateUser(UpdateUserRequest req) {
        User updated = UserMapperV2.toEntity(req);
        User current = ur.findById(updated.getId()).orElseThrow(UserDoesNotExistException::new);
        if(!encoder.matches(req.getPassword(), current.getPwdHashAndSalt())){
            throw new UserPasswordDoesNotMatchException();
        }
        updated.setPwdHashAndSalt(current.getPwdHashAndSalt());
        ur.save(updated);
        return UserMapperV2.toResponse(updated);
    }

    public UserPostResponse deleteUser(DeleteUserRequest req) {
        User user = UserMapperV2.toEntity(req);
        User toDelete = ur.findById(user.getId()).orElseThrow(UserDoesNotExistException::new);
        ur.delete(toDelete);
        return UserMapperV2.toResponse(toDelete);
    }

    public UserGetResponse getUser(ReadUserRequest req) {
        User user = UserMapperV2.toEntity(req);
        user = ur.findById(user.getId()).orElseThrow(UserDoesNotExistException::new);
        return UserMapperV2.toGetResponse(user);
    }

    public UserGetResponse loginUser(LoginRequest req) {
        User user = UserMapperV2.toEntity(req);
        user = ur.findByName(user.getName()).orElseThrow(UserDoesNotExistException::new);
        if(!encoder.matches(req.getPassword() + this.pepper, user.getPwdHashAndSalt())) {
            throw new UserPasswordIllegalException();
        }
        return UserMapperV2.toGetResponse(user);
    }
}
