package com.proyecto_a.dto;

public class Dispositivos_has_franjaHoraria {

    private int idFranjaHoraria;
    private int idDispositivo;
    private String nivelPrioridad;

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
}