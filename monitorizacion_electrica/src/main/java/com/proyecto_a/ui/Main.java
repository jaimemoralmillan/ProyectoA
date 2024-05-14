package com.proyecto_a.ui;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MonitorizacionGUI gui = new MonitorizacionGUI();
            gui.setVisible(true);
        });

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
            System.out.println(informacion);
        }

    } catch(Exception e) {
        e.printStackTrace();
    }
    }
}
