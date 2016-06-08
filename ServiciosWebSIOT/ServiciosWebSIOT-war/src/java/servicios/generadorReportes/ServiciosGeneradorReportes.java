package servicios.basedatos;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import modelo.datos.objetos.generadorReportes.Basedatos;
import modelo.datos.objetos.generadorReportes.Columnasseleccionadas;

import modelo.logica.generadorReportes.GestionBasedatos;
import modelo.logica.generadorReportes.GestionColumnasseleccionadas;


@WebService
public class ServiciosGeneradorReportes {
    GestionBasedatos gestionBasedatos;
    GestionColumnasseleccionadas gestionColumnasseleccionadas;

    public ServiciosGeneradorReportes() {
        super();
        crearObjetos();
    }

    private void crearObjetos() {
        gestionBasedatos = new GestionBasedatos();
        gestionColumnasseleccionadas = new GestionColumnasseleccionadas();
    }

    // GestionBasedatos

    @WebMethod
    public Basedatos crearBasedatos(Basedatos obj) {
        return gestionBasedatos.crearBasedatos(obj);
    }

    @WebMethod
    public boolean editarBasedatos(Basedatos obj) {
        return gestionBasedatos.editarBasedatos(obj);
    }

    @WebMethod
    public Basedatos buscarPrimeroBasedatos(Basedatos obj) {
        return gestionBasedatos.buscarPrimeroBasedatos(obj);
    }

    @WebMethod
    public List buscarBasedatos(Basedatos obj) {
        return gestionBasedatos.buscarBasedatos(obj);
    }

    @WebMethod
    public List listarBasedatos() {
        return gestionBasedatos.listarBasedatos();
    }

    @WebMethod
    public boolean eliminarBasedatos(Basedatos obj) {
        return gestionBasedatos.eliminarBasedatos(obj);
    }

    // Columnasseleccionadas

    @WebMethod
    public Columnasseleccionadas crearColumnasseleccionadas(Columnasseleccionadas obj) {
        return gestionColumnasseleccionadas.crearColumnasseleccionadas(obj);
    }

    @WebMethod
    public boolean editarColumnasseleccionadas(Columnasseleccionadas obj) {
        return gestionColumnasseleccionadas.editarColumnasseleccionadas(obj);
    }

    @WebMethod
    public Columnasseleccionadas buscarPrimeroColumnasseleccionadas(Columnasseleccionadas obj) {
        return gestionColumnasseleccionadas.buscarPrimeroColumnasseleccionadas(obj);
    }

    @WebMethod
    public List buscarColumnasseleccionadas(Columnasseleccionadas obj) {
        return gestionColumnasseleccionadas.buscarColumnasseleccionadas(obj);
    }

    @WebMethod
    public List listarColumnasseleccionadas() {
        return gestionColumnasseleccionadas.listarColumnasseleccionadas();
    }

    @WebMethod
    public boolean eliminarColumnasseleccionadas(Columnasseleccionadas obj) {
        return gestionColumnasseleccionadas.eliminarColumnasseleccionadas(obj);
    }

    //

}

