package servicios.archivosPlanos;

import java.sql.Connection;
import java.sql.SQLException;

import java.util.List;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;

import modelo.datos.dao.generales.vehiculo.ViewInfoVehiculoPlano;
import modelo.datos.objetos.generales.medidasCautelares.ViewMedidasCautelares;
import modelo.datos.objetos.liquidacion.caja.ViewAsobancaria;
import modelo.datos.objetos.tramites.ViewTramitesVehiculoPorFecha;

import modelo.logica.generales.GestionServiciosViewMedidasCautelares;
import modelo.logica.generales.GestionServiciosViewTramitesVehiculoPorFechas;
import modelo.logica.generales.vehiculo.GestionServiciosInfoVehiculoPlano;
import modelo.logica.liquidacion.GestionServiciosViewPagos;

@WebService
public class ServiciosArchivosPlanos
{
    GestionServiciosViewTramitesVehiculoPorFechas gestionServiciosViewTramitesVehiculoPorFechas;
    GestionServiciosViewMedidasCautelares gestionServiciosViewMedidasCautelares;
    GestionServiciosInfoVehiculoPlano gestionServiciosInfoVehiculoPlano;
    GestionServiciosViewPagos gestionServiciosViewPagos;
    
    public ServiciosArchivosPlanos() {
        super();
        crearObjetos();
    }

    @WebMethod
    @Oneway
    public void crearObjetos(){
        gestionServiciosViewTramitesVehiculoPorFechas = new GestionServiciosViewTramitesVehiculoPorFechas();  
        gestionServiciosViewMedidasCautelares = new GestionServiciosViewMedidasCautelares();
        gestionServiciosInfoVehiculoPlano = new GestionServiciosInfoVehiculoPlano();
        gestionServiciosViewPagos = new GestionServiciosViewPagos();
    }

    @WebMethod
    public List getTramitesVehiculoPorFechaPlaca(ViewTramitesVehiculoPorFecha viewTramitesVehiculoPorFechas, String fecha1, String fecha2)throws Exception{
        try{return gestionServiciosViewTramitesVehiculoPorFechas.getTramitesVehiculoPorFechaPlaca(viewTramitesVehiculoPorFechas, fecha1, fecha2);}catch(Exception e){throw new Exception(e.getMessage());} 
    }
    
    @WebMethod
    public List getViewMedidasCautelares(ViewMedidasCautelares viewMedidasCautelares)throws Exception{
        try{return gestionServiciosViewMedidasCautelares.getViewMedidasCautelares(viewMedidasCautelares);}catch(Exception e){throw new Exception(e.getMessage());} 
    }

    @WebMethod
    public List getInfoVehiculoPlano(ViewInfoVehiculoPlano viewInfoVehiculoPlano)throws Exception{
        try{return gestionServiciosInfoVehiculoPlano.getInfoVehiculoPlano(viewInfoVehiculoPlano);}catch(Exception e){throw new Exception(e.getMessage());} 
    }
    
    @WebMethod
    public List loadPlanoAsobancaria(ViewAsobancaria viewAsobancaria, String fechai, String fechaf)throws Exception
    { 
        try{return gestionServiciosViewPagos.loadPlanoAsobancaria(viewAsobancaria, fechai, fechaf);}catch(Exception e){throw new Exception(e.getMessage());} 
    }
}
