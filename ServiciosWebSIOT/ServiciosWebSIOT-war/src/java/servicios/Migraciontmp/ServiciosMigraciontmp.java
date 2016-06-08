package servicios.Migraciontmp;


import java.util.List;

//import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;

import modelo.datos.objetos.Migraciontmp.Migraciontmp;

import modelo.logica.Migraciontmp.GestionMigraciontmp;

import utilidades.Seguridad;

@WebService
public class ServiciosMigraciontmp{
	GestionMigraciontmp gestionMigraciontmp;
	
	public ServiciosMigraciontmp() {
		super();
		crearObjetos();
	}


    @WebMethod
    @Oneway
    public void crearObjetos(){
		gestionMigraciontmp = new GestionMigraciontmp();
	}


    @WebMethod(exclude = true)
    public Migraciontmp crearMigraciontmp(Migraciontmp obj ) {
				return gestionMigraciontmp.crearMigraciontmp(obj); 
	}


    @WebMethod
    public boolean editarMigraciontmp(@WebParam(name = "arg0")
        Migraciontmp obj) {
				return gestionMigraciontmp.editarMigraciontmp(obj);
	}


    @WebMethod
    public Migraciontmp buscarPrimeroMigraciontmp(@WebParam(name = "arg0")
        Migraciontmp obj) {
				return gestionMigraciontmp.buscarPrimeroMigraciontmp(obj);
	}


    @WebMethod
    public List buscarMigraciontmp(@WebParam(name = "arg0")
        Migraciontmp obj) {
				return gestionMigraciontmp.buscarMigraciontmp(obj);
	}


    @WebMethod
    public List buscarPaginacionMigraciontmp(@WebParam(name = "arg0")
        Migraciontmp obj, @WebParam(name = "arg1")
        int pag, @WebParam(name = "arg2")
        int numReg) {
				return gestionMigraciontmp.buscarMigraciontmp(obj, pag, numReg);
	}


    @WebMethod
    public List listarMigraciontmp(@WebParam(name = "arg0")
        int id, @WebParam(name = "arg1")
        String token) {
			return gestionMigraciontmp.listarMigraciontmp();
	}


    @WebMethod(exclude = true)
    public List listarPaginacionMigraciontmp(int id, String token, int pag, int numReg) {
			return gestionMigraciontmp.listarMigraciontmp(pag, numReg);
	}


    @WebMethod
    public int contarBusquedaMigraciontmp(@WebParam(name = "arg0")
        int id, @WebParam(name = "arg1")
        String token, @WebParam(name = "arg2")
        Migraciontmp obj) {
				return gestionMigraciontmp.contarBusquedaMigraciontmp(obj);
	}


    @WebMethod
    public boolean eliminarMigraciontmp(@WebParam(name = "arg0")
        int id, @WebParam(name = "arg1")
        String token, @WebParam(name = "arg2")
        Migraciontmp obj) {
				return gestionMigraciontmp.eliminarMigraciontmp(obj);
	}
}
