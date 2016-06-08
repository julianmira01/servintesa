package modelo.logica.comparendos.ciatran;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.comparendos.ciatran.ViewComparendoCiatranDao;
import modelo.datos.objetos.comparendos.ciatran.ViewComparendoCiatran;

import utilidades.Funciones;


public class GestionConsultaCiatran {
    Conexion conexion;
    Connection conn;
    String myMotor;
    public GestionConsultaCiatran() {
        super();
        myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        conexion = new Conexion();
        
    }
    
    public ViewComparendoCiatran consultarComparendo(String nroComparendo){
      List lista = null;
      ViewComparendoCiatran tmp = new ViewComparendoCiatran();
      try {
          conn = conexion.conectarComparendos();
          
          ViewComparendoCiatranDao myDao = new ViewComparendoCiatranDao();
          tmp.setNUMEROCOMPARENDO(nroComparendo);
          lista = myDao.searchMatching(conn, tmp);
          if (lista != null && lista.size()>0)
              tmp = (ViewComparendoCiatran)lista.get(0);
          else
              tmp = null;
      }catch (Exception e) {
        e.printStackTrace();;
      }finally {
         conexion.cerrarCx();
      }
      return tmp;
      
  }
}
