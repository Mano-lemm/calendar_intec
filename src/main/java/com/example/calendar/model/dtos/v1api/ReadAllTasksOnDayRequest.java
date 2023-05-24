package com.example.calendar.model.dtos.v1api;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class ReadAllTasksOnDayRequest {
    private ZonedDateTime date;
}
