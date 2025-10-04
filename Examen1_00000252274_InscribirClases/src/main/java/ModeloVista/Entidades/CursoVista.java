package ModeloVista.Entidades;

public class CursoVista {
    private String nombre;
    private String aula;
    private Double costo;

    public CursoVista(String nombre, String aula, Double costo) {
        this.nombre = nombre;
        this.aula = aula;
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "CursoVista{" + "nombre=" + nombre + ", aula=" + aula + ", costo=" + costo + '}';
    }
    
    
    
    
}
