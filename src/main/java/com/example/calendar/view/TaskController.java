package com.example.calendar.view;

import com.example.calendar.flow.exceptions.TaskDoesNotExistException;
import com.example.calendar.flow.services.TaskService;
import com.example.calendar.model.dtos.*;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
@RequestMapping("/api/v1")
public class TaskController implements exposed_api{
    private final TaskService taskService;

    public TaskController(TaskService service){
        this.taskService = service;
    }

    @PostMapping("/create")
    @Override
    public TaskResponse createTask(@RequestBody CreateTaskRequest req) {
        return taskService.createNewTask(req);
    }

    @PostMapping("/update")
    @Override
    public TaskResponse updateTask(@RequestBody UpdateTaskRequest req) throws TaskDoesNotExistException {
        return taskService.updateTask(req);
    }

    @DeleteMapping("/delete")
    @Override
    public TaskResponse deleteTask(@RequestBody DeleteTaskRequest req) throws TaskDoesNotExistException{
        return taskService.deleteTask(req);
    }

    @GetMapping("/read/all/day")
    @Override
    public ReadAllTasksResponse readAllTasksOnDay(@RequestBody ReadAllTasksOnDayRequest req) {
        return taskService.readAllTasksOnDay(req);
    }

    @GetMapping("/read/all/range")
    @Override
    public ReadAllTasksResponse ReadAllTasksInRange(@RequestBody ReadAllTasksInRangeRequest req) {
        return taskService.readAllTasksInRange(req);
    }
}
