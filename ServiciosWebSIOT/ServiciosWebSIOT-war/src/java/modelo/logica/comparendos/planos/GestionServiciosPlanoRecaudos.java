package modelo.logica.comparendos.planos;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.comparendos.planos.PlanoRecaudosDao;
import modelo.datos.objetos.comparendos.planos.PlanoRecaudos;
import modelo.datos.objetos.generales.AuditoriaSystem;

import utilidades.Auditoria;
import utilidades.Funciones;


public class GestionServiciosPlanoRecaudos {
    Conexion conexion;
    Connection conn;
    PlanoRecaudosDao planoRecaudosDao;
    String myMotor;
    
    public GestionServiciosPlanoRecaudos() {
        super();
        conexion = new Conexion();
        planoRecaudosDao = new PlanoRecaudosDao();
        myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
    }
         
    public List getPlanoRecaudos(PlanoRecaudos planoRecaudos) {
      List lista = null;
      try {
        conn = conexion.conectarComparendos();
        lista = planoRecaudosDao.searchMatching(conn, planoRecaudos); 
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
    
    public PlanoRecaudos createPlanoRecaudos(PlanoRecaudos planoRecaudos, int idUsuario, String myIp, String myHost) {
        List lista = null;
        int id=0;
        try {
            conn = conexion.conectarComparendos();
            id=Funciones.obtenerId(conn, "GEN_PLANORECAUDOS", "GEN_PLANORECAUDOS", myMotor);
            planoRecaudos.setID_PLANORECAUDOS(id);
            planoRecaudosDao.create(conn, planoRecaudos);
            lista=planoRecaudosDao.searchMatching(conn, planoRecaudos);
            if(lista!=null && lista.size()>0){
                planoRecaudos = (PlanoRecaudos)lista.get(0);
            }
            //auditar insert
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("PLANO_RECAUDOS");
            myAuditSx.setCAMPOCLAVE("ID_PLANORECAUDOS");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(planoRecaudos.getID_PLANORECAUDOS()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, planoRecaudos, 0);

        } catch (Exception e) {
            e.printStackTrace();
            planoRecaudos.setID_PLANORECAUDOS(-1);

          } finally {
            conexion.cerrarCx();
        }
        return planoRecaudos;
    }
    
    public boolean editPlanoRecaudos(PlanoRecaudos planoRecaudos, int idUsuario, String myIp, String myHost)
    {
    boolean resultado = false;    
    try{
        conn = conexion.conectarComparendos();
        //auditar edicion
        PlanoRecaudos ant = new PlanoRecaudos();
        ant.setID_PLANORECAUDOS(planoRecaudos.getID_PLANORECAUDOS());
        planoRecaudosDao.load(conn, ant);
        planoRecaudosDao.save(conn, planoRecaudos);
        resultado = true;
        //auditar edicion
        Auditoria myAuditoria = new Auditoria();
        AuditoriaSystem myAuditSx = new AuditoriaSystem();
        myAuditSx.setTABLAAFECTADA("PLANO_RECAUDOS");
        myAuditSx.setCAMPOCLAVE("ID_PLANORECAUDOS");
        myAuditSx.setVLRCAMPOCLAVE(String.valueOf(planoRecaudos.getID_PLANORECAUDOS()));
        myAuditSx.setID_USUARIO(idUsuario);
        myAuditSx.setIP(myIp);
        myAuditSx.setNOMBREEQUIPO(myHost);
        myAuditoria.auditarEdicion(conn, myAuditSx, ant, planoRecaudos, myIp, myHost, 0);

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
    
    public List allPlanoRecaudos(PlanoRecaudos planoRecaudos) {
      List lista = null;
      try {
        conn = conexion.conectarComparendos();
        lista = planoRecaudosDao.loadAll(conn); 
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
