package com.proyecto_a.dao;
import java.sql.*;
import java.time.Duration;
import java.time.LocalDateTime;


public class EventosPrecioDAO {
    


    public static void InsertarEventosPrecio() {
        Connection connection = null;
        PreparedStatement psEventosConsumo = null;
        ResultSet rsEventosConsumo = null;
        PreparedStatement psPrecioElectricidad = null;
        ResultSet rsPrecioElectricidad = null;
        PreparedStatement psInsertEventoPrecio = null;

        try {
            connection = Conexion.getConnection();

            // Obtener datos de EventosConsumo
            String selectEventosConsumo = "SELECT idEventosConsumo, fechaInicio, fechaFin, consumoKwh FROM EventosConsumo";
            psEventosConsumo = connection.prepareStatement(selectEventosConsumo);
            rsEventosConsumo = psEventosConsumo.executeQuery();

            while (rsEventosConsumo.next()) {
                int eventId = rsEventosConsumo.getInt("idEventosConsumo");
                LocalDateTime eventStart = rsEventosConsumo.getTimestamp("fechaInicio").toLocalDateTime();
                LocalDateTime eventEnd = rsEventosConsumo.getTimestamp("fechaFin").toLocalDateTime();
                float totalKwh = rsEventosConsumo.getFloat("consumoKwh");

                // Obtener datos de PrecioElectricidad
                String selectPrecioElectricidad = "SELECT idPrecioElectricidad, fechaInicio, fechaFin, precioKwh FROM PrecioElectricidad";
                psPrecioElectricidad = connection.prepareStatement(selectPrecioElectricidad);
                rsPrecioElectricidad = psPrecioElectricidad.executeQuery();

                while (rsPrecioElectricidad.next()) {
                    int priceId = rsPrecioElectricidad.getInt("idPrecioElectricidad");
                    Timestamp tsPriceStart = rsPrecioElectricidad.getTimestamp("fechaInicio");
                    Timestamp tsPriceEnd = rsPrecioElectricidad.getTimestamp("fechaFin");
                    float price = rsPrecioElectricidad.getFloat("precioKwh");

                    if (tsPriceStart != null && tsPriceEnd != null) {
                        LocalDateTime priceStart = tsPriceStart.toLocalDateTime();
                        LocalDateTime priceEnd = tsPriceEnd.toLocalDateTime();

                        // Calcular el período superpuesto
                        LocalDateTime overlapStart = eventStart.isAfter(priceStart) ? eventStart : priceStart;
                        LocalDateTime overlapEnd = eventEnd.isBefore(priceEnd) ? eventEnd : priceEnd;

                        if (overlapStart.isBefore(overlapEnd)) {
                            long secondsInInterval = Duration.between(overlapStart, overlapEnd).getSeconds();
                            long totalEventSeconds = Duration.between(eventStart, eventEnd).getSeconds();
                            float partialKwh = (totalKwh * secondsInInterval) / totalEventSeconds;

                            // Insertar en EventoPrecio
                            String insertEventoPrecio = "INSERT INTO EventoPrecio (idEventosConsumo, idPrecioElectricidad, periodoInicio, periodoFin, consumoParcial) VALUES (?, ?, ?, ?, ?)";
                            psInsertEventoPrecio = connection.prepareStatement(insertEventoPrecio);
                            psInsertEventoPrecio.setInt(1, eventId);
                            psInsertEventoPrecio.setInt(2, priceId);
                            psInsertEventoPrecio.setTimestamp(3, Timestamp.valueOf(overlapStart));
                            psInsertEventoPrecio.setTimestamp(4, Timestamp.valueOf(overlapEnd));
                            psInsertEventoPrecio.setFloat(5, partialKwh);
                            psInsertEventoPrecio.executeUpdate();
                        }
                    } else {
                        continue;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar todos los recursos
            try {
                if (rsPrecioElectricidad != null) rsPrecioElectricidad.close();
                if (psPrecioElectricidad != null) psPrecioElectricidad.close();
                if (rsEventosConsumo != null) rsEventosConsumo.close();
                if (psEventosConsumo != null) psEventosConsumo.close();
                if (psInsertEventoPrecio != null) psInsertEventoPrecio.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


