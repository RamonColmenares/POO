import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaPrincipal extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel nota1, nota2, nota3, nota4, nota5, promedio, desviacion, menor, mayor;
    private JTextField campoNota1, campoNota2, campoNota3, campoNota4, campoNota5;
    private JButton calcular,limpiar;


    public VentanaPrincipal() {
        inicio();
        setTitle("Notas");
        setSize(280, 380);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }
    

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        nota1 = new JLabel("Nota 1:");
        nota1.setBounds(20, 20, 135, 23);
        campoNota1 = new JTextField();
        campoNota1.setBounds(105, 20, 135, 23);
        
        nota2 = new JLabel("Nota 2:");
        nota2.setBounds(20, 60, 135, 23);
        campoNota2 = new JTextField();
        campoNota2.setBounds(105, 60, 135, 23);
        nota3 = new JLabel("Nota 3:");
        nota3.setBounds(20, 100, 135, 23);
        campoNota3 = new JTextField();
        campoNota3.setBounds(105, 100, 135, 23);
        nota4 = new JLabel("Nota 4:");
        nota4.setBounds(20, 140, 135, 23);
        campoNota4 = new JTextField();
        campoNota4.setBounds(105, 140, 135, 23);
        nota5 = new JLabel("Nota 5:");
        nota5.setBounds(20, 180, 135, 23);
        campoNota5 = new JTextField();
        campoNota5.setBounds(105, 180, 135, 23);

        calcular = new JButton("Calcular");
        calcular.setBounds(20, 210, 100, 20);

        limpiar = new JButton("Limpiar");
        limpiar.setBounds(135, 210, 100, 20);

        calcular.addActionListener(this);
        limpiar.addActionListener(this);


        
        promedio = new JLabel("Promedio: ");
        promedio.setBounds(20, 230, 130, 23);
        desviacion = new JLabel("Desviación Estándar: ");
        desviacion.setBounds(20, 250, 200, 23);
        mayor = new JLabel("Nota Mayor: ");
        mayor.setBounds(20, 270, 120, 23);
        menor = new JLabel("Nota menor: ");
        menor.setBounds(20, 290, 120, 23);

        contenedor.add(nota1);
        contenedor.add(campoNota1);
        contenedor.add(nota2);
        contenedor.add(campoNota2);
        contenedor.add(nota3);
        contenedor.add(campoNota3);
        contenedor.add(nota4);
        contenedor.add(campoNota4);
        contenedor.add(nota5);
        contenedor.add(campoNota5);
        
        contenedor.add(calcular);
        contenedor.add(limpiar);

        contenedor.add(promedio);
        contenedor.add(desviacion);
        contenedor.add(menor);
        contenedor.add(mayor);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calcular) {
            Notas notas = new Notas();
            try {
                notas.listaNotas[0] = Double.parseDouble(campoNota1.getText());
                notas.listaNotas[1] = Double.parseDouble(campoNota2.getText());
                notas.listaNotas[2] = Double.parseDouble(campoNota3.getText());
                notas.listaNotas[3] = Double.parseDouble(campoNota4.getText());
                notas.listaNotas[4] = Double.parseDouble(campoNota5.getText());
                
                promedio.setText("Promedio: " + String.valueOf(String.format("%.2f", notas.calcularPromedio())));
                double des =notas.calcularDesviacion();
                desviacion.setText("Desviación Estándar: " + String.format("%.2f", des));
                mayor.setText("Nota Mayor: " + String.valueOf(notas.calcularMayor()));
                menor.setText("Nota menor: " + String.valueOf(notas.calcularMenor()));

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese valores numéricos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == limpiar) {
            campoNota1.setText("");
            campoNota2.setText("");
            campoNota3.setText("");
            campoNota4.setText("");
            campoNota5.setText("");
            promedio.setText("Promedio: ");
            desviacion.setText("Desviación Estándar: ");
            menor.setText("Nota menor: ");
            mayor.setText("Nota Mayor: ");
        }

        if (e.getSource() == limpiar) {
            campoNota1.setText("");
            campoNota2.setText("");
            campoNota3.setText("");
            campoNota4.setText("");
            campoNota5.setText("");
            promedio.setText("Promedio: ");
            desviacion.setText("Desviación Estándar: ");
            menor.setText("Nota menor: ");
            mayor.setText("Nota Mayor: ");
        }

    }
}
