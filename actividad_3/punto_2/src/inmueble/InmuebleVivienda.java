package inmueble;

public class InmuebleVivienda extends Inmueble {
    protected int numeroHabitaciones;
    protected int numeroBanos;

    public InmuebleVivienda(int id, int area, String direccion, int habitaciones, int banos) {
        super(id, area, direccion);
        this.numeroHabitaciones = habitaciones;
        this.numeroBanos = banos;
    }

    public void imprimir() {
        super.imprimir();
        System.out.println("Número de habitaciones = " + numeroHabitaciones);
        System.out.println("Número de baños = " + numeroBanos);
    }
}
