package modelo.logica.licenciasConduccion;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.licenciasConduccion.ViewlicenciaresidenciaDao;
import modelo.datos.objetos.licenciasConduccion.Viewlicenciaresidencia;

import utilidades.Funciones;


public class GestionViewlicenciaresidencia {
    Conexion conexion;
    Connection conn;
    String myMotor;

    public GestionViewlicenciaresidencia() {
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
     * @param Viewlicenciaresidencia obj
     * @return Retorna el mismo objeto pero con la llave primaria configurada
     */
	public Viewlicenciaresidencia crearViewlicenciaresidencia(Viewlicenciaresidencia obj) {
		List lista = null;
        try {
            ViewlicenciaresidenciaDao dao = new ViewlicenciaresidenciaDao();
            conn = conexion.conectar();
            //int id = Funciones.obtenerId(conn, "VIEWLICENCIARESIDENCIA", "GEN_VIEWLICENCIARESIDENCIA", myMotor);
            //obj.setID_LICENCIA(id);
            dao.create(conn, obj);
            String id = lastId();
            obj.setID_LICENCIA(id);
            //verificar existencia
            //obj = new Viewlicenciaresidencia();
            //obj.setID_LICENCIA(id);
            //lista = dao.searchMatching(conn, obj);
            //if (lista != null && lista.size() > 0) {
            //    obj = (Viewlicenciaresidencia)lista.get(0);
            //}
            //else {
            //    obj.setID_LICENCIA(-1);
            //}
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_LICENCIA("-1");
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
	
	/**
     * Edita un registro en la tabla
     * @param Viewlicenciaresidencia obj
     * @return boolean indicando si se realizo o no la actualizacion
     */
    public boolean editarViewlicenciaresidencia(Viewlicenciaresidencia obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			ViewlicenciaresidenciaDao dao = new ViewlicenciaresidenciaDao();
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
     * @param Viewlicenciaresidencia obj
     * @return Retorna el mismo objeto pero con los datos consultados
     */
    public Viewlicenciaresidencia buscarPrimeroViewlicenciaresidencia(Viewlicenciaresidencia obj) {
        List lista = null;
        try {
			ViewlicenciaresidenciaDao dao = new ViewlicenciaresidenciaDao();
            conn = conexion.conectar();
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Viewlicenciaresidencia)lista.get(0);
            }
            else {
				obj.setID_LICENCIA("-1");
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_LICENCIA("-1");
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
    
    /**
     * Busca los registros que coincidan con los datos enviados
     * @param Viewlicenciaresidencia obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List buscarViewlicenciaresidencia(Viewlicenciaresidencia obj) {
        List lista = null;
        try {
			ViewlicenciaresidenciaDao dao = new ViewlicenciaresidenciaDao();
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
     * @param Viewlicenciaresidencia obj
     * @return Retorna la lista de los registros en la tabla
     */
    public List listarViewlicenciaresidencia() {
        List lista = null;
        try {
			ViewlicenciaresidenciaDao dao = new ViewlicenciaresidenciaDao();
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
     * @param Viewlicenciaresidencia obj
     * @return Retorna un boolean indicando si se realizo o no la operacion
     */
    public boolean eliminarViewlicenciaresidencia(Viewlicenciaresidencia obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			ViewlicenciaresidenciaDao dao = new ViewlicenciaresidenciaDao();
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
        String sql = "SELECT IDENT_CURRENT('VIEW_LICENCIARESIDENCIA') AS id ";
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

