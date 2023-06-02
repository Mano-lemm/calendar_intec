package com.example.calendar.model.dtos;

import lombok.Value;

@Value
public class UpdateUserRequest {
    Long id;
    String name;
    String password;
}
