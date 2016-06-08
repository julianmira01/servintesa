package modelo.logica.generales;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.accesorias.DiasfestivosDao;
import modelo.datos.objetos.accesorias.Diasfestivos;

import utilidades.Funciones;


public class GestionServiciosDiasfestivos {
    Conexion conexion;
    Connection conn;
    String myMotor;

    public GestionServiciosDiasfestivos() {
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
    
    /**
     *
     * @param diasfestivos
     * @return
     */
    public List searchMatching(Diasfestivos diasfestivos) {
        List lista = null;
        try {
            conn = conexion.conectarComparendos();
            DiasfestivosDao myDao = new DiasfestivosDao();
            lista = myDao.searchMatching(conn, diasfestivos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
    /**
     *
     * @return
     */
    public List loadAll() {
        List lista = null;
        try {
            conn = conexion.conectarComparendos();
            DiasfestivosDao myDao = new DiasfestivosDao();
            lista = myDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
}
