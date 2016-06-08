package modelo.logica.generales;

//import com.bea.core.repackaged.springframework.dao.support.DaoSupport;

import java.sql.Array;
import java.sql.Connection;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.generales.EmpresaDao;
import modelo.datos.dao.generales.PersonaDao;
import modelo.datos.dao.accesorias.CiudadDao;
import modelo.datos.dao.medidasCautelares.J_PendienteDao;
import modelo.datos.dao.generales.RepresentanteLegalDao;
import modelo.datos.dao.generales.SucursalDao;
import modelo.datos.dao.generales.vehiculo.VehiculoDao;
import modelo.datos.dao.generales.vehiculo.VehiculoDao;
import modelo.datos.dao.generales.vistas.ViewTramitesVehiculoDao;
import modelo.datos.dao.liquidacion.ConceptosTarifaDao;
import modelo.datos.dao.liquidacion.SalarioDao;
import modelo.datos.dao.liquidacion.TarifaDao;

import modelo.datos.dao.medidasCautelares.JPendienteViewCTDao;
import modelo.datos.objetos.generales.Empresa;
import modelo.datos.objetos.generales.Persona;
import modelo.datos.objetos.accesorias.Ciudad;
import modelo.datos.objetos.generales.AuditoriaSystem;
import modelo.datos.objetos.medidasCautelares.J_Pendiente;
import modelo.datos.objetos.generales.RepresentanteLegal;
import modelo.datos.objetos.generales.Sucursal;
import modelo.datos.objetos.generales.vehiculo.Vehiculo;
import modelo.datos.objetos.liquidacion.Tarifa;

import modelo.datos.objetos.medidasCautelares.JPendienteViewCT;

import utilidades.Auditoria;
import utilidades.Compilador;
import utilidades.Funciones;

public class GestionServiciosMedidasCautelaresLocal {
    
  Conexion conexion;
  Connection conn;
  PersonaDao personaDao;
  VehiculoDao vehiculoDao;
  EmpresaDao empresaDao;
  J_PendienteDao medidaCautelarDao;
  String myMotor;
  
    public GestionServiciosMedidasCautelaresLocal() {
        super();
        crearObjetos();
    }
    
    private void crearObjetos(){
      conexion = new Conexion();
      personaDao = new PersonaDao();
      medidaCautelarDao = new J_PendienteDao();
      myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
    }
    
    public J_Pendiente crearMedidaCautelar(J_Pendiente medidaCautelar,int idUsuario,String myIp,String myHost){
      List lista = null;
      //Campos para la auditoria
      Auditoria myAuditoria;
      AuditoriaSystem myAuditSx;
      //--Campos para la auditoria              
      int id;
      try {
          conn = conexion.conectar();
          medidaCautelar.setJP_ESTADO("ACT");
          medidaCautelar.setJP_ACTIVO(1);
          id=Funciones.obtenerId(conn, "GEN_J_PENDIENTE_JP_ID", "GEN_J_PENDIENTE", myMotor);
          medidaCautelar.setJP_ID(id);
          medidaCautelarDao.create(conn, medidaCautelar);
          id=medidaCautelarDao.ultimoId(conn);
          //Pasos para la auditoria
          myAuditoria = new Auditoria();
          myAuditSx= new AuditoriaSystem();
          myAuditSx.setTABLAAFECTADA("J_PENDIENTE");
          myAuditSx.setCAMPOCLAVE("JP_ID");
          myAuditSx.setVLRCAMPOCLAVE(String.valueOf(id));
          myAuditSx.setID_USUARIO(idUsuario);
          myAuditSx.setIP(myIp);
          myAuditSx.setNOMBREEQUIPO(myHost);
          myAuditoria.auditarInsersion(conn,myAuditSx, medidaCautelar,0);
          //-- para la auditoria
      } catch (Exception e) {
          e.printStackTrace();

      } finally {
          conexion.cerrarCx();
      }
      return medidaCautelar;
      
    }
    
    public J_Pendiente levantarMedidaCautelar(J_Pendiente medidaCautelar, int idUsuario, String myIp, String myHost){
      List lista = null;
      //Campos para la auditoria
      Auditoria myAuditoria;
      AuditoriaSystem myAuditSx;
      //--Campos para la auditoria
      try {
          conn = conexion.conectar();
          medidaCautelar.setJP_ESTADO("RET");
          medidaCautelar.setJP_ACTIVO(0);          
          medidaCautelarDao.save(conn, medidaCautelar);
          //Pasos para la auditoria
          myAuditoria = new Auditoria();
          myAuditSx= new AuditoriaSystem();
          myAuditSx.setTABLAAFECTADA("J_PENDIENTE");
          myAuditSx.setCAMPOCLAVE("JP_ID");
          myAuditSx.setVLRCAMPOCLAVE(String.valueOf(medidaCautelar.getJP_ID()));
          myAuditSx.setID_USUARIO(idUsuario);
          myAuditSx.setIP(myIp);
          myAuditSx.setNOMBREEQUIPO(myHost);
          myAuditSx.setDESCRIPOPERACION(" Levantamiento de Medida Cautelar ");
          myAuditSx.setTIPOPERACION("E");
          myAuditoria.auditarOtraOp(conn,myAuditSx,0);
          //-- para la auditoria
          lista=medidaCautelarDao.searchMatching(conn, medidaCautelar);
          if(lista!=null && lista.size()>0){
              medidaCautelar=(J_Pendiente)lista.get(0);
          }
      } catch (Exception e) {
          e.printStackTrace();

      } finally {
          conexion.cerrarCx();
      }
      return medidaCautelar;      
    }
    
    public J_Pendiente actualizarMedidaCautelar(J_Pendiente medidaCautelar,int idUsuario,String myIp,String myHost){
      //Campos para la auditoria
      J_Pendiente anterior;
      Auditoria myAuditoria;
      AuditoriaSystem myAuditSx;
      //--Campos para la auditoria
      List lista = null;
      try {
          conn = conexion.conectar();
          //Pasos previos Auditoria
          anterior= new J_Pendiente();
          anterior.setJP_ID(medidaCautelar.getJP_ID());
          lista=medidaCautelarDao.searchMatching(conn, anterior);
          if(lista!=null && lista.size()>0)
          {
              anterior=(J_Pendiente)lista.get(0);
          }
          else
          {
              anterior=null;
          }
          //Pasos previos para auditoria
          medidaCautelarDao.save(conn, medidaCautelar);
          //Pasos para la auditoria
          myAuditoria = new Auditoria();
          myAuditSx= new AuditoriaSystem();
          myAuditSx.setTABLAAFECTADA("J_PENDIENTE");
          myAuditSx.setCAMPOCLAVE("JP_ID");
          myAuditSx.setVLRCAMPOCLAVE(String.valueOf(medidaCautelar.getJP_ID()));
          myAuditSx.setID_USUARIO(idUsuario);
          myAuditSx.setIP(myIp);
          myAuditSx.setNOMBREEQUIPO(myHost);
          myAuditoria.auditarEdicion(conn,myAuditSx,anterior,medidaCautelar,myIp,myHost,0);
          //-- para la auditoria
          lista=medidaCautelarDao.searchMatching(conn, medidaCautelar);
          if(lista!=null && lista.size()>0){
              medidaCautelar=(J_Pendiente)lista.get(0);
          }
      } catch (Exception e) {
          e.printStackTrace();

      } finally {
          conexion.cerrarCx();
      }
      return medidaCautelar;      
    }
    
    public List ListarMedidaCautelar(J_Pendiente medidaCautelar){
      List lista = null;      
      try {
        conn = conexion.conectar();
        lista=medidaCautelarDao.searchMatching(conn, medidaCautelar);
      }
      catch (Exception e) {
          e.printStackTrace();
      }
      finally{
        conexion.cerrarCx();
      }
      return lista;
    }
    
    public List getMedidasCautelaresCT(JPendienteViewCT myMedida){
        JPendienteViewCTDao myMedidaDao;
        List lista = null;
        int id=0;
        try {
            conn = conexion.conectar();
            myMedidaDao = new JPendienteViewCTDao();
            lista = myMedidaDao.searchMatching(conn, myMedida);
        }
        catch (Exception e){
          e.printStackTrace();
        }
        finally{
          conexion.cerrarCx();
        }
        return lista;
    }
}
