package servicios.comparendos.planos;

import java.util.List;

import javax.jws.WebService;

import modelo.datos.objetos.comparendos.planos.ViewInfraccionesComparendo;

import modelo.logica.comparendos.planos.GestionServiciosViewInfraccionesComparendo;

@WebService
public class ServiciosViewInfraccionesComparendo {
    
    GestionServiciosViewInfraccionesComparendo gestionServiciosViewInfraccionesComparendo;
    
    public ServiciosViewInfraccionesComparendo() {
        super();
        gestionServiciosViewInfraccionesComparendo = new GestionServiciosViewInfraccionesComparendo();
    }
    
    public List getViewInfraccionesComparendo(ViewInfraccionesComparendo viewInfraccionesComparendo){
        return gestionServiciosViewInfraccionesComparendo.getViewInfraccionesComparendo(viewInfraccionesComparendo);
    }
}
