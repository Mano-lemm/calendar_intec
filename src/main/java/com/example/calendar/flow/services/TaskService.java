package com.example.calendar.flow.services;

import com.example.calendar.flow.exceptions.TaskDoesNotExistException;
import com.example.calendar.flow.mappers.TaskMapper;
import com.example.calendar.model.dtos.*;
import com.example.calendar.model.entities.Task;
import com.example.calendar.model.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
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
            throw new TaskDoesNotExistException();
        }
        repo.deleteById(task.getId());
        return TaskMapper.toResponse(task);
    }

    public ReadAllTasksResponse readAllTasksOnDay(ReadAllTasksOnDayRequest req) {
        Date date = Date.valueOf(req.getDate());
        return TaskMapper.toReadAllResponse(
                repo.findAllByDate(date).stream()
                        .map(TaskMapper::toReadResponse)
                        .collect(Collectors.toList()));
    }

    public ReadAllTasksResponse readAllTasksInRange(ReadAllTasksInRangeRequest req) {
        Date start = Date.valueOf(req.getStart());
        Date end = Date.valueOf(req.getEnd());
        return TaskMapper.toReadAllResponse(
                repo.findAllByDateBetween(start, end).stream()
                        .map(TaskMapper::toReadResponse)
                        .collect(Collectors.toList()));
    }
}
