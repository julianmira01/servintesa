package modelo.logica.liquidacion;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import modelo.conexion.Conexion;

import modelo.datos.dao.liquidacion.caja.LPagosDao;
import modelo.datos.dao.liquidacion.caja.ViewAsobancariaDao;
import modelo.datos.objetos.liquidacion.caja.ViewPagos;
import modelo.datos.dao.liquidacion.caja.ViewPagosDao;
import modelo.datos.dao.liquidacion.caja.ViewPagosRuntDao;
import modelo.datos.objetos.liquidacion.caja.LPagos;
import modelo.datos.objetos.liquidacion.caja.ViewAsobancaria;
import modelo.datos.objetos.liquidacion.caja.ViewPagosRunt;

import utilidades.Funciones;

public class GestionServiciosViewPagos {
    
    Conexion conexion;
    Connection conn;   
    String myMotor;
    
    public GestionServiciosViewPagos() {
        super();
        crearObjetos();
    }
  
    public void crearObjetos(){
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
    
    public List getPagos(ViewPagos viewPagos, String fechai, String fechaf)
    {
        List lista;
        lista = null;
        try
        {
            conn = conexion.conectar();
            ViewPagosDao myviewPagosDao = new ViewPagosDao();
            lista = myviewPagosDao.buscarPagos(conn, viewPagos, fechai, fechaf);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
           conexion.cerrarCx();
        }
        return lista;
    }      

    public List getPagosRunt(ViewPagosRunt viewPagosRunt, String fechai, String fechaf)
    {
        List lista;
        lista = null;
        try
        {
            conn = conexion.conectar();
            ViewPagosRuntDao myviewPagosRuntDao = new ViewPagosRuntDao();
            lista = myviewPagosRuntDao.buscarPagosRunt(conn, viewPagosRunt, fechai, fechaf);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
           conexion.cerrarCx();
        }
        return lista;
    }  
    
    public List loadPlanoAsobancaria(ViewAsobancaria viewAsobancaria, String fechai, String fechaf)
    {
        List lista;
        lista = null;
        try
        {
            conn = conexion.conectar();
            ViewAsobancariaDao myViewAsobancariaDao = new ViewAsobancariaDao();
            lista = myViewAsobancariaDao.loadPlano(conn, fechai, fechaf);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
           conexion.cerrarCx();
        }
        return lista;
    }
}
