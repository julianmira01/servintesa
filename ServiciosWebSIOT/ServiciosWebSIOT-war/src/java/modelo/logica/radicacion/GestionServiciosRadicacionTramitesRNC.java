package modelo.logica.radicacion;

import java.sql.Connection;

import java.util.ArrayList;
import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.accesorias.ColoresDao;
import modelo.datos.dao.accesorias.RequisitotramiteDao;
import modelo.datos.dao.generales.EmpresaDao;
import modelo.datos.dao.generales.PersonaDao;
import modelo.datos.dao.generales.RepresentanteLegalDao;
import modelo.datos.dao.generales.RuntDuplicadoPlacaDao;
import modelo.datos.dao.generales.RuntRegrabacionVehiculoDao;
import modelo.datos.dao.generales.SucursalDao;
import modelo.datos.dao.generales.vehiculo.VehiculoDao;
import modelo.datos.dao.tramites.CabrequisitobaseDao;
import modelo.datos.dao.tramites.DetrequisitobaseDao;
import modelo.datos.dao.tramites.ReqxtramiteDao;
import modelo.datos.dao.tramites.SubtipotramiteDao;
import modelo.datos.objetos.generales.TramiteBasico;
import modelo.datos.objetos.generales.vehiculo.Vehiculo;
import modelo.datos.objetos.tramites.CambioColor;

import modelo.datos.objetos.tramites.CambioServicio;

import modelo.datos.objetos.tramites.Tramiteinterno;
import modelo.datos.dao.tramites.TramiteinternoDao;

import modelo.datos.objetos.generales.RuntDuplicadoPlaca;
import modelo.datos.objetos.generales.RuntRegrabacionVehiculo;
import modelo.datos.objetos.tramites.Cabrequisitobase;
import modelo.datos.objetos.tramites.CambioTipoPlacas;

import modelo.datos.objetos.tramites.CancelacionMatricula;

import modelo.datos.objetos.tramites.Detrequisitobase;
import modelo.datos.objetos.tramites.Reqxtramite;
import modelo.datos.objetos.tramites.Subtipotramite;

public class GestionServiciosRadicacionTramitesRNC {
    //VehiculoDao vehiculoDao;
    Conexion conexion;
    Connection conn;
    
    public GestionServiciosRadicacionTramitesRNC() {
        super();
        crearObjetos();
    }
    
  
  public void crearObjetos() {
      conexion = new Conexion();
      //vehiculoDao=new VehiculoDao();
     }
}
