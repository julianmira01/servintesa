package servicios.liquidacion;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import modelo.datos.objetos.liquidacion.tarifas.LVigencias;
import modelo.datos.objetos.liquidacion.tarifas.LconceptosCobro;
import modelo.datos.objetos.liquidacion.tarifas.Ltarifas;
import modelo.datos.objetos.liquidacion.tarifas.LtarifasDet;
import modelo.datos.objetos.liquidacion.tarifas.LtipoConcepto;
import modelo.datos.objetos.liquidacion.tarifas.ViewDetalleTarifa;
import modelo.datos.objetos.tramites.Tramiteinterno;

import modelo.logica.liquidacion.GestionServiciosTarifas;


@WebService
public class ServiciosTarifas {
    GestionServiciosTarifas gestionServiciosTarifas;
    
    public ServiciosTarifas() {
        super();
        gestionServiciosTarifas= new GestionServiciosTarifas();
    }

    @WebMethod
    public boolean crearTarifas(Ltarifas ltarifas,int idUsuario,String myIp,String myHost)
    {
        return gestionServiciosTarifas.crearTarifas(ltarifas,idUsuario,myIp,myHost);         
    } 

    @WebMethod
    public boolean editarTarifa(Ltarifas ltarifas,int idUsuario,String myIp,String myHost){
        return gestionServiciosTarifas.editarTarifa(ltarifas,idUsuario,myIp,myHost);
    } 
    
    @WebMethod
    public List getLtarifas(Ltarifas ltarifas){
        return gestionServiciosTarifas.getLtarifas(ltarifas);
    } 
    
    @WebMethod
    public List getLtarifasPorVigencia(Ltarifas ltarifas, int vigenciaInicial, int vigenciaFinal){
        return gestionServiciosTarifas.getLtarifasPorVigencia(ltarifas, vigenciaInicial, vigenciaFinal);
    } 
    
    @WebMethod
    public List getLTtarifas(){
        return gestionServiciosTarifas.getLTtarifas();
    } 

    @WebMethod
    public boolean eliminarTarifas(Ltarifas ltarifas,int idUsuario,String myIp,String myHost)
    {
        return gestionServiciosTarifas.eliminarTarifas(ltarifas,idUsuario,myIp,myHost);         
    } 
    
    @WebMethod
    public List getTramitesInternos(Tramiteinterno tramiteinterno){
        return gestionServiciosTarifas.getTramitesInternos(tramiteinterno);
    }
 
    @WebMethod
    public boolean crearConceptos(LconceptosCobro lconceptoscobro)
    {
        return gestionServiciosTarifas.crearConceptos(lconceptoscobro);         
    } 
    
    @WebMethod
    public List getLconceptos(){
        return gestionServiciosTarifas.getLconceptos();
    }     

    @WebMethod
    public LconceptosCobro getLconceptosId(LconceptosCobro lconceptoscobro){
        return gestionServiciosTarifas.getLconceptosId(lconceptoscobro);
    }

    @WebMethod
    public List getLTconceptos(LconceptosCobro lconceptoscobro){
        return gestionServiciosTarifas.getLTconceptos(lconceptoscobro);
    }

    @WebMethod
    public List getLtipoConceptos(LtipoConcepto ltipoconcepto){
        return gestionServiciosTarifas.getLtipoConceptos(ltipoconcepto);
    }  

    @WebMethod
    public boolean crearDetTarifas(LtarifasDet ltarifasdet, int idUsuario, String myIp, String myHost)
    {
        return gestionServiciosTarifas.crearDetTarifas(ltarifasdet, idUsuario, myIp, myHost);         
    }

    @WebMethod
    public boolean editarDetTarifa(LtarifasDet ltarifasdet, int idUsuario, String myIp, String myHost){
        return gestionServiciosTarifas.editarDetTarifa(ltarifasdet, idUsuario, myIp, myHost);
    } 

    @WebMethod
    public boolean eliminarDetTarifa(LtarifasDet ltarifasdet, int idUsuario, String myIp, String myHost){
        return gestionServiciosTarifas.eliminarDetTarifa(ltarifasdet, idUsuario, myIp, myHost);
    }

    @WebMethod
    public List getLtarifasDet(ViewDetalleTarifa viewdetalletarifa){
        return gestionServiciosTarifas.getLtarifasDet(viewdetalletarifa);
    } 
    
    @WebMethod
    public ViewDetalleTarifa getLtarifaDetId(ViewDetalleTarifa viewdetalletarifa) {
        return gestionServiciosTarifas.getLtarifaDetId(viewdetalletarifa);
    }

    @WebMethod
    public List getLTvigencias(LVigencias lvigencia){
        return gestionServiciosTarifas.getLTvigencias(lvigencia);
    }
    
    @WebMethod
    public LVigencias getLVigenciasId(LVigencias lvigencia) {
        return gestionServiciosTarifas.getLVigenciasId(lvigencia);
    }

    @WebMethod
    public List getLVigencias(LVigencias lvigencia)
    {
        return gestionServiciosTarifas.getLVigencias(lvigencia);
    }

    @WebMethod
    public boolean crearLVigencias(LVigencias lvigencia, int idUsuario, String myIp, String myHost)
    {
        return gestionServiciosTarifas.crearLVigencias(lvigencia, idUsuario, myIp, myHost);         
    }
    
    @WebMethod
    public boolean crearLVigenciasConReplica(LVigencias lvigencia,int numvigenciaant, int idUsuario, String myIp, String myHost)
    {
        return gestionServiciosTarifas.crearLVigenciasConReplica(lvigencia,numvigenciaant ,idUsuario, myIp, myHost);         
    }
    
  
    @WebMethod
    public boolean editarLVigencias(LVigencias lvigencia, int idUsuario, String myIp, String myHost){
        return gestionServiciosTarifas.editarLVigencias(lvigencia, idUsuario, myIp, myHost);
    } 
       
}
