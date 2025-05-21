package actividad_3.punto_1;

public class CuentaCorriente extends Cuenta {
    private float sobregiro;

    public CuentaCorriente(float saldo, float tasa) {
        super(saldo, tasa);
        sobregiro = 0;
    }

    @Override
    public void retirar(float cantidad) {
        float resultado = saldo - cantidad;
        if (resultado < 0) {
            sobregiro -= resultado;
            saldo = 0;
            numeroRetiros++;
        } else {
            super.retirar(cantidad);
        }
    }

    @Override
    public void consignar(float cantidad) {
        if (sobregiro > 0) {
            if (cantidad >= sobregiro) {
                saldo += (cantidad - sobregiro);
                sobregiro = 0;
            } else {
                sobregiro -= cantidad;
            }
            numeroConsignaciones++;
        } else {
            super.consignar(cantidad);
        }
    }

    @Override
    public void extractoMensual() {
        super.extractoMensual();
    }

    @Override
    public void imprimir() {
        System.out.println("Saldo = $" + saldo);
        System.out.println("Comisión mensual = $" + comisionMensual);
        System.out.println("Número de transacciones = " + (numeroConsignaciones + numeroRetiros));
        System.out.println("Valor de sobregiro = $" + sobregiro);
        System.out.println();
    }
}