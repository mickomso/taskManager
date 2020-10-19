package com.company.taskManager.service.impl;

import com.company.taskManager.domain.Task;
import com.company.taskManager.repository.TaskRepository;
import com.company.taskManager.service.api.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

/**
 * Task Service implementation.
 *
 * @author Miguel Company
 */
@Service
public class TaskService implements ITaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Iterable<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> findTaskById(Integer id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task createNewTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteTaskById(Integer id) {
        taskRepository.deleteById(id);
    }

    @Override
    public void markAsCompleted(Task task) {
        task.setCompleted(true);
        task.setUpdated_on(new Date(System.currentTimeMillis()));
        taskRepository.save(task);
    }

    @Override
    public void updateTask(Task task) {

    }
}
