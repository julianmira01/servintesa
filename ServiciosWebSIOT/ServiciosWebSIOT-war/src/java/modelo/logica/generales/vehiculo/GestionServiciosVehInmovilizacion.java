package modelo.logica.generales.vehiculo;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.generales.vehiculo.VehInmovilizacionDao;
import modelo.datos.objetos.generales.AuditoriaSystem;
import modelo.datos.objetos.generales.vehiculo.VehInmovilizacion;

import utilidades.Auditoria;
import utilidades.Funciones;


public class GestionServiciosVehInmovilizacion {
    Conexion conexion;
    Connection conn;
    String myMotor;

    public GestionServiciosVehInmovilizacion() {
        super();
        crearObjetos();
    }

    private void crearObjetos() {
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
     * @param VehInmovilizacion obj
     * @return Retorna el mismo objeto pero con la llave primaria configurada
     */
    public VehInmovilizacion crear(VehInmovilizacion obj, int idUsuario, String myIp, String myHost) {
        try {
            VehInmovilizacionDao dao = new VehInmovilizacionDao();
            conn = conexion.conectar();
            int id = Funciones.obtenerId(conn, "GEN_VEHINMOVILIZACION", "GEN_VEHINMOVILIZACION", myMotor);
            obj.setID_VEHINMOVILIZA(id);
            dao.create(conn, obj);
            //verificar existencia
            obj = new VehInmovilizacion();
            obj.setID_VEHINMOVILIZA(id);
            List objs = dao.searchMatching(conn, obj);
            if (objs != null && objs.size() > 0) {
                obj = (VehInmovilizacion)objs.get(0);
            } else {
                obj.setID_VEHINMOVILIZA(-1);
            }
            //auditar
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("VEHINMOVILIZACION");
            myAuditSx.setCAMPOCLAVE("ID_VEHINMOVILIZA");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(obj.getID_VEHINMOVILIZA()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, obj, 0);
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_VEHINMOVILIZA(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }

    /**
     * Edita un registro en la tabla
     * @param VehInmovilizacion obj
     * @return boolean indicando si se realizo o no la actualizacion
     */
    
     public boolean editarFechaHoraFinNull(VehInmovilizacion obj) {
         boolean resultado;
         resultado = false;
         int id = 0;
         try {
             VehInmovilizacionDao dao = new VehInmovilizacionDao();
             conn = conexion.conectar();
             dao.saveFechaHoraFinNull(conn, obj);
             resultado = true;
                          
         } catch (Exception e) {
             e.printStackTrace();
             resultado = false;
         } finally {
             conexion.cerrarCx();
         }
         return resultado;
     }
    
    public boolean editar(VehInmovilizacion obj, int idUsuario, String myIp, String myHost) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
            VehInmovilizacionDao dao = new VehInmovilizacionDao();
            conn = conexion.conectar();
            //auditar
            VehInmovilizacion ant = new VehInmovilizacion();
            ant.setID_VEHINMOVILIZA(obj.getID_VEHINMOVILIZA());
            dao.load(conn, ant);
            dao.save(conn, obj);
            resultado = true;
            //auditar
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("VEHINMOVILIZACION");
            myAuditSx.setCAMPOCLAVE("ID_VEHINMOVILIZA");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(obj.getID_VEHINMOVILIZA()));
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
    
    
    public boolean editarEstado(VehInmovilizacion obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
            VehInmovilizacionDao dao = new VehInmovilizacionDao();
            conn = conexion.conectar();
            dao.saveActiva(conn, obj);
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
     * @param VehInmovilizacion obj
     * @return Retorna el mismo objeto pero con los datos consultados
     */
    public VehInmovilizacion getOne(VehInmovilizacion obj) {
        List lista = null;
        try {
            VehInmovilizacionDao dao = new VehInmovilizacionDao();
            conn = conexion.conectar();
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (VehInmovilizacion)lista.get(0);
            } else {
                obj.setID_VEHINMOVILIZA(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_VEHINMOVILIZA(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }

    /**
     * Busca los registros que coincidan con los datos enviados
     * @param VehInmovilizacion obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List get(VehInmovilizacion obj) {
        List lista = null;
        try {
            VehInmovilizacionDao dao = new VehInmovilizacionDao();
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
     * @param VehInmovilizacion obj
     * @return Retorna la lista de los registros en la tabla
     */
    public List listar() {
        List lista = null;
        try {
            VehInmovilizacionDao dao = new VehInmovilizacionDao();
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
     * @param VehInmovilizacion obj
     * @return Retorna un boolean indicando si se realizo o no la operacion
     */
    public boolean eliminar(VehInmovilizacion obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
            VehInmovilizacionDao dao = new VehInmovilizacionDao();
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

