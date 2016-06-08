package facturaVehiculo.objetos;


import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;


public class FacturaDetalleDs implements JRDataSource {
    int indice = -1;
    List listaConceptos;
    String tipoLiquidacion;
    
    public FacturaDetalleDs(List listaConceptos, String tipoLiquidacion) {
        super();
        this.listaConceptos = listaConceptos;
        this.tipoLiquidacion = tipoLiquidacion;
    }

    @Override
    public boolean next() throws JRException {
        indice++;
        if (indice < listaConceptos.size())
            return true;
        return false;
    }

    @Override
    public Object getFieldValue(JRField jRField) throws JRException {
        if (tipoLiquidacion.equals("T"))
            return asignarDatos(jRField);
        else return asignarDatosComp(jRField);
        
        
    }

    public List getListaConceptos() {
        return listaConceptos;
    }

    public void setListaConceptos(List listaConceptos) {
        this.listaConceptos = listaConceptos;
    }

    private Object asignarDatos(JRField jrField) {
        modelo.datos.objetos.liquidador.ConceptosTarifa concepto =
            (modelo.datos.objetos.liquidador.ConceptosTarifa)listaConceptos.get(indice);
        Object res = null;
        if (jrField.getName().equals("LCC_NOMBRE")) {
            res = concepto.getLCC_NOMBRE();
        }
        else if (jrField.getName().equals("LT_NOMBRE")) {
            res = concepto.getLT_NOMBRE();
        }
        else if (jrField.getName().equals("LT_VIGENCIA")) {
            res = concepto.getLT_VIGENCIA();
        }
        else if (jrField.getName().equals("LTD_VALOR")) {
            res = concepto.getLTD_VALOR();
        }
        return res;
    }

    private Object asignarDatosComp(JRField jrField) {
        modelo.datos.objetos.comparendos.liquidador.ConceptosTarifa concepto =
            (modelo.datos.objetos.comparendos.liquidador.ConceptosTarifa)listaConceptos.get(indice);
        Object res = null;
        if (jrField.getName().equals("LCC_NOMBRE")) {
            res = concepto.getDESCRIPCION();
        }
        else if (jrField.getName().equals("NUMEROCOMPARENDO")) {
            res = concepto.getNUMEROCOMPARENDO();
        }
        else if (jrField.getName().equals("FECHACOMPARENDO")) {
            res = concepto.getFECHACOMPARENDO();
        }
        else if (jrField.getName().equals("LT_VIGENCIA")) {
            res = concepto.getLT_VIGENCIA();
        }
        else if (jrField.getName().equals("LTD_VALOR")) {
            res = concepto.getLTD_VALOR();
        }
        return res;
    }
}
