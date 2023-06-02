package com.example.calendar.model.dtos;

import lombok.Value;

@Value
public class CreateUserRequest {
    String name;
    String password;
}
