package Excepciones;
import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaPrincipal extends JFrame implements ActionListener{
    private Container contenedor;
    private JLabel numerador, denominador, resultado;
    private JTextField campoNumerador, campoDenominador, campoResultado;
    private JButton calcular, limpiar;

    
    public VentanaPrincipal() {
        inicio();
        setTitle("División");
        setSize(280, 220);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }
    double calcularResultado(double numerador, double denominador) {
        return numerador / denominador;
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        numerador = new JLabel("Numerador:");
        numerador.setBounds(20, 20, 135, 23);
        denominador = new JLabel("Denominador:");
        denominador.setBounds(20, 60, 135, 23);
        resultado = new JLabel("Resultado:");
        resultado.setBounds(20, 100, 135, 23);

        campoNumerador = new JTextField();
        campoNumerador.setBounds(105, 20, 135, 23);
        campoDenominador = new JTextField();
        campoDenominador.setBounds(105, 60, 135, 23);
        campoResultado = new JTextField();
        campoResultado.setBounds(105, 100, 135, 23);
        campoResultado.setEditable(false);

        calcular = new JButton("Calcular");
        calcular.setBounds(20, 140, 100, 20);
        limpiar = new JButton("Limpiar");
        limpiar.setBounds(135, 140, 100, 20);

        contenedor.add(numerador);
        contenedor.add(campoNumerador);
        contenedor.add(denominador);
        contenedor.add(campoDenominador);
        contenedor.add(resultado);
        contenedor.add(campoResultado);
        contenedor.add(calcular);
        contenedor.add(limpiar);

        calcular.addActionListener(this);
        limpiar.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calcular) {
            try {
                double numerador = Double.parseDouble(campoNumerador.getText());
                double denominador = Double.parseDouble(campoDenominador.getText());
                campoResultado.setText(String.valueOf(calcularResultado(numerador, denominador)));
            } catch (ArithmeticException ex) {
                JOptionPane.showMessageDialog(this, "Error: División por cero no permitida.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error: Ingresa un valor numerico valido.");
            }
        } else if (e.getSource() == limpiar) {
            campoNumerador.setText("");
            campoDenominador.setText("");
            campoResultado.setText("");
        }
    }
}
