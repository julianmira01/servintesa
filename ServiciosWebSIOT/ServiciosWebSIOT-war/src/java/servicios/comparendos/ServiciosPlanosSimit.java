package servicios.comparendos;

import java.util.List;

import javax.jws.WebService;

import modelo.datos.objetos.comparendos.planos.PlanosSimit;

import modelo.logica.comparendos.planos.GestionServiciosPlanosSimit;


@WebService
public class ServiciosPlanosSimit {
    
    GestionServiciosPlanosSimit gestionServiciosPlanosSimit;
    
    public ServiciosPlanosSimit() {
        super();
        gestionServiciosPlanosSimit = new GestionServiciosPlanosSimit();
    }

    public List getPlanosSimit(){
        return gestionServiciosPlanosSimit.getPlanosSimit();
    }

    public boolean savePlanosSimit(PlanosSimit planosSimit, int idUsuario, String myIp, String myHost) {    
        return gestionServiciosPlanosSimit.savePlanosSimit(planosSimit, idUsuario, myIp, myHost);
    }

    public PlanosSimit createPlanosSimit(PlanosSimit planosSimit, int idUsuario, String myIp, String myHost){
        return gestionServiciosPlanosSimit.createPlanosSimit(planosSimit, idUsuario, myIp, myHost);
    }
}
