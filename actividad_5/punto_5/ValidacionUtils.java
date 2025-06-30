import java.io.File;

public class ValidacionUtils {
    
    public static void validarRuta(String ruta) throws ArchivoException {
        if (ruta == null || ruta.trim().isEmpty()) {
            throw new ArchivoException("La ruta del archivo no puede estar vacía");
        }
        
        File archivo = new File(ruta);
        
        if (!archivo.exists()) {
            throw new ArchivoException("El archivo no existe: " + ruta);
        }
        
        if (!archivo.isFile()) {
            throw new ArchivoException("La ruta especificada no es un archivo válido: " + ruta);
        }
        
        if (!archivo.canRead()) {
            throw new ArchivoException("No se puede leer el archivo: " + ruta);
        }
    }
}
