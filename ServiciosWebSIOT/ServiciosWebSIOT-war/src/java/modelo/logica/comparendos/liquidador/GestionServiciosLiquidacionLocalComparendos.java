package modelo.logica.comparendos.liquidador;


import java.sql.Connection;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.comparendos.liquidacion.PagosCompDao;
import modelo.datos.dao.comparendos.liquidacion.RecibocuotasDao;
import modelo.datos.dao.comparendos.liquidador.ConceptosTarifaDao;
import modelo.datos.dao.comparendos.liquidador.DatosLiquidacionDao;
import modelo.datos.dao.comparendos.liquidador.LiquidacionDao;
import modelo.datos.dao.comparendos.liquidador.ReciboscomparendoDao;
import modelo.datos.dao.comparendos.liquidador.TarifaDao;
import modelo.datos.dao.liquidador.SalarioDao;
import modelo.datos.objetos.comparendos.accesorias.InfraccionesComp;
import modelo.datos.objetos.comparendos.generales.ComparendoComp;
import modelo.datos.objetos.comparendos.generales.InfracionComparendoComp;
import modelo.datos.objetos.comparendos.generales.InfractorComp;
import modelo.datos.objetos.comparendos.generales.VehiculosComp;
import modelo.datos.objetos.comparendos.liquidacion.PagosComp;
import modelo.datos.objetos.comparendos.liquidacion.Recibocuotas;
import modelo.datos.objetos.comparendos.liquidador.ConceptosTarifa;
import modelo.datos.objetos.comparendos.liquidador.DatosAdicionalesFactura;
import modelo.datos.objetos.comparendos.liquidador.DatosLiquidacion;
import modelo.datos.objetos.comparendos.liquidador.Liquidacion;
import modelo.datos.objetos.comparendos.liquidador.Reciboscomparendo;
import modelo.datos.objetos.comparendos.liquidador.Tarifa;
import modelo.datos.objetos.generales.AuditoriaSystem;
import modelo.datos.objetos.generales.Header;
import modelo.datos.objetos.liquidador.DatosFactura;

import modelo.logica.comparendos.generales.GestionServiciosGeneralesComp;
import modelo.logica.facturacion.GestionServiciosFacturacion;

import servicios.comparendos.ServiciosAccesoriasComp;
import servicios.comparendos.ServiciosGeneralesComp;

import utilidades.Auditoria;
import utilidades.CompiladorComparendo;
import utilidades.Funciones;
import utilidades.GenerarReportes;


//import modelo.datos.objetos.generales.Header;


public class GestionServiciosLiquidacionLocalComparendos {

    Conexion conexion;
    Connection conn;
    TarifaDao tarifaDao;
    LiquidacionDao facturaDao;
    DatosLiquidacionDao facturaDetDao;
    ConceptosTarifaDao conceptosTarifaDao;
    SalarioDao salarioDao;
    ReciboscomparendoDao reciboscomparendoDao;
    PagosCompDao pagosDao;
    RecibocuotasDao reciboCuotasDao;
    CompiladorComparendo compilador;
    GenerarReportes generarReportes;
    ServiciosGeneralesComp serviciosComparendos;
    ServiciosAccesoriasComp serviciosAccesorias;
    String myMotor;


    public GestionServiciosLiquidacionLocalComparendos() {
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
        conceptosTarifaDao = new ConceptosTarifaDao();
        tarifaDao = new TarifaDao();
        salarioDao = new SalarioDao();
        facturaDao = new LiquidacionDao();
        facturaDetDao = new DatosLiquidacionDao();
        reciboscomparendoDao = new ReciboscomparendoDao();
        pagosDao = new PagosCompDao();
        reciboCuotasDao = new RecibocuotasDao();
        
        compilador = new CompiladorComparendo(null, getSalarios());
        generarReportes = new GenerarReportes();
        serviciosComparendos = new ServiciosGeneralesComp();
        serviciosAccesorias = new ServiciosAccesoriasComp();
    }

    public List getTarifas(Tarifa tarifa) {
        List lista = null;
        try {
            conn = conexion.conectarComparendos();
            if (tarifa != null && !tarifa.getLT_VIGENCIA().equals("")) {
                lista = (ArrayList)tarifaDao.searchMatching(conn, tarifa);
            } else {
                lista = (ArrayList)tarifaDao.loadAll(conn);
            }
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
            conn = conexion.conectarComparendos();
            lista = (ArrayList)salarioDao.loadAll(conn);
        } catch (Exception e) {

        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }


    public List getConceptosTarifa(ConceptosTarifa conceptoTarifa, InfractorComp persona, List comparendos) {
        ArrayList lista = new ArrayList();
        List conceptosTarifas = new ArrayList();
        ComparendoComp comparendo;
        VehiculosComp vehiculo;
        
        try
        {
          System.out.println("tamano lista " + comparendos.size());
          
          for (int i = 0; i < comparendos.size(); i++) {
              comparendo = (ComparendoComp)comparendos.get(i);
              InfracionComparendoComp infraccionComparendo = new InfracionComparendoComp();
  
              infraccionComparendo.setIDCOMPARENDO(comparendo.getID_COMPARENDO());
              infraccionComparendo = serviciosComparendos.getInfraccionComparendo(infraccionComparendo);
  
              if(infraccionComparendo!=null)
              {
                InfraccionesComp infraccion = new InfraccionesComp();
                infraccion.setID_INFRACCION(infraccionComparendo.getIDINFRACCION());
    
                infraccion = serviciosAccesorias.getInfraccionComp(infraccion);
                
                vehiculo = new VehiculosComp();
                vehiculo.setPLACA(comparendo.getPLACA());
                GestionServiciosGeneralesComp serviciosgenerales = new GestionServiciosGeneralesComp();
                vehiculo = serviciosgenerales.getFirstVehiculoComp(vehiculo);
    
                conceptosTarifas.addAll((Collection<ConceptosTarifa>)getConceptosTarifa(infraccionComparendo,
                    conceptoTarifa, comparendo, infraccion, conceptosTarifas, vehiculo));
                lista.add(conceptosTarifas);
              }
          }
            
          System.out.println("Resultado Final " + lista.size());
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conexion.cerrarCx();
        }
      return conceptosTarifas;
    }


    public List getConceptosTarifa(InfracionComparendoComp infraccionComparendo, ConceptosTarifa conceptoTarifa,
                                   ComparendoComp comparendo, InfraccionesComp infraccion, List conceptosTarifas,
                                   VehiculosComp vehiculo) {
        String valor = "";

        try {
            conn = conexion.conectarComparendos();
            conceptosTarifas = (ArrayList)conceptosTarifaDao.searchMatching(conn, conceptoTarifa);

            if (conceptosTarifas != null && conceptosTarifas.size() > 0) {
                for (int i = 0; i < conceptosTarifas.size(); i++) {
                    conceptoTarifa = (ConceptosTarifa)conceptosTarifas.get(i);
                    
                    if (conceptoTarifa.getLTD_TIPO() != null && !conceptoTarifa.getLTD_TIPO().equals("")) {
                        if (conceptoTarifa.getLTD_TIPO().equals("1")) {
                            //valor
                            valor = conceptoTarifa.getLTD_VALOR();
                        }
                        else if (conceptoTarifa.getLTD_TIPO().equals("2")) {
                            //dato base
                            valor =
                                compilador.compilar(conceptoTarifa.getLTD_DATO_BASE(), conceptoTarifa.getLT_VIGENCIA(), infraccionComparendo,
                                                    "", comparendo, infraccion, vehiculo);
                        }
                        else if (conceptoTarifa.getLTD_TIPO().equals("4")) {
                            //formula
                            valor =
                                compilador.compilar(conceptoTarifa.getLTD_CALCULO(), conceptoTarifa.getLT_VIGENCIA(), infraccionComparendo,
                                                    "", comparendo, infraccion, vehiculo);
                        }
                        else {
                            valor = "0";
                        }
                    }
                    else {
                        valor = "0";
                    }
                        
                    System.out.println(conceptoTarifa.getDESCRIPCION() + " " + conceptoTarifa.getLTD_CALCULO() + " " +
                                       valor);
                    conceptoTarifa.setLTD_VALOR(valor);
                    conceptoTarifa.setNUMEROCOMPARENDO(comparendo.getNUMEROCOMPARENDO());
                    conceptoTarifa.setFECHACOMPARENDO(comparendo.getFECHACOMPARENDO());
                    conceptoTarifa.setCODIGO(infraccion.getCOD_INFRACCION());
                    conceptoTarifa.setINFRACCION(infraccion.getDESCRIPCION());
                    conceptoTarifa.setID_INFRACCION(String.valueOf(infraccionComparendo.getID())); //new
                    conceptoTarifa.setESTADO(String.valueOf(infraccionComparendo.getIDESTADO()));
                    conceptosTarifas.remove(i);
                    conceptosTarifas.add(i, conceptoTarifa);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conexion.cerrarCx();
        }
        return conceptosTarifas;
    }


    public DatosFactura facturar(Header header, List listaConceptos, DatosAdicionalesFactura datosAdionalesFactura,
                                 InfractorComp infractor, int idUsuario, String myIp, String myHost, Liquidacion Certificado) {
        DatosFactura datosFactura = new DatosFactura();
        ConceptosTarifa conceptoTarifa;
        Liquidacion factura = new Liquidacion();
        DatosLiquidacion facturaDet = null;
        int idL_factura = 0;
        int idL_facturaDet = 0;
        int idRecibo = 0;
        int idPago = 0;
        int idReciboCuota = 0;
        
        try {
            
            //crear liquidacion
            //idL_factura = facturaDao.getMaxId(conn);            
            
            conn = conexion.conectarComparendos();
            myMotor = myMotor.toUpperCase();
            
            idL_factura = Funciones.obtenerId(conn, "GEN_IDLIQUIDACION", "GEN_IDLIQUIDACION", myMotor);
            
            String numeroFactura = getNumeroFactura(idL_factura);
            
            //factura.setFECHA(getFechaFactura());
            factura.setFECHA(Funciones.getFechaSistema(conn,myMotor));          
            
            factura.setIDLIQUIDACION(idL_factura);
            
            
            //factura.setFECHAREGISTRO(getFechaFactura());
            factura.setFECHAREGISTRO(Funciones.getFechaSistema(conn,myMotor));
            
            //factura.setHORAREGISTRO(getHoraFactura());
            factura.setHORAREGISTRO(Funciones.getHoraSistemaString(conn));
            
            factura.setTOTAL(datosAdionalesFactura.getTotal());
            factura.setSALDO(datosAdionalesFactura.getTotal());
            factura.setIDUSUARIO(header.getIdUsuario());
            factura.setESTADOLIQ("LIQUIDADO"); //("11");
            factura.setNROCOMP(Certificado.getNROCOMP());
            factura.setFECHA_CERTIFICADO(Certificado.getFECHA_CERTIFICADO());
            factura.setID_CENTRO(Certificado.getID_CENTRO());
            factura.setNUMERO_CERTIFICADO(Certificado.getNUMERO_CERTIFICADO());
            facturaDao.create(conn, factura);
            //auditar insert
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("LIQUIDACION");
            myAuditSx.setCAMPOCLAVE("IDLIQUIDACION");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(factura.getIDLIQUIDACION()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, factura, 0);

            //crear datos liquidacion de la lista de conceptos
            for (int i = 0; i < listaConceptos.size(); i++) {
                                              
              //idL_facturaDet = facturaDetDao.getMaxId(conn);
              idL_facturaDet = Funciones.obtenerId(conn, "GEN_ID_DATOSLIQUIDACION", "GEN_ID_DATOSLIQUIDACION", myMotor);

                
                conceptoTarifa = (ConceptosTarifa)listaConceptos.get(i);
                facturaDet = new DatosLiquidacion();
                facturaDet.setID(String.valueOf(idL_facturaDet));
                try{
                    facturaDet.setIDITEM(Integer.parseInt(conceptoTarifa.getID_ITEM()));
                }catch(Exception exce){}
                
                facturaDet.setIDLIQUIDACION(String.valueOf(idL_factura));
                
                try{
                    facturaDet.setVIGENCIA(conceptoTarifa.getLT_VIGENCIA());
                }catch(Exception exce){}
                try{
                    facturaDet.setIDINFRACCION(conceptoTarifa.getID_INFRACCION());
                }catch(Exception exce){}
                
                if (conceptoTarifa.getLTD_VALOR() != null && !conceptoTarifa.getLTD_VALOR().equals("")) {
                    facturaDet.setVALOR(conceptoTarifa.getLTD_VALOR());
                }
                try{
                    facturaDet.setL_TARIFASDET(conceptoTarifa.getLTD_ID());
                }catch(Exception exce){}
                
                facturaDetDao.create(conn, facturaDet);
                //auditar insert
                myAuditoria = new Auditoria();
                myAuditSx = new AuditoriaSystem();
                myAuditSx.setTABLAAFECTADA("DATOSLIQUIDACION");
                myAuditSx.setCAMPOCLAVE("IDITEM");
                myAuditSx.setVLRCAMPOCLAVE(String.valueOf(facturaDet.getIDITEM()));
                myAuditSx.setID_USUARIO(idUsuario);
                myAuditSx.setIP(myIp);
                myAuditSx.setNOMBREEQUIPO(myHost);
                myAuditoria.auditarInsersion(conn, myAuditSx, facturaDet, 0);

            }
            //crear el recibo
            Reciboscomparendo reciboscomparendo = new Reciboscomparendo();
            idRecibo = Funciones.obtenerId(conn, "GEN_ID_RECIBOSCOMPARENDO", "GEN_ID_RECIBOSCOMPARENDO", myMotor);
            reciboscomparendo.setID(idRecibo);
            reciboscomparendo.setESTADO(14);
            reciboscomparendo.setFECHACREACION(factura.getFECHA());
            reciboscomparendo.setFECHAREGISTRO(factura.getFECHAREGISTRO());
            reciboscomparendo.setHORAREGISTRO(factura.getHORAREGISTRO());
            reciboscomparendo.setIDINFRACTOR(infractor.getID_INFRACTOR());
            reciboscomparendo.setIDLIQUIDACION(factura.getIDLIQUIDACION());
            if (Funciones.esEntero(factura.getIDUSUARIO()))
                reciboscomparendo.setIDUSUARIO(Integer.parseInt(factura.getIDUSUARIO()));
            reciboscomparendo.setNUMERO_RECIBO(numeroFactura);
            if (Funciones.esDouble(factura.getTOTAL()))
                reciboscomparendo.setVALOR(Double.parseDouble(factura.getTOTAL()));
            reciboscomparendoDao.create(conn, reciboscomparendo);
            //auditar insert
            myAuditoria = new Auditoria();
            myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("RECIBOSCOMPARENDO");
            myAuditSx.setCAMPOCLAVE("ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(reciboscomparendo.getID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, reciboscomparendo, 0);

            //crear pagos comparendo
            PagosComp pago = new PagosComp();
            pago.setESTADO(14);
            pago.setFECHAPAGO(Funciones.getFechaSistema(conn,myMotor));
            idPago = Funciones.obtenerId(conn, "GEN_PAGOSCOMPARENDO", "GEN_PAGOSCOMPARENDO", myMotor);
            pago.setID(idPago);
            pago.setIDLIQUIDACION(idL_factura);
            pago.setNOCUOTA(1);
            pago.setPORCENTAJE(100);
            pago.setVALOR((float)reciboscomparendo.getVALOR());
            pagosDao.create(conn, pago);
            //auditar insert
            myAuditoria = new Auditoria();
            myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("PAGOSCOMPARENDO");
            myAuditSx.setCAMPOCLAVE("ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(pago.getID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, pago, 0);

            //crear recibo cuota
            Recibocuotas reciboCuotas = new Recibocuotas();
            reciboCuotas.setFECHAREGISTRO(Funciones.getFechaSistema(conn,myMotor));
            idReciboCuota = Funciones.obtenerId(conn, "GEN_ID_RECIBOCUOTAS", "GEN_ID_RECIBOCUOTAS", myMotor);
            reciboCuotas.setID(idReciboCuota);
            reciboCuotas.setIDCUOTA(pago.getID());
            reciboCuotas.setIDRECIBO(reciboscomparendo.getID());
            reciboCuotasDao.create(conn, reciboCuotas);
            //auditar insert
            myAuditoria = new Auditoria();
            myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("RECIBOCUOTAS");
            myAuditSx.setCAMPOCLAVE("ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(reciboCuotas.getID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, reciboCuotas, 0);

            //generamos el pdf
            String codigoBarras; // = "(415)7709998013711(8020)000010129389000011127135(3900)0001168375(96)20111207";
            GestionServiciosFacturacion gestionSFacturacion = new GestionServiciosFacturacion();
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
            String str_date = (String)formatter.format(date);
            
            //codigoBarras = gestionSFacturacion.generarCodigoBarras(infractor.getNROIDENTIFICACION().trim(), 
            //                                                       numeroFactura, factura.getTOTAL(), str_date);
            
            codigoBarras = gestionSFacturacion.generarCodigoBarras2(infractor.getNROIDENTIFICACION().trim(), 
                                                                    numeroFactura, factura.getTOTAL(), str_date);
            
            codigoBarras = codigoBarras.replace("(","").replace(")","");            
            System.out.println("C-*-digo de barras neto: " + codigoBarras);
            
            String formaPago = header.getParametros().get(0).toString();
            
            generarReportes.generarReporte(listaConceptos, numeroFactura, infractor, factura.getTOTAL(),
                                           factura.getTOTAL(), formaPago, factura.getTOTAL(), codigoBarras);

            datosFactura.setNumeroFacturaLocal(numeroFactura);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return datosFactura;
    }

    public DatosFactura facturarParaCuota(Header header, List listaConceptos, DatosAdicionalesFactura datosAdionalesFactura,
                                 InfractorComp infractor, int idUsuario, String myIp, String myHost) {
        DatosFactura datosFactura = new DatosFactura();
        ConceptosTarifa conceptoTarifa;
        Liquidacion factura = new Liquidacion();
        DatosLiquidacion facturaDet = null;
        int idL_factura = 0;
        int idL_facturaDet = 0;
        
        try {
            conn = conexion.conectarComparendos();
            //crear liquidacion
            //idL_factura = facturaDao.getMaxId(conn);
                        
            myMotor = myMotor.toUpperCase();            
            idL_factura = Funciones.obtenerId(conn, "GEN_IDLIQUIDACION", "GEN_IDLIQUIDACION", myMotor);
            
            String numeroFactura = getNumeroFactura(idL_factura);
            
          //factura.setFECHA(getFechaFactura());
          factura.setFECHA(Funciones.getFechaSistema(conn,myMotor));    
            
            factura.setIDLIQUIDACION(idL_factura);
            
            //factura.setFECHAREGISTRO(getFechaFactura());          
          factura.setFECHAREGISTRO(Funciones.getFechaSistema(conn,myMotor));
            
            //factura.setHORAREGISTRO(getHoraFactura());            
            factura.setHORAREGISTRO(Funciones.getHoraSistemaString(conn));
            
            factura.setTOTAL(datosAdionalesFactura.getTotal());
            factura.setSALDO(datosAdionalesFactura.getTotal());
            factura.setIDUSUARIO(header.getIdUsuario());
            factura.setESTADOLIQ("LIQUIDADO"); //("11");
            
            facturaDao.create(conn, factura);
            //auditar insert
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("LIQUIDACION");
            myAuditSx.setCAMPOCLAVE("IDLIQUIDACION");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(factura.getIDLIQUIDACION()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, factura, 0);

            //crear datos liquidacion de la lista de conceptos
            for (int i = 0; i < listaConceptos.size(); i++) {
                
                //idL_facturaDet = facturaDetDao.getMaxId(conn);
                idL_facturaDet = Funciones.obtenerId(conn, "GEN_ID_DATOSLIQUIDACION", "GEN_ID_DATOSLIQUIDACION", myMotor);
                
                conceptoTarifa = (ConceptosTarifa)listaConceptos.get(i);
                facturaDet = new DatosLiquidacion();
                facturaDet.setID(String.valueOf(idL_facturaDet));
                facturaDet.setIDITEM(Integer.parseInt(conceptoTarifa.getID_ITEM()));
                facturaDet.setIDLIQUIDACION(String.valueOf(idL_factura));
                facturaDet.setVIGENCIA(conceptoTarifa.getLT_VIGENCIA());
                facturaDet.setIDINFRACCION(conceptoTarifa.getID_INFRACCION());
                if (conceptoTarifa.getLTD_VALOR() != null && !conceptoTarifa.getLTD_VALOR().equals("")) {
                    facturaDet.setVALOR(conceptoTarifa.getLTD_VALOR());
                }
                facturaDet.setL_TARIFASDET(conceptoTarifa.getLTD_ID());
                facturaDetDao.create(conn, facturaDet);
                //auditar insert
                myAuditoria = new Auditoria();
                myAuditSx = new AuditoriaSystem();
                myAuditSx.setTABLAAFECTADA("DATOSLIQUIDACION");
                myAuditSx.setCAMPOCLAVE("IDITEM");
                myAuditSx.setVLRCAMPOCLAVE(String.valueOf(facturaDet.getIDITEM()));
                myAuditSx.setID_USUARIO(idUsuario);
                myAuditSx.setIP(myIp);
                myAuditSx.setNOMBREEQUIPO(myHost);
                myAuditoria.auditarInsersion(conn, myAuditSx, facturaDet, 0);

            }
            datosFactura.setNumeroFacturaLocal(numeroFactura);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return datosFactura;
    }


    public int crearL_FACTURAS(Liquidacion factura) {
        List lista = null;
        int id = 0;
        try {
            conn = conexion.conectarComparendos();
            facturaDao.create(conn, factura);

        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return id;
    }


    public int crearL_FACTURAS_DET(DatosLiquidacion facturaDet) {
        int id = 0;
        try {
            conn = conexion.conectarComparendos();
            facturaDetDao.create(conn, facturaDet);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return id;
    }    

    public List getDatosLiquidacion(DatosLiquidacion obj) {
        ArrayList lista = null;
        try {
            conn = conexion.conectarComparendos();
            DatosLiquidacionDao dao = new DatosLiquidacionDao();
            lista = (ArrayList)dao.searchMatching(conn, obj);
        } catch (Exception e) {
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public String getNumeroFactura(int idL_factura) {

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");
        String str_date = (String)formatter.format(date);
        String numero = ""+idL_factura;
        return numero;
    }

    public String getFechaHoraFactura() {

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String str_date = (String)formatter.format(date);
        System.out.println(str_date);
        return str_date;
    }

    /* public String getFechaFactura() {

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String str_date = (String)formatter.format(date);
        //System.out.println(str_date);
        return str_date;
        //return Funciones.getFechaSistema(null);
    }

    public String getHoraFactura() {

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");
        String str_date = (String)formatter.format(date);
        System.out.println(str_date);
        return str_date;
    } */


}

