package com.example.calendar.view;

import com.example.calendar.flow.exceptions.TaskDoesNotExistException;
import com.example.calendar.flow.services.TaskService;
import com.example.calendar.model.dtos.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
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

    @Operation(summary = "read all tasks that are planned on day specified in request")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success, all tasks on that day are in response body"),
            @ApiResponse(responseCode = "400", description = "Bad request, likely incorrect formatting of request body"),
            @ApiResponse(responseCode = "500", description = "Server error, likely database related")
    })
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

    @GetMapping("/read/all")
    @Override
    public ReadAllTasksResponse ReadAllTasks() {
        return taskService.readAllTasks();
    }
}
