package modelo.logica.generales;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.generales.HistoriaDeVehiculoDao;
import modelo.datos.objetos.generales.HistoriaDeVehiculo;

import utilidades.Funciones;


public class GestionServiciosHistoriaDeVehiculo {

    Conexion conexion;
    Connection conn;
    HistoriaDeVehiculoDao myHistoriaDeVehiculoDao;
    String myMotor;

    public GestionServiciosHistoriaDeVehiculo() {
        super();
        crearObjetos();
        myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
    }

    public void crearObjetos() {
        conexion = new Conexion();
    }

    public HistoriaDeVehiculo getHistoriaDeVehiculo(HistoriaDeVehiculo myHistoriaDeVehiculo)
    {
        List lista = null;
        try {
            myHistoriaDeVehiculoDao = new HistoriaDeVehiculoDao();
            conn = conexion.conectar();
            lista = myHistoriaDeVehiculoDao.searchMatching(conn, myHistoriaDeVehiculo);
            if (lista != null && lista.size() > 0) {
                myHistoriaDeVehiculo = (HistoriaDeVehiculo)lista.get(0);
            } else {
                myHistoriaDeVehiculo.setGEN_HISTORIAVEHICULO(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return myHistoriaDeVehiculo;
    }
    
    public List getHistoriasDeVehiculo(HistoriaDeVehiculo myHistoriaDeVehiculo)
    {
        List lista = null;
        try {
            myHistoriaDeVehiculoDao = new HistoriaDeVehiculoDao();
            conn = conexion.conectar();
            lista = myHistoriaDeVehiculoDao.searchMatching(conn, myHistoriaDeVehiculo);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    
    public List getHistoricoVehiculosSinFecha()
    {
        List lista = null;
        try {
            myHistoriaDeVehiculoDao = new HistoriaDeVehiculoDao();
            conn = conexion.conectar();
            lista = myHistoriaDeVehiculoDao.getHistoricoVehiculosSinFecha(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }


    public HistoriaDeVehiculo crearHistoriaDeVehiculo(HistoriaDeVehiculo myHistoria, boolean desatrasarHistorial) {
        List lista = null;
        int id = 0;
        myHistoriaDeVehiculoDao = new HistoriaDeVehiculoDao();
        try {
            conn = conexion.conectar();
            id = Funciones.obtenerId(conn, "GEN_HISTORIAVEHICULO", "GEN_HISTORIAVEHICULO", myMotor);
            myHistoria.setGEN_HISTORIAVEHICULO(id);
            if(!desatrasarHistorial)
                myHistoria.setFECHA(Funciones.getFechaSistema(conn,myMotor));
            myHistoriaDeVehiculoDao.create(conn, myHistoria);
            myHistoria = new HistoriaDeVehiculo();
            myHistoria.setGEN_HISTORIAVEHICULO(id);
            lista = myHistoriaDeVehiculoDao.searchMatching(conn, myHistoria);
            if (lista != null && lista.size() > 0) {
                myHistoria = (HistoriaDeVehiculo)lista.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            myHistoria.setGEN_HISTORIAVEHICULO(-1);

        } finally {
            conexion.cerrarCx();
        }
        return myHistoria;
    }

    public boolean actualizarHistoriaDeVehiculo(HistoriaDeVehiculo myHistoria) {
        myHistoriaDeVehiculoDao = new HistoriaDeVehiculoDao();
        boolean res = false;
        try {
            conn = conexion.conectar();
            myHistoriaDeVehiculoDao.save(conn, myHistoria);
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
            res = false;
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public boolean eliminarHistoriaDeVehiculo(HistoriaDeVehiculo myHistoria) {
        myHistoriaDeVehiculoDao = new HistoriaDeVehiculoDao();
        boolean res = false;
        try {
            conn = conexion.conectar();
            myHistoriaDeVehiculoDao.delete(conn, myHistoria);
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
            res = false;
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }
}
