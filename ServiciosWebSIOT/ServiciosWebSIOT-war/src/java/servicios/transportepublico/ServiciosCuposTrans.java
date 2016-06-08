package servicios.transportepublico;

import java.util.List;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;

import modelo.datos.objetos.transportepublico.cupos.CuposTaxisTrans;
import modelo.datos.objetos.transportepublico.cupos.DetalleRangoCupoTrans;
import modelo.datos.objetos.transportepublico.cupos.EmpresasdeServicioTrans;
import modelo.datos.objetos.transportepublico.cupos.HistoricoCupoTrans;
import modelo.datos.objetos.transportepublico.cupos.InventarioCuposTrans;
import modelo.datos.objetos.transportepublico.cupos.RangoCuposVehiculoPublicoTrans;
import modelo.datos.objetos.transportepublico.cupos.TipoVehiculoTrans;
import modelo.datos.objetos.transportepublico.cupos.ViewCupos;
import modelo.datos.objetos.transportepublico.cupos.ViewPropietariosCupoTrans;
import modelo.datos.objetos.transportepublico.cupos.ViewTarjetasCupoTrans;
import modelo.datos.objetos.transportepublico.cupos.ViewVehiculosActivosEmpresa;
import modelo.datos.objetos.transportepublico.cupos.ViewVidaUtilVehiculoTrans;
import modelo.datos.objetos.transportepublico.cupos.Viewinventariocupos;
import modelo.datos.objetos.transportepublico.tramites.ViewDatosCupoTrans;
import modelo.datos.objetos.transportepublico.tramites.ViewResoluciones;
import modelo.datos.objetos.transportepublico.cupos.Viewinventariorangos;

import modelo.logica.transportepublico.GestionServiciosCuposTrans;


@WebService
public class ServiciosCuposTrans {

    GestionServiciosCuposTrans gestionServiciosCuposTrans;

    public ServiciosCuposTrans() {
        super();
        crearObjetos();
    }

    @Oneway
    @WebMethod
    public void crearObjetos() {
        gestionServiciosCuposTrans = new GestionServiciosCuposTrans();
    }

    @WebMethod
    public List getTEmpresasServicio(EmpresasdeServicioTrans empresasdeserviciotrans) {
        return gestionServiciosCuposTrans.getTEmpresasServicio(empresasdeserviciotrans);
    }

    @WebMethod
    public List getEmpresaServicio(EmpresasdeServicioTrans empresasdeserviciotrans) {
        return gestionServiciosCuposTrans.getEmpresaServicio(empresasdeserviciotrans);
    }

    @WebMethod
    public List getTipoVehiculoTrans(TipoVehiculoTrans tipovehiculotrans) {
        return gestionServiciosCuposTrans.getTipoVehiculoTrans(tipovehiculotrans);
    }

    @WebMethod
    public List buscarTipoVehiculoTrans(TipoVehiculoTrans tipovehiculotrans) {
        return gestionServiciosCuposTrans.buscarTipoVehiculoTrans(tipovehiculotrans);
    }

    @WebMethod
    public List getSTipoVehiculoTrans(TipoVehiculoTrans tipovehiculotrans) {
        return gestionServiciosCuposTrans.getSTipoVehiculoTrans(tipovehiculotrans);
    }

    @WebMethod
    public TipoVehiculoTrans getTipoVehiculoTransPorId(TipoVehiculoTrans tipovehiculotrans) {
        return gestionServiciosCuposTrans.getTipoVehiculoTransPorId(tipovehiculotrans);
    }

    @WebMethod
    public List getDiferentesTaxis() {
        return gestionServiciosCuposTrans.getDiferentesTaxis();
    }

    @WebMethod
    public List getSInventarioCupos(InventarioCuposTrans inventariocupos) {
        return gestionServiciosCuposTrans.getSInventarioCupos(inventariocupos);
    }

    @WebMethod
    public boolean validarRangoInventarioCupoEmpresa(int rangoInicial, int rangoFinal, int idTipoVehiculo){
        
        boolean res = false;
        
        res = gestionServiciosCuposTrans.validarRangoInventarioCupoEmpresa(rangoInicial, rangoFinal, idTipoVehiculo);
                                                                                                                                
        return res;                                                                                                                                                                                                                                  
    }
    
    @WebMethod
    public List getSInventarioCuposEmpresa(DetalleRangoCupoTrans detallerangocupo) {
        return gestionServiciosCuposTrans.getSInventarioCuposEmpresa(detallerangocupo);
    }

    @WebMethod
    public List getSRangoCuposVehiculo(RangoCuposVehiculoPublicoTrans rangocuposvehiculo) {
        return gestionServiciosCuposTrans.getSRangoCuposVehiculo(rangocuposvehiculo);
    }

    @WebMethod
    public boolean crearCupos(InventarioCuposTrans inventariocupos) {
        return gestionServiciosCuposTrans.crearCupos(inventariocupos);
    }

    @WebMethod
    public int crearCuposEmpresa(RangoCuposVehiculoPublicoTrans rangocuposvehiculo) {
        return gestionServiciosCuposTrans.crearCuposEmpresa(rangocuposvehiculo);
    }

    @WebMethod
    public boolean crearDetalleCuposEmpresa(DetalleRangoCupoTrans detallerangocupo) {
        return gestionServiciosCuposTrans.crearDetalleCuposEmpresa(detallerangocupo);
    }

    @WebMethod
    public boolean editarCupos(InventarioCuposTrans inventariocupos) {
        return gestionServiciosCuposTrans.editarCupos(inventariocupos);
    }

    @WebMethod
    public List getSCupos(CuposTaxisTrans cupostaxistrans) {
        return gestionServiciosCuposTrans.getSCupos(cupostaxistrans);
    }

    @WebMethod
    public List getSCuposAsignados(CuposTaxisTrans cupostaxistrans) {
        return gestionServiciosCuposTrans.getSCuposAsignados(cupostaxistrans);
    }

    @WebMethod
    public CuposTaxisTrans getCuposTaxisTransPorId(CuposTaxisTrans cupostaxistrans) {
        return gestionServiciosCuposTrans.getCuposTaxisTransPorId(cupostaxistrans);
    }

    @WebMethod
    public List getTCupos() {
        return gestionServiciosCuposTrans.getTCupos();
    }

    @WebMethod
    public int crearCuposTaxis(CuposTaxisTrans cupostaxis) {
        return gestionServiciosCuposTrans.crearCuposTaxis(cupostaxis);
    }

    @WebMethod
    public boolean editarCuposTaxis(CuposTaxisTrans cupostaxis) {
        return gestionServiciosCuposTrans.editarCuposTaxis(cupostaxis);
    }

    @WebMethod
    public boolean cambiarEmpresaCuposTaxis(CuposTaxisTrans cupostaxis) {
        return gestionServiciosCuposTrans.cambiarEmpresaCuposTaxis(cupostaxis);
    }

    @WebMethod
    public boolean editarDetalleRangoCupos(DetalleRangoCupoTrans detallerangocupo) {
        return gestionServiciosCuposTrans.editarDetalleRangoCupos(detallerangocupo);
    }

    @WebMethod
    public List getDetalleRangoCupos(DetalleRangoCupoTrans detallerangocupo) {
        return gestionServiciosCuposTrans.getDetalleRangoCupos(detallerangocupo);
    }

    @WebMethod
    public List getSVehiculosActivosEmpresa(ViewVehiculosActivosEmpresa viewvehiculosactivos) {
        return gestionServiciosCuposTrans.getSVehiculosActivosEmpresa(viewvehiculosactivos);
    }

    @WebMethod
    public boolean crearHistoricoCuposTaxis(HistoricoCupoTrans historicocupotrans) {
        return gestionServiciosCuposTrans.crearHistoricoCuposTaxis(historicocupotrans);
    }

    @WebMethod
    public List getSHistoricoCuposTaxis(HistoricoCupoTrans historicocupotrans) {
        return gestionServiciosCuposTrans.getSHistoricoCuposTaxis(historicocupotrans);
    }

    @WebMethod
    public List getSViewCupos(ViewCupos viewcupos) {
        return gestionServiciosCuposTrans.getSViewCupos(viewcupos);
    }

    @WebMethod
    public List getSViewResoluciones(ViewResoluciones viewresoluciones) {
        return gestionServiciosCuposTrans.getSViewResoluciones(viewresoluciones);
    }

    @WebMethod
    public List getSViewDatosCupo(ViewDatosCupoTrans viewdatoscupotrans) {
        return gestionServiciosCuposTrans.getSViewDatosCupo(viewdatoscupotrans);
    }

    @WebMethod
    public List getSViewPropietariosCupo(ViewPropietariosCupoTrans viewpropietarioscupotrans) {
        return gestionServiciosCuposTrans.getSViewPropietariosCupo(viewpropietarioscupotrans);
    }

    @WebMethod
    public List getSViewTarjetasCupo(ViewTarjetasCupoTrans viewtarjetascupotrans) {
        return gestionServiciosCuposTrans.getSViewTarjetasCupo(viewtarjetascupotrans);
    }

    @WebMethod
    public List getSViewVidaUtilVehiculo(ViewVidaUtilVehiculoTrans viewvidautilvehiculotrans) {
        return gestionServiciosCuposTrans.getSViewVidaUtilVehiculo(viewvidautilvehiculotrans);
    }

    @WebMethod
    public CuposTaxisTrans getOneCuposTaxis(CuposTaxisTrans cupostaxistrans) {
        return gestionServiciosCuposTrans.getOneCuposTaxis(cupostaxistrans);
    }

    @WebMethod
    public EmpresasdeServicioTrans crearEmpresasdeServicioTrans(EmpresasdeServicioTrans empresaserviciotrans) {
        return gestionServiciosCuposTrans.crearEmpresasdeServicioTrans(empresaserviciotrans);
    }

    @WebMethod
    public boolean editarEmpresasdeServicioTrans(EmpresasdeServicioTrans empresaserviciotrans) {
        return gestionServiciosCuposTrans.editarEmpresasdeServicioTrans(empresaserviciotrans);
    }

    @WebMethod
    public boolean eliminarEmpresasdeServicioTrans(EmpresasdeServicioTrans empresaserviciotrans) {
        return gestionServiciosCuposTrans.eliminarEmpresasdeServicioTrans(empresaserviciotrans);
    }

    @WebMethod
    public List getViewinventariorangos(Viewinventariorangos obj) {
        return gestionServiciosCuposTrans.getViewinventariorangos(obj);

    }

    @WebMethod
    public List getViewinventariocupos(Viewinventariocupos obj) {
        return gestionServiciosCuposTrans.getViewinventariocupos(obj);
    }

}
