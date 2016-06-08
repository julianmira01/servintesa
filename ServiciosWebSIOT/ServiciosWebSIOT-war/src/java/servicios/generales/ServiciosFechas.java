package servicios.generales;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;
import modelo.datos.objetos.accesorias.Diasfestivos;

import modelo.datos.objetos.generales.Header;
import modelo.datos.objetos.generales.RuntCombustibleModificado;
import modelo.datos.objetos.generales.RuntMedidaCautelarModificada;
import modelo.datos.objetos.generales.RuntModificarAutomotor;
import modelo.datos.objetos.generales.RuntPrendaModificada;
import modelo.datos.objetos.generales.RuntPropietarioModificado;
import modelo.datos.objetos.generales.RuntRTMModificada;
import modelo.datos.objetos.generales.RuntSoatModificado;
import modelo.datos.objetos.generales.VehiculoRadicadoCta;
import modelo.datos.objetos.generales.vehiculo.RuntVehiculoModificado;
import modelo.datos.objetos.generales.Auditoriatramite;

import modelo.datos.objetos.generales.SumarTiempoFecha;

import modelo.logica.generales.GestionAuditoriaTramite;
import modelo.logica.generales.GestionBiometricos;
import modelo.logica.generales.GestionServiciosDiasfestivos;
import modelo.logica.generales.GestionServiciosGeneralesLocal;


@WebService
public class ServiciosFechas {    
    
    public ServiciosFechas() {
        super();
        crearObjetos();
    }

    @Oneway
    @WebMethod
    public void crearObjetos(){
        
    }

    @WebMethod
    public String agregarDiasHabilesaFecha(String fechaIni, Integer diasHabiles){
        String fechaFinal ="";

        Calendar fecha1 = Calendar.getInstance();
        fecha1.set(Integer.valueOf(fechaIni.substring(0,3)), Integer.valueOf(fechaIni.substring(5,6)), Integer.valueOf(fechaIni.substring(8,9)));

        String strdate = null;

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        if (fecha1 != null) {
            strdate = sdf.format(fecha1.getTime());
        }
        return fechaFinal;
    }

    @WebMethod
    public boolean esFechaFestivoFirebird(String fecha)
    {
        Diasfestivos daoDF = new Diasfestivos();
        daoDF.setFecha(fecha);
        GestionServiciosDiasfestivos gestionFestivos = new GestionServiciosDiasfestivos();
        List listaCoincidencias = gestionFestivos.searchMatching(daoDF);
        if(listaCoincidencias != null && listaCoincidencias.size()>0)
        {
            if(((Diasfestivos)listaCoincidencias.get(0)).getFecha().equals(fecha))
                return true;
            else
                return false;
        }
        else
            return false;
    }
    
    @WebMethod
    public String[] consultarRangoFechasEnDiasCalendario(String fechaIni, String fechaFin, Integer diasCalendario){
        String[] fechas = new String[2];
        
        Calendar fecha1 = Calendar.getInstance();
        fecha1.set(Integer.valueOf(fechaIni.substring(0,3)), Integer.valueOf(fechaIni.substring(5,6)), Integer.valueOf(fechaIni.substring(8,9)));
        fechas [0] = SumarTiempoFecha.sumarDiasCalendario(fecha1, diasCalendario);
        
        Calendar fecha2 = Calendar.getInstance();
        fecha2.set(Integer.valueOf(fechaIni.substring(0,3)), Integer.valueOf(fechaIni.substring(5,6)), Integer.valueOf(fechaIni.substring(8,9)));
        fechas [0] = SumarTiempoFecha.sumarDiasCalendario(fecha1, diasCalendario);
        
        return fechas;
    }
}
