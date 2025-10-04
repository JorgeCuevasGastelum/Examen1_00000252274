package ModeloVista;

import ModeloNegocios.Entidades.Curso;
import ModeloNegocios.Entidades.Inscripcion;
import ModeloVista.Entidades.CursoVista;
import ModeloVista.Entidades.InscripcionVista;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ControlVista {
    private ModeloVista modeloVista;
    
    public ControlVista(ModeloVista modeloVista) {
        this.modeloVista = modeloVista;
    }
    
    public void actualizarListadoCursos(List<Curso> cursosDisponibles, List<Curso> cursosInscritos){
        modeloVista.actualizarCursosDisponibles(convertirACursosVista(cursosDisponibles));
        modeloVista.actualizarCursosInscritos(convertirACursosVista(cursosInscritos));
    }
    
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
    
    public void actualizarCostoTotal(Double costoTotal){
        modeloVista.actualizarCostoTotal(costoTotal);
    }
    
    public void actualizarInscripcion(Inscripcion inscripcionAlumno){
        modeloVista.actualizarInscripcion(convertirAInscripcionVista(inscripcionAlumno));
    }
    
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
