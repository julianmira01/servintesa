package servicios.comparendos.planos;

import java.util.List;

import javax.jws.WebService;

import modelo.datos.objetos.comparendos.planos.PlanoRecaudos;

import modelo.logica.comparendos.planos.GestionServiciosPlanoRecaudos;


@WebService
public class ServiciosPlanoRecaudos {
    
    GestionServiciosPlanoRecaudos gestionServiciosPlanoRecaudos;
    
    public ServiciosPlanoRecaudos() {
        super();
        gestionServiciosPlanoRecaudos = new GestionServiciosPlanoRecaudos();
    }
    
    public List getPlanoRecaudos(PlanoRecaudos planoRecaudos){
        return gestionServiciosPlanoRecaudos.getPlanoRecaudos(planoRecaudos);
    }
    
    public PlanoRecaudos createPlanoRecaudos(PlanoRecaudos planoRecaudos, int idUsuario, String myIp, String myHost){
        return gestionServiciosPlanoRecaudos.createPlanoRecaudos(planoRecaudos, idUsuario, myIp, myHost);
    }
    
    public boolean editPlanoRecaudos(PlanoRecaudos planoRecaudos, int idUsuario, String myIp, String myHost){
        return gestionServiciosPlanoRecaudos.editPlanoRecaudos(planoRecaudos, idUsuario, myIp, myHost);
    }
    
    public List allPlanoRecaudos(PlanoRecaudos planoRecaudos){
        return gestionServiciosPlanoRecaudos.allPlanoRecaudos(planoRecaudos);
    }
}
