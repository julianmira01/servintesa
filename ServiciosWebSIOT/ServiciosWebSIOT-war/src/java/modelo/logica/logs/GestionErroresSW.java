package modelo.logica.logs;



import modelo.datos.objetos.logs.*;
import modelo.datos.dao.logs.*;

import java.sql.Connection;
import java.util.List;
import modelo.conexion.Conexion;

import utilidades.Funciones;


public class GestionErroresSW {
    Conexion conexion;
    Connection conn;
    String myMotor;

    public GestionErroresSW() {
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
	public ErroresSW crearErroresSW(ErroresSW obj) {
		List lista = null;
        try {
            ErroresSWDao dao = new ErroresSWDao();
            conn = conexion.conectar();
            int id = 1;
            //if(myMotor.equals("ORACLE"))
            //{
              id = Funciones.obtenerId(conn, "GEN_ERRORES_SW", "GEN_ERRORES_SW", myMotor);    
            //}
                                    
            obj.setID_ERRORES_SW(id);           
            dao.create(conn, obj);
            //verificar existencia
            obj = new ErroresSW();
            obj.setID_ERRORES_SW(id);
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (ErroresSW)lista.get(0);
            }
            else {
                obj.setID_ERRORES_SW(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_ERRORES_SW(-1);
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
    public ErroresSW editarErroresSW(ErroresSW obj) {
        int id = 0;
        try {
			ErroresSWDao dao = new ErroresSWDao();
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
    public ErroresSW buscarPrimeroLog(ErroresSW obj) {
        List lista = null;
        try {
			ErroresSWDao dao = new ErroresSWDao();
            conn = conexion.conectar();
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (ErroresSW)lista.get(0);
            }
            else {
				obj.setID_ERRORES_SW(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_ERRORES_SW(-1);
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
    public List buscarErroresSW(ErroresSW obj) {
        List lista = null;
        try {
            ErroresSWDao dao = new ErroresSWDao();
            
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
     * @param Auditoriatramite obj
     * @return Retorna la lista de los registros en la tabla
     */
    public List listarErroresSW() {
        List lista = null;
        try {
			ErroresSWDao dao = new ErroresSWDao();
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
    public boolean eliminarErroresSW(ErroresSW obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			ErroresSWDao dao = new ErroresSWDao();
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

