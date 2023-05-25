package com.example.calendar.model.dtos.v1api;

import lombok.Value;

import java.time.LocalDate;

@Value
public class ReadAllTasksOnDayRequest {
    private LocalDate date;
}
