package com.example.demo.task;
import jakarta.persistence.*;


@Entity
@Table
public class Task {
    @Id
    @SequenceGenerator(name = "task_sequence",
                    sequenceName="task_sequence",
                    allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "task_sequence")
    private int id;
    private String task;
    private boolean is_completed;

    public Task() {
    }

    public Task(Integer id, String task, boolean is_completed) {

        this.id = id;
        this.task = task;
        this.is_completed = is_completed;
    }

    public Task(String task, boolean is_completed) {
        this.task = task;
        this.is_completed = is_completed;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isIs_completed() {
        return is_completed;
    }

    public void setIs_completed(boolean is_completed) {
        this.is_completed = is_completed;
    }


    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", task='" + task + '\'' +
                ", is_completed=" + is_completed +
                '}';
    }
}
