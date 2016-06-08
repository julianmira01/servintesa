package modelo.logica.comparendos.planos;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.comparendos.planos.PlanoResolucionesDao;
import modelo.datos.objetos.comparendos.planos.PlanoResoluciones;
import modelo.datos.objetos.generales.AuditoriaSystem;

import utilidades.Auditoria;
import utilidades.Funciones;


public class GestionServiciosPlanoResoluciones {
    Conexion conexion;
    Connection conn;
    PlanoResolucionesDao planoResolucionesDao;
    String myMotor;
    
    public GestionServiciosPlanoResoluciones() {
        super();
        conexion = new Conexion();
        planoResolucionesDao = new PlanoResolucionesDao();
        myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
    }
         
    public List getPlanoResoluciones(PlanoResoluciones planoResoluciones) {
      List lista = null;
      try {
        conn = conexion.conectarComparendos();
        lista = planoResolucionesDao.searchMatching(conn, planoResoluciones); 
      }
      catch (Exception e) 
      {  
          lista=null;
      } 
      finally {
          conexion.cerrarCx();
      }
      return lista; 
    }
    
    public PlanoResoluciones createPlanoResoluciones(PlanoResoluciones planoResoluciones, int idUsuario, String myIp, String myHost) {
        List lista = null;
        int id=0;
        try {
            conn = conexion.conectarComparendos();
            id=Funciones.obtenerId(conn, "GEN_PLANORESOLUCIONES", "GEN_PLANORESOLUCIONES", myMotor);
            planoResoluciones.setID_PLANORESOLUCION(id);
            planoResolucionesDao.create(conn, planoResoluciones);
            lista=planoResolucionesDao.searchMatching(conn, planoResoluciones);
            if(lista!=null && lista.size()>0){
                planoResoluciones=(PlanoResoluciones)lista.get(0);
            }
            //auditar insert
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("PLANO_RESOLUCIONES");
            myAuditSx.setCAMPOCLAVE("ID_PLANORESOLUCION");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(planoResoluciones.getID_PLANORESOLUCION()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, planoResoluciones, 0);

        } catch (Exception e) {
            e.printStackTrace();
            planoResoluciones.setID_PLANORESOLUCION(-1);

          } finally {
            conexion.cerrarCx();
        }
        return planoResoluciones;
    }
    
    public boolean editPlanoResoluciones(PlanoResoluciones planoResoluciones, int idUsuario, String myIp, String myHost)
    {
    boolean resultado = false;    
    try{
        conn = conexion.conectarComparendos();
        //auditar edicion
        PlanoResoluciones ant = new PlanoResoluciones();
        ant.setID_PLANORESOLUCION(planoResoluciones.getID_PLANORESOLUCION());
        planoResolucionesDao.load(conn, ant);
        planoResolucionesDao.save(conn, planoResoluciones);
        resultado = true;
        //auditar edicion
        Auditoria myAuditoria = new Auditoria();
        AuditoriaSystem myAuditSx = new AuditoriaSystem();
        myAuditSx.setTABLAAFECTADA("PLANO_RESOLUCIONES");
        myAuditSx.setCAMPOCLAVE("ID_PLANORESOLUCION");
        myAuditSx.setVLRCAMPOCLAVE(String.valueOf(planoResoluciones.getID_PLANORESOLUCION()));
        myAuditSx.setID_USUARIO(idUsuario);
        myAuditSx.setIP(myIp);
        myAuditSx.setNOMBREEQUIPO(myHost);
        myAuditoria.auditarEdicion(conn, myAuditSx, ant, planoResoluciones, myIp, myHost, 0);

    }
    catch(Exception e){
      e.printStackTrace();
      resultado = false;
    }
    finally{
      conexion.cerrarCx();
    }
    return resultado;
    }
    
    public List allPlanoResoluciones(PlanoResoluciones planoResoluciones) {
      List lista = null;
      try {
        conn = conexion.conectarComparendos();
        lista = planoResolucionesDao.loadAll(conn); 
      }
      catch (Exception e) 
      {  
          lista=null;
      } 
      finally {
          conexion.cerrarCx();
      }
      return lista; 
    }
}
