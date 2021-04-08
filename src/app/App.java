package app;

import java.sql.*;
import java.util.Scanner;

public class App {

    private static Connection conn;

    public static void main(String[] args) throws SQLException {
        Menu menu = new Menu();
        menu.start();

        public static void addNewTodo()  {
            String query = "INSERT INTO todos SET todo_content = ? WHERE user_id = ?";
            Scanner scanner = new Scanner(System.in);

            try {
//            System.out.println("Enter the user ID where you want to add a todo.");
//            Int userId = scanner.nextInt();
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
}