package com.example.calendar.flow.mappers;

import com.example.calendar.model.dtos.v1api.*;
import com.example.calendar.model.entities.Task;
import lombok.experimental.UtilityClass;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@UtilityClass
public class TaskMapper {
    public static Task toEntity(CreateTaskRequest req){
        Task task = new Task();
        task.setTime(Time.valueOf(req.getDateTime().toLocalTime()));
        task.setDate(Date.valueOf(req.getDateTime().toLocalDate()));
        task.setDescription(req.getDescription());
        task.setTitle(req.getTitle());
        return task;
    }

    public static Task toEntity(UpdateTaskRequest req){
        Task task = new Task();
        task.setTime(Time.valueOf(req.getDateTime().toLocalTime()));
        task.setDate(Date.valueOf(req.getDateTime().toLocalDate()));
        task.setDescription(req.getDescription());
        task.setTitle(req.getTitle());
        task.setId(req.getId());
        return task;
    }

    public static Task toEntity(DeleteTaskRequest req){
        Task task = new Task();
        task.setId(req.getId());
        return task;
    }

    public static TaskResponse toResponse(Task task) {
        return new TaskResponse(task.getId());
    }

    public static ReadTaskResponse toReadResponse(Task task){
        return new ReadTaskResponse(
            task.getId(),
            task.getTitle(),
            task.getDescription(),
            LocalDateTime.of(
                    task.getDate().toLocalDate(),
                    task.getTime().toLocalTime()));
    }

    public static ReadAllTasksResponse toReadAllResponse(List<ReadTaskResponse> tasks){
        return new ReadAllTasksResponse(Collections.unmodifiableList(tasks));
    }
}
