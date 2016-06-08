package modelo.logica.generales;

import java.sql.Connection;

import java.util.ArrayList;
import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.generales.LPagoImpuestoDao;
import modelo.datos.objetos.generales.Empresa;
import modelo.datos.objetos.generales.LPagoImpuesto;

import utilidades.Funciones;

public class GestionServiciosLPagoImpuesto {
  Conexion conexion;
  Connection conn;
  LPagoImpuestoDao pagoImpuestoDao; 
  String myMotor;
  
    public GestionServiciosLPagoImpuesto() {
        super();
        crearObjetos();
    }
    
    public void crearObjetos() {
      conexion = new Conexion();  
      pagoImpuestoDao = new LPagoImpuestoDao();
      myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
    }
    
    public List getLPagoImpuestos(LPagoImpuesto pagoImpuestos) {
      List lista = null;
      try {
              conn = conexion.conectar();
              lista = (ArrayList)pagoImpuestoDao.searchMatching(conn, pagoImpuestos);
      } catch (Exception e) {
          System.out.println(e.getMessage());
      } finally {
          conexion.cerrarCx();
      }
      return lista;
    }
    
    public boolean createLPagoImpuestos(LPagoImpuesto pagoImpuestos) {
      boolean resultado = false;
      int id;
      try {
          conn = conexion.conectar();
          id=Funciones.obtenerId(conn, "GEN_PAGOIMPUESTO", "GEN_PAGOIMPUESTO", myMotor);
          pagoImpuestos.setL_IDPAGOIMP(id);
          pagoImpuestoDao.create(conn, pagoImpuestos);
          resultado = true;
      } catch (Exception e) {
         System.out.println(e.getMessage());
         resultado = false;
      } finally {
         conexion.cerrarCx();
      }
      return resultado;
    }
    
    public boolean deleteLPagoImpuestos(LPagoImpuesto pagoImpuestos) {
      boolean resultado = false;
      int id;
      try {
          conn = conexion.conectar();
          pagoImpuestoDao.delete(conn, pagoImpuestos);
          resultado = true;
      } catch (Exception e) {
         System.out.println(e.getMessage());
         resultado = false;
      } finally {
         conexion.cerrarCx();
      }
      return resultado;
    }
    
    
    
}
