package inmueble;

public class CasaUrbana extends Casa {
    public CasaUrbana(int id, int area, String direccion, int habitaciones, int banos, int pisos) {
        super(id, area, direccion, habitaciones, banos, pisos);
    }

    public void imprimir() {
        super.imprimir();
        System.out.println();
    }
}