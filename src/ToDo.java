import java.util.Scanner;
import java.util.ArrayList;

public class ToDo {
    // Class to represent a task
    static class Task {
        String name;   // Name of the task
        boolean done;  // Whether the task is marked as done or not

        // Constructor to initialize the task with a name
        Task(String name) {
            this.name = name;
            this.done = false;  // By default, the task is not done
        }

        // Method to convert the task object into a string format for easy printing
        public String toString() {
            return name + (done ? " [✓]" : " [ ]");  // Displays [✓] if done, [ ] if not done
        }
    }

    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner sc = new Scanner(System.in);
        // Create an ArrayList to store the tasks
        ArrayList<Task> tasks = new ArrayList<>();

        // Infinite loop to keep showing the menu until the user chooses to exit
        while (true) {
            // Display the main menu options
            System.out.println("\n--- TO-DO LIST ---");
            System.out.println("1. View tasks");
            System.out.println("2. Add task");
            System.out.println("3. Mark task as done");
            System.out.println("4. Remove task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            // Take the user's choice as input
            int choice = sc.nextInt();
            sc.nextLine();  // Consume the newline left by nextInt() to avoid issues with nextLine()

            // Switch block to handle different menu options
            switch (choice) {
                case 1:
                    // Case 1: View all tasks
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks found");  // If no tasks are in the list, notify the user
                    } else {
                        // If there are tasks, loop through the list and print each one
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));  // Display task number and task details
                        }
                    }
                    break;

                case 2:
                    // Case 2: Add a new task
                    System.out.print("Enter task name: ");
                    String name = sc.nextLine();  // Get the task name from the user
                    tasks.add(new Task(name));  // Create a new Task object and add it to the tasks list
                    System.out.println("Task added!");
                    break;

                case 3:
                    // Case 3: Mark a task as done
                    System.out.print("Enter task number to mark as done: ");
                    int taskNumber = sc.nextInt() - 1;  // Get the task number from the user (adjusted for 0-based index)
                    if (taskNumber >= 0 && taskNumber < tasks.size()) {
                        tasks.get(taskNumber).done = true;  // Mark the selected task as done
                        System.out.println("Task marked as done: " + tasks.get(taskNumber));  // Display the task after marking it as done
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;

                case 4:
                    // Case 4: Remove a task
                    System.out.print("Enter task number to remove: ");
                    int taskRemove = sc.nextInt() - 1;  // Get the task number from the user (adjusted for 0-based index)
                    if (taskRemove >= 0 && taskRemove < tasks.size()) {
                        tasks.remove(taskRemove);  // Remove the task at the specified index
                        System.out.println("Task removed!");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;

                case 5:
                    // Case 5: Exit the program
                    sc.close();
                    System.out.println("Goodbye!");
                    return;  // Exit the program by returning from the main method

                default:
                    // If the user enters an invalid option
                    System.out.println("Invalid option");
            }
        }
    }
}
