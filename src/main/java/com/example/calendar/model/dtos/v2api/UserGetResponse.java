package com.example.calendar.model.dtos.v2api;

import jakarta.validation.constraints.NotNull;

public record UserGetResponse(@NotNull String name, @NotNull Long id) {
}
