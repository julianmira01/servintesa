package servicios.generales;


import java.util.List;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import modelo.datos.objetos.generales.Header;
import modelo.datos.objetos.generales.RuntCombustibleModificado;
import modelo.datos.objetos.generales.RuntMedidaCautelarModificada;
import modelo.datos.objetos.generales.RuntModificarAutomotor;
import modelo.datos.objetos.generales.RuntPrendaModificada;
import modelo.datos.objetos.generales.RuntPropietarioModificado;
import modelo.datos.objetos.generales.RuntRTMModificada;
import modelo.datos.objetos.generales.RuntSoatModificado;
import modelo.datos.objetos.generales.VehiculoRadicadoCta;
import modelo.datos.objetos.generales.vehiculo.RuntVehiculoModificado;
import modelo.datos.objetos.generales.Auditoriatramite;

import modelo.logica.generales.GestionAuditoriaTramite;
import modelo.logica.generales.GestionBiometricos;
import modelo.logica.generales.GestionServiciosGeneralesLocal;


@WebService
public class ServiciosGenerales {
    GestionServiciosGeneralesLocal gestionServiciosGeneralesLocal;
    GestionBiometricos gestionBimetricos;
    GestionAuditoriaTramite gestionauditoriatramite;
    
    
    public ServiciosGenerales() {
        super();
        crearObjetos();
    }

    @Oneway
    @WebMethod
    public void crearObjetos(){
        gestionServiciosGeneralesLocal=new GestionServiciosGeneralesLocal(); 
        gestionBimetricos=new GestionBiometricos(); 
        gestionauditoriatramite = new GestionAuditoriaTramite();
    }

    @WebMethod
    public RuntVehiculoModificado consultaVehiculoModificado(RuntVehiculoModificado vehiculoModificado)throws Exception{
      try{ return gestionServiciosGeneralesLocal.existeVehiculoModificado(vehiculoModificado);}catch(Exception e){throw new Exception(e.getMessage());} 
    }

    @WebMethod
    public boolean eliminarVehiculoConsultado(int idv, int idm)throws Exception{
      try{ return gestionServiciosGeneralesLocal.eliminarVehiculoConsultado(idv, idm);}catch(Exception e){throw new Exception(e.getMessage());} 
    }
    
    @WebMethod
    public RuntModificarAutomotor consultarModificacion(RuntModificarAutomotor modificarAutomotor)throws Exception{
        try{ return gestionServiciosGeneralesLocal.consultarModificacion(modificarAutomotor);}catch(Exception e){throw new Exception(e.getMessage());} 
    }

    @WebMethod
    public RuntVehiculoModificado getVehiculoModificado(RuntVehiculoModificado vehiculoModificado)throws Exception{
      try{ return gestionServiciosGeneralesLocal.getVehiculoModificado(vehiculoModificado);}catch(Exception e){throw new Exception(e.getMessage());} 
    }

    @WebMethod
    public boolean crearCombustibleModificado(RuntCombustibleModificado combustibleModificado)throws Exception{
      try{ return gestionServiciosGeneralesLocal.crearCombustibleModificado(combustibleModificado);}catch(Exception e){throw new Exception(e.getMessage());} 
    }

    @WebMethod
    public boolean actualizarCombustibleModificado(RuntCombustibleModificado combustibleModificado)throws Exception{
      try{ return gestionServiciosGeneralesLocal.actualizarCombustibleModificado(combustibleModificado);}catch(Exception e){throw new Exception(e.getMessage());} 
    }

    @WebMethod
    public boolean eliminarCombustibleModificado(RuntCombustibleModificado combustibleModificado)throws Exception{
      try{ return gestionServiciosGeneralesLocal.eliminarCombustibleModificado(combustibleModificado);}catch(Exception e){throw new Exception(e.getMessage());} 
    }

    @WebMethod
    public List getCombustiblesModificado(RuntCombustibleModificado combustibleModificado)throws Exception{
      try{ return gestionServiciosGeneralesLocal.getCombustiblesModificado(combustibleModificado);}catch(Exception e){throw new Exception(e.getMessage());} 
    }

    @WebMethod
    public boolean crearPropietarioModificado(RuntPropietarioModificado propietarioModificado)throws Exception{
      try{ return gestionServiciosGeneralesLocal.crearPropietarioModificado(propietarioModificado);}catch(Exception e){throw new Exception(e.getMessage());} 
    }

    @WebMethod
    public boolean actualizarPropietarioModificado(RuntPropietarioModificado propietarioModificado)throws Exception{
      try{ return gestionServiciosGeneralesLocal.actualizarPropietarioModificado(propietarioModificado);}catch(Exception e){throw new Exception(e.getMessage());} 
    }

    @WebMethod
    public boolean eliminarPropietarioModificado(RuntPropietarioModificado propietarioModificado)throws Exception{
      try{ return gestionServiciosGeneralesLocal.eliminarPropietarioModificado(propietarioModificado);}catch(Exception e){throw new Exception(e.getMessage());} 
    }

    @WebMethod
    public List getPropietariosModificado(RuntPropietarioModificado propietarioModificado)throws Exception{
      try{ return gestionServiciosGeneralesLocal.getPropietariosModificado(propietarioModificado);}catch(Exception e){throw new Exception(e.getMessage());} 
    }

    @WebMethod
    public boolean crearPrendaModificada(RuntPrendaModificada prendaModificada)throws Exception{
      try{ return gestionServiciosGeneralesLocal.crearPrendaModificada(prendaModificada);}catch(Exception e){throw new Exception(e.getMessage());} 
    }

    @WebMethod
    public boolean actualizarPrendaModificada(RuntPrendaModificada prendaModificada)throws Exception{
      try{ return gestionServiciosGeneralesLocal.actualizarPrendaModificada(prendaModificada);}catch(Exception e){throw new Exception(e.getMessage());} 
    }

    @WebMethod
    public boolean eliminarPrendaModificada(RuntPrendaModificada prendaModificada)throws Exception{
      try{ return gestionServiciosGeneralesLocal.eliminarPrendaModificada(prendaModificada);}catch(Exception e){throw new Exception(e.getMessage());} 
    }

    @WebMethod
    public List getPrendaModificada(RuntPrendaModificada prendaModificada)throws Exception{
      try{ return gestionServiciosGeneralesLocal.getPrendaModificada(prendaModificada);}catch(Exception e){throw new Exception(e.getMessage());} 
    }

    @WebMethod
    public boolean crearMedidaCautelarModificada(RuntMedidaCautelarModificada medidaCautelarModificada)throws Exception{
      try{ return gestionServiciosGeneralesLocal.crearMedidaCautelarModificada(medidaCautelarModificada);}catch(Exception e){throw new Exception(e.getMessage());} 
    }

    @WebMethod
    public boolean actualizarMedidaCautelarModificada(RuntMedidaCautelarModificada medidaCautelarModificada)throws Exception{
      try{ return gestionServiciosGeneralesLocal.actualizarMedidaCautelarModificada(medidaCautelarModificada);}catch(Exception e){throw new Exception(e.getMessage());} 
    }

    @WebMethod
    public boolean eliminarMedidaCautelarModificada(RuntMedidaCautelarModificada medidaCautelarModificada)throws Exception{
      try{ return gestionServiciosGeneralesLocal.eliminarMedidaCautelarModificada(medidaCautelarModificada);}catch(Exception e){throw new Exception(e.getMessage());} 
    }

    @WebMethod
    public List getMedidasCautelaresModificada(RuntMedidaCautelarModificada medidaCautelarModificada)throws Exception{
      try{ return gestionServiciosGeneralesLocal.getMedidasCautelaresModificada(medidaCautelarModificada);}catch(Exception e){throw new Exception(e.getMessage());} 
    }

    @WebMethod
    public boolean crearSoatModificado(RuntSoatModificado soatModificado)throws Exception{
      try{ return gestionServiciosGeneralesLocal.crearSoatModificado(soatModificado);}catch(Exception e){throw new Exception(e.getMessage());} 
    }

    @WebMethod
    public boolean actualizarSoatModificado(RuntSoatModificado soatModificado)throws Exception{
      try{ return gestionServiciosGeneralesLocal.actualizarSoatModificado(soatModificado);}catch(Exception e){throw new Exception(e.getMessage());} 
    }

    @WebMethod
    public boolean eliminarSoatModificado(RuntSoatModificado soatModificado)throws Exception{
      try{ return gestionServiciosGeneralesLocal.eliminarSoatModificado(soatModificado);}catch(Exception e){throw new Exception(e.getMessage());} 
    }

    @WebMethod
    public List getSoatModificado(RuntSoatModificado soatModificado)throws Exception{
      try{ return gestionServiciosGeneralesLocal.getSoatModificado(soatModificado);}catch(Exception e){throw new Exception(e.getMessage());} 
    }

    @WebMethod
    public boolean crearRTMModificada(RuntRTMModificada rtmModificada)throws Exception{
      try{ return gestionServiciosGeneralesLocal.crearRTMModificada(rtmModificada);}catch(Exception e){throw new Exception(e.getMessage());} 
    }

    @WebMethod
    public boolean actualizarRTMModificada(RuntRTMModificada rtmModificada)throws Exception{
      try{ return gestionServiciosGeneralesLocal.actualizarRTMModificada(rtmModificada);}catch(Exception e){throw new Exception(e.getMessage());} 
    }

    @WebMethod
    public boolean eliminarRTMModificada(RuntRTMModificada rtmModificada)throws Exception{
      try{ return gestionServiciosGeneralesLocal.eliminarRTMModificada(rtmModificada);}catch(Exception e){throw new Exception(e.getMessage());} 
    }

    @WebMethod
    public List getRTMModificada(RuntRTMModificada rtmModificada)throws Exception{
      try{ return gestionServiciosGeneralesLocal.getRTMModificada(rtmModificada);}catch(Exception e){throw new Exception(e.getMessage());} 
    }

    
    @WebMethod
    public String getFechaServidor()throws Exception{
        try{ return gestionServiciosGeneralesLocal.getFechaServidor();}catch(Exception e){throw new Exception(e.getMessage());} 
    }
    
    @WebMethod
    public String getFechaHoraServidor()throws Exception{
        try{ return gestionServiciosGeneralesLocal.getFechaHoraServidor();}catch(Exception e){throw new Exception(e.getMessage());} 
    }
    
    @WebMethod
    public VehiculoRadicadoCta crearRadicadoCuentaVehiculo(VehiculoRadicadoCta myVehiRadCta) throws Exception {
        try{ return gestionServiciosGeneralesLocal.crearRadicadoCuentaVehiculo(myVehiRadCta);}catch(Exception e){throw new Exception(e.getMessage());} 
    }
    
    @WebMethod
    public VehiculoRadicadoCta getRadicadoCuentaVehiculo(VehiculoRadicadoCta myVehiRadiCta) throws Exception {
        try{ return gestionServiciosGeneralesLocal.getRadicadoCuentaVehiculo(myVehiRadiCta);}catch(Exception e){throw new Exception(e.getMessage());} 
    }
    
    @WebMethod
    public boolean actualizarRadicadoCuentaVehiculo(VehiculoRadicadoCta myVehiRadiCta) throws Exception {
        try{ return gestionServiciosGeneralesLocal.actualizarRadicadoCuentaVehiculo(myVehiRadiCta);}catch(Exception e){throw new Exception(e.getMessage());}     
    }
       
    
    @WebMethod
    public List consultarAuditoriaTramite(Auditoriatramite myauditoriatramite) throws Exception {
        try{ return gestionauditoriatramite.buscarAuditoriatramite(myauditoriatramite);}catch(Exception e){throw new Exception(e.getMessage());} 
    }
    
    @WebMethod
    public List consultarAuditoriaTramiteView(Auditoriatramite myauditoriatramite) throws Exception {
        try{ return gestionauditoriatramite.buscarAuditoriatramiteView(myauditoriatramite);}catch(Exception e){throw new Exception(e.getMessage());} 
    }
    
    @WebMethod
    public List consultarAuditoriaTramiteWebView(Auditoriatramite myauditoriatramite) throws Exception {
        try{ return gestionauditoriatramite.buscarAuditoriatramiteWebView(myauditoriatramite);}catch(Exception e){throw new Exception(e.getMessage());} 
    }
}
