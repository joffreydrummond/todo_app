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

public class TodoDao {
  private Connection conn = null;
  private PreparedStatement ps = null;
  private ResultSet rs = null;
  private final String GET_TODOS_BY_USER_ID = "SELECT * FROM todos WHERE user_id = ?";
  private final String INSERT_TODO = "INSERT INTO todos (todo_content, user_id) VALUES(?, ?)";
  private final String UPDATE_TODO_STATUS = "UPDATE todos SET status_id = ? WHERE todo_id = ?";
  private final String DELETE_TODO = "DELETE FROM todos WHERE todo_id = ?";

  public TodoDao() throws SQLException {
    conn = DBConnection.getConn();
  }

  public List<Todo> getTodoByUserId(int userId) throws SQLException {
    List<Todo> todos = new ArrayList<>();
    ps = conn.prepareStatement(GET_TODOS_BY_USER_ID);
    ps.setInt(1, userId);
    rs = ps.executeQuery();

    try {
      System.out.println("Status: 1 = Open, 2 = Completed, 3 = Abandoned.");
      while (rs.next()) {
        System.out.println(
                "---------------------------------" +
            " \nUser ID: "
                + rs.getInt("user_id")
                + "\n---------------------------------"
                + "\nTo-Do ID: "
                + rs.getInt("todo_id")
                + "\n To-Do: "
                + rs.getString("todo_content")
                + "\n Created: "
                + rs.getDate("created_date")
                + "\nStatus: "
                + rs.getInt("status_id")
                + "\n---------------------------------");
      }
    } catch (SQLException throwables) {
      System.out.println("Error when running SelectAllUsers()...");
      throwables.printStackTrace();
    }
    return todos;
  }

  public void updateTodoStatus(int statusId, int todoId) throws SQLException {
    ps = conn.prepareStatement(UPDATE_TODO_STATUS);
    ps.setInt(1, statusId);
    ps.setInt(2, todoId);
    ps.executeUpdate();
  }

  public void deleteTodoById(int todoId) throws SQLException {
    ps = conn.prepareStatement(DELETE_TODO);
    ps.setInt(1, todoId);
    ps.executeUpdate();
  }

  public void addNewTodoToUser(int userId, String todoContent) throws SQLException {
    ps = conn.prepareStatement(INSERT_TODO);
    ps.setInt(2, userId);
    ps.setString(1, todoContent);
    ps.executeUpdate();
  }

  public Todo populateTodo(
      int todoId, String todoContent, Date createdDate, int userId, int statusId) {
    return new Todo(todoId, todoContent, createdDate, userId, statusId);
  }
}
