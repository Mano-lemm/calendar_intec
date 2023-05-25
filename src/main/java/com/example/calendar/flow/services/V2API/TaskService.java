package com.example.calendar.flow.services.V2API;

import com.example.calendar.flow.exceptions.TaskDoesNotExistException;
import com.example.calendar.flow.exceptions.UserDoesNotExistException;
import com.example.calendar.flow.mappers.V2API.TaskMapper;
import com.example.calendar.model.dtos.v2api.*;
import com.example.calendar.model.entities.Task;
import com.example.calendar.model.entities.User;
import com.example.calendar.model.repositories.TaskRepository;
import com.example.calendar.model.repositories.UserRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private final UserRepository ur;
    private final TaskRepository tr;
    private final UserService us;

    public TaskService(UserService userService, TaskRepository taskRepository, UserRepository userRepository){
        this.tr = taskRepository;
        this.ur = userRepository;
        this.us = userService;
    }

    public TaskPostResponse createNewTask(CreateTaskRequest req) {
        User user = ur.findById(req.getOwnerId()).orElseThrow(UserDoesNotExistException::new);
        Task task = TaskMapper.toEntity(req);
        task.setOwner(user);
        task = tr.save(task);
        return TaskMapper.toResponse(task);
    }

    public TaskPostResponse updateTask(UpdateTaskRequest req) {
        User user = ur.findById(req.getOwnerId()).orElseThrow(UserDoesNotExistException::new);
        Task task = TaskMapper.toEntity(req);
        task.setOwner(user);
        task = tr.save(task);
        return TaskMapper.toResponse(task);
    }

    public TaskPostResponse deleteTask(DeleteTaskRequest req) {
        Task task = TaskMapper.toEntity(req);
        if(!tr.existsById(task.getId())){
            throw new TaskDoesNotExistException();
        }
        tr.delete(task);
        return TaskMapper.toResponse(task);
    }

    public TaskGetResponse getTask(GetTaskRequest req) {
        Task task = tr.findById(req.getId()).orElseThrow(TaskDoesNotExistException::new);
        return TaskMapper.toGetResponse(task);
    }

    public List<TaskGetResponse> getAllTasks() {
        return tr.findAll().stream()
                .map(TaskMapper::toGetResponse)
                .collect(Collectors.toList());
    }

    public List<TaskGetResponse> getAllTasksInRange(GetTasksInRangeRequest req) {
        return tr.findAll().stream()
                .filter(e -> {
                    return e.getTimeStamp().toLocalDateTime().isAfter(req.getStart().toLocalDateTime()) &&
                            e.getTimeStamp().toLocalDateTime().isBefore(req.getEnd().toLocalDateTime());
                })
                .map(TaskMapper::toGetResponse)
                .collect(Collectors.toList());
    }
}
