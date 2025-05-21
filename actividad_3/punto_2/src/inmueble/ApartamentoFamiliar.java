package inmueble;

public class ApartamentoFamiliar extends Apartamento {
    protected static double valorArea = 2000000;
    protected int valorAdministracion;

    public ApartamentoFamiliar(int id, int area, String direccion, int habitaciones, int banos, int admin) {
        super(id, area, direccion, habitaciones, banos);
        this.valorAdministracion = admin;
    }

    public void imprimir() {
        super.imprimir();
        System.out.println("Valor de la administración = $" + valorAdministracion);
        System.out.println();
    }
}