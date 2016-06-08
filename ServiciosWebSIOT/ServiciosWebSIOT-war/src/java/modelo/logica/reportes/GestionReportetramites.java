package modelo.logica.reportes;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.reportes.ReportetramitesDao;
import modelo.datos.objetos.reportes.Reportetramites;

import utilidades.Funciones;


public class GestionReportetramites {
    Conexion conexion;
    Connection conn;
    String myMotor;

    public GestionReportetramites() {
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
     * @param Reportetramites obj
     * @return Retorna el mismo objeto pero con la llave primaria configurada
     */
	public Reportetramites crear(Reportetramites obj) {
        try {
            ReportetramitesDao dao = new ReportetramitesDao();
            conn = conexion.conectar();
            int id = Funciones.obtenerId(conn, "GEN_REPORTETRAMITES", "GEN_REPORTETRAMITES", myMotor);
            obj.setID_FACTURA(id);
            dao.create(conn, obj);
            //verificar existencia
            obj = new Reportetramites();
            obj.setID_FACTURA(id);
            List objs = dao.searchMatching(conn, obj, null, null, null, null);
            if (objs != null && objs.size() > 0) {
                obj = (Reportetramites)objs.get(0);
            }
            else {
                obj.setID_FACTURA(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_FACTURA(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
	
	/**
     * Edita un registro en la tabla
     * @param Reportetramites obj
     * @return boolean indicando si se realizo o no la actualizacion
     */
    public boolean editar(Reportetramites obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			ReportetramitesDao dao = new ReportetramitesDao();
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
     * @param Reportetramites obj
     * @return Retorna el mismo objeto pero con los datos consultados
     */
    public Reportetramites getOne(Reportetramites obj, String fechaTramiteIni,
                               String fechaTramiteFin, String fechaPagoIni, String fechaPagoFin) {
        List lista = null;
        try {
			ReportetramitesDao dao = new ReportetramitesDao();
            conn = conexion.conectar();
            lista = dao.searchMatching(conn, obj, fechaTramiteIni,
                               fechaTramiteFin, fechaPagoIni, fechaPagoFin);
            if (lista != null && lista.size() > 0) {
                obj = (Reportetramites)lista.get(0);
            }
            else {
				obj.setID_FACTURA(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_FACTURA(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
    
    /**
     * Busca los registros que coincidan con los datos enviados
     * @param Reportetramites obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List get(Reportetramites obj, String fechaTramiteIni,
                               String fechaTramiteFin, String fechaPagoIni, String fechaPagoFin) {
        List lista = null;
        try {
			ReportetramitesDao dao = new ReportetramitesDao();
            conn = conexion.conectar();
            lista = dao.searchMatching(conn, obj, fechaTramiteIni,
                               fechaTramiteFin, fechaPagoIni, fechaPagoFin);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
    /**
     * Consulta todos los registros de la tabla
     * @param Reportetramites obj
     * @return Retorna la lista de los registros en la tabla
     */
    public List listar() {
        List lista = null;
        try {
			ReportetramitesDao dao = new ReportetramitesDao();
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
     * @param Reportetramites obj
     * @return Retorna un boolean indicando si se realizo o no la operacion
     */
    public boolean eliminar(Reportetramites obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			ReportetramitesDao dao = new ReportetramitesDao();
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

