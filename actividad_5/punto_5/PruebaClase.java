import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PruebaClase {
    
    public static void main(String[] args) {
        System.out.println("=== PRUEBAS AUTOMÁTICAS PARA LECTURA DE ARCHIVOS ===\n");
        
        PruebaClase prueba = new PruebaClase();
        prueba.ejecutarTodasLasPruebas();
    }
    
    public void ejecutarTodasLasPruebas() {
        pruebaArchivoValido();
        pruebaArchivoInexistente();
        pruebaConversionMayusculas();
        pruebaRutaVacia();
        pruebaArchivoSinPermisos();
        
        System.out.println("\n=== TODAS LAS PRUEBAS COMPLETADAS ===");
    }
    
    private void pruebaArchivoValido() {
        System.out.println("1. Prueba: Archivo válido");
        
        try {
            File archivoTemporal = crearArchivoTemporal("Hola mundo\nEsta es una prueba\nTercera línea");
            
            String[] lineas = ArchivoUtils.leerArchivo(archivoTemporal.getAbsolutePath());
            
            if (lineas.length == 3 && 
                "Hola mundo".equals(lineas[0]) && 
                "Esta es una prueba".equals(lineas[1]) && 
                "Tercera línea".equals(lineas[2])) {
                System.out.println("   ✓ PASÓ: Archivo leído correctamente");
            } else {
                System.out.println("   ✗ FALLÓ: Contenido incorrecto");
            }
            
            archivoTemporal.delete();
            
        } catch (Exception e) {
            System.out.println("   ✗ FALLÓ: " + e.getMessage());
        }
        System.out.println();
    }
    
    private void pruebaArchivoInexistente() {
        System.out.println("2. Prueba: Archivo inexistente");
        
        try {
            ArchivoUtils.leerArchivo("archivo_que_no_existe.txt");
            System.out.println("   ✗ FALLÓ: Debería haber lanzado excepción");
        } catch (ArchivoException e) {
            System.out.println("   ✓ PASÓ: Excepción capturada correctamente - " + e.getMessage());
        } catch (Exception e) {
            System.out.println("   ✗ FALLÓ: Excepción incorrecta - " + e.getMessage());
        }
        System.out.println();
    }
    
    private void pruebaConversionMayusculas() {
        System.out.println("3. Prueba: Conversión a mayúsculas");
        
        try {
            String[] lineasOriginales = {"hola mundo", "esta es una PRUEBA", "tercera Línea"};
            String[] lineasMayusculas = ArchivoUtils.convertirMayusculas(lineasOriginales);
            
            if (lineasMayusculas.length == 3 && 
                "HOLA MUNDO".equals(lineasMayusculas[0]) && 
                "ESTA ES UNA PRUEBA".equals(lineasMayusculas[1]) && 
                "TERCERA LÍNEA".equals(lineasMayusculas[2])) {
                System.out.println("   ✓ PASÓ: Conversión a mayúsculas correcta");
            } else {
                System.out.println("   ✗ FALLÓ: Conversión incorrecta");
            }
            
        } catch (Exception e) {
            System.out.println("   ✗ FALLÓ: " + e.getMessage());
        }
        System.out.println();
    }
    
    private void pruebaRutaVacia() {
        System.out.println("4. Prueba: Ruta vacía");
        
        try {
            ValidacionUtils.validarRuta("");
            System.out.println("   ✗ FALLÓ: Debería haber lanzado excepción");
        } catch (ArchivoException e) {
            System.out.println("   ✓ PASÓ: Validación de ruta vacía correcta - " + e.getMessage());
        } catch (Exception e) {
            System.out.println("   ✗ FALLÓ: Excepción incorrecta - " + e.getMessage());
        }
        System.out.println();
    }
    
    private void pruebaArchivoSinPermisos() {
        System.out.println("5. Prueba: Archivo sin permisos de lectura");
        
        try {
            File archivoTemporal = crearArchivoTemporal("Contenido de prueba");
            archivoTemporal.setReadable(false);
            
            ValidacionUtils.validarRuta(archivoTemporal.getAbsolutePath());
            System.out.println("   ✗ FALLÓ: Debería haber lanzado excepción por permisos");
            
            archivoTemporal.setReadable(true);
            archivoTemporal.delete();
            
        } catch (ArchivoException e) {
            System.out.println("   ✓ PASÓ: Validación de permisos correcta - " + e.getMessage());
        } catch (Exception e) {
            System.out.println("   ⚠  ADVERTENCIA: " + e.getMessage());
        }
        System.out.println();
    }
    
    private File crearArchivoTemporal(String contenido) throws IOException {
        Path archivoTemporal = Files.createTempFile("test_", ".txt");
        
        try (FileWriter writer = new FileWriter(archivoTemporal.toFile())) {
            writer.write(contenido);
        }
        
        return archivoTemporal.toFile();
    }
}
