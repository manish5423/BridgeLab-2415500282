package com.jdbc.student_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionImpl implements IConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/student"; 
    private static final String USER = "root"; 
    private static final String PASSWORD = "root"; 

    @Override
    public Connection getConnection() {
        Connection conn = null;

        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connected successfully!");

            
            createStudentTable(conn);

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Connection or table creation failed: " + e.getMessage());
        }

        return conn;
    }

    private void createStudentTable(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS student ("
                   + "id INT PRIMARY KEY, "
                   + "name VARCHAR(50), "
                   + "age INT, "
                   + "email VARCHAR(50)"
                   + ")";  

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table 'student' is ready to use!");
        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
        }
    }
}