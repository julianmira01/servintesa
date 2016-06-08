package servicios.comparendos.planos;

import java.util.List;

import javax.jws.WebService;

import modelo.datos.objetos.comparendos.planos.ViewCompPorRangoAprobados;

import modelo.logica.comparendos.planos.GestionServiciosViewCompPorRangoAprobados;

@WebService
public class ServiciosViewCompPorRangoAprobados {
    
    GestionServiciosViewCompPorRangoAprobados gestionServiciosViewCompPorRangoAprobados;
    
    public ServiciosViewCompPorRangoAprobados() {
        super();
        gestionServiciosViewCompPorRangoAprobados = new GestionServiciosViewCompPorRangoAprobados();
    }
    
    public List getViewCompPorRangoAprobados(ViewCompPorRangoAprobados viewCompPorRangoAprobados){
        return gestionServiciosViewCompPorRangoAprobados.getViewCompPorRangoAprobados(viewCompPorRangoAprobados);
    }
}
