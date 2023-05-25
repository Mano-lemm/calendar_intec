package com.example.calendar.flow.mappers.V2API;

import com.example.calendar.model.dtos.v2api.*;
import com.example.calendar.model.entities.Task;
import lombok.experimental.UtilityClass;

import java.sql.Timestamp;
import java.time.ZonedDateTime;

@UtilityClass
public class TaskMapper {
    public static Task toEntity(CreateTaskRequest req) {
        Task t = new Task();
        t.setDescription(req.getDescription());
        t.setTitle(req.getTitle());
        t.setTimeStamp(Timestamp.from(req.getDateTime().toInstant()));
        t.setTimezone(req.getDateTime().getOffset());
        return t;
    }

    public static TaskPostResponse toResponse(Task task) {
        return new TaskPostResponse(task.getId());
    }

    public static Task toEntity(UpdateTaskRequest req) {
        Task t = new Task();
        t.setDescription(req.getDescription());
        t.setTitle(req.getTitle());
        t.setTimeStamp(Timestamp.from(req.getDateTime().toInstant()));
        t.setTimezone(req.getDateTime().getOffset());
        return t;
    }

    public static Task toEntity(DeleteTaskRequest req) {
        Task t = new Task();
        t.setId(req.getId());
        return t;
    }

    public static TaskGetResponse toGetResponse(Task task) {
        TaskGetResponse tgr = new TaskGetResponse()
                .dateTime(ZonedDateTime.of(task.getTimeStamp().toLocalDateTime(), task.getTimezone()))
                .title(task.getTitle())
                .description(task.getDescription())
                .Owner(UserMapper.toGetResponse(task.getOwner()));
        return tgr;
    }
}
