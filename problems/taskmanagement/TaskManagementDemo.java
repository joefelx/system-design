package taskmanagement;

import java.util.List;
import java.util.Scanner;

public class TaskManagementDemo {
    private static final UserManager userManager = UserManager.getInstance();
    private static final TaskManager taskManager = TaskManager.getInstance();
    private static final Scanner sc = new Scanner(System.in);

    public static void execute() {
        while (true) {
            System.out.println("\n--- Task Management ---");
            System.out.println("1. Create User");
            System.out.println("2. Create Task");
            System.out.println("3. Assign Task");
            System.out.println("4. Update Task");
            System.out.println("5. Delete Task");
            System.out.println("6. View Task");
            System.out.println("7. View User");
            System.out.println("8. View All User");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");

            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1: {
                    System.out.println("[TaskManager] Option: Create User");
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    userManager.createUser(name);
                    break;
                }
                case 2: {
                    System.out.println("[TaskManager] Option: Create Task");
                    System.out.print("Enter user ID: ");
                    int createUserId = sc.nextInt();
                    sc.nextLine();
                    User user = userManager.getUser(createUserId);
                    System.out.print("Enter task title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter description: ");
                    String description = sc.nextLine();
                    System.out.print("Enter due date (YYYY-MM-DD): ");
                    String dueDate = sc.nextLine();
                    System.out.print("Enter priority (LOW, MEDIUM, HIGH): ");
                    Priority priority = Priority.valueOf(sc.nextLine().toUpperCase());
                    taskManager.create(title, description, dueDate, priority, user);
                    System.out.println("Task created.");
                    break;
                }
                case 3: {
                    System.out.println("[TaskManager] Option: Assign Task");
                    System.out.print("Enter user ID to assign to: ");
                    int assignUserId = sc.nextInt();
                    System.out.print("Enter task ID: ");
                    int assignTaskId = sc.nextInt();
                    if (taskManager.assign(userManager.getUser(assignUserId), assignTaskId)) {
                        System.out.println("Task assigned.");
                    } else {
                        System.out.println("Assignment failed (check IDs).");
                    }
                    break;
                }
                case 4: {
                    System.out.println("[TaskManager] Option: Update Task");
                    System.out.print("Enter user ID: ");
                    int updateUserId = sc.nextInt();
                    System.out.print("Enter task ID: ");
                    int updateTaskId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new title: ");
                    String newTitle = sc.nextLine();
                    System.out.print("Enter new description: ");
                    String newDesc = sc.nextLine();
                    System.out.print("Enter new due date: ");
                    String newDue = sc.nextLine();
                    System.out.print("Enter new priority (LOW, MEDIUM, HIGH): ");
                    Priority newPriority = Priority.valueOf(sc.nextLine().toUpperCase());
                    System.out.print("Enter new status (TODO, IN_PROGRESS, DONE): ");
                    Status newStatus = Status.valueOf(sc.nextLine().toUpperCase());

                    if (taskManager.update(updateUserId, updateTaskId, newTitle, newDesc, newDue, newPriority, newStatus)) {
                        System.out.println("Task updated.");
                    } else {
                        System.out.println("Update failed (check IDs).");
                    }
                    break;
                }
                case 5: {
                    System.out.println("[TaskManager] Option: Delete Task");
                    System.out.print("Enter user ID: ");
                    int deleteUserId = sc.nextInt();
                    System.out.print("Enter task ID: ");
                    int deleteTaskId = sc.nextInt();
                    if (taskManager.delete(deleteUserId, deleteTaskId)) {
                        System.out.println("Task deleted.");
                    } else {
                        System.out.println("Delete failed (check IDs).");
                    }
                    break;

                }
                case 6: {
                    System.out.println("[TaskManager] Option: View Tasks for User");
                    System.out.print("Enter user ID: ");
                    int viewUserId = sc.nextInt();
                    List<Task> tasks = taskManager.view(viewUserId);
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks found for user ID " + viewUserId);
                    } else {
                        for (Task t : tasks) {
                            System.out.println("Task ID: " + t.getId() + ", Title: " + t.getTitle());
                        }
                    }
                    break;
                }
                case 7: {
                    System.out.println("[TaskManager] Option: View User by id");
                    System.out.print("Enter user ID: ");
                    int userId = sc.nextInt();
                    User user = userManager.getUser(userId);
                    if (user == null) {
                        System.out.println("No user found!");
                    } else {
                        System.out.println("-------");
                        System.out.println("User id: " + user.getId());
                        System.out.println("User name: " + user.getName());
                        System.out.println("-------");
                    }
                    break;
                }

                case 8:
                    System.out.println("[TaskManager] Option: View All Users");
                    userManager.viewUsers();
                    break;

                case 9:
                    System.out.println("[TaskManager] Exiting...");
                    return;


                default:
                    System.out.println("[TaskManager] Invalid option. Try again.");
            }
        }
    }
}
