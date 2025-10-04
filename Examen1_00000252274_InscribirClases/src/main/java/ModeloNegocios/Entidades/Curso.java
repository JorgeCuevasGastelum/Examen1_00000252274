package ModeloNegocios.Entidades;

public class Curso {
    private String idCurso;
    private String nombre;
    private String aula;
    private Double costo;

    public Curso(String idCurso, String nombre, String aula, Double costo) {
        this.nombre = nombre;
        this.aula = aula;
        this.costo = costo;
    }

    public String getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
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
    
    
}
