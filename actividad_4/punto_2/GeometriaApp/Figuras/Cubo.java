package GeometriaApp.Figuras;

/**
 * Esta clase denominada Cubo define una figura geométrica específica
 * que permite calcular su volumen y superficie
 * 
 * @version 1.0/2025
 */
public class Cubo extends FiguraGeométrica {
    private double lado; // Atributo que establece el lado de un cubo

    /**
     * Constructor de la clase Cubo
     * 
     * @param lado Parámetro que define el lado de un cubo
     */
    public Cubo(double lado) {
        this.lado = lado;
        this.setVolumen(calcularVolumen()); /*
                                             * Calcula el volumen y
                                             * establece su atributo
                                             */
        this.setSuperficie(calcularSuperficie()); /*
                                                   * Calcula la superficie y
                                                   * establece su atributo
                                                   */
    }

    /**
     * Método para calcular el volumen de un cubo
     * 
     * @return El volumen de un cubo
     */
    public double calcularVolumen() {
        double volumen = Math.pow(lado, 3.0);
        return volumen;
    }

    /**
     * Método para calcular la superficie de un cubo
     * 
     * @return La superficie de un cubo
     */
    public double calcularSuperficie() {
        double superficie = 6.0 * Math.pow(lado, 2.0);
        return superficie;
    }
}
