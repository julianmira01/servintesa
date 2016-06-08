package servicios.generales;

import java.util.List;

import javax.jws.WebService;

import modelo.datos.objetos.avaluos.Avaluo;
import modelo.datos.objetos.avaluos.AvaluoCarga;
import modelo.datos.objetos.avaluos.AvaluoMotos;
import modelo.datos.objetos.avaluos.AvaluoResultado;
import modelo.datos.objetos.avaluos.AvaluoVehiculo;
import modelo.datos.objetos.avaluos.CarroceriaMin;
import modelo.datos.objetos.avaluos.ClExcepCarga;
import modelo.datos.objetos.avaluos.ClGrupoCarga;
import modelo.datos.objetos.avaluos.ClGrupoCargaPas;
import modelo.datos.objetos.avaluos.ClGrupoMoto;
import modelo.datos.objetos.avaluos.ClGrupoPas;
import modelo.datos.objetos.avaluos.ClMotoCilind;
import modelo.datos.objetos.avaluos.ClaseVehiculoAvaluo;
import modelo.datos.objetos.avaluos.ExepAvaluo;
import modelo.datos.objetos.avaluos.ViewCLGrupoCargaPas;
import modelo.datos.objetos.avaluos.ViewClGrupoMoto;

import modelo.logica.generales.GestionServiciosAvaluos;


@WebService
public class ServiciosAvaluos {
    private GestionServiciosAvaluos gestionAvaluos;
    public ServiciosAvaluos() {
        super();
        gestionAvaluos = new GestionServiciosAvaluos();
    }
    
    public boolean crearAvaluoVehiculo(AvaluoVehiculo avaluoVehiculo){
      return gestionAvaluos.crearAvaluoVehiculo(avaluoVehiculo);
    }
    
    public boolean crearAvaluoMoto(AvaluoMotos avaluoMoto){
      return gestionAvaluos.crearAvaluoMotos(avaluoMoto);
    }
    
    public boolean crearAvaluoCarga(AvaluoCarga avaluoCarga){
      return gestionAvaluos.crearAvaluoCarga(avaluoCarga);
    }
    
    public double getAvaluo(Avaluo avaluo, String grupo){
      return gestionAvaluos.getAvaluo(avaluo, grupo);
    }
    
    public List getTipoVehiculosAvaluo(){
      return gestionAvaluos.getTipoVehiculoAvaluo();
    }
    
    public ClaseVehiculoAvaluo getOneTipoVehiculo(ClaseVehiculoAvaluo claseVehiculoAvaluo){
      return gestionAvaluos.getOneTipoVehiculoAvaluo(claseVehiculoAvaluo);
    }
    
    public boolean crearClGrupoMoto(ClGrupoMoto clGrupoMoto){
      return gestionAvaluos.crearClGrupoMoto(clGrupoMoto);
    }
    
    public boolean eliminarClGrupoMoto(ClGrupoMoto clGrupoMoto){
      return gestionAvaluos.eliminarClGrupoMoto(clGrupoMoto);
    }
    
    public List bucarClGrupoMoto(ClGrupoMoto clGrupoMoto){
      return gestionAvaluos.bucarClGrupoMoto(clGrupoMoto);
    }
    
    public List listarClGrupoMoto(){
      return gestionAvaluos.listarClGrupoMoto();
    }
    
    public List listarCLVigenciaGurpoMoto()
    {
        return gestionAvaluos.listarClVigenciasGrupoMoto();
    }
    
    public boolean crearClMotoCilindraje(ClMotoCilind clMotoCilindraje){
      return gestionAvaluos.crearClMotoCilindraje(clMotoCilindraje);
    }
    
    public boolean eliminarClMotoCilindraje(ClMotoCilind clMotoCilindraje){
      return gestionAvaluos.eliminarClMotoCilindraje(clMotoCilindraje);
    }
    
    public List buscarClMotoCilindraje(ClMotoCilind clMotoCilindraje){
      return gestionAvaluos.buscarClMotoCilindraje(clMotoCilindraje);
    }
    
    public List getClGrupoMoto(){
      return gestionAvaluos.getClGrupoMoto();
    }
    
    public List getClMotoCilindraje(){
      return gestionAvaluos.getClMotoCilindraje();
    }
    
    public boolean crearExcepcionAvaluo(ExepAvaluo exepAvaluo){
      return gestionAvaluos.crearExcepcionAvaluo(exepAvaluo);
    }
    
    public boolean eliminarExcepcionAvaluo(ExepAvaluo exepAvaluo){
      return gestionAvaluos.eliminarExcepcionAvaluo(exepAvaluo);
    }
    
    public List getAllExcepcionAvaluo(){
      return gestionAvaluos.getAllExcepcionAvaluo();
    }
    
    public List getExcepCarga(){
      return gestionAvaluos.getExcepCarga();
    }
    
    public boolean crearExcepCarga(ClExcepCarga excepCarga){
      return gestionAvaluos.crearExcepCarga(excepCarga);
    }
    
    public boolean eliminarExcepCarga(ClExcepCarga excepCarga){
      return gestionAvaluos.eliminarExcepCarga(excepCarga);
    }
    
    public boolean crearRangoCarga(ClGrupoCarga clGrupoCarga){
      return gestionAvaluos.crearRangoCarga(clGrupoCarga);
    }
    
    public boolean crearGrupoCargaPas(ClGrupoCargaPas clGrupoCargaPas) {
      return gestionAvaluos.crearGrupoCargaPas(clGrupoCargaPas);
    }
    
    public boolean eliminarGrupoCargaPas(ClGrupoCargaPas clGrupoCargaPas) {
      return gestionAvaluos.eliminarGrupoCargaPas(clGrupoCargaPas);
    }
    
    public boolean eliminarRangoCarga(ClGrupoCarga clGrupoCarga){
      return gestionAvaluos.eliminarRangoCarga(clGrupoCarga);
    }
    
    public List getRangoCarga(){
      return gestionAvaluos.getRangoCarga();
    }
    
    public boolean crearRangoPasajeros(ClGrupoPas clGrupoPas){
      return gestionAvaluos.crearRangoPasajeros(clGrupoPas);
    }
    
    public boolean eliminarRangoPasajeros(ClGrupoPas clGrupoPas){
        return gestionAvaluos.eliminarRangoPasajeros(clGrupoPas);
    }
    
    public List getRangoPasajeros(){
      return gestionAvaluos.getRangoPasajeros();
    }
    
    
    
    public List getGrupoCargaPas(){
      return gestionAvaluos.getGrupoCargaPas();
    }
    
    public List searchTipoVehiculoAvaluo(ClaseVehiculoAvaluo claseVehiculoAvaluo){
      return gestionAvaluos.searchTipoVehiculoAvaluo(claseVehiculoAvaluo);
    }
    
    public List getViewClGrupoMoto(ViewClGrupoMoto tmp){
        return gestionAvaluos.getViewClGrupoMoto(tmp);
    }
    
    public List getViewGrupoPas(ViewCLGrupoCargaPas tmp) {
        return gestionAvaluos.getViewGrupoPas(tmp);
    }
    
    public List getVigencia(String tipo){
      return gestionAvaluos.getVigencias(tipo);
    }
    
    public List getCarroceriaMin(CarroceriaMin carroceriaMin){
        return gestionAvaluos.getCarroceria(carroceriaMin);
    }
    
    public AvaluoResultado getAvaluoResultado() {
        AvaluoResultado avr = new AvaluoResultado();
        return avr;
    }
}