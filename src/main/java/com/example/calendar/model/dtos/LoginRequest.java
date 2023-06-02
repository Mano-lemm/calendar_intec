package com.example.calendar.model.dtos;

import jakarta.validation.constraints.NotNull;

public record LoginRequest(@NotNull String username, @NotNull String password) {
}
