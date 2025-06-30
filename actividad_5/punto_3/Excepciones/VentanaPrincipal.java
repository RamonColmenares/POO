package Excepciones;
import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaPrincipal extends JFrame implements ActionListener{
    private Container contenedor;
    private JLabel lblOperacion, lblValor1, lblValor2, lblValor3, lblValor4, lblResultado;
    private JTextField campoValor1, campoValor2, campoValor3, campoValor4;
    private JTextArea campoResultado;
    private JComboBox<String> comboOperaciones;
    private JButton calcular, limpiar;
    private JPanel panelInputs;
    
    public VentanaPrincipal() {
        inicio();
        setTitle("Calculadora Matemática - Manejo de Excepciones");
        setSize(450, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }
    
    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        lblOperacion = new JLabel("Operación:");
        lblOperacion.setBounds(20, 20, 100, 23);
        
        String[] operaciones = {
            "Seleccionar operación...",
            "Logaritmo Neperiano",
            "Raíz Cuadrada", 
            "Pendiente de Línea",
            "Punto Medio",
            "Ecuación Cuadrática",
            "Conversión de Base"
        };
        
        comboOperaciones = new JComboBox<>(operaciones);
        comboOperaciones.setBounds(130, 20, 280, 25);
        comboOperaciones.addActionListener(this);

        panelInputs = new JPanel();
        panelInputs.setLayout(null);
        panelInputs.setBounds(20, 60, 390, 180);
        panelInputs.setBorder(BorderFactory.createTitledBorder("Parámetros de Entrada"));

        lblValor1 = new JLabel("Valor 1:");
        lblValor1.setBounds(20, 30, 80, 23);
        lblValor1.setVisible(false);
        
        campoValor1 = new JTextField();
        campoValor1.setBounds(110, 30, 120, 23);
        campoValor1.setVisible(false);

        lblValor2 = new JLabel("Valor 2:");
        lblValor2.setBounds(20, 65, 80, 23);
        lblValor2.setVisible(false);
        
        campoValor2 = new JTextField();
        campoValor2.setBounds(110, 65, 120, 23);
        campoValor2.setVisible(false);

        lblValor3 = new JLabel("Valor 3:");
        lblValor3.setBounds(20, 100, 80, 23);
        lblValor3.setVisible(false);
        
        campoValor3 = new JTextField();
        campoValor3.setBounds(110, 100, 120, 23);
        campoValor3.setVisible(false);

        lblValor4 = new JLabel("Valor 4:");
        lblValor4.setBounds(20, 135, 80, 23);
        lblValor4.setVisible(false);
        
        campoValor4 = new JTextField();
        campoValor4.setBounds(110, 135, 120, 23);
        campoValor4.setVisible(false);

        panelInputs.add(lblValor1);
        panelInputs.add(campoValor1);
        panelInputs.add(lblValor2);
        panelInputs.add(campoValor2);
        panelInputs.add(lblValor3);
        panelInputs.add(campoValor3);
        panelInputs.add(lblValor4);
        panelInputs.add(campoValor4);

        lblResultado = new JLabel("Resultado:");
        lblResultado.setBounds(20, 250, 100, 23);

        campoResultado = new JTextArea();
        campoResultado.setBounds(20, 275, 390, 60);
        campoResultado.setLineWrap(true); 
        campoResultado.setWrapStyleWord(true);
        campoResultado.setEditable(false);
        campoResultado.setBorder(BorderFactory.createLoweredBevelBorder());

        calcular = new JButton("Calcular");
        calcular.setBounds(20, 345, 100, 30);
        
        limpiar = new JButton("Limpiar");
        limpiar.setBounds(140, 345, 100, 30);

        contenedor.add(lblOperacion);
        contenedor.add(comboOperaciones);
        contenedor.add(panelInputs);
        contenedor.add(lblResultado);
        contenedor.add(campoResultado);
        contenedor.add(calcular);
        contenedor.add(limpiar);

        calcular.addActionListener(this);
        limpiar.addActionListener(this);
    }
    
    private void configurarInputs(int operacion) {
        lblValor1.setVisible(false);
        campoValor1.setVisible(false);
        lblValor2.setVisible(false);
        campoValor2.setVisible(false);
        lblValor3.setVisible(false);
        campoValor3.setVisible(false);
        lblValor4.setVisible(false);
        campoValor4.setVisible(false);
        
        switch(operacion) {
            case 1: // Logaritmo Neperiano
            case 2: // Raíz Cuadrada
                lblValor1.setText("Número:");
                lblValor1.setVisible(true);
                campoValor1.setVisible(true);
                break;
                
            case 3: // Pendiente de Línea
            case 4: // Punto Medio
                lblValor1.setText("X1:");
                lblValor2.setText("Y1:");
                lblValor3.setText("X2:");
                lblValor4.setText("Y2:");
                lblValor1.setVisible(true);
                campoValor1.setVisible(true);
                lblValor2.setVisible(true);
                campoValor2.setVisible(true);
                lblValor3.setVisible(true);
                campoValor3.setVisible(true);
                lblValor4.setVisible(true);
                campoValor4.setVisible(true);
                break;
                
            case 5: // Ecuación Cuadrática
                lblValor1.setText("a:");
                lblValor2.setText("b:");
                lblValor3.setText("c:");
                lblValor1.setVisible(true);
                campoValor1.setVisible(true);
                lblValor2.setVisible(true);
                campoValor2.setVisible(true);
                lblValor3.setVisible(true);
                campoValor3.setVisible(true);
                break;
                
            case 6: // Conversión de Base
                lblValor1.setText("Número:");
                lblValor2.setText("Base destino:");
                lblValor1.setVisible(true);
                campoValor1.setVisible(true);
                lblValor2.setVisible(true);
                campoValor2.setVisible(true);
                break;
        }
        panelInputs.repaint();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == comboOperaciones) {
            int seleccion = comboOperaciones.getSelectedIndex();
            configurarInputs(seleccion);
            limpiarCampos();
        }
        else if (e.getSource() == calcular) {
            realizarCalculo();
        } 
        else if (e.getSource() == limpiar) {
            limpiarCampos();
        }
    }
    
    private void realizarCalculo() {
        int operacionSeleccionada = comboOperaciones.getSelectedIndex();
        
        if (operacionSeleccionada == 0) {
            JOptionPane.showMessageDialog(this, "Por favor selecciona una operación.");
            return;
        }
        
        try {
            String resultado = "";
            
            switch(operacionSeleccionada) {
                case 1: // Logaritmo Neperiano
                    if (campoValor1.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Por favor ingresa el número.");
                        return;
                    }
                    double valor = Double.parseDouble(campoValor1.getText());
                    resultado = calcularLogaritmo(valor);
                    break;
                    
                case 2: // Raíz Cuadrada
                    if (campoValor1.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Por favor ingresa el número.");
                        return;
                    }
                    valor = Double.parseDouble(campoValor1.getText());
                    resultado = calcularRaizCuadrada(valor);
                    break;
                    
                case 3: // Pendiente de Línea
                    if (campoValor1.getText().trim().isEmpty() || campoValor2.getText().trim().isEmpty() ||
                        campoValor3.getText().trim().isEmpty() || campoValor4.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Por favor ingresa todas las coordenadas.");
                        return;
                    }
                    double x1 = Double.parseDouble(campoValor1.getText());
                    double y1 = Double.parseDouble(campoValor2.getText());
                    double x2 = Double.parseDouble(campoValor3.getText());
                    double y2 = Double.parseDouble(campoValor4.getText());
                    resultado = calcularPendiente(x1, y1, x2, y2);
                    break;
                    
                case 4: // Punto Medio
                    if (campoValor1.getText().trim().isEmpty() || campoValor2.getText().trim().isEmpty() ||
                        campoValor3.getText().trim().isEmpty() || campoValor4.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Por favor ingresa todas las coordenadas.");
                        return;
                    }
                    x1 = Double.parseDouble(campoValor1.getText());
                    y1 = Double.parseDouble(campoValor2.getText());
                    x2 = Double.parseDouble(campoValor3.getText());
                    y2 = Double.parseDouble(campoValor4.getText());
                    resultado = calcularPuntoMedio(x1, y1, x2, y2);
                    break;
                    
                case 5: // Ecuación Cuadrática
                    if (campoValor1.getText().trim().isEmpty() || campoValor2.getText().trim().isEmpty() ||
                        campoValor3.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Por favor ingresa todos los coeficientes.");
                        return;
                    }
                    double a = Double.parseDouble(campoValor1.getText());
                    double b = Double.parseDouble(campoValor2.getText());
                    double c = Double.parseDouble(campoValor3.getText());
                    resultado = calcularEcuacionCuadratica(a, b, c);
                    break;
                    
                case 6: // Conversión de Base
                    if (campoValor1.getText().trim().isEmpty() || campoValor2.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Por favor ingresa el número y la base destino.");
                        return;
                    }
                    int numero = Integer.parseInt(campoValor1.getText());
                    int base = Integer.parseInt(campoValor2.getText());
                    resultado = convertirABase(numero, base);
                    break;
            }
            
            campoResultado.setText(resultado);
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: Por favor ingresa valores numéricos válidos.");
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(this, "Error Aritmético: " + ex.getMessage());
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, "Error de Argumento: " + ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error inesperado: " + ex.getMessage());
        }
    }
    
    private String calcularLogaritmo(double valor) throws ArithmeticException {
        if (valor <= 0) {
            throw new ArithmeticException("El valor debe ser positivo para calcular el logaritmo");
        }
        double resultado = Math.log(valor);
        return "Logaritmo neperiano = " + resultado;
    }
    
    private String calcularRaizCuadrada(double valor) throws ArithmeticException {
        if (valor < 0) {
            throw new ArithmeticException("El valor debe ser no negativo para calcular la raíz cuadrada");
        }
        double resultado = Math.sqrt(valor);
        return "Raíz cuadrada = " + resultado;
    }
    
    private String calcularPendiente(double x1, double y1, double x2, double y2) throws ArithmeticException {
        if (x2 - x1 == 0) {
            throw new ArithmeticException("No se puede calcular la pendiente: línea vertical (x2 - x1 = 0)");
        }
        double pendiente = (y2 - y1) / (x2 - x1);
        return "Pendiente = " + pendiente;
    }
    
    private String calcularPuntoMedio(double x1, double y1, double x2, double y2) {
        double xMedio = (x1 + x2) / 2;
        double yMedio = (y1 + y2) / 2;
        return "Punto medio: (" + xMedio + ", " + yMedio + ")";
    }
    
    private String calcularEcuacionCuadratica(double a, double b, double c) throws ArithmeticException {
        if (a == 0) {
            throw new ArithmeticException("El coeficiente 'a' no puede ser cero en una ecuación cuadrática");
        }
        
        double discriminante = b * b - 4 * a * c;
        
        if (discriminante < 0) {
            throw new ArithmeticException("El discriminante es negativo: no hay raíces reales");
        }
        
        if (discriminante == 0) {
            double raiz = -b / (2 * a);
            return "Raíz única: " + raiz;
        } else {
            double raiz1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double raiz2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            return "Raíz 1: " + raiz1 + "\nRaíz 2: " + raiz2;
        }
    }
    
    private String convertirABase(int numero, int base) throws IllegalArgumentException {
        if (numero < 0) {
            throw new IllegalArgumentException("El número debe ser positivo");
        }
        if (base < 2 || base > 16) {
            throw new IllegalArgumentException("La base debe estar entre 2 y 16");
        }
        
        if (numero == 0) {
            return "Conversión a base " + base + ": 0";
        }
        
        StringBuilder resultado = new StringBuilder();
        String digitos = "0123456789ABCDEF";
        int numeroOriginal = numero;
        
        while (numero > 0) {
            resultado.insert(0, digitos.charAt(numero % base));
            numero /= base;
        }
        
        return "Número " + numeroOriginal + " en base " + base + ": " + resultado.toString();
    }
    
    private void limpiarCampos() {
        campoValor1.setText("");
        campoValor2.setText("");
        campoValor3.setText("");
        campoValor4.setText("");
        campoResultado.setText("");
    }
}
