package com.example.calendar.flow.services;

import com.example.calendar.flow.exceptions.TaskDoesNotExistException;
import com.example.calendar.flow.mappers.TaskMapper;
import com.example.calendar.model.dtos.v1api.*;
import com.example.calendar.model.entities.Task;
import com.example.calendar.model.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private final TaskRepository repo;

    public TaskService(TaskRepository repo){
        this.repo = repo;
    }

    public TaskResponse createNewTask(CreateTaskRequest req){
        Task task = TaskMapper.toEntity(req);
        task = repo.save(task);
        return TaskMapper.toResponse(task);
    }

    public TaskResponse updateTask(UpdateTaskRequest req) throws TaskDoesNotExistException {
        Task task = TaskMapper.toEntity(req);
        if(repo.findById(task.getId()).isEmpty()){
            throw new TaskDoesNotExistException();
        }
        task = repo.save(task);
        return TaskMapper.toResponse(task);
    }

    public TaskResponse deleteTask(DeleteTaskRequest req) throws TaskDoesNotExistException{
        Task task = TaskMapper.toEntity(req);
        if(repo.findById(task.getId()).isEmpty()){
            throw new TaskDoesNotExistException("this task does not exist");
        }
        repo.deleteById(task.getId());
        return TaskMapper.toResponse(task);
    }

    public ReadAllTasksResponse readAllTasksOnDay(ReadAllTasksOnDayRequest req) {
        return TaskMapper.toReadAllResponse(
                repo.findAll().stream()
                        .filter(task -> task.getTimeStamp().toLocalDateTime().toLocalDate().equals(req.getDate().toLocalDate()))
                        .map(TaskMapper::toReadResponse)
                        .collect(Collectors.toList()));
    }

    public ReadAllTasksResponse readAllTasksInRange(ReadAllTasksInRangeRequest req) {
        return TaskMapper.toReadAllResponse(
                repo.findAll().stream()
                        .filter(task ->
                                task.getTimeStamp().toLocalDateTime().isAfter(req.getStart().toLocalDateTime()) &&
                                task.getTimeStamp().toLocalDateTime().isBefore(req.getEnd().toLocalDateTime()))
                        .map(TaskMapper::toReadResponse)
                        .collect(Collectors.toList()));
    }

    public ReadAllTasksResponse readAllTasks() {
        return TaskMapper.toReadAllResponse(
                repo.findAll().stream()
                .map(TaskMapper::toReadResponse)
                .collect(Collectors.toList()));
    }
}
