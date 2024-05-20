package com.proyecto_a.dto;

public class Categoria {

    // atributos
    private int idCategoria;
    private String[] nombre = {"A","B","C","D","E","F"};
    private String[] descripcion = new String[3];
    private String[][] categorias;
    private boolean control = false;
    private Dispositivo consumoPorHora;
    private float[] rangos = {0.0f,130.0f,162.0f,207.0f,300.0f,404.0f};
    
    // constructores
    public Categoria(String[] nombre, String[] descripcion, String[][] categorias, Dispositivo consumoPorHora, float[] rangos) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categorias = categorias;
        this.consumoPorHora = consumoPorHora;
        this.rangos = rangos;
    }

    public Categoria() {
    };

    // SETTERS
    public void setId(int idCategoria) {
        throw new UnsupportedOperationException("No hacer 'setId', es autonumérico en la BD");
    }
    public void setNombre(String[] nombre) {
        this.nombre = nombre;
    }
    public void setDescripcion(String[] descripcion) {
        this.descripcion = descripcion;
    }
    // GETTERS
    public boolean getControl() {
        return control;
    }
    public int getIdCategoria() {
        return idCategoria;
    }
    public String[] getNombre() {
        return nombre;
    }
    public String[] getDescripcion() {
        return descripcion;
    }
    public String[][] getCategorias() {
        return categorias;
    }
    public Dispositivo getConsumoPorHora() {
        return consumoPorHora;
    }
    public float[] getRangos() {
        return rangos;
    }
    //
    /*@Override
    public String toString() {
        return this.getNombre()+" "+this.getDescripcion();
    }*/
    //Metodos
    public static void rellenarCategorias (String[] nombre, String[] descripcion, String[][] categorias){
        categorias = new String[nombre.length][descripcion.length];

        for(int i=0; i<nombre.length; i++) {
            
        }

    }
}
