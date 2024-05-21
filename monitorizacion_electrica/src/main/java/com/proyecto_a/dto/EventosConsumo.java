package com.proyecto_a.dto;

public class EventosConsumo {
    
    private int idEventosConsumo;
    private String fechaInicio;
    private String fechaFin;
    private float consumoKwh;
    private int idDispositivo;
    
    public int getIdEventosConsumo() {
        return idEventosConsumo;
    }
    public void setIdEventosConsumo(int idEventosConsumo) {
        this.idEventosConsumo = idEventosConsumo;
    }
    public String getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public String getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
    public float getConsumoKwh() {
        return consumoKwh;
    }
    public void setConsumoKwh(float consumoKwh) {
        this.consumoKwh = consumoKwh;
    }
    public int getIdDispositivo() {
        return idDispositivo;
    }
    public void setIdDispositivo(int idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    
    

    

}
