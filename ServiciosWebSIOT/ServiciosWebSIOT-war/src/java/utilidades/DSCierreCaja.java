package utilidades;

import java.io.ByteArrayInputStream;

import java.util.ArrayList;
import java.util.HashMap;

import modelo.datos.objetos.generales.Transito;
import modelo.datos.objetos.generales.Usuarios;
import modelo.datos.objetos.liquidacion.caja.CierreCaja;

import modelo.logica.liquidacion.ResumenCierreCaja;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;


public class DSCierreCaja implements JRDataSource {    
    private int indice = -1;
    private int cantidad = 0;
    private String tipoArqueo = "local";
    private Transito transito;
    private CierreCaja cierreCaja;
    private Usuarios usuarioArquea;
    private ArrayList listaResumenCierreCaja;
    
    private Double totalBase;
    private Double totalFactura;
    private Double totalPago;
    private Double totalDesface;
    private Double totalBalance;
    
    public DSCierreCaja() {
        super();
    }

    @Override
    public boolean next() throws JRException {
        indice++;
        return indice < getCantidad();
    }

    @Override
    public Object getFieldValue(JRField jRField) throws JRException {
        ResumenCierreCaja resumenCierreCaja;
        resumenCierreCaja = (ResumenCierreCaja)getListaResumenCierreCaja().get(indice);
        
        if (jRField.getName().equals("REGISTRO_NUMERO")) {
            return indice + 1;
        } else if (jRField.getName().equals("CAJERO_NOMBRE")) {
            return resumenCierreCaja.getCajero_nombre();
        } else if (jRField.getName().equals("CAJERO_DOCUMENTO")) {
            return resumenCierreCaja.getCajero_documento();
        } else if (jRField.getName().equals("BASE_VALOR")) {
            return resumenCierreCaja.getBase_valor();
        } else if (jRField.getName().equals("FACTURA_VALOR")) {
            return resumenCierreCaja.getFactura_valor();
        } else if (jRField.getName().equals("PAGO_VALOR")) {
            return resumenCierreCaja.getPago_valor();
        } else if (jRField.getName().equals("DESFACE_VALOR")) {
            return resumenCierreCaja.getDesface_valor();
        } else if (jRField.getName().equals("BALANCE_VALOR")) {
            return resumenCierreCaja.getBalance_valor();
        }
        return "INDEFINIDO";
    }
    
    public HashMap getParametros() {
        HashMap parametros = new HashMap();
        parametros.put("ARQUEOLOGIN", getUsuarioArquea().getLOGIN());
        parametros.put("ARQUEODOCUMENTO", getUsuarioArquea().getDOCUMENTO());
        parametros.put("ARQUEONOMBRE", getUsuarioArquea().getNOMBRE());
        parametros.put("CIERRE_FECHA", Funciones.fechaToTimestamp2(getCierreCaja().getFECHACIERRE() + " " + getCierreCaja().getHORACIERRE()));
        parametros.put("CIERRE_FECHAINICIO", Funciones.fechaToTimestamp2(getCierreCaja().getFECHAINICIERRE()));
        parametros.put("CIERRE_FECHAFIN", Funciones.fechaToTimestamp2(getCierreCaja().getFECHAFINCIERRE()));
        parametros.put("TRANSITO_NOMBRE", getTransito().getNOMBREALCALDIA());
        parametros.put("TRANSITO_DESCRIPCION", getTransito().getDESCRIPCION());
        parametros.put("TRANSITO_LOGO", new ByteArrayInputStream(getTransito().getLOGO()));
        parametros.put("REGISTRO_CANTIDAD", getCantidad());
        calcularTotales();
        parametros.put("REGISTRO_TOTALBASE", totalBase);
        parametros.put("REGISTRO_TOTALFACTURA", totalFactura);
        parametros.put("REGISTRO_TOTALPAGO", totalPago);
        parametros.put("REGISTRO_TOTALDESFACE", totalDesface);
        parametros.put("REGISTRO_TOTALBALANCE", totalBalance);
        return parametros;
    }

    private void calcularTotales() {
        totalBase = 0.0;
        totalFactura = 0.0;
        totalPago = 0.0;
        totalDesface = 0.0;
        totalBalance = 0.0;
        ResumenCierreCaja obj;
        for (int i = 0; i < getListaResumenCierreCaja().size(); i++) {
            obj = (ResumenCierreCaja)getListaResumenCierreCaja().get(i);
            totalBase += obj.getBase_valor();
            totalFactura += obj.getFactura_valor();
            totalPago += obj.getPago_valor();
            totalDesface += obj.getDesface_valor();
            totalBalance += obj.getBalance_valor();
        }
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipoArqueo() {
        return tipoArqueo;
    }

    public void setTipoArqueo(String tipoArqueo) {
        this.tipoArqueo = tipoArqueo;
    }

    public Transito getTransito() {
        return transito;
    }

    public void setTransito(Transito transito) {
        this.transito = transito;
    }

    public CierreCaja getCierreCaja() {
        return cierreCaja;
    }

    public void setCierreCaja(CierreCaja cierreCaja) {
        this.cierreCaja = cierreCaja;
    }

    public Usuarios getUsuarioArquea() {
        return usuarioArquea;
    }

    public void setUsuarioArquea(Usuarios usuarioArquea) {
        this.usuarioArquea = usuarioArquea;
    }

    public ArrayList getListaResumenCierreCaja() {
        return listaResumenCierreCaja;
    }

    public void setListaResumenCierreCaja(ArrayList listaResumenCierreCaja) {
        this.listaResumenCierreCaja = listaResumenCierreCaja;
    }
}
