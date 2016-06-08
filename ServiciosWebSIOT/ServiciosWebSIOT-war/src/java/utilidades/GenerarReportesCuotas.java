package utilidades;

import java.util.HashMap;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import servicios.generales.ServiciosConfiguraciones;


public class GenerarReportesCuotas {
    public GenerarReportesCuotas() {
        super();
    }

    public static void main(String[] args) {
        GenerarReportesCuotas generarReportesCuotas = new GenerarReportesCuotas();
        DSAcuerdoPago ds = new DSAcuerdoPago();
        ds.setCantidad(0);
        DSAcuerdoPago dsa = new DSAcuerdoPago();
        dsa.setCantidad(5);
        DSAcuerdoPago dsb = new DSAcuerdoPago();
        dsb.setCantidad(5);
        HashMap parametros = new HashMap();
        parametros.put("TRANSITO_NOMBRE", "ALCALDIA DE POPAYAN");
        parametros.put("DSLIQUIDACION", dsa);
        parametros.put("DSACUERDO", dsb);
        generarReportesCuotas.crearReporteAcuerdoPagoComp(new JREmptyDataSource(), parametros, "couta1");
    }

    public void crearReporteAcuerdoPagoComp(JRDataSource recurso, HashMap parametros, String fileName) {
        try {
            ServiciosConfiguraciones serviciosConfiguraciones = new ServiciosConfiguraciones();
            
            //compilamos la plantilla
            JasperReport jasperReport = JasperCompileManager.compileReport(serviciosConfiguraciones.directorioFacturasPlantillas() + 
                                                  "acuerdoPagoComparendos.jrxml");
            //llenamos la plantilla
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, recurso);
            //exportamos el pdf
            JasperExportManager.exportReportToPdfFile(jasperPrint, serviciosConfiguraciones.directorioFacturasComparendo() +
                                                   fileName + ".pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void crearReporteReciboAcuerdoPagoComp(JRDataSource recurso, HashMap parametros, String fileName) {
        try {
            ServiciosConfiguraciones serviciosConfiguraciones = new ServiciosConfiguraciones();
            
            //compilamos la plantilla
            JasperReport jasperReport = JasperCompileManager.compileReport(serviciosConfiguraciones.directorioFacturasPlantillas() + 
                                                  "reciboAcuerdoPagoComparendos.jrxml");
            //llenamos la plantilla
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, recurso);
            //exportamos el pdf
            JasperExportManager.exportReportToPdfFile(jasperPrint, serviciosConfiguraciones.directorioFacturasComparendo() +
                                                   fileName + ".pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
