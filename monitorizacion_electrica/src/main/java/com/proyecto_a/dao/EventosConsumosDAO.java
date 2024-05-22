package com.proyecto_a.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Duration;

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


   
    public static boolean actualizarConsumoKwhEventosConsumo() {
        try (Connection conn = Conexion.getConnection()) {
            if (conn != null) {
                // Consulta para obtener los datos de dispositivos y eventosconsumo
                String sqlSelect = "SELECT eventosconsumo.idEventosConsumo, eventosconsumo.idDispositivo, dispositivos.consumoPorHora, eventosconsumo.fechainicio, eventosconsumo.fechafin " +
                                   "FROM dispositivos " +
                                   "JOIN eventosconsumo ON dispositivos.idDispositivo = eventosconsumo.idDispositivo";
                PreparedStatement statementSelect = conn.prepareStatement(sqlSelect);
                ResultSet rs = statementSelect.executeQuery();
    
                // Preparar la sentencia de actualización para eventosconsumo
                String sqlActualizar = "UPDATE eventosconsumo SET consumoKwh = ? WHERE idEventosConsumo = ?";
                PreparedStatement statementUpdate = conn.prepareStatement(sqlActualizar);
    
                // Iterar sobre los resultados de la consulta y realizar las actualizaciones
                while (rs.next()) {
                    int idEvento = rs.getInt("idEventosConsumo");
                    float consumoPorHora = rs.getFloat("consumoPorHora");
                    Timestamp fechainicio = rs.getTimestamp("fechainicio");
                    Timestamp fechafin = rs.getTimestamp("fechafin");
    
                    // Calcular la duración en horas entre fechainicio y fechafin
                    long milliseconds = Duration.between(fechainicio.toInstant(), fechafin.toInstant()).toMillis();
                    float hours = milliseconds / (1000f * 60 * 60);
    
                    // Calcular el consumo total
                    float consumoTotal = consumoPorHora * hours;
    
                    // Asignar los valores a la sentencia de actualización
                    statementUpdate.setFloat(1, consumoTotal);
                    statementUpdate.setInt(2, idEvento);
                    statementUpdate.executeUpdate();
                }
    
                return true; // Indicar que la operación fue exitosa
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Indicar que la operación falló
    }
    
    
    
    

}
