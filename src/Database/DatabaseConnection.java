package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/datataskdb";
    private static final String USER = "root";
    public static final String PASSWORD = "";

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Gagal terhubung ke database!");
        }
    }
}
