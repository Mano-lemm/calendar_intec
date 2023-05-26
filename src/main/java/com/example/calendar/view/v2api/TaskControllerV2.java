package com.example.calendar.view.v2api;

import com.example.calendar.flow.services.V2API.*;
import com.example.calendar.model.dtos.v2api.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@RequestMapping("/api/v2/task")
public class TaskControllerV2 implements V2TaskAPI{
    private final TaskServiceV2 ts;

    public TaskControllerV2(TaskServiceV2 taskService){
        this.ts = taskService;
    }

    @PostMapping("create")
    @Override
    public TaskPostResponse createTask(CreateTaskRequest req) {
        return ts.createNewTask(req);
    }

    @PostMapping("update")
    @Override
    public TaskPostResponse updateTask(UpdateTaskRequest req) {
        return ts.updateTask(req);
    }

    @DeleteMapping("delete")
    @Override
    public TaskPostResponse deleteTask(DeleteTaskRequest req) {
        return ts.deleteTask(req);
    }

    @GetMapping("get")
    @Override
    public TaskGetResponse getTask(GetTaskRequest req) {
        return ts.getTask(req);
    }

    @GetMapping("get/all")
    @Override
    public List<TaskGetResponse> getAllTasks() {
        return ts.getAllTasks();
    }

    @GetMapping("get/range")
    @Override
    public List<TaskGetResponse> getAllTasksInRange(GetTasksInRangeRequest req) {
        return ts.getAllTasksInRange(req);
    }
}
