package com.example.calendar.flow.mappers.V2API;

import com.example.calendar.model.dtos.v2api.*;
import com.example.calendar.model.entities.Task;
import lombok.experimental.UtilityClass;

import java.sql.Timestamp;
import java.time.ZonedDateTime;

@UtilityClass
public class TaskMapperV2 {
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
        TaskGetResponse tgr = new TaskGetResponse();
        tgr.setDateTime(ZonedDateTime.of(task.getTimeStamp().toLocalDateTime(), task.getTimezone()));
        tgr.setTitle(task.getTitle());
        tgr.setDescription(task.getDescription());
        tgr.setOwner(UserMapperV2.toGetResponse(task.getOwner()));
        tgr.setId(task.getId());
        return tgr;
    }
}
