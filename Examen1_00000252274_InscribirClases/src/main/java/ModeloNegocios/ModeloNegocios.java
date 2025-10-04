package ModeloNegocios;

import ModeloNegocios.Entidades.Curso;
import ModeloVista.ControlVista;
import ModeloNegocios.Entidades.Inscripcion;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase ModeloNegocios
 *
 * Esta clase representa la capa de negocio del sistema de inscripción. Contiene
 * la lógica principal para administrar los cursos disponibles, los cursos
 * inscritos y la creación de la inscripción del alumno.
 *
 * @author Jorge Cuevas Gastelum - 00000252274
 */
public class ModeloNegocios implements IModeloNegocios {

    private ControlVista controlVista;
    private List<Curso> cursosDisponibles;
    private List<Curso> cursosInscritos;
    private Inscripcion inscripcionAlumno;

    /**
     * Constructor del modelo de negocio. Inicializa el controlador de vista y
     * carga la lista de cursos disponibles simulados.
     *
     * @param controlVista controlVista instancia del controlador que comunica
     * la vista y el modelo.
     */
    public ModeloNegocios(ControlVista controlVista) {
        this.controlVista = controlVista;
        this.cursosDisponibles = crearListadoCursosDisponiblesMock();
        this.cursosInscritos = new ArrayList<>();
    }

    /**
     * Inicia una nueva inscripción para un alumno. Asigna el nombre del alumno,
     * la fecha actual del sistema y actualiza los cursos disponibles en la
     * vista.
     *
     * @param nombre nombre del alumno que realiza la inscripción.
     */
    public void iniciarInscripcion(String nombre) {
        this.inscripcionAlumno = new Inscripcion(nombre);
        inscripcionAlumno.setFecha(LocalDate.now());
        ObtenerCursosDisponibles();
    }

    /**
     * Finaliza la inscripción actual del alumno. Asigna los cursos inscritos,
     * el costo total y la fecha actual. Si no hay una inscripción activa,
     * muestra un mensaje de error.
     */
    public void finalizarInscripcion() {
        if (inscripcionAlumno == null) {
            System.out.println("Error: No hay inscripción activa.");
            return;
        }

        // Asignamos los datos actuales
        inscripcionAlumno.setCursos(new ArrayList<>(cursosInscritos));
        inscripcionAlumno.setCosto(calcularCostoTotal(cursosInscritos));
        inscripcionAlumno.setFecha(LocalDate.now());

        controlVista.actualizarInscripcion(inscripcionAlumno);
    }

    /**
     * Envía la información de los cursos disponibles e inscritos al modelo de
     * vista.
     */
    public void ObtenerCursosDisponibles() {
        controlVista.actualizarListadoCursos(cursosDisponibles, cursosInscritos);
    }

    /**
     * Mueve un curso entre las listas de disponibles e inscritos según el
     * parámetro.
     *
     * @param haciaDisponibles true si se desea mover el curso hacia los
     * disponibles (desinscribir), false si se desea mover hacia los inscritos
     * (inscribir).
     * @param indice índice del curso en la lista correspondiente.
     */
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
        controlVista.actualizarCostoTotal(calcularCostoTotal(cursosInscritos));
    }

    /**
     * Calcula el costo total de los cursos inscritos.
     *
     * @param cursosInscritos lista de cursos inscritos por el alumno.
     * @return el costo total de todos los cursos inscritos.
     */
    public double calcularCostoTotal(List<Curso> cursosInscritos) {
        return cursosInscritos.stream()
                .mapToDouble(Curso::getCosto)
                .sum();
    }

    /**
     * Crea una lista simulada (mock) de cursos disponibles para inscripción.
     * Este método se utiliza como fuente de datos de prueba.
     *
     * @return una lista de cursos disponibles con datos predefinidos.
     */
    public List<Curso> crearListadoCursosDisponiblesMock() {
        cursosDisponibles = new ArrayList<>();
        cursosDisponibles.add(new Curso("1A2E", "Programación III", "AV1825", 1500.0));
        cursosDisponibles.add(new Curso("2A3E", "Base de Datos", "LV1821", 1800.0));
        cursosDisponibles.add(new Curso("3A4E", "Estructuras de Datos", "LV1823", 1300.0));
        cursosDisponibles.add(new Curso("4A5E", "Sistemas Operativos", "AV1821", 1700.0));
        cursosDisponibles.add(new Curso("5A6E", "Ingeniería de Software", "AV1828", 2000.0));
        return cursosDisponibles;
    }

}
