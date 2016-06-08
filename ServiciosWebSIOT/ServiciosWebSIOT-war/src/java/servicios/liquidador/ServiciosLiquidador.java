package servicios.liquidador;

import java.util.List;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import modelo.datos.objetos.generales.Header;
import modelo.datos.objetos.generales.Item;
import modelo.datos.objetos.generales.vehiculo.Vehiculo;
import modelo.datos.objetos.liquidador.ConceptosTarifa;
import modelo.datos.objetos.liquidador.DatosAdicionalesFactura;
import modelo.datos.objetos.liquidador.DatosFactura;
import modelo.datos.objetos.liquidador.Factura;
import modelo.datos.objetos.liquidador.FacturaDet;
import modelo.datos.objetos.liquidador.Fechaimpuesto;
import modelo.datos.objetos.liquidador.Tarifa;

import modelo.logica.liquidador.GestionServiciosLiquidacionLocal2;
import modelo.logica.liquidador.GestionFechaimpuesto;

import servicios.generales.ServiciosVehiculos;

import utilidades.Funciones;
import utilidades.Seguridad;


@WebService
public class ServiciosLiquidador {

    GestionServiciosLiquidacionLocal2 gestionServiciosLiquidacionLocal;
    ServiciosVehiculos serviciosVehiculos;
    GestionFechaimpuesto gestionFechaimpuesto;

    public ServiciosLiquidador() {
        super();
        crearObjetos();
    }

    @Oneway
    @WebMethod
    public void crearObjetos() {
        gestionServiciosLiquidacionLocal = new GestionServiciosLiquidacionLocal2();
        gestionFechaimpuesto = new GestionFechaimpuesto();
        serviciosVehiculos = new ServiciosVehiculos();
    }

    @WebMethod
    public List getTarifas(Tarifa tarifa, boolean vehiculoActivo) {
        System.out.println("getTarifas");
        return gestionServiciosLiquidacionLocal.getTarifas(tarifa, vehiculoActivo);
    }

    @WebMethod
    public List getTarifasPorRangoVigencia(Tarifa tarifa, int vigenciaInicial, int vigenciaFinal) {
        return gestionServiciosLiquidacionLocal.getTarifasPorRangoVigencia(tarifa, vigenciaInicial, vigenciaFinal);
    }

    @WebMethod
    public List getDetalleFactura(FacturaDet facturadet) {
        return gestionServiciosLiquidacionLocal.getFacturaDetalle(facturadet);
    }


    @WebMethod
    public List getConceptosTarifa(ConceptosTarifa conceptoTarifa, String placa) {
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setPLACA(placa);
        vehiculo = serviciosVehiculos.getVehiculo(vehiculo);
        List res = gestionServiciosLiquidacionLocal.getConceptosTarifa(conceptoTarifa, vehiculo);
        return res;
    }
    
    @WebMethod
    public String getMeses() {
        return gestionServiciosLiquidacionLocal.getMeses();
    }    
    
    @WebMethod
    public String invocarCompilar(ConceptosTarifa conceptoTarifa, String placa) {
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setPLACA(placa);
        vehiculo = serviciosVehiculos.getVehiculo(vehiculo);
        String valor = "0";
        if (vehiculo != null && vehiculo.getID_VEHICULO() > 0) {
            valor = gestionServiciosLiquidacionLocal.invocarCompilar(conceptoTarifa, vehiculo);
        }
        return valor;
    }

    @WebMethod
    public DatosFactura facturar(Header header, List tarifas, List listaConceptos,
                                 DatosAdicionalesFactura datosAdionalesFactura, int idUsuario, String myIp, String myHost, String avaluo, int IdSolicitante) throws Exception {
        try{
        return gestionServiciosLiquidacionLocal.facturar(header, tarifas, listaConceptos, datosAdionalesFactura,false
                                                        /*Funciones.trabajaConRunt(header.getParametros())*/, idUsuario, myIp, myHost, avaluo, IdSolicitante);
        }catch(Exception e){e.printStackTrace(); return null;}   
    }

    @WebMethod
    public DatosFactura facturarTemp(Header header, List tarifas, List listaConceptos,
                                 DatosAdicionalesFactura datosAdionalesFactura, int idUsuario, String myIp, String myHost) throws Exception {
        try{
        return gestionServiciosLiquidacionLocal.facturarTemp(header, tarifas, listaConceptos, datosAdionalesFactura,false
                                                         /*Funciones.trabajaConRunt(header.getParametros())*/, idUsuario, myIp, myHost);
        }catch(Exception e){throw new Exception (e.getMessage());}   
    }
    
    @WebMethod
    public boolean editarNotaFactura(@WebParam(name = "lf_numero") String lf_numero, 
                                     @WebParam(name = "lf_nota") String lf_nota) {
        return gestionServiciosLiquidacionLocal.editarNotaFactura(lf_numero, lf_nota);
    }
    
    @WebMethod
    public boolean auditarCorrecciones(List listaConceptosAuditar, List listaConceptos, int idUsuario, String myIp, String myHost) {
        return gestionServiciosLiquidacionLocal.auditarCorrecciones(listaConceptosAuditar, listaConceptos, idUsuario, myIp, myHost);
    }

    @WebMethod
    public Factura buscarFactura(String idVehiculo, String idPersona, Item item) {
        return gestionServiciosLiquidacionLocal.buscarFactura(idVehiculo, idPersona);
    }
    
    @WebMethod
    public boolean permiteMultipleLiquidacion(int ltd_id) {
        return gestionServiciosLiquidacionLocal.permiteMultipleLiquidacion(ltd_id);
    }
        
    @WebMethod
    public boolean ActualizarSecuencialFacturas(int valor)
    {
        return gestionServiciosLiquidacionLocal.ActualizarSecuencialFacturas(valor);    
    }
    
    @WebMethod
    public int ConsultarSecuencialFacturas()
    {
        return gestionServiciosLiquidacionLocal.ConsultarSecuencialFacturas();
    }
    
    @WebMethod
    public Fechaimpuesto buscarPrimeroFechaimpuesto(Fechaimpuesto obj) {
            return gestionFechaimpuesto.buscarPrimeroFechaimpuesto(obj);
    }
    @WebMethod
    public Factura crearFacturaSimple(Factura obj) {
       return gestionServiciosLiquidacionLocal.crearFacturaSimple(obj);
    }
    
    @WebMethod
    public boolean setFacturaEstadoPagoSimple(Factura obj)
    {
       return gestionServiciosLiquidacionLocal.setFacturaEstadoPagoSimple(obj);
    }

}
