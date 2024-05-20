package com.proyecto_a.ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import com.proyecto_a.negocio.GestorMonitorizacion;
import com.proyecto_a.dao.DispositivosDAO;
import com.proyecto_a.dto.Dispositivo;

public class MonitorizacionGUI extends JFrame {


    //preguntar rodolfo por que se usa el gestor monitorizacion
    private GestorMonitorizacion gestorMonitorizacion = new GestorMonitorizacion();


    //inicializacion de todos los elementos que se vayan a usar y que tenga que leer una funcion: botones, combobox,paneles,campos de texto....
    //txt=caja de texto, btn=boton , combo=combobox (desplegable)
    private JTextField txtDispositivoNombre,txtDispositivoDescripcion;
    private JButton btnAgregarDispositivo;
    private JComboBox<Dispositivo>  comboDispositivosEliminar;


    public MonitorizacionGUI() {
        setTitle("Sistema de Monitorización eléctrica");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

    //UI AGREGAR DISPOSITIVO
        //se crea el tabbed pane, que es la ventana en si, pero permite añadirle pestañas
        JTabbedPane panelPestanias=new JTabbedPane();

        // Pestaña agregar dispositivo
        //los JPanel son las pestañas. creamos una para agregar dispositivo
        JPanel pestanaAgregarDispositivo = new JPanel(new GridLayout(0,2,10,10));
       
        //creamos los botones, etiquetas y cajas de texto que necesitamos para esta pestaña. las que solo son esteticas se pueden crear de 0 aqui
        //pero las que tiene que leer una de las funciones de abajo tienen que estar inicializadas en las lineas 20,21,22
       
        JLabel etiquetaNombreDispositivo = new JLabel("Nombre del Dispositivo: ");
        txtDispositivoNombre = new JTextField();
        JLabel etiquetaDescripcionDispositivo = new JLabel("Descripcion del Dispositivo: ");
        txtDispositivoDescripcion = new JTextField();
        btnAgregarDispositivo = new JButton("Agregar Dispositivo");

        //se le agrega el action listener al botón que va a agregar; cuando se le clica ejecuta la funcion agregarDispositivo
        btnAgregarDispositivo.addActionListener(this::agregarDispositivo);
       
        //ahora añadimos todos los elementos en el orden que queramos: se ponen de izq a derecha, 2 por fila.
        // 

        pestanaAgregarDispositivo.add(etiquetaNombreDispositivo);
        pestanaAgregarDispositivo.add(txtDispositivoNombre);
        pestanaAgregarDispositivo.add(etiquetaDescripcionDispositivo);
        pestanaAgregarDispositivo.add(txtDispositivoDescripcion);
        pestanaAgregarDispositivo.add(btnAgregarDispositivo);


    //UI ELIMINAR DISPOSITIVO

        JPanel pestanaEliminarDispositivo = new JPanel(new GridLayout(0,2,10,10));
        JButton btnEliminarDispositivo = new JButton("Eliminar Dispositivo");
        JLabel etiquetaElegirDispositivo = new JLabel("Elegir Dispositivo");
        comboDispositivosEliminar = new JComboBox<>();
        btnEliminarDispositivo.addActionListener( e->eliminarDispositivo());
        pestanaEliminarDispositivo.add(etiquetaElegirDispositivo);
        pestanaEliminarDispositivo.add(comboDispositivosEliminar);
        pestanaEliminarDispositivo.add(btnEliminarDispositivo);

        

        //Añadimos las pestañas al panel

        

        panelPestanias.addTab("Agregar Dispositivo", pestanaAgregarDispositivo);
        panelPestanias.addTab("Eliminar Dispositivo", pestanaEliminarDispositivo);
        add(panelPestanias, BorderLayout.CENTER);
      
        setVisible(true);
        
        // ejecutamos la funcion que rellena los combo boxes cargar dispositivos

        cargarDispositivos();
     


    }



   


    //aqui se crean las funciones que leen/toman cosas de los elementos de la UI que hemos declarado arriba
    // y que ejecutan las funciones que tenemos creadas en DAO con esos datos 

        //funcion Agregar Dispositivo
    private void agregarDispositivo(ActionEvent event) {
        String nombre = txtDispositivoNombre.getText();
        String descripcion = txtDispositivoDescripcion.getText();
        Dispositivo dispositivo = new Dispositivo(0, nombre, descripcion);
        if (gestorMonitorizacion.agregarDispositivo(dispositivo)) {
            JOptionPane.showMessageDialog(this, "Dispositivo agregado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Error al agregar dispositivo.");
        }

        cargarDispositivos();
        
    }


       //funcion cargarDispositivos,  rellena los combo boxes con los datos de los dispositivos

       private void cargarDispositivos(){

        //crea un arraylist de tipo dispositivo para almacenar todos los dispositivos
        // y dentro mete el resultado de la funcion obtenerTodosDispositivos (esta en dao), que hace un
        //select * a la tabla dispositivos y lo mete todo en un ArrayList de tipo dispositivo que luego retorna

        ArrayList<Dispositivo> dispositivos = DispositivosDAO.obtenerTodosDispositivos();
        
        //quitamos todos los dispositivos del desplegable primero
        comboDispositivosEliminar.removeAllItems();


// y ahora por cada dispositivo en el arrayList que acabamos de rellenar, añade un item al desplegable

        for (Dispositivo dispositivo : dispositivos) {
            
            comboDispositivosEliminar.addItem(dispositivo);

        }
       
            
       }

       //funcion eliminar dispositivo

       private void eliminarDispositivo () {
        //esta sintaxis no la entiendo, linea 139 preguntar
        Dispositivo dispositivo = (Dispositivo) comboDispositivosEliminar.getSelectedItem();
        if (dispositivo != null) {
            if (DispositivosDAO.eliminarDispositivo(dispositivo.getId())) {
                JOptionPane.showMessageDialog(this, "Dispositivo eliminado exitosamente.");
                cargarDispositivos(); // Recargar lista de autores
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar dispositivo.");
            }
        }


       }
       

   
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MonitorizacionGUI().setVisible(true));
    }


}
