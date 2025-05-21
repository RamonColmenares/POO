package inmueble;

public class Casa extends InmuebleVivienda {
    protected int numeroPisos;

    public Casa(int id, int area, String direccion, int habitaciones, int banos, int pisos) {
        super(id, area, direccion, habitaciones, banos);
        this.numeroPisos = pisos;
    }

    public void imprimir() {
        super.imprimir();
        System.out.println("Número de pisos = " + numeroPisos);
    }
}