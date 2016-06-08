package modelo.logica.tramites;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.tramites.RuntpersonaapoderadoDao;
import modelo.datos.objetos.tramites.Runtpersonaapoderado;

import utilidades.Funciones;


public class GestionRuntpersonaapoderado {
    Conexion conexion;
    Connection conn;
    String myMotor;

    public GestionRuntpersonaapoderado() {
        super();
        crearObjetos();
    }
    
    private void crearObjetos(){
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
     * Inserta nuevo registro en la tabla
     * @param Runtpersonaapoderado obj
     * @return Retorna el mismo objeto pero con la llave primaria configurada
     */
	public Runtpersonaapoderado crearRuntpersonaapoderado(Runtpersonaapoderado obj) {
		List lista = null;
        try {
            RuntpersonaapoderadoDao dao = new RuntpersonaapoderadoDao();
            conn = conexion.conectar();
            int id = Funciones.obtenerId(conn, "GEN_RUNTPERSONAAPODERADO", "GEN_RUNTPERSONAAPODERADO", myMotor);
            obj.setID_PERSONAAPODERADO(id);
            dao.create(conn, obj);
            //verificar existencia
            obj = new Runtpersonaapoderado();
            obj.setID_PERSONAAPODERADO(id);
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Runtpersonaapoderado)lista.get(0);
            }
            else {
                obj.setID_PERSONAAPODERADO(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_PERSONAAPODERADO(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
	
	/**
     * Edita un registro en la tabla
     * @param Runtpersonaapoderado obj
     * @return boolean indicando si se realizo o no la actualizacion
     */
    public boolean editarRuntpersonaapoderado(Runtpersonaapoderado obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			RuntpersonaapoderadoDao dao = new RuntpersonaapoderadoDao();
            conn = conexion.conectar();
            dao.save(conn, obj);
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }
    
    /**
     * Busca el primer registro que coincida con los datos enviados
     * @param Runtpersonaapoderado obj
     * @return Retorna el mismo objeto pero con los datos consultados
     */
    public Runtpersonaapoderado buscarPrimeroRuntpersonaapoderado(Runtpersonaapoderado obj) {
        List lista = null;
        try {
			RuntpersonaapoderadoDao dao = new RuntpersonaapoderadoDao();
            conn = conexion.conectar();
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Runtpersonaapoderado)lista.get(0);
            }
            else {
				obj.setID_PERSONAAPODERADO(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_PERSONAAPODERADO(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
    
    /**
     * Busca los registros que coincidan con los datos enviados
     * @param Runtpersonaapoderado obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List buscarRuntpersonaapoderado(Runtpersonaapoderado obj) {
        List lista = null;
        try {
			RuntpersonaapoderadoDao dao = new RuntpersonaapoderadoDao();
            conn = conexion.conectar();
            lista = dao.searchMatching(conn, obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
    /**
     * Consulta todos los registros de la tabla
     * @param Runtpersonaapoderado obj
     * @return Retorna la lista de los registros en la tabla
     */
    public List listarRuntpersonaapoderado() {
        List lista = null;
        try {
			RuntpersonaapoderadoDao dao = new RuntpersonaapoderadoDao();
            conn = conexion.conectar();
            lista = dao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
    /**
     * Elimina un registro de la tabla
     * @param Runtpersonaapoderado obj
     * @return Retorna un boolean indicando si se realizo o no la operacion
     */
    public boolean eliminarRuntpersonaapoderado(Runtpersonaapoderado obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			RuntpersonaapoderadoDao dao = new RuntpersonaapoderadoDao();
            conn = conexion.conectar();
            dao.delete(conn, obj);
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }

}

