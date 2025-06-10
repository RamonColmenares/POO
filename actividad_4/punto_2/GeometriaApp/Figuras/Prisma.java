package GeometriaApp.Figuras;

/**
 * Esta clase denominada Prisma define una figura geométrica específica
 * que permite calcular su volumen y superficie
 * 
 * @version 1.0/2025
 */
public class Prisma extends FiguraGeométrica {
    private double base; // Atributo que establece la base de un prisma rectangular
    private double anchura; // Atributo que establece la anchura de un prisma rectangular
    private double altura; // Atributo que establece la altura de un prisma rectangular

    /**
     * Constructor de la clase Prisma
     * 
     * @param base    Parámetro que define la base de un prisma rectangular
     * @param anchura Parámetro que define la anchura de un prisma rectangular
     * @param altura  Parámetro que define la altura de un prisma rectangular
     */
    public Prisma(double base, double anchura, double altura) {
        this.base = base;
        this.anchura = anchura;
        this.altura = altura;
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
     * Método para calcular el volumen de un prisma rectangular
     * 
     * @return El volumen de un prisma rectangular
     */
    public double calcularVolumen() {
        double volumen = base * anchura * altura;
        return volumen;
    }

    /**
     * Método para calcular la superficie de un prisma rectangular
     * 
     * @return La superficie de un prisma rectangular
     */
    public double calcularSuperficie() {
        double superficie = 2 * (base * anchura + base * altura + anchura * altura);
        return superficie;
    }
}
