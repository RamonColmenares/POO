import java.util.ArrayList;
import java.util.List;

public class ClasePrincipal {
    
    public static class EquipoCompleto extends Exception {
        public EquipoCompleto(String mensaje) {
            super(mensaje);
        }
    }
    
    public static class CampoInvalido extends Exception {
        public CampoInvalido(String mensaje) {
            super(mensaje);
        }
    }
    
    public static class ContrasenaInvalida extends Exception {
        public ContrasenaInvalida(String mensaje) {
            super(mensaje);
        }
    }
    
    public static class Programador {
        private final String nombre;
        private final String apellidos;
        
        public Programador(String nombre, String apellidos) {
            this.nombre = nombre;
            this.apellidos = apellidos;
        }
        
        public String getNombre() {
            return nombre;
        }
        
        public String getApellidos() {
            return apellidos;
        }
        
        @Override
        public String toString() {
            return nombre + " " + apellidos;
        }
    }
    
    public static class EquipoMaraton {
        private final String nombreEquipo;
        private final String universidad;
        private final String lenguajeProgramacion;
        private final List<Programador> programadores;
        private static final int MAXIMO_INTEGRANTES = 3;
        
        public EquipoMaraton(String nombreEquipo, String universidad, String lenguajeProgramacion) {
            this.nombreEquipo = nombreEquipo;
            this.universidad = universidad;
            this.lenguajeProgramacion = lenguajeProgramacion;
            this.programadores = new ArrayList<>();
        }
        
        public boolean estaCompleto() {
            return programadores.size() == MAXIMO_INTEGRANTES;
        }
        
        public void agregarProgramador(Programador programador) throws EquipoCompleto {
            if (estaCompleto()) {
                throw new EquipoCompleto("El equipo está completo. No se puede agregar más programadores.");
            }
            programadores.add(programador);
        }
        
        public String getNombreEquipo() {
            return nombreEquipo;
        }
        
        public String getUniversidad() {
            return universidad;
        }
        
        public String getLenguajeProgramacion() {
            return lenguajeProgramacion;
        }
        
        public List<Programador> getProgramadores() {
            return new ArrayList<>(programadores);
        }
        
        public int getTamaño() {
            return programadores.size();
        }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Equipo: ").append(nombreEquipo).append("\n");
            sb.append("Universidad: ").append(universidad).append("\n");
            sb.append("Lenguaje: ").append(lenguajeProgramacion).append("\n");
            sb.append("Integrantes (").append(programadores.size()).append("/").append(MAXIMO_INTEGRANTES).append("):\n");
            for (Programador p : programadores) {
                sb.append("- ").append(p.toString()).append("\n");
            }
            return sb.toString();
        }
    }
    
    public static void validarTexto(String texto) throws CampoInvalido {
        if (texto == null || texto.trim().isEmpty()) {
            throw new CampoInvalido("El campo no puede estar vacío.");
        }
        
        if (texto.length() > 20) {
            throw new CampoInvalido("La longitud no debe ser superior a 20 caracteres.");
        }
        
        for (char c : texto.toCharArray()) {
            if (Character.isDigit(c)) {
                throw new CampoInvalido("El campo no puede contener números.");
            }
        }
    }
    
    public static void validarContrasena(String contrasena) throws ContrasenaInvalida {
        if (contrasena == null || contrasena.length() < 8) {
            throw new ContrasenaInvalida("La contraseña debe tener al menos 8 caracteres.");
        }
        
        if (contrasena.contains(" ")) {
            throw new ContrasenaInvalida("La contraseña no puede contener espacios.");
        }
        
        boolean tieneMayuscula = false;
        boolean tieneMinuscula = false;
        boolean tieneNumero = false;
        boolean tieneEspecial = false;
        
        for (char c : contrasena.toCharArray()) {
            if (Character.isUpperCase(c)) {
                tieneMayuscula = true;
            } else if (Character.isLowerCase(c)) {
                tieneMinuscula = true;
            } else if (Character.isDigit(c)) {
                tieneNumero = true;
            } else if (!Character.isLetterOrDigit(c)) {
                tieneEspecial = true;
            }
        }
        
        if (!tieneMayuscula) {
            throw new ContrasenaInvalida("La contraseña debe contener al menos una letra mayúscula.");
        }
        if (!tieneMinuscula) {
            throw new ContrasenaInvalida("La contraseña debe contener al menos una letra minúscula.");
        }
        if (!tieneNumero) {
            throw new ContrasenaInvalida("La contraseña debe contener al menos un número.");
        }
        if (!tieneEspecial) {
            throw new ContrasenaInvalida("La contraseña debe contener al menos un carácter especial.");
        }
    }
    
    public static void validarConfirmacionContrasena(String contrasena, String confirmacion) throws ContrasenaInvalida {
        if (!contrasena.equals(confirmacion)) {
            throw new ContrasenaInvalida("Las contraseñas no coinciden.");
        }
    }
    
    public static EquipoMaraton crearEquipo(String nombreEquipo, String universidad, String lenguaje) throws CampoInvalido {
        validarTexto(nombreEquipo);
        validarTexto(universidad);
        validarTexto(lenguaje);
        return new EquipoMaraton(nombreEquipo, universidad, lenguaje);
    }
    
    public static Programador crearProgramador(String nombre, String apellidos) throws CampoInvalido {
        validarTexto(nombre);
        validarTexto(apellidos);
        return new Programador(nombre, apellidos);
    }
    
    public static String validarContrasenaCompleta(String contrasena, String confirmacion) throws ContrasenaInvalida {
        validarContrasena(contrasena);
        validarConfirmacionContrasena(contrasena, confirmacion);
        return "Contraseña válida y confirmada correctamente.";
    }
}
