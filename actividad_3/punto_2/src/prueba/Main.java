package prueba;

import inmueble.*;

public class Main {
    public static void main(String[] args) {
        ApartamentoFamiliar apto1 = new ApartamentoFamiliar(103067, 120, "Avenida Santander 45-45", 3, 2, 200000);
        System.out.println("Datos apartamento familiar");
        apto1.calcularPrecioVenta(2000000);
        apto1.imprimir();

        Apartaestudio aptestudio1 = new Apartaestudio(12354, 50, "Avenida Caracas 30-15");
        System.out.println("Datos apartaestudio");
        aptestudio1.calcularPrecioVenta(2000000);
        aptestudio1.imprimir();
    }
}