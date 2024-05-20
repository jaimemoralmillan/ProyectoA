package com.proyecto_a.ui;
import javax.swing.SwingUtilities;

import com.proyecto_a.dao.FranjaHorariaDAO;
import com.proyecto_a.dto.FranjaHoraria;

public class Main {
    public static void main(String[] args) {
        
        FranjaHorariaDAO dao = new FranjaHorariaDAO();
        FranjaHoraria[] franjas = {
            new FranjaHoraria("Madrugada", "00:00:00", "06:00:00"),
            new FranjaHoraria("Mañana", "06:00:00", "08:00:00"),
            new FranjaHoraria("Mañana/Tarde", "08:00:00", "14:00:00"),
            new FranjaHoraria("Tarde/Noche", "14:00:00", "18:00:00"),
            new FranjaHoraria("Noche", "18:00:00", "24:00:00")
        };
        
        boolean result = dao.insertarFranjas(franjas);
        System.out.println("Insert result: " + result);

        SwingUtilities.invokeLater(() -> {
            MonitorizacionGUI gui = new MonitorizacionGUI();
            gui.setVisible(true);
        });
    }
}


        
        
        
        