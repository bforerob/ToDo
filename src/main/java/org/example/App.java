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
                    System.out.println("Fill the next info to add a new task: ");
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
                    System.out.println("Task added");
                    pressEnterToContinue();
                    break;

                case 2:
                    System.out.println("Remove task: ");
                    List<Task> allTasks = getAllTasks(user);
                    System.out.println("Enter the number of the task you would like to remove: ");
                    int taskToDelete = scan.nextInt();
                    user.removeTask(allTasks.get(taskToDelete));
                    System.out.println("Task removed");
                    pressEnterToContinue();

                    break;
                case 3:
                    System.out.println("These are all the tasks: ");
                    if (getAllTasks(user).size() <= 0) {
                        System.out.println("No tasks found");
                    }
                    pressEnterToContinue();
                    break;
                case 4:

                    List<Task> completedTasks = user.getCompletedTasks();
                    if (completedTasks.size() > 0) {
                        System.out.println("These are the completed tasks: ");
                        for (Task task : completedTasks) {
                            System.out.println(completedTasks.indexOf(task) + ". ");
                            printTask(task, false);
                        }
                    }
                    else {
                        System.out.println("There are no completed tasks!");
                    }

                    pressEnterToContinue();
                    break;
                case 5:


                    List<Task> uncompletedTasks = user.getUncompletedTasks();
                    if (uncompletedTasks.size() > 0) {
                        System.out.println("These are the uncompleted tasks: ");
                        for (Task task : uncompletedTasks) {
                            System.out.println(uncompletedTasks.indexOf(task) + ". ");
                            printTask(task, false);
                        }
                    }
                    else {
                        System.out.println("There are no uncompleted tasks!");
                    }
                    pressEnterToContinue();
                    break;

                case 6:
                    int updateOption;
                    System.out.println("6. Update task");
                    List<Task> tasks = getAllTasks(user);
                    System.out.println("Enter the number of the task you would like to update: ");
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
                            System.out.println("task " + taskToUpdate.getName() + " is completed");
                            pressEnterToContinue();
                            break;

                        case 2:
                            taskToUpdate.setCompleted(false);
                            System.out.println("task " + taskToUpdate.getName() + " is not completed");
                            pressEnterToContinue();
                            break;
                        case 3:
                            System.out.println("New task name: ");
                            scan.nextLine();
                            String newTaskName = scan.nextLine();
                            taskToUpdate.setName(newTaskName);
                            System.out.println("task name updated successfully");
                            pressEnterToContinue();
                            break;
                        case 4:
                            System.out.println("New task description: ");
                            scan.nextLine();
                            String newTaskDescription = scan.nextLine();
                            taskToUpdate.setDescription(newTaskDescription);
                            System.out.println("task description updated successfully");
                            pressEnterToContinue();
                            break;
                        case 5:
                            System.out.println("New task priority: ");
                            int newTaskPriority = scan.nextInt();
                            taskToUpdate.setPriority(newTaskPriority);
                            System.out.println("task priority updated successfully");
                            pressEnterToContinue();
                            break;
                        case 6:
                            System.out.println("Updating date...");
                            System.out.println("task date updated successfully");
                            pressEnterToContinue();
                            break;

                        case 7:
                            System.out.println("Return to main menu...");
                            pressEnterToContinue();
                            break;
                        default:
                            System.out.println("Invalid option, try again");
                            break;
                    }

                    break;

                case 7:
                    System.out.println("Closing de application...");

                    break;

                default:
                    System.out.println("Invalid option, try again");
                    break;

            }

        } while(option > 0 && option < 8);
    }

    public static void pressEnterToContinue() {
        System.out.println("Press Enter to continue...");
        scan.nextLine();
        scan.nextLine();

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
