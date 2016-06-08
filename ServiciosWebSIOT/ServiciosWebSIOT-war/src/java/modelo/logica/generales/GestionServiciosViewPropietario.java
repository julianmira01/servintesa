package modelo.logica.generales;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.generales.ViewPropietarioDao;
import modelo.datos.objetos.generales.ViewPropietario;

import utilidades.Funciones;


public class GestionServiciosViewPropietario {   
  Conexion conexion;
  Connection conn;
  ViewPropietarioDao viewPropDao;
  String myMotor;
  
  public GestionServiciosViewPropietario() {
      super();
      conexion = new Conexion();      
      viewPropDao=new ViewPropietarioDao();
      myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
  }  
  
  public List getViewPropietarios(ViewPropietario viewPropietario) {
      List lista = null;
      try {
        conn = conexion.conectar();
        lista = viewPropDao.searchMatching(conn, viewPropietario); 
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
