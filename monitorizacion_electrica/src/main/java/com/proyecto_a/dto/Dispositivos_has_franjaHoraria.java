package com.proyecto_a.dto;

public class Dispositivos_has_franjaHoraria {

    private int idFranjaHoraria;
    private int idDispositivo;
    private String nivelPrioridad;
    private String descripcion;
    private String horaInicio;
    private String horaFin;

    
    public Dispositivos_has_franjaHoraria(String descripcion, String nivelPrioridad, String horaInicio, String horaFin) {
        this.descripcion = descripcion;
        this.nivelPrioridad = nivelPrioridad;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }
    
    public static String optimo = "Óptima";
    public static String aceptable = "Aceptable";
    public static String mala = "Mala";
    public static String siempreEncendido = "Siempre encendido";

    public int getIdFranjaHoraria() {
        return idFranjaHoraria;
    }
    public void setIdFranjaHoraria(int idFranjaHoraria) {
        this.idFranjaHoraria = idFranjaHoraria;
    }
    public int getIdDispositivo() {
        return idDispositivo;
    }
    public void setIdDispositivo(int idDispositivo) {
        this.idDispositivo = idDispositivo;
    }
    public String getNivelPrioridad() {
        return nivelPrioridad;
    }
    public void setNivelPrioridad(String nivelPrioridad) {
        this.nivelPrioridad = nivelPrioridad;
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
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "De: " + horaInicio + " a " + horaFin + ", Nivel de Prioridad: " + nivelPrioridad; // Devuelve la descripción y el nivel de prioridad de la franja horaria.
    }
}