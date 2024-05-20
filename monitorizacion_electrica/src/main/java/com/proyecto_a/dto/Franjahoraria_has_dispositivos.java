
package com.proyecto_a.dto;

public class Franjahoraria_has_dispositivos {
    private int franjaHoraria_id;
    private int dispositivos_id;
    private String nivelPrioridad;

    public String getNivelPrioridad() {
        return nivelPrioridad;
    }
    public void setNivelPrioridad(String nivelPrioridad) {
        this.nivelPrioridad = nivelPrioridad;
    }
    public int getFranjaHoraria_id() {
        return franjaHoraria_id;
    }
    public void setFranjaHoraria_id(int franjaHoraria_id) {
        this.franjaHoraria_id = franjaHoraria_id;
    }
    public int getDispositivos_id() {
        return dispositivos_id;
    }
    public void setDispositivos_id(int dispositivos_id) {
        this.dispositivos_id = dispositivos_id;
    }
    
}
