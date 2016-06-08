package modelo.logica.generales;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.generales.PropietarioDeVehiculoDao;
import modelo.datos.dao.generales.propietarioDeVehiculo.ViewPropietariosDao;
import modelo.datos.dao.tramites.ViewTotalTraspasosDao;
import modelo.datos.objetos.generales.AuditoriaSystem;
import modelo.datos.objetos.generales.propietarioDeVehiculo.PropietarioDeVehiculo;
import modelo.datos.objetos.generales.propietarioDeVehiculo.ViewPropietarios;
import modelo.datos.objetos.generales.vehiculo.Vehiculo;
import modelo.datos.objetos.tramites.ViewTotalTraspasos;

import utilidades.Auditoria;
import utilidades.Funciones;


public class GestionServiciosPropietariosLocal {
    
  Conexion conexion;
  Connection conn;
  String myMotor;
  PropietarioDeVehiculoDao propietarioDeVehiculoDao;
  //VehiculoDao vehiculoDao;
    
    public GestionServiciosPropietariosLocal() {
        super();
        crearObjetos();
    }
    
  public void crearObjetos() {
      conexion = new Conexion();      
      //vehiculoDao = new VehiculoDao();
      propietarioDeVehiculoDao = new PropietarioDeVehiculoDao();
      myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
  }
  
  /*public List getPropietarios(PropietarioDeVehiculo propietarioDeVehiculo) {
      List lista = null;
      try {
          conn = conexion.conectar();
          lista = propietarioDeVehiculoDao.searchMatching(conn, propietarioDeVehiculo);
      } catch (Exception e) {
          System.out.println(e.getMessage());
      } finally {
          conexion.cerrarCx();
      }
      return lista;
  }*/

  public List getPropietarios(PropietarioDeVehiculo propietarioDeVehiculo)
  {
      System.out.println("getPropietarios");
      List lista;
      lista = null;
      try
      {
          conexion = new Conexion();
          conn = conexion.conectar();
          PropietarioDeVehiculoDao myPropietarioDeVehiculoDao = new PropietarioDeVehiculoDao();
          lista = myPropietarioDeVehiculoDao.searchMatching(conn, propietarioDeVehiculo);
      }
      catch (Exception e){
          e.printStackTrace();
      }
      finally{
         conexion.cerrarCx();
      }
      
      System.out.println("null");
      return lista;
  } 
  
  public boolean createPropietarios(PropietarioDeVehiculo propietarioDeVehiculo,int idUsuario,String myIp,String myHost) {
      boolean resultado = false;
      int id;
      //Campos para la auditoria
      Auditoria myAuditoria;
      AuditoriaSystem myAuditSx;
      //--Campos para la auditoria
      try {
          conn = conexion.conectar();
          id=Funciones.obtenerId(conn, "GEN_PROPIETVEHICULO", "GEN_PROPIETVEHICULO", myMotor);
          propietarioDeVehiculo.setID_PROPVEHICULO(id);
          //propietarioDeVehiculo.setFECHA(Funciones.getFechaSistema(conn));
          propietarioDeVehiculo.setPROPIETARIOACTUAL("T");
          propietarioDeVehiculoDao.create(conn, propietarioDeVehiculo);
          //Pasos para la auditoria
          myAuditoria = new Auditoria();
          myAuditSx= new AuditoriaSystem();
          myAuditSx.setTABLAAFECTADA("PROPIETARIODEVEHICULO");
          myAuditSx.setCAMPOCLAVE("ID_PROPVEHICULO");
          myAuditSx.setVLRCAMPOCLAVE(String.valueOf(id));
          myAuditSx.setID_USUARIO(idUsuario);
          myAuditSx.setIP(myIp);
          myAuditSx.setNOMBREEQUIPO(myHost);
          myAuditoria.auditarInsersion(conn,myAuditSx, propietarioDeVehiculo,0);
          //-- para la auditoria
          resultado = true;  
      } catch (Exception e) {
          System.out.println(e.getMessage());
          resultado = false;
      } finally {
          conexion.cerrarCx();
      }
      return resultado;
  }
  
  public boolean actualizarPropietarioDeVehiculo(PropietarioDeVehiculo propietarioDeVehiculo,int idUsuario,String myIp,String myHost){

       boolean resultado = false;
       List lista;
       //Campos para la auditoria
       PropietarioDeVehiculo anterior;
       
       Auditoria myAuditoria;
       AuditoriaSystem myAuditSx;
       //--Campos para la auditoria
       
       try {
            conn = conexion.conectar();
            //Pasos previos Auditoria
            anterior = new PropietarioDeVehiculo();
            anterior.setID_PROPIETARIO(propietarioDeVehiculo.getID_PROPIETARIO());
            lista = propietarioDeVehiculoDao.searchMatching(conn, anterior);
           
           if (lista != null && lista.size() > 0) {
               anterior = (PropietarioDeVehiculo)lista.get(0);
           } else {
               anterior = null;
           }
           
           //Pasos previos para auditoria
           propietarioDeVehiculoDao.save(conn, propietarioDeVehiculo);
           //Pasos para la auditoria
           myAuditoria = new Auditoria();
           myAuditSx = new AuditoriaSystem();
           myAuditSx.setTABLAAFECTADA("VEHICULO");
           myAuditSx.setCAMPOCLAVE("ID_VEHICULO");
           myAuditSx.setVLRCAMPOCLAVE(String.valueOf(propietarioDeVehiculo.getID_PROPIETARIO()));
           myAuditSx.setID_USUARIO(idUsuario);
           myAuditSx.setIP(myIp);
           myAuditSx.setNOMBREEQUIPO(myHost);
           myAuditoria.auditarEdicion(conn, myAuditSx, anterior, propietarioDeVehiculo, myIp, myHost, 0);
           
           //-- para la auditoria
           resultado = true;
           
       } catch (Exception e) {
           System.out.println(e.getMessage());
           resultado = false;
       } finally {
           conexion.cerrarCx();
       }
       
       return resultado;
   }
  
  public boolean cambiarEstadoPropietarios(PropietarioDeVehiculo propietarioDeVehiculo,int idUsuario,String myIp,String myHost) {
        boolean resultado = false;
        int id;
        //Campos para la auditoria
        Auditoria myAuditoria;
        AuditoriaSystem myAuditSx;
        //--Campos para la auditoria
        try {
            conn = conexion.conectar();
            id=propietarioDeVehiculo.getID_PROPVEHICULO();
            propietarioDeVehiculoDao.activarDesactivar(conn, propietarioDeVehiculo);
            //Pasos para la auditoria
            myAuditoria = new Auditoria();
            myAuditSx= new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("PROPIETARIODEVEHICULO");
            myAuditSx.setCAMPOCLAVE("ID_PROPVEHICULO");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(id));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            if(propietarioDeVehiculo.getESTADO().equals("T"))
                myAuditSx.setDESCRIPOPERACION("Se activo el usuario");
            if(propietarioDeVehiculo.getESTADO().equals("F"))
                myAuditSx.setDESCRIPOPERACION("Se desactivo el usuario");
            myAuditoria.auditarOtraOp(conn,myAuditSx,0);
            //-- para la auditoria
            resultado = true;  
        } catch (Exception e) {
            System.out.println(e.getMessage());
            resultado = false;
        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }
  
  public List getTotalTraspasos(ViewTotalTraspasos totalTraspasos) {
      ViewTotalTraspasosDao totalTraspasosDao = new ViewTotalTraspasosDao();
      List lista = null;
      try
      {
          conexion = new Conexion();
          conn = conexion.conectar();
          lista = totalTraspasosDao.searchMatching(conn, totalTraspasos);
      }
      catch (Exception e){
          e.printStackTrace();
      }
      finally{
         conexion.cerrarCx();
      }
      return lista;
  }
  
  public boolean borrarPropietarioVehiculo(PropietarioDeVehiculo propietario) {
        boolean resultado;
        
        List lista = null;
        try
        {  
            conexion = new Conexion();
            conn = conexion.conectar();
            PropietarioDeVehiculoDao myPropietarioDeVehiculoDao = new PropietarioDeVehiculoDao();         
            myPropietarioDeVehiculoDao.delete(conn, propietario);
        
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
   
  public boolean eliminarPropietariosDeVehiculo(PropietarioDeVehiculo propietario,int idUsuario,String myIp,String myHost)
  {
      boolean completo=false;
      int idVehiculo;
      List lista;
      lista = null;
      //Campos para la auditoria
      PropietarioDeVehiculo anterior;
      Auditoria myAuditoria;
      AuditoriaSystem myAuditSx;
      //--Campos para la auditoria
      try
      {
          conexion = new Conexion();
          conn = conexion.conectar();
          PropietarioDeVehiculoDao myPropietarioDeVehiculoDao = new PropietarioDeVehiculoDao();         
          idVehiculo=propietario.getID_VEHICULO();
          if(idVehiculo>0)
          {
              lista = myPropietarioDeVehiculoDao.searchMatching(conn, propietario);
              if(lista!=null&&lista.size()>0)
              {
                  for(int i=0;i<lista.size();i++)
                  {
                      propietario=(PropietarioDeVehiculo)lista.get(i);
                      //Pasos para la auditoria
                      myAuditoria = new Auditoria();
                      myAuditSx= new AuditoriaSystem();
                      myAuditSx.setTABLAAFECTADA("PROPIETARIODEVEHICULO");
                      myAuditSx.setCAMPOCLAVE("ID_PROPVEHICULO");
                      myAuditSx.setVLRCAMPOCLAVE(String.valueOf(propietario.getID_PROPIETARIO()));
                      myAuditSx.setID_USUARIO(idUsuario);
                      myAuditSx.setIP(myIp);
                      myAuditSx.setNOMBREEQUIPO(myHost);
                      myAuditoria.auditarEliminacion(conn,myAuditSx,propietario,0);
                      //-- para la auditoria
                      propietarioDeVehiculoDao.delete(conn, propietario);
                      completo = true;
                  }
              }
              propietario = new PropietarioDeVehiculo();
              propietario.setID_VEHICULO(idVehiculo);
              lista=propietarioDeVehiculoDao.searchMatching(conn, propietario);
              if(lista==null||lista.size()<=0)
                  completo=true;
          }
      }
      catch (Exception e){
          e.printStackTrace();
          return false;
      }
      finally{
         conexion.cerrarCx();
      }
      System.out.println("null");
      return completo;
  }
  
    public boolean desvincularPropietarioDeVehiculo(PropietarioDeVehiculo propietarioDeVehiculo,int idUsuario,String myIp,String myHost) {
        boolean resultado = false;
        int id;
        //Campos para la auditoria
        Auditoria myAuditoria;
        AuditoriaSystem myAuditSx;
        //--Campos para la auditoria
        try {
            conn = conexion.conectar();
            id=propietarioDeVehiculo.getID_PROPVEHICULO();
            propietarioDeVehiculo.setFECHAFINPROPIEDAD(Funciones.getFechaSistema(conn,myMotor));
            propietarioDeVehiculoDao.desvincular(conn, propietarioDeVehiculo);
            //Pasos para la auditoria
            myAuditoria = new Auditoria();
            myAuditSx= new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("PROPIETARIODEVEHICULO");
            myAuditSx.setCAMPOCLAVE("ID_PROPVEHICULO");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(id));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditSx.setDESCRIPOPERACION("Se desvinculo el propietario del Vehiculo");
            myAuditoria.auditarOtraOp(conn,myAuditSx,0);
            //-- para la auditoria
            resultado = true;  
        } catch (Exception e) {
            System.out.println(e.getMessage());
            resultado = false;
        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }
    
    public List getViewPropietarios(ViewPropietarios propietariosDeVehiculo)
    {
        System.out.println("getViewPropietarios");
        List lista;
        lista = null;
        try
        {
            conexion = new Conexion();
            conn = conexion.conectar();
            ViewPropietariosDao myPropietarioDeVehiculoDao = new ViewPropietariosDao();
            lista = myPropietarioDeVehiculoDao.searchMatching(conn, propietariosDeVehiculo);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
           conexion.cerrarCx();
        }
        
        System.out.println("null");
        return lista;
    } 
    
}
