package modelo.logica.generales;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.generales.RuntsucursalempresaDao;
import modelo.datos.objetos.generales.Runtsucursalempresa;

import utilidades.Funciones;


public class GestionRuntsucursalempresa {
    Conexion conexion;
    Connection conn;
    String myMotor;

    public GestionRuntsucursalempresa() {
        super();
        crearObjetos();
    }

    private void crearObjetos() {
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

    /**
     * Inserta nuevo registro en la tabla
     * @param Runtsucursalempresa obj
     * @return Retorna el mismo objeto pero con la llave primaria configurada
     */
    public Runtsucursalempresa crearRuntsucursalempresa(Runtsucursalempresa obj) {
        List lista = null;
        try {
            RuntsucursalempresaDao dao = new RuntsucursalempresaDao();
            conn = conexion.conectar();
            int id = Funciones.obtenerId(conn, "GEN_RUNTSUCURSALEMPRESA", "GEN_RUNTSUCURSALEMPRESA", myMotor);
            obj.setID_RUNTSUCURSAL(id);
            dao.create(conn, obj);
            //verificar existencia
            obj = new Runtsucursalempresa();
            obj.setID_RUNTSUCURSAL(id);
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Runtsucursalempresa)lista.get(0);
            } else {
                obj.setID_RUNTSUCURSAL(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_RUNTSUCURSAL(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }

    /**
     * Edita un registro en la tabla
     * @param Runtsucursalempresa obj
     * @return boolean indicando si se realizo o no la actualizacion
     */
    public boolean editarRuntsucursalempresa(Runtsucursalempresa obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
            RuntsucursalempresaDao dao = new RuntsucursalempresaDao();
            conn = conexion.conectar();
            dao.save(conn, obj);
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }

    /**
     * Busca el primer registro que coincida con los datos enviados
     * @param Runtsucursalempresa obj
     * @return Retorna el mismo objeto pero con los datos consultados
     */
    public Runtsucursalempresa buscarPrimeroRuntsucursalempresa(Runtsucursalempresa obj) {
        List lista = null;
        try {
            RuntsucursalempresaDao dao = new RuntsucursalempresaDao();
            conn = conexion.conectar();
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Runtsucursalempresa)lista.get(0);
            } else {
                obj.setID_RUNTSUCURSAL(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_RUNTSUCURSAL(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }

    /**
     * Busca los registros que coincidan con los datos enviados
     * @param Runtsucursalempresa obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List buscarRuntsucursalempresa(Runtsucursalempresa obj) {
        List lista = null;
        try {
            RuntsucursalempresaDao dao = new RuntsucursalempresaDao();
            conn = conexion.conectar();
            lista = dao.searchMatching(conn, obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    /**
     * Consulta todos los registros de la tabla
     * @param Runtsucursalempresa obj
     * @return Retorna la lista de los registros en la tabla
     */
    public List listarRuntsucursalempresa() {
        List lista = null;
        try {
            RuntsucursalempresaDao dao = new RuntsucursalempresaDao();
            conn = conexion.conectar();
            lista = dao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    /**
     * Elimina un registro de la tabla
     * @param Runtsucursalempresa obj
     * @return Retorna un boolean indicando si se realizo o no la operacion
     */
    public boolean eliminarRuntsucursalempresa(Runtsucursalempresa obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
            RuntsucursalempresaDao dao = new RuntsucursalempresaDao();
            conn = conexion.conectar();
            dao.delete(conn, obj);
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }

}
