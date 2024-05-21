package com.proyecto_a.ui;
import javax.swing.SwingUtilities;

import com.proyecto_a.dao.EventosConsumosDAO;
import com.proyecto_a.dto.EventosConsumo;
import com.proyecto_a.dto.PrecioElectricidad;
import com.proyecto_a.negocio.GestorMonitorizacion;
import com.proyecto_a.negocio.LectorArchivosJson;

public class Main {
    public static void main(String[] args) {
        GestorMonitorizacion gestorMonitorizacion = new GestorMonitorizacion();
        PrecioElectricidad precioElectricidad = new PrecioElectricidad();
        gestorMonitorizacion.extraerDatosJsonPrecios();
        gestorMonitorizacion.insertarPrecioElectricidad(precioElectricidad);

        LectorArchivosJson lectorArchivosJson = new LectorArchivosJson();
        lectorArchivosJson.extraerDatosJsonDispositivos();
        lectorArchivosJson.extraerDatosJsonEventosConsumo();
        // lectorArchivosJson.procesarJsonYGuardarEventosEnBD();
        // EventosConsumosDAO eventosConsumosDAO = new EventosConsumosDAO();
       

        SwingUtilities.invokeLater(() -> {
            MonitorizacionGUI gui = new MonitorizacionGUI();
            gui.setVisible(true);
        });
    }
}
