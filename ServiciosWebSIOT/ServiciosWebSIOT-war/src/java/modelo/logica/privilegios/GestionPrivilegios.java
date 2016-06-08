package modelo.logica.privilegios;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.privilegios.PrivilegiosDao;
import modelo.datos.objetos.privilegios.Privilegios;

import utilidades.Funciones;


public class GestionPrivilegios {
    Conexion conexion;
    Connection conn;
    String myMotor;

    public GestionPrivilegios() {
        super();
        crearObjetos();
    }
    
    private void crearObjetos(){
        conexion = new Conexion();
        myMotor = Funciones.leer_ini("/WSPIAC.ini", "MOTOR");
    }
	
	/**
     * Inserta nuevo registro en la tabla
     * @param Privilegios obj
     * @return Retorna el mismo objeto pero con la llave primaria configurada
     */
	public Privilegios crearPrivilegios(Privilegios obj) {
		List lista = null;
        try {
            PrivilegiosDao dao = new PrivilegiosDao();
            conn = conexion.conectar();
            int id = Funciones.obtenerId(conn, "GEN_PRIVILEGIOS", "GEN_PRIVILEGIOS", myMotor);
            obj.setID_PRIVILEGIOS(id);
            dao.create(conn, obj);
            //verificar existencia
            obj = new Privilegios();
            obj.setID_PRIVILEGIOS(id);
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Privilegios)lista.get(0);
            }
            else {
                obj.setID_PRIVILEGIOS(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_PRIVILEGIOS(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
	
	/**
     * Edita un registro en la tabla
     * @param Privilegios obj
     * @return boolean indicando si se realizo o no la actualizacion
     */
    public boolean editarPrivilegios(Privilegios obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
            PrivilegiosDao dao = new PrivilegiosDao();
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
     * @param Privilegios obj
     * @return Retorna el mismo objeto pero con los datos consultados
     */
    public Privilegios buscarPrimeroPrivilegios(Privilegios obj) {
        List lista = null;
        try {
            PrivilegiosDao dao = new PrivilegiosDao();
            conn = conexion.conectar();
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Privilegios)lista.get(0);
            }
            else {
		obj.setID_PRIVILEGIOS(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_PRIVILEGIOS(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
    
    /**
     * Busca los registros que coincidan con los datos enviados
     * @param Privilegios obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List buscarPrivilegios(Privilegios obj) {
        List lista = null;
        try {
            PrivilegiosDao dao = new PrivilegiosDao();
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
     * @param Privilegios obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List buscarPrivilegios(Privilegios obj,int pagina, int numRegPagina) {
        List lista = null;
		if(pagina>0&&numRegPagina>0)
		{
			pagina--;
			int limInf =0;
			int limSup =0;
			limInf = pagina*numRegPagina+1;
			limSup = (pagina+1)*numRegPagina;
			try {
				PrivilegiosDao dao = new PrivilegiosDao();
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
     * @param Privilegios obj
     * @return Retorna la lista de los registros en la tabla
     */
    public List listarPrivilegios() {
        List lista = null;
        try {
            PrivilegiosDao dao = new PrivilegiosDao();
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
     * @param Privilegios obj
     * @return Retorna la lista de los registros en la tabla con paginacion
     */
	
	public List listarPrivilegios(int pagina, int numRegPagina) {
        List lista = null;
		if(pagina>0&&numRegPagina>0)
		{
			pagina--;
			int limInf =0;
			int limSup =0;
			limInf = pagina*numRegPagina+1;
			limSup = (pagina+1)*numRegPagina;
			try {
				PrivilegiosDao dao = new PrivilegiosDao();
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
	
	public int contarBusquedaPrivilegios(Privilegios obj) {
		int cantidad=-1;
        try {
            PrivilegiosDao dao = new PrivilegiosDao();
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
     * @param Privilegios obj
     * @return Retorna un boolean indicando si se realizo o no la operacion
     */
    public boolean eliminarPrivilegios(Privilegios obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
            PrivilegiosDao dao = new PrivilegiosDao();
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

