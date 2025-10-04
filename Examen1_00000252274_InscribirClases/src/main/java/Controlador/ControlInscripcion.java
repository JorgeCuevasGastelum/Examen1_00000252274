package Controlador;

import ModeloVista.ModeloVista;

public class ControlInscripcion {
    private final ModeloVista modeloVista;

    public ControlInscripcion(ModeloVista modeloVista) {
        this.modeloVista = modeloVista;
    }
    
    public void iniciarInscripcion(String nombre){
        modeloVista.iniciarInscripcion(nombre);
    }
    
    public void inscribirCurso(int indice) {
        modeloVista.moverCurso(false, indice); // false = de disponibles a inscritos
    }

    public void desinscribirCurso(int indice) {
        modeloVista.moverCurso(true, indice); // true = de inscritos a disponibles
    }
    
    public void finalizarInscripcion(){ 
        modeloVista.finalizarInscripcion();
    }
}
