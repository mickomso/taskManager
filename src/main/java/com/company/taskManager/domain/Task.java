package com.company.taskManager.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TASK")
@NoArgsConstructor
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    private String title;

    @NonNull
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @NonNull
    private Date created_on;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_on;

    @NonNull
    private boolean completed;

    public Task(@NonNull String title, @NonNull String description, @NonNull Date created_on, @NonNull boolean completed) {
        this.title = title;
        this.description = description;
        this.created_on = created_on;
        this.completed = completed;
    }
}