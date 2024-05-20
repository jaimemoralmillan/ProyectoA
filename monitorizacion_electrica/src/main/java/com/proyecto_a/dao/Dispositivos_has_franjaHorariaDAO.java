package com.proyecto_a.dao;

import java.sql.*;

import com.proyecto_a.dto.Dispositivo;
import com.proyecto_a.dto.FranjaHoraria;

public class Dispositivos_has_franjaHorariaDAO {

    // Asociar prioridades a los dispositivos
    public boolean asociarPrioridades(Dispositivo dispositivo, FranjaHoraria franja, int contadorFranja) {
        String sql = "INSERT INTO dispositivos_has_franjahoraria (dispositivos_idDispositivos, franjaHoraria_idFranjaHoraria, nivelPrioridad) VALUES (?,?,?)";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (contadorFranja = 1; contadorFranja <= 6; contadorFranja++) { // Bucle for que recorre las 6 franjas horarias.
                String nivel = obtenerNivelPrioridad(dispositivo, franja);  // Obtiene el nivel de prioridad para el dispositivo para cada franja horaria de los ifs de abajo.
                pstmt.setInt(1, dispositivo.getId());
                pstmt.setInt(2, franja.getIdFranjaHoraria());
                pstmt.setString(3, nivel); // Convierte el nivel de prioridad a String y lo inserta en la base de datos (Óptima, Aceptable, Mala).
                pstmt.addBatch(); // Agrega la inserción a un lote (un conjunto de inserciones que se ejecutarán juntas)
            }
            int[] affectedRows = pstmt.executeBatch(); // Ejecuta todas las inserciones del lote al mismo tiempo.
            return affectedRows.length == 6; // Verifica que se hayan insertado las 6 filas
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /*
     * Madrugada: 00:00 - 04:00
     * Mañana temprano: 04:00 - 08:00
     * Mañana tardía: 08:00 - 12:00
     * Mediodía: 12:00 - 16:00
     * Tarde: 16:00 - 20:00
     * Noche: 20:00 - 00:00
     */

    /*
     *00:00 - 05:00 - Very Cheap
     * 06:00 - 08:00 - Under Avg
     * 08:00 - 14:00 - Expensive
     * 14:00 - 18:00 - Under Avg
     * 18:00 - 24:00 - Expensive
     */

    // Método que devuelve el nivel de prioridad de un dispositivo en una franja horaria.-
    public static String obtenerNivelPrioridad(Dispositivo dispositivo, FranjaHoraria franja) {
        
        if (dispositivo.getNombre() == "Frigorifico") {  // Estableciendo los niveles de prioridad para el frigorífico.
            if (franja.getIdFranjaHoraria() == 1 || franja.getIdFranjaHoraria() == 2) {
                return "Óptima";
            } else if (franja.getIdFranjaHoraria() == 3 || franja.getIdFranjaHoraria() == 5) {
                return "Mala";
            } else if (franja.getIdFranjaHoraria() == 4 || franja.getIdFranjaHoraria() == 6) {
                return "Aceptable";
            }
        } else if (dispositivo.getNombre() == "Vitroceramica") {  // Estableciendo los niveles de prioridad para la vitrocerámica.
            if (franja.getIdFranjaHoraria() == 1 || franja.getIdFranjaHoraria() == 2 || franja.getIdFranjaHoraria() == 5) {
                return "Óptima";
            } else if (franja.getIdFranjaHoraria() == 3 || franja.getIdFranjaHoraria() == 4 || franja.getIdFranjaHoraria() == 6) {
                return "Aceptable";
            }
        } else if (dispositivo.getNombre() == "Lavadora") {  // Estableciendo los niveles de prioridad para la lavadora.
            if (franja.getIdFranjaHoraria() == 1 || franja.getIdFranjaHoraria() == 2 || franja.getIdFranjaHoraria() == 5) {
                return "Mala";
            } else if (franja.getIdFranjaHoraria() == 3 || franja.getIdFranjaHoraria() == 4 || franja.getIdFranjaHoraria() == 6) {
                return "Aceptable";
            }
        } else if (dispositivo.getNombre() == "Lavavajillas") {  // Estableciendo los niveles de prioridad para el lavavajillas.
            if (franja.getIdFranjaHoraria() == 1 || franja.getIdFranjaHoraria() == 2 || franja.getIdFranjaHoraria() == 3) {
                return "Óptima";
            } else if (franja.getIdFranjaHoraria() == 4 || franja.getIdFranjaHoraria() == 5) {
                return "Aceptable";
            } else if (franja.getIdFranjaHoraria() == 6) {
                return "Mala";
            }
        } else if (dispositivo.getNombre() == "Secadora") {  // Estableciendo los niveles de prioridad para la secadora.
            if (franja.getIdFranjaHoraria() == 1 || franja.getIdFranjaHoraria() == 2 || franja.getIdFranjaHoraria() == 6) {
                return "Mala";
            } else if (franja.getIdFranjaHoraria() == 3) {
                return "Óptima";
            } else if (franja.getIdFranjaHoraria() == 4 || franja.getIdFranjaHoraria() == 5) {
                return "Aceptable";
            } 
        } else if (dispositivo.getNombre() == "Aire Acondicionado") {  // Estableciendo los niveles de prioridad para el aire acondicionado.
            if (franja.getIdFranjaHoraria() == 1 || franja.getIdFranjaHoraria() == 2 || franja.getIdFranjaHoraria() == 3) {
                return "Óptima";
            } else if (franja.getIdFranjaHoraria() == 4 || franja.getIdFranjaHoraria() == 5) {
                return "Aceptable";
            } else if (franja.getIdFranjaHoraria() == 6) {
                return "Mala";
            }
        } else if (dispositivo.getNombre() == "Televisor") {  // Estableciendo los niveles de prioridad para el televisor.
            if (franja.getIdFranjaHoraria() == 1 || franja.getIdFranjaHoraria() == 2) {
                return "Óptima";
            } else if (franja.getIdFranjaHoraria() == 3 || franja.getIdFranjaHoraria() == 4 || franja.getIdFranjaHoraria() == 5) {
                return "Aceptable";
            } else if (franja.getIdFranjaHoraria() == 6) {
                return "Mala";
            }
        } else if (dispositivo.getNombre() == "Ordenador") {  // Estableciendo los niveles de prioridad para el ordenador.
            if (franja.getIdFranjaHoraria() == 1 || franja.getIdFranjaHoraria() == 2) {
                return "Óptima";
            } else if (franja.getIdFranjaHoraria() == 3 || franja.getIdFranjaHoraria() == 4 || franja.getIdFranjaHoraria() == 5) {
                return "Aceptable";
            } else if (franja.getIdFranjaHoraria() == 6) {
                return "Mala";
            }
        }
        return null;
    }
}
