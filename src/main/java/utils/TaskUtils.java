package utils;

import dbConnection.DBConnection;
import taskEnums.Status;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TaskUtils {
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;
    private static Scanner scanner = new Scanner(System.in);
    private static Status status;
    public static void printTasks(Integer userId) throws SQLException {
        String sql = "SELECT * FROM user_tasks WHERE user_id = ?";

        preparedStatement = DBConnection.getDBConnection().prepareStatement(sql);
        preparedStatement.setInt(1,userId);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            String task = resultSet.getString("task");
            String status = resultSet.getString("status");
            String dueDate = resultSet.getString("due_date");

            System.out.println(status + ": " + task + ", due date: " + dueDate);
        }
    }

    public static void addTask(Integer userId, String taskToAdd,String dueDate) throws SQLException {
        String sql = "INSERT INTO user_tasks (user_id, task, status, due_date) VALUES (?, ?, ?, ?)";

        preparedStatement = DBConnection.getDBConnection().prepareStatement(sql);
        preparedStatement.setInt(1,userId);
        preparedStatement.setString(2,taskToAdd);
        preparedStatement.setString(3,status.OPEN.toString());
        preparedStatement.setString(4,dueDate);

        int rowsInserted = preparedStatement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Task inserted successfully!");
        }
    }

    public static void markTaskAsDone(String task) throws SQLException {
        String sql = "UPDATE user_tasks SET status = ? WHERE task = ?";

        preparedStatement = DBConnection.getDBConnection().prepareStatement(sql);
        preparedStatement.setString(1,status.CLOSE.toString());
        preparedStatement.setString(2,task);

        int rowsUpdated = preparedStatement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Task marked as DONE. Great Job!");
        }
    }

    public static void changeDueDate(String task, String updatedDueDate) throws SQLException {
        String sql = "UPDATE user_tasks SET due_date = ? WHERE task = ?";

        preparedStatement = DBConnection.getDBConnection().prepareStatement(sql);
        preparedStatement.setString(1,updatedDueDate);
        preparedStatement.setString(2,task);

        int rowsUpdated = preparedStatement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Due date of the task has been changed, please don't forget to do it!");
            System.out.println();
        }
    }
}
