package modelo.logica.logs;



import modelo.datos.objetos.logs.*;
import modelo.datos.dao.logs.*;

import java.sql.Connection;
import java.util.List;
import modelo.conexion.Conexion;

import utilidades.Funciones;


public class GestionLogs {
    Conexion conexion;
    Connection conn;
    String myMotor;

    public GestionLogs() {
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
     * @param Auditoriatramite obj
     * @return Retorna el mismo objeto pero con la llave primaria configurada
     */
	public LOGS crearLog(LOGS obj) {
		List lista = null;
        try {
            LOGSDao dao = new LOGSDao();
            conn = conexion.conectar();
            int id = 1;
            //if(myMotor.equals("ORACLE"))
            //{
              id = Funciones.obtenerId(conn, "GEN_LOGS", "GEN_LOGS", myMotor);    
            //}
                                    
            obj.setID_LOGS(id);           
            dao.create(conn, obj);
            //verificar existencia
            obj = new LOGS();
            obj.setID_LOGS(id);
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (LOGS)lista.get(0);
            }
            else {
                obj.setID_LOGS(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_LOGS(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
	
	/**
     * Edita un registro en la tabla
     * @param Auditoriatramite obj
     * @return boolean indicando si se realizo o no la actualizacion
     */
    public LOGS editarLog(LOGS obj) {
        int id = 0;
        try {
			LOGSDao dao = new LOGSDao();
            conn = conexion.conectar();
            dao.save(conn, obj);
            
        } catch (Exception e) {
            e.printStackTrace();
            obj = null;
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
    
    /**
     * Busca el primer registro que coincida con los datos enviados
     * @param Auditoriatramite obj
     * @return Retorna el mismo objeto pero con los datos consultados
     */
    public LOGS buscarPrimeroLog(LOGS obj) {
        List lista = null;
        try {
			LOGSDao dao = new LOGSDao();
            conn = conexion.conectar();
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (LOGS)lista.get(0);
            }
            else {
				obj.setID_LOGS(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_LOGS(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
    
    /**
     * Busca los registros que coincidan con los datos enviados
     * @param Auditoriatramite obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List buscarLOGS(LOGS obj) {
        List lista = null;
        try {
            LOGSDao dao = new LOGSDao();
            
            conn = conexion.conectar();
            lista = dao.searchMatching(conn, obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
    public List buscarLogsRangoFecha(LOGS obj,String fechaFinal) {
        List lista = null;
        try {
            LOGSDao dao = new LOGSDao();
            
            conn = conexion.conectar();
            lista = dao.searchMatchingRangoFecha(conn, obj,fechaFinal);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    
    /**
     * Consulta todos los registros de la tabla
     * @param Auditoriatramite obj
     * @return Retorna la lista de los registros en la tabla
     */
    public List listarLOGS() {
        List lista = null;
        try {
			LOGSDao dao = new LOGSDao();
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
     * @param Auditoriatramite obj
     * @return Retorna un boolean indicando si se realizo o no la operacion
     */
    public boolean eliminarLOGS(LOGS obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			LOGSDao dao = new LOGSDao();
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

