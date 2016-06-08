package servicios.comparendos.planos;
import java.util.List;
import javax.jws.WebService;

import modelo.datos.objetos.comparendos.planos.ViewPagosFaltantesCarga;

import modelo.logica.comparendos.planos.GestionServiciosViewPagosFaltantesCarga;

@WebService
public class ServiciosViewPagosFaltantesCarga {
    GestionServiciosViewPagosFaltantesCarga myGestion;
    
    public ServiciosViewPagosFaltantesCarga() {
        super();
        myGestion = new GestionServiciosViewPagosFaltantesCarga();
    }
    
    public List getViewPagosFaltantesCarga(ViewPagosFaltantesCarga viewPagosFaltantesCarga){
        return myGestion.getViewPagosFaltantesCarga(viewPagosFaltantesCarga);
    }
    
    public List listarViewPagosFaltantesCarga(){
        return myGestion.getViewPagosFaltantesCarga();
    }
}
