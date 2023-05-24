package com.example.calendar.model.dtos.v1api;

import lombok.Value;

import java.time.LocalDate;
import java.time.ZonedDateTime;

@Value
public class ReadAllTasksOnDayRequest {
    private ZonedDateTime date;
}
