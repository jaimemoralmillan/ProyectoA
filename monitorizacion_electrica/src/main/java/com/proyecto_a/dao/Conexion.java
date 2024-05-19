package com.proyecto_a.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static Connection connection = null;

    private static final String URL = "jdbc:mysql://localhost:3306/monitorizacion";
    private static final String USER = "root";
    private static final String PASSWORD = "Angela.digitech23";

    private Conexion() {
    }

    public static Connection getConnection() throws SQLException {
        // Revisar si la conexión está cerrada y reconectar si es necesario
        try {
            if (connection == null || connection.isClosed()) {
                reconnect();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            reconnect(); // Intentar reconectar si la verificación falla
        }
        return connection;
    }

    private static void reconnect() throws SQLException {
        closeConnection(); // Cerrar la conexión actual si está abierta
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver not found", e);
        }
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error closing the connection: " + e.getMessage());
            }
            connection = null;
        }
    }
}

    

