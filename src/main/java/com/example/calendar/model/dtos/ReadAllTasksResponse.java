package com.example.calendar.model.dtos;

import lombok.Value;

import java.util.List;

@Value
public class ReadAllTasksResponse {
    List<ReadTaskResponse> responseList;
}
