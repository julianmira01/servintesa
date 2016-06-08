package modelo.logica.comparendos.planos;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.comparendos.planos.ViewResFaltantesCargaDao;
import modelo.datos.dao.comparendos.planos.ViewResolucionesDao;
import modelo.datos.objetos.comparendos.planos.ViewResFaltantesCarga;
import modelo.datos.objetos.comparendos.planos.ViewResoluciones;

import utilidades.Funciones;

public class GestionServiciosViewResFaltantesCarga {
    
    Conexion conexion;
    Connection conn;
    ViewResFaltantesCargaDao viewResFaltantesCargaDao;
    String myMotor;
    
    public GestionServiciosViewResFaltantesCarga() {
        super();
        conexion = new Conexion();
        viewResFaltantesCargaDao = new ViewResFaltantesCargaDao();
        myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
    }
    
    public List getViewResFaltantesCarga(ViewResFaltantesCarga viewResFaltantesCarga) {
        List lista = null;
        try {
            conn = conexion.conectarComparendos();
            lista = viewResFaltantesCargaDao.searchMatching(conn, viewResFaltantesCarga);
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
    
    public List getViewResFaltantesCarga2(ViewResFaltantesCarga viewResFaltantesCarga) {
        List lista = null;
        try {
            conn = conexion.conectarComparendos();
            lista = viewResFaltantesCargaDao.searchMatching2(conn, viewResFaltantesCarga);
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
    
    public List getResFaltantesCargaPorFechas(ViewResFaltantesCarga viewResFaltantesCarga, String fecha1, String fecha2) {
        List lista = null;
        try {
            conn = conexion.conectarComparendos();
            lista = viewResFaltantesCargaDao.getResFaltantesCargaPorFechas(conn, viewResFaltantesCarga, fecha1, fecha2);
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
