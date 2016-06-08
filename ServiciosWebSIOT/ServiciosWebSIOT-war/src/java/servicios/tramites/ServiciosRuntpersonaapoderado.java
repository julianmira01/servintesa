package servicios.runtpersonaapoderado;

import java.util.List;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;

import modelo.datos.objetos.tramites.Runtpersonaapoderado;

import modelo.logica.tramites.GestionRuntpersonaapoderado;


@WebService
public class ServiciosRuntpersonaapoderado{
	GestionRuntpersonaapoderado gestionRuntpersonaapoderado;
	
	public ServiciosRuntpersonaapoderado() {
		super();
		crearObjetos();
	}
	
	@Oneway
	@WebMethod
    public void crearObjetos(){
		gestionRuntpersonaapoderado = new GestionRuntpersonaapoderado();
	}
	
	@WebMethod
	public Runtpersonaapoderado crearRuntpersonaapoderado(Runtpersonaapoderado obj) {
		return gestionRuntpersonaapoderado.crearRuntpersonaapoderado(obj); 
	}
	
	@WebMethod
	public boolean editarRuntpersonaapoderado(Runtpersonaapoderado obj) {
		return gestionRuntpersonaapoderado.editarRuntpersonaapoderado(obj);
	}
	
	@WebMethod
	public Runtpersonaapoderado buscarPrimeroRuntpersonaapoderado(Runtpersonaapoderado obj) {
		return gestionRuntpersonaapoderado.buscarPrimeroRuntpersonaapoderado(obj);
	}
	
	@WebMethod
	public List buscarRuntpersonaapoderado(Runtpersonaapoderado obj) {
		return gestionRuntpersonaapoderado.buscarRuntpersonaapoderado(obj);
	}
	
	@WebMethod
	public List listarRuntpersonaapoderado() {
		return gestionRuntpersonaapoderado.listarRuntpersonaapoderado();
	}
	
	@WebMethod
	public boolean eliminarRuntpersonaapoderado(Runtpersonaapoderado obj) {
		return gestionRuntpersonaapoderado.eliminarRuntpersonaapoderado(obj);
	}
		
	
}
