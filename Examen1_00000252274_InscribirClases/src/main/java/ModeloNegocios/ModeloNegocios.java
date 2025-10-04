package ModeloNegocios;

import ModeloNegocios.Entidades.Curso;
import ModeloVista.ControlVista;
import ModeloNegocios.Entidades.Inscripcion;
import java.util.ArrayList;
import java.util.List;


public class ModeloNegocios {
    private ControlVista controlVista;
    private List<Curso> cursosDisponibles;
    private List<Curso> cursosInscritos;
    private Inscripcion inscripcionAlumno;
    
    public ModeloNegocios(ControlVista controlVista) {
        this.controlVista = controlVista;
        this.cursosDisponibles = crearListadoCursosDisponiblesMock();
        this.cursosInscritos = new ArrayList<>();
    }
    
    public void iniciarInscripcion(String nombre){
        this.inscripcionAlumno = new Inscripcion(nombre);
        ObtenerCursosDisponibles();
    }
    
    
    public void ObtenerCursosDisponibles(){
        controlVista.actualizarListadoCursos(cursosDisponibles, cursosInscritos);
    }
    
    // Método para mover curso entre listas
    public void moverCurso(boolean haciaDisponibles, int indice) {
        if (haciaDisponibles) {
            // Desinscribir
            Curso curso = cursosInscritos.remove(indice);
            cursosDisponibles.add(curso);
        } else {
            // Inscribir
            Curso curso = cursosDisponibles.remove(indice);
            cursosInscritos.add(curso);
        }

        // Notificar al modeloVista para que se actualice
        controlVista.actualizarListadoCursos(cursosDisponibles, cursosInscritos);
    }
    
    public List<Curso> crearListadoCursosDisponiblesMock(){
        cursosDisponibles = new ArrayList<>();
        cursosDisponibles.add(new Curso("1A2E","Programación III", "Aula 202", 1500.0));
        cursosDisponibles.add(new Curso("2A3E","Base de Datos", "Laboratorio 3", 1800.0));
        cursosDisponibles.add(new Curso("3A4E","Estructuras de Datos", "Aula 105", 1300.0));
        cursosDisponibles.add(new Curso("4A5E","Sistemas Operativos", "Aula 301", 1700.0));
        cursosDisponibles.add(new Curso("5A6E","Ingeniería de Software", "Aula 204", 2000.0));
        return cursosDisponibles;
    }
    
}
