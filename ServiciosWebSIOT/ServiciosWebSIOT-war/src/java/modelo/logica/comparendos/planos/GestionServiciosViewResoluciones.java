package modelo.logica.comparendos.planos;

import java.sql.Connection;

import java.sql.SQLException;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.comparendos.planos.PlanosSimitDao;

import modelo.datos.dao.comparendos.planos.ViewResolucionesDao;

import modelo.datos.objetos.comparendos.planos.ViewResoluciones;

import utilidades.Funciones;

public class GestionServiciosViewResoluciones {
    
    Conexion conexion;
    Connection conn;
    ViewResolucionesDao viewResolucionesDao;
    String myMotor;
    
    public GestionServiciosViewResoluciones() {
        super();
        conexion = new Conexion();
        viewResolucionesDao = new ViewResolucionesDao();
        myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
    }
    
    public List getViewResoluciones(ViewResoluciones viewResoluciones) {
        List lista = null;
        try {
            conn = conexion.conectarComparendos();
            lista = viewResolucionesDao.searchMatching(conn, viewResoluciones);
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
    
    public List getResolucionesPorFechas(ViewResoluciones viewResoluciones, String fecha1, String fecha2) {
        List lista = null;
        try {
            conn = conexion.conectarComparendos();
            lista = viewResolucionesDao.getResolucionesPorFechas(conn, viewResoluciones, fecha1, fecha2);
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
