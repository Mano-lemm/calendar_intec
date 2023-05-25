package com.example.calendar.view.v2api;

import com.example.calendar.flow.exceptions.UserDoesNotExistException;
import com.example.calendar.flow.services.V2API.*;
import com.example.calendar.model.dtos.v2api.*;
import com.example.calendar.model.entities.Task;
import com.example.calendar.model.entities.User;
import com.example.calendar.model.repositories.TaskRepository;
import com.example.calendar.model.repositories.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class TaskController implements V2TaskAPI{
    private final TaskService ts;

    public TaskController(TaskService taskService){
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
