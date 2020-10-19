package com.company.taskManager.repository;

import com.company.taskManager.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer> {

    @Query("update Task t set t.completed=true where t.id = :id")
    public void updateCompletedTaskState(Integer id);
}
