package modelo.logica.comparendos.planos;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.comparendos.planos.PlanosSimitDao;

import modelo.datos.dao.comparendos.planos.ViewResolucionAnteriorDao;

import modelo.datos.objetos.comparendos.planos.ViewResolucionAnterior;

import utilidades.Funciones;

public class GestionServiciosViewResolucionAnterior {
    
    Conexion conexion;
    Connection conn;
    ViewResolucionAnteriorDao viewResolucionAnteriorDao;
    String myMotor;
    
    public GestionServiciosViewResolucionAnterior() {
        super();
        conexion = new Conexion();
        viewResolucionAnteriorDao = new ViewResolucionAnteriorDao();
        myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
    }
    
    public List getViewResolucionAnterior(ViewResolucionAnterior viewResolucionAnterior) {
        List lista = null;
        try {
            conn = conexion.conectarComparendos();
            lista = viewResolucionAnteriorDao.searchMatching(conn, viewResolucionAnterior);
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
