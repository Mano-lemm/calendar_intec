package com.example.calendar.model.dtos.v1api;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class ReadTaskResponse {
    private Long id;
    private String Title;
    private String Description;
    private LocalDateTime dateTime;
}
