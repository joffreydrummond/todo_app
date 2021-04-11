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
    private static Connection conn;
    private List<User> users;
    private List<Status> statuses;

//trying by removing the List from the contructor
    public Todo(int todoId, String todoContent, Date createdDate, int userId, int statusId) {
        this.todoId = todoId;
        this.todoContent = todoContent;
        this.createdDate = createdDate;
        this.userId = userId;
        this.statusId = statusId;

    }

    public Todo(String todoContent) {
        this.todoContent = todoContent;
    }

    public Todo(int anInt, String string) {
    }

//    public Todo(String todoContent) {
//    }

    public void TodoNew(String todoContent, Date createdDate, int userId, int statusId) {
        this.todoId = todoId;
        this.todoContent = todoContent;
        this.createdDate = createdDate;
        this.userId = userId;
        this.statusId = statusId;

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

    public static void addNewTodo() throws SQLException {
        String query1 = "";
        String query = "INSERT INTO todos (todo_content) VALUES(?)";
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter the user ID where you want to add a todo.");
            int userId = scanner.nextInt();
            PreparedStatement ps = conn.prepareStatement(query);
//            ps.setInt(2, userId);
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
}
