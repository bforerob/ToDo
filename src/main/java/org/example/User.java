package org.example;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int id;
    private String username;
    private String password;
    private TaskManager taskManager;

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.taskManager = new TaskManager();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Task addTask(Task task) {
        return taskManager.addTask(task);
    }

    public Task removeTask(Task task) {
        return taskManager.removeTask(task);
    }

    public List<Task> getAllTasks() {
        return taskManager.getAllTasks();
    }

    public List<Task> getCompletedTasks() {
        return taskManager.getCompletedTasks();
    }

    public List<Task> getUncompletedTasks() {
        return taskManager.getUncompletedTasks();
    }

    public boolean authenticate(String username, String password) {
        return true;

    }

}
