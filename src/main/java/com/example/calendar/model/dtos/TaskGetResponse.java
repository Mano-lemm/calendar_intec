package com.example.calendar.model.dtos;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class TaskGetResponse {
    private ZonedDateTime dateTime;
    private String description;
    private String title;
    private UserGetResponse Owner;
    private Long id;
}
