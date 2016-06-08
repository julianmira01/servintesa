package servicios.comparendos.planos;

import java.util.List;

import javax.jws.WebService;

import modelo.datos.objetos.comparendos.planos.PlanoResoluciones;

import modelo.logica.comparendos.planos.GestionServiciosPlanoResoluciones;


@WebService
public class ServiciosPlanoResoluciones {
    
    GestionServiciosPlanoResoluciones gestionServiciosPlanoesoluciones;
    
    public ServiciosPlanoResoluciones() {
        super();
        gestionServiciosPlanoesoluciones = new GestionServiciosPlanoResoluciones();
    }
    
    public List getPlanoResoluciones(PlanoResoluciones planoResoluciones) {
        return gestionServiciosPlanoesoluciones.getPlanoResoluciones(planoResoluciones);
    }
    
    public PlanoResoluciones createPlanoResoluciones(PlanoResoluciones planoResoluciones, int idUsuario, String myIp, String myHost){
        return gestionServiciosPlanoesoluciones.createPlanoResoluciones(planoResoluciones, idUsuario, myIp, myHost);
    }
    
    public boolean editPlanoResoluciones(PlanoResoluciones planoResoluciones, int idUsuario, String myIp, String myHost){
        return gestionServiciosPlanoesoluciones.editPlanoResoluciones(planoResoluciones, idUsuario, myIp, myHost);
    }
    
    public List allPlanoResoluciones(PlanoResoluciones planoResoluciones) {
        return gestionServiciosPlanoesoluciones.allPlanoResoluciones(planoResoluciones);
    }    
}
