package com.example.userservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "User")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String userId;
    private String name;
    private String email;
    private String about;
//    this will not be stored in database
    @Transient
    private List<Rating> ratings;
}
