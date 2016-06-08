package servicios.comparendos.planos;

import java.util.List;

import javax.jws.WebService;

import modelo.datos.objetos.comparendos.planos.ViewInfractorComparendo;

import modelo.logica.comparendos.planos.GestionServiciosViewInfractorComparendo;

@WebService
public class ServiciosViewInfractorComparendo {
    
    GestionServiciosViewInfractorComparendo gestionServiciosViewInfractorComparendo;
    
    public ServiciosViewInfractorComparendo() {
        super();
        gestionServiciosViewInfractorComparendo = new GestionServiciosViewInfractorComparendo();
    }
    
    public List getViewInfractorComparendo(ViewInfractorComparendo viewInfractorComparendo){
        return gestionServiciosViewInfractorComparendo.getViewInfractorComparendo(viewInfractorComparendo);
    }
    
    //SERVICIOS NUEVOS - EDWIN
  public List getViewInfractorComparendoPersuasivo(){
      return gestionServiciosViewInfractorComparendo.getViewInfractorComparendoPersuasivo();
  }
}
