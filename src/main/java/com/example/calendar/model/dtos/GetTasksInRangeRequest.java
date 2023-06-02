package com.example.calendar.model.dtos;

import lombok.Value;

import java.time.ZonedDateTime;

@Value
public class GetTasksInRangeRequest {
    ZonedDateTime start;
    ZonedDateTime end;
}
