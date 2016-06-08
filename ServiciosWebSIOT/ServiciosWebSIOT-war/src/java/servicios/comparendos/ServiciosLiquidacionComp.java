package servicios.comparendos;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import modelo.datos.objetos.comparendos.liquidacion.AcuerdosPagoComp;
import modelo.datos.objetos.comparendos.liquidacion.PagosComp;
import modelo.datos.objetos.comparendos.liquidacion.Recibocuotas;
import modelo.datos.objetos.comparendos.liquidacion.ViewPagosComp;
import modelo.datos.objetos.comparendos.liquidacion.tarifas.LiquidacionComp;

import modelo.logica.comparendos.liquidacion.GestionRecibocuotas;
import modelo.logica.comparendos.liquidacion.GestionReporteCuotas;
import modelo.logica.comparendos.liquidacion.GestionServiciosLiquidacionComp;


@WebService
public class ServiciosLiquidacionComp {
    GestionServiciosLiquidacionComp gestionServicio;

    public ServiciosLiquidacionComp() {
        super();
        gestionServicio = new GestionServiciosLiquidacionComp();
    }

    public List listarLiquidacionesDeudor(String nroIdentificacion, int tipo_identificacion) {
        return gestionServicio.obtenerLiquidacionesDeudor(nroIdentificacion, tipo_identificacion);
    }

    public List getLiquidaciones(LiquidacionComp myLiquid) {
        return gestionServicio.obtenerLiquidaciones(myLiquid);
    }
    
    public List getLiquidacionesAll(LiquidacionComp myLiquid) {
        return gestionServicio.getLiquidaciones(); //obtenerLiquidaciones(myLiquid);
    }

    public boolean editarLiquidacion(LiquidacionComp obj, int idUsuario, String myIp, String myHost) {
        return gestionServicio.editarLiquidacion(obj, idUsuario, myIp, myHost);
    }

    public AcuerdosPagoComp crearAcuerdoPago(AcuerdosPagoComp myAcuerdo, int idUsuario, String myIp, String myHost) {
        return gestionServicio.insertarAcuerdosPago(myAcuerdo, idUsuario, myIp, myHost);
    }

    public List ListarAcuerdosInfractor(String nroIdentificacion, int tipo_identificacion) {
        return gestionServicio.obtenerAcuerdosPagoInfractor(nroIdentificacion, tipo_identificacion);
    }

    public List getAcuerdoPagoComp(AcuerdosPagoComp myAcuerdo) {
        return gestionServicio.getAcuerdoPago(myAcuerdo);
    }

    public boolean eliminarAcuerdoPagoComp(AcuerdosPagoComp myAcuerdo, int idUsuario, String myIp, String myHost) {
        return gestionServicio.eliminarAcuerdoPago(myAcuerdo, idUsuario, myIp, myHost);
    }

    public PagosComp registarPagoComp(PagosComp myPago, int idUsuario, String myIp, String myHost) {
        return gestionServicio.insertarPagosComp(myPago, idUsuario, myIp, myHost);
    }

    public PagosComp registarConFechaPagoComp(PagosComp obj, int idUsuario, String myIp, String myHost) {
        return gestionServicio.insertarConFechaPagoComp(obj, idUsuario, myIp, myHost);
    }

    public List getDetallesPagosComp(ViewPagosComp myPago) {
        return gestionServicio.getViewPagosComp(myPago);
    }

    @WebMethod
    public boolean eliminarPagoComp(PagosComp MyPago, int idUsuario, String myIp, String myHost) {
        return gestionServicio.eliminarPagoComp(MyPago, idUsuario, myIp, myHost);
    }

    public List getPagosComp(PagosComp obj) {
        return gestionServicio.getPagosComp(obj);
    }

    public boolean editarPagosComp(PagosComp obj, int idUsuario, String myIp, String myHost) {
        return gestionServicio.editarPagosComp(obj, idUsuario, myIp, myHost);
    }

    public Recibocuotas crearReciboCuota(Recibocuotas obj, int idUsuario, String myIp, String myHost) {
        GestionRecibocuotas gestion = new GestionRecibocuotas();
        return gestion.crear(obj, idUsuario, myIp, myHost);
    }

    public boolean editarReciboCuota(Recibocuotas obj, int idUsuario, String myIp, String myHost) {
        GestionRecibocuotas gestion = new GestionRecibocuotas();
        return gestion.editar(obj, idUsuario, myIp, myHost);
    }

    public List getReciboCuota(Recibocuotas obj) {
        GestionRecibocuotas gestion = new GestionRecibocuotas();
        return gestion.get(obj);
    }

    public List listarReciboCuota() {
        GestionRecibocuotas gestion = new GestionRecibocuotas();
        return gestion.listar();
    }

    public LiquidacionComp insertarLiquidacionComp(LiquidacionComp myLiquidacion, int idUsuario, String myIp, String myHost) {
        return gestionServicio.insertarLiquidacionComp(myLiquidacion, idUsuario, myIp, myHost);
    }
    
    public String crearReporteCuotasPago(AcuerdosPagoComp acuerdosPago, int idEmpresa, int idInfractor,
                                         int idRecibosCom, int idUsuario, String myIp, String myHost) {
        GestionReporteCuotas gestion = new GestionReporteCuotas();
        return gestion.crearReporteCuotas(acuerdosPago, idEmpresa, idInfractor, idRecibosCom, idUsuario, myIp, myHost);
    }

    public String crearReporteReciboCuotasPago(int nroCuota, int idEmpresa, int idInfractor, int idLiquidacion, int idUsuario, String myIp, String myHost) {
        GestionReporteCuotas gestion = new GestionReporteCuotas();
        return gestion.crearReporteReciboCuotas(nroCuota, idEmpresa, idInfractor, idLiquidacion, idUsuario, myIp, myHost);
    }

    public String facturarCuotaPago(int idInfractor, int idLiquidacion, int nroCuota, int idUsuario, String myIp, String myHost) {
        return gestionServicio.facturarCuotaPago(idInfractor, idLiquidacion, nroCuota, idUsuario, myIp, myHost);
    }
    
    public int anularLiquidacion(int idLiquidacion, int idUsuario, String myIp, String myHost) {
        return gestionServicio.anularLiquidacion(idLiquidacion, idUsuario, myIp, myHost);
    }
}
