package com.example.calendar.view.v2api;

import com.example.calendar.model.dtos.v2api.*;

import java.time.ZonedDateTime;
import java.util.List;

public interface V2TaskAPI {
    TaskPostResponse createTask(CreateTaskRequest req);

    TaskPostResponse updateTask(UpdateTaskRequest req);

    TaskPostResponse deleteTask(Long id);

    TaskGetResponse getTask(GetTaskRequest req);

    List<TaskGetResponse> getAllTasks();

    List<TaskGetResponse> getAllTasksByUserId(Long userId);

    List<TaskGetResponse> getAllTasksInRange(ZonedDateTime start, ZonedDateTime end);
}
