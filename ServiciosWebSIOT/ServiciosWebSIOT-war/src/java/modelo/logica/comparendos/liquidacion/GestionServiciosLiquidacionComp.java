package modelo.logica.comparendos.liquidacion;

import java.sql.Connection;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.comparendos.generales.InfracionComparendoCompDao;
import modelo.datos.dao.comparendos.generales.InfractorCompDao;
import modelo.datos.dao.comparendos.generales.LicenciaCompDao;
import modelo.datos.dao.comparendos.generales.TransitoCompDao;
import modelo.datos.dao.comparendos.liquidacion.AcuerdosPagoCompDao;
import modelo.datos.dao.comparendos.liquidacion.PagosCompDao;
import modelo.datos.dao.comparendos.liquidacion.RecibocuotasDao;
import modelo.datos.dao.comparendos.liquidacion.ViewPagosCompDao;
import modelo.datos.dao.comparendos.liquidacion.tarifas.LiquidacionCompDao;
import modelo.datos.dao.comparendos.liquidador.DatosLiquidacionDao;
import modelo.datos.dao.comparendos.liquidador.ReciboscomparendoDao;
import modelo.datos.objetos.comparendos.generales.InfracionComparendoComp;
import modelo.datos.objetos.comparendos.generales.InfractorComp;
import modelo.datos.objetos.comparendos.generales.TransitoComp;
import modelo.datos.objetos.comparendos.liquidacion.AcuerdosPagoComp;
import modelo.datos.objetos.comparendos.liquidacion.PagosComp;
import modelo.datos.objetos.comparendos.liquidacion.Recibocuotas;
import modelo.datos.objetos.comparendos.liquidacion.ViewPagosComp;
import modelo.datos.objetos.comparendos.liquidacion.tarifas.LiquidacionComp;
import modelo.datos.objetos.comparendos.liquidador.DatosLiquidacion;
import modelo.datos.objetos.comparendos.liquidador.Reciboscomparendo;
import modelo.datos.objetos.generales.AuditoriaSystem;

import utilidades.Auditoria;
import utilidades.Funciones;


public class GestionServiciosLiquidacionComp {
    Conexion conexion;
    Connection conn;
    String myMotor;

    public GestionServiciosLiquidacionComp() {
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

    public List getLiquidacion(LiquidacionComp myLiqui) {
        List mylista;
        mylista = null;
        try {
            conn = conexion.conectarComparendos();
            LiquidacionCompDao myLiquidacionDao = new LiquidacionCompDao();
            mylista = myLiquidacionDao.searchMatching(conn, myLiqui);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return mylista;
    }

    public List getLiquidaciones() {
        List mylista;
        mylista = null;
        try {
            conn = conexion.conectarComparendos();
            LiquidacionCompDao myLiquidacionDao = new LiquidacionCompDao();
            mylista = myLiquidacionDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return mylista;
    }


    public AcuerdosPagoComp insertarAcuerdosPago(AcuerdosPagoComp myAcuerdo, int idUsuario, String myIp, String myHost) {
        int id;
        List lista;
        //myAcuerdo.setNUMERO(obtenerNroAcuerdoPAgo());
        try {
            conn = conexion.conectarComparendos();
            AcuerdosPagoCompDao myAcuerdoDao = new AcuerdosPagoCompDao();
            myMotor = myMotor.toUpperCase();
            id = Funciones.obtenerId(conn, "ACUERDOSPAGO_ID_GEN", "GEN_ACUERDOSPAGO", myMotor);
            myAcuerdo.setID(id);
            myAcuerdo.setFECHAREGISTRO(Funciones.getFechaSistema(conn,myMotor));
            myAcuerdo.setHORAREGISTRO(Funciones.getHoraSistemaString(conn));
            myAcuerdoDao.create(conn, myAcuerdo);
            myAcuerdo = new AcuerdosPagoComp();
            myAcuerdo.setID(id);
            lista = myAcuerdoDao.searchMatching(conn, myAcuerdo);
            if (lista != null && lista.size() > 0) {
                myAcuerdo = (AcuerdosPagoComp)lista.get(0);
            }
            //auditar insert
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("ACUERDOSPAGO");
            myAuditSx.setCAMPOCLAVE("ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(myAcuerdo.getID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, myAcuerdo, 0);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return myAcuerdo;
    }
    
    public List getAcuerdoPago(AcuerdosPagoComp myAcuerdoPago) {
        List mylista;
        mylista = null;
        try {
            conn = conexion.conectarComparendos();
            AcuerdosPagoCompDao myAcuerdoPagoCompDao = new AcuerdosPagoCompDao();
            mylista = myAcuerdoPagoCompDao.searchMatching(conn, myAcuerdoPago);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return mylista;
    }

    public String obtenerNroAcuerdoPAgo() {
        double nro = 0;
        List lista;
        TransitoComp myTransito;
        try {
            conn = conexion.conectarComparendos();
            TransitoCompDao myTransDao = new TransitoCompDao();
            lista = myTransDao.loadAll(conn);
            if (lista != null && lista.size() > 0) {
                myTransito = (TransitoComp)lista.get(0);
                nro = myTransito.getNROINICIOACUERDOPAGO();
                myTransito.setNROINICIOACUERDOPAGO(nro + 1);
                myTransDao.actualizarNroAcuerdoPago(conn, myTransito);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return String.valueOf((int)nro);
    }

    public List obtenerAcuerdosPagoInfractor(String nroIdent, int tipo_iden) {
        List mylista;
        mylista = null;
        try {
            conn = conexion.conectarComparendos();
            AcuerdosPagoCompDao myAcuerPagoDao = new AcuerdosPagoCompDao();
            mylista = myAcuerPagoDao.buscarAcuerdosInfractor(conn, nroIdent, tipo_iden);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return mylista;
    }
    
    public boolean eliminarAcuerdoPago(AcuerdosPagoComp myAcuerdoPago, int idUsuario, String myIp, String myHost) {
        boolean res = false;
        try {
            conn = conexion.conectarComparendos();
            AcuerdosPagoCompDao myAcuerdoPagoCompDao = new AcuerdosPagoCompDao();
            //auditar eliminar
            myAcuerdoPagoCompDao.load(conn, myAcuerdoPago);
            myAcuerdoPagoCompDao.delete(conn, myAcuerdoPago);
            res = true;
            //auditar eliminar
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("ACUERDOSPAGO");
            myAuditSx.setCAMPOCLAVE("ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(myAcuerdoPago.getID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEliminacion(conn, myAuditSx, myAcuerdoPago, 0);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public PagosComp insertarPagosComp(PagosComp myPago, int idUsuario, String myIp, String myHost) {
        int id;
        List lista;
        try {
            conn = conexion.conectarComparendos();
            PagosCompDao myPagoDao = new PagosCompDao();
            myMotor = myMotor.toUpperCase();
            id = Funciones.obtenerId(conn, "GEN_PAGOSCOMPARENDO", "GEN_PAGOSCOMPARENDO", myMotor);
            myPago.setID(id);
            myPago.setESTADO(14);
            myPagoDao.create(conn, myPago);
            myPago = new PagosComp();
            myPago.setID(id);
            lista = myPagoDao.searchMatching(conn, myPago);
            if (lista != null && lista.size() > 0) {
                myPago = (PagosComp)lista.get(0);
            }
            //auditar insert
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("PAGOSCOMPARENDO");
            myAuditSx.setCAMPOCLAVE("ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(myPago.getID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, myPago, 0);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return myPago;
    }

    public PagosComp insertarConFechaPagoComp(PagosComp myPago, int idUsuario, String myIp, String myHost) {
        int id;
        List lista;
        try {
            conn = conexion.conectarComparendos();
            PagosCompDao myPagoDao = new PagosCompDao();
            myMotor = myMotor.toUpperCase();
            id = Funciones.obtenerId(conn, "GEN_PAGOSCOMPARENDO", "GEN_PAGOSCOMPARENDO", myMotor);
            myPago.setFECHAPAGO(Funciones.getFechaSistema(conn,myMotor));
            myPago.setID(id);
            myPagoDao.create(conn, myPago);
            myPago = new PagosComp();
            myPago.setID(id);
            lista = myPagoDao.searchMatching(conn, myPago);
            if (lista != null && lista.size() > 0) {
                myPago = (PagosComp)lista.get(0);
            }
            //auditar insert
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("PAGOSCOMPARENDO");
            myAuditSx.setCAMPOCLAVE("ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(myPago.getID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, myPago, 0);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return myPago;
    }

    public List obtenerLiquidacionesDeudor(String nroIdent, int tipo_iden) {
        List mylista;
        mylista = null;
        try {
            conn = conexion.conectarComparendos();
            LiquidacionCompDao myLiqCompDao = new LiquidacionCompDao();
            mylista = myLiqCompDao.buscarLiquiInfractor(conn, nroIdent, tipo_iden);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return mylista;
    }

    public List obtenerLiquidaciones(LiquidacionComp myLiquid) {
        List mylista;
        mylista = null;
        try {
            conn = conexion.conectarComparendos();
            LiquidacionCompDao myLiqCompDao = new LiquidacionCompDao();
            mylista = myLiqCompDao.searchMatching(conn, myLiquid);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return mylista;
    }

    public boolean editarLiquidacion(LiquidacionComp obj, int idUsuario, String myIp, String myHost) {
        boolean res = false;
        try {
            conn = conexion.conectarComparendos();
            LiquidacionCompDao dao = new LiquidacionCompDao();
            //auditar edicion
            LiquidacionComp ant = new LiquidacionComp();
            ant.setIDLIQUIDACION(obj.getIDLIQUIDACION());
            dao.load(conn, ant);
            dao.save(conn, obj);
            res = true;
            //auditar edicion
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("LIQUIDACION");
            myAuditSx.setCAMPOCLAVE("IDLIQUIDACION");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(obj.getIDLIQUIDACION()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEdicion(conn, myAuditSx, ant, obj, myIp, myHost, 0);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public List getViewPagosComp(ViewPagosComp myPagos) {
        List mylista;
        mylista = null;
        try {
            conn = conexion.conectarComparendos();
            ViewPagosCompDao myViewPagosDao = new ViewPagosCompDao();
            mylista = myViewPagosDao.searchMatching(conn, myPagos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return mylista;
    }

    public boolean eliminarPagoComp(PagosComp myPago, int idUsuario, String myIp, String myHost) {
        boolean res = false;
        try {
            conn = conexion.conectarComparendos();
            PagosCompDao myPagoCompDao = new PagosCompDao();
            //auditar eliminar
            myPagoCompDao.load(conn, myPago);
            myPagoCompDao.delete(conn, myPago);
            res = true;
            //auditar eliminar
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("PAGOSCOMPARENDO");
            myAuditSx.setCAMPOCLAVE("ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(myPago.getID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEliminacion(conn, myAuditSx, myPago, 0);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public List getPagosComp(PagosComp obj) {
        List lista;
        lista = null;
        try {
            conn = conexion.conectarComparendos();
            PagosCompDao dao = new PagosCompDao();
            lista = dao.searchMatching(conn, obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public boolean editarPagosComp(PagosComp obj, int idUsuario, String myIp, String myHost) {
        boolean edited = false;
        try {
            conn = conexion.conectarComparendos();
            obj.setFECHAPAGO(Funciones.getFechaSistema(conn,myMotor));
            PagosCompDao dao = new PagosCompDao();
            //auditar edicion
            PagosComp ant = new PagosComp();
            ant.setID(obj.getID());
            dao.load(conn, ant);
            dao.save(conn, obj);
            edited = true;
            //auditar edicion
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("PAGOSCOMPARENDO");
            myAuditSx.setCAMPOCLAVE("ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(obj.getID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEdicion(conn, myAuditSx, ant, obj, myIp, myHost, 0);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return edited;
    }

    public String facturarCuotaPago(int idInfractor, int idLiquidacion, int nroCuota, int idUsuario, String myIp, String myHost) {
        String numRecibo = "-1";
        try {
            conn = conexion.conectarComparendos();
            //daos
            InfractorCompDao infractorDao = new InfractorCompDao();
            LiquidacionCompDao liquidacionDao = new LiquidacionCompDao();
            ReciboscomparendoDao recibosDao = new ReciboscomparendoDao();
            PagosCompDao pagosDao = new PagosCompDao();
            RecibocuotasDao reciboCuotaDao = new RecibocuotasDao();
            //obs
            InfractorComp infractor;
            LiquidacionComp liquidacion;
            Reciboscomparendo recibo;
            PagosComp pago;
            Recibocuotas reciboCuota;
            List objs;
            
            if (idInfractor > 0 && idLiquidacion > 0) {
                //buscar infractor
                infractor = new InfractorComp();
                infractor.setID_INFRACTOR(idInfractor);
                infractorDao.load(conn, infractor);
                //buscar liquidacion
                liquidacion = new LiquidacionComp();
                liquidacion.setIDLIQUIDACION(idLiquidacion);
                liquidacionDao.load(conn, liquidacion);
                
                //verificar no recibo para el pago
                pago = new PagosComp();
                pago.setIDLIQUIDACION(idLiquidacion);
                pago.setNOCUOTA(nroCuota);
                objs = pagosDao.searchMatching(conn, pago);
                //existe
                if (objs != null && objs.size() > 0) {
                    //buscar recibo cuota
                    pago = (PagosComp)objs.get(0);
                    reciboCuota = new Recibocuotas();
                    reciboCuota.setIDCUOTA(pago.getID());
                    objs = reciboCuotaDao.searchMatching(conn, reciboCuota);
                    numRecibo = getNumeroFactura(idLiquidacion, pago.getID());
                    
                    if (objs != null && objs.size() > 0) {
                        reciboCuota = (Recibocuotas)objs.get(0);
                        //buscar recibo comparendo
                        recibo = new Reciboscomparendo();
                        recibo.setID(reciboCuota.getIDRECIBO());
                        objs = recibosDao.searchMatching(conn, recibo);
                        if (objs != null && objs.size() > 0) {
                            recibo = (Reciboscomparendo)objs.get(0);
                            numRecibo = recibo.getNUMERO_RECIBO();
                        }
                    }
                    else {
                        //crear recibo comparendo
                        recibo = new Reciboscomparendo();
                        int idRecibo = Funciones.obtenerId(conn, "GEN_ID_RECIBOSCOMPARENDO", "GEN_ID_RECIBOSCOMPARENDO", myMotor);
                        recibo.setID(idRecibo);
                        recibo.setESTADO(14);
                        recibo.setFECHACREACION(liquidacion.getFECHA());
                        recibo.setFECHAREGISTRO(liquidacion.getFECHAREGISTRO());
                        recibo.setHORAREGISTRO(liquidacion.getHORAREGISTRO());
                        recibo.setIDINFRACTOR(infractor.getID_INFRACTOR());
                        recibo.setIDLIQUIDACION(liquidacion.getIDLIQUIDACION());
                        recibo.setIDUSUARIO(liquidacion.getIDUSUARIO());
                        recibo.setNUMERO_RECIBO(numRecibo);
                        recibo.setVALOR(pago.getVALOR());
                        recibosDao.create(conn, recibo);
                        //auditar insert
                        Auditoria myAuditoria = new Auditoria();
                        AuditoriaSystem myAuditSx = new AuditoriaSystem();
                        myAuditSx.setTABLAAFECTADA("RECIBOSCOMPARENDO");
                        myAuditSx.setCAMPOCLAVE("ID");
                        myAuditSx.setVLRCAMPOCLAVE(String.valueOf(recibo.getID()));
                        myAuditSx.setID_USUARIO(idUsuario);
                        myAuditSx.setIP(myIp);
                        myAuditSx.setNOMBREEQUIPO(myHost);
                        myAuditoria.auditarInsersion(conn, myAuditSx, recibo, 0);

                        //crear recibo cuota
                        reciboCuota = new Recibocuotas();
                        reciboCuota.setFECHAREGISTRO(Funciones.getFechaSistema(conn,myMotor));
                        int idReciboCuota = Funciones.obtenerId(conn, "GEN_ID_RECIBOCUOTAS", "GEN_ID_RECIBOCUOTAS", myMotor);
                        reciboCuota.setID(idReciboCuota);
                        reciboCuota.setIDCUOTA(pago.getID());
                        reciboCuota.setIDRECIBO(recibo.getID());
                        reciboCuotaDao.create(conn, reciboCuota);
                        //auditar insert
                        myAuditoria = new Auditoria();
                        myAuditSx = new AuditoriaSystem();
                        myAuditSx.setTABLAAFECTADA("RECIBOCUOTAS");
                        myAuditSx.setCAMPOCLAVE("ID");
                        myAuditSx.setVLRCAMPOCLAVE(String.valueOf(reciboCuota.getID()));
                        myAuditSx.setID_USUARIO(idUsuario);
                        myAuditSx.setIP(myIp);
                        myAuditSx.setNOMBREEQUIPO(myHost);
                        myAuditoria.auditarInsersion(conn, myAuditSx, reciboCuota, 0);

                    }
                    //actualizar pago
                    if (pago.getESTADO() == 14) { //no pago
                        pago.setESTADO(11); //liquidado
                        //auditar edicion
                        PagosComp ant = new PagosComp();
                        ant.setID(pago.getID());
                        pagosDao.load(conn, ant);
                        pagosDao.save(conn, pago);
                        //auditar edicion
                        Auditoria myAuditoria = new Auditoria();
                        AuditoriaSystem myAuditSx = new AuditoriaSystem();
                        myAuditSx.setTABLAAFECTADA("PAGOSCOMPARENDO");
                        myAuditSx.setCAMPOCLAVE("ID");
                        myAuditSx.setVLRCAMPOCLAVE(String.valueOf(pago.getID()));
                        myAuditSx.setID_USUARIO(idUsuario);
                        myAuditSx.setIP(myIp);
                        myAuditSx.setNOMBREEQUIPO(myHost);
                        myAuditoria.auditarEdicion(conn, myAuditSx, ant, pago, myIp, myHost, 0);

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            numRecibo = "-1";
        } finally {
            conexion.cerrarCx();
        }
        return numRecibo;
    }
    
    public String getNumeroFactura(int idL_factura, int idPago) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");
        String str_date = (String)formatter.format(date);
        //String numero = "2" + str_date + idL_factura + idPago;
        String numero = ""+idPago;
        return numero;
    }
    
    public int anularLiquidacion(int idLiquidacion, int idUsuario, String myIp, String myHost) {
        int res = 0;
        try {
            conn = conexion.conectarComparendos();
            
            ReciboscomparendoDao recibosCompDao = new ReciboscomparendoDao();
            DatosLiquidacionDao datosLiquidacionDao = new DatosLiquidacionDao();
            InfracionComparendoCompDao infraccionComparendoDao = new InfracionComparendoCompDao();
            PagosCompDao pagosDao = new PagosCompDao();
            //objetos
            Reciboscomparendo recibo = null;
            DatosLiquidacion datosLiquidacion = null;
            InfracionComparendoComp infraccionComparendo = null;
            PagosComp pago = null;
            //listas
            List objs;
            List objsInfraccionComparendo;
            
            if (idLiquidacion >= 0) {
                //actualizar recibos
                recibo = new Reciboscomparendo();
                recibo.setIDLIQUIDACION(idLiquidacion);
                objs = recibosCompDao.searchMatching(conn, recibo);
                if (objs != null && objs.size() > 0) {
                    for (int i = 0; i < objs.size(); i++) {
                        recibo = (Reciboscomparendo)objs.get(i);
                        recibo.setESTADO(15);
                        //auditar edicion
                        Reciboscomparendo ant = new Reciboscomparendo();
                        ant.setID(recibo.getID());
                        recibosCompDao.load(conn, ant);
                        recibosCompDao.save(conn, recibo);
                        //auditar edicion
                        Auditoria myAuditoria = new Auditoria();
                        AuditoriaSystem myAuditSx = new AuditoriaSystem();
                        myAuditSx.setTABLAAFECTADA("RECIBOSCOMPARENDO");
                        myAuditSx.setCAMPOCLAVE("ID");
                        myAuditSx.setVLRCAMPOCLAVE(String.valueOf(recibo.getID()));
                        myAuditSx.setID_USUARIO(idUsuario);
                        myAuditSx.setIP(myIp);
                        myAuditSx.setNOMBREEQUIPO(myHost);
                        myAuditoria.auditarEdicion(conn, myAuditSx, ant, recibo, myIp, myHost, 0);

                    }
                }
                else res = 1;
                //actualizar pagos
                pago = new PagosComp();
                pago.setIDLIQUIDACION(idLiquidacion);
                objs = pagosDao.searchMatching(conn, pago);
                if (objs != null && objs.size() > 0) {
                    for (int i = 0; i < objs.size(); i++) {
                        pago = (PagosComp)objs.get(i);
                        pago.setESTADO(15);
                        //auditar edicion
                        PagosComp ant = new PagosComp();
                        ant.setID(pago.getID());
                        pagosDao.load(conn, ant);
                        pagosDao.save(conn, pago);
                        //auditar edicion
                        Auditoria myAuditoria = new Auditoria();
                        AuditoriaSystem myAuditSx = new AuditoriaSystem();
                        myAuditSx.setTABLAAFECTADA("PAGOSCOMPARENDO");
                        myAuditSx.setCAMPOCLAVE("ID");
                        myAuditSx.setVLRCAMPOCLAVE(String.valueOf(pago.getID()));
                        myAuditSx.setID_USUARIO(idUsuario);
                        myAuditSx.setIP(myIp);
                        myAuditSx.setNOMBREEQUIPO(myHost);
                        myAuditoria.auditarEdicion(conn, myAuditSx, ant, pago, myIp, myHost, 0);

                    }
                }
                else res = 2;
                //infracciones
                //buscamos datos de liquidacion
                datosLiquidacion = new DatosLiquidacion();
                datosLiquidacion.setIDLIQUIDACION(idLiquidacion + "");
                objs = datosLiquidacionDao.searchMatching(conn, datosLiquidacion);
                if (objs != null && objs.size() > 0) {
                    //para cada dato liquidacion
                    for (int i = 0; i < objs.size(); i++) {
                        datosLiquidacion = (DatosLiquidacion)objs.get(i);
                        if (Funciones.esEntero(datosLiquidacion.getIDLIQUIDACION())) {
                            //buscamos infraccion comparendo
                            infraccionComparendo = new InfracionComparendoComp();
                            infraccionComparendo.setID(Integer.parseInt(datosLiquidacion.getIDINFRACCION()));
                            objsInfraccionComparendo =
                                    infraccionComparendoDao.searchMatching(conn, infraccionComparendo);
                            if (objsInfraccionComparendo != null && objsInfraccionComparendo.size() > 0) {
                                //para cada infraccion comparendo
                                for (int j = 0; j < objsInfraccionComparendo.size(); j++) {
                                    //actualizamos el estado
                                    infraccionComparendo = (InfracionComparendoComp)objsInfraccionComparendo.get(j);
                                    infraccionComparendo.setIDESTADO(10);
                                    //auditar edicion
                                    InfracionComparendoComp ant = new InfracionComparendoComp();
                                    ant.setID(infraccionComparendo.getID());
                                    infraccionComparendoDao.load(conn, ant);
                                    infraccionComparendoDao.save(conn, infraccionComparendo);
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

                                }
                            }
                            else res = 23;
                        }
                        else res = 22;
                    }
                }
                else res = 21;
            }
            else res = 20;
        } catch (Exception e) {
            e.printStackTrace();
            res = 100;
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }
    
    public LiquidacionComp insertarLiquidacionComp(LiquidacionComp myLiquidacion, int idUsuario, String myIp, String myHost) {
        int id;
        List lista;
        try {
            conn = conexion.conectarComparendos();
            LiquidacionCompDao myLiquidacionDao = new LiquidacionCompDao();
            myMotor = myMotor.toUpperCase();
            id = Funciones.obtenerId(conn, "GEN_IDLIQUIDACION", "GEN_IDLIQUIDACION", myMotor);
            myLiquidacion.setIDLIQUIDACION(id);
            myLiquidacionDao.create(conn, myLiquidacion);
            myLiquidacion = new LiquidacionComp();
            myLiquidacion.setIDLIQUIDACION(id);
            lista = myLiquidacionDao.searchMatching(conn, myLiquidacion);
            if (lista != null && lista.size() > 0) {
                myLiquidacion = (LiquidacionComp)lista.get(0);
            }
            //auditar insert
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("LIQUIDACION");
            myAuditSx.setCAMPOCLAVE("IDLIQUIDACION");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(myLiquidacion.getIDLIQUIDACION()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, myLiquidacion, 0);

        } catch (Exception e) {
            e.printStackTrace();
            myLiquidacion.setIDLIQUIDACION(-1);
        } finally {
            conexion.cerrarCx();
        }
        return myLiquidacion;
    }
}
