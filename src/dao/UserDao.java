package dao;

import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
  private Connection conn = null;
  private PreparedStatement ps = null;
  private ResultSet rs = null;
  private final String SHOW_ALL_USERS = "SELECT * FROM users";
  private final String SHOW_USER_BY_ID = "SELECT * FROM users WHERE user_id = ?";
  private final String DELETE_USER_BY_ID = "DELETE FROM users WHERE user_id = ? ";
  private final String INSERT_NEW_USER =
      "INSERT INTO users(first_name, last_name, email_address, phone_number) VALUES" + "(?,?,?,?)";

  public UserDao() throws SQLException {
    conn = DBConnection.getConn();
  }

  public List<User> showAllUsers() throws SQLException {
    List<User> users = new ArrayList<>();
    rs = conn.prepareStatement(SHOW_ALL_USERS).executeQuery();
    try {
      System.out.println("Querying all users from DB...");
      while (rs.next()) {

        users.add(
            new User(
                rs.getInt("user_id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("email_address"),
                rs.getString("phone_number")));
      }
    } catch (SQLException throwables) {
      System.out.println("Error when running SelectAllUsers()...");
      throwables.printStackTrace();
    }
    return users;
  }

  public User getUserByID(int userId) throws SQLException {
    ps = conn.prepareStatement(SHOW_USER_BY_ID);
    ps.setInt(1, userId);
    rs = ps.executeQuery();
    rs.next();
    return populateUser(
        rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
  }

  public void addNewUser(String firstName, String lastName, String emailAddy, String phoneNum)
      throws SQLException {
    ps = conn.prepareStatement(INSERT_NEW_USER);
    ps.setString(1, firstName);
    ps.setString(2, lastName);
    ps.setString(3, emailAddy);
    ps.setString(4, phoneNum);
    ps.executeUpdate();
  }

  public void deleteUserById(int userId) throws SQLException {
    ps = conn.prepareStatement(DELETE_USER_BY_ID);
    ps.setInt(1, userId);
    ps.executeUpdate();
  }

  public void closeConn() throws SQLException {
    System.out.println("Closing the DB connection....");
    conn.close();
    System.out.println("DB connection has successfully disconnected.");
  }

  public User populateUser(
      int userId, String firstName, String lastName, String emailAddy, String phoneNum) {
    return new User(userId, firstName, lastName, emailAddy, phoneNum);
  }
}
