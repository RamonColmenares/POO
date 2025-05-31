package GeometriaApp.UI;

import GeometriaApp.Figuras.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Esta clase denominada VentanaPrisma define una interfaz gráfica
 * que permitirá calcular el volumen y superficie de un prisma rectangular
 * 
 * @version 1.0/2025
 */
public class VentanaPrisma extends JFrame implements ActionListener {
    // Un contenedor de elementos gráficos
    private Container contenedor;
    /*
     * Etiquetas estáticas para identificar los campos de texto a ingresar
     * y calcular
     */
    private JLabel base, anchura, altura, volumen, superficie, imagenLabel;
    // Campos de texto a ingresar
    private JTextField campoBase, campoAnchura, campoAltura;
    // Botón para realizar los cálculos numéricos
    private JButton calcular;

    /**
     * Constructor de la clase VentanaPrisma
     */
    public VentanaPrisma() {
        inicio();
        setTitle("Prisma Rectangular"); // Establece el título de la ventana
        setSize(400, 350); // Establece el tamaño de la ventana
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
        
        // Imagen del prisma usando gráfico personalizado
        JPanel panelPrisma = GraficadorFiguras.crearPrisma();
        panelPrisma.setBounds(20, 20, 120, 120);
        panelPrisma.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelPrisma.setBackground(Color.WHITE);

        // Establece la etiqueta y campo de texto para la base del prisma
        base = new JLabel();
        base.setText("Base (cms):");
        base.setBounds(160, 20, 135, 23);
        campoBase = new JTextField();
        campoBase.setBounds(240, 20, 135, 23);
        
        // Establece la etiqueta y campo de texto para la anchura del prisma
        anchura = new JLabel();
        anchura.setText("Anchura (cms):");
        anchura.setBounds(160, 50, 135, 23);
        campoAnchura = new JTextField();
        campoAnchura.setBounds(240, 50, 135, 23);

        // Establece la etiqueta y campo de texto para la altura del prisma
        altura = new JLabel();
        altura.setText("Altura (cms):");
        altura.setBounds(160, 80, 135, 23);
        campoAltura = new JTextField();
        campoAltura.setBounds(240, 80, 135, 23);

        /*
         * Establece el botón para calcular el volumen y superficie del
         * prisma
         */
        calcular = new JButton();
        calcular.setText("Calcular");
        calcular.setBounds(240, 120, 135, 23);
        /*
         * Agrega al botón un ActionListener para que gestione eventos
         * del botón
         */
        calcular.addActionListener(this);
        
        // Establece la etiqueta y el valor del volumen del prisma
        volumen = new JLabel();
        volumen.setText("Volumen (cm3):");
        volumen.setBounds(20, 170, 350, 23);
        
        // Establece la etiqueta y el valor de la superficie del prisma
        superficie = new JLabel();
        superficie.setText("Superficie (cm2):");
        superficie.setBounds(20, 200, 350, 23);
        
        // Se añade cada componente gráfico al contenedor de la ventana
        contenedor.add(panelPrisma);
        contenedor.add(base);
        contenedor.add(campoBase);
        contenedor.add(anchura);
        contenedor.add(campoAnchura);
        contenedor.add(altura);
        contenedor.add(campoAltura);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
    }

    /**
     * Método que gestiona los eventos generados en la ventana del
     * prisma
     */
    public void actionPerformed(ActionEvent event) {
        // Se inicializan las dimensiones del prisma
        boolean error = false; /*
                                * Se inicializa variable para determinar si
                                * ocurre un error
                                */
        double base = 0;
        double anchura = 0;
        double altura = 0;
        try {
            // Se obtienen las dimensiones del prisma ingresadas
            base = Double.parseDouble(campoBase.getText());
            anchura = Double.parseDouble(campoAnchura.getText());
            altura = Double.parseDouble(campoAltura.getText());
            Prisma prisma = new Prisma(base, anchura, altura); /*
                                                                * Se crea un
                                                                * objeto Prisma
                                                                */
            // Se calcula y muestra el volumen
            volumen.setText("Volumen (cm3): " + String.format("%.2f",
                    prisma.calcularVolumen()));
            // Se calcula y muestra la superficie
            superficie.setText("Superficie (cm2): " + String.format("%.2f",
                    prisma.calcularSuperficie()));
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
