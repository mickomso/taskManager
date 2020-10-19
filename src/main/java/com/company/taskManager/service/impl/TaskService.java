package com.company.taskManager.service.impl;

import com.company.taskManager.domain.Task;
import com.company.taskManager.repository.TaskRepository;
import com.company.taskManager.service.api.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

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
    public void markAsCompleted(Integer id) {
        taskRepository.updateCompletedTaskState(id);
    }
}
