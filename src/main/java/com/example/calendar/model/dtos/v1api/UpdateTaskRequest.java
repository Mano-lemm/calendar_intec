package com.example.calendar.model.dtos.v1api;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class UpdateTaskRequest {
    // what tasks to update
    private Long id;
    private ZonedDateTime dateTime;
    private String Description;
    private String Title;
}
