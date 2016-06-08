package servicios.liquidacion;

import java.util.ArrayList;
import java.util.List;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;

import modelo.datos.objetos.comparendos.liquidacion.cuentasContables.CuentaConceptosComp;
import modelo.datos.objetos.comparendos.liquidacion.cuentasContables.CuentasContablesComp;
import modelo.datos.objetos.comparendos.liquidacion.cuentasContables.ListaTotalesCuentas;
import modelo.datos.objetos.comparendos.liquidacion.cuentasContables.ViewDetallesPagos;
import modelo.datos.objetos.comparendos.liquidacion.cuentasContables.ViewDetallesPagosConceptos;
import modelo.datos.objetos.debidoCobrarImpuesto.Debidocobrarimpuesto;
import modelo.datos.objetos.debidoCobrarImpuesto.Registrodebidocobrar;
import modelo.datos.objetos.debidoCobrarImpuesto.Registroimpuesto;
import modelo.datos.objetos.debidoCobrarImpuesto.Viewconsvehiimpuestoslote;
import modelo.datos.objetos.debidoCobrarImpuesto.Viewdebidocobrarimpuestos;
import modelo.datos.objetos.debidoCobrarImpuesto.Viewregistrodebidocobrar;
import modelo.datos.objetos.generales.Transito;
import modelo.datos.objetos.generales.Usuarios;
import modelo.datos.objetos.generales.vehiculo.Vehiculo;
import modelo.datos.objetos.liquidacion.ConceptosTarifa;
import modelo.datos.objetos.liquidacion.DatosAdicionalesFactura;
import modelo.datos.objetos.liquidacion.Factura;
import modelo.datos.objetos.liquidacion.Tarifa;
import modelo.datos.objetos.liquidacion.ViewFacturaRNC;
import modelo.datos.objetos.liquidacion.Viewfactura;
import modelo.datos.objetos.liquidacion.caja.AperturaTurno;
import modelo.datos.objetos.liquidacion.caja.ArqueoCaja;
import modelo.datos.objetos.liquidacion.caja.CierreCaja;
import modelo.datos.objetos.liquidacion.caja.DetArqueo;
import modelo.datos.objetos.liquidacion.caja.DetArqueoRunt;
import modelo.datos.objetos.liquidacion.caja.LPagos;
import modelo.datos.objetos.liquidacion.caja.LPagosRunt;
import modelo.datos.objetos.liquidacion.caja.ViewAsobancaria;

import modelo.logica.debidoCobrarImpuesto.GestionDebidocobrarimpuesto;
import modelo.logica.debidoCobrarImpuesto.GestionRegistrodebidocobrar;
import modelo.logica.debidoCobrarImpuesto.GestionRegistroimpuesto;
import modelo.logica.debidoCobrarImpuesto.GestionViewconsvehiimpuestoslote;
import modelo.logica.debidoCobrarImpuesto.GestionViewdebidocobrarimpuestos;
import modelo.logica.debidoCobrarImpuesto.GestionViewregistrodebidocobrar;
import modelo.logica.liquidacion.GestionReporteArqueo;
import modelo.logica.liquidacion.GestionServiciosLiquidacionLocal;
import modelo.logica.liquidacion.GestionViewfactura;
import modelo.logica.liquidacion.ResumenCierreCaja;

import servicios.generales.ServiciosVehiculos;

import utilidades.Seguridad;

@WebService(endpointInterface = "servicios.liquidacion.ServiciosLiquidacionPortType")
public class ServiciosLiquidacion {

    GestionServiciosLiquidacionLocal gestionServiciosLiquidacionLocal;
    ServiciosVehiculos ServiciosVehiculos;
    GestionViewfactura gestionViewFactura;
    GestionDebidocobrarimpuesto gestionDebidocobrarimpuesto;
    GestionViewdebidocobrarimpuestos gestionViewdebidocobrarimpuestos;
    GestionRegistroimpuesto gestionRegistroimpuesto;
    GestionRegistrodebidocobrar gestionRegistrodebidocobrar;
    GestionViewregistrodebidocobrar gestionViewregistrodebidocobrar;
    GestionViewconsvehiimpuestoslote gestionViewconsvehiimpuestoslote;
    

    public ServiciosLiquidacion() {
        super();
        crearObjetos();
    }

    
    
    public void crearObjetos() {
        gestionServiciosLiquidacionLocal = new GestionServiciosLiquidacionLocal();
        ServiciosVehiculos = new ServiciosVehiculos();
        gestionViewFactura = new GestionViewfactura();
        gestionDebidocobrarimpuesto = new GestionDebidocobrarimpuesto();
        gestionViewdebidocobrarimpuestos = new GestionViewdebidocobrarimpuestos();
        gestionRegistroimpuesto = new GestionRegistroimpuesto();
        gestionRegistrodebidocobrar = new GestionRegistrodebidocobrar();
        gestionViewregistrodebidocobrar = new GestionViewregistrodebidocobrar();
        gestionViewconsvehiimpuestoslote = new GestionViewconsvehiimpuestoslote();
    }

    
    public List getTarifas(Tarifa tarifa) {
        return gestionServiciosLiquidacionLocal.getTarifas(tarifa);
    }


    
    public List getConceptosTarifa(ConceptosTarifa conceptoTarifa, String placa) {
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setPLACA(placa);
        vehiculo = ServiciosVehiculos.getVehiculo(vehiculo);
        return gestionServiciosLiquidacionLocal.getConceptosTarifa(conceptoTarifa, vehiculo);
    }

    
    
    public void facturar(List tarifas, List conceptosTarifas, DatosAdicionalesFactura datosAdionalesFactura) {
        gestionServiciosLiquidacionLocal.facturar(tarifas, conceptosTarifas, datosAdionalesFactura);
    }

    
    public List BuscarApertura(AperturaTurno aperturaTurno) {
        return gestionServiciosLiquidacionLocal.getAperturas(aperturaTurno);
    }

    
    public AperturaTurno BuscarAperturaTurno(AperturaTurno aperturaTurno) {
        return gestionServiciosLiquidacionLocal.getAperturaTurno(aperturaTurno);
    }

    
    public boolean crearApertura(AperturaTurno aperturaTurno, int idUsuario, String myIp, String myHost) {
        return gestionServiciosLiquidacionLocal.crearApertura(aperturaTurno, idUsuario, myIp, myHost);
    }

    
    public boolean editarApertura(AperturaTurno aperturaTurno, int idUsuario, String myIp, String myHost) {
        return gestionServiciosLiquidacionLocal.editarApertura(aperturaTurno, idUsuario, myIp, myHost);
    }

    
    public boolean arquearApertura(AperturaTurno aperturaTurno, int idUsuario, String myIp, String myHost) {
        return gestionServiciosLiquidacionLocal.arquearApertura(aperturaTurno, idUsuario, myIp, myHost);
    }

    
    public int crearArqueo(ArqueoCaja arqueoCaja, int idUsuario, String myIp, String myHost) {
        return gestionServiciosLiquidacionLocal.crearArqueo(arqueoCaja, idUsuario, myIp, myHost);
    }

    
    public ArqueoCaja preCrearArqueo(ArqueoCaja arqueoCaja) {
        return gestionServiciosLiquidacionLocal.preCrearArqueo(arqueoCaja);
    }

    
    public boolean editarArqueo(ArqueoCaja arqueoCaja, int idUsuario, String myIp, String myHost) {
        return gestionServiciosLiquidacionLocal.editarArqueo(arqueoCaja, idUsuario, myIp, myHost);
    }

    
    public boolean crearDetArqueo(DetArqueo detArqueo, int idUsuario, String myIp, String myHost) {
        return gestionServiciosLiquidacionLocal.crearDetArqueo(detArqueo, idUsuario, myIp, myHost);
    }

    
    public int crearArqueoRunt(ArqueoCaja arqueoCaja, int idUsuario, String myIp, String myHost) {
        return gestionServiciosLiquidacionLocal.crearArqueoRunt(arqueoCaja, idUsuario, myIp, myHost);
    }

    
    public ArqueoCaja preCrearArqueoRunt(ArqueoCaja arqueoCaja) {
        return gestionServiciosLiquidacionLocal.preCrearArqueoRunt(arqueoCaja);
    }

    
    public List buscarArqueosSinCierreRunt() {
        return gestionServiciosLiquidacionLocal.getArqueosSinCierreRunt();
    }

    
    public boolean crearDetArqueoRunt(DetArqueoRunt detArqueoRunt, int idUsuario, String myIp, String myHost) {
        return gestionServiciosLiquidacionLocal.crearDetArqueoRunt(detArqueoRunt, idUsuario, myIp, myHost);
    }

    
    public List buscarPago(LPagos lpagos) {
        return gestionServiciosLiquidacionLocal.getPagos(lpagos);
    }

    
    public boolean editarPago(LPagos lpagos, int idUsuario, String myIp, String myHost) {
        return gestionServiciosLiquidacionLocal.editarPago(lpagos, idUsuario, myIp, myHost);
    }
    
    
    public boolean editarPagoIdArqueo(LPagos lpagos, int idUsuario, String myIp, String myHost) {
        return gestionServiciosLiquidacionLocal.editarPagoIdArqueo(lpagos, idUsuario, myIp, myHost);
    }

    
    public List buscarPagoRunt(LPagosRunt lpagosrunt) {
        return gestionServiciosLiquidacionLocal.getPagosRunt(lpagosrunt);
    }

    
    public boolean editarPagoRunt(LPagosRunt lpagosrunt, int idUsuario, String myIp, String myHost) {
        return gestionServiciosLiquidacionLocal.editarPagoRunt(lpagosrunt, idUsuario, myIp, myHost);
    }

    
    public int cerrarCaja(CierreCaja cierreCaja, int idUsuario, String myIp, String myHost) {
        return gestionServiciosLiquidacionLocal.cerrarCaja(cierreCaja, idUsuario, myIp, myHost);
    }

    
    public boolean createPago(Factura factura,LPagos pago, int idUsuario, String myIp, String myHost) {
        return gestionServiciosLiquidacionLocal.createPagos(factura,pago, idUsuario, myIp, myHost);
    }
    
    
    public boolean anularPago(Factura factura,int idUsuario, String myIp, String myHost) {
        return gestionServiciosLiquidacionLocal.anularPago(factura,idUsuario, myIp, myHost);
    }

    
    public List getTCuentasContables() {
        return gestionServiciosLiquidacionLocal.getTCuentasContables();
    }

    
    public CuentasContablesComp getCuentaContableId(CuentasContablesComp cuentacontable) {
        return gestionServiciosLiquidacionLocal.getCuentaContableId(cuentacontable);
    }

    
    public boolean CrearCuentaContable(CuentasContablesComp cuentacontable) {
        return gestionServiciosLiquidacionLocal.CrearCuentaContable(cuentacontable);
    }

    
    public boolean editarCuentaContable(CuentasContablesComp cuentacontable) {
        return gestionServiciosLiquidacionLocal.editarCuentaContable(cuentacontable);
    }

    
    public boolean eliminarCuentaContable(CuentasContablesComp cuentacontable) {
        return gestionServiciosLiquidacionLocal.eliminarCuentaContable(cuentacontable);
    }

    
    public List getSCuentaConcepto(CuentaConceptosComp cuentaconcepto) {
        return gestionServiciosLiquidacionLocal.getSCuentaConcepto(cuentaconcepto);
    }

    
    public boolean CrearCuentaConcepto(CuentaConceptosComp cuentaconcepto) {
        return gestionServiciosLiquidacionLocal.CrearCuentaConcepto(cuentaconcepto);
    }

    
    public boolean eliminarCuentaConcepto(CuentaConceptosComp cuentaconcepto) {
        return gestionServiciosLiquidacionLocal.eliminarCuentaConcepto(cuentaconcepto);
    }

    
    public List getTotalesCuenta(ListaTotalesCuentas listatotalescuentas, ViewDetallesPagos viewdetallespagos,
                                 ViewDetallesPagosConceptos viewdetallespagosconceptos,
                                 ViewAsobancaria viewasobancaria) {
        return gestionServiciosLiquidacionLocal.getTotalesCuenta(listatotalescuentas, viewdetallespagos,
                                                                 viewdetallespagosconceptos, viewasobancaria);
    }

    
    public List getTotalesporCuenta(String fechai, String fechaf) {
        return gestionServiciosLiquidacionLocal.getTotalesporCuenta(fechai, fechaf);
    }
    
    public List getTotalesporCuentaTarifas(String fechai, String fechaf) {
        return gestionServiciosLiquidacionLocal.getTotalesporCuentaTarifas(fechai, fechaf);
    }

    
    public List getTotalesporConcepto(String fechai, String fechaf) {
        return gestionServiciosLiquidacionLocal.getTotalesporConcepto(fechai, fechaf);
    }

    
    public List getAsobancaria(String fechai, String fechaf) {
        return gestionServiciosLiquidacionLocal.getAsobancaria(fechai, fechaf);
    }

    
    public List listarViewFactura() {
        return gestionViewFactura.listar();
    }

    
    public List getViewFactura(Viewfactura obj) {
        return gestionViewFactura.get(obj);
    }
    
    public List getViewFacturaRNC(ViewFacturaRNC  obj) {
        return gestionViewFactura.getRNC(obj);
    }
    
    public List getViewFacturaDateRange(Viewfactura obj) {
        return gestionViewFactura.getDateRange(obj);
    }
    
    
    public String crearReporteArqueo(String tipoArqueo, Usuarios usuarioArquea, Usuarios usuarioArqueado, 
                                   AperturaTurno aperturaTurno, ArqueoCaja arqueoCaja, 
                                   ArrayList<DetArqueo> listaDetArqueo, ArrayList<Factura> listaFactura, ArrayList<LPagos> listaPago, 
                                   ArrayList<DetArqueoRunt> listaDetArqueoRunt, ArrayList<LPagosRunt> listaPagoRunt, Transito transito) {
        GestionReporteArqueo gestion = new GestionReporteArqueo();
        return gestion.crearReporteArqueo(tipoArqueo, usuarioArquea, usuarioArqueado, aperturaTurno, arqueoCaja, listaDetArqueo, listaFactura, listaPago, listaDetArqueoRunt, listaPagoRunt, transito);
    }
    
    public String crearReporteCierreCaja(String tipoArqueo, Usuarios usuarioArquea, CierreCaja cierreCaja, 
                                   Transito transito, ArrayList<ResumenCierreCaja> listaResumenCierreCaja) {
        GestionReporteArqueo gestion = new GestionReporteArqueo();
        return gestion.crearReporteCierreCaja(tipoArqueo, usuarioArquea, cierreCaja, transito, listaResumenCierreCaja);
    }

    public List buscarArqueos(ArqueoCaja arqueoCaja) {
        return gestionServiciosLiquidacionLocal.getArqueos(arqueoCaja);
    }

    public List buscarArqueosSinCierre() {
        return gestionServiciosLiquidacionLocal.getArqueosSinCierre();
    }
    
            
}