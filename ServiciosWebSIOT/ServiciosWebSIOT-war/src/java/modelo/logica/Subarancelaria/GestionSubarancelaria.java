package modelo.logica.Subarancelaria;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.Subarancelaria.SubarancelariaDao;
import modelo.datos.objetos.Subarancelaria.Subarancelaria;

import utilidades.Funciones;


public class GestionSubarancelaria {
    Conexion conexion;
    Connection conn;
    String myMotor;

    public GestionSubarancelaria() {
        super();
        crearObjetos();
    }
    
    private void crearObjetos(){
        conexion = new Conexion();
        myMotor = Funciones.leer_ini("/WSPIAC.ini", "MOTOR");
    }
	
	/**
     * Inserta nuevo registro en la tabla
     * @param Subarancelaria obj
     * @return Retorna el mismo objeto pero con la llave primaria configurada
     */
	public Subarancelaria crearSubarancelaria(Subarancelaria obj) {
		List lista = null;
        try {
            SubarancelariaDao dao = new SubarancelariaDao();
            conn = conexion.conectar();
            //int id = Funciones.obtenerId(conn, "GEN_SUBARANCELARIA", "GEN_SUBARANCELARIA","SUB_ARANCELARIA", myMotor);
            //obj.setID(id);
            int id = obj.getID();
            dao.create(conn, obj);
            //verificar existencia
            obj = new Subarancelaria();
            obj.setID(id);
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Subarancelaria)lista.get(0);
            }
            else {
                obj.setID(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
	
	/**
     * Edita un registro en la tabla
     * @param Subarancelaria obj
     * @return boolean indicando si se realizo o no la actualizacion
     */
    public boolean editarSubarancelaria(Subarancelaria obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			SubarancelariaDao dao = new SubarancelariaDao();
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
     * @param Subarancelaria obj
     * @return Retorna el mismo objeto pero con los datos consultados
     */
    public Subarancelaria buscarPrimeroSubarancelaria(Subarancelaria obj) {
        List lista = null;
        try {
			SubarancelariaDao dao = new SubarancelariaDao();
            conn = conexion.conectar();
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Subarancelaria)lista.get(0);
            }
            else {
				obj.setID(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
    
    /**
     * Busca los registros que coincidan con los datos enviados
     * @param Subarancelaria obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List buscarSubarancelaria(Subarancelaria obj) {
        List lista = null;
        try {
			SubarancelariaDao dao = new SubarancelariaDao();
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
     * @param Subarancelaria obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List buscarSubarancelaria(Subarancelaria obj,int pagina, int numRegPagina) {
        List lista = null;
		if(pagina>0&&numRegPagina>0)
		{
			pagina--;
			int limInf =0;
			int limSup =0;
			limInf = pagina*numRegPagina+1;
			limSup = (pagina+1)*numRegPagina;
			try {
				SubarancelariaDao dao = new SubarancelariaDao();
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
     * @param Subarancelaria obj
     * @return Retorna la lista de los registros en la tabla
     */
    public List listarSubarancelaria() {
        List lista = null;
        try {
			SubarancelariaDao dao = new SubarancelariaDao();
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
     * @param Subarancelaria obj
     * @return Retorna la lista de los registros en la tabla con paginacion
     */
	
	public List listarSubarancelaria(int pagina, int numRegPagina) {
        List lista = null;
		if(pagina>0&&numRegPagina>0)
		{
			pagina--;
			int limInf =0;
			int limSup =0;
			limInf = pagina*numRegPagina+1;
			limSup = (pagina+1)*numRegPagina;
			try {
				SubarancelariaDao dao = new SubarancelariaDao();
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
	
	public int contarBusquedaSubarancelaria(Subarancelaria obj) {
		int cantidad=-1;
        try {
			SubarancelariaDao dao = new SubarancelariaDao();
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
     * @param Subarancelaria obj
     * @return Retorna un boolean indicando si se realizo o no la operacion
     */
    public boolean eliminarSubarancelaria(Subarancelaria obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			SubarancelariaDao dao = new SubarancelariaDao();
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
