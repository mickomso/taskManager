package com.company.taskManager;

import com.company.taskManager.model.Task;
import com.company.taskManager.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class TaskManagerApplicationTests {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void findAllTasks() {
        System.out.println("Initializing TaskManagerApplicationTests.findAllTasks TEST...");
        List<Task> tasks = taskRepository.findAll();
        assertNotNull(tasks);
        assertFalse(tasks.isEmpty());
        System.out.println("TEST TaskManagerApplicationTests.findAllTasks finished OK!");
    }

    @Test
    public void findTaskById() {
        System.out.println("Initializing TaskManagerApplicationTests.findTaskById TEST...");
        Optional<Task> user = taskRepository.findById(1);
        assertNotNull(user.get());
        System.out.println("TEST TaskManagerApplicationTests.findAllTasks finished OK!");
    }

    @Test
    public void createTask() {
        System.out.println("Initializing TaskManagerApplicationTests.createTask TEST...");
        Task task = new Task("Test Title Task", "Test Description Task", new Date(System.currentTimeMillis()),false);
        Task savedTask = taskRepository.save(task);
        Task newTask = taskRepository.findById(savedTask.getId()).get();
        assertEquals("Test Title Task", newTask.getTitle());
        assertEquals("Test Description Task", newTask.getDescription());
        System.out.println("TEST TaskManagerApplicationTests.findAllTasks finished OK!");
    }
}
