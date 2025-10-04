package ModeloNegocios;

import ModeloNegocios.Entidades.Curso;

import java.util.List;

public interface IModeloNegocios {

    public void iniciarInscripcion(String nombre);

    public void finalizarInscripcion();
    
    public void ObtenerCursosDisponibles();

    public void moverCurso(boolean haciaDisponibles, int indice);

    public double calcularCostoTotal(List<Curso> cursosInscritos);

    public List<Curso> crearListadoCursosDisponiblesMock();
}
