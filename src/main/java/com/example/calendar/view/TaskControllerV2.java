package com.example.calendar.view;

import com.example.calendar.flow.exceptions.TaskDoesNotExistException;
import com.example.calendar.flow.exceptions.UserDoesNotExistException;
import com.example.calendar.flow.services.TaskServiceV2;
import com.example.calendar.model.dtos.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
        try {
            return ts.deleteTask(new DeleteTaskRequest(id));
        } catch (TaskDoesNotExistException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    String.format("Task with id(%d) does not exist", id),
                    e);
        }
    }

    @GetMapping("get")
    @Override
    public TaskGetResponse getTask(@RequestBody GetTaskRequest req) {
        try {
            return ts.getTask(req);
        } catch (TaskDoesNotExistException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    String.format("Task with id(%d) does not exist", req.id()),
                    e);
        }
    }

    @GetMapping("get/all")
    @Override
    public List<TaskGetResponse> getAllTasks() {
        // no err handling, can only fail if db fails
        // in that case its joever anyway
        return ts.getAllTasks();
    }

    @GetMapping("getAll")
    @Override
    public List<TaskGetResponse> getAllTasksByUserId(@RequestParam(name = "userId") Long userId) {
        try {
            return ts.getAllTasksByUserId(userId);
        } catch (UserDoesNotExistException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    String.format("User with id(%d) does not exist", userId),
                    e);
        }
    }

    @GetMapping("get/range")
    @Override
    public List<TaskGetResponse> getAllTasksInRange(@RequestParam(name = "end") ZonedDateTime end, @RequestParam(name = "start") ZonedDateTime start) {
        // cannot fail, returns empty list if range is reverse
        // no err handling, can only fail if db fails
        // in that case its joever anyway
        return ts.getAllTasksInRange(new GetTasksInRangeRequest(start, end));
    }
}
