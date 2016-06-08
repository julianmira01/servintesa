package modelo.logica.generales;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.generales.LicenciaDeTransitoDao;
import modelo.datos.objetos.generales.LicenciaDeTransito;

import utilidades.Funciones;


public class GestionServiciosLicenciaDeTransito {

    Conexion conexion;
    Connection conn;
    LicenciaDeTransitoDao licenciaDeTransitoDao;
    String myMotor;

    public GestionServiciosLicenciaDeTransito() {
        super();
        crearObjetos();
    }

    public void crearObjetos() {
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

    public LicenciaDeTransito getLicenciaDeTransito(LicenciaDeTransito licenciaDeTransito) {
        List lista = null;
        try {
            licenciaDeTransitoDao = new LicenciaDeTransitoDao();
            conn = conexion.conectar();
            lista = licenciaDeTransitoDao.searchMatching(conn, licenciaDeTransito);
            if (lista != null && lista.size() > 0) {
                licenciaDeTransito = (LicenciaDeTransito)lista.get(0);
            } else {
                licenciaDeTransito.setGEN_IDTRANSITO(-1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conexion.cerrarCx();
        }
        return licenciaDeTransito;
    }

    public List getLicenciasDeTransito(LicenciaDeTransito myLicencia) {
        List lista = null;
        try {
            licenciaDeTransitoDao = new LicenciaDeTransitoDao();
            conn = conexion.conectar();
            lista = licenciaDeTransitoDao.searchMatching(conn, myLicencia);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getLicenciasDeTransitoSinFechaExpedicion() {
        List lista = null;
        try {
            licenciaDeTransitoDao = new LicenciaDeTransitoDao();
            conn = conexion.conectar();
            lista = licenciaDeTransitoDao.getLicenciasSinFechaExpedicion(conn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public LicenciaDeTransito crearLicenciaDeTransito(LicenciaDeTransito licenciaDeTransito) {
        LicenciaDeTransito tmp = new LicenciaDeTransito();
        List lista = null;
        int id = -1;
        try {
            licenciaDeTransitoDao = new LicenciaDeTransitoDao();
            conn = conexion.conectar();
            id = Funciones.obtenerId(conn, "GEN_LICTRANSITO", "GEN_LICTRANSITO", myMotor);
            licenciaDeTransito.setGEN_IDTRANSITO(id);
            licenciaDeTransitoDao.create(conn, licenciaDeTransito);
            tmp.setGEN_IDTRANSITO(id);
            lista = licenciaDeTransitoDao.searchMatching(conn, tmp);
            if (lista != null && lista.size() > 0) {
                tmp = (LicenciaDeTransito)lista.get(0);
            } else {
                tmp.setGEN_IDTRANSITO(-1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conexion.cerrarCx();
        }
        return tmp;
    }

    public boolean actualizarNroLicenciaDeTransito(int idLic, String nroLic) {
        LicenciaDeTransito tmp = new LicenciaDeTransito();
        try {
            licenciaDeTransitoDao = new LicenciaDeTransitoDao();
            conn = conexion.conectar();
            tmp.setGEN_IDTRANSITO(idLic);
            tmp.setID_LICTRANSITO(nroLic);
            licenciaDeTransitoDao.actNroLic(conn, tmp);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            conexion.cerrarCx();
        }
        return true;
    }

    public boolean actualizarLicenciaDeTransito(LicenciaDeTransito obj) {
        try {
            licenciaDeTransitoDao = new LicenciaDeTransitoDao();
            conn = conexion.conectar();
            licenciaDeTransitoDao.save(conn, obj);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            conexion.cerrarCx();
        }
        return true;
    }
    
    public boolean eliminarLicenciaDeTransito(LicenciaDeTransito obj) {
        try {
            licenciaDeTransitoDao = new LicenciaDeTransitoDao();
            conn = conexion.conectar();
            licenciaDeTransitoDao.delete(conn, obj);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            conexion.cerrarCx();
        }
        return true;
    }
}
