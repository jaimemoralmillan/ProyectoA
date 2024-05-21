package com.proyecto_a.dto;
import java.sql.Time;
public class FranjaHoraria {
    
    private int idFranjaHoraria;
    private String descripcion;
    private String horaInicio;
    private String horaFin;
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
    public String getHoraInicio() {
        return horaInicio;
    }
    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }
    public String getHoraFin() {
        return horaFin;
    }
    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }
    public int getDispositivos_id() {
        return dispositivos_id;
    }
    public void setDispositivos_id(int dispositivos_id) {
        this.dispositivos_id = dispositivos_id;
    }

    //constructores

    public FranjaHoraria(String descripcion, String horaInicio, String horaFin) {
        this.descripcion = descripcion;
        this.horaInicio=horaInicio;
        this.horaFin=horaFin;
    }





}
