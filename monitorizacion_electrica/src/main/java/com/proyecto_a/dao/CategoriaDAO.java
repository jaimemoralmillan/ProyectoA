package com.proyecto_a.dao;

import com.proyecto_a.dto.Categoria;
import java.sql.*;

public class CategoriaDAO {

    // Crear una categoria
    public boolean insertarCategoria(Categoria categoria) {
        String sql = "INSERT INTO categorias (nombre,descripcion) VALUES (?,?)";

        try (Connection conn = Conexion.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, categoria.getNombre());
            pstmt.setString(2, categoria.getDescripcion());
            
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //modificar la descripcion de una dispositivo

    public static boolean modificarDescripcionCategoria(Categoria categoria) {

        String sql = "UPDATE categorias SET descripcion= ? WHERE idCategoria = ?";

        try (
            Connection conn = Conexion.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, categoria.getDescripcion());
            pstmt.setInt(2, categoria.getIdCategoria());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();
            return false;

        }
    }
}