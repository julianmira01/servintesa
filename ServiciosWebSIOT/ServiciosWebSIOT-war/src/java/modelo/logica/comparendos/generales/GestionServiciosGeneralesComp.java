package modelo.logica.comparendos.generales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.NotFoundException;
import modelo.datos.dao.comparendos.accesorias.InfraccionesCompDao;
import modelo.datos.dao.comparendos.generales.AgenteCompDao;
import modelo.datos.dao.comparendos.generales.BancoDao;
import modelo.datos.dao.comparendos.generales.ComparendoCompDao;
import modelo.datos.dao.comparendos.generales.EstadoAlcoholemiaDao;
import modelo.datos.dao.comparendos.generales.FormaPagoDao;
import modelo.datos.dao.comparendos.generales.HistoricoEstadosCompDao;
import modelo.datos.dao.comparendos.generales.InfracionComparendoCompDao;
import modelo.datos.dao.comparendos.generales.InfractorCompDao;
import modelo.datos.dao.comparendos.generales.OrigenDescargoDao;
import modelo.datos.dao.comparendos.generales.PropietarioVehCompDao;
import modelo.datos.dao.comparendos.generales.ResolucionesSimitDao;
import modelo.datos.dao.comparendos.generales.TarjetasCreditoDao;
import modelo.datos.dao.comparendos.generales.TestigoCompDao;
import modelo.datos.dao.comparendos.generales.TipoPagoDao;
import modelo.datos.dao.comparendos.generales.TransitoCompDao;
import modelo.datos.dao.comparendos.generales.VehiculosCompDao;
import modelo.datos.dao.comparendos.generales.ViewComparendosResolSancionCompDao;
import modelo.datos.dao.comparendos.generales.ViewLiquidacionComparendoDao;
import modelo.datos.objetos.comparendos.accesorias.InfraccionesComp;
import modelo.datos.objetos.comparendos.generales.AgenteComp;
import modelo.datos.objetos.comparendos.generales.Banco;
import modelo.datos.objetos.comparendos.generales.ComparendoComp;
import modelo.datos.objetos.comparendos.generales.EstadoAlcoholemia;
import modelo.datos.objetos.comparendos.generales.FormaPago;
import modelo.datos.objetos.comparendos.generales.HistoricoEstadosComp;
import modelo.datos.objetos.comparendos.generales.InfracionComparendoComp;
import modelo.datos.objetos.comparendos.generales.InfractorComp;
import modelo.datos.objetos.comparendos.generales.OrigenDescargo;
import modelo.datos.objetos.comparendos.generales.PropietarioVehComp;
import modelo.datos.objetos.comparendos.generales.ResolucionesSimit;
import modelo.datos.objetos.comparendos.generales.TarjetasCredito;
import modelo.datos.objetos.comparendos.generales.TestigoComp;
import modelo.datos.objetos.comparendos.generales.TipoPago;
import modelo.datos.objetos.comparendos.generales.TransitoComp;
import modelo.datos.objetos.comparendos.generales.VehiculosComp;
import modelo.datos.objetos.comparendos.generales.ViewComparendosResolSancionComp;
import modelo.datos.objetos.comparendos.generales.ViewLiquidacionComparendo;
import modelo.datos.objetos.generales.AuditoriaSystem;

import modelo.logica.comparendos.GestionServiciosComparendos;

import modelo.datos.dao.comparendos.generales.PasosDao;
import modelo.datos.objetos.comparendos.generales.Pasos;

import modelo.datos.objetos.comparendos.generales.Procesos;
import modelo.datos.dao.comparendos.generales.ProcesosDao;

import modelo.datos.objetos.comparendos.generales.Secuenciaprocesos;
import modelo.datos.dao.comparendos.generales.SecuenciaprocesosDao;

import modelo.datos.objetos.accesorias.Diasfestivos;
import modelo.datos.dao.accesorias.DiasfestivosDao;

import modelo.datos.objetos.generales.SumarTiempoFecha;

import modelo.logica.generales.GestionServiciosDiasfestivos;

import utilidades.Auditoria;
import utilidades.Funciones;

import modelo.datos.objetos.generales.SumarTiempoFecha;


public class GestionServiciosGeneralesComp {

    Conexion conexion;
    Connection conn;
    String myMotor;

    public GestionServiciosGeneralesComp() {
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

    public List getAgentes(AgenteComp agente) {
        List lista;
        lista = null;
        try {
            conn = conexion.conectarComparendos();
            AgenteCompDao myAgenteCompDao = new AgenteCompDao();
            lista = myAgenteCompDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
    public List buscarAgentes(AgenteComp agente) {
        List lista;
        lista = null;
        try {
            conn = conexion.conectarComparendos();
            AgenteCompDao myAgenteCompDao = new AgenteCompDao();
            lista = myAgenteCompDao.searchMatching(conn, agente);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
    
    

    public AgenteComp getOneAgente(AgenteComp agente) {
        List lista;
        lista = null;
        AgenteComp res = null;
        try {
            conn = conexion.conectarComparendos();
            res = new AgenteComp();
            AgenteCompDao myAgenteCompDao = new AgenteCompDao();
            lista = myAgenteCompDao.searchMatching(conn, agente);
            if (lista != null && lista.size() > 0)
                res = (AgenteComp)lista.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public InfractorComp getInfractor(InfractorComp infractor) {
        List lista;
        lista = null;
        InfractorComp myInfractor = new InfractorComp();
        try {
            conn = conexion.conectarComparendos();
            InfractorCompDao myInfracCompDao = new InfractorCompDao();
            lista = myInfracCompDao.searchMatching(conn, infractor);
            if (lista != null && lista.size() > 0)
                myInfractor = (InfractorComp)lista.get(0);
            else
                myInfractor.setID_INFRACTOR(-1);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return myInfractor;
    }

    public int crearInfractor(InfractorComp infractor, int idUsuario, String myIp, String myHost) {
        List lista;
        lista = null;
        int res = -1;
        int id;
        try {
            conn = conexion.conectarComparendos();
            myMotor = myMotor.toUpperCase();
            id = Funciones.obtenerId(conn, "GEN_INFRACTOR", "GEN_INFRACTOR", myMotor);
            infractor.setID_INFRACTOR(id);
            InfractorCompDao myInfracCompDao = new InfractorCompDao();
            myInfracCompDao.create(conn, infractor);
            res = id;
            //auditar insert
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("INFRACTOR");
            myAuditSx.setCAMPOCLAVE("ID_INFRACTOR");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(infractor.getID_INFRACTOR()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, infractor, 0);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            conexion.cerrarCx();
        }
        return res;
    }

    public boolean eliminarInfractor(InfractorComp infractor, int idUsuario, String myIp, String myHost) {
        boolean res = false;
        InfractorComp myInfractor = null;
        try {
            conn = conexion.conectarComparendos();
            InfractorCompDao myInfracCompDao = new InfractorCompDao();
            //auditar eliminar
            myInfracCompDao.load(conn, infractor);
            myInfracCompDao.delete(conn, infractor);
            res = true;
            //auditar eliminar
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("INFRACTOR");
            myAuditSx.setCAMPOCLAVE("ID_INFRACTOR");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(infractor.getID_INFRACTOR()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEliminacion(conn, myAuditSx, infractor, 0);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public boolean actualizarInfractor(InfractorComp infractor, int idUsuario, String myIp, String myHost) {
        boolean res = false;
        InfractorComp myInfractor = null;
        try {
            conn = conexion.conectarComparendos();
            InfractorCompDao myInfracCompDao = new InfractorCompDao();
            //auditar edicion
            InfractorComp ant = new InfractorComp();
            ant.setID_INFRACTOR(infractor.getID_INFRACTOR());
            myInfracCompDao.load(conn, ant);
            myInfracCompDao.save(conn, infractor);
            res = true;
            //auditar edicion
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("INFRACTOR");
            myAuditSx.setCAMPOCLAVE("ID_INFRACTOR");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(infractor.getID_INFRACTOR()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEdicion(conn, myAuditSx, ant, infractor, myIp, myHost, 0);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public List listarInfractorComp() {
        List lista = null;
        InfractorComp myInfractor = null;
        try {
            conn = conexion.conectarComparendos();
            InfractorCompDao myInfracCompDao = new InfractorCompDao();
            lista = myInfracCompDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getComparendo() {
        List lista;
        lista = null;
        ComparendoCompDao comparendoDao = new ComparendoCompDao();
        try {
            conn = conexion.conectarComparendos();
            lista = comparendoDao.loadAll(conn);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List searchComparendo(ComparendoComp comparendo) {
        List lista;
        lista = null;

        ComparendoCompDao comparendoDao = new ComparendoCompDao();
        try {
            conn = conexion.conectarComparendos();
            lista = comparendoDao.searchMatching(conn, comparendo);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List searchComparendoEstado(ComparendoComp comparendo) {
        List lista;
        lista = null;

        ComparendoCompDao comparendoDao = new ComparendoCompDao();
        try {
            conn = conexion.conectarComparendos();
            String estadosAdmitidos;
            
            estadosAdmitidos = "";
        
            try{
                estadosAdmitidos = Funciones.leer_ini("/WSTransito.ini", "ESTADOSCOM_ADMITIDOS_LIQUIDACION");
            }catch(Exception exce){}
            if(estadosAdmitidos.equals(""))
            try{
                estadosAdmitidos = Funciones.leer_ini("c:\\WSTransito.ini", "ESTADOSCOM_ADMITIDOS_LIQUIDACION");
            }catch(Exception exce){}
            
            
            String[] listaEstadosAdmitidos = estadosAdmitidos.split(",");
            lista = comparendoDao.searchMatching(conn, comparendo);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
    public ComparendoComp searchOneComparendo(ComparendoComp comparendo) {
        List lista;
        lista = null;
        ComparendoComp resultado = new ComparendoComp();
        ComparendoCompDao comparendoDao = new ComparendoCompDao();
        try {
            conn = conexion.conectarComparendos();
            lista = comparendoDao.searchMatching(conn, comparendo);
            if (lista != null && lista.size() > 0)
                resultado = (ComparendoComp)lista.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }

    public int crearComparendo(ComparendoComp comparendo, int idUsuario, String myIp, String myHost) {
        List lista = null;
        int id = -1;
        ComparendoCompDao comparendoDao = new ComparendoCompDao();
        try {
            conn = conexion.conectarComparendos();
            myMotor = myMotor.toUpperCase();
            id = Funciones.obtenerId(conn, "GENCOMPARENDO", "GEN_COMPARENDO", myMotor);
            comparendo.setID_COMPARENDO(id);
            comparendo.setHORAREGISTRO(Funciones.getHoraSistemaString(conn));
            comparendo.setFECHAREGISTRO(Funciones.getFechaSistema(conn,myMotor));
            comparendoDao.create(conn, comparendo);
            
        } catch (Exception e) {
            id = -1;
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        
        if (id >= 0) {
            GestionServiciosComparendos gestionComparendos = new GestionServiciosComparendos();
            gestionComparendos.actualizarEstadoComparendo(comparendo.getNUMEROCOMPARENDO(), "T", idUsuario, myIp, myHost);
        }
        return id;
    }


    public boolean actualizarComparendo(ComparendoComp comparendo, int idUsuario, String myIp, String myHost) {
        boolean res = false;
        ComparendoCompDao comparendoDao = new ComparendoCompDao();
        try {
            conn = conexion.conectarComparendos();
            //auditar edicion
            ComparendoComp ant = new ComparendoComp();
            ant.setID_COMPARENDO(comparendo.getID_COMPARENDO());
            comparendoDao.load(conn, ant);
            comparendoDao.save(conn, comparendo);
            res = true;
            //auditar edicion
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("COMPARENDO");
            myAuditSx.setCAMPOCLAVE("ID_COMPARENDO");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(comparendo.getID_COMPARENDO()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEdicion(conn, myAuditSx, ant, comparendo, myIp, myHost, 0);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    
    public boolean eliminarComparendo(ComparendoComp comparendo, int idUsuario, String myIp, String myHost) {
        boolean res = false;
        ComparendoComp myComparendo = null;
        try {
            conn = conexion.conectarComparendos();
            ComparendoCompDao myComparendoDao = new ComparendoCompDao();
            //auditar eliminar
            myComparendoDao.load(conn, comparendo);
            myComparendoDao.delete(conn, comparendo);
            InfracionComparendoComp infraccionComparendo = new InfracionComparendoComp();
            infraccionComparendo.setIDCOMPARENDO(comparendo.getID_COMPARENDO());
            eliminarInfraccionComparendo(infraccionComparendo,idUsuario,myIp,myHost);
            res = true;
            //auditar eliminar
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("COMPARENDO");
            myAuditSx.setCAMPOCLAVE("ID_COMPARENDO");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(comparendo.getID_COMPARENDO()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEliminacion(conn, myAuditSx, comparendo, 0);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }


    /*public boolean eliminarComparendo(ComparendoComp comparendo, int idUsuario, String myIp, String myHost) {
        boolean res = false;
        ComparendoComp myComparendo = null;
        try {
            conn = conexion.conectarComparendos();
            ComparendoCompDao myComparendoDao = new ComparendoCompDao();
            //auditar eliminar
            myComparendoDao.load(conn, comparendo);
            myComparendoDao.delete(conn, comparendo);
            res = true;
            //auditar eliminar
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("COMPARENDO");
            myAuditSx.setCAMPOCLAVE("ID_COMPARENDO");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(comparendo.getID_COMPARENDO()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEliminacion(conn, myAuditSx, comparendo, 0);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }*/


    public int crearVehiculoComp(VehiculosComp vehiculocomp, int idUsuario, String myIp, String myHost) {
        int res = -1;
        int id;
        List lista = null;
        VehiculosCompDao vehiculocompDao = new VehiculosCompDao();
        try {
            conn = conexion.conectarComparendos();
            myMotor = myMotor.toUpperCase();
            id = Funciones.obtenerId(conn, "GENVEHICULOCOMP", "GEN_VEHICULOCOMP", myMotor);
            vehiculocomp.setIDVEHICULOCOMP(id);
            vehiculocompDao.create(conn, vehiculocomp);
            VehiculosComp tmp = new VehiculosComp();
            tmp.setIDVEHICULOCOMP(id);
            lista = vehiculocompDao.searchMatching(conn, tmp);
            if (lista != null && lista.size() > 0) {
                vehiculocomp = (VehiculosComp)lista.get(0);
                res = vehiculocomp.getIDVEHICULOCOMP();
            }
            //auditar insert
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("VEHICULOSCOM");
            myAuditSx.setCAMPOCLAVE("IDVEHICULOCOMP");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(vehiculocomp.getIDVEHICULOCOMP()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, vehiculocomp, 0);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public boolean actualizarVehiculoComp(VehiculosComp vehiculocomp, int idUsuario, String myIp, String myHost) {
        boolean res = true;
        VehiculosCompDao vehiculocompDao = new VehiculosCompDao();
        try {
            conn = conexion.conectarComparendos();
            //auditar edicion
            VehiculosComp ant = new VehiculosComp();
            ant.setIDVEHICULOCOMP(vehiculocomp.getIDVEHICULOCOMP());
            vehiculocompDao.load(conn, ant);
            vehiculocompDao.save(conn, vehiculocomp);
            res = true;
            //auditar edicion
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("VEHICULOSCOM");
            myAuditSx.setCAMPOCLAVE("IDVEHICULOCOMP");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(vehiculocomp.getIDVEHICULOCOMP()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEdicion(conn, myAuditSx, ant, vehiculocomp, myIp, myHost, 0);

        } catch (Exception e) {
            System.out.println("get: " + e.getStackTrace());
            System.out.println("Message: " + e.getMessage());
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public boolean eliminarVehiculoComp(VehiculosComp vehiculocomp, int idUsuario, String myIp, String myHost) {
        boolean res = false;
        VehiculosCompDao vehiculocompDao = new VehiculosCompDao();
        try {
            conn = conexion.conectarComparendos();
            //auditar eliminar
            vehiculocompDao.load(conn, vehiculocomp);
            vehiculocompDao.delete(conn, vehiculocomp);
            res = true;
            //auditar eliminar
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("VEHICULOSCOM");
            myAuditSx.setCAMPOCLAVE("IDVEHICULOCOMP");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(vehiculocomp.getIDVEHICULOCOMP()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEliminacion(conn, myAuditSx, vehiculocomp, 0);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public VehiculosComp getFirstVehiculoComp(VehiculosComp vehiculocomp) {

        List lista = null;
        VehiculosCompDao vehiculocompDao = new VehiculosCompDao();
        try {
            conn = conexion.conectarComparendos();
            lista = vehiculocompDao.searchMatching(conn, vehiculocomp);
            if (lista != null && lista.size() > 0)
                vehiculocomp = (VehiculosComp)lista.get(0);
            else
                vehiculocomp.setIDVEHICULOCOMP(-1);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return vehiculocomp;
    }

    public List getVehiculoComp(VehiculosComp vehiculocomp) {

        List lista = null;
        VehiculosCompDao vehiculocompDao = new VehiculosCompDao();
        try {
            conn = conexion.conectarComparendos();
            lista = vehiculocompDao.searchMatching(conn, vehiculocomp);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List ListarVehiculoComp() {

        List lista = null;
        VehiculosCompDao vehiculocompDao = new VehiculosCompDao();
        try {
            conn = conexion.conectarComparendos();
            lista = vehiculocompDao.loadAll(conn);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public int crearPropietarioVehiculo(PropietarioVehComp propietarioVehComp) {
        int res = -1;
        List lista = null;
        int id;
        PropietarioVehCompDao propietarioVehDao = new PropietarioVehCompDao();
        try {
            conn = conexion.conectarComparendos();
            myMotor = myMotor.toUpperCase();
            id = Funciones.obtenerId(conn, "GEN_PROPIETVEHICULO", "GEN_PROPIETVEHICULO", myMotor);
            propietarioVehComp.setID_PROPIETARIOVEH(id);
            propietarioVehDao.create(conn, propietarioVehComp);
            propietarioVehComp = new PropietarioVehComp();
            propietarioVehComp.setID_PROPIETARIOVEH(id);
            lista = propietarioVehDao.searchMatching(conn, propietarioVehComp);
            if (lista != null && lista.size() > 0) {
                propietarioVehComp = (PropietarioVehComp)lista.get(0);
                res = propietarioVehComp.getID_PROPIETARIOVEH();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;

    }

    public boolean actualizarPropietarioVehiculo(PropietarioVehComp propietarioVehComp, int idUsuario, String myIp, String myHost) {
        boolean res = false;
        PropietarioVehCompDao propietarioVehDao = new PropietarioVehCompDao();
        try {
            conn = conexion.conectarComparendos();
            //auditar edicion
            PropietarioVehComp ant = new PropietarioVehComp();
            ant.setID_PROPIETARIOVEH(propietarioVehComp.getID_PROPIETARIOVEH());
            propietarioVehDao.load(conn, ant);
            propietarioVehDao.save(conn, propietarioVehComp);
            res = true;
            //auditar edicion
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("PROPIETARIOVEHCOMPARENDO");
            myAuditSx.setCAMPOCLAVE("ID_PROPIETARIOVEH");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(propietarioVehComp.getID_PROPIETARIOVEH()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEdicion(conn, myAuditSx, ant, propietarioVehComp, myIp, myHost, 0);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public boolean eliminarPropietarioVehiculo(PropietarioVehComp propietarioVehComp, int idUsuario, String myIp, String myHost) {
        boolean res = false;
        PropietarioVehCompDao propietarioVehDao = new PropietarioVehCompDao();
        try {
            conn = conexion.conectarComparendos();
            //auditar eliminar
            propietarioVehDao.load(conn, propietarioVehComp);
            propietarioVehDao.delete(conn, propietarioVehComp);
            res = true;
            //auditar eliminar
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("PROPIETARIOVEHCOMPARENDO");
            myAuditSx.setCAMPOCLAVE("ID_PROPIETARIOVEH");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(propietarioVehComp.getID_PROPIETARIOVEH()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEliminacion(conn, myAuditSx, propietarioVehComp, 0);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public PropietarioVehComp getPropietarioVehiculo(PropietarioVehComp propietarioVehComp) {
        List lista = null;
        PropietarioVehCompDao propietarioVehDao = new PropietarioVehCompDao();
        try {
            conn = conexion.conectarComparendos();
            lista = propietarioVehDao.searchMatching(conn, propietarioVehComp);
            if (lista != null && lista.size() > 0)
                propietarioVehComp = (PropietarioVehComp)lista.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return propietarioVehComp;
    }

    public int crearTestigoComp(TestigoComp testigoComp) {
        int res = -1;
        List lista = null;
        TestigoCompDao testigoCompDao = new TestigoCompDao();
        int id;
        try {
            conn = conexion.conectarComparendos();
            myMotor = myMotor.toUpperCase();
            id = Funciones.obtenerId(conn, "GEN_TESTIGOCOMPARENDO", "GEN_TESTIGOCOMPARENDO", myMotor);
            testigoComp.setID_TESTIGO(id);
            testigoCompDao.create(conn, testigoComp);
            testigoComp = new TestigoComp();
            testigoComp.setID_TESTIGO(id);
            lista = testigoCompDao.searchMatching(conn, testigoComp);
            if (lista != null && lista.size() > 0) {
                testigoComp = (TestigoComp)lista.get(0);
                res = testigoComp.getID_TESTIGO();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public boolean actualizarTestigoComp(TestigoComp testigoComp) {
        boolean res = false;
        TestigoCompDao testigoCompDao = new TestigoCompDao();
        try {
            conn = conexion.conectarComparendos();
            testigoCompDao.save(conn, testigoComp);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public boolean eliminarTestigoComp(TestigoComp testigoComp) {
        boolean res = false;
        TestigoCompDao testigoCompDao = new TestigoCompDao();
        try {
            conn = conexion.conectarComparendos();
            testigoCompDao.delete(conn, testigoComp);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }


    public TestigoComp getTestigoComp(TestigoComp testigoComp) {
        List lista = null;
        TestigoCompDao testigoCompDao = new TestigoCompDao();
        try {
            conn = conexion.conectarComparendos();
            lista = testigoCompDao.searchMatching(conn, testigoComp);
            if (lista != null && lista.size() > 0)
                testigoComp = (TestigoComp)lista.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return testigoComp;
    }

    public boolean crearAgenteTto(AgenteComp agenteComp) {
        boolean res = false;
        AgenteCompDao agenteCompDao = new AgenteCompDao();
        int id;
        try {
            conn = conexion.conectarComparendos();
            myMotor = myMotor.toUpperCase();
            id = Funciones.obtenerId(conn, "GEN_AGENTETRANSITO", "GEN_AGENTETRANSITO", myMotor);
            agenteComp.setID_AGENTE(id);
            agenteCompDao.create(conn, agenteComp);
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public boolean actualizarAgenteTto(AgenteComp agenteComp) {
        boolean res = false;
        AgenteCompDao agenteCompDao = new AgenteCompDao();
        try {
            conn = conexion.conectarComparendos();
            agenteCompDao.save(conn, agenteComp);
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public boolean eliminarAgenteTto(AgenteComp agenteComp) {
        boolean res = false;
        AgenteCompDao agenteCompDao = new AgenteCompDao();
        try {
            conn = conexion.conectarComparendos();
            agenteCompDao.delete(conn, agenteComp);
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public String getNITTransito() {
        String res = "00000000";
        List lista = null;
        TransitoComp transitoComp = new TransitoComp();
        TransitoCompDao transitoCompDao = new TransitoCompDao();
        try {
            conn = conexion.conectarComparendos();
            lista = transitoCompDao.loadAll(conn);
            if (lista != null && lista.size() > 0) {
                transitoComp = (TransitoComp)lista.get(0);
                res = transitoComp.getNIT();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public String getPrefijoPol() {
        String res = "00000000";
        List lista = null;
        TransitoComp transitoComp = new TransitoComp();
        TransitoCompDao transitoCompDao = new TransitoCompDao();
        try {
            conn = conexion.conectarComparendos();
            lista = transitoCompDao.loadAll(conn);
            if (lista != null && lista.size() > 0) {
                transitoComp = (TransitoComp)lista.get(0);
                res = transitoComp.getPREFIJOPOLCADEPARTAMENTAL();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public boolean crearInfraccionComparendo(InfracionComparendoComp infraccionComparendo, int idUsuario, String myIp, String myHost) {
        boolean res = false;
        InfracionComparendoCompDao infraccionComparendoDao = new InfracionComparendoCompDao();
        int id;
        try {
            conn = conexion.conectarComparendos();
            infraccionComparendo.setIDESTADO(10);
            myMotor = myMotor.toUpperCase();
            id = Funciones.obtenerId(conn, "GEN_INFRACCIONCOMPARENDO", "GEN_INFRACCIONCOMPARENDO", myMotor);
            infraccionComparendo.setID(id);
            infraccionComparendoDao.create(conn, infraccionComparendo);
            res = true;
            //auditar insert
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("INFRACCIONCOMPARENDO");
            myAuditSx.setCAMPOCLAVE("ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(infraccionComparendo.getID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, infraccionComparendo, 0);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }
    
    public boolean crearInfraccionComparendoDesdePlanos(InfracionComparendoComp infraccionComparendo, int idUsuario, String myIp, String myHost) {
        boolean res = false;
        InfracionComparendoCompDao infraccionComparendoDao = new InfracionComparendoCompDao();
        int id;
        try {
            conn = conexion.conectarComparendos();
            //infraccionComparendo.setIDESTADO(10);
            
            myMotor = myMotor.toUpperCase();
            id = Funciones.obtenerId(conn, "GEN_INFRACCIONCOMPARENDO", "GEN_INFRACCIONCOMPARENDO", myMotor);
            infraccionComparendo.setID(id);
            infraccionComparendoDao.create(conn, infraccionComparendo);
            res = true;
            //auditar insert
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("INFRACCIONCOMPARENDO");
            myAuditSx.setCAMPOCLAVE("ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(infraccionComparendo.getID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, infraccionComparendo, 0);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public boolean actualizarInfraccionComparendo(InfracionComparendoComp infraccionComparendo, int idUsuario, String myIp, String myHost) {
        boolean res = false;
        InfracionComparendoCompDao infraccionComparendoDao = new InfracionComparendoCompDao();
        try {
            conn = conexion.conectarComparendos();
            //auditar edicion
            InfracionComparendoComp ant = new InfracionComparendoComp();
            ant.setID(infraccionComparendo.getID());
            infraccionComparendoDao.load(conn, ant);
            infraccionComparendoDao.save(conn, infraccionComparendo);
            res = true;
            //auditar edicion
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("INFRACCIONCOMPARENDO");
            myAuditSx.setCAMPOCLAVE("ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(infraccionComparendo.getID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEdicion(conn, myAuditSx, ant, infraccionComparendo, myIp, myHost, 0);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public boolean eliminarInfraccionComparendo(InfracionComparendoComp infraccionComparendo, int idUsuario, String myIp, String myHost) {
        boolean res = false;
        InfracionComparendoCompDao infraccionComparendoDao = new InfracionComparendoCompDao();
        try {
            conn = conexion.conectarComparendos();
            //auditar eliminar
            infraccionComparendoDao.load(conn, infraccionComparendo);
            infraccionComparendoDao.delete(conn, infraccionComparendo);
            res = true;
            //auditar eliminar
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("INFRACCIONCOMPARENDO");
            myAuditSx.setCAMPOCLAVE("ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(infraccionComparendo.getID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEliminacion(conn, myAuditSx, infraccionComparendo, 0);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public InfracionComparendoComp getInfraccionComparendo(InfracionComparendoComp infraccionComparendo) {
        List lista = null;
        InfracionComparendoCompDao infraccionComparendoDao = new InfracionComparendoCompDao();
        try {
            conn = conexion.conectarComparendos();
            lista = infraccionComparendoDao.searchMatching(conn, infraccionComparendo);
            if (lista != null && lista.size() > 0)
                infraccionComparendo = (InfracionComparendoComp)lista.get(0);
            else
                infraccionComparendo = null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return infraccionComparendo;
    }

    public List getInfraccionComparendos(InfracionComparendoComp infraccionComparendo) {
        List lista = null;
        try {
            conn = conexion.conectarComparendos();
            InfracionComparendoCompDao dao = new InfracionComparendoCompDao();
            lista = dao.searchMatching(conn, infraccionComparendo);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List buscarComparendosPorRangoFechaMasDiasHabilesPorcDesc(Calendar fecha, int diasHabilesIni,int diasHabilesFin,  ViewComparendosResolSancionComp myComparResolSanc, String tipoEstado, String porcDesc){
        
        String fechaFin1 = SumarTiempoFecha.restarDiasHabilesFecha(fecha, diasHabilesIni);
        
        String fechaFin2 = SumarTiempoFecha.restarDiasHabilesFecha(fecha, diasHabilesFin);
        
        List lista = null;
        ViewComparendosResolSancionCompDao myComparResolSancDao = new ViewComparendosResolSancionCompDao();
        try {
              conn = conexion.conectarComparendos();
              lista = myComparResolSancDao.buscarComparendosEnRangoFechasPorcDesc(conn, fechaFin2, fechaFin1, myComparResolSanc,tipoEstado, porcDesc);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

public List buscarComparendosPorRangoFechaMasDiasHabiles(Calendar fecha, int diasHabilesIni,int diasHabilesFin,  ViewComparendosResolSancionComp myComparResolSanc, String tipoEstado){
    
    String fechaFin1 = SumarTiempoFecha.restarDiasHabilesFecha(fecha, diasHabilesIni);
    
    String fechaFin2 = SumarTiempoFecha.restarDiasHabilesFecha(fecha, diasHabilesFin);
    
    List lista = null;
    ViewComparendosResolSancionCompDao myComparResolSancDao = new ViewComparendosResolSancionCompDao();
    try {
          conn = conexion.conectarComparendos();
          lista = myComparResolSancDao.buscarComparendosEnRangoFechas(conn, fechaFin2, fechaFin1, myComparResolSanc,tipoEstado);
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        conexion.cerrarCx();
    }
    return lista;
}

    public List buscarComparendosPorFechaMasDiasCalendarioPorcDesc(Calendar fecha, int diasCalendarioIni, int diasCalendarioFin, ViewComparendosResolSancionComp myComparResolSanc, String tipoEstado, String porcDesc){        
        
        String fechaFin1 = SumarTiempoFecha.restarDiasCalendario(fecha, diasCalendarioIni);
        
        String fechaFin2 = SumarTiempoFecha.restarDiasCalendario(fecha, diasCalendarioFin);
        
        List lista = null;
        ViewComparendosResolSancionCompDao myComparResolSancDao = new ViewComparendosResolSancionCompDao();
        try {
              conn = conexion.conectarComparendos();
              lista = myComparResolSancDao.buscarComparendosEnRangoFechasPorcDesc(conn, fechaFin2, fechaFin1, myComparResolSanc,tipoEstado, porcDesc);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
    public List buscarComparendosPorFechaMasDiasCalendario(Calendar fecha, int diasCalendarioIni, int diasCalendarioFin, ViewComparendosResolSancionComp myComparResolSanc, String tipoEstado){        
        
        String fechaFin1 = SumarTiempoFecha.restarDiasCalendario(fecha, diasCalendarioIni);
        
        String fechaFin2 = SumarTiempoFecha.restarDiasCalendario(fecha, diasCalendarioFin);
        
        List lista = null;
        ViewComparendosResolSancionCompDao myComparResolSancDao = new ViewComparendosResolSancionCompDao();
        try {
              conn = conexion.conectarComparendos();
              lista = myComparResolSancDao.buscarComparendosEnRangoFechas(conn, fechaFin2, fechaFin1, myComparResolSanc,tipoEstado);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
  public List buscarComparendosEnRangoFecha(String fechaIni, String fechaFin, ViewComparendosResolSancionComp myComparResolSanc, String tipoEstado){
      List lista = null;
      ViewComparendosResolSancionCompDao myComparResolSancDao = new ViewComparendosResolSancionCompDao();
      try {
            conn = conexion.conectarComparendos();
            lista = myComparResolSancDao.buscarComparendosEnRangoFechas(conn, fechaIni, fechaFin, myComparResolSanc,tipoEstado);
      } catch (Exception e) {
          e.printStackTrace();
      } finally {
          conexion.cerrarCx();
      }
      return lista;
  }

    public List getViewComparendosResolSancion(ViewComparendosResolSancionComp myComparResolSanc) {
        List lista = null;
        ViewComparendosResolSancionCompDao myComparResolSancDao = new ViewComparendosResolSancionCompDao();
        try {
            conn = conexion.conectarComparendos();
            lista = myComparResolSancDao.searchMatching(conn, myComparResolSanc);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public void crearHistoricoEstadoComparendo(HistoricoEstadosComp myHistEstado) {
        List lista;
        lista = null;
        int id;
        InfractorComp myInfractor = null;
        try {
            conn = conexion.conectarComparendos();
            HistoricoEstadosCompDao myHistEstadoDao = new HistoricoEstadosCompDao();
            myMotor = myMotor.toUpperCase();
            id = Funciones.obtenerId(conn, "GEN_ID_HISTORICOESTADOSCOM", "GEN_HISTORICOESTADOSCOM", myMotor);
            myHistEstado.setID(id);
            myHistEstado.setFECHAREGISTRO(Funciones.getFechaSistema(conn,myMotor));
            myHistEstado.setHORAREGISTRO(Funciones.getHoraSistemaString(conn));
            myHistEstadoDao.create(conn, myHistEstado);
            myHistEstado = new HistoricoEstadosComp();
            myHistEstado.setID(id);
            lista = myHistEstadoDao.searchMatching(conn, myHistEstado);
            if (lista != null && lista.size() > 0) {
                myHistEstado = (HistoricoEstadosComp)lista.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
    }

    public void cambiarEstadoComparendo(InfracionComparendoComp myInfracComp, int idUsuario, String myIp, String myHost) {
        List lista;
        lista = null;
        try {
            conn = conexion.conectarComparendos();
            InfracionComparendoCompDao myInfracCompDao = new InfracionComparendoCompDao();
            //auditar edicion
            InfracionComparendoComp ant = new InfracionComparendoComp();
            ant.setID(myInfracComp.getID());
            myInfracCompDao.load(conn, ant);
            myInfracCompDao.cambiarEstado(conn, myInfracComp);
            //auditar edicion
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("INFRACCIONCOMPARENDO");
            myAuditSx.setCAMPOCLAVE("ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(myInfracComp.getID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEdicion(conn, myAuditSx, ant, myInfracComp, myIp, myHost, 0);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
    }

    public void cambiarCodigoComparendo(InfracionComparendoComp myInfracComp) {
        List lista;
        lista = null;
        try {
            conn = conexion.conectarComparendos();
            InfracionComparendoCompDao myInfracCompDao = new InfracionComparendoCompDao();
            myInfracCompDao.cambiarCodigo(conn, myInfracComp);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
    }

    public String getEstadosResolSancion() {
        String estados = "";
        List lista = null;
        TransitoComp transitoComp = new TransitoComp();
        TransitoCompDao transitoCompDao = new TransitoCompDao();
        try {
            conn = conexion.conectarComparendos();
            lista = transitoCompDao.loadAll(conn);
            if (lista != null && lista.size() > 0) {
                transitoComp = (TransitoComp)lista.get(0);
                estados = transitoComp.getESTADOSRESOLUCIONDESANCION();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return estados;
    }

    public String getEstadosResolPrescripcion() {
        String estados = "";
        List lista = null;
        TransitoComp transitoComp = new TransitoComp();
        TransitoCompDao transitoCompDao = new TransitoCompDao();
        try {
            conn = conexion.conectarComparendos();
            lista = transitoCompDao.loadAll(conn);
            if (lista != null && lista.size() > 0) {
                transitoComp = (TransitoComp)lista.get(0);
                estados = transitoComp.getESTADORESOLUCIONESPRESCRIPCION();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return estados;
    }

    public String getEstadosResolFalleceCambCodigo() {
        String estados = "";
        List lista = null;
        TransitoComp transitoComp = new TransitoComp();
        TransitoCompDao transitoCompDao = new TransitoCompDao();
        try {
            conn = conexion.conectarComparendos();
            lista = transitoCompDao.loadAll(conn);
            if (lista != null && lista.size() > 0) {
                transitoComp = (TransitoComp)lista.get(0);
                estados = transitoComp.getESTADORESOLFALLECECAMBIOCODIGO();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return estados;
    }

    public String getEstadosResolExoneracion() {
        String estados = "";
        List lista = null;
        TransitoComp transitoComp = new TransitoComp();
        TransitoCompDao transitoCompDao = new TransitoCompDao();
        try {
            conn = conexion.conectarComparendos();
            lista = transitoCompDao.loadAll(conn);
            if (lista != null && lista.size() > 0) {
                transitoComp = (TransitoComp)lista.get(0);
                estados = transitoComp.getESTADORESOLEXONERACION();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return estados;
    }
    
    public String getEstadosResolRevocatoria() {
        String estados = "";
        List lista = null;
        TransitoComp transitoComp = new TransitoComp();
        TransitoCompDao transitoCompDao = new TransitoCompDao();
        try {
            conn = conexion.conectarComparendos();
            lista = transitoCompDao.loadAll(conn);
            if (lista != null && lista.size() > 0) {
                transitoComp = (TransitoComp)lista.get(0);
                estados = transitoComp.getESTADORESOLEXONERACION();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return estados;
    }

    public ResolucionesSimit getResolucionSimit(ResolucionesSimit resolucionesSimit) {
        List lista;
        lista = null;
        ResolucionesSimit resolucion;
        resolucion = new ResolucionesSimit();
        try {
            conn = conexion.conectarComparendos();
            ResolucionesSimitDao resolucionesSimitDao = new ResolucionesSimitDao();
            lista = resolucionesSimitDao.searchMatching(conn, resolucionesSimit);
            if (lista != null && lista.size() > 0)
                resolucion = (ResolucionesSimit)lista.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return resolucion;
    }

    public boolean crearResolucionSimit(ResolucionesSimit resolucionesSimit, int idUsuario, String myIp, String myHost) {
        List lista;
        lista = null;
        boolean resultado = false;
        try {
            conn = conexion.conectarComparendos();
            myMotor = myMotor.toUpperCase();
            ResolucionesSimitDao resolucionesSimitDao = new ResolucionesSimitDao();
            resolucionesSimitDao.create(conn, resolucionesSimit);
            resultado = true;
            //auditar insert
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("RESOLUCIONESSIMIT");
            myAuditSx.setCAMPOCLAVE("IDENTIFICACION");
            myAuditSx.setVLRCAMPOCLAVE(resolucionesSimit.getIDENTIFICACION());
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, resolucionesSimit, 0);

        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }

    public boolean actualizarResolucionesSimit(ResolucionesSimit resolucionesSimit, int idUsuario, String myIp, String myHost) {
        boolean res = false;
        try {
            conn = conexion.conectarComparendos();
            ResolucionesSimitDao resolucionesSimitDao = new ResolucionesSimitDao();
            //auditar edicion
            ResolucionesSimit ant = new ResolucionesSimit();
            ant.setNR(resolucionesSimit.getNR());
            resolucionesSimitDao.load(conn, ant);
            resolucionesSimitDao.save(conn, resolucionesSimit);
            res = true;
            //auditar edicion
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("RESOLUCIONESSIMIT");
            myAuditSx.setCAMPOCLAVE("NR");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(resolucionesSimit.getNR()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEdicion(conn, myAuditSx, ant, resolucionesSimit, myIp, myHost, 0);

        } catch (Exception e) {
            e.printStackTrace();
            res = false;
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public EstadoAlcoholemia getFechaSuspension(EstadoAlcoholemia estadoAlcoholemia, Integer Valor) {
        List lista;
        lista = null;
        EstadoAlcoholemia estado;
        estado = new EstadoAlcoholemia();
        try {
            conn = conexion.conectarComparendos();
            EstadoAlcoholemiaDao estadoAlcoholemiaDao = new EstadoAlcoholemiaDao();
            lista = estadoAlcoholemiaDao.getFechaSuspension(conn, estadoAlcoholemia, Valor);
            if (lista != null && lista.size() > 0)
                estado = (EstadoAlcoholemia)lista.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return estado;
    }

    public TransitoComp getTransitoComp(TransitoComp transito) {
        List lista = null;
        TransitoComp transitoComp = new TransitoComp();
        TransitoCompDao transitoCompDao = new TransitoCompDao();
        try {
            conn = conexion.conectarComparendos();
            lista = transitoCompDao.loadAll(conn);
            if (lista != null && lista.size() > 0) {
                transitoComp = (TransitoComp)lista.get(0);
            }

        } catch (Exception e) {
            e.printStackTrace();
            transitoComp.setID_TRANSITO(-1);
        } finally {
            conexion.cerrarCx();
        }
        return transitoComp;
    }
    
    public boolean crearTransitoComp(TransitoComp transito) {
        List lista;
        lista = null;
        boolean resultado = false;
        try {
            conn = conexion.conectarComparendos();
            myMotor = myMotor.toUpperCase();
            TransitoCompDao transitoCompDao = new TransitoCompDao();
            transitoCompDao.create(conn, transito);
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }
    
    public boolean guardarTransitoComp(TransitoComp transito) {
        boolean resultado = false;
        try {
            conn = conexion.conectarComparendos();
            myMotor = myMotor.toUpperCase();
            TransitoCompDao transitoCompDao = new TransitoCompDao();
            transitoCompDao.save(conn, transito);
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }

    public String getNitTransitoComp() {
        String nit = "";
        try {
            TransitoComp transitoComp = getTransitoComp(null);
            if (transitoComp != null) {
                nit = transitoComp.getNIT();
            }
        } catch (Exception e) {
            e.printStackTrace();
            nit = "0";
        } finally {
            conexion.cerrarCx();
        }
        return nit;
    }

    public int getCiudadTransitoComp() {
        int ciudad = 0;
        try {
            TransitoComp transitoComp = getTransitoComp(null);
            if (transitoComp != null) {
                ciudad = transitoComp.getID_CIUDAD();
            }
        } catch (Exception e) {
            e.printStackTrace();
            ciudad = 0;
        } finally {
            conexion.cerrarCx();
        }
        return ciudad;
    }


    public List listarOrigenDescargoComp() {
        List lista = null;
        OrigenDescargo objs = null;
        try {
            conn = conexion.conectarComparendos();
            OrigenDescargoDao dao = new OrigenDescargoDao();
            lista = dao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getOrigenDescargoComp(OrigenDescargo obj) {
        List lista;
        lista = null;
        try {
            conn = conexion.conectarComparendos();
            OrigenDescargoDao dao = new OrigenDescargoDao();
            lista = dao.searchMatching(conn, obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List listarTipoPagoComp() {
        List lista = null;
        TipoPago objs = null;
        try {
            conn = conexion.conectarComparendos();
            TipoPagoDao dao = new TipoPagoDao();
            lista = dao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getTipoPagoComp(TipoPago obj) {
        List lista;
        lista = null;
        try {
            conn = conexion.conectarComparendos();
            TipoPagoDao dao = new TipoPagoDao();
            lista = dao.searchMatching(conn, obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List listarTarjetasCredito() {
        List lista = null;
        TarjetasCredito objs = null;
        try {
            conn = conexion.conectarComparendos();
            TarjetasCreditoDao dao = new TarjetasCreditoDao();
            lista = dao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getTarjetasCredito(TarjetasCredito obj) {
        List lista;
        lista = null;
        try {
            conn = conexion.conectarComparendos();
            TarjetasCreditoDao dao = new TarjetasCreditoDao();
            lista = dao.searchMatching(conn, obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List listarBanco() {
        List lista = null;
        Banco objs = null;
        try {
            conn = conexion.conectarComparendos();
            BancoDao dao = new BancoDao();
            lista = dao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getBanco(Banco obj) {
        List lista;
        lista = null;
        try {
            conn = conexion.conectarComparendos();
            BancoDao dao = new BancoDao();
            lista = dao.searchMatching(conn, obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List listarFormaPago() {
        List lista = null;
        FormaPago objs = null;
        try {
            conn = conexion.conectarComparendos();
            FormaPagoDao dao = new FormaPagoDao();
            lista = dao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getFormaPago(FormaPago obj) {
        List lista;
        lista = null;
        try {
            conn = conexion.conectarComparendos();
            FormaPagoDao dao = new FormaPagoDao();
            lista = dao.searchMatching(conn, obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public FormaPago crearFormaPago(FormaPago obj) {
        try {
            conn = conexion.conectarComparendos();
            int id = getMaxIdFormaPago(conn) + 1;
            obj.setID(id);
            FormaPagoDao dao = new FormaPagoDao();
            dao.create(conn, obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }

    public boolean editarFormaPago(FormaPago obj) {
        boolean edited = false;
        try {
            conn = conexion.conectarComparendos();
            FormaPagoDao dao = new FormaPagoDao();
            dao.save(conn, obj);
            edited = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return edited;
    }

    public boolean eliminarFormaPago(FormaPago obj, int idUsuario, String myIp, String myHost) {
        boolean deleted = false;
        try {
            conn = conexion.conectarComparendos();
            FormaPagoDao dao = new FormaPagoDao();
            //auditar eliminar
            dao.load(conn, obj);
            dao.delete(conn, obj);
            deleted = true;
            //auditar eliminar
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("FORMAPAGO");
            myAuditSx.setCAMPOCLAVE("ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(obj.getID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEliminacion(conn, myAuditSx, obj, 0);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return deleted;
    }

    public int getMaxIdFormaPago(Connection conn) {
        String sql = "SELECT MAX(ID) FROM FORMAPAGO";
        PreparedStatement stmt = null;
        ResultSet result = null;
        int allRows = 1;
        try {
            stmt = conn.prepareStatement(sql);
            result = stmt.executeQuery();

            if (result.next())
                allRows = result.getInt(1);
        } catch (Exception exp) {
            ;
        } finally {
            try {
                if (result != null)
                    result.close();
                if (stmt != null)
                    stmt.close();
            } catch (Exception exp) {
                ;
            }
        }
        return allRows;
    }
    
    public List getViewLiquiComparendo(ViewLiquidacionComparendo obj) {
        List lista;
        lista = null;
        try {
            conn = conexion.conectarComparendos();
            ViewLiquidacionComparendoDao dao = new ViewLiquidacionComparendoDao();
            lista = dao.searchMatching(conn, obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getInfractoresComparendo(Date fechaIni, Date fechaFin) {
        List lista;
        lista = null;
        try {
            
            conn = conexion.conectarComparendos();
            InfractorCompDao infractorCompDao = new InfractorCompDao();
            // buscar infracotres por fecha
            System.out.println(" Antes de llamar a buscarInfractoresPorFechaComparendo " + fechaIni + " " + fechaFin);
            List listaInfractor = infractorCompDao.buscarInfractoresPorFechaComparendo(conn, fechaIni, fechaFin);
            System.out.println("Despues de llamar a buscarInfractoresPorFechaComparendo");
            if (listaInfractor != null && listaInfractor.size() > 0) {
                InfractorComp objInfractor;
                ComparendoCompDao comparendoDao = new ComparendoCompDao();
                List listaComparendos;
                ComparendoComp objComparendo;
                // recorres cada infractor para buscar sus comparendos
                for (int i = 0; i < listaInfractor.size(); i++) {
                    objInfractor = (InfractorComp)listaInfractor.get(i);
                    objComparendo = new ComparendoComp();
                    objComparendo.setID_INFRACTOR(objInfractor.getID_INFRACTOR());
                    listaComparendos = comparendoDao.searchMatching(conn, objComparendo);
                    if (listaComparendos != null && listaComparendos.size() > 0) {
                        //adicionamos la lista de comparendos al infractor
                        objInfractor.setListaComparendo(listaComparendos);
                        
                        InfraccionesCompDao infraccionesCompDao = new InfraccionesCompDao();
                        InfracionComparendoCompDao infraccionComparendoCompDao = new InfracionComparendoCompDao();
                        InfraccionesComp objInfracciones;
                        InfracionComparendoComp objInfraccionComparendo;
                        List listaInfraccionesComp;
                        for (int j = 0; j < listaComparendos.size(); j++) {
                            
                            objComparendo = (ComparendoComp)listaComparendos.get(j);
                            // buscar la infraccion comparendo
                            objInfraccionComparendo = new InfracionComparendoComp();
                            objInfraccionComparendo.setIDCOMPARENDO(objComparendo.getID_COMPARENDO());
                            listaInfraccionesComp = infraccionComparendoCompDao.searchMatching(conn, objInfraccionComparendo);
                            if (listaInfraccionesComp != null && listaInfraccionesComp.size() > 0) {
                                objInfraccionComparendo = (InfracionComparendoComp)listaInfraccionesComp.get(0);
                                objComparendo.setObjInfracionComparendoComp(objInfraccionComparendo);
                            }
                            // buscar la infraccion
                            objInfracciones = new InfraccionesComp();
                            objInfracciones.setID_INFRACCION(objInfraccionComparendo.getIDINFRACCION());
                            try {
                                infraccionesCompDao.load(conn, objInfracciones);
                            } catch (Exception ex) { 
                                ex.printStackTrace();
                            }
                            objComparendo.setObjInfraccionesComp(objInfracciones);
                        }
                    }
                }
            }
            lista = listaInfractor;
            /*conn = conexion.conectarComparendos();
            ComparendoCompDao comparendoDao = new ComparendoCompDao();
            List listaComparendos = comparendoDao.buscarPorRangoFecha(conn, fechaIni, fechaFin);
            if (listaComparendos != null && listaComparendos.size() > 0) {
                ComparendoComp objComparendo;
                for (int i = 0; i < listaComparendos.size(); i++) {
                    objComparendo = (ComparendoComp)listaComparendos.get(i);
                }
            }
            
            ViewComparendosInfractorDao myViewComparendosInfractorDao = new ViewComparendosInfractorDao();
            lista = myViewComparendosInfractorDao.searchMatching(conn, viewcomparendosinfractor);
*/

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
    
    public List getInfractoresComparendoPorFecha(String fechaIni, String fechaFin) {
        List lista;
        lista = null;
        try {
            
            conn = conexion.conectarComparendos();
            InfractorCompDao infractorCompDao = new InfractorCompDao();
            // buscar infracotres por fecha
            List listaInfractor = infractorCompDao.buscarInfractoresPorFechaComp(conn, fechaIni, fechaFin, myMotor);
            if (listaInfractor != null && listaInfractor.size() > 0) {
                InfractorComp objInfractor;
                ComparendoCompDao comparendoDao = new ComparendoCompDao();
                List listaComparendos;
                ComparendoComp objComparendo;
                // recorres cada infractor para buscar sus comparendos
                for (int i = 0; i < listaInfractor.size(); i++) {
                    objInfractor = (InfractorComp)listaInfractor.get(i);
                    objComparendo = new ComparendoComp();
                    objComparendo.setID_INFRACTOR(objInfractor.getID_INFRACTOR());
                    listaComparendos = comparendoDao.searchMatching(conn, objComparendo);
                    if (listaComparendos != null && listaComparendos.size() > 0) {
                        //adicionamos la lista de comparendos al infractor
                        objInfractor.setListaComparendo(listaComparendos);
                        
                        InfraccionesCompDao infraccionesCompDao = new InfraccionesCompDao();
                        InfracionComparendoCompDao infraccionComparendoCompDao = new InfracionComparendoCompDao();
                        InfraccionesComp objInfracciones;
                        InfracionComparendoComp objInfraccionComparendo;
                        List listaInfraccionesComp;
                        for (int j = 0; j < listaComparendos.size(); j++) {
                            
                            objComparendo = (ComparendoComp)listaComparendos.get(j);
                            // buscar la infraccion comparendo
                            objInfraccionComparendo = new InfracionComparendoComp();
                            objInfraccionComparendo.setIDCOMPARENDO(objComparendo.getID_COMPARENDO());
                            listaInfraccionesComp = infraccionComparendoCompDao.searchMatching(conn, objInfraccionComparendo);
                            if (listaInfraccionesComp != null && listaInfraccionesComp.size() > 0) {
                                objInfraccionComparendo = (InfracionComparendoComp)listaInfraccionesComp.get(0);
                                objComparendo.setObjInfracionComparendoComp(objInfraccionComparendo);
                            }
                            // buscar la infraccion
                            objInfracciones = new InfraccionesComp();
                            objInfracciones.setID_INFRACCION(objInfraccionComparendo.getIDINFRACCION());
                            try {
                                infraccionesCompDao.load(conn, objInfracciones);
                            } catch (Exception ex) { 
                                ex.printStackTrace();
                            }
                            objComparendo.setObjInfraccionesComp(objInfracciones);
                        }
                    }
                }
            }
            lista = listaInfractor;
            /*conn = conexion.conectarComparendos();
            ComparendoCompDao comparendoDao = new ComparendoCompDao();
            List listaComparendos = comparendoDao.buscarPorRangoFecha(conn, fechaIni, fechaFin);
            if (listaComparendos != null && listaComparendos.size() > 0) {
                ComparendoComp objComparendo;
                for (int i = 0; i < listaComparendos.size(); i++) {
                    objComparendo = (ComparendoComp)listaComparendos.get(i);
                }
            }
            
            ViewComparendosInfractorDao myViewComparendosInfractorDao = new ViewComparendosInfractorDao();
            lista = myViewComparendosInfractorDao.searchMatching(conn, viewcomparendosinfractor);
    */

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
  //***************************************** PASOS ************************************************************
  //************************************************************************************************************  
  //************************************************************************************************************
  /**
  * Inserta nuevo registro en la tabla
  * @param Pasos obj
  * @return Retorna el mismo objeto pero con la llave primaria configurada
  */
  public Pasos crearPasos(Pasos obj) {
          List lista = null;
  try {
      PasosDao dao = new PasosDao();
      conn = conexion.conectar();
      int id = Funciones.obtenerId(conn, "GEN_PASOS", "GEN_PASOS",myMotor);
      obj.setID_PASO(id);
      dao.create(conn, obj);
      //verificar existencia
      obj = new Pasos();
      obj.setID_PASO(id);
      lista = dao.searchMatching(conn, obj);
      if (lista != null && lista.size() > 0) {
          obj = (Pasos)lista.get(0);
      }
      else {
          obj.setID_PASO(-1);
      }
  } catch (Exception e) {
      e.printStackTrace();
      obj.setID_PASO(-1);
  } finally {
      conexion.cerrarCx();
  }
  return obj;
  }
  
    /**
         * Edita un registro en la tabla
         * @param Pasos obj
         * @return boolean indicando si se realizo o no la actualizacion
         */
        public boolean editarPasos(Pasos obj) {
            boolean resultado;
            resultado = false;
            int id = 0;
            try {
                            PasosDao dao = new PasosDao();
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
         * Busca los registros que coincidan con los datos enviados
         * @param Pasos obj
         * @return Retorna la lista de los registros que coinciden
         */
        public List buscarPasos(Pasos obj) {
            List lista = null;
            try {
                            PasosDao dao = new PasosDao();
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
         * @param Pasos obj
         * @return Retorna la lista de los registros en la tabla
         */
        public List listarPasos() {
            List lista = null;
            try {
                            PasosDao dao = new PasosDao();
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
     * @param Pasos obj
     * @return Retorna un boolean indicando si se realizo o no la operacion
     */
    public boolean eliminarPasos(Pasos obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
                        PasosDao dao = new PasosDao();
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
    
    
  //************************************* FIN PASOS ************************************************************
  //************************************************************************************************************  
  //************************************************************************************************************
    
  //************************************* PROCESOS *************************************************************
  //************************************************************************************************************  
  //************************************************************************************************************
        
  /**
       * Inserta nuevo registro en la tabla
       * @param Procesos obj
       * @return Retorna el mismo objeto pero con la llave primaria configurada
       */
          public Procesos crearProcesos(Procesos obj) {
                  List lista = null;
          try {
              ProcesosDao dao = new ProcesosDao();
              conn = conexion.conectar();
              int id = Funciones.obtenerId(conn, "GEN_PROCESOS", "GEN_PROCESOS", myMotor);
              obj.setID_PROCESO(id);
              dao.create(conn, obj);
              //verificar existencia
              obj = new Procesos();
              obj.setID_PROCESO(id);
              lista = dao.searchMatching(conn, obj);
              if (lista != null && lista.size() > 0) {
                  obj = (Procesos)lista.get(0);
              }
              else {
                  obj.setID_PROCESO(-1);
              }
          } catch (Exception e) {
              e.printStackTrace();
              obj.setID_PROCESO(-1);
          } finally {
              conexion.cerrarCx();
          }
          return obj;
      }
        
    /**
         * Edita un registro en la tabla
         * @param Procesos obj
         * @return boolean indicando si se realizo o no la actualizacion
         */
        public boolean editarProcesos(Procesos obj) {
            boolean resultado;
            resultado = false;
            int id = 0;
            try {
                            ProcesosDao dao = new ProcesosDao();
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
         * Busca los registros que coincidan con los datos enviados
         * @param Procesos obj
         * @return Retorna la lista de los registros que coinciden
         */
        public List buscarProcesos(Procesos obj) {
            List lista = null;
            try {
                            ProcesosDao dao = new ProcesosDao();
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
         * @param Procesos obj
         * @return Retorna la lista de los registros en la tabla
         */
        public List listarProcesos() {
            List lista = null;
            try {
                            ProcesosDao dao = new ProcesosDao();
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
         * @param Procesos obj
         * @return Retorna un boolean indicando si se realizo o no la operacion
         */
        public boolean eliminarProcesos(Procesos obj) {
            boolean resultado;
            resultado = false;
            int id = 0;
            try {
                            ProcesosDao dao = new ProcesosDao();
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
        
            
  //********************************** FIN PROCESOS ************************************************************
  //************************************************************************************************************  
  //************************************************************************************************************
    
  //******************************** SECUENCIA PROCESOS ********************************************************
  //************************************************************************************************************  
  //************************************************************************************************************
  /**
       * Inserta nuevo registro en la tabla
       * @param Secuenciaprocesos obj
       * @return Retorna el mismo objeto pero con la llave primaria configurada
       */
          public Secuenciaprocesos crearSecuenciaprocesos(Secuenciaprocesos obj) {
                  List lista = null;
          try {
              SecuenciaprocesosDao dao = new SecuenciaprocesosDao();
              conn = conexion.conectar();
              int id = Funciones.obtenerId(conn, "GEN_SECUENCIAPROCESOS", "GEN_SECUENCIAPROCESOS", myMotor);
              obj.setID_SECUENCIAPROCESOS(id);
              dao.create(conn, obj);
              //verificar existencia
              obj = new Secuenciaprocesos();
              obj.setID_SECUENCIAPROCESOS(id);
              lista = dao.searchMatching(conn, obj);
              if (lista != null && lista.size() > 0) {
                  obj = (Secuenciaprocesos)lista.get(0);
              }
              else {
                  obj.setID_SECUENCIAPROCESOS(-1);
              }
          } catch (Exception e) {
              e.printStackTrace();
              obj.setID_SECUENCIAPROCESOS(-1);
          } finally {
              conexion.cerrarCx();
          }
          return obj;
      }
    
    /**
         * Edita un registro en la tabla
         * @param Secuenciaprocesos obj
         * @return boolean indicando si se realizo o no la actualizacion
         */
        public boolean editarSecuenciaprocesos(Secuenciaprocesos obj) {
            boolean resultado;
            resultado = false;
            int id = 0;
            try {
                            SecuenciaprocesosDao dao = new SecuenciaprocesosDao();
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
         * Busca los registros que coincidan con los datos enviados
         * @param Secuenciaprocesos obj
         * @return Retorna la lista de los registros que coinciden
         */
        public List buscarSecuenciaprocesos(Secuenciaprocesos obj) {
            List lista = null;
            try {
                            SecuenciaprocesosDao dao = new SecuenciaprocesosDao();
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
         * @param Secuenciaprocesos obj
         * @return Retorna la lista de los registros en la tabla
         */
        public List listarSecuenciaprocesos() {
            List lista = null;
            try {
                            SecuenciaprocesosDao dao = new SecuenciaprocesosDao();
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
         * @param Secuenciaprocesos obj
         * @return Retorna un boolean indicando si se realizo o no la operacion
         */
        public boolean eliminarSecuenciaprocesos(Secuenciaprocesos obj) {
            boolean resultado;
            resultado = false;
            int id = 0;
            try {
                            SecuenciaprocesosDao dao = new SecuenciaprocesosDao();
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
    
    public List getDiasFestivos(Diasfestivos diasf) {
    Diasfestivos diasfestivos;
    boolean esFestivo;
    GestionServiciosDiasfestivos gestionDiasfestivos = new GestionServiciosDiasfestivos();
        List lista = gestionDiasfestivos.loadAll();
        
    return lista;
    }
    
  //**************************** FIN SECUENCIA PROCESOS ********************************************************
  //************************************************************************************************************  
  //************************************************************************************************************
    
}


