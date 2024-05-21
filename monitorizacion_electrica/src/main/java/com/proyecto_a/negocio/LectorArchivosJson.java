package com.proyecto_a.negocio;
import java.io.FileReader;
//import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;

import com.google.gson.Gson;
//import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
//import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.proyecto_a.dao.EventosConsumosDAO;
import com.proyecto_a.dao.PrecioElectricidadDAO;
import com.proyecto_a.dto.EventosConsumo;
import com.proyecto_a.dto.PrecioElectricidad;



public class LectorArchivosJson {
    private static boolean insertado = false;
     public static PrecioElectricidad extraerDatosJsonPreciosElectricidad(PrecioElectricidad precioElectricidad){
       
        
        //FileReader abre el archivo json para lectura y el JsonParser.parseReader  utiliza gson para parsear el archivo json en un objeto de tipo JsonObject
        try (FileReader leerJsonPrecios = new FileReader("monitorizacion_electrica\\may_2024_data.json")) {
            JsonObject jsonObject = JsonParser.parseReader(leerJsonPrecios).getAsJsonObject();

            // Recorremos las fechas y horas para extraer los datos. Con jsonObject.keySet() se obtiene un conjunto de todas las claves (horas) dentro del objeto json. Y con el jsonObject.getAsJsonObject(fecha) para cada fecha, obtiene el objeto json correspondiente a esa fecha, que contiene los datos de las horas.
            for (String fecha : jsonObject.keySet()) {
                JsonObject horas = jsonObject.getAsJsonObject(fecha);
                //En este segundo for con el horas.keySet() obtenemos todas las claves(horas) dentro del json para la fecha actual y con el horas.getAsJsonObject(hora) para cada hora, se obtiene el objeto json que contiene los atributos específicos (fecha, hora, precio).
                for (String hora : horas.keySet()) {
                    JsonObject detalle = horas.getAsJsonObject(hora);
                    // Extraer datos del objeto JSON parseado y mostrarlos.
                    String fechaValue = detalle.get("fecha").getAsString();// Obtiene y convierte el valor de "fecha" a cadena.
                    String horaValue = detalle.get("hora").getAsString();// Obtiene y convierte el valor de "hora" a cadena.
                    float precioKwh = detalle.get("preciokWh").getAsFloat();// Obtiene y convierte el valor de "preciokWh" a float.

                    precioElectricidad.setFecha(fechaValue); //Asigna el valor extraído de la fecha al objeto "precioElectricidad"
                    precioElectricidad.setHora(horaValue);//Asigna el valor extraído de la hora al objeto "precioElectricidad"
                    precioElectricidad.setPrecioKwh(precioKwh);//Asigna el valor extraído del precio al objeto "precioElectricidad"

                    if (!insertado) {
                        insertado = true;
                    }
                    // Aquí se podrían insertar los datos en la base de datos si queremos, pero como una función va en negocio y otra en dto lo he puesto así.
                    PrecioElectricidadDAO.insertarPrecioElectricidad(precioElectricidad);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();  // Imprime el rastro del error si ocurre uno durante la escritura.
        }
        return  precioElectricidad;
    }


    public List<EventosConsumo> extraerDatosJsonEventosConsumo(){
        List<EventosConsumo> eventosConsumo = new ArrayList<>();
        EventosConsumosDAO eventosConsumosDAO = new EventosConsumosDAO();

        try (FileReader leerJsonEventos = new FileReader("may_2024_appliance_events.json")) {
            Gson gson = new Gson();
            Type listType = new TypeToken<List<EventosConsumo>>() {}.getType();
            eventosConsumo = gson.fromJson(leerJsonEventos, listType);
            if (eventosConsumo != null) {
                      for (EventosConsumo evento : eventosConsumo) {
                      eventosConsumosDAO.insertarEventosConsumo(evento);
                      }
                    }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eventosConsumo;
        }   
}




        // public void procesarJsonYGuardarEventosEnBD() {
        //     List<EventosConsumo> eventosConsumo = extraerDatosJsonEventosConsumo();
        //     EventosConsumosDAO eventosConsumosDAO = new EventosConsumosDAO();
        //     if (eventosConsumo != null) {
        //         for (EventosConsumo evento : eventosConsumo) {
        //             eventosConsumosDAO.insertarEventosConsumo(evento);
        //         }
        //     }
        // }
        
    




        
        