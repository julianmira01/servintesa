package servicios.generales;

import java.util.List;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;

import modelo.datos.objetos.generales.Sucursal;

import modelo.logica.generales.GestionServiciosSucursalesLocal;


@WebService
public class ServiciosSucursales {
    
    GestionServiciosSucursalesLocal gestionServiciosSucursalesLocal;
    
    public ServiciosSucursales() {
        super();
        crearObjetos();
    }

    @WebMethod
    @Oneway
    public void crearObjetos(){
      gestionServiciosSucursalesLocal = new GestionServiciosSucursalesLocal();
    }

    @WebMethod
    public List getSucursal(Sucursal mySucursal){
       return gestionServiciosSucursalesLocal.getSucursal(mySucursal);
    }

    @WebMethod
    public Sucursal crearSucursal(Sucursal mySucursal){
      return gestionServiciosSucursalesLocal.crearSucursal(mySucursal);
    }
    
    @WebMethod
    public Sucursal actualizarSucursal(Sucursal mySucursal){
      return gestionServiciosSucursalesLocal.actualizarSucursal(mySucursal);
    }
}
