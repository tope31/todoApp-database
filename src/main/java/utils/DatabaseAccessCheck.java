package utils;

import dbConnection.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseAccessCheck {
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    public static Boolean usernameDBCheck(String username) throws SQLException {
        String sql = "SELECT username FROM users WHERE username = ?";
        Boolean IsUsernameValid = false;

        preparedStatement = DBConnection.getDBConnection().prepareStatement(sql);
        preparedStatement.setString(1, username);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            resultSet.getString(1);
            IsUsernameValid = true;
        }
        return IsUsernameValid;
    }

    public static Integer retrieveUserId(String username) throws SQLException {
        String sql = "SELECT user_id FROM users WHERE username = ?";
        Integer userId = 0;

        preparedStatement = DBConnection.getDBConnection().prepareStatement(sql);
        preparedStatement.setString(1, username);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            userId = resultSet.getInt(1);
        }
        return userId;
    }
}
