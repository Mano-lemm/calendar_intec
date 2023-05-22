package com.example.calendar.model.repositories;

import com.example.calendar.model.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    public List<Task> findAllByDate(Date date);

    public List<Task> findAllByDateBetween(Date start, Date end);
}
