package servicios.generales;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import modelo.datos.objetos.generales.vehiculo.Viewtramitesvehiculoporfecha;

import modelo.logica.generales.vehiculo.GestionViewtramitesvehiculoporfecha;


@WebService
public class ServiciosViewtramitesvehiculoporfecha{
	GestionViewtramitesvehiculoporfecha gestionViewtramitesvehiculoporfecha;
	
	public ServiciosViewtramitesvehiculoporfecha() {
		super();
		crearObjetos();
	}
	
    private void crearObjetos(){
		gestionViewtramitesvehiculoporfecha = new GestionViewtramitesvehiculoporfecha();
	}
	
	//@WebMethod
	//public Viewtramitesvehiculoporfecha crearViewtramitesvehiculoporfecha(Viewtramitesvehiculoporfecha obj) {
//		return gestionViewtramitesvehiculoporfecha.crearViewtramitesvehiculoporfecha(obj); 
	//}
	
	//@WebMethod
	//public boolean editarViewtramitesvehiculoporfecha(Viewtramitesvehiculoporfecha obj) {
	//	return gestionViewtramitesvehiculoporfecha.editarViewtramitesvehiculoporfecha(obj);
	//}
	
	@WebMethod
	public Viewtramitesvehiculoporfecha buscarPrimeroViewtramitesvehiculoporfecha(Viewtramitesvehiculoporfecha obj) {
		return gestionViewtramitesvehiculoporfecha.buscarPrimeroViewtramitesvehiculoporfecha(obj);
	}
	
	@WebMethod
	public List buscarViewtramitesvehiculoporfecha(Viewtramitesvehiculoporfecha obj) {
		return gestionViewtramitesvehiculoporfecha.buscarViewtramitesvehiculoporfecha(obj);
	}
	
	@WebMethod
	public List listarViewtramitesvehiculoporfecha() {
		return gestionViewtramitesvehiculoporfecha.listarViewtramitesvehiculoporfecha();
	}
	
	//@WebMethod
	//public boolean eliminarViewtramitesvehiculoporfecha(Viewtramitesvehiculoporfecha obj) {
	//	return gestionViewtramitesvehiculoporfecha.eliminarViewtramitesvehiculoporfecha(obj);
	//}
	
	@WebMethod
	public List listarTramitesdevehiculos() {
		return gestionViewtramitesvehiculoporfecha.listarTramitesdevehiculos();
	}
}

