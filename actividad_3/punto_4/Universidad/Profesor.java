package Universidad;

public class Profesor extends Persona {
    private String departamento;
    private String categoria;

    public Profesor(String nombre, String direccion, String departamento, String categoria) {
        super(nombre, direccion);
        this.departamento = departamento;
        this.categoria = categoria;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
