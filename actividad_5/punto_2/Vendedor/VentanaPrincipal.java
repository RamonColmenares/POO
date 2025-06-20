package Vendedor;
import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class VentanaPrincipal extends JFrame implements ActionListener{
    private Container contenedor;
    private JLabel nombre, apellidos, edad, respuesta;
    private JTextField camponombre, campoapellidos, campoedad;
    private JTextArea camporespuesta;
    private JButton calcular, limpiar;

    
    public VentanaPrincipal() {
        inicio();
        setTitle("Vendedor");
        setSize(280, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }
    private String respuestaEdad(double edad) {
    if (edad <= 0 || edad > 120) {
        return "La edad no puede ser menor o igual a 0, ni mayor a 120";
    }else if (edad < 18) {
        return "Edad no válida, debe ser mayor o igual a 18";
    }else {
        return "Edad válida";
    }
}

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        nombre = new JLabel("nombre:");
        nombre.setBounds(20, 20, 135, 23);
        apellidos = new JLabel("apellidos:");
        apellidos.setBounds(20, 60, 135, 23);
        edad = new JLabel("edad:");
        edad.setBounds(20, 100, 135, 23);
        respuesta = new JLabel("respuesta:");
        respuesta.setBounds(20, 140, 135, 23);

        camponombre = new JTextField();
        camponombre.setBounds(105, 20, 135, 23);
        campoapellidos = new JTextField();
        campoapellidos.setBounds(105, 60, 135, 23);
        campoedad = new JTextField();
        campoedad.setBounds(105, 100, 135, 23);
        camporespuesta = new JTextArea();
        camporespuesta.setBounds(20, 160, 220, 46);
        camporespuesta.setLineWrap(true); 
        camporespuesta.setWrapStyleWord(true);
        camporespuesta.setEditable(false);

        calcular = new JButton("Validar edad");
        calcular.setBounds(10, 220, 120, 20);
        limpiar = new JButton("Limpiar");
        limpiar.setBounds(135, 220, 120, 20);

        contenedor.add(nombre);
        contenedor.add(camponombre);
        contenedor.add(apellidos);
        contenedor.add(campoapellidos);
        contenedor.add(edad);
        contenedor.add(campoedad);
        contenedor.add(respuesta);
        contenedor.add(camporespuesta);
        contenedor.add(calcular);
        contenedor.add(limpiar);

        calcular.addActionListener(this);
        limpiar.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calcular) {
            if (camponombre.getText().trim().isEmpty() || campoapellidos.getText().trim().isEmpty() || campoedad.getText().trim().isEmpty()) {
             JOptionPane.showMessageDialog(this, "Por favor llena todos los campos.");
             return;
            }
            try {
                double edadValue= Double.parseDouble(campoedad.getText());
                String resultado = respuestaEdad(edadValue);
                camporespuesta.setText(resultado);
            
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error: Ingresa una edad valida.");
            }
        } else if (e.getSource() == limpiar) {
            camponombre.setText("");
            campoapellidos.setText("");
            campoedad.setText("");
            camporespuesta.setText("");
        }
    }
}
