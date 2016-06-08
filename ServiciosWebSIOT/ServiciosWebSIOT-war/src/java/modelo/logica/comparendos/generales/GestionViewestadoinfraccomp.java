package modelo.logica.comparendos.generales;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.comparendos.generales.ViewestadoinfraccompDao;
import modelo.datos.objetos.comparendos.generales.Viewestadoinfraccomp;


import utilidades.Funciones;


public class GestionViewestadoinfraccomp {
    Conexion conexion;
    Connection conn;
    String myMotor;

    public GestionViewestadoinfraccomp() {
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
     * @param Viewestadoinfraccomp obj
     * @return Retorna el mismo objeto pero con la llave primaria configurada
     */
    public Viewestadoinfraccomp crearViewestadoinfraccomp(Viewestadoinfraccomp obj) {
        List lista = null;
        try {
            ViewestadoinfraccompDao dao = new ViewestadoinfraccompDao();
            //conn = conexion.conectar();
            conn = conexion.conectarComparendos();
            int id = Funciones.getId_FB(conn, "");
            obj.setID_COMPARENDO(id);
            dao.create(conn, obj);
            //verificar existencia
            obj = new Viewestadoinfraccomp();
            obj.setID_COMPARENDO(id);
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Viewestadoinfraccomp)lista.get(0);
            } else {
                obj.setID_COMPARENDO(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_COMPARENDO(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }

    /**
     * Edita un registro en la tabla
     * @param Viewestadoinfraccomp obj
     * @return boolean indicando si se realizo o no la actualizacion
     */
    public boolean editarViewestadoinfraccomp(Viewestadoinfraccomp obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
            ViewestadoinfraccompDao dao = new ViewestadoinfraccompDao();
            //conn = conexion.conectarComparendos();
            conn = conexion.conectarComparendos();
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
     * @param Viewestadoinfraccomp obj
     * @return Retorna el mismo objeto pero con los datos consultados
     */
    public Viewestadoinfraccomp buscarPrimeroViewestadoinfraccomp(Viewestadoinfraccomp obj) {
        List lista = null;
        try {
            ViewestadoinfraccompDao dao = new ViewestadoinfraccompDao();
            //conn = conexion.conectar();
            conn = conexion.conectarComparendos();
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Viewestadoinfraccomp)lista.get(0);
            } else {
                obj.setID_COMPARENDO(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_COMPARENDO(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }

    /**
     * Busca los registros que coincidan con los datos enviados
     * @param Viewestadoinfraccomp obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List buscarViewestadoinfraccomp(Viewestadoinfraccomp obj) {
        List lista = null;
        try {
            ViewestadoinfraccompDao dao = new ViewestadoinfraccompDao();
            //conn = conexion.conectar();
            conn = conexion.conectarComparendos();
            lista = dao.searchMatching(conn, obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
  public List buscarViewestadoinfraccompPersuasivo(int idInfractor) {
      List lista = null;
      try {
          ViewestadoinfraccompDao dao = new ViewestadoinfraccompDao();
          //conn = conexion.conectar();
          conn = conexion.conectarComparendos();
          lista = dao.searchMatchingSql(conn, idInfractor);
      } catch (Exception e) {
          e.printStackTrace();
      } finally {
          conexion.cerrarCx();
      }
      return lista;
  }
    

    /**
     * Busca los registros que coincidan con los datos enviados
     * @param Viewestadoinfraccomp obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List buscarViewestadoinfraccomp(Viewestadoinfraccomp obj, int pagina, int numRegPagina) {
        List lista = null;
        if (pagina > 0 && numRegPagina > 0) {
            pagina--;
            int limInf = 0;
            int limSup = 0;
            limInf = pagina * numRegPagina + 1;
            limSup = (pagina + 1) * numRegPagina;
            try {
                ViewestadoinfraccompDao dao = new ViewestadoinfraccompDao();
                //conn = conexion.conectar();
                conn = conexion.conectarComparendos();
                lista = dao.searchMatching(conn, obj, limInf, limSup);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                conexion.cerrarCx();
            }
        }
        return lista;
    }

    /**
     * Consulta todos los registros de la tabla
     * @param Viewestadoinfraccomp obj
     * @return Retorna la lista de los registros en la tabla
     */
    public List listarViewestadoinfraccomp() {
        List lista = null;
        try {
            ViewestadoinfraccompDao dao = new ViewestadoinfraccompDao();
            //conn = conexion.conectar();
            conn = conexion.conectarComparendos();
            lista = dao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List listarViewestadoinfraccompEnEstados(String estados,int idinfractor) {
        List lista = null;
        if (estados != null && !estados.equals("")) {
            try {
                ViewestadoinfraccompDao dao = new ViewestadoinfraccompDao();
                //conn = conexion.conectar();
                conn = conexion.conectarComparendos();
                lista = dao.loadEnEstados(conn, estados,idinfractor);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                conexion.cerrarCx();
            }
        }

        return lista;
    }


    /**
     * Consulta todos los registros de la tabla pero con Paginacion
     * @param Viewestadoinfraccomp obj
     * @return Retorna la lista de los registros en la tabla con paginacion
     */

    public List listarViewestadoinfraccomp(int pagina, int numRegPagina) {
        List lista = null;
        if (pagina > 0 && numRegPagina > 0) {
            pagina--;
            int limInf = 0;
            int limSup = 0;
            limInf = pagina * numRegPagina + 1;
            limSup = (pagina + 1) * numRegPagina;
            try {
                ViewestadoinfraccompDao dao = new ViewestadoinfraccompDao();
                //conn = conexion.conectar();
                conn = conexion.conectarComparendos();
                if (limInf <= dao.countAll(conn))
                    lista = dao.loadAll(conn, limInf, limSup);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                conexion.cerrarCx();
            }
        }
        return lista;
    }

    public int contarBusquedaViewestadoinfraccomp(Viewestadoinfraccomp obj) {
        int cantidad = -1;
        try {
            ViewestadoinfraccompDao dao = new ViewestadoinfraccompDao();
            //conn = conexion.conectar();
            conn = conexion.conectarComparendos();
            cantidad = dao.countSearchMatching(conn, obj);
        } catch (Exception e) {
            e.printStackTrace();
            cantidad = -1;
        } finally {
            conexion.cerrarCx();
        }
        return cantidad;
    }

    /**
     * Elimina un registro de la tabla
     * @param Viewestadoinfraccomp obj
     * @return Retorna un boolean indicando si se realizo o no la operacion
     */
    public boolean eliminarViewestadoinfraccomp(Viewestadoinfraccomp obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
            ViewestadoinfraccompDao dao = new ViewestadoinfraccompDao();
            //conn = conexion.conectar();
            conn = conexion.conectarComparendos();
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

