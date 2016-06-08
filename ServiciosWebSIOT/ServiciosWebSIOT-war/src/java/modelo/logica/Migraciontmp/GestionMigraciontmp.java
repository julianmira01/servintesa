package modelo.logica.Migraciontmp;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.Migraciontmp.MigraciontmpDao;

import modelo.datos.objetos.Migraciontmp.Migraciontmp;

import utilidades.Funciones;


public class GestionMigraciontmp {
    Conexion conexion;
    Connection conn;
    String myMotor;

    public GestionMigraciontmp() {
        super();
        crearObjetos();
    }
    
    private void crearObjetos(){
        conexion = new Conexion();
        myMotor = Funciones.leer_ini("/WSPIAC.ini", "MOTOR");
    }
	
	/**
     * Inserta nuevo registro en la tabla
     * @param Migraciontmp obj
     * @return Retorna el mismo objeto pero con la llave primaria configurada
     */
	public Migraciontmp crearMigraciontmp(Migraciontmp obj) {
		List lista = null;
        try {
            MigraciontmpDao dao = new MigraciontmpDao();
            conn = conexion.conectar();
            int id = Funciones.obtenerId(conn, "GEN_MIGRACIONTMP", "GEN_MIGRACIONTMP", myMotor);
            obj.setID_MIGRACION(id);
            dao.create(conn, obj);
            //verificar existencia
            obj = new Migraciontmp();
            obj.setID_MIGRACION(id);
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Migraciontmp)lista.get(0);
            }
            else {
                obj.setID_MIGRACION(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_MIGRACION(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
	
	/**
     * Edita un registro en la tabla
     * @param Migraciontmp obj
     * @return boolean indicando si se realizo o no la actualizacion
     */
    public boolean editarMigraciontmp(Migraciontmp obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			MigraciontmpDao dao = new MigraciontmpDao();
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
     * @param Migraciontmp obj
     * @return Retorna el mismo objeto pero con los datos consultados
     */
    public Migraciontmp buscarPrimeroMigraciontmp(Migraciontmp obj) {
        List lista = null;
        try {
			MigraciontmpDao dao = new MigraciontmpDao();
            conn = conexion.conectar();
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Migraciontmp)lista.get(0);
            }
            else {
				obj.setID_MIGRACION(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_MIGRACION(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
    
    /**
     * Busca los registros que coincidan con los datos enviados
     * @param Migraciontmp obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List buscarMigraciontmp(Migraciontmp obj) {
        List lista = null;
        try {
			MigraciontmpDao dao = new MigraciontmpDao();
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
     * @param Migraciontmp obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List buscarMigraciontmp(Migraciontmp obj,int pagina, int numRegPagina) {
        List lista = null;
		if(pagina>0&&numRegPagina>0)
		{
			pagina--;
			int limInf =0;
			int limSup =0;
			limInf = pagina*numRegPagina+1;
			limSup = (pagina+1)*numRegPagina;
			try {
				MigraciontmpDao dao = new MigraciontmpDao();
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
     * @param Migraciontmp obj
     * @return Retorna la lista de los registros en la tabla
     */
    public List listarMigraciontmp() {
        List lista = null;
        try {
			MigraciontmpDao dao = new MigraciontmpDao();
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
     * @param Migraciontmp obj
     * @return Retorna la lista de los registros en la tabla con paginacion
     */
	
	public List listarMigraciontmp(int pagina, int numRegPagina) {
        List lista = null;
		if(pagina>0&&numRegPagina>0)
		{
			pagina--;
			int limInf =0;
			int limSup =0;
			limInf = pagina*numRegPagina+1;
			limSup = (pagina+1)*numRegPagina;
			try {
				MigraciontmpDao dao = new MigraciontmpDao();
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
	
	public int contarBusquedaMigraciontmp(Migraciontmp obj) {
		int cantidad=-1;
        try {
			MigraciontmpDao dao = new MigraciontmpDao();
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
     * @param Migraciontmp obj
     * @return Retorna un boolean indicando si se realizo o no la operacion
     */
    public boolean eliminarMigraciontmp(Migraciontmp obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			MigraciontmpDao dao = new MigraciontmpDao();
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

