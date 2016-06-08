package servicios.generales;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import modelo.datos.objetos.generales.vistas.DetalleprocersarView;
import modelo.datos.objetos.generales.vistas.ViewVehiculoRUNT;
import modelo.datos.objetos.liquidacion.caja.ViewPagos;
import modelo.datos.objetos.liquidacion.caja.ViewPagosRunt;

import modelo.logica.generales.GestionViewGeneralesLocal;
import modelo.logica.liquidacion.GestionServiciosViewPagos;


@WebService
public class ServiciosViewGenerales {
    GestionServiciosViewPagos gestionServiciosViewPagos;
    GestionViewGeneralesLocal gestionViewGeneralLocal;
    public ServiciosViewGenerales() {
        super();
        gestionViewGeneralLocal = new GestionViewGeneralesLocal();
        gestionServiciosViewPagos = new GestionServiciosViewPagos();
    }

    @WebMethod
    public List getDetalleProcesar(DetalleprocersarView detalleProcesar){
      return gestionViewGeneralLocal.getDetalleProcesar(detalleProcesar);
    }

    @WebMethod
    public List BuscarPagos(@WebParam(name = "arg0")
        ViewPagos viewPagos, @WebParam(name = "arg1")
        String fechai, @WebParam(name = "arg2")
        String fechaf)
    {
        return gestionServiciosViewPagos.getPagos(viewPagos,fechai,fechaf);         
    }

    @WebMethod
    public List BuscarPagosRunt(@WebParam(name = "arg0")
        ViewPagosRunt viewPagosRunt, @WebParam(name = "arg1")
        String fechai, @WebParam(name = "arg2")
        String fechaf)
    {
        return gestionServiciosViewPagos.getPagosRunt(viewPagosRunt,fechai,fechaf);         
    }
	
	@WebMethod
    public ViewVehiculoRUNT getViewVehiculoRUNT(ViewVehiculoRUNT vehiculo)        
    {
      return gestionViewGeneralLocal.getVehiculoPorId(vehiculo);
    }
	
	@WebMethod
    public List getViewVehiculoRUNTs(ViewVehiculoRUNT vehiculo)        
    {
      return gestionViewGeneralLocal.getVehiculos(vehiculo);
    }
}
