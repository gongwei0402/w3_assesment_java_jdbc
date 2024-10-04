package com.cogent;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        TaskDao taskDao = new TaskDaoImpl();

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("To-Do List Application");
            System.out.println("1. Add Task");
            System.out.println("2. Update Task");
            System.out.println("3. Delete Task");
            System.out.println("4. List Tasks");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

//            task.setDescription("Build Simple Java Project");
//            task.setCategory(Category.WORK);
//            task.setCompleted(false);

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter task category (PERSONAL, WORK, HOBBY, OTHER): ");
                    String categoryStr = scanner.nextLine();
                    Category category = Category.valueOf(categoryStr.toUpperCase());

                    Task task = new Task();
                    task.setDescription(description);
                    task.setCategory(category);
                    task.setCompleted(false);

                    taskDao.addTask(task);
                    System.out.println("Task added.");
                    break;
                case 2:
                    System.out.print("Enter task ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Task updateTask = new Task();
                    updateTask.setTaskId(updateId);
                    System.out.print("Enter new description: ");
                    updateTask.setDescription(scanner.nextLine());
                    System.out.print("Enter new category (PERSONAL, WORK, HOBBY, OTHER): ");
                    updateTask.setCategory(Category.valueOf(scanner.nextLine().toUpperCase()));
                    System.out.print("Is the task completed? (true/false): ");
                    updateTask.setCompleted(scanner.nextBoolean());

                    taskDao.updateTask(updateTask);
                    System.out.println("Task updated.");
                    break;
                case 3:
                    System.out.print("Enter task ID to delete: ");
                    int deleteId = scanner.nextInt();
                    taskDao.deleteTask(deleteId);
                    System.out.println("Task deleted.");
                    break;
                case 4:
                    System.out.println("Listing all tasks:");
                    taskDao.getAllTasks().forEach(System.out::println);
                    break;
                case 5:
                    scanner.close();
                    System.out.println("Exiting.");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }




    }
}
