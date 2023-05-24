package com.example.calendar.model.dtos.v1api;

import lombok.Value;

import java.time.ZonedDateTime;

@Value
public class ReadTaskResponse {
    Long id;
    String Title;
    String Description;
    ZonedDateTime dateTime;
}
