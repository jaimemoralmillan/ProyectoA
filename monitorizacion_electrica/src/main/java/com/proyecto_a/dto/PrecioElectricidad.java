package com.proyecto_a.dto;

public class PrecioElectricidad {
    
    private int id;
    private String fecha;
    private String hora;
    private float precioKwh;
    
    // public PrecioElectricidad(){
    //     id=-1;
    //     fecha="";
    //     hora="";
    //     precioKwh=-1.0f;
    // }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    public float getPrecioKwh() {
        return precioKwh;
    }
    public void setPrecioKwh(float precioKwh) {
        this.precioKwh = precioKwh;
    }  
}
