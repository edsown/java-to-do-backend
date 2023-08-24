package com.example.demo.task;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="api/v1/task")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping("/{taskId}")
    public Optional<Task> getTaskById(@PathVariable Integer taskId) {
        return taskService.getTaskById(taskId);
    }

    @PostMapping
    public void addNewTask(@RequestBody Task task)  {
        taskService.addNewTask(task);
    }

    @DeleteMapping(path = "/{taskId}")
    public void deleteTaskById(@PathVariable("taskId") Integer taskId) {
         taskService.deleteTaskById(taskId);
    }

    @PutMapping(path = "/{taskId}")
    public void updateTaskById(@PathVariable("taskId") Integer taskId,
                               @RequestParam(name= "task", required = false) String task,
                               @RequestParam(name= "is_completed", required = false) boolean is_completed)  {
        taskService.updateTaskById(taskId, task, is_completed);
    }
}
