package com.example.calendar.model.dtos;

import lombok.Value;

import java.time.LocalDate;

@Value
public class ReadAllTasksOnDayRequest {
    private LocalDate date;
}
