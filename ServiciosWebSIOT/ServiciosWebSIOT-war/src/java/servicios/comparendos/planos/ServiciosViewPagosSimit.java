package servicios.comparendos.planos;

import java.util.List;

import javax.jws.WebService;

import modelo.datos.objetos.comparendos.planos.ViewPagosSimit;

import modelo.logica.comparendos.planos.GestionServiciosViewPagosSimit;

@WebService
public class ServiciosViewPagosSimit {
    
    GestionServiciosViewPagosSimit gestionServiciosViewPagosSimit;
    
    public ServiciosViewPagosSimit() {
        super();
        gestionServiciosViewPagosSimit = new GestionServiciosViewPagosSimit();
    }
    
    public List getViewPagosSimit(ViewPagosSimit viewPagosSimit){
        return gestionServiciosViewPagosSimit.getViewPagosSimit(viewPagosSimit);
    }
    
    public List getPagosSimitPorFechas(ViewPagosSimit viewPagosSimit, String fecha1, String fecha2){
        return gestionServiciosViewPagosSimit.getPagosSimitPorFechas(viewPagosSimit, fecha1, fecha2);
    }
}
