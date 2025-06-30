import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaPrincipal extends JFrame implements ActionListener {
    private JComboBox<String> comboOperaciones;
    private JTextField[] campos;
    private JTextArea campoResultado;
    private JButton calcular, limpiar;
    private JLabel[] etiquetas;
    private JPanel panelCampos;
    private ClasePrincipal.EquipoMaraton equipoActual;
    
    private static final String[] OPERACIONES = {
        "Crear Equipo",
        "Agregar Programador",
        "Validar Contraseña"
    };
    
    public VentanaPrincipal() {
        initComponents();
        configurarVentana();
        configurarInputs(0);
    }
    
    private void initComponents() {
        setTitle("Gestión de Equipos de Programación");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        JPanel panelSuperior = new JPanel(new FlowLayout());
        panelSuperior.add(new JLabel("Operación:"));
        comboOperaciones = new JComboBox<>(OPERACIONES);
        comboOperaciones.addActionListener(this);
        panelSuperior.add(comboOperaciones);
        
        panelCampos = new JPanel(new GridBagLayout());
        campos = new JTextField[5];
        etiquetas = new JLabel[5];
        
        for (int i = 0; i < campos.length; i++) {
            campos[i] = new JTextField(20);
            etiquetas[i] = new JLabel();
        }
        
        JPanel panelBotones = new JPanel(new FlowLayout());
        calcular = new JButton("Ejecutar");
        limpiar = new JButton("Limpiar");
        calcular.addActionListener(this);
        limpiar.addActionListener(this);
        panelBotones.add(calcular);
        panelBotones.add(limpiar);
        
        campoResultado = new JTextArea(10, 40);
        campoResultado.setEditable(false);
        campoResultado.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        JScrollPane scrollResultado = new JScrollPane(campoResultado);
        scrollResultado.setBorder(BorderFactory.createTitledBorder("Resultado"));
        
        add(panelSuperior, BorderLayout.NORTH);
        add(panelCampos, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
        add(scrollResultado, BorderLayout.EAST);
    }
    
    private void configurarVentana() {
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    private void configurarInputs(int operacion) {
        panelCampos.removeAll();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        String[] labels = obtenerEtiquetas(operacion);
        int numCampos = labels.length;
        
        for (int i = 0; i < numCampos; i++) {
            etiquetas[i].setText(labels[i]);
            campos[i].setText("");
            campos[i].setVisible(true);
            etiquetas[i].setVisible(true);
            
            gbc.gridx = 0;
            gbc.gridy = i;
            panelCampos.add(etiquetas[i], gbc);
            
            gbc.gridx = 1;
            panelCampos.add(campos[i], gbc);
        }
        
        for (int i = numCampos; i < campos.length; i++) {
            campos[i].setVisible(false);
            etiquetas[i].setVisible(false);
        }
        
        panelCampos.revalidate();
        panelCampos.repaint();
        pack();
    }
    
    private String[] obtenerEtiquetas(int operacion) {
        switch (operacion) {
            case 0:
                return new String[]{"Nombre del Equipo:", "Universidad:", "Lenguaje de Programación:"};
            case 1:
                return new String[]{"Nombre del Programador:", "Apellidos del Programador:"};
            case 2:
                return new String[]{"Contraseña:", "Confirmar Contraseña:"};
            default:
                return new String[]{};
        }
    }
    
    private void realizarCalculo() {
        try {
            int operacion = comboOperaciones.getSelectedIndex();
            String resultado = "";
            
            switch (operacion) {
                case 0:
                    resultado = crearEquipo();
                    break;
                case 1:
                    resultado = agregarProgramador();
                    break;
                case 2:
                    resultado = validarContrasena();
                    break;
            }
            
            campoResultado.setText(resultado);
            campoResultado.setForeground(Color.BLACK);
            
        } catch (Exception e) {
            campoResultado.setText("ERROR: " + e.getMessage());
            campoResultado.setForeground(Color.RED);
        }
    }
    
    private String crearEquipo() throws ClasePrincipal.CampoInvalido {
        String nombreEquipo = campos[0].getText().trim();
        String universidad = campos[1].getText().trim();
        String lenguaje = campos[2].getText().trim();
        
        equipoActual = ClasePrincipal.crearEquipo(nombreEquipo, universidad, lenguaje);
        return "Equipo creado exitosamente:\n" + equipoActual.toString();
    }
    
    private String agregarProgramador() throws ClasePrincipal.CampoInvalido, ClasePrincipal.EquipoCompleto {
        if (equipoActual == null) {
            throw new ClasePrincipal.CampoInvalido("Debe crear un equipo primero.");
        }
        
        String nombre = campos[0].getText().trim();
        String apellidos = campos[1].getText().trim();
        
        ClasePrincipal.Programador programador = ClasePrincipal.crearProgramador(nombre, apellidos);
        equipoActual.agregarProgramador(programador);
        
        return "Programador agregado exitosamente:\n" + equipoActual.toString();
    }
    
    private String validarContrasena() throws ClasePrincipal.ContrasenaInvalida {
        String contrasena = campos[0].getText();
        String confirmacion = campos[1].getText();
        
        return ClasePrincipal.validarContrasenaCompleta(contrasena, confirmacion);
    }
    
    private void limpiarCampos() {
        for (JTextField campo : campos) {
            campo.setText("");
        }
        campoResultado.setText("");
        campoResultado.setForeground(Color.BLACK);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == comboOperaciones) {
            configurarInputs(comboOperaciones.getSelectedIndex());
        } else if (e.getSource() == calcular) {
            realizarCalculo();
        } else if (e.getSource() == limpiar) {
            limpiarCampos();
        }
    }
}
