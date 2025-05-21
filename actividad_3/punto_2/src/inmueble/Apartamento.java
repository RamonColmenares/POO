package inmueble;

public class Apartamento extends InmuebleVivienda {
    public Apartamento(int id, int area, String direccion, int habitaciones, int banos) {
        super(id, area, direccion, habitaciones, banos);
    }

    public void imprimir() {
        super.imprimir();
    }
}