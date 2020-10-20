package com.company.taskManager.controller;

import com.company.taskManager.domain.Task;
import com.company.taskManager.service.api.TaskService;
import com.company.taskManager.service.impl.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

/**
 * Task Controller to handle REST calls.
 *
 * @author Miguel Company
 */
@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public Iterable<Task> listTasks() {
        return taskService.findAll();
    }

    @PostMapping(value = "/tasks", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Task> createTask(@Validated @RequestBody Task task) {
        Task savedTask = taskService.createNewTask(task);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(savedTask.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/tasks/{id}")
    public void deleteTask(@PathVariable(value = "id") Integer id) {
        Optional<Task> taskFound = taskService.findTaskById(id);
        taskService.deleteTaskById(taskFound.get().getId());

    }

    @PutMapping(value = "/tasks/markAsCompleted/{id}")
    public void markAsCompleted(@PathVariable(value = "id") Integer id) {
        Optional<Task> taskFound = taskService.findTaskById(id);
        if (taskFound.isPresent()) {
            taskService.markAsCompleted(taskFound.get());
        }
    }

    @PutMapping(value = "/tasks/{id}")
    public void updateTask(@PathVariable(value = "id") Integer id, @RequestBody Task task) {
        Optional<Task> taskFound = taskService.findTaskById(id);
        if (taskFound.isPresent()) {
            taskService.updateTask(task);
        }
    }
}
