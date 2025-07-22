package modelo;

public class Estudiante {
    private String id;
    private String nombre;
    private String apellido;
    private String email;
    private int edad;
    private String carrera;
    private double promedio;
    
    public Estudiante() {
    }
    
    public Estudiante(String id, String nombre, String apellido, String email, 
                     int edad, String carrera, double promedio) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.edad = edad;
        this.carrera = carrera;
        this.promedio = promedio;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public int getEdad() {
        return edad;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public String getCarrera() {
        return carrera;
    }
    
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    
    public double getPromedio() {
        return promedio;
    }
    
    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
    
    @Override
    public String toString() {
        return "Estudiante{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", edad=" + edad +
                ", carrera='" + carrera + '\'' +
                ", promedio=" + promedio +
                '}';
    }
    
    public String toCSV() {
        return id + "," + nombre + "," + apellido + "," + email + "," + 
               edad + "," + carrera + "," + promedio;
    }
    
    public static Estudiante fromCSV(String csvLine) {
        String[] datos = csvLine.split(",");
        if (datos.length == 7) {
            return new Estudiante(
                datos[0].trim(),
                datos[1].trim(),
                datos[2].trim(),
                datos[3].trim(),
                Integer.parseInt(datos[4].trim()),
                datos[5].trim(),
                Double.parseDouble(datos[6].trim())
            );
        }
        return null;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Estudiante that = (Estudiante) obj;
        return id.equals(that.id);
    }
    
    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
