package com.proyecto_a.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.proyecto_a.dto.Categoria;
import com.proyecto_a.dto.Dispositivo;
import com.proyecto_a.dto.Dispositivos_has_franjaHoraria;
import com.proyecto_a.dto.FranjaHoraria;

public class CategoriaDAO {

    static int idCategoria;

    public static boolean insertarCategorias(Categoria[] categorias) {
        String sql = "INSERT INTO categoria (nombre, descripcion, franjaConsumo)" + /*Inserta las categorias en la base de datos si no existe ya en la base de datos*/
                "SELECT ?, ?, ? WHERE NOT EXISTS ("
                + "SELECT 1 FROM categoria WHERE nombre = ? AND descripcion = ? AND franjaConsumo = ?)"; /*Comprueba que no exista ya en la base de datos.*/
        try (Connection conn = Conexion.getConnection(); // Establece la conexión con la base de datos.
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (Categoria categoria : categorias) { // Recorre todas las categorias.
                pstmt.setString(1, categoria.getNombre());
                pstmt.setString(2, categoria.getDescripcion());
                pstmt.setString(3, categoria.getFranjaConsumo());
                pstmt.setString(4, categoria.getNombre());
                pstmt.setString(5, categoria.getDescripcion());
                pstmt.setString(6, categoria.getFranjaConsumo());
                pstmt.addBatch(); // Añade la sentencia SQL a la lista de sentencias a ejecutar.
            }
            int[] affectedRows = pstmt.executeBatch(); // Ejecuta la sentencia SQL.
            return affectedRows.length == categorias.length; // Devuelve true si se han insertado todas las categorias.
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    

    private static int obtenerNivelCategoria(Dispositivo dispositivo, Categoria categoria) {
        // Asignar prioridades a los dispositivos según la franja horaria.
        idCategoria = 0;
        double consumoPorHora = dispositivo.getConsumoPorHora();
        if ("Luces".equalsIgnoreCase(dispositivo.getNombre())) {
            if (dispositivo.getConsumoPorHora() >= 0.06846) {
                idCategoria = 1;
            } else if (consumoPorHora <= 0.06847 && consumoPorHora >= 0.07688) {
                idCategoria = 2;
            } else if (consumoPorHora <= 0.07689 && consumoPorHora >= 0.08530) {
                idCategoria = 3;
            } else if (consumoPorHora <= 0.08531 && consumoPorHora >= 0.09372) {
                idCategoria = 4;
            } else if (consumoPorHora <= 0.09373 && consumoPorHora >= 0.10214) {
                idCategoria = 5;
            } else if (consumoPorHora <= 0.10215 && consumoPorHora >= 0.11056) {
                idCategoria = 6;
            } else if (consumoPorHora <= 0.11057) {
                idCategoria = 7;
            }
        } else if ("Vitroceramica".equalsIgnoreCase(dispositivo.getNombre())) {
            if (dispositivo.getConsumoPorHora() >= 0.06846) {
                idCategoria = 1;
            } else if (consumoPorHora <= 0.06847 && consumoPorHora >= 0.07688) {
                idCategoria = 2;
            } else if (consumoPorHora <= 0.07689 && consumoPorHora >= 0.08530) {
                idCategoria = 3;
            } else if (consumoPorHora <= 0.08531 && consumoPorHora >= 0.09372) {
                idCategoria = 4;
            } else if (consumoPorHora <= 0.09373 && consumoPorHora >= 0.10214) {
                idCategoria = 5;
            } else if (consumoPorHora <= 0.10215 && consumoPorHora >= 0.11056) {
                idCategoria = 6;
            } else if (consumoPorHora <= 0.11057) {
                idCategoria = 7;
            }
        } else if ("Lavavajillas".equalsIgnoreCase(dispositivo.getNombre())) {
            if (dispositivo.getConsumoPorHora() >= 0.06846) {
                idCategoria = 1;
            } else if (consumoPorHora <= 0.06847 && consumoPorHora >= 0.07688) {
                idCategoria = 2;
            } else if (consumoPorHora <= 0.07689 && consumoPorHora >= 0.08530) {
                idCategoria = 3;
            } else if (consumoPorHora <= 0.08531 && consumoPorHora >= 0.09372) {
                idCategoria = 4;
            } else if (consumoPorHora <= 0.09373 && consumoPorHora >= 0.10214) {
                idCategoria = 5;
            } else if (consumoPorHora <= 0.10215 && consumoPorHora >= 0.11056) {
                idCategoria = 6;
            } else if (consumoPorHora <= 0.11057) {
                idCategoria = 7;
            }
        } else if ("Luces".equalsIgnoreCase(dispositivo.getNombre())) {
            if (dispositivo.getConsumoPorHora() >= 0.06846) {
                idCategoria = 1;
            } else if (consumoPorHora <= 0.06847 && consumoPorHora >= 0.07688) {
                idCategoria = 2;
            } else if (consumoPorHora <= 0.07689 && consumoPorHora >= 0.08530) {
                idCategoria = 3;
            } else if (consumoPorHora <= 0.08531 && consumoPorHora >= 0.09372) {
                idCategoria = 4;
            } else if (consumoPorHora <= 0.09373 && consumoPorHora >= 0.10214) {
                idCategoria = 5;
            } else if (consumoPorHora <= 0.10215 && consumoPorHora >= 0.11056) {
                idCategoria = 6;
            } else if (consumoPorHora <= 0.11057) {
                idCategoria = 7;
            }
        } else if ("Lavadora".equalsIgnoreCase(dispositivo.getNombre())) {
            if (dispositivo.getConsumoPorHora() >= 0.06846) {
                idCategoria = 1;
            } else if (consumoPorHora <= 0.06847 && consumoPorHora >= 0.07688) {
                idCategoria = 2;
            } else if (consumoPorHora <= 0.07689 && consumoPorHora >= 0.08530) {
                idCategoria = 3;
            } else if (consumoPorHora <= 0.08531 && consumoPorHora >= 0.09372) {
                idCategoria = 4;
            } else if (consumoPorHora <= 0.09373 && consumoPorHora >= 0.10214) {
                idCategoria = 5;
            } else if (consumoPorHora <= 0.10215 && consumoPorHora >= 0.11056) {
                idCategoria = 6;
            } else if (consumoPorHora <= 0.11057) {
                idCategoria = 7;
            }
        } else if ("Aires Acondicionados".equalsIgnoreCase(dispositivo.getNombre())) {
            if (dispositivo.getConsumoPorHora() >= 0.06846) {
                idCategoria = 1;
            } else if (consumoPorHora <= 0.06847 && consumoPorHora >= 0.07688) {
                idCategoria = 2;
            } else if (consumoPorHora <= 0.07689 && consumoPorHora >= 0.08530) {
                idCategoria = 3;
            } else if (consumoPorHora <= 0.08531 && consumoPorHora >= 0.09372) {
                idCategoria = 4;
            } else if (consumoPorHora <= 0.09373 && consumoPorHora >= 0.10214) {
                idCategoria = 5;
            } else if (consumoPorHora <= 0.10215 && consumoPorHora >= 0.11056) {
                idCategoria = 6;
            } else if (consumoPorHora <= 0.11057) {
                idCategoria = 7;
            }
        } else if ("Televisor".equalsIgnoreCase(dispositivo.getNombre())) {
            if (dispositivo.getConsumoPorHora() >= 0.06846) {
                idCategoria = 1;
            } else if (consumoPorHora <= 0.06847 && consumoPorHora >= 0.07688) {
                idCategoria = 2;
            } else if (consumoPorHora <= 0.07689 && consumoPorHora >= 0.08530) {
                idCategoria = 3;
            } else if (consumoPorHora <= 0.08531 && consumoPorHora >= 0.09372) {
                idCategoria = 4;
            } else if (consumoPorHora <= 0.09373 && consumoPorHora >= 0.10214) {
                idCategoria = 5;
            } else if (consumoPorHora <= 0.10215 && consumoPorHora >= 0.11056) {
                idCategoria = 6;
            } else if (consumoPorHora <= 0.11057) {
                idCategoria = 7;
            }
        } else if ("Secadora".equalsIgnoreCase(dispositivo.getNombre())) {
            if (dispositivo.getConsumoPorHora() >= 0.06846) {
                idCategoria = 1;
            } else if (consumoPorHora <= 0.06847 && consumoPorHora >= 0.07688) {
                idCategoria = 2;
            } else if (consumoPorHora <= 0.07689 && consumoPorHora >= 0.08530) {
                idCategoria = 3;
            } else if (consumoPorHora <= 0.08531 && consumoPorHora >= 0.09372) {
                idCategoria = 4;
            } else if (consumoPorHora <= 0.09373 && consumoPorHora >= 0.10214) {
                idCategoria = 5;
            } else if (consumoPorHora <= 0.10215 && consumoPorHora >= 0.11056) {
                idCategoria = 6;
            } else if (consumoPorHora <= 0.11057) {
                idCategoria = 7;
            }
        } else if ("Ordenador".equalsIgnoreCase(dispositivo.getNombre())) {
            if (dispositivo.getConsumoPorHora() >= 0.06846) {
                idCategoria = 1;
            } else if (consumoPorHora <= 0.06847 && consumoPorHora >= 0.07688) {
                idCategoria = 2;
            } else if (consumoPorHora <= 0.07689 && consumoPorHora >= 0.08530) {
                idCategoria = 3;
            } else if (consumoPorHora <= 0.08531 && consumoPorHora >= 0.09372) {
                idCategoria = 4;
            } else if (consumoPorHora <= 0.09373 && consumoPorHora >= 0.10214) {
                idCategoria = 5;
            } else if (consumoPorHora <= 0.10215 && consumoPorHora >= 0.11056) {
                idCategoria = 6;
            } else if (consumoPorHora <= 0.11057) {
                idCategoria = 7;
            }
        }
        return idCategoria;
    }

    public static List<Integer> obtenerIdCategoria() {
        List<Integer> idCategoria = new ArrayList<>();
        String obtenerIdCategoriaSQL = "SELECT idCategoria FROM categoria";

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
}
