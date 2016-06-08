package modelo.logica.generales;

import java.sql.Connection;

import java.util.List;

import javax.swing.text.View;

import modelo.conexion.Conexion;

import modelo.datos.dao.generales.ViewPropietarioDao;
import modelo.datos.dao.tramites.ViewTramitesVehiculoPorFechaDao;
import modelo.datos.objetos.generales.ViewPropietario;
import modelo.datos.objetos.tramites.ViewTramitesVehiculoPorFecha;

import utilidades.Funciones;

public class GestionServiciosViewTramitesVehiculoPorFechas {
  Conexion conexion;
  Connection conn;
  ViewTramitesVehiculoPorFechaDao viewTramitesVehiculoPorFechaDao;
  String myMotor;
  
    public GestionServiciosViewTramitesVehiculoPorFechas() {
        super();
        conexion = new Conexion();      
        viewTramitesVehiculoPorFechaDao =new ViewTramitesVehiculoPorFechaDao();
        myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
    }
    
  public List getTramitesVehiculoPorFechaPlaca(ViewTramitesVehiculoPorFecha viewTramitesVehiculoPorFecha, String fecha1, String fecha2) throws Exception {
      List lista = null;
      try {
        conn = conexion.conectar();
        lista = viewTramitesVehiculoPorFechaDao.getTramitesPorFechaPlaca(conn, viewTramitesVehiculoPorFecha, fecha1, fecha2); 
      }
      catch (Exception e) 
      {  
          lista=null;
          throw new Exception(e.getMessage());
      } 
      finally {
          conexion.cerrarCx();
      }
      return lista; 
  }
}
