package modelo.logica.generales;



import modelo.datos.objetos.generales.Auditoriatramite;
import modelo.datos.dao.generales.AuditoriatramiteDao;

import java.sql.Connection;
import java.util.List;
import modelo.conexion.Conexion;
import utilidades.Funciones;


public class GestionAuditoriaTramite {
    Conexion conexion;
    Connection conn;
    String myMotor;

    public GestionAuditoriaTramite() {
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
     * @param Auditoriatramite obj
     * @return Retorna el mismo objeto pero con la llave primaria configurada
     */
	public Auditoriatramite crearAuditoriatramite(Auditoriatramite obj) {
		List lista = null;
        try {
            AuditoriatramiteDao dao = new AuditoriatramiteDao();
            conn = conexion.conectar();
            int id = 1;
            //if(myMotor.equals("ORACLE"))
            //{
              id = Funciones.obtenerId(conn, "AUDITORIATRAMITE_ID_GEN", "AUDITORIATRAMITE_ID_GEN", myMotor);    
            //}
                                    
            obj.setID(id);           
            dao.create(conn, obj);
            //verificar existencia
            obj = new Auditoriatramite();
            obj.setID(id);
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Auditoriatramite)lista.get(0);
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
     * @param Auditoriatramite obj
     * @return boolean indicando si se realizo o no la actualizacion
     */
    public boolean editarAuditoriatramite(Auditoriatramite obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			AuditoriatramiteDao dao = new AuditoriatramiteDao();
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
     * @param Auditoriatramite obj
     * @return Retorna el mismo objeto pero con los datos consultados
     */
    public Auditoriatramite buscarPrimeroAuditoriatramite(Auditoriatramite obj) {
        List lista = null;
        try {
			AuditoriatramiteDao dao = new AuditoriatramiteDao();
            conn = conexion.conectar();
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Auditoriatramite)lista.get(0);
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
     * @param Auditoriatramite obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List buscarAuditoriatramite(Auditoriatramite obj) {
        List lista = null;
        try {
			AuditoriatramiteDao dao = new AuditoriatramiteDao();
            conn = conexion.conectar();
            lista = dao.searchMatching(conn, obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List buscarAuditoriatramiteView(Auditoriatramite obj) {
        List lista = null;
        try {
            AuditoriatramiteDao dao = new AuditoriatramiteDao();
            conn = conexion.conectar();
            lista = dao.searchMatchingView(conn, obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List buscarAuditoriatramiteWebView(Auditoriatramite obj) {
        List lista = null;
        try {
            AuditoriatramiteDao dao = new AuditoriatramiteDao();
            conn = conexion.conectar();
            lista = dao.searchMatchingView(conn, obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
	
	/**
     * Busca los registros que coincidan con los datos enviados
     * @param Auditoriatramite obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List buscarAuditoriatramite(Auditoriatramite obj,int pagina, int numRegPagina) {
        List lista = null;
		if(pagina>0&&numRegPagina>0)
		{
			pagina--;
			int limInf =0;
			int limSup =0;
			limInf = pagina*numRegPagina+1;
			limSup = (pagina+1)*numRegPagina;
			try {
				AuditoriatramiteDao dao = new AuditoriatramiteDao();
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
     * @param Auditoriatramite obj
     * @return Retorna la lista de los registros en la tabla
     */
    public List listarAuditoriatramite() {
        List lista = null;
        try {
			AuditoriatramiteDao dao = new AuditoriatramiteDao();
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
     * @param Auditoriatramite obj
     * @return Retorna la lista de los registros en la tabla con paginacion
     */
	
	public List listarAuditoriatramite(int pagina, int numRegPagina) {
        List lista = null;
		if(pagina>0&&numRegPagina>0)
		{
			pagina--;
			int limInf =0;
			int limSup =0;
			limInf = pagina*numRegPagina+1;
			limSup = (pagina+1)*numRegPagina;
			try {
				AuditoriatramiteDao dao = new AuditoriatramiteDao();
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
	
	public int contarBusquedaAuditoriatramite(Auditoriatramite obj) {
		int cantidad=-1;
        try {
			AuditoriatramiteDao dao = new AuditoriatramiteDao();
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
     * @param Auditoriatramite obj
     * @return Retorna un boolean indicando si se realizo o no la operacion
     */
    public boolean eliminarAuditoriatramite(Auditoriatramite obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			AuditoriatramiteDao dao = new AuditoriatramiteDao();
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

