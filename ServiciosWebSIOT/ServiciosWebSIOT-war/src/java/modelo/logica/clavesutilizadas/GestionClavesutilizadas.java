package modelo.logica.clavesutilizadas;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.clavesutilizadas.*;
import modelo.datos.objetos.clavesutilizadas.Clavesutilizadas;

import utilidades.Funciones;
import utilidades.Seguridad;


public class GestionClavesutilizadas {
    Conexion conexion;
    Connection conn;
    String myMotor;

    public GestionClavesutilizadas() {
        super();
        crearObjetos();
    }
    
    private void crearObjetos(){
        conexion = new Conexion();
        myMotor = Funciones.leer_ini("/WSPIAC.ini", "MOTOR");
    }
	
	/**
     * Inserta nuevo registro en la tabla
     * @param Clavesutilizadas obj
     * @return Retorna el mismo objeto pero con la llave primaria configurada
     */
	public Clavesutilizadas crearClavesutilizadas(Clavesutilizadas obj) {
		List lista = null;
        try {
            ClavesutilizadasDao dao = new ClavesutilizadasDao();
            conn = conexion.conectar();
            int id = Funciones.obtenerId(conn, "GEN_CLAVES_UTILIZADAS", "GEN_CLAVES_UTILIZADAS", myMotor);
            obj.setID_CLAVES_UTILIZADAS(id);
            dao.create(conn, obj);
            //verificar existencia
            obj = new Clavesutilizadas();
            obj.setID_CLAVES_UTILIZADAS(id);
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Clavesutilizadas)lista.get(0);
            }
            else {
                obj.setID_CLAVES_UTILIZADAS(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_CLAVES_UTILIZADAS(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
	
	/**
     * Edita un registro en la tabla
     * @param Clavesutilizadas obj
     * @return boolean indicando si se realizo o no la actualizacion
     */
    public boolean editarClavesutilizadas(Clavesutilizadas obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			ClavesutilizadasDao dao = new ClavesutilizadasDao();
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
     * @param Clavesutilizadas obj
     * @return Retorna el mismo objeto pero con los datos consultados
     */
    public Clavesutilizadas buscarPrimeroClavesutilizadas(Clavesutilizadas obj) {
        List lista = null;
        try {
			ClavesutilizadasDao dao = new ClavesutilizadasDao();
            conn = conexion.conectar();
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Clavesutilizadas)lista.get(0);
            }
            else {
				obj.setID_CLAVES_UTILIZADAS(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_CLAVES_UTILIZADAS(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
    
    /**
     * Busca los registros que coincidan con los datos enviados
     * @param Clavesutilizadas obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List buscarClavesutilizadas(Clavesutilizadas obj) {
        List lista = null;
        try {
			ClavesutilizadasDao dao = new ClavesutilizadasDao();
            conn = conexion.conectar();
            obj.setCLAVE(Seguridad.getHash(obj.getCLAVE()));
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
     * @param Clavesutilizadas obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List buscarClavesutilizadas(Clavesutilizadas obj,int pagina, int numRegPagina) {
        List lista = null;
		if(pagina>0&&numRegPagina>0)
		{
			pagina--;
			int limInf =0;
			int limSup =0;
			limInf = pagina*numRegPagina+1;
			limSup = (pagina+1)*numRegPagina;
			try {
				ClavesutilizadasDao dao = new ClavesutilizadasDao();
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
     * @param Clavesutilizadas obj
     * @return Retorna la lista de los registros en la tabla
     */
    public List listarClavesutilizadas() {
        List lista = null;
        try {
			ClavesutilizadasDao dao = new ClavesutilizadasDao();
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
     * @param Clavesutilizadas obj
     * @return Retorna la lista de los registros en la tabla con paginacion
     */
	
	public List listarClavesutilizadas(int pagina, int numRegPagina) {
        List lista = null;
		if(pagina>0&&numRegPagina>0)
		{
			pagina--;
			int limInf =0;
			int limSup =0;
			limInf = pagina*numRegPagina+1;
			limSup = (pagina+1)*numRegPagina;
			try {
				ClavesutilizadasDao dao = new ClavesutilizadasDao();
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
	
	public int contarBusquedaClavesutilizadas(Clavesutilizadas obj) {
		int cantidad=-1;
        try {
			ClavesutilizadasDao dao = new ClavesutilizadasDao();
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
     * @param Clavesutilizadas obj
     * @return Retorna un boolean indicando si se realizo o no la operacion
     */
    public boolean eliminarClavesutilizadas(Clavesutilizadas obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			ClavesutilizadasDao dao = new ClavesutilizadasDao();
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

