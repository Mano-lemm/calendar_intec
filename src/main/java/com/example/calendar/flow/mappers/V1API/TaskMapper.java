package com.example.calendar.flow.mappers.V1API;

import com.example.calendar.model.dtos.v1api.*;
import com.example.calendar.model.entities.Task;
import lombok.experimental.UtilityClass;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;

@UtilityClass
public class TaskMapper {
    public static Task toEntity(CreateTaskRequest req){
        Task task = new Task();
        task.setTimeStamp(Timestamp.from(req.getDateTime().toInstant()));
        task.setTimezone(req.getDateTime().getOffset());
        task.setDescription(req.getDescription());
        task.setTitle(req.getTitle());
        return task;
    }

    public static Task toEntity(UpdateTaskRequest req){
        Task task = new Task();
        task.setTimeStamp(Timestamp.from(req.getDateTime().toInstant()));
        task.setTimezone(req.getDateTime().getOffset());
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
            ZonedDateTime.ofInstant(task.getTimeStamp().toInstant(), task.getTimezone()));
    }

    public static ReadAllTasksResponse toReadAllResponse(List<ReadTaskResponse> tasks){
        return new ReadAllTasksResponse(Collections.unmodifiableList(tasks));
    }
}
