package com.example.calendar.view;

import com.example.calendar.flow.services.TaskServiceV2;
import com.example.calendar.model.dtos.*;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
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
    public TaskPostResponse createTask(@RequestBody CreateTaskRequest req) {
        return ts.createNewTask(req);
    }

    @PostMapping("update")
    @Override
    public TaskPostResponse updateTask(@RequestBody UpdateTaskRequest req) {
        return ts.updateTask(req);
    }

    @DeleteMapping("delete")
    @Override
    public TaskPostResponse deleteTask(@RequestParam(name = "id") Long id) {
        return ts.deleteTask(new DeleteTaskRequest(id));
    }

    @GetMapping("get")
    @Override
    public TaskGetResponse getTask(@RequestBody GetTaskRequest req) {
        return ts.getTask(req);
    }

    @GetMapping("get/all")
    @Override
    public List<TaskGetResponse> getAllTasks() {
        return ts.getAllTasks();
    }

    @GetMapping("getAll")
    @Override
    public List<TaskGetResponse> getAllTasksByUserId(@RequestParam(name = "userId") Long userId) {
        return ts.getAllTasksByUserId(userId);
    }

    @GetMapping("get/range")
    @Override
    public List<TaskGetResponse> getAllTasksInRange(@RequestParam(name = "end") ZonedDateTime end, @RequestParam(name = "start") ZonedDateTime start) {
        return ts.getAllTasksInRange(new GetTasksInRangeRequest(start, end));
    }
}
