package modelo.logica.reportes;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.reportes.ReportevehiculosDao;
import modelo.datos.objetos.reportes.Reportevehiculos;

import utilidades.Funciones;


public class GestionReportevehiculos {
    Conexion conexion;
    Connection conn;
    String myMotor;

    public GestionReportevehiculos() {
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
     * @param Reportevehiculos obj
     * @return Retorna el mismo objeto pero con la llave primaria configurada
     */
	public Reportevehiculos crear(Reportevehiculos obj) {
        try {
            ReportevehiculosDao dao = new ReportevehiculosDao();
            conn = conexion.conectar();
            int id = Funciones.obtenerId(conn, "GEN_REPORTEVEHICULOS", "GEN_REPORTEVEHICULOS", myMotor);
            obj.setID_VEHICULO(id);
            dao.create(conn, obj);
            //verificar existencia
            obj = new Reportevehiculos();
            obj.setID_VEHICULO(id);
            List objs = dao.searchMatching(conn, obj);
            if (objs != null && objs.size() > 0) {
                obj = (Reportevehiculos)objs.get(0);
            }
            else {
                obj.setID_VEHICULO(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_VEHICULO(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
	
	/**
     * Edita un registro en la tabla
     * @param Reportevehiculos obj
     * @return boolean indicando si se realizo o no la actualizacion
     */
    public boolean editar(Reportevehiculos obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			ReportevehiculosDao dao = new ReportevehiculosDao();
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
     * @param Reportevehiculos obj
     * @return Retorna el mismo objeto pero con los datos consultados
     */
    public Reportevehiculos getOne(Reportevehiculos obj) {
        List lista = null;
        try {
			ReportevehiculosDao dao = new ReportevehiculosDao();
            conn = conexion.conectar();
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Reportevehiculos)lista.get(0);
            }
            else {
				obj.setID_VEHICULO(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_VEHICULO(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
    
    /**
     * Busca los registros que coincidan con los datos enviados
     * @param Reportevehiculos obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List get(Reportevehiculos obj) {
        List lista = null;
        try {
			ReportevehiculosDao dao = new ReportevehiculosDao();
            conn = conexion.conectar();
            lista = dao.searchMatching(conn, obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
    public List get(Reportevehiculos obj, String cilindrajeMin, String cilindrajeMax) {
        List lista = null;
        try {
			ReportevehiculosDao dao = new ReportevehiculosDao();
            conn = conexion.conectar();
            lista = dao.searchMatchingCilindraje(conn, obj, cilindrajeMin, cilindrajeMax);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
    /**
     * Consulta todos los registros de la tabla
     * @param Reportevehiculos obj
     * @return Retorna la lista de los registros en la tabla
     */
    public List listar() {
        List lista = null;
        try {
			ReportevehiculosDao dao = new ReportevehiculosDao();
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
     * @param Reportevehiculos obj
     * @return Retorna un boolean indicando si se realizo o no la operacion
     */
    public boolean eliminar(Reportevehiculos obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			ReportevehiculosDao dao = new ReportevehiculosDao();
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

