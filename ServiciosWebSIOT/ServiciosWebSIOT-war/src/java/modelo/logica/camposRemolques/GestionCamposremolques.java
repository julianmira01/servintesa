package modelo.logica.camposRemolques;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.camposRemolques.CamposremolquesDao;
import modelo.datos.objetos.camposRemolques.Camposremolques;

import utilidades.Funciones;

public class GestionCamposremolques {
    Conexion conexion;
    Connection conn;
    String myMotor;

    public GestionCamposremolques() {
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
     * @param Camposremolques obj
     * @return Retorna el mismo objeto pero con la llave primaria configurada
     */
	public Camposremolques crearCamposremolques(Camposremolques obj) {
		List lista = null;
        try {
            CamposremolquesDao dao = new CamposremolquesDao();
            conn = conexion.conectar();
            int id = Funciones.obtenerId(conn, "GEN_CAMPOS_REMOLQUES", "GEN_CAMPOS_REMOLQUES", myMotor);
            obj.setID(id);
            dao.create(conn, obj);
            //verificar existencia
            obj = new Camposremolques();
            obj.setID(id);
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Camposremolques)lista.get(0);
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
     * @param Camposremolques obj
     * @return boolean indicando si se realizo o no la actualizacion
     */
    public boolean editarCamposremolques(Camposremolques obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			CamposremolquesDao dao = new CamposremolquesDao();
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
     * @param Camposremolques obj
     * @return Retorna el mismo objeto pero con los datos consultados
     */
    public Camposremolques buscarPrimeroCamposremolques(Camposremolques obj) {
        List lista = null;
        try {
			CamposremolquesDao dao = new CamposremolquesDao();
            conn = conexion.conectar();
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Camposremolques)lista.get(0);
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
     * @param Camposremolques obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List buscarCamposremolques(Camposremolques obj) {
        List lista = null;
        try {
			CamposremolquesDao dao = new CamposremolquesDao();
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
     * @param Camposremolques obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List buscarCamposremolques(Camposremolques obj,int pagina, int numRegPagina) {
        List lista = null;
		if(pagina>0&&numRegPagina>0)
		{
			pagina--;
			int limInf =0;
			int limSup =0;
			limInf = pagina*numRegPagina+1;
			limSup = (pagina+1)*numRegPagina;
			try {
				CamposremolquesDao dao = new CamposremolquesDao();
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
     * @param Camposremolques obj
     * @return Retorna la lista de los registros en la tabla
     */
    public List listarCamposremolques() {
        List lista = null;
        try {
			CamposremolquesDao dao = new CamposremolquesDao();
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
     * @param Camposremolques obj
     * @return Retorna la lista de los registros en la tabla con paginacion
     */
	
	public List listarCamposremolques(int pagina, int numRegPagina) {
        List lista = null;
		if(pagina>0&&numRegPagina>0)
		{
			pagina--;
			int limInf =0;
			int limSup =0;
			limInf = pagina*numRegPagina+1;
			limSup = (pagina+1)*numRegPagina;
			try {
				CamposremolquesDao dao = new CamposremolquesDao();
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
	
	public int contarBusquedaCamposremolques(Camposremolques obj) {
		int cantidad=-1;
        try {
			CamposremolquesDao dao = new CamposremolquesDao();
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
     * @param Camposremolques obj
     * @return Retorna un boolean indicando si se realizo o no la operacion
     */
    public boolean eliminarCamposremolques(Camposremolques obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			CamposremolquesDao dao = new CamposremolquesDao();
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
