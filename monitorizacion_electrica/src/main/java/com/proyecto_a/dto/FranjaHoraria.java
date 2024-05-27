package com.proyecto_a.dto;

public class FranjaHoraria {
    
    private int idFranjaHoraria;
    private String descripcion;
    private String horaInicio;
    private String horaFin;
    private int dispositivos_id;
    
    public static FranjaHoraria[] franjas = { // Array de franjas horarias.
        new FranjaHoraria("Madrugada", "00:00:00", "06:00:00"),
        new FranjaHoraria("Mañana", "06:00:00", "08:00:00"),
        new FranjaHoraria("Mañana/Tarde", "08:00:00", "14:00:00"),
        new FranjaHoraria("Tarde/Noche", "14:00:00", "18:00:00"),
        new FranjaHoraria("Noche", "18:00:00", "24:00:00")
    };
  
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


    public FranjaHoraria(int idFranjaHoraria) {
        this.idFranjaHoraria = idFranjaHoraria;
    }

}
