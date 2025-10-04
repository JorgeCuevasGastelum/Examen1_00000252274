package ModeloVista;

import ModeloNegocios.IModeloNegocios;
import ModeloVista.Entidades.CursoVista;
import ModeloVista.Entidades.InscripcionVista;
import Observer.Observer;
import java.util.List;

public interface IModeloVista {

    public void setModeloNegocio(IModeloNegocios modeloNegocio);

    public void iniciarInscripcion(String nombre);

    public void actualizarInscripcion(InscripcionVista inscripcion);

    public void finalizarInscripcion();

    public void moverCurso(boolean haciaDisponibles, int indice);

    public List<CursoVista> getCursosDisponibles();

    public List<CursoVista> getCursosInscritos();

    public void actualizarCursosDisponibles(List<CursoVista> cursosDisponibles);

    public void actualizarCursosInscritos(List<CursoVista> cursosInscritos);

    public void actualizarCostoTotal(double costoTotal);

    public Double getCostoTotal();

    public void setCostoTotal(Double costoTotal);

    public InscripcionVista getInscripcion();

    public void setInscripcion(InscripcionVista inscripcion);

    //Metodo usado para agregar observadores en este caso la PRESENTACION se agrega como observador
    public void addObserver(Observer o);

}
