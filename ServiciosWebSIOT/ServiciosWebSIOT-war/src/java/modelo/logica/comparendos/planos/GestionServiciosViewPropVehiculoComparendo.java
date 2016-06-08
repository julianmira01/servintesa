package modelo.logica.comparendos.planos;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.comparendos.planos.ViewPropVehiculoComparendoDao;
import modelo.datos.dao.comparendos.planos.ViewResolucionesDao;
import modelo.datos.objetos.comparendos.planos.ViewPropVehiculoComparendo;
import modelo.datos.objetos.comparendos.planos.ViewResoluciones;

import utilidades.Funciones;

public class GestionServiciosViewPropVehiculoComparendo {
    
    Conexion conexion;
    Connection conn;
    ViewPropVehiculoComparendoDao viewPropVehiculoComparendoDao;
    String myMotor;    
    
    public GestionServiciosViewPropVehiculoComparendo() {
        super();
        conexion = new Conexion();
        viewPropVehiculoComparendoDao = new ViewPropVehiculoComparendoDao();
        myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
    }
    
    public List getViewPropVehiculoComparendo(ViewPropVehiculoComparendo viewPropVehiculoComparendo) {
        List lista = null;
        try {
            conn = conexion.conectarComparendos();
            lista = viewPropVehiculoComparendoDao.searchMatching(conn, viewPropVehiculoComparendo);
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
