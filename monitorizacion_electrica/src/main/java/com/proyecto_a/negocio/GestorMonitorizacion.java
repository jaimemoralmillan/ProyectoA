package com.proyecto_a.negocio;

import com.proyecto_a.dao.CategoriaDAO;
import com.proyecto_a.dao.DispositivosDAO;
import com.proyecto_a.dao.FranjaHorariaDAO;
import com.proyecto_a.dao.PrecioElectricidadDAO;
import com.proyecto_a.dto.Categoria;
import com.proyecto_a.dto.Dispositivo;
import com.proyecto_a.dto.FranjaHoraria;
import com.proyecto_a.dto.PrecioElectricidad;


public class GestorMonitorizacion {
    
   
    // Métodos para dispositivos
        //Método que el usuario agregue un nuevo dispositivo mediante la UI
    public static boolean agregarDispositivo(Dispositivo dispositivo) {
        return DispositivosDAO.insertarDispositivo(dispositivo);
    }

    //Métodos para franjahoraria

        //agregar franjas horarias por defecto a la bdd
        public static void insertarFranjas(){
            FranjaHorariaDAO.insertarFranjas(FranjaHoraria.franjas);
        }
        
    //Metodos para categoria

        //agregar categorias por defecto a la bdd
        public static void insertarCategorias(){
            CategoriaDAO.insertarCategorias(Categoria.categorias);
        }
        

    // Métodos para leer e insertar datos de un json en la BD

        //Método para extraer datos del JSON de los precios de electricidad
    public static PrecioElectricidad extraerDatosJsonPrecios() {
        return LectorArchivosJson.extraerDatosJsonPreciosElectricidad();
    }

        //Método para insertar en la BDD los precios de electricidad
    public static boolean insertarPrecioElectricidad(PrecioElectricidad precioElectricidad) {
        return PrecioElectricidadDAO.insertarPrecioElectricidad(precioElectricidad);
    }


    /*  Métodos para Libros
    public boolean agregarLibro(Libro libro) {
        return libroDAO.insertarLibro(libro);
    }

    // Métodos para relaciones AutorLibro
    public boolean agregarAutorLibro(AutorLibro autorLibro) {
        return autorLibroDAO.insertarAutorLibro(autorLibro);
    }

    // Método para asociar un autor con un libro
    public boolean asociarAutorConLibro(int autorId, int libroId) {
        AutorLibro autorLibro = new AutorLibro(autorId, libroId);
        return autorLibroDAO.insertarAutorLibro(autorLibro);
    } */
}
