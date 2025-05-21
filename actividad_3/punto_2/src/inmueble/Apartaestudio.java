package inmueble;

public class Apartaestudio extends Apartamento {
    protected static double valorArea = 1500000;

    public Apartaestudio(int id, int area, String direccion) {
        super(id, area, direccion, 1, 1); // Solo una habitación y un baño
    }

    public void imprimir() {
        super.imprimir();
        System.out.println();
    }
}