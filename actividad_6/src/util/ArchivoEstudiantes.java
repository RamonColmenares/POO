package util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Estudiante;

public class ArchivoEstudiantes {
    private static final String ARCHIVO_ESTUDIANTES = "estudiantes.csv";
    private static ArchivoEstudiantes instancia;
    
    private ArchivoEstudiantes() {
        inicializarArchivo();
    }
    
    public static ArchivoEstudiantes getInstance() {
        if (instancia == null) {
            instancia = new ArchivoEstudiantes();
        }
        return instancia;
    }
    
    private void inicializarArchivo() {
        File archivo = new File(ARCHIVO_ESTUDIANTES);
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
                try (PrintWriter writer = new PrintWriter(new FileWriter(archivo))) {
                    writer.println("ID,Nombre,Apellido,Email,Edad,Carrera,Promedio");
                }
            } catch (IOException e) {
                System.err.println("Error al crear el archivo: " + e.getMessage());
            }
        }
    }
    
    public boolean agregarEstudiante(Estudiante estudiante) {
        if (buscarEstudiantePorId(estudiante.getId()) != null) {
            return false;
        }
        
        try (PrintWriter writer = new PrintWriter(new FileWriter(ARCHIVO_ESTUDIANTES, true))) {
            writer.println(estudiante.toCSV());
            return true;
        } catch (IOException e) {
            System.err.println("Error al agregar estudiante: " + e.getMessage());
            return false;
        }
    }
    
    public List<Estudiante> obtenerTodosLosEstudiantes() {
        List<Estudiante> estudiantes = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_ESTUDIANTES))) {
            String linea;
            boolean primeraLinea = true;
            
            while ((linea = reader.readLine()) != null) {
                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
                }
                
                if (!linea.trim().isEmpty()) {
                    Estudiante estudiante = Estudiante.fromCSV(linea);
                    if (estudiante != null) {
                        estudiantes.add(estudiante);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer estudiantes: " + e.getMessage());
        }
        
        return estudiantes;
    }
    
    public Estudiante buscarEstudiantePorId(String id) {
        List<Estudiante> estudiantes = obtenerTodosLosEstudiantes();
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getId().equals(id)) {
                return estudiante;
            }
        }
        return null;
    }
    
    public boolean actualizarEstudiante(Estudiante estudianteActualizado) {
        List<Estudiante> estudiantes = obtenerTodosLosEstudiantes();
        boolean encontrado = false;
        
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).getId().equals(estudianteActualizado.getId())) {
                estudiantes.set(i, estudianteActualizado);
                encontrado = true;
                break;
            }
        }
        
        if (encontrado) {
            return guardarTodosLosEstudiantes(estudiantes);
        }
        
        return false;
    }
    
    public boolean eliminarEstudiante(String id) {
        List<Estudiante> estudiantes = obtenerTodosLosEstudiantes();
        boolean eliminado = estudiantes.removeIf(estudiante -> estudiante.getId().equals(id));
        
        if (eliminado) {
            return guardarTodosLosEstudiantes(estudiantes);
        }
        
        return false;
    }
    
    private boolean guardarTodosLosEstudiantes(List<Estudiante> estudiantes) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ARCHIVO_ESTUDIANTES))) {
            writer.println("ID,Nombre,Apellido,Email,Edad,Carrera,Promedio");
            
            for (Estudiante estudiante : estudiantes) {
                writer.println(estudiante.toCSV());
            }
            
            return true;
        } catch (IOException e) {
            System.err.println("Error al guardar estudiantes: " + e.getMessage());
            return false;
        }
    }
    
    public List<Estudiante> buscarEstudiantes(String criterio, String valor) {
        List<Estudiante> resultado = new ArrayList<>();
        List<Estudiante> todosLosEstudiantes = obtenerTodosLosEstudiantes();
        
        for (Estudiante estudiante : todosLosEstudiantes) {
            switch (criterio.toLowerCase()) {
                case "nombre":
                    if (estudiante.getNombre().toLowerCase().contains(valor.toLowerCase())) {
                        resultado.add(estudiante);
                    }
                    break;
                case "apellido":
                    if (estudiante.getApellido().toLowerCase().contains(valor.toLowerCase())) {
                        resultado.add(estudiante);
                    }
                    break;
                case "carrera":
                    if (estudiante.getCarrera().toLowerCase().contains(valor.toLowerCase())) {
                        resultado.add(estudiante);
                    }
                    break;
                case "email":
                    if (estudiante.getEmail().toLowerCase().contains(valor.toLowerCase())) {
                        resultado.add(estudiante);
                    }
                    break;
            }
        }
        
        return resultado;
    }
}
