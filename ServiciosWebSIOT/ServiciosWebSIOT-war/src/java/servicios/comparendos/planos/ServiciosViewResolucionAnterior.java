package servicios.comparendos.planos;

import java.util.List;

import javax.jws.WebService;

import modelo.datos.objetos.comparendos.planos.ViewResolucionAnterior;

import modelo.logica.comparendos.planos.GestionServiciosViewResolucionAnterior;

@WebService
public class ServiciosViewResolucionAnterior {
    
    GestionServiciosViewResolucionAnterior gestionServiciosViewResolucionAnterior;
    
    public ServiciosViewResolucionAnterior() {
        super();
        gestionServiciosViewResolucionAnterior = new GestionServiciosViewResolucionAnterior ();
    }
    
    public List getViewResolucionAnterior(ViewResolucionAnterior viewResolucionAnterior){
        return gestionServiciosViewResolucionAnterior.getViewResolucionAnterior(viewResolucionAnterior);
    }
}
