package servicios.logs;

import java.util.List;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import modelo.datos.objetos.logs.ErroresSW;

import modelo.logica.logs.GestionErroresSW;


import modelo.logica.usuarios.GestionServiciosUsuarios;

import servicios.generales.ServiciosVehiculos;

import utilidades.Funciones;


@WebService
public class ServiciosErroresSW {

    GestionErroresSW gestionErroresSW;

    public ServiciosErroresSW() {
        super();
        crearObjetos();
    }

    @Oneway
    @WebMethod
    public void crearObjetos() {
        gestionErroresSW = new GestionErroresSW();
    }

    @WebMethod
    public List buscarErroresSW(ErroresSW log) {
        return gestionErroresSW.buscarErroresSW(log);
    }
    
    @WebMethod
    public ErroresSW crearRegistroErroresSW(ErroresSW log) {
        return gestionErroresSW.crearErroresSW(log);
    }
    
    @WebMethod
    public ErroresSW actualizarErrorSW(ErroresSW log) {
        return gestionErroresSW.editarErroresSW(log);
    }
    
    @WebMethod
    public boolean eliminarErrorSW(ErroresSW log) {
        return gestionErroresSW.eliminarErroresSW(log);
    }
}
