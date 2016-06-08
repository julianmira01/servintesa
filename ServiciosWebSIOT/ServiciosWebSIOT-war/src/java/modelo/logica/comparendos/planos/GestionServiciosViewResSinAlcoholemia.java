package modelo.logica.comparendos.planos;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.comparendos.planos.ViewResSinAlcoholemiaDao;
import modelo.datos.dao.comparendos.planos.ViewResolucionesDao;
import modelo.datos.objetos.comparendos.planos.ViewResSinAlcoholemia;
import modelo.datos.objetos.comparendos.planos.ViewResoluciones;

import modelo.datos.objetos.comparendos.planos.ViewResolucionesAlcoholemia;

import utilidades.Funciones;

public class GestionServiciosViewResSinAlcoholemia {
    
    Conexion conexion;
    Connection conn;
    ViewResSinAlcoholemiaDao viewResSinAlcoholemiaDao;
    String myMotor;
    
    public GestionServiciosViewResSinAlcoholemia() {
        super();
        conexion = new Conexion();
        viewResSinAlcoholemiaDao = new ViewResSinAlcoholemiaDao();
        myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
    }
    
    
    public List getViewResSinAlcholemia(ViewResSinAlcoholemia viewResSinAlcoholemia) {
        List lista = null;
        try {
            conn = conexion.conectarComparendos();
            lista = viewResSinAlcoholemiaDao.searchMatching(conn, viewResSinAlcoholemia);
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
    
    public List getResolucionesSinAlcoholemiaPorFechas(ViewResSinAlcoholemia viewResSinAlcoholemia, String fecha1, String fecha2) {
        List lista = null;
        try {
            conn = conexion.conectarComparendos();
            lista = viewResSinAlcoholemiaDao.getResolucionesSinAlcoholemiaPorFechas(conn, viewResSinAlcoholemia, fecha1, fecha2);
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
