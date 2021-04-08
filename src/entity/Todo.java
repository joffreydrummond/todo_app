package entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Todo {
    private int todoId;
    private String todoContent;
    private Date createdDate;
    private int userId;
    private int statusId;
    private List<User> users;
    private List<Status> statuses;

    public Todo(int todoId, String todoContent, Date createdDate, int userId, int statusId, List<User> users,
                List<Status> statuses) {
        this.todoId = todoId;
        this.todoContent = todoContent;
        this.createdDate = createdDate;
        this.userId = userId;
        this.statusId = statusId;
        this.users = users;
        this.statuses = statuses;
    }

    private static Connection conn;

    public static void addNewTodo() throws SQLException {
        String query = "UPDATE todos SET todo_content = ? WHERE user_id = ?";
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter the user ID where you want to add a todo.");
            Integer userId = scanner.nextInt();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(2, userId);
            System.out.println("Enter the todo details.");
            String todosContent = scanner.nextLine();
            ps.setString(1, todosContent);
            ps.executeUpdate();
            System.out.println("New todo added successfully!");
        } catch (SQLException throwables) {
            System.out.println("Error when running addNewTodo().");
            throwables.printStackTrace();
        }finally {
            if (conn != null) {
                System.out.println("Closing DB connection...");
                conn.close();
                System.out.println("DB has disconnected successfully.");
            }
        }


    }


    public int getTodoId() {
        return todoId;
    }

    public void setTodoId(int todoId) {
        this.todoId = todoId;
    }

    public String getTodoContent() {
        return todoContent;
    }

    public void setTodoContent(String todoContent) {
        this.todoContent = todoContent;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Status> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<Status> statuses) {
        this.statuses = statuses;
    }
}
