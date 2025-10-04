package ModeloNegocios.Entidades;

import java.time.LocalDate;
import java.util.List;

public class Inscripcion {
    private String nombreAlumno;
    private List<Curso> cursos;
    private double costo;
    private LocalDate fecha;

    public Inscripcion(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public Inscripcion(String nombreAlumno, List<Curso> cursos, double costo, LocalDate fecha) {
        this.nombreAlumno = nombreAlumno;
        this.cursos = cursos;
        this.costo = costo;
        this.fecha = fecha;
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "nombreAlumno=" + nombreAlumno + ", cursos=" + cursos + ", costo=" + costo + ", fecha=" + fecha + '}';
    }
    
    
    
}
