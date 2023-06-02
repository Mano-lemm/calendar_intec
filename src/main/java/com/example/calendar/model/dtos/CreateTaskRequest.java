package com.example.calendar.model.dtos;

import lombok.Value;

import java.time.ZonedDateTime;

@Value
public class CreateTaskRequest {
    ZonedDateTime dateTime;
    String description;
    String title;
    Long ownerId;
}
