package com.proyecto_a.ui;

import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import com.proyecto_a.dao.*;
import com.proyecto_a.dto.*;
import com.proyecto_a.negocio.*;

public class MonitorizacionGUI extends JFrame {

    private JTextField txtDispositivoDescripcion, txtDispositivoModificar;
    private JButton btnAgregarDispositivo, btnActualizarBaseDatos;
    private JComboBox<Dispositivo> comboDispositivosEliminar, comboDispositivosModificar, comboSeleccionaDispositivoCalculo, comboSeleccionaDispositivoEnRango, comboSeleccionaDispositivoCategoria;
    private JComboBox<String> comboSeleccionarDispositivo, comboSeleccionDia1, comboSeleccionDia2, comboSeleccionDia3, comboSeleccionDia4, comboSeleccionDia5;

    private CardLayout cardLayout;
    private JPanel panelPrincipal;

    public MonitorizacionGUI() {
        setTitle("Sistema de Monitorización eléctrica");
        setSize(1200, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Crear el menú de dispositivos
        JMenuBar menuBar = new JMenuBar();
        JMenu menuDispositivos = new JMenu("Dispositivos");

        String[] opcionesDisp = {
            "Agregar Dispositivo",
            "Eliminar Dispositivo",
            "Modificar Dispositivo",
            "Mostrar Categoría y Franjas de Dispositivo"
        };

        for (String opcion : opcionesDisp) {
            JMenuItem menuItemDisp = new JMenuItem(opcion);
            menuItemDisp.addActionListener(e -> mostrarPanel(opcion));
            menuDispositivos.add(menuItemDisp);
        }

        menuBar.add(menuDispositivos);
       

        // Crear el menú de calculos
        
        JMenu menuCalculos= new JMenu("Cálculos");

        String[] opcionesCalc = {
           "Calcular Gasto por Dia",
           "Calcular Gasto por Rango",
           "Calcular Gasto por Dispositivo",
           "Calcular Gasto por Dispositivo en Rango"
        };

        for (String opcion : opcionesCalc) {
            JMenuItem menuItemCalc = new JMenuItem(opcion);
            menuItemCalc.addActionListener(e -> mostrarPanel(opcion));
            menuCalculos.add(menuItemCalc);
        }

        menuBar.add(menuCalculos);
        setJMenuBar(menuBar);

        cardLayout = new CardLayout();
        panelPrincipal = new JPanel(cardLayout);

        //crear menu graficos
        JMenu menuGraficos = new JMenu("Gráficos");

        String[] opcionesGraficos = {
            "Gráfico Consumo por Semanas Mayo",
            "Gráfico Gasto por Dispositivos Mayo",
            
         };

         for (String opcion : opcionesGraficos) {
            JMenuItem menuItemGraph = new JMenuItem(opcion);
            menuItemGraph.addActionListener(e -> mostrarPanel(opcion));
            menuGraficos.add(menuItemGraph);
        }
        //añadir el menu graficos a la barra de menus
        menuBar.add(menuGraficos);
    
        // Crear y añadir los paneles al panel principal
        panelPrincipal.add(crearPanelAgregarDispositivo(), "Agregar Dispositivo");
        panelPrincipal.add(crearPanelEliminarDispositivo(), "Eliminar Dispositivo");
        panelPrincipal.add(crearPanelModificarDispositivo(), "Modificar Dispositivo");
        panelPrincipal.add(crearPanelCalcularGastoDia(), "Calcular Gasto por Dia");
        panelPrincipal.add(crearPanelCalcularGastoRango(), "Calcular Gasto por Rango");
        panelPrincipal.add(crearPanelCalcularGastoPorDispositivo(), "Calcular Gasto por Dispositivo");
        panelPrincipal.add(crearPanelCalcularGastoPorDispositivoEnRango(), "Calcular Gasto por Dispositivo en Rango");
        panelPrincipal.add(crearPanelEnseñarCategoriaDispositivo(), "Mostrar Categoría y Franjas de Dispositivo");
        panelPrincipal.add(crearPanelGraficoBarrasSemanasMayo(EventosPrecio.diasDeMayo),"Gráfico Consumo por Semanas Mayo");
        panelPrincipal.add(crearPanelGraficoPastel(DispositivosDAO.obtenerTodosDispositivos()),"Gráfico Gasto por Dispositivos Mayo");
         // panelPrincipal.add(crearPanelGraficoHistorigrama(DispositivosDAO.obtenerTodosDispositivos()),"Gráfico Historigrama");

        add(panelPrincipal, BorderLayout.CENTER);
        setVisible(true);

        // Ejecutar funciones iniciales
        Dispositivo.rellenarArrayDispositivosDefault();
        cargarDispositivosBDD();
        cargarDispositivosDefaultComboBox(Dispositivo.getDispositivosDefault());
        cargarComboDiasMayo(EventosPrecio.diasDeMayo);
    } // fin del constructor

    private void mostrarPanel(String panel) {
        cardLayout.show(panelPrincipal, panel);
    }


    //panel grafico barras semanas de mayo

    private ChartPanel crearPanelGraficoBarrasSemanasMayo(String[] diasDeMayo) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        float gastoSemana1=EventosPrecioDAO.calcularConsumoPorRango("2024-05-01", "2024-05-07");
        float gastoSemana2=EventosPrecioDAO.calcularConsumoPorRango("2024-05-07", "2024-05-14");
        float gastoSemana3=EventosPrecioDAO.calcularConsumoPorRango("2024-05-14", "2024-05-21");
        float gastoSemana4=EventosPrecioDAO.calcularConsumoPorRango("2024-05-21", "2024-05-28");
      
        dataset.addValue(gastoSemana1,"Semana 1","2024-05-01 / 2024-05-07");
        dataset.addValue(gastoSemana2,"Semana 2","2024-05-07 / 2024-05-14");
        dataset.addValue(gastoSemana3,"Semana 3","2024-05-14 / 2024-05-21");
        dataset.addValue(gastoSemana4,"Semana 4","2024-05-21 / 2024-05-28");


        JFreeChart chart = ChartFactory.createBarChart(
                "Consumo por Semanas en Mayo", 
                "Semanas", 
                "Consumo(€)", 
                dataset, 
                PlotOrientation.VERTICAL, 
                true, true, false);

                //CategoryPlot plot = chart.getCategoryPlot();
        //CategoryAxis xAxis = plot.getDomainAxis();
        //xAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45); // Rotar las etiquetas del eje X 45 grados

        //BarRenderer renderer = (BarRenderer) plot.getRenderer();
        //renderer.setMaximumBarWidth(0.15); // Ajustar el ancho de las barras

        return new ChartPanel(chart);
    }


    //panel grafico pastel

    private ChartPanel crearPanelGraficoPastel(ArrayList<Dispositivo> dispositivos) {
       

        DefaultPieDataset dataset = new DefaultPieDataset();


        for (Dispositivo dispositivo : dispositivos) {

            float resultado=EventosPrecioDAO.calculoConsumoPorDispositivo(dispositivo);
            String descripcion=dispositivo.getDescripcion();
            dataset.setValue(descripcion,resultado);

        }
  
          JFreeChart chart = ChartFactory.createPieChart(
                 "Gasto por Dispositivo durante Mayo",
                 dataset,
                 true,true,false);
  
          return new ChartPanel(chart);
      }


      //panel grafico historigrama TO DO

    private ChartPanel crearPanelGraficoHistorigrama(ArrayList<Dispositivo> dispositivos) {
       
        float resultadoDisp0=EventosPrecioDAO.calculoConsumoPorDispositivo(dispositivos.get(0));
  
          DefaultCategoryDataset dataset = new DefaultCategoryDataset();
          dataset.addValue(resultadoDisp0, "Series1", "Category1");
          dataset.addValue(2, "Series1", "Category2");
          dataset.addValue(3, "Series1", "Category3");
          dataset.addValue(4, "Series1", "Category4");
          dataset.addValue(1, "Series2", "Category5");
          dataset.addValue(6, "Series2", "Category6");
          dataset.addValue(7, "Series2", "Category7");
          dataset.addValue(8, "Series2", "Category8");
  
          JFreeChart chart = ChartFactory.createBarChart(
                  "Titulo del grafico", 
                  "Subtitulo del grafico abajito", 
                  "Unidad medida (Euros)", 
                  dataset, 
                  PlotOrientation.VERTICAL, 
                  true, true, false);
  
          return new ChartPanel(chart);
      }

    //panel agregar dispositivo
    private JPanel crearPanelAgregarDispositivo() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));

        JLabel etiquetaNombreDispositivo = new JLabel("Seleccione el dispositivo para agregar: ");
        comboSeleccionarDispositivo = new JComboBox<>();

        JLabel etiquetaDescripcionDispositivo = new JLabel("Descripcion del Dispositivo: ");
        txtDispositivoDescripcion = new JTextField();
        btnAgregarDispositivo = new JButton("Agregar Dispositivo");
        btnActualizarBaseDatos = new JButton("Actualizar Base de Datos");

        btnAgregarDispositivo.addActionListener(this::agregarDispositivo);
        btnActualizarBaseDatos.addActionListener(this::funcionesActualizacionBD);

        panel.add(etiquetaNombreDispositivo);
        panel.add(comboSeleccionarDispositivo);
        panel.add(etiquetaDescripcionDispositivo);
        panel.add(txtDispositivoDescripcion);
        panel.add(btnAgregarDispositivo);
        panel.add(btnActualizarBaseDatos);
        return panel;
    }

    private JPanel crearPanelEliminarDispositivo() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
        JButton btnEliminarDispositivo = new JButton("Eliminar Dispositivo");
        JLabel etiquetaElegirDispositivo = new JLabel("Elegir Dispositivo");
        comboDispositivosEliminar = new JComboBox<>();
        btnEliminarDispositivo.addActionListener(e -> eliminarDispositivo());
        panel.add(etiquetaElegirDispositivo);
        panel.add(comboDispositivosEliminar);
        panel.add(btnEliminarDispositivo);
        return panel;
    }

    private JPanel crearPanelModificarDispositivo() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
        JButton btnModificarDispositivo = new JButton("Modificar Dispositivo");
        JLabel etiquetaModificarDispositivo = new JLabel("Seleccione Dispositivo a Modificar");
        JLabel etiquetaNuevaDescripcion = new JLabel("Nueva descripcion del dispositivo");
        comboDispositivosModificar = new JComboBox<>();
        txtDispositivoModificar = new JTextField();
        btnModificarDispositivo.addActionListener(e -> modificarDispositivo());
        panel.add(etiquetaModificarDispositivo);
        panel.add(comboDispositivosModificar);
        panel.add(etiquetaNuevaDescripcion);
        panel.add(txtDispositivoModificar);
        panel.add(btnModificarDispositivo);
        return panel;
    }



    private JPanel crearPanelCalcularGastoDia() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
        JButton btnCalcularGastoDia = new JButton("Calcular Gasto en el Dia indicado");
        JLabel etiquetaElegirDia = new JLabel("Seleccione un día para ver el gasto total");
        comboSeleccionDia1 = new JComboBox<>();
        btnCalcularGastoDia.addActionListener(this::calcularGastoDia);
        panel.add(etiquetaElegirDia);
        panel.add(comboSeleccionDia1);
        panel.add(btnCalcularGastoDia);
        return panel;
    }

    private JPanel crearPanelCalcularGastoRango() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
        JButton btnCalcularGastoRango = new JButton("Calcular Gasto en el rango indicado");
        JLabel etiquetaElegirRango1 = new JLabel("Seleccione el primer dia del rango");
        JLabel etiquetaElegirRango2 = new JLabel("Seleccione el segundo dia del rango");
        comboSeleccionDia2 = new JComboBox<>();
        comboSeleccionDia3 = new JComboBox<>();
        btnCalcularGastoRango.addActionListener(this::calcularGastoRango);
        panel.add(etiquetaElegirRango1);
        panel.add(comboSeleccionDia2);
        panel.add(etiquetaElegirRango2);
        panel.add(comboSeleccionDia3);
        panel.add(btnCalcularGastoRango);
        return panel;
    }

    private JPanel crearPanelCalcularGastoPorDispositivo() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
        JButton btnCalcularGastoPorDispositivo = new JButton("Calcular Gasto Dispositivo");
        JLabel etiquetaElegirDispositivoGasto = new JLabel("Seleccione el dispositivo");
        comboSeleccionaDispositivoCalculo = new JComboBox<>();
        btnCalcularGastoPorDispositivo.addActionListener(this::calcularGastoPorDispositivo);
        panel.add(etiquetaElegirDispositivoGasto);
        panel.add(comboSeleccionaDispositivoCalculo);
        panel.add(btnCalcularGastoPorDispositivo);
        return panel;
    }

    private JPanel crearPanelCalcularGastoPorDispositivoEnRango() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
        JButton btnCalcularGastoPorDispositivoEnRango = new JButton("Calcular Gasto Dispositivo en Rango");
        JLabel etiquetaElegirDispositivoGastoEnRango = new JLabel("Seleccione el dispositivo");
        JLabel etiquetaElegirFechaDispositivoEnRango1 = new JLabel("Seleccione el primer dia del rango");
        JLabel etiquetaElegirFechaDispositivoEnRango2 = new JLabel("Seleccione el ultimo dia del rango");
        comboSeleccionaDispositivoEnRango = new JComboBox<>();
        comboSeleccionDia4 = new JComboBox<>();
        comboSeleccionDia5 = new JComboBox<>();
        btnCalcularGastoPorDispositivoEnRango.addActionListener(this::calcularGastoPorDispositivoEnRango);
        panel.add(etiquetaElegirDispositivoGastoEnRango);
        panel.add(comboSeleccionaDispositivoEnRango);
        panel.add(etiquetaElegirFechaDispositivoEnRango1);
        panel.add(comboSeleccionDia4);
        panel.add(etiquetaElegirFechaDispositivoEnRango2);
        panel.add(comboSeleccionDia5);
        panel.add(btnCalcularGastoPorDispositivoEnRango);
        return panel;
    }

    private JPanel crearPanelEnseñarCategoriaDispositivo() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
        JButton btnCategoriaDispositivo = new JButton("Mostrar Categoria de Dispositivo");
        JLabel etiquetaElegirDispositivoCategoria = new JLabel("Seleccione el dispositivo");
        comboSeleccionaDispositivoCategoria = new JComboBox<>();
        btnCategoriaDispositivo.addActionListener(this::enseñarCategoriaDispositivo);
        panel.add(etiquetaElegirDispositivoCategoria);
        panel.add(comboSeleccionaDispositivoCategoria);
        panel.add(btnCategoriaDispositivo);
        return panel;
    }

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

    private void cargarDispositivosBDD() {
        ArrayList<Dispositivo> dispositivos = DispositivosDAO.obtenerTodosDispositivos();
        comboDispositivosEliminar.removeAllItems();
        comboDispositivosModificar.removeAllItems();
        comboSeleccionaDispositivoCategoria.removeAllItems();
        for (Dispositivo dispositivo : dispositivos) {
            comboDispositivosEliminar.addItem(dispositivo);
            comboDispositivosModificar.addItem(dispositivo);
            comboSeleccionaDispositivoCalculo.addItem(dispositivo);
            comboSeleccionaDispositivoEnRango.addItem(dispositivo);
            comboSeleccionaDispositivoCategoria.addItem(dispositivo);
        }
    }

    private void cargarDispositivosDefaultComboBox(ArrayList<String> dispositivosDefault) {
        for (String dispositivo : dispositivosDefault) {
            comboSeleccionarDispositivo.addItem(dispositivo);
        }
    }

    private void eliminarDispositivo() {
        Dispositivo dispositivo = (Dispositivo) comboDispositivosEliminar.getSelectedItem();
        if (dispositivo != null) {
            if (DispositivosDAO.eliminarDispositivo(dispositivo.getId())) {
                JOptionPane.showMessageDialog(this, "Dispositivo eliminado exitosamente.");
                cargarDispositivosBDD();
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar dispositivo.");
            }
        }
    }

    private void modificarDispositivo() {
        Dispositivo dispositivo = (Dispositivo) comboDispositivosModificar.getSelectedItem();
        if (dispositivo != null) {
            if (DispositivosDAO.modificarDescripcionDispositivo(dispositivo.getId(), txtDispositivoModificar.getText())) {
                JOptionPane.showMessageDialog(this, "Dispositivo modificado correctamente");
                cargarDispositivosBDD();
            } else {
                JOptionPane.showMessageDialog(this, "Error al modificar dispositivo.");
            }
        }
    }

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

    private void calcularGastoDia(ActionEvent event) {
        NumberFormat truncar = NumberFormat.getInstance();
        truncar.setMaximumFractionDigits(2);
        truncar.setGroupingUsed(false);
        String diaElegido = comboSeleccionDia1.getSelectedItem().toString();
        float gastoTotal = EventosPrecioDAO.calcularConsumoPorDia(diaElegido);
        String mensaje = "El dia " + diaElegido + " se gastó " + truncar.format(gastoTotal) + " Euros en total en el importe de la luz";
        JOptionPane.showMessageDialog(this, mensaje);
    }

    private void calcularGastoRango(ActionEvent event) {
        NumberFormat truncar = NumberFormat.getInstance();
        truncar.setMaximumFractionDigits(2);
        truncar.setGroupingUsed(false);
        String diaElegido1 = comboSeleccionDia2.getSelectedItem().toString();
        String diaElegido2 = comboSeleccionDia3.getSelectedItem().toString();
        float gastoTotal = EventosPrecioDAO.calcularConsumoPorRango(diaElegido1, diaElegido2);
        String mensaje = "Entre el " + diaElegido1 + " y el " + diaElegido2 + " se gastó " + truncar.format(gastoTotal) + " Euros en total en el importe de la luz.";
        JOptionPane.showMessageDialog(this, mensaje);
    }

    private void calcularGastoPorDispositivo(ActionEvent event) {
        NumberFormat truncar = NumberFormat.getInstance();
        truncar.setMaximumFractionDigits(2);
        truncar.setGroupingUsed(false);
        Dispositivo dispositivo = (Dispositivo) comboSeleccionaDispositivoCalculo.getSelectedItem();
        float gastoTotal = EventosPrecioDAO.calculoConsumoPorDispositivo(dispositivo);
        String mensaje = "El gasto total del dispositivo " + dispositivo.getDescripcion() + " durante todo el mes ha sido de " + truncar.format(gastoTotal) + " Euros";
        JOptionPane.showMessageDialog(this, mensaje);
    }

    private void calcularGastoPorDispositivoEnRango(ActionEvent event) {
        NumberFormat truncar = NumberFormat.getInstance();
        truncar.setMaximumFractionDigits(2);
        truncar.setGroupingUsed(false);
        Dispositivo dispositivo = (Dispositivo) comboSeleccionaDispositivoEnRango.getSelectedItem();
        String diaElegido1 = comboSeleccionDia4.getSelectedItem().toString();
        String diaElegido2 = comboSeleccionDia5.getSelectedItem().toString();
        float gastoTotal = EventosPrecioDAO.calculoConsumoPorDispositivoEnRango(dispositivo, diaElegido1, diaElegido2);
        String mensaje = "El gasto total del dispositivo " + dispositivo.getDescripcion() + " entre el " + diaElegido1 + " y el " + diaElegido2 + " ha sido de " + truncar.format(gastoTotal) + " Euros";
        JOptionPane.showMessageDialog(this, mensaje);
    }

    private void cargarComboDiasMayo(String[] diasMayo) {
        for (String dia : diasMayo) {
            comboSeleccionDia1.addItem(dia);
            comboSeleccionDia2.addItem(dia);
            comboSeleccionDia3.addItem(dia);
            comboSeleccionDia4.addItem(dia);
            comboSeleccionDia5.addItem(dia);
        }
    }

    private void enseñarCategoriaDispositivo(ActionEvent event) {
        Dispositivo dispositivo = (Dispositivo) comboSeleccionaDispositivoCategoria.getSelectedItem();
        int idDispositivo = dispositivo.getId();
        Categoria categoria = DispositivosDAO.obtenerCategoriaDispositivo(idDispositivo);
    
        // Obtener las franjas horarias y sus niveles de prioridad
        List<Dispositivos_has_franjaHoraria> franjasHorarias = DispositivosDAO.obtenerFranjasHorariasDispositivo(idDispositivo); // Obtener las franjas horarias del dispositivo
    
        StringBuilder mensaje = new StringBuilder(); // Mensaje a mostrar en el cuadro de diálogo
        mensaje.append("El dispositivo ") // Añadir la descripción del dispositivo y la categoría a la variable mensaje
               .append(dispositivo.getDescripcion()) // Añadir la descripción del dispositivo
               .append(" pertenece a la categoría: ")
               .append(categoria.getNombre()) // Añadir el nombre de la categoría
               .append(" - ")
               .append(categoria.getDescripcion()) // Añadir la descripción de la categoría
               .append("\n\nFranjas Horarias:\n"); // Añadir un salto de línea y el texto "Franjas Horarias:"
    
        for (Dispositivos_has_franjaHoraria franja : franjasHorarias) { // Recorrer todas las franjas horarias
            mensaje.append(franja.toString()).append("\n"); // Añadir la franja horaria a la variable mensaje
        }
    
        JOptionPane.showMessageDialog(this, mensaje.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MonitorizacionGUI().setVisible(true));
    }
}
