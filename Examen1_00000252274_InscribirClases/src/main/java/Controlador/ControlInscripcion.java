package Controlador;

import ModeloVista.IModeloVista;

/**
 * Clase Control Inscripcion
 *
 * Se encarga de llevar acabo la conexion entre la presentacion y modelo vista,
 * para llevar acabo las acciones y eventos que se ejecuten en presentacion
 *
 * @author Jorge Cuevas Gastelum - 00000252274
 */
public class ControlInscripcion {

    private final IModeloVista modeloVista;

    /**
     * Constructor que inicializa el modeloVista
     *
     * @param modeloVista Recibe un modeloVista como parametro
     */
    public ControlInscripcion(IModeloVista modeloVista) {
        this.modeloVista = modeloVista;
    }

    /**
     * Metodo que inicializa el objeto de inscripcion a sus valores por defecto
     *
     * @param nombre Le asigna un nombre de estudiante a la inscripcion
     */
    public void iniciarInscripcion(String nombre) {
        modeloVista.iniciarInscripcion(nombre);
    }

    /**
     * Metodo que se utiliza para mandar a llamar al modelo vista para inscribir
     * en un curso a un estudiante
     *
     * @param indice recibe como parametro el indice del curso en el que se
     * encuentra en la lista
     */
    public void inscribirCurso(int indice) {
        modeloVista.moverCurso(false, indice); // false = de disponibles a inscritos
    }

    /**
     * Metodo que se utiliza para mandar a llamar al modelo vista para
     * desinscribir en un curso a un estudiante
     *
     * @param indice recibe como parametro el indice del curso en el que se
     * encuentra en la lista
     */
    public void desinscribirCurso(int indice) {
        modeloVista.moverCurso(true, indice); // true = de inscritos a disponibles
    }

    /**
     * Metodo que finaliza el objeto Inscripcion asignadole los cursos
     * seleccionados y generando una ficha de pago
     */
    public void finalizarInscripcion() {
        modeloVista.finalizarInscripcion();
    }
}
