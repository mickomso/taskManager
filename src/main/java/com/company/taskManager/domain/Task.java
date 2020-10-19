package com.company.taskManager.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TASK")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    @Column(name = "title", nullable = false)
    private String title;

    @NonNull
    @Column(name = "description", nullable = false)
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @NonNull
    @Column(name = "created_on", nullable = false)
    private Date created_on;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_on", insertable = false)
    private Date updated_on;

    @NonNull
    @Column(name = "completed", nullable = false)
    private boolean completed;

    public Task(String title, String description, Date created_on, boolean completed) {
        this.title = title;
        this.description = description;
        this.created_on = created_on;
        this.completed = completed;
    }
}
