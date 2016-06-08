package servicios.generales;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

import modelo.datos.objetos.generales.medidasCautelares.ViewMedidasCautelares;
import modelo.datos.objetos.medidasCautelares.JPendienteViewCT;
import modelo.datos.objetos.medidasCautelares.J_Pendiente;

import modelo.logica.generales.GestionServiciosEmpresasLocal;
import modelo.logica.generales.GestionServiciosMedidasCautelaresLocal;
import modelo.logica.generales.GestionServiciosViewMedidasCautelares;

@WebService
public class ServiciosMedidasCautelares {
    
    GestionServiciosMedidasCautelaresLocal gestionServiciosMedidasCautelaresLocal;
    GestionServiciosViewMedidasCautelares gestionServiciosViewMedidasCautelares;
    
    public ServiciosMedidasCautelares() {
        super();
        crearObjetos();
    }
    
  @Oneway
  @WebMethod
    private void crearObjetos(){
      gestionServiciosMedidasCautelaresLocal = new GestionServiciosMedidasCautelaresLocal();
      gestionServiciosViewMedidasCautelares = new GestionServiciosViewMedidasCautelares();
    }
    
  @WebMethod
    public J_Pendiente CrearMedidaCautelar(J_Pendiente medidaCautelar, int idUsuario, String myIp, String myHost){
      return gestionServiciosMedidasCautelaresLocal.crearMedidaCautelar(medidaCautelar,idUsuario,myIp,myHost);
    }
    
  @WebMethod
  public J_Pendiente ActualizarMedidaCautelar(J_Pendiente medidaCautelar,int idUsuario,String myIp,String myHost){
    return gestionServiciosMedidasCautelaresLocal.actualizarMedidaCautelar(medidaCautelar,idUsuario,myIp,myHost);
  }
  
  @WebMethod
  public J_Pendiente LevantarMedidaCautelar(J_Pendiente medidaCautelar,int idUsuario,String myIp,String myHost){
    return gestionServiciosMedidasCautelaresLocal.levantarMedidaCautelar(medidaCautelar,idUsuario,myIp,myHost);
  }

    /**
     * @param medidaCautelar
     * @return
     */
    @WebMethod
  public List ListarMedidasCautelares(J_Pendiente medidaCautelar){
    return gestionServiciosMedidasCautelaresLocal.ListarMedidaCautelar(medidaCautelar);
  }
    
    public List getMedidasCautelaresCT(JPendienteViewCT myMedida)
    {
        return gestionServiciosMedidasCautelaresLocal.getMedidasCautelaresCT(myMedida);
    }
       
}
