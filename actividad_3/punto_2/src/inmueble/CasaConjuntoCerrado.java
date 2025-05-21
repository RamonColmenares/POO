package inmueble;

public class CasaConjuntoCerrado extends CasaUrbana {
    protected static double valorArea = 2500000;
    protected int valorAdministracion;
    protected boolean tienePiscina;
    protected boolean tieneCamposDeportivos;

    public CasaConjuntoCerrado(int id, int area, String direccion, int habitaciones, int banos,
                               int pisos, int admin, boolean piscina, boolean deportivos) {
        super(id, area, direccion, habitaciones, banos, pisos);
        this.valorAdministracion = admin;
        this.tienePiscina = piscina;
        this.tieneCamposDeportivos = deportivos;
    }

    public void imprimir() {
        super.imprimir();
        System.out.println("Valor de la administración = $" + valorAdministracion);
        System.out.println("Tiene piscina? = " + tienePiscina);
        System.out.println("Tiene campos deportivos? = " + tieneCamposDeportivos);
        System.out.println();
    }
}