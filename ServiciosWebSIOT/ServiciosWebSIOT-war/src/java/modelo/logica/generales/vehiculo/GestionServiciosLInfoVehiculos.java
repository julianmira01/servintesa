package modelo.logica.generales.vehiculo;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.generales.vehiculo.LInfoVehiculoDao;
import modelo.datos.objetos.generales.AuditoriaSystem;
import modelo.datos.objetos.generales.vehiculo.LInfoVehiculo;

import utilidades.Auditoria;
import utilidades.Funciones;


public class GestionServiciosLInfoVehiculos {
    Conexion conexion;
    Connection conn;
    String myMotor;

    public GestionServiciosLInfoVehiculos() {
        super();
        crearObjetos();
    }

    public void crearObjetos() {
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

    public LInfoVehiculo getInfoVehiculoPorIdVehiculo(LInfoVehiculo infoVehiculo) {
        LInfoVehiculoDao infoVehiculoDao;
        try {
            conn = conexion.conectar();
            infoVehiculoDao = new LInfoVehiculoDao();
            infoVehiculoDao.load(conn, infoVehiculo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            infoVehiculo.setLIV_V_ID(-1);
        } finally {
            conexion.cerrarCx();
        }
        return infoVehiculo;
    }

    public boolean createInfoVehiculo(LInfoVehiculo infoVehiculo, int idUsuario, String myIp, String myHost) {
        boolean resultado = false;
        LInfoVehiculoDao infoVehiculoDao;
        try {
            conn = conexion.conectar();
            infoVehiculoDao = new LInfoVehiculoDao();
            infoVehiculo.setLIV_FECHA_REG(Funciones.getFechaSistema(conn,myMotor));
            infoVehiculoDao.create(conn, infoVehiculo);
            resultado = true;
            //auditar
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("L_INFOVEHICULO");
            myAuditSx.setCAMPOCLAVE("LIV_V_ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(infoVehiculo.getLIV_V_ID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, infoVehiculo, 0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            resultado = false;
        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }

    /**
     * Edita un registro en la tabla
     * @param LInfoVehiculo obj
     * @return boolean indicando si se realizo o no la actualizacion
     */
    

     public boolean editarGrupoLiquidacion(LInfoVehiculo obj, int idUsuario, String myIp, String myHost) {
         boolean resultado;
         resultado = false;
         int id = 0;
         try {
             LInfoVehiculoDao dao = new LInfoVehiculoDao();
             conn = conexion.conectar();
             //auditar
             LInfoVehiculo ant = new LInfoVehiculo();
             ant.setLIV_V_ID(obj.getLIV_V_ID());
                         
             dao.saveGrupo(conn, obj);
             resultado = true;
             //auditar
             Auditoria myAuditoria = new Auditoria();
             AuditoriaSystem myAuditSx = new AuditoriaSystem();
             myAuditSx.setTABLAAFECTADA("L_INFOVEHICULO");
             myAuditSx.setCAMPOCLAVE("LIV_V_ID");
             myAuditSx.setVLRCAMPOCLAVE(String.valueOf(obj.getLIV_V_ID()));
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
    
    
    
    public boolean editar(LInfoVehiculo obj, int idUsuario, String myIp, String myHost) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
            LInfoVehiculoDao dao = new LInfoVehiculoDao();
            conn = conexion.conectar();
            //auditar
            LInfoVehiculo ant = new LInfoVehiculo();
            ant.setLIV_V_ID(obj.getLIV_V_ID());
            dao.load(conn, ant);
            dao.save(conn, obj);
            resultado = true;
            //auditar
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("L_INFOVEHICULO");
            myAuditSx.setCAMPOCLAVE("LIV_V_ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(obj.getLIV_V_ID()));
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
     * @param LInfoVehiculo obj
     * @return Retorna el mismo objeto pero con los datos consultados
     */
    public LInfoVehiculo getOne(LInfoVehiculo obj) {
        List lista = null;
        try {
            LInfoVehiculoDao dao = new LInfoVehiculoDao();
            conn = conexion.conectar();
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (LInfoVehiculo)lista.get(0);
            } else {
                obj.setLIV_V_ID(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setLIV_V_ID(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }

    /**
     * Busca los registros que coincidan con los datos enviados
     * @param LInfoVehiculo obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List get(LInfoVehiculo obj) {
        List lista = null;
        try {
            LInfoVehiculoDao dao = new LInfoVehiculoDao();
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
     * @param LInfoVehiculo obj
     * @return Retorna la lista de los registros en la tabla
     */
    public List listar() {
        List lista = null;
        try {
            LInfoVehiculoDao dao = new LInfoVehiculoDao();
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
     * @param LInfoVehiculo obj
     * @return Retorna un boolean indicando si se realizo o no la operacion
     */
    public boolean eliminar(LInfoVehiculo obj, int idUsuario, String myIp, String myHost) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
            LInfoVehiculoDao dao = new LInfoVehiculoDao();
            conn = conexion.conectar();
            dao.delete(conn, obj);
            resultado = true;
            //auditar
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("L_INFOVEHICULO");
            myAuditSx.setCAMPOCLAVE("LIV_V_ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(obj.getLIV_V_ID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEliminacion(conn, myAuditSx, obj, 0);
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }

}
