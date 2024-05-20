package com.proyecto_a.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.proyecto_a.dto.FranjaHoraria;

public class FranjaHorariaDAO {
    public static boolean insertarFranjas(FranjaHoraria[] franjas) {
        String sql = "INSERT INTO franjaHoraria (descripcion, horaInicio, horaFin) " +      // Inserta las franjas horarias en la base de datos si no existe ya en la base de datos.
                     "SELECT ?, ?, ? WHERE NOT EXISTS (" + "SELECT 1 FROM franjaHoraria WHERE descripcion = ? AND horaInicio = ? AND horaFin = ?)";   // Comprueba que no exista ya en la base de datos.
        try (Connection conn = Conexion.getConnection(); // Establece la conexión con la base de datos.
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (FranjaHoraria franja : franjas) { // Recorre todas las franjas horarias.
                pstmt.setString(1, franja.getDescripcion());
                pstmt.setString(2, franja.getHoraInicio());
                pstmt.setString(3, franja.getHoraFin());
                pstmt.setString(4, franja.getDescripcion());
                pstmt.setString(5, franja.getHoraInicio());
                pstmt.setString(6, franja.getHoraFin()); 
                pstmt.addBatch(); // Añade la sentencia SQL a la lista de sentencias a ejecutar.
            }
            int[] affectedRows = pstmt.executeBatch(); // Ejecuta la sentencia SQL.
            return affectedRows.length == franjas.length; // Devuelve true si se han insertado todas las franjas horarias.
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}


/*
 * 00:00 - 05:00 - Very Cheap
 * 06:00 - 08:00 - Under Avg
 * 08:00 - 14:00 - Expensive
 * 14:00 - 18:00 - Under Avg
 * 18:00 - 24:00 - Expensive
 */