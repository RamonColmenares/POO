public class PruebaClase {
    private static int pruebas = 0;
    private static int exitos = 0;
    
    public static void main(String[] args) {
        System.out.println("=== PRUEBAS UNITARIAS ===\n");
        
        probarCreacionEquipo();
        probarValidacionTexto();
        probarGestionProgramadores();
        probarValidacionContrasena();
        
        System.out.println("\n=== RESUMEN ===");
        System.out.println("Pruebas ejecutadas: " + pruebas);
        System.out.println("Pruebas exitosas: " + exitos);
        System.out.println("Pruebas fallidas: " + (pruebas - exitos));
        System.out.println("Porcentaje de éxito: " + (exitos * 100.0 / pruebas) + "%");
    }
    
    private static void probarCreacionEquipo() {
        System.out.println("1. PRUEBAS DE CREACIÓN DE EQUIPO");
        
        pruebaExitosa("Crear equipo válido", () -> {
            ClasePrincipal.EquipoMaraton equipo = ClasePrincipal.crearEquipo("TeamJava", "Universidad", "Java");
            return equipo.getNombreEquipo().equals("TeamJava") && 
                   equipo.getUniversidad().equals("Universidad") && 
                   equipo.getLenguajeProgramacion().equals("Java");
        });
        
        pruebaExcepcion("Crear equipo con nombre vacío", ClasePrincipal.CampoInvalido.class, () -> {
            ClasePrincipal.crearEquipo("", "Universidad", "Java");
            return false;
        });
        
        pruebaExcepcion("Crear equipo con nombre largo", ClasePrincipal.CampoInvalido.class, () -> {
            ClasePrincipal.crearEquipo("NombreDeEquipoDemasiadoLargo", "Universidad", "Java");
            return false;
        });
        
        pruebaExcepcion("Crear equipo con números en nombre", ClasePrincipal.CampoInvalido.class, () -> {
            ClasePrincipal.crearEquipo("Team123", "Universidad", "Java");
            return false;
        });
        
        System.out.println();
    }
    
    private static void probarValidacionTexto() {
        System.out.println("2. PRUEBAS DE VALIDACIÓN DE TEXTO");
        
        pruebaExitosa("Validar texto válido", () -> {
            ClasePrincipal.validarTexto("TextoValido");
            return true;
        });
        
        pruebaExcepcion("Validar texto con números", ClasePrincipal.CampoInvalido.class, () -> {
            ClasePrincipal.validarTexto("Texto123");
            return false;
        });
        
        pruebaExcepcion("Validar texto vacío", ClasePrincipal.CampoInvalido.class, () -> {
            ClasePrincipal.validarTexto("");
            return false;
        });
        
        pruebaExcepcion("Validar texto largo", ClasePrincipal.CampoInvalido.class, () -> {
            ClasePrincipal.validarTexto("TextoDemasiadoLargoParaSerValido");
            return false;
        });
        
        System.out.println();
    }
    
    private static void probarGestionProgramadores() {
        System.out.println("3. PRUEBAS DE GESTIÓN DE PROGRAMADORES");
        
        pruebaExitosa("Crear y agregar programador válido", () -> {
            ClasePrincipal.EquipoMaraton equipo = ClasePrincipal.crearEquipo("Team", "Universidad", "Java");
            ClasePrincipal.Programador programador = ClasePrincipal.crearProgramador("Juan", "Perez");
            equipo.agregarProgramador(programador);
            return equipo.getTamaño() == 1 && !equipo.estaCompleto();
        });
        
        pruebaExitosa("Llenar equipo completo", () -> {
            ClasePrincipal.EquipoMaraton equipo = ClasePrincipal.crearEquipo("Team", "Universidad", "Java");
            String[] nombres = {"Juan", "Ana", "Luis"};
            String[] apellidos = {"Perez", "Garcia", "Lopez"};
            for (int i = 0; i < 3; i++) {
                ClasePrincipal.Programador programador = ClasePrincipal.crearProgramador(nombres[i], apellidos[i]);
                equipo.agregarProgramador(programador);
            }
            return equipo.getTamaño() == 3 && equipo.estaCompleto();
        });
        
        pruebaExcepcion("Agregar programador a equipo completo", ClasePrincipal.EquipoCompleto.class, () -> {
            ClasePrincipal.EquipoMaraton equipo = ClasePrincipal.crearEquipo("Team", "Universidad", "Java");
            String[] nombres = {"Juan", "Ana", "Luis", "Carlos"};
            String[] apellidos = {"Perez", "Garcia", "Lopez", "Martinez"};
            for (int i = 0; i < 4; i++) {
                ClasePrincipal.Programador programador = ClasePrincipal.crearProgramador(nombres[i], apellidos[i]);
                equipo.agregarProgramador(programador);
            }
            return false;
        });
        
        pruebaExcepcion("Crear programador con nombre inválido", ClasePrincipal.CampoInvalido.class, () -> {
            ClasePrincipal.crearProgramador("Juan123", "Perez");
            return false;
        });
        
        System.out.println();
    }
    
    private static void probarValidacionContrasena() {
        System.out.println("4. PRUEBAS DE VALIDACIÓN DE CONTRASEÑA");
        
        pruebaExitosa("Validar contraseña válida", () -> {
            String resultado = ClasePrincipal.validarContrasenaCompleta("Password123!", "Password123!");
            return resultado.contains("válida");
        });
        
        pruebaExcepcion("Contraseña muy corta", ClasePrincipal.ContrasenaInvalida.class, () -> {
            ClasePrincipal.validarContrasenaCompleta("Pass1!", "Pass1!");
            return false;
        });
        
        pruebaExcepcion("Contraseña sin mayúscula", ClasePrincipal.ContrasenaInvalida.class, () -> {
            ClasePrincipal.validarContrasenaCompleta("password123!", "password123!");
            return false;
        });
        
        pruebaExcepcion("Contraseña sin minúscula", ClasePrincipal.ContrasenaInvalida.class, () -> {
            ClasePrincipal.validarContrasenaCompleta("PASSWORD123!", "PASSWORD123!");
            return false;
        });
        
        pruebaExcepcion("Contraseña sin número", ClasePrincipal.ContrasenaInvalida.class, () -> {
            ClasePrincipal.validarContrasenaCompleta("Password!", "Password!");
            return false;
        });
        
        pruebaExcepcion("Contraseña sin carácter especial", ClasePrincipal.ContrasenaInvalida.class, () -> {
            ClasePrincipal.validarContrasenaCompleta("Password123", "Password123");
            return false;
        });
        
        pruebaExcepcion("Contraseña con espacios", ClasePrincipal.ContrasenaInvalida.class, () -> {
            ClasePrincipal.validarContrasenaCompleta("Pass word123!", "Pass word123!");
            return false;
        });
        
        pruebaExcepcion("Contraseñas no coinciden", ClasePrincipal.ContrasenaInvalida.class, () -> {
            ClasePrincipal.validarContrasenaCompleta("Password123!", "Password456!");
            return false;
        });
        
        System.out.println();
    }
    
    private static void pruebaExitosa(String nombre, TestRunner test) {
        pruebas++;
        try {
            if (test.run()) {
                System.out.println("✓ " + nombre);
                exitos++;
            } else {
                System.out.println("✗ " + nombre + " - Falló sin excepción");
            }
        } catch (Exception e) {
            System.out.println("✗ " + nombre + " - Excepción inesperada: " + e.getMessage());
        }
    }
    
    private static void pruebaExcepcion(String nombre, Class<? extends Exception> excepcionEsperada, TestRunner test) {
        pruebas++;
        try {
            test.run();
            System.out.println("✗ " + nombre + " - Debería haber lanzado " + excepcionEsperada.getSimpleName());
        } catch (Exception e) {
            if (excepcionEsperada.isInstance(e)) {
                System.out.println("✓ " + nombre);
                exitos++;
            } else {
                System.out.println("✗ " + nombre + " - Excepción incorrecta: " + e.getClass().getSimpleName());
            }
        }
    }
    
    @FunctionalInterface
    private interface TestRunner {
        boolean run() throws Exception;
    }
}
