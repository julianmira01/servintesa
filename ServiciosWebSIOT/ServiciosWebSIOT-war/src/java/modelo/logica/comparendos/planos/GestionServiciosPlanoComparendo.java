package modelo.logica.comparendos.planos;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.comparendos.planos.PlanoComparendoDao;
import modelo.datos.objetos.comparendos.planos.PlanoComparendo;
import modelo.datos.objetos.generales.AuditoriaSystem;

import utilidades.Auditoria;
import utilidades.Funciones;


public class GestionServiciosPlanoComparendo {
    Conexion conexion;
    Connection conn;
    PlanoComparendoDao planoComparendoDao;
    String myMotor;

    public GestionServiciosPlanoComparendo() {
        super();
        conexion = new Conexion();
        planoComparendoDao = new PlanoComparendoDao();			
        
        myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}


    }

    public List getPlanoComparendo(PlanoComparendo planoComparendo) {
        List lista = null;
        try {
            conn = conexion.conectarComparendos();
            lista = planoComparendoDao.searchMatching(conn, planoComparendo);
        } catch (Exception e) {
            lista = null;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public PlanoComparendo crearPlanoComparendo(PlanoComparendo planoComparendo, int idUsuario, String myIp,
                                                String myHost) {
        List lista = null;
        int id = 0;
        try {
            conn = conexion.conectarComparendos();
            id = Funciones.obtenerId(conn, "GEN_PLANOCOMPARENDO", "GEN_PLANOCOMPARENDO", myMotor);
            planoComparendo.setID_PLANOCOMPARENDO(id);
            planoComparendoDao.create(conn, planoComparendo);
            lista = planoComparendoDao.searchMatching(conn, planoComparendo);
            if (lista != null && lista.size() > 0) {
                planoComparendo = (PlanoComparendo)lista.get(0);
            }
            //auditar insert
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("PLANOCOMPARENDO");
            myAuditSx.setCAMPOCLAVE("ID_PLANOCOMPARENDO");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(planoComparendo.getID_PLANOCOMPARENDO()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, planoComparendo, 0);

        } catch (Exception e) {
            e.printStackTrace();
            planoComparendo.setID_PLANOCOMPARENDO(-1);

        } finally {
            conexion.cerrarCx();
        }
        return planoComparendo;
    }

    public List allPlanoComparendo(PlanoComparendo planoComparendo) {
        List lista = null;
        try {
            conn = conexion.conectarComparendos();
            lista = planoComparendoDao.loadAll(conn);
        } catch (Exception e) {
            lista = null;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public boolean editPlanoComparendo(PlanoComparendo planoComparendo, int idUsuario, String myIp, String myHost) {
        boolean respuesta = false;
        try {
            conn = conexion.conectarComparendos();
            //auditar edicion
            PlanoComparendo ant = new PlanoComparendo();
            ant.setID_PLANOCOMPARENDO(planoComparendo.getID_PLANOCOMPARENDO());
            planoComparendoDao.load(conn, ant);
            planoComparendoDao.save(conn, planoComparendo);
            respuesta = true;
            //auditar edicion
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("PLANOCOMPARENDO");
            myAuditSx.setCAMPOCLAVE("ID_PLANOCOMPARENDO");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(planoComparendo.getID_PLANOCOMPARENDO()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEdicion(conn, myAuditSx, ant, planoComparendo, myIp, myHost, 0);

        } catch (Exception e) {
            respuesta = false;
        } finally {
            conexion.cerrarCx();
        }
        return respuesta;
    }
}
