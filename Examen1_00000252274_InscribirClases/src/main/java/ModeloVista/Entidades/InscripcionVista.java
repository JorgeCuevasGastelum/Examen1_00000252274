package ModeloVista.Entidades;

import java.time.LocalDate;
import java.util.List;

public class InscripcionVista {
    private String nombreAlumno;
    private List<CursoVista> cursosInscritos;
    private double costoTotal;
    private LocalDate fecha;

    public InscripcionVista(String nombreAlumno, List<CursoVista> cursosInscritos, double costoTotal, LocalDate fecha) {
        this.nombreAlumno = nombreAlumno;
        this.cursosInscritos = cursosInscritos;
        this.costoTotal = costoTotal;
        this.fecha = fecha;
    }

    public InscripcionVista() {
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public List<CursoVista> getCursosInscritos() {
        return cursosInscritos;
    }

    public void setCursosInscritos(List<CursoVista> cursosInscritos) {
        this.cursosInscritos = cursosInscritos;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "InscripcionVista{" + "nombreAlumno=" + nombreAlumno + ", cursosInscritos=" + cursosInscritos + ", costoTotal=" + costoTotal + ", fecha=" + fecha + '}';
    }
    
    
}
