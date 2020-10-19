package com.company.taskManager.domain;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * Pojo object for the Task entity.
 *
 * @author Miguel Company
 */
@Entity
@Table(name = "TASK")
@DynamicUpdate
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
    @Column(name = "created_on", insertable = false)
    private Date created_on;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_on", insertable = false)
    private Date updated_on;

    @Column(name = "completed", insertable = false)
    private boolean completed;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.created_on = new Date(System.currentTimeMillis());
        this.completed = false;
    }
}
