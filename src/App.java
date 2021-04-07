import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

private static Connection conn;
    public static void main(String[] args) throws SQLException {
        String connString = "jdbc:mysql://localhost:3306/todo_db";
        try {
            System.out.println("Establishing DB connection...");
            conn = DriverManager.getConnection(connString, "root", "password");
            System.out.println("Connected to DB successfully! Way to go.");


        } catch (SQLException throwables) {
            System.out.println("Error connecting to the DB. Debug time.");
            throwables.printStackTrace();
        } finally {
            if (conn != null){
                System.out.println("Closing the DB connection....");
                conn.close();
                System.out.println("DB connection has successfully disconnected.");
            }
        }
    }




}
