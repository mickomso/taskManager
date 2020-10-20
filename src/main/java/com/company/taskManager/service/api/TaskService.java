package com.company.taskManager.service.api;

import com.company.taskManager.domain.Task;

import java.util.Optional;

/**
 * Task Service interface.
 *
 * @author Miguel Company
 */
public interface TaskService {

    /**
     * Gets all the existing tasks.
     *
     * @return a collection of tasks
     */
    public Iterable<Task> findAll();

    /**
     * Gets a task by its id attribute.
     *
     * @param id
     * @return a task or null, if exists or not.
     */
    public Optional<Task> findTaskById(Integer id);

    /**
     * Creates a new task and persists it.
     *
     * @param task
     * @return a task if it was created and saved correctly.
     */
    public Task createNewTask(Task task);

    /**
     * Removes a persisted task.
     *
     * @param id
     */
    public void deleteTaskById(Integer id);

    /**
     * Marks a task as completed (finished).
     * @param task
     */
    public void markAsCompleted(Task task);

    /**
     * Updates a persisted task.
     * @param task
     */
    public void updateTask(Task task);
}
