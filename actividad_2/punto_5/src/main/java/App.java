package main.java;

import main.java.classes.CuentaBancaria;

public class App {
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria(
            "Pedro",
            "Pérez",
            123456789,
            CuentaBancaria.tipo.AHORROS,
            2.0f
        );

        cuenta.imprimir();
        cuenta.consignar(200000);
        cuenta.consignar(300000);
        cuenta.retirar(400000);
        cuenta.aplicarInteres();
    }
}