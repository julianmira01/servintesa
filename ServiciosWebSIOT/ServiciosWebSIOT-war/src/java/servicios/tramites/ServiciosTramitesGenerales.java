package servicios.tramites;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import modelo.datos.objetos.tramites.AnotacionTransfor;
import modelo.datos.objetos.tramites.Runtactaimportacion;
import modelo.datos.objetos.tramites.TipoRepotenciacion;
import modelo.datos.objetos.tramites.TipoTransformacion;
import modelo.datos.objetos.tramites.VehiculoActaImportacion;

import modelo.logica.tramites.GestionServiciosTramitesGeneralesLocal;

@WebService
public class ServiciosTramitesGenerales {
    GestionServiciosTramitesGeneralesLocal gestionSertviciosTramitesGeneralesLocal;
    

    public ServiciosTramitesGenerales() {
        super();
    }

    @WebMethod
    public List getActasImportacion(){
      gestionSertviciosTramitesGeneralesLocal = new GestionServiciosTramitesGeneralesLocal();
      return gestionSertviciosTramitesGeneralesLocal.getActasImportacion();
  }

    @WebMethod
    public List searchActasImportacion(Runtactaimportacion actaImportacion){
      gestionSertviciosTramitesGeneralesLocal = new GestionServiciosTramitesGeneralesLocal();
      return gestionSertviciosTramitesGeneralesLocal.searchActasImportacion(actaImportacion);
  }

    @WebMethod
    public VehiculoActaImportacion searchVehiculoImportacion(int id_vehiculo){
      gestionSertviciosTramitesGeneralesLocal = new GestionServiciosTramitesGeneralesLocal();
      return gestionSertviciosTramitesGeneralesLocal.searchVevhiculoImportacion(id_vehiculo);
    }
    
    @WebMethod
    public boolean crearActaImportacion(Runtactaimportacion actaImportacion, VehiculoActaImportacion vehiculoImportacion){
      gestionSertviciosTramitesGeneralesLocal = new GestionServiciosTramitesGeneralesLocal();
      return gestionSertviciosTramitesGeneralesLocal.crearActaaImportacion(actaImportacion, vehiculoImportacion);
  }

    @WebMethod
    public boolean actualizarActaImportacion(Runtactaimportacion actaImportacion, VehiculoActaImportacion vehiculoImp){
      gestionSertviciosTramitesGeneralesLocal = new GestionServiciosTramitesGeneralesLocal();
      return gestionSertviciosTramitesGeneralesLocal.actualizarActaImportacion(actaImportacion, vehiculoImp);
  }

    @WebMethod
    public boolean eliminarActaImportacion(Runtactaimportacion actaImportacion, VehiculoActaImportacion vehiculoImp){
      gestionSertviciosTramitesGeneralesLocal = new GestionServiciosTramitesGeneralesLocal();
      return gestionSertviciosTramitesGeneralesLocal.eliminarActaImportacion(actaImportacion, vehiculoImp);
  }
    
    @WebMethod
    public boolean actualizarEstadoActa(int idacta, String estadoActa, int idvehi, String estadoVehi){
      gestionSertviciosTramitesGeneralesLocal = new GestionServiciosTramitesGeneralesLocal();
      return gestionSertviciosTramitesGeneralesLocal.actualizarEstadoActa(idacta, estadoActa, idvehi, estadoVehi);
    }
    
    @WebMethod
    public List buscarTipoTransformacion(TipoTransformacion myTipoTrans){
      gestionSertviciosTramitesGeneralesLocal = new GestionServiciosTramitesGeneralesLocal();
      return gestionSertviciosTramitesGeneralesLocal.getTipoTransformacion(myTipoTrans);
    }
    
    @WebMethod
    public List listarTipoTransformacion(){
      gestionSertviciosTramitesGeneralesLocal = new GestionServiciosTramitesGeneralesLocal();
      return gestionSertviciosTramitesGeneralesLocal.getTipoTransformacion();
    }
       
    @WebMethod
    public List buscarTipoRepotenciacion(TipoRepotenciacion myTipoRepot){
      gestionSertviciosTramitesGeneralesLocal = new GestionServiciosTramitesGeneralesLocal();
      return gestionSertviciosTramitesGeneralesLocal.getTipoRepotenciacion(myTipoRepot);
    }
    
    @WebMethod
    public List listarTipoRepotenciacion(){
      gestionSertviciosTramitesGeneralesLocal = new GestionServiciosTramitesGeneralesLocal();
      return gestionSertviciosTramitesGeneralesLocal.getTipoRepotenciacion();
    } 
    
    @WebMethod
    public List buscarAnotacionTransfor(AnotacionTransfor myAnotacion){
      gestionSertviciosTramitesGeneralesLocal = new GestionServiciosTramitesGeneralesLocal();
      return gestionSertviciosTramitesGeneralesLocal.getAnotacionTransfor(myAnotacion);
    }
    
    @WebMethod
    public List listarAnotacionTransfor(){
      gestionSertviciosTramitesGeneralesLocal = new GestionServiciosTramitesGeneralesLocal();
      return gestionSertviciosTramitesGeneralesLocal.getAnotacionTransfor();
    } 
}
