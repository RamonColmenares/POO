package controlador;

import java.util.List;
import modelo.Estudiante;
import util.ArchivoEstudiantes;
import vista.VentanaPrincipal;

public class ControladorEstudiantes {
    private ArchivoEstudiantes archivoEstudiantes;
    private VentanaPrincipal vista;
    
    public ControladorEstudiantes(VentanaPrincipal vista) {
        this.vista = vista;
        this.archivoEstudiantes = ArchivoEstudiantes.getInstance();
    }
    
    public boolean crearEstudiante(String id, String nombre, String apellido, 
                                  String email, int edad, String carrera, double promedio) {
        try {
            if (validarDatos(id, nombre, apellido, email, edad, carrera, promedio)) {
                Estudiante nuevoEstudiante = new Estudiante(id, nombre, apellido, 
                                                           email, edad, carrera, promedio);
                
                if (archivoEstudiantes.agregarEstudiante(nuevoEstudiante)) {
                    vista.mostrarMensaje("Estudiante agregado exitosamente", "Éxito");
                    return true;
                } else {
                    vista.mostrarMensaje("Ya existe un estudiante con ese ID", "Error");
                    return false;
                }
            } else {
                vista.mostrarMensaje("Por favor, complete todos los campos correctamente", "Error de validación");
                return false;
            }
        } catch (Exception e) {
            vista.mostrarMensaje("Error al crear estudiante: " + e.getMessage(), "Error");
            return false;
        }
    }
    
    // Leer todos los estudiantes
    public List<Estudiante> obtenerTodosLosEstudiantes() {
        try {
            return archivoEstudiantes.obtenerTodosLosEstudiantes();
        } catch (Exception e) {
            vista.mostrarMensaje("Error al cargar estudiantes: " + e.getMessage(), "Error");
            return null;
        }
    }
    
    // Buscar estudiante por ID
    public Estudiante buscarEstudiantePorId(String id) {
        try {
            if (id == null || id.trim().isEmpty()) {
                vista.mostrarMensaje("Por favor, ingrese un ID válido", "Error de validación");
                return null;
            }
            
            Estudiante estudiante = archivoEstudiantes.buscarEstudiantePorId(id);
            if (estudiante == null) {
                vista.mostrarMensaje("No se encontró estudiante con ID: " + id, "Información");
            }
            return estudiante;
        } catch (Exception e) {
            vista.mostrarMensaje("Error al buscar estudiante: " + e.getMessage(), "Error");
            return null;
        }
    }
    
    // Actualizar estudiante existente
    public boolean actualizarEstudiante(String id, String nombre, String apellido, 
                                       String email, int edad, String carrera, double promedio) {
        try {
            if (validarDatos(id, nombre, apellido, email, edad, carrera, promedio)) {
                Estudiante estudianteActualizado = new Estudiante(id, nombre, apellido, 
                                                                 email, edad, carrera, promedio);
                
                if (archivoEstudiantes.actualizarEstudiante(estudianteActualizado)) {
                    vista.mostrarMensaje("Estudiante actualizado exitosamente", "Éxito");
                    return true;
                } else {
                    vista.mostrarMensaje("No se encontró el estudiante para actualizar", "Error");
                    return false;
                }
            } else {
                vista.mostrarMensaje("Por favor, complete todos los campos correctamente", "Error de validación");
                return false;
            }
        } catch (Exception e) {
            vista.mostrarMensaje("Error al actualizar estudiante: " + e.getMessage(), "Error");
            return false;
        }
    }
    
    // Eliminar estudiante
    public boolean eliminarEstudiante(String id) {
        try {
            if (id == null || id.trim().isEmpty()) {
                vista.mostrarMensaje("Por favor, ingrese un ID válido", "Error de validación");
                return false;
            }
            
            if (archivoEstudiantes.eliminarEstudiante(id)) {
                vista.mostrarMensaje("Estudiante eliminado exitosamente", "Éxito");
                return true;
            } else {
                vista.mostrarMensaje("No se encontró el estudiante para eliminar", "Error");
                return false;
            }
        } catch (Exception e) {
            vista.mostrarMensaje("Error al eliminar estudiante: " + e.getMessage(), "Error");
            return false;
        }
    }
    
    // Buscar estudiantes por criterio
    public List<Estudiante> buscarEstudiantes(String criterio, String valor) {
        try {
            if (criterio == null || valor == null || valor.trim().isEmpty()) {
                vista.mostrarMensaje("Por favor, ingrese criterio y valor de búsqueda", "Error de validación");
                return null;
            }
            
            List<Estudiante> resultados = archivoEstudiantes.buscarEstudiantes(criterio, valor);
            if (resultados.isEmpty()) {
                vista.mostrarMensaje("No se encontraron estudiantes con el criterio especificado", "Información");
            }
            return resultados;
        } catch (Exception e) {
            vista.mostrarMensaje("Error en la búsqueda: " + e.getMessage(), "Error");
            return null;
        }
    }
    
    // Método para validar datos de entrada
    private boolean validarDatos(String id, String nombre, String apellido, 
                                String email, int edad, String carrera, double promedio) {
        // Validar que no sean nulos o vacíos
        if (id == null || id.trim().isEmpty() ||
            nombre == null || nombre.trim().isEmpty() ||
            apellido == null || apellido.trim().isEmpty() ||
            email == null || email.trim().isEmpty() ||
            carrera == null || carrera.trim().isEmpty()) {
            return false;
        }
        
        // Validar edad
        if (edad < 16 || edad > 100) {
            return false;
        }
        
        // Validar promedio
        if (promedio < 0.0 || promedio > 5.0) {
            return false;
        }
        
        // Validar formato de email básico
        if (!email.contains("@") || !email.contains(".")) {
            return false;
        }
        
        return true;
    }
    
    // Método para obtener estadísticas básicas
    public String obtenerEstadisticas() {
        try {
            List<Estudiante> estudiantes = archivoEstudiantes.obtenerTodosLosEstudiantes();
            int totalEstudiantes = estudiantes.size();
            
            if (totalEstudiantes == 0) {
                return "No hay estudiantes registrados";
            }
            
            double sumaPromedios = 0;
            int edadMinima = Integer.MAX_VALUE;
            int edadMaxima = Integer.MIN_VALUE;
            
            for (Estudiante estudiante : estudiantes) {
                sumaPromedios += estudiante.getPromedio();
                if (estudiante.getEdad() < edadMinima) {
                    edadMinima = estudiante.getEdad();
                }
                if (estudiante.getEdad() > edadMaxima) {
                    edadMaxima = estudiante.getEdad();
                }
            }
            
            double promedioGeneral = sumaPromedios / totalEstudiantes;
            
            return String.format(
                "Total de estudiantes: %d\n" +
                "Promedio general: %.2f\n" +
                "Edad mínima: %d años\n" +
                "Edad máxima: %d años",
                totalEstudiantes, promedioGeneral, edadMinima, edadMaxima
            );
        } catch (Exception e) {
            return "Error al calcular estadísticas: " + e.getMessage();
        }
    }
}
