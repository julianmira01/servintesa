package modelo.logica.tramites;

import java.sql.Connection;

import java.util.ArrayList;
import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.tramites.AnotacionTransforDao;
import modelo.datos.dao.tramites.RuntactaimportacionDao;
import modelo.datos.dao.tramites.TipoRepotenciacionDao;
import modelo.datos.dao.tramites.TipoTransformacionDao;
import modelo.datos.dao.tramites.VehiculoActaImportacionDao;
import modelo.datos.objetos.tramites.AnotacionTransfor;
import modelo.datos.objetos.tramites.Runtactaimportacion;
import modelo.datos.objetos.tramites.TipoRepotenciacion;
import modelo.datos.objetos.tramites.TipoTransformacion;
import modelo.datos.objetos.tramites.VehiculoActaImportacion;

import utilidades.Funciones;


public class GestionServiciosTramitesGeneralesLocal {
    
    Conexion conexion;
    Connection conn;
    String myMotor;
    Runtactaimportacion actaimportacion = new Runtactaimportacion();
    public GestionServiciosTramitesGeneralesLocal() {
        super();
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
    
  public List getActasImportacion(){
    List lista = null;
    try {
        RuntactaimportacionDao runtactaimportacionDao = new RuntactaimportacionDao();
        conn = conexion.conectar();
        lista = (ArrayList)runtactaimportacionDao.loadAll(conn);
    }
    catch (Exception e){
      e.printStackTrace();
    }
    finally{
      conexion.cerrarCx();
    }
    return lista;
  }
  
  public List searchActasImportacion(Runtactaimportacion actaImportacion){
    List lista = null;
    int id=0;
    try {
        RuntactaimportacionDao runtactaimportacionDao = new RuntactaimportacionDao();
        conn = conexion.conectar();
        lista = runtactaimportacionDao.searchMatching(conn, actaImportacion);
    }
    catch (Exception e){
      e.printStackTrace();
    }
    finally{
      conexion.cerrarCx();
    }
    return lista;
  }
  
  public boolean crearActaaImportacion(Runtactaimportacion actaImportacion, VehiculoActaImportacion vehiculoImportacion){
    Boolean resultado = false;
    int id=0;
    try {
        VehiculoActaImportacionDao vehiculoImpDao = new VehiculoActaImportacionDao();
        RuntactaimportacionDao runtactaimportacionDao = new RuntactaimportacionDao();
        conn = conexion.conectar();
        id=Funciones.obtenerId(conn, "GEN_VEHICULOACTAIMPORTACION", "GEN_VEHICULOACTAIMPORTACION", myMotor);
        vehiculoImportacion.setID_VEHICULO(id);
        vehiculoImpDao.create(conn, vehiculoImportacion);  
        vehiculoImportacion = new VehiculoActaImportacion();
        vehiculoImportacion.setID_VEHICULO(id);
        List lista = vehiculoImpDao.searchMatching(conn, vehiculoImportacion);
        actaImportacion.setID_VEHICULO(vehiculoImportacion.getID_VEHICULO());
        runtactaimportacionDao.create(conn, actaImportacion);
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
  
  public boolean actualizarActaImportacion(Runtactaimportacion actaImportacion, VehiculoActaImportacion vehiculoImp){
    Boolean resultado = false;
    int id=0;
    try {
        RuntactaimportacionDao runtactaimportacionDao = new RuntactaimportacionDao();
        VehiculoActaImportacionDao vehiculoImpDao = new VehiculoActaImportacionDao();
        conn = conexion.conectar();
        runtactaimportacionDao.save(conn, actaImportacion);
        vehiculoImpDao.save(conn, vehiculoImp);
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
  
  public boolean eliminarActaImportacion(Runtactaimportacion actaImportacion, VehiculoActaImportacion vehiculoImp){
    Boolean resultado = false;
    int id=0;
    try {
        RuntactaimportacionDao runtactaimportacionDao = new RuntactaimportacionDao();
        VehiculoActaImportacionDao vehiculoImpDao = new VehiculoActaImportacionDao();
        conn = conexion.conectar();
        runtactaimportacionDao.delete(conn, actaImportacion);
        vehiculoImpDao.delete(conn, vehiculoImp);
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
  
  public boolean actualizarEstadoActa(int idacta, String estadoActa, int idvehi, String estadoVehi){
  Boolean resultado = false;
  int id=0;
  try {
      RuntactaimportacionDao runtactaimportacionDao = new RuntactaimportacionDao();
      VehiculoActaImportacionDao vehiculoImpDao = new VehiculoActaImportacionDao();
      conn = conexion.conectar();
      runtactaimportacionDao.estadoActa(conn, idacta, estadoActa);
      vehiculoImpDao.estadoVehiculo(conn, idvehi, estadoVehi);
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
  
  public VehiculoActaImportacion searchVevhiculoImportacion (int id_vehiculo){
    VehiculoActaImportacionDao vehiculoImpDao = new VehiculoActaImportacionDao();
    VehiculoActaImportacion vehiculoImp = new VehiculoActaImportacion();
    vehiculoImp.setID_VEHICULO(id_vehiculo);
    try {
        
        conn = conexion.conectar();
        vehiculoImpDao.load(conn, vehiculoImp);
        
    }
    catch (Exception e){
      e.printStackTrace();
      
    }
    finally{
      conexion.cerrarCx();
    }
    return vehiculoImp;
  }
  
    public List getTipoTransformacion(TipoTransformacion myTipoTrans){
       List lista = null;
      try {
          TipoTransformacionDao myTipoTransDao = new TipoTransformacionDao();
          conn = conexion.conectar();
          lista = myTipoTransDao.searchMatching(conn,myTipoTrans);
      }
      catch (Exception e){
        e.printStackTrace();
      }
      finally{
        conexion.cerrarCx();
      }
      return lista;
    }
  
    public List getTipoTransformacion(){
      List lista = null;
      try {
          TipoTransformacionDao myTipoTransDao = new TipoTransformacionDao();
          conn = conexion.conectar();
          lista = myTipoTransDao.loadAll(conn);
      }
      catch (Exception e){
        e.printStackTrace();
      }
      finally{
        conexion.cerrarCx();
      }
      return lista;
    }
    
    
    public List getTipoRepotenciacion(TipoRepotenciacion myTipoRep){
      List lista = null;
      try {
          TipoRepotenciacionDao myTipoRepDao = new TipoRepotenciacionDao();
          conn = conexion.conectar();
          lista = myTipoRepDao.searchMatching(conn,myTipoRep);
      }
      catch (Exception e){
        e.printStackTrace();
      }
      finally{
        conexion.cerrarCx();
      }
      return lista;
    }
    
    public List getTipoRepotenciacion(){
      List lista = null;
      try {
          TipoRepotenciacionDao myTipoRepDao = new TipoRepotenciacionDao();
          conn = conexion.conectar();
          lista = myTipoRepDao.loadAll(conn);
      }
      catch (Exception e){
        e.printStackTrace();
      }
      finally{
        conexion.cerrarCx();
      }
      return lista;
    }
    
    public List getAnotacionTransfor(AnotacionTransfor myAnotacion){
      List lista = null;
      try {
          AnotacionTransforDao myAnotacionDao = new AnotacionTransforDao();
          conn = conexion.conectar();
          lista = myAnotacionDao.searchMatching(conn,myAnotacion);
      }
      catch (Exception e){
        e.printStackTrace();
      }
      finally{
        conexion.cerrarCx();
      }
      return lista;
    }
    
    public List getAnotacionTransfor(){
      List lista = null;
      try {
          AnotacionTransforDao myAnotacionDao = new AnotacionTransforDao();
          conn = conexion.conectar();
          lista = myAnotacionDao.loadAll(conn);
      }
      catch (Exception e){
        e.printStackTrace();
      }
      finally{
        conexion.cerrarCx();
      }
      return lista;
    }
    
  
    //GEN_REMATRICULA
}
