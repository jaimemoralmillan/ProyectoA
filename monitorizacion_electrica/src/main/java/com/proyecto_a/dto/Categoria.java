package com.proyecto_a.dto;

public class Categoria {
    
    private int idCategoria;
    private String nombre;
    private String descripcion;
    private double consumoMinimo;
    private double consumoMaximo;

    public Categoria(String nombre, String descripcion, double consumoMinimo, double consumoMaximo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.consumoMinimo = consumoMinimo;
        this.consumoMaximo = consumoMaximo;
    }

    public static String a = "A";
    public static String b = "B";
    public static String c = "C";
    public static String d = "D";
    public static String e = "E";
    public static String f = "F";
    public static String g = "G";
    
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
    public double getConsumoMinimo() {
        return consumoMinimo;
    }
    public void setConsumoMinimo(double consumoMinimo) {
        this.consumoMinimo = consumoMinimo;
    }
    public double getConsumoMaximo() {
        return consumoMaximo;
    }
    public void setConsumoMaximo(double consumoMaximo) {
        this.consumoMaximo = consumoMaximo;
    }
    
    public static Categoria[] categorias = {
        new Categoria(a, "Bajo Consumo", 0.0, 0.05),
        new Categoria(b, "Bajo Consumo", 0.051, 0.1),
        new Categoria(c, "Consumo Medio", 0.101, 0.3),
        new Categoria(d, "Consumo Medio", 0.301, 0.5),
        new Categoria(e, "Consumo Medio", 0.501, 1.0),
        new Categoria(f, "Alto Consumo", 1.001, 2.0),
        new Categoria(g, "Alto Consumo", 2.001, 3.0)
    };
}

    /*public static Categoria[] categorias = { // Array de categorias.
        new Categoria("A", "Bajo Consumo", ">0.06846"),
        new Categoria("B", "Bajo Consumo", "0.06847 - 0.07688"),
        new Categoria("C", "Consumo Medio", "0.07689 - 0.08530"),
        new Categoria("D", "Consumo Medio", "0.08531 - 0.09372"),
        new Categoria("E", "Consumo Medio", "0.09373 - 0.10214"),
        new Categoria("F", "Alto Consumo", "0.10215 - 0.11056"),
        new Categoria("G", "Alto Consumo", "0.11057<")
    };*/

