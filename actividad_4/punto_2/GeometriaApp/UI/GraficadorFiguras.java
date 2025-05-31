package GeometriaApp.UI;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Clase utilitaria para cargar y mostrar imágenes de figuras geométricas
 * 
 * @version 1.0/2025
 */
public class GraficadorFiguras {
    
    /**
     * Carga una imagen desde la carpeta imagenes usando rutas relativas
     * @param nombreArchivo nombre del archivo de imagen
     * @return BufferedImage o null si no se puede cargar
     */
    private static BufferedImage cargarImagen(String nombreArchivo) {
        // Lista de rutas relativas posibles para buscar las imágenes
        String[] rutasPosibles = {
            "GeometriaApp/imagenes/" + nombreArchivo,     // Desde directorio padre
            "imagenes/" + nombreArchivo,                   // Desde directorio actual
            "./GeometriaApp/imagenes/" + nombreArchivo,   // Ruta explícita relativa
            "../imagenes/" + nombreArchivo                 // Un nivel arriba
        };
        
        for (String ruta : rutasPosibles) {
            try {
                File archivo = new File(ruta);
                if (archivo.exists()) {
                    System.out.println("Imagen encontrada en: " + archivo.getAbsolutePath());
                    return ImageIO.read(archivo);
                }
            } catch (IOException e) {
                // Continuar con la siguiente ruta
            }
        }
        
        System.err.println("No se pudo encontrar la imagen: " + nombreArchivo);
        System.err.println("Directorio de trabajo actual: " + System.getProperty("user.dir"));
        return null;
    }
    
    /**
     * Crea un panel genérico para mostrar una imagen escalada
     * @param imagen la imagen a mostrar
     * @param nombreFigura nombre de la figura para mostrar si no hay imagen
     * @return JPanel con la imagen escalada o texto alternativo
     */
    private static JPanel crearPanelImagen(BufferedImage imagen, String nombreFigura) {
        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (imagen != null) {
                    // Obtener dimensiones del panel
                    int panelWidth = getWidth();
                    int panelHeight = getHeight();
                    
                    // Aplicar anti-aliasing para mejor calidad
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, 
                                       RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                    g2d.setRenderingHint(RenderingHints.KEY_RENDERING, 
                                       RenderingHints.VALUE_RENDER_QUALITY);
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                                       RenderingHints.VALUE_ANTIALIAS_ON);
                    
                    // Escalar la imagen para que ocupe todo el panel manteniendo proporciones
                    int imgWidth = imagen.getWidth();
                    int imgHeight = imagen.getHeight();
                    
                    // Calcular escalas para mantener proporciones
                    double scaleX = (double) panelWidth / imgWidth;
                    double scaleY = (double) panelHeight / imgHeight;
                    double scale = Math.min(scaleX, scaleY); // Usar la escala menor para mantener proporciones
                    
                    // Calcular nuevo tamaño
                    int newWidth = (int) (imgWidth * scale);
                    int newHeight = (int) (imgHeight * scale);
                    
                    // Calcular posición para centrar
                    int x = (panelWidth - newWidth) / 2;
                    int y = (panelHeight - newHeight) / 2;
                    
                    // Dibujar la imagen escalada y centrada
                    g2d.drawImage(imagen, x, y, newWidth, newHeight, this);
                } else {
                    // Si no hay imagen, mostrar texto alternativo
                    g.setColor(Color.BLACK);
                    g.setFont(new Font("Arial", Font.BOLD, 12));
                    FontMetrics fm = g.getFontMetrics();
                    String texto = nombreFigura;
                    int x = (getWidth() - fm.stringWidth(texto)) / 2;
                    int y = (getHeight() + fm.getAscent()) / 2;
                    g.drawString(texto, x, y);
                }
            }
        };
    }
    
    /**
     * Crea un panel que muestra la imagen de un cilindro
     * @return JPanel con la imagen del cilindro
     */
    public static JPanel crearCilindro() {
        BufferedImage imagen = cargarImagen("cilindro.png");
        return crearPanelImagen(imagen, "Cilindro");
    }
    
    /**
     * Crea un panel que muestra la imagen de una esfera
     * @return JPanel con la imagen de la esfera
     */
    public static JPanel crearEsfera() {
        BufferedImage imagen = cargarImagen("esfera.png");
        return crearPanelImagen(imagen, "Esfera");
    }
    
    /**
     * Crea un panel que muestra la imagen de una pirámide
     * @return JPanel con la imagen de la pirámide
     */
    public static JPanel crearPiramide() {
        BufferedImage imagen = cargarImagen("piramide.png");
        return crearPanelImagen(imagen, "Pirámide");
    }
    
    /**
     * Crea un panel que muestra la imagen de un cubo
     * @return JPanel con la imagen del cubo
     */
    public static JPanel crearCubo() {
        BufferedImage imagen = cargarImagen("cubo.png");
        return crearPanelImagen(imagen, "Cubo");
    }
    
    /**
     * Crea un panel que muestra la imagen de un prisma
     * @return JPanel con la imagen del prisma
     */
    public static JPanel crearPrisma() {
        BufferedImage imagen = cargarImagen("prisma.png");
        return crearPanelImagen(imagen, "Prisma");
    }
}
