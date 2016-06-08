package servicios.comparendos.planos;

import java.util.List;

import javax.jws.WebService;

import modelo.datos.objetos.comparendos.planos.ComparendosCargaAlSimit;

import modelo.logica.comparendos.planos.GestionServiciosComparendosCargaAlSimit;


@WebService
public class ServiciosComparendosCargaSimit {
    
    GestionServiciosComparendosCargaAlSimit gestionServiciosCargaAlSimit;
    
    public ServiciosComparendosCargaSimit() {
        super();
        gestionServiciosCargaAlSimit = new GestionServiciosComparendosCargaAlSimit();
    }
    
    public List getComparendosCargaAlSimit(ComparendosCargaAlSimit comparendosCargaAlSimit){
        return gestionServiciosCargaAlSimit.getComparendosCargasAlSimit(comparendosCargaAlSimit);
    }
    
    public ComparendosCargaAlSimit createComparendosCargaAlSimit(ComparendosCargaAlSimit comparendosCargaAlSimit, int idUsuario, String myIp, String myHost){
        return gestionServiciosCargaAlSimit.crearComparendosCargaAlSimit(comparendosCargaAlSimit, idUsuario, myIp, myHost);
    }
    
    public boolean editComparendosCargaAlSimit(ComparendosCargaAlSimit comparendosCargaAlSimit, int idUsuario, String myIp, String myHost){
        return gestionServiciosCargaAlSimit.editComparendosCargaAlSimit(comparendosCargaAlSimit, idUsuario, myIp, myHost);
    }
    
    public List allComparendosCargaAlSimit(ComparendosCargaAlSimit comparendosCargaAlSimit){
        return gestionServiciosCargaAlSimit.allComparendosCargasAlSimit(comparendosCargaAlSimit);
    }
    
    public Integer  getCantidadCompEnviadosPorCarga(ComparendosCargaAlSimit comparendosCargaAlSimit){
        return gestionServiciosCargaAlSimit.getCantidadCompEnviadosPorCarga(comparendosCargaAlSimit);
    }
    
    public Integer  getCantidadArchivosAprobadosPorCarga(ComparendosCargaAlSimit comparendosCargaAlSimit){
        return gestionServiciosCargaAlSimit.getCantidadArchivosAprobadosPorCarga(comparendosCargaAlSimit);
    }
    
    public boolean  marcarComprandosQueSubieron(ComparendosCargaAlSimit comparendosCargaAlSimit){
        return gestionServiciosCargaAlSimit.marcarComparendosQueSiSubieron(comparendosCargaAlSimit);
    }
    
    public boolean  marcarComprandosQueNoSubieron(ComparendosCargaAlSimit comparendosCargaAlSimit){
        return gestionServiciosCargaAlSimit.marcarComparendosQueNoSubieron(comparendosCargaAlSimit);
    }
    
    public boolean  clarearComparendosCargados(ComparendosCargaAlSimit comparendosCargaAlSimit, int idUsuario, String myIp, String myHost){
        return gestionServiciosCargaAlSimit.clarearComparendosCargados(comparendosCargaAlSimit, idUsuario, myIp, myHost);
    }
}
