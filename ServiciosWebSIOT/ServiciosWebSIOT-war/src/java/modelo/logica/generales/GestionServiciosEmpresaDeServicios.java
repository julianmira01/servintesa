package modelo.logica.generales;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.generales.EmpresaDao;
import modelo.datos.dao.generales.EmpresaDeServicioDao;
import modelo.datos.dao.generales.PersonaDao;
import modelo.datos.dao.generales.vehiculo.VehiculoDao;
import modelo.datos.dao.medidasCautelares.J_PendienteDao;
import modelo.datos.objetos.generales.EmpresaDeServicio;
import modelo.datos.objetos.medidasCautelares.J_Pendiente;

import utilidades.Funciones;

public class GestionServiciosEmpresaDeServicios {
    
    Conexion conexion;
    Connection conn;
    EmpresaDeServicioDao empresaDeServicioDao;
    String myMotor;
    
    public GestionServiciosEmpresaDeServicios() {
        super();
        crearObjetos();
    }
    
    private void crearObjetos(){
      conexion = new Conexion();
      empresaDeServicioDao = new EmpresaDeServicioDao();
      myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
    }
    
    
    //Obtengo las medidas cautelares
    public EmpresaDeServicio getEmpresaDeServicio(EmpresaDeServicio empresaDeServicio){
        List lista = null;
        EmpresaDeServicio empresa = null;
        try {
            Conexion conexion = new Conexion();;
            Connection conn = conexion.conectar();  
            lista = empresaDeServicioDao.searchMatching(conn, empresaDeServicio);
            
            if((lista != null) && (lista.size() > 0))
                empresa = (EmpresaDeServicio)lista.get(0);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            conexion.cerrarCx();
        }
        
        return empresa;
    }
}
