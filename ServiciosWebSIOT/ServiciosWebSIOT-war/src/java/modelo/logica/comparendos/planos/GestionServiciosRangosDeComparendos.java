package modelo.logica.comparendos.planos;

import java.sql.Connection;

import java.sql.SQLException;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.NotFoundException;
import modelo.datos.dao.comparendos.planos.RangosDeComparendosDao;
import modelo.datos.objetos.comparendos.planos.RangosDeComparendos;

import modelo.datos.dao.comparendos.comparenderas.ComparenderasDao;
import modelo.datos.objetos.comparendos.comparenderas.Comparenderas;

import utilidades.Funciones;

public class GestionServiciosRangosDeComparendos {
    Conexion conexion;
    Connection conn;
    RangosDeComparendosDao rangosDeComparendosDao;
    String myMotor;
    
    public GestionServiciosRangosDeComparendos() {
        super();
        conexion = new Conexion();
        rangosDeComparendosDao = new RangosDeComparendosDao();
        myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
    }
    
    public List getRangosDeComparendos() {
        List lista = null;
        try {
            conn = conexion.conectarComparendos();
            lista = rangosDeComparendosDao.loadAll(conn);
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
    
    public RangosDeComparendos createRangoDeComparendos(RangosDeComparendos rangoDeComparendos){
        int i;
        List lista = null;
        try{
            conn = conexion.conectarComparendos();
            myMotor=myMotor.toUpperCase();
            i=Funciones.obtenerId(conn, "GEN_RANGOSDECOMPARENDOS", "GEN_RANGOSDECOMPARENDOS", myMotor);
            rangoDeComparendos.setID_RANGOCOMPARENDO(i);
            rangosDeComparendosDao.create(conn, rangoDeComparendos);
            rangoDeComparendos = new RangosDeComparendos();
            rangoDeComparendos.setID_RANGOCOMPARENDO(i);
            lista = rangosDeComparendosDao.searchMatching(conn, rangoDeComparendos);
            if((lista != null)&&(lista.size()>0)) {
                rangoDeComparendos = (RangosDeComparendos)lista.get(0);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            rangoDeComparendos.setID_RANGOCOMPARENDO(-1);
        }
        finally{
            conexion.cerrarCx();
        }
        return rangoDeComparendos;
    }
    
  
    public boolean saveRangosDeComparendos(RangosDeComparendos rangoDeComparendos) {
      boolean resultado = false;
      try{
          conn = conexion.conectarComparendos();
          
          //Si el rango ya est-*- asignado, no se puede editar
          if (rangoComparendoAsignado(rangoDeComparendos)) {
            resultado = false;
          }
          else
          {          
            rangosDeComparendosDao.save(conn, rangoDeComparendos);
            resultado = true;
          }
          return resultado;
      }
      catch(Exception e) {
          e.printStackTrace();
          resultado = false;
      }
      finally{
          conexion.cerrarCx();
      }
      return resultado;
  }    
  
    
  /**
       * Elimina un registro de la tabla
       * @param Rangosdecomparendos obj
       * @return Retorna un boolean indicando si se realizo o no la operacion
       */
      public boolean eliminarRangosdecomparendos(RangosDeComparendos obj) {
          boolean resultado;
          resultado = false;
          int id = 0;
          try {
        RangosDeComparendosDao dao = new RangosDeComparendosDao();
              //conn = conexion.conectar();
              conn = conexion.conectarComparendos();
              
              //Si el rango ya est-*- asignado, no se puede eliminar
              if(rangoComparendoAsignado(obj))
              {
                resultado = false;
              }
              else
              {
                dao.delete(conn, obj);
                resultado = true;
              }
          } catch (Exception e) {
              e.printStackTrace();
              resultado = false;
          } finally {
              conexion.cerrarCx();
          }
          return resultado;
      }
  
  //Determina si el rango de comparendos proporcionado ha sido asignado a una comparendera
  private boolean rangoComparendoAsignado(RangosDeComparendos rangoDeComparendos) throws SQLException{
    Comparenderas objComparenderas = new Comparenderas();
    ComparenderasDao objComparenderasDao = new ComparenderasDao();      
    objComparenderas.setID_RANGOCOMPARENDOS(rangoDeComparendos.getID_RANGOCOMPARENDO());
          
    List listaComparenderas = objComparenderasDao.searchMatching(conn, objComparenderas);
    
    if (listaComparenderas!=null && listaComparenderas.size() > 0) {
      return true;
    }
    
    return false;
  }
}
