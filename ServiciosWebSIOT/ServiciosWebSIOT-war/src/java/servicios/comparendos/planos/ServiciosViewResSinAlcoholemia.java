package servicios.comparendos.planos;

import java.util.List;

import javax.jws.WebService;

import modelo.datos.objetos.comparendos.planos.ViewResSinAlcoholemia;

import modelo.datos.objetos.comparendos.planos.ViewResolucionesAlcoholemia;

import modelo.logica.comparendos.planos.GestionServiciosViewResSinAlcoholemia;

@WebService
public class ServiciosViewResSinAlcoholemia {
    
    GestionServiciosViewResSinAlcoholemia gestionServiciosViewResSinAlcoholemia;
    
    public ServiciosViewResSinAlcoholemia() {
        super();
        gestionServiciosViewResSinAlcoholemia = new GestionServiciosViewResSinAlcoholemia();
    }
    
    public List getViewResSinAlcoholemia(ViewResSinAlcoholemia viewResSinAlcoholemia){
        return gestionServiciosViewResSinAlcoholemia.getViewResSinAlcholemia(viewResSinAlcoholemia);
    }
    
    public List getResolucionesSinAlcoholemiaPorFechas(ViewResSinAlcoholemia viewResSinAlcoholemia, String fecha1, String fecha2) {
        return gestionServiciosViewResSinAlcoholemia.getResolucionesSinAlcoholemiaPorFechas(viewResSinAlcoholemia, fecha1, fecha2);
    }
}
