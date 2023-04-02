package utils;

import java.sql.SQLException;
import java.util.Scanner;

public class ShowUserMenu {
    public static void mainMenu(Integer userId) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mma");
//        LocalTime localTime = LocalTime.now();
//        if (localTime.isBefore(localTime.minusHours(9))) {
//            System.out.println("Good afternoon");
//        } else if (localTime.isAfter(localTime.))
//        System.out.println(dtf.format(localTime));
        System.out.println("Manage your Tasks");

        while (choice <= 4) {
            System.out.println("1 to print all tasks\n2 to add new task\n3 to mark task as DONE\n4 to change due date of task\n5 to quit");
            choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (choice) {
                case 1:
                    TaskUtils.printTasks(userId);
                    System.out.println();
                    break;
                case 2:
                    TaskUtils.addTask(userId,"play jenshin","2023-04-30");
                    System.out.println();
                    break;
                case 3:
                    TaskUtils.markTaskAsDone("play jenshin");
                    System.out.println();
                    break;
                case 4:
                    TaskUtils.changeDueDate("play jenshin", "2024-05-01");
                    break;
            }
        }
    }
}
