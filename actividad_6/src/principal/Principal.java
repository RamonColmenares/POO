package principal;

import javax.swing.SwingUtilities;
import vista.VentanaPrincipal;

public class Principal {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                VentanaPrincipal ventana = new VentanaPrincipal();
                ventana.setVisible(true);
            } catch (Exception e) {
                System.err.println("Error al iniciar la aplicación: " + e.getMessage());
            }
        });
    }
}
