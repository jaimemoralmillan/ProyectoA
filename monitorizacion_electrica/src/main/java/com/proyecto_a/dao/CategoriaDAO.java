package com.proyecto_a.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.proyecto_a.dto.Categoria;
import com.proyecto_a.dto.Dispositivo;

public class CategoriaDAO {

    static int idCategoria;

    public static boolean insertarCategorias(Categoria[] categorias) {
        String checkSql = "SELECT COUNT(*) FROM categoria WHERE nombre = ? AND descripcion = ? AND consumoMinimo = ? AND consumoMaximo = ?";
        String insertSql = "INSERT INTO categoria (nombre, descripcion, consumoMinimo, consumoMaximo) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = Conexion.getConnection()) {
            for (Categoria categoria : categorias) {
                try (PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {
                    checkStmt.setString(1, categoria.getNombre());
                    checkStmt.setString(2, categoria.getDescripcion());
                    checkStmt.setDouble(3, categoria.getConsumoMinimo());
                    checkStmt.setDouble(4, categoria.getConsumoMaximo());
                    ResultSet rs = checkStmt.executeQuery();
                    if (rs.next() && rs.getInt(1) == 0) {
                        try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
                            insertStmt.setString(1, categoria.getNombre());
                            insertStmt.setString(2, categoria.getDescripcion());
                            insertStmt.setDouble(3, categoria.getConsumoMinimo());
                            insertStmt.setDouble(4, categoria.getConsumoMaximo());
                            insertStmt.executeUpdate();
                        }
                    }
                }
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<Integer> obtenerIdCategoria() { // Obtiene el id de la categoria.
        List<Integer> idCategoria = new ArrayList<>();
        String obtenerIdCategoriaSQL = "SELECT idCategoria FROM categoria"; // Selecciona el id de la categoria de la tabla categoria.

        try (Connection conn = Conexion.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(obtenerIdCategoriaSQL);
                ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                idCategoria.add(rs.getInt("idCategoria")); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idCategoria; 
    }

    public static int obtenerNivelCategoria(Dispositivo dispositivo, Categoria categoria) {
        int idCategoria = 0;
        double consumoPorHora = dispositivo.getConsumoPorHora();
    
        if (consumoPorHora >= 0 && consumoPorHora <= 0.05) {
            idCategoria = 1; // Bajo Consumo - Franja 1
        } else if (consumoPorHora > 0.05 && consumoPorHora <= 0.1) {
            idCategoria = 2; // Bajo Consumo - Franja 2
        } else if (consumoPorHora > 0.1 && consumoPorHora <= 0.3) {
            idCategoria = 3; // Consumo Medio - Franja 3
        } else if (consumoPorHora > 0.3 && consumoPorHora <= 0.5) {
            idCategoria = 4; // Consumo Medio - Franja 4
        } else if (consumoPorHora > 0.5 && consumoPorHora <= 1) {
            idCategoria = 5; // Consumo Medio - Franja 5
        } else if (consumoPorHora > 1 && consumoPorHora <= 2) {
            idCategoria = 6; // Alto Consumo - Franja 6
        } else if (consumoPorHora > 2 && consumoPorHora <= 3) {
            idCategoria = 7; // Alto Consumo - Franja 7
        }
        return idCategoria;
    }
    

}
