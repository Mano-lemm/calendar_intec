package com.example.calendar.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
public class User {
    @Id
    private Long id;
    private String name;
    private String pwdHash;
    private String pepper;
}
