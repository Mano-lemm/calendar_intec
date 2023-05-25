package com.example.calendar.model.dtos.v2api;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.ZonedDateTime;

@Data
@Accessors(fluent = true)
public class TaskGetResponse {
    private ZonedDateTime dateTime;
    private String description;
    private String title;
    private UserGetResponse Owner;
}
