package com.proyecto_a.dto;
import java.util.Date;
import java.sql.Time;



public class PrecioElectricidad {
    

    private int idprecioElectricidad;
    private float precioKwh;
    private Date fecha;
    private Time hora;

    public int getIdprecioElectricidad() {
        return idprecioElectricidad;
    }
    public void setIdprecioElectricidad(int idprecioElectricidad) {
        this.idprecioElectricidad = idprecioElectricidad;
    }
    public float getPrecioKwh() {
        return precioKwh;
    }
    public void setPrecioKwh(float precioKwh) {
        this.precioKwh = precioKwh;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Time getHora() {
        return hora;
    }
    public void setHora(Time hora) {
        this.hora = hora;
    }
    
}
