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
import modelo.datos.objetos.liquidacion.Factura;
import modelo.datos.dao.liquidacion.FacturaDao;
import modelo.datos.objetos.tramites.Cabrequisitobase;
import modelo.datos.objetos.tramites.CambioTipoPlacas;

import modelo.datos.objetos.tramites.CancelacionMatricula;

import modelo.datos.objetos.tramites.Detrequisitobase;
import modelo.datos.objetos.tramites.Reqxtramite;
import modelo.datos.objetos.tramites.Subtipotramite;

import utilidades.Funciones;

public class GestionServiciosRadicacionTramitesRNA {
    //VehiculoDao vehiculoDao;
    Conexion conexion;
    Connection conn;
    String myMotor;
    
    public GestionServiciosRadicacionTramitesRNA() {
        super();
        conexion = new Conexion();
        myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
      //vehiculoDao=new VehiculoDao();
        //crearObjetos();
    }
    
  public List getFacturas(Factura myFactura)
  {
        List mylista;
        mylista = null;
        try
    {
      conn = conexion.conectar();
      FacturaDao myFacturaDao = new FacturaDao();
      mylista = myFacturaDao.searchMatching(conn, myFactura);
    }
    catch (Exception e){
      e.printStackTrace();
    }
    finally{
      conexion.cerrarCx();
    }
    return mylista;
  }

  public boolean editarFactura(Factura factura){
      boolean resultado;
      resultado = false;
      FacturaDao myFacturaDao = new FacturaDao();      
      try
      {
          conn = conexion.conectar();
          myFacturaDao.save(conn, factura);
          resultado = true;
      }
      catch (Exception e){
          e.printStackTrace();
          resultado = false;
      }
      finally{
          conexion.cerrarCx();
          myFacturaDao = null;
      }
      return resultado;
  }  
}
