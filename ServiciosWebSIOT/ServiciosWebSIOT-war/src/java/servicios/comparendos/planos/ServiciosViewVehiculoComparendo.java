package servicios.comparendos.planos;

import java.util.List;

import javax.jws.WebService;

import modelo.datos.objetos.comparendos.planos.ViewVehiculoComparendo;

import modelo.logica.comparendos.planos.GestionServiciosViewVehiculoComparendo;

@WebService
public class ServiciosViewVehiculoComparendo {
    
    GestionServiciosViewVehiculoComparendo gestionServiciosViewVehiculoComparendo;
    
    public ServiciosViewVehiculoComparendo() {
        super();
        gestionServiciosViewVehiculoComparendo = new GestionServiciosViewVehiculoComparendo();
    }
    
    public List getViewVehiculoComparendo(ViewVehiculoComparendo viewVehiculoComparendo){
        return gestionServiciosViewVehiculoComparendo.getViewVehiculoComparendo(viewVehiculoComparendo);
    }
}
