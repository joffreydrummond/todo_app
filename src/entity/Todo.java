package entity;

import java.util.Date;
import java.util.List;

public class Todo {
    private int todoId;
    private String todoContent;
    private Date createdDate;
    private int userId;
    private int statusId;
    private List<User> users;
    private List<Status> statuses;

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

    public Todo(int anInt, String string, java.sql.Date date) {
    }

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


}
