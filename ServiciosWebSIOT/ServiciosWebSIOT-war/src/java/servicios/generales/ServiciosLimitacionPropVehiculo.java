package servicios.generales;

import java.util.List;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;

import modelo.datos.objetos.generales.LimitacionPropVehiculo;
import modelo.datos.objetos.generales.TramiteBasico;
import modelo.datos.objetos.tramites.InscripcionPrenda;
import modelo.datos.objetos.tramites.LevantarPrenda;

import modelo.logica.generales.GestionServiciosLimitacionPropVehiculo;
import modelo.logica.tramites.GestionServiciosTramitesRNA;


@WebService
public class ServiciosLimitacionPropVehiculo {
    GestionServiciosLimitacionPropVehiculo gestionServiciosLimitacionPropVehiculo;
    GestionServiciosTramitesRNA gestionServiciosTramitesRNA;
    
    public ServiciosLimitacionPropVehiculo() {
        super();
        crearObjetos();
    }
    
    @Oneway
    private void crearObjetos() {
        gestionServiciosLimitacionPropVehiculo = new GestionServiciosLimitacionPropVehiculo();
    }
    
    @WebMethod
    public LimitacionPropVehiculo crearLimitacionPropVehiculo(TramiteBasico tramiteBasico, LimitacionPropVehiculo limitacionPropVehiculo, int idUsuario, String myIp, String myHost) {
        return gestionServiciosLimitacionPropVehiculo.crearLimitacionPropVehiculo(tramiteBasico,limitacionPropVehiculo, idUsuario, myIp, myHost);
    }
    
    @WebMethod
    public boolean saveLimitacionPropVehiculo(TramiteBasico tramiteBasico, LimitacionPropVehiculo limitacionPropVehiculo, int idUsuario, String myIp, String myHost) {
        return gestionServiciosLimitacionPropVehiculo.saveLimitacionPropVehiculo(tramiteBasico, limitacionPropVehiculo, idUsuario, myIp, myHost);
    }
    
    @WebMethod
    public List getLimitacionPropVehiculo(LimitacionPropVehiculo limitacionPropVehiculo) {
        return gestionServiciosLimitacionPropVehiculo.getLimitacionPropVehiculo(limitacionPropVehiculo);
    }
}
