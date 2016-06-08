package modelo.logica.generales;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.generales.SucursalDao;
import modelo.datos.objetos.generales.Sucursal;

import utilidades.Funciones;


public class GestionServiciosSucursalesLocal {

    Conexion conexion;
    Connection conn;
    SucursalDao sucursalDao;
    String myMotor;

    public GestionServiciosSucursalesLocal() {
        super();
        crearObjetos();
    }

    public void crearObjetos() {
        conexion = new Conexion();
        sucursalDao = new SucursalDao();
        myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
    }

    public List getSucursal(Sucursal sucursal) {
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = sucursalDao.searchMatching(conn, sucursal);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public Sucursal crearSucursal(Sucursal sucursal) {
        List lista = null;
        int id = 0;
        try {
            conn = conexion.conectar();
            id = Funciones.obtenerId(conn, "GEN_SUCURSAL", "GEN_SUCURSAL", myMotor);
            sucursal.setID_SUCURSAL(id);
            sucursalDao.create(conn, sucursal);
            sucursal = new Sucursal();
            sucursal.setID_SUCURSAL(id);
            lista = sucursalDao.searchMatching(conn, sucursal);
            if (lista != null && lista.size() > 0) {
                sucursal = (Sucursal)lista.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            sucursal.setID_SUCURSAL(-1);

        } finally {
            conexion.cerrarCx();
        }
        return sucursal;
    }

    public Sucursal actualizarSucursal(Sucursal sucursal) {
        List lista = null;
        int id = 0;
        try {
            conn = conexion.conectar();
            id = sucursal.getID_SUCURSAL();
            sucursalDao.save(conn, sucursal);
            sucursal = new Sucursal();
            sucursal.setID_SUCURSAL(id);
            lista = sucursalDao.searchMatching(conn, sucursal);
            if (lista != null && lista.size() > 0) {
                sucursal = (Sucursal)lista.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            sucursal.setID_SUCURSAL(-1);

        } finally {
            conexion.cerrarCx();
        }
        return sucursal;
    }

}
