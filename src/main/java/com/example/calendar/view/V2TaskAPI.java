package com.example.calendar.view;

import com.example.calendar.model.dtos.v2api.*;

public interface V2TaskAPI {
    public TaskPostResponse createTask(CreateTaskRequest req);

    public TaskPostResponse updateTask(UpdateTaskRequest req);

    public TaskPostResponse deleteTask(DeleteTaskRequest req);

    public TaskGetResponse getTask(GetTaskRequest req);
}
