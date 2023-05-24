package com.example.calendar.model.dtos.v1api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class ReadAllTasksInRangeRequest {
    @Schema(description = "ISO 8601 compliant start date and time string, with time zone", pattern = "YYYY-MM-DDThh:mm:ss±hh:mm", example = "2023-01-01T00:00:00+3:00")
    private ZonedDateTime start;
    @Schema(description = "ISO 8601 compliant end date and time string, with time zone", pattern = "YYYY-MM-DDThh:mm:ss±hh:mm", example = "2023-01-01T00:00:00+3:00")
    private ZonedDateTime end;
}
