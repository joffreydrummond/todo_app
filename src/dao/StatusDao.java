package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatusDao {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private final String UPDATE_TODO_STATUS = "UPDATE todos SET status_id = ? WHERE todo_id = ?";


    public StatusDao() throws SQLException {
        conn = DBConnection.getConn();
    }


    public void updateTodoStatus(int statusId, int todoId) throws SQLException {
        ps = conn.prepareStatement(UPDATE_TODO_STATUS);
        ps.setInt(1, statusId);
        ps.setInt(2, todoId);
        ps.executeUpdate();
    }

}
