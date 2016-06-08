package modelo.logica.comparendos.planos;

import java.sql.Connection;

import java.sql.SQLException;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.comparendos.planos.ViewResolucionesAlcoholemiaDao;
import modelo.datos.dao.comparendos.planos.ViewResolucionesDao;
import modelo.datos.objetos.comparendos.planos.ViewResoluciones;

import modelo.datos.objetos.comparendos.planos.ViewResolucionesAlcoholemia;

import utilidades.Funciones;

public class GestionServiciosViewResolucionesAlcoholemia {
    
    Conexion conexion;
    Connection conn;
    ViewResolucionesAlcoholemiaDao viewResolucionesAlcoholemiaDao;
    String myMotor;
    
    public GestionServiciosViewResolucionesAlcoholemia() {
        super();
        conexion = new Conexion();
        viewResolucionesAlcoholemiaDao = new ViewResolucionesAlcoholemiaDao();
        myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
    }
    
    public List getViewResolucionesAlcoholemia(ViewResolucionesAlcoholemia viewResolucionesAlcoholemia) {
        List lista = null;
        try {
            conn = conexion.conectarComparendos();
            lista = viewResolucionesAlcoholemiaDao.searchMatching(conn, viewResolucionesAlcoholemia);
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
    
    public List getResolucionesAlcoholemiaPorFechas(ViewResolucionesAlcoholemia viewResolucionesAlcoholemia, String fecha1, String fecha2) {
        List lista = null;
        try {
            conn = conexion.conectarComparendos();
            lista = viewResolucionesAlcoholemiaDao.getResolucionesAlcoholemiaPorFechas(conn, viewResolucionesAlcoholemia, fecha1, fecha2);
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
