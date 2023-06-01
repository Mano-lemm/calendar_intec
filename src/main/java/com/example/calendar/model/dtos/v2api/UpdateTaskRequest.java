package com.example.calendar.model.dtos.v2api;

import lombok.Value;

import java.time.ZonedDateTime;

@Value
public class UpdateTaskRequest {
    ZonedDateTime dateTime;
    String description;
    String title;
    Long ownerId;
    Long taskId;
}
