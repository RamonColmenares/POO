package inmueble;

public class Local extends Inmueble {
    public enum Tipo { INTERNO, CALLE }
    protected Tipo tipoLocal;

    public Local(int id, int area, String direccion, Tipo tipo) {
        super(id, area, direccion);
        this.tipoLocal = tipo;
    }

    public void imprimir() {
        super.imprimir();
        System.out.println("Tipo de local = " + tipoLocal);
    }
}