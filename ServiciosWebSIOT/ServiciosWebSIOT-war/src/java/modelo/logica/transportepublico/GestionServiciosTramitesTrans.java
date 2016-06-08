package modelo.logica.transportepublico;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.accesorias.CategoriaLicTransitoDao;
import modelo.datos.dao.transportepublico.tramites.NuevaPersonaTransDao;
import modelo.datos.dao.transportepublico.tramites.NumConceptosFavorablesTransDao;
import modelo.datos.dao.transportepublico.tramites.TNuevosVehiculosTransDao;
import modelo.datos.dao.transportepublico.tramites.TarjetaOperacionDao;
import modelo.datos.dao.transportepublico.tramites.TtResolucionesTransDao;
import modelo.datos.objetos.accesorias.CategoriaLicTransito;
import modelo.datos.objetos.transportepublico.tramites.NuevaPersonaTrans;
import modelo.datos.objetos.transportepublico.tramites.NumConceptosFavorablesTrans;
import modelo.datos.objetos.transportepublico.tramites.TNuevosVehiculosTrans;
import modelo.datos.objetos.transportepublico.tramites.TarjetaOperacion;
import modelo.datos.objetos.transportepublico.tramites.TtResolucionesTrans;

import utilidades.Funciones;


public class GestionServiciosTramitesTrans {
    Conexion conexion;
    Connection conn;
    String myMotor;
    public GestionServiciosTramitesTrans() {
        super();
        myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
    }
     
    public int getMaxConcepto() 
    { 
        int Numconcepto=0;
        try
        {
            conexion = new Conexion();
            conn = conexion.conectar();
            NumConceptosFavorablesTransDao myNumConceptosFavorablesTransDao = new NumConceptosFavorablesTransDao();
            Numconcepto = myNumConceptosFavorablesTransDao.getMaxConcepto(conn);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
           conexion.cerrarCx();
        }
        return Numconcepto;
    }

    public List getSNumConceptosFavorablesTrans(NumConceptosFavorablesTrans numconceptosfavorables)
    {
        List lista;
        lista = null;
        int vig=0;
        try
        {
            conexion = new Conexion();
            conn = conexion.conectar();
            vig=Integer.parseInt(Funciones.getVigenciaActual());
            numconceptosfavorables.setVIGENCIAFAVORABLE(vig);
            NumConceptosFavorablesTransDao myNumConceptosFavorablesTransDao = new NumConceptosFavorablesTransDao();
            lista = myNumConceptosFavorablesTransDao.searchMatching(conn, numconceptosfavorables);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
           conexion.cerrarCx();
        }
        return lista;
    } 

    public int crearTNuevosVehiculosTrans(TNuevosVehiculosTrans tnuevovhiculotrans)
    {
        boolean resultado;
        resultado = false;
        TNuevosVehiculosTransDao myTNuevosVehiculosTransDao = new TNuevosVehiculosTransDao();
        int id=0;
        
        try
        {
            conexion = new Conexion();
            conn = conexion.conectar();
            id=Funciones.obtenerId(conn, "GEN_T_NUEVOSVEHICULO_TNV_ID", "GEN_T_NUEVOSVEHICULO", myMotor);
            tnuevovhiculotrans.setTNV_ID(id);
            myTNuevosVehiculosTransDao.create(conn, tnuevovhiculotrans);
            resultado = true;
        }
        catch (Exception e){
            e.printStackTrace();
            resultado = false;
            id=0;
        }
        finally{
            conexion.cerrarCx();
            myTNuevosVehiculosTransDao = null;
        }
        return id;
    }
    
    public boolean crearNumConceptosFavorablesTrans(NumConceptosFavorablesTrans numconceptofavorable)
    {
        boolean resultado;
        resultado = false;
        NumConceptosFavorablesTransDao myNumConceptosFavorablesTransDao = new NumConceptosFavorablesTransDao();
        int id=0;
        
        try
        {
            conexion = new Conexion();
            conn = conexion.conectar();
            id=Funciones.obtenerId(conn, "GEN_IDCONCEPTOFAVORABLE", "GEN_IDCONCEPTOFAVORABLE", myMotor);
            numconceptofavorable.setIDCONCEPTOFAVORABLE(id);
            myNumConceptosFavorablesTransDao.create(conn, numconceptofavorable);
            resultado = true;
        }
        catch (Exception e){
            e.printStackTrace();
            resultado = false;
        }
        finally{
            conexion.cerrarCx();
            myNumConceptosFavorablesTransDao = null;
        }
        return resultado;
    }    

    public boolean  editarNumConceptosFavorablesTrans(NumConceptosFavorablesTrans numconceptofavorable)
    {
        boolean resultado;
        resultado = false;
        NumConceptosFavorablesTransDao myNumConceptosFavorablesTransDao = new NumConceptosFavorablesTransDao();      
        try
        {
            conexion = new Conexion();
            conn = conexion.conectar();
            myNumConceptosFavorablesTransDao.save(conn, numconceptofavorable);
            resultado = true;
        }
        catch (Exception e){
            e.printStackTrace();
            resultado = false;
        }
        finally{
            conexion.cerrarCx();
            myNumConceptosFavorablesTransDao = null;
        }
        return resultado;
    }

    public List getTTtResolucionesTrans() 
    {
        List lista;
        lista = null;
        try
        {
            conexion = new Conexion();
            conn = conexion.conectar();
            TtResolucionesTransDao myTtResolucionesTransDao = new TtResolucionesTransDao();
            lista = myTtResolucionesTransDao.loadAll(conn);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
           conexion.cerrarCx();
        }
        return lista;
    }

    public TtResolucionesTrans getTtResolucionesTransPorId(TtResolucionesTrans ttresoluciones) 
    {
        TtResolucionesTransDao myTtResolucionesTransDao=new TtResolucionesTransDao();
        try 
        {
            conexion = new Conexion();
            conn = conexion.conectar();
            myTtResolucionesTransDao.load(conn, ttresoluciones);
        } catch (Exception e) 
        {
              e.printStackTrace();;
              ttresoluciones.setID(-1);
        } finally {
            conexion.cerrarCx();
        }
        return ttresoluciones;
    }

    public List getSTtResolucionesTrans(TtResolucionesTrans ttresoluciones)
    {
        List lista;
        lista = null;
        try
        {
            conexion = new Conexion();
            conn = conexion.conectar();
            TtResolucionesTransDao myTtResolucionesTransDao = new TtResolucionesTransDao();
            lista = myTtResolucionesTransDao.searchMatching(conn, ttresoluciones);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
           conexion.cerrarCx();
        }
        return lista;
    } 

    public int crearTtResolucionesTrans(TtResolucionesTrans ttresoluciones)
    {
        boolean resultado;
        resultado = false;
        TtResolucionesTransDao myTtResolucionesTransDao = new TtResolucionesTransDao();
        int id=0;
        String fechareg="";
        
        try
        {
            conexion = new Conexion();
            conn = conexion.conectar();
            id=Funciones.obtenerId(conn, "GEN_T_RESOLUCIONES_TR_ID", "GEN_T_RESOLUCIONES", myMotor);
            ttresoluciones.setID(id);
            fechareg=Funciones.getFechaSistema(conn,myMotor);
            ttresoluciones.setFECHAREGISTRO(fechareg);
            myTtResolucionesTransDao.create(conn, ttresoluciones);
            resultado = true;
        }
        catch (Exception e){
            e.printStackTrace();
            resultado = false;
            id=0;
        }
        finally{
            conexion.cerrarCx();
            myTtResolucionesTransDao = null;
        }
        return id;
    }
 
    public boolean editarTtResolucionesTrans(TtResolucionesTrans ttresoluciones)
    {
        boolean resultado;
        resultado = false;
        TtResolucionesTransDao myTtResolucionesTransDao = new TtResolucionesTransDao();      
        try
        {
            conexion = new Conexion();
            conn = conexion.conectar();
            myTtResolucionesTransDao.save(conn, ttresoluciones);
            resultado = true;
        }
        catch (Exception e){
            e.printStackTrace();
            resultado = false;
        }
        finally{
            conexion.cerrarCx();
            myTtResolucionesTransDao = null;
        }
        return resultado;
    } 
    
    public int crearNuevaPersonaTrans(NuevaPersonaTrans nuevapersona)
    {
        boolean resultado;
        resultado = false;
        NuevaPersonaTransDao myNuevaPersonaTransDao = new NuevaPersonaTransDao();
        int id=0;
        
        try
        {
            conexion = new Conexion();
            conn = conexion.conectar();
            id=Funciones.obtenerId(conn, "GEN_TT_NUEVAPERSONA", "GEN_TT_NUEVAPERSONA", myMotor);
            nuevapersona. setID(id);
            myNuevaPersonaTransDao.create(conn, nuevapersona);
            resultado = true;
        }
        catch (Exception e){
            e.printStackTrace();
            resultado = false;
            id=0;
        }
        finally{
            conexion.cerrarCx();
            myNuevaPersonaTransDao = null;
        }
        return id;
    }
    
  public TarjetaOperacion crearTarjetaOperacion(TarjetaOperacion tarjetaOperacion)
  {
      List lista;
      TarjetaOperacionDao myDao = new TarjetaOperacionDao();
      int id=0;
      
      try
      {
          conexion = new Conexion();
          conn = conexion.conectar();
          id=Funciones.obtenerId(conn, "ID_GEN_TARJETA", "GEN_ID_GEN_TARJETA", myMotor);
          tarjetaOperacion.setID(id);
          myDao.create(conn,tarjetaOperacion);
          tarjetaOperacion= new TarjetaOperacion();
          tarjetaOperacion.setID(id);
          lista=myDao.searchMatching(conn, tarjetaOperacion);
          
          if(lista!=null&&lista.size()>0)
          {
              tarjetaOperacion=(TarjetaOperacion)lista.get(0);
          }
      }
      catch (Exception e){
          e.printStackTrace();
          if(tarjetaOperacion!=null)
            tarjetaOperacion.setID(0);
      }
      finally{
          conexion.cerrarCx();
          myDao = null;
      }
      return tarjetaOperacion;
  }
  
  public boolean modificarTarjetaOperacion(TarjetaOperacion tarjetaOperacion)
  {
      boolean res = false;
      
      TarjetaOperacionDao myDao = new TarjetaOperacionDao();
      
      try
      {
          conexion = new Conexion();
          conn = conexion.conectar();
          myDao.save(conn,tarjetaOperacion);
          res = true;
      }
      catch (Exception e){
          e.printStackTrace();         
      }
      finally{
          conexion.cerrarCx();
          
          myDao = null;
      }
      
      return res;
  }
  
    public List getCategoriaLicTrans() 
    {
        List lista;
        lista = null;
        try
        {
            conexion = new Conexion();
            conn = conexion.conectar();
            CategoriaLicTransitoDao myCategoriaDao = new CategoriaLicTransitoDao();
            lista = myCategoriaDao.loadAll(conn);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
           conexion.cerrarCx();
        }
        return lista;
    }
  
    public List getCategoriaLicTrans(CategoriaLicTransito myCategoria) 
    {
        List lista;
        lista = null;
        try
        {
            conexion = new Conexion();
            conn = conexion.conectar();
            CategoriaLicTransitoDao myCategoriaDao = new CategoriaLicTransitoDao();
            lista = myCategoriaDao.searchMatching(conn,myCategoria);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
           conexion.cerrarCx();
        }
        return lista;
    }
    
    
    public List getTarjetaOperacion(TarjetaOperacion tarjetaOperacion)
    {
        List lista = null;
        TarjetaOperacionDao myDao = new TarjetaOperacionDao();
        try
        {
            conexion = new Conexion();
            conn = conexion.conectar();
            lista=myDao.searchMatching(conn,tarjetaOperacion);
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
