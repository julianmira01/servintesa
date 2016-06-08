package modelo.logica.generales;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.generales.LimitacionPropVehiculoDao;
import modelo.datos.objetos.generales.AuditoriaSystem;
import modelo.datos.objetos.generales.LimitacionPropVehiculo;
import modelo.datos.objetos.generales.TramiteBasico;

import utilidades.Auditoria;
import utilidades.Funciones;


public class GestionServiciosLimitacionPropVehiculo {
    Conexion conexion;
    Connection conn;
    String myMotor;
    LimitacionPropVehiculoDao limitacionPropVehiculoDao;
    
    public GestionServiciosLimitacionPropVehiculo() {
        super();
        crearObjetos();
    }
    
    public void crearObjetos() {
      conexion = new Conexion();      
      limitacionPropVehiculoDao = new LimitacionPropVehiculoDao();
      myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
    }
    
    public LimitacionPropVehiculo crearLimitacionPropVehiculo(TramiteBasico tramiteBasico,LimitacionPropVehiculo limitacionPropVehiculo, int idUsuario, String myIp, String myHost) {
        List lista = null;
        int id=0;
        try {
            conn = conexion.conectar();
            id=Funciones.obtenerId(conn, "GEN_LIMITACVEHICULO", "GEN_LIMITACVEHICULO", myMotor);
            limitacionPropVehiculo.setIDLIMITAC_VEHICULO(id);
            limitacionPropVehiculoDao.create(conn, limitacionPropVehiculo);
            limitacionPropVehiculo = new LimitacionPropVehiculo();
            limitacionPropVehiculo.setIDLIMITAC_VEHICULO(id);
            lista=limitacionPropVehiculoDao.searchMatching(conn, limitacionPropVehiculo);
            if(lista!=null && lista.size()>0){
                limitacionPropVehiculo=(LimitacionPropVehiculo)lista.get(0);
            }
            //auditar insert
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("LIMITACIONPROP_VEHICULO");
            myAuditSx.setCAMPOCLAVE("IDLIMITAC_VEHICULO");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(limitacionPropVehiculo.getIDLIMITAC_VEHICULO()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, limitacionPropVehiculo, 0);

            
        } catch (Exception e) {
            e.printStackTrace();
            limitacionPropVehiculo.setIDLIMITAC_VEHICULO(-1);
          } finally {
            conexion.cerrarCx();
        }
        return limitacionPropVehiculo;
    }
    
    public boolean saveLimitacionPropVehiculo(TramiteBasico tramiteBasico, LimitacionPropVehiculo limitacionPropVehiculo, int idUsuario, String myIp, String myHost) {
        boolean respuesta;
        try {
            conn = conexion.conectar();
            //auditar edicion
            LimitacionPropVehiculo ant = new LimitacionPropVehiculo();
            ant.setIDLIMITAC_VEHICULO(limitacionPropVehiculo.getIDLIMITAC_VEHICULO());
            limitacionPropVehiculoDao.load(conn, ant);
            limitacionPropVehiculoDao.save(conn, limitacionPropVehiculo);
            respuesta = true;
            //auditar edicion
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("LIMITACIONPROP_VEHICULO");
            myAuditSx.setCAMPOCLAVE("IDLIMITAC_VEHICULO");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(limitacionPropVehiculo.getIDLIMITAC_VEHICULO()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEdicion(conn, myAuditSx, ant, limitacionPropVehiculo, myIp, myHost, 0);

        } catch (Exception e) {
            e.printStackTrace();
            respuesta = false;
          } finally {
            conexion.cerrarCx();
        }
        return respuesta;
    }
    
    public List getLimitacionPropVehiculo(LimitacionPropVehiculo limitacionPropVehiculo) {
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = limitacionPropVehiculoDao.searchMatching(conn, limitacionPropVehiculo);
        } catch (Exception e) {
            e.printStackTrace();
          } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
}
