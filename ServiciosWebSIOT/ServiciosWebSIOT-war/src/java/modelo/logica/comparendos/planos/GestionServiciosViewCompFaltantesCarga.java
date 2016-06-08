package modelo.logica.comparendos.planos;

import java.sql.Connection;

import java.sql.SQLException;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.comparendos.planos.ViewCompFaltantesCargaDao;
import modelo.datos.dao.comparendos.planos.ViewResolucionesDao;
import modelo.datos.objetos.comparendos.planos.ViewCompFaltantesCarga;
import modelo.datos.objetos.comparendos.planos.ViewResoluciones;

import utilidades.Funciones;

public class GestionServiciosViewCompFaltantesCarga {
    
    Conexion conexion;
    Connection conn;
    ViewCompFaltantesCargaDao viewCompFaltantesCargaDao;
    String myMotor;
    
    public GestionServiciosViewCompFaltantesCarga() {
        super();
        conexion = new Conexion();
        viewCompFaltantesCargaDao = new ViewCompFaltantesCargaDao();
        myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
    }
    
    public List getViewCompFaltantesDao(ViewCompFaltantesCarga viewCompFaltantesCarga) {
        List lista = null;
        try {
            conn = conexion.conectarComparendos();
            lista = viewCompFaltantesCargaDao.searchMatching(conn, viewCompFaltantesCarga);
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
    
    public List getCompFaltantesCargaPorFechas(ViewCompFaltantesCarga viewCompFaltantesCarga, String fecha1, String fecha2) {
        List lista = null;
        try {
            conn = conexion.conectarComparendos();
            lista = viewCompFaltantesCargaDao.getCompFaltantesCargaPorFechas(conn, viewCompFaltantesCarga, fecha1, fecha2);
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
