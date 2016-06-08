package modelo.logica.comparendos.liquidacion.detallerecibo;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;


import modelo.datos.dao.comparendos.liquidacion.detallerecibo.DetallereciboDao;

import modelo.datos.objetos.comparendos.liquidacion.detallerecibo.*;

import utilidades.Funciones;


public class GestionDetallerecibo {
    Conexion conexion;
    Connection conn;
    String myMotor;

    public GestionDetallerecibo() {
        super();
        crearObjetos();
    }
    
    private void crearObjetos(){
        conexion = new Conexion();
        myMotor = Funciones.leer_ini("/WSPIAC.ini", "MOTOR");
    }
	
	/**
     * Inserta nuevo registro en la tabla
     * @param Detallerecibo obj
     * @return Retorna el mismo objeto pero con la llave primaria configurada
     */
	public Detallerecibo crearDetallerecibo(Detallerecibo obj) {
		List lista = null;
        try {
            DetallereciboDao dao = new DetallereciboDao();
            conn = conexion.conectarComparendos();
            int id = Funciones.obtenerId(conn, "GEN_DETALLE_RECIBO", "GEN_DETALLE_RECIBO", myMotor);
            obj.setID_DETALLE_RECIBO(id);
            dao.create(conn, obj);
            //verificar existencia
            obj = new Detallerecibo();
            obj.setID_DETALLE_RECIBO(id);
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Detallerecibo)lista.get(0);
            }
            else {
                obj.setID_DETALLE_RECIBO(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_DETALLE_RECIBO(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
	
	/**
     * Edita un registro en la tabla
     * @param Detallerecibo obj
     * @return boolean indicando si se realizo o no la actualizacion
     */
    public boolean editarDetallerecibo(Detallerecibo obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			DetallereciboDao dao = new DetallereciboDao();
            conn = conexion.conectarComparendos();
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
     * @param Detallerecibo obj
     * @return Retorna el mismo objeto pero con los datos consultados
     */
    public Detallerecibo buscarPrimeroDetallerecibo(Detallerecibo obj) {
        List lista = null;
        try {
			DetallereciboDao dao = new DetallereciboDao();
            conn = conexion.conectarComparendos();
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Detallerecibo)lista.get(0);
            }
            else {
				obj.setID_DETALLE_RECIBO(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_DETALLE_RECIBO(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
    
    /**
     * Busca los registros que coincidan con los datos enviados
     * @param Detallerecibo obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List buscarDetallerecibo(Detallerecibo obj) {
        List lista = null;
        try {
			DetallereciboDao dao = new DetallereciboDao();
            conn = conexion.conectarComparendos();
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
     * @param Detallerecibo obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List buscarDetallerecibo(Detallerecibo obj,int pagina, int numRegPagina) {
        List lista = null;
		if(pagina>0&&numRegPagina>0)
		{
			pagina--;
			int limInf =0;
			int limSup =0;
			limInf = pagina*numRegPagina+1;
			limSup = (pagina+1)*numRegPagina;
			try {
				DetallereciboDao dao = new DetallereciboDao();
				conn = conexion.conectarComparendos();
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
     * @param Detallerecibo obj
     * @return Retorna la lista de los registros en la tabla
     */
    public List listarDetallerecibo() {
        List lista = null;
        try {
			DetallereciboDao dao = new DetallereciboDao();
            conn = conexion.conectarComparendos();
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
     * @param Detallerecibo obj
     * @return Retorna la lista de los registros en la tabla con paginacion
     */
	
	public List listarDetallerecibo(int pagina, int numRegPagina) {
        List lista = null;
		if(pagina>0&&numRegPagina>0)
		{
			pagina--;
			int limInf =0;
			int limSup =0;
			limInf = pagina*numRegPagina+1;
			limSup = (pagina+1)*numRegPagina;
			try {
				DetallereciboDao dao = new DetallereciboDao();
				conn = conexion.conectarComparendos();
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
	
	public int contarBusquedaDetallerecibo(Detallerecibo obj) {
		int cantidad=-1;
        try {
			DetallereciboDao dao = new DetallereciboDao();
            conn = conexion.conectarComparendos();
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
     * @param Detallerecibo obj
     * @return Retorna un boolean indicando si se realizo o no la operacion
     */
    public boolean eliminarDetallerecibo(Detallerecibo obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			DetallereciboDao dao = new DetallereciboDao();
            conn = conexion.conectarComparendos();
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

