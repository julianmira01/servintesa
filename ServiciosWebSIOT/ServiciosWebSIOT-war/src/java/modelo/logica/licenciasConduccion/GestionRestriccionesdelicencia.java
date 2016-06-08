package modelo.logica.licenciasConduccion;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.licenciasConduccion.RestriccionesdelicenciaDao;
import modelo.datos.objetos.licenciasConduccion.Restriccionesdelicencia;

import utilidades.Funciones;


public class GestionRestriccionesdelicencia {
    Conexion conexion;
    Connection conn;
    String myMotor;

    public GestionRestriccionesdelicencia() {
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
     * @param Restriccionesdelicencia obj
     * @return Retorna el mismo objeto pero con la llave primaria configurada
     */
	public Restriccionesdelicencia crearRestriccionesdelicencia(Restriccionesdelicencia obj) {
		List lista = null;
        try {
            RestriccionesdelicenciaDao dao = new RestriccionesdelicenciaDao();
            conn = conexion.conectar();
            
            //int id = Funciones.obtenerId(conn, "GEN_RESTRICCION_LICCONDUCCION", "GEN_RESTRICCION_LICCONDUCCION", myMotor);
            //obj.setID_LICENCIAC("" + id);
            
            //System.out.println("Creaci-*-n de restricci-*-n de licencia con ID: " + id);
            
            dao.create(conn, obj);
            //String id = lastId();
            //obj.setID_LICENCIAC("" + id);
            //verificar existencia
            //obj = new Restriccionesdelicencia();
            //obj.setID_LICENCIAC("" + id);
            lista = dao.searchMatching(conn, obj);
            
            if (lista != null && lista.size() > 0) {
                obj = (Restriccionesdelicencia)lista.get(0);
            }
            else {
                obj.setID_LICENCIAC("-1");
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_LICENCIAC("-1");
        } finally {
            conexion.cerrarCx();
        }
        
        
        System.out.println("Valores registro restricciones licencia que se retorna: ID_LICENCIAC: " + obj.getID_LICENCIAC() +
                            " ID_RESTRICCIONC: " + obj.getID_RESTRICCIONC());
        
        return obj;
    }
	
	/**
     * Edita un registro en la tabla
     * @param Restriccionesdelicencia obj
     * @return boolean indicando si se realizo o no la actualizacion
     */
    public boolean editarRestriccionesdelicencia(Restriccionesdelicencia obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			RestriccionesdelicenciaDao dao = new RestriccionesdelicenciaDao();
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
     * @param Restriccionesdelicencia obj
     * @return Retorna el mismo objeto pero con los datos consultados
     */
    public Restriccionesdelicencia buscarPrimeroRestriccionesdelicencia(Restriccionesdelicencia obj) {
        List lista = null;
        try {
			RestriccionesdelicenciaDao dao = new RestriccionesdelicenciaDao();
            conn = conexion.conectar();
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Restriccionesdelicencia)lista.get(0);
            }
            else {
				obj.setID_LICENCIAC("-1");
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_LICENCIAC("-1");
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
    
    /**
     * Busca los registros que coincidan con los datos enviados
     * @param Restriccionesdelicencia obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List buscarRestriccionesdelicencia(Restriccionesdelicencia obj) {
        List lista = null;
        try {
			RestriccionesdelicenciaDao dao = new RestriccionesdelicenciaDao();
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
     * Consulta todos los registros de la tabla
     * @param Restriccionesdelicencia obj
     * @return Retorna la lista de los registros en la tabla
     */
    public List listarRestriccionesdelicencia() {
        List lista = null;
        try {
			RestriccionesdelicenciaDao dao = new RestriccionesdelicenciaDao();
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
     * Elimina un registro de la tabla
     * @param Restriccionesdelicencia obj
     * @return Retorna un boolean indicando si se realizo o no la operacion
     */
    public boolean eliminarRestriccionesdelicencia(Restriccionesdelicencia obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			RestriccionesdelicenciaDao dao = new RestriccionesdelicenciaDao();
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

	/**
     * Lee el ultimo id auto incremental insertado en la tabla Marca.
     * 
     * @return int : -1 si hubo algun error. >= 0.
     */
    public String lastId() {
        String sql = "SELECT IDENT_CURRENT('RESTRICCIONESDELICENCIA') AS id ";
        java.sql.PreparedStatement stmt = null;
        java.sql.ResultSet result = null;
        
        try {
            conn = conexion.conectar();
            stmt = conn.prepareStatement(sql);
            result = stmt.executeQuery();
            if (result.next()) {
                 return result.getString("id");
            } else {
                 System.out.println("Id autoincremental no encontrado!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
            if (result != null)
                result.close();
            if (stmt != null)
                stmt.close();
            }
            catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
            conexion.cerrarCx();
        }
        return "-1";
    }
}

