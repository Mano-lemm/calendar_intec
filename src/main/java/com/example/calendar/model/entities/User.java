package com.example.calendar.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String name;
    private String pwdHashAndSalt;
}
