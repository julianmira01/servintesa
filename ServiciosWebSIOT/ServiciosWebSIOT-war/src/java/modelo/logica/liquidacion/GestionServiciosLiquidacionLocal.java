package modelo.logica.liquidacion;

import java.sql.Connection;
import java.sql.Time;

import java.util.ArrayList;
import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.comparendos.liquidacion.cuentasContables.CuentaConceptosCompDao;
import modelo.datos.dao.comparendos.liquidacion.cuentasContables.CuentasContablesCompDao;
import modelo.datos.dao.comparendos.liquidacion.cuentasContables.ListaTotalesCuentasDao;
import modelo.datos.dao.comparendos.liquidacion.cuentasContables.ViewDetallesPagosConceptosDao;
import modelo.datos.dao.comparendos.liquidacion.cuentasContables.ViewDetallesPagosDao;
import modelo.datos.dao.liquidacion.ConceptosTarifaDao;
import modelo.datos.dao.liquidacion.FacturaDao;
import modelo.datos.dao.liquidacion.SalarioDao;
import modelo.datos.dao.liquidacion.TarifaDao;
import modelo.datos.dao.liquidacion.caja.AperturaTurnoDao;
import modelo.datos.dao.liquidacion.caja.ArqueoCajaDao;
import modelo.datos.dao.liquidacion.caja.CierreCajaDao;
import modelo.datos.dao.liquidacion.caja.DetArqueoDao;
import modelo.datos.dao.liquidacion.caja.DetArqueoRuntDao;
import modelo.datos.dao.liquidacion.caja.LPagosDao;
import modelo.datos.dao.liquidacion.caja.LPagosRuntDao;
import modelo.datos.dao.liquidacion.caja.ViewAsobancariaDao;
import modelo.datos.objetos.comparendos.liquidacion.cuentasContables.CuentaConceptosComp;
import modelo.datos.objetos.comparendos.liquidacion.cuentasContables.CuentasContablesComp;
import modelo.datos.objetos.comparendos.liquidacion.cuentasContables.ListaTotalesCuentas;
import modelo.datos.objetos.comparendos.liquidacion.cuentasContables.ViewDetallesPagos;
import modelo.datos.objetos.comparendos.liquidacion.cuentasContables.ViewDetallesPagosConceptos;
import modelo.datos.objetos.generales.AuditoriaSystem;
import modelo.datos.objetos.generales.Auditoriatramite;
import modelo.datos.objetos.generales.Persona;
import modelo.datos.objetos.generales.Usuarios;
import modelo.datos.objetos.generales.vehiculo.Vehiculo;
import modelo.datos.objetos.generales.vistas.DetalleprocersarView;
import modelo.datos.objetos.liquidacion.ConceptosTarifa;
import modelo.datos.objetos.liquidacion.DatosAdicionalesFactura;
import modelo.datos.objetos.liquidacion.Factura;
import modelo.datos.objetos.liquidacion.Tarifa;
import modelo.datos.objetos.liquidacion.caja.AperturaTurno;
import modelo.datos.objetos.liquidacion.caja.ArqueoCaja;
import modelo.datos.objetos.liquidacion.caja.CierreCaja;
import modelo.datos.objetos.liquidacion.caja.DetArqueo;
import modelo.datos.objetos.liquidacion.caja.DetArqueoRunt;
import modelo.datos.objetos.liquidacion.caja.LPagos;
import modelo.datos.objetos.liquidacion.caja.LPagosRunt;
import modelo.datos.objetos.liquidacion.caja.ViewAsobancaria;

import modelo.logica.generales.GestionAuditoriaTramite;
import modelo.logica.generales.GestionViewGeneralesLocal;
import modelo.logica.generales.vehiculo.GestionServiciosVehiculosLocal;
import modelo.logica.usuarios.GestionServiciosUsuarios;

import servicios.generales.ServiciosPersonas;

import utilidades.Auditoria;
import utilidades.Compilador;
import utilidades.Funciones;
import utilidades.GenerarReportes;


//import utils.system;

public class GestionServiciosLiquidacionLocal {

    Conexion conexion;
    Connection conn;
    TarifaDao tarifaDao;
    FacturaDao facturaDao;
    ConceptosTarifaDao conceptosTarifaDao;
    SalarioDao salarioDao;
    Compilador compilador;
    GenerarReportes generarReportes;
    AperturaTurnoDao aperturaTurnoDao;
    String myMotor;


    public GestionServiciosLiquidacionLocal() {
        super();
        crearObjetos();
    }

    public void crearObjetos() {
        conexion = new Conexion();
        conceptosTarifaDao = new ConceptosTarifaDao();
        tarifaDao = new TarifaDao();
        salarioDao = new SalarioDao();
        facturaDao = new FacturaDao();
        compilador = new Compilador(null, getSalarios());
        generarReportes = new GenerarReportes();
        aperturaTurnoDao = new AperturaTurnoDao();
        myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
    }

    public List getTarifas(Tarifa tarifa) {
        List lista = null;
        try {
            conn = conexion.conectar();
            if (tarifa != null && !tarifa.getLT_VIGENCIA().equals("")) {
                lista = (ArrayList)tarifaDao.searchMatching(conn, tarifa);
            } else {
                lista = (ArrayList)tarifaDao.loadAll(conn);
            }
            // generarReportes.generarReporte(lista);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }


    public ArrayList getSalarios() {
        ArrayList lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)salarioDao.loadAll(conn);
        } catch (Exception e) {

        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }


    public List getConceptosTarifa(ConceptosTarifa conceptoTarifa, Vehiculo vehi) {
        List lista = null;
        String valor = "";
        try {
            conn = conexion.conectar();
            lista = (ArrayList)conceptosTarifaDao.searchMatching(conn, conceptoTarifa);
            if (lista != null && lista.size() > 0) {
                for (int i = 0; i < lista.size(); i++) {
                    conceptoTarifa = (ConceptosTarifa)lista.get(i);
                    valor =
                            compilador.compilar(conceptoTarifa.getLTD_CALCULO(), conceptoTarifa.getLT_VIGENCIA(), vehi, "");
                    conceptoTarifa.setLTD_VALOR(valor);
                    lista.remove(i);
                    lista.add(i, conceptoTarifa);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public void facturar(List tarifas, List conceptosTarifas, DatosAdicionalesFactura datosAdionalesFactura) {
        Tarifa tarifa;
        ConceptosTarifa conceptoTarifa;
        Double total = 0.0;
        Factura factura = new Factura();
        for (int i = 0; i < conceptosTarifas.size(); i++) {
            conceptoTarifa = (ConceptosTarifa)conceptosTarifas.get(i);
            total = total + Double.parseDouble(conceptoTarifa.getLTD_VALOR());
        }
        factura.setLF_TOTAL(total);
        System.out.println("total " + total);
        crearL_FACTURAS(factura);
        
            
            }


    public int crearL_FACTURAS(Factura factura) {
        List lista = null;
        int id = 0;
        try {
            conn = conexion.conectar();
            id = Funciones.obtenerId(conn, "GEN_L_FACTURAS_LF_ID", "GEN_L_FACTURAS", myMotor);
            System.out.println("id " + id);
            factura.setLF_ID(id);
            facturaDao.create(conn, factura);
            
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
            conexion.cerrarCx();
        }
        return id;
    }

    public List getFactura(Factura factura) {
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)facturaDao.searchMatching(conn, factura);
            if (lista != null && lista.size() > 0) {
                factura = (Factura)lista.get(0);
            } else {
                factura.setLF_ID(-1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List loadAll() {
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)facturaDao.loadAll(conn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getAperturas(AperturaTurno aperturaTurno) {
        List lista;
        lista = null;
        try {
            conn = conexion.conectar();
            AperturaTurnoDao myAperturaTurnoDao = new AperturaTurnoDao();
            lista = myAperturaTurnoDao.searchMatching(conn, aperturaTurno);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public AperturaTurno getAperturaTurno(AperturaTurno aperturaTurno) {
        List lista;
        lista = null;
        try {
            conn = conexion.conectar();
            AperturaTurnoDao myAperturaTurnoDao = new AperturaTurnoDao();
            lista = myAperturaTurnoDao.searchAperturaTurno(conn, aperturaTurno);
            if (lista != null && lista.size() > 0)
                aperturaTurno = (AperturaTurno)lista.get(0);
            else
                aperturaTurno.setIDAPERTURA(-1);
        } catch (Exception e) {
            e.printStackTrace();
            aperturaTurno.setIDAPERTURA(-1);
        } finally {
            conexion.cerrarCx();
        }
        return aperturaTurno;
    }

    public boolean crearApertura(AperturaTurno aperturaTurno, int idUsuario, String myIp, String myHost) {
        boolean resultado;
        resultado = false;
        AperturaTurnoDao myAperturaTurnoDao = new AperturaTurnoDao();
        int id = 0;
        try {
            conn = conexion.conectar();
            id = Funciones.obtenerId(conn, "GEN_APERTURATURNO", "GEN_APERTURATURNO", myMotor);
            aperturaTurno.setIDAPERTURA(id);
            aperturaTurno.setFECHAHORA_USUARIOREGISTRA(Funciones.getFechaHoraSistema(myMotor));
            myAperturaTurnoDao.create(conn, aperturaTurno);
            resultado = true;
            //auditar insert
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("APERTURA_TURNO");
            myAuditSx.setCAMPOCLAVE("IDAPERTURA");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(aperturaTurno.getIDAPERTURA()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, aperturaTurno, 0);
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myAperturaTurnoDao = null;
        }
        return resultado;
    }

    public boolean editarApertura(AperturaTurno aperturaTurno, int idUsuario, String myIp, String myHost) {
        boolean resultado;
        resultado = false;
        AperturaTurnoDao myAperturaTurnoDao = new AperturaTurnoDao();
        try {
            conn = conexion.conectar();
            //auditar edicion
            AperturaTurno ant = new AperturaTurno();
            ant.setIDAPERTURA(aperturaTurno.getIDAPERTURA());
            myAperturaTurnoDao.load(conn, ant);
            myAperturaTurnoDao.save(conn, aperturaTurno);
            resultado = true;
            //auditar edicion
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("APERTURA_TURNO");
            myAuditSx.setCAMPOCLAVE("IDAPERTURA");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(aperturaTurno.getIDAPERTURA()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEdicion(conn, myAuditSx, ant, aperturaTurno, myIp, myHost, 0);
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myAperturaTurnoDao = null;
        }
        return resultado;
    }

    public boolean arquearApertura(AperturaTurno aperturaTurno, int idUsuario, String myIp, String myHost) {
        boolean resultado;
        resultado = false;
        AperturaTurnoDao myAperturaTurnoDao = new AperturaTurnoDao();
        try {
            conn = conexion.conectar();
            //auditar edicion
            AperturaTurno ant = new AperturaTurno();
            ant.setIDAPERTURA(aperturaTurno.getIDAPERTURA());
            myAperturaTurnoDao.load(conn, ant);
            myAperturaTurnoDao.arquearApertura(conn, aperturaTurno);
            resultado = true;
            //auditar edicion
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("APERTURA_TURNO");
            myAuditSx.setCAMPOCLAVE("IDAPERTURA");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(aperturaTurno.getIDAPERTURA()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEdicion(conn, myAuditSx, ant, aperturaTurno, myIp, myHost, 0);

        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myAperturaTurnoDao = null;
        }
        return resultado;
    }

    public int crearArqueo(ArqueoCaja arqueoCaja, int idUsuario, String myIp, String myHost) {
        boolean resultado;
        //Campos para la auditoria
        Auditoria myAuditoria;
        AuditoriaSystem myAuditSx;
        //--Campos para la auditoria
        resultado = false;
        ArqueoCajaDao myArqueoCajaDao = new ArqueoCajaDao();
        LPagosDao myLPagosDao = new LPagosDao();
        int id = 0, idcajero = 0;
        String maxfecha = null, minfecha = null;
        Time maxhora = null, minhora = null;

        try {
            conn = conexion.conectar();
            idcajero = Integer.parseInt(arqueoCaja.getID_CAJERO());
            maxfecha = myLPagosDao.getMaxFecha(conn, idcajero);
            minfecha = myLPagosDao.getMinFecha(conn, idcajero);
            maxhora = myLPagosDao.getMaxHora(conn, idcajero);
            minhora = myLPagosDao.getMinHora(conn, idcajero);
            id = Funciones.obtenerId(conn, "GEN_ARQUEOCAJA", "GEN_ARQUEOCAJA", myMotor);
            arqueoCaja.setID_ARQUEO(id);
            arqueoCaja.setFEC_FINAL(maxfecha.toString());
            arqueoCaja.setFEC_INICIAL(minfecha.toString());
            arqueoCaja.setH_FINAL(maxhora.toString());
            arqueoCaja.setH_INICIAL(minhora.toString());
            myArqueoCajaDao.create(conn, arqueoCaja, myMotor);
            //Pasos para la auditoria
            myAuditoria = new Auditoria();
            myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("ARQUEO_CAJA");
            myAuditSx.setCAMPOCLAVE("ID_ARQUEO");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(id));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, arqueoCaja, 0);
            //-- para la auditoria
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
            id = 0;
        } finally {
            conexion.cerrarCx();
            myArqueoCajaDao = null;
        }
        return id;
    }

    public ArqueoCaja preCrearArqueo(ArqueoCaja arqueoCaja) {
        LPagosDao myLPagosDao = new LPagosDao();
        int idcajero = 0;
        String maxfecha = null, minfecha = null;
        Time maxhora = null, minhora = null;

        try {
            conn = conexion.conectar();
            idcajero = Integer.parseInt(arqueoCaja.getID_CAJERO());
            maxfecha = myLPagosDao.getMaxFecha(conn, idcajero);
            minfecha = myLPagosDao.getMinFecha(conn, idcajero);
            maxhora = myLPagosDao.getMaxHora(conn, idcajero);
            minhora = myLPagosDao.getMinHora(conn, idcajero);
            arqueoCaja.setFEC_FINAL(maxfecha.toString());
            arqueoCaja.setFEC_INICIAL(minfecha.toString());
            arqueoCaja.setH_FINAL(maxhora.toString());
            arqueoCaja.setH_INICIAL(minhora.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return arqueoCaja;
    }

    public boolean editarArqueo(ArqueoCaja arqueoCaja, int idUsuario, String myIp, String myHost) {
        boolean resultado;
        List lista;
        //Campos para la auditoria
        ArqueoCaja anterior;
        Auditoria myAuditoria;
        AuditoriaSystem myAuditSx;
        //--Campos para la auditoria
        resultado = false;
        ArqueoCajaDao myArqueoCajaDao = new ArqueoCajaDao();
        try {
            conn = conexion.conectar();
            //Pasos previos Auditoria
            anterior = new ArqueoCaja();
            anterior.setID_ARQUEO(arqueoCaja.getID_ARQUEO());
            lista = myArqueoCajaDao.searchMatching(conn, anterior);
            if (lista != null && lista.size() > 0) {
                anterior = (ArqueoCaja)lista.get(0);
            } else {
                anterior = null;
            }
            //Pasos previos para auditoria
            myArqueoCajaDao.save(conn, arqueoCaja);
            //Pasos para la auditoria
            myAuditoria = new Auditoria();
            myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("ARQUEO_CAJA");
            myAuditSx.setCAMPOCLAVE("ID_ARQUEO");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(arqueoCaja.getID_ARQUEO()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEdicion(conn, myAuditSx, anterior, arqueoCaja, myIp, myHost, 0);
            //-- para la auditoria
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myArqueoCajaDao = null;
        }
        return resultado;
    }

    public List getArqueos(ArqueoCaja obj) {
        List lista;
        lista = null;
        try {
            conn = conexion.conectar();
            ArqueoCajaDao dao = new ArqueoCajaDao();
            lista = dao.searchMatching(conn, obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getArqueosSinCierre() {
        List lista;
        lista = null;
        try {
            conn = conexion.conectar();
            ArqueoCajaDao myArqueoCajaDao = new ArqueoCajaDao();
            lista = myArqueoCajaDao.buscarArqueosSinCierre(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public boolean crearDetArqueo(DetArqueo detArqueo, int idUsuario, String myIp, String myHost) {
        boolean resultado;
        resultado = false;
        DetArqueoDao myDetArqueoDao = new DetArqueoDao();
        int id = 0;

        try {
            conn = conexion.conectar();
            id = Funciones.obtenerId(conn, "GEN_DETARQUEO", "GEN_DETARQUEO", myMotor);
            detArqueo.setIDDETARQUEO(id);
            myDetArqueoDao.create(conn, detArqueo, myMotor);
            resultado = true;
            //auditar insert
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("DETARQUEO");
            myAuditSx.setCAMPOCLAVE("IDDETARQUEO");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(detArqueo.getIDDETARQUEO()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, detArqueo, 0);
            
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myDetArqueoDao = null;
        }
        return resultado;
    }

    public int crearArqueoRunt(ArqueoCaja arqueoCaja, int idUsuario, String myIp, String myHost) {
        boolean resultado;
        resultado = false;
        ArqueoCajaDao myArqueoCajaDao = new ArqueoCajaDao();
        LPagosRuntDao myLPagosRuntDao = new LPagosRuntDao();
        int id = 0, idcajero = 0;
        ;
        String maxfecha = null, minfecha = null;
        Time maxhora = null, minhora = null;

        try {
            conn = conexion.conectar();
            idcajero = Integer.parseInt(arqueoCaja.getID_CAJERO());
            maxfecha = myLPagosRuntDao.getMaxFecha(conn, idcajero);
            minfecha = myLPagosRuntDao.getMinFecha(conn, idcajero);
            id = Funciones.obtenerId(conn, "GEN_ARQUEOCAJA", "GEN_ARQUEOCAJA", myMotor);
            arqueoCaja.setID_ARQUEO(id);
            arqueoCaja.setFEC_FINAL(maxfecha.toString());
            arqueoCaja.setFEC_INICIAL(minfecha.toString());
            myArqueoCajaDao.create(conn, arqueoCaja,myMotor);
            resultado = true;
            //auditar insert
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("ARQUEO_CAJA");
            myAuditSx.setCAMPOCLAVE("ID_ARQUEO");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(arqueoCaja.getID_ARQUEO()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, arqueoCaja, 0);
            
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
            id = 0;
        } finally {
            conexion.cerrarCx();
            myArqueoCajaDao = null;
        }
        return id;
    }

    public ArqueoCaja preCrearArqueoRunt(ArqueoCaja arqueoCaja) {
        LPagosRuntDao myLPagosRuntDao = new LPagosRuntDao();
        int idcajero = 0;
        String maxfecha = null, minfecha = null;

        try {
            conn = conexion.conectar();
            idcajero = Integer.parseInt(arqueoCaja.getID_CAJERO());
            maxfecha = myLPagosRuntDao.getMaxFecha(conn, idcajero);
            minfecha = myLPagosRuntDao.getMinFecha(conn, idcajero);
            arqueoCaja.setFEC_FINAL(maxfecha.toString());
            arqueoCaja.setFEC_INICIAL(minfecha.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return arqueoCaja;
    }

    public List getArqueosSinCierreRunt() {
        List lista;
        lista = null;
        try {
            conn = conexion.conectar();
            ArqueoCajaDao myArqueoCajaDao = new ArqueoCajaDao();
            lista = myArqueoCajaDao.buscarArqueosSinCierreRunt(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public boolean crearDetArqueoRunt(DetArqueoRunt detArqueoRunt, int idUsuario, String myIp, String myHost) {
        boolean resultado;
        resultado = false;
        DetArqueoRuntDao myDetArqueoRuntDao = new DetArqueoRuntDao();
        int id = 0;

        try {
            conn = conexion.conectar();
            id = Funciones.obtenerId(conn, "GEN_DETARQUEORUNT", "GEN_DETARQUEORUNT", myMotor);
            detArqueoRunt.setIDDETARQUEO(id);
            myDetArqueoRuntDao.create(conn, detArqueoRunt);
            resultado = true;
            //auditar insert
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("DetArqueoRunt");
            myAuditSx.setCAMPOCLAVE("IDDETARQUEO");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(detArqueoRunt.getIDDETARQUEO()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, detArqueoRunt, 0);

        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myDetArqueoRuntDao = null;
        }
        return resultado;
    }

    public boolean editarPago(LPagos lpagos, int idUsuario, String myIp, String myHost) {
        boolean resultado;
        List lista;
        //Campos para la auditoria
        LPagos anterior;
        Auditoria myAuditoria;
        AuditoriaSystem myAuditSx;
        //--Campos para la auditoria
        resultado = false;
        LPagosDao myLPagosDao = new LPagosDao();
        try {
            conn = conexion.conectar();
            //Pasos previos Auditoria
            anterior = new LPagos();
            anterior.setLP_ID(lpagos.getLP_ID());
            lista = myLPagosDao.searchMatching(conn, anterior);
            if (lista != null && lista.size() > 0) {
                anterior = (LPagos)lista.get(0);
            } else {
                anterior = null;
            }
            //Pasos previos para auditoria
            myLPagosDao.save(conn, lpagos);
            //Pasos para la auditoria
            myAuditoria = new Auditoria();
            myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("L_PAGOS");
            myAuditSx.setCAMPOCLAVE("LP_ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(lpagos.getLP_ID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEdicion(conn, myAuditSx, anterior, lpagos, myIp, myHost, 0);
            //-- para la auditoria
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myLPagosDao = null;
        }
        return resultado;
    }
    
    public boolean editarPagoIdArqueo(LPagos lpagos, int idUsuario, String myIp, String myHost) {
        boolean resultado;
        resultado = false;
        LPagosDao myLPagosDao = new LPagosDao();
        try {
            conn = conexion.conectar();
            myLPagosDao.saveIdArqueo(conn, lpagos);
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myLPagosDao = null;
        }
        return resultado;
    }

    public List getPagos(LPagos lpagos) {
        List lista;
        lista = null;
        try {
            conn = conexion.conectar();
            LPagosDao myLPagosDao = new LPagosDao();
            lista = myLPagosDao.searchMatching(conn, lpagos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public boolean editarPagoRunt(LPagosRunt lpagosrunt, int idUsuario, String myIp, String myHost) {
        boolean resultado;
        resultado = false;
        LPagosRuntDao myLPagosRuntDao = new LPagosRuntDao();
        try {
            conn = conexion.conectar();
            //auditar edicion
            LPagosRunt ant = new LPagosRunt();
            ant.setID_PAGORUNT(lpagosrunt.getID_PAGORUNT());
            myLPagosRuntDao.load(conn, ant);
            myLPagosRuntDao.save(conn, lpagosrunt);
            resultado = true;
            //auditar edicion
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("L_PAGOSRUNT");
            myAuditSx.setCAMPOCLAVE("ID_PAGORUNT");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(lpagosrunt.getID_PAGORUNT()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEdicion(conn, myAuditSx, ant, lpagosrunt, myIp, myHost, 0);

        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myLPagosRuntDao = null;
        }
        return resultado;
    }

    public List getPagosRunt(LPagosRunt lpagosrunt) {
        List lista;
        lista = null;
        try {
            conn = conexion.conectar();
            LPagosRuntDao myLPagosRuntDao = new LPagosRuntDao();
            lista = myLPagosRuntDao.searchMatching(conn, lpagosrunt);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public boolean anularPago(Factura factura,int idUsuario, String myIp, String myHost) {
      boolean resultado = false;
        int id;
        List listausuarios = null;
        List listafacturas=null;
        //Campos para la auditoria
        Auditoria myAuditoria;
        AuditoriaSystem myAuditSx;
        //--Campos para la auditoria
        try {
            conn = conexion.conectar();
                    
            LPagosDao myLPagosDao = new LPagosDao();
            myLPagosDao.deletePorIdFactura(conn, factura.getLF_ID());
            facturaDao.ponerEstadoLiquidado(conn, factura);            
            //Pasos para la auditoria
           /* 
            myAuditoria = new Auditoria();
            myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("L_PAGOS");
            myAuditSx.setCAMPOCLAVE("LP_ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(id));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, pagos, 0);
            */
            //-- para la auditoria
            
            
            //*********** AUDITORIA TRAMITE ***************************                 
            
            GestionAuditoriaTramite mygestionauditoriatramite = new GestionAuditoriaTramite();
            GestionServiciosUsuarios mygestionusuario = new GestionServiciosUsuarios();
            Auditoriatramite objAuditoriaTramite = new Auditoriatramite();
            Usuarios objusuario = new Usuarios();
            objusuario.setID_USUARIO(idUsuario);
            listausuarios = mygestionusuario.getUsuarios(objusuario, 0);
            if (listausuarios != null && listausuarios.size() > 0)
                    objAuditoriaTramite.setUSUARIO(((Usuarios)listausuarios.get(0)).getLOGIN());
                                       
            Factura fact = factura;
            
            if(fact.getLF_V_ID()>0)
            {
               objAuditoriaTramite.setTARGET_TRAMITE(2);
                Vehiculo objvehiculo = new Vehiculo();
                GestionServiciosVehiculosLocal gestionVehiculos = new GestionServiciosVehiculosLocal();
                objvehiculo.setID_VEHICULO(fact.getLF_V_ID());
                objvehiculo = gestionVehiculos.getVehiculo(objvehiculo);
                objAuditoriaTramite.setPLACA_VEHICULO(objvehiculo.getPLACA());
            
            }
            if(fact.getLF_ID_PERSONA()>0)
            {
            
            objAuditoriaTramite.setTARGET_TRAMITE(1);
            
            ServiciosPersonas serviciopers = new ServiciosPersonas();
            Persona pers = new Persona();
            pers.setID_PERSONAS(fact.getLF_ID_PERSONA());
            pers = serviciopers.getPersona(pers);          
            if(pers!=null)
                objAuditoriaTramite.setCEDULA_PERSONA(pers.getIDENTIFICACION());
            
            }          
            
            GestionViewGeneralesLocal mygestiongenerales = new GestionViewGeneralesLocal();
            DetalleprocersarView detalle = new DetalleprocersarView();   
            detalle.setLF_ID(fact.getLF_ID());
            List listadetalle = null;
            listadetalle = mygestiongenerales.getDetalleProcesar(detalle);
            if(listadetalle!=null && listadetalle.size()>0)
            {
                    String tramites="";
                    for(int i=0;i<listadetalle.size();i++)
                    {
                    tramites += ((DetalleprocersarView)listadetalle.get(i)).getDESCTRAMITE() + ",";
                    }
                    objAuditoriaTramite.setTRAMITE(tramites); 
                }
              
            
            String fecha = Funciones.getFechaSistemaCortaTexto(myMotor);
            objAuditoriaTramite.setFECHA(fecha);
            
            objAuditoriaTramite.setHORA(Funciones.getHoraSistema().toString());
            objAuditoriaTramite.setACCION(5); 
            
            String datosadicionales="";
            if(fact.getLF_NOTA()!=null)
                datosadicionales=fact.getLF_NOTA();
           
            objAuditoriaTramite.setINFO_ADICIONAL("Factura Nro:" + fact.getLF_NUMERO() + " Host:" + myHost + " Direccion IP:" + myIp+". "+datosadicionales);                                    
            mygestionauditoriatramite.crearAuditoriatramite(objAuditoriaTramite);
                       
            
            //******** FIN AUDITORIA TRAMITE *************************
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
        }
      
      return resultado;
    }


    public boolean createPagos(Factura factura,LPagos pagos, int idUsuario, String myIp, String myHost) {
        boolean resultado = false;
        int id;
        List listausuarios = null;
        List listafacturas=null;
        //Campos para la auditoria
        Auditoria myAuditoria;
        AuditoriaSystem myAuditSx;
        //--Campos para la auditoria
        try {
            conn = conexion.conectar();
            id = Funciones.obtenerId(conn, "GEN_L_PAGOS_LP_ID", "GEN_L_PAGOS", myMotor);
            pagos.setLP_ID(id);
            pagos.setLP_FECHAHORA(Funciones.getFechaHoraSistema(myMotor));
            LPagosDao myLPagosDao = new LPagosDao();
            myLPagosDao.create(conn, pagos, myMotor);
            //Pasos para la auditoria
           /* 
            myAuditoria = new Auditoria();
            myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("L_PAGOS");
            myAuditSx.setCAMPOCLAVE("LP_ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(id));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, pagos, 0);
            */
            //-- para la auditoria
            
            
            //*********** AUDITORIA TRAMITE ***************************                 
            
            GestionAuditoriaTramite mygestionauditoriatramite = new GestionAuditoriaTramite();
            GestionServiciosUsuarios mygestionusuario = new GestionServiciosUsuarios();
            Auditoriatramite objAuditoriaTramite = new Auditoriatramite();
            Usuarios objusuario = new Usuarios();
            objusuario.setID_USUARIO(idUsuario);
            listausuarios = mygestionusuario.getUsuarios(objusuario, 0);
            if (listausuarios != null && listausuarios.size() > 0)
                    objAuditoriaTramite.setUSUARIO(((Usuarios)listausuarios.get(0)).getLOGIN());
                                       
            Factura fact = factura;
            
            if(fact.getLF_V_ID()>0)
            {
               objAuditoriaTramite.setTARGET_TRAMITE(2);
                Vehiculo objvehiculo = new Vehiculo();
                GestionServiciosVehiculosLocal gestionVehiculos = new GestionServiciosVehiculosLocal();
                objvehiculo.setID_VEHICULO(fact.getLF_V_ID());
                objvehiculo = gestionVehiculos.getVehiculo(objvehiculo);
                objAuditoriaTramite.setPLACA_VEHICULO(objvehiculo.getPLACA());
            
            }
            if(fact.getLF_ID_PERSONA()>0)
            {
            
            objAuditoriaTramite.setTARGET_TRAMITE(1);
            
            ServiciosPersonas serviciopers = new ServiciosPersonas();
            Persona pers = new Persona();
            pers.setID_PERSONAS(fact.getLF_ID_PERSONA());
            pers = serviciopers.getPersona(pers);          
            if(pers!=null)
                objAuditoriaTramite.setCEDULA_PERSONA(pers.getIDENTIFICACION());
            
            }          
            
            GestionViewGeneralesLocal mygestiongenerales = new GestionViewGeneralesLocal();
            DetalleprocersarView detalle = new DetalleprocersarView();   
            detalle.setLF_ID(fact.getLF_ID());
            List listadetalle = null;
            listadetalle = mygestiongenerales.getDetalleProcesar(detalle);
            if(listadetalle!=null && listadetalle.size()>0)
            {
                    String tramites="";
                    for(int i=0;i<listadetalle.size();i++)
                    {
                    tramites += ((DetalleprocersarView)listadetalle.get(i)).getDESCTRAMITE() + ",";
                    }
                    objAuditoriaTramite.setTRAMITE(tramites); 
                }
              
            
            String fecha = Funciones.getFechaSistemaCortaTexto(myMotor);
            objAuditoriaTramite.setFECHA(fecha);
            
            objAuditoriaTramite.setHORA(Funciones.getHoraSistema().toString());
            objAuditoriaTramite.setACCION(3); 
            
            String datosadicionales="";
            if(fact.getLF_NOTA()!=null)
                datosadicionales=fact.getLF_NOTA();
           
            objAuditoriaTramite.setINFO_ADICIONAL("Factura Nro:" + fact.getLF_NUMERO() + " Host:" + myHost + " Direccion IP:" + myIp+". "+datosadicionales);                                    
            mygestionauditoriatramite.crearAuditoriatramite(objAuditoriaTramite);
                       
            
            //******** FIN AUDITORIA TRAMITE *************************
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }

    public int cerrarCaja(CierreCaja cierreCaja, int idUsuario, String myIp, String myHost) {
        boolean resultado;
        resultado = false;
        //Campos para la auditoria
        Auditoria myAuditoria;
        AuditoriaSystem myAuditSx;
        //--Campos para la auditoria
        CierreCajaDao myCierreCajaDao = new CierreCajaDao();
        int id = 0;
        try {
            conn = conexion.conectar();
            id = Funciones.obtenerId(conn, "GEN_CIERRECAJA", "GEN_CIERRECAJA", myMotor);
            cierreCaja.setIDCIERRE_CAJA(id);
            myCierreCajaDao.create(conn, cierreCaja);
            //Pasos para la auditoria
            myAuditoria = new Auditoria();
            myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("CIERRECAJA");
            myAuditSx.setCAMPOCLAVE("IDCIERRE_CAJA");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(id));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, cierreCaja, 0);
            //-- para la auditoria
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
            id = 0;
        } finally {
            conexion.cerrarCx();
            myCierreCajaDao = null;
        }
        return id;
    }

    public List getTCuentasContables() {
        List lista;
        lista = null;
        try {
            conn = conexion.conectar();
            CuentasContablesCompDao myCuentasContablesCompDao = new CuentasContablesCompDao();
            lista = myCuentasContablesCompDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public CuentasContablesComp getCuentaContableId(CuentasContablesComp cuentacontable) {
        CuentasContablesCompDao myCuentasContablesCompDao = new CuentasContablesCompDao();
        try {
            conn = conexion.conectar();
            myCuentasContablesCompDao.load(conn, cuentacontable);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return cuentacontable;
    }

    public boolean CrearCuentaContable(CuentasContablesComp cuentacontable) {
        boolean resultado = false;
        int id = 0;
        try {
            conn = conexion.conectar();
            CuentasContablesCompDao myCuentasContablesCompDao = new CuentasContablesCompDao();
            id = Funciones.obtenerId(conn, "GEN_CUENTA_CONTABLE", "GEN_CUENTA_CONTABLE", myMotor);
            cuentacontable.setIDCUENTA_CONTABLE(id);
            myCuentasContablesCompDao.create(conn, cuentacontable);
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }

    public boolean editarCuentaContable(CuentasContablesComp cuentacontable) {
        boolean resultado;
        resultado = false;
        CuentasContablesCompDao myCuentasContablesCompDao = new CuentasContablesCompDao();
        try {
            conn = conexion.conectar();
            myCuentasContablesCompDao.save(conn, cuentacontable);
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myCuentasContablesCompDao = null;
        }
        return resultado;
    }

    public boolean eliminarCuentaContable(CuentasContablesComp cuentacontable) {
        boolean resultado;
        resultado = false;
        CuentasContablesCompDao myCuentasContablesCompDao = new CuentasContablesCompDao();
        try {
            conn = conexion.conectar();
            myCuentasContablesCompDao.delete(conn, cuentacontable);
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myCuentasContablesCompDao = null;
        }
        return resultado;
    }

    public List getSCuentaConcepto(CuentaConceptosComp cuentaconcepto) {
        List lista;
        lista = null;
        try {
            conn = conexion.conectar();
            CuentaConceptosCompDao myCuentaConceptosCompDao = new CuentaConceptosCompDao();
            lista = myCuentaConceptosCompDao.searchMatching(conn, cuentaconcepto);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public boolean CrearCuentaConcepto(CuentaConceptosComp cuentaconcepto) {
        boolean resultado = false;
        int id = 0;
        try {
            conn = conexion.conectar();
            CuentaConceptosCompDao myCuentaConceptosCompDao = new CuentaConceptosCompDao();
            id = Funciones.obtenerId(conn, "GEN_CUENTACONCEPTOS", "GEN_CUENTACONCEPTOS", myMotor);
            cuentaconcepto.setIDCUENTA_CONCEPTO(id);
            myCuentaConceptosCompDao.create(conn, cuentaconcepto);
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }

    public boolean eliminarCuentaConcepto(CuentaConceptosComp cuentaconcepto) {
        boolean resultado;
        resultado = false;
        CuentaConceptosCompDao myCuentaConceptosCompDao = new CuentaConceptosCompDao();
        try {
            conn = conexion.conectar();
            myCuentaConceptosCompDao.delete(conn, cuentaconcepto);
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myCuentaConceptosCompDao = null;
        }
        return resultado;
    }

    public List getTotalesCuenta(ListaTotalesCuentas listatotalescuentas, ViewDetallesPagos viewdetallespagos,
                                 ViewDetallesPagosConceptos viewdetallespagosconceptos,
                                 ViewAsobancaria viewasobancaria) {
        ArrayList lista = null;
        try {
            conn = conexion.conectar();
            ListaTotalesCuentasDao myListaTotalesCuentasDao = new ListaTotalesCuentasDao();
            lista = (ArrayList)myListaTotalesCuentasDao.loadAll(conn);
        } catch (Exception e) {

        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getTotalesporCuenta(String fechai, String fechaf) {
        
        List listafecha, listavigencia, listacuentas;
        listafecha = null;
        listavigencia = null;
        
        listacuentas = new ArrayList();
        
        try {
            conn = conexion.conectar();
            ViewDetallesPagosDao myViewDetallesPagosDao = new ViewDetallesPagosDao();
            listafecha = myViewDetallesPagosDao.TotalesCuentasFechas(conn, fechai, fechaf);
            listavigencia = myViewDetallesPagosDao.TotalesCuentasVigencias(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        if (listafecha != null && listafecha.size() > 0) {
            ViewDetallesPagos lcuentaf = new ViewDetallesPagos();

            for (int q = 0; q < listafecha.size(); q++) {
                lcuentaf = (ViewDetallesPagos)listafecha.get(q);

                ListaTotalesCuentas listacuentaf = new ListaTotalesCuentas();
                listacuentaf.setCODIGOCUENTA(lcuentaf.getCODIGOCUENTA());
                listacuentaf.setNOMBRECUENTA(lcuentaf.getNOMBRECUENTA());
                listacuentaf.setVALORPAGO(lcuentaf.getVALORPAGO());

                listacuentas.add(listacuentaf);
            }
        }

        if (listavigencia != null && listavigencia.size() > 0) {
            ViewDetallesPagos lcuentav = new ViewDetallesPagos();

            for (int q = 0; q < listavigencia.size(); q++) {
                lcuentav = (ViewDetallesPagos)listavigencia.get(q);

                ListaTotalesCuentas listacuentav = new ListaTotalesCuentas();
                listacuentav.setCODIGOCUENTA(lcuentav.getCODIGOCUENTA());
                listacuentav.setNOMBRECUENTA(lcuentav.getNOMBRECUENTA());
                listacuentav.setVALORPAGO(lcuentav.getVALORPAGO());

                listacuentas.add(listacuentav);
            }
        }

        return listacuentas;
    }

    public List getTotalesporCuentaTarifas(String fechai, String fechaf) {
        
        List listafecha, listavigencia, listacuentas;
        listafecha = null;
        listavigencia = null;
        
        listacuentas = new ArrayList();
        
        try {            
                conn = conexion.conectar();
            
                ViewDetallesPagosDao myViewDetallesPagosDao = new ViewDetallesPagosDao();
            
                listafecha = myViewDetallesPagosDao.TotalesCuentasFechasTarifas(conn, fechai, fechaf);
                //listafecha = myViewDetallesPagosDao.TotalesCuentasFechasTarifas(conn, fechai, fechaf, myMotor);
                       
                listavigencia = myViewDetallesPagosDao.TotalesCuentasVigenciasTarifas(conn);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            conexion.cerrarCx();
        }
              
        if (listafecha != null && listafecha.size() > 0) {
            ViewDetallesPagos lcuentaf = new ViewDetallesPagos();

            for (int q = 0; q < listafecha.size(); q++) {
                lcuentaf = (ViewDetallesPagos)listafecha.get(q);

                ListaTotalesCuentas listacuentaf = new ListaTotalesCuentas();
                listacuentaf.setCODIGOCUENTA(lcuentaf.getCODIGOCUENTA());
                listacuentaf.setNOMBRECUENTA(lcuentaf.getNOMBRECUENTA());
                listacuentaf.setVALORPAGO(lcuentaf.getVALORPAGO());

                listacuentas.add(listacuentaf);
            }
        }
        else System.out.println("la lista de Totales Cuentas Fechas Tarifas esta vac-*-a");
               
        if (listavigencia != null && listavigencia.size() > 0) {
            ViewDetallesPagos lcuentav = new ViewDetallesPagos();

            for (int q = 0; q < listavigencia.size(); q++) {
                lcuentav = (ViewDetallesPagos)listavigencia.get(q);

                ListaTotalesCuentas listacuentav = new ListaTotalesCuentas();
                listacuentav.setCODIGOCUENTA(lcuentav.getCODIGOCUENTA());
                listacuentav.setNOMBRECUENTA(lcuentav.getNOMBRECUENTA());
                listacuentav.setVALORPAGO(lcuentav.getVALORPAGO());

                listacuentas.add(listacuentav);
            }
        }
        else System.out.println("la lista de Totales Cuentas Vigencias esta vac-*-a");
                           
        return listacuentas;
    }


    public List getTotalesporConcepto(String fechai, String fechaf) {
        List listafecha, listacuentas;
        listafecha = null;
        listacuentas = new ArrayList();
        
        try {           
                conn = conexion.conectar();
            
                ViewDetallesPagosConceptosDao myViewDetallesPagosConceptosDao = new ViewDetallesPagosConceptosDao();
            
                listafecha = myViewDetallesPagosConceptosDao.TotalesConceptoFechas(conn, fechai, fechaf);
                //listafecha = myViewDetallesPagosConceptosDao.TotalesConceptoFechas(conn, fechai, fechaf, myMotor);           
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        
        if (listafecha != null && listafecha.size() > 0) {
            ViewDetallesPagosConceptos lcuentaf = new ViewDetallesPagosConceptos();

            for (int q = 0; q < listafecha.size(); q++) {
                lcuentaf = (ViewDetallesPagosConceptos)listafecha.get(q);

                ListaTotalesCuentas listacuentaf = new ListaTotalesCuentas();
                listacuentaf.setCODIGOCUENTA("" + lcuentaf.getIDCUENTACONTABLE());
                listacuentaf.setNOMBRECUENTA(lcuentaf.getNOMBRECONCEPTO());
                listacuentaf.setVALORPAGO(lcuentaf.getVALORPAGO());

                if (lcuentaf.getIDITEM() > 0) {

                }

                listacuentas.add(listacuentaf);
            }
        }
        else System.out.println("la lista de Totales Concepto Fechas esta vac-*-a");

        return listacuentas;
    }

    public List getAsobancaria(String fechai, String fechaf) {
        List lista;
        lista = null;
        try {
            conn = conexion.conectar();
            ViewAsobancariaDao myViewAsobancariaDao = new ViewAsobancariaDao();
            lista = myViewAsobancariaDao.loadPlano(conn, fechai, fechaf);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

}
