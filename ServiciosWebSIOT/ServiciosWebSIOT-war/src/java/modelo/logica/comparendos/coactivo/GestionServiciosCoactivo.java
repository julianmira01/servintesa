package modelo.logica.comparendos.coactivo;

import java.sql.Connection;

import java.util.List;

import javax.jws.WebMethod;

import modelo.conexion.Conexion;

import modelo.datos.dao.comparendos.coactivo.BieninmuebleDao;
import modelo.datos.dao.comparendos.coactivo.DocsexpedienteDao;
import modelo.datos.dao.comparendos.coactivo.ExpedienteDao;
import modelo.datos.dao.comparendos.coactivo.ExpedientecomparendoDao;
import modelo.datos.dao.comparendos.coactivo.InstitucionesDao;
import modelo.datos.dao.comparendos.coactivo.TipodoccobroDao;
import modelo.datos.objetos.comparendos.coactivo.Bieninmueble;
import modelo.datos.objetos.comparendos.coactivo.Docsexpediente;
import modelo.datos.objetos.comparendos.coactivo.Expediente;
import modelo.datos.objetos.comparendos.coactivo.Expedientecomparendo;
import modelo.datos.objetos.comparendos.coactivo.Instituciones;
import modelo.datos.objetos.comparendos.coactivo.Tipodoccobro;

import utilidades.Funciones;

public class GestionServiciosCoactivo {
  Conexion conexion;
  Connection conn;
  String myMotor;
  
    public GestionServiciosCoactivo() {
        super();
        crearObjetos();
      }

      public void crearObjetos() {
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
  
  //*************************** INICIO BIENINMUEBLE *******************************************
  //*******************************************************************************************
      /**
       * Inserta nuevo registro en la tabla
       * @param Bieninmueble obj
       * @return Retorna el mismo objeto pero con la llave primaria configurada
       */
    public Bieninmueble crearBieninmueble(Bieninmueble obj) {
      List lista = null;
          try {
              BieninmuebleDao dao = new BieninmuebleDao();
              conn = conexion.conectarComparendos();
              int id = Funciones.obtenerId(conn, "GEN_BIENINMUEBLE", "GEN_BIENINMUEBLE", myMotor);
              obj.setID_BIENINMUEBLE(id);
              dao.create(conn, obj);
              //verificar existencia
              obj = new Bieninmueble();
              obj.setID_BIENINMUEBLE(id);
              lista = dao.searchMatching(conn, obj);
              if (lista != null && lista.size() > 0) {
                  obj = (Bieninmueble)lista.get(0);
              }
              else {
                  obj.setID_BIENINMUEBLE(-1);
              }
          } catch (Exception e) {
              e.printStackTrace();
              obj.setID_BIENINMUEBLE(-1);
          } finally {
              conexion.cerrarCx();
          }
          return obj;
      }
    
      /**
         * Edita un registro en la tabla
         * @param Bieninmueble obj
         * @return boolean indicando si se realizo o no la actualizacion
         */
      public boolean editarBieninmueble(Bieninmueble obj) {
          boolean resultado;
          resultado = false;
          int id = 0;
          try {
        BieninmuebleDao dao = new BieninmuebleDao();
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
       * @param Bieninmueble obj
       * @return Retorna el mismo objeto pero con los datos consultados
       */
      public Bieninmueble buscarPrimeroBieninmueble(Bieninmueble obj) {
          List lista = null;
          try {
        BieninmuebleDao dao = new BieninmuebleDao();
              conn = conexion.conectarComparendos();
              lista = dao.searchMatching(conn, obj);
              if (lista != null && lista.size() > 0) {
                  obj = (Bieninmueble)lista.get(0);
              }
              else {
          obj.setID_BIENINMUEBLE(-1);
              }
          } catch (Exception e) {
              e.printStackTrace();
              obj.setID_BIENINMUEBLE(-1);
          } finally {
              conexion.cerrarCx();
          }
          return obj;
      }
      
      /**
       * Busca los registros que coincidan con los datos enviados
       * @param Bieninmueble obj
       * @return Retorna la lista de los registros que coinciden
       */
      public List buscarBieninmueble(Bieninmueble obj) {
          List lista = null;
          try {
        BieninmuebleDao dao = new BieninmuebleDao();
              conn = conexion.conectarComparendos();
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
       * @param Bieninmueble obj
       * @return Retorna la lista de los registros en la tabla
       */
      public List listarBieninmueble() {
          List lista = null;
          try {
        BieninmuebleDao dao = new BieninmuebleDao();
              conn = conexion.conectarComparendos();
              lista = dao.loadAll(conn);
          } catch (Exception e) {
              e.printStackTrace();
          } finally {
              conexion.cerrarCx();
          }
          return lista;
      }
      
      public int contarBusquedaBieninmueble(Bieninmueble obj) {
        int cantidad=-1;
            try {
          BieninmuebleDao dao = new BieninmuebleDao();
                conn = conexion.conectarComparendos();
                cantidad = dao.countSearchMatching(conn, obj);
            } catch (Exception e) {
                e.printStackTrace();
          cantidad=-1;
            } finally {
                conexion.cerrarCx();
            }
            return cantidad;
        }
  
      /**
       * Elimina un registro de la tabla
       * @param Bieninmueble obj
       * @return Retorna un boolean indicando si se realizo o no la operacion
       */
      public boolean eliminarBieninmueble(Bieninmueble obj) {
          boolean resultado;
          resultado = false;
          int id = 0;
          try {
        BieninmuebleDao dao = new BieninmuebleDao();
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
  //*************************** FIN BIENINMUEBLE *******************************************
  //****************************************************************************************


  //*************************** INICIO Docsexpediente *******************************************
  //*******************************************************************************************
  /**
       * Inserta nuevo registro en la tabla
       * @param Docsexpediente obj
       * @return Retorna el mismo objeto pero con la llave primaria configurada
       */
    public Docsexpediente crearDocsexpediente(Docsexpediente obj) {
      List lista = null;
          try {
              DocsexpedienteDao dao = new DocsexpedienteDao();
              conn = conexion.conectarComparendos();
              int id = Funciones.obtenerId(conn, "GEN_DOCSEXPEDIENTE", "GEN_DOCSEXPEDIENTE", myMotor);
              obj.setID_DOCSEXPEDIENTE(id);
              dao.create(conn, obj);
              //verificar existencia
              obj = new Docsexpediente();
              obj.setID_DOCSEXPEDIENTE(id);
              lista = dao.searchMatching(conn, obj);
              if (lista != null && lista.size() > 0) {
                  obj = (Docsexpediente)lista.get(0);
              }
              else {
                  obj.setID_DOCSEXPEDIENTE(-1);
              }
          } catch (Exception e) {
              e.printStackTrace();
              obj.setID_DOCSEXPEDIENTE(-1);
          } finally {
              conexion.cerrarCx();
          }
          return obj;
      }
    
    /**
       * Edita un registro en la tabla
       * @param Docsexpediente obj
       * @return boolean indicando si se realizo o no la actualizacion
       */
      public boolean editarDocsexpediente(Docsexpediente obj) {
          boolean resultado;
          resultado = false;
          int id = 0;
          try {
        DocsexpedienteDao dao = new DocsexpedienteDao();
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
       * @param Docsexpediente obj
       * @return Retorna el mismo objeto pero con los datos consultados
       */
      public Docsexpediente buscarPrimeroDocsexpediente(Docsexpediente obj) {
          List lista = null;
          try {
        DocsexpedienteDao dao = new DocsexpedienteDao();
              conn = conexion.conectarComparendos();
              lista = dao.searchMatching(conn, obj);
              if (lista != null && lista.size() > 0) {
                  obj = (Docsexpediente)lista.get(0);
              }
              else {
          obj.setID_DOCSEXPEDIENTE(-1);
              }
          } catch (Exception e) {
              e.printStackTrace();
              obj.setID_DOCSEXPEDIENTE(-1);
          } finally {
              conexion.cerrarCx();
          }
          return obj;
      }
      
      /**
       * Busca los registros que coincidan con los datos enviados
       * @param Docsexpediente obj
       * @return Retorna la lista de los registros que coinciden
       */
      public List buscarDocsexpediente(Docsexpediente obj) {
          List lista = null;
          try {
        DocsexpedienteDao dao = new DocsexpedienteDao();
              conn = conexion.conectarComparendos();
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
       * @param Docsexpediente obj
       * @return Retorna la lista de los registros en la tabla
       */
      public List listarDocsexpediente() {
          List lista = null;
          try {
        DocsexpedienteDao dao = new DocsexpedienteDao();
              conn = conexion.conectarComparendos();
              lista = dao.loadAll(conn);
          } catch (Exception e) {
              e.printStackTrace();
          } finally {
              conexion.cerrarCx();
          }
          return lista;
      }
      
    
    public int contarBusquedaDocsexpediente(Docsexpediente obj) {
      int cantidad=-1;
          try {
        DocsexpedienteDao dao = new DocsexpedienteDao();
              conn = conexion.conectarComparendos();
              cantidad = dao.countSearchMatching(conn, obj);
          } catch (Exception e) {
              e.printStackTrace();
        cantidad=-1;
          } finally {
              conexion.cerrarCx();
          }
          return cantidad;
      }
    
      /**
       * Elimina un registro de la tabla
       * @param Docsexpediente obj
       * @return Retorna un boolean indicando si se realizo o no la operacion
       */
      public boolean eliminarDocsexpediente(Docsexpediente obj) {
          boolean resultado;
          resultado = false;
          int id = 0;
          try {
        DocsexpedienteDao dao = new DocsexpedienteDao();
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
  //*************************** FIN Docsexpediente *******************************************
  //****************************************************************************************      
      
  
  //*************************** INICIO Expediente *******************************************
  //*******************************************************************************************
  /**
       * Inserta nuevo registro en la tabla
       * @param Expediente obj
       * @return Retorna el mismo objeto pero con la llave primaria configurada
       */
    public Expediente crearExpediente(Expediente obj) {
      List lista = null;
          try {
              ExpedienteDao dao = new ExpedienteDao();
              conn = conexion.conectarComparendos();
              int id = Funciones.obtenerId(conn, "GEN_EXPEDIENTE", "GEN_EXPEDIENTE", myMotor);
              obj.setID_EXPEDIENTE(id);
              dao.create(conn, obj);
              //verificar existencia
              obj = new Expediente();
              obj.setID_EXPEDIENTE(id);
              lista = dao.searchMatching(conn, obj);
              if (lista != null && lista.size() > 0) {
                  obj = (Expediente)lista.get(0);
              }
              else {
                  obj.setID_EXPEDIENTE(-1);
              }
          } catch (Exception e) {
              e.printStackTrace();
              obj.setID_EXPEDIENTE(-1);
          } finally {
              conexion.cerrarCx();
          }
          return obj;
      }
    
    /**
       * Edita un registro en la tabla
       * @param Expediente obj
       * @return boolean indicando si se realizo o no la actualizacion
       */
      public boolean editarExpediente(Expediente obj) {
          boolean resultado;
          resultado = false;
          int id = 0;
          try {
        ExpedienteDao dao = new ExpedienteDao();
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
       * @param Expediente obj
       * @return Retorna el mismo objeto pero con los datos consultados
       */
      public Expediente buscarPrimeroExpediente(Expediente obj) {
          List lista = null;
          try {
        ExpedienteDao dao = new ExpedienteDao();
              conn = conexion.conectarComparendos();
              lista = dao.searchMatching(conn, obj);
              if (lista != null && lista.size() > 0) {
                  obj = (Expediente)lista.get(0);
              }
              else {
          obj.setID_EXPEDIENTE(-1);
              }
          } catch (Exception e) {
              e.printStackTrace();
              obj.setID_EXPEDIENTE(-1);
          } finally {
              conexion.cerrarCx();
          }
          return obj;
      }
      
      /**
       * Busca los registros que coincidan con los datos enviados
       * @param Expediente obj
       * @return Retorna la lista de los registros que coinciden
       */
      public List buscarExpediente(Expediente obj) {
          List lista = null;
          try {
        ExpedienteDao dao = new ExpedienteDao();
              conn = conexion.conectarComparendos();
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
       * @param Expediente obj
       * @return Retorna la lista de los registros en la tabla
       */
      public List listarExpediente() {
          List lista = null;
          try {
        ExpedienteDao dao = new ExpedienteDao();
              conn = conexion.conectarComparendos();
              lista = dao.loadAll(conn);
          } catch (Exception e) {
              e.printStackTrace();
          } finally {
              conexion.cerrarCx();
          }
          return lista;
      }
      
    public int contarBusquedaExpediente(Expediente obj) {
      int cantidad=-1;
          try {
        ExpedienteDao dao = new ExpedienteDao();
              conn = conexion.conectarComparendos();
              cantidad = dao.countSearchMatching(conn, obj);
          } catch (Exception e) {
              e.printStackTrace();
        cantidad=-1;
          } finally {
              conexion.cerrarCx();
          }
          return cantidad;
      }
    
      /**
       * Elimina un registro de la tabla
       * @param Expediente obj
       * @return Retorna un boolean indicando si se realizo o no la operacion
       */
      public boolean eliminarExpediente(Expediente obj) {
          boolean resultado;
          resultado = false;
          int id = 0;
          try {
        ExpedienteDao dao = new ExpedienteDao();
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
  //*************************** FIN Expediente *******************************************
  //**************************************************************************************
      
  
  //*************************** INICIO Expedientecomparendo *******************************************
  //**************************************************************************************
  /**
       * Inserta nuevo registro en la tabla
       * @param Expedientecomparendo obj
       * @return Retorna el mismo objeto pero con la llave primaria configurada
       */
    public Expedientecomparendo crearExpedientecomparendo(Expedientecomparendo obj) {
      List lista = null;
          try {
              ExpedientecomparendoDao dao = new ExpedientecomparendoDao();
              conn = conexion.conectarComparendos();
              int id = Funciones.obtenerId(conn, "GEN_EXPEDIENTECOMPARENDO", "GEN_EXPEDIENTECOMPARENDO", myMotor);
              obj.setID_EXPEDIENTECOMPARENDO(id);
              dao.create(conn, obj);
              //verificar existencia
              obj = new Expedientecomparendo();
              obj.setID_EXPEDIENTECOMPARENDO(id);
              lista = dao.searchMatching(conn, obj);
              if (lista != null && lista.size() > 0) {
                  obj = (Expedientecomparendo)lista.get(0);
              }
              else {
                  obj.setID_EXPEDIENTECOMPARENDO(-1);
              }
          } catch (Exception e) {
              e.printStackTrace();
              obj.setID_EXPEDIENTECOMPARENDO(-1);
          } finally {
              conexion.cerrarCx();
          }
          return obj;
      }
    
    /**
       * Edita un registro en la tabla
       * @param Expedientecomparendo obj
       * @return boolean indicando si se realizo o no la actualizacion
       */
      public boolean editarExpedientecomparendo(Expedientecomparendo obj) {
          boolean resultado;
          resultado = false;
          int id = 0;
          try {
        ExpedientecomparendoDao dao = new ExpedientecomparendoDao();
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
       * @param Expedientecomparendo obj
       * @return Retorna el mismo objeto pero con los datos consultados
       */
      public Expedientecomparendo buscarPrimeroExpedientecomparendo(Expedientecomparendo obj) {
          List lista = null;
          try {
        ExpedientecomparendoDao dao = new ExpedientecomparendoDao();
              conn = conexion.conectarComparendos();
              lista = dao.searchMatching(conn, obj);
              if (lista != null && lista.size() > 0) {
                  obj = (Expedientecomparendo)lista.get(0);
              }
              else {
          obj.setID_EXPEDIENTECOMPARENDO(-1);
              }
          } catch (Exception e) {
              e.printStackTrace();
              obj.setID_EXPEDIENTECOMPARENDO(-1);
          } finally {
              conexion.cerrarCx();
          }
          return obj;
      }
      
      /**
       * Busca los registros que coincidan con los datos enviados
       * @param Expedientecomparendo obj
       * @return Retorna la lista de los registros que coinciden
       */
      public List buscarExpedientecomparendo(Expedientecomparendo obj) {
          List lista = null;
          try {
        ExpedientecomparendoDao dao = new ExpedientecomparendoDao();
              conn = conexion.conectarComparendos();
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
       * @param Expedientecomparendo obj
       * @return Retorna la lista de los registros en la tabla
       */
      public List listarExpedientecomparendo() {
          List lista = null;
          try {
        ExpedientecomparendoDao dao = new ExpedientecomparendoDao();
              conn = conexion.conectarComparendos();
              lista = dao.loadAll(conn);
          } catch (Exception e) {
              e.printStackTrace();
          } finally {
              conexion.cerrarCx();
          }
          return lista;
      }
    
    public int contarBusquedaExpedientecomparendo(Expedientecomparendo obj) {
      int cantidad=-1;
          try {
        ExpedientecomparendoDao dao = new ExpedientecomparendoDao();
              conn = conexion.conectarComparendos();
              cantidad = dao.countSearchMatching(conn, obj);
          } catch (Exception e) {
              e.printStackTrace();
        cantidad=-1;
          } finally {
              conexion.cerrarCx();
          }
          return cantidad;
      }
    
      /**
       * Elimina un registro de la tabla
       * @param Expedientecomparendo obj
       * @return Retorna un boolean indicando si se realizo o no la operacion
       */
      public boolean eliminarExpedientecomparendo(Expedientecomparendo obj) {
          boolean resultado;
          resultado = false;
          int id = 0;
          try {
        ExpedientecomparendoDao dao = new ExpedientecomparendoDao();
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

  //*************************** FIN Expedientecomparendo *******************************************
  //**************************************************************************************
      
      
  //*************************** INICIO Instituciones *******************************************
  //**************************************************************************************
  /**
       * Inserta nuevo registro en la tabla
       * @param Instituciones obj
       * @return Retorna el mismo objeto pero con la llave primaria configurada
       */
    public Instituciones crearInstituciones(Instituciones obj) {
      List lista = null;
          try {
              InstitucionesDao dao = new InstitucionesDao();
              conn = conexion.conectarComparendos();
              int id = Funciones.obtenerId(conn, "GEN_INSTITUCIONES", "GEN_INSTITUCIONES", myMotor);
              obj.setID_INSTITUCION(id);
              dao.create(conn, obj);
              //verificar existencia
              obj = new Instituciones();
              obj.setID_INSTITUCION(id);
              lista = dao.searchMatching(conn, obj);
              if (lista != null && lista.size() > 0) {
                  obj = (Instituciones)lista.get(0);
              }
              else {
                  obj.setID_INSTITUCION(-1);
              }
          } catch (Exception e) {
              e.printStackTrace();
              obj.setID_INSTITUCION(-1);
          } finally {
              conexion.cerrarCx();
          }
          return obj;
      }
    
    /**
       * Edita un registro en la tabla
       * @param Instituciones obj
       * @return boolean indicando si se realizo o no la actualizacion
       */
      public boolean editarInstituciones(Instituciones obj) {
          boolean resultado;
          resultado = false;
          int id = 0;
          try {
        InstitucionesDao dao = new InstitucionesDao();
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
       * @param Instituciones obj
       * @return Retorna el mismo objeto pero con los datos consultados
       */
      public Instituciones buscarPrimeroInstituciones(Instituciones obj) {
          List lista = null;
          try {
        InstitucionesDao dao = new InstitucionesDao();
              conn = conexion.conectarComparendos();
              lista = dao.searchMatching(conn, obj);
              if (lista != null && lista.size() > 0) {
                  obj = (Instituciones)lista.get(0);
              }
              else {
          obj.setID_INSTITUCION(-1);
              }
          } catch (Exception e) {
              e.printStackTrace();
              obj.setID_INSTITUCION(-1);
          } finally {
              conexion.cerrarCx();
          }
          return obj;
      }
      
      /**
       * Busca los registros que coincidan con los datos enviados
       * @param Instituciones obj
       * @return Retorna la lista de los registros que coinciden
       */
      public List buscarInstituciones(Instituciones obj) {
          List lista = null;
          try {
        InstitucionesDao dao = new InstitucionesDao();
              conn = conexion.conectarComparendos();
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
       * @param Instituciones obj
       * @return Retorna la lista de los registros en la tabla
       */
      public List listarInstituciones() {
          List lista = null;
          try {
        InstitucionesDao dao = new InstitucionesDao();
              conn = conexion.conectarComparendos();
              lista = dao.loadAll(conn);
          } catch (Exception e) {
              e.printStackTrace();
          } finally {
              conexion.cerrarCx();
          }
          return lista;
      }
      
    public int contarBusquedaInstituciones(Instituciones obj) {
      int cantidad=-1;
          try {
        InstitucionesDao dao = new InstitucionesDao();
              conn = conexion.conectarComparendos();
              cantidad = dao.countSearchMatching(conn, obj);
          } catch (Exception e) {
              e.printStackTrace();
        cantidad=-1;
          } finally {
              conexion.cerrarCx();
          }
          return cantidad;
      }
    
      /**
       * Elimina un registro de la tabla
       * @param Instituciones obj
       * @return Retorna un boolean indicando si se realizo o no la operacion
       */
      public boolean eliminarInstituciones(Instituciones obj) {
          boolean resultado;
          resultado = false;
          int id = 0;
          try {
        InstitucionesDao dao = new InstitucionesDao();
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

  //*************************** FIN Instituciones *******************************************
  //**************************************************************************************
      
            
  //*************************** INICIO Tipodoccobro *******************************************
  //**************************************************************************************

  /**
     * Inserta nuevo registro en la tabla
     * @param Tipodoccobro obj
     * @return Retorna el mismo objeto pero con la llave primaria configurada
     */
  public Tipodoccobro crearTipodoccobro(Tipodoccobro obj) {
    List lista = null;
        try {
            TipodoccobroDao dao = new TipodoccobroDao();
            conn = conexion.conectarComparendos();
            int id = Funciones.obtenerId(conn, "GEN_TIPODOCCOBRO", "GEN_TIPODOCCOBRO", myMotor);
            obj.setID_TIPODOC_COBRO(id);
            dao.create(conn, obj);
            //verificar existencia
            obj = new Tipodoccobro();
            obj.setID_TIPODOC_COBRO(id);
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Tipodoccobro)lista.get(0);
            }
            else {
                obj.setID_TIPODOC_COBRO(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_TIPODOC_COBRO(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
  
  /**
     * Edita un registro en la tabla
     * @param Tipodoccobro obj
     * @return boolean indicando si se realizo o no la actualizacion
     */
    public boolean editarTipodoccobro(Tipodoccobro obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
      TipodoccobroDao dao = new TipodoccobroDao();
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
     * @param Tipodoccobro obj
     * @return Retorna el mismo objeto pero con los datos consultados
     */
    public Tipodoccobro buscarPrimeroTipodoccobro(Tipodoccobro obj) {
        List lista = null;
        try {
      TipodoccobroDao dao = new TipodoccobroDao();
            conn = conexion.conectarComparendos();
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Tipodoccobro)lista.get(0);
            }
            else {
        obj.setID_TIPODOC_COBRO(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_TIPODOC_COBRO(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
    
    /**
     * Busca los registros que coincidan con los datos enviados
     * @param Tipodoccobro obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List buscarTipodoccobro(Tipodoccobro obj) {
        List lista = null;
        try {
      TipodoccobroDao dao = new TipodoccobroDao();
            conn = conexion.conectarComparendos();
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
     * @param Tipodoccobro obj
     * @return Retorna la lista de los registros en la tabla
     */
    public List listarTipodoccobro() {
        List lista = null;
        try {
      TipodoccobroDao dao = new TipodoccobroDao();
            conn = conexion.conectarComparendos();
            lista = dao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
  
  public int contarBusquedaTipodoccobro(Tipodoccobro obj) {
    int cantidad=-1;
        try {
      TipodoccobroDao dao = new TipodoccobroDao();
            conn = conexion.conectarComparendos();
            cantidad = dao.countSearchMatching(conn, obj);
        } catch (Exception e) {
            e.printStackTrace();
      cantidad=-1;
        } finally {
            conexion.cerrarCx();
        }
        return cantidad;
    }
  
    /**
     * Elimina un registro de la tabla
     * @param Tipodoccobro obj
     * @return Retorna un boolean indicando si se realizo o no la operacion
     */
    public boolean eliminarTipodoccobro(Tipodoccobro obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
      TipodoccobroDao dao = new TipodoccobroDao();
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

  //*************************** FIN Tipodoccobro *******************************************
  //**************************************************************************************
    
  //NUEVO METODO EDWIN
  public String consultarAlertas() {
    String resultado = "";
    try {
    ExpedienteDao dao = new ExpedienteDao();
        conn = conexion.conectarComparendos();
        resultado = dao.consultarAlertas(conn);        
    } catch (Exception e) {
        e.printStackTrace();
        resultado = "";
    } finally {
        conexion.cerrarCx();
    }
    return resultado;
  }
}
