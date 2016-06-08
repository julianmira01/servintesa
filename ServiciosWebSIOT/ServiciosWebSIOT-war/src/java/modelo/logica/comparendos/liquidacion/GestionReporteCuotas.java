package modelo.logica.comparendos.liquidacion;

import java.sql.Connection;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.comparendos.accesorias.EmpresaCompDao;
import modelo.datos.dao.comparendos.generales.ComparendoCompDao;
import modelo.datos.dao.comparendos.generales.InfracionComparendoCompDao;
import modelo.datos.dao.comparendos.generales.InfractorCompDao;
//import modelo.datos.dao.comparendos.generales.TransitoCompDao;
import modelo.datos.dao.comparendos.liquidacion.AcuerdosPagoCompDao;
import modelo.datos.dao.comparendos.liquidacion.PagosCompDao;
import modelo.datos.dao.comparendos.liquidacion.RecibocuotasDao;
import modelo.datos.dao.comparendos.liquidador.ConceptosTarifaDao;
import modelo.datos.dao.comparendos.liquidador.DatosLiquidacionDao;
import modelo.datos.dao.comparendos.liquidador.ReciboscomparendoDao;
import modelo.datos.dao.generales.TransitoDao;
import modelo.datos.objetos.comparendos.accesorias.EmpresaComp;
import modelo.datos.objetos.comparendos.generales.ComparendoComp;
import modelo.datos.objetos.comparendos.generales.InfracionComparendoComp;
import modelo.datos.objetos.comparendos.generales.InfractorComp;
//import modelo.datos.objetos.comparendos.generales.TransitoComp;
import modelo.datos.objetos.comparendos.liquidacion.AcuerdosPagoComp;
import modelo.datos.objetos.comparendos.liquidacion.PagosComp;
import modelo.datos.objetos.comparendos.liquidacion.Recibocuotas;
import modelo.datos.objetos.comparendos.liquidador.ConceptosTarifa;
import modelo.datos.objetos.comparendos.liquidador.DatosLiquidacion;
import modelo.datos.objetos.comparendos.liquidador.Reciboscomparendo;
import modelo.datos.objetos.generales.AuditoriaSystem;
import modelo.datos.objetos.generales.Transito;

import modelo.logica.facturacion.GestionServiciosFacturacion;

import net.sf.jasperreports.engine.JREmptyDataSource;

import utilidades.Auditoria;
import utilidades.DSAcuerdoDet;
import utilidades.DSAcuerdoDetLiquidacion;
import utilidades.DSAcuerdoPago;
import utilidades.Funciones;
import utilidades.GenerarReportesCuotas;


public class GestionReporteCuotas {

    Connection connPrincipal;
    Conexion conexion;
    Connection conn;
    String myMotor;

    public GestionReporteCuotas() {
        super();
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

    public String crearReporteCuotas(Transito transito, AcuerdosPagoComp acuerdosPago, EmpresaComp empresa,
                                     InfractorComp infractor, Reciboscomparendo recibosComparendo,
                                     ArrayList listaPagosComp, ArrayList listaConceptosTarifa, int idUsuario, String myIp, String myHost) {

        GenerarReportesCuotas generarReportesCuotas = new GenerarReportesCuotas();
        DSAcuerdoPago dsAcuerdoPago = new DSAcuerdoPago();
        DSAcuerdoDet dsAcuerdoDet = new DSAcuerdoDet();
        DSAcuerdoDetLiquidacion dsAcuerdoLiq = new DSAcuerdoDetLiquidacion();

        dsAcuerdoDet.setListaPagosComp(listaPagosComp);
        dsAcuerdoDet.setCantidad(listaPagosComp.size());

        dsAcuerdoLiq.setListaConceptosTarifa(listaConceptosTarifa);
        dsAcuerdoLiq.setCantidad(listaConceptosTarifa.size());
        dsAcuerdoLiq.setValorTotalCuotas(dsAcuerdoDet.getValorTotal());

        dsAcuerdoPago.setAcuerdosPago(acuerdosPago);
        dsAcuerdoPago.setCantidad(0);
        dsAcuerdoPago.setDsAcuerdo(dsAcuerdoDet);
        dsAcuerdoPago.setDsLiquidacion(dsAcuerdoLiq);
        dsAcuerdoPago.setEmpresa(empresa);
        dsAcuerdoPago.setInfractor(infractor);
        dsAcuerdoPago.setRecibosComparendo(recibosComparendo);
        dsAcuerdoPago.setTransito(transito);

        Date fechaActual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyMMddHHmmss");
        //String fileName = "AcuerdoPago_" + acuerdosPago.getNUMERO() + "_" + formato.format(fechaActual);
        String fileName = acuerdosPago.getNUMERO();
        generarReportesCuotas.crearReporteAcuerdoPagoComp(new JREmptyDataSource(), dsAcuerdoPago.getParametros(),
                                                          fileName);
        //auditar otro
        Auditoria myAuditoria = new Auditoria();
        AuditoriaSystem myAuditSx = new AuditoriaSystem();
        myAuditSx.setTABLAAFECTADA("RECIBOSCOMPARENDO");
        myAuditSx.setCAMPOCLAVE("NUMERO_RECIBO");
        myAuditSx.setVLRCAMPOCLAVE(String.valueOf(recibosComparendo.getNUMERO_RECIBO()));
        myAuditSx.setID_USUARIO(idUsuario);
        myAuditSx.setIP(myIp);
        myAuditSx.setNOMBREEQUIPO(myHost);
        myAuditSx.setDESCRIPOPERACION(" Imprimir reporte acuerdo pago nro " + acuerdosPago.getNUMERO());
        myAuditSx.setTIPOPERACION("IMPRI");
        myAuditoria.auditarOtraOp(conn, myAuditSx, 0);

        return fileName;
    }

    private String crearReporteReciboCuotas(Transito transito, AcuerdosPagoComp acuerdosPago, EmpresaComp empresa,
                                            InfractorComp infractor, Reciboscomparendo recibosComparendo,
                                            PagosComp pagosComp, ArrayList listaPagosComp,
                                            ArrayList listaConceptosTarifa, String codigoBarras, int idUsuario, String myIp, String myHost) {

        GenerarReportesCuotas generarReportesCuotas = new GenerarReportesCuotas();
        DSAcuerdoPago dsAcuerdoPago = new DSAcuerdoPago();
        DSAcuerdoDet dsAcuerdoDet = new DSAcuerdoDet();
        DSAcuerdoDetLiquidacion dsAcuerdoLiq = new DSAcuerdoDetLiquidacion();

        dsAcuerdoDet.setListaPagosComp(listaPagosComp);
        dsAcuerdoDet.setCantidad(listaPagosComp.size());

        dsAcuerdoLiq.setListaConceptosTarifa(listaConceptosTarifa);
        dsAcuerdoLiq.setCantidad(listaConceptosTarifa.size());
        dsAcuerdoLiq.setValorTotalCuotas(dsAcuerdoDet.getValorTotal());

        dsAcuerdoPago.setAcuerdosPago(acuerdosPago);
        dsAcuerdoPago.setCantidad(0);
        dsAcuerdoPago.setDsAcuerdo(dsAcuerdoDet);
        dsAcuerdoPago.setDsLiquidacion(dsAcuerdoLiq);
        dsAcuerdoPago.setEmpresa(empresa);
        dsAcuerdoPago.setInfractor(infractor);
        dsAcuerdoPago.setRecibosComparendo(recibosComparendo);
        dsAcuerdoPago.setTransito(transito);
        dsAcuerdoPago.setPago(pagosComp);
        dsAcuerdoPago.setCodigoBarras(codigoBarras);
        

        Date fechaActual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyMMddHHmmss");
        String fileName =
            //"ReciboAcuerdoPago_" + recibosComparendo.getNUMERO_RECIBO() + "_" + formato.format(fechaActual);
            recibosComparendo.getNUMERO_RECIBO();
        generarReportesCuotas.crearReporteReciboAcuerdoPagoComp(new JREmptyDataSource(), dsAcuerdoPago.getParametros(),
                                                                fileName);
        //auditar otro
        Auditoria myAuditoria = new Auditoria();
        AuditoriaSystem myAuditSx = new AuditoriaSystem();
        myAuditSx.setTABLAAFECTADA("RECIBOSCOMPARENDO");
        myAuditSx.setCAMPOCLAVE("NUMERO_RECIBO");
        myAuditSx.setVLRCAMPOCLAVE(String.valueOf(recibosComparendo.getNUMERO_RECIBO()));
        myAuditSx.setID_USUARIO(idUsuario);
        myAuditSx.setIP(myIp);
        myAuditSx.setNOMBREEQUIPO(myHost);
        myAuditSx.setDESCRIPOPERACION(" Imprimir reporte recibo cuota de pago nro " + acuerdosPago.getNUMERO());
        myAuditSx.setTIPOPERACION("IMPRI");
        myAuditoria.auditarOtraOp(conn, myAuditSx, 0);

        return fileName;
    }

    public String crearReporteCuotas(AcuerdosPagoComp acuerdosPago, int idEmpresa, int idInfractor,
                                     int idLiquidacion, int idUsuario, String myIp, String myHost) {
        String res = null;
        //daos
        //TransitoCompDao transitoDao = new TransitoCompDao();
        TransitoDao transitoDao = new TransitoDao();
        EmpresaCompDao empresaDao = new EmpresaCompDao();
        InfractorCompDao infractorDao = new InfractorCompDao();
        ReciboscomparendoDao recibosCompDao = new ReciboscomparendoDao();
        ConceptosTarifaDao conceptosDao = new ConceptosTarifaDao();
        DatosLiquidacionDao datosLiquidacionDao = new DatosLiquidacionDao();
        InfracionComparendoCompDao infraccionComparendoDao = new InfracionComparendoCompDao();
        ComparendoCompDao comparendoDao = new ComparendoCompDao();
        PagosCompDao pagosDao = new PagosCompDao();
        //objetos
        //TransitoComp transito = null;
        Transito transito = null;
        EmpresaComp empresa = null;
        InfractorComp infractor = null;
        Reciboscomparendo recibo = null;
        ConceptosTarifa conceptos = null;
        DatosLiquidacion datosLiquidacion = null;
        InfracionComparendoComp infraccionComparendo = null;
        ComparendoComp comparendo = null;
        PagosComp pago = null;
        //listas
        ArrayList listaConceptosTarifa = new ArrayList();
        ArrayList listaPagosComp = new ArrayList();
        List objs;
        List objsConceptos;
        List objsInfraccionComparendo;
        List objsComparendo;

        try {
            conn = conexion.conectarComparendos();
            connPrincipal = conexion.conectar();

            objs = transitoDao.loadAll(connPrincipal);
            if (objs != null && objs.size() > 0) {
              transito = (Transito)objs.get(0);
                //transito = (TransitoComp)objs.get(0);
            }
            if (idEmpresa >= 0) {
                empresa = new EmpresaComp();
                empresa.setID_EMPRESA(idEmpresa);
                objs = empresaDao.searchMatching(conn, empresa);
                if (objs != null && objs.size() > 0) {
                    empresa = (EmpresaComp)objs.get(0);
                }
            }
            if (idInfractor >= 0) {
                infractor = new InfractorComp();
                infractor.setID_INFRACTOR(idInfractor);
                objs = infractorDao.searchMatching(conn, infractor);
                if (objs != null && objs.size() > 0) {
                    infractor = (InfractorComp)objs.get(0);
                }
            }
            if (idLiquidacion >= 0) {
                //recibo
                recibo = new Reciboscomparendo();
                recibo.setIDLIQUIDACION(idLiquidacion);
                objs = recibosCompDao.searchMatching(conn, recibo);
                if (objs != null && objs.size() > 0) {
                    recibo = (Reciboscomparendo)objs.get(0);
                }
                //pagos
                pago = new PagosComp();
                pago.setIDLIQUIDACION(idLiquidacion);
                objs = pagosDao.searchMatching(conn, pago);
                if (objs != null && objs.size() > 0) {
                    for (int i = 0; i < objs.size(); i++) {
                        listaPagosComp.add(objs.get(i));
                    }
                }
                //conceptos
                datosLiquidacion = new DatosLiquidacion();
                datosLiquidacion.setIDLIQUIDACION(idLiquidacion + "");
                objs = datosLiquidacionDao.searchMatching(conn, datosLiquidacion);
                if (objs != null && objs.size() > 0) {
                    for (int i = 0; i < objs.size(); i++) {
                        datosLiquidacion = (DatosLiquidacion)objs.get(i);
                        conceptos = new ConceptosTarifa();
                        conceptos.setID_ITEM(datosLiquidacion.getIDITEM() + "");
                        objsConceptos = conceptosDao.searchMatching(conn, conceptos);
                        if (objsConceptos != null && objsConceptos.size() > 0) {
                            conceptos = (ConceptosTarifa)objsConceptos.get(0);
                            conceptos.setLTD_VALOR(datosLiquidacion.getVALOR());
                            if (Funciones.esEntero(datosLiquidacion.getIDLIQUIDACION())) {
                                infraccionComparendo = new InfracionComparendoComp();
                                infraccionComparendo.setID(Integer.parseInt(datosLiquidacion.getIDINFRACCION()));
                                objsInfraccionComparendo =
                                        infraccionComparendoDao.searchMatching(conn, infraccionComparendo);
                                if (objsInfraccionComparendo != null && objsInfraccionComparendo.size() > 0) {
                                    infraccionComparendo = (InfracionComparendoComp)objsInfraccionComparendo.get(0);
                                    comparendo = new ComparendoComp();
                                    comparendo.setID_COMPARENDO(infraccionComparendo.getIDCOMPARENDO());
                                    objsComparendo = comparendoDao.searchMatching(conn, comparendo);
                                    if (objsComparendo != null && objsComparendo.size() > 0) {
                                        comparendo = (ComparendoComp)objsComparendo.get(0);
                                        conceptos.setNUMEROCOMPARENDO(comparendo.getNUMEROCOMPARENDO());
                                        conceptos.setFECHACOMPARENDO(comparendo.getFECHACOMPARENDO());
                                    }
                                }
                            }
                            listaConceptosTarifa.add(conceptos);
                        }
                    }
                    conceptos = new ConceptosTarifa();
                    conceptos.setDESCRIPCION("INTERES");
                    conceptos.setLTD_VALOR("INTERES");
                    listaConceptosTarifa.add(conceptos);
                    conceptos = new ConceptosTarifa();
                    conceptos.setDESCRIPCION("TOTAL");
                    conceptos.setLTD_VALOR("TOTAL");
                    listaConceptosTarifa.add(conceptos);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        res =
crearReporteCuotas(transito, acuerdosPago, empresa, infractor, recibo, listaPagosComp, listaConceptosTarifa, idUsuario, myIp, myHost);
        return res;
    }

    public String crearReporteReciboCuotas(int nroCuota, int idEmpresa, int idInfractor, int idLiquidacion, int idUsuario, String myIp, String myHost) {
        String res = null;
        //daos
        //TransitoCompDao transitoDao = new TransitoCompDao();
        TransitoDao transitoDao = new TransitoDao();
        EmpresaCompDao empresaDao = new EmpresaCompDao();
        InfractorCompDao infractorDao = new InfractorCompDao();
        ReciboscomparendoDao recibosCompDao = new ReciboscomparendoDao();
        ConceptosTarifaDao conceptosDao = new ConceptosTarifaDao();
        DatosLiquidacionDao datosLiquidacionDao = new DatosLiquidacionDao();
        InfracionComparendoCompDao infraccionComparendoDao = new InfracionComparendoCompDao();
        ComparendoCompDao comparendoDao = new ComparendoCompDao();
        PagosCompDao pagosDao = new PagosCompDao();
        AcuerdosPagoCompDao acuerdosPagoDao = new AcuerdosPagoCompDao();
        RecibocuotasDao reciboCuotasDao = new RecibocuotasDao();
        //objetos
        //TransitoComp transito = null;
        Transito transito = null;
        EmpresaComp empresa = null;
        InfractorComp infractor = null;
        Reciboscomparendo recibo = null;
        ConceptosTarifa conceptos = null;
        DatosLiquidacion datosLiquidacion = null;
        InfracionComparendoComp infraccionComparendo = null;
        ComparendoComp comparendo = null;
        PagosComp pago = null;
        AcuerdosPagoComp acuerdoPago = null;
        Recibocuotas reciboCuota = null;
        String codigoBarras = "";
        //listas
        ArrayList listaConceptosTarifa = new ArrayList();
        ArrayList listaPagosComp = new ArrayList();
        List objs;
        List objsConceptos;
        List objsInfraccionComparendo;
        List objsComparendo;

        try {
            conn = conexion.conectarComparendos();
            
            connPrincipal = conexion.conectar();
            objs = transitoDao.loadAll(connPrincipal);
            if (objs != null && objs.size() > 0) {
                transito = (Transito)objs.get(0);
            }
            if (idEmpresa >= 0) {
                empresa = new EmpresaComp();
                empresa.setID_EMPRESA(idEmpresa);
                objs = empresaDao.searchMatching(conn, empresa);
                if (objs != null && objs.size() > 0) {
                    empresa = (EmpresaComp)objs.get(0);
                }
            }
            if (idInfractor >= 0) {
                infractor = new InfractorComp();
                infractor.setID_INFRACTOR(idInfractor);
                objs = infractorDao.searchMatching(conn, infractor);
                if (objs != null && objs.size() > 0) {
                    infractor = (InfractorComp)objs.get(0);
                }
            }
            if (idLiquidacion >= 0) {
                //acuerdo pago
                acuerdoPago = new AcuerdosPagoComp();
                acuerdoPago.setIDLIQUIDACION(idLiquidacion);
                objs = acuerdosPagoDao.searchMatching(conn, acuerdoPago);
                if (objs != null && objs.size() > 0) {
                    acuerdoPago = (AcuerdosPagoComp)objs.get(0);
                }
                //pagos
                pago = new PagosComp();
                pago.setIDLIQUIDACION(idLiquidacion);
                objs = pagosDao.searchMatching(conn, pago);
                if (objs != null && objs.size() > 0) {
                    for (int i = 0; i < objs.size(); i++) {
                        listaPagosComp.add(objs.get(i));
                    }
                }
                //pago
                pago = new PagosComp();
                pago.setIDLIQUIDACION(idLiquidacion);
                pago.setNOCUOTA(nroCuota);
                objs = pagosDao.searchMatching(conn, pago);
                if (objs != null && objs.size() > 0) {
                    pago = (PagosComp)objs.get(0);
                }
                //recibo cuota
                reciboCuota = new Recibocuotas();
                reciboCuota.setIDCUOTA(pago.getID());
                objs = reciboCuotasDao.searchMatching(conn, reciboCuota);
                if (objs != null && objs.size() > 0) {
                    reciboCuota = (Recibocuotas)objs.get(0);
                }
                //recibo
                recibo = new Reciboscomparendo();
                recibo.setID(reciboCuota.getIDRECIBO());
                objs = recibosCompDao.searchMatching(conn, recibo);
                if (objs != null && objs.size() > 0) {
                    recibo = (Reciboscomparendo)objs.get(0);
                }
                //conceptos
                datosLiquidacion = new DatosLiquidacion();
                datosLiquidacion.setIDLIQUIDACION(idLiquidacion + "");
                objs = datosLiquidacionDao.searchMatching(conn, datosLiquidacion);
                if (objs != null && objs.size() > 0) {
                    for (int i = 0; i < objs.size(); i++) {
                        datosLiquidacion = (DatosLiquidacion)objs.get(i);
                        conceptos = new ConceptosTarifa();
                        conceptos.setID_ITEM(datosLiquidacion.getIDITEM() + "");
                        objsConceptos = conceptosDao.searchMatching(conn, conceptos);
                        if (objsConceptos != null && objsConceptos.size() > 0) {
                            conceptos = (ConceptosTarifa)objsConceptos.get(0);
                            conceptos.setLTD_VALOR(datosLiquidacion.getVALOR());
                            if (Funciones.esEntero(datosLiquidacion.getIDLIQUIDACION())) {
                                infraccionComparendo = new InfracionComparendoComp();
                                infraccionComparendo.setID(Integer.parseInt(datosLiquidacion.getIDINFRACCION()));
                                objsInfraccionComparendo =
                                        infraccionComparendoDao.searchMatching(conn, infraccionComparendo);
                                if (objsInfraccionComparendo != null && objsInfraccionComparendo.size() > 0) {
                                    infraccionComparendo = (InfracionComparendoComp)objsInfraccionComparendo.get(0);
                                    comparendo = new ComparendoComp();
                                    comparendo.setID_COMPARENDO(infraccionComparendo.getIDCOMPARENDO());
                                    objsComparendo = comparendoDao.searchMatching(conn, comparendo);
                                    if (objsComparendo != null && objsComparendo.size() > 0) {
                                        comparendo = (ComparendoComp)objsComparendo.get(0);
                                        conceptos.setNUMEROCOMPARENDO(comparendo.getNUMEROCOMPARENDO());
                                        conceptos.setFECHACOMPARENDO(comparendo.getFECHACOMPARENDO());
                                    }
                                }
                            }
                            listaConceptosTarifa.add(conceptos);
                        }
                    }
                    conceptos = new ConceptosTarifa();
                    conceptos.setDESCRIPCION("INTERES");
                    conceptos.setLTD_VALOR("INTERES");
                    listaConceptosTarifa.add(conceptos);
                    conceptos = new ConceptosTarifa();
                    conceptos.setDESCRIPCION("TOTAL");
                    conceptos.setLTD_VALOR("TOTAL");
                    listaConceptosTarifa.add(conceptos);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        
        //codigo de barras
        if (infractor != null && recibo != null && pago != null) {
            GestionServiciosFacturacion gestionSFacturacion = new GestionServiciosFacturacion();
            String str_date = new SimpleDateFormat("yyyyMMdd").format(new Date());
            codigoBarras = gestionSFacturacion.generarCodigoBarras(infractor.getNROIDENTIFICACION().trim(), 
                                                                   recibo.getNUMERO_RECIBO(), (int)pago.getVALOR() + "", str_date);
        }
        res = crearReporteReciboCuotas(transito, acuerdoPago, empresa, infractor, recibo, pago, listaPagosComp, 
                                       listaConceptosTarifa, codigoBarras, idUsuario, myIp, myHost);
        return res;
    }
}
