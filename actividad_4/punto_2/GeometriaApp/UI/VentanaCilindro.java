package GeometriaApp.UI;

import GeometriaApp.Figuras.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaCilindro extends JFrame implements ActionListener {
    // Un contenedor de elementos gráficos
    private Container contenedor;
    /*
     * Etiquetas estáticas para identificar los campos de texto a ingresar
     * y calcular
     */
    private JLabel radio, altura, volumen, superficie, imagenLabel;
    // Campos de texto a ingresar
    private JTextField campoRadio, campoAltura;
    // Botón para realizar los cálculos numéricos
    private JButton calcular;

    /**
     * Constructor de la clase VentanaCilindro
     */
    public VentanaCilindro() {
        inicio();
        setTitle("Cilindro"); // Establece el título de la ventana
        setSize(400, 300); // Establece el tamaño de la ventana
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
     * 
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
        
        // Imagen del cilindro usando gráfico personalizado
        JPanel panelCilindro = GraficadorFiguras.crearCilindro();
        panelCilindro.setBounds(20, 20, 120, 120);
        panelCilindro.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelCilindro.setBackground(Color.WHITE);
        
        // Establece la etiqueta y campo de texto para el radio del cilindro
        radio = new JLabel();
        radio.setText("Radio (cms):");
        radio.setBounds(160, 20, 135, 23); /*
                                           * Establece la posición de la
                                           * etiqueta de radio del cilindro
                                           */
        campoRadio = new JTextField();
        // Establece la posición del campo de texto de radio del cilindro
        campoRadio.setBounds(260, 20, 115, 23);
        // Establece la etiqueta y campo de texto para la altura del cilindro
        altura = new JLabel();
        altura.setText("Altura (cms):");
        altura.setBounds(160, 50, 135, 23); /*
                                            * Establece la posición de la
                                            * etiqueta de altura del cilindro
                                            */
        campoAltura = new JTextField();
        // Establece la posición del campo de texto de altura del cilindro
        campoAltura.setBounds(260, 50, 115, 23);
        /*
         * Establece el botón para calcular el volumen y superficie del
         * cilindro
         */
        calcular = new JButton();
        calcular.setText("Calcular");
        calcular.setBounds(260, 80, 115, 23); /*
                                               * Establece la posición
                                               * del botón calcular
                                               */
        /*
         * Agrega al botón un ActionListener para que gestione eventos
         * del botón
         */
        calcular.addActionListener(this);
        // Establece la etiqueta y el valor del volumen del cilindro
        volumen = new JLabel();
        volumen.setText("Volumen (cm3):");
        // Establece la posición de la etiqueta de volumen del cilindro
        volumen.setBounds(20, 170, 350, 23);
        // Establece la etiqueta y el valor de la superficie del cilindro

        superficie = new JLabel();
        superficie.setText("Superficie (cm2):");
        // Establece la posición de la etiqueta de superficie del cilindro
        superficie.setBounds(20, 200, 350, 23);
        // Se añade cada componente gráfico al contenedor de la ventana
        contenedor.add(panelCilindro);
        contenedor.add(radio);
        contenedor.add(campoRadio);
        contenedor.add(altura);
        contenedor.add(campoAltura);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
    }

    /**
     * Método que gestiona los eventos generados en la ventana del
     * cilindro throws Exception Excepción al ingresar un campo nulo o
     * error en formato de número
     */
    public void actionPerformed(ActionEvent event) {
        // Se inicializan el radio y la altura del cilindro
        boolean error = false; /*
                                * Se inicializa variable para determinar si
                                * ocurre un error
                                */
        double radio = 0;
        double altura = 0;
        try {
            // Se obtiene el radio del cilindro ingresado
            radio = Double.parseDouble(campoRadio.getText());
            // Se obtiene la altura del cilindro ingresada
            altura = Double.parseDouble(campoAltura.getText());
            Cilindro cilindro = new Cilindro(radio, altura); /*
                                                              * Se crea un
                                                              * objeto Cilindro
                                                              */
            // Se calcula y muestra el volumen
            volumen.setText("Volumen (cm3): " + String.format("%.2f",
                    cilindro.calcularVolumen()));
            // Se calcula y muestra la superficie
            superficie.setText("Superficie (cm2): " + String.format("%.2f",
                    cilindro.calcularSuperficie()));
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