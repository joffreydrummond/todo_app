package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection conn;
    private final static String URL = "jdbc:mysql://localhost:3306/todo_db";
    private final static String USERNAME = "root";
    private final static String PASSWD = "password";
    private static DBConnection instance;

    private DBConnection(Connection conn) {
        this.conn = conn;
    }

    public static Connection getConn() throws SQLException {
        if (instance == null) {
            try {
                System.out.println("Establishing DB connection...");
                conn = DriverManager.getConnection(URL, USERNAME, PASSWD);
                instance = new DBConnection(conn);
                System.out.println("Connected to DB successfully! Way to go.");
            } catch (SQLException throwables) {
                System.out.println("Error in connecting to DB....");
                throwables.printStackTrace();
            }
//            finally {
//                if (conn != null) {
//                    System.out.println("Closing the DB connection....");
//                    conn.close();
//                    System.out.println("DB connection has successfully disconnected.");
//                }
//            }
        }
        return DBConnection.conn;
    }
}
