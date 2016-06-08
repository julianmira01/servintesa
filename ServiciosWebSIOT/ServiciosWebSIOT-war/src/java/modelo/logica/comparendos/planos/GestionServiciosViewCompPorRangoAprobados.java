package modelo.logica.comparendos.planos;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.comparendos.planos.PlanosSimitDao;

import modelo.datos.dao.comparendos.planos.ViewCompPorRangoAprobadosDao;

import modelo.datos.objetos.comparendos.planos.ViewCompPorRangoAprobados;

import utilidades.Funciones;

public class GestionServiciosViewCompPorRangoAprobados {
    
    Conexion conexion;
    Connection conn;
    ViewCompPorRangoAprobadosDao viewCompPorRangoAprobadosDao;
    String myMotor;
    
    public GestionServiciosViewCompPorRangoAprobados() {
        super();
        conexion = new Conexion();
        viewCompPorRangoAprobadosDao = new ViewCompPorRangoAprobadosDao();
        myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
    }
    
    public List getViewCompPorRangoAprobados(ViewCompPorRangoAprobados viewCompPorRangoAprobados){
        List lista = null;
        try {
            conn = conexion.conectarComparendos();
            lista = viewCompPorRangoAprobadosDao.searchMatching(conn, viewCompPorRangoAprobados);
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
