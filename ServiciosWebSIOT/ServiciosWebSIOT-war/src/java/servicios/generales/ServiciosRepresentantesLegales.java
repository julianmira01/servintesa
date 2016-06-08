package servicios.generales;

import java.util.List;

import javax.jws.Oneway;
import javax.jws.WebMethod;

import javax.jws.WebService;

import modelo.datos.objetos.generales.RepresentanteLegal;

import modelo.logica.generales.GestionServiciosRepresentantesLegalesLocal;

@WebService
public class ServiciosRepresentantesLegales {
    
    GestionServiciosRepresentantesLegalesLocal gestionServiciosRepresentantesLegalesLocal; 
    
    public ServiciosRepresentantesLegales() {
        super();
        crearObjetos();
    }

    @WebMethod
    @Oneway
    public void crearObjetos(){
      gestionServiciosRepresentantesLegalesLocal = new GestionServiciosRepresentantesLegalesLocal();
    }

    @WebMethod
    public List getRepresentanteLegal(RepresentanteLegal representante){
      return gestionServiciosRepresentantesLegalesLocal.getRepresentanteLegal(representante);
    }

    @WebMethod
    public RepresentanteLegal crearRepresentanteLegal(RepresentanteLegal representante){
      return gestionServiciosRepresentantesLegalesLocal.crearRepresentanteLegal(representante);          
    }
    
    @WebMethod
    public RepresentanteLegal actualizarRepresentanteLegal(RepresentanteLegal representante){
      return gestionServiciosRepresentantesLegalesLocal.actualizarRepresentanteLegal(representante);          
    }
}
