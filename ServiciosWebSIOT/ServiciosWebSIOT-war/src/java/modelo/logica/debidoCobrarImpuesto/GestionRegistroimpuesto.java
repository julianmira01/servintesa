package modelo.logica.debidoCobrarImpuesto;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.debidoCobrarImpuesto.RegistroimpuestoDao;
import modelo.datos.objetos.debidoCobrarImpuesto.Registroimpuesto;

import utilidades.Funciones;


public class GestionRegistroimpuesto {
    Conexion conexion;
    Connection conn;
    String myMotor;

    public GestionRegistroimpuesto() {
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
     * @param Registroimpuesto obj
     * @return Retorna el mismo objeto pero con la llave primaria configurada
     */
	public Registroimpuesto crearRegistroimpuesto(Registroimpuesto obj) {
		List lista = null;
        try {
            RegistroimpuestoDao dao = new RegistroimpuestoDao();
            conn = conexion.conectar();
            int id = Funciones.obtenerId(conn, "GEN_RI_ID", "GEN_RI_ID", myMotor);
            obj.setRI_ID(id);
            dao.create(conn, obj);
            //verificar existencia
            obj = new Registroimpuesto();
            obj.setRI_ID(id);
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Registroimpuesto)lista.get(0);
            }
            else {
                obj.setRI_ID(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setRI_ID(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
	
	/**
     * Edita un registro en la tabla
     * @param Registroimpuesto obj
     * @return boolean indicando si se realizo o no la actualizacion
     */
    public boolean editarRegistroimpuesto(Registroimpuesto obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			RegistroimpuestoDao dao = new RegistroimpuestoDao();
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
     * @param Registroimpuesto obj
     * @return Retorna el mismo objeto pero con los datos consultados
     */
    public Registroimpuesto buscarPrimeroRegistroimpuesto(Registroimpuesto obj) {
        List lista = null;
        try {
			RegistroimpuestoDao dao = new RegistroimpuestoDao();
            conn = conexion.conectar();
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Registroimpuesto)lista.get(0);
            }
            else {
				obj.setRI_ID(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setRI_ID(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
    
    /**
     * Busca los registros que coincidan con los datos enviados
     * @param Registroimpuesto obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List buscarRegistroimpuesto(Registroimpuesto obj) {
        List lista = null;
        try {
			RegistroimpuestoDao dao = new RegistroimpuestoDao();
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
     * @param Registroimpuesto obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List buscarRegistroimpuesto(Registroimpuesto obj,int pagina, int numRegPagina) {
        List lista = null;
		if(pagina>0&&numRegPagina>0)
		{
			pagina--;
			int limInf =0;
			int limSup =0;
			limInf = pagina*numRegPagina+1;
			limSup = (pagina+1)*numRegPagina;
			try {
				RegistroimpuestoDao dao = new RegistroimpuestoDao();
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
     * @param Registroimpuesto obj
     * @return Retorna la lista de los registros en la tabla
     */
    public List listarRegistroimpuesto() {
        List lista = null;
        try {
			RegistroimpuestoDao dao = new RegistroimpuestoDao();
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
     * @param Registroimpuesto obj
     * @return Retorna la lista de los registros en la tabla con paginacion
     */
	
	public List listarRegistroimpuesto(int pagina, int numRegPagina) {
        List lista = null;
		if(pagina>0&&numRegPagina>0)
		{
			pagina--;
			int limInf =0;
			int limSup =0;
			limInf = pagina*numRegPagina+1;
			limSup = (pagina+1)*numRegPagina;
			try {
				RegistroimpuestoDao dao = new RegistroimpuestoDao();
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
	
	public int contarBusquedaRegistroimpuesto(Registroimpuesto obj) {
		int cantidad=-1;
        try {
			RegistroimpuestoDao dao = new RegistroimpuestoDao();
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
     * @param Registroimpuesto obj
     * @return Retorna un boolean indicando si se realizo o no la operacion
     */
    public boolean eliminarRegistroimpuesto(Registroimpuesto obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			RegistroimpuestoDao dao = new RegistroimpuestoDao();
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

