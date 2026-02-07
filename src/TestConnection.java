import database.DatabaseConnection; // <--- This imports YOUR class
import java.sql.Connection;         // <--- This imports the SQL tool

public class TestConnection {
    public static void main(String[] args) {
        // Now it knows where "DatabaseConnection" comes from because of line 1
        Connection connection = DatabaseConnection.getConnection();

        if (connection != null) {
            System.out.println("Connection test passed!");
            DatabaseConnection.closeConnection(connection);
        } else {
            System.out.println("Connection test failed!");
        }
    }
}