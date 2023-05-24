package com.example.calendar.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.ZoneOffset;

@Data
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Timestamp timeStamp;
    private ZoneOffset timezone;
    private String Description;
    private String Title;
    @ManyToOne
    private User Owner;
}
