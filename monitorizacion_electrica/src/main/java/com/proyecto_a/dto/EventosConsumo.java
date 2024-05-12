package com.proyecto_a.dto;

import java.util.Date;

public class EventosConsumo {
    
    private int idEventosConsumo;
    private Date fechaInicio;
    private float consumoKwh;
    private float precioTotal;
    private int dispositivos_id ;

    public int getIdEventosConsumo() {
        return idEventosConsumo;
    }
    public void setIdEventosConsumo(int idEventosConsumo) {
        this.idEventosConsumo = idEventosConsumo;
    }
    public Date getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public float getConsumoKwh() {
        return consumoKwh;
    }
    public void setConsumoKwh(float consumoKwh) {
        this.consumoKwh = consumoKwh;
    }
    public float getPrecioTotal() {
        return precioTotal;
    }
    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }
    public int getDispositivos_id() {
        return dispositivos_id;
    }
    public void setDispositivos_id(int dispositivos_id) {
        this.dispositivos_id = dispositivos_id;
    }

}
