package ModeloVista;

import ModeloNegocios.Entidades.Curso;
import ModeloVista.Entidades.CursoVista;
import java.util.ArrayList;
import java.util.List;

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

}
