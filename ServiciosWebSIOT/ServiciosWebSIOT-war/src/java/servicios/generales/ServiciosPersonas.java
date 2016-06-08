package servicios.generales;

import com.ctc.wstx.util.ExceptionUtil;

import java.util.List;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;

import modelo.datos.objetos.accesorias.Direccion;
import modelo.datos.objetos.generales.Persona;

import modelo.logica.generales.GestionServiciosPersonasLocal;


@WebService
public class ServiciosPersonas {
    
    GestionServiciosPersonasLocal gestionServiciosPersonasLocal;
    
    public ServiciosPersonas() {
        super();
        crearObjetos();
    }

    @Oneway
    @WebMethod
    public void crearObjetos(){
       gestionServiciosPersonasLocal=new GestionServiciosPersonasLocal();
    }

    @WebMethod
    public Persona getPersona(Persona persona) throws Exception {   
        try{
        return gestionServiciosPersonasLocal.getPersona(persona, false );}catch(Exception e){throw new Exception (e.getMessage());}
    }

    @WebMethod
    public List getPersonas(Persona persona) throws Exception {
        try{
      return gestionServiciosPersonasLocal.getPersonas(persona);}catch(Exception e){throw new Exception (e.getMessage());}
    }
    
    @WebMethod
    public List getPersonasNombres(Persona persona) throws Exception {
        try{
      return gestionServiciosPersonasLocal.getPersonasNombres(persona);
        }catch(Exception e){throw new Exception (e.getMessage());}
    }

    @WebMethod
    public Persona crearPersona(Persona persona) throws Exception {
        try{

      return gestionServiciosPersonasLocal.crearPersona(persona, false);
        }catch(Exception e){throw new Exception (e.getMessage());}
    }

    @WebMethod
    public boolean editarPersona(Persona persona) throws Exception {
        try{

      return gestionServiciosPersonasLocal.editarPersona(persona);
        }catch(Exception e){throw new Exception(e.getMessage());}
    }

    @WebMethod
    public String crearImagenes(Persona persona) {
    return gestionServiciosPersonasLocal.crearImagenes(persona);
  }

    @WebMethod
    public boolean validarExistenciaPersonaLlavePrimaria(Persona persona){
      return gestionServiciosPersonasLocal.validarExistenciaPersonaLlavePrimaria(persona);
    }

    @WebMethod
    public boolean validarExistenciaPersona(Persona persona){
      return gestionServiciosPersonasLocal.validarExistenciaPersona(persona);
    }

    @WebMethod
    public List getLoadAllPersonas(Persona persona){
      return gestionServiciosPersonasLocal.loadAllPersonas(persona);
    }

    @WebMethod
    public List getPersonasIdentificacion(Persona persona){
      return gestionServiciosPersonasLocal.getPersonasIdentificacion(persona);
    }

    @WebMethod
    public Direccion getDireccion(Direccion direccion){
      return null;
    }
}
