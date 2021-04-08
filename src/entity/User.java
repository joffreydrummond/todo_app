package entity;

import java.sql.*;
import java.util.Scanner;

public class User {
    private int userId;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;

    public User(int userId, String firstName, String lastName, String emailAddress, String phoneNumber){
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }















    public static Connection conn;
    public static void showAllUsers() throws SQLException {
        String query = "SELECT * FROM users";
        try {
            System.out.println("Querying all users from DB...");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.getResultSet();
            while(rs.next()){
                System.out.println("Entity.User ID: " + rs.getInt("user_id") + " First Name: " + rs.getString("first_name") + " Last Name: " +
                        rs.getString("last_name") + "Email Address: " + rs.getString("email_address") + "Phone " +
                        "Number: " + rs.getString("phone_number"));
            }
        } catch (SQLException throwables) {
            System.out.println("Error when running SelectAllUsers()...");
            throwables.printStackTrace();
        } finally {
            if (conn != null){
                System.out.println("Closing the DB connection....");
                conn.close();
                System.out.println("DB connection has successfully disconnected.");
            }
        }
    }

    public static void addNewUser() throws SQLException {
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
            if (conn != null){
                System.out.println("Closing the DB connection....");
                conn.close();
                System.out.println("DB connection has successfully disconnected.");
            }
        }
    }

    public static void deleteUser() throws SQLException {
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


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
