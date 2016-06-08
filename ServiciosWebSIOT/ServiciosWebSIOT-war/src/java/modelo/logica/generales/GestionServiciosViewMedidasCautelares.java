package modelo.logica.generales;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.medidasCautelares.ViewMedidasCautelaresDao;
import modelo.datos.objetos.generales.medidasCautelares.ViewMedidasCautelares;
import modelo.datos.objetos.tramites.ViewTramitesVehiculoPorFecha;

import utilidades.Funciones;

public class GestionServiciosViewMedidasCautelares {
    Conexion conexion;
    Connection conn;
    ViewMedidasCautelaresDao viewMedidasCautelaresDao;
    String myMotor;
  
    public GestionServiciosViewMedidasCautelares() {
        super();
        crearObjetos();
    }
    
    private void crearObjetos() 
    {
        conexion = new Conexion();
        viewMedidasCautelaresDao = new  ViewMedidasCautelaresDao();
        myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
    }
    
    public List getViewMedidasCautelares(ViewMedidasCautelares viewMedidasCautelares) throws Exception {
      List lista = null;
      try {
        conn = conexion.conectar();
        lista = viewMedidasCautelaresDao.searchMatching(conn, viewMedidasCautelares); 
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
