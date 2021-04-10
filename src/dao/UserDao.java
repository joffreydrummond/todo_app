package dao;

import entity.Todo;
import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserDao {
  private Connection conn = null;
  private PreparedStatement ps = null;
  private ResultSet rs = null;
  Scanner scan = new Scanner(System.in);
  private User user;
  private List<Todo> todos;
  private TodoDao todoDao = new TodoDao();
  private final String SHOW_ALL_USERS = "SELECT * FROM users";
  private final String SHOW_USER_BY_ID = "SELECT * FROM users WHERE user_id = ?";
  private final String DELETE_USER_BY_ID = "DELETE FROM users WHERE user_id = ? ";
  private final String INSERT_NEW_USER =
      "INSERT INTO users(first_name, last_name, email_address, phone_number) VALUES" + "(?,?,?,?)";
  private Object ResultSet;

  public UserDao() throws SQLException {
    conn = DBConnection.getConn();
  }

  public List<User> showAllUsers() throws SQLException {
    System.out.println("Querying all users from DB...");
    List<User> users = new ArrayList<>();
   rs = conn.prepareStatement(SHOW_ALL_USERS).executeQuery();
    try {
      System.out.println("Querying all users from DB...");
      while (rs.next()) {
        System.out.println(
            "User ID: "
                + rs.getInt("user_id")
                + " First Name: "
                + rs.getString("first_name")
                + " | Last Name: "
                + rs.getString("last_name")
                + " | Email Address: "
                + rs.getString("email_address")
                + " | Phone "
                + "Number: "
                + rs.getString("phone_number"));
      }
    } catch (SQLException throwables) {
      System.out.println("Error when running SelectAllUsers()...");
      throwables.printStackTrace();
    }
    //    finally {
    //      if (conn != null) {
    //        System.out.println("Closing the DB connection....");
    //        conn.close();
    //        System.out.println("DB connection has successfully disconnected.");
    //      }
    //    }
    return users;
  }


  //  public User showUserByID() throws SQLException {
  //    Scanner scan = new Scanner(System.in);
  //    User user = null;
  //    System.out.println("Enter the User ID of who you want to view.");
  //    int userId = Integer.parseInt(scan.nextLine());
  //    ResultSet rs = conn.prepareStatement(SHOW_USER_BY_ID).executeQuery();
  //    ps.setInt(1, userId);
  //    try {
  //      System.out.println("Querying all users from DB...");
  //      Statement stmt = conn.createStatement();
  //      while (rs.next()) {
  //        System.out.println(
  //                "User ID: "
  //                        + rs.getInt("user_id")
  //                        + " First Name: "
  //                        + rs.getString("first_name")
  //                        + " | Last Name: "
  //                        + rs.getString("last_name")
  //                        + " | Email Address: "
  //                        + rs.getString("email_address")
  //                        + " | Phone "
  //                        + "Number: "
  //                        + rs.getString("phone_number"));
  //      }
  //    } catch (SQLException throwables) {
  //      System.out.println("Error when running SelectAllUsers()...");
  //      throwables.printStackTrace();
  //    }
  //    return user;
  //  }

  public User getUserByID(int userId) throws SQLException {
//    System.out.println("Enter the User ID of who you want to view.");
//    int userId = Integer.parseInt(scan.nextLine());
    ps = conn.prepareStatement(SHOW_USER_BY_ID);
    ps.setInt(1, userId);
    rs = ps.executeQuery();
    rs.next();
    return populateUser(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));

  }

  public User populateUser(int userId, String firstName, String lastName, String emailAddy, String phoneNum) {

    return new User(userId, firstName, lastName, emailAddy, phoneNum);
  }
}



//  //    public void showAllUsers() throws SQLException {
//  //        String query = "SELECT * FROM users";
//          try {
//              System.out.println("Querying all users from DB...");
//              Statement stmt = conn.createStatement();
//              ResultSet rs = stmt.getResultSet();
//              while (rs.next()) {
//                  System.out.println("Entity.User ID: " + rs.getInt("user_id") + " First Name: " +
//   rs.getString("first_name") + " Last Name: " +
//                          rs.getString("last_name") + "Email Address: " +
//   rs.getString("email_address") + "Phone " +
//                          "Number: " + rs.getString("phone_number"));
//              }
//          } catch (SQLException throwables) {
//              System.out.println("Error when running SelectAllUsers()...");
//              throwables.printStackTrace();
//          } finally {
//              if (conn != null) {
//                  System.out.println("Closing the DB connection....");
//                  conn.close();
//                  System.out.println("DB connection has successfully disconnected.");
//              }
//          }
//  //    }
//
//  public void addNewUser() throws SQLException {
//    String query =
//        "INSERT INTO users(first_name, last_name, email_address, phone_number) VALUES(?,?,?,?)";
//    Scanner scan = new Scanner(System.in);
//    try {
//      System.out.println("Enter the first name of the new user: ");
//      String firstName = scan.nextLine();
//      PreparedStatement ps = conn.prepareStatement(query);
//      ps.setString(1, firstName);
//      System.out.println("Enter the last name of the new user: ");
//      String lastName = scan.nextLine();
//      ps.setString(2, lastName);
//      System.out.println("Enter the email address of the new user: ");
//      String emailAddress = scan.nextLine();
//      ps.setString(3, emailAddress);
//      System.out.println("Enter the phone number of the new user: ");
//      String phoneNumber = scan.nextLine();
//      ps.setString(4, phoneNumber);
//      ps.executeUpdate();
//      System.out.println("New user created successfully!");
//    } catch (SQLException throwables) {
//      System.out.println("Error when running addNewUsers()...");
//      throwables.printStackTrace();
//    } finally {
//      if (conn != null) {
//        System.out.println("Closing the DB connection....");
//        conn.close();
//        System.out.println("DB connection has successfully disconnected.");
//      }
//    }
//  }
//
//  public void deleteUser() throws SQLException {
//    String query = "DELETE FROM users WHERE user_id = ? ";
//    Scanner scan = new Scanner(System.in);
//    try {
//      System.out.println("Enter the user id of the user you want to delete: ");
//      Integer userId = scan.nextInt();
//      PreparedStatement ps = conn.prepareStatement(query);
//      ps.setInt(1, userId);
//      ps.executeUpdate();
//      System.out.println("Entity.User was deleted successfully!");
//    } catch (SQLException throwables) {
//      System.out.println("Error when running deleteUser()");
//      throwables.printStackTrace();
//    } finally {
//      if (conn != null) {
//        System.out.println("Closing the DB connection....");
//        conn.close();
//        System.out.println("DB connection has successfully disconnected.");
//      }
//    }
//  }
