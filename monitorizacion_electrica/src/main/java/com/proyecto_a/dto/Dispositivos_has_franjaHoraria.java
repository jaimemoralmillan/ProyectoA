
package com.proyecto_a.dto;

public class Dispositivos_has_franjaHoraria {
    
    private int dispositivos_id;
    private int franjaHoraria_id;
    
    public String nivelPrioridad;

    public int getDispositivos_id() {
        return dispositivos_id;
    }
    public void setDispositivos_id(int dispositivos_id) {
        this.dispositivos_id = dispositivos_id;
    }
    public int getFranjaHoraria_id() {
        return franjaHoraria_id;
    }
    public void setFranjaHoraria_id(int franjaHoraria_id) {
        this.franjaHoraria_id = franjaHoraria_id;
    }
}
