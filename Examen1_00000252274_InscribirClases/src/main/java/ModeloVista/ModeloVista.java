package ModeloVista;

import ModeloNegocios.IModeloNegocios;
import ModeloVista.Entidades.CursoVista;
import ModeloVista.Entidades.InscripcionVista;
import Observer.Observer;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase ModeloVista
 * 
 * Representa la capa intermedia entre la vista (presentacion) y el modelo de negocio.
 * Su funcion principal es mantener el estado de los datos que deben ser visibles en la interfaz,
 * recibir notificaciones desde la capa de negocio y actualizar las vistas observadoras
 * mediante el patrón Observer.
 * 
 * @author Jorge Cuevas Gastelum - 00000252274
 */
public class ModeloVista implements IModeloVista{

    private List<CursoVista> cursosDisponibles;
    private List<CursoVista> cursosInscritos;
    private Double costoTotal;
    private List<Observer> observers = new ArrayList<>();
    private IModeloNegocios modeloNegocio;
    private InscripcionVista inscripcion;

    /**
     * Constructor por defecto del modelo vista.
     * Inicializa las listas y el costo total a valores nulos.
     */
    public ModeloVista() {
        
    }
    
    /**
     * Asigna el modelo de negocio que se comunicará con esta capa.
     * 
     * @param modeloNegocio instancia del modelo de negocio.
     */
    public void setModeloNegocio(IModeloNegocios modeloNegocio){
        this.modeloNegocio = modeloNegocio;
    }
    
    /**
     * Inicia una nueva inscripción para un alumno.
     * Limpia las listas de cursos inscritos, reinicia el costo total
     * y delega la operación al modelo de negocio.
     * 
     * @param nombre nombre del alumno que realiza la inscripción.
     */
    public void iniciarInscripcion(String nombre){
        this.cursosInscritos = new ArrayList<>();
        this.costoTotal = 0.0;
        modeloNegocio.iniciarInscripcion(nombre);
    }
    
    /**
     * Actualiza la información de la inscripción actual.
     * Recibe el objeto InscripcionVista desde el modelo de negocio.
     * 
     * @param inscripcion objeto que contiene los datos completos de la inscripción.
     */
    public void actualizarInscripcion(InscripcionVista inscripcion){
        this.inscripcion = inscripcion;
        notificar();
    }
    
    /**
     * Finaliza el proceso de inscripción delegando la acción al modelo de negocio.
     */
    public void finalizarInscripcion(){
        modeloNegocio.finalizarInscripcion();
    }
    
    /**
     * Solicita al modelo de negocio mover un curso entre las listas
     * de disponibles e inscritos según el parámetro recibido.
     * 
     * @param haciaDisponibles true si se desea mover hacia los cursos disponibles (desinscribir),
     *                         false si se desea mover hacia los cursos inscritos (inscribir).
     * @param indice índice del curso seleccionado en la lista correspondiente.
     */
     public void moverCurso(boolean haciaDisponibles, int indice) {
        modeloNegocio.moverCurso(haciaDisponibles, indice);
    }

     /**
     * Retorna la lista actual de cursos disponibles.
     * 
     * @return lista de objetos CursoVista disponibles para inscripción.
     */
    public List<CursoVista> getCursosDisponibles() {
        return cursosDisponibles;
    }

    /**
     * Retorna la lista actual de cursos inscritos.
     * 
     * @return lista de objetos CursoVista ya inscritos.
     */
    public List<CursoVista> getCursosInscritos() {
        return cursosInscritos;
    }
    
    /**
     * Actualiza la lista de cursos disponibles y notifica a los observadores.
     * 
     * @param cursosDisponibles nueva lista de cursos disponibles.
     */
    public void actualizarCursosDisponibles(List<CursoVista> cursosDisponibles){
        this.cursosDisponibles = cursosDisponibles;
        notificar();
    }
    
    /**
     * Actualiza la lista de cursos inscritos y notifica a los observadores.
     * 
     * @param cursosInscritos nueva lista de cursos inscritos.
     */
    public void actualizarCursosInscritos(List<CursoVista> cursosInscritos){
        this.cursosInscritos = cursosInscritos;
        notificar();
    }
    
    /**
     * Actualiza el costo total acumulado de los cursos inscritos y notifica a los observadores.
     * 
     * @param costoTotal nuevo valor del costo total.
     */
    public void actualizarCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
        notificar();
    }

    /**
     * Retorna el costo total actual de los cursos inscritos.
     * 
     * @return costo total de los cursos inscritos.
     */
    public Double getCostoTotal() {
        return costoTotal;
    }

    /**
     * Asigna un nuevo valor al costo total.
     * 
     * @param costoTotal nuevo valor del costo total.
     */
    public void setCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal;
    }

    /**
     * Retorna el objeto InscripcionVista actual.
     * 
     * @return inscripción actual con todos los datos del alumno y sus cursos.
     */
    public InscripcionVista getInscripcion() {
        return inscripcion;
    }

    /**
     * Asigna una nueva inscripción y notifica a los observadores.
     * 
     * @param inscripcion nueva inscripción con datos actualizados.
     */
    public void setInscripcion(InscripcionVista inscripcion) {
        this.inscripcion = inscripcion;
    }
    

    /**
     * Agrega un nuevo observador (como una vista o panel de interfaz) que será
     * notificado cada vez que el modelo cambie.
     * 
     * @param o observador que implementa la interfaz Observer.
     */
    public void addObserver(Observer o) {
        observers.add(o);
    }
    
    /**
     * Notifica a todos los observadores registrados que se ha producido un cambio
     * en el modelo. Cada observador ejecutará su método update().
     */
    private void notificar() {
        for (Observer o : observers) {
            o.update();
        }
    }

}
