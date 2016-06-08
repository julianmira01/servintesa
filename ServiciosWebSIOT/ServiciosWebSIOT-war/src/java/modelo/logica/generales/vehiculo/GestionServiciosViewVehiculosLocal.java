package modelo.logica.generales.vehiculo;

import java.sql.Connection;

import java.util.ArrayList;
import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.generales.vehiculo.ViewVehiculoDao;
import modelo.datos.dao.transportepublico.cupos.InventarioCuposTransDao;
import modelo.datos.objetos.generales.vehiculo.Vehiculo;
import modelo.datos.objetos.generales.vehiculo.ViewVehiculo;
import modelo.datos.objetos.transportepublico.cupos.InventarioCuposTrans;

import utilidades.Funciones;

public class GestionServiciosViewVehiculosLocal {
    
  Conexion conexion;
  Connection conn;
  String myMotor;
  ViewVehiculoDao viewVehiculoDao;
    
    public GestionServiciosViewVehiculosLocal() {
        super();
        crearObjetos();
    }
    
    public void crearObjetos(){
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
    
    public ViewVehiculo consultarInformacionVehiculo(ViewVehiculo vehiculo) {
        List lista = null;
        try {
            viewVehiculoDao = new ViewVehiculoDao();
            
            conn = conexion.conectar();
            lista = viewVehiculoDao.searchMatching(conn, vehiculo);
            
            if(lista!=null && lista.size()>0){
                vehiculo=(ViewVehiculo)lista.get(0);
            }
            else {
              vehiculo=null;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conexion.cerrarCx();
        }
        return vehiculo;
    }
    
    public List getSViewVehiculo(ViewVehiculo viewVehiculo)
    {
        List lista;
        lista = null;
        try
        {
            viewVehiculoDao = new ViewVehiculoDao();
            conexion = new Conexion();
            conn = conexion.conectar();
            ViewVehiculoDao myViewVehiculoDao = new ViewVehiculoDao();
            lista = myViewVehiculoDao.searchMatching(conn, viewVehiculo);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
           conexion.cerrarCx();
        }
        return lista;
    } 
}
