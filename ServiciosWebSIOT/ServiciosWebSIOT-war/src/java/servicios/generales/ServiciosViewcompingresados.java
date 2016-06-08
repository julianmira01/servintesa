package servicios.generales;

import java.util.List;

//import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import modelo.datos.objetos.comparendos.generales.Viewcompingresados;

import modelo.logica.comparendos.generales.GestionViewcompingresados;

import utilidades.Seguridad;

@WebService
public class ServiciosViewcompingresados{
	GestionViewcompingresados gestionViewcompingresados;
	
	public ServiciosViewcompingresados() {
		super();
		crearObjetos();
	}

    @WebMethod
    @Oneway
    public void crearObjetos(){
		gestionViewcompingresados = new GestionViewcompingresados();
	}

    @WebMethod
    public Viewcompingresados crearViewcompingresados(@WebParam(name = "arg0")
        int id, @WebParam(name = "arg1")
        String token, @WebParam(name = "arg2")
        Viewcompingresados obj ) {
				return gestionViewcompingresados.crearViewcompingresados(obj); 
	}

    @WebMethod
    public boolean editarViewcompingresados(@WebParam(name = "arg0")
        int id, @WebParam(name = "arg1")
        String token, @WebParam(name = "arg2")
        Viewcompingresados obj) {
				return gestionViewcompingresados.editarViewcompingresados(obj);
	}

    @WebMethod
    public Viewcompingresados buscarPrimeroViewcompingresados(@WebParam(name = "arg0")
        int id, @WebParam(name = "arg1")
        String token, @WebParam(name = "arg2")
        Viewcompingresados obj) {
				return gestionViewcompingresados.buscarPrimeroViewcompingresados(obj);
	}

    @WebMethod(exclude = true)
    public List buscarViewcompingresados(int id, String token,Viewcompingresados obj) {
				return gestionViewcompingresados.buscarViewcompingresados(obj);
	}

    @WebMethod
    public List buscarPaginacionViewcompingresados(@WebParam(name = "arg0")
        int id, @WebParam(name = "arg1")
        String token, @WebParam(name = "arg2")
        Viewcompingresados obj, @WebParam(name = "arg3")
        int pag, @WebParam(name = "arg4")
        int numReg) {
				return gestionViewcompingresados.buscarViewcompingresados(obj, pag, numReg);
	}

    @WebMethod
    public List listarViewcompingresados(@WebParam(name = "arg0")
        int id, @WebParam(name = "arg1")
        String token) {
			return gestionViewcompingresados.listarViewcompingresados();
	}

    @WebMethod
    public List listarPaginacionViewcompingresados(@WebParam(name = "arg0")
        int id, @WebParam(name = "arg1")
        String token, @WebParam(name = "arg2")
        int pag, @WebParam(name = "arg3")
        int numReg) {
			return gestionViewcompingresados.listarViewcompingresados(pag, numReg);
	}

    @WebMethod
    public int contarBusquedaViewcompingresados(@WebParam(name = "arg0")
        int id, @WebParam(name = "arg1")
        String token, @WebParam(name = "arg2")
        Viewcompingresados obj) {
				return gestionViewcompingresados.contarBusquedaViewcompingresados(obj);
	}

    @WebMethod(exclude = true)
    public boolean eliminarViewcompingresados(int id, String token,Viewcompingresados obj) {
				return gestionViewcompingresados.eliminarViewcompingresados(obj);
	}

    @WebMethod
    public List buscarViewcompingresadosFechas(@WebParam(name = "arg0")
        Viewcompingresados obj, @WebParam(name = "arg1")
        String fecha1, @WebParam(name = "arg2")
        String fecha2) {
            return gestionViewcompingresados.buscarViewcompingresadosFechas(obj, fecha1, fecha2);
        }
}
