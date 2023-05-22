package com.example.calendar.model.dtos;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class CreateTaskRequest {
    private LocalDateTime dateTime;
    private String Title;
    private String Description;
}
