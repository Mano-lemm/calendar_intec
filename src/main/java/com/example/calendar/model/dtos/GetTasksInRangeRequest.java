package com.example.calendar.model.dtos;

import java.time.ZonedDateTime;

public record GetTasksInRangeRequest(ZonedDateTime start, ZonedDateTime end) {
}
