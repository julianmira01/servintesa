package servicios.comparendos.planos;

import java.util.List;

import javax.jws.WebService;

import modelo.datos.objetos.comparendos.planos.PlanoComparendo;

import modelo.logica.comparendos.planos.GestionServiciosPlanoComparendo;


@WebService
public class ServiciosPlanoComparendo {
    
    GestionServiciosPlanoComparendo gestionServiciosPlanoComparendo;
    
    public ServiciosPlanoComparendo() {
        super();
        gestionServiciosPlanoComparendo = new GestionServiciosPlanoComparendo();
    }
    
    public List getPlanoComparendo(PlanoComparendo planoComparendo){
        return gestionServiciosPlanoComparendo.getPlanoComparendo(planoComparendo);
    }
    
    public PlanoComparendo createPlanoComparendo(PlanoComparendo planoComparendo, int idUsuario, String myIp, String myHost){
        return gestionServiciosPlanoComparendo.crearPlanoComparendo(planoComparendo, idUsuario, myIp, myHost);
    }
    
    public boolean editPlanoComparendo(PlanoComparendo planoComparendo, int idUsuario, String myIp, String myHost){
        return gestionServiciosPlanoComparendo.editPlanoComparendo(planoComparendo, idUsuario, myIp, myHost);
    }
    
    public List allPlanoComparendo(PlanoComparendo planoComparendo){
        return gestionServiciosPlanoComparendo.allPlanoComparendo(planoComparendo);
    }
}
