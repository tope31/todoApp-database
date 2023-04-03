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
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mma");
//        LocalTime localTime = LocalTime.now();
//        if (localTime.isBefore(localTime.minusHours(9))) {
//            System.out.println("Good afternoon");
//        } else if (localTime.isAfter(localTime.))
//        System.out.println(dtf.format(localTime));
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
                    userTasks.setTask("Code Java");
                    userTasks.setStatus(Status.OPEN.toString());
                    userTasks.setDueDate("2024-05-03");
                    TaskUtils.addTask(userTasks);
                    System.out.println();
                    break;
                case 3:
                    TaskUtils.markTaskAsDone("play jenshin");
                    System.out.println();
                    break;
                case 4:
                    TaskUtils.changeDueDate("play jenshin", "2024-05-01");
                    break;
                case 5:
                    System.out.println("System exit");
                    System.exit(0);
            }
        }
    }
}
