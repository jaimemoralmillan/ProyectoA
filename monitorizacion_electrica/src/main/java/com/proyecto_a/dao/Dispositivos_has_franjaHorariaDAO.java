package com.proyecto_a.dao;

import java.sql.*;

import com.proyecto_a.dto.Dispositivo;
import com.proyecto_a.dto.Dispositivos_has_franjaHoraria;
import com.proyecto_a.dto.FranjaHoraria;

public class Dispositivos_has_franjaHorariaDAO {

    static String prioridad;

    public static void insertarFranjasParaDispositivo(String nombreDispositivo) {
        try (Connection conn = Conexion.getConnection()) {
            // Obtener los IDs de los dispositivos a partir de su nombre
            String obtenerIdDispositivoSQL = "SELECT idDispositivo FROM Dispositivos WHERE nombre = ?";
            
            try (PreparedStatement pstmt = conn.prepareStatement(obtenerIdDispositivoSQL)) {
                pstmt.setString(1, nombreDispositivo);
                
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        int idDispositivo = rs.getInt("idDispositivo");
                        insertarFranjas(conn, idDispositivo, nombreDispositivo);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertarFranjas(Connection conn, int idDispositivo, String nombreDispositivo) throws SQLException {
        // Verificar e insertar registros en la tabla Dispositivos_has_franjaHoraria para las franjas horarias 1 a 5
        String verificarExistenciaSQL = "SELECT COUNT(*) FROM Dispositivos_has_franjaHoraria WHERE idDispositivo = ? AND idFranjaHoraria = ?";
        String insertarFranjaSQL = "INSERT INTO Dispositivos_has_franjaHoraria (idDispositivo, idFranjaHoraria, nivelPrioridad) VALUES (?, ?, ?)";
    
        try (PreparedStatement pstmtVerificar = conn.prepareStatement(verificarExistenciaSQL);
             PreparedStatement pstmtInsertar = conn.prepareStatement(insertarFranjaSQL)) {
            
            for (int idFranja = 1; idFranja <= 5; idFranja++) {
                // Verificar si la combinación ya existe
                pstmtVerificar.setInt(1, idDispositivo);
                pstmtVerificar.setInt(2, idFranja);
                
                try (ResultSet rs = pstmtVerificar.executeQuery()) {
                    rs.next();
                    int count = rs.getInt(1);
                    if (count == 0) {
                        // Crear objetos Dispositivo y FranjaHoraria para obtener la prioridad
                        Dispositivo dispositivo = new Dispositivo(idDispositivo, nombreDispositivo);
                        FranjaHoraria franja = new FranjaHoraria(idFranja);
                        String prioridad = obtenerNivelPrioridad(dispositivo, franja);
    
                        // Establecer los valores para la inserción
                        pstmtInsertar.setInt(1, idDispositivo);
                        pstmtInsertar.setInt(2, idFranja);
                        pstmtInsertar.setString(3, prioridad);
    
                        pstmtInsertar.executeUpdate();
                    }
                }
            }
        }
    }
    

    private static String obtenerNivelPrioridad(Dispositivo dispositivo, FranjaHoraria franja) {
        // Asignar prioridades a los dispositivos según la franja horaria.
        prioridad = "Default";

        if ("Frigorifico".equalsIgnoreCase(dispositivo.getNombre())) {
            if (franja.getIdFranjaHoraria() >= 1 && franja.getIdFranjaHoraria() <= 5) {
                prioridad = Dispositivos_has_franjaHoraria.siempreEncendido;
            }
        } else if ("Vitroceramica".equalsIgnoreCase(dispositivo.getNombre())) {
            if (franja.getIdFranjaHoraria() == 1) {
                prioridad = Dispositivos_has_franjaHoraria.optimo;
            } else if (franja.getIdFranjaHoraria() == 2 || franja.getIdFranjaHoraria() == 4) {
                prioridad = Dispositivos_has_franjaHoraria.aceptable;
            } else if (franja.getIdFranjaHoraria() == 3 || franja.getIdFranjaHoraria() == 5) {
                prioridad = Dispositivos_has_franjaHoraria.mala;
            }
        } else if ("Lavavajillas".equalsIgnoreCase(dispositivo.getNombre())) {
            if (franja.getIdFranjaHoraria() == 1) {
                prioridad = Dispositivos_has_franjaHoraria.optimo;
            } else if (franja.getIdFranjaHoraria() == 2 || franja.getIdFranjaHoraria() == 4) {
                prioridad = Dispositivos_has_franjaHoraria.aceptable;
            } else if (franja.getIdFranjaHoraria() == 3 || franja.getIdFranjaHoraria() == 5) {
                prioridad = Dispositivos_has_franjaHoraria.mala;
            }
        } else if ("Luces".equalsIgnoreCase(dispositivo.getNombre())) {
            if (franja.getIdFranjaHoraria() == 1 || franja.getIdFranjaHoraria() == 3) {
                prioridad = Dispositivos_has_franjaHoraria.mala;
            } else if (franja.getIdFranjaHoraria() == 2) {
                prioridad = Dispositivos_has_franjaHoraria.optimo;
            } else if (franja.getIdFranjaHoraria() == 4 || franja.getIdFranjaHoraria() == 5) {
                prioridad = Dispositivos_has_franjaHoraria.aceptable;
            }
        } else if ("Lavadora".equalsIgnoreCase(dispositivo.getNombre())) {
            if (franja.getIdFranjaHoraria() == 1 || franja.getIdFranjaHoraria() == 3 || franja.getIdFranjaHoraria() == 5) {
                prioridad = Dispositivos_has_franjaHoraria.mala;
            } else if (franja.getIdFranjaHoraria() == 2) {
                prioridad = Dispositivos_has_franjaHoraria.aceptable;
            } else if (franja.getIdFranjaHoraria() == 4) {
                prioridad = Dispositivos_has_franjaHoraria.optimo;
            }
        } else if ("Aires Acondicionados".equalsIgnoreCase(dispositivo.getNombre())) {
            if (franja.getIdFranjaHoraria() == 1) {
                prioridad = Dispositivos_has_franjaHoraria.optimo;
            } else if (franja.getIdFranjaHoraria() == 2 || franja.getIdFranjaHoraria() == 4) {
                prioridad = Dispositivos_has_franjaHoraria.aceptable;
            } else if (franja.getIdFranjaHoraria() == 3 || franja.getIdFranjaHoraria() == 5) {
                prioridad = Dispositivos_has_franjaHoraria.mala;
            }
        } else if ("Televisor".equalsIgnoreCase(dispositivo.getNombre())) {
            if (franja.getIdFranjaHoraria() == 1 || franja.getIdFranjaHoraria() == 2) {
                prioridad = Dispositivos_has_franjaHoraria.aceptable;
            } else if (franja.getIdFranjaHoraria() == 3 || franja.getIdFranjaHoraria() == 5) {
                prioridad = Dispositivos_has_franjaHoraria.mala;
            } else if (franja.getIdFranjaHoraria() == 4) {
                prioridad = Dispositivos_has_franjaHoraria.optimo;
            }
        } else if ("Secadora".equalsIgnoreCase(dispositivo.getNombre())) {
            if (franja.getIdFranjaHoraria() == 1 || franja.getIdFranjaHoraria() == 3 || franja.getIdFranjaHoraria() == 5) {
                prioridad = Dispositivos_has_franjaHoraria.mala;
            } else if (franja.getIdFranjaHoraria() == 2) {
                prioridad = Dispositivos_has_franjaHoraria.aceptable;
            } else if (franja.getIdFranjaHoraria() == 4) {
                prioridad = Dispositivos_has_franjaHoraria.optimo;
            }
        } else if ("Ordenador".equalsIgnoreCase(dispositivo.getNombre())) {
            if (franja.getIdFranjaHoraria() == 1 || franja.getIdFranjaHoraria() == 2 || franja.getIdFranjaHoraria() == 3) {
                prioridad = Dispositivos_has_franjaHoraria.aceptable;
            } else if (franja.getIdFranjaHoraria() == 4) {
                prioridad = Dispositivos_has_franjaHoraria.optimo;
            } else if (franja.getIdFranjaHoraria() == 5) {
                prioridad = Dispositivos_has_franjaHoraria.mala;
            }
        }
        return prioridad;
    }
}