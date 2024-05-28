package com.proyecto_a.ui;
import java.util.List;

import javax.swing.SwingUtilities;


import com.proyecto_a.dto.PrecioElectricidad;
import com.proyecto_a.negocio.GestorMonitorizacion;
import com.proyecto_a.negocio.LectorArchivosJson;
import com.proyecto_a.dao.DispositivosDAO;
import com.proyecto_a.dao.Dispositivos_has_franjaHorariaDAO;

public class Main {
    public static void main(String[] args) {
        
        GestorMonitorizacion.insertarCategorias();
        GestorMonitorizacion.insertarFranjas();

        PrecioElectricidad precioElectricidad = new PrecioElectricidad();
        GestorMonitorizacion.extraerDatosJsonPrecios();
        GestorMonitorizacion.insertarPrecioElectricidad(precioElectricidad);

        LectorArchivosJson lectorArchivosJson = new LectorArchivosJson();
        lectorArchivosJson.extraerDatosJsonDispositivos();
        lectorArchivosJson.extraerDatosJsonEventosConsumo();

        GestorMonitorizacion.actualizarCategoriasDispositivos();
        
        List<String> nombresDispositivos = DispositivosDAO.obtenerNombresDispositivos();
        for (String nombreDispositivo : nombresDispositivos) {
            Dispositivos_has_franjaHorariaDAO.insertarFranjasParaDispositivo(nombreDispositivo);
        }
        
        SwingUtilities.invokeLater(() -> {
            MonitorizacionGUI gui = new MonitorizacionGUI();
            gui.setVisible(true);
        });
    }
}
