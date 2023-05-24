package com.example.calendar.model.dtos.v1api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

import java.time.ZonedDateTime;

@Value
public class ReadTaskResponse {
    Long id;
    String Title;
    String Description;
    @Schema(description = "ISO 8601 compliant date and time string, with time zone", pattern = "YYYY-MM-DDThh:mm:ss±hh:mm", example = "2023-01-01T00:00:00+3:00")
    ZonedDateTime dateTime;
}
