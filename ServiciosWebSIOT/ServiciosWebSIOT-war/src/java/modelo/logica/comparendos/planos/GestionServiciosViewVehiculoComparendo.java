package modelo.logica.comparendos.planos;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.comparendos.planos.ViewResolucionesDao;
import modelo.datos.dao.comparendos.planos.ViewVehiculoComparendoDao;
import modelo.datos.objetos.comparendos.planos.ViewResoluciones;

import modelo.datos.objetos.comparendos.planos.ViewVehiculoComparendo;

import utilidades.Funciones;

public class GestionServiciosViewVehiculoComparendo {

    Conexion conexion;
    Connection conn;
    ViewVehiculoComparendoDao viewVehiculoComparendoDao;
    String myMotor;

    public GestionServiciosViewVehiculoComparendo() {
        super();
        conexion = new Conexion();
        viewVehiculoComparendoDao = new ViewVehiculoComparendoDao();
        myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
    }
        
    public List getViewVehiculoComparendo(ViewVehiculoComparendo viewVehiculoComparendo) {
        List lista = null;
        try {
            conn = conexion.conectarComparendos();
            lista = viewVehiculoComparendoDao.searchMatching(conn, viewVehiculoComparendo);
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
