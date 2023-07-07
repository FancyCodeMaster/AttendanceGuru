package com.arun.ag_backend.Entities;


import lombok.Data;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    private int roll;

    @ManyToOne
    @JoinColumn(name="class_id")
    private Class aClass;
}
