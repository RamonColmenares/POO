package Universidad;

public class Main {
    public static void main(String[] args) {
        Estudiante e = new Estudiante("Ana", "Calle 1", "Ingeniería", 3);
        Profesor p = new Profesor("Carlos", "Calle 2", "Matemáticas", "Titular");

        System.out.println("Estudiante: " + e.getNombre() + ", Carrera: " + e.getCarrera() + ", Semestre: " + e.getSemestre());
        System.out.println("Profesor: " + p.getNombre() + ", Departamento: " + p.getDepartamento() + ", Categoría: " + p.getCategoria());
    }
}
