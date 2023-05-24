package com.example.calendar.model.dtos.v1api;

import lombok.Value;

import java.time.ZonedDateTime;

@Value
public class UpdateTaskRequest {
    // what task to update
    private Long id;
    private ZonedDateTime dateTime;
    private String description;
    private String title;
}
