package utilidades;

import facturaVehiculo.objetos.FacturaDataSource;

import java.util.List;
import java.util.Map;

import modelo.datos.objetos.comparendos.generales.InfractorComp;
import modelo.datos.objetos.generales.ViewPropietario;
import modelo.datos.objetos.generales.vehiculo.Vehiculo;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import servicios.generales.ServiciosConfiguraciones;


public class GenerarReportes {

    FacturaDataSource facturaDataSource;
    String numeroFactura;
    Vehiculo vehiculo;
    ViewPropietario propietario;
    String total = "";
    String saldo = "";
    String cuotas = "";
    String totalPagar = "";
    String codigoBarras = "";
    InfractorComp infractor;

    public GenerarReportes() {
        super();
    }

    public void generarReporte(List tarifas, String numero, Vehiculo vehi, ViewPropietario pro, String tot, String sal,
                               String cuot, String totalP, String codigoBarras, String avaluo) throws Exception {
        numeroFactura = numero;
        vehiculo = vehi;
        propietario = pro;
        total = tot;
        saldo = sal;
        cuotas = cuot;
        totalPagar = totalP;
        this.codigoBarras = codigoBarras;

        crearDataSource(tarifas, avaluo);
        crearReporte(facturaDataSource, facturaDataSource.getParametros());
    }

    public void generarReporte(List tarifas, String numero, InfractorComp infractor, String tot, String sal,
                               String cuot, String totalP, String codigoBarras) {
        numeroFactura = numero;

        total = tot;
        saldo = sal;
        cuotas = cuot;
        totalPagar = totalP;
        this.codigoBarras = codigoBarras;
        this.infractor = infractor;
        crearDataSourceComparendos(tarifas);
        crearReporteComparendos(cuot, facturaDataSource, facturaDataSource.getParametros());
    }

    public void crearDataSource(List tarifas, String avaluo) throws Exception {
        facturaDataSource =  new FacturaDataSource(tarifas, numeroFactura, vehiculo, propietario, total, saldo, cuotas, totalPagar, codigoBarras, avaluo);

    }

    public void crearDataSourceComparendos(List tarifas) {
        facturaDataSource = new FacturaDataSource(tarifas, numeroFactura, infractor, total, saldo, cuotas, totalPagar, codigoBarras);

    }

    public void crearReporte(JRDataSource recurso, Map<String, Object> parametros) {
        try {
            ServiciosConfiguraciones serviciosConfiguraciones = new ServiciosConfiguraciones();
            
            String esCompuesta = "";
            String separador = "";
            try{
                esCompuesta = Funciones.leer_ini("/WSTransito.ini", "USAR_FACTURA_COMPUESTA");
                separador = "/";
            }catch(Exception exce){}
            
            if(esCompuesta == null || esCompuesta.equals(""))
            {
                esCompuesta = Funciones.leer_ini("C:\\WSTransito.ini", "USAR_FACTURA_COMPUESTA");
                separador = "\\";
            }
            String plantilla = serviciosConfiguraciones.directorioFacturasPlantillas();
            String documento = serviciosConfiguraciones.directorioFacturasTransito();
            
            if(!documento.endsWith("\\") && !documento.endsWith("\\"))
                documento += separador + numeroFactura + ".pdf";
            else
                documento += numeroFactura + ".pdf";
            
            if(!plantilla.endsWith("\\") && !plantilla.endsWith("/"))
                plantilla += separador;

    
            if (esCompuesta.toUpperCase().equals("SI")) 
                plantilla += "reciboPagoBarra_compuesta.jrxml";
            else plantilla += "reciboPagoBarra.jrxml";
            
           // System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX Documento = " + documento + "   XXXXXXXXXXXX Plantilla = " + plantilla);
            //compilamos la plantilla
            JasperReport jasperReport = JasperCompileManager.compileReport(plantilla);
            //llenamos la plantilla
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, recurso);
            //exportamos el pdf
            JasperExportManager.exportReportToPdfFile(jasperPrint, documento);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void crearReporteComparendos(String numCuotas ,JRDataSource recurso, Map<String, Object> parametros) {
        try {
            ServiciosConfiguraciones serviciosConfiguraciones = new ServiciosConfiguraciones();
            
             String esCompuesta = "";
            try{
                esCompuesta = Funciones.leer_ini("/WSTransito.ini", "USAR_FACTURA_COMPUESTA");
            }catch(Exception exce){}
            
            if(esCompuesta.equals(""))
                esCompuesta = Funciones.leer_ini("C:\\WSTransito.ini", "USAR_FACTURA_COMPUESTA");
            
            String plantilla = serviciosConfiguraciones.directorioFacturasPlantillas();
            String documento = serviciosConfiguraciones.directorioFacturasComparendo() + numeroFactura + ".pdf";
            if (esCompuesta.toUpperCase().equals("SI")&& !numCuotas.equals("PAGO TOTAL")) 
                plantilla += "reciboPagoComparendosBarra_compuesta.jrxml";
            else if (esCompuesta.toUpperCase().equals("SI")&& numCuotas.equals("PAGO TOTAL")) 
                plantilla += "reciboPagoComparendosBarra_compuesta_TOTAL.jrxml";
            else if(!numCuotas.equals("PAGO TOTAL"))
                plantilla += "reciboPagoComparendosBarra.jrxml";
            else
                plantilla += "reciboPagoComparendosBarra_TOTAL.jrxml";
            
            //compilamos la plantilla
            JasperReport jasperReport = JasperCompileManager.compileReport(plantilla);
            //llenamos la plantilla
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, recurso);
            //exportamos el pdf
            JasperExportManager.exportReportToPdfFile(jasperPrint, documento);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
