package com.proyecto_a.ui;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import com.proyecto_a.negocio.GestorMonitorizacion;
import com.proyecto_a.negocio.LectorArchivosJson;
import com.proyecto_a.dao.DispositivosDAO;
import com.proyecto_a.dao.Dispositivos_has_franjaHorariaDAO;
import com.proyecto_a.dao.EventosConsumosDAO;
import com.proyecto_a.dao.EventosPrecioDAO;
import com.proyecto_a.dto.Categoria;
import com.proyecto_a.dto.Dispositivo;
import com.proyecto_a.dto.Dispositivos_has_franjaHoraria;
import com.proyecto_a.dto.EventosPrecio;
import com.proyecto_a.dto.FranjaHoraria;
import com.proyecto_a.dto.PrecioElectricidad;

public class MonitorizacionGUI extends JFrame {



    //inicializacion de todos los elementos que se vayan a usar y que tenga que leer una funcion: botones, combobox,paneles,campos de texto....
    //txt=caja de texto, btn=boton , combo=combobox (desplegable)
    private JTextField txtDispositivoDescripcion,txtDispositivoModificar;
    private JButton btnAgregarDispositivo,btnActualizarBaseDatos;
    private JComboBox<Dispositivo>  comboDispositivosEliminar, comboDispositivosModificar,comboSeleccionaDispositivoCalculo,comboSeleccionaDispositivoEnRango, comboSeleccionaDispositivoCategoria;
    private JComboBox<String>  comboSeleccionarDispositivo,comboSeleccionDia1,comboSeleccionDia2,comboSeleccionDia3,comboSeleccionDia4,comboSeleccionDia5;
    
    

    public MonitorizacionGUI() {
        setTitle("Sistema de Monitorización eléctrica");
        setSize(1200, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        // rellenar array con datos de los dispositivos por defecto
        Dispositivo.rellenarArrayDispositivosDefault();
        // UI AGREGAR DISPOSITIVO
        // se crea el tabbed pane, que es la ventana en si, pero permite añadirle
        // pestañas
        JTabbedPane panelPestanias = new JTabbedPane();

        // Pestaña agregar dispositivo
        // los JPanel son las pestañas. creamos una para agregar dispositivo
        JPanel pestanaAgregarDispositivo = new JPanel(new GridLayout(0, 2, 10, 10));

        // creamos los botones, etiquetas y cajas de texto que necesitamos para esta
        // pestaña. las que solo son esteticas se pueden crear de 0 aqui
        // pero las que tiene que leer una de las funciones de abajo tienen que estar
        // inicializadas en las lineas 20,21,22

        JLabel etiquetaNombreDispositivo = new JLabel("Seleccione el dispositivo para agregar: ");
        comboSeleccionarDispositivo = new JComboBox<>();

        JLabel etiquetaDescripcionDispositivo = new JLabel("Descripcion del Dispositivo: ");
        txtDispositivoDescripcion = new JTextField();
        btnAgregarDispositivo = new JButton("Agregar Dispositivo");
        btnActualizarBaseDatos = new JButton("Actualizar Base de Datos");

        // se le agrega el action listener al botón que va a agregar; cuando se le clica
        // ejecuta la funcion agregarDispositivo
        btnAgregarDispositivo.addActionListener(this::agregarDispositivo);
        btnActualizarBaseDatos.addActionListener(this::funcionesActualizacionBD);

        // ahora añadimos todos los elementos en el orden que queramos: se ponen de izq
        // a derecha, 2 por fila.
        //

        pestanaAgregarDispositivo.add(etiquetaNombreDispositivo);
        pestanaAgregarDispositivo.add(comboSeleccionarDispositivo);
        pestanaAgregarDispositivo.add(etiquetaDescripcionDispositivo);
        pestanaAgregarDispositivo.add(txtDispositivoDescripcion);
        pestanaAgregarDispositivo.add(btnAgregarDispositivo);
        pestanaAgregarDispositivo.add(btnActualizarBaseDatos);

        // UI ELIMINAR DISPOSITIVO

        JPanel pestanaEliminarDispositivo = new JPanel(new GridLayout(0, 2, 10, 10));
        JButton btnEliminarDispositivo = new JButton("Eliminar Dispositivo");
        JLabel etiquetaElegirDispositivo = new JLabel("Elegir Dispositivo");
        comboDispositivosEliminar = new JComboBox<>();
        btnEliminarDispositivo.addActionListener(e -> eliminarDispositivo());
        pestanaEliminarDispositivo.add(etiquetaElegirDispositivo);
        pestanaEliminarDispositivo.add(comboDispositivosEliminar);
        pestanaEliminarDispositivo.add(btnEliminarDispositivo);

        // UI MODIFICAR DISPOSITIVO existente
        JPanel pestanaModificarDispositivo = new JPanel(new GridLayout(0, 2, 10, 10));
        JButton btnModificarDispositivo = new JButton("Modificar Dispositivo");
        JLabel etiquetaModificarDispositivo = new JLabel("Seleccione Dispositivo a Modificar");
        JLabel etiquetaNuevaDescripcion = new JLabel("Nueva descripcion del dispositivo");
        comboDispositivosModificar = new JComboBox<>();
        txtDispositivoModificar = new JTextField();
        btnModificarDispositivo.addActionListener(e -> modificarDispositivo());
        pestanaModificarDispositivo.add(etiquetaModificarDispositivo);
        pestanaModificarDispositivo.add(comboDispositivosModificar);
        pestanaModificarDispositivo.add(etiquetaNuevaDescripcion);
        pestanaModificarDispositivo.add(txtDispositivoModificar);
        pestanaModificarDispositivo.add(btnModificarDispositivo);

        //UI CALCULAR GASTO POR DIA

        JPanel pestanaCalculoGastoDia = new JPanel(new GridLayout(0,2,10,10));
        JButton btnCalcularGastoDia = new JButton("Calcular Gasto en el Dia indicado");
        JLabel etiquetaElegirDia = new JLabel("Seleccione un día para ver el gasto total");
        comboSeleccionDia1 = new JComboBox<>();
        btnCalcularGastoDia.addActionListener(this::calcularGastoDia);
        pestanaCalculoGastoDia.add(etiquetaElegirDia);
        pestanaCalculoGastoDia.add(comboSeleccionDia1);
        pestanaCalculoGastoDia.add(btnCalcularGastoDia);
        
        //UI CALCULAR GASTO POR RANGO

        
        JPanel pestanaCalculoGastoRango = new JPanel(new GridLayout(0,2,10,10));
        JButton btnCalcularGastoRango = new JButton("Calcular Gasto en el rango indicado");
        JLabel etiquetaElegirRango1 = new JLabel("Seleccione el primer dia del rango");
        JLabel etiquetaElegirRango2 = new JLabel("Seleccione el segundo dia del rango");

        comboSeleccionDia2 = new JComboBox<>();
        comboSeleccionDia3 = new JComboBox<>();
        btnCalcularGastoRango.addActionListener(this::calcularGastoRango);
        pestanaCalculoGastoRango.add(etiquetaElegirRango1);
        pestanaCalculoGastoRango.add(comboSeleccionDia2);
        pestanaCalculoGastoRango.add(etiquetaElegirRango2);
        pestanaCalculoGastoRango.add(comboSeleccionDia3);
        pestanaCalculoGastoRango.add(btnCalcularGastoRango);

        //UI Calcular gasto por dispositivo

        JPanel pestanaCalculoPorDispositivo = new JPanel(new GridLayout(0,2,10,10));
        JButton btnCalcularGastoPorDispositivo = new JButton("Calcular Gasto Dispositivo");
        JLabel etiquetaElegirDispositivoGasto = new JLabel("Seleccione el dispositivo");
        comboSeleccionaDispositivoCalculo = new JComboBox<>();

        btnCalcularGastoPorDispositivo.addActionListener(this::calcularGastoPorDispositivo);

        pestanaCalculoPorDispositivo.add(etiquetaElegirDispositivoGasto);
        pestanaCalculoPorDispositivo.add(comboSeleccionaDispositivoCalculo);
        pestanaCalculoPorDispositivo.add(btnCalcularGastoPorDispositivo);

        //UI calcular gasto por dispositivo en rango


        JPanel pestanaCalculoPorDispositivoEnRango = new JPanel(new GridLayout(0,2,10,10));
        JButton btnCalcularGastoPorDispositivoEnRango = new JButton("Calcular Gasto Dispositivo en Rango");
        JLabel etiquetaElegirDispositivoGastoEnRango = new JLabel("Seleccione el dispositivo");
        JLabel etiquetaElegirFechaDispositivoEnRango1 =  new JLabel("Seleccione el primer dia del rango");
        JLabel etiquetaElegirFechaDispositivoEnRango2 =  new JLabel("Seleccione el ultimo dia del rango");
        comboSeleccionaDispositivoEnRango = new JComboBox<>();
        comboSeleccionDia4 = new JComboBox<>();
        comboSeleccionDia5 = new JComboBox<>();
        btnCalcularGastoPorDispositivoEnRango.addActionListener(this::calcularGastoPorDispositivoEnRango);

        pestanaCalculoPorDispositivoEnRango.add(etiquetaElegirDispositivoGastoEnRango);
        pestanaCalculoPorDispositivoEnRango.add(comboSeleccionaDispositivoEnRango);
        pestanaCalculoPorDispositivoEnRango.add(etiquetaElegirFechaDispositivoEnRango1);
        pestanaCalculoPorDispositivoEnRango.add(comboSeleccionDia4);
        pestanaCalculoPorDispositivoEnRango.add(etiquetaElegirFechaDispositivoEnRango2);
        pestanaCalculoPorDispositivoEnRango.add(comboSeleccionDia5);
        pestanaCalculoPorDispositivoEnRango.add(btnCalcularGastoPorDispositivoEnRango);

        
        // UI Enseñar categoria de dispositivos
        JPanel pestanaCategoriaDispositivo = new JPanel(new GridLayout(0, 2, 10, 10));
        JButton btnCategoriaDispositivo = new JButton("Mostrar Categoria de Dispositivo");
        JLabel etiquetaElegirDispositivoCategoria = new JLabel("Seleccione el dispositivo");
        comboSeleccionaDispositivoCategoria = new JComboBox<>();
        btnCategoriaDispositivo.addActionListener(this::enseñarCategoriaDispositivo);
        
        pestanaCategoriaDispositivo.add(etiquetaElegirDispositivoCategoria);
        pestanaCategoriaDispositivo.add(comboSeleccionaDispositivoCategoria);
        pestanaCategoriaDispositivo.add(btnCategoriaDispositivo);



        //Añadimos las pestañas al panel

        panelPestanias.addTab("Agregar Dispositivo", pestanaAgregarDispositivo);
        panelPestanias.addTab("Eliminar Dispositivo", pestanaEliminarDispositivo);
        panelPestanias.addTab("Modificar Dispositivo",pestanaModificarDispositivo);
        panelPestanias.addTab("Calcular Gasto por Dia",pestanaCalculoGastoDia);
        panelPestanias.addTab("Calcular Gasto por Rango",pestanaCalculoGastoRango);
        panelPestanias.addTab("Calculo por Dispositivo",pestanaCalculoPorDispositivo);
        panelPestanias.addTab("Calculo por Dispositivo en Rango",pestanaCalculoPorDispositivoEnRango);
        panelPestanias.addTab("Enseñar Categoria de Dispositivo",pestanaCategoriaDispositivo);
        

        add(panelPestanias, BorderLayout.CENTER);
        // hace jframe visible
        setVisible(true);

        
        // ejecutamos las funciones para rellenar los comboBox al inicializar el programa

        cargarDispositivosBDD();
        cargarDispositivosDefaultComboBox(Dispositivo.getDispositivosDefault());
        cargarComboDiasMayo(EventosPrecio.diasDeMayo);
     
    }

    // aqui se crean las funciones que leen/toman cosas de los elementos de la UI
    // que hemos declarado arriba
    // y que ejecutan las funciones que tenemos creadas en DAO con esos datos

    // funcion Agregar Dispositivo
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

    // funcion cargarDispositivos, rellena los combo boxes con los datos de los
    // dispositivos sacados de la BDD

    private void cargarDispositivosBDD() {

        // crea un arraylist de tipo dispositivo para almacenar todos los dispositivos
        // y dentro mete el resultado de la funcion obtenerTodosDispositivos (esta en
        // dao), que hace un
        // select * a la tabla dispositivos y lo mete todo en un ArrayList de tipo
        // dispositivo que luego retorna

        ArrayList<Dispositivo> dispositivos = DispositivosDAO.obtenerTodosDispositivos();

        // quitamos todos los dispositivos del desplegable primero
        comboDispositivosEliminar.removeAllItems();
        comboDispositivosModificar.removeAllItems();

        // y ahora por cada dispositivo en el arrayList que acabamos de rellenar, añade
        // un item al desplegable

        for (Dispositivo dispositivo : dispositivos) {

            comboDispositivosEliminar.addItem(dispositivo);
            comboDispositivosModificar.addItem(dispositivo);
            comboSeleccionaDispositivoCalculo.addItem(dispositivo);
            comboSeleccionaDispositivoEnRango.addItem(dispositivo);
            comboSeleccionaDispositivoCategoria.addItem(dispositivo);
        }

    }

    // funcion cargar dispositivos por defecto en el combobox

    private void cargarDispositivosDefaultComboBox(ArrayList<String> dispositivosDefault) {

        for (String dispositivo : dispositivosDefault) {

            comboSeleccionarDispositivo.addItem(dispositivo);

        }

    }

    // funcion eliminar dispositivo

    private void eliminarDispositivo() {
        // esta sintaxis no la entiendo, linea 139 preguntar
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

    // funcion modificar dispositivo

    private void modificarDispositivo() {

        Dispositivo dispositivo = (Dispositivo) comboDispositivosModificar.getSelectedItem();
        if (dispositivo != null) {
            if (DispositivosDAO.modificarDescripcionDispositivo(dispositivo.getId(),
                    txtDispositivoModificar.getText())) {
                JOptionPane.showMessageDialog(this, "Dispositivo modificado correctamente");
                cargarDispositivosBDD(); // Recargar lista de dispositivos
            } else {
                JOptionPane.showMessageDialog(this, "Error al modificar dispositivo.");
            }
        }

    }

    // funcion actualizar base de datos

    public void funcionesActualizacionBD(ActionEvent event) {

        PrecioElectricidad precioElectricidad = new PrecioElectricidad();
        GestorMonitorizacion.extraerDatosJsonPrecios();
        GestorMonitorizacion.insertarPrecioElectricidad(precioElectricidad);

        LectorArchivosJson lectorArchivosJson = new LectorArchivosJson();
        lectorArchivosJson.extraerDatosJsonDispositivos();
        lectorArchivosJson.extraerDatosJsonEventosConsumo();

        GestorMonitorizacion.insertarFranjas();
        List<String> nombresDispositivos = DispositivosDAO.obtenerNombresDispositivos();
        for (String nombreDispositivo : nombresDispositivos) {
            Dispositivos_has_franjaHorariaDAO.insertarFranjasParaDispositivo(nombreDispositivo);
        }
        GestorMonitorizacion.insertarCategorias();
        GestorMonitorizacion.actualizarCategoriasDispositivos();
        EventosConsumosDAO.actualizarConsumoKwhEventosConsumo();
        EventosPrecioDAO.InsertarEventosPrecio();
        cargarDispositivosBDD();

    }
      

    //funcion calcularGastosDia

    private void calcularGastoDia(ActionEvent event) {

        NumberFormat truncar = NumberFormat.getInstance();
        truncar.setMaximumFractionDigits(2);            
        truncar.setGroupingUsed(false);
        String diaElegido = comboSeleccionDia1.getSelectedItem().toString();
        float gastoTotal = EventosPrecioDAO.calcularConsumoPorDia(diaElegido);
        String mensaje = "El dia "+diaElegido+" se gastó "+truncar.format(gastoTotal)+" Euros en total en el importe de la luz";

        JOptionPane.showMessageDialog(this,mensaje);


    }

    //funcion calcularGastosRangoDias

    private void calcularGastoRango(ActionEvent event) {

        NumberFormat truncar = NumberFormat.getInstance();
        truncar.setMaximumFractionDigits(2);            
        truncar.setGroupingUsed(false);
        String diaElegido1 = comboSeleccionDia2.getSelectedItem().toString();
        String diaElegido2 = comboSeleccionDia3.getSelectedItem().toString();
        float gastoTotal = EventosPrecioDAO.calcularConsumoPorRango(diaElegido1,diaElegido2);
        String mensaje ="Entre el "+diaElegido1+" y el "+diaElegido2+" se gastó "+ truncar.format(gastoTotal)+" Euros en total en el importe de la luz.";
        JOptionPane.showMessageDialog(this,mensaje);

    }
    
    //funcion calculo por dispositivo

    private void calcularGastoPorDispositivo (ActionEvent event) {

        NumberFormat truncar = NumberFormat.getInstance();
        truncar.setMaximumFractionDigits(2);            
        truncar.setGroupingUsed(false);
        Dispositivo dispositivo = (Dispositivo) comboSeleccionaDispositivoCalculo.getSelectedItem();
        float gastoTotal = EventosPrecioDAO.calculoConsumoPorDispositivo(dispositivo);
        String mensaje ="El gasto total del dispositivo "+dispositivo.getDescripcion()+" durante todo el mes ha sido de "+truncar.format(gastoTotal)+" Euros";
        JOptionPane.showMessageDialog(this,mensaje);

    

    }

    //funcion calculo por dispositivo en rango

    private void calcularGastoPorDispositivoEnRango (ActionEvent event) {
        NumberFormat truncar = NumberFormat.getInstance();
        truncar.setMaximumFractionDigits(2);            
        truncar.setGroupingUsed(false);
        Dispositivo dispositivo = (Dispositivo) comboSeleccionaDispositivoEnRango.getSelectedItem();
        String diaElegido1 = comboSeleccionDia4.getSelectedItem().toString();
        String diaElegido2 = comboSeleccionDia5.getSelectedItem().toString();

        float gastoTotal = EventosPrecioDAO.calculoConsumoPorDispositivoEnRango(dispositivo,diaElegido1,diaElegido2);
        String mensaje ="El gasto total del dispositivo "+dispositivo.getDescripcion()+" entre el "+diaElegido1+" y el "+diaElegido2+" ha sido de "+truncar.format(gastoTotal)+" Euros";
        JOptionPane.showMessageDialog(this,mensaje);

    

    }
    //funcion cargar combo box dias mayo

    private void cargarComboDiasMayo(String[] diasMayo) {

        for (String dia : diasMayo) {
            
            comboSeleccionDia1.addItem(dia);
            comboSeleccionDia2.addItem(dia);
            comboSeleccionDia3.addItem(dia);
            comboSeleccionDia4.addItem(dia);
            comboSeleccionDia5.addItem(dia);


        }


    }

    //funcion enseñar categoria de dispositivo

    private void enseñarCategoriaDispositivo(ActionEvent event) {
        Dispositivo dispositivo = (Dispositivo) comboSeleccionaDispositivoCategoria.getSelectedItem();
        int idDispositivo = dispositivo.getId(); // Obtener el id del dispositivo
        Categoria categoria = DispositivosDAO.obtenerCategoriaDispositivo(idDispositivo); // Obtener la categoría usando el id del dispositivo
        String mensaje = "El dispositivo "+dispositivo.getDescripcion()+" pertenece a la categoría: "+ categoria.getNombre() + " - "+ categoria.getDescripcion();
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MonitorizacionGUI().setVisible(true));
    }

}
