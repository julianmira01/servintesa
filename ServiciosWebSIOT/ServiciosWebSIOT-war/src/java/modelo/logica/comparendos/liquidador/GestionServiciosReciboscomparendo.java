package modelo.logica.comparendos.liquidador;


import java.sql.Connection;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.comparendos.liquidador.ReciboscomparendoDao;
import modelo.datos.objetos.comparendos.liquidador.Reciboscomparendo;

import utilidades.Funciones;


public class GestionServiciosReciboscomparendo {

    Conexion conexion;
    Connection conn;
    String myMotor;
    ReciboscomparendoDao reciboscomparendoDao;

    public GestionServiciosReciboscomparendo() {
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
        reciboscomparendoDao = new ReciboscomparendoDao();
    }

    public List listarTodos() {
        List lista = null;
        try {
            conn = conexion.conectarComparendos();
            lista = (ArrayList)reciboscomparendoDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List buscar(Reciboscomparendo reciboscomparendo) {
        List lista = null;
        try {
            conn = conexion.conectarComparendos();
            lista = (ArrayList)reciboscomparendoDao.searchMatching(conn, reciboscomparendo);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public int crear(Reciboscomparendo reciboscomparendo) {
        int id = -1;
        try {
            conn = conexion.conectarComparendos();
            id = Funciones.obtenerId(conn, "GEN_ID_RECIBOSCOMPARENDO", "GEN_ID_RECIBOSCOMPARENDO", myMotor);
            reciboscomparendo.setID(id);
            if (id != -1)
                reciboscomparendoDao.create(conn, reciboscomparendo);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return id;
    }

    public boolean editar(Reciboscomparendo reciboscomparendo) {
        try {
            conn = conexion.conectarComparendos();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
          
            //reciboscomparendo.setFECHAREGISTROPAGO(formatter.format(new Date()));
            reciboscomparendo.setFECHAREGISTROPAGO(Funciones.getFechaSistema(conn, myMotor));
            
            reciboscomparendoDao.save(conn, reciboscomparendo);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return false;
    }
}
