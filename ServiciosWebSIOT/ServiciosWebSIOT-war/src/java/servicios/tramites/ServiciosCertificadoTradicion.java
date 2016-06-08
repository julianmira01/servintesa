package servicios.tramites;

import modelo.datos.objetos.generales.TramiteBasico;
import modelo.datos.objetos.generales.vehiculo.ViewVehiculo;

import modelo.logica.tramites.GestionServiciosCertificadoTradicion;


public class ServiciosCertificadoTradicion {
    
    GestionServiciosCertificadoTradicion gestionServiciosCertificadoTradicion;
    
    public ServiciosCertificadoTradicion() {
        super();
        gestionServiciosCertificadoTradicion = new GestionServiciosCertificadoTradicion();
    }
    
    public ViewVehiculo getInfoVehiculo(TramiteBasico tramiteBasico){
        return gestionServiciosCertificadoTradicion.getInfoVehiculo(tramiteBasico);
    }
}
