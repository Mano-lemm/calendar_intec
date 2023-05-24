package com.example.calendar.model.dtos.v1api;

import lombok.Value;

import java.time.ZonedDateTime;

@Value
public class CreateTaskRequest {
    private ZonedDateTime dateTime;
    private String Title;
    private String Description;
}
