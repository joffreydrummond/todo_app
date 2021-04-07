import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User {
    public static Connection conn;
    public static void selectAllUsers() throws SQLException {
        String query = "SELECT * FROM users";
        try {
            System.out.println("Querying all users from DB...");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.getResultSet();
            while(rs.next()){
                System.out.println("User ID: " + rs.getInt("user_id") + " First Name: " + rs.getString("first_name") + " Last Name: " +
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

}
