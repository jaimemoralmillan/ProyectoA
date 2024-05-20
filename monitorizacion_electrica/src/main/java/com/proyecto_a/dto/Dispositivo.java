package com.proyecto_a.dto;


import java.util.ArrayList;

public class Dispositivo {

    // atributos
    private int idDispositivo;
    private String nombre;
    private String descripcion;
    private float consumoPorHora;
    private static ArrayList<String> dispositivosDefault = new ArrayList<>();
    
    

    

    // getters y setters

    public int getId() {
        return idDispositivo;
    }

    public void setId(int idDispositivo) {
        throw new UnsupportedOperationException("No hacer 'setId', es autonumérico en la BD");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getConsumoPorHora() {
        return consumoPorHora;
    }
    public void setConsumoPorHora(float consumoPorHora) {
        this.consumoPorHora = consumoPorHora;
    }

    public static ArrayList<String> getDispositivosDefault() {
        return dispositivosDefault;
    }

    // constructores
    public Dispositivo(int idDispositivo, String nombre, String descripcion, float consumoPorHora) {
        this.idDispositivo = idDispositivo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.consumoPorHora = consumoPorHora;
    }

    public Dispositivo() {
    };


    //

     @Override
    public String toString() {

        return this.getNombre()+" "+this.getDescripcion();
    }

    //methods

    public static void rellenarArrayDispositivosDefault (){

        dispositivosDefault.add("Frigorifico");
        dispositivosDefault.add("Vitroceramica");
        dispositivosDefault.add("Lavadora");
        dispositivosDefault.add("Lavavajillas");
        dispositivosDefault.add("Secadora");
        dispositivosDefault.add("Aire Acondicionado");
        dispositivosDefault.add("Televisor");
        dispositivosDefault.add("Ordenador");
        dispositivosDefault.add("Luces");


    }
    

   

  

    
}
