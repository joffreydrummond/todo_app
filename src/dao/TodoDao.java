package dao;

import entity.Todo;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TodoDao {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private static UserDao userDao;
    private User user;
    private List<Todo> todos;
    Scanner scan = new Scanner(System.in);
    private final String GET_TODOS_BY_USER_ID = "SELECT * FROM todos WHERE user_id = ?";
    private final String INSERT_TODO = "INSERT INTO todos (todo_content, user_id) VALUES(?, ?)";

    public TodoDao() throws SQLException {
        conn = DBConnection.getConn();

    }

    public Todo getTodoByUserId1(int userId) throws SQLException {
        ps = conn.prepareStatement(GET_TODOS_BY_USER_ID);
        ps.setInt(1, userId);
        rs = ps.executeQuery();
        rs.next();
       return populateTodo(rs.getString(2));
    }

    public Todo getTodoByUserId(int userId) throws SQLException {
        ps = conn.prepareStatement(GET_TODOS_BY_USER_ID);
        ps.setInt(1, userId);
        rs = ps.executeQuery();
        rs.next();
        List<Todo> todos = new ArrayList<>();
            while (rs.next()){
                todos.add(new Todo(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getInt(4)));
            }
        return populateTodo(rs.getString(2));
    }

    public void addNewTodoToUser(int userId, String todoContent) throws SQLException {
        ps = conn.prepareStatement(INSERT_TODO);
        ps.setInt(2, userId);
        ps.setString(1, todoContent);
            ps.executeUpdate();
    }



    public Todo populateTodo(String todoContent){

        return new Todo(todoContent);
    }

//    public List<Todo> getTodoByUserID(int userId) throws SQLException {
//        try {
//            PreparedStatement ps = conn.prepareStatement(GET_TODOS_BY_USER_ID);
//            System.out.println("Enter the user ID where you want to add a todo.");
//            ps.setInt(1, userId);
//            ResultSet rs = ps.executeQuery();
//            List<Todo> todos = new ArrayList<>();
//
//            while (rs.next()){
//                todos.add(new Todo(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getInt(5)));
//            }
//
//            if (user != null){
//
//                System.out.println("Enter the todo details.");
//                String todosContent = scan.nextLine();
//                ps.setString(1, todosContent);
//                ps.executeUpdate();
//            }
//
//        } catch (SQLException throwables) {
//            System.out.println("Error when running addNewTodo().");
//            throwables.printStackTrace();
//        }
//        finally {
//            if (conn != null) {
//                System.out.println("Closing DB connection...");
//                conn.close();
//                System.out.println("DB has disconnected successfully.");
//            }
//        }
//        return todos;
//    }

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
