package com.example.calendar.view;

import com.example.calendar.model.dtos.*;

public interface exposed_api {
    public TaskResponse createTask(CreateTaskRequest req);
    public TaskResponse updateTask(UpdateTaskRequest req);
    public TaskResponse deleteTask(DeleteTaskRequest req);
    public ReadAllTasksResponse readAllTasksOnDay(ReadAllTasksOnDayRequest req);
    public ReadAllTasksResponse ReadAllTasks();
    public ReadAllTasksResponse ReadAllTasksInRange(ReadAllTasksInRangeRequest req);
}