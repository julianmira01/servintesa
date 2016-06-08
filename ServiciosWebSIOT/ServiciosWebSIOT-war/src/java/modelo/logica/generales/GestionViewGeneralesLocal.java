package modelo.logica.generales;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.generales.vistas.DetalleprocersarViewDao;
import modelo.datos.dao.generales.vistas.ViewPropietarioEmpresaDao;
import modelo.datos.dao.generales.vistas.ViewPropietarioPersonaDao;
import modelo.datos.dao.generales.vistas.ViewTramitesVehiculoDao;
import modelo.datos.dao.generales.vistas.ViewVehiculoRUNTDao;
import modelo.datos.objetos.generales.vistas.DetalleprocersarView;
import modelo.datos.objetos.generales.vistas.ViewPropietarioEmpresa;
import modelo.datos.objetos.generales.vistas.ViewPropietarioPersona;
import modelo.datos.objetos.generales.vistas.ViewTramitesVehiculo;
import modelo.datos.objetos.generales.vistas.ViewVehiculoRUNT;

import utilidades.Funciones;


public class GestionViewGeneralesLocal {
    Conexion conexion;
    Connection conn;
    DetalleprocersarView detalleProcesar;
    DetalleprocersarViewDao detalleProcesarDao;
    String myMotor;
    public GestionViewGeneralesLocal() {
        super();
        detalleProcesar = new DetalleprocersarView();
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
    
    public List getDetalleProcesar(DetalleprocersarView detalleProcesarView){
      List lista = null;      
      try {
          conn = conexion.conectar();
          detalleProcesarDao = new DetalleprocersarViewDao();
          lista=detalleProcesarDao.searchMatching(conn,detalleProcesarView);
      }
      catch (Exception e) {
          e.printStackTrace();
      }
      finally{
        conexion.cerrarCx();
      }
      return lista;
      }
    
    public List getPropietariosPersonas(ViewPropietarioPersona viewPropietarioPersona){
      List lista = null;
      ViewPropietarioPersonaDao viewPropietarioPersonaDao;
      try{
        conn = conexion.conectar();
        viewPropietarioPersonaDao = new ViewPropietarioPersonaDao();
        lista = viewPropietarioPersonaDao.searchMatching(conn, viewPropietarioPersona);  
      }
      catch (Exception e){
        e.printStackTrace();
      }
      finally{
        conexion.cerrarCx();
      }
      return lista;    
    }
    
  public List getPropietariosEmpresas(ViewPropietarioEmpresa viewPropietarioEmpresa){
    List lista = null;
    ViewPropietarioEmpresaDao viewPropietarioEmpresaDao;
    try{
      conn = conexion.conectar();
      viewPropietarioEmpresaDao = new ViewPropietarioEmpresaDao();
      lista = viewPropietarioEmpresaDao.searchMatching(conn, viewPropietarioEmpresa);  
    }
    catch (Exception e){
      e.printStackTrace();
    }
    finally{
      conexion.cerrarCx();
    }
    return lista;    
  }
  
  public ViewPropietarioPersona getUnPropietarioPersona(ViewPropietarioPersona viewPropietarioPersona){
    List lista = null;
    ViewPropietarioPersonaDao viewPropietarioPersonaDao;
    ViewPropietarioPersona propietario = new ViewPropietarioPersona(); 
    try{
      conn = conexion.conectar();
      viewPropietarioPersonaDao = new ViewPropietarioPersonaDao();
      lista = viewPropietarioPersonaDao.searchMatching(conn, viewPropietarioPersona);  
        if((lista.size()>0) && (lista != null)){
          propietario = (ViewPropietarioPersona)lista.get(0);
        }
          
    }
    catch (Exception e){
      e.printStackTrace();
      propietario.setIDENTIFICACION("-1");
    }
    finally{
      conexion.cerrarCx();
    }
    return propietario;    
  }
  
  public ViewPropietarioEmpresa getUnPropietarioEmpresa(ViewPropietarioEmpresa viewPropietarioEmpresa){
  List lista = null;
  ViewPropietarioEmpresaDao viewPropietarioEmpresaDao;
  ViewPropietarioEmpresa propietario = new ViewPropietarioEmpresa();
  try{
    conn = conexion.conectar();
    viewPropietarioEmpresaDao = new ViewPropietarioEmpresaDao();
    lista = viewPropietarioEmpresaDao.searchMatching(conn, viewPropietarioEmpresa);  
      if((lista.size()>0) && (lista != null)){
        propietario = (ViewPropietarioEmpresa)lista.get(0);
      }
  }
  catch (Exception e){
    e.printStackTrace();
    propietario.setNIT("0");
  }
  finally{
    conexion.cerrarCx();
  }
  return propietario;    
  }
  
  public List getTramitesVehiculo(ViewTramitesVehiculo viewTramitesVehiculo ){
    List lista = null;
    ViewTramitesVehiculoDao viewTramitesVehiculoDao;
    try{
      conn = conexion.conectar();
      viewTramitesVehiculoDao = new ViewTramitesVehiculoDao();
      lista = viewTramitesVehiculoDao.searchMatching(conn, viewTramitesVehiculo);  
    }
    catch (Exception e){
      e.printStackTrace();
    }
    finally{
      conexion.cerrarCx();
    }
    return lista;    
  }
  
  
    public ViewVehiculoRUNT getVehiculoPorId(ViewVehiculoRUNT infoVehiculo){
        ViewVehiculoRUNTDao infoVehiculoDao;
        try {
            conn = conexion.conectar();
            infoVehiculoDao = new ViewVehiculoRUNTDao();
            infoVehiculoDao.load(conn, infoVehiculo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            infoVehiculo.setID_VEHICULO(-1);
        } finally {
            conexion.cerrarCx();
        }
        return infoVehiculo;
  }
    
    public List getVehiculos(ViewVehiculoRUNT infoVehiculo){
        ViewVehiculoRUNTDao infoVehiculoDao;
        List lista = null;
        try {
            conn = conexion.conectar();
            infoVehiculoDao = new ViewVehiculoRUNTDao();
            lista = infoVehiculoDao.searchMatching(conn, infoVehiculo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            lista = null;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
  
}
