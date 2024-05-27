package com.proyecto_a.dto;

public class Categoria {
    
    private int idCategoria;
    private String nombre;
    private String descripcion;
    private String franjaConsumo; 

    public static String a = "A";
    public static String b = "B";
    public static String c = "C";
    public static String d = "D";
    public static String e = "E";
    public static String f = "F";
    public static String g = "G";
    
    public Categoria(String nombre, String descripcion, String franjaConsumo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.franjaConsumo = franjaConsumo;
    }
    public int getIdCategoria() {
        return idCategoria;
    }
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
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
    public String getFranjaConsumo() {
        return franjaConsumo;
    }
    public void setFranjaConsumo(String franjaConsumo) {
        this.franjaConsumo = franjaConsumo;
    }
    
    public static Categoria[] categorias = { // Array de categorias.
        new Categoria("A", "Bajo Consumo", ">0.06846"),
        new Categoria("B", "Bajo Consumo", "0.06847 - 0.07688"),
        new Categoria("C", "Consumo Medio", "0.07689 - 0.08530"),
        new Categoria("D", "Consumo Medio", "0.08531 - 0.09372"),
        new Categoria("E", "Consumo Medio", "0.09373 - 0.10214"),
        new Categoria("F", "Alto Consumo", "0.10215 - 0.11056"),
        new Categoria("G", "Alto Consumo", "0.11057<")
    };
    
}
