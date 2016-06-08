package modelo.logica.debidoCobrarImpuesto;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;


import modelo.datos.dao.debidoCobrarImpuesto.RegistrodebidocobrarDao;
import modelo.datos.objetos.debidoCobrarImpuesto.Registrodebidocobrar;

import utilidades.Funciones;


public class GestionRegistrodebidocobrar {
    Conexion conexion;
    Connection conn;
    String myMotor;

    public GestionRegistrodebidocobrar() {
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
     * @param Registrodebidocobrar obj
     * @return Retorna el mismo objeto pero con la llave primaria configurada
     */
	public Registrodebidocobrar crearRegistrodebidocobrar(Registrodebidocobrar obj) {
		List lista = null;
        try {
            RegistrodebidocobrarDao dao = new RegistrodebidocobrarDao();
            conn = conexion.conectar();
            int id = Funciones.obtenerId(conn, "GEN_RDC_ID", "GEN_RDC_ID", myMotor);
            obj.setRDC_ID(id);
            dao.create(conn, obj);
            //verificar existencia
            obj = new Registrodebidocobrar();
            obj.setRDC_ID(id);
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Registrodebidocobrar)lista.get(0);
            }
            else {
                obj.setRDC_ID(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setRDC_ID(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
	
	/**
     * Edita un registro en la tabla
     * @param Registrodebidocobrar obj
     * @return boolean indicando si se realizo o no la actualizacion
     */
    public boolean editarRegistrodebidocobrar(Registrodebidocobrar obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			RegistrodebidocobrarDao dao = new RegistrodebidocobrarDao();
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
     * @param Registrodebidocobrar obj
     * @return Retorna el mismo objeto pero con los datos consultados
     */
    public Registrodebidocobrar buscarPrimeroRegistrodebidocobrar(Registrodebidocobrar obj) {
        List lista = null;
        try {
			RegistrodebidocobrarDao dao = new RegistrodebidocobrarDao();
            conn = conexion.conectar();
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Registrodebidocobrar)lista.get(0);
            }
            else {
				obj.setRDC_ID(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setRDC_ID(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
    
    /**
     * Busca los registros que coincidan con los datos enviados
     * @param Registrodebidocobrar obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List buscarRegistrodebidocobrar(Registrodebidocobrar obj) {
        List lista = null;
        try {
			RegistrodebidocobrarDao dao = new RegistrodebidocobrarDao();
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
     * @param Registrodebidocobrar obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List buscarRegistrodebidocobrar(Registrodebidocobrar obj,int pagina, int numRegPagina) {
        List lista = null;
		if(pagina>0&&numRegPagina>0)
		{
			pagina--;
			int limInf =0;
			int limSup =0;
			limInf = pagina*numRegPagina+1;
			limSup = (pagina+1)*numRegPagina;
			try {
				RegistrodebidocobrarDao dao = new RegistrodebidocobrarDao();
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
     * @param Registrodebidocobrar obj
     * @return Retorna la lista de los registros en la tabla
     */
    public List listarRegistrodebidocobrar() {
        List lista = null;
        try {
			RegistrodebidocobrarDao dao = new RegistrodebidocobrarDao();
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
     * @param Registrodebidocobrar obj
     * @return Retorna la lista de los registros en la tabla con paginacion
     */
	
	public List listarRegistrodebidocobrar(int pagina, int numRegPagina) {
        List lista = null;
		if(pagina>0&&numRegPagina>0)
		{
			pagina--;
			int limInf =0;
			int limSup =0;
			limInf = pagina*numRegPagina+1;
			limSup = (pagina+1)*numRegPagina;
			try {
				RegistrodebidocobrarDao dao = new RegistrodebidocobrarDao();
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
	
	public int contarBusquedaRegistrodebidocobrar(Registrodebidocobrar obj) {
		int cantidad=-1;
        try {
			RegistrodebidocobrarDao dao = new RegistrodebidocobrarDao();
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
     * @param Registrodebidocobrar obj
     * @return Retorna un boolean indicando si se realizo o no la operacion
     */
    public boolean eliminarRegistrodebidocobrar(Registrodebidocobrar obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			RegistrodebidocobrarDao dao = new RegistrodebidocobrarDao();
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

