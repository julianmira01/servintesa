package modelo.logica.comparendos;

import java.sql.Array;
import java.sql.Connection;

import java.util.ArrayList;
import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.comparendos.accesorias.*;
import modelo.datos.dao.comparendos.generales.AgenteCompDao;
import modelo.datos.dao.comparendos.generales.PorcDescMoraTipoInfrDao;
import modelo.datos.dao.comparendos.generales.TipoInfrInfraccionCompDao;
import modelo.datos.dao.comparendos.generales.TipoInfraccionCompDao;
import modelo.datos.dao.comparendos.liquidacion.tarifas.LVigenciasCompDao;
import modelo.datos.dao.rangos.RangosDeplacasDao;
import modelo.datos.objetos.comparendos.accesorias.*;
import modelo.datos.objetos.comparendos.generales.PorcDescMoraTipoInfrComp;
import modelo.datos.objetos.comparendos.generales.TipoInfrInfraccionComp;
import modelo.datos.objetos.comparendos.liquidacion.tarifas.LVigenciasComp;

import utilidades.Funciones;
import modelo.datos.objetos.comparendos.generales.TipoInfraccionComp;

public class GestionServiciosAccesoriasComp {
    Conexion conexion;
    Connection conn;
    String myMotor;
    
    
    public GestionServiciosAccesoriasComp() {
        super();
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
    
    public List getTipoDocumento(DocumentoComp myDoc)
    {
        List mylista;
        mylista = null;
        try
        {
        conn = conexion.conectarComparendos();
        DocumentoCompDao myDocDao = new DocumentoCompDao();
        mylista = myDocDao.searchMatching(conn, myDoc);
        }
        catch (Exception e){
        e.printStackTrace();
        }
        finally{
        conexion.cerrarCx();
        }
        return mylista;
    }

    public List listarTiposDocumento()
    {
        List mylista;
        mylista = null;
        try
        {
            conn = conexion.conectarComparendos();
            DocumentoCompDao myDocDao = new DocumentoCompDao();
            mylista = myDocDao.loadAll(conn);
        }
        catch (Exception e){
        e.printStackTrace();
        }
        finally{
            conexion.cerrarCx();
        }
        return mylista;
    }
    
  public List listarClaseVehiculo()
  {
      List mylista;
      mylista = null;
      try
      {
          conn = conexion.conectarComparendos();
          ClaseVehiculoCompDao myDocDao = new ClaseVehiculoCompDao();
          mylista = myDocDao.loadAll(conn);
      }
      catch (Exception e){
      e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return mylista;
  }
  
  public List getClaseVehiculo(ClaseVehiculoComp claseVehiculoComp)
  {
      List mylista;
      mylista = null;
      try
      {
          conn = conexion.conectarComparendos();
          ClaseVehiculoCompDao myDocDao = new ClaseVehiculoCompDao();
          mylista = myDocDao.searchMatching(conn, claseVehiculoComp);
      }
      catch (Exception e){
      e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return mylista;
  }
  
  public String getClaseVehiculo(int idclase)
  {
      ClaseVehiculoComp tmp = new ClaseVehiculoComp();
      tmp.setID_CVEHICULO(idclase);
      try
      {
          conn = conexion.conectarComparendos();
          ClaseVehiculoCompDao myDocDao = new ClaseVehiculoCompDao();
          myDocDao.load(conn, tmp);
      }
      catch (Exception e){
      e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return tmp.getDESCRIPCION();
  }
  
  public List listarTipoServicioComp()
  {
      List mylista;
      mylista = null;
      try
      {
          conn = conexion.conectarComparendos();
          ServicioCompDao myDocDao = new ServicioCompDao();
          mylista = myDocDao.loadAll(conn);
      }
      catch (Exception e){
      e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return mylista;
  }
  
  public List getTipoServicioComp(ServicioComp servicioComp)
  {
      List mylista;
      mylista = null;
      try
      {
          conn = conexion.conectarComparendos();
          ServicioCompDao myDocDao = new ServicioCompDao();
          mylista = myDocDao.searchMatching(conn, servicioComp);
      }
      catch (Exception e){
      e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return mylista;
  }
  
  public String getTipoServicioComp(int idServicio)
  {
      ServicioComp tmp = new ServicioComp();
      tmp.setID_SERVICIO(idServicio);
      try
      {
          conn = conexion.conectarComparendos();
          ServicioCompDao myDocDao = new ServicioCompDao();
          myDocDao.load(conn, tmp);
      }
      catch (Exception e){
      e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return tmp.getDESCRIPCION();
  }
    
  public List listarOrganismoTransitoComp()
  {
      List mylista;
      mylista = null;
      try
      {
          conn = conexion.conectarComparendos();
          OrganismoTransitoCompDao myDocDao = new OrganismoTransitoCompDao();
          mylista = myDocDao.loadAll(conn);
      }
      catch (Exception e){
      e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return mylista;
  }
  
  public List getOrganismoTransitoComp(OrganismoTransitoComp organismoComp)
  {
      List mylista;
      mylista = null;
      try
      {
          conn = conexion.conectarComparendos();
          OrganismoTransitoCompDao myDocDao = new OrganismoTransitoCompDao();
          mylista = myDocDao.searchMatching(conn, organismoComp);
      }
      catch (Exception e){
      e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return mylista;
  }
  
  public String getNombreOrganismoTransitoComp(int id)
  {
      String res="";
      List mylista;
      mylista = null;
      OrganismoTransitoComp tmp = new OrganismoTransitoComp();
      tmp.setIDORGTRANSITO(id);
      try
      {
          conn = conexion.conectarComparendos();
          OrganismoTransitoCompDao myDocDao = new OrganismoTransitoCompDao();
          mylista = myDocDao.searchMatching(conn, tmp);
          if ( mylista!= null && mylista.size()>0) {
            tmp = (OrganismoTransitoComp)mylista.get(0);
            res = tmp.getNOMBRESECRETARIA();
          }
      }
      catch (Exception e){
      e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return res;
  }
  
  public boolean crearEmpresasComp(EmpresaComp empresaComp)
  {
      boolean res = false;
      int id;
      try
      {
          conn = conexion.conectarComparendos();
          myMotor=myMotor.toUpperCase();
          id=Funciones.obtenerId(conn, "GEN_EMPRESA", "GEN_EMPRESA", myMotor);
          empresaComp.setID_EMPRESA(id);
          EmpresaCompDao myDocDao = new EmpresaCompDao();
          myDocDao.create(conn, empresaComp);
          res = true;
      }
      catch (Exception e){
      e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return res;
  }
  
  public boolean actualizarEmpresasComp(EmpresaComp empresaComp)
  {
      boolean res = false;
      try
      {
          conn = conexion.conectarComparendos();
          EmpresaCompDao myDocDao = new EmpresaCompDao();
          myDocDao.save(conn, empresaComp);
          res = true;
      }
      catch (Exception e){
      e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return res;
  }
  
  public boolean eliminarEmpresasComp(EmpresaComp empresaComp)
  {
      boolean res = false;
      try
      {
          conn = conexion.conectarComparendos();
          EmpresaCompDao myDocDao = new EmpresaCompDao();
          myDocDao.delete(conn, empresaComp);
          res = true;
      }
      catch (Exception e){
      e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return res;
  }
  
  public List listarEmpresasComp()
  {
      List mylista;
      mylista = null;
      try
      {
          conn = conexion.conectarComparendos();
          EmpresaCompDao myDocDao = new EmpresaCompDao();
          mylista = myDocDao.loadAll(conn);
      }
      catch (Exception e){
      e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return mylista;
  }
  
  public List getEmpresasComp(EmpresaComp empresaComp)
  {
      List mylista;
      mylista = null;
      try
      {
          conn = conexion.conectarComparendos();
          EmpresaCompDao myDocDao = new EmpresaCompDao();
          mylista = myDocDao.searchMatching(conn, empresaComp);
      }
      catch (Exception e){
      e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return mylista;
  }
  
  public String getEmpresasComp(int idEmpresa)
  {
      EmpresaComp empresaComp = new EmpresaComp();
      empresaComp.setID_EMPRESA(idEmpresa);
      try
      {
          conn = conexion.conectarComparendos();
          EmpresaCompDao myDocDao = new EmpresaCompDao();
          myDocDao.load(conn, empresaComp);
      }
      catch (Exception e){
      e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return empresaComp.getRAZONSOCIAL();
  }
  
  public List listarRadioAccionComp()
  {
      List mylista;
      mylista = null;
      try
      {
          conn = conexion.conectarComparendos();
          RadioDeAccionCompDao myDocDao = new RadioDeAccionCompDao();
          mylista = myDocDao.loadAll(conn);
      }
      catch (Exception e){
      e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return mylista;
  }
  
  public List getRadioAccionComp(RadioDeAccionComp radioAccionComp)
  {
      List mylista;
      mylista = null;
      try
      {
          conn = conexion.conectarComparendos();
          RadioDeAccionCompDao myDocDao = new RadioDeAccionCompDao();
          mylista = myDocDao.searchMatching(conn, radioAccionComp);
      }
      catch (Exception e){
      e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return mylista;
  }
  
  public String getRadioAccionComp(int idRadioAccion)
  {
      RadioDeAccionComp radioAccionComp = new RadioDeAccionComp();
      radioAccionComp.setID_RADIODEACCION(idRadioAccion);
      try
      {
          conn = conexion.conectarComparendos();
          RadioDeAccionCompDao myDocDao = new RadioDeAccionCompDao();
          myDocDao.load(conn, radioAccionComp);
      }
      catch (Exception e){
      e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return radioAccionComp.getDESC_RADIOACCION();
  }
  
  public List listarModalidadTransComp()
  {
      List mylista;
      mylista = null;
      try
      {
          conn = conexion.conectarComparendos();
          ModalidadCompDao myDocDao = new ModalidadCompDao();
          mylista = myDocDao.loadAll(conn);
      }
      catch (Exception e){
      e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return mylista;
  }
  
  public List getModalidadTransComp(ModalidadComp modalidadComp)
  {
      List mylista;
      mylista = null;
      try
      {
          conn = conexion.conectarComparendos();
          ModalidadCompDao myDocDao = new ModalidadCompDao();
          mylista = myDocDao.searchMatching(conn, modalidadComp);
      }
      catch (Exception e){
      e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return mylista;
  }
  
  public List listarTransPasajerosComp()
  {
      List mylista;
      mylista = null;
      try
      {
          conn = conexion.conectarComparendos();
          TipoTransportePasajeroCompDao myDocDao = new TipoTransportePasajeroCompDao();
          mylista = myDocDao.loadAll(conn);
      }
      catch (Exception e){
      e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return mylista;
  }
  
  public List getTransPasajerosComp(TipoTransportePasajeroComp tipoTransporte)
  {
      List mylista;
      mylista = null;
      try
      {
          conn = conexion.conectarComparendos();
          TipoTransportePasajeroCompDao myDocDao = new TipoTransportePasajeroCompDao();
          mylista = myDocDao.searchMatching(conn, tipoTransporte);
      }
      catch (Exception e){
      e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return mylista;
  }
  
  public List listarCategoriaLicCondComp()
  {
      List mylista;
      mylista = null;
      try
      {
          conn = conexion.conectarComparendos();
          CategoriaLicTransitoCompDao myDocDao = new CategoriaLicTransitoCompDao();
          mylista = myDocDao.loadAll(conn);
      }
      catch (Exception e){
      e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return mylista;
  }
  
  public List getCategoriaLicCondComp(CategoriaLicTransitoComp categoriaLicTransComp)
  {
      List mylista;
      mylista = null;
      try
      {
          conn = conexion.conectarComparendos();
          CategoriaLicTransitoCompDao myDocDao = new CategoriaLicTransitoCompDao();
          mylista = myDocDao.searchMatching(conn, categoriaLicTransComp);
      }
      catch (Exception e){
      e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return mylista;
  }
  
  public List listarSexoComp()
  {
      List mylista;
      mylista = null;
      try
      {
          conn = conexion.conectarComparendos();
          SexoCompDao myDocDao = new SexoCompDao();
          mylista = myDocDao.loadAll(conn);
      }
      catch (Exception e){
      e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return mylista;
  }
  
  public List getSexoComp(SexoComp sexoComp)
  {
      List mylista;
      mylista = null;
      try
      {
          conn = conexion.conectarComparendos();
          SexoCompDao myDocDao = new SexoCompDao();
          mylista = myDocDao.searchMatching(conn, sexoComp);
      }
      catch (Exception e){
      e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return mylista;
  }
  
  public List listarCiudadComp()
  {
      List mylista;
      mylista = null;
      try
      {
          conn = conexion.conectarComparendos();
          CiudadCompDao myDocDao = new CiudadCompDao();
          mylista = myDocDao.loadAll(conn);
      }
      catch (Exception e){
      e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return mylista;
  }
  
  public List getCiudadComp(CiudadComp ciudadComp)
  {
      List mylista;
      mylista = null;
      try
      {
          conn = conexion.conectarComparendos();
          CiudadCompDao myDocDao = new CiudadCompDao();
          mylista = myDocDao.searchMatching(conn, ciudadComp);
      }
      catch (Exception e){
      e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return mylista;
  }
  
  public double getSalario(int annio){
    double res =0;
    SalarioMinimoComp salarioComp = new SalarioMinimoComp();
    salarioComp.setANO(annio);
    try
    {
        conn = conexion.conectar();
        SalarioMinimoCompDao salarioCompDao = new SalarioMinimoCompDao();
        salarioCompDao.load(conn, salarioComp);
        if (salarioComp != null)
            res = salarioComp.getVALOR();
    }
    catch (Exception e){
    e.printStackTrace();
    }
    finally{
        conexion.cerrarCx();
    }
    return res;
  }
  
  public List ListarInfracciones()
  {
      List mylista;
      mylista = null;
      try
      {
          conn = conexion.conectarComparendos();
          InfraccionesCompDao infraccionesDao = new InfraccionesCompDao();
          mylista = infraccionesDao.loadAll(conn);
      }
      catch (Exception e){
      e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return mylista;
  }

    public List ListarTipoInfraccionEstado()
    {
        List mylista;
        mylista = null;
        try
        {
            conn = conexion.conectarComparendos();
            TipoInfraccioEstadoDao tipoInfraccionesDao  = new TipoInfraccioEstadoDao();
            mylista = tipoInfraccionesDao.loadAll(conn);
        }
        catch (Exception e){
        e.printStackTrace();
        }
        finally{
            conexion.cerrarCx();
        }
        return mylista;
    }

    public List ListarTiposInfraccion()
    {
        List mylista;
        mylista = null;
        try
        {
            conn = conexion.conectarComparendos();
            TipoInfraccionCompDao tipoInfraccionesDao  = new TipoInfraccionCompDao();
            mylista = tipoInfraccionesDao.loadAll(conn);
        }
        catch (Exception e){
        e.printStackTrace();
        }
        finally{
            conexion.cerrarCx();
        }
        return mylista;
    }
    
    public List ListarTiposInfrInfraccion()
    {
        List mylista;
        mylista = null;
        try
        {
            conn = conexion.conectarComparendos();
            TipoInfrInfraccionCompDao tipoInfraccionesDao  = new TipoInfrInfraccionCompDao();
            mylista = tipoInfraccionesDao.loadAll(conn);
        }
        catch (Exception e){
        e.printStackTrace();
        }
        finally{
            conexion.cerrarCx();
        }
        return mylista;
    }
    
    public List ListarPorcDescMoraTipoInfr()
    {
        List mylista;
        mylista = null;
        try
        {
            conn = conexion.conectarComparendos();
            PorcDescMoraTipoInfrDao tipoInfraccionesDao  = new PorcDescMoraTipoInfrDao();
            mylista = tipoInfraccionesDao.loadAll(conn);
        }
        catch (Exception e){
        e.printStackTrace();
        }
        finally{
            conexion.cerrarCx();
        }
        return mylista;
    }
    
    public List getTipoInfraccionEstado(TipoInfraccioEstado tipoInfraccion)
    {
        List mylista;
        mylista = null;
        try
        {
            conn = conexion.conectarComparendos();
            TipoInfraccioEstadoDao myDao = new TipoInfraccioEstadoDao();
            mylista = myDao.searchMatching(conn, tipoInfraccion);
        }
        catch (Exception e){
        e.printStackTrace();
        }
        finally{
            conexion.cerrarCx();
        }
        return mylista;
    }
    
    public List getTipoInfraccionComp(TipoInfraccionComp tipoInfraccion)
    {
        List mylista;
        mylista = null;
        try
        {
            conn = conexion.conectarComparendos();
            TipoInfraccionCompDao myDao = new TipoInfraccionCompDao();
            mylista = myDao.searchMatching(conn, tipoInfraccion);
        }
        catch (Exception e){
        e.printStackTrace();
        }
        finally{
            conexion.cerrarCx();
        }
        return mylista;
    }
    
    public List getTipoInfrInfraccionComp(TipoInfrInfraccionComp tipoInfraccion)
    {
        List mylista;
        mylista = null;
        try
        {
            conn = conexion.conectarComparendos();
            TipoInfrInfraccionCompDao myDao = new TipoInfrInfraccionCompDao();
            mylista = myDao.searchMatching(conn, tipoInfraccion);
        }
        catch (Exception e){
        e.printStackTrace();
        }
        finally{
            conexion.cerrarCx();
        }
        return mylista;
    }
    
    public List getTiposInfraccionComp()
    {
        List mylista;
        mylista = null;
        try
        {
            conn = conexion.conectarComparendos();
            TipoInfraccionCompDao myDao = new TipoInfraccionCompDao();
            mylista = myDao.loadAll(conn);
        }
        catch (Exception e){
        e.printStackTrace();
        }
        finally{
            conexion.cerrarCx();
        }
        return mylista;
    }
    
    
    public List getPorcDescMoraTipoInfr(PorcDescMoraTipoInfrComp tipoInfraccion)
    {
        List mylista;
        mylista = null;
        try
        {
            conn = conexion.conectarComparendos();
            PorcDescMoraTipoInfrDao myDao = new PorcDescMoraTipoInfrDao();
            mylista = myDao.searchMatching(conn, tipoInfraccion);
        }
        catch (Exception e){
        e.printStackTrace();
        }
        finally{
            conexion.cerrarCx();
        }
        return mylista;
    }
    
    public boolean crearTipoInfraccionEstado(TipoInfraccioEstado tipoInfraccionComp)
    {
        boolean resultado;
        resultado = false;
       TipoInfraccioEstadoDao myInfraccionesCompDao = new TipoInfraccioEstadoDao();
        int id=0;
        
        try
        {
            conn = conexion.conectarComparendos();
            myMotor=myMotor.toUpperCase();
            id=Funciones.obtenerId(conn, "GEN_TIPO_INFRACCION_ESTADO", "GEN_TIPO_INFRACCION_ESTADO", myMotor);
            tipoInfraccionComp.setID_TIPO_INFR_ESTADO(id);
            myInfraccionesCompDao.create(conn, tipoInfraccionComp);
            resultado = true;
        }
        catch (Exception e){
            e.printStackTrace();
            resultado = false;
        }
        finally{
            conexion.cerrarCx();
            myInfraccionesCompDao = null;
        }
        return resultado;
    } 
    
    public boolean crearTipoInfraccionComp(TipoInfraccionComp tipoInfraccionComp)
    {
        boolean resultado;
        resultado = false;
       TipoInfraccionCompDao myInfraccionesCompDao = new TipoInfraccionCompDao();
        int id=0;
        
        try
        {
            conn = conexion.conectarComparendos();
            myMotor=myMotor.toUpperCase();
            id=Funciones.obtenerId(conn, "GEN_TIPO_INFRACCION", "GEN_TIPO_INFRACCION", myMotor);
            tipoInfraccionComp.setID_TIPO_INFRACCION(id);
            myInfraccionesCompDao.create(conn, tipoInfraccionComp);
            resultado = true;
        }
        catch (Exception e){
            e.printStackTrace();
            resultado = false;
        }
        finally{
            conexion.cerrarCx();
            myInfraccionesCompDao = null;
        }
        return resultado;
    } 
    
    public boolean crearTipoInfrInfraccionComp(TipoInfrInfraccionComp tipoInfraccionComp)
    {
        boolean resultado;
        resultado = false;
       TipoInfrInfraccionCompDao myInfraccionesCompDao = new TipoInfrInfraccionCompDao();
        int id=0;
        
        try
        {
            conn = conexion.conectarComparendos();
            myMotor=myMotor.toUpperCase();
            id=Funciones.obtenerId(conn, "GEN_TIPO_INFR_INFRACCION", "GEN_TIPO_INFR_INFRACCION", myMotor);
            tipoInfraccionComp.setID_TIPO_INFR_INFRACCION(id);
            myInfraccionesCompDao.create(conn, tipoInfraccionComp);
            resultado = true;
        }
        catch (Exception e){
            e.printStackTrace();
            resultado = false;
        }
        finally{
            conexion.cerrarCx();
            myInfraccionesCompDao = null;
        }
        return resultado;
    } 
    
    public boolean crearPorcDescMoraTipoInfr(PorcDescMoraTipoInfrComp tipoInfraccionComp)
    {
        boolean resultado;
        resultado = false;
       PorcDescMoraTipoInfrDao myInfraccionesCompDao = new PorcDescMoraTipoInfrDao();
        int id=0;
        
        try
        {
            conn = conexion.conectarComparendos();
            myMotor=myMotor.toUpperCase();
            id=Funciones.obtenerId(conn, "GEN_PORC_DESC_MORA_TIPO_INFR", "GEN_PORC_DESC_MORA_TIPO_INFR", myMotor);
            tipoInfraccionComp.setID_PORC_DESC_MORA_TIPO_INFR(id);
            myInfraccionesCompDao.create(conn, tipoInfraccionComp);
            resultado = true;
        }
        catch (Exception e){
            e.printStackTrace();
            resultado = false;
        }
        finally{
            conexion.cerrarCx();
            myInfraccionesCompDao = null;
        }
        return resultado;
    } 
    
    public boolean editarInfraccionesComp(InfraccionesComp infraccionesComp)
    {
        boolean resultado;
        resultado = false;
        InfraccionesCompDao myInfraccionesCompDao = new InfraccionesCompDao();      
        try
        {
            conn = conexion.conectarComparendos();
            myInfraccionesCompDao.save(conn, infraccionesComp);
            resultado = true;
        }
        catch (Exception e){
            e.printStackTrace();
            resultado = false;
        }
        finally{
            conexion.cerrarCx();
            myInfraccionesCompDao = null;
        }
        return resultado;
    }
    
    public boolean editarTipoInfraccionesEstado(TipoInfraccioEstado infraccionesComp)
    {
        boolean resultado;
        resultado = false;
        TipoInfraccioEstadoDao myInfraccionesCompDao = new TipoInfraccioEstadoDao();      
        try
        {
            conn = conexion.conectarComparendos();
            myInfraccionesCompDao.save(conn, infraccionesComp);
            resultado = true;
        }
        catch (Exception e){
            e.printStackTrace();
            resultado = false;
        }
        finally{
            conexion.cerrarCx();
            myInfraccionesCompDao = null;
        }
        return resultado;
    }


    public boolean editarPorcDescMoraTipoInfr(PorcDescMoraTipoInfrComp infraccionesComp)
    {
        boolean resultado;
        resultado = false;
        PorcDescMoraTipoInfrDao myInfraccionesCompDao = new PorcDescMoraTipoInfrDao();      
        try
        {
            conn = conexion.conectarComparendos();
            myInfraccionesCompDao.save(conn, infraccionesComp);
            resultado = true;
        }
        catch (Exception e){
            e.printStackTrace();
            resultado = false;
        }
        finally{
            conexion.cerrarCx();
            myInfraccionesCompDao = null;
        }
        return resultado;
    }
    
    public boolean eliminarPorcDescMoraTipoInfr(PorcDescMoraTipoInfrComp tipoInfraccionesComp)
    {
        List mylista;
        mylista = null;
        boolean res = false;
        try
        {
            conn = conexion.conectarComparendos();
            PorcDescMoraTipoInfrDao myInfraccionesCompDao = new PorcDescMoraTipoInfrDao();
            myInfraccionesCompDao.delete(conn, tipoInfraccionesComp);
            res = true;
        }
        catch (Exception e){
        e.printStackTrace();
        }
        finally{
            conexion.cerrarCx();
        }
        return res;
    }
           
    public boolean eliminarTipoInfraccionComp(TipoInfraccionComp tipoInfraccionesComp)
    {
        List mylista;
        mylista = null;
        boolean res = false;
        try
        {
            conn = conexion.conectarComparendos();
            TipoInfraccionCompDao myInfraccionesCompDao = new TipoInfraccionCompDao();
            myInfraccionesCompDao.delete(conn, tipoInfraccionesComp);
            res = true;
        }
        catch (Exception e){
        e.printStackTrace();
        }
        finally{
            conexion.cerrarCx();
        }
        return res;
    }
    
    public boolean eliminarTipoInfrInfraccionComp(TipoInfrInfraccionComp tipoInfraccionesComp)
    {
        List mylista;
        mylista = null;
        boolean res = false;
        try
        {
            conn = conexion.conectarComparendos();
            TipoInfrInfraccionCompDao myInfraccionesCompDao = new TipoInfrInfraccionCompDao();
            myInfraccionesCompDao.delete(conn, tipoInfraccionesComp);
            res = true;
        }
        catch (Exception e){
        e.printStackTrace();
        }
        finally{
            conexion.cerrarCx();
        }
        return res;
    }
    
  public boolean crearInfraccionesComp(InfraccionesComp infraccionesComp)
  {
      boolean resultado;
      resultado = false;
      InfraccionesCompDao myInfraccionesCompDao = new InfraccionesCompDao();
      int id=0;
      
      try
      {
          conn = conexion.conectarComparendos();
          myMotor=myMotor.toUpperCase();
          id=Funciones.obtenerId(conn, "GEN_INFRACCION", "GEN_INFRACCION", myMotor);
          infraccionesComp.setID_INFRACCION(id);
          myInfraccionesCompDao.create(conn, infraccionesComp);
          resultado = true;
      }
      catch (Exception e){
          e.printStackTrace();
          resultado = false;
      }
      finally{
          conexion.cerrarCx();
          myInfraccionesCompDao = null;
      }
      return resultado;
  }  

  public boolean editarTipoInfraccionComp(TipoInfraccionComp infraccionesComp)
  {
      boolean resultado;
      resultado = false;
      TipoInfraccionCompDao myInfraccionesCompDao = new TipoInfraccionCompDao();      
      try
      {
          conn = conexion.conectarComparendos();
          myInfraccionesCompDao.save(conn, infraccionesComp);
          resultado = true;
      }
      catch (Exception e){
          e.printStackTrace();
          resultado = false;
      }
      finally{
          conexion.cerrarCx();
          myInfraccionesCompDao = null;
      }
      return resultado;
  }
  
    public boolean editarTipoInfrInfraccionComp(TipoInfrInfraccionComp infraccionesComp)
    {
        boolean resultado;
        resultado = false;
        TipoInfrInfraccionCompDao myInfraccionesCompDao = new TipoInfrInfraccionCompDao();      
        try
        {
            conn = conexion.conectarComparendos();
            myInfraccionesCompDao.save(conn, infraccionesComp);
            resultado = true;
        }
        catch (Exception e){
            e.printStackTrace();
            resultado = false;
        }
        finally{
            conexion.cerrarCx();
            myInfraccionesCompDao = null;
        }
        return resultado;
    }

  public boolean eliminarInfraccionesComp(InfraccionesComp infraccionesComp)
  {
      List mylista;
      mylista = null;
      boolean res = false;
      try
      {
          conn = conexion.conectarComparendos();
          InfraccionesCompDao myInfraccionesCompDao = new InfraccionesCompDao();
          myInfraccionesCompDao.delete(conn, infraccionesComp);
          res = true;
      }
      catch (Exception e){
      e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return res;
  }
  
  public InfraccionesComp getInfraccion(InfraccionesComp infraccionesComp)
  {
      List mylista;
      mylista = null;
      try
      {
          conn = conexion.conectarComparendos();
          InfraccionesCompDao infraccionesDao = new InfraccionesCompDao();
          mylista = infraccionesDao.searchMatching(conn, infraccionesComp);
          if (mylista != null && mylista.size()>0)
              infraccionesComp = (InfraccionesComp) mylista.get(0);
          else
              infraccionesComp.setID_INFRACCION(-1);
      }
      catch (Exception e){
      e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return infraccionesComp;
  }
  
    public boolean eliminarTipoInfraccionEstado(TipoInfraccioEstado infraccionesComp)
    {
        List mylista;
        mylista = null;
        boolean res = false;
        try
        {
            conn = conexion.conectarComparendos();
            TipoInfraccioEstadoDao myInfraccionesCompDao = new TipoInfraccioEstadoDao();
            myInfraccionesCompDao.delete(conn, infraccionesComp);
            res = true;
        }
        catch (Exception e){
        e.printStackTrace();
        }
        finally{
            conexion.cerrarCx();
        }
        return res;
    }
  public List getTipoInfractorComp(TipoInfractorComp tipoInfractorComp)
  {
      List mylista;
      mylista = null;
      try
      {
          conn = conexion.conectarComparendos();
          TipoInfractorCompDao myDao = new TipoInfractorCompDao();
          mylista = myDao.searchMatching(conn, tipoInfractorComp);
      }
      catch (Exception e){
      e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return mylista;
  }
  public List listarTipoInfractorComp()
  {
      List mylista;
      mylista = null;
      try
      {
          conn = conexion.conectarComparendos();
          TipoInfractorCompDao myDao = new TipoInfractorCompDao();
          mylista = myDao.loadAll(conn);
      }
      catch (Exception e){
      e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return mylista;
  }
  
  public String getCodTipoDoc(int id) {
      String res = "";
      List lista;
      lista = null;
      DocumentoComp tmp = new DocumentoComp();
      tmp.setID_DOCCOMP(id);
      try
      {
          conn = conexion.conectarComparendos();
          DocumentoCompDao myDao = new DocumentoCompDao();
          lista = myDao.searchMatching(conn, tmp);
          if (lista != null &&lista.size()>0) {
            tmp = (DocumentoComp)lista.get(0);
            res = tmp.getID_DOCTO();
          }
      }
      catch (Exception e){
          e.printStackTrace();
      }
      finally{
         conexion.cerrarCx();
      }
      return res;      
  }
  
  public boolean crearPatiosComp(PatiosInmovilizacionComp patioInmovilizacion)
  {
      List mylista;
      mylista = null;
      boolean res = false;
      int id;
      try
      {
          conn = conexion.conectarComparendos();
          myMotor=myMotor.toUpperCase();
          id=Funciones.obtenerId(conn, "GEN_PATIOSINMOVILIZACION", "GEN_PATIOSINMOVILIZACION", myMotor);
          patioInmovilizacion.setID_PATIO(id);
          PatiosInmovilizacionCompDao myDao = new PatiosInmovilizacionCompDao();
          myDao.create(conn, patioInmovilizacion);
          res = true;
      }
      catch (Exception e){
      e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return res;
  }
  
  public boolean actualizarPatiosComp(PatiosInmovilizacionComp patioInmovilizacion)
  {
      List mylista;
      mylista = null;
      boolean res = false;
      try
      {
          conn = conexion.conectarComparendos();
          PatiosInmovilizacionCompDao myDao = new PatiosInmovilizacionCompDao();
          myDao.save(conn, patioInmovilizacion);
          res = true;
      }
      catch (Exception e){
      e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return res;
  }
  
  public boolean eliminarPatiosComp(PatiosInmovilizacionComp patioInmovilizacion)
  {
      List mylista;
      mylista = null;
      boolean res = false;
      try
      {
          conn = conexion.conectarComparendos();
          PatiosInmovilizacionCompDao myDao = new PatiosInmovilizacionCompDao();
          myDao.delete(conn, patioInmovilizacion);
          res = true;
      }
      catch (Exception e){
      e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return res;
  }
  
  public List listarPatiosComp()
  {
      List mylista;
      mylista = null;
      
      try
      {
          conn = conexion.conectarComparendos();
          PatiosInmovilizacionCompDao myDao = new PatiosInmovilizacionCompDao();
          mylista = myDao.loadAll(conn);
          
      }
      catch (Exception e){
      e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return mylista;
  }
  
  public PatiosInmovilizacionComp getOnePatiosComp(PatiosInmovilizacionComp patios)
  {
      List mylista;
      mylista = null;
      PatiosInmovilizacionComp res = null;
      try
      {
          conn = conexion.conectarComparendos();
          res = new PatiosInmovilizacionComp();
          PatiosInmovilizacionCompDao myDao = new PatiosInmovilizacionCompDao();
          mylista = myDao.searchMatching(conn, patios);
          if (mylista != null && mylista.size()>0)
              res = (PatiosInmovilizacionComp)mylista.get(0);
          
      }
      catch (Exception e){
      e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return res;
  }
  
  public String getDireccionPatiosComp(int id)
  {
      List mylista;
      mylista = null;
      String res = "";
      PatiosInmovilizacionComp tmp = new PatiosInmovilizacionComp();
      tmp.setID_PATIO(id);
      try
      {
          conn = conexion.conectarComparendos();
          PatiosInmovilizacionCompDao myDao = new PatiosInmovilizacionCompDao();
          mylista = myDao.searchMatching(conn, tmp);
          if (mylista != null && mylista.size()>0){
              tmp = (PatiosInmovilizacionComp)mylista.get(0);
              res = tmp.getDIRECCIONPATIO();
              }
          
      }
      catch (Exception e){
      e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return res;
  }
  
  public List listarEstadosComp()
  {
      List mylista;
      mylista = null;
      
      try
      {
          conn = conexion.conectarComparendos();
          EstadoCompDao myDao = new EstadoCompDao();
          mylista = myDao.loadAll(conn);
          
      }
      catch (Exception e){
      e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return mylista;
  }
  
  public List SearchEstadosComp(EstadoComp estadoComp)
  {
      List mylista;
      mylista = null;
      
      try
      {
          conn = conexion.conectarComparendos();
          EstadoCompDao myDao = new EstadoCompDao();
          mylista = myDao.searchMatching(conn, estadoComp);
            
      }
      catch (Exception e){
      e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return mylista;
  }
  
    public List buscarInfraccionesPorTipoInfraccion(TipoInfraccionComp tipoInfraccion)
    {
        List mylista;
        mylista = null;
        List al = new ArrayList();
        try
        {
            TipoInfrInfraccionComp tmp = new TipoInfrInfraccionComp();
            tmp.setID_TIPO_INFRACCION(tipoInfraccion.getID_TIPO_INFRACCION());
            conn = conexion.conectarComparendos();
            TipoInfrInfraccionCompDao myDao = new TipoInfrInfraccionCompDao();
            mylista = myDao.searchMatching(conn, tmp);
            
            if(mylista != null && mylista.size()>0)
            {
                for(int i = 0; i < mylista.size();i++)
                {
                    TipoInfrInfraccionComp tmpTIIC = (TipoInfrInfraccionComp)mylista.get(i);
                    InfraccionesComp ic = new InfraccionesComp();
                    ic.setID_INFRACCION(tmpTIIC.getID_INFRACCION());
                    InfraccionesCompDao dao = new InfraccionesCompDao();
                    List listaTmp = dao.searchMatching(conn, ic);
                    al.add(listaTmp.get(0));
                }
            } 
        }
        catch (Exception e){
        e.printStackTrace();
        }
        finally{
            conexion.cerrarCx();
        }
        return al;
    }
    
  public EstadoComp  SearchOneEstadosComp(EstadoComp estadoComp)
  {
      List mylista;
      mylista = null;
      EstadoComp tmp = new EstadoComp();
      try
      {
          conn = conexion.conectarComparendos();
          EstadoCompDao myDao = new EstadoCompDao();
          mylista = myDao.searchMatching(conn, estadoComp);
          if (mylista!= null && mylista.size()>0)
              tmp = (EstadoComp)mylista.get(0);
            
      }
      catch (Exception e){
      e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return tmp;
  }
  
  public List listarDepartamentosComp()
  {
      List mylista;
      mylista = null;
      
      try
      {
          conn = conexion.conectarComparendos();
          DepartamentoCompDao myDao = new DepartamentoCompDao();
          mylista = myDao.loadAll(conn);
          
      }
      catch (Exception e){
      e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return mylista;
  }
  
  public DepartamentoComp getOneDepartamentosComp(DepartamentoComp departamento)
  {
      List mylista;
      mylista = null;
      DepartamentoComp res = null;
      try
      {
          conn = conexion.conectarComparendos();
          res = new DepartamentoComp();
          DepartamentoCompDao myDao = new DepartamentoCompDao();
          mylista = myDao.searchMatching(conn, departamento);
          if (mylista != null && mylista.size()>0)
              res = (DepartamentoComp)mylista.get(0);
          
      }
      catch (Exception e){
      e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return res;
  }
  
  public boolean crearDepartamentosComp(DepartamentoComp departamento)
  {
      boolean res = false;
      //int id;
      try
      {
          conn = conexion.conectarComparendos();
          /*myMotor=myMotor.toUpperCase();
          id=Funciones.obtenerId(conn, "GEN_PATIOSINMOVILIZACION", "GEN_PATIOSINMOVILIZACION", myMotor);*/
          DepartamentoCompDao myDao = new DepartamentoCompDao();
          //departamento.setID_DEPTO(id);
          myDao.create(conn, departamento);
          res = true;
          
      }
      catch (Exception e){
      e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return res;
  }
  
  public boolean eliminarDepartamentosComp(DepartamentoComp departamento)
  {
      boolean res = false;
      try
      {
          conn = conexion.conectarComparendos();
          DepartamentoCompDao myDao = new DepartamentoCompDao();
          myDao.delete(conn, departamento);
          res = true;
          
      }
      catch (Exception e){
      e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return res;
  }
  
  public boolean actualizarDepartamentosComp(DepartamentoComp departamento)
  {
      boolean res = false;
      try
      {
          conn = conexion.conectarComparendos();
          DepartamentoCompDao myDao = new DepartamentoCompDao();
          myDao.save(conn, departamento);
          res = true;
          
      }
      catch (Exception e){
      e.printStackTrace();
      }
      finally{
          conexion.cerrarCx();
      }
      return res;
  }
  
}
