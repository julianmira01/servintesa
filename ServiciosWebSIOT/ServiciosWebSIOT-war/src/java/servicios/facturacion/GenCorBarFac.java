package servicios.facturacion;


import java.util.List;

import javax.jws.WebService;

import modelo.logica.facturacion.GestionServiciosFacturacion;

@WebService
public class GenCorBarFac 
{
  GestionServiciosFacturacion gestionSFacturacion;
    
    public GenCorBarFac() 
    {
        super();
        gestionSFacturacion = new GestionServiciosFacturacion();
    }
    
    public String getCamposCodigoBarras(String identificacionCliente, String numFactura, String valorFactura, String fechaAAAAMMDD)
    {
      return gestionSFacturacion.generarCodigoBarras(identificacionCliente, numFactura, valorFactura, fechaAAAAMMDD);
    }
}
