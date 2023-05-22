package com.example.calendar.model.dtos;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class UpdateTaskRequest {
    // what task to update
    private Long id;
    private LocalDateTime dateTime;
    private String description;
    private String title;
}
