package com.company.taskManager.controller;

/*
@RunWith(SpringRunner.class)
@WebMvcTest(TaskController.class)

 */
public class TaskControllerTest {
/*
    @Autowired
    private TaskService taskService;

    @Test
    public void findAllTasks() {
        System.out.println("Initializing TaskManagerApplicationTests.findAllTasks TEST...");
        List<Task> tasks = taskService.findAll();
        assertNotNull(tasks);
        assertFalse(tasks.isEmpty());
        System.out.println("TEST TaskManagerApplicationTests.findAllTasks finished OK!");
    }

    @Test
    public void findTaskById() {
        System.out.println("Initializing TaskManagerApplicationTests.findTaskById TEST...");
        Optional<Task> user = taskService.findTaskById(1);
        assertNotNull(user.get());
        System.out.println("TEST TaskManagerApplicationTests.findAllTasks finished OK!");
    }

    @Test
    public void createTask() {
        System.out.println("Initializing TaskManagerApplicationTests.createTask TEST...");
        Task task = new Task("Test Title Task", "Test Description Task", new Date(System.currentTimeMillis()),false);
        Task savedTask = taskService.saveOrUpdateTask(task);
        Task newTask = taskService.findTaskById(savedTask.getId()).get();
        assertEquals("Test Title Task", newTask.getTitle());
        assertEquals("Test Description Task", newTask.getDescription());
        System.out.println("TEST TaskManagerApplicationTests.findAllTasks finished OK!");
    }
    */
}
