package servicios.tramites;

import java.util.List;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import modelo.datos.objetos.generales.EmpresaDeServicio;
import modelo.datos.objetos.generales.RuntDuplicadoPlaca;
import modelo.datos.objetos.generales.RuntRegrabacionVehiculo;
import modelo.datos.objetos.generales.RuntTipoEntrega;
import modelo.datos.objetos.generales.TramiteBasico;
import modelo.datos.objetos.generales.vehiculo.Vehiculo;
import modelo.datos.objetos.generales.vehiculo.ViewVehiculo;
import modelo.datos.objetos.generales.vistas.ViewPropietarioEmpresa;
import modelo.datos.objetos.generales.vistas.ViewPropietarioPersona;
import modelo.datos.objetos.generales.vistas.ViewTramitesVehiculo;
import modelo.datos.objetos.generales.vistas.ViewVehiculoRUNT;
import modelo.datos.objetos.medidasCautelares.J_Pendiente;
import modelo.datos.objetos.tramites.Cabrequisitobase;
import modelo.datos.objetos.tramites.CambioColor;
import modelo.datos.objetos.tramites.CambioServicio;
import modelo.datos.objetos.tramites.CambioTipoPlacas;
import modelo.datos.objetos.tramites.CancelacionMatricula;
import modelo.datos.objetos.tramites.Detrequisitobase;
import modelo.datos.objetos.tramites.Reqxtramite;
import modelo.datos.objetos.tramites.RuntCambioMotor;
import modelo.datos.objetos.tramites.RuntEntidadReporta;
import modelo.datos.objetos.tramites.RuntRematricula;
import modelo.datos.objetos.tramites.RuntTraspasoVehiculo;
import modelo.datos.objetos.tramites.Solicitud;
import modelo.datos.objetos.tramites.Subtipotramite;
import modelo.datos.objetos.tramites.TipoTraspaso;
import modelo.datos.objetos.tramites.TramiteRadicadoCuenta;
import modelo.datos.objetos.tramites.Tramiteinterno;
import modelo.datos.objetos.tramites.TransformacionVehiculo;
import modelo.datos.objetos.tramites.Traspaso;
import modelo.datos.objetos.tramites.TraspasoIndeterminado;

import modelo.logica.generales.GestionServiciosEmpresaDeServicios;
import modelo.logica.tramites.GestionServiciosCertificadoTradicion;
import modelo.logica.tramites.GestionServiciosTramitesRNA;


@WebService
public class ServiciosTramitesRNA {
    GestionServiciosTramitesRNA gestionServiciosTramitesRNA;
    GestionServiciosCertificadoTradicion gestionServiciosCertificadoTradicion;
    GestionServiciosEmpresaDeServicios gestionServiciosEmpresaDeServicios;
    
    public ServiciosTramitesRNA() {
        super();
        crearObjetos();
    }

    @Oneway
    @WebMethod
    public void crearObjetos(){
    gestionServiciosTramitesRNA=new GestionServiciosTramitesRNA(); 
    gestionServiciosCertificadoTradicion = new GestionServiciosCertificadoTradicion();
    gestionServiciosEmpresaDeServicios = new GestionServiciosEmpresaDeServicios();
  }


    @WebMethod
    public boolean actualizarNuevoColorVehiculo(TramiteBasico tramiteBasico,CambioColor cambioColor){
    return gestionServiciosTramitesRNA.actualizarNuevoColorVehiculo(tramiteBasico, cambioColor);
  }
    
      @WebMethod
      public boolean actualizarColorVehiculo(Vehiculo myVehi){
      return gestionServiciosTramitesRNA.actualizarNuevoColorVehiculo(myVehi);
      }

    @WebMethod
    public boolean actualizarNuevoServicioVehiculo(TramiteBasico tramiteBasico,CambioServicio cambioServicio){
    return gestionServiciosTramitesRNA.actualizarNuevoServicioVehiculo(tramiteBasico, cambioServicio);
  }

    @WebMethod
    public boolean actualizarNuevoTipoPlacasVehiculo(TramiteBasico tramiteBasico,CambioTipoPlacas cambioTipoPlacas){
    return gestionServiciosTramitesRNA.actualizarNuevoTipoPlacaVehiculo(tramiteBasico, cambioTipoPlacas);
  }

    @WebMethod
    public boolean crearTramiteInterno(Tramiteinterno tinterno){
      return gestionServiciosTramitesRNA.crearTramiteInterno(tinterno);
    }

    @WebMethod
    public boolean eliminarTramiteInterno(Tramiteinterno tinterno){
      return gestionServiciosTramitesRNA.eliminarTramiteInterno(tinterno);
    }

    @WebMethod
    public boolean actualizarTramiteInterno(Tramiteinterno tinterno){
      return gestionServiciosTramitesRNA.actualizarTramiteInterno(tinterno);
    }

    @WebMethod
    public List getTramitesInternos(Tramiteinterno tinterno){
      return gestionServiciosTramitesRNA.getTramitesInternos(tinterno);
    }

    @WebMethod
    public List listaTramitesInternos(){
      return gestionServiciosTramitesRNA.listaTramitesInternos();
    }

    @WebMethod
    public boolean cancelarMatriculaVehiculo(String resolucionCancelacion, String recuperaMotor,  TramiteBasico tramiteBasico,CancelacionMatricula cancelarMatricula,int idUsuario,String myIp,String myHost){
      return gestionServiciosTramitesRNA.cancelacionMatriculaVehiculo(resolucionCancelacion, recuperaMotor, tramiteBasico, cancelarMatricula,idUsuario,myIp,myHost);
    }

    @WebMethod
    public boolean crearSubTramite(Subtipotramite subtramite){
      return gestionServiciosTramitesRNA.crearSubTramite(subtramite);
    }

    @WebMethod
    public boolean eliminarSubTramite(Subtipotramite subtramite){
      return gestionServiciosTramitesRNA.eliminarSubTramite(subtramite);
    }

    @WebMethod
    public boolean actualizarSubTramite(Subtipotramite subtramite){
      return gestionServiciosTramitesRNA.actualizarSubTramite(subtramite);
    }

    @WebMethod
    public List getSubtramite(Subtipotramite subtramite){
      return gestionServiciosTramitesRNA.getSubTramite(subtramite);
    }

    @WebMethod
    public Subtipotramite getSubTramiteporID(Subtipotramite subtramite){
      return gestionServiciosTramitesRNA.getSubTramiteporID(subtramite);
    }

    @WebMethod
    public boolean crearRequisitoxtramite(Reqxtramite requisitoxtramite){
      return gestionServiciosTramitesRNA.crearRequisitoXtramite(requisitoxtramite);
    }

    @WebMethod
    public boolean eliminarRequisitoxtramite(Reqxtramite requisitoxtramite){
      return gestionServiciosTramitesRNA.eliminarRequisitoXtramite(requisitoxtramite);
    }

    @WebMethod
    public boolean actualizarRequisitoxtramite(Reqxtramite requisitoxtramite){
        return gestionServiciosTramitesRNA.actualizarRequisitoXtramite(requisitoxtramite);
    }

    @WebMethod
    public boolean crearCabRequisito(Cabrequisitobase cabrequisito){
      return gestionServiciosTramitesRNA.crearCabRequisitoBase(cabrequisito);
    }

    @WebMethod
    public boolean eliminarCabRequisito(Cabrequisitobase cabrequisito){
      return gestionServiciosTramitesRNA.eliminarCabRequisitoBase(cabrequisito);
    }

    @WebMethod
    public boolean actualizarCabrequisito(Cabrequisitobase cabrequisito){
      return gestionServiciosTramitesRNA.actualizarCabRequisitoBase(cabrequisito);
    }

    @WebMethod
    public List getCabrequisito(){
      return gestionServiciosTramitesRNA.getCabRequisitoBase();
    }

    @WebMethod
    public Cabrequisitobase getCabrequisitoporID(Cabrequisitobase cabrequisito){
      return gestionServiciosTramitesRNA.getCabRequisitoBaseporID(cabrequisito);
    }

    @WebMethod
    public boolean crearDetRequisito(Detrequisitobase detrequisito){
      return gestionServiciosTramitesRNA.crearDetRequisitoBase(detrequisito);
    }

    @WebMethod
    public boolean eliminarDetRequisito(Detrequisitobase detrequisito){
      return gestionServiciosTramitesRNA.eliminarDetRequisitoBase(detrequisito);
    }

    @WebMethod
    public boolean actualizarDetrequisito(Detrequisitobase detrequisito){
      return gestionServiciosTramitesRNA.actualizarDetRequisitoBase(detrequisito);
    }

    @WebMethod
    public List getDetrequisito(Detrequisitobase detrequisito){
      return gestionServiciosTramitesRNA.getDetRequisitoBase(detrequisito);
    }

    @WebMethod
    public Detrequisitobase getDetrequisitoporID(Detrequisitobase detrequisito){
      return gestionServiciosTramitesRNA.getDetRequisitoBaseporID(detrequisito);
    }

    @WebMethod
    public boolean crearRuntDuplicadoPlaca(TramiteBasico tramiteBasico, RuntDuplicadoPlaca runtDuplicadoPlaca){
      return gestionServiciosTramitesRNA.crearRuntDuplicadoPlacas(tramiteBasico, runtDuplicadoPlaca);
    }

    @WebMethod
    public boolean deshabilitarDuplicadosAnteriores(RuntDuplicadoPlaca runtDuplicadoPlaca){
      return gestionServiciosTramitesRNA.deshabilitarDuplicadosAnteriores(runtDuplicadoPlaca);
    }

    @WebMethod
    public boolean getRegrabacionVehiculo(RuntRegrabacionVehiculo runtRegrabacionVehiculo, TramiteBasico tramiteBasico){
      return gestionServiciosTramitesRNA.getRegrabacionVehiculo(runtRegrabacionVehiculo, tramiteBasico);
    }
    
    @WebMethod
    public List getRequisitosXTramite(Reqxtramite reqtramite){
      return gestionServiciosTramitesRNA.getRequisitosXTramite(reqtramite);
    }
    
    @WebMethod
    public boolean setRuntCambioMotor(TramiteBasico tramiteBasico, RuntCambioMotor runtCambioMotor){
      return gestionServiciosTramitesRNA.crearCambioMotor(tramiteBasico, runtCambioMotor);
    }
    
    @WebMethod
    public boolean desactivarRuntCambioMotor(RuntCambioMotor runtCambioMotor){
      return gestionServiciosTramitesRNA.desactivarRuntCambioMotor(runtCambioMotor);
    }

    @WebMethod
    public boolean searchCambioMotor(RuntCambioMotor runtCambioMotor){
      return gestionServiciosTramitesRNA.searchCambioMotor(runtCambioMotor);
    }
    
    @WebMethod
    public List getTTipoTraspaso(TipoTraspaso tipotraspaso)
    {
      return gestionServiciosTramitesRNA.getTTipoTraspaso(tipotraspaso);
    }
    
    @WebMethod
    public List listarTramiteInicial(){
      return gestionServiciosTramitesRNA.listarTramiteInicial();
    }
    
    @WebMethod
            public List listarTramiteInicialRemolquesSemiremolques(){
              return gestionServiciosTramitesRNA.listarTramiteInicialRemolquesSemiremolques();
            }

      @WebMethod
              public List listarTramiteInicialMaquinaria(){
                return gestionServiciosTramitesRNA.listarTramiteInicialMaquinaria();
              }

    
    @WebMethod
    public boolean auditarCertificadoTradicion(TramiteBasico tramiteBasico, int idUsuario, String myIp, String myHost){
      return gestionServiciosCertificadoTradicion.auditarCertificadoTradicion(tramiteBasico, idUsuario, myIp, myHost);
    }     
    
    @WebMethod
    public ViewVehiculo getInfoVehiculo(TramiteBasico tramiteBasico){
      return gestionServiciosCertificadoTradicion.getInfoVehiculo(tramiteBasico);
    }     
    
    @WebMethod
    public boolean getJ_Pendiente(J_Pendiente jPendiente){
        return true;
    }
    
    @WebMethod
    public List getMedidasCautelares(ViewVehiculo viewVehiculo){
        return gestionServiciosCertificadoTradicion.getMedidasCautelares(viewVehiculo);
    }
    
    @WebMethod
    public boolean getViewPropietarioEmpresa(ViewPropietarioEmpresa viewPropietarioEmpresa){
        return true;
    }
    
    @WebMethod
    public List getPropietariosVehiculosEmpresas(ViewVehiculo viewVehiculo){
        return gestionServiciosCertificadoTradicion.getPropietariosVehiculosEmpresas(viewVehiculo);
    }
    
    @WebMethod
    public boolean getViewPropietarioPersona(ViewPropietarioPersona viewPropietarioPersona){
        return true;
    }
    
    @WebMethod
    public List getPropietariosVehiculosPersonas(ViewVehiculo viewVehiculo){
        return gestionServiciosCertificadoTradicion.getPropietariosVehiculosPersonas(viewVehiculo);
    }
    
    @WebMethod
    public List getViewTramitesVehiculo(ViewTramitesVehiculo viewTramitesVehiculo){
        return gestionServiciosCertificadoTradicion.getViewTramitesVehiculo(viewTramitesVehiculo);
    }
    
    @WebMethod
    public List getTramitesVehiculo(ViewVehiculo viewVehiculo){
        return gestionServiciosCertificadoTradicion.getTramitesVehiculo(viewVehiculo);
    }
    
      /*@WebMethod
      public boolean getEmpresaDeServicio(EmpresaDeServicio empresaDeServicio){
          return true;
      }*/
      
    @WebMethod
    public EmpresaDeServicio getEmpresaDeServicio(EmpresaDeServicio empresaDeServicio){
        return gestionServiciosEmpresaDeServicios.getEmpresaDeServicio(empresaDeServicio);
    }
    
    @WebMethod
    public List ListarRuntEntidadReporta(){
        return gestionServiciosTramitesRNA.getRuntEntidadReporta();
    }
    
    @WebMethod
    public List buscarRuntEntidadReporta(RuntEntidadReporta myRuntEntRep){
        return gestionServiciosTramitesRNA.getRuntEntidadReporta(myRuntEntRep);
    }
    
    @WebMethod
    public List ListarRuntTipoEntrega(){
        return gestionServiciosTramitesRNA.getRuntTipoEntrega();
    }
      
    @WebMethod
    public List buscarRuntTipoEntrega(RuntTipoEntrega myRuntTipoEntr){
        return gestionServiciosTramitesRNA.getRuntTipoEntrega(myRuntTipoEntr);
    }
          
    @WebMethod
    public RuntRematricula crearRuntRematricula(TramiteBasico tramiteBasico, RuntRematricula myRuntRematricula){
        return gestionServiciosTramitesRNA.crearRuntRematricula(tramiteBasico, myRuntRematricula);
    }
    
    @WebMethod
    public TransformacionVehiculo crearTransformacionVehiculo(TramiteBasico tramiteBasico,TransformacionVehiculo myTransfVehiculo){
        return gestionServiciosTramitesRNA.crearTransformacionVehiculo(tramiteBasico,myTransfVehiculo);
    }
    
    @WebMethod
    public List buscarTransformacionVehiculo(TransformacionVehiculo myTransfVehiculo){
        return gestionServiciosTramitesRNA.getTransformacionVehiculo(myTransfVehiculo);
    }
    
    @WebMethod
    public RuntTraspasoVehiculo crearTraspasoVehiculo(TramiteBasico tramiteBasico, RuntTraspasoVehiculo myTraspVehiculo,Traspaso traspaso){
        return gestionServiciosTramitesRNA.crearTraspasoVehiculo(tramiteBasico,myTraspVehiculo, traspaso);
    }
    
      @WebMethod
      public RuntTraspasoVehiculo crearTraspasoVehiculoIndeterminado(TramiteBasico tramiteBasico, RuntTraspasoVehiculo myTraspVehiculo,TraspasoIndeterminado traspasoIndet){
          return gestionServiciosTramitesRNA.crearTraspasoVehiculoIndeterminado(tramiteBasico,myTraspVehiculo, traspasoIndet);
      }
    
    @WebMethod
    public List buscarTraspasosVehiculo(RuntTraspasoVehiculo myTraspVehiculo){
        return gestionServiciosTramitesRNA.getTraspasosVehiculo(myTraspVehiculo);
    }
    
    @WebMethod
    public RuntTraspasoVehiculo desactivarTraspasoVehiculo(RuntTraspasoVehiculo myTraspVehiculo){
        return gestionServiciosTramitesRNA.desactivarTraspasoVehiculo(myTraspVehiculo);
      }  
  }
