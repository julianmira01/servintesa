package servicios.liquidacion;

import java.rmi.Remote;

import java.util.ArrayList;
import java.util.List;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import modelo.datos.objetos.comparendos.liquidacion.cuentasContables.CuentaConceptosComp;
import modelo.datos.objetos.comparendos.liquidacion.cuentasContables.CuentasContablesComp;
import modelo.datos.objetos.comparendos.liquidacion.cuentasContables.ListaTotalesCuentas;
import modelo.datos.objetos.comparendos.liquidacion.cuentasContables.ViewDetallesPagos;
import modelo.datos.objetos.comparendos.liquidacion.cuentasContables.ViewDetallesPagosConceptos;
import modelo.datos.objetos.generales.Transito;
import modelo.datos.objetos.generales.Usuarios;
import modelo.datos.objetos.liquidacion.ConceptosTarifa;
import modelo.datos.objetos.liquidacion.DatosAdicionalesFactura;
import modelo.datos.objetos.liquidacion.Factura;
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
import modelo.logica.liquidacion.ResumenCierreCaja;

@WebService(targetNamespace = "http://liquidacion.servicios/")
public interface ServiciosLiquidacionPortType extends Remote {
    @WebMethod
    public int crearArqueo(@WebParam(name = "arg0")
        ArqueoCaja arqueoCaja, @WebParam(name = "arg1")
        int idUsuario, @WebParam(name = "arg2")
        String myIp, @WebParam(name = "arg3")
        String myHost);

    @WebMethod
    public List getTotalesporCuentaTarifas(@WebParam(name = "arg0")
        String fechai, @WebParam(name = "arg1")
        String fechaf);

    @WebMethod
    public List getTCuentasContables();

    @WebMethod
    public ArqueoCaja preCrearArqueo(@WebParam(name = "arg0")
        ArqueoCaja arqueoCaja);

    @WebMethod
    public boolean eliminarCuentaConcepto(@WebParam(name = "arg0")
        CuentaConceptosComp cuentaconcepto);

    @WebMethod
    public List getTotalesporCuenta(@WebParam(name = "arg0")
        String fechai, @WebParam(name = "arg1")
        String fechaf);

    @WebMethod
    public boolean crearApertura(@WebParam(name = "arg0")
        AperturaTurno aperturaTurno, @WebParam(name = "arg1")
        int idUsuario, @WebParam(name = "arg2")
        String myIp, @WebParam(name = "arg3")
        String myHost);

    @WebMethod
    public boolean editarCuentaContable(@WebParam(name = "arg0")
        CuentasContablesComp cuentacontable);

    @WebMethod
    public boolean crearDetArqueo(@WebParam(name = "arg0")
        DetArqueo detArqueo, @WebParam(name = "arg1")
        int idUsuario, @WebParam(name = "arg2")
        String myIp, @WebParam(name = "arg3")
        String myHost);

    @WebMethod
    public boolean arquearApertura(@WebParam(name = "arg0")
        AperturaTurno aperturaTurno, @WebParam(name = "arg1")
        int idUsuario, @WebParam(name = "arg2")
        String myIp, @WebParam(name = "arg3")
        String myHost);

    @WebMethod
    public List getSCuentaConcepto(@WebParam(name = "arg0")
        CuentaConceptosComp cuentaconcepto);

    @WebMethod
    public CuentasContablesComp getCuentaContableId(@WebParam(name = "arg0")
        CuentasContablesComp cuentacontable);

    @WebMethod
    public List getConceptosTarifa(@WebParam(name = "arg0")
        ConceptosTarifa conceptoTarifa, @WebParam(name = "arg1")
        String placa);

    @WebMethod
    public boolean createPago(@WebParam(name = "arg0")
        Factura factura, @WebParam(name = "arg1")
        LPagos pago, @WebParam(name = "arg2")
        int idUsuario, @WebParam(name = "arg3")
        String myIp, @WebParam(name = "arg4")
        String myHost);

    @WebMethod
    public List getViewFacturaDateRange(@WebParam(name = "arg0")
        Viewfactura obj);

    @WebMethod
    public ArqueoCaja preCrearArqueoRunt(@WebParam(name = "arg0")
        ArqueoCaja arqueoCaja);

    @WebMethod
    public AperturaTurno BuscarAperturaTurno(@WebParam(name = "arg0")
        AperturaTurno aperturaTurno);

    @WebMethod
    public boolean editarPagoRunt(@WebParam(name = "arg0")
        LPagosRunt lpagosrunt, @WebParam(name = "arg1")
        int idUsuario, @WebParam(name = "arg2")
        String myIp, @WebParam(name = "arg3")
        String myHost);

    @WebMethod
    public List getTotalesporConcepto(@WebParam(name = "arg0")
        String fechai, @WebParam(name = "arg1")
        String fechaf);

    @WebMethod
    @Oneway
    public void crearObjetos();

    @WebMethod
    public List buscarArqueos(@WebParam(name = "arg0")
        ArqueoCaja arqueoCaja);

    @WebMethod
    public boolean eliminarCuentaContable(@WebParam(name = "arg0")
        CuentasContablesComp cuentacontable);

    @WebMethod
    public List buscarPagoRunt(@WebParam(name = "arg0")
        LPagosRunt lpagosrunt);

    @WebMethod
    public boolean anularPago(@WebParam(name = "arg0")
        Factura factura, @WebParam(name = "arg1")
        int idUsuario, @WebParam(name = "arg2")
        String myIp, @WebParam(name = "arg3")
        String myHost);

    @WebMethod
    public List BuscarApertura(@WebParam(name = "arg0")
        AperturaTurno aperturaTurno);

    @WebMethod
    public List buscarArqueosSinCierreRunt();

    @WebMethod
    public List getTotalesCuenta(@WebParam(name = "arg0")
        ListaTotalesCuentas listatotalescuentas, @WebParam(name = "arg1")
        ViewDetallesPagos viewdetallespagos, @WebParam(name = "arg2")
        ViewDetallesPagosConceptos viewdetallespagosconceptos, @WebParam(name = "arg3")
        ViewAsobancaria viewasobancaria);

    @WebMethod
    public List buscarPago(@WebParam(name = "arg0")
        LPagos lpagos);

    @WebMethod
    public int cerrarCaja(@WebParam(name = "arg0")
        CierreCaja cierreCaja, @WebParam(name = "arg1")
        int idUsuario, @WebParam(name = "arg2")
        String myIp, @WebParam(name = "arg3")
        String myHost);

    @WebMethod
    public String crearReporteArqueo(@WebParam(name = "arg0")
        String tipoArqueo, @WebParam(name = "arg1")
        Usuarios usuarioArquea, @WebParam(name = "arg2")
        Usuarios usuarioArqueado, @WebParam(name = "arg3")
        AperturaTurno aperturaTurno, @WebParam(name = "arg4")
        ArqueoCaja arqueoCaja, @WebParam(name = "arg5")
        ArrayList<DetArqueo> listaDetArqueo, @WebParam(name = "arg6")
        ArrayList<Factura> listaFactura, @WebParam(name = "arg7")
        ArrayList<LPagos> listaPago, @WebParam(name = "arg8")
        ArrayList<DetArqueoRunt> listaDetArqueoRunt, @WebParam(name = "arg9")
        ArrayList<LPagosRunt> listaPagoRunt, @WebParam(name = "arg10")
        Transito transito);

    @WebMethod
    @Oneway
    public void facturar(@WebParam(name = "arg0")
        List tarifas, @WebParam(name = "arg1")
        List conceptosTarifas, @WebParam(name = "arg2")
        DatosAdicionalesFactura datosAdionalesFactura);

    @WebMethod
    public List getTarifas(@WebParam(name = "arg0")
        modelo.datos.objetos.liquidacion.Tarifa tarifa);

    @WebMethod
    public List getViewFactura(@WebParam(name = "arg0")
        Viewfactura obj);
    
    @WebMethod
    public List getViewFacturaRNC(@WebParam(name = "arg0")
        ViewFacturaRNC obj);

    @WebMethod
    public boolean editarPago(@WebParam(name = "arg0")
        LPagos lpagos, @WebParam(name = "arg1")
        int idUsuario, @WebParam(name = "arg2")
        String myIp, @WebParam(name = "arg3")
        String myHost);

    @WebMethod
    public int crearArqueoRunt(@WebParam(name = "arg0")
        ArqueoCaja arqueoCaja, @WebParam(name = "arg1")
        int idUsuario, @WebParam(name = "arg2")
        String myIp, @WebParam(name = "arg3")
        String myHost);

    @WebMethod
    public boolean editarPagoIdArqueo(@WebParam(name = "arg0")
        LPagos lpagos, @WebParam(name = "arg1")
        int idUsuario, @WebParam(name = "arg2")
        String myIp, @WebParam(name = "arg3")
        String myHost);

    @WebMethod
    public boolean CrearCuentaContable(@WebParam(name = "arg0")
        CuentasContablesComp cuentacontable);

    @WebMethod
    public boolean CrearCuentaConcepto(@WebParam(name = "arg0")
        CuentaConceptosComp cuentaconcepto);

    @WebMethod
    public boolean editarApertura(@WebParam(name = "arg0")
        AperturaTurno aperturaTurno, @WebParam(name = "arg1")
        int idUsuario, @WebParam(name = "arg2")
        String myIp, @WebParam(name = "arg3")
        String myHost);

    @WebMethod
    public String crearReporteCierreCaja(@WebParam(name = "arg0")
        String tipoArqueo, @WebParam(name = "arg1")
        Usuarios usuarioArquea, @WebParam(name = "arg2")
        CierreCaja cierreCaja, @WebParam(name = "arg3")
        Transito transito, @WebParam(name = "arg4")
        ArrayList<ResumenCierreCaja> listaResumenCierreCaja);

    @WebMethod
    public List listarViewFactura();

    @WebMethod
    public List getAsobancaria(@WebParam(name = "arg0")
        String fechai, @WebParam(name = "arg1")
        String fechaf);

    @WebMethod
    public boolean crearDetArqueoRunt(@WebParam(name = "arg0")
        DetArqueoRunt detArqueoRunt, @WebParam(name = "arg1")
        int idUsuario, @WebParam(name = "arg2")
        String myIp, @WebParam(name = "arg3")
        String myHost);
}
