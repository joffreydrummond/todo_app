package dao;

import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TodoDao {
    public static Connection conn;
    private static UserDao userDao;




    public static void addNewTodo() throws SQLException {
              String query = "INSERT INTO todos (todo_content, user_id) VALUES(?, ?, ?)";
        Scanner scanner = new Scanner(System.in);
        System.out.println("We are passing in a new user.");
        int userId = scanner.nextInt();
        User user = userDao.populateUser(userId);

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            System.out.println("Enter the user ID where you want to add a todo.");
            ps.setInt(1, userId);

            if (user != null){

                System.out.println("Enter the todo details.");
                String todosContent = scanner.nextLine();
                ps.setString(1, todosContent);
                ps.executeUpdate();
            }

        } catch (SQLException throwables) {
            System.out.println("Error when running addNewTodo().");
            throwables.printStackTrace();
        }
        finally {
            if (conn != null) {
                System.out.println("Closing DB connection...");
                conn.close();
                System.out.println("DB has disconnected successfully.");
            }
        }
    }
}
