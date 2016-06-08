package modelo.logica.comparendos.planos;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.comparendos.planos.ViewInfraccionesComparendoDao;
import modelo.datos.dao.comparendos.planos.ViewResolucionesDao;
import modelo.datos.objetos.comparendos.planos.ViewInfraccionesComparendo;
import modelo.datos.objetos.comparendos.planos.ViewResoluciones;

import utilidades.Funciones;

public class GestionServiciosViewInfraccionesComparendo {
    
    Conexion conexion;
    Connection conn;
    ViewInfraccionesComparendoDao viewInfraccionesComparendoDao;
    String myMotor;
    
    public GestionServiciosViewInfraccionesComparendo() {
        super();
        conexion = new Conexion();
        viewInfraccionesComparendoDao = new ViewInfraccionesComparendoDao();
        myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
    }
    
    public List getViewInfraccionesComparendo(ViewInfraccionesComparendo viewInfraccionesComparendo) {
        List lista = null;
        try {
            conn = conexion.conectarComparendos();
            lista = viewInfraccionesComparendoDao.searchMatching(conn, viewInfraccionesComparendo);
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
