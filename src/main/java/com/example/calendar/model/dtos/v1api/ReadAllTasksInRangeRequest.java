package com.example.calendar.model.dtos.v1api;

import lombok.Value;

import java.time.ZonedDateTime;

@Value
public class ReadAllTasksInRangeRequest {
    ZonedDateTime start;
    ZonedDateTime end;
}
