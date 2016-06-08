package modelo.logica.auditoria;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.generales.AuditoriaSystemDao;

import modelo.datos.objetos.generales.AuditoriaSystem;

import utilidades.Auditoria;
import utilidades.Funciones;

public class GestionServiciosAuditoria {
    Conexion conexion;
    Connection conn;
    String myMotor;
    
    public GestionServiciosAuditoria() {
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
    
    public List getTablas(int modulo)
    {
         List mylista;
         mylista = null;
         try
         {
             if(modulo==0)
                 conn= conexion.conectar();
             else
                 conn = conexion.conectarComparendos();
             AuditoriaSystemDao myAuditoriaDao = new AuditoriaSystemDao();
             mylista = myAuditoriaDao.listaTablas(conn);
         }
         catch (Exception e){
             e.printStackTrace();
         }
         finally{
             conexion.cerrarCx();
         }
         return mylista;
    }
    
    public List getAuditoria(AuditoriaSystem myAuditoria,int modulo)
    {
         List mylista;
         mylista = null;
         try
         {
             if(modulo==0)
                 conn= conexion.conectar();
             else
                 conn = conexion.conectarComparendos();
             AuditoriaSystemDao myAuditoriaDao = new AuditoriaSystemDao();
             mylista = myAuditoriaDao.searchMatching(conn,myAuditoria);
         }
         catch (Exception e){
             e.printStackTrace();
         }
         finally{
             conexion.cerrarCx();
         }
         return mylista;
    }
    public List getAuditoria(AuditoriaSystem myAuditoria,String fechaInicial,String fechaFinal,int modulo)
    {
         List mylista;
         mylista = null;
         try
         {
             if(modulo==0)
                 conn= conexion.conectar();
             else
                 conn = conexion.conectarComparendos();
             AuditoriaSystemDao myAuditoriaDao = new AuditoriaSystemDao();
             mylista = myAuditoriaDao.searchMatchingRangoFecha(conn,myAuditoria,fechaInicial,fechaFinal);
         }
         catch (Exception e){
             e.printStackTrace();
         }
         finally{
             conexion.cerrarCx();
         }
         return mylista;
    }
}
