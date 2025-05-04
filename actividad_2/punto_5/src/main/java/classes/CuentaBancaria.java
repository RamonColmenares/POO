package main.java.classes;

public class CuentaBancaria {

    public enum tipo { AHORROS, CORRIENTE }

    String nombresTitular;
    String apellidosTitular;
    int númeroCuenta;
    float saldo = 0;
    float interesMensual;
    tipo tipoCuenta;

    // Constructor
    public CuentaBancaria(String nombresTitular, String apellidosTitular, int numeroCuenta, tipo tipoCuenta, float interesMensual) {
        this.nombresTitular = nombresTitular;
        this.apellidosTitular = apellidosTitular;
        this.númeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.interesMensual = interesMensual;
    }

    public void imprimir() {
        System.out.println("Nombres del titular = " + nombresTitular);
        System.out.println("Apellidos del titular = " + apellidosTitular);
        System.out.println("Número de cuenta = " + númeroCuenta);
        System.out.println("Tipo de cuenta = " + tipoCuenta);
        System.out.println("Saldo = $" + saldo);
    }

    public void consultarSaldo() {
        System.out.println("El saldo actual es = $" + saldo);
    }

    public boolean consignar(int valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Se ha consignado $" + valor + " en la cuenta. El nuevo saldo es $" + saldo);
            return true;
        } else {
            System.out.println("El valor a consignar debe ser mayor que cero.");
            return false;
        }
    }

    public boolean retirar(int valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Se ha retirado $" + valor + " en la cuenta. El nuevo saldo es $" + saldo);
            return true;
        } else {
            System.out.println("El valor a retirar debe ser menor o igual al saldo actual.");
            return false;
        }
    }

    public void aplicarInteres() {
        float interesCalculado = saldo * (interesMensual / 100);
        saldo += interesCalculado;
        System.out.println("Se ha aplicado un interés de " + interesMensual + "%. El nuevo saldo es $" + saldo);
    }
}
