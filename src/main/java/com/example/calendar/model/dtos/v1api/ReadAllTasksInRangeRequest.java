package com.example.calendar.model.dtos.v1api;

import lombok.Value;

import java.time.LocalDate;

@Value
public class ReadAllTasksInRangeRequest {
    LocalDate start;
    LocalDate end;
}
