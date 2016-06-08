package modelo.logica.generales;

import java.sql.Connection;

import java.util.ArrayList;
import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.generales.vistas.ViewPopietarioEmpresa2Dao;
import modelo.datos.objetos.generales.Empresa;
import modelo.datos.objetos.generales.vistas.ViewPopietarioEmpresa2;
import modelo.datos.objetos.generales.vistas.ViewPropietarioEmpresa;

import utilidades.Funciones;

public class GestionServiciosViewPropietarios2 {
    
    Conexion conexion;
    Connection conn;
    String myMotor;
    ViewPopietarioEmpresa2Dao viewPropietarioEmpresa;
    
    public GestionServiciosViewPropietarios2() {
        super();
        viewPropietarioEmpresa = new ViewPopietarioEmpresa2Dao();
        myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
    }
    
    public List getPropietarioEmpresa(ViewPopietarioEmpresa2 propEmpresa) {
        List lista = null;
        try {
                conn = conexion.conectar();
                lista = (ArrayList)viewPropietarioEmpresa.searchMatching(conn, propEmpresa);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
}
