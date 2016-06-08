package utilidades;

import java.util.HashMap;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import servicios.generales.ServiciosConfiguraciones;


public class GenerarReportesArqueo {
    public GenerarReportesArqueo() {
        super();
    }

    public static void main(String[] args) {
        GenerarReportesArqueo generarReportesArqueo = new GenerarReportesArqueo();
        DSArqueo dsArqueo = new DSArqueo();
        dsArqueo.setCantidad(10); 
        generarReportesArqueo.crearReporteArqueo(dsArqueo, dsArqueo.getParametros(), "reporte1");
    }

    public void crearReporteArqueo(JRDataSource recurso, HashMap parametros, String fileName) {
        try {
            ServiciosConfiguraciones serviciosConfiguraciones = new ServiciosConfiguraciones();
            
            //compilamos la plantilla
            JasperReport jasperReport = JasperCompileManager.compileReport(serviciosConfiguraciones.directorioFacturasPlantillas() + 
                                                  "ArqueoCaja.jrxml");
            //llenamos la plantilla
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, recurso);
            //exportamos el pdf
            JasperExportManager.exportReportToPdfFile(jasperPrint, serviciosConfiguraciones.directorioReportesArqueo() +
                                                   fileName + ".pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 

    public void crearReporteCierrecaja(JRDataSource recurso, HashMap parametros, String fileName) {
        try {
            ServiciosConfiguraciones serviciosConfiguraciones = new ServiciosConfiguraciones();
            
            //compilamos la plantilla
            JasperReport jasperReport = JasperCompileManager.compileReport(serviciosConfiguraciones.directorioFacturasPlantillas() + 
                                                  "CierreCaja.jrxml");
            //llenamos la plantilla
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, recurso);
            //exportamos el pdf
            JasperExportManager.exportReportToPdfFile(jasperPrint, serviciosConfiguraciones.directorioReportesArqueo() +
                                                   fileName + ".pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
