package com.example.calendar.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.sql.Date;

@Data
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private Time time;
    private String description;
    private String Title;
    @ManyToOne
    private User Owner;
}
