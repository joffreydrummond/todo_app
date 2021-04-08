package dao;

import entity.Todo;
import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class UserDao {
    private Connection conn;
    private User user;
    private List<Todo> todos;
    private TodoDao todoDao;
    private final String SHOW_ALL_USERS = "SELECT * FROM users";
    private final String SHOW_USER_BY_ID = "SELECT * FROM users WHERE user_id = ?";


    public UserDao() throws SQLException {
        conn = DBConnection.getConn();
    }

    public List<User> showAllUsers() throws SQLException {
        System.out.println("Querying all users from DB...");
        ResultSet rs = conn.prepareStatement(SHOW_ALL_USERS).executeQuery();
        List<User> users = new ArrayList<>();
        while (rs.next()) {
            users.add(populateUsers(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
             todos));
        }
        System.out.println("Here is the list of all users.");
        return users;
    }

    public User getUserById(int userId) throws SQLException {
        System.out.println("Enter the ID of the user you want to view.");
        PreparedStatement ps = conn.prepareStatement(SHOW_USER_BY_ID);
        ps.setInt(1, userId);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return populateUsers(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                todos);

    }

    private User populateUsers(int userId, String firstName, String lastName, String emailAddress, String phoneNumber
            , List<Todo> todos) throws SQLException {
        return new User(userId, firstName, lastName, emailAddress, phoneNumber, todoDao.getTodoByUserID(userId));
    }


//    public User populateUser(int user_id){
//        ResultSet rs = null;
//        try {
//            rs = conn.prepareStatement(SHOW_USER_BY_ID).executeQuery();
//            while(rs.next()){
//                user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
//            }
//            return user;
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return null;
//    }

//    public User populateUsers(int user_id) {
//        ResultSet rs = null;
//        try {
//            rs = conn.prepareStatement(SHOW_USER_BY_ID).executeQuery();
//            while (rs.next()) {
//                user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
//                        (List<Todo>) rs.getArray(6));
//            }
//            return user;
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return null;
//    }


//    public void showAllUsers() throws SQLException {
//        String query = "SELECT * FROM users";
//        try {
//            System.out.println("Querying all users from DB...");
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.getResultSet();
//            while (rs.next()) {
//                System.out.println("Entity.User ID: " + rs.getInt("user_id") + " First Name: " + rs.getString("first_name") + " Last Name: " +
//                        rs.getString("last_name") + "Email Address: " + rs.getString("email_address") + "Phone " +
//                        "Number: " + rs.getString("phone_number"));
//            }
//        } catch (SQLException throwables) {
//            System.out.println("Error when running SelectAllUsers()...");
//            throwables.printStackTrace();
//        } finally {
//            if (conn != null) {
//                System.out.println("Closing the DB connection....");
//                conn.close();
//                System.out.println("DB connection has successfully disconnected.");
//            }
//        }
//    }

    public void addNewUser() throws SQLException {
        String query = "INSERT INTO users(first_name, last_name, email_address, phone_number) VALUES(?,?,?,?)";
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Enter the first name of the new user: ");
            String firstName = scan.nextLine();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, firstName);
            System.out.println("Enter the last name of the new user: ");
            String lastName = scan.nextLine();
            ps.setString(2, lastName);
            System.out.println("Enter the email address of the new user: ");
            String emailAddress = scan.nextLine();
            ps.setString(3, emailAddress);
            System.out.println("Enter the phone number of the new user: ");
            String phoneNumber = scan.nextLine();
            ps.setString(4, phoneNumber);
            ps.executeUpdate();
            System.out.println("New user created successfully!");
        } catch (SQLException throwables) {
            System.out.println("Error when running addNewUsers()...");
            throwables.printStackTrace();
        } finally {
            if (conn != null) {
                System.out.println("Closing the DB connection....");
                conn.close();
                System.out.println("DB connection has successfully disconnected.");
            }
        }
    }

    public void deleteUser() throws SQLException {
        String query = "DELETE FROM users WHERE user_id = ? ";
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Enter the user id of the user you want to delete: ");
            Integer userId = scan.nextInt();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, userId);
            ps.executeUpdate();
            System.out.println("Entity.User was deleted successfully!");
        } catch (SQLException throwables) {
            System.out.println("Error when running deleteUser()");
            throwables.printStackTrace();
        } finally {
            if (conn != null) {
                System.out.println("Closing the DB connection....");
                conn.close();
                System.out.println("DB connection has successfully disconnected.");
            }
        }
    }

}
