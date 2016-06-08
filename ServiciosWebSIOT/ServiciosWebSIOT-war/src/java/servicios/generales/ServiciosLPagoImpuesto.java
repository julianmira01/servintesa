package servicios.generales;

import java.util.List;

import javax.jws.WebService;

import modelo.datos.objetos.generales.Empresa;

import modelo.datos.objetos.generales.LPagoImpuesto;

import modelo.logica.generales.GestionServiciosLPagoImpuesto;


@WebService
public class ServiciosLPagoImpuesto {
    
    GestionServiciosLPagoImpuesto gestionServiciosLPagoImpuesto;
    
    public ServiciosLPagoImpuesto() {
        super();
        gestionServiciosLPagoImpuesto = new GestionServiciosLPagoImpuesto();
    }
    
    public List getLPagoImpuesto(LPagoImpuesto pagoImpuesto){
      return gestionServiciosLPagoImpuesto.getLPagoImpuestos(pagoImpuesto);
    }
    
    public boolean createLPagoImpuesto(LPagoImpuesto pagoImpuesto){
      return gestionServiciosLPagoImpuesto.createLPagoImpuestos(pagoImpuesto);
    }
    
    public boolean deleteLPagoImpuesto(LPagoImpuesto pagoImpuesto){
      return gestionServiciosLPagoImpuesto.deleteLPagoImpuestos(pagoImpuesto);
    }
}
