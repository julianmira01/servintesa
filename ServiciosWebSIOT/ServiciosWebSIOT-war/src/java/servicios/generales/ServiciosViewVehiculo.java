package servicios.generales;

import java.util.List;

import javax.jws.Oneway;
import javax.jws.WebMethod;

import javax.jws.WebService;

import modelo.datos.objetos.generales.vehiculo.Vehiculo;

import modelo.datos.objetos.generales.vehiculo.ViewVehiculo;

import modelo.logica.generales.vehiculo.GestionServiciosViewVehiculosLocal;


@WebService
public class ServiciosViewVehiculo {
    
    GestionServiciosViewVehiculosLocal gestionServiciosViewVehiculosLocal;
    
    public ServiciosViewVehiculo() {
        super();
        crearObjetos();
    }

    @Oneway
    @WebMethod
    public void crearObjetos(){
      gestionServiciosViewVehiculosLocal = new GestionServiciosViewVehiculosLocal();
    }

    @WebMethod
    public ViewVehiculo consultarInformacionVehiculoPorPlaca(ViewVehiculo vehiculo){
      return gestionServiciosViewVehiculosLocal.consultarInformacionVehiculo(vehiculo);
    }

    @WebMethod
    public ViewVehiculo consultarInformacionVehiculoPorNroMotor(ViewVehiculo vehiculo){
      return gestionServiciosViewVehiculosLocal.consultarInformacionVehiculo(vehiculo);
    }

    @WebMethod
    public ViewVehiculo consultarInformacionVehiculoPorChasis(ViewVehiculo vehiculo){
      return gestionServiciosViewVehiculosLocal.consultarInformacionVehiculo(vehiculo);
    }

    @WebMethod
    public ViewVehiculo consultarInformacionVehiculoPorSerie(ViewVehiculo vehiculo){
      return gestionServiciosViewVehiculosLocal.consultarInformacionVehiculo(vehiculo);
    }

    @WebMethod
    public ViewVehiculo consultarInformacionVehiculoPorIdVehiculo(ViewVehiculo vehiculo){
      return gestionServiciosViewVehiculosLocal.consultarInformacionVehiculo(vehiculo);
    }
    
    @WebMethod
    public List getSViewVehiculo(ViewVehiculo viewVehiculo)
    {
        return gestionServiciosViewVehiculosLocal.getSViewVehiculo(viewVehiculo);
    }
    
}