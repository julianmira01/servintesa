package modelo.logica.comparendos.liquidacion;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.comparendos.liquidacion.RecibocuotasDao;
import modelo.datos.objetos.comparendos.liquidacion.Recibocuotas;
import modelo.datos.objetos.generales.AuditoriaSystem;

import utilidades.Auditoria;
import utilidades.Funciones;


public class GestionRecibocuotas {
    Conexion conexion;
    Connection conn;
    String myMotor;

    public GestionRecibocuotas() {
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
     * @param Recibocuotas obj
     * @return Retorna el mismo objeto pero con la llave primaria configurada
     */
	public Recibocuotas crear(Recibocuotas obj, int idUsuario, String myIp, String myHost) {
        try {
            RecibocuotasDao dao = new RecibocuotasDao();
            conn = conexion.conectarComparendos();
            int id = Funciones.obtenerId(conn, "GEN_ID_RECIBOCUOTAS", "GEN_RECIBOCUOTAS", myMotor);
            obj.setID(id);
            dao.create(conn, obj);
            //verificar existencia
            obj = new Recibocuotas();
            obj.setID(id);
            List objs = dao.searchMatching(conn, obj);
            if (objs != null && objs.size() > 0) {
                obj = (Recibocuotas)objs.get(0);
            }
            else {
                obj.setID(-1);
            }
            //auditar insert
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("RECIBOCUOTAS");
            myAuditSx.setCAMPOCLAVE("ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(obj.getID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, obj, 0);

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
     * @param Recibocuotas obj
     * @return boolean indicando si se realizo o no la actualizacion
     */
    public boolean editar(Recibocuotas obj, int idUsuario, String myIp, String myHost) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			RecibocuotasDao dao = new RecibocuotasDao();
            conn = conexion.conectarComparendos();
            //auditar edicion
            Recibocuotas ant = new Recibocuotas();
            ant.setID(obj.getID());
            dao.load(conn, ant);
            dao.save(conn, obj);
            resultado = true;
            //auditar edicion
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("RECIBOCUOTAS");
            myAuditSx.setCAMPOCLAVE("ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(obj.getID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEdicion(conn, myAuditSx, ant, obj, myIp, myHost, 0);

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
     * @param Recibocuotas obj
     * @return Retorna el mismo objeto pero con los datos consultados
     */
    public Recibocuotas getOne(Recibocuotas obj) {
        List lista = null;
        try {
			RecibocuotasDao dao = new RecibocuotasDao();
            conn = conexion.conectarComparendos();
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Recibocuotas)lista.get(0);
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
     * @param Recibocuotas obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List get(Recibocuotas obj) {
        List lista = null;
        try {
			RecibocuotasDao dao = new RecibocuotasDao();
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
     * Consulta todos los registros de la tabla
     * @param Recibocuotas obj
     * @return Retorna la lista de los registros en la tabla
     */
    public List listar() {
        List lista = null;
        try {
			RecibocuotasDao dao = new RecibocuotasDao();
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
     * Elimina un registro de la tabla
     * @param Recibocuotas obj
     * @return Retorna un boolean indicando si se realizo o no la operacion
     */
    public boolean eliminar(Recibocuotas obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
			RecibocuotasDao dao = new RecibocuotasDao();
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

