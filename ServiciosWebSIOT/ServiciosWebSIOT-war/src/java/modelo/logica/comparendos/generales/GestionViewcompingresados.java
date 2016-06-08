package modelo.logica.comparendos.generales;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.comparendos.generales.ViewcompingresadosDao;

import modelo.datos.objetos.comparendos.generales.Viewcompingresados;

import utilidades.Funciones;


public class GestionViewcompingresados {
    Conexion conexion;
    Connection conn;
    String myMotor;

    public GestionViewcompingresados() {
        super();
        crearObjetos();
    }
    
    private void crearObjetos(){
        conexion = new Conexion();
        myMotor = Funciones.leer_ini("/WSPIAC.ini", "MOTOR");
    }
	
	/**
     * Inserta nuevo registro en la tabla
     * @param Viewcompingresados obj
     * @return Retorna el mismo objeto pero con la llave primaria configurada
     */
	public Viewcompingresados crearViewcompingresados(Viewcompingresados obj) {
		List lista = null;
        try {
            ViewcompingresadosDao dao = new ViewcompingresadosDao();
            conn = conexion.conectar();
            int id = Funciones.obtenerId(conn, "GEN_VIEWCOMPINGRESADOS", "GEN_VIEWCOMPINGRESADOS", myMotor);
            obj.setID_COMPARENDO(id);
            dao.create(conn, obj);
            //verificar existencia
            obj = new Viewcompingresados();
            obj.setID_COMPARENDO(id);
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Viewcompingresados)lista.get(0);
            }
            else {
                obj.setID_COMPARENDO(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_COMPARENDO(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
	
	/**
     * Edita un registro en la tabla
     * @param Viewcompingresados obj
     * @return boolean indicando si se realizo o no la actualizacion
     */
    public boolean editarViewcompingresados(Viewcompingresados obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			ViewcompingresadosDao dao = new ViewcompingresadosDao();
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
     * @param Viewcompingresados obj
     * @return Retorna el mismo objeto pero con los datos consultados
     */
    public Viewcompingresados buscarPrimeroViewcompingresados(Viewcompingresados obj) {
        List lista = null;
        try {
			ViewcompingresadosDao dao = new ViewcompingresadosDao();
            conn = conexion.conectar();
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Viewcompingresados)lista.get(0);
            }
            else {
				obj.setID_COMPARENDO(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_COMPARENDO(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
    
    /**
     * Busca los registros que coincidan con los datos enviados
     * @param Viewcompingresados obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List buscarViewcompingresados(Viewcompingresados obj) {
        List lista = null;
        try {
			ViewcompingresadosDao dao = new ViewcompingresadosDao();
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
     * @param Viewcompingresados obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List buscarViewcompingresados(Viewcompingresados obj,int pagina, int numRegPagina) {
        List lista = null;
		if(pagina>0&&numRegPagina>0)
		{
			pagina--;
			int limInf =0;
			int limSup =0;
			limInf = pagina*numRegPagina+1;
			limSup = (pagina+1)*numRegPagina;
			try {
				ViewcompingresadosDao dao = new ViewcompingresadosDao();
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

    public List buscarViewcompingresadosFechas(Viewcompingresados obj,String fecha1, String fecha2) {
        List lista = null;
                
        try {
            ViewcompingresadosDao dao = new ViewcompingresadosDao();
            conn = conexion.conectarComparendos();
            lista = dao.searchMatchingFechas(conn, obj, fecha1, fecha2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
                
        return lista;
    }
    
    
    /**
     * Consulta todos los registros de la tabla
     * @param Viewcompingresados obj
     * @return Retorna la lista de los registros en la tabla
     */
    public List listarViewcompingresados() {
        List lista = null;
        try {
			ViewcompingresadosDao dao = new ViewcompingresadosDao();
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
     * @param Viewcompingresados obj
     * @return Retorna la lista de los registros en la tabla con paginacion
     */
	
	public List listarViewcompingresados(int pagina, int numRegPagina) {
        List lista = null;
		if(pagina>0&&numRegPagina>0)
		{
			pagina--;
			int limInf =0;
			int limSup =0;
			limInf = pagina*numRegPagina+1;
			limSup = (pagina+1)*numRegPagina;
			try {
				ViewcompingresadosDao dao = new ViewcompingresadosDao();
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
	
	public int contarBusquedaViewcompingresados(Viewcompingresados obj) {
		int cantidad=-1;
        try {
			ViewcompingresadosDao dao = new ViewcompingresadosDao();
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
     * @param Viewcompingresados obj
     * @return Retorna un boolean indicando si se realizo o no la operacion
     */
    public boolean eliminarViewcompingresados(Viewcompingresados obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			ViewcompingresadosDao dao = new ViewcompingresadosDao();
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

