package com.company.taskManager.repository;

import com.company.taskManager.domain.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Task repository that adds functionality to the JPA CrudRepository interface if it is needed.
 *
 * @author Miguel Company
 */
@Repository
public interface TaskRepository extends CrudRepository<Task, Integer> {

}
