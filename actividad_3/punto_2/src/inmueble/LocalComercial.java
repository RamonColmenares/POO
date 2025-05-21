package inmueble;

public class LocalComercial extends Local {
    protected static double valorArea = 3000000;
    protected String centroComercial;

    public LocalComercial(int id, int area, String direccion, Tipo tipo, String centro) {
        super(id, area, direccion, tipo);
        this.centroComercial = centro;
    }

    public void imprimir() {
        super.imprimir();
        System.out.println("Centro comercial = " + centroComercial);
        System.out.println();
    }
}