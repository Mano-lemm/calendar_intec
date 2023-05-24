package com.example.calendar.model.dtos.v1api;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class CreateTaskRequest {
    private ZonedDateTime dateTime;
    private String Title;
    private String Description;
}
