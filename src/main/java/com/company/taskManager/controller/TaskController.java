package com.company.taskManager.controller;

import com.company.taskManager.domain.Task;
import com.company.taskManager.service.impl.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public Iterable<Task> listTasks() {
        return taskService.findAll();
    }

    @PostMapping(value = "/tasks", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task savedTask = taskService.createNewTask(task);
        if (savedTask == null) {
            return ResponseEntity.status(500).build();
        }
        return ResponseEntity.ok(savedTask);
    }

    @DeleteMapping(value = "/tasks/{id}")
    public void deleteTask(@PathVariable(value = "id") Integer id) {
        Optional<Task> taskFound = taskService.findTaskById(id);
        if (taskFound != null) {
            taskService.deleteTaskById(taskFound.get().getId());
        }
    }

    @PutMapping(value = "/tasks/update/{id}",
            consumes = "application/json",
            produces = "application/json")
    public void markAsFinished(@PathVariable(value = "id") Integer id) {
        Optional<Task> taskFound = taskService.findTaskById(id);
        if (taskFound != null) {
            taskService.markAsCompleted(taskFound.get());
        }
    }
}
