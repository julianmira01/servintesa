package servicios.comparendos.planos;

import java.util.List;

import javax.jws.WebService;

import modelo.datos.objetos.comparendos.planos.ViewResFaltantesCarga;

import modelo.logica.comparendos.planos.GestionServiciosViewResFaltantesCarga;

@WebService
public class ServiciosViewResFaltantesCarga {
    
    GestionServiciosViewResFaltantesCarga gestionServiciosViewResFaltantesCarga;
    
    public ServiciosViewResFaltantesCarga() {
        super();
        gestionServiciosViewResFaltantesCarga = new GestionServiciosViewResFaltantesCarga();
    }
    
    public List getViewResFaltantesCarga(ViewResFaltantesCarga viewResFaltantesCarga){
        return gestionServiciosViewResFaltantesCarga.getViewResFaltantesCarga(viewResFaltantesCarga);
    }
    
    public List getViewResFaltantesCarga2(ViewResFaltantesCarga viewResFaltantesCarga){
        return gestionServiciosViewResFaltantesCarga.getViewResFaltantesCarga2(viewResFaltantesCarga);
    }
    
    public List getResFaltantesCargaPorFechas(ViewResFaltantesCarga viewResFaltantesCarga, String fecha1, String fecha2) {
        return gestionServiciosViewResFaltantesCarga.getResFaltantesCargaPorFechas(viewResFaltantesCarga, fecha1, fecha2);
    }
}
