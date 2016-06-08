package servicios.generales;


import javax.jws.WebParam;
import javax.jws.WebService;

import modelo.datos.objetos.generales.ViewPropietario;
import java.util.List;

import javax.jws.WebMethod;

import modelo.datos.objetos.generales.vistas.ViewPopietarioEmpresa2;

import modelo.logica.generales.GestionServiciosEmpresasLocal;
import modelo.logica.generales.GestionServiciosViewPropietario;


@WebService
public class ServiciosViewPropietario {
    GestionServiciosViewPropietario gestionServiciosViewPropietario;
    
    public ServiciosViewPropietario() {
        super();
        gestionServiciosViewPropietario = new GestionServiciosViewPropietario();
    }


    @WebMethod
    public List listarViewPropietarios(@WebParam(name = "arg0")
        ViewPropietario viewPropietario){
        return gestionServiciosViewPropietario.getViewPropietarios(viewPropietario);
        }
}
