package com.example.calendar.model.dtos;

import java.time.ZonedDateTime;

public record CreateTaskRequest (ZonedDateTime dateTime, String description, String title, Long ownerId){
}
