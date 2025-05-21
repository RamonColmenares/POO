package inmueble;

public class CasaIndependiente extends CasaUrbana {
    protected static double valorArea = 3000000;

    public CasaIndependiente(int id, int area, String direccion, int habitaciones, int banos, int pisos) {
        super(id, area, direccion, habitaciones, banos, pisos);
    }

    public void imprimir() {
        super.imprimir();
        System.out.println();
    }
}