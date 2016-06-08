package servicios.generales;


import java.util.List;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;

import modelo.datos.objetos.generales.propietarioDeVehiculo.PropietarioDeVehiculo;
import modelo.datos.objetos.generales.propietarioDeVehiculo.ViewPropietarios;
import modelo.datos.objetos.tramites.ViewTotalTraspasos;

import modelo.logica.generales.GestionServiciosPropietariosLocal;


@WebService
public class ServiciosPropietarios {
    
    GestionServiciosPropietariosLocal gestionServiciosPropietariosLocal;

    public ServiciosPropietarios() {
        super();
        crearObjetos();
    }

    @WebMethod
    @Oneway
    public void crearObjetos(){
        gestionServiciosPropietariosLocal = new GestionServiciosPropietariosLocal();
    }

    @WebMethod
    public List getPropietariosDeVehiculos(PropietarioDeVehiculo propietario){
        return gestionServiciosPropietariosLocal.getPropietarios(propietario);
    }
    
    @WebMethod
    public boolean createPropietariosDeVehiculos(PropietarioDeVehiculo propietario,int idUsuario,String myIp,String myHost){
        return gestionServiciosPropietariosLocal.createPropietarios(propietario,idUsuario,myIp,myHost);
    }
    
    @WebMethod
    public boolean actualizarPropietarioDeVehiculo(PropietarioDeVehiculo propietario,int idUsuario,String myIp,String myHost){
        return gestionServiciosPropietariosLocal.actualizarPropietarioDeVehiculo(propietario,idUsuario,myIp,myHost);
    }
    
    @WebMethod
    public boolean cambiarestadoPropietariosDeVehiculos(PropietarioDeVehiculo propietario,int idUsuario,String myIp,String myHost){
        return gestionServiciosPropietariosLocal.cambiarEstadoPropietarios(propietario,idUsuario,myIp,myHost);
    }
    
    @WebMethod
    public List getTotalTraspasos(ViewTotalTraspasos totalTraspasos){
        return gestionServiciosPropietariosLocal.getTotalTraspasos(totalTraspasos);
    }
    
    @WebMethod
    public boolean eliminarPropietarioVehiculo(PropietarioDeVehiculo propietario,int idUsuario,String myIp,String myHost)
    {
        return gestionServiciosPropietariosLocal.eliminarPropietariosDeVehiculo(propietario,idUsuario,myIp,myHost);
    }
           
    @WebMethod
    public boolean borrarPropietarioVehiculo(PropietarioDeVehiculo propietario)
    {
        return gestionServiciosPropietariosLocal.borrarPropietarioVehiculo(propietario);
    }
    
    @WebMethod
    public boolean desvincularPropietarioDeVehiculo(PropietarioDeVehiculo propietario,int idUsuario,String myIp,String myHost){
        return gestionServiciosPropietariosLocal.desvincularPropietarioDeVehiculo(propietario, idUsuario, myIp, myHost);
    }
    
    @WebMethod
    public List getViewPropietariosDeVehiculos(ViewPropietarios viewPropietario){
        return gestionServiciosPropietariosLocal.getViewPropietarios(viewPropietario);
    }
    
}

