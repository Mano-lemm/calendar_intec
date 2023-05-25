package com.example.calendar.view.v2api;

import com.example.calendar.flow.services.V2API.*;
import com.example.calendar.model.dtos.v2api.*;

import java.util.List;

public class TaskController implements V2TaskAPI{
    private final TaskServiceV2 ts;

    public TaskController(TaskServiceV2 taskService){
        this.ts = taskService;
    }

    @Override
    public TaskPostResponse createTask(CreateTaskRequest req) {
        return ts.createNewTask(req);
    }

    @Override
    public TaskPostResponse updateTask(UpdateTaskRequest req) {
        return ts.updateTask(req);
    }

    @Override
    public TaskPostResponse deleteTask(DeleteTaskRequest req) {
        return ts.deleteTask(req);
    }

    @Override
    public TaskGetResponse getTask(GetTaskRequest req) {
        return ts.getTask(req);
    }

    @Override
    public List<TaskGetResponse> getAllTasks() {
        return ts.getAllTasks();
    }

    @Override
    public List<TaskGetResponse> getAllTasksInRange(GetTasksInRangeRequest req) {
        return ts.getAllTasksInRange(req);
    }
}
