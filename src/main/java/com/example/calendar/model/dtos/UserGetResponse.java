package com.example.calendar.model.dtos;

import jakarta.validation.constraints.NotNull;

public record UserGetResponse(@NotNull String name, @NotNull Long id) {
}
