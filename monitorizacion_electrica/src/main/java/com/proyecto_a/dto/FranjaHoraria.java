package com.proyecto_a.dto;
import java.sql.Time;
public class FranjaHoraria {
    
    private int idFranjaHoraria;
    private String descripcion;
    private Time horaInicio;
    private Time horaFin;
    private int dispositivos_id;
    
    public int getIdFranjaHoraria() {
        return idFranjaHoraria;
    }
    public void setIdFranjaHoraria(int idFranjaHoraria) {
        this.idFranjaHoraria = idFranjaHoraria;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Time getHoraInicio() {
        return horaInicio;
    }
    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }
    public Time getHoraFin() {
        return horaFin;
    }
    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }
    public int getDispositivos_id() {
        return dispositivos_id;
    }
    public void setDispositivos_id(int dispositivos_id) {
        this.dispositivos_id = dispositivos_id;
    }





}
