package modelo.logica.comparendos.planos;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.comparendos.planos.ViewPagosSimitDao;
import modelo.datos.dao.comparendos.planos.ViewResolucionesDao;
import modelo.datos.objetos.comparendos.planos.ViewPagosSimit;
import modelo.datos.objetos.comparendos.planos.ViewResoluciones;

import utilidades.Funciones;

public class GestionServiciosViewPagosSimit {
    
    Conexion conexion;
    Connection conn;
    ViewPagosSimitDao viewPagosSimitDao;
    String myMotor;
    
    public GestionServiciosViewPagosSimit() {
        super();
        conexion = new Conexion();
        viewPagosSimitDao = new ViewPagosSimitDao();
        myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
    }
        
    public List getViewPagosSimit(ViewPagosSimit viewPagosSimit) {
        List lista = null;
        try {
            conn = conexion.conectarComparendos();
            lista = viewPagosSimitDao.searchMatching(conn, viewPagosSimit);
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
    
    public List getPagosSimitPorFechas(ViewPagosSimit viewPagosSimit, String fecha1, String fecha2) {
        List lista = null;
        try {
            conn = conexion.conectarComparendos();
            lista = viewPagosSimitDao.getPagosSimitPorFechas(conn, viewPagosSimit, fecha1, fecha2);
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
}
