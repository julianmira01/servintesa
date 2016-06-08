package servicios.reportes;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import modelo.datos.objetos.reportes.Reportetramites;
import modelo.datos.objetos.reportes.Reportevehiculos;

import modelo.logica.reportes.GestionReportetramites;
import modelo.logica.reportes.GestionReportevehiculos;


@WebService
public class ServiciosReportes {
    
    @WebMethod
    public List listarReporteTramites() {
        GestionReportetramites gestion = new GestionReportetramites();
        return gestion.listar();
    }
    
    @WebMethod
    public List buscarReporteTramites(Reportetramites obj, String fechaTramiteIni,
                               String fechaTramiteFin, String fechaPagoIni, String fechaPagoFin) {
        GestionReportetramites gestion = new GestionReportetramites();
        return gestion.get(obj, fechaTramiteIni,
                               fechaTramiteFin, fechaPagoIni, fechaPagoFin);
    }
    
    @WebMethod
    public List listarReporteVehiculos() {
        GestionReportevehiculos gestion = new GestionReportevehiculos();
        return gestion.listar();
    }
    
    @WebMethod
    public List buscarReporteVehiculos(Reportevehiculos obj, String cilindrajeMin, String cilindrajeMax) {
        
        GestionReportevehiculos gestion = new GestionReportevehiculos();
        return gestion.get(obj, cilindrajeMin, cilindrajeMax);
    }
}
