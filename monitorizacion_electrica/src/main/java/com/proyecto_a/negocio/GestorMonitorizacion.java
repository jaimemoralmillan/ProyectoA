package com.proyecto_a.negocio;


import com.proyecto_a.dao.DispositivosDAO;
import com.proyecto_a.dao.PrecioElectricidadDAO;
import com.proyecto_a.dto.Dispositivo;
import com.proyecto_a.dto.PrecioElectricidad;


public class GestorMonitorizacion {
    
    private DispositivosDAO dispositivoDAO = new DispositivosDAO();
    private LectorArchivosJson lectorArchivosJson = new LectorArchivosJson();
    private PrecioElectricidadDAO precioElectricidadDAO = new PrecioElectricidadDAO();

    // Métodos para dispositivos
    public boolean agregarDispositivo(Dispositivo dispositivo) {
        return dispositivoDAO.insertarDispositivo(dispositivo);
    }

    // Métodos para leer e insertar datos de un json en la BD
    public PrecioElectricidad extraerDatosJsonPrecios() {
        return lectorArchivosJson.extraerDatosJsonPreciosElectricidad();
    }
    public boolean insertarPrecioElectricidad(PrecioElectricidad precioElectricidad) {
        return precioElectricidadDAO.insertarPrecioElectricidad(precioElectricidad);
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
