package Excepciones;
import java.util.*;

public class CalculosNumericos {

    static void calcularLogaritmoNeperiano(double valor) throws ArithmeticException {
        if (valor <= 0) {
            throw new ArithmeticException("El valor debe ser positivo para calcular el logaritmo");
        }
        double result = Math.log(valor);
        System.out.println("Logaritmo neperiano = " + result);
    }

    static void calcularRaizCuadrada(double valor) throws ArithmeticException {
        if (valor < 0) {
            throw new ArithmeticException("El valor debe ser no negativo para calcular la raíz cuadrada");
        }
        double result = Math.sqrt(valor);
        System.out.println("Raíz cuadrada = " + result);
    }

    static double calcularPendiente(double x1, double y1, double x2, double y2) throws ArithmeticException {
        if (x2 - x1 == 0) {
            throw new ArithmeticException("No se puede calcular la pendiente: línea vertical (x2 - x1 = 0)");
        }
        double pendiente = (y2 - y1) / (x2 - x1);
        System.out.println("Pendiente = " + pendiente);
        return pendiente;
    }

    static String calcularPuntoMedio(double x1, double y1, double x2, double y2) {
        double xMedio = (x1 + x2) / 2;
        double yMedio = (y1 + y2) / 2;
        String resultado = "Punto medio: (" + xMedio + ", " + yMedio + ")";
        System.out.println(resultado);
        return resultado;
    }

    static void calcularRaicesEcuacionCuadratica(double a, double b, double c) throws ArithmeticException {
        if (a == 0) {
            throw new ArithmeticException("El coeficiente 'a' no puede ser cero en una ecuación cuadrática");
        }
        
        double discriminante = b * b - 4 * a * c;
        
        if (discriminante < 0) {
            throw new ArithmeticException("El discriminante es negativo: no hay raíces reales");
        }
        
        if (discriminante == 0) {
            double raiz = -b / (2 * a);
            System.out.println("Raíz única: " + raiz);
        } else {
            double raiz1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double raiz2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            System.out.println("Raíz 1: " + raiz1);
            System.out.println("Raíz 2: " + raiz2);
        }
    }

    static String convertirABase(int numero, int base) throws IllegalArgumentException {
        if (numero < 0) {
            throw new IllegalArgumentException("El número debe ser positivo");
        }
        if (base < 2 || base > 16) {
            throw new IllegalArgumentException("La base debe estar entre 2 y 16");
        }
        
        if (numero == 0) {
            return "0";
        }
        
        StringBuilder resultado = new StringBuilder();
        String digitos = "0123456789ABCDEF";
        
        while (numero > 0) {
            resultado.insert(0, digitos.charAt(numero % base));
            numero /= base;
        }
        
        String conversion = resultado.toString();
        System.out.println("Conversión a base " + base + ": " + conversion);
        return conversion;
    }

    static void mostrarMenu() {
        System.out.println("\n=== CALCULADORA MATEMÁTICA ===");
        System.out.println("1. Calcular logaritmo neperiano");
        System.out.println("2. Calcular raíz cuadrada");
        System.out.println("3. Calcular pendiente de una línea");
        System.out.println("4. Calcular punto medio");
        System.out.println("5. Resolver ecuación cuadrática");
        System.out.println("6. Convertir número a otra base");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        
        do {
            mostrarMenu();
            try {
                opcion = sc.nextInt();
                
                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese un número: ");
                        try {
                            double valor = sc.nextDouble();
                            calcularLogaritmoNeperiano(valor);
                        } catch (ArithmeticException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                        
                    case 2:
                        System.out.print("Ingrese un número: ");
                        try {
                            double valor = sc.nextDouble();
                            calcularRaizCuadrada(valor);
                        } catch (ArithmeticException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                        
                    case 3:
                        System.out.println("Ingrese las coordenadas de dos puntos:");
                        System.out.print("x1: ");
                        double x1 = sc.nextDouble();
                        System.out.print("y1: ");
                        double y1 = sc.nextDouble();
                        System.out.print("x2: ");
                        double x2 = sc.nextDouble();
                        System.out.print("y2: ");
                        double y2 = sc.nextDouble();
                        try {
                            calcularPendiente(x1, y1, x2, y2);
                        } catch (ArithmeticException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                        
                    case 4:
                        System.out.println("Ingrese las coordenadas de dos puntos:");
                        System.out.print("x1: ");
                        x1 = sc.nextDouble();
                        System.out.print("y1: ");
                        y1 = sc.nextDouble();
                        System.out.print("x2: ");
                        x2 = sc.nextDouble();
                        System.out.print("y2: ");
                        y2 = sc.nextDouble();
                        calcularPuntoMedio(x1, y1, x2, y2);
                        break;
                        
                    case 5:
                        System.out.println("Ingrese los coeficientes de la ecuación ax² + bx + c = 0:");
                        System.out.print("a: ");
                        double a = sc.nextDouble();
                        System.out.print("b: ");
                        double b = sc.nextDouble();
                        System.out.print("c: ");
                        double c = sc.nextDouble();
                        try {
                            calcularRaicesEcuacionCuadratica(a, b, c);
                        } catch (ArithmeticException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                        
                    case 6:
                        System.out.print("Ingrese el número a convertir (entero positivo): ");
                        try {
                            int numero = sc.nextInt();
                            System.out.print("Ingrese la base destino (2-16): ");
                            int base = sc.nextInt();
                            convertirABase(numero, base);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                        
                    case 0:
                        System.out.println("¡Hasta luego!");
                        break;
                        
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
                
            } catch (InputMismatchException e) {
                System.out.println("Error: Entrada inválida. Por favor ingrese un número válido.");
                sc.nextLine();
                opcion = -1;
            }
            
            if (opcion != 0) {
                System.out.println("\nPresione Enter para continuar...");
                sc.nextLine();
                sc.nextLine();
            }
            
        } while (opcion != 0);
        
        sc.close();
    }
}
