package modelo.logica.comparendos.liquidacion;

import java.sql.Connection;

import java.util.ArrayList;
import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.comparendos.liquidacion.tarifas.ItemsLiquidacionCompDao;
import modelo.datos.dao.comparendos.liquidacion.tarifas.LtarifasCompDao;
import modelo.datos.dao.comparendos.liquidacion.tarifas.LtarifasDetCompDao;
import modelo.datos.dao.comparendos.liquidacion.tarifas.TramiteContravencionalCompDao;
import modelo.datos.dao.comparendos.liquidacion.tarifas.ViewDetalleTarifaCompDao;
import modelo.datos.objetos.comparendos.liquidacion.tarifas.ItemsLiquidacionComp;
import modelo.datos.objetos.comparendos.liquidacion.tarifas.LtarifasComp;
import modelo.datos.objetos.comparendos.liquidacion.tarifas.LtarifasDetComp;
import modelo.datos.objetos.comparendos.liquidacion.tarifas.TramiteContravencionalComp;
import modelo.datos.objetos.comparendos.liquidacion.tarifas.ViewDetalleTarifaComp;
import modelo.datos.objetos.generales.AuditoriaSystem;

import utilidades.Auditoria;
import utilidades.Funciones;


public class GestionServiciosTarifasComp {
    Conexion conexion;
    Connection conn;
    String myMotor;

    public GestionServiciosTarifasComp() {
        super();
        crearObjetos();
    }

    public void crearObjetos() {
        myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        conexion = new Conexion();
    }

    public List getTramitesContravencional(TramiteContravencionalComp tramitecomtravencional) {
        List lista = null;
        TramiteContravencionalCompDao myTramiteContravencionalCompDao = new TramiteContravencionalCompDao();
        try {
            conn = conexion.conectarComparendos();
            lista = (ArrayList)myTramiteContravencionalCompDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public boolean crearTarifas(LtarifasComp ltarifascomp, int idUsuario, String myIp, String myHost) {
        boolean resultado;
        resultado = false;
        LtarifasCompDao myLtarifasCompDao = new LtarifasCompDao();
        int id = 0;

        try {
            conn = conexion.conectarComparendos();
            myMotor = myMotor.toUpperCase();
            id = Funciones.obtenerId(conn, "L_TARIFAS_LT_ID_GEN", "GEN_L_TARIFAS", myMotor);
            ltarifascomp.setLT_ID(id);
            myLtarifasCompDao.create(conn, ltarifascomp);
            resultado = true;
            //auditar insert
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("L_TARIFAS");
            myAuditSx.setCAMPOCLAVE("LT_ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(ltarifascomp.getLT_ID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, ltarifascomp, 0);

        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myLtarifasCompDao = null;
        }
        return resultado;
    }

    public boolean editarTarifa(LtarifasComp ltarifascomp, int idUsuario, String myIp, String myHost) {
        boolean resultado;
        resultado = false;
        LtarifasCompDao myLtarifasCompDao = new LtarifasCompDao();
        try {
            conn = conexion.conectarComparendos();
            //auditar edicion
            LtarifasComp ant = new LtarifasComp();
            ant.setLT_ID(ltarifascomp.getLT_ID());
            myLtarifasCompDao.load(conn, ant);
            myLtarifasCompDao.save(conn, ltarifascomp);
            resultado = true;
            //auditar edicion
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("L_TARIFAS");
            myAuditSx.setCAMPOCLAVE("LT_ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(ltarifascomp.getLT_ID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEdicion(conn, myAuditSx, ant, ltarifascomp, myIp, myHost, 0);

        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myLtarifasCompDao = null;
        }
        return resultado;
    }

    public List getLtarifas(LtarifasComp ltarifascomp) {
        List lista;
        lista = null;
        try {
            conn = conexion.conectarComparendos();
            LtarifasCompDao myLtarifasCompDao = new LtarifasCompDao();
            lista = myLtarifasCompDao.searchMatching(conn, ltarifascomp);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
    public List getLtarifasPorVigencia(LtarifasComp ltarifascomp, int vigenciaInicial, int vigenciaFinal) {
        List lista;
        lista = null;
        try {
            conn = conexion.conectarComparendos();
            LtarifasCompDao myLtarifasCompDao = new LtarifasCompDao();
            lista = myLtarifasCompDao.buscarPorVigencia(conn, ltarifascomp, vigenciaInicial, vigenciaFinal);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getLTtarifas() {
        List lista;
        lista = null;
        try {
            conn = conexion.conectarComparendos();
            LtarifasCompDao myLtarifasCompDao = new LtarifasCompDao();
            lista = myLtarifasCompDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public boolean eliminarTarifas(LtarifasComp ltarifascomp, int idUsuario, String myIp, String myHost) {
        boolean resultado;
        resultado = false;
        LtarifasCompDao myLtarifasCompDao = new LtarifasCompDao();
        try {
            conn = conexion.conectarComparendos();
            //auditar eliminar
            myLtarifasCompDao.load(conn, ltarifascomp);
            myLtarifasCompDao.delete(conn, ltarifascomp);
            resultado = true;
            //auditar eliminar
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("L_TARIFAS");
            myAuditSx.setCAMPOCLAVE("LT_ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(ltarifascomp.getLT_ID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEliminacion(conn, myAuditSx, ltarifascomp, 0);

        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myLtarifasCompDao = null;
        }
        return resultado;
    }

    public List getLtarifasDet(ViewDetalleTarifaComp viewdetalletarifacomp) {
        List lista;
        lista = null;
        try {
            conn = conexion.conectarComparendos();
            ViewDetalleTarifaCompDao myViewDetalleTarifaCompDao = new ViewDetalleTarifaCompDao();
            lista = myViewDetalleTarifaCompDao.searchMatching(conn, viewdetalletarifacomp);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public ViewDetalleTarifaComp getLtarifaDetId(ViewDetalleTarifaComp viewdetalletarifacomp) {
        ViewDetalleTarifaCompDao myViewDetalleTarifaCompDao = new ViewDetalleTarifaCompDao();
        try {
            conn = conexion.conectarComparendos();
            myViewDetalleTarifaCompDao.load(conn, viewdetalletarifacomp);
        } catch (Exception e) {
            e.printStackTrace();
            viewdetalletarifacomp.setLITEM_ID(-1);
        } finally {
            conexion.cerrarCx();
        }
        return viewdetalletarifacomp;
    }

    public List getTItemsLiquidacion(ItemsLiquidacionComp itemliquidacioncomp) {
        List lista;
        lista = null;
        try {
            conn = conexion.conectarComparendos();
            ItemsLiquidacionCompDao myItemsLiquidacionCompDao = new ItemsLiquidacionCompDao();
            lista = myItemsLiquidacionCompDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public boolean eliminarTarifasComp(LtarifasComp ltarifascomp, int idUsuario, String myIp, String myHost) {
        boolean resultado;
        resultado = false;
        LtarifasCompDao myLtarifasCompDao = new LtarifasCompDao();
        try {
            conn = conexion.conectarComparendos();
            //auditar eliminar
            myLtarifasCompDao.load(conn, ltarifascomp);
            myLtarifasCompDao.delete(conn, ltarifascomp);
            resultado = true;
            //auditar eliminar
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("L_TARIFAS");
            myAuditSx.setCAMPOCLAVE("LT_ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(ltarifascomp.getLT_ID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEliminacion(conn, myAuditSx, ltarifascomp, 0);

        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myLtarifasCompDao = null;
        }
        return resultado;
    }

    public boolean editarTarifaComp(LtarifasComp ltarifascomp, int idUsuario, String myIp, String myHost) {
        boolean resultado;
        resultado = false;
        LtarifasCompDao myLtarifasCompDao = new LtarifasCompDao();
        try {
            conn = conexion.conectarComparendos();
            //auditar edicion
            LtarifasComp ant = new LtarifasComp();
            ant.setLT_ID(ltarifascomp.getLT_ID());
            myLtarifasCompDao.load(conn, ant);
            myLtarifasCompDao.save(conn, ltarifascomp);
            resultado = true;
            //auditar edicion
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("L_TARIFAS");
            myAuditSx.setCAMPOCLAVE("LT_ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(ltarifascomp.getLT_ID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEdicion(conn, myAuditSx, ant, ltarifascomp, myIp, myHost, 0);

        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myLtarifasCompDao = null;
        }
        return resultado;
    }

    public boolean crearDetTarifasComp(LtarifasDetComp ltarifasdetcomp, int idUsuario, String myIp, String myHost) {
        boolean resultado;
        resultado = false;
        LtarifasDetCompDao myLtarifasDetCompDao = new LtarifasDetCompDao();
        int id = 0;

        try {
            conn = conexion.conectarComparendos();
            myMotor = myMotor.toUpperCase();
            id = Funciones.obtenerId(conn, "L_TARIFASDET_LTD_ID_GEN", "GEN_L_TARIFASDET", myMotor);
            ltarifasdetcomp.setLTD_ID(id);
            myLtarifasDetCompDao.create(conn, ltarifasdetcomp);
            resultado = true;
            //auditar insert
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("L_TARIFASDET");
            myAuditSx.setCAMPOCLAVE("LTD_ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(ltarifasdetcomp.getLTD_ID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, ltarifasdetcomp, 0);

        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myLtarifasDetCompDao = null;
        }
        return resultado;
    }

    public boolean editarDetTarifaComp(LtarifasDetComp ltarifasdetcomp, int idUsuario, String myIp, String myHost) {
        boolean resultado;
        resultado = false;
        LtarifasDetCompDao myLtarifasDetCompDao = new LtarifasDetCompDao();
        try {
            conn = conexion.conectarComparendos();
            //auditar edicion
            LtarifasDetComp ant = new LtarifasDetComp();
            ant.setLTD_ID(ltarifasdetcomp.getLTD_ID());
            myLtarifasDetCompDao.load(conn, ant);
            myLtarifasDetCompDao.save(conn, ltarifasdetcomp);
            resultado = true;
            //auditar edicion
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("L_TARIFASDET");
            myAuditSx.setCAMPOCLAVE("LTD_ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(ltarifasdetcomp.getLTD_ID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEdicion(conn, myAuditSx, ant, ltarifasdetcomp, myIp, myHost, 0);

        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myLtarifasDetCompDao = null;
        }
        return resultado;
    }

    public boolean eliminarDetTarifaComp(LtarifasDetComp ltarifasdetcomp, int idUsuario, String myIp, String myHost) {
        boolean resultado;
        resultado = false;
        LtarifasDetCompDao myLtarifasDetCompDao = new LtarifasDetCompDao();
        try {
            conn = conexion.conectarComparendos();
            //auditar eliminar
            myLtarifasDetCompDao.load(conn, ltarifasdetcomp);
            myLtarifasDetCompDao.delete(conn, ltarifasdetcomp);
            resultado = true;
            //auditar eliminar
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("L_TARIFASDET");
            myAuditSx.setCAMPOCLAVE("LTD_ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(ltarifasdetcomp.getLTD_ID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEliminacion(conn, myAuditSx, ltarifasdetcomp, 0);

        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myLtarifasDetCompDao = null;
        }
        return resultado;
    }

}
