package servicios.logs;

import java.util.List;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;

import modelo.datos.objetos.logs.*;

import modelo.logica.logs.*;


@WebService
public class ServiciosLogs {

    GestionLogs gestionLOGS;

    public ServiciosLogs() {
        super();
        crearObjetos();
    }

    @Oneway
    @WebMethod
    public void crearObjetos() {
        gestionLOGS = new GestionLogs();
    }

    @WebMethod
    public List buscarLogs(LOGS log) {
        return gestionLOGS.buscarLOGS(log);
    }
    
    @WebMethod
    public List buscarLogsRangoFecha(LOGS log,String fechaFinal)throws Exception{
        try
        {
            return gestionLOGS.buscarLogsRangoFecha(log,fechaFinal);
        }catch(Exception e){throw new Exception(e.getMessage());}
    }
    
    @WebMethod
    public LOGS crearRegistroLog(LOGS log) {
        return gestionLOGS.crearLog(log);
    }
    
    @WebMethod
    public LOGS actualizarRegistroLog(LOGS log) {
        return gestionLOGS.editarLog(log);
    }
}
