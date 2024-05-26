package com.proyecto_a.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.proyecto_a.dto.PrecioElectricidad;

public class PrecioElectricidadDAO {
    public static boolean insertarPrecioElectricidad(PrecioElectricidad precioElectricidad) {  
        try (Connection conn = Conexion.getConnection()) {
            if (conn != null) {
                String sql = "INSERT INTO precioElectricidad (fechaInicio, fechaFin, precioKwh) VALUES (?,?,?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);

                pstmt.setString(1, precioElectricidad.getFechaInicio());
                pstmt.setString(2, precioElectricidad.getFechaFin());
                pstmt.setFloat(3, precioElectricidad.getPrecioKwh());

                int affectedRows = pstmt.executeUpdate(); // Solo necesita una llamada a executeUpdate()
                return affectedRows > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
