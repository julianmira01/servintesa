package servicios.comparendos.planos;

import java.util.List;

import javax.jws.WebService;

import modelo.datos.objetos.comparendos.planos.ViewResolucionesAlcoholemia;

import modelo.logica.comparendos.planos.GestionServiciosViewResolucionesAlcoholemia;

@WebService
public class ServiciosViewResolucionesAlcoholemia {
    
    GestionServiciosViewResolucionesAlcoholemia gestionServiciosViewResolucionesAlcoholemia;
    
    public ServiciosViewResolucionesAlcoholemia() {
        super();
        gestionServiciosViewResolucionesAlcoholemia = new GestionServiciosViewResolucionesAlcoholemia();
    }
    
    public List getViewResolucionesAlcoholemia(ViewResolucionesAlcoholemia viewResolucionesAlcoholemia){
        return gestionServiciosViewResolucionesAlcoholemia.getViewResolucionesAlcoholemia(viewResolucionesAlcoholemia);
    }
    
    public List getResolucionesAlcoholemiaPorFechas(ViewResolucionesAlcoholemia viewResolucionesAlcoholemia, String fecha1, String fecha2) {
        return gestionServiciosViewResolucionesAlcoholemia.getResolucionesAlcoholemiaPorFechas(viewResolucionesAlcoholemia, fecha1, fecha2);
    }
}
