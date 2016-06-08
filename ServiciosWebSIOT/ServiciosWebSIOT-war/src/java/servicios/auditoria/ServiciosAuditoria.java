package servicios.auditoria;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import modelo.datos.objetos.generales.AuditoriaSystem;

import modelo.logica.auditoria.GestionServiciosAuditoria;


@WebService
public class ServiciosAuditoria {
    
    GestionServiciosAuditoria gestionServiciosAuditoria;
    
    public ServiciosAuditoria() {
        super();
        crearObjetos();
    }

    @WebMethod(exclude = true)
    public void crearObjetos(){
        gestionServiciosAuditoria=new GestionServiciosAuditoria();
    }

    @WebMethod
    public List obtenerTablas()
    {
        return gestionServiciosAuditoria.getTablas(0);
    }

    @WebMethod
    public List obtenerAuditoria(AuditoriaSystem myAudit)
    {
        return gestionServiciosAuditoria.getAuditoria(myAudit,0);
    }
    
    @WebMethod
    public List obtenerAuditoriaFecha(AuditoriaSystem myAudit,String fechaInicial,String fechaFinal)
    {
        return gestionServiciosAuditoria.getAuditoria(myAudit,fechaInicial,fechaFinal,0);
    }
    
    @WebMethod
    public List obtenerTablasComp()
    {
        return gestionServiciosAuditoria.getTablas(1);
    }

    @WebMethod
    public List obtenerAuditoriaComp(AuditoriaSystem myAudit)
    {
        return gestionServiciosAuditoria.getAuditoria(myAudit,1);
    }
    
    @WebMethod
    public List obtenerAuditoriaFechaComp(AuditoriaSystem myAudit,String fechaInicial,String fechaFinal)
    {
        return gestionServiciosAuditoria.getAuditoria(myAudit,fechaInicial,fechaFinal,1);
    }
}
   