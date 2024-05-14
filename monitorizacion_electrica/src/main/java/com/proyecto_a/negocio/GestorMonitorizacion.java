package com.proyecto_a.negocio;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.proyecto_a.dao.DispositivosDAO;
import com.proyecto_a.dto.Dispositivo;


public class GestorMonitorizacion {
    


    private DispositivosDAO dispositivoDAO = new DispositivosDAO();
   

    // Métodos para dispositivos
    public boolean agregarDispositivo(Dispositivo dispositivo) {
        return dispositivoDAO.insertarDispositivo(dispositivo);
    }

    //Info sobre la API, es necesario pasar un valor de zona mediante el parámetro ?zone= Con este valor obtendremos los precios relativos a la zona deseada, PCB(Península, Canarias, Baleares) o CYM(Ceuta y Melilla).


    //Solicitar una petición
    /*ENDPOINTS DISPONIBLES:
        - Obtiene la serie de precios completa --> https://api.preciodelaluz.org/v1/prices/all?zone=PCB
        - Obtiene el precio medio de la serie --> https://api.preciodelaluz.org/v1/prices/avg?zone=PCB
        - Obtiene el precio más alto de la serie --> https://api.preciodelaluz.org/v1/prices/max?zone=PCB
        - Obtiene el precio más bajo de la serie --> https://api.preciodelaluz.org/v1/prices/min?zone=PCB
        - Obtiene el precio en el momento de la consulta --> https://api.preciodelaluz.org/v1/prices/now?zone=PCB
        - Obtiene los n precios más económicos de la serie --> https://api.preciodelaluz.org/v1/prices/cheapests?zone=PCB&n=2
    */ 
    try{
        //Creamos una url, que será el endpoint de la api
        URL url = new URL("https://api.preciodelaluz.org/v1/prices/all?zone=PCB");
        //Creamos una conexion a una url por http creando un objeto de clase HttpUrlConnection y con openConnection() abrimos la conexión
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        //Establecemos que su método de petición va a ser GET y conectamos
        conexion.setRequestMethod("GET");
        conexion.connect();

        //¿Petición correcta?. Con conexion.getResponseCode() leemos el código que nos responde. Si el código es distinto de un código 200 lanzamos un error/excepción indicando el código de error que nos ha devuelto la petición.
        int responseCode = conexion.getResponseCode();
        if(responseCode != 200){
            throw new RuntimeException("Ocurrió un error " + responseCode); 
        }else{
            // En caso de que no haya habido ninhún error Abrimos un scanner que lea el flujo de datos. Para ello utilizamos un objeto de clase StringBuilder al cual vamos a añadirle toda la información que hemos recibido de la petición API. Para ello tenemos el scanner que va a leer el flujo de datos obtenido
            StringBuilder informacion = new StringBuilder();
            Scanner scanner = new Scanner(url.openStream());

            //Mientras haya flujo de datos, es decir, mientras haya una línea que leer (scanner.hasNext()) va a estar añadiendo a nuestra información (esto se hace con el append)
            while(scanner.hasNext()){
                informacion.append(scanner.nextLine());
            }
            scanner.close();

            // Pintar la información obtenida por consola
            // System.out.println(informacion);

            //Lectura e interpretación del contenido: Si el contenido del json empieza por corchetes se entiende que tenemos un array con un único objeto, los objetos vienen definidos en json por llaves.
            JSONArray jsonArray = new JSONArray(informacion.toString());
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            System.out.println(jsonObject.getString(date));
        }

    } catch(Exception e) {
        e.printStackTrace();
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
