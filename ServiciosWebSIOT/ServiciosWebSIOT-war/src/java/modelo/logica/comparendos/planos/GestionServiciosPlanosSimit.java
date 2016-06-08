package modelo.logica.comparendos.planos;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.comparendos.planos.PlanosSimitDao;
import modelo.datos.objetos.comparendos.planos.PlanosSimit;
import modelo.datos.objetos.generales.AuditoriaSystem;

import utilidades.Auditoria;
import utilidades.Funciones;


public class GestionServiciosPlanosSimit {
    Conexion conexion;
    Connection conn;
    PlanosSimitDao planosSimitDao;
    String myMotor;
    
    public GestionServiciosPlanosSimit() {
        super();
        conexion = new Conexion();
        planosSimitDao = new PlanosSimitDao();
        myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
    }
    
    public List getPlanosSimit() {
        List lista = null;
        try {
            conn = conexion.conectarComparendos();
            lista = planosSimitDao.loadAll(conn);
        }
        catch (Exception e)
        { 
            e.printStackTrace();
        }
        finally{
            conexion.cerrarCx();
        }
        return lista;
    }
    
    public boolean savePlanosSimit(PlanosSimit planosSimit, int idUsuario, String myIp, String myHost) {
        boolean resultado = false;
        try{
            conn = conexion.conectarComparendos();
            //auditar edicion
            PlanosSimit ant = new PlanosSimit();
            ant.setID(planosSimit.getID());
            planosSimitDao.load(conn, ant);
            planosSimitDao.save(conn, planosSimit);
            resultado = true;
            //auditar edicion
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("PLANOSSIMIT");
            myAuditSx.setCAMPOCLAVE("ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(planosSimit.getID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEdicion(conn, myAuditSx, ant, planosSimit, myIp, myHost, 0);

        }
        catch(Exception e) {
            e.printStackTrace();
            resultado = false;
        }
        finally{
            conexion.cerrarCx();
        }
        return resultado;
    }
    
    public PlanosSimit createPlanosSimit(PlanosSimit planosSimit, int idUsuario, String myIp, String myHost){
        int i;
        List lista = null;
        try{
            conn = conexion.conectarComparendos();
            myMotor=myMotor.toUpperCase();
            i=Funciones.obtenerId(conn, "PLANOSSIMIT_ID_GEN", "GEN_PLANOSSIMIT", myMotor);
            planosSimit.setID(i);
            planosSimitDao.create(conn, planosSimit);
            planosSimit = new PlanosSimit();
            planosSimit.setID(i);
            lista = planosSimitDao.searchMatching(conn, planosSimit);
            if((lista != null)&&(lista.size()>0)) {
                planosSimit = (PlanosSimit)lista.get(0);
            }
            //auditar insert
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("PLANOSSIMIT");
            myAuditSx.setCAMPOCLAVE("ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(planosSimit.getID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, planosSimit, 0);

        }
        catch (Exception e) {
            e.printStackTrace();
            planosSimit.setID(-1);
        }
        finally{
            conexion.cerrarCx();
        }
        return planosSimit;
    }
}
