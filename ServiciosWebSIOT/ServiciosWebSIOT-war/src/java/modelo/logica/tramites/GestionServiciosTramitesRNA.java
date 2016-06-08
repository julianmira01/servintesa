package modelo.logica.tramites;

import java.io.File;

import java.sql.Connection;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.jws.WebParam;

import modelo.conexion.Conexion;

import modelo.datos.dao.generales.RuntDuplicadoPlacaDao;
import modelo.datos.dao.generales.RuntRegrabacionVehiculoDao;
import modelo.datos.dao.generales.RuntTipoEntregaDao;
import modelo.datos.dao.generales.vehiculo.VehiculoDao;
import modelo.datos.dao.generales.vistas.ViewVehiculoRUNTDao;
import modelo.datos.dao.tramites.CabrequisitobaseDao;
import modelo.datos.dao.tramites.DetrequisitobaseDao;
import modelo.datos.dao.tramites.ReqxtramiteDao;
import modelo.datos.dao.tramites.RuntCambioMotorDao;
import modelo.datos.dao.tramites.RuntEntidadReportaDao;
import modelo.datos.dao.tramites.RuntRematriculaDao;
import modelo.datos.dao.tramites.RuntTraspasoVehiculoDao;
import modelo.datos.dao.tramites.SubtipotramiteDao;
import modelo.datos.dao.tramites.TipoTraspasoDao;
import modelo.datos.dao.tramites.TramiteinternoDao;
import modelo.datos.dao.tramites.TransformacionVehiculoDao;
import modelo.datos.objetos.accesorias.Servicio;
import modelo.datos.objetos.documentos.CertificadoTrad;
import modelo.datos.objetos.generales.AuditoriaSystem;
import modelo.datos.objetos.generales.CertificadoTradicion;
import modelo.datos.objetos.generales.RuntDuplicadoPlaca;
import modelo.datos.objetos.generales.RuntRegrabacionVehiculo;
import modelo.datos.objetos.generales.RuntTipoEntrega;
import modelo.datos.objetos.generales.TramiteBasico;
import modelo.datos.objetos.generales.Transito;
import modelo.datos.objetos.generales.vehiculo.Vehiculo;
import modelo.datos.objetos.generales.vistas.ViewVehiculoRUNT;
import modelo.datos.objetos.tramites.Cabrequisitobase;
import modelo.datos.objetos.tramites.CambioColor;
import modelo.datos.objetos.tramites.CambioServicio;
import modelo.datos.objetos.tramites.CambioTipoPlacas;
import modelo.datos.objetos.tramites.CancelacionMatricula;
import modelo.datos.objetos.tramites.Detrequisitobase;
import modelo.datos.objetos.tramites.InscripcionPrenda;
import modelo.datos.objetos.tramites.LevantarPrenda;
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

import modelo.logica.accesorias.GestionServiciosAccesoriasLocal;
import modelo.logica.generales.GestionServiciosTransitoLocal;
import modelo.logica.generales.vehiculo.GestionServiciosVehiculosLocal;

import utilidades.Auditoria;
import utilidades.Funciones;


public class GestionServiciosTramitesRNA {
    VehiculoDao vehiculoDao;
    Conexion conexion;
    Connection conn;
    String myMotor;
    
    public GestionServiciosTramitesRNA() {
        super();
        crearObjetos();
    }
    
  
  public void crearObjetos() {
      conexion = new Conexion();
      myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
     }
    public boolean actualizarNuevoColorVehiculo(Vehiculo myVehi){
          List lista = null;
          boolean resultado = true;
          int id=0;
          try {
              vehiculoDao=new VehiculoDao();
              conn = conexion.conectar();
              vehiculoDao.actualizarNuevoColorVehiculo(conn, myVehi);
              resultado = true;
              
          } catch (Exception e) {
              e.printStackTrace();
              resultado = false;

            } finally {
              conexion.cerrarCx();
          }
          return resultado;
       
    }
    
    
  public boolean actualizarNuevoColorVehiculo(TramiteBasico tramiteBasico,CambioColor cambioColor){
        boolean resultado = true;
        Vehiculo vehiculo=new Vehiculo();

        int id=0;
        try {
            conn = conexion.conectar();
            vehiculoDao=new VehiculoDao();
            vehiculo.setID_VEHICULO(Integer.parseInt(tramiteBasico.getIdVehiculo()));
            vehiculo.setID_COLOR(cambioColor.getIdNuevoColor());
            vehiculoDao.actualizarNuevoColorVehiculo(conn, vehiculo);
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            vehiculo.setID_VEHICULO(-1);
            resultado = false;

          } finally {
            conexion.cerrarCx();
        }
        return resultado;
     
  }
  
  public boolean actualizarNuevoServicioVehiculo(TramiteBasico tramiteBasico,CambioServicio cambioServicio){
        List lista = null;
        boolean resultado = true;
        Vehiculo vehiculo = new Vehiculo();
        Servicio servicio = new Servicio();
        GestionServiciosAccesoriasLocal gestionServiciosAccesoriasLocal = new GestionServiciosAccesoriasLocal();  
        int id=0;
        try {
            vehiculoDao=new VehiculoDao();
            conn = conexion.conectar(); 
            vehiculo.setID_VEHICULO(Integer.parseInt(tramiteBasico.getIdVehiculo()));
            servicio.setID_SERVICIORUNT(cambioServicio.getIdNuevoServicio());
            servicio = gestionServiciosAccesoriasLocal.getTipoServicioPorIdServicioRunt(servicio);
            vehiculo.setID_SERVICIO(String.valueOf(servicio.getID_SERVICIO()));
            conn = conexion.conectar();    
            vehiculoDao.actualizarNuevoServicioVehiculo(conn, vehiculo);
            resultado = true;     
            /*Object tmp = new Object();
            String tRunt = Funciones.leer_ini("/WSTransito.ini", "RUNT");
            if (tRunt.toUpperCase().equals("SI")) {
                            
                            GestionServiciosTramitesRNARunt gestionServiciosRNARunt = new GestionServiciosTramitesRNARunt();
                            tmp = gestionServiciosRNARunt.getTramiteCambioServicioDTO(tramiteBasico, cambioServicio);
                            Funciones.obecjtToArchivoBinario(Funciones.leer_ini("/WSTransito.ini", "BINARIO_RUNT_FALTANTES")+"\\"+tramiteBasico.getNumeroFactura()+"-"+tramiteBasico.getOrdenEjecucion()+".bin", tmp);
                        }*/
        } catch (Exception e) {
            e.printStackTrace();
            vehiculo.setID_VEHICULO(-1);
            resultado = false;

          } finally {
            conexion.cerrarCx();
        }
        return resultado;
     
  }
  
  public boolean actualizarNuevoTipoPlacaVehiculo(TramiteBasico tramiteBasico,CambioTipoPlacas cambioTipoPlaca){
        List lista = null;
        boolean resultado = true;
        Vehiculo vehiculo1=new Vehiculo();
        int id=0;
        try {
            vehiculoDao=new VehiculoDao();
            conn = conexion.conectar();
           
            vehiculo1.setID_VEHICULO(Integer.parseInt(tramiteBasico.getIdVehiculo()));
            vehiculo1.setID_TIPOPLACA(cambioTipoPlaca.getIdNuevoTipoPlacas());
            vehiculo1.setID_RUNTTIPOPLACA(cambioTipoPlaca.getIdNuevoTipoPlacas());
            vehiculoDao.actualizarNuevoTipoPlacaVehiculo(conn, vehiculo1);
            resultado = true;
            Object tmp = new Object();
        } catch (Exception e) {
            e.printStackTrace();
            vehiculo1.setID_VEHICULO(-1);
            resultado = false;

          } finally {
            conexion.cerrarCx();
        }
        return resultado;
     
  }
  
  public boolean crearTramiteInterno(Tramiteinterno tinterno){
    List lista = null;
    TramiteinternoDao tramiteInternoDao;
    boolean resultado = false;
    int id;
    try {
        tramiteInternoDao = new TramiteinternoDao();
        conn = conexion.conectar();
        id=Funciones.obtenerId(conn, "GEN_TRAMITEINTERNO", "GEN_TRAMITEINTERNO", myMotor);
        tinterno.setIDTRAM_INTERNO(id);
        tramiteInternoDao.create(conn, tinterno);
        resultado = true;
    }
    catch (Exception e){
      e.printStackTrace();
      resultado = false;
    }
    finally{
      conexion.cerrarCx();
    }
    return resultado;
  }
  
  public boolean eliminarTramiteInterno(Tramiteinterno tinterno){
    List lista = null;
    TramiteinternoDao tramiteInternoDao;
    boolean resultado = false;
    int id=0;
    try {
        tramiteInternoDao = new TramiteinternoDao();
        conn = conexion.conectar();
        tramiteInternoDao.delete(conn, tinterno);
        resultado = true;
    }
    catch (Exception e){
      e.printStackTrace();
      resultado = false;
    }
    finally{
      conexion.cerrarCx();
    }
    return resultado;
  }
  
  public List listarTramiteInicial(){
    List lista = null;
    TramiteinternoDao tramiteInternoDao;
    Tramiteinterno tinterno;
    int id=0;
    try {
        tinterno = new Tramiteinterno();
        tinterno.setT_INICIAL("T");
        tramiteInternoDao = new TramiteinternoDao();
        conn = conexion.conectar();
        lista = tramiteInternoDao.searchMatchingSinRemolques(conn, tinterno);
    }
    catch (Exception e){
      e.printStackTrace();
    }
    finally{
      conexion.cerrarCx();
    }
    return lista;
  }
  
    public List listarTramiteInicialRemolquesSemiremolques(){
          List lista = null;
          TramiteinternoDao tramiteInternoDao;
          Tramiteinterno tinterno;
          int id=0;
          try {
              tinterno = new Tramiteinterno();
              tinterno.setT_INICIAL("T");
              tinterno.setID_TIPO_TRAMITE(3);
              tramiteInternoDao = new TramiteinternoDao();
              conn = conexion.conectar();
              lista = tramiteInternoDao.searchMatching(conn, tinterno);
          }
          catch (Exception e){
            e.printStackTrace();
          }
          finally{
            conexion.cerrarCx();
          }
          return lista;
        }
    
    
    public List listarTramiteInicialMaquinaria(){
          List lista = null;
          TramiteinternoDao tramiteInternoDao;
          Tramiteinterno tinterno;
          int id=0;
          try {
              tinterno = new Tramiteinterno();
              tinterno.setT_INICIAL("T");
              tinterno.setID_TIPO_TRAMITE(4);
              tramiteInternoDao = new TramiteinternoDao();
              conn = conexion.conectar();
              lista = tramiteInternoDao.searchMatching(conn, tinterno);
          }
          catch (Exception e){
            e.printStackTrace();
          }
          finally{
            conexion.cerrarCx();
          }
          return lista;
        }

  
  public boolean actualizarTramiteInterno(Tramiteinterno tinterno){
    List lista = null;
    TramiteinternoDao tramiteInternoDao;
    boolean resultado = false;
    int id=0;
    try {
        tramiteInternoDao = new TramiteinternoDao();
        conn = conexion.conectar();
        tramiteInternoDao.save(conn, tinterno);
        resultado = true;
    }
    catch (Exception e){
      e.printStackTrace();
      resultado = false;
    }
    finally{
      conexion.cerrarCx();
    }
    return resultado;
  }
  
  public List getTramitesInternos(Tramiteinterno tinterno){
   List lista = null;      
   TramiteinternoDao tramiteInternoDao;
   try {
     tramiteInternoDao = new TramiteinternoDao();  
     conn = conexion.conectar();
     lista=tramiteInternoDao.searchMatching(conn, tinterno);
  }
  catch (Exception e) {
      e.printStackTrace();
  }
  finally{
    conexion.cerrarCx();
  }
  return lista;
  }
  
  public List listaTramitesInternos(){
    List lista = null;      
    TramiteinternoDao tramiteInternoDao;
    try {
      tramiteInternoDao = new TramiteinternoDao();  
      conn = conexion.conectar();
      lista=tramiteInternoDao.loadAll(conn);
    }
    catch (Exception e) {
       e.printStackTrace();
    }
    finally{
     conexion.cerrarCx();
    }
    return lista; 
  }
  
  public boolean cancelacionMatriculaVehiculo(String resolucionCancelacion, String recuperaMotor, TramiteBasico tramiteBasico,CancelacionMatricula cancelacionMatricula, int idUsuario,String myIp,String myHost){
        List lista = null;
        //Campos para la auditoria
        Auditoria myAuditoria;
        AuditoriaSystem myAuditSx;
        //--Campos para la auditoria
        boolean resultado = true;
        Vehiculo vehiculo=new Vehiculo();
        int id=0;
        try {
            conn = conexion.conectar();
            vehiculoDao=new VehiculoDao();
            vehiculo.setID_VEHICULO(Integer.parseInt(tramiteBasico.getIdVehiculo()));
            vehiculo.setID_MOTIVOCANCELACION(cancelacionMatricula.getIdMotivoCancelacion());
            vehiculo.setFECHACANCELACIONVEHICULO(cancelacionMatricula.getFechaCancelacion());
            vehiculo.setRECUPERAMOTOR(recuperaMotor);
            vehiculo.setRESOLUCIONCANCELACION(resolucionCancelacion);
            vehiculoDao.cancelarMatriculaVehiculo(conn, vehiculo);
            //Pasos para la auditoria
            myAuditoria = new Auditoria();
            myAuditSx= new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("VEHICULO");
            myAuditSx.setCAMPOCLAVE("ID_VEHICULO");
            myAuditSx.setVLRCAMPOCLAVE(tramiteBasico.getIdVehiculo());
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditSx.setDESCRIPOPERACION("Cancelacion de Matricula de Vehiculo");
            myAuditSx.setTIPOPERACION("E");
            myAuditoria.auditarOtraOp(conn,myAuditSx,0);
            //-- para la auditoria
            
            Object tmp = new Object();

            resultado = true;
            
        } catch (Exception e) {
            e.printStackTrace();
            vehiculo.setID_VEHICULO(-1);
            resultado = false;

          } finally {
            conexion.cerrarCx();
        }
        return resultado;     
  }
      
  public boolean crearSubTramite(Subtipotramite subtramite){
    boolean resultado;
    SubtipotramiteDao subtramiteDao;
    resultado = false;
    int id;
    try
    {
        subtramiteDao = new SubtipotramiteDao();
        conn = conexion.conectar();
        id=Funciones.obtenerId(conn, "GEN_SUBTIPOTRAMITE", "GEN_SUBTIPOTRAMITE", myMotor);
        subtramite.setID_SUBTIPOTRAMITE(id);
        subtramiteDao.create(conn, subtramite);
        resultado = true;
    }
    catch (Exception e){
      e.printStackTrace();
      resultado = false;
    }
    finally{
      conexion.cerrarCx();
      subtramiteDao = null;
    }
    return resultado;
    
  }
  
  public boolean eliminarSubTramite(Subtipotramite subtramite){
    boolean resultado;
    SubtipotramiteDao subtramiteDao;
    resultado = false;
    
    try
    {
      subtramiteDao = new SubtipotramiteDao();
      conn = conexion.conectar();
      subtramiteDao.delete(conn, subtramite);
      resultado = true;
    }
    catch (Exception e){
      e.printStackTrace();
      resultado = false;
    }
    finally{
      conexion.cerrarCx();
      subtramiteDao = null;
    }
    return resultado;
    
  }
  
  public boolean actualizarSubTramite(Subtipotramite subtramite){
    boolean resultado;
    SubtipotramiteDao subtramiteDao;
    resultado = false;
    
    try
    {
      subtramiteDao = new SubtipotramiteDao();
      conn = conexion.conectar();
      subtramiteDao.save(conn, subtramite);
      resultado = true;
    }
    catch (Exception e){
      e.printStackTrace();
      resultado = false;
    }
    finally{
      conexion.cerrarCx();
      subtramiteDao = null;
    }
    return resultado;
    
  }
  
  public List getSubTramite(Subtipotramite subtramite){
    List lista = null;
    SubtipotramiteDao subtramiteDao;
    try
    {
      subtramiteDao = new SubtipotramiteDao();
      conn = conexion.conectar();
      lista = (ArrayList)subtramiteDao.searchMatching(conn, subtramite);
    }
    catch (Exception e){
      e.printStackTrace();
    }
    finally{
      conexion.cerrarCx();
      subtramiteDao = null;
    }
    return lista;
    
  }
  
  public Subtipotramite getSubTramiteporID(Subtipotramite subtramite){
    SubtipotramiteDao subtramiteDao;
    try
    {
      subtramiteDao = new SubtipotramiteDao();
      conn = conexion.conectar();
      subtramiteDao.load(conn, subtramite);
    }
    catch (Exception e){
      e.printStackTrace();
    }
    finally{
      conexion.cerrarCx();
      subtramiteDao = null;
    }
    return subtramite;
  }
  
  public boolean crearRequisitoXtramite(Reqxtramite requisitoxtramite){
    boolean resultado;
    ReqxtramiteDao requisitoxtramiteDao;
    resultado = false;
    int id;
    try
    {
        requisitoxtramiteDao = new ReqxtramiteDao();
        conn = conexion.conectar();
        id=Funciones.obtenerId(conn, "GEN_REQXTRAMITE", "GEN_REQXTRAMITE", myMotor);
        requisitoxtramite.setID_REQXTRAMITE(id);
        requisitoxtramiteDao.create(conn, requisitoxtramite);
        resultado = true;
    }
    catch (Exception e){
      e.printStackTrace();
      resultado = false;
    }
    finally{
      conexion.cerrarCx();
      requisitoxtramiteDao = null;
    }
    return resultado;
  }
  
  public boolean eliminarRequisitoXtramite(Reqxtramite requisitoxtramite){
    boolean resultado;
    ReqxtramiteDao requisitoxtramiteDao;
    resultado = false;
    try
    {
      requisitoxtramiteDao = new ReqxtramiteDao();
      conn = conexion.conectar();
      requisitoxtramiteDao.delete(conn, requisitoxtramite);
      resultado = true;
    }
    catch (Exception e){
      e.printStackTrace();
      resultado = false;
    }
    finally{
      conexion.cerrarCx();
      requisitoxtramiteDao = null;
    }
    return resultado;
  }
  
  public boolean actualizarRequisitoXtramite(Reqxtramite requisitoxtramite){
    boolean resultado;
    ReqxtramiteDao requisitoxtramiteDao;
    resultado = false;
    try
    {
      requisitoxtramiteDao = new ReqxtramiteDao();
      conn = conexion.conectar();
      requisitoxtramiteDao.save(conn, requisitoxtramite);
      resultado = true;
    }
    catch (Exception e){
      e.printStackTrace();
      resultado = false;
    }
    finally{
      conexion.cerrarCx();
      requisitoxtramiteDao = null;
    }
    return resultado;
  }
  
  public List getRequisitosXTramite(Reqxtramite reqtramite){
    List lista = null;
    ReqxtramiteDao reqTramiteDao; 
    try
    {
      reqTramiteDao = new ReqxtramiteDao();
      conn = conexion.conectar();
      lista = reqTramiteDao.searchMatching(conn, reqtramite);
    }
    catch (Exception e){
      e.printStackTrace();
    }
    finally{
      conexion.cerrarCx();
      reqTramiteDao = null;
    }
    return lista;
  
  }
  
  public boolean crearCabRequisitoBase(Cabrequisitobase cabrequisito){
    boolean resultado;
    resultado = false;
    CabrequisitobaseDao cabrequisitoDao; 
    int id;
    try
    {
        cabrequisitoDao = new CabrequisitobaseDao();
        conn = conexion.conectar();
        id=Funciones.obtenerId(conn, "GEN_CABREQBASE", "GEN_CABREQBASE", myMotor);
        cabrequisito.setID_CABREQBASE(id);
        cabrequisitoDao.create(conn, cabrequisito);
        resultado = true;
    }
    catch (Exception e){
      e.printStackTrace();
      resultado = false;
    }
    finally{
      conexion.cerrarCx();
      cabrequisitoDao = null;
    }
    return resultado;
  }
  
  public boolean eliminarCabRequisitoBase(Cabrequisitobase cabrequisito){
    boolean resultado;
    resultado = false;
    CabrequisitobaseDao cabrequisitoDao; 
    try
    {
      cabrequisitoDao = new CabrequisitobaseDao();
      conn = conexion.conectar();
      cabrequisitoDao.delete(conn, cabrequisito);
      resultado = true;
    }
    catch (Exception e){
      e.printStackTrace();
      resultado = false;
    }
    finally{
      conexion.cerrarCx();
      cabrequisitoDao = null;
    }
    return resultado;
  }
  
  public boolean actualizarCabRequisitoBase(Cabrequisitobase cabrequisito){
    boolean resultado;
    resultado = false;
    CabrequisitobaseDao cabrequisitoDao; 
    try
    {
      cabrequisitoDao = new CabrequisitobaseDao();
      conn = conexion.conectar();
      cabrequisitoDao.save(conn, cabrequisito);
      resultado = true;
    }
    catch (Exception e){
      e.printStackTrace();
      resultado = false;
    }
    finally{
      conexion.cerrarCx();
      cabrequisitoDao = null;
    }
    return resultado;
  }
  
  public List getCabRequisitoBase(){
    List lista = null;
    CabrequisitobaseDao cabrequisitoDao; 
    try
    {
      cabrequisitoDao = new CabrequisitobaseDao();
      conn = conexion.conectar();
      lista = (ArrayList)cabrequisitoDao.loadAll(conn);
    }
    catch (Exception e){
      e.printStackTrace();
    }
    finally{
      conexion.cerrarCx();
      cabrequisitoDao = null;
    }
    return lista;
  }
  
  public Cabrequisitobase getCabRequisitoBaseporID(Cabrequisitobase cabrequisito){
    CabrequisitobaseDao cabrequisitoDao; 
    try
    {
      cabrequisitoDao = new CabrequisitobaseDao();
      conn = conexion.conectar();
      cabrequisitoDao.load(conn, cabrequisito);
    }
    catch (Exception e){
      e.printStackTrace();
    }
    finally{
      conexion.cerrarCx();
      cabrequisitoDao = null;
    }
    return cabrequisito;
  }
  
  // Actualizada Jun 18 2011 Cesar
  public boolean crearDetRequisitoBase(Detrequisitobase detrequisito){
    boolean resultado;
    resultado = false;
    DetrequisitobaseDao detrequisitoDao; 
    int id;
    try
    {
        detrequisitoDao = new DetrequisitobaseDao();
        conn = conexion.conectar();
        id=Funciones.obtenerId(conn, "GEN_DETREQUISITOBASE", "GEN_DETREQUISITOBASE", myMotor);
        detrequisito.setID_DETREQBASE(id);
        detrequisitoDao.create(conn, detrequisito);
        resultado = true;
    }
    catch (Exception e){
      e.printStackTrace();
      resultado = false;
    }
    finally{
      conexion.cerrarCx();
      detrequisitoDao = null;
    }
    return resultado;
  }
  
  public boolean eliminarDetRequisitoBase(Detrequisitobase detrequisito){
    boolean resultado;
    resultado = false;
    DetrequisitobaseDao detrequisitoDao; 
    try
    {
      detrequisitoDao = new DetrequisitobaseDao();
      conn = conexion.conectar();
      detrequisitoDao.delete(conn, detrequisito);
      resultado = true;
    }
    catch (Exception e){
      e.printStackTrace();
      resultado = false;
    }
    finally{
      conexion.cerrarCx();
      detrequisitoDao = null;
    }
    return resultado;
  }
  
  public boolean actualizarDetRequisitoBase(Detrequisitobase detrequisito){
    boolean resultado;
    resultado = false;
    DetrequisitobaseDao detrequisitoDao; 
    try
    {
      detrequisitoDao = new DetrequisitobaseDao();
      conn = conexion.conectar();
      detrequisitoDao.save(conn, detrequisito);
      resultado = true;
    }
    catch (Exception e){
      e.printStackTrace();
      resultado = false;
    }
    finally{
      conexion.cerrarCx();
      detrequisitoDao = null;
    }
    return resultado;
  }
  
  public List getDetRequisitoBase(Detrequisitobase detrequisito){
    List lista = null;
    DetrequisitobaseDao detrequisitoDao; 
    try
    {
      detrequisitoDao = new DetrequisitobaseDao();
      conn = conexion.conectar();
      lista = (ArrayList)detrequisitoDao.searchMatching(conn, detrequisito);
    }
    catch (Exception e){
      e.printStackTrace();
    }
    finally{
      conexion.cerrarCx();
      detrequisitoDao = null;
    }
    return lista;
  }
  
  public Detrequisitobase getDetRequisitoBaseporID(Detrequisitobase detrequisito){
    DetrequisitobaseDao detrequisitoDao; 
    try
    {
      detrequisitoDao = new DetrequisitobaseDao();
      conn = conexion.conectar();
      detrequisitoDao.load(conn, detrequisito);
    }
    catch (Exception e){
      e.printStackTrace();
    }
    finally{
      conexion.cerrarCx();
      detrequisitoDao = null;
    }
    return detrequisito;
  }
  
  public boolean crearRuntDuplicadoPlacas(TramiteBasico tramiteBasico, RuntDuplicadoPlaca runtDuplicadoPlacas){
    List lista = null;
    RuntDuplicadoPlacaDao runtDuplicadoPlcasDao;
    boolean resultado = false;
    int id=0;
    try {
        runtDuplicadoPlcasDao = new RuntDuplicadoPlacaDao();
        conn = conexion.conectar();
        id=Funciones.obtenerId(conn, "GEN_ID_RUNTDUPLIPLACA", "GEN_RUNTDUPLIPLACA", myMotor);
        runtDuplicadoPlacas.setID_RUNTDUPLICADOPLACA(id);
        runtDuplicadoPlcasDao.create(conn, runtDuplicadoPlacas);
        Object tmp = new Object();

        resultado = true;
    }
    catch (Exception e){
      e.printStackTrace();
      resultado = false;
    }
    finally{
      conexion.cerrarCx();
    }
    return resultado;
  }

  public boolean deshabilitarDuplicadosAnteriores(RuntDuplicadoPlaca runtDuplicadoPlacas){
    RuntDuplicadoPlacaDao runtDuplicadoPlcasDao;
    boolean resultado = false;
    int id=0;
    try {
        runtDuplicadoPlcasDao = new RuntDuplicadoPlacaDao();
        conn = conexion.conectar();
        runtDuplicadoPlcasDao.deshabilitarDuplicadosAnteriores(conn, runtDuplicadoPlacas);
        resultado = true;
    }
    catch (Exception e){
      e.printStackTrace();
      resultado = false;
    }
    finally{
      conexion.cerrarCx();
    }
    return resultado;
  }
  
  public boolean getRegrabacionVehiculo(RuntRegrabacionVehiculo runtRegrabacionVehiculo, TramiteBasico tramiteBasico){
    Vehiculo vehiculo =  new Vehiculo();
    GestionServiciosVehiculosLocal gestionVehiculos = new GestionServiciosVehiculosLocal(); 
    RuntRegrabacionVehiculoDao runRegrabacionVehicuoDao = new RuntRegrabacionVehiculoDao();
    VehiculoDao vehiculoDao = new VehiculoDao();

    boolean resultado = false;
    int id=0;
    try {
        conn = conexion.conectar();
        id=Funciones.obtenerId(conn, "GEN_RUNTREGRABACION", "GEN_RUNTREGRABACION", myMotor);
        runtRegrabacionVehiculo.setID_RUNTREGRABACION(id);
        runRegrabacionVehicuoDao.create(conn, runtRegrabacionVehiculo);
        vehiculo.setID_VEHICULO(runtRegrabacionVehiculo.getID_VEHICULO());
        vehiculo = gestionVehiculos.getVehiculo(vehiculo);
        if(vehiculo != null){
          if(runtRegrabacionVehiculo.getNUMERO_CHASIS()!=null)
          {
            vehiculo.setCHASIS(runtRegrabacionVehiculo.getNUMERO_CHASIS());
            vehiculo.setCHASISREGREBADO("X");
          }
          else if(runtRegrabacionVehiculo.getNUMERO_MOTOR()!=null) {
           vehiculo.setNRO_MOTOR(runtRegrabacionVehiculo.getNUMERO_MOTOR());  
           vehiculo.setMOTORREGRABADO("X");
         }
          else {
            vehiculo.setSERIE_MOTOR(runtRegrabacionVehiculo.getNUMERO_SERIE());
            vehiculo.setNUMSERIE_REGRABADO("X");
          }
          vehiculoDao.save(conn, vehiculo);
          Object tmp = new Object();
          resultado = true;
        }
    }
    catch (Exception e){
      e.printStackTrace();
      resultado = false;
    }
    finally{
      conexion.cerrarCx();
    }
    return resultado;
  }
  
  public CertificadoTrad getCertificadoTradicion(TramiteBasico tramiteBasico){
    boolean resultado = false;
    Vehiculo vehiculo = new Vehiculo();
    CertificadoTrad certificado = new CertificadoTrad();
    CertificadoTradicion certificadoTmp = new CertificadoTradicion();
    if(tramiteBasico != null){
      vehiculo.setID_VEHICULO(Integer.parseInt(tramiteBasico.getIdVehiculo()));
      vehiculo.setPLACA(tramiteBasico.getPlaca());
      certificado = certificadoTmp.generarCertificadoTradicion(vehiculo);
    }
    return certificado;
  }
  
  public boolean crearCambioMotor(TramiteBasico tramiteBasico, RuntCambioMotor runtCambioMotor){
    boolean resultado;
    resultado = false;
    RuntCambioMotorDao runtCambioMotorDao;
    
    int id;
    try
    {
        runtCambioMotorDao = new RuntCambioMotorDao();
        conn = conexion.conectar();
        id=Funciones.obtenerId(conn, "GEN_RUNT_CAMBIOMOTOR", "GEN_RUNTCAMBIOMOTOR", myMotor);
        runtCambioMotor.setID_CAMBIOMOTOR(id);
        runtCambioMotorDao.create(conn, runtCambioMotor);
        // TODO sql
        Object tmp = new Object();
        resultado = true;
    }
    catch (Exception e){
      e.printStackTrace();
      resultado = false;
    }
    finally{
      conexion.cerrarCx();
      runtCambioMotorDao = null;
    }
    return resultado;
  }
  
  public boolean desactivarRuntCambioMotor(RuntCambioMotor runtCambioMotor){
    boolean resultado;
    resultado = false;
    RuntCambioMotorDao runtCambioMotorDao;
    try
    {
      runtCambioMotorDao = new RuntCambioMotorDao();
      conn = conexion.conectar();
      runtCambioMotorDao.desactivarRuntCambioMotor(conn, runtCambioMotor);
      resultado = true;
    }
    catch (Exception e){
      e.printStackTrace();
      resultado = false;
    }
    finally{
      conexion.cerrarCx();
      runtCambioMotorDao = null;
    }
    return resultado;
  }
  
  public boolean searchCambioMotor(RuntCambioMotor runtCambioMotor){
    List lista = null;
    boolean resultado;
    RuntCambioMotorDao runtCambioMotorDao;
    resultado = false;
    
    try
    {
      runtCambioMotorDao = new RuntCambioMotorDao();
      conn = conexion.conectar();
      lista = runtCambioMotorDao.searchMatching(conn, runtCambioMotor);
      if(lista.size() > 0)
          resultado = true;
      else
          resultado = false;
    }
    catch (Exception e){
      e.printStackTrace();
      resultado = false;
    }
    finally{
      conexion.cerrarCx();
      runtCambioMotorDao = null;
    }
    return resultado;
  }
  
  public List getTTipoTraspaso(TipoTraspaso tipotraspaso)
  {
      List lista = null;      
      TipoTraspasoDao myTipoTraspasoDao;
      try 
      {
          myTipoTraspasoDao = new TipoTraspasoDao();  
          conn = conexion.conectar();
          lista=myTipoTraspasoDao.loadAll(conn);
      }
      catch (Exception e) {
          e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return lista; 
  }
  
    public List getRuntTipoEntrega()
    {
        List lista=null;
        RuntTipoEntregaDao myRuntTipEntregaDao;
            try 
            {
                myRuntTipEntregaDao = new RuntTipoEntregaDao();
                conn = conexion.conectar();
                lista=myRuntTipEntregaDao.loadAll(conn);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            finally{
                conexion.cerrarCx();
            }
            return lista; 
    }
    
    public List getRuntTipoEntrega(RuntTipoEntrega myRuntTipEntrega)
    {
        List lista=null;
        int id;
        RuntTipoEntregaDao myRuntTipEntregaDao;
            try 
            {
                id = myRuntTipEntrega.getID_TIPOENTREGA();
                myRuntTipEntregaDao = new RuntTipoEntregaDao();
                conn = conexion.conectar();
                lista=myRuntTipEntregaDao.searchMatching(conn,myRuntTipEntrega);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            finally{
                conexion.cerrarCx();
            }
            return lista; 
    }
  
    public List getRuntEntidadReporta()
    {
        List lista=null;
        RuntEntidadReportaDao myRuntEntRepDao;
            try 
            {
                myRuntEntRepDao = new RuntEntidadReportaDao();
                conn = conexion.conectar();
                lista=myRuntEntRepDao.loadAll(conn);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            finally{
                conexion.cerrarCx();
            }
            return lista; 
        }
  
  public List getRuntEntidadReporta(RuntEntidadReporta myRuntEntRep)
  {
      List lista=null;
      RuntEntidadReportaDao myRuntEntRepDao;
          try 
          {
              myRuntEntRepDao = new RuntEntidadReportaDao();
              conn = conexion.conectar();
              lista=myRuntEntRepDao.searchMatching(conn,myRuntEntRep);
          }
          catch (Exception e) {
              e.printStackTrace();
          }
          finally{
              conexion.cerrarCx();
          }
          return lista; 
      }
  
    public RuntEntidadReporta getOneRuntEntidadReporta(RuntEntidadReporta myRuntEntRep)
    {
        List lista=null;
        RuntEntidadReporta tmp = new RuntEntidadReporta();
        RuntEntidadReportaDao myRuntEntRepDao;
            try 
            {
                myRuntEntRepDao = new RuntEntidadReportaDao();
                conn = conexion.conectar();
                lista=myRuntEntRepDao.searchMatching(conn,myRuntEntRep);
                if (lista != null && lista.size()>0)
                    tmp = (RuntEntidadReporta)lista.get(0);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            finally{
                conexion.cerrarCx();
            }
            return tmp; 
        }
  
    public RuntRematricula crearRuntRematricula(TramiteBasico tramiteBasico, RuntRematricula myRuntRematricula){
      RuntRematriculaDao myRuntRematriculaDao; 
      List lista;
      int id;
      try
      {
          myRuntRematriculaDao = new RuntRematriculaDao();
          conn = conexion.conectar();
          id=Funciones.obtenerId(conn, "GEN_REMATRICULA", "GEN_REMATRICULA", myMotor);
          myRuntRematricula.setID_REMATRICULA(id);
          myRuntRematriculaDao.create(conn, myRuntRematricula);
          myRuntRematricula= new RuntRematricula();
          myRuntRematricula.setID_REMATRICULA(id);

          Object tmp = new Object();
          lista=myRuntRematriculaDao.searchMatching(conn, myRuntRematricula);
          if(lista!=null&&lista.size()>0)
          {
              myRuntRematricula=(RuntRematricula)lista.get(0);
          }
      }
      catch (Exception e){
        e.printStackTrace();
        myRuntRematricula=null;
      }
      finally{
        conexion.cerrarCx();
      }
      return myRuntRematricula;
    }
    
    public TransformacionVehiculo crearTransformacionVehiculo(TramiteBasico tramiteBasico, TransformacionVehiculo myTransVehi){
      TransformacionVehiculoDao myTransVehiDao; 
      List lista;
      int id;
      Object tmp = new Object();

      try
      {
          myTransVehiDao = new TransformacionVehiculoDao();
          conn = conexion.conectar();
          id=Funciones.obtenerId(conn, "GEN_TRANSFORVEH", "GEN_TRANSFORVEH", myMotor);
          myTransVehi.setIDTRANSF_VEHICULO(id);
          myTransVehi.setFECHAEXE(Funciones.getFechaSistema(conn,myMotor));
          myTransVehiDao.create(conn, myTransVehi);
          myTransVehi= new TransformacionVehiculo();
          myTransVehi.setIDTRANSF_VEHICULO(id);
          lista=myTransVehiDao.searchMatching(conn, myTransVehi);
          if(lista!=null&&lista.size()>0)
          {
              myTransVehi=(TransformacionVehiculo)lista.get(0);
          }
      }
      catch (Exception e){
        e.printStackTrace();
        return new TransformacionVehiculo();
      }
      finally{
        conexion.cerrarCx();
      }
      return myTransVehi;
    }
    
    public List getTransformacionVehiculo(TransformacionVehiculo myTransVehi){
      TransformacionVehiculoDao myTransVehiDao; 
      List lista=null;
      try
      {
          myTransVehiDao = new TransformacionVehiculoDao();
          conn = conexion.conectar();
          lista=myTransVehiDao.searchMatching(conn, myTransVehi);
      }
      catch (Exception e){
        e.printStackTrace();
      }
      finally{
        conexion.cerrarCx();
      }
      return lista;
    }
    
    public RuntTraspasoVehiculo crearTraspasoVehiculo(TramiteBasico tramiteBasico,RuntTraspasoVehiculo myTraspVehi, Traspaso traspaso){
      RuntTraspasoVehiculoDao myTraspVehiDao; 
      List lista;
      int id;
      try
      {
          myTraspVehiDao = new RuntTraspasoVehiculoDao();
          conn = conexion.conectar();
          id=Funciones.obtenerId(conn, "GEN_TRASPASOVEHICULO", "GEN_TRASPASOVEHICULO", myMotor);
          myTraspVehi.setID_TRASPASOVEH(id);
          myTraspVehiDao.create(conn, myTraspVehi);
          myTraspVehi= new RuntTraspasoVehiculo();
          myTraspVehi.setID_TRASPASOVEH(id);
          lista=myTraspVehiDao.searchMatching(conn, myTraspVehi);
          if(lista!=null&&lista.size()>0)
          {
              myTraspVehi=(RuntTraspasoVehiculo)lista.get(0);
          }
          
          Object tmp = new Object();
      }
      catch (Exception e){
        e.printStackTrace();
        return new RuntTraspasoVehiculo();
      }
      finally{
        conexion.cerrarCx();
      }
      return myTraspVehi;
    }
    
    public RuntTraspasoVehiculo crearTraspasoVehiculoIndeterminado(TramiteBasico tramiteBasico,RuntTraspasoVehiculo myTraspVehi, TraspasoIndeterminado traspasoIndet){
      RuntTraspasoVehiculoDao myTraspVehiDao; 
      List lista;
      int id;
      try
      {
          myTraspVehiDao = new RuntTraspasoVehiculoDao();
          conn = conexion.conectar();
          id=Funciones.obtenerId(conn, "GEN_TRASPASOVEHICULO", "GEN_TRASPASOVEHICULO", myMotor);
          myTraspVehi.setID_TRASPASOVEH(id);
          myTraspVehiDao.create(conn, myTraspVehi);
          myTraspVehi= new RuntTraspasoVehiculo();
          myTraspVehi.setID_TRASPASOVEH(id);
          lista=myTraspVehiDao.searchMatching(conn, myTraspVehi);
          /*if(lista!=null&&lista.size()>0)
          {
              myTraspVehi=(RuntTraspasoVehiculo)lista.get(0);
          }
          
          Object tmp = new Object();
          String tRunt = Funciones.leer_ini("/WSTransito.ini", "RUNT");
          if (tRunt.toUpperCase().equals("SI")) {
              GestionServiciosTramitesRNARunt gestionServiciosRNARunt = new GestionServiciosTramitesRNARunt();
              tmp = gestionServiciosRNARunt.getTramiteTraspasoIndeterminadoDTO(tramiteBasico, traspasoIndet);
              Funciones.obecjtToArchivoBinario(Funciones.leer_ini("/WSTransito.ini", "BINARIO_RUNT_FALTANTES")+"\\"+tramiteBasico.getNumeroFactura()+"-"+tramiteBasico.getOrdenEjecucion()+".bin", tmp);
          }*/
      }
      catch (Exception e){
        e.printStackTrace();
        return new RuntTraspasoVehiculo();
      }
      finally{
        conexion.cerrarCx();
      }
      return myTraspVehi;
    }
    
    public List getTraspasosVehiculo(RuntTraspasoVehiculo myTraspVehi){
      RuntTraspasoVehiculoDao myTraspVehiDao; 
      List lista=null;
      try
      {
          myTraspVehiDao = new RuntTraspasoVehiculoDao();
          conn = conexion.conectar();
          lista=myTraspVehiDao.searchMatching(conn, myTraspVehi);
      }
      catch (Exception e){
        e.printStackTrace();
      }
      finally{
        conexion.cerrarCx();
      }
      return lista;
    }
    
    public RuntTraspasoVehiculo desactivarTraspasoVehiculo(RuntTraspasoVehiculo myTraspVehi){
      RuntTraspasoVehiculoDao myTraspVehiDao; 
      List lista;
      int id;
      try
      {
          myTraspVehiDao = new RuntTraspasoVehiculoDao();
          conn = conexion.conectar();
          id=myTraspVehi.getID_TRASPASOVEH();
          myTraspVehiDao.desactivar(conn, myTraspVehi);
          myTraspVehi= new RuntTraspasoVehiculo();
          myTraspVehi.setID_TRASPASOVEH(id);
          lista=myTraspVehiDao.searchMatching(conn, myTraspVehi);
          if(lista!=null&&lista.size()>0)
          {
              myTraspVehi=(RuntTraspasoVehiculo)lista.get(0);
          }
      }
      catch (Exception e){
        e.printStackTrace();
        return new RuntTraspasoVehiculo();
      }
      finally{
        conexion.cerrarCx();
      }
      return myTraspVehi;
    }
}


