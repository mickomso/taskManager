package com.company.taskManager.service.api;

import com.company.taskManager.domain.Task;

import java.util.List;
import java.util.Optional;

public interface ITaskService {

    public Iterable<Task> findAll();
    public Optional<Task> findTaskById(Integer id);
    public Task createNewTask(Task task);
    public void deleteTaskById(Integer id);
    public void markAsCompleted(Task task);
}
