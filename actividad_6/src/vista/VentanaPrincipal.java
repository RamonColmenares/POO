package vista;

import controlador.ControladorEstudiantes;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import modelo.Estudiante;

public class VentanaPrincipal extends JFrame {
    private ControladorEstudiantes controlador;
    
    private JTextField txtId, txtNombre, txtApellido, txtEmail, txtEdad, txtCarrera, txtPromedio;
    private JTextField txtBuscar;
    private JComboBox<String> cbCriterio;
    private JTable tablaEstudiantes;
    private DefaultTableModel modeloTabla;
    private JButton btnAgregar, btnActualizar, btnEliminar, btnLimpiar, btnBuscar, btnMostrarTodos, btnEstadisticas;
    
    public VentanaPrincipal() {
        this.controlador = new ControladorEstudiantes(this);
        inicializarComponentes();
        configurarVentana();
        cargarDatos();
    }
    
    private void inicializarComponentes() {
        // Panel principal
        setLayout(new BorderLayout());
        
        // Panel superior - Formulario
        JPanel panelFormulario = crearPanelFormulario();
        
        // Panel central - Tabla
        JPanel panelTabla = crearPanelTabla();
        
        // Panel inferior - Botones
        JPanel panelBotones = crearPanelBotones();
        
        // Panel de búsqueda
        JPanel panelBusqueda = crearPanelBusqueda();
        
        // Agregar paneles a la ventana
        add(panelFormulario, BorderLayout.NORTH);
        add(panelTabla, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
        add(panelBusqueda, BorderLayout.EAST);
    }
    
    private JPanel crearPanelFormulario() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Datos del Estudiante"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // Campos de texto
        txtId = new JTextField(15);
        txtNombre = new JTextField(15);
        txtApellido = new JTextField(15);
        txtEmail = new JTextField(15);
        txtEdad = new JTextField(15);
        txtCarrera = new JTextField(15);
        txtPromedio = new JTextField(15);
        
        // Primera fila
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("ID:"), gbc);
        gbc.gridx = 1;
        panel.add(txtId, gbc);
        
        gbc.gridx = 2;
        panel.add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 3;
        panel.add(txtNombre, gbc);
        
        // Segunda fila
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Apellido:"), gbc);
        gbc.gridx = 1;
        panel.add(txtApellido, gbc);
        
        gbc.gridx = 2;
        panel.add(new JLabel("Email:"), gbc);
        gbc.gridx = 3;
        panel.add(txtEmail, gbc);
        
        // Tercera fila
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Edad:"), gbc);
        gbc.gridx = 1;
        panel.add(txtEdad, gbc);
        
        gbc.gridx = 2;
        panel.add(new JLabel("Carrera:"), gbc);
        gbc.gridx = 3;
        panel.add(txtCarrera, gbc);
        
        // Cuarta fila
        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(new JLabel("Promedio:"), gbc);
        gbc.gridx = 1;
        panel.add(txtPromedio, gbc);
        
        return panel;
    }
    
    private JPanel crearPanelTabla() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Lista de Estudiantes"));
        
        // Modelo de tabla
        String[] columnas = {"ID", "Nombre", "Apellido", "Email", "Edad", "Carrera", "Promedio"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hacer la tabla no editable
            }
        };
        
        tablaEstudiantes = new JTable(modeloTabla);
        tablaEstudiantes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        // Evento de selección de fila
        tablaEstudiantes.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int filaSeleccionada = tablaEstudiantes.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    cargarDatosEnFormulario(filaSeleccionada);
                }
            }
        });
        
        JScrollPane scrollPane = new JScrollPane(tablaEstudiantes);
        scrollPane.setPreferredSize(new Dimension(800, 300));
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel crearPanelBotones() {
        JPanel panel = new JPanel(new FlowLayout());
        
        btnAgregar = new JButton("Agregar");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");
        btnLimpiar = new JButton("Limpiar");
        btnMostrarTodos = new JButton("Mostrar Todos");
        btnEstadisticas = new JButton("Estadísticas");
        
        // Configurar colores de botones para mejor visibilidad
        btnAgregar.setBackground(new Color(40, 167, 69));
        btnAgregar.setForeground(Color.WHITE);
        btnAgregar.setOpaque(true);
        btnAgregar.setBorderPainted(false);
        
        btnActualizar.setBackground(new Color(0, 123, 255));
        btnActualizar.setForeground(Color.WHITE);
        btnActualizar.setOpaque(true);
        btnActualizar.setBorderPainted(false);
        
        btnEliminar.setBackground(new Color(220, 53, 69));
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setOpaque(true);
        btnEliminar.setBorderPainted(false);
        
        btnLimpiar.setBackground(new Color(108, 117, 125));
        btnLimpiar.setForeground(Color.WHITE);
        btnLimpiar.setOpaque(true);
        btnLimpiar.setBorderPainted(false);
        
        btnMostrarTodos.setBackground(new Color(255, 193, 7));
        btnMostrarTodos.setForeground(Color.BLACK);
        btnMostrarTodos.setOpaque(true);
        btnMostrarTodos.setBorderPainted(false);
        
        btnEstadisticas.setBackground(new Color(111, 66, 193));
        btnEstadisticas.setForeground(Color.WHITE);
        btnEstadisticas.setOpaque(true);
        btnEstadisticas.setBorderPainted(false);
        
        // Eventos de botones
        btnAgregar.addActionListener(this::accionAgregar);
        btnActualizar.addActionListener(this::accionActualizar);
        btnEliminar.addActionListener(this::accionEliminar);
        btnLimpiar.addActionListener(this::accionLimpiar);
        btnMostrarTodos.addActionListener(this::accionMostrarTodos);
        btnEstadisticas.addActionListener(this::accionEstadisticas);
        
        panel.add(btnAgregar);
        panel.add(btnActualizar);
        panel.add(btnEliminar);
        panel.add(btnLimpiar);
        panel.add(btnMostrarTodos);
        panel.add(btnEstadisticas);
        
        return panel;
    }
    
    private JPanel crearPanelBusqueda() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Búsqueda"));
        panel.setPreferredSize(new Dimension(250, 0));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // Criterio de búsqueda
        String[] criterios = {"nombre", "apellido", "carrera", "email"};
        cbCriterio = new JComboBox<>(criterios);
        
        // Campo de búsqueda
        txtBuscar = new JTextField(15);
        
        // Botón de búsqueda
        btnBuscar = new JButton("Buscar");
        btnBuscar.setBackground(new Color(255, 152, 0));
        btnBuscar.setForeground(Color.BLACK);
        btnBuscar.setOpaque(true);
        btnBuscar.setBorderPainted(false);
        btnBuscar.addActionListener(this::accionBuscar);
        
        // Layout
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(new JLabel("Criterio de búsqueda:"), gbc);
        
        gbc.gridy = 1;
        panel.add(cbCriterio, gbc);
        
        gbc.gridy = 2;
        panel.add(new JLabel("Valor a buscar:"), gbc);
        
        gbc.gridy = 3;
        panel.add(txtBuscar, gbc);
        
        gbc.gridy = 4;
        panel.add(btnBuscar, gbc);
        
        return panel;
    }
    
    private void configurarVentana() {
        setTitle("Sistema de Gestión de Estudiantes - CRUD");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 700);
        setLocationRelativeTo(null);
        setResizable(true);
        
        // Icono de la aplicación (opcional)
        // setIconImage(...)
    }
    
    // Métodos de eventos
    private void accionAgregar(ActionEvent e) {
        try {
            String id = txtId.getText().trim();
            String nombre = txtNombre.getText().trim();
            String apellido = txtApellido.getText().trim();
            String email = txtEmail.getText().trim();
            int edad = Integer.parseInt(txtEdad.getText().trim());
            String carrera = txtCarrera.getText().trim();
            double promedio = Double.parseDouble(txtPromedio.getText().trim());
            
            if (controlador.crearEstudiante(id, nombre, apellido, email, edad, carrera, promedio)) {
                limpiarFormulario();
                cargarDatos();
            }
        } catch (NumberFormatException ex) {
            mostrarMensaje("Por favor, ingrese valores numéricos válidos para edad y promedio", "Error de formato");
        }
    }
    
    private void accionActualizar(ActionEvent e) {
        int filaSeleccionada = tablaEstudiantes.getSelectedRow();
        if (filaSeleccionada < 0) {
            mostrarMensaje("Por favor, seleccione un estudiante para actualizar", "Información");
            return;
        }
        
        try {
            String id = txtId.getText().trim();
            String nombre = txtNombre.getText().trim();
            String apellido = txtApellido.getText().trim();
            String email = txtEmail.getText().trim();
            int edad = Integer.parseInt(txtEdad.getText().trim());
            String carrera = txtCarrera.getText().trim();
            double promedio = Double.parseDouble(txtPromedio.getText().trim());
            
            if (controlador.actualizarEstudiante(id, nombre, apellido, email, edad, carrera, promedio)) {
                limpiarFormulario();
                cargarDatos();
            }
        } catch (NumberFormatException ex) {
            mostrarMensaje("Por favor, ingrese valores numéricos válidos para edad y promedio", "Error de formato");
        }
    }
    
    private void accionEliminar(ActionEvent e) {
        int filaSeleccionada = tablaEstudiantes.getSelectedRow();
        if (filaSeleccionada < 0) {
            mostrarMensaje("Por favor, seleccione un estudiante para eliminar", "Información");
            return;
        }
        
        String id = (String) modeloTabla.getValueAt(filaSeleccionada, 0);
        int confirmacion = JOptionPane.showConfirmDialog(
            this,
            "¿Está seguro de que desea eliminar al estudiante con ID: " + id + "?",
            "Confirmar eliminación",
            JOptionPane.YES_NO_OPTION
        );
        
        if (confirmacion == JOptionPane.YES_OPTION) {
            if (controlador.eliminarEstudiante(id)) {
                limpiarFormulario();
                cargarDatos();
            }
        }
    }
    
    private void accionLimpiar(ActionEvent e) {
        limpiarFormulario();
        tablaEstudiantes.clearSelection();
    }
    
    private void accionMostrarTodos(ActionEvent e) {
        cargarDatos();
        txtBuscar.setText("");
    }
    
    private void accionBuscar(ActionEvent e) {
        String criterio = (String) cbCriterio.getSelectedItem();
        String valor = txtBuscar.getText().trim();
        
        if (valor.isEmpty()) {
            mostrarMensaje("Por favor, ingrese un valor para buscar", "Error de validación");
            return;
        }
        
        List<Estudiante> resultados = controlador.buscarEstudiantes(criterio, valor);
        if (resultados != null) {
            actualizarTabla(resultados);
        }
    }
    
    private void accionEstadisticas(ActionEvent e) {
        String estadisticas = controlador.obtenerEstadisticas();
        JOptionPane.showMessageDialog(this, estadisticas, "Estadísticas del Sistema", JOptionPane.INFORMATION_MESSAGE);
    }
    
    // Métodos auxiliares
    private void cargarDatos() {
        List<Estudiante> estudiantes = controlador.obtenerTodosLosEstudiantes();
        if (estudiantes != null) {
            actualizarTabla(estudiantes);
        }
    }
    
    private void actualizarTabla(List<Estudiante> estudiantes) {
        modeloTabla.setRowCount(0); // Limpiar tabla
        
        for (Estudiante estudiante : estudiantes) {
            Object[] fila = {
                estudiante.getId(),
                estudiante.getNombre(),
                estudiante.getApellido(),
                estudiante.getEmail(),
                estudiante.getEdad(),
                estudiante.getCarrera(),
                estudiante.getPromedio()
            };
            modeloTabla.addRow(fila);
        }
    }
    
    private void cargarDatosEnFormulario(int fila) {
        txtId.setText((String) modeloTabla.getValueAt(fila, 0));
        txtNombre.setText((String) modeloTabla.getValueAt(fila, 1));
        txtApellido.setText((String) modeloTabla.getValueAt(fila, 2));
        txtEmail.setText((String) modeloTabla.getValueAt(fila, 3));
        txtEdad.setText(modeloTabla.getValueAt(fila, 4).toString());
        txtCarrera.setText((String) modeloTabla.getValueAt(fila, 5));
        txtPromedio.setText(modeloTabla.getValueAt(fila, 6).toString());
    }
    
    private void limpiarFormulario() {
        txtId.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtEmail.setText("");
        txtEdad.setText("");
        txtCarrera.setText("");
        txtPromedio.setText("");
    }
    
    // Método público para mostrar mensajes (usado por el controlador)
    public void mostrarMensaje(String mensaje, String titulo) {
        int tipoMensaje = titulo.toLowerCase().contains("error") ? 
            JOptionPane.ERROR_MESSAGE : JOptionPane.INFORMATION_MESSAGE;
        JOptionPane.showMessageDialog(this, mensaje, titulo, tipoMensaje);
    }
}
