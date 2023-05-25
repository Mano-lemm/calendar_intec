package com.example.calendar.model.dtos.v2api;

import lombok.Value;

import java.time.ZonedDateTime;

@Value
public class GetTasksInRangeRequest {
    ZonedDateTime start;
    ZonedDateTime end;
}
