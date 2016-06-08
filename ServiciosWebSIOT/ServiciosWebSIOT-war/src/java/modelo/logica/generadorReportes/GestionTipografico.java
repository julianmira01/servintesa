package modelo.logica.generadorReportes;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.generadorReportes.TipograficoDao;
import modelo.datos.objetos.generadorReportes.Tipografico;

import utilidades.Funciones;


public class GestionTipografico {
    Conexion conexion;
    Connection conn;
    String myMotor;

    public GestionTipografico() {
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
     * @param Tipografico obj
     * @return Retorna el mismo objeto pero con la llave primaria configurada
     */
	public Tipografico crearTipografico(Tipografico obj) {
		List lista = null;
        try {
            TipograficoDao dao = new TipograficoDao();
            conn = conexion.conectar();
            //int id = Funciones.obtenerId(conn, "TIPOGRAFICO", "GEN_TIPOGRAFICO", myMotor);
            //obj.setID(id);
            dao.create(conn, obj);
            int id = lastId();
            obj.setID(id);
            //verificar existencia
            //obj = new Tipografico();
            //obj.setID(id);
            //lista = dao.searchMatching(conn, obj);
            //if (lista != null && lista.size() > 0) {
            //    obj = (Tipografico)lista.get(0);
            //}
            //else {
            //    obj.setID(-1);
            //}
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
     * @param Tipografico obj
     * @return boolean indicando si se realizo o no la actualizacion
     */
    public boolean editarTipografico(Tipografico obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			TipograficoDao dao = new TipograficoDao();
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
     * @param Tipografico obj
     * @return Retorna el mismo objeto pero con los datos consultados
     */
    public Tipografico buscarPrimeroTipografico(Tipografico obj) {
        List lista = null;
        try {
			TipograficoDao dao = new TipograficoDao();
            conn = conexion.conectar();
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Tipografico)lista.get(0);
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
     * @param Tipografico obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List buscarTipografico(Tipografico obj) {
        List lista = null;
        try {
			TipograficoDao dao = new TipograficoDao();
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
     * @param Tipografico obj
     * @return Retorna la lista de los registros en la tabla
     */
    public List listarTipografico() {
        List lista = null;
        try {
			TipograficoDao dao = new TipograficoDao();
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
     * @param Tipografico obj
     * @return Retorna un boolean indicando si se realizo o no la operacion
     */
    public boolean eliminarTipografico(Tipografico obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			TipograficoDao dao = new TipograficoDao();
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
        String sql = "SELECT IDENT_CURRENT('TIPO_GRAFICO') AS id ";
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
}

