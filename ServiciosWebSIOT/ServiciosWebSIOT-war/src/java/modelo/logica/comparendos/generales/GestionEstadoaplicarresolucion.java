package modelo.logica.comparendos.generales;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.comparendos.generales.EstadoaplicarresolucionDao;
import modelo.datos.objetos.comparendos.generales.Estadoaplicarresolucion;

import utilidades.Funciones;


public class GestionEstadoaplicarresolucion {
    Conexion conexion;
    Connection conn;
    String myMotor;

    public GestionEstadoaplicarresolucion() {
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
     * @param Estadoaplicarresolucion obj
     * @return Retorna el mismo objeto pero con la llave primaria configurada
     */
	public Estadoaplicarresolucion crearEstadoaplicarresolucion(Estadoaplicarresolucion obj) {
		List lista = null;
        try {
            EstadoaplicarresolucionDao dao = new EstadoaplicarresolucionDao();
            //conn = conexion.conectar();
            conn = conexion.conectarComparendos();
            //int id = Funciones.obtenerId(conn, "GEN_ESTADOAPLICARRESOLUCION", "GEN_ESTADOAPLICARRESOLUCION","ESTADO_APLICAR_RESOLUCION", myMotor);
            int id = Funciones.getId_FB(conn, "GEN_ESTADOCOMP_RESOLUCI");
            obj.setID_ESTADOCOMP_RESOLUCION(id);
            dao.create(conn, obj);
            //verificar existencia
            obj = new Estadoaplicarresolucion();
            obj.setID_ESTADOCOMP_RESOLUCION(id);
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Estadoaplicarresolucion)lista.get(0);
            }
            else {
                obj.setID_ESTADOCOMP_RESOLUCION(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_ESTADOCOMP_RESOLUCION(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
	
	/**
     * Edita un registro en la tabla
     * @param Estadoaplicarresolucion obj
     * @return boolean indicando si se realizo o no la actualizacion
     */
    public boolean editarEstadoaplicarresolucion(Estadoaplicarresolucion obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			EstadoaplicarresolucionDao dao = new EstadoaplicarresolucionDao();
            //conn = conexion.conectar();
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
     * @param Estadoaplicarresolucion obj
     * @return Retorna el mismo objeto pero con los datos consultados
     */
    public Estadoaplicarresolucion buscarPrimeroEstadoaplicarresolucion(Estadoaplicarresolucion obj) {
        List lista = null;
        try {
			EstadoaplicarresolucionDao dao = new EstadoaplicarresolucionDao();
            //conn = conexion.conectar();
            conn = conexion.conectarComparendos();
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Estadoaplicarresolucion)lista.get(0);
            }
            else {
				obj.setID_ESTADOCOMP_RESOLUCION(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_ESTADOCOMP_RESOLUCION(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
    
    /**
     * Busca los registros que coincidan con los datos enviados
     * @param Estadoaplicarresolucion obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List buscarEstadoaplicarresolucion(Estadoaplicarresolucion obj) {
        List lista = null;
        try {
			EstadoaplicarresolucionDao dao = new EstadoaplicarresolucionDao();
            //conn = conexion.conectar();
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
     * @param Estadoaplicarresolucion obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List buscarEstadoaplicarresolucion(Estadoaplicarresolucion obj,int pagina, int numRegPagina) {
        List lista = null;
		if(pagina>0&&numRegPagina>0)
		{
			pagina--;
			int limInf =0;
			int limSup =0;
			limInf = pagina*numRegPagina+1;
			limSup = (pagina+1)*numRegPagina;
			try {
				EstadoaplicarresolucionDao dao = new EstadoaplicarresolucionDao();
				//conn = conexion.conectar();
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
     * @param Estadoaplicarresolucion obj
     * @return Retorna la lista de los registros en la tabla
     */
    public List listarEstadoaplicarresolucion() {
        List lista = null;
        try {
			EstadoaplicarresolucionDao dao = new EstadoaplicarresolucionDao();
            //conn = conexion.conectar();
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
     * @param Estadoaplicarresolucion obj
     * @return Retorna la lista de los registros en la tabla con paginacion
     */
	
	public List listarEstadoaplicarresolucion(int pagina, int numRegPagina) {
        List lista = null;
		if(pagina>0&&numRegPagina>0)
		{
			pagina--;
			int limInf =0;
			int limSup =0;
			limInf = pagina*numRegPagina+1;
			limSup = (pagina+1)*numRegPagina;
			try {
				EstadoaplicarresolucionDao dao = new EstadoaplicarresolucionDao();
				//conn = conexion.conectar();
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
	
	public int contarBusquedaEstadoaplicarresolucion(Estadoaplicarresolucion obj) {
		int cantidad=-1;
        try {
			EstadoaplicarresolucionDao dao = new EstadoaplicarresolucionDao();
            //conn = conexion.conectar();
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
     * @param Estadoaplicarresolucion obj
     * @return Retorna un boolean indicando si se realizo o no la operacion
     */
    public boolean eliminarEstadoaplicarresolucion(Estadoaplicarresolucion obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			EstadoaplicarresolucionDao dao = new EstadoaplicarresolucionDao();
            //conn = conexion.conectar();
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

