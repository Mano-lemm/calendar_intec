package com.example.calendar.model.dtos;

import java.time.ZonedDateTime;

public record UpdateTaskRequest(ZonedDateTime dateTime, String description, String title, Long ownerId, Long taskId) {
}
