package modelo.logica.generales;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.generales.TransitoDao;
import modelo.datos.objetos.generales.Transito;

import utilidades.Funciones;


public class GestionServiciosTransitoLocal {
    Conexion conexion;
    Connection conn;
    String myMotor;

    public GestionServiciosTransitoLocal() {
        super();
        crearObjetos();
    }

    public void crearObjetos() {
        conexion = new Conexion();
        myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
    }

    public Transito getTransito(Transito transito) {
        List lista = null;
        TransitoDao transitoDao;
        try {
            transitoDao = new TransitoDao();
            conn = conexion.conectar();
            lista = transitoDao.searchMatching(conn, transito);
            if (lista != null && lista.size() > 0) {
                transito = (Transito)lista.get(0);
                System.out.println(lista.size());
            }
        } catch (Exception e) {
            lista = null;
            System.out.println(e.getMessage());
        } finally {
            conexion.cerrarCx();
        }
        transito.toString();
        return transito;
    }

    public Transito getTransito() {
        List lista = null;
        Transito myTransito = null;
        TransitoDao transitoDao;
        try {
            conn = conexion.conectar();
            transitoDao = new TransitoDao();
            lista = transitoDao.loadAll(conn);
            if (lista != null && lista.size() > 0) {
                myTransito = (Transito)lista.get(0);
                System.out.println(lista.size());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conexion.cerrarCx();
        }
        return myTransito;
    }

    public List getTransitos() {
        List lista = null;
        Transito myTransito = null;
        TransitoDao transitoDao;
        try {
            conn = conexion.conectar();
            transitoDao = new TransitoDao();
            lista = transitoDao.searchMatching(conn, new Transito());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public Transito saveTransito(Transito transito) {
        int id = 0;
        List lista = null;
        TransitoDao transitoDao;
        try {
            conn = conexion.conectar();
            id = transito.getID_TRANSITO();
            transitoDao = new TransitoDao();
            transitoDao.save(conn, transito);
            transito = new Transito();
            transito.setID_TRANSITO(id);
            lista = transitoDao.searchMatching(conn, transito);
            if (lista != null && lista.size() > 0) {
                transito = (Transito)lista.get(0);
            }
        } catch (Exception e) {
            lista = null;
            System.out.println(e.getMessage());
            transito.setID_TRANSITO(-1);
        } finally {
            conexion.cerrarCx();
        }
        transito.toString();
        return transito;
    }
    
    public Transito crearTransito(Transito transito) {
        TransitoDao transitoDao;
        try {
            conn = conexion.conectar();
            transitoDao = new TransitoDao();
            transitoDao.create(conn, transito);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transito.setID_TRANSITO(-1);
        } finally {
            conexion.cerrarCx();
        }
        return transito;
    }
    
    


    /*
  Conexion conexion;
  Connection conn;
  TransitoDao transitoDao;
  String myMotor;

  public GestionServiciosTransitoLocal() {
      super();
      crearObjetos();
  }

  public void crearObjetos() {
      conexion = new Conexion();
      transitoDao = new TransitoDao();
      myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
  }

    public Transito getTransito(Transito transito){
      List lista = null;
      try{
        conn = conexion.conectar();
        lista = transitoDao.searchMatching(conn,transito);
          if(lista != null && lista.size()>0){
            transito = (Transito)lista.get(0);
          }
      }catch(Exception e) {
        lista=null;
        System.out.println(e.getMessage());
      }
      finally{
        conexion.cerrarCx();
      }
      return transito;
    }

  public Transito getTransito(){
    List lista = null;
    Transito myTransito=null;
    try{
      conn = conexion.conectar();
      lista = transitoDao.loadAll(conn);
      if(lista != null && lista.size()>0){
          myTransito = (Transito)lista.get(0);
        }
    }catch(Exception e) {
      System.out.println(e.getMessage());
    }
    finally{
      conexion.cerrarCx();
    }
    return myTransito;
  }

    public List getTransitos(){
      List lista = null;
      Transito myTransito=null;
      try{
        conn = conexion.conectar();
        lista = transitoDao.searchMatching(conn,new Transito());
      }catch(Exception e) {
        System.out.println(e.getMessage());
      }
      finally{
        conexion.cerrarCx();
      }
      return lista;
    }
  */
}
