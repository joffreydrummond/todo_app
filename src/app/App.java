package app;

import java.sql.*;
import java.util.Scanner;

public class App {

    private static Connection conn;

    public static void main(String[] args) throws SQLException {
        Menu menu = new Menu();
        menu.start();


//        String connString = "jdbc:mysql://localhost:3306/todo_db";
//        try {
//            System.out.println("Establishing DB connection...");
//            conn = DriverManager.getConnection(connString, "root", "password");
//            System.out.println("Connected to DB successfully! Way to go.");
//            addNewTodo();
//            deleteUser();
//            selectAllUsers();
//
//        } catch (SQLException throwables) {
//            System.out.println("Error connecting to the DB. Debug time.");
//            throwables.printStackTrace();
//        }
//        finally {
//            if (conn != null) {
//                System.out.println("Closing the DB connection....");
//                conn.close();
//                System.out.println("DB connection has successfully disconnected.");
//            }
//        }
    }

//    public static void selectAllUsers() throws SQLException {
//        String query = "SELECT * FROM users";
//        try {
//            System.out.println("Querying all users from DB...");
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(query);
//            while (rs.next()) {
//                System.out.println("Entity.User ID: " + rs.getInt("user_id") + " | First Name: " + rs.getString("first_name") + " | Last Name: " +
//                        rs.getString("last_name") + " | Email Address: " + rs.getString("email_address") + " | Phone " +
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
//
//    public static void addNewUser() throws SQLException {
//        String query = "INSERT INTO users(first_name, last_name, email_address, phone_number) VALUES(?,?,?,?)";
//        Scanner scan = new Scanner(System.in);
//        try {
//            System.out.println("Enter the first name of the new user: ");
//            String firstName = scan.nextLine();
//            PreparedStatement ps = conn.prepareStatement(query);
//            ps.setString(1, firstName);
//            System.out.println("Enter the last name of the new user: ");
//            String lastName = scan.nextLine();
//            ps.setString(2, lastName);
//            System.out.println("Enter the email address of the new user: ");
//            String emailAddress = scan.nextLine();
//            ps.setString(3, emailAddress);
//            System.out.println("Enter the phone number of the new user: ");
//            String phoneNumber = scan.nextLine();
//            ps.setString(4, phoneNumber);
//            ps.executeUpdate();
//            System.out.println("New user created successfully!");
//        } catch (SQLException throwables) {
//            System.out.println("Error when running addNewUsers()...");
//            throwables.printStackTrace();
//        } finally {
//            if (conn != null) {
//                System.out.println("Closing the DB connection....");
//                conn.close();
//                System.out.println("DB connection has successfully disconnected.");
//            }
//        }
//    }
//
//    public static void deleteUser() throws SQLException {
//        String query = "DELETE FROM users WHERE user_id = ? ";
//        Scanner scan = new Scanner(System.in);
//        try {
//            System.out.println("Enter the user id of the user you want to delete: ");
//            Integer userId = scan.nextInt();
//            PreparedStatement ps = conn.prepareStatement(query);
//            ps.setInt(1, userId);
//            ps.executeUpdate();
//            System.out.println("Entity.User was deleted successfully!");
//        } catch (SQLException throwables) {
//            System.out.println("Error when running deleteUser()");
//            throwables.printStackTrace();
//        } finally {
//            if (conn != null) {
//                System.out.println("Closing the DB connection....");
//                conn.close();
//                System.out.println("DB connection has successfully disconnected.");
//            }
//        }
//    }

//    public static void addNewTodo() throws SQLException {
//        String query = "UPDATE todos SET todo_content = ? WHERE user_id = ?";
//        Scanner scanner = new Scanner(System.in);
//
//        try {
//            System.out.println("Enter the user ID where you want to add a todo.");
//            Integer userId = scanner.nextInt();
//            PreparedStatement ps = conn.prepareStatement(query);
//            ps.setInt(2, userId);
//            System.out.println("Enter the todo details.");
//            String todosContent = scanner.nextLine();
//            ps.setString(1, todosContent);
//            ps.executeUpdate();
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
//    }


}
