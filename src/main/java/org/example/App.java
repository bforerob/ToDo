package org.example;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Basic loop for the menu
 *
 */
public class App 
{
    static Scanner scan = new Scanner(System.in);
    public static void main( String[] args )
    {
        int option;
        boolean logged = false;
        int currentTaskId = 0;
        String username = "Brandon";
        String password = "Forero";

        User user = new User(0, username, password);

        do {

            System.out.println("Welcome");
            System.out.println("Please select an option");
            System.out.println("1. Add task");
            System.out.println("2. Remove task");
            System.out.println("3. Display all tasks");
            System.out.println("4. Display completed tasks");
            System.out.println("5. Display uncompleted tasks");
            System.out.println("6. Update tasks");
            System.out.println("7. Exit");
            option = scan.nextInt();

            switch (option) {
                case 1:
                    System.out.println("1. Add task");
                    System.out.println("Task name:");
                    scan.nextLine();
                    String taskName = scan.nextLine();
                    System.out.println("Task description:");
                    String taskDescription = scan.nextLine();
                    System.out.println("Task priority:");
                    int taskPriority = scan.nextInt();
                    System.out.println("Task date:");
                    Date taskDate = new Date(2025, 05, 10);
                    Task newTask = new Task(currentTaskId,taskName, taskDescription, taskPriority, false, taskDate);
                    user.addTask(newTask);
                    break;

                case 2:
                    System.out.println("2. Remove task");
                    List<Task> allTasks = getAllTasks(user);
                    System.out.println("Enter the number of the task you would like to remove: ");
                    int taskToDelete = scan.nextInt();
                    user.removeTask(allTasks.get(taskToDelete));

                    break;
                case 3:
                    System.out.println("3. Display all tasks");
                    getAllTasks(user);
                    break;
                case 4:
                    System.out.println("4. Display completed tasks");
                    List<Task> completedTasks = user.getCompletedTasks();
                    for (Task task : completedTasks) {
                        System.out.println(completedTasks.indexOf(task) + ". ");
                        printTask(task, false);
                    }
                    break;
                case 5:
                    System.out.println("5. Display uncompleted tasks");
                    List<Task> uncompletedTasks = user.getUncompletedTasks();
                    for (Task task : uncompletedTasks) {
                        System.out.println(uncompletedTasks.indexOf(task) + ". ");
                        printTask(task, false);
                    }
                    break;

                case 6:
                    int updateOption;
                    System.out.println("6. Update task");
                    List<Task> tasks = getAllTasks(user);
                    System.out.println("Enter the number of the task you would like to remove: ");
                    Task taskToUpdate = tasks.get(scan.nextInt());
                    System.out.println("1. Set task as completed");
                    System.out.println("2. Set task as uncompleted");
                    System.out.println("3. update task name");
                    System.out.println("4. Update task description");
                    System.out.println("5. Update task priority");
                    System.out.println("6. Update task date");
                    updateOption = scan.nextInt();
                    switch (updateOption){
                        case 1:
                            taskToUpdate.setCompleted(true);
                            break;

                        case 2:
                            taskToUpdate.setCompleted(false);
                            break;
                        case 3:
                            System.out.println("New task name: ");
                            scan.nextLine();
                            String newTaskName = scan.nextLine();
                            taskToUpdate.setName(newTaskName);
                            break;
                        case 4:
                            System.out.println("New task description: ");
                            scan.nextLine();
                            String newTaskDescription = scan.nextLine();
                            taskToUpdate.setDescription(newTaskDescription);
                            break;
                        case 5:
                            System.out.println("New task priority: ");
                            int newTaskPriority = scan.nextInt();
                            taskToUpdate.setPriority(newTaskPriority);
                            break;
                        case 6:
                            System.out.println("Updating Date...");
                            break;
                    }

                    break;

                case 7:
                    System.out.println("6. Exit");
                    break;



            }

        } while(option > 0 && option < 8);
    }

    public static List<Task> getAllTasks(User user) {
        List<Task> allTasks = user.getAllTasks();
        for (Task task : allTasks) {
            System.out.println(allTasks.indexOf(task) + ". ");
            printTask(task, true);
        }
        return allTasks;
    }

    public static void printTask(Task task, boolean printCompleted) {
        System.out.println("    name: " + task.getName());
        System.out.println("    description: " + task.getDescription());
        System.out.println("    priority: " + task.getPriority());
        if (printCompleted) {
            System.out.println("    completed: " + task.isCompleted());

        }
        System.out.println("    Date: "+ task.getDate());
    }
}
