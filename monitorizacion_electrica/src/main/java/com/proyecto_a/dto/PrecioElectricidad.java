package com.proyecto_a.dto;

public class PrecioElectricidad {
    
    private int id;
    private String fechaInicio;
    private String fechaFin;
    private float precioKwh;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public float getPrecioKwh() {
        return precioKwh;
    }
    public void setPrecioKwh(float precioKwh) {
        this.precioKwh = precioKwh;
    }
   
   
}
