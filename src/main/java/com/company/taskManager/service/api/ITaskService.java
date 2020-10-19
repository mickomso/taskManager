package com.company.taskManager.service.api;

import com.company.taskManager.domain.Task;

import java.util.Optional;

/**
 * Task services interface.
 *
 * @author Miguel Company
 */
public interface ITaskService {

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
     * Creates a new task and saves it in the database.
     *
     * @param task
     * @return a task if it was created and saved correctly.
     */
    public Task createNewTask(Task task);

    /**
     * Removes a task from the database.
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
     * Updates a task information.
     * @param task
     */
    public void updateTask(Task task);
}
