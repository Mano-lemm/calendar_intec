package com.example.calendar.model.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class LoginRequest {
    @NotNull String username;
    @NotNull String password;
}
