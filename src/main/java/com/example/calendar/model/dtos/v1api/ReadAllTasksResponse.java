package com.example.calendar.model.dtos.v1api;

import lombok.Value;

import java.util.List;

@Value
public class ReadAllTasksResponse {
    List<ReadTaskResponse> responseList;
}
