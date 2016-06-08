package modelo.logica.comparendos.planos;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.comparendos.planos.PlanosSimitDao;

import modelo.datos.dao.comparendos.planos.ViewInfractorComparendoDao;

import modelo.datos.objetos.comparendos.planos.ViewInfractorComparendo;

import utilidades.Funciones;

public class GestionServiciosViewInfractorComparendo {
    
    Conexion conexion;
    Connection conn;
    ViewInfractorComparendoDao viewInfractorComparendoDao;
    String myMotor;
    
    public GestionServiciosViewInfractorComparendo() {
        super();
        conexion = new Conexion();
        viewInfractorComparendoDao = new ViewInfractorComparendoDao();
        myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
    }
    
    public List getViewInfractorComparendo(ViewInfractorComparendo viewInfractorComparendo) {
        List lista = null;
        try {
            conn = conexion.conectarComparendos();
            lista = viewInfractorComparendoDao.searchMatching(conn, viewInfractorComparendo);
        }
        catch (Exception e)
        { 
            e.printStackTrace();
        }
        finally{
            conexion.cerrarCx();
        }
        return lista;
    }
    
    
    //NUEVOS M-*-TODOS - EDWIN
    public List getViewInfractorComparendoPersuasivo() {
      List lista = null;
      try {
          conn = conexion.conectarComparendos();
          lista = viewInfractorComparendoDao.searchMatchingSql(conn);
      }
      catch (Exception e)
      { 
          e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return lista;
  }
}
