package ModeloVista;

import ModeloNegocios.ModeloNegocios;
import ModeloVista.Entidades.CursoVista;
import ModeloVista.Entidades.InscripcionVista;
import Observer.Observer;
import java.util.ArrayList;
import java.util.List;

public class ModeloVista {

    private List<CursoVista> cursosDisponibles;
    private List<CursoVista> cursosInscritos;
    private Double costoTotal;
    private List<Observer> observers = new ArrayList<>();
    private ModeloNegocios modeloNegocio;
    private InscripcionVista inscripcion;

    public ModeloVista() {
        
    }
    
    public void setModeloNegocio(ModeloNegocios modeloNegocio){
        this.modeloNegocio = modeloNegocio;
    }
    
    public void iniciarInscripcion(String nombre){
        this.cursosInscritos = new ArrayList<>();
        this.costoTotal = 0.0;
        modeloNegocio.iniciarInscripcion(nombre);
    }
    
    public void actualizarInscripcion(InscripcionVista inscripcion){
        this.inscripcion = inscripcion;
        notificar();
    }
    
    public void finalizarInscripcion(){
        modeloNegocio.finalizarInscripcion();
    }
    
     public void moverCurso(boolean haciaDisponibles, int indice) {
        modeloNegocio.moverCurso(haciaDisponibles, indice);
    }

    public List<CursoVista> getCursosDisponibles() {
        return cursosDisponibles;
    }

    public List<CursoVista> getCursosInscritos() {
        return cursosInscritos;
    }
    
    public void actualizarCursosDisponibles(List<CursoVista> cursosDisponibles){
        this.cursosDisponibles = cursosDisponibles;
        notificar();
    }
    
    public void actualizarCursosInscritos(List<CursoVista> cursosInscritos){
        this.cursosInscritos = cursosInscritos;
        notificar();
    }
    
    public void actualizarCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
        notificar();
    }

    public Double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public InscripcionVista getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(InscripcionVista inscripcion) {
        this.inscripcion = inscripcion;
    }
    
    
    

    //Metodo usado para agregar observadores en este caso la PRESENTACION se agrega como observador
    public void addObserver(Observer o) {
        observers.add(o);
    }

    //Metodo que notifica a los observadores (en este caso solamente la PRESENTACION). despues como la presentacion implementa metodos de observer, se ejecuta update() el cual repinta la pantalla despues de ser notificada.
    private void notificar() {
        for (Observer o : observers) {
            o.update();
        }
    }

}
