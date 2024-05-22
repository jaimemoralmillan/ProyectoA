package com.proyecto_a.ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import com.proyecto_a.negocio.GestorMonitorizacion;
import com.proyecto_a.negocio.Inicializacion;
import com.proyecto_a.negocio.LectorArchivosJson;
import com.proyecto_a.dao.DispositivosDAO;
import com.proyecto_a.dao.EventosConsumosDAO;
import com.proyecto_a.dto.Dispositivo;
import com.proyecto_a.dto.PrecioElectricidad;

public class MonitorizacionGUI extends JFrame {



    //inicializacion de todos los elementos que se vayan a usar y que tenga que leer una funcion: botones, combobox,paneles,campos de texto....
    //txt=caja de texto, btn=boton , combo=combobox (desplegable)
    private JTextField txtDispositivoDescripcion,txtDispositivoModificar;
    private JButton btnAgregarDispositivo,btnActualizarBaseDatos;
    private JComboBox<Dispositivo>  comboDispositivosEliminar, comboDispositivosModificar;
    private JComboBox<String>  comboSeleccionarDispositivo;


    public MonitorizacionGUI() {
        setTitle("Sistema de Monitorización eléctrica");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        //rellenar array con datos de los dispositivos por defecto
        Dispositivo.rellenarArrayDispositivosDefault ();
    //UI AGREGAR DISPOSITIVO
        //se crea el tabbed pane, que es la ventana en si, pero permite añadirle pestañas
        JTabbedPane panelPestanias=new JTabbedPane();

        // Pestaña agregar dispositivo
        //los JPanel son las pestañas. creamos una para agregar dispositivo
        JPanel pestanaAgregarDispositivo = new JPanel(new GridLayout(0,2,10,10));
       
        //creamos los botones, etiquetas y cajas de texto que necesitamos para esta pestaña. las que solo son esteticas se pueden crear de 0 aqui
        //pero las que tiene que leer una de las funciones de abajo tienen que estar inicializadas en las lineas 20,21,22
       
        JLabel etiquetaNombreDispositivo = new JLabel("Seleccione el dispositivo para agregar: ");
        comboSeleccionarDispositivo = new JComboBox<>();
        
      
        JLabel etiquetaDescripcionDispositivo = new JLabel("Descripcion del Dispositivo: ");
        txtDispositivoDescripcion = new JTextField();
        btnAgregarDispositivo = new JButton("Agregar Dispositivo");
        btnActualizarBaseDatos = new JButton("Actualizar Base de Datos");

        //se le agrega el action listener al botón que va a agregar; cuando se le clica ejecuta la funcion agregarDispositivo
        btnAgregarDispositivo.addActionListener(this::agregarDispositivo);
        btnActualizarBaseDatos.addActionListener(this::funcionesActualizacionBD);
       
        //ahora añadimos todos los elementos en el orden que queramos: se ponen de izq a derecha, 2 por fila.
        // 

        pestanaAgregarDispositivo.add(etiquetaNombreDispositivo);
        pestanaAgregarDispositivo.add(comboSeleccionarDispositivo);
        pestanaAgregarDispositivo.add(etiquetaDescripcionDispositivo);
        pestanaAgregarDispositivo.add(txtDispositivoDescripcion);
        pestanaAgregarDispositivo.add(btnAgregarDispositivo);
        pestanaAgregarDispositivo.add(btnActualizarBaseDatos);

    //UI ELIMINAR DISPOSITIVO

        JPanel pestanaEliminarDispositivo = new JPanel(new GridLayout(0,2,10,10));
        JButton btnEliminarDispositivo = new JButton("Eliminar Dispositivo");
        JLabel etiquetaElegirDispositivo = new JLabel("Elegir Dispositivo");
        comboDispositivosEliminar = new JComboBox<>();
        btnEliminarDispositivo.addActionListener( e->eliminarDispositivo());
        pestanaEliminarDispositivo.add(etiquetaElegirDispositivo);
        pestanaEliminarDispositivo.add(comboDispositivosEliminar);
        pestanaEliminarDispositivo.add(btnEliminarDispositivo);

    //UI MODIFICAR DISPOSITIVO existente
        JPanel pestanaModificarDispositivo = new JPanel(new GridLayout(0,2,10,10));
        JButton btnModificarDispositivo = new JButton("Modificar Dispositivo");
        JLabel etiquetaModificarDispositivo = new JLabel("Seleccione Dispositivo a Modificar");
        JLabel etiquetaNuevaDescripcion = new JLabel("Nueva descripcion del dispositivo");
        comboDispositivosModificar = new JComboBox<>();
        txtDispositivoModificar = new JTextField();
        btnModificarDispositivo.addActionListener( e->modificarDispositivo());
        pestanaModificarDispositivo.add(etiquetaModificarDispositivo);
        pestanaModificarDispositivo.add(comboDispositivosModificar);
        pestanaModificarDispositivo.add(etiquetaNuevaDescripcion);
        pestanaModificarDispositivo.add(txtDispositivoModificar);
        pestanaModificarDispositivo.add(btnModificarDispositivo);

        


        //Añadimos las pestañas al panel

        panelPestanias.addTab("Agregar Dispositivo", pestanaAgregarDispositivo);
        panelPestanias.addTab("Eliminar Dispositivo", pestanaEliminarDispositivo);
        panelPestanias.addTab("Modificar Dispositivo",pestanaModificarDispositivo);
        add(panelPestanias, BorderLayout.CENTER);
      //hace jframe visible
        setVisible(true);

        /* PRUEBA MENU 

           //creacion barra de menus
           JMenuBar menuBar = new JMenuBar();

           //crear menu
           JMenu menuDispositivo = new JMenu("Dispositivos");
           //añadir menu a barra de menus
           menuBar.add(menuDispositivo);
           //crear items del menu
           JMenuItem agregarDispositivoMenu = new JMenuItem("Agregar Dispositivos");
           JMenuItem eliminarDispositivosMenu = new JMenuItem("Eliminar Dispositivos");
           JMenuItem modificarDispositivosMenu = new JMenuItem("Modificar Dispositivos");

               // Añadir ítems al menú
            menuDispositivo.add(agregarDispositivoMenu);
            menuDispositivo.add(eliminarDispositivosMenu);
            menuDispositivo.add(modificarDispositivosMenu);
          
           // Establecer la barra de menús en el JFrame
           setJMenuBar(menuBar);

             // Añadir acciones a los ítems del menú
        agregarDispositivoMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                
            }
        });

        eliminarDispositivosMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });





        FIN PRUEBA MENU */
        
        // ejecutamos las funciones para rellenar los comboBox al inicializar el programa

        cargarDispositivosBDD();
        cargarDispositivosDefaultComboBox(Dispositivo.getDispositivosDefault());
     
    }

    //aqui se crean las funciones que leen/toman cosas de los elementos de la UI que hemos declarado arriba
    // y que ejecutan las funciones que tenemos creadas en DAO con esos datos 

        //funcion Agregar Dispositivo
    private void agregarDispositivo(ActionEvent event) {
        String nombre = comboSeleccionarDispositivo.getSelectedItem().toString();
        String descripcion = txtDispositivoDescripcion.getText();
        Dispositivo dispositivo = new Dispositivo(0, nombre, descripcion);
        if (GestorMonitorizacion.agregarDispositivo(dispositivo)) {
            JOptionPane.showMessageDialog(this, "Dispositivo agregado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Error al agregar dispositivo.");
        }

        cargarDispositivosBDD();
        
    }

    //funcion cargarDispositivos,  rellena los combo boxes con los datos de los dispositivos sacados de la BDD

       private void cargarDispositivosBDD(){

        //crea un arraylist de tipo dispositivo para almacenar todos los dispositivos
        // y dentro mete el resultado de la funcion obtenerTodosDispositivos (esta en dao), que hace un
        //select * a la tabla dispositivos y lo mete todo en un ArrayList de tipo dispositivo que luego retorna

        ArrayList<Dispositivo> dispositivos = DispositivosDAO.obtenerTodosDispositivos();
       
        //quitamos todos los dispositivos del desplegable primero
        comboDispositivosEliminar.removeAllItems();
        comboDispositivosModificar.removeAllItems();

        // y ahora por cada dispositivo en el arrayList que acabamos de rellenar, añade un item al desplegable

        for (Dispositivo dispositivo : dispositivos) {
            
            comboDispositivosEliminar.addItem(dispositivo);
            comboDispositivosModificar.addItem(dispositivo);
        }
         
       }

    //funcion cargar dispositivos por defecto en el combobox 

       private void cargarDispositivosDefaultComboBox (ArrayList<String> dispositivosDefault) {

        for (String dispositivo : dispositivosDefault) {
            
            comboSeleccionarDispositivo.addItem(dispositivo);

        }

       }

    //funcion eliminar dispositivo

       private void eliminarDispositivo () {
        //esta sintaxis no la entiendo, linea 139 preguntar
        Dispositivo dispositivo = (Dispositivo) comboDispositivosEliminar.getSelectedItem();
        if (dispositivo != null) {
            if (DispositivosDAO.eliminarDispositivo(dispositivo.getId())) {
                JOptionPane.showMessageDialog(this, "Dispositivo eliminado exitosamente.");
                cargarDispositivosBDD(); // Recargar lista de autores
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar dispositivo.");
            }
        }

       }

        //funcion modificar dispositivo

        private void modificarDispositivo () {
            
            Dispositivo dispositivo = (Dispositivo) comboDispositivosModificar.getSelectedItem();
            if (dispositivo != null) {
                if (DispositivosDAO.modificarDescripcionDispositivo(dispositivo.getId(),txtDispositivoModificar.getText())) {
                    JOptionPane.showMessageDialog(this, "Dispositivo modificado correctamente");
                    cargarDispositivosBDD(); // Recargar lista de dispositivos
                } else {
                    JOptionPane.showMessageDialog(this, "Error al modificar dispositivo.");
                }
            }
    
           }

           //funcion actualizar base de datos

           public void funcionesActualizacionBD(ActionEvent event){

         PrecioElectricidad precioElectricidad = new PrecioElectricidad();
        GestorMonitorizacion.extraerDatosJsonPrecios();
        GestorMonitorizacion.insertarPrecioElectricidad(precioElectricidad);

        LectorArchivosJson lectorArchivosJson = new LectorArchivosJson();
        lectorArchivosJson.extraerDatosJsonDispositivos();
        lectorArchivosJson.extraerDatosJsonEventosConsumo();
        
        
        GestorMonitorizacion.insertarFranjas();
        EventosConsumosDAO.actualizarConsumoKwhEventosConsumo();

    }
       
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MonitorizacionGUI().setVisible(true));
    }


}
