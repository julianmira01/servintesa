package servicios.licenciasConduccion;

import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import modelo.datos.objetos.generales.vistas.ViewDetConductores;
import modelo.datos.objetos.licenciasConduccion.LicenciasConduccion;
import modelo.datos.objetos.licenciasConduccion.Restricciones;
import modelo.datos.objetos.licenciasConduccion.Restriccionesdelicencia;
import modelo.datos.objetos.licenciasConduccion.Viewlicenciaconduccion;
import modelo.datos.objetos.licenciasConduccion.Viewlicenciaresidencia;
import modelo.datos.objetos.licenciasConduccion.Viewlicenciarestriccion;

import modelo.logica.licenciasConduccion.GestionLicenciasConduccion;
import modelo.logica.licenciasConduccion.GestionRestricciones;
import modelo.logica.licenciasConduccion.GestionRestriccionesdelicencia;
import modelo.logica.licenciasConduccion.GestionViewlicenciaconduccion;
import modelo.logica.licenciasConduccion.GestionViewlicenciaresidencia;
import modelo.logica.licenciasConduccion.GestionViewlicenciarestriccion;
import modelo.datos.objetos.licenciasConduccion.ESTADOS_LICENCIACOND;

@WebService
public class ServiciosLicenciasConduccion {
    GestionLicenciasConduccion gestionLicenciaConduccion;
    GestionRestricciones gestionRestricciones;
    GestionRestriccionesdelicencia gestionRestriccionesdelicencia;
    GestionViewlicenciaconduccion gestionViewlicenciaconduccion;
    GestionViewlicenciaresidencia gestionViewlicenciaresidencia;
    GestionViewlicenciarestriccion gestionViewlicenciarestriccion;

    public ServiciosLicenciasConduccion() {
        super();
    }

    public int crearLicenciaConduccion(LicenciasConduccion licencia) {
        gestionLicenciaConduccion = new GestionLicenciasConduccion();
        return gestionLicenciaConduccion.crearLicenciaConduccion(licencia);
    }
    
    public int crearEstadoLicencia(ESTADOS_LICENCIACOND estadoLicencia) {
            gestionLicenciaConduccion = new GestionLicenciasConduccion();
            return gestionLicenciaConduccion.crearEstadoLicenciaCond(estadoLicencia);
        }

    public boolean modificarLicenciaConduccion(LicenciasConduccion licencia) {
        gestionLicenciaConduccion = new GestionLicenciasConduccion();
        return gestionLicenciaConduccion.modificarLicenciaConduccion(licencia);
    }

    public LicenciasConduccion buscarLicenciaConduccion(LicenciasConduccion licencia) {
        gestionLicenciaConduccion = new GestionLicenciasConduccion();
        return gestionLicenciaConduccion.getLicenciaConduccion(licencia);
    }

    public List buscarLicenciasConduccion(LicenciasConduccion licencia) {
        gestionLicenciaConduccion = new GestionLicenciasConduccion();
        return gestionLicenciaConduccion.getLicenciasConduccion(licencia);
    }

    public boolean eliminarLicenciaConduccion(LicenciasConduccion licencia) {
        gestionLicenciaConduccion = new GestionLicenciasConduccion();
        return gestionLicenciaConduccion.eliminarLicenciaConduccion(licencia);
    }
    
    public List getDetalleFacCond(ViewDetConductores detalleConductores)
    {
        gestionLicenciaConduccion = new GestionLicenciasConduccion();
        return gestionLicenciaConduccion.getDetalleFacCond(detalleConductores);
    }
    
    public List getEstadosLicencia(ESTADOS_LICENCIACOND estadoLicencia)
        {
            gestionLicenciaConduccion = new GestionLicenciasConduccion();
            return gestionLicenciaConduccion.getEstadosLicencias(estadoLicencia);
        }
    // restricciones
    
    @WebMethod
    public Restricciones crearRestricciones(Restricciones obj) {
        gestionRestricciones = new GestionRestricciones();
            return gestionRestricciones.crearRestricciones(obj); 
    }
    
    @WebMethod
    public boolean editarRestricciones(Restricciones obj) {
        gestionRestricciones = new GestionRestricciones();
            return gestionRestricciones.editarRestricciones(obj);
    }
    
    @WebMethod
    public Restricciones buscarPrimeroRestricciones(Restricciones obj) {
        gestionRestricciones = new GestionRestricciones();
            return gestionRestricciones.buscarPrimeroRestricciones(obj);
    }
    
    @WebMethod
    public List buscarRestricciones(Restricciones obj) {
        gestionRestricciones = new GestionRestricciones();
            return gestionRestricciones.buscarRestricciones(obj);
    }
    
    @WebMethod
    public List listarRestricciones() {
        gestionRestricciones = new GestionRestricciones();
            return gestionRestricciones.listarRestricciones();
    }
    
    //@WebMethod
    //public boolean eliminarRestricciones(Restricciones obj) {
    //         gestionRestricciones = new GestionRestricciones();
    //      return gestionRestricciones.eliminarRestricciones(obj);
    //}
    
    // restricciones de licencia
    
    @WebMethod
    public Restriccionesdelicencia crearRestriccionesdelicencia(Restriccionesdelicencia obj) {
            gestionRestriccionesdelicencia = new GestionRestriccionesdelicencia();
            return gestionRestriccionesdelicencia.crearRestriccionesdelicencia(obj); 
    }
    
    @WebMethod
    public boolean editarRestriccionesdelicencia(Restriccionesdelicencia obj) {
        gestionRestriccionesdelicencia = new GestionRestriccionesdelicencia();
            return gestionRestriccionesdelicencia.editarRestriccionesdelicencia(obj);
    }
    
    @WebMethod
    public Restriccionesdelicencia buscarPrimeroRestriccionesdelicencia(Restriccionesdelicencia obj) {
        gestionRestriccionesdelicencia = new GestionRestriccionesdelicencia();
            return gestionRestriccionesdelicencia.buscarPrimeroRestriccionesdelicencia(obj);
    }
    
    @WebMethod
    public List buscarRestriccionesdelicencia(Restriccionesdelicencia obj) {
        gestionRestriccionesdelicencia = new GestionRestriccionesdelicencia();
            return gestionRestriccionesdelicencia.buscarRestriccionesdelicencia(obj);
    }
    
    @WebMethod
    public List listarRestriccionesdelicencia() {
        gestionRestriccionesdelicencia = new GestionRestriccionesdelicencia();
            return gestionRestriccionesdelicencia.listarRestriccionesdelicencia();
    }
    
    @WebMethod
    public boolean eliminarRestriccionesdelicencia(Restriccionesdelicencia obj) {
        gestionRestriccionesdelicencia = new GestionRestriccionesdelicencia();
          return gestionRestriccionesdelicencia.eliminarRestriccionesdelicencia(obj);
    }
    
    // vista licencia conduccion
    
    //@WebMethod
    //public Viewlicenciaconduccion crearViewlicenciaconduccion(Viewlicenciaconduccion obj) {
    // 		gestionViewlicenciaconduccion = new GestionViewlicenciaconduccion();
    //      return gestionViewlicenciaconduccion.crearViewlicenciaconduccion(obj); 
    //}
    
    //@WebMethod
    //public boolean editarViewlicenciaconduccion(Viewlicenciaconduccion obj) {
    // 		gestionViewlicenciaconduccion = new GestionViewlicenciaconduccion();
    //      return gestionViewlicenciaconduccion.editarViewlicenciaconduccion(obj);
    //}
    
    @WebMethod
    public Viewlicenciaconduccion buscarPrimeroViewlicenciaconduccion(Viewlicenciaconduccion obj) {
		gestionViewlicenciaconduccion = new GestionViewlicenciaconduccion();
            return gestionViewlicenciaconduccion.buscarPrimeroViewlicenciaconduccion(obj);
    }
    
    @WebMethod
    public List buscarViewlicenciaconduccion(Viewlicenciaconduccion obj) {
		gestionViewlicenciaconduccion = new GestionViewlicenciaconduccion();
            return gestionViewlicenciaconduccion.buscarViewlicenciaconduccion(obj);
    }
    
    @WebMethod
    public List buscarViewlicenciaconduccionPorFecha(Viewlicenciaconduccion obj, 
                                                     @WebParam(name = "fechaIni") Date fechaIni, 
                                                     @WebParam(name = "fechaFin") Date fechaFin) {
		gestionViewlicenciaconduccion = new GestionViewlicenciaconduccion();
            return gestionViewlicenciaconduccion.buscarViewlicenciaconduccion(obj, fechaIni, fechaFin);
    }
    
    @WebMethod
    public List buscarViewlicenciaconduccionPorFechaOK(Viewlicenciaconduccion obj, 
                                                     @WebParam(name = "fechaIni") String fechaIni, 
                                                     @WebParam(name = "fechaFin") String fechaFin) {
                gestionViewlicenciaconduccion = new GestionViewlicenciaconduccion();
            return gestionViewlicenciaconduccion.buscarViewlicenciaconduccionFechasOK(obj, fechaIni, fechaFin);
    }
    
    @WebMethod
    public List listarViewlicenciaconduccion() {
		gestionViewlicenciaconduccion = new GestionViewlicenciaconduccion();
            return gestionViewlicenciaconduccion.listarViewlicenciaconduccion();
    }
    
    //@WebMethod
    //public boolean eliminarViewlicenciaconduccion(Viewlicenciaconduccion obj) {
    // 		gestionViewlicenciaconduccion = new GestionViewlicenciaconduccion();
    //      return gestionViewlicenciaconduccion.eliminarViewlicenciaconduccion(obj);
    //}
    
    // vista licencia residencia
    
    //@WebMethod
    //public Viewlicenciaresidencia crearViewlicenciaresidencia(Viewlicenciaresidencia obj) {
    // 		gestionViewlicenciaresidencia = new GestionViewlicenciaresidencia();
    //      return gestionViewlicenciaresidencia.crearViewlicenciaresidencia(obj); 
    //}
    
    //@WebMethod
    //public boolean editarViewlicenciaresidencia(Viewlicenciaresidencia obj) {
    // 		gestionViewlicenciaresidencia = new GestionViewlicenciaresidencia();
    //      return gestionViewlicenciaresidencia.editarViewlicenciaresidencia(obj);
    //}
    
    @WebMethod
    public Viewlicenciaresidencia buscarPrimeroViewlicenciaresidencia(Viewlicenciaresidencia obj) {
		gestionViewlicenciaresidencia = new GestionViewlicenciaresidencia();
            return gestionViewlicenciaresidencia.buscarPrimeroViewlicenciaresidencia(obj);
    }
    
    @WebMethod
    public List buscarViewlicenciaresidencia(Viewlicenciaresidencia obj) {
		gestionViewlicenciaresidencia = new GestionViewlicenciaresidencia();
            return gestionViewlicenciaresidencia.buscarViewlicenciaresidencia(obj);
    }
    
    @WebMethod
    public List listarViewlicenciaresidencia() {
		gestionViewlicenciaresidencia = new GestionViewlicenciaresidencia();
            return gestionViewlicenciaresidencia.listarViewlicenciaresidencia();
    }
    
    //@WebMethod
    //public boolean eliminarViewlicenciaresidencia(Viewlicenciaresidencia obj) {
    // 		gestionViewlicenciaresidencia = new GestionViewlicenciaresidencia();
    //      return gestionViewlicenciaresidencia.eliminarViewlicenciaresidencia(obj);
    //}
    
    // vista licencia restriccion
    
    //@WebMethod
    //public Viewlicenciarestriccion crearViewlicenciarestriccion(Viewlicenciarestriccion obj) {
    // 		gestionViewlicenciarestriccion = new GestionViewlicenciarestriccion();
    //      return gestionViewlicenciarestriccion.crearViewlicenciarestriccion(obj); 
    //}
    
    //@WebMethod
    //public boolean editarViewlicenciarestriccion(Viewlicenciarestriccion obj) {
    // 		gestionViewlicenciarestriccion = new GestionViewlicenciarestriccion();
    //      return gestionViewlicenciarestriccion.editarViewlicenciarestriccion(obj);
    //}
    
    @WebMethod
    public Viewlicenciarestriccion buscarPrimeroViewlicenciarestriccion(Viewlicenciarestriccion obj) {
		gestionViewlicenciarestriccion = new GestionViewlicenciarestriccion();
            return gestionViewlicenciarestriccion.buscarPrimeroViewlicenciarestriccion(obj);
    }
    
    @WebMethod
    public List buscarViewlicenciarestriccion(Viewlicenciarestriccion obj) {
		gestionViewlicenciarestriccion = new GestionViewlicenciarestriccion();
            return gestionViewlicenciarestriccion.buscarViewlicenciarestriccion(obj);
    }
    
    @WebMethod
    public List listarViewlicenciarestriccion() {
		gestionViewlicenciarestriccion = new GestionViewlicenciarestriccion();
            return gestionViewlicenciarestriccion.listarViewlicenciarestriccion();
    }
    
    //@WebMethod
    //public boolean eliminarViewlicenciarestriccion(Viewlicenciarestriccion obj) {
    // 		gestionViewlicenciarestriccion = new GestionViewlicenciarestriccion();
    //      return gestionViewlicenciarestriccion.eliminarViewlicenciarestriccion(obj);
    //}
    
}
