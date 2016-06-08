package modelo.logica.generales.vehiculo;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.generales.vehiculo.ViewInfoVehiculoPlano;
import modelo.datos.dao.generales.vehiculo.ViewInfoVehiculoPlanoDao;
import modelo.datos.objetos.tramites.ViewTramitesVehiculoPorFecha;

import utilidades.Funciones;

public class GestionServiciosInfoVehiculoPlano {
    Conexion conexion;
    Connection conn;
    ViewInfoVehiculoPlanoDao viewInfoVehiculoPlanoDao;
    String myMotor;
    
    public GestionServiciosInfoVehiculoPlano() {
        super();
        crearObjetos();
    }
    
    private void crearObjetos() {
      conexion = new Conexion();
      viewInfoVehiculoPlanoDao = new ViewInfoVehiculoPlanoDao();
      myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
    }
    
    public List getInfoVehiculoPlano(ViewInfoVehiculoPlano viewInfoVehiculoPlano) {
      List lista = null;
      try {
        conn = conexion.conectar();
        lista = viewInfoVehiculoPlanoDao.searchMatching(conn, viewInfoVehiculoPlano); 
      }
      catch (Exception e) 
      {  
          lista=null;
      } 
      finally {
          conexion.cerrarCx();
      }
      return lista; 
  }
}
