package modelo.logica.liquidador;

import java.sql.Connection;
import java.sql.SQLException;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.liquidador.FechaimpuestoDao;
import modelo.datos.objetos.liquidador.Fechaimpuesto;

import utilidades.Funciones;


public class GestionFechaimpuesto {
    Conexion conexion;
    Conexion conexionComp;
    Connection conn;
    Connection connComp;
    String myMotor;

    public GestionFechaimpuesto() {
        super();
        crearObjetos();
    }
    
    private void crearObjetos(){
        conexion = new Conexion();
        conexionComp = new Conexion();
        myMotor = Funciones.leer_ini("/WSTransitoArmeniaContravencional.ini", "MOTOR");
    }
	
	/**
     * Inserta nuevo registro en la tabla
     * @param Fechaimpuesto obj
     * @return Retorna el mismo objeto pero con la llave primaria configurada
     */
	public Fechaimpuesto crearFechaimpuesto(Fechaimpuesto obj) {
		List lista = null;
        try {
            FechaimpuestoDao dao = new FechaimpuestoDao();
            conn = conexion.conectar();
            int id = Funciones.obtenerId(conn, "GEN_FECHAIMPUESTO", "GEN_FECHAIMPUESTO", myMotor);
            obj.setID_FECHAIMPUESTO(id);
            dao.create(conn, obj);
            //verificar existencia
            obj = new Fechaimpuesto();
            obj.setID_FECHAIMPUESTO(id);
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Fechaimpuesto)lista.get(0);
            }
            else {
                obj.setID_FECHAIMPUESTO(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_FECHAIMPUESTO(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
	
	/**
     * Edita un registro en la tabla
     * @param Fechaimpuesto obj
     * @return boolean indicando si se realizo o no la actualizacion
     */
    public boolean editarFechaimpuesto(Fechaimpuesto obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			FechaimpuestoDao dao = new FechaimpuestoDao();
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
     * @param Fechaimpuesto obj
     * @return Retorna el mismo objeto pero con los datos consultados
     */
    public Fechaimpuesto buscarPrimeroFechaimpuesto(Fechaimpuesto obj) {
        List lista = null;
        try {
            FechaimpuestoDao dao = new FechaimpuestoDao();
            conn = conexion.conectar();
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Fechaimpuesto)lista.get(0);
            }
            else {
				obj.setID_FECHAIMPUESTO(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_FECHAIMPUESTO(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
    
    /**
     * Busca los registros que coincidan con los datos enviados
     * @param Fechaimpuesto obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List buscarFechaimpuesto(Fechaimpuesto obj) {
        List lista = null;
        try {
			FechaimpuestoDao dao = new FechaimpuestoDao();
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
     * @param Fechaimpuesto obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List buscarFechaimpuesto(Fechaimpuesto obj,int pagina, int numRegPagina) {
        List lista = null;
		if(pagina>0&&numRegPagina>0)
		{
			pagina--;
			int limInf =0;
			int limSup =0;
			limInf = pagina*numRegPagina+1;
			limSup = (pagina+1)*numRegPagina;
			try {
				FechaimpuestoDao dao = new FechaimpuestoDao();
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
     * @param Fechaimpuesto obj
     * @return Retorna la lista de los registros en la tabla
     */
    public List listarFechaimpuesto() {
        List lista = null;
        try {
			FechaimpuestoDao dao = new FechaimpuestoDao();
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
     * @param Fechaimpuesto obj
     * @return Retorna la lista de los registros en la tabla con paginacion
     */
	
	public List listarFechaimpuesto(int pagina, int numRegPagina) {
        List lista = null;
		if(pagina>0&&numRegPagina>0)
		{
			pagina--;
			int limInf =0;
			int limSup =0;
			limInf = pagina*numRegPagina+1;
			limSup = (pagina+1)*numRegPagina;
			try {
				FechaimpuestoDao dao = new FechaimpuestoDao();
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
	
	public int contarBusquedaFechaimpuesto(Fechaimpuesto obj) {
		int cantidad=-1;
        try {
			FechaimpuestoDao dao = new FechaimpuestoDao();
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
     * @param Fechaimpuesto obj
     * @return Retorna un boolean indicando si se realizo o no la operacion
     */
    public boolean eliminarFechaimpuesto(Fechaimpuesto obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			FechaimpuestoDao dao = new FechaimpuestoDao();
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

