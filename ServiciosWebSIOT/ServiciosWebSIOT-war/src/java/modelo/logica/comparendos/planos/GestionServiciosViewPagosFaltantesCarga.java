package modelo.logica.comparendos.planos;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.comparendos.planos.ViewPagosFaltantesCargaDao;
import modelo.datos.dao.comparendos.planos.ViewResFaltantesCargaDao;

import modelo.datos.objetos.comparendos.planos.ViewPagosFaltantesCarga;

import utilidades.Funciones;

public class GestionServiciosViewPagosFaltantesCarga {
    Conexion conexion;
    Connection conn;
    ViewPagosFaltantesCargaDao viewPagosFaltantesCargaDao;
    String myMotor;
    
    public GestionServiciosViewPagosFaltantesCarga() {
        super();
        conexion = new Conexion();
        myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
    }
    
    public List getViewPagosFaltantesCarga() {
        List lista = null;
        try {
            viewPagosFaltantesCargaDao= new  ViewPagosFaltantesCargaDao();
            conn = conexion.conectarComparendos();
            lista = viewPagosFaltantesCargaDao.loadAll(conn);
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
    
    public List getViewPagosFaltantesCarga(ViewPagosFaltantesCarga viewPagosFaltantesCarga) {
        List lista = null;
        try {
            viewPagosFaltantesCargaDao= new  ViewPagosFaltantesCargaDao();
            conn = conexion.conectarComparendos();
            lista = viewPagosFaltantesCargaDao.searchMatching(conn, viewPagosFaltantesCarga);
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
