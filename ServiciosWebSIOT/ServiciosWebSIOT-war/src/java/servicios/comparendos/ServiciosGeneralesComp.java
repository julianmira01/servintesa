 package servicios.comparendos;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import modelo.datos.objetos.comparendos.generales.AgenteComp;
import modelo.datos.objetos.comparendos.generales.Banco;
import modelo.datos.objetos.comparendos.generales.ComparendoComp;
import modelo.datos.objetos.comparendos.generales.EstadoAlcoholemia;
import modelo.datos.objetos.comparendos.generales.FormaPago;
import modelo.datos.objetos.comparendos.generales.HistoricoEstadosComp;
import modelo.datos.objetos.comparendos.generales.InfracionComparendoComp;
import modelo.datos.objetos.comparendos.generales.InfractorComp;
import modelo.datos.objetos.comparendos.generales.OrigenDescargo;
import modelo.datos.objetos.comparendos.generales.PropietarioVehComp;
import modelo.datos.objetos.comparendos.generales.ResolucionesSimit;
import modelo.datos.objetos.comparendos.generales.TarjetasCredito;
import modelo.datos.objetos.comparendos.generales.TestigoComp;
import modelo.datos.objetos.comparendos.generales.TipoPago;
import modelo.datos.objetos.comparendos.generales.TransitoComp;
import modelo.datos.objetos.comparendos.generales.VehiculosComp;
import modelo.datos.objetos.comparendos.generales.ViewComparendosResolSancionComp;
import modelo.datos.objetos.comparendos.generales.ViewLiquidacionComparendo;
import modelo.datos.objetos.comparendos.generales.Viewestadoinfraccomp;
import modelo.datos.objetos.comparendos.generales.Estadoaplicarresolucion;

import modelo.logica.comparendos.generales.GestionServiciosGeneralesComp;
import modelo.logica.comparendos.generales.GestionViewestadoinfraccomp;
import modelo.logica.comparendos.generales.GestionEstadoaplicarresolucion;
import modelo.logica.comparendos.generales.GestionHistorialcomparendo;


import modelo.datos.objetos.resoluciones.Docsresoluciones;
import modelo.datos.objetos.documentos.Tipodocgenerar;
import modelo.datos.objetos.comparendos.generales.Historialcomparendo;
import modelo.datos.objetos.comparendos.generales.Pasos;
import modelo.datos.objetos.comparendos.generales.Procesos;
import modelo.datos.objetos.comparendos.generales.Secuenciaprocesos;
import modelo.datos.objetos.accesorias.Diasfestivos;
import modelo.datos.objetos.generales.SumarTiempoFecha;

import modelo.logica.documentos.GestionServiciosDocumentos;


import modelo.logica.generales.GestionServiciosDiasfestivos;

import utilidades.Seguridad;

@WebService
public class ServiciosGeneralesComp {
    GestionServiciosGeneralesComp gestionServiciosGeneralesComp;
    GestionViewestadoinfraccomp gestionViewestadoinfraccomp;
    GestionEstadoaplicarresolucion gestionEstadoaplicarresolucion;
    GestionServiciosDocumentos gestionServiciosDocumentos;
    GestionHistorialcomparendo gestionHistorialcomparendo;
    GestionServiciosDiasfestivos gestionServiciosDiasfestivos;

    public ServiciosGeneralesComp() {
        super();
        gestionServiciosGeneralesComp = new GestionServiciosGeneralesComp();
        gestionViewestadoinfraccomp = new GestionViewestadoinfraccomp();
        gestionEstadoaplicarresolucion = new GestionEstadoaplicarresolucion();
        gestionServiciosDocumentos = new GestionServiciosDocumentos();
        gestionHistorialcomparendo = new GestionHistorialcomparendo();
        gestionServiciosDiasfestivos = new GestionServiciosDiasfestivos();
    }

    //** GESTION GestionViewestadoinfraccomp

    @WebMethod
    public Viewestadoinfraccomp buscarPrimeroViewestadoinfraccomp(Viewestadoinfraccomp obj) {

        return gestionViewestadoinfraccomp.buscarPrimeroViewestadoinfraccomp(obj);

    }

    @WebMethod
    public List buscarViewestadoinfraccomp(Viewestadoinfraccomp obj) {
        return gestionViewestadoinfraccomp.buscarViewestadoinfraccomp(obj);
    }
    
    
    //SERVICIO NUEVO EDWIN
    @WebMethod
    public List buscarViewestadoinfraccompPersuasivo(int idInfractor) {
        return gestionViewestadoinfraccomp.buscarViewestadoinfraccompPersuasivo(idInfractor);
    }


    @WebMethod
    public List buscarPaginacionViewestadoinfraccomp(Viewestadoinfraccomp obj, int pag, int numReg) {

        return gestionViewestadoinfraccomp.buscarViewestadoinfraccomp(obj, pag, numReg);

    }

    @WebMethod
    public List listarViewestadoinfraccomp() {

        return gestionViewestadoinfraccomp.listarViewestadoinfraccomp();

    }

    @WebMethod
    public List getComparendosEnEstados(String estados, int idinfractor) {

        return gestionViewestadoinfraccomp.listarViewestadoinfraccompEnEstados(estados, idinfractor);

    }

    @WebMethod
    public List listarPaginacionViewestadoinfraccomp(int pag, int numReg) {

        return gestionViewestadoinfraccomp.listarViewestadoinfraccomp(pag, numReg);

    }

    @WebMethod
    public int contarBusquedaViewestadoinfraccomp(Viewestadoinfraccomp obj) {


        return gestionViewestadoinfraccomp.contarBusquedaViewestadoinfraccomp(obj);

    }

    //*******************************************************

    //GESTION ESTADOCOMPARENDO

    @WebMethod
    public Estadoaplicarresolucion crearEstadoAplicarResolucion(Estadoaplicarresolucion obj) {

        return gestionEstadoaplicarresolucion.crearEstadoaplicarresolucion(obj);

    }

    @WebMethod
    public boolean editarEstadoaplicarresolucion(Estadoaplicarresolucion obj) {

        return gestionEstadoaplicarresolucion.editarEstadoaplicarresolucion(obj);

    }

    @WebMethod
    public Estadoaplicarresolucion buscarPrimeroEstadoaplicarresolucion(Estadoaplicarresolucion obj) {

        return gestionEstadoaplicarresolucion.buscarPrimeroEstadoaplicarresolucion(obj);

    }

    @WebMethod
    public List buscarEstadoaplicarresolucion(Estadoaplicarresolucion obj) {

        return gestionEstadoaplicarresolucion.buscarEstadoaplicarresolucion(obj);

    }

    @WebMethod
    public List buscarPaginacionEstadoaplicarresolucion(Estadoaplicarresolucion obj, int pag, int numReg) {

        return gestionEstadoaplicarresolucion.buscarEstadoaplicarresolucion(obj, pag, numReg);

    }

    @WebMethod
    public List listarEstadoaplicarresolucion() {

        return gestionEstadoaplicarresolucion.listarEstadoaplicarresolucion();

    }

    @WebMethod
    public List listarPaginacionEstadoaplicarresolucion(int pag, int numReg) {

        return gestionEstadoaplicarresolucion.listarEstadoaplicarresolucion(pag, numReg);

    }

    @WebMethod
    public int contarBusquedaEstadoaplicarresolucion(Estadoaplicarresolucion obj) {

        return gestionEstadoaplicarresolucion.contarBusquedaEstadoaplicarresolucion(obj);

    }

    @WebMethod
    public boolean eliminarEstadoaplicarresolucion(Estadoaplicarresolucion obj) {

        return gestionEstadoaplicarresolucion.eliminarEstadoaplicarresolucion(obj);

    }

    //*******************************************************

    @WebMethod
    public List getAgentes(AgenteComp agente) {
        return gestionServiciosGeneralesComp.getAgentes(agente);
    }

    @WebMethod
    public List buscarAgentes(AgenteComp agente) {
        return gestionServiciosGeneralesComp.buscarAgentes(agente);
    }

    @WebMethod
    public InfractorComp buscarInfractor(InfractorComp myInfrac) {
        return gestionServiciosGeneralesComp.getInfractor(myInfrac);
    }

    @WebMethod
    public List listarInfractorComp() {
        return gestionServiciosGeneralesComp.listarInfractorComp();
    }

    @WebMethod
    public int crearInfractorComp(InfractorComp infractorComp, int idUsuario, String myIp, String myHost) {
        return gestionServiciosGeneralesComp.crearInfractor(infractorComp, idUsuario, myIp, myHost);
    }

    @WebMethod
    public boolean actualizarInfractorComp(InfractorComp infractorComp, int idUsuario, String myIp, String myHost) {
        return gestionServiciosGeneralesComp.actualizarInfractor(infractorComp, idUsuario, myIp, myHost);
    }

    @WebMethod
    public boolean eliminarInfractorComp(InfractorComp infractorComp, int idUsuario, String myIp, String myHost) {
        return gestionServiciosGeneralesComp.eliminarInfractor(infractorComp, idUsuario, myIp, myHost);
    }

    @WebMethod
    public int crearPropietarioVehiculo(PropietarioVehComp propietarioVehComp) {
        return gestionServiciosGeneralesComp.crearPropietarioVehiculo(propietarioVehComp);
    }

    @WebMethod
    public boolean actualizarPropietarioVehiculo(PropietarioVehComp propietarioVehComp, int idUsuario, String myIp,
                                                 String myHost) {
        return gestionServiciosGeneralesComp.actualizarPropietarioVehiculo(propietarioVehComp, idUsuario, myIp,
                                                                           myHost);
    }

    @WebMethod
    public boolean eliminarPropietarioVehiculo(PropietarioVehComp propietarioVehComp, int idUsuario, String myIp,
                                               String myHost) {
        return gestionServiciosGeneralesComp.eliminarPropietarioVehiculo(propietarioVehComp, idUsuario, myIp, myHost);
    }

    @WebMethod
    public PropietarioVehComp searchPropietarioVehiculo(PropietarioVehComp propietarioVehComp) {
        return gestionServiciosGeneralesComp.getPropietarioVehiculo(propietarioVehComp);
    }

    @WebMethod
    public int crearVehiculoComp(VehiculosComp vehiculoComp, int idUsuario, String myIp, String myHost) {
        return gestionServiciosGeneralesComp.crearVehiculoComp(vehiculoComp, idUsuario, myIp, myHost);
    }

    @WebMethod
    public boolean actualizarVehiculoComp(VehiculosComp vehiculoComp, int idUsuario, String myIp, String myHost) {
        return gestionServiciosGeneralesComp.actualizarVehiculoComp(vehiculoComp, idUsuario, myIp, myHost);
    }

    @WebMethod
    public boolean eliminarVehiculoComp(VehiculosComp vehiculoComp, int idUsuario, String myIp, String myHost) {
        return gestionServiciosGeneralesComp.eliminarVehiculoComp(vehiculoComp, idUsuario, myIp, myHost);
    }

    @WebMethod
    public VehiculosComp getFirstVehiculoComp(VehiculosComp vehiculoComp) {
        return gestionServiciosGeneralesComp.getFirstVehiculoComp(vehiculoComp);
    }

    @WebMethod
    public List getVehiculoComp(VehiculosComp vehiculoComp) {
        return gestionServiciosGeneralesComp.getVehiculoComp(vehiculoComp);
    }

    @WebMethod
    public List listarVehiculoComp() {
        return gestionServiciosGeneralesComp.ListarVehiculoComp();
    }

    @WebMethod
    public int crearTestigo(TestigoComp testigoComp) {
        return gestionServiciosGeneralesComp.crearTestigoComp(testigoComp);
    }

    @WebMethod
    public boolean actualizarTestigo(TestigoComp testigoComp) {
        return gestionServiciosGeneralesComp.actualizarTestigoComp(testigoComp);
    }

    @WebMethod
    public boolean eliminarTestigo(TestigoComp testigoComp) {
        return gestionServiciosGeneralesComp.eliminarTestigoComp(testigoComp);
    }

    @WebMethod
    public TestigoComp getTestigo(TestigoComp testigoComp) {
        return gestionServiciosGeneralesComp.getTestigoComp(testigoComp);
    }

    @WebMethod
    public boolean crearAgenteTto(AgenteComp agenteComp) {
        return gestionServiciosGeneralesComp.crearAgenteTto(agenteComp);
    }

    @WebMethod
    public boolean actualizarAgenteTto(AgenteComp agenteComp) {
        return gestionServiciosGeneralesComp.actualizarAgenteTto(agenteComp);
    }

    @WebMethod
    public boolean eliminarAgenteTto(AgenteComp agenteComp) {
        return gestionServiciosGeneralesComp.eliminarAgenteTto(agenteComp);
    }

    @WebMethod
    public int crearComparendo(ComparendoComp comparendo, int idUsuario, String myIp, String myHost) {
        return gestionServiciosGeneralesComp.crearComparendo(comparendo, idUsuario, myIp, myHost);
    }

    @WebMethod
    public boolean actualizarComparendo(ComparendoComp comparendo, int idUsuario, String myIp, String myHost) {
        return gestionServiciosGeneralesComp.actualizarComparendo(comparendo, idUsuario, myIp, myHost);
    }

    @WebMethod
    public List getComparendo() {
        return gestionServiciosGeneralesComp.getComparendo();
    }

    @WebMethod
    public List searchComparendo(ComparendoComp comparendo) {
        return gestionServiciosGeneralesComp.searchComparendo(comparendo);
    }

    @WebMethod
    public ComparendoComp searchOneComparendo(ComparendoComp comparendo) {
        return gestionServiciosGeneralesComp.searchOneComparendo(comparendo);
    }

    @WebMethod
    public boolean eliminarComparendo(ComparendoComp comparendo, int idUsuario, String myIp, String myHost){
        return gestionServiciosGeneralesComp.eliminarComparendo(comparendo, idUsuario, myIp, myHost);
    }


    @WebMethod
    public String getNITTransito() {
        return gestionServiciosGeneralesComp.getNITTransito();
    }

    @WebMethod
    public String getPrefijoPol() {
        return gestionServiciosGeneralesComp.getPrefijoPol();
    }

    @WebMethod
    public boolean crearInfraccionComparendo(InfracionComparendoComp infraccionComparendo, int idUsuario, String myIp,
                                             String myHost) {
        return gestionServiciosGeneralesComp.crearInfraccionComparendo(infraccionComparendo, idUsuario, myIp, myHost);
    }
    
    @WebMethod
    public boolean crearInfraccionComparendoDesdePlanos(InfracionComparendoComp infraccionComparendo, int idUsuario, String myIp,
                                             String myHost) {
        return gestionServiciosGeneralesComp.crearInfraccionComparendoDesdePlanos(infraccionComparendo, idUsuario, myIp, myHost);
    }

    @WebMethod
    public boolean actualizarInfraccionComparendo(InfracionComparendoComp infraccionComparendo, int idUsuario,
                                                  String myIp, String myHost) {
        return gestionServiciosGeneralesComp.actualizarInfraccionComparendo(infraccionComparendo, idUsuario, myIp,
                                                                            myHost);
    }

    @WebMethod
    public boolean eliminarInfraccionComparendo(InfracionComparendoComp infraccionComparendo, int idUsuario,
                                                String myIp, String myHost) {
        return gestionServiciosGeneralesComp.eliminarInfraccionComparendo(infraccionComparendo, idUsuario, myIp,
                                                                          myHost);
    }

    @WebMethod
    public InfracionComparendoComp getInfraccionComparendo(InfracionComparendoComp infraccionComparendo) {
        return gestionServiciosGeneralesComp.getInfraccionComparendo(infraccionComparendo);
    }

    @WebMethod
    public List getInfraccionComparendos(InfracionComparendoComp infraccionComparendo) {
        return gestionServiciosGeneralesComp.getInfraccionComparendos(infraccionComparendo);
    }

    @WebMethod
    public List obtenerComparendosResolSancion(ViewComparendosResolSancionComp myCompaResolSanc) {
        return gestionServiciosGeneralesComp.getViewComparendosResolSancion(myCompaResolSanc);
    }
    
    
    
    @WebMethod
    public List buscarComparendosEnRangoFecha(String fechaIni, String fechaFin, ViewComparendosResolSancionComp myCompaResolSanc, String tipoEstado) {
        return gestionServiciosGeneralesComp.buscarComparendosEnRangoFecha(fechaIni, fechaFin, myCompaResolSanc, tipoEstado);
    }
    
    @WebMethod
    public List buscarComparendosFechaDiasHabiles(String fechaIni, int diasHabilesIni,int diasHabilesFin, ViewComparendosResolSancionComp myCompaResolSanc, String tipoEstado) {
        
        int year = Integer.valueOf(fechaIni.substring(6,10));
        int month = Integer.valueOf(fechaIni.substring(0,2));
        int day = Integer.valueOf(fechaIni.substring(3,5));
        Calendar fecha = Calendar.getInstance();
        fecha.set(year,month,day);
        
        return gestionServiciosGeneralesComp.buscarComparendosPorRangoFechaMasDiasHabiles(fecha, diasHabilesIni, diasHabilesFin, myCompaResolSanc, tipoEstado);
    }
    
    @WebMethod
    public List buscarComparendosFechaHC(String fechaIni, int diasCalendarioIni, int diasCalendarioFin, ViewComparendosResolSancionComp myCompaResolSanc, String tipoEstado, String tipoDias, String porcDesc) {
        
        int year = Integer.valueOf(fechaIni.substring(6,10));
        int month = Integer.valueOf(fechaIni.substring(0,2));
        int day = Integer.valueOf(fechaIni.substring(3,5));
        
        Calendar fecha = Calendar.getInstance();
        fecha.set(year,month,day);
        
        if(tipoDias.equals("C"))
            return gestionServiciosGeneralesComp.buscarComparendosPorFechaMasDiasCalendarioPorcDesc(fecha, diasCalendarioIni, diasCalendarioFin, myCompaResolSanc, tipoEstado, porcDesc);
        else if(tipoDias.equals("H"))
            return gestionServiciosGeneralesComp.buscarComparendosPorRangoFechaMasDiasHabilesPorcDesc(fecha, diasCalendarioIni, diasCalendarioFin, myCompaResolSanc, tipoEstado, porcDesc);
        else 
            return null;
    }
    
    @WebMethod
    public List buscarComparendosFechaDiasCalendario(String fechaIni, int diasCalendarioIni, int diasCalendarioFin, ViewComparendosResolSancionComp myCompaResolSanc, String tipoEstado) {
        
        int year = Integer.valueOf(fechaIni.substring(6,10));
        int month = Integer.valueOf(fechaIni.substring(0,2));
        int day = Integer.valueOf(fechaIni.substring(3,5));
        
        Calendar fecha = Calendar.getInstance();
        fecha.set(year,month,day);
                
        return gestionServiciosGeneralesComp.buscarComparendosPorFechaMasDiasCalendario(fecha, diasCalendarioIni, diasCalendarioFin, myCompaResolSanc, tipoEstado);
    }

    @WebMethod
    public void insertarHistoricoEstadosComp(HistoricoEstadosComp myHistEstado) {
        gestionServiciosGeneralesComp.crearHistoricoEstadoComparendo(myHistEstado);
    }

    @WebMethod
    public void cambiarEstadoComp(InfracionComparendoComp myInfracComp, int idUsuario, String myIp, String myHost) {
        gestionServiciosGeneralesComp.cambiarEstadoComparendo(myInfracComp, idUsuario, myIp, myHost);
    }

    @WebMethod
    public void cambiarCodigoComp(InfracionComparendoComp myInfracComp) {
        gestionServiciosGeneralesComp.cambiarCodigoComparendo(myInfracComp);
    }

    @WebMethod
    public String obtenerEstadosResolSancion() {
        return gestionServiciosGeneralesComp.getEstadosResolSancion();
    }

    @WebMethod
    public String obtenerEstadosResolPrescripcion() {
        return gestionServiciosGeneralesComp.getEstadosResolPrescripcion();
    }

    @WebMethod
    public String obtenerEstadosResolFalleceCambCodigo() {
        return gestionServiciosGeneralesComp.getEstadosResolFalleceCambCodigo();
    }

    @WebMethod
    public AgenteComp getOneAgente(AgenteComp agente) {
        return gestionServiciosGeneralesComp.getOneAgente(agente);
    }

    @WebMethod
    public String obtenerEstadosResolExoneracion() {
        return gestionServiciosGeneralesComp.getEstadosResolExoneracion();
    }
    
    @WebMethod
    public String obtenerEstadosResolRevocatoria() {
        return gestionServiciosGeneralesComp.getEstadosResolRevocatoria();
    }

    @WebMethod
    public ResolucionesSimit getResolucionSimit(ResolucionesSimit resolucionesSimit) {
        return gestionServiciosGeneralesComp.getResolucionSimit(resolucionesSimit);
    }

    @WebMethod
    public boolean crearResolucionSimit(ResolucionesSimit resolucionesSimit, int idUsuario, String myIp,
                                        String myHost) {
        return gestionServiciosGeneralesComp.crearResolucionSimit(resolucionesSimit, idUsuario, myIp, myHost);
    }

    @WebMethod
    public boolean actualizarResolucionesSimit(ResolucionesSimit resolucionesSimit, int idUsuario, String myIp,
                                               String myHost) {
        return gestionServiciosGeneralesComp.actualizarResolucionesSimit(resolucionesSimit, idUsuario, myIp, myHost);
    }

    @WebMethod
    public EstadoAlcoholemia getFechaSuspension(EstadoAlcoholemia estadoAlcoholemia, Integer Valor) {
        return gestionServiciosGeneralesComp.getFechaSuspension(estadoAlcoholemia, Valor);
    }

    @WebMethod
    public boolean crearTransitoComp(TransitoComp transito) {
        return gestionServiciosGeneralesComp.crearTransitoComp(transito);
    }

    @WebMethod
    public TransitoComp getTransitoComp(TransitoComp transito) {
        return gestionServiciosGeneralesComp.getTransitoComp(transito);
    }

    @WebMethod
    public boolean guardarTransitoComp(TransitoComp transito) {
        return gestionServiciosGeneralesComp.guardarTransitoComp(transito);
    }

    @WebMethod
    public String getNitTransitoComp() {
        return gestionServiciosGeneralesComp.getNITTransito();
    }

    @WebMethod
    public int getCiudadTransitoComp() {
        return gestionServiciosGeneralesComp.getCiudadTransitoComp();
    }

    @WebMethod
    public List getOrigenDescargo(OrigenDescargo obj) {
        return gestionServiciosGeneralesComp.getOrigenDescargoComp(obj);
    }

    @WebMethod
    public List listarOrigenDescargo() {
        return gestionServiciosGeneralesComp.listarOrigenDescargoComp();
    }

    @WebMethod
    public List getTipoPago(TipoPago obj) {
        return gestionServiciosGeneralesComp.getTipoPagoComp(obj);
    }

    @WebMethod
    public List listarTipoPago() {
        return gestionServiciosGeneralesComp.listarTipoPagoComp();
    }

    @WebMethod
    public List getTarjetasCredito(TarjetasCredito obj) {
        return gestionServiciosGeneralesComp.getTarjetasCredito(obj);
    }

    @WebMethod
    public List listarTarjetasCredito() {
        return gestionServiciosGeneralesComp.listarTarjetasCredito();
    }

    @WebMethod
    public List getBanco(Banco obj) {
        return gestionServiciosGeneralesComp.getBanco(obj);
    }

    @WebMethod
    public List listarBanco() {
        return gestionServiciosGeneralesComp.listarBanco();
    }

    @WebMethod
    public List getFormaPago(FormaPago obj) {
        return gestionServiciosGeneralesComp.getFormaPago(obj);
    }

    @WebMethod
    public List listarFormaPago() {
        return gestionServiciosGeneralesComp.listarFormaPago();
    }

    @WebMethod
    public FormaPago crearFormaPago(FormaPago obj) {
        return gestionServiciosGeneralesComp.crearFormaPago(obj);
    }

    @WebMethod
    public boolean editarFormaPago(FormaPago obj) {
        return gestionServiciosGeneralesComp.editarFormaPago(obj);
    }

    @WebMethod
    public boolean eliminarFormaPago(FormaPago obj, int idUsuario, String myIp, String myHost) {
        return gestionServiciosGeneralesComp.eliminarFormaPago(obj, idUsuario, myIp, myHost);
    }

    @WebMethod
    public List getViewLiquiComprendo(ViewLiquidacionComparendo obj) {
        return gestionServiciosGeneralesComp.getViewLiquiComparendo(obj);
    }

    @WebMethod
    public List getInfractoresComparendo(@WebParam(name = "fechaIni")
        Date fechaIni, @WebParam(name = "fechaFin")
        Date fechaFin) {
        System.out.println(" Antes de llamar Ingractores comparendo " + fechaIni + " " + fechaFin);
        return gestionServiciosGeneralesComp.getInfractoresComparendo(fechaIni, fechaFin);
    }
    
    @WebMethod
    public List getInfractoresComparendoPorFecha(@WebParam(name = "fechaIni")
        String fechaIni, @WebParam(name = "fechaFin")
        String fechaFin) {
        return gestionServiciosGeneralesComp.getInfractoresComparendoPorFecha(fechaIni, fechaFin);
    }

    @WebMethod
    public InfractorComp getInfractor(InfractorComp infractor) {
        return gestionServiciosGeneralesComp.getInfractor(infractor);
    }

    //**************** METODOS PARA NUEVA LOGICA DE HISTORIAL COMPARENDOS   *******************
    //*****************************************************************************************
    //*****************************************************************************************

    //DOCSRESOLUCIONES

    @WebMethod
    public Docsresoluciones crearDocsresoluciones(Docsresoluciones obj) {
        return gestionServiciosDocumentos.crearDocsresoluciones(obj);
    }

    @WebMethod
    public boolean editarDocsresoluciones(Docsresoluciones obj) {
        return gestionServiciosDocumentos.editarDocsresoluciones(obj);
    }

    @WebMethod
    public List buscarDocsresoluciones(Docsresoluciones obj) {
        return gestionServiciosDocumentos.buscarDocsresoluciones(obj);
    }

    @WebMethod
    public List listarDocsresoluciones() {
        return gestionServiciosDocumentos.listarDocsresoluciones();
    }

    @WebMethod
    public boolean eliminarDocsresoluciones(Docsresoluciones obj) {
        return gestionServiciosDocumentos.eliminarDocsresoluciones(obj);
    }

    // TIPODOCGENERAR

    @WebMethod
    public Tipodocgenerar crearTipodocgenerar(Tipodocgenerar obj) {
        return gestionServiciosDocumentos.crearTipodocgenerar(obj);
    }

    @WebMethod
    public boolean editarTipodocgenerar(Tipodocgenerar obj) {
        return gestionServiciosDocumentos.editarTipodocgenerar(obj);
    }

    @WebMethod
    public List buscarTipodocgenerar(Tipodocgenerar obj) {
        return gestionServiciosDocumentos.buscarTipodocgenerar(obj);
    }

    @WebMethod
    public List listarTipodocgenerar() {
        return gestionServiciosDocumentos.listarTipodocgenerar();
    }

    @WebMethod
    public boolean eliminarTipodocgenerar(Tipodocgenerar obj) {
        return gestionServiciosDocumentos.eliminarTipodocgenerar(obj);
    }

    //HISTORIAL COMPARENDO

    @WebMethod
    public Historialcomparendo crearHistorialcomparendo(Historialcomparendo obj) {
        return gestionHistorialcomparendo.crearHistorialcomparendo(obj);
    }

    @WebMethod
    public boolean editarHistorialcomparendo(Historialcomparendo obj) {
        return gestionHistorialcomparendo.editarHistorialcomparendo(obj);
    }

    @WebMethod
    public List buscarHistorialcomparendo(Historialcomparendo obj) {
        return gestionHistorialcomparendo.buscarHistorialcomparendo(obj);
    }

    @WebMethod
    public List listarHistorialcomparendo() {
        return gestionHistorialcomparendo.listarHistorialcomparendo();
    }

    @WebMethod
    public boolean eliminarHistorialcomparendo(Historialcomparendo obj) {
        return gestionHistorialcomparendo.eliminarHistorialcomparendo(obj);
    }

    //PASOS

    @WebMethod
    public Pasos crearPasos(Pasos obj) {
        return gestionServiciosGeneralesComp.crearPasos(obj);
    }

    @WebMethod
    public boolean editarPasos(Pasos obj) {
        return gestionServiciosGeneralesComp.editarPasos(obj);
    }

    @WebMethod
    public List buscarPasos(Pasos obj) {
        return gestionServiciosGeneralesComp.buscarPasos(obj);
    }

    @WebMethod
    public List listarPasos() {
        return gestionServiciosGeneralesComp.listarPasos();
    }

    @WebMethod
    public boolean eliminarPasos(Pasos obj) {
        return gestionServiciosGeneralesComp.eliminarPasos(obj);
    }

    // PROCESOS

    @WebMethod
    public Procesos crearProcesos(Procesos obj) {
        return gestionServiciosGeneralesComp.crearProcesos(obj);
    }

    @WebMethod
    public boolean editarProcesos(Procesos obj) {
        return gestionServiciosGeneralesComp.editarProcesos(obj);
    }

    @WebMethod
    public List buscarProcesos(Procesos obj) {
        return gestionServiciosGeneralesComp.buscarProcesos(obj);
    }

    @WebMethod
    public List listarProcesos() {
        return gestionServiciosGeneralesComp.listarProcesos();
    }

    @WebMethod
    public boolean eliminarProcesos(Procesos obj) {
        return gestionServiciosGeneralesComp.eliminarProcesos(obj);
    }

    // SECUENCIAPROCESOS

    @WebMethod
    public Secuenciaprocesos crearSecuenciaprocesos(Secuenciaprocesos obj) {
        return gestionServiciosGeneralesComp.crearSecuenciaprocesos(obj);
    }

    @WebMethod
    public boolean editarSecuenciaprocesos(Secuenciaprocesos obj) {
        return gestionServiciosGeneralesComp.editarSecuenciaprocesos(obj);
    }

    @WebMethod
    public List buscarSecuenciaprocesos(Secuenciaprocesos obj) {
        return gestionServiciosGeneralesComp.buscarSecuenciaprocesos(obj);
    }

    @WebMethod
    public List listarSecuenciaprocesos() {
        return gestionServiciosGeneralesComp.listarSecuenciaprocesos();
    }

    @WebMethod
    public boolean eliminarSecuenciaprocesos(Secuenciaprocesos obj) {
        return gestionServiciosGeneralesComp.eliminarSecuenciaprocesos(obj);
    }
        //**************** FIN METODOS PARA NUEVA LOGICA DE HISTORIAL COMPARENDOS   ***************
    
    @WebMethod
    public List obtenerDiasFestivos(Diasfestivos obj){
        return gestionServiciosGeneralesComp.getDiasFestivos(obj);
    }
}
