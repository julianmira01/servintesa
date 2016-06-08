package utilidades;

import java.sql.Timestamp;

import java.util.ArrayList;

import modelo.datos.objetos.comparendos.liquidador.ConceptosTarifa;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;


public class DSAcuerdoDetLiquidacion implements JRDataSource {
    
    private int indice = -1;
    private int cantidad = 0;
    private ArrayList listaConceptosTarifa;
    private double valorTotalCuotas;
    private double valorTotalInfracciones;
    
    public DSAcuerdoDetLiquidacion() {
        super();
    }

    @Override
    public boolean next() throws JRException {
        indice++;
        return indice < cantidad;
    }

    @Override
    public Object getFieldValue(JRField jRField) throws JRException {
        ConceptosTarifa conceptosTarifa = (ConceptosTarifa)listaConceptosTarifa.get(indice);
        if (jRField.getName().equals("LIQUIDACION_CONCEPTO"))
            return conceptosTarifa.getDESCRIPCION();
        else if (jRField.getName().equals("LIQUIDACION_NUMEROCOMP"))
            return conceptosTarifa.getNUMEROCOMPARENDO();
        else if (jRField.getName().equals("LIQUIDACION_FECHACOMP")) {
            Timestamp fecha = Funciones.fechaToTimestamp3(conceptosTarifa.getFECHACOMPARENDO());
            if (fecha == null) fecha = Funciones.fechaToTimestamp1(conceptosTarifa.getFECHACOMPARENDO());
            return fecha;
        }
        else if (jRField.getName().equals("LIQUIDACION_VIGENCIA"))
            return conceptosTarifa.getLT_VIGENCIA();
        else if (jRField.getName().equals("LIQUIDACION_VALOR")) {
            if (conceptosTarifa.getLTD_VALOR().equals("INTERES")) {
                calcularTotales();
                return valorTotalCuotas - valorTotalInfracciones;
            }
            else if (conceptosTarifa.getLTD_VALOR().equals("TOTAL")) {
                calcularTotales();
                return valorTotalCuotas;
            }
            else if (Funciones.esDouble(conceptosTarifa.getLTD_VALOR()))
                return Double.parseDouble(conceptosTarifa.getLTD_VALOR());
        }
        return null;
    }

    private void calcularTotales() {
        valorTotalInfracciones = 0;
        ConceptosTarifa conceptosTarifa;
        for (int i = 0; i < listaConceptosTarifa.size(); i++) {
            conceptosTarifa = (ConceptosTarifa)listaConceptosTarifa.get(i);
            if (Funciones.esDouble(conceptosTarifa.getLTD_VALOR()))
                valorTotalInfracciones += Double.parseDouble(conceptosTarifa.getLTD_VALOR());
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

    public ArrayList getListaConceptosTarifa() {
        return listaConceptosTarifa;
    }

    public void setListaConceptosTarifa(ArrayList listaConceptosTarifa) {
        this.listaConceptosTarifa = listaConceptosTarifa;
    }

    public double getValorTotalCuotas() {
        return valorTotalCuotas;
    }

    public void setValorTotalCuotas(double valorTotalCuotas) {
        this.valorTotalCuotas = valorTotalCuotas;
    }
}
