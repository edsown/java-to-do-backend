package com.example.demo.task;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public void addNewTask(Task task)  {
        taskRepository.save(task);
    }

    public Optional<Task> getTaskById(Integer taskId) {
       return taskRepository.findById(taskId);
    }

    public void deleteTaskById(Integer taskId) {
        if(taskRepository.existsById(taskId)) {
            taskRepository.deleteById(taskId);
        }
        else throw new IllegalStateException("Id does not exist");
    }

    @Transactional
    public void updateTaskById(Integer id, String task, boolean is_completed){
        Task taskToUpdate = taskRepository.findById(id).orElseThrow(() -> new IllegalStateException("id not found"));
        System.out.println(taskToUpdate);
        System.out.println("____________________________");
        System.out.println(task);
        System.out.println(is_completed);


        if (task != null && !task.isEmpty()) {

            taskToUpdate.setTask(task);
        }
        taskToUpdate.setIs_completed(is_completed);
        System.out.print(taskToUpdate);

    }

}
