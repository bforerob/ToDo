package org.example;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public Task addTask(Task task) {
        this.tasks.add(task);
        return task;
    }

    public Task removeTask(Task task) {
        this.tasks.remove(task);
        return task;
    }

    public List<Task> getAllTasks() {
        return this.tasks;
    }

    public List<Task> getCompletedTasks() {
        List<Task> completedTasks = new ArrayList<>();
        for (Task task : this.tasks) {
            if (task.isCompleted()) {
                completedTasks.add(task);
            }
        }
        return completedTasks;
    }

    public List<Task> getUncompletedTasks() {
        List<Task> uncompletedTasks = new ArrayList<>();
        for (Task task : this.tasks) {
            if (!task.isCompleted()) {
                uncompletedTasks.add(task);
            }
        }
        return uncompletedTasks;
    }
}
