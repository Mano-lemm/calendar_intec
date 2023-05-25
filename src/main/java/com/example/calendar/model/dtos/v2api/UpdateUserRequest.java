package com.example.calendar.model.dtos.v2api;

import lombok.Value;

@Value
public class UpdateUserRequest {
    Long id;
    String name;
    String password;
}
