package com.proyecto_a.dto;

public class Dispositivo {

    // atributos
    private int idDispositivo;
    private String nombre;
    private String descripcion;

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

    // constructores
    public Dispositivo(int idDispositivo, String nombre, String descripcion) {
        this.idDispositivo = idDispositivo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Dispositivo() {
    };


    //

     @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.getNombre();
    }
}
