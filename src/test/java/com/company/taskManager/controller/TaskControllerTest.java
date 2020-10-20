package com.company.taskManager.controller;

import com.company.taskManager.domain.Task;
import com.company.taskManager.repository.TaskRepository;
import com.company.taskManager.service.api.TaskService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
class TaskControllerTest {

    Logger log = LoggerFactory.getLogger(TaskControllerTest.class);

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskService taskService;

    @MockBean
    private TaskRepository taskRepository;

    @Test
    void whenFindingItemsItShouldReturnAllItems() throws Exception {
        log.info("TEST TaskControllerTest.whenFindingItemsItShouldReturnAllItems()");
        // given
        Task task = new Task();
        task.setId(1);
        task.setTitle("Task 1");
        task.setDescription("Description 1");
        List<Task> tasks = Arrays.asList(task);
        given(this.taskService.findAll()).willReturn(tasks);

        // when + then
        this.mockMvc.perform(get("/api/v1/tasks"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'id': 1,'title': 'Task 1';'description': 'Description 1'}]"));
    }

    @Test
    void whenAddingItemItShouldReturnTheSavedItem() throws Exception {
        log.info("TEST TaskControllerTest.whenAddingItemItShouldReturnTheSavedItem()");
        //given
        Task task = new Task();
        task.setTitle("Task 1");
        task.setDescription("Description 1");
        given(this.taskService.createNewTask(task)).willReturn(task);

        //when + then
        String json = asJsonString(task);
        this.mockMvc.perform(post("/api/v1/tasks")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isCreated());
    }

    private String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}