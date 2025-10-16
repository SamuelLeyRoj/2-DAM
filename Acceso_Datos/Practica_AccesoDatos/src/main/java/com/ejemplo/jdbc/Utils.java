package com.ejemplo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Utils {

    public static void insertarAlumno(Alumno alumno) throws SQLException {
        try (Connection conn = DataBaseConnection.getConnection()) {
            if(conn != null) {
                String sql = "INSERT INTO alumnos (nombre, edad) VALUES (?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, alumno.getNombre());
                ps.setInt(2, alumno.getEdad());
                ps.executeUpdate();

            }
        }
    }

    public static void borrarAlumno(String nombre) throws SQLException {
        try (Connection conn = DataBaseConnection.getConnection()) {
            if(conn != null) {
                String sql = "DELETE FROM alumnos WHERE nombre = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, nombre);
                ps.executeUpdate();
            }
        }
    }


    public static void alumnosMayoresde20() throws SQLException {
        try(Connection conn = DataBaseConnection.getConnection()){
        if(conn != null) {
        String sql = "SELECT * FROM alumnos WHERE edad >= 20 ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            System.out.printf("Nombre: ");
            System.out.printf(rs.getString("nombre"));  
        }
            }
        }
    }
}
