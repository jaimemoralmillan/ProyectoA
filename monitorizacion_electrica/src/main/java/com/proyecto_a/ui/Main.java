package com.proyecto_a.ui;

import javax.swing.SwingUtilities;

import com.proyecto_a.dao.FranjaHorariaDAO;
import com.proyecto_a.dto.PrecioElectricidad;
import com.proyecto_a.negocio.GestorMonitorizacion;
import com.proyecto_a.negocio.Inicializacion;
public class Main {
    public static void main(String[] args) {
        GestorMonitorizacion gestorMonitorizacion = new GestorMonitorizacion();
        PrecioElectricidad precioElectricidad = new PrecioElectricidad();
        gestorMonitorizacion.extraerDatosJson();
        gestorMonitorizacion.insertarPrecioElectricidad(precioElectricidad);
        
        FranjaHorariaDAO.insertarFranjas(Inicializacion.franjas);

        SwingUtilities.invokeLater(() -> {
            MonitorizacionGUI gui = new MonitorizacionGUI();
            gui.setVisible(true);
        });
    }
}
