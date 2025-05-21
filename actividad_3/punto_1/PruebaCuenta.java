package actividad_3.punto_1;

import java.util.Scanner;

public class PruebaCuenta {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Cuenta de ahorros");
        System.out.print("Ingrese saldo inicial: $");
        float saldoInicialAhorros = input.nextFloat();

        System.out.print("Ingrese tasa de interés: ");
        float tasaAhorros = input.nextFloat();

        CuentaAhorros cuenta1 = new CuentaAhorros(saldoInicialAhorros, tasaAhorros);

        System.out.print("Ingresar cantidad a consignar: $");
        float cantidadDepositar = input.nextFloat();
        cuenta1.consignar(cantidadDepositar);

        System.out.print("Ingresar cantidad a retirar: $");
        float cantidadRetirar = input.nextFloat();
        cuenta1.retirar(cantidadRetirar);

        cuenta1.extractoMensual();
        cuenta1.imprimir();

        // Prueba adicional de Cuenta Corriente (opcional)
        System.out.println("Cuenta corriente");
        CuentaCorriente cuenta2 = new CuentaCorriente(5000, 0.02f);
        cuenta2.retirar(7000); // activa sobregiro
        cuenta2.consignar(3000); // reduce sobregiro
        cuenta2.extractoMensual();
        cuenta2.imprimir();

        input.close();
    }
}