package com.example.calendar.model.dtos.v1api;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class ReadAllTasksInRangeRequest {
    private ZonedDateTime start;
    private ZonedDateTime end;
}
