package servicios.centroConduccion;

import java.util.List;

import javax.jws.WebService;

import modelo.datos.objetos.centroConduccion.CentroConduccion;
import modelo.datos.objetos.licenciasConduccion.LicenciasConduccion;
import modelo.logica.CentroConduccion.GestionCentroConduccion;
import modelo.logica.accesorias.GestionServiciosAccesoriasLocal;


@WebService
public class ServiciosCentroConduccion {
    GestionCentroConduccion gestionCentroConduccion;

    public ServiciosCentroConduccion() {
        super();
        gestionCentroConduccion = new GestionCentroConduccion();
    }

    public int crearCentroConduccion(CentroConduccion centro) {
        return gestionCentroConduccion.crearCentroConduccion(centro);
    }

    public boolean modificarCentroConduccion(CentroConduccion centro) {
        return gestionCentroConduccion.modificarCentroConduccion(centro);
    }

    public CentroConduccion buscarCentroConduccion(CentroConduccion centro) {
        return gestionCentroConduccion.getCentroConduccion(centro);
    }

    public boolean eliminarCentroConduccion(CentroConduccion centro) {
        return gestionCentroConduccion.eliminarCentroConduccion(centro);
    }
    
    public List listarCentrosConduccion() {
        return gestionCentroConduccion.listarCentrosConduccion();
    }
    
}