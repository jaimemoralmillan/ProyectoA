package com.proyecto_a.dao;

import com.proyecto_a.dto.Dispositivo;

import java.util.ArrayList;
import java.sql.*;

public class DispositivosDAO {

    // Crear un dispositivo
    public boolean insertarDispositivo(Dispositivo dispositivo) {
        String sql = "INSERT INTO dispositivos (nombre,descripcion) VALUES (?,?)";
        try (Connection conn = Conexion.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, dispositivo.getNombre());
            pstmt.setString(2, dispositivo.getDescripcion());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // eliminar un dispositivo

    public static boolean eliminarDispositivo(int id) {

        String sql = "DELETE FROM dispositivos WHERE idDispositivo = ?";

        try (

            Connection conn = Conexion.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();
            return false;

        }
    }

    //modificar la descripcion de un dispositivo (modificarDispositivo)

    public static boolean modificarDescripcionDispositivo(int id, String descripcion) {

        String sql = "UPDATE dispositivos SET descripcion= ? WHERE idDispositivo = ?";

        try (

            Connection conn = Conexion.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, descripcion);
            pstmt.setInt(2, id);
            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();
            return false;

        }
    }


    // obtener todos los dispositivos

    public static ArrayList<Dispositivo> obtenerTodosDispositivos() {

        String SQL = "SELECT * FROM dispositivos";

        try (Connection conn = Conexion.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(SQL);
                ResultSet rs = pstmt.executeQuery();) {

            ArrayList<Dispositivo> dispositivos = new ArrayList<>();

            while (rs.next()) {

                dispositivos.add(new Dispositivo(rs.getInt("IdDispositivo"), rs.getString("nombre"),
                        rs.getString("descripcion")));
            }

            return dispositivos;

        } catch (SQLException e) {

            e.printStackTrace();
            return null;
        }

    }

}
