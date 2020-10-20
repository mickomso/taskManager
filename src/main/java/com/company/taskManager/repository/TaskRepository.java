package com.company.taskManager.repository;

import com.company.taskManager.domain.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Task repository that encapsulates the CRUD calls.
 *
 * @author Miguel Company
 */
@Repository
public interface TaskRepository extends CrudRepository<Task, Integer> {

}
