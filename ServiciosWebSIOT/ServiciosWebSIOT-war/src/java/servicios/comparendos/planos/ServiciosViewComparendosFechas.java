package servicios.comparendos.planos;

import java.util.List;

import javax.jws.WebService;

import modelo.datos.objetos.comparendos.planos.ViewComparendosFechas;

import modelo.logica.comparendos.planos.GestionServiciosViewComparendosFechas;


@WebService
public class ServiciosViewComparendosFechas {
    
    GestionServiciosViewComparendosFechas gestionServiciosViewComparendosFechas;
    
    public ServiciosViewComparendosFechas() {
        super();
        gestionServiciosViewComparendosFechas = new GestionServiciosViewComparendosFechas();
    }
    
    public List getViewComparendosFechas(ViewComparendosFechas viewComparendosFechas){
        return gestionServiciosViewComparendosFechas.getViewComparendosFechas(viewComparendosFechas);
    }
    
    public List getComparendoPorRangoFechas(ViewComparendosFechas viewComparendosFechas, String fecha1, String fecha2){
        return gestionServiciosViewComparendosFechas.getComparendoPorRangoFechas(viewComparendosFechas, fecha1, fecha2);
    }

    public List getComparendoPorRangoFechasRegistro(ViewComparendosFechas viewComparendosFechas, String fecha1, String fecha2){
        return gestionServiciosViewComparendosFechas.getComparendoPorRangoFechasRegistro(viewComparendosFechas, fecha1, fecha2);
    }
    
    public List getComparendoNoPagosPorRangoFechas(ViewComparendosFechas viewComparendosFechas, String fecha1, String fecha2){
        return gestionServiciosViewComparendosFechas.getComparendoNoPagosPorRangoFechas(viewComparendosFechas, fecha1, fecha2);
    }
    
    public List getComparendoNoPagosPorRangoFechasRegistro(ViewComparendosFechas viewComparendosFechas, String fecha1, String fecha2){
        return gestionServiciosViewComparendosFechas.getComparendoNoPagosPorRangoFechasRegistro(viewComparendosFechas, fecha1, fecha2);
    }
    
    public List getAllComparendoPorRangoFechas(ViewComparendosFechas viewComparendosFechas){
        return gestionServiciosViewComparendosFechas.getAllViewComparendosFechas(viewComparendosFechas);
    }
}
