package com.example.calendar.model.dtos.v2api;

import lombok.Value;

import java.time.ZonedDateTime;

@Value
public class UpdateTaskRequest {
    private ZonedDateTime dateTime;
    private String description;
    private String title;
    private Long ownerId;
}
