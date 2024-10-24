package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/ecommerce?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root"; // DB username
    private static final String PASSWORD = "22501a4423"; // DB password
    private static final String driver = "com.mysql.cj.jdbc.Driver";

    // Method to get connection
    public static Connection getConnection() throws SQLException {
        try {
            // Load the MySQL JDBC driver
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}