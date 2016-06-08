package servicios.comparendos;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import modelo.datos.objetos.comparendos.coactivo.Bieninmueble;
import modelo.datos.objetos.comparendos.coactivo.Docsexpediente;
import modelo.datos.objetos.comparendos.coactivo.Expediente;
import modelo.datos.objetos.comparendos.coactivo.Expedientecomparendo;
import modelo.datos.objetos.comparendos.coactivo.Instituciones;
import modelo.datos.objetos.comparendos.coactivo.Tipodoccobro;

import modelo.logica.comparendos.coactivo.GestionServiciosCoactivo;

@WebService
public class ServiciosCoactivo {
    
    GestionServiciosCoactivo gestionServiciosCoactivo;

    public ServiciosCoactivo() {
        super();
        gestionServiciosCoactivo = new GestionServiciosCoactivo();
    }
    
  //*************************** INICIO BIENINMUEBLE *******************************************
  //*******************************************************************************************
    @WebMethod
    public Bieninmueble crearBieninmueble(Bieninmueble obj ) {
      return gestionServiciosCoactivo.crearBieninmueble(obj); 
    }
    
    @WebMethod
    public boolean editarBieninmueble(Bieninmueble obj) {   
          return gestionServiciosCoactivo.editarBieninmueble(obj);
    }
    
    @WebMethod
    public Bieninmueble buscarPrimeroBieninmueble(Bieninmueble obj) {   
          return gestionServiciosCoactivo.buscarPrimeroBieninmueble(obj);
    }
    
    @WebMethod
    public List buscarBieninmueble(Bieninmueble obj) {  
          return gestionServiciosCoactivo.buscarBieninmueble(obj);
    }
    
    @WebMethod
    public List listarBieninmueble() {
        return gestionServiciosCoactivo.listarBieninmueble();
    }
    
    @WebMethod
    public int contarBusquedaBieninmueble(Bieninmueble obj) {
          return gestionServiciosCoactivo.contarBusquedaBieninmueble(obj);
    }
    
    @WebMethod
    public boolean eliminarBieninmueble(Bieninmueble obj) {
          return gestionServiciosCoactivo.eliminarBieninmueble(obj);
    }
  //*************************** FIN BIENINMUEBLE *******************************************
  //****************************************************************************************

    
    
  //*************************** INICIO DOCSEXPEDIENTE *******************************************
  //*******************************************************************************************
  @WebMethod
    public Docsexpediente crearDocsexpediente(Docsexpediente obj ) {
          return gestionServiciosCoactivo.crearDocsexpediente(obj); 
    }
    
    @WebMethod
    public boolean editarDocsexpediente(Docsexpediente obj) {
          return gestionServiciosCoactivo.editarDocsexpediente(obj);
    }
    
    @WebMethod
    public Docsexpediente buscarPrimeroDocsexpediente(Docsexpediente obj) {
          return gestionServiciosCoactivo.buscarPrimeroDocsexpediente(obj);
    }
    
    @WebMethod
    public List buscarDocsexpediente(Docsexpediente obj) {
          return gestionServiciosCoactivo.buscarDocsexpediente(obj);
    }
    
    @WebMethod
    public List listarDocsexpediente() {
        return gestionServiciosCoactivo.listarDocsexpediente();
    }
    
    @WebMethod
    public int contarBusquedaDocsexpediente(Docsexpediente obj) {
          return gestionServiciosCoactivo.contarBusquedaDocsexpediente(obj);
    }
    
    @WebMethod
    public boolean eliminarDocsexpediente(Docsexpediente obj) {
          return gestionServiciosCoactivo.eliminarDocsexpediente(obj);
    }
  
  //*************************** FIN DOCSEXPEDIENTE *****************************************
  //****************************************************************************************


  //*************************** INICIO EXPEDIENTE *******************************************
  //****************************************************************************************
  @WebMethod
    public Expediente crearExpediente(Expediente obj ) {
          return gestionServiciosCoactivo.crearExpediente(obj); 
    }
    
    @WebMethod
    public boolean editarExpediente(Expediente obj) {
          return gestionServiciosCoactivo.editarExpediente(obj);
    }
    
    @WebMethod
    public Expediente buscarPrimeroExpediente(Expediente obj) {
          return gestionServiciosCoactivo.buscarPrimeroExpediente(obj);
    }
    
    @WebMethod
    public List buscarExpediente(Expediente obj) {
          return gestionServiciosCoactivo.buscarExpediente(obj);
    }
      
    @WebMethod
    public List listarExpediente() {
        return gestionServiciosCoactivo.listarExpediente();
    }
    
    @WebMethod
    public int contarBusquedaExpediente(Expediente obj) {
          return gestionServiciosCoactivo.contarBusquedaExpediente(obj);
    }
    
    @WebMethod
    public boolean eliminarExpediente(Expediente obj) {
          return gestionServiciosCoactivo.eliminarExpediente(obj);
    }
  //*************************** FIN EXPEDIENTE *******************************************
  //****************************************************************************************
    
  
  
  //*************************** INICIO Expedientecomparendo *******************************************
  //****************************************************************************************

  @WebMethod
  public Expedientecomparendo crearExpedientecomparendo(Expedientecomparendo obj) {
    return gestionServiciosCoactivo.crearExpedientecomparendo(obj); 
  }
  
  @WebMethod
  public boolean editarExpedientecomparendo(Expedientecomparendo obj) {
        return gestionServiciosCoactivo.editarExpedientecomparendo(obj);
  }
  
  @WebMethod
  public Expedientecomparendo buscarPrimeroExpedientecomparendo(Expedientecomparendo obj) {
        return gestionServiciosCoactivo.buscarPrimeroExpedientecomparendo(obj);
  }
  
  @WebMethod
  public List buscarExpedientecomparendo(Expedientecomparendo obj) {
        return gestionServiciosCoactivo.buscarExpedientecomparendo(obj);
  }
  
  @WebMethod
  public List listarExpedientecomparendo() {
      return gestionServiciosCoactivo.listarExpedientecomparendo();
  }
  
  @WebMethod
  public int contarBusquedaExpedientecomparendo(Expedientecomparendo obj) {
        return gestionServiciosCoactivo.contarBusquedaExpedientecomparendo(obj);
  }
  
  @WebMethod
  public boolean eliminarExpedientecomparendo(Expedientecomparendo obj) {
        return gestionServiciosCoactivo.eliminarExpedientecomparendo(obj);
  }
  //*************************** FIN Expedientecomparendo *******************************************
  //****************************************************************************************    
  
  

  
  //*************************** INICIO Instituciones *******************************************
  //****************************************************************************************
  @WebMethod
    public Instituciones crearInstituciones( Instituciones obj ) {
          return gestionServiciosCoactivo.crearInstituciones(obj); 
    }
    
    @WebMethod
    public boolean editarInstituciones(Instituciones obj) {
          return gestionServiciosCoactivo.editarInstituciones(obj);
    }
    
    @WebMethod
    public Instituciones buscarPrimeroInstituciones(Instituciones obj) {
          return gestionServiciosCoactivo.buscarPrimeroInstituciones(obj);
    }
    
    @WebMethod
    public List buscarInstituciones(Instituciones obj) {
          return gestionServiciosCoactivo.buscarInstituciones(obj);
    }
    
    @WebMethod
    public List listarInstituciones() {
        return gestionServiciosCoactivo.listarInstituciones();
    }
    
    @WebMethod
    public int contarBusquedaInstituciones(Instituciones obj) {
          return gestionServiciosCoactivo.contarBusquedaInstituciones(obj);
    }
    
    @WebMethod
    public boolean eliminarInstituciones(Instituciones obj) {
          return gestionServiciosCoactivo.eliminarInstituciones(obj);
    }
  
  //*************************** FIN Instituciones *******************************************
  //****************************************************************************************
    
  
  
  //*************************** INICIO Tipodoccobro *******************************************
  //****************************************************************************************    
  @WebMethod
    public Tipodoccobro crearTipodoccobro(Tipodoccobro obj ) {
          return gestionServiciosCoactivo.crearTipodoccobro(obj); 
    }
    
    @WebMethod
    public boolean editarTipodoccobro(Tipodoccobro obj) {
          return gestionServiciosCoactivo.editarTipodoccobro(obj);
    }
    
    @WebMethod
    public Tipodoccobro buscarPrimeroTipodoccobro(Tipodoccobro obj) {
          return gestionServiciosCoactivo.buscarPrimeroTipodoccobro(obj);
    }
    
    @WebMethod
    public List buscarTipodoccobro(Tipodoccobro obj) {
          return gestionServiciosCoactivo.buscarTipodoccobro(obj);
    }
    
    @WebMethod
    public List listarTipodoccobro() {
        return gestionServiciosCoactivo.listarTipodoccobro();
    }
    
    @WebMethod
    public int contarBusquedaTipodoccobro(Tipodoccobro obj) {
          return gestionServiciosCoactivo.contarBusquedaTipodoccobro(obj);
    }
    
    @WebMethod
    public boolean eliminarTipodoccobro(Tipodoccobro obj) {
          return gestionServiciosCoactivo.eliminarTipodoccobro(obj);
    }
  //*************************** FIN  Tipodoccobro *******************************************
  //****************************************************************************************
    
  //NUEVO METODO EDWIN
  @WebMethod
  public String consultarAlertas() {
        return gestionServiciosCoactivo.consultarAlertas();
  }
    
}
