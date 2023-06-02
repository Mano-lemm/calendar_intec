package com.example.calendar.flow.services;

import com.example.calendar.flow.exceptions.TaskDoesNotExistException;
import com.example.calendar.flow.exceptions.UnqualifiedTaskUpdateException;
import com.example.calendar.flow.exceptions.UserDoesNotExistException;
import com.example.calendar.flow.mappers.TaskMapperV2;
import com.example.calendar.model.dtos.*;
import com.example.calendar.model.entities.Task;
import com.example.calendar.model.entities.User;
import com.example.calendar.model.repositories.TaskRepository;
import com.example.calendar.model.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceV2 {
    private final UserRepository ur;
    private final TaskRepository tr;

    public TaskServiceV2(TaskRepository taskRepository, UserRepository userRepository){
        this.tr = taskRepository;
        this.ur = userRepository;
    }

    public TaskPostResponse createNewTask(CreateTaskRequest req) {
        User user = ur.findById(req.getOwnerId()).orElseThrow(UserDoesNotExistException::new);
        Task task = TaskMapperV2.toEntity(req);
        task.setOwner(user);
        task = tr.save(task);
        return TaskMapperV2.toResponse(task);
    }

    public TaskPostResponse updateTask(UpdateTaskRequest req) {
        Task newTask = TaskMapperV2.toEntity(req);
        User user = ur.findById(req.getOwnerId()).orElseThrow(UserDoesNotExistException::new);
        Task task = tr.findById(req.getTaskId()).orElseThrow(TaskDoesNotExistException::new);
        if(!task.getOwner().equals(user)){
            throw new UnqualifiedTaskUpdateException();
        }
        task.setTimezone(newTask.getTimezone());
        task.setTitle(newTask.getTitle());
        task.setDescription(newTask.getDescription());
        task.setTimeStamp(newTask.getTimeStamp());
        task = tr.save(task);
        return TaskMapperV2.toResponse(task);
    }

    public TaskPostResponse deleteTask(DeleteTaskRequest req) {
        Task task = TaskMapperV2.toEntity(req);
        if(!tr.existsById(task.getId())){
            throw new TaskDoesNotExistException();
        }
        tr.delete(task);
        return TaskMapperV2.toResponse(task);
    }

    public TaskGetResponse getTask(GetTaskRequest req) {
        Task task = tr.findById(req.getId()).orElseThrow(TaskDoesNotExistException::new);
        return TaskMapperV2.toGetResponse(task);
    }

    public List<TaskGetResponse> getAllTasks() {
        return tr.findAll().stream()
                .map(TaskMapperV2::toGetResponse)
                .collect(Collectors.toList());
    }

    public List<TaskGetResponse> getAllTasksInRange(GetTasksInRangeRequest req) {
        return tr.findAll().stream()
                .filter(e -> e.getTimeStamp().toLocalDateTime().isAfter(req.getStart().toLocalDateTime()) &&
                        e.getTimeStamp().toLocalDateTime().isBefore(req.getEnd().toLocalDateTime()))
                .map(TaskMapperV2::toGetResponse)
                .collect(Collectors.toList());
    }

    public List<TaskGetResponse> getAllTasksByUserId(Long userId) {
        User user = ur.findById(userId).orElseThrow(UserDoesNotExistException::new);
        return tr.findAllByOwnerId(user.getId()).stream()
                        .map(TaskMapperV2::toGetResponse)
                        .collect(Collectors.toList());
    }
}
