package servicios.rangos;

import java.util.List;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;

import modelo.datos.objetos.generales.Usuarios;
import modelo.datos.objetos.rangos.DetPlacaGenerada;
import modelo.datos.objetos.rangos.RangosDeplacas;
import modelo.datos.objetos.rangos.RangosLicencias;

import modelo.logica.rangos.GestionServiciosRangos;


@WebService
public class ServiciosRangos {
    GestionServiciosRangos gestionServiciosRangos;

    public ServiciosRangos() {
        super();
        crearObjetos();
    }

    @Oneway
    @WebMethod
    public void crearObjetos() {
        gestionServiciosRangos = new GestionServiciosRangos();
    }

    @WebMethod
    public List buscarRangoDePlaca(RangosDeplacas myRangoPlaca) {
        return gestionServiciosRangos.getRangoDePlaca(myRangoPlaca);
    }

    @WebMethod
    public List listarRangosDePlacas() {
        return gestionServiciosRangos.getRangosDePlacas();
    }

    @WebMethod
    public List listarRangosDePlacasRemolquesSemiremolques() {
        return gestionServiciosRangos.getRangosDePlacasRemolquesSemiremolques();
    }
    
    @WebMethod
    public List listarRangosDePlacasMaquinaria() {
        return gestionServiciosRangos.getRangosDePlacasMaquinarias();
    }

    @WebMethod
    public RangosDeplacas insertarRangoDePlacas(RangosDeplacas myRango, String tipovehiculo, Usuarios myusuario,
                                                String host, String ip) {
        return gestionServiciosRangos.insertarRangoDePlacas(myRango, tipovehiculo, myusuario, host, ip);
    }
    
    @WebMethod
    public RangosDeplacas insertarRangoDePlacasRemolquesSemiremolques(RangosDeplacas myRango, String tipovehiculo, Usuarios myusuario,
                                                String host, String ip) {
        return gestionServiciosRangos.insertarRangoDePlacasRemolquesSemiremolques(myRango, tipovehiculo, myusuario, host, ip);
    }
    
    @WebMethod
    public RangosDeplacas insertarRangoDePlacasMaquinaria(RangosDeplacas myRango, String tipovehiculo, Usuarios myusuario,
                                                String host, String ip) {
        return gestionServiciosRangos.insertarRangoDePlacasMaquinaria(myRango, tipovehiculo, myusuario, host, ip);
    }

    @WebMethod
    public RangosDeplacas editarRangoDePlacas(RangosDeplacas myRango, Usuarios myusuario, String host, String ip) {
        return gestionServiciosRangos.editarRangoDePlacas(myRango, myusuario, host, ip);
    }

    @WebMethod
    public List buscarRangoLicencia(RangosLicencias myRangoPlaca) {
        return gestionServiciosRangos.getRangoLicencia(myRangoPlaca);
    }

    @WebMethod
    public List listarRangosLicencias() {
        return gestionServiciosRangos.getRangosLicencias();
    }

    @WebMethod
    public RangosLicencias insertarRangoLicencias(RangosLicencias myRango) {
        return gestionServiciosRangos.insertarRangoLicencias(myRango);
    }

    @WebMethod
    public RangosLicencias editarRangoLicencias(RangosLicencias myRango) {
        return gestionServiciosRangos.editarRangoLicencias(myRango);
    }

    @WebMethod
    public RangosDeplacas getRangoDePlacaActivo(RangosDeplacas myRangoPlaca) {
        return gestionServiciosRangos.getRangoDePlacaActivo(myRangoPlaca);
    }

    
    @WebMethod
    public List getRangoDePlacaActivoAll(RangosDeplacas myRangoPlaca) {
        return gestionServiciosRangos.getRangoDePlacaActivoAll(myRangoPlaca);
    }
    
    @WebMethod
    public List getRangoDePlacaActivoSinMotos(RangosDeplacas myRangoPlaca) {
        return gestionServiciosRangos.getRangoDePlacaActivoSinMotos(myRangoPlaca);
    }

    
    @WebMethod
    public List getRangoDePlacaActivoAllF(RangosDeplacas myRangoPlaca) {
        return gestionServiciosRangos.getRangoDePlacaActivoAll(myRangoPlaca);
    }


    @WebMethod
    public List getDetPlacaGenerada(DetPlacaGenerada myDetPlacaGen) {
        return gestionServiciosRangos.getDetPlacaGenerada(myDetPlacaGen);
    }

    @WebMethod
    public boolean editarDetPlacaGenerada(DetPlacaGenerada myDetPlacaGen) {
        return gestionServiciosRangos.editarDetPlacaGenerada(myDetPlacaGen);
    }


    @WebMethod
    public String getPlaca(int id) {
        return gestionServiciosRangos.getPlaca(id);
    }

    @WebMethod
    public boolean registrarPlaca(int idPlaca) {
        return gestionServiciosRangos.registrarPlaca(idPlaca);
    }


    @WebMethod
    public boolean borrarRangoPlacas(RangosDeplacas rango, Usuarios myusuario, String host, String ip) {
        return gestionServiciosRangos.eliminarRango(rango, myusuario, host, ip);
    }

    public boolean liberarPlaca(int idPlaca) {
        return gestionServiciosRangos.liberarPlaca(idPlaca);
    }

}

