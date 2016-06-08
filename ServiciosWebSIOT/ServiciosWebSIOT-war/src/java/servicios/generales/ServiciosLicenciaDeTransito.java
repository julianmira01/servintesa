package servicios.generales;

import java.util.List;

import javax.jws.WebService;

import modelo.datos.objetos.generales.LicenciaDeTransito;

import modelo.logica.generales.GestionServiciosLicenciaDeTransito;


@WebService
public class ServiciosLicenciaDeTransito {
    private GestionServiciosLicenciaDeTransito myGestionLicenciaDeTransito;
    
    public ServiciosLicenciaDeTransito() {
        super();
        myGestionLicenciaDeTransito = new GestionServiciosLicenciaDeTransito();
    }
    
    public LicenciaDeTransito getLicenciaDeTransito(LicenciaDeTransito myLicencia)
    {
        return myGestionLicenciaDeTransito.getLicenciaDeTransito(myLicencia);
    }
    
    public List getLicenciasDeTransito(LicenciaDeTransito myLicencia)
    {
        return myGestionLicenciaDeTransito.getLicenciasDeTransito(myLicencia);
    }

    public List getLicenciasDeTransitoSinFechaExpedicion()
    {
        return myGestionLicenciaDeTransito.getLicenciasDeTransitoSinFechaExpedicion();
    }
    
    public List getLicenciasDeTransitoSinFechaExpedicionF()
    {
        return myGestionLicenciaDeTransito.getLicenciasDeTransitoSinFechaExpedicion();
    }
    
    public LicenciaDeTransito crearLicenciaDeTransito(LicenciaDeTransito licenciaDeTransito){
        return myGestionLicenciaDeTransito.crearLicenciaDeTransito(licenciaDeTransito);
    }
    
    public boolean actualizarNroLicenciaDeTransito(int idLic,String nroLic){
        return myGestionLicenciaDeTransito.actualizarNroLicenciaDeTransito(idLic, nroLic);
    }
    
    
    public boolean actualizarLicenciaDeTransito(LicenciaDeTransito licenciaDeTransito){
        return myGestionLicenciaDeTransito.actualizarLicenciaDeTransito(licenciaDeTransito);
    }    
    
    public boolean eliminarLicenciaDeTransito(LicenciaDeTransito licenciaDeTransito){
        return myGestionLicenciaDeTransito.eliminarLicenciaDeTransito(licenciaDeTransito);
    }
}
