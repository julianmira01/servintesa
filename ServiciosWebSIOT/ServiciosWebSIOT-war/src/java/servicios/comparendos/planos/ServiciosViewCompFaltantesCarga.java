package servicios.comparendos.planos;

import java.util.List;

import javax.jws.WebService;

import modelo.datos.objetos.comparendos.planos.ViewCompFaltantesCarga;

import modelo.logica.comparendos.planos.GestionServiciosViewCompFaltantesCarga;

@WebService
public class ServiciosViewCompFaltantesCarga {
    
    GestionServiciosViewCompFaltantesCarga gestionServiciosViewCompFaltantesCarga;
    
    public ServiciosViewCompFaltantesCarga() {
        super();
        gestionServiciosViewCompFaltantesCarga = new GestionServiciosViewCompFaltantesCarga();
    }
    
    public List getViewCompFaltantesCarga(ViewCompFaltantesCarga viewCompFaltantesCarga){
        return gestionServiciosViewCompFaltantesCarga.getViewCompFaltantesDao(viewCompFaltantesCarga);
    }
    
    public List getCompFaltantesCargaPorFechas(ViewCompFaltantesCarga viewCompFaltantesCarga, String fecha1, String fecha2){
        return gestionServiciosViewCompFaltantesCarga.getCompFaltantesCargaPorFechas(viewCompFaltantesCarga, fecha1, fecha2);
    }
}
