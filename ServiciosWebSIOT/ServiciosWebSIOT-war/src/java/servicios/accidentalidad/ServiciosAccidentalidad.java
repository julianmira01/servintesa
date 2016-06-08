package servicios.accidentalidad;

import java.util.List;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import modelo.datos.objetos.accidentalidad.AccesoriaAccidente;
import modelo.datos.objetos.accidentalidad.Accidente;
import modelo.datos.objetos.accidentalidad.CitasAudiencia;
import modelo.datos.objetos.accidentalidad.ComparendoAccidente;
import modelo.datos.objetos.accidentalidad.DeclaracionesAudiencia;
import modelo.datos.objetos.accidentalidad.FalloAudiencia;
import modelo.datos.objetos.accidentalidad.Implicado;

import modelo.datos.objetos.accidentalidad.VehiculoAccidente;

import modelo.logica.accidentalidad.GestionAccidentalidad;

import utilidades.Funciones;

@WebService
public class ServiciosAccidentalidad {
    
    public ServiciosAccidentalidad() {
        super();
        crearObjetos();
    }

    @Oneway
    @WebMethod
    public void crearObjetos() {
    }
    
    @WebMethod
    public int getConsecutivoAccidente() {
        GestionAccidentalidad gestion = new GestionAccidentalidad();
        return gestion.getConsecutivoAccidente();
    }

    @WebMethod
    public Implicado crearImplicado(Implicado obj) {
        GestionAccidentalidad gestion = new GestionAccidentalidad();
        return gestion.crearImplicado(obj);
    }
    
    @WebMethod
    public FalloAudiencia crearFalloAudiencia(FalloAudiencia obj) {
        GestionAccidentalidad gestion = new GestionAccidentalidad();
        return gestion.crearFalloAudiencia(obj);
    }
    
    public CitasAudiencia crearCitaAudiencia(CitasAudiencia obj) {
        GestionAccidentalidad gestion = new GestionAccidentalidad();
        return gestion.crearCitaAudiencia(obj);
    }
    
    public DeclaracionesAudiencia crearDeclaracionesAudiencia(DeclaracionesAudiencia obj) {
        GestionAccidentalidad gestion = new GestionAccidentalidad();
        return gestion.crearDeclaracionesAudiencia(obj);
    }
    
    @WebMethod
    public VehiculoAccidente crearVehiculoAccidente(VehiculoAccidente obj) {
        GestionAccidentalidad gestion = new GestionAccidentalidad();
        return gestion.crearVehiculoAccidente(obj);
    }
    
    public ComparendoAccidente crearComparendoAccidente(ComparendoAccidente obj) {
        GestionAccidentalidad gestion = new GestionAccidentalidad();
        return gestion.crearComparendoAccidente(obj);
    }
    
    @WebMethod
    public Accidente crearAccidente(Accidente obj) {
        GestionAccidentalidad gestion = new GestionAccidentalidad();
        return gestion.crearAccidente(obj);
    }
    
    @WebMethod
    public List consultarFalloAudiencia(FalloAudiencia obj) {
        GestionAccidentalidad gestion = new GestionAccidentalidad();
        return gestion.consultarFalloAudiencia(obj);
    }
    
    @WebMethod    
    public List consultarImplicados(Implicado obj) {
        GestionAccidentalidad gestion = new GestionAccidentalidad();
        return gestion.buscarImplicados(obj);
    }
    
    @WebMethod
    public List consultarCitasAudiencia(CitasAudiencia obj) {
        GestionAccidentalidad gestion = new GestionAccidentalidad();
        return gestion.consultarCitasAudiencia(obj);
    }
    
    @WebMethod
    public List consultarDeclaracionesAudiencia(DeclaracionesAudiencia obj) {
        GestionAccidentalidad gestion = new GestionAccidentalidad();
        return gestion.consultarDeclaracionesAccidente(obj);
    }
    
    @WebMethod
    public List consultarVehiculosAccidente(VehiculoAccidente obj) {
        GestionAccidentalidad gestion = new GestionAccidentalidad();
        return gestion.buscarVechiculosAccidentes(obj);
    }
    
    public List consultarComparendosAccidente(ComparendoAccidente obj) {
        GestionAccidentalidad gestion = new GestionAccidentalidad();
        return gestion.buscarComparendosAccidentes(obj);
    }
    
    @WebMethod
    public Implicado consultarImplicado(Implicado obj) {
        GestionAccidentalidad gestion = new GestionAccidentalidad();
        return gestion.buscarPrimeroImplicado(obj);
    }
    
    @WebMethod
    public VehiculoAccidente consultarVehiculoAccidente(VehiculoAccidente obj) {
        GestionAccidentalidad gestion = new GestionAccidentalidad();
        return gestion.buscarPrimeroVechiculoAccidente(obj);
    }
    
    @WebMethod
    public List consultarAccesoriasAccidente(AccesoriaAccidente valueObject) {
        GestionAccidentalidad gestion = new GestionAccidentalidad();
        return gestion.listarAccesoriaAccidente(valueObject);
    }
    
    @WebMethod
    public List  consultarAccidentesRangoFechas(String fecha1, String fecha2)
    {
        GestionAccidentalidad gestion = new GestionAccidentalidad();
        return gestion.consultarAccidentesRangoFechas(fecha1, fecha2);
    }

    @WebMethod
    public List consultarAccidente(Accidente valueObject) {
        GestionAccidentalidad gestion = new GestionAccidentalidad();
        return gestion.consultarAccidentes(valueObject);
    }
    
    @WebMethod
    public boolean eliminarImplicado(Implicado obj) {
        GestionAccidentalidad gestion = new GestionAccidentalidad();
        return gestion.eliminarImplicados(obj);
    }
    
    @WebMethod
    public boolean eliminarCitaAudiencia(CitasAudiencia obj) {
        GestionAccidentalidad gestion = new GestionAccidentalidad();
        return gestion.eliminarCitasAudiencia(obj);
    }
    
    @WebMethod
    public boolean eliminarFalloAudiencia(FalloAudiencia obj) {
        GestionAccidentalidad gestion = new GestionAccidentalidad();
        return gestion.eliminarFalloAudiencia(obj);
    }
    
    @WebMethod
    public boolean eliminarDeclaracionesAudiencia(DeclaracionesAudiencia obj) {
        GestionAccidentalidad gestion = new GestionAccidentalidad();
        return gestion.eliminarDeclaracionesAudiencia(obj);
    }
    
    @WebMethod
    public boolean eliminarVehiculoAccidente(VehiculoAccidente obj) {
        GestionAccidentalidad gestion = new GestionAccidentalidad();
        return gestion.eliminarVehiculoAccidente(obj);
    }
    
    @WebMethod
    public boolean eliminarComparendoAccidente(ComparendoAccidente obj) {
        GestionAccidentalidad gestion = new GestionAccidentalidad();
        return gestion.eliminarComparendoAccidente(obj);
    }
    
    @WebMethod
    public boolean actualizarAccidente(Accidente obj)
    {
        GestionAccidentalidad gestion = new GestionAccidentalidad();
        return gestion.editarAccidente(obj);
    }
}
