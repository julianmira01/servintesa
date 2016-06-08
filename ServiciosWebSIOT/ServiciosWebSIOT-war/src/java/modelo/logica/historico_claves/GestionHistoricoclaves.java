package modelo.logica.historico_claves;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.historico_claves.HistoricoclavesDao;
import modelo.datos.objetos.historico_claves.Historicoclaves;

import utilidades.Funciones;


public class GestionHistoricoclaves {
    Conexion conexion;
    Connection conn;
    String myMotor;

    public GestionHistoricoclaves() {
        super();
        crearObjetos();
    }
    
    private void crearObjetos(){
        conexion = new Conexion();
        myMotor = Funciones.leer_ini("/WSPIAC.ini", "MOTOR");
    }
	
	/**
     * Inserta nuevo registro en la tabla
     * @param Historicoclaves obj
     * @return Retorna el mismo objeto pero con la llave primaria configurada
     */
	public Historicoclaves crearHistoricoclaves(Historicoclaves obj) {
		List lista = null;
        try {
            HistoricoclavesDao dao = new HistoricoclavesDao();
            conn = conexion.conectar();
            int id = Funciones.obtenerId(conn, "GEN_HISTORICO_CLAVES", "GEN_HISTORICO_CLAVES", myMotor);
            obj.setID_HISTORICO_CLAVES(id);
            dao.create(conn, obj);
            //verificar existencia
            obj = new Historicoclaves();
            obj.setID_HISTORICO_CLAVES(id);
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Historicoclaves)lista.get(0);
            }
            else {
                obj.setID_HISTORICO_CLAVES(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_HISTORICO_CLAVES(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
	
	/**
     * Edita un registro en la tabla
     * @param Historicoclaves obj
     * @return boolean indicando si se realizo o no la actualizacion
     */
    public boolean editarHistoricoclaves(Historicoclaves obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			HistoricoclavesDao dao = new HistoricoclavesDao();
            conn = conexion.conectar();
            if(obj.getID_HISTORICO_CLAVES() > 0)
                dao.save(conn, obj);
            else
            {
                obj.setID_HISTORICO_CLAVES(Funciones.obtenerId(conn, "GEN_HISTORICO_CLAVES", "GEN_HISTORICO_CLAVES", myMotor));
                dao.create(conn, obj);
            }
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
     * @param Historicoclaves obj
     * @return Retorna el mismo objeto pero con los datos consultados
     */
    public Historicoclaves buscarPrimeroHistoricoclaves(Historicoclaves obj) {
        List lista = null;
        try {
			HistoricoclavesDao dao = new HistoricoclavesDao();
            conn = conexion.conectar();
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Historicoclaves)lista.get(0);
            }
            else {
				obj.setID_HISTORICO_CLAVES(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_HISTORICO_CLAVES(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
    
    /**
     * Busca los registros que coincidan con los datos enviados
     * @param Historicoclaves obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List buscarHistoricoclaves(Historicoclaves obj) {
        List lista = null;
        try {
			HistoricoclavesDao dao = new HistoricoclavesDao();
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
     * Busca los registros que coincidan con los datos enviados
     * @param Historicoclaves obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List buscarHistoricoclaves(Historicoclaves obj,int pagina, int numRegPagina) {
        List lista = null;
		if(pagina>0&&numRegPagina>0)
		{
			pagina--;
			int limInf =0;
			int limSup =0;
			limInf = pagina*numRegPagina+1;
			limSup = (pagina+1)*numRegPagina;
			try {
				HistoricoclavesDao dao = new HistoricoclavesDao();
				conn = conexion.conectar();
				lista = dao.searchMatching(conn, obj,limInf,limSup);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				conexion.cerrarCx();
			}
		}
        return lista;
    }
    
    /**
     * Consulta todos los registros de la tabla
     * @param Historicoclaves obj
     * @return Retorna la lista de los registros en la tabla
     */
    public List listarHistoricoclaves() {
        List lista = null;
        try {
			HistoricoclavesDao dao = new HistoricoclavesDao();
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
     * Consulta todos los registros de la tabla pero con Paginacion
     * @param Historicoclaves obj
     * @return Retorna la lista de los registros en la tabla con paginacion
     */
	
	public List listarHistoricoclaves(int pagina, int numRegPagina) {
        List lista = null;
		if(pagina>0&&numRegPagina>0)
		{
			pagina--;
			int limInf =0;
			int limSup =0;
			limInf = pagina*numRegPagina+1;
			limSup = (pagina+1)*numRegPagina;
			try {
				HistoricoclavesDao dao = new HistoricoclavesDao();
				conn = conexion.conectar();
				if(limInf<=dao.countAll(conn))
					lista = dao.loadAll(conn,limInf,limSup);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				conexion.cerrarCx();
			}
		}
        return lista;
    }
	
	public int contarBusquedaHistoricoclaves(Historicoclaves obj) {
		int cantidad=-1;
        try {
			HistoricoclavesDao dao = new HistoricoclavesDao();
            conn = conexion.conectar();
            cantidad = dao.countSearchMatching(conn, obj);
        } catch (Exception e) {
            e.printStackTrace();
			cantidad=-1;
        } finally {
            conexion.cerrarCx();
        }
        return cantidad;
    }
	
    /**
     * Elimina un registro de la tabla
     * @param Historicoclaves obj
     * @return Retorna un boolean indicando si se realizo o no la operacion
     */
    public boolean eliminarHistoricoclaves(Historicoclaves obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			HistoricoclavesDao dao = new HistoricoclavesDao();
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

