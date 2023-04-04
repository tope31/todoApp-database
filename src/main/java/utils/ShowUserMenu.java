package utils;

import model.UserTasks;
import model.Users;
import taskEnums.Status;

import java.sql.SQLException;
import java.util.Scanner;

public class ShowUserMenu {
    public static void mainMenu(Users users) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        UserTasks userTasks = new UserTasks();

        int choice = 0;

        System.out.println("Hi " + users.getUsername());
        System.out.println("Manage your Tasks");

        while (choice <= 5) {
            System.out.println("1 to print all tasks\n2 to add new task\n3 to mark task as DONE\n4 to change due date of task\n5 to quit");
            choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (choice) {
                case 1:
                    TaskUtils.printTasks(users.getUserId());
                    System.out.println();
                    break;
                case 2:
                    userTasks.setUserId(users.getUserId());
                    userTasks.setTask("ginhawa");
                    userTasks.setStatus(Status.OPEN.toString());
                    userTasks.setDueDate("2024-04-10");
                    TaskUtils.addTask(userTasks);
                    System.out.println();
                    break;
                case 3:
                    userTasks.setTask("read effective java");
                    TaskUtils.markTaskAsDone(userTasks);
                    System.out.println();
                    break;
                case 4:
                    userTasks.setTask("read effective java");
                    userTasks.setDueDate("2024-05-01");
                    TaskUtils.changeDueDate(userTasks);
                    break;
                case 5:
                    System.out.println("System exit");
                    System.exit(0);
            }
        }
    }
}
