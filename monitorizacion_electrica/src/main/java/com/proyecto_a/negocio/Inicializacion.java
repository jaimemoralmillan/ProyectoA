package com.proyecto_a.negocio;

import com.proyecto_a.dao.FranjaHorariaDAO;
import com.proyecto_a.dto.FranjaHoraria;

public class Inicializacion {
    
    public FranjaHorariaDAO dao = new FranjaHorariaDAO();
        public static FranjaHoraria[] franjas = {
            new FranjaHoraria("Madrugada", "00:00:00", "06:00:00"),
            new FranjaHoraria("Mañana", "06:00:00", "08:00:00"),
            new FranjaHoraria("Mañana/Tarde", "08:00:00", "14:00:00"),
            new FranjaHoraria("Tarde/Noche", "14:00:00", "18:00:00"),
            new FranjaHoraria("Noche", "18:00:00", "24:00:00")
        };
}
