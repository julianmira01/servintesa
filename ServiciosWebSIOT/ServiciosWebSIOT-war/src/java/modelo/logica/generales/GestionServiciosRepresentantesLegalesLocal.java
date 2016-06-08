package modelo.logica.generales;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.generales.RepresentanteLegalDao;
import modelo.datos.objetos.generales.RepresentanteLegal;

import utilidades.Funciones;


public class GestionServiciosRepresentantesLegalesLocal {
    
  Conexion conexion;
  Connection conn;
  RepresentanteLegalDao representanteLegalDao;
  String myMotor;
  
    public GestionServiciosRepresentantesLegalesLocal() {
        super();
        crearObjetos();
    }
    
  public void crearObjetos() {
      conexion = new Conexion();
      representanteLegalDao=new RepresentanteLegalDao();
      myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
  }
  
  public List getRepresentanteLegal(RepresentanteLegal representante) {
      List lista = null;
      try {
              conn = conexion.conectar();
              lista = representanteLegalDao.searchMatching(conn, representante);
      } catch (Exception e) {
          System.out.println(e.getMessage());
      } finally {
          conexion.cerrarCx();
      }
      return lista;
  }
  
  public RepresentanteLegal crearRepresentanteLegal(RepresentanteLegal representante) {
      List lista = null;
      int id=0;
      try {
          conn = conexion.conectar();
          id=Funciones.obtenerId(conn, "GEN_REPRESENTANTELEGA", "GEN_REPRESENTANTELEGA", myMotor);
          representante.setID_REPRESENTANTE(id);
          representanteLegalDao.create(conn, representante);
          representante = new RepresentanteLegal();
          representante.setID_REPRESENTANTE(id);
          lista=representanteLegalDao.searchMatching(conn, representante);
          if(lista!=null && lista.size()>0){
              representante=(RepresentanteLegal)lista.get(0);
          }
      } catch (Exception e) {
          e.printStackTrace();
          representante.setID_REPRESENTANTE(-1);

        } finally {
          conexion.cerrarCx();
      }
      return representante;
  }
  
    public RepresentanteLegal actualizarRepresentanteLegal(RepresentanteLegal representante) {
        List lista = null;
        int id=0;
        try {
            conn = conexion.conectar();
            id=representante.getID_REPRESENTANTE();
            representanteLegalDao.save(conn, representante);
            representante = new RepresentanteLegal();
            representante.setID_REPRESENTANTE(id);
            lista=representanteLegalDao.searchMatching(conn, representante);
            if(lista!=null && lista.size()>0){
                representante=(RepresentanteLegal)lista.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            representante.setID_REPRESENTANTE(-1);

          } finally {
            conexion.cerrarCx();
        }
        return representante;
    }
  
}
