package modelo.logica.comparendos.centros_atencion;


import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.objetos.comparendos.centros_atencion.Centroatencion;
import modelo. datos.dao.comparendos.centros_atencion.*;

import utilidades.Funciones;


public class GestionCentroatencion {
    Conexion conexion;
    Connection conn;
    String myMotor;

    public GestionCentroatencion() {
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
     * @param Centroatencion obj
     * @return Retorna el mismo objeto pero con la llave primaria configurada
     */
	public Centroatencion crearCentroatencion(Centroatencion obj) {
		List lista = null;
        try {
            CentroatencionDao dao = new CentroatencionDao();
            conn = conexion.conectarComparendos();
            int id = Funciones.obtenerId(conn, "GEN_CENTROATENCION", "GEN_CENTROATENCION", myMotor);
            obj.setID_CENTRO(id);
            dao.create(conn, obj);
            //verificar existencia
            obj = new Centroatencion();
            obj.setID_CENTRO(id);
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Centroatencion)lista.get(0);
            }
            else {
                obj.setID_CENTRO(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_CENTRO(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
	
	/**
     * Edita un registro en la tabla
     * @param Centroatencion obj
     * @return boolean indicando si se realizo o no la actualizacion
     */
    public boolean editarCentroatencion(Centroatencion obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			CentroatencionDao dao = new CentroatencionDao();
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
     * @param Centroatencion obj
     * @return Retorna el mismo objeto pero con los datos consultados
     */
    public Centroatencion buscarPrimeroCentroatencion(Centroatencion obj) {
        List lista = null;
        try {
			CentroatencionDao dao = new CentroatencionDao();
            conn = conexion.conectarComparendos();
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Centroatencion)lista.get(0);
            }
            else {
				obj.setID_CENTRO(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_CENTRO(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
    
    /**
     * Busca los registros que coincidan con los datos enviados
     * @param Centroatencion obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List buscarCentroatencion(Centroatencion obj) {
        List lista = null;
        try {
			CentroatencionDao dao = new CentroatencionDao();
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
     * @param Centroatencion obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List buscarCentroatencion(Centroatencion obj,int pagina, int numRegPagina) {
        List lista = null;
		if(pagina>0&&numRegPagina>0)
		{
			pagina--;
			int limInf =0;
			int limSup =0;
			limInf = pagina*numRegPagina+1;
			limSup = (pagina+1)*numRegPagina;
			try {
				CentroatencionDao dao = new CentroatencionDao();
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
     * @param Centroatencion obj
     * @return Retorna la lista de los registros en la tabla
     */
    public List listarCentroatencion() {
        List lista = null;
        try {
			CentroatencionDao dao = new CentroatencionDao();
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
     * @param Centroatencion obj
     * @return Retorna la lista de los registros en la tabla con paginacion
     */
	
	public List listarCentroatencion(int pagina, int numRegPagina) {
        List lista = null;
		if(pagina>0&&numRegPagina>0)
		{
			pagina--;
			int limInf =0;
			int limSup =0;
			limInf = pagina*numRegPagina+1;
			limSup = (pagina+1)*numRegPagina;
			try {
				CentroatencionDao dao = new CentroatencionDao();
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
	
	public int contarBusquedaCentroatencion(Centroatencion obj) {
		int cantidad=-1;
        try {
			CentroatencionDao dao = new CentroatencionDao();
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
     * @param Centroatencion obj
     * @return Retorna un boolean indicando si se realizo o no la operacion
     */
    public boolean eliminarCentroatencion(Centroatencion obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			CentroatencionDao dao = new CentroatencionDao();
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

