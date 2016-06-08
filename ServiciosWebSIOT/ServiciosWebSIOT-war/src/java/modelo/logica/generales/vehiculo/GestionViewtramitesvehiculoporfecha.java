package modelo.logica.generales.vehiculo;

import java.sql.Connection;

import java.util.ArrayList;
import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.accesorias.TramitesdevehiculosDao;
import modelo.datos.dao.generales.vehiculo.ViewtramitesvehiculoporfechaDao;
import modelo.datos.objetos.generales.vehiculo.Viewtramitesvehiculoporfecha;

import utilidades.Funciones;


public class GestionViewtramitesvehiculoporfecha {
    Conexion conexion;
    Connection conn;
    String myMotor;

    public GestionViewtramitesvehiculoporfecha() {
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
     * @param Viewtramitesvehiculoporfecha obj
     * @return Retorna el mismo objeto pero con la llave primaria configurada
     */
	public Viewtramitesvehiculoporfecha crearViewtramitesvehiculoporfecha(Viewtramitesvehiculoporfecha obj) {
		List lista = null;
        try {
            ViewtramitesvehiculoporfechaDao dao = new ViewtramitesvehiculoporfechaDao();
            conn = conexion.conectar();
            //int id = Funciones.obtenerId(conn, "VIEWTRAMITESVEHICULOPORFECHA", "GEN_VIEWTRAMITESVEHICULOPORFECHA", myMotor);
            //obj.setID_TRAMITEINTERNO(id);
            dao.create(conn, obj);
            int id = lastId();
            obj.setID_TRAMITEINTERNO(id);
            //verificar existencia
            //obj = new Viewtramitesvehiculoporfecha();
            //obj.setID_TRAMITEINTERNO(id);
            //lista = dao.searchMatching(conn, obj);
            //if (lista != null && lista.size() > 0) {
            //    obj = (Viewtramitesvehiculoporfecha)lista.get(0);
            //}
            //else {
            //    obj.setID_TRAMITEINTERNO(-1);
            //}
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_TRAMITEINTERNO(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
	
	/**
     * Edita un registro en la tabla
     * @param Viewtramitesvehiculoporfecha obj
     * @return boolean indicando si se realizo o no la actualizacion
     */
    public boolean editarViewtramitesvehiculoporfecha(Viewtramitesvehiculoporfecha obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			ViewtramitesvehiculoporfechaDao dao = new ViewtramitesvehiculoporfechaDao();
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
     * @param Viewtramitesvehiculoporfecha obj
     * @return Retorna el mismo objeto pero con los datos consultados
     */
    public Viewtramitesvehiculoporfecha buscarPrimeroViewtramitesvehiculoporfecha(Viewtramitesvehiculoporfecha obj) {
        List lista = null;
        try {
			ViewtramitesvehiculoporfechaDao dao = new ViewtramitesvehiculoporfechaDao();
            conn = conexion.conectar();
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Viewtramitesvehiculoporfecha)lista.get(0);
            }
            else {
				obj.setID_TRAMITEINTERNO(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_TRAMITEINTERNO(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
    
    /**
     * Busca los registros que coincidan con los datos enviados
     * @param Viewtramitesvehiculoporfecha obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List buscarViewtramitesvehiculoporfecha(Viewtramitesvehiculoporfecha obj) {
        List lista = null;
        try {
			ViewtramitesvehiculoporfechaDao dao = new ViewtramitesvehiculoporfechaDao();
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
     * @param Viewtramitesvehiculoporfecha obj
     * @return Retorna la lista de los registros en la tabla
     */
    public List listarViewtramitesvehiculoporfecha() {
        List lista = null;
        try {
			ViewtramitesvehiculoporfechaDao dao = new ViewtramitesvehiculoporfechaDao();
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
     * @param Viewtramitesvehiculoporfecha obj
     * @return Retorna un boolean indicando si se realizo o no la operacion
     */
    public boolean eliminarViewtramitesvehiculoporfecha(Viewtramitesvehiculoporfecha obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			ViewtramitesvehiculoporfechaDao dao = new ViewtramitesvehiculoporfechaDao();
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
    public int lastId() {
        String sql = "SELECT IDENT_CURRENT('VIEW_TRAMITESVEHICULOPORFECHA') AS id ";
        java.sql.PreparedStatement stmt = null;
        java.sql.ResultSet result = null;
        
        try {
            conn = conexion.conectar();
            stmt = conn.prepareStatement(sql);
            result = stmt.executeQuery();
            if (result.next()) {
                 return result.getInt("id");
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
        return -1;
    }
        
    public List listarTramitesdevehiculos() {
        List lista = null;
        TramitesdevehiculosDao tipo_tramiteDao = new TramitesdevehiculosDao();
        try {
            conn = conexion.conectar();
            lista = (ArrayList)tipo_tramiteDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
}

