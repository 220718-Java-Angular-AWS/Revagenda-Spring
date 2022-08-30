package com.revature.revagenda.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity(name = "tasks")
public class Task {
    @Id
    @Column(name = "task_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer taskId;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private Boolean completed;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private User user;
}
