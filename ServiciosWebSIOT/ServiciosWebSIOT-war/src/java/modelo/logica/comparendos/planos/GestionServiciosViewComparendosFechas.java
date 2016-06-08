package modelo.logica.comparendos.planos;

import java.sql.Connection;

import java.util.List;

import javax.swing.text.View;

import modelo.conexion.Conexion;

import modelo.datos.dao.comparendos.planos.PlanoComparendoDao;

import modelo.datos.dao.comparendos.planos.ViewComparendosFechasDao;
import modelo.datos.objetos.comparendos.planos.PlanoComparendo;

import modelo.datos.objetos.comparendos.planos.ViewComparendosFechas;

import utilidades.Funciones;

public class GestionServiciosViewComparendosFechas {
    
    Conexion conexion;
    Connection conn;
    ViewComparendosFechasDao viewComparendosFechasDao;
    String myMotor;
    
    public GestionServiciosViewComparendosFechas() {
        super();
        conexion = new Conexion();
        viewComparendosFechasDao = new ViewComparendosFechasDao();
        myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
    }
            
    public List getViewComparendosFechas(ViewComparendosFechas viewComparendosFechas) {
      List lista = null;
      try {
        conn = conexion.conectarComparendos();
        lista = viewComparendosFechasDao.searchMatching(conn, viewComparendosFechas); 
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
    
    public List getComparendoPorRangoFechas(ViewComparendosFechas viewComparendosFechas, String fecha1, String fecha2) {
      List lista = null;
      try {
        conn = conexion.conectarComparendos();
        lista = viewComparendosFechasDao.getComparendoPorRangoFechas(conn, viewComparendosFechas, fecha1, fecha2); 
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
    
    public List getComparendoPorRangoFechasRegistro(ViewComparendosFechas viewComparendosFechas, String fecha1, String fecha2) {
      List lista = null;
      try {
        conn = conexion.conectarComparendos();
        lista = viewComparendosFechasDao.getComparendoPorRangoFechasRegistro(conn, viewComparendosFechas, fecha1, fecha2); 
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
    
    public List getComparendoNoPagosPorRangoFechas(ViewComparendosFechas viewComparendosFechas, String fecha1, String fecha2) {
      List lista = null;
      try {
        conn = conexion.conectarComparendos();
        lista = viewComparendosFechasDao.getComparendoNoPagosPorRangoFechas(conn, viewComparendosFechas, fecha1, fecha2); 
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
    
    public List getComparendoNoPagosPorRangoFechasRegistro(ViewComparendosFechas viewComparendosFechas, String fecha1, String fecha2) {
      List lista = null;
      try {
        conn = conexion.conectarComparendos();
        lista = viewComparendosFechasDao.getComparendoNoPagosPorRangoFechasRegistro(conn, viewComparendosFechas, fecha1, fecha2); 
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
    
    
    public List getAllViewComparendosFechas(ViewComparendosFechas viewComparendosFechas) {
      List lista = null;
      try {
        conn = conexion.conectarComparendos();
        lista = viewComparendosFechasDao.loadAll(conn);
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
