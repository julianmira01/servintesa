package servicios.generales;

import java.util.List;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;

import modelo.datos.objetos.generales.Transito;

import modelo.logica.generales.GestionServiciosTransitoLocal;


@WebService
public class ServiciosTransito {
    
    GestionServiciosTransitoLocal gestionServiciosTransitoLocal;
    
    public ServiciosTransito() {
        super();
        crearObjetos();
    }

    @WebMethod
    @Oneway
    public void crearObjetos(){
      gestionServiciosTransitoLocal = new GestionServiciosTransitoLocal();
    }

    @WebMethod
    public List obtenerTransitos(){
      return gestionServiciosTransitoLocal.getTransitos();
    }
    
    @WebMethod
    public Transito obtenerTransito(){
      return gestionServiciosTransitoLocal.getTransito();
    }
    
    @WebMethod
    public Transito getTransito(Transito transito){
      return gestionServiciosTransitoLocal.getTransito(transito);
    }
    
    @WebMethod
    public Transito guardarTransito(Transito transito){
      return gestionServiciosTransitoLocal.saveTransito(transito);
    }
    
    @WebMethod
    public Transito crearTransito(Transito transito){
      return gestionServiciosTransitoLocal.crearTransito(transito);
    }
}
