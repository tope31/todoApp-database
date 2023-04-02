package utils;

import java.sql.SQLException;

public class StartProgram {
    public static void startProgram() throws SQLException {
        String username = "lem";
        Integer userId;
        if (DatabaseAccessCheck.usernameDBCheck(username)) {
            userId = DatabaseAccessCheck.retrieveUserId(username);
            ShowUserMenu.mainMenu(userId);
        } else {
            System.out.println("Sorry, the username does not exist on the database.");
            System.out.println("Please contact the administrator");
        }
    }

}
