package com.company.taskManager.controller;

import com.company.taskManager.domain.Task;
import com.company.taskManager.exceptions.ResourceNotFoundException;
import com.company.taskManager.service.impl.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public void deleteTask(@PathVariable Integer id) {
        Task taskFound = taskService.findTaskById(id).orElseThrow(() -> new ResourceNotFoundException("No task found with id = " + id));
        taskService.deleteTaskById(taskFound.getId());
    }

    // TODO Realizar SQL Update correctamente por @Query o por @NamedQuery
    @PutMapping(value = "/tasks/completed/{id}")
    public ResponseEntity<Integer> markAsCompleted(@PathVariable Integer id) {
        Task taskFound = taskService.findTaskById(id).orElseThrow(() -> new ResourceNotFoundException("No task found with id = " + id));
        if (taskFound.isCompleted()) {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        taskService.markAsCompleted(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
