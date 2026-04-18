import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String name;
    boolean isCompleted;

    Task(String name) {
        this.name = name;
        this.isCompleted = false;
    }
}

public class Main {
    static ArrayList<Task> tasks = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n====== StudyMate Planner ======");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    markCompleted();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    static void addTask() {
        System.out.print("Enter task: ");
        String name = sc.nextLine();
        tasks.add(new Task(name));
        System.out.println("✅ Task added successfully!");
    }

    static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("\nYour Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            Task t = tasks.get(i);
            String status = t.isCompleted ? "✔ Completed" : "⏳ Pending";
            System.out.println((i + 1) + ". " + t.name + " - " + status);
        }
    }

    static void markCompleted() {
        viewTasks();
        if (tasks.isEmpty()) return;

        System.out.print("Enter task number to mark complete: ");
        int index = sc.nextInt();

        if (index > 0 && index <= tasks.size()) {
            tasks.get(index - 1).isCompleted = true;
            System.out.println("✅ Task marked as completed!");
        } else {
            System.out.println("Invalid task number!");
        }
    }

    static void deleteTask() {
        viewTasks();
        if (tasks.isEmpty()) return;

        System.out.print("Enter task number to delete: ");
        int index = sc.nextInt();

        if (index > 0 && index <= tasks.size()) {
            tasks.remove(index - 1);
            System.out.println("❌ Task deleted successfully!");
        } else {
            System.out.println("Invalid task number!");
        }
    }
}