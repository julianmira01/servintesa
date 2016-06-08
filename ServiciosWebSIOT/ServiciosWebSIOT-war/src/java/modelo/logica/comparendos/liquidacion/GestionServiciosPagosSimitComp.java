package modelo.logica.comparendos.liquidacion;


import java.sql.Connection;

import java.util.ArrayList;
import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.comparendos.liquidacion.PagosSimitDao;
import modelo.datos.objetos.comparendos.liquidacion.PagosSimit;
import modelo.datos.objetos.generales.AuditoriaSystem;

import utilidades.Auditoria;
import utilidades.Funciones;


public class GestionServiciosPagosSimitComp {
    Conexion conexion;
    Connection conn;
    String myMotor;
    public GestionServiciosPagosSimitComp() {
        super();
        crearObjetos(); 
    }

    public void crearObjetos() {
        myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        conexion = new Conexion();
    }
    
    public List getPlanosSimit(PagosSimit pagossimit){
        List lista = null;
        PagosSimitDao myPagosSimitDao= new PagosSimitDao();
        try
        {
            conn = conexion.conectarComparendos();
            lista = (ArrayList)myPagosSimitDao.loadAll(conn);
        }
        catch (Exception e){
        e.printStackTrace();;
        }
        finally{
            conexion.cerrarCx();
        }
        return lista;
    }
    
    public PagosSimit getOnePlanosSimit(PagosSimit pagossimit){
        List lista = null;
        PagosSimitDao myPagosSimitDao= new PagosSimitDao();
        try
        {
            conn = conexion.conectarComparendos();
            lista = myPagosSimitDao.searchMatching(conn,pagossimit);
            if (lista != null && lista.size()>0)
                pagossimit = (PagosSimit)lista.get(0);
            else
                return null;
        }
        catch (Exception e){
        e.printStackTrace();;
        }
        finally{
            conexion.cerrarCx();
        }
        return pagossimit;
    }
    
    public boolean crearPagosSimit(PagosSimit pagosSimit, int idUsuario, String myIp, String myHost){
        boolean resultado;
        resultado = false;
        PagosSimitDao myPagosSimitDao = new PagosSimitDao();
        int id=0;
        
        try
        {
            conn = conexion.conectarComparendos();
            myMotor=myMotor.toUpperCase();
            id=Funciones.obtenerId(conn, "PAGOSSIMIT_ID_GEN", "GEN_PAGOSSIMIT", myMotor);
            pagosSimit.setID(id);
            pagosSimit.setFECHAREGISTRO(Funciones.getFechaSistema(conn,myMotor));
            myPagosSimitDao.create(conn, pagosSimit);
            resultado = true;
            //auditar insert
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("PAGOSSIMIT");
            myAuditSx.setCAMPOCLAVE("ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(pagosSimit.getID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, pagosSimit, 0);

        }
        catch (Exception e){
            e.printStackTrace();
            resultado = false;
        }
        finally{
            conexion.cerrarCx();
            myPagosSimitDao = null;
        }
        return resultado;
    }

    
    public boolean eliminarPagosSimit(PagosSimit pagosSimit)
    {
        boolean resultado;
        resultado = false;
        PagosSimitDao myPagosSimitDao = new PagosSimitDao();        
        try
        {
            conn = conexion.conectarComparendos();
            myPagosSimitDao.delete(conn, pagosSimit);
            resultado = true;
        }
        catch (Exception e){
            e.printStackTrace();
            resultado = false;
        }
        finally{
            conexion.cerrarCx();
            myPagosSimitDao = null;
        }
        return resultado;
    }
    
    
    public boolean editarPlanosSimit(PagosSimit pagosSimit, int idUsuario, String myIp, String myHost){
        boolean resultado;
        resultado = false;
        PagosSimitDao myPagosSimitDao = new PagosSimitDao();      
        try
        {
            conn = conexion.conectarComparendos();
            //auditar edicion
            PagosSimit ant = new PagosSimit();
            ant.setID(pagosSimit.getID());
            myPagosSimitDao.load(conn, ant);
            myPagosSimitDao.save(conn, pagosSimit);
            resultado = true;
            //auditar edicion
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("PAGOSSIMIT");
            myAuditSx.setCAMPOCLAVE("ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(pagosSimit.getID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEdicion(conn, myAuditSx, ant, pagosSimit, myIp, myHost, 0);

        }
        catch (Exception e){
            e.printStackTrace();
            resultado = false;
        }
        finally{
            conexion.cerrarCx();
            myPagosSimitDao = null;
        }
        return resultado;
    }
 
}
