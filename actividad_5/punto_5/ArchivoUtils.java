import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArchivoUtils {
    
    public static String[] leerArchivo(String ruta) throws ArchivoException {
        ValidacionUtils.validarRuta(ruta);
        
        List<String> lineas = new ArrayList<>();
        
        try (FileInputStream fis = new FileInputStream(ruta);
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(isr)) {
            
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
            
        } catch (IOException e) {
            throw new ArchivoException("Error al leer el archivo: " + ruta, e);
        }
        
        return lineas.toArray(new String[0]);
    }
    
    public static String[] convertirMayusculas(String[] lineas) {
        if (lineas == null) {
            return new String[0];
        }
        
        String[] lineasMayusculas = new String[lineas.length];
        for (int i = 0; i < lineas.length; i++) {
            lineasMayusculas[i] = lineas[i] != null ? lineas[i].toUpperCase() : "";
        }
        
        return lineasMayusculas;
    }
}
