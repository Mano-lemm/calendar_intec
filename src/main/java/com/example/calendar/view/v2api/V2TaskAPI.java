package com.example.calendar.view.v2api;

import com.example.calendar.model.dtos.v2api.*;

import java.util.List;

public interface V2TaskAPI {
    public TaskPostResponse createTask(CreateTaskRequest req);

    public TaskPostResponse updateTask(UpdateTaskRequest req);

    public TaskPostResponse deleteTask(DeleteTaskRequest req);

    public TaskGetResponse getTask(GetTaskRequest req);

    public List<TaskGetResponse> getAllTasks();

    public List<TaskGetResponse> getAllTasksInRange(GetTasksInRangeRequest req);
}
