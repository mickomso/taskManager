package com.company.taskManager.controller;

import com.company.taskManager.domain.Task;
import com.company.taskManager.service.api.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Task Controller to handle REST calls.
 *
 * @author Miguel Company
 */
@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("")
    public Iterable<Task> listTasks() {
        return taskService.findAll();
    }

    @PostMapping(value=(""), consumes = "application/json", produces = "application/json")
    public ResponseEntity<Task> createTask(@Validated @RequestBody Task task) {
        Task savedTask = taskService.createNewTask(task);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(savedTask.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTask(@PathVariable(value = "id") Integer id) {
        Optional<Task> taskFound = taskService.findTaskById(id);
        taskService.deleteTaskById(taskFound.get().getId());
    }

    @PutMapping(value = "/{id}")
    public void updateTask(@PathVariable(value = "id") Integer id, @RequestBody Task task) {
        Task taskFound = taskService.findTaskById(id).orElseThrow(() -> new NoSuchElementException("Element doesn't exist."));
        taskService.updateTask(id, task);
    }

    @PutMapping(value = "/completed/{id}")
    public void markAsCompleted(@PathVariable(value = "id") Integer id) {
        Optional<Task> taskFound = taskService.findTaskById(id);
        taskService.markAsCompleted(taskFound.get());
    }

}
