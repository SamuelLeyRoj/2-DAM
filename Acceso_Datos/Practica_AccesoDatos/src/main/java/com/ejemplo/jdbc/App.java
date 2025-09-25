package com.ejemplo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class App {

    public static void main(String[] args) throws SQLException {
        /*
        Alumno alumno = new Alumno();
        alumno.setNombre("Samuel");
        alumno.setEdad(19);

        Alumno alumno2 = new Alumno();
        alumno2.setNombre("Mathias");
        alumno2.setEdad(8);

        Utils.insertarAlumno(alumno);
        Utils.insertarAlumno(alumno2);
        Utils.insertarAlumno(alumno3);

         Utils.borrarAlumno("Ana");
        */

        Utils.alumnosMayoresde20();

/*

        try (Connection conn = DataBaseConnection.getConnection()) {
            if (conn != null) {

                String sql = "SELECT * FROM alumnos";
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    int edad = rs.getInt("edad");
                    System.out.println(id + " - " + nombre + " - " + edad);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

 */
    }
}


