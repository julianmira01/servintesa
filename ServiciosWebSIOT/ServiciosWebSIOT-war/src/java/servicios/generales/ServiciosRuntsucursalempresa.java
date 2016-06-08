package servicios.generales;

import java.util.List;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;

import modelo.datos.objetos.generales.Runtsucursalempresa;

import modelo.logica.generales.GestionRuntsucursalempresa;


@WebService
public class ServiciosRuntsucursalempresa {
    GestionRuntsucursalempresa gestionRuntsucursalempresa;

    public ServiciosRuntsucursalempresa() {
        super();
        crearObjetos();
    }

    @Oneway
    @WebMethod
    public void crearObjetos() {
        gestionRuntsucursalempresa = new GestionRuntsucursalempresa();
    }

    @WebMethod
    public Runtsucursalempresa crearRuntsucursalempresa(Runtsucursalempresa obj) {
        return gestionRuntsucursalempresa.crearRuntsucursalempresa(obj);
    }

    @WebMethod
    public boolean editarRuntsucursalempresa(Runtsucursalempresa obj) {
        return gestionRuntsucursalempresa.editarRuntsucursalempresa(obj);
    }

    @WebMethod
    public Runtsucursalempresa buscarPrimeroRuntsucursalempresa(Runtsucursalempresa obj) {
        return gestionRuntsucursalempresa.buscarPrimeroRuntsucursalempresa(obj);
    }

    @WebMethod
    public List buscarRuntsucursalempresa(Runtsucursalempresa obj) {
        return gestionRuntsucursalempresa.buscarRuntsucursalempresa(obj);
    }

    @WebMethod
    public List listarRuntsucursalempresa() {
        return gestionRuntsucursalempresa.listarRuntsucursalempresa();
    }

    @WebMethod
    public boolean eliminarRuntsucursalempresa(Runtsucursalempresa obj) {
        return gestionRuntsucursalempresa.eliminarRuntsucursalempresa(obj);
    }


}
