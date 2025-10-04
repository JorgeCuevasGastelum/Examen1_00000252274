package ModeloVista;

import ModeloNegocios.Entidades.Curso;
import ModeloNegocios.Entidades.Inscripcion;
import ModeloVista.Entidades.CursoVista;
import ModeloVista.Entidades.InscripcionVista;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase Control Vista ControlVista es la clase controladora que sirve de
 * intermediaria entre el ModeloNegocio y el ModeloVista.
 *
 * @author Jorge Cuevas Gastelum - 00000252274
 */
public class ControlVista {

    private ModeloVista modeloVista;

    /**
     * Constructor que recibe la instancia de ModeloVista a controlar.
     *
     * @param modeloVista instancia del ModeloVista.
     */
    public ControlVista(ModeloVista modeloVista) {
        this.modeloVista = modeloVista;
    }

    /**
     * Actualiza las listas de cursos disponibles e inscritos en el ModeloVista.
     * Convierte previamente los cursos de entidad de negocio a entidad de
     * vista.
     *
     * @param cursosDisponibles lista de cursos disponibles del modelo de
     * negocio.
     * @param cursosInscritos lista de cursos inscritos del modelo de negocio.
     */
    public void actualizarListadoCursos(List<Curso> cursosDisponibles, List<Curso> cursosInscritos) {
        modeloVista.actualizarCursosDisponibles(convertirACursosVista(cursosDisponibles));
        modeloVista.actualizarCursosInscritos(convertirACursosVista(cursosInscritos));
    }

    /**
     * Convierte una lista de objetos Curso del modelo de negocio en una lista
     * de objetos CursoVista para la vista.
     *
     * @param listaCursos lista de cursos del modelo de negocio.
     * @return lista de cursos convertida a CursoVista.
     */
    public List<CursoVista> convertirACursosVista(List<Curso> listaCursos) {
        List<CursoVista> listaVista = new ArrayList<>();
        //Conversion a entidad de modelo vista
        for (Curso curso : listaCursos) {
            CursoVista vista = new CursoVista(
                    curso.getNombre(),
                    curso.getAula(),
                    curso.getCosto()
            );
            listaVista.add(vista);
        }

        return listaVista;
    }

    /**
     * Actualiza el costo total de los cursos inscritos en el ModeloVista.
     *
     * @param costoTotal valor del costo total a mostrar en la vista.
     */
    public void actualizarCostoTotal(Double costoTotal) {
        modeloVista.actualizarCostoTotal(costoTotal);
    }

    /**
     * Actualiza la información completa de una inscripción en el ModeloVista.
     * Convierte primero la inscripción del modelo de negocio a
     * InscripcionVista.
     *
     * @param inscripcionAlumno objeto Inscripcion del modelo de negocio.
     */
    public void actualizarInscripcion(Inscripcion inscripcionAlumno) {
        modeloVista.actualizarInscripcion(convertirAInscripcionVista(inscripcionAlumno));
    }

    /**
     * Convierte un objeto Inscripcion del modelo de negocio a un objeto
     * InscripcionVista para la vista.
     *
     * @param inscripcion objeto Inscripcion del modelo de negocio.
     * @return objeto InscripcionVista listo para la vista.
     */
    private InscripcionVista convertirAInscripcionVista(Inscripcion inscripcion) {
        List<CursoVista> cursosVista = inscripcion.getCursos().stream()
                .map(c -> new CursoVista(c.getNombre(), c.getAula(), c.getCosto()))
                .collect(Collectors.toList());

        return new InscripcionVista(
                inscripcion.getNombreAlumno(),
                cursosVista,
                inscripcion.getCosto(),
                inscripcion.getFecha()
        );

    }

}
