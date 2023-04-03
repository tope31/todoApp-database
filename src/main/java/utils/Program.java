package utils;

import model.Users;

import java.sql.SQLException;

public class Program {
    public static void startProgram() throws SQLException {
        Users users = new Users();
        users.setUsername("lem");
        String username = users.getUsername();
        Boolean usernameExists = DatabaseAccessCheck.usernameDBCheck(username);

        if (usernameExists) {
            Integer retrieveUserId = DatabaseAccessCheck.retrieveUserId(username);
            users.setUserId(retrieveUserId);
            ShowUserMenu.mainMenu(users);
        } else {
            System.out.println("Sorry, the username does not exist on the database.");
            System.out.println("Please contact the administrator");
        }
    }
}
