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
    
    // Insertar categorias por defecto en la base de datos
    public static boolean insertarCategorias(Categoria[] categorias) {
        String checkSql = "SELECT COUNT(*) FROM categoria WHERE nombre = ? AND descripcion = ? AND consumoMinimo = ? AND consumoMaximo = ?"; // Comprueba si la categoria ya existe en la base de datos.
        String insertSql = "INSERT INTO categoria (nombre, descripcion, consumoMinimo, consumoMaximo) VALUES (?, ?, ?, ?)"; // Inserta la categoria en la base de datos, si no existe.
        
        try (Connection conn = Conexion.getConnection()) {
            for (Categoria categoria : categorias) {
                try (PreparedStatement checkStmt = conn.prepareStatement(checkSql)) { // Comprueba si la categoria ya existe en la base de datos.
                    checkStmt.setString(1, categoria.getNombre());
                    checkStmt.setString(2, categoria.getDescripcion());
                    checkStmt.setDouble(3, categoria.getConsumoMinimo());
                    checkStmt.setDouble(4, categoria.getConsumoMaximo());
                    ResultSet rs = checkStmt.executeQuery(); 
                    if (rs.next() && rs.getInt(1) == 0) { // Si la categoria no existe, la inserta.
                        try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) { // Inserta la categoria en la base de datos, si no existe.
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
                PreparedStatement pstmt = conn.prepareStatement(obtenerIdCategoriaSQL); // Prepara la sentencia SQL.
                ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                idCategoria.add(rs.getInt("idCategoria")); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idCategoria; 
    }

    public static int obtenerNivelCategoria(Dispositivo dispositivo, Categoria categoria) { // Obtiene el nivel de la categoria.
        int idCategoria = 0;
        double consumoPorHora = dispositivo.getConsumoPorHora(); // Obtiene el consumo por hora del dispositivo.
    
        if (consumoPorHora >= 0 && consumoPorHora <= 0.05) { // Si el consumo por hora es mayor o igual a 0 y menor o igual a 0.05, se asigna el id de la categoria 1.
            idCategoria = 1; // Bajo Consumo - Franja 1
        } else if (consumoPorHora > 0.05 && consumoPorHora <= 0.1) { // Si el consumo por hora es mayor a 0.05 y menor o igual a 0.1, se asigna el id de la categoria 2.
            idCategoria = 2; // Bajo Consumo - Franja 2
        } else if (consumoPorHora > 0.1 && consumoPorHora <= 0.3) { // Si el consumo por hora es mayor a 0.1 y menor o igual a 0.3, se asigna el id de la categoria 3.
            idCategoria = 3; // Consumo Medio - Franja 3
        } else if (consumoPorHora > 0.3 && consumoPorHora <= 0.5) { // Si el consumo por hora es mayor a 0.3 y menor o igual a 0.5, se asigna el id de la categoria 4.
            idCategoria = 4; // Consumo Medio - Franja 4
        } else if (consumoPorHora > 0.5 && consumoPorHora <= 1) {  // Si el consumo por hora es mayor a 0.5 y menor o igual a 1, se asigna el id de la categoria 5.
            idCategoria = 5; // Consumo Medio - Franja 5
        } else if (consumoPorHora > 1 && consumoPorHora <= 2) { // Si el consumo por hora es mayor a 1 y menor o igual a 2, se asigna el id de la categoria 6.
            idCategoria = 6; // Alto Consumo - Franja 6
        } else if (consumoPorHora > 2 && consumoPorHora <= 3) { // Si el consumo por hora es mayor a 2 y menor o igual a 3, se asigna el id de la categoria 7.
            idCategoria = 7; // Alto Consumo - Franja 7
        }
        return idCategoria; // Devuelve el id de la categoria.
    }
    

}
