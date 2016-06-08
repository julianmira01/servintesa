package servicios.comparendos;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import modelo.datos.objetos.comparendos.planos.RangosDeComparendos;

import modelo.logica.comparendos.planos.GestionServiciosRangosDeComparendos;

@WebService
public class ServiciosRangosDeComparendos {
    
    GestionServiciosRangosDeComparendos gestionRangosDeComparendos;
    
    public ServiciosRangosDeComparendos() {
        super();
        gestionRangosDeComparendos = new GestionServiciosRangosDeComparendos();
    }

    @WebMethod()
    public List getRangosDeComparendos(){
        return gestionRangosDeComparendos.getRangosDeComparendos();
    }

    @WebMethod
    public boolean saveRangosDeComparendos(@WebParam(name = "arg0")
        RangosDeComparendos rangoDeComparendos) {    
        return gestionRangosDeComparendos.saveRangosDeComparendos(rangoDeComparendos);
    }

    @WebMethod()
    public RangosDeComparendos createRangosDeComparendos(RangosDeComparendos rangoDeComparendos){
        return gestionRangosDeComparendos.createRangoDeComparendos(rangoDeComparendos);
    }
    
    @WebMethod
    public boolean eliminarRangosdecomparendos(RangosDeComparendos obj) {   
      return gestionRangosDeComparendos.eliminarRangosdecomparendos(obj); 
    }
}
