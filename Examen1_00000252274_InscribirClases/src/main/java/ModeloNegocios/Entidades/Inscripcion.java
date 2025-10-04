package ModeloNegocios.Entidades;

import java.util.List;

public class Inscripcion {
    private String nombreAlumno;
    private List<Curso> cursos;
    private double costo;

    public Inscripcion(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public Inscripcion(String nombreAlumno, List<Curso> cursos, double costo) {
        this.nombreAlumno = nombreAlumno;
        this.cursos = cursos;
        this.costo = costo;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    
}
