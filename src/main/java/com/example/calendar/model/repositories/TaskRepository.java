package com.example.calendar.model.repositories;

import com.example.calendar.model.entities.Task;
import com.example.calendar.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("select id, timeStamp, timezone, Description, Title, Owner from Task where Owner.id = ?1")
    List<Task> findAllByOwnerId(Long id);
}
