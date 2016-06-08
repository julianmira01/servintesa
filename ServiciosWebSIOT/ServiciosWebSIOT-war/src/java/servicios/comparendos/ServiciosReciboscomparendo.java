package servicios.comparendos;

import java.util.List;

import javax.jws.WebService;

import modelo.datos.objetos.comparendos.liquidador.Reciboscomparendo;

import modelo.logica.comparendos.liquidador.GestionServiciosReciboscomparendo;


@WebService
public class ServiciosReciboscomparendo {

    GestionServiciosReciboscomparendo gestionServiciosReciboscomparendo;

    public ServiciosReciboscomparendo() {
        super();
        gestionServiciosReciboscomparendo = new GestionServiciosReciboscomparendo();
    }
    
    /**
     *
     * @return
     */
    public String version() {
        return "1.0";
    }
    
    /**
     *
     * @return
     */
    public List listarTodosReciboscomparendo() {
        return gestionServiciosReciboscomparendo.listarTodos();
    }
    
    /**
     *
     * @param reciboscomparendo
     * @return
     */
    public int crearReciboscomparendo(Reciboscomparendo reciboscomparendo) {
        return gestionServiciosReciboscomparendo.crear(reciboscomparendo);
    }
    
    /**
     *
     * @param reciboscomparendo
     * @return
     */
    public boolean editarReciboscomparendo(Reciboscomparendo reciboscomparendo) {
        return gestionServiciosReciboscomparendo.editar(reciboscomparendo);
    }
    
    /**
     *
     * @param reciboscomparendo
     * @return
     */
    public List buscarReciboscomparendo(Reciboscomparendo reciboscomparendo) {
        return gestionServiciosReciboscomparendo.buscar(reciboscomparendo);
    }
}
