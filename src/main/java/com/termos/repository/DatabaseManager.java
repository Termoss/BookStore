package com.termos.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    public static Connection connectToDatabase() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:8080/termos_store",
                "postgres",
                "postgres");
    }
}
