package modelo.logica.radicacion;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;


import modelo.datos.dao.radicacion.ViewcitaDao;
import modelo.datos.objetos.radicacion.Viewcita;

import utilidades.Funciones;


public class GestionViewcita {
    Conexion conexion;
    Connection conn;
    String myMotor;

    public GestionViewcita() {
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
     * @param Viewcita obj
     * @return Retorna el mismo objeto pero con la llave primaria configurada
     */
	public Viewcita crearViewcita(Viewcita obj) {
		List lista = null;
        try {
            ViewcitaDao dao = new ViewcitaDao();
            conn = conexion.conectar();
            int id = Funciones.obtenerId(conn, "GEN_VIEWCITA", "GEN_VIEWCITA","VIEW_CITA");
            obj.setNUMERO_CITA(id);
            dao.create(conn, obj);
            //verificar existencia
            obj = new Viewcita();
            obj.setNUMERO_CITA(id);
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Viewcita)lista.get(0);
            }
            else {
                obj.setNUMERO_CITA(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setNUMERO_CITA(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
	
	/**
     * Edita un registro en la tabla
     * @param Viewcita obj
     * @return boolean indicando si se realizo o no la actualizacion
     */
    public boolean editarViewcita(Viewcita obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			ViewcitaDao dao = new ViewcitaDao();
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
     * @param Viewcita obj
     * @return Retorna el mismo objeto pero con los datos consultados
     */
    public Viewcita buscarPrimeroViewcita(Viewcita obj) {
        List lista = null;
        try {
			ViewcitaDao dao = new ViewcitaDao();
            conn = conexion.conectar();
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Viewcita)lista.get(0);
            }
            else {
				obj.setNUMERO_CITA(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setNUMERO_CITA(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
    
    /**
     * Busca los registros que coincidan con los datos enviados
     * @param Viewcita obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List buscarViewcita(Viewcita obj) {
        List lista = null;
        try {
			ViewcitaDao dao = new ViewcitaDao();
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
     * @param Viewcita obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List buscarViewcita(Viewcita obj,int pagina, int numRegPagina) {
        List lista = null;
		if(pagina>0&&numRegPagina>0)
		{
			pagina--;
			int limInf =0;
			int limSup =0;
			limInf = pagina*numRegPagina+1;
			limSup = (pagina+1)*numRegPagina;
			try {
				ViewcitaDao dao = new ViewcitaDao();
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
     * @param Viewcita obj
     * @return Retorna la lista de los registros en la tabla
     */
    public List listarViewcita() {
        List lista = null;
        try {
			ViewcitaDao dao = new ViewcitaDao();
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
     * @param Viewcita obj
     * @return Retorna la lista de los registros en la tabla con paginacion
     */
	
	public List listarViewcita(int pagina, int numRegPagina) {
        List lista = null;
		if(pagina>0&&numRegPagina>0)
		{
			pagina--;
			int limInf =0;
			int limSup =0;
			limInf = pagina*numRegPagina+1;
			limSup = (pagina+1)*numRegPagina;
			try {
				ViewcitaDao dao = new ViewcitaDao();
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
	
	public int contarBusquedaViewcita(Viewcita obj) {
		int cantidad=-1;
        try {
			ViewcitaDao dao = new ViewcitaDao();
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
     * @param Viewcita obj
     * @return Retorna un boolean indicando si se realizo o no la operacion
     */
    public boolean eliminarViewcita(Viewcita obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			ViewcitaDao dao = new ViewcitaDao();
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
