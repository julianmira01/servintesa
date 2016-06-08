package utilidades;

import java.io.ByteArrayInputStream;

import java.util.ArrayList;
import java.util.HashMap;

import modelo.datos.objetos.comparendos.accesorias.EmpresaComp;
import modelo.datos.objetos.comparendos.generales.InfractorComp;
import modelo.datos.objetos.comparendos.liquidacion.AcuerdosPagoComp;
import modelo.datos.objetos.comparendos.liquidacion.PagosComp;
import modelo.datos.objetos.comparendos.liquidador.Reciboscomparendo;

import modelo.datos.objetos.generales.Transito;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;


public class DSAcuerdoPago implements JRDataSource {
    
    private int indice = -1;
    private int cantidad = 0;
    private Transito transito;
    private Reciboscomparendo recibosComparendo;
    private AcuerdosPagoComp acuerdosPago;
    private InfractorComp infractor;
    private EmpresaComp empresa;
    
    //variables de recibo //pueden ser nulas
    private PagosComp pago;
    private String codigoBarras;
    
    private DSAcuerdoDet dsAcuerdo;
    private DSAcuerdoDetLiquidacion dsLiquidacion;
    
    public DSAcuerdoPago() {
        super();
    }

    @Override
    public boolean next() throws JRException {
        return false;
    }

    @Override
    public Object getFieldValue(JRField jRField) throws JRException {
        return null;
    }
    
    public HashMap getParametros() {
        HashMap parametros = new HashMap();
        parametros.put("TRANSITO_NOMBRE", transito.getNOMBREALCALDIA());
        parametros.put("TRANSITO_DESCRIPCION", transito.getDESCRIPCION());
        parametros.put("TRANSITO_TELEFONO", transito.getTELEFONOS());
        parametros.put("TRANSITO_FAX", transito.getFAX1());
        parametros.put("TRANSITO_NIT", transito.getNIT());
        parametros.put("TRANSITO_DIRECCION", transito.getDIRECCION());
        parametros.put("RECIBO_NUMERO", recibosComparendo.getNUMERO_RECIBO());
        parametros.put("ACUERDO_NUMERO", acuerdosPago.getNUMERO());
        parametros.put("RECIBO_FECHA", Funciones.fechaToTimestamp1(acuerdosPago.getFECHA()));
        parametros.put("RECIBO_TOTALPAGO", dsAcuerdo.getValorTotal());
        parametros.put("INFRACTOR_IDENTIFICACION", infractor == null ? empresa == null ? null : 
                       empresa.getNIT() : infractor.getNROIDENTIFICACION());
        parametros.put("INFRACTOR_NOMBRE", infractor == null ? empresa == null ? null : 
                       empresa.getRAZONSOCIAL() : infractor.getNOMBRES() + " " + infractor.getAPELLIDOS());
        if(transito.getLOGO()!=null)
          parametros.put("TRANSITO_LOGO", new ByteArrayInputStream(transito.getLOGO()));// PROBLEMA: el logo viene null, SOLUCION: validar transito.getLOGO()!=null
        parametros.put("DSLIQUIDACION", dsLiquidacion);
        parametros.put("DSACUERDO", dsAcuerdo);
        parametros.put("CUOTAS_CANTIDAD", dsAcuerdo.getCantidad());
        parametros.put("COUTAS_FECHAULTIMOPAGO", dsAcuerdo.getFechaUltimoPago());
        parametros.put("ACUERDO_CONCEPTO", acuerdosPago.getCONCEPTO());
        
        parametros.put("ACUERDO_JUSTIFICACION", acuerdosPago.getDESCRIPCION());
        if (pago != null) {
            parametros.put("ACUERDO_FECHAPAGO", Funciones.fechaToTimestamp1(pago.getFECHAPAGO()));
            parametros.put("ACUERDO_VALORPAGO", pago.getVALOR());
            parametros.put("CUOTA_NUMERO", pago.getNOCUOTA());
            parametros.put("CUOTA_PORCENTAJE", pago.getPORCENTAJE() / 100);
            ArrayList listaSaldosFuturos = dsAcuerdo.getListaSaldosFuturos();
            if (listaSaldosFuturos != null && listaSaldosFuturos.size() >= pago.getNOCUOTA()) {
                parametros.put("CUOTA_SALDOPROXIMO", listaSaldosFuturos.get(pago.getNOCUOTA() - 1));
            }
        }
        if (codigoBarras != null) {
            parametros.put("RECIBO_CODIGOBARRA", codigoBarras);
        }
        return parametros;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Transito getTransito() {
        return transito;
    }

    public void setTransito(Transito transito) {
        this.transito = transito;
    }

    public Reciboscomparendo getRecibosComparendo() {
        return recibosComparendo;
    }

    public void setRecibosComparendo(Reciboscomparendo recibosComparendo) {
        this.recibosComparendo = recibosComparendo;
    }

    public AcuerdosPagoComp getAcuerdosPago() {
        return acuerdosPago;
    }

    public void setAcuerdosPago(AcuerdosPagoComp acuerdosPago) {
        this.acuerdosPago = acuerdosPago;
    }

    public InfractorComp getInfractor() {
        return infractor;
    }

    public void setInfractor(InfractorComp infractor) {
        this.infractor = infractor;
    }

    public EmpresaComp getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaComp empresa) {
        this.empresa = empresa;
    }

    public DSAcuerdoDet getDsAcuerdo() {
        return dsAcuerdo;
    }

    public void setDsAcuerdo(DSAcuerdoDet dsAcuerdo) {
        this.dsAcuerdo = dsAcuerdo;
    }

    public DSAcuerdoDetLiquidacion getDsLiquidacion() {
        return dsLiquidacion;
    }

    public void setDsLiquidacion(DSAcuerdoDetLiquidacion dsLiquidacion) {
        this.dsLiquidacion = dsLiquidacion;
    }

    public PagosComp getPago() {
        return pago;
    }

    public void setPago(PagosComp pago) {
        this.pago = pago;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }
}

