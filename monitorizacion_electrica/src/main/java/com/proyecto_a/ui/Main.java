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
        
       // PrecioElectricidad precioElectricidad = new PrecioElectricidad();
       // GestorMonitorizacion.extraerDatosJsonPrecios();
        //GestorMonitorizacion.insertarPrecioElectricidad(precioElectricidad);

       // LectorArchivosJson lectorArchivosJson = new LectorArchivosJson();
        //lectorArchivosJson.extraerDatosJsonDispositivos();
        //lectorArchivosJson.extraerDatosJsonEventosConsumo();
        
        
        GestorMonitorizacion.insertarFranjas();
        List<String> nombresDispositivos = DispositivosDAO.obtenerNombresDispositivos();
        for (String nombreDispositivo : nombresDispositivos) {
            Dispositivos_has_franjaHorariaDAO.insertarFranjasParaDispositivo(nombreDispositivo);
        }

        //LectorArchivosJson lectorArchivosJson = new LectorArchivosJson();
        //lectorArchivosJson.extraerDatosJsonEventosConsumo();
        // lectorArchivosJson.procesarJsonYGuardarEventosEnBD();
         //EventosConsumosDAO eventosConsumosDAO = new EventosConsumosDAO();
       

        SwingUtilities.invokeLater(() -> {
            MonitorizacionGUI gui = new MonitorizacionGUI();
            gui.setVisible(true);
        });
    }
}
