package inmueble;

public class CasaRural extends Casa {
    protected static double valorArea = 1500000;
    protected int distanciaCabecera;
    protected int altitud;

    public CasaRural(int id, int area, String direccion, int habitaciones, int banos,
                     int pisos, int distancia, int altitud) {
        super(id, area, direccion, habitaciones, banos, pisos);
        this.distanciaCabecera = distancia;
        this.altitud = altitud;
    }

    public void imprimir() {
        super.imprimir();
        System.out.println("Distancia a la cabecera municipal = " + distanciaCabecera + " km");
        System.out.println("Altitud sobre el nivel del mar = " + altitud + " metros");
        System.out.println();
    }
}