package inmueble;

public class Oficina extends Local {
    protected static double valorArea = 3500000;
    protected boolean esGobierno;

    public Oficina(int id, int area, String direccion, Tipo tipo, boolean esGobierno) {
        super(id, area, direccion, tipo);
        this.esGobierno = esGobierno;
    }

    public void imprimir() {
        super.imprimir();
        System.out.println("Es oficina gubernamental = " + esGobierno);
        System.out.println();
    }
}