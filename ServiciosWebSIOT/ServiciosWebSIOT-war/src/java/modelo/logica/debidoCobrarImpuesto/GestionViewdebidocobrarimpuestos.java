package modelo.logica.debidoCobrarImpuesto;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.debidoCobrarImpuesto.ViewdebidocobrarimpuestosDao;
import modelo.datos.objetos.debidoCobrarImpuesto.Viewdebidocobrarimpuestos;

import utilidades.Funciones;


public class GestionViewdebidocobrarimpuestos {
    Conexion conexion;
    Connection conn;
    String myMotor;

    public GestionViewdebidocobrarimpuestos() {
        super();
        crearObjetos();
    }
    
    private void crearObjetos(){
        conexion = new Conexion();
        myMotor = Funciones.leer_ini("/WSPIAC.ini", "MOTOR");
    }
	
	/**
     * Inserta nuevo registro en la tabla
     * @param Viewdebidocobrarimpuestos obj
     * @return Retorna el mismo objeto pero con la llave primaria configurada
     */
	public Viewdebidocobrarimpuestos crearViewdebidocobrarimpuestos(Viewdebidocobrarimpuestos obj) {
		List lista = null;
        try {
            ViewdebidocobrarimpuestosDao dao = new ViewdebidocobrarimpuestosDao();
            conn = conexion.conectar();
            int id = Funciones.obtenerId(conn, "GEN_VIEWDEBIDOCOBRARIMPUESTOS", "GEN_VIEWDEBIDOCOBRARIMPUESTOS", myMotor);
            obj.setID(id);
            dao.create(conn, obj);
            //verificar existencia
            obj = new Viewdebidocobrarimpuestos();
            obj.setID(id);
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Viewdebidocobrarimpuestos)lista.get(0);
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
     * @param Viewdebidocobrarimpuestos obj
     * @return boolean indicando si se realizo o no la actualizacion
     */
    public boolean editarViewdebidocobrarimpuestos(Viewdebidocobrarimpuestos obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			ViewdebidocobrarimpuestosDao dao = new ViewdebidocobrarimpuestosDao();
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
     * @param Viewdebidocobrarimpuestos obj
     * @return Retorna el mismo objeto pero con los datos consultados
     */
    public Viewdebidocobrarimpuestos buscarPrimeroViewdebidocobrarimpuestos(Viewdebidocobrarimpuestos obj) {
        List lista = null;
        try {
			ViewdebidocobrarimpuestosDao dao = new ViewdebidocobrarimpuestosDao();
            conn = conexion.conectar();
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Viewdebidocobrarimpuestos)lista.get(0);
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
     * @param Viewdebidocobrarimpuestos obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List buscarViewdebidocobrarimpuestos(Viewdebidocobrarimpuestos obj) {
        List lista = null;
        try {
			ViewdebidocobrarimpuestosDao dao = new ViewdebidocobrarimpuestosDao();
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
     * @param Viewdebidocobrarimpuestos obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List buscarViewdebidocobrarimpuestos(Viewdebidocobrarimpuestos obj,int pagina, int numRegPagina) {
        List lista = null;
		if(pagina>0&&numRegPagina>0)
		{
			pagina--;
			int limInf =0;
			int limSup =0;
			limInf = pagina*numRegPagina+1;
			limSup = (pagina+1)*numRegPagina;
			try {
				ViewdebidocobrarimpuestosDao dao = new ViewdebidocobrarimpuestosDao();
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
     * @param Viewdebidocobrarimpuestos obj
     * @return Retorna la lista de los registros en la tabla
     */
    public List listarViewdebidocobrarimpuestos() {
        List lista = null;
        try {
			ViewdebidocobrarimpuestosDao dao = new ViewdebidocobrarimpuestosDao();
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
     * @param Viewdebidocobrarimpuestos obj
     * @return Retorna la lista de los registros en la tabla con paginacion
     */
	
	public List listarViewdebidocobrarimpuestos(int pagina, int numRegPagina) {
        List lista = null;
		if(pagina>0&&numRegPagina>0)
		{
			pagina--;
			int limInf =0;
			int limSup =0;
			limInf = pagina*numRegPagina+1;
			limSup = (pagina+1)*numRegPagina;
			try {
				ViewdebidocobrarimpuestosDao dao = new ViewdebidocobrarimpuestosDao();
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
	
	public int contarBusquedaViewdebidocobrarimpuestos(Viewdebidocobrarimpuestos obj) {
		int cantidad=-1;
        try {
			ViewdebidocobrarimpuestosDao dao = new ViewdebidocobrarimpuestosDao();
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
     * @param Viewdebidocobrarimpuestos obj
     * @return Retorna un boolean indicando si se realizo o no la operacion
     */
    public boolean eliminarViewdebidocobrarimpuestos(Viewdebidocobrarimpuestos obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			ViewdebidocobrarimpuestosDao dao = new ViewdebidocobrarimpuestosDao();
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

