import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {
    
    private JTextField campoRuta;
    private JComboBox<String> comboOperaciones;
    private JTextArea areaResultado;
    private JButton botonCalcular;
    
    public VentanaPrincipal() {
        inicializarComponentes();
        configurarVentana();
        configurarEventos();
    }
    
    private void inicializarComponentes() {
        campoRuta = new JTextField(30);
        comboOperaciones = new JComboBox<>(new String[]{
            "Leer archivo", 
            "Leer y convertir a mayúsculas"
        });
        areaResultado = new JTextArea(15, 50);
        areaResultado.setEditable(false);
        areaResultado.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        botonCalcular = new JButton("Calcular");
    }
    
    private void configurarVentana() {
        setTitle("Lector de Archivos de Texto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        JPanel panelSuperior = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 5, 5);
        panelSuperior.add(new JLabel("Ruta del archivo:"), gbc);
        
        gbc.gridx = 1; gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(10, 5, 5, 10);
        panelSuperior.add(campoRuta, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0.0;
        gbc.insets = new Insets(5, 10, 5, 5);
        panelSuperior.add(new JLabel("Operación:"), gbc);
        
        gbc.gridx = 1; gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(5, 5, 5, 10);
        panelSuperior.add(comboOperaciones, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0.0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10);
        panelSuperior.add(botonCalcular, gbc);
        
        add(panelSuperior, BorderLayout.NORTH);
        
        JScrollPane scrollPane = new JScrollPane(areaResultado);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Contenido del archivo"));
        add(scrollPane, BorderLayout.CENTER);
        
        pack();
        setLocationRelativeTo(null);
    }
    
    private void configurarEventos() {
        botonCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                procesarArchivo();
            }
        });
        
        campoRuta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                procesarArchivo();
            }
        });
    }
    
    private void procesarArchivo() {
        String ruta = campoRuta.getText().trim();
        
        if (ruta.isEmpty()) {
            mostrarError("Por favor, ingrese la ruta del archivo");
            return;
        }
        
        try {
            String[] lineas = ArchivoUtils.leerArchivo(ruta);
            
            if (comboOperaciones.getSelectedIndex() == 1) {
                lineas = ArchivoUtils.convertirMayusculas(lineas);
            }
            
            mostrarResultado(lineas);
            
        } catch (ArchivoException ex) {
            mostrarError("Error: " + ex.getMessage());
        }
    }
    
    private void mostrarResultado(String[] lineas) {
        StringBuilder sb = new StringBuilder();
        
        if (lineas.length == 0) {
            sb.append("El archivo está vacío.");
        } else {
            for (int i = 0; i < lineas.length; i++) {
                sb.append("Línea ").append(i + 1).append(": ").append(lineas[i]).append("\n");
            }
        }
        
        areaResultado.setText(sb.toString());
        areaResultado.setCaretPosition(0);
    }
    
    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
        areaResultado.setText("");
    }
}
