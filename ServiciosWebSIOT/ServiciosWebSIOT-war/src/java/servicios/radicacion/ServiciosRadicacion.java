package servicios.radicacion;

import java.util.List;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;

import modelo.datos.objetos.liquidacion.Factura;
import modelo.datos.objetos.liquidacion.ViewDetFactura;
import modelo.datos.objetos.liquidacion.ViewDetalleFactura;
import modelo.datos.objetos.radicacion.Cita;
import modelo.datos.objetos.radicacion.DetCita;
import modelo.datos.objetos.radicacion.PuntosAtencion;
import modelo.datos.objetos.radicacion.RadRequisitoGral;
import modelo.datos.objetos.radicacion.RadTramitesRevisados;
import modelo.datos.objetos.radicacion.RadicadoDeVehiculos;
import modelo.datos.objetos.radicacion.RuntTipoEntregaSol;
import modelo.datos.objetos.radicacion.TramiteDependencia;
import modelo.datos.objetos.radicacion.TramitesPorDependencia;
import modelo.datos.objetos.radicacion.TramitesVehiculosRadicados;
import modelo.datos.objetos.radicacion.Viewcita;
import modelo.logica.radicacion.GestionPuntosAtencion;

import modelo.logica.radicacion.GestionServiciosRadicacionTramites;
import modelo.logica.radicacion.GestionViewcita;

@WebService
public class ServiciosRadicacion {
    GestionServiciosRadicacionTramites gestionServiciosRadicacion;
    GestionPuntosAtencion gestionPuntosAtencion; 
    GestionViewcita gestionViewcita;

    public ServiciosRadicacion() {
        super();
        crearObjetos();
    }

    @Oneway
    @WebMethod
    public void crearObjetos() {
        gestionServiciosRadicacion = new GestionServiciosRadicacionTramites();
        gestionViewcita = new GestionViewcita();
        gestionPuntosAtencion = new GestionPuntosAtencion() ;
    }

    @WebMethod
    public List buscarFactura(Factura factura) {
        return gestionServiciosRadicacion.getFacturas(factura);
    }

    @WebMethod
    public boolean validarFactura(RadicadoDeVehiculos radicado) {
        return gestionServiciosRadicacion.validarFactura(radicado);
    }

    @WebMethod
    public List buscarRadTramitesRevisados(RadTramitesRevisados myRadTramRev) {
        return gestionServiciosRadicacion.getRadTramitesRevisados(myRadTramRev);
    }

    @WebMethod
    public List buscarViewcita(Viewcita obj) {
        return gestionViewcita.buscarViewcita(obj);
        
    }

    @WebMethod
    public RadTramitesRevisados insertarRadTramitesRevisados(RadTramitesRevisados myRadTramRev) {
        return gestionServiciosRadicacion.insertarRadTramitesRevisados(myRadTramRev);
    }

    @WebMethod
    public List buscarRadicadoDeVehiculos(RadicadoDeVehiculos radicado) {
        return gestionServiciosRadicacion.getRadicadoDeVehiculos(radicado);
    }

    @WebMethod
    public RadicadoDeVehiculos insertarRadicadoDeVehiculos(RadicadoDeVehiculos radicado, int idUsuario, String myIp,
                                                           String myHost) {
        return gestionServiciosRadicacion.insertarRadicadoDeVehiculos(radicado, idUsuario, myIp, myHost);
    }

    @WebMethod
    public boolean saveIdCitaRadicado(RadicadoDeVehiculos radicado) {
        return gestionServiciosRadicacion.saveIdCitaRadicado(radicado);
    }

    @WebMethod
    public RadicadoDeVehiculos anularRadicadoDeVehiculo(RadicadoDeVehiculos radicado, int idUsuario, String myIp,
                                                        String myHost) {
        return gestionServiciosRadicacion.anularRadicadoDeVehiculos(radicado, idUsuario, myIp, myHost);
    }

    @WebMethod
    public RadicadoDeVehiculos aprobarRadicadoDeVehiculo(RadicadoDeVehiculos radicado, int idUsuario, String myIp,
                                                         String myHost) {
        return gestionServiciosRadicacion.aprobarRadicadoDeVehiculos(radicado, idUsuario, myIp, myHost);
    }

    @WebMethod
    public RadicadoDeVehiculos terminarRadicadoDeVehiculo(RadicadoDeVehiculos radicado, int idUsuario, String myIp,
                                                          String myHost) {
        return gestionServiciosRadicacion.terminarRadicadoDeVehiculos(radicado, idUsuario, myIp, myHost);
    }

    @WebMethod
    public RadicadoDeVehiculos fijarCitaRadicadoDeVehiculo(RadicadoDeVehiculos radicado) {
        return gestionServiciosRadicacion.fijarCitaRadicadoDeVehiculos(radicado);
    }

    @WebMethod
    public TramitesVehiculosRadicados insertarTramiteVehiculoRadicado(TramitesVehiculosRadicados myTramVehiRad) {
        return gestionServiciosRadicacion.insertarTramiteVehiculoRadicado(myTramVehiRad);
    }

    @WebMethod
    public List buscarTramiteVehiculoRadicado(TramitesVehiculosRadicados myTramVehiRad) {
        return gestionServiciosRadicacion.getTramiteVehiculoRadicado(myTramVehiRad);
    }

    @WebMethod
    public RadRequisitoGral insertarRadRequisitoGral(RadRequisitoGral myRadReqGral) {
        return gestionServiciosRadicacion.insertarRadRequisitoGral(myRadReqGral);
    }

    @WebMethod
    public List buscarRadRequisitoGral(RadRequisitoGral myRadReqGral) {
        return gestionServiciosRadicacion.getRadRequisitoGral(myRadReqGral);
    }

    @WebMethod
    public RadRequisitoGral cambiarEstadoRadRequisitoGral(RadRequisitoGral myRadReqGral, int idUsuario, String myIp,
                                                          String myHost) {
        return gestionServiciosRadicacion.cambiarEstadoRadRequisitoGral(myRadReqGral, idUsuario, myIp, myHost);
    }

    @WebMethod
    public RadRequisitoGral cambiarObservacionRadRequisitoGral(RadRequisitoGral myRadReqGral) {
        return gestionServiciosRadicacion.cambiarObservacionRadRequisitoGral(myRadReqGral);
    }

    @WebMethod
    public RadTramitesRevisados cambiarEstadoRadTramitesRev(RadTramitesRevisados myRadTramRev) {
        return gestionServiciosRadicacion.cambiarEstadoRadTramitesRev(myRadTramRev);
    }

    @WebMethod
    public RadTramitesRevisados cambiarObservacionRadTramitesRev(RadTramitesRevisados myRadTramRev) {
        return gestionServiciosRadicacion.cambiarObservacionRadTramitesRev(myRadTramRev);
    }

    @WebMethod
    public List buscarTramitePorDependencia(TramitesPorDependencia myTraPorDep) {
        return gestionServiciosRadicacion.getTramitePorDependencia(myTraPorDep, 0);
    }

    @WebMethod
    public TramiteDependencia insertarTramiteDependencia(TramiteDependencia myTramDep) {
        return gestionServiciosRadicacion.insertarTramiteDependencia(myTramDep, 0);
    }

    @WebMethod
    public void eliminarTramiteDependencia(TramiteDependencia myTramDep) {
        gestionServiciosRadicacion.eliminarTramiteDependencia(myTramDep, 0);
    }

    @WebMethod
    public String obtenerFecha() {
        return gestionServiciosRadicacion.getFecha();
    }

    @WebMethod
    public Cita insertarCita(Cita myCita, int idUsuario, String myIp, String myHost) {
        return gestionServiciosRadicacion.insertarCita(myCita, idUsuario, myIp, myHost, 0);
    }

    @WebMethod
    public Cita reasignarCita(Cita myCita, int idUsuario, String myIp, String myHost) {
        return gestionServiciosRadicacion.reasignarCita(myCita, idUsuario, myIp, myHost, 0);
    }


    @WebMethod
    public Cita terminarCita(Cita myCita, int idUsuario, String myIp, String myHost) {
        return gestionServiciosRadicacion.terminarCita(myCita, idUsuario, myIp, myHost, 0);
    }
    
    @WebMethod
    public Cita canelarCita(Cita myCita, int idUsuario, String myIp, String myHost) {
        return gestionServiciosRadicacion.cancelarCita(myCita, idUsuario, myIp, myHost, 0);
    }
    
    @WebMethod
    public Cita atenderCita(Cita myCita,String parametrosObservaciones, int idUsuario, String myIp, String myHost) {
        return gestionServiciosRadicacion.atenderCita(myCita,parametrosObservaciones, idUsuario, myIp, myHost, 0);
    }

    @WebMethod
    public Cita anularCita(Cita myCita, int idUsuario, String myIp, String myHost) {
        return gestionServiciosRadicacion.anularCita(myCita, idUsuario, myIp, myHost, 0);
    }

    @WebMethod
    public List buscarCita(Cita myCita) {
        return gestionServiciosRadicacion.getCita(myCita, 0);
    }

    @WebMethod
    public Cita ponerObservacionCita(Cita myCita) {
        return gestionServiciosRadicacion.ponerObservacionCita(myCita, 0);
    }

    @WebMethod
    public DetCita insertarDetCita(DetCita myDetCita) {
        return gestionServiciosRadicacion.insertarDetCita(myDetCita, 0);
    }

    @WebMethod
    public List buscarDetCita(DetCita myDetCita) {
        return gestionServiciosRadicacion.getDetCita(myDetCita, 0);
    }

    @WebMethod
    public void eliminarDetCita(DetCita myDetCita) {
        gestionServiciosRadicacion.eliminarDetCita(myDetCita, 0);
    }

    @WebMethod
    public boolean editarFactura(Factura factura) {
        return gestionServiciosRadicacion.editarFactura(factura);
    }
    
    @WebMethod
    public boolean editarFacturaIdArqueo(Factura factura) {
        return gestionServiciosRadicacion.editarFacturaIdArqueo(factura);
    }

    @WebMethod
    public List buscarItemsFactura(ViewDetFactura viewdetfactura) {
        return gestionServiciosRadicacion.buscarItemsFactura(viewdetfactura);
    }

    @WebMethod
    public List buscarDetItemsFactura(ViewDetalleFactura viewdetallefactura) {
        return gestionServiciosRadicacion.buscarDetItemsFactura(viewdetallefactura);
    }


    @WebMethod
    public List getLiquidacionImpuestos(ViewDetalleFactura viewdetallefactura) {
        return gestionServiciosRadicacion.getLiquidacionImpuestos(viewdetallefactura);
    }

    @WebMethod
    public boolean anulaFactura(Factura factura, int idUsuario, String myIp, String myHost) {
        return gestionServiciosRadicacion.anularFactura(factura, idUsuario, myIp, myHost);
    }


    @WebMethod
    public boolean procesarAnulacionFacturaInicial(Factura facturaprincipal, Factura facturaamiga) {
        return gestionServiciosRadicacion.eliminarFacturasMatriculaInicial(facturaprincipal, facturaamiga);
    }

    @WebMethod
    public boolean procesaFactura(Factura factura, int idUsuario, String myIp, String myHost) {
        return gestionServiciosRadicacion.procesaFactura(factura, idUsuario, myIp, myHost);
    }

    @WebMethod
    public boolean pagarFactura(Factura factura) {
        return gestionServiciosRadicacion.pagarFactura(factura);
    }

    @WebMethod
    public List getTipoEntregaSol(RuntTipoEntregaSol tipoentregasol) {
        return gestionServiciosRadicacion.getTipoEntregaSol(tipoentregasol);
    }
    
    @WebMethod
    public boolean setCargadoRunt(String estado, int idFactura) {
        return gestionServiciosRadicacion.setCargadoRunt(estado, idFactura);
    }
    
    // puntos atencion
    @WebMethod
    public List buscarPuntosAtencion(PuntosAtencion puntoAtencion) {
        return gestionPuntosAtencion.buscarPuntosAtencion(puntoAtencion);
    }
    
    @WebMethod
    public boolean actualizarPuntosAtencion(PuntosAtencion puntoAtencion) {
        return gestionPuntosAtencion.actualizarPuntosAtencion(puntoAtencion);
    }
    
    @WebMethod
    public List listarPuntosAtencion() {
        return gestionPuntosAtencion.listarPuntosAtencion();
    } 
    
    @WebMethod
    public PuntosAtencion insertarPuntoAtencion(PuntosAtencion puntoAtencion) {
        return gestionPuntosAtencion.insertarTramiteVehiculoRadicado(puntoAtencion);
    }
}

