package com.proyecto_a.dao;

import com.proyecto_a.dto.Dispositivo;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class DispositivosDAO {

    // Insertar dispositivo desde el archivo json
    public boolean insertarDispositivoDesdeJson(Dispositivo dispositivo) {
        int affectedRows = 0;
        String sql = "INSERT INTO dispositivos (nombre,descripcion, consumoPorHora) VALUES (?,?,?)";
        String selectSQL = "SELECT COUNT(*) FROM dispositivos WHERE descripcion = ?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                PreparedStatement pstmtSelect = conn.prepareStatement(selectSQL)) {

            if (dispositivo != null && dispositivo.getDescripcion() != null) {
                pstmtSelect.setString(1, dispositivo.getDescripcion());
                ResultSet rsDescripcion = pstmtSelect.executeQuery();
                rsDescripcion.next();
                int count = rsDescripcion.getInt(1);

                if (count == 0) {
                    pstmt.setString(1, dispositivo.getNombre());
                    pstmt.setString(2, dispositivo.getDescripcion());
                    pstmt.setFloat(3, dispositivo.getConsumoPorHora());
                    affectedRows = pstmt.executeUpdate();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return affectedRows > 0;
    }

    // Crear un dispositivo el usuario
    public static boolean insertarDispositivo(Dispositivo dispositivo) {
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

        String sql = "DELETE FROM dispositivos where idDispositivo = ?";

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

    // modificar la descripcion de un dispositivo (modificarDispositivo)

    public static boolean modificarDescripcionDispositivo(int id, String descripcion) {

        String sql = "UPDATE dispositivos SET descripcion= ? where idDispositivo = ?";

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

        String SQL = "Select * from dispositivos";

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

    // Prueba Nicklas para Franjas

    public static List<String> obtenerNombresDispositivos() {
        List<String> nombresDispositivos = new ArrayList<>();
        String obtenerNombresSQL = "SELECT nombre FROM dispositivos";

        try (Connection conn = Conexion.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(obtenerNombresSQL);
                ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                nombresDispositivos.add(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nombresDispositivos;
    }

    // Prueba Nicklas para Categorias

    public static boolean modificarCategoriaDispositivo(int id, int idCategoria) {

        String sql = "UPDATE dispositivos SET idCategoria = ? where idDispositivo = ?";
        try (Connection conn = Conexion.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idCategoria);
            pstmt.setInt(2, id);
            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();
            return false;

        }
    }
}
