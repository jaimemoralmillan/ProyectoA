package com.proyecto_a.dto;
public class EventosPrecio {
    
    private int idEventoPrecio ;
    private int idEventosConsumo;
    private int idPrecioElectricidad;
    private  String periodoInicio;
    private  String periodoFin;
    private  float consumoParcial;
        
    public static String[] diasDeMayo = {
        "2024-05-01", "2024-05-02", "2024-05-03", "2024-05-04", "2024-05-05",
        "2024-05-06", "2024-05-07", "2024-05-08", "2024-05-09", "2024-05-10",
        "2024-05-11", "2024-05-12", "2024-05-13", "2024-05-14", "2024-05-15",
        "2024-05-16", "2024-05-17", "2024-05-18", "2024-05-19", "2024-05-20",
        "2024-05-21", "2024-05-22", "2024-05-23", "2024-05-24", "2024-05-25",
        "2024-05-26", "2024-05-27", "2024-05-28", "2024-05-29", "2024-05-30",
        "2024-05-31"
    }; 


    public int getIdEventoPrecio() {
        return idEventoPrecio;
    }
    public void setIdEventoPrecio(int idEventoPrecio) {
        this.idEventoPrecio = idEventoPrecio;
    }
    public int getIdEventosConsumo() {
        return idEventosConsumo;
    }
    public void setIdEventosConsumo(int idEventosConsumo) {
        this.idEventosConsumo = idEventosConsumo;
    }
    public int getIdPrecioElectricidad() {
        return idPrecioElectricidad;
    }
    public void setIdPrecioElectricidad(int idPrecioElectricidad) {
        this.idPrecioElectricidad = idPrecioElectricidad;
    }
    public String getPeriodoInicio() {
        return periodoInicio;
    }
    public void setPeriodoInicio(String periodoInicio) {
        this.periodoInicio = periodoInicio;
    }
    public String getPeriodoFin() {
        return periodoFin;
    }
    public void setPeriodoFin(String periodoFin) {
        this.periodoFin = periodoFin;
    }
    public float getConsumoParcial() {
        return consumoParcial;
    }
    public void setConsumoParcial(float consumoParcial) {
        this.consumoParcial = consumoParcial;
    }





}
