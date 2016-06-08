package servicios.comparendos;

import java.util.List;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;

import modelo.datos.objetos.comparendos.generales.ComparendoComp;
import modelo.datos.objetos.comparendos.generales.InfractorComp;
import modelo.datos.objetos.comparendos.liquidacion.detallerecibo.Detallerecibo;
import modelo.datos.objetos.comparendos.liquidador.ConceptosTarifa;
import modelo.datos.objetos.comparendos.liquidador.DatosAdicionalesFactura;
import modelo.datos.objetos.comparendos.liquidador.DatosLiquidacion;
import modelo.datos.objetos.comparendos.liquidador.Liquidacion;
import modelo.datos.objetos.comparendos.liquidador.Tarifa;
import modelo.datos.objetos.generales.Header;
import modelo.datos.objetos.liquidador.DatosFactura;

import modelo.logica.comparendos.generales.GestionServiciosGeneralesComp;
import modelo.logica.comparendos.liquidacion.detallerecibo.GestionDetallerecibo;
import modelo.logica.comparendos.liquidador.GestionServiciosLiquidacionLocalComparendos;


@WebService
public class ServiciosLiquidadorComparendos {

    GestionServiciosLiquidacionLocalComparendos gestionServiciosLiquidacionLocal;
    ServiciosGeneralesComp serviciosGeneralesComp;
    GestionServiciosGeneralesComp gestionServiciosGeneralesComp;
    GestionDetallerecibo gestionDetallerecibo;

    public ServiciosLiquidadorComparendos() {
        super();
        crearObjetos();
    }

    @Oneway
    @WebMethod
    public void crearObjetos() {
        gestionServiciosLiquidacionLocal = new GestionServiciosLiquidacionLocalComparendos();
        serviciosGeneralesComp = new ServiciosGeneralesComp();
        gestionServiciosGeneralesComp = new GestionServiciosGeneralesComp();
        gestionDetallerecibo = new GestionDetallerecibo();
    }


    @WebMethod
    public List getTarifas(Tarifa tarifa) {
        System.out.println("getTarifas");
        return gestionServiciosLiquidacionLocal.getTarifas(tarifa);
    }


    @WebMethod
    public List getConceptosTarifa(ConceptosTarifa conceptoTarifa, InfractorComp infractor, List comparendos,
                                   ComparendoComp comp) {
        return gestionServiciosLiquidacionLocal.getConceptosTarifa(conceptoTarifa, infractor, comparendos);
    }


    @WebMethod
    public DatosFactura facturar(Header header, List listaConceptos, DatosAdicionalesFactura datosAdionalesFactura,
                                 InfractorComp infractor, int idUsuario, String myIp, String myHost, Liquidacion Certificado) {
        return gestionServiciosLiquidacionLocal.facturar(header, listaConceptos, datosAdionalesFactura, infractor, idUsuario, myIp, myHost, Certificado);
    }

    @WebMethod
    public DatosFactura facturarParaCuota(Header header, List listaConceptos, DatosAdicionalesFactura datosAdionalesFactura,
                                 InfractorComp infractor, int idUsuario, String myIp, String myHost) {
        return gestionServiciosLiquidacionLocal.facturarParaCuota(header, listaConceptos, datosAdionalesFactura, infractor, idUsuario, myIp, myHost);
    }

    public List searchComparendo(ComparendoComp comparendo) {
        return gestionServiciosGeneralesComp.searchComparendo(comparendo);
    }
    
    public List searchComparendoEstado(ComparendoComp comparendo) {
        return gestionServiciosGeneralesComp.searchComparendo(comparendo);
    }
    
    public List getDatosLiquidacion(DatosLiquidacion obj) {
        return gestionServiciosLiquidacionLocal.getDatosLiquidacion(obj);
    }

    //
    //DETALLE_RECIBO
    //
    
            @WebMethod
            public Detallerecibo crearDetallerecibo(int id, String token, Detallerecibo obj ) {
                return gestionDetallerecibo.crearDetallerecibo(obj); 
            }
            
            @WebMethod
            public boolean editarDetallerecibo(int id, String token,Detallerecibo obj) {
                return gestionDetallerecibo.editarDetallerecibo(obj);
            }
            
            @WebMethod
            public Detallerecibo buscarPrimeroDetallerecibo(int id, String token,Detallerecibo obj) {
                return gestionDetallerecibo.buscarPrimeroDetallerecibo(obj);
            }
            
            @WebMethod
            public List buscarDetallerecibo(int id, String token,Detallerecibo obj) {
                return gestionDetallerecibo.buscarDetallerecibo(obj);
            }
            
            @WebMethod
            public List buscarPaginacionDetallerecibo(int id, String token,Detallerecibo obj,int pag,int numReg) {
               return gestionDetallerecibo.buscarDetallerecibo(obj, pag, numReg);
            }
            
            @WebMethod
            public List listarDetallerecibo(int id, String token) {
                return gestionDetallerecibo.listarDetallerecibo();
            }
            
            @WebMethod
            public List listarPaginacionDetallerecibo(int id, String token,int pag,int numReg) {
                return gestionDetallerecibo.listarDetallerecibo(pag, numReg);
            }
            
            @WebMethod
            public int contarBusquedaDetallerecibo(int id, String token,Detallerecibo obj) {
                return gestionDetallerecibo.contarBusquedaDetallerecibo(obj);
            }
            
            @WebMethod
            public boolean eliminarDetallerecibo(int id, String token,Detallerecibo obj) {
               return gestionDetallerecibo.eliminarDetallerecibo(obj);
            }
    
}


