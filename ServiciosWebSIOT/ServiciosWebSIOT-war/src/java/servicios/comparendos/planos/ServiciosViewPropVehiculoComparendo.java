package servicios.comparendos.planos;

import java.util.List;

import javax.jws.WebService;

import modelo.datos.objetos.comparendos.planos.ViewPropVehiculoComparendo;
import modelo.datos.objetos.comparendos.planos.ViewResFaltantesCarga;

import modelo.logica.comparendos.planos.GestionServiciosViewPropVehiculoComparendo;

@WebService
public class ServiciosViewPropVehiculoComparendo {
    
    GestionServiciosViewPropVehiculoComparendo gestionServiciosViewPropVehiculoComparendo;
    
    public ServiciosViewPropVehiculoComparendo() {
        super();
        gestionServiciosViewPropVehiculoComparendo = new GestionServiciosViewPropVehiculoComparendo();
    }
    
    public List getViewPropVehiculoComparendo(ViewPropVehiculoComparendo viewPropVehiculoComparendo){
        return gestionServiciosViewPropVehiculoComparendo.getViewPropVehiculoComparendo(viewPropVehiculoComparendo);
    }
}
