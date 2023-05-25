package com.example.calendar.model.dtos.v2api;

import lombok.Value;

@Value
public class CreateUserRequest {
    String name;
    String password;
}
