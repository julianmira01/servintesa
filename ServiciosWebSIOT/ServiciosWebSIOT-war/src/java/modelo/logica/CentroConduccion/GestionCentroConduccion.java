package modelo.logica.CentroConduccion;

import java.sql.Connection;

import java.util.ArrayList;
import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.centroConduccion.CentroConduccionDao;
import modelo.datos.dao.licenciasConduccion.LicenciasConduccionDao;
import modelo.datos.objetos.centroConduccion.CentroConduccion;

import utilidades.Funciones;


public class GestionCentroConduccion {
    Conexion conexion;
    Connection conn;
    String myMotor;
    List listaCentrosConduccion;
    
    public GestionCentroConduccion() {
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
        
    }
    
    public int crearCentroConduccion(CentroConduccion centro)
    {
       CentroConduccionDao myDao = new CentroConduccionDao();
       int id=-1;
       try
       {
             conn = conexion.conectar();
             id=Funciones.obtenerId(conn, "GEN_ID_CRC", "GEN_ID_CRC", myMotor);
             System.out.println("idlic:  "+id);
             centro.setID_CRC(id);
             myDao.create(conn, centro);
        }
        catch (Exception e){
           e.printStackTrace();
           id = -1;
        }
        finally{
            conexion.cerrarCx();
            myDao = null;
        }
        return id;
      }
    
  public boolean modificarCentroConduccion(CentroConduccion centro)
  {
     boolean resultado;
     resultado = false;
     CentroConduccionDao myDao = new CentroConduccionDao();
     int id=0;
     try
     {
           conn = conexion.conectar();
           myDao.save(conn, centro);
           resultado = true;
      }
      catch (Exception e){
         e.printStackTrace();
          resultado = false;
      }
      finally{
          conexion.cerrarCx();
          myDao = null;
      }
      return resultado;
    }
  
    public CentroConduccion getCentroConduccion(CentroConduccion centro)
    {
       List lista=null;
       CentroConduccionDao myDao = new CentroConduccionDao();
       try
       {
            conn = conexion.conectar();
            lista = myDao.searchMatching(conn, centro);
            if(lista!=null&&lista.size()>0)
            {
                 centro=(CentroConduccion)lista.get(0);
            }
        }
        catch (Exception e){
           e.printStackTrace();
        }
        finally{
            conexion.cerrarCx();
            myDao = null;
        }
        return centro;
      }
    public List listarCentrosConduccion()
    {
       listaCentrosConduccion = new ArrayList();
       CentroConduccionDao myDao = new CentroConduccionDao();
       try
       {
            conn = conexion.conectar();
            listaCentrosConduccion = myDao.loadAll(conn);
            if(listaCentrosConduccion!=null&&listaCentrosConduccion.size()>0)
            {
                return listaCentrosConduccion;
            }
        }
        catch (Exception e){
           e.printStackTrace();
        }
        finally{
            conexion.cerrarCx();
            myDao = null;
        }
        return null;
      }
  
  public boolean eliminarCentroConduccion(CentroConduccion centro)
  {
     boolean resultado;
     resultado = false;
     CentroConduccionDao myDao = new CentroConduccionDao();
     int id=0;
     try
     {
           conn = conexion.conectar();
           myDao.delete(conn, centro);
           resultado = true;
      }
      catch (Exception e){
         e.printStackTrace();
          resultado = false;
      }
      finally{
          conexion.cerrarCx();
          myDao = null;
      }
      return resultado;
    }

}
