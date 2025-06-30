package Excepciones;
/**
 * Clase de prueba para demostrar el funcionamiento de CálculosNuméricos
 */
public class PruebaCalculosNumericos {
    
    public static void main(String[] args) {
        System.out.println("=== PRUEBAS DE LA CLASE CálculosNuméricos ===\n");
        
        // Prueba 1: Logaritmo neperiano
        System.out.println("1. Pruebas de Logaritmo Neperiano:");
        try {
            CalculosNumericos.calcularLogaritmoNeperiano(Math.E); // Debería dar ≈ 1
            CalculosNumericos.calcularLogaritmoNeperiano(1.0);    // Debería dar 0
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        // Prueba con valor inválido
        try {
            CalculosNumericos.calcularLogaritmoNeperiano(-1.0);
        } catch (ArithmeticException e) {
            System.out.println("Error capturado correctamente: " + e.getMessage());
        }
        
        // Prueba 2: Raíz cuadrada
        System.out.println("\n2. Pruebas de Raíz Cuadrada:");
        try {
            CalculosNumericos.calcularRaizCuadrada(16.0);  // Debería dar 4
            CalculosNumericos.calcularRaizCuadrada(0.0);   // Debería dar 0
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        // Prueba con valor inválido
        try {
            CalculosNumericos.calcularRaizCuadrada(-4.0);
        } catch (ArithmeticException e) {
            System.out.println("Error capturado correctamente: " + e.getMessage());
        }
        
        // Prueba 3: Pendiente
        System.out.println("\n3. Pruebas de Pendiente:");
        try {
            CalculosNumericos.calcularPendiente(0, 0, 1, 1);    // Pendiente = 1
            CalculosNumericos.calcularPendiente(0, 0, 2, 4);    // Pendiente = 2
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        // Prueba con línea vertical
        try {
            CalculosNumericos.calcularPendiente(1, 0, 1, 5);
        } catch (ArithmeticException e) {
            System.out.println("Error capturado correctamente: " + e.getMessage());
        }
        
        // Prueba 4: Punto medio
        System.out.println("\n4. Pruebas de Punto Medio:");
        CalculosNumericos.calcularPuntoMedio(0, 0, 4, 4);   // (2, 2)
        CalculosNumericos.calcularPuntoMedio(-2, -2, 2, 2); // (0, 0)
        
        // Prueba 5: Ecuación cuadrática
        System.out.println("\n5. Pruebas de Ecuación Cuadrática:");
        try {
            // x² - 5x + 6 = 0, raíces: 2 y 3
            CalculosNumericos.calcularRaicesEcuacionCuadratica(1, -5, 6);
            
            // x² - 4x + 4 = 0, raíz única: 2
            CalculosNumericos.calcularRaicesEcuacionCuadratica(1, -4, 4);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        // Prueba con discriminante negativo
        try {
            CalculosNumericos.calcularRaicesEcuacionCuadratica(1, 0, 1);
        } catch (ArithmeticException e) {
            System.out.println("Error capturado correctamente: " + e.getMessage());
        }
        
        // Prueba 6: Conversión de base
        System.out.println("\n6. Pruebas de Conversión de Base:");
        try {
            CalculosNumericos.convertirABase(255, 16);  // FF
            CalculosNumericos.convertirABase(8, 2);     // 1000
            CalculosNumericos.convertirABase(0, 10);    // 0
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        // Prueba con valores inválidos
        try {
            CalculosNumericos.convertirABase(-5, 10);
        } catch (IllegalArgumentException e) {
            System.out.println("Error capturado correctamente: " + e.getMessage());
        }
        
        try {
            CalculosNumericos.convertirABase(100, 20);
        } catch (IllegalArgumentException e) {
            System.out.println("Error capturado correctamente: " + e.getMessage());
        }
        
        System.out.println("\n=== FIN DE PRUEBAS ===");
    }
}
