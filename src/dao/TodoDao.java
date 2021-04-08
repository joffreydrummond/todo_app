package dao;

import entity.Todo;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TodoDao {
    public static Connection conn;
    private static UserDao userDao;
    private User user;
    private List<Todo> todos;
    Scanner scan = new Scanner(System.in);
    private final String GET_TODO_BY_USER_ID = "SELECT * FROM todos WHERE user_id = ?";

    public TodoDao() throws SQLException {
        conn = DBConnection.getConn();

    }

    public List<Todo> getTodoByUserID(int userId) throws SQLException {
        try {
            PreparedStatement ps = conn.prepareStatement(GET_TODO_BY_USER_ID);
            System.out.println("Enter the user ID where you want to add a todo.");
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            List<Todo> todos = new ArrayList<>();

            while (rs.next()){
                todos.add(new Todo(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getInt(5), rs.getInt(6)));
            }

            if (user != null){

                System.out.println("Enter the todo details.");
                String todosContent = scan.nextLine();
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
        return todos;
    }

/*
    public static void addNewTodo() throws SQLException {
        String query = "INSERT INTO todos (todo_content, user_id) VALUES(?, ?, ?)";
        Scanner scanner = new Scanner(System.in);
        System.out.println("We are adding a new todo.");
        int userId = scanner.nextInt();
        User user = userDao.populateUsers(userId);

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            System.out.println("Enter the user ID of the user to add a todo.");
            ps.setInt(1, userId);

            if (user != null) {

                System.out.println("Enter the todo details.");
                String todosContent = scanner.nextLine();
                ps.setString(1, todosContent);
                ps.executeUpdate();
            }

        } catch (SQLException throwables) {
            System.out.println("Error when running addNewTodo().");
            throwables.printStackTrace();
        } finally {
            if (conn != null) {
                System.out.println("Closing DB connection...");
                conn.close();
                System.out.println("DB has disconnected successfully.");
            }
        }
    }
*/
}
