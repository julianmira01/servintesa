package servicios.comparendos;

import java.util.List;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;


import modelo.datos.dao.comparendos.generales.PorcDescMoraTipoInfrDao;
import modelo.datos.dao.comparendos.generales.TipoInfraccionCompDao;
import modelo.datos.objetos.accesorias.Dependencia;
import modelo.datos.objetos.comparendos.accesorias.*;


import modelo.datos.objetos.comparendos.generales.PorcDescMoraTipoInfrComp;
import modelo.datos.objetos.comparendos.generales.TipoInfrInfraccionComp;
import modelo.datos.objetos.comparendos.generales.TipoInfraccionComp;

import modelo.logica.accesorias.GestionServiciosAccesoriasLocal;
import modelo.logica.comparendos.GestionServiciosAccesoriasComp;

import utilidades.Funciones;

@WebService
public class ServiciosAccesoriasComp_old {
    
    private GestionServiciosAccesoriasComp gestionServiciosAccesorias;
    private  GestionServiciosAccesoriasLocal gestionServiciosAccesoriasLocal;
    
    public ServiciosAccesoriasComp_old() {
        super();
        gestionServiciosAccesoriasLocal = new GestionServiciosAccesoriasLocal();
        gestionServiciosAccesorias = new GestionServiciosAccesoriasComp();
    }
    
    @WebMethod
    public List ListarDependencias() throws Exception {
        try{
        return gestionServiciosAccesoriasLocal.getDependencias(1); }catch(Exception e){throw new Exception(e.getMessage());} 
    }
      
    @WebMethod
    public List getDependencia(Dependencia myDependencia) throws Exception {
        try{
        return gestionServiciosAccesoriasLocal.getDependencia(myDependencia,1); }catch(Exception e){throw new Exception(e.getMessage());} 
    }
    
    @WebMethod
    public List obtenerTipoDocumento(DocumentoComp myDoc)
    {
        return gestionServiciosAccesorias.getTipoDocumento(myDoc);
    }
    
    @WebMethod
    public List obtenerTiposDocumento()
    {
        return gestionServiciosAccesorias.listarTiposDocumento();
    }
    
    @WebMethod
    public List ListarClaseVehiculo(){
      return gestionServiciosAccesorias.listarClaseVehiculo();
    }
    
    @WebMethod
    public List getClaseVehiculo(ClaseVehiculoComp claseVehiculoComp){
      return gestionServiciosAccesorias.getClaseVehiculo(claseVehiculoComp);
    }
    
    @WebMethod
    public String getDescClaseVehiculo(int idclase){
      return gestionServiciosAccesorias.getClaseVehiculo(idclase);
    }
    
    @WebMethod
    public List ListarTipoServicioComp(){
      return gestionServiciosAccesorias.listarTipoServicioComp();
    }
    
    @WebMethod
    public List getTipoServicioComp(ServicioComp servicioComp){
      return gestionServiciosAccesorias.getTipoServicioComp(servicioComp);
    }
    
    @WebMethod
    public String getDescTipoServicioComp(int idServicio){
      return gestionServiciosAccesorias.getTipoServicioComp(idServicio);
    }
  
    @WebMethod
    public List ListarOrganismoTransitoComp(){
      return gestionServiciosAccesorias.listarOrganismoTransitoComp();
    }
    
    @WebMethod
    public List getOrganismoTransitoComp(OrganismoTransitoComp organismo){
      return gestionServiciosAccesorias.getOrganismoTransitoComp(organismo);
    }
    
    @WebMethod
    public List listarEmpresaComp(){
      return gestionServiciosAccesorias.listarEmpresasComp();
    }
    
    @WebMethod 
    public List getEmpresaComp(EmpresaComp empresaComp){
      return gestionServiciosAccesorias.getEmpresasComp(empresaComp);
    }
    
    @WebMethod 
    public String getDescEmpresaComp(int idEmpresa){
      return gestionServiciosAccesorias.getEmpresasComp(idEmpresa);
    }
    
    @WebMethod
    public List listarRadioAccionComp(){
      return gestionServiciosAccesorias.listarRadioAccionComp();
    }
    
    @WebMethod
    public List getRadioAccionComp(RadioDeAccionComp radioAccionComp){
      return gestionServiciosAccesorias.getRadioAccionComp(radioAccionComp);
    }
    
    @WebMethod
    public String getDescRadioAccionComp(int idRadioAccion){
      return gestionServiciosAccesorias.getRadioAccionComp(idRadioAccion);
    }
  
    @WebMethod
    public List listarModalidadTransComp(){
      return gestionServiciosAccesorias.listarModalidadTransComp();
    }
    
    @WebMethod 
    public List getModalidadTransComp(ModalidadComp modalidadComp){
      return gestionServiciosAccesorias.getModalidadTransComp(modalidadComp);
    }
    
    @WebMethod
    public List listarTransPasajeros(){
      return gestionServiciosAccesorias.listarTransPasajerosComp();
    }
    
    @WebMethod
    public List getTransPasajeros(TipoTransportePasajeroComp tipoTransporte){
      return gestionServiciosAccesorias.getTransPasajerosComp(tipoTransporte);
    }
    
    @WebMethod
    public List listarCategoriaLicTransComp(){
      return gestionServiciosAccesorias.listarCategoriaLicCondComp();
    }
    
    @WebMethod
    public List getCategoriaLicTransitoComp(CategoriaLicTransitoComp categoriaLicTransComp){
      return gestionServiciosAccesorias.getCategoriaLicCondComp(categoriaLicTransComp);
    }
    
    @WebMethod
    public List listarSexoComp(){
        return gestionServiciosAccesorias.listarSexoComp();
    }
    
    @WebMethod
    public List getSexoComp(SexoComp sexoComp){
      return gestionServiciosAccesorias.getSexoComp(sexoComp);
    }
    
    @WebMethod
    public List listarCiudadComp(){
      return gestionServiciosAccesorias.listarCiudadComp();
    }
    
    @WebMethod 
    public List getCiudadComp(CiudadComp ciudadComp){
      return gestionServiciosAccesorias.getCiudadComp(ciudadComp);
    }
    
    @WebMethod 
    public double getSalario(int annio){
      return gestionServiciosAccesorias.getSalario(annio);
    }
    
    @WebMethod
    public List listarTiposInfraccionesComp(){
      return gestionServiciosAccesorias.ListarTiposInfraccion();
    }
    
    @WebMethod
    public List listarTiposInfrInfraccionesComp(){
      return gestionServiciosAccesorias.ListarTiposInfrInfraccion();
    }
    
    @WebMethod
    public List listarInfraccionesComp(){
      return gestionServiciosAccesorias.ListarInfracciones();
    }

    @WebMethod
    public boolean crearInfraccionesComp(InfraccionesComp infraccionesComp)
    {
        return gestionServiciosAccesorias.crearInfraccionesComp(infraccionesComp);
    }
    
    @WebMethod
    public boolean crearTipoInfrInfraccionComp(TipoInfrInfraccionComp infraccionesComp)
    {
        return gestionServiciosAccesorias.crearTipoInfrInfraccionComp(infraccionesComp);
    }
    
   /* @WebMethod
    public boolean crearTipoInfraccionEstado(TipoInfraccioEstado infraccionesComp)
    {
        return gestionServiciosAccesorias.crearTipoInfraccionEstado(infraccionesComp);
    }*/
    
    @WebMethod
    public boolean crearPorcDescMoraTipoInfr(PorcDescMoraTipoInfrComp PorcDescMoraTipoInfr)
    {
        return gestionServiciosAccesorias.crearPorcDescMoraTipoInfr(PorcDescMoraTipoInfr);
    }
    
    @WebMethod
    public boolean editarInfraccionesComp(InfraccionesComp infraccionesComp)
    {
        return gestionServiciosAccesorias.editarInfraccionesComp(infraccionesComp);
    }
    
   /* @WebMethod
    public boolean editarTipoINfraccionEstado(TipoInfraccioEstado infraccionesComp)
    {
        return gestionServiciosAccesorias.editarTipoInfraccionesEstado(infraccionesComp);
    }*/
    
    @WebMethod
    public boolean editarTipoInfrInfraccionesComp(TipoInfrInfraccionComp infraccionesComp)
    {
        return gestionServiciosAccesorias.editarTipoInfrInfraccionComp(infraccionesComp);
    }
    
    @WebMethod
    public boolean editarTipoInfraccionesComp(TipoInfraccionComp infraccionesComp)
    {
        return gestionServiciosAccesorias.editarTipoInfraccionComp(infraccionesComp);
    }

    @WebMethod
    public boolean editarPorcDescMoraTipoInfr(PorcDescMoraTipoInfrComp porcDescMoraTipoInfr)
    {
        return gestionServiciosAccesorias.editarPorcDescMoraTipoInfr(porcDescMoraTipoInfr);
    }

    @WebMethod
    public boolean eliminarInfraccionesComp(InfraccionesComp infraccionesComp)
    {
        return gestionServiciosAccesorias.eliminarInfraccionesComp(infraccionesComp);
    }
    
    
   /* @WebMethod
    public boolean eliminarTipoInfraccionEstado(TipoInfraccioEstado infraccionesComp)
    {
        return gestionServiciosAccesorias.eliminarTipoInfraccionEstado(infraccionesComp);
    }*/
    
    @WebMethod
    public boolean eliminarTipoInfraccionesComp(TipoInfraccionComp infraccionesComp)
    {
        return gestionServiciosAccesorias.eliminarTipoInfraccionComp(infraccionesComp);
    }
    
    @WebMethod
    public boolean eliminarTipoInfrInfraccionesComp(TipoInfrInfraccionComp infraccionesComp)
    {
        return gestionServiciosAccesorias.eliminarTipoInfrInfraccionComp(infraccionesComp);
    }
    
    
    @WebMethod
    public boolean eliminarPorcDescMoraTipoInfr(PorcDescMoraTipoInfrComp porcDescMoraTipoInfr)
    {
        return gestionServiciosAccesorias.eliminarPorcDescMoraTipoInfr(porcDescMoraTipoInfr);
    }
    @WebMethod
    public InfraccionesComp getInfraccionComp(InfraccionesComp infraccionComp){
      return gestionServiciosAccesorias.getInfraccion(infraccionComp);
    }
    
    @WebMethod
    public List getTipoInfraccionesComp(TipoInfraccionComp tipoInfraccionComp){
      return gestionServiciosAccesorias.getTipoInfraccionComp(tipoInfraccionComp);
    }
   
    /*@WebMethod
    public List getTipoInfraccionEstado(TipoInfraccioEstado tipoInfraccionComp){
      return gestionServiciosAccesorias.getTipoInfraccionEstado(tipoInfraccionComp);
    }*/
   
    @WebMethod
    public List getTipoInfrInfraccionesComp(TipoInfrInfraccionComp tipoInfraccionComp){
      return gestionServiciosAccesorias.getTipoInfrInfraccionComp(tipoInfraccionComp);
    }
    
    @WebMethod
    public List getPorcDescMoraTipoInfr(PorcDescMoraTipoInfrComp porcDescMoraTipoInfrComp){
      return gestionServiciosAccesorias.getPorcDescMoraTipoInfr(porcDescMoraTipoInfrComp);
    }
    
   @WebMethod
   public List getTipoInfractorComp(TipoInfractorComp tipoInfractorComp){
     return gestionServiciosAccesorias.getTipoInfractorComp(tipoInfractorComp);
   }
   
   @WebMethod
   public List listarTipoInfractorComp(){
     return gestionServiciosAccesorias.listarTipoInfractorComp();
   }
   
   @WebMethod
   public String getCodTipoDoc(int id){
     return gestionServiciosAccesorias.getCodTipoDoc(id);
   }
   
   @WebMethod
   public String getNombreOrganismo(int id){
     return gestionServiciosAccesorias.getNombreOrganismoTransitoComp(id);
   }
   
   @WebMethod
   public List listarPatioInmovilizacion() {
     return gestionServiciosAccesorias.listarPatiosComp();
   }
   
   @WebMethod
   public boolean crearPatioInmovilizacion(PatiosInmovilizacionComp patioInmovilizacion){
       return gestionServiciosAccesorias.crearPatiosComp(patioInmovilizacion);
   }
   
    @WebMethod
    public boolean crearTipoInfraccionComp(TipoInfraccionComp tipoInfraccionNueva){
        return gestionServiciosAccesorias.crearTipoInfraccionComp(tipoInfraccionNueva);
    }
   
   @WebMethod 
   public boolean actualizarPatioInmovilizacion(PatiosInmovilizacionComp patioInmovilizacion){
       return gestionServiciosAccesorias.actualizarPatiosComp(patioInmovilizacion);
   }
   
   @WebMethod
   public boolean eliminarPatioInmovilizacion(PatiosInmovilizacionComp patioInmovilizacion){
       return gestionServiciosAccesorias.eliminarPatiosComp(patioInmovilizacion);
   }
   
   @WebMethod
   public String getDireccionPatio(int id){
     return gestionServiciosAccesorias.getDireccionPatiosComp(id);
   }
   
   @WebMethod
   public List listarEstadosComp(){
     return gestionServiciosAccesorias.listarEstadosComp();
   }
   
   @WebMethod
   public List searchEstadosComp(EstadoComp estadoComp){
     return gestionServiciosAccesorias.SearchEstadosComp(estadoComp);
   }
   
   /* @WebMethod
    public List consultarInfraccionesCompPorTipoInfraccion(TipoInfraccionComp tipoInfraccion){
      return gestionServiciosAccesorias.buscarInfraccionesPorTipoInfraccion(tipoInfraccion);
    }*/
    
    @WebMethod
    public EstadoComp searchOneEstadosComp(EstadoComp estadoComp){
    return gestionServiciosAccesorias.SearchOneEstadosComp(estadoComp);
  }
    
    public List listarDepartamentosComp(){
      return gestionServiciosAccesorias.listarDepartamentosComp();
    }
    
    public boolean crearDepartamentoComp(DepartamentoComp departamento){
      return gestionServiciosAccesorias.crearDepartamentosComp(departamento);
    }
    
    public boolean eliminarDepartamentoComp(DepartamentoComp departamento){
      return gestionServiciosAccesorias.eliminarDepartamentosComp(departamento);
    }
    
    public boolean actualizarDepartamentoComp(DepartamentoComp departamento){
      return gestionServiciosAccesorias.actualizarDepartamentosComp(departamento);
    }
    
    public boolean crearEmpresaComp(EmpresaComp empresaComp){
      return gestionServiciosAccesorias.crearEmpresasComp(empresaComp);
    }
    
    public boolean actualizarEmpresaComp(EmpresaComp empresaComp){
      return gestionServiciosAccesorias.actualizarEmpresasComp(empresaComp);
    }
    
    public boolean eliminarEmpresaComp(EmpresaComp empresaComp){
      return gestionServiciosAccesorias.eliminarEmpresasComp(empresaComp);
    }
    
    public DepartamentoComp getOneDepartamento(DepartamentoComp departamento){
      return gestionServiciosAccesorias.getOneDepartamentosComp(departamento);
    }
    
    public PatiosInmovilizacionComp getOnePatiosInmovilizacion(PatiosInmovilizacionComp patios){
      return gestionServiciosAccesorias.getOnePatiosComp(patios);
    }
    
    public String getFechaHora(String formato){
        return Funciones.getFechaSistema2(formato,null);
    }
}


