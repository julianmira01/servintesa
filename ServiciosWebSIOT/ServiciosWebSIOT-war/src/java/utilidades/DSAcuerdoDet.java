package utilidades;

import java.sql.Timestamp;

import java.util.ArrayList;

import modelo.datos.objetos.comparendos.liquidacion.PagosComp;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;


public class DSAcuerdoDet implements JRDataSource {
    
    private int indice = -1;
    private int cantidad = 0;
    private ArrayList listaPagosComp;
    private ArrayList listaSaldosFuturos;
    private Double valorTotal;
    private Timestamp fechaUltimoPago;
    
    public DSAcuerdoDet() {
        super();
    }

    @Override
    public boolean next() throws JRException {
        indice++;
        return indice < cantidad;
    }

    @Override
    public Object getFieldValue(JRField jRField) throws JRException {
        PagosComp pagos = (PagosComp)listaPagosComp.get(indice);
        if (jRField.getName().equals("ACUERDO_NUMEROCUOTA"))
            return pagos.getNOCUOTA();
        else if (jRField.getName().equals("ACUERDO_PORCENTAJE"))
            return pagos.getPORCENTAJE() / 100;
        else if (jRField.getName().equals("ACUERDO_VALOR"))
            return pagos.getVALOR();
        else if (jRField.getName().equals("ACUERDO_SALDOFUTURO"))
            return listaSaldosFuturos.get(indice);
        else if (jRField.getName().equals("ACUERDO_FECHAPAGO")) {
            Timestamp fecha = Funciones.fechaToTimestamp3(pagos.getFECHAPAGO());
            if (fecha == null) fecha = Funciones.fechaToTimestamp1(pagos.getFECHAPAGO());
            return fecha;
        }
        return null;
    }

    private void setValorTotal() {
        PagosComp pago = new PagosComp();
        valorTotal = 0.0;
        if (listaPagosComp != null && listaPagosComp.size() > 0) {
            for (int i = 0; i < listaPagosComp.size(); i++) {
                pago = (PagosComp)listaPagosComp.get(i);
                valorTotal += pago.getVALOR();
            }
            fechaUltimoPago = Funciones.fechaToTimestamp3(pago.getFECHAPAGO());
            if (fechaUltimoPago == null) fechaUltimoPago = Funciones.fechaToTimestamp1(pago.getFECHAPAGO());
        }
        else fechaUltimoPago = null;
    }
    
    private void setListaSaldosFuturos() {
        PagosComp pago;
        listaSaldosFuturos = new ArrayList();
        float valor = 0;
        if (listaPagosComp != null && listaPagosComp.size() > 0) {
            for (int i = 0; i < listaPagosComp.size(); i++) {
                pago = (PagosComp)listaPagosComp.get(i);
                valor += pago.getVALOR();
                listaSaldosFuturos.add(valorTotal - valor);
            }
        }
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

    public ArrayList getListaPagosComp() {
        return listaPagosComp;
    }

    public void setListaPagosComp(ArrayList listaPagosComp) {
        this.listaPagosComp = listaPagosComp;
        setValorTotal();
        setListaSaldosFuturos();
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Timestamp getFechaUltimoPago() {
        return fechaUltimoPago;
    }

    public void setFechaUltimoPago(Timestamp fechaUltimoPago) {
        this.fechaUltimoPago = fechaUltimoPago;
    }

    public ArrayList getListaSaldosFuturos() {
        return listaSaldosFuturos;
    }
}
