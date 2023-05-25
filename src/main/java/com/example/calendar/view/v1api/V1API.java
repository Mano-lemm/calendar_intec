package com.example.calendar.view.v1api;

import com.example.calendar.model.dtos.v1api.*;

public interface V1API {
    public TaskResponse createTask(CreateTaskRequest req);
    public TaskResponse updateTask(UpdateTaskRequest req);
    public TaskResponse deleteTask(DeleteTaskRequest req);
    public ReadAllTasksResponse readAllTasksOnDay(ReadAllTasksOnDayRequest req);
    public ReadAllTasksResponse ReadAllTasks();
    public ReadAllTasksResponse ReadAllTasksInRange(ReadAllTasksInRangeRequest req);
}