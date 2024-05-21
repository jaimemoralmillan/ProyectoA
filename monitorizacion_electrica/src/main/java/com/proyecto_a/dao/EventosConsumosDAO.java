package com.proyecto_a.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.proyecto_a.dto.EventosConsumo;


public class EventosConsumosDAO {
    public boolean insertarEventosConsumo(EventosConsumo eventosConsumo) {
        try (Connection conn = Conexion.getConnection()) {
            if (conn != null) {
                String sql = "INSERT INTO eventosConsumo (fechaInicio, fechaFin, idDispositivo) VALUES (?,?,?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);

                pstmt.setString(1, eventosConsumo.getFechaInicio());
                pstmt.setString(2, eventosConsumo.getFechaFin());
                pstmt.setInt(3, eventosConsumo.getIdDispositivo());
                // pstmt.setInt(4, eventosConsumo.getidDispositivo); Añadir id en los values
                
             
                int affectedRows = pstmt.executeUpdate(); // Solo necesita una llamada a executeUpdate()
                return affectedRows > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
