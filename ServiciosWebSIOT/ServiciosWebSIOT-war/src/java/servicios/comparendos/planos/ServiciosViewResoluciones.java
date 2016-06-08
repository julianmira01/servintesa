package servicios.comparendos.planos;

import java.util.List;

import javax.jws.WebService;

import modelo.datos.objetos.comparendos.planos.ViewResoluciones;

import modelo.logica.comparendos.planos.GestionServiciosViewResoluciones;

@WebService
public class ServiciosViewResoluciones {
    
    GestionServiciosViewResoluciones gestionServiciosViewResoluciones;
    
    public ServiciosViewResoluciones() {
        super();
        gestionServiciosViewResoluciones = new GestionServiciosViewResoluciones();
    }
    
    public List getViewResoluciones(ViewResoluciones viewResoluciones){
        return gestionServiciosViewResoluciones.getViewResoluciones(viewResoluciones);
    }
    
    public List getResolucionesPorFechas(ViewResoluciones viewResoluciones, String fecha1, String fecha2) {
        return gestionServiciosViewResoluciones.getResolucionesPorFechas(viewResoluciones, fecha1, fecha2);
    }
}
