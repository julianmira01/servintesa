package modelo.logica.liquidacion;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.liquidacion.ViewFacturaRNCDao;
import modelo.datos.dao.liquidacion.ViewfacturaDao;
import modelo.datos.objetos.liquidacion.ViewFacturaRNC;
import modelo.datos.objetos.liquidacion.Viewfactura;

import utilidades.Funciones;


public class GestionViewfactura {
    Conexion conexion;
    Connection conn;
    String myMotor;

    public GestionViewfactura() {
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
     * @param Viewfactura obj
     * @return Retorna el mismo objeto pero con la llave primaria configurada
     */
    public Viewfactura crear(Viewfactura obj) {
        try {
            ViewfacturaDao dao = new ViewfacturaDao();
            conn = conexion.conectar();
            int id = Funciones.obtenerId(conn, "GEN_VIEWFACTURA", "GEN_VIEWFACTURA", myMotor);
            obj.setLF_ID(id);
            dao.create(conn, obj);
            //verificar existencia
            obj = new Viewfactura();
            obj.setLF_ID(id);
            List objs = dao.searchMatching(conn, obj);
            if (objs != null && objs.size() > 0) {
                obj = (Viewfactura)objs.get(0);
            } else {
                obj.setLF_ID(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setLF_ID(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }

    /**
     * Edita un registro en la tabla
     * @param Viewfactura obj
     * @return boolean indicando si se realizo o no la actualizacion
     */
    public boolean editar(Viewfactura obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
            ViewfacturaDao dao = new ViewfacturaDao();
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
     * @param Viewfactura obj
     * @return Retorna el mismo objeto pero con los datos consultados
     */
    public Viewfactura getOne(Viewfactura obj) {
        List lista = null;
        try {
            ViewfacturaDao dao = new ViewfacturaDao();
            conn = conexion.conectar();
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Viewfactura)lista.get(0);
            } else {
                obj.setLF_ID(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setLF_ID(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }

    /**
     * Busca los registros que coincidan con los datos enviados
     * @param Viewfactura obj
     * @return Retorna la lista de los registros que coinciden
     */
    
    
    public List get(Viewfactura obj) {
        List lista = null;
        try {
            ViewfacturaDao dao = new ViewfacturaDao();
            conn = conexion.conectar();
            lista = dao.searchMatching(conn, obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
    public List getRNC(ViewFacturaRNC obj) {
        List lista = null;
        try {
            ViewFacturaRNCDao dao = new ViewFacturaRNCDao();
            conn = conexion.conectar();
            lista = dao.searchMatching(conn, obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getDateRange(Viewfactura obj) {
        List lista = null;
        try {
            ViewfacturaDao dao = new ViewfacturaDao();
            conn = conexion.conectar();
            lista = dao.searchMatchingDateRange(conn, obj, myMotor);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }


    /**
     * Consulta todos los registros de la tabla
     * @param Viewfactura obj
     * @return Retorna la lista de los registros en la tabla
     */
    public List listar() {
        List lista = null;
        try {
            ViewfacturaDao dao = new ViewfacturaDao();
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
     * @param Viewfactura obj
     * @return Retorna un boolean indicando si se realizo o no la operacion
     */
    public boolean eliminar(Viewfactura obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
            ViewfacturaDao dao = new ViewfacturaDao();
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

