package GeometriaApp.UI;

import GeometriaApp.Figuras.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Esta clase denominada VentanaCubo define una interfaz gráfica
 * que permitirá calcular el volumen y superficie de un cubo
 * 
 * @version 1.0/2025
 */
public class VentanaCubo extends JFrame implements ActionListener {
    // Un contenedor de elementos gráficos
    private Container contenedor;
    /*
     * Etiquetas estáticas para identificar los campos de texto a ingresar
     * y calcular
     */
    private JLabel lado, volumen, superficie, imagenLabel;
    // Campos de texto a ingresar
    private JTextField campoLado;
    // Botón para realizar los cálculos numéricos
    private JButton calcular;

    /**
     * Constructor de la clase VentanaCubo
     */
    public VentanaCubo() {
        inicio();
        setTitle("Cubo"); // Establece el título de la ventana
        setSize(400, 320); // Establece el tamaño de la ventana
        setLocationRelativeTo(null); /*
                                      * La ventana se posiciona en el
                                      * centro de la pantalla
                                      */
        setResizable(false); /*
                              * Establece que la ventana no sea redimensionable
                              */
    }

    /**
     * Método que crea la ventana con sus diferentes componentes
     * gráficos
     */
    private void inicio() {
        contenedor = getContentPane(); /*
                                        * Obtiene el panel de
                                        * contenidos de la ventana
                                        */
        contenedor.setLayout(null); /*
                                     * Establece que el contenedor no
                                     * tiene un layout
                                     */
        
        // Imagen del cubo usando gráfico personalizado
        JPanel panelCubo = GraficadorFiguras.crearCubo();
        panelCubo.setBounds(20, 20, 120, 120);
        panelCubo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelCubo.setBackground(Color.WHITE);

        // Establece la etiqueta y campo de texto para el lado del cubo
        lado = new JLabel();
        lado.setText("Lado (cms):");
        lado.setBounds(160, 20, 135, 23); /*
                                           * Establece la posición de la
                                           * etiqueta de lado del cubo
                                           */
        campoLado = new JTextField();
        // Establece la posición del campo de texto de lado del cubo
        campoLado.setBounds(240, 20, 135, 23);

        /*
         * Establece el botón para calcular el volumen y superficie del
         * cubo
         */
        calcular = new JButton();
        calcular.setText("Calcular");
        calcular.setBounds(240, 60, 135, 23); /*
                                               * Establece la posición
                                               * del botón calcular
                                               */
        /*
         * Agrega al botón un ActionListener para que gestione eventos
         * del botón
         */
        calcular.addActionListener(this);
        
        // Establece la etiqueta y el valor del volumen del cubo
        volumen = new JLabel();
        volumen.setText("Volumen (cm3):");
        // Establece la posición de la etiqueta de volumen del cubo
        volumen.setBounds(20, 170, 350, 23);
        
        // Establece la etiqueta y el valor de la superficie del cubo
        superficie = new JLabel();
        superficie.setText("Superficie (cm2):");
        // Establece la posición de la etiqueta de superficie del cubo
        superficie.setBounds(20, 200, 350, 23);
        
        // Se añade cada componente gráfico al contenedor de la ventana
        contenedor.add(panelCubo);
        contenedor.add(lado);
        contenedor.add(campoLado);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
    }

    /**
     * Método que gestiona los eventos generados en la ventana del
     * cubo
     */
    public void actionPerformed(ActionEvent event) {
        // Se inicializa el lado del cubo
        boolean error = false; /*
                                * Se inicializa variable para determinar si
                                * ocurre un error
                                */
        double lado = 0;
        try {
            // Se obtiene el lado del cubo ingresado
            lado = Double.parseDouble(campoLado.getText());
            Cubo cubo = new Cubo(lado); /*
                                         * Se crea un
                                         * objeto Cubo
                                         */
            // Se calcula y muestra el volumen
            volumen.setText("Volumen (cm3): " + String.format("%.2f",
                    cubo.calcularVolumen()));
            // Se calcula y muestra la superficie
            superficie.setText("Superficie (cm2): " + String.format("%.2f",
                    cubo.calcularSuperficie()));
        } catch (Exception e) {
            error = true; // Si ocurre una excepción
        } finally {
            if (error) { /*
                          * Si ocurre una excepción, se muestra un mensaje
                          * de error
                          */
                JOptionPane.showMessageDialog(null, "Campo nulo o error en formato de numero",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
