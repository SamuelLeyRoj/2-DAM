package com.ejemplo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataBaseConnection {
    private static final String URL = "jdbc:mariadb://localhost:3306/escuela";
    private static final String USER = "root"; // cambia según tu instalación
    private static final String PASSWORD = "123456"; // cambia según tu instalación

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Conexión establecida correctamente");
        } catch (SQLException e) {
            System.out.println("❌ Error al conectar: " + e.getMessage());
        }
        return conn;
    }
}
