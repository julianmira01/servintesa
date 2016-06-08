package servicios.comparendos;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import modelo.datos.objetos.comparendos.liquidacion.tarifas.ItemsLiquidacionComp;
import modelo.datos.objetos.comparendos.liquidacion.tarifas.LtarifasComp;
import modelo.datos.objetos.comparendos.liquidacion.tarifas.LtarifasDetComp;
import modelo.datos.objetos.comparendos.liquidacion.tarifas.TramiteContravencionalComp;
import modelo.datos.objetos.comparendos.liquidacion.tarifas.ViewDetalleTarifaComp;

import modelo.logica.comparendos.liquidacion.GestionServiciosTarifasComp;


@WebService
public class ServiciosTarifasComp {
    GestionServiciosTarifasComp gestionServiciosTarifasComp;
    public ServiciosTarifasComp() {
        super();
        gestionServiciosTarifasComp=new GestionServiciosTarifasComp();
    }
    
    @WebMethod
    public List getTramitesContravencional(TramiteContravencionalComp tramitecomtravencional){
        return gestionServiciosTarifasComp.getTramitesContravencional(tramitecomtravencional);
    }
 
    @WebMethod
    public boolean crearTarifas(LtarifasComp ltarifascomp, int idUsuario, String myIp, String myHost)
    {
        return gestionServiciosTarifasComp.crearTarifas(ltarifascomp, idUsuario, myIp, myHost);
    }
    
    @WebMethod
    public boolean editarTarifa(LtarifasComp ltarifascomp, int idUsuario, String myIp, String myHost){
        return gestionServiciosTarifasComp.editarTarifa(ltarifascomp, idUsuario, myIp, myHost);
    } 
    
    @WebMethod
    public List getLtarifas(LtarifasComp ltarifascomp){
        return gestionServiciosTarifasComp.getLtarifas(ltarifascomp);
    } 
    
    @WebMethod
    public List getLtarifasPorVigencia(LtarifasComp ltarifascomp, int vigenciaInicial, int vigenciaFinal){
        return gestionServiciosTarifasComp.getLtarifasPorVigencia(ltarifascomp, vigenciaInicial, vigenciaFinal);
    } 
    
    @WebMethod
    public List getLTtarifas(){
        return gestionServiciosTarifasComp.getLTtarifas();
    } 
  
    @WebMethod
    public boolean eliminarTarifas(LtarifasComp ltarifascomp, int idUsuario, String myIp, String myHost)
    {
        return gestionServiciosTarifasComp.eliminarTarifas(ltarifascomp, idUsuario, myIp, myHost);         
    } 
    
    @WebMethod
    public List getLtarifasDet(ViewDetalleTarifaComp viewdetalletarifacomp){
        return gestionServiciosTarifasComp.getLtarifasDet(viewdetalletarifacomp);
    } 
    
    @WebMethod
    public ViewDetalleTarifaComp getLtarifaDetId(ViewDetalleTarifaComp viewdetalletarifacomp) {
        return gestionServiciosTarifasComp.getLtarifaDetId(viewdetalletarifacomp);
    }  
    
    @WebMethod
    public List getTItemsLiquidacion(ItemsLiquidacionComp itemliquidacioncomp){
        return gestionServiciosTarifasComp.getTItemsLiquidacion(itemliquidacioncomp);
    }

    @WebMethod
    public boolean eliminarTarifasComp(LtarifasComp ltarifascomp, int idUsuario, String myIp, String myHost)
    {
        return gestionServiciosTarifasComp.eliminarTarifasComp(ltarifascomp, idUsuario, myIp, myHost);         
    } 

    @WebMethod
    public boolean editarTarifaComp(LtarifasComp ltarifascomp, int idUsuario, String myIp, String myHost){
        return gestionServiciosTarifasComp.editarTarifaComp(ltarifascomp, idUsuario, myIp, myHost);
    } 

    @WebMethod
    public boolean crearDetTarifasComp(LtarifasDetComp ltarifasdetcomp, int idUsuario, String myIp, String myHost)
    {
        return gestionServiciosTarifasComp.crearDetTarifasComp(ltarifasdetcomp, idUsuario, myIp, myHost);         
    }
  
    @WebMethod
    public boolean editarDetTarifaComp(LtarifasDetComp ltarifasdetcomp, int idUsuario, String myIp, String myHost){
        return gestionServiciosTarifasComp.editarDetTarifaComp(ltarifasdetcomp, idUsuario, myIp, myHost);
    } 
  
    @WebMethod
    public boolean eliminarDetTarifaComp(LtarifasDetComp ltarifasdetcomp, int idUsuario, String myIp, String myHost){
        return gestionServiciosTarifasComp.eliminarDetTarifaComp(ltarifasdetcomp, idUsuario, myIp, myHost);
    }
    
}
