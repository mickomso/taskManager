package com.company.taskManager.service.impl;

import com.company.taskManager.domain.Task;
import com.company.taskManager.repository.TaskRepository;
import com.company.taskManager.service.api.TaskService;
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
public class TaskServiceImpl implements TaskService {

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
        Task updatedTask = new Task();
        updatedTask.setId(task.getId());
        updatedTask.setTitle(task.getTitle());
        updatedTask.setDescription(task.getDescription());
        updatedTask.setCreated_on(task.getCreated_on());
        updatedTask.setUpdated_on(new Date(System.currentTimeMillis()));
        updatedTask.setCompleted(task.isCompleted());
        taskRepository.save(updatedTask);
    }
}
