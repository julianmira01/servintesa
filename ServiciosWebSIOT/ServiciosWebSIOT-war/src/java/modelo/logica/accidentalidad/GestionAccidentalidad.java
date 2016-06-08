package modelo.logica.accidentalidad;

//import com.bea.core.repackaged.aspectj.internal.lang.reflect.DeclareAnnotationImpl;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.accidentalidad.AccesoriaAccidenteDao;
import modelo.datos.dao.accidentalidad.AccidenteDao;
import modelo.datos.dao.accidentalidad.CitasAudienciaDao;
import modelo.datos.dao.accidentalidad.ComparendoAccidenteDao;
import modelo.datos.dao.accidentalidad.DeclaracionesAudienciaDao;
import modelo.datos.dao.accidentalidad.FalloAudienciaDao;
import modelo.datos.dao.accidentalidad.ImplicadoDao;
import modelo.datos.dao.accidentalidad.VehiculoAccidenteDao;
import modelo.datos.dao.clavesutilizadas.ClavesutilizadasDao;
import modelo.datos.objetos.accidentalidad.AccesoriaAccidente;
import modelo.datos.objetos.accidentalidad.Accidente;
import modelo.datos.objetos.accidentalidad.CitasAudiencia;
import modelo.datos.objetos.accidentalidad.ComparendoAccidente;
import modelo.datos.objetos.accidentalidad.DeclaracionesAudiencia;
import modelo.datos.objetos.accidentalidad.FalloAudiencia;
import modelo.datos.objetos.accidentalidad.Implicado;
import modelo.datos.objetos.accidentalidad.VehiculoAccidente;
import modelo.datos.objetos.clavesutilizadas.Clavesutilizadas;

import utilidades.Funciones;
import utilidades.Seguridad;


public class GestionAccidentalidad {
    Conexion conexion;
    Connection conn;
    String myMotor;

    public GestionAccidentalidad() {
        super();
        crearObjetos();
    }
    
    private void crearObjetos(){
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
    
    public int getConsecutivoAccidente() 
    {
        conn = conexion.conectarComparendos();
        try{
        return Funciones.obtenerId(conn, "GEN_CONSECUTIVO_ACCIDENTES", "GEN_CONSECUTIVO_ACCIDENTES", myMotor);
        }
        catch(Exception exce){return -1;}
    }
    
    public Implicado crearImplicado(Implicado obj) 
    {
        List lista = null;
        try {
            ImplicadoDao dao = new ImplicadoDao();
            conn = conexion.conectarComparendos();
            int id = Funciones.obtenerId(conn, "GEN_IMPLICADOS", "GEN_IMPLICADOS", myMotor);
            obj.setID_IMPLICADOS(id);
            dao.create(conn, obj);
            //verificar existencia
            obj = new Implicado();
            obj.setID_IMPLICADOS(id);
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Implicado)lista.get(0);
            }
            else {
                obj.setID_IMPLICADOS(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_IMPLICADOS(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
    
    public FalloAudiencia crearFalloAudiencia(FalloAudiencia obj) 
    {
        List lista = null;
        try {
            FalloAudienciaDao dao = new FalloAudienciaDao();
            conn = conexion.conectarComparendos();
            int id = Funciones.obtenerId(conn, "GEN_FALLO_AUDIENCIA", "GEN_FALLO_AUDIENCIA", myMotor);
            obj.setID_FALLO_AUDIENCIA(id);
            dao.create(conn, obj);
            //verificar existencia
            obj = new FalloAudiencia();
            obj.setID_FALLO_AUDIENCIA(id);
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (FalloAudiencia)lista.get(0);
            }
            else {
                obj.setID_FALLO_AUDIENCIA(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_FALLO_AUDIENCIA(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
    
    public CitasAudiencia crearCitaAudiencia(CitasAudiencia obj) 
    {
        List lista = null;
        try {
            CitasAudienciaDao dao = new CitasAudienciaDao();
            conn = conexion.conectarComparendos();
            int id = Funciones.obtenerId(conn, "GEN_CITAS_AUDIENCIA", "GEN_CITAS_AUDIENCIA", myMotor);
            obj.setID_CITAS_AUDIENCIA(id);
            dao.create(conn, obj);
            //verificar existencia
            obj = new CitasAudiencia();
            obj.setID_CITAS_AUDIENCIA(id);
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (CitasAudiencia)lista.get(0);
            }
            else {
                obj.setID_CITAS_AUDIENCIA(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_CITAS_AUDIENCIA(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
    
    public DeclaracionesAudiencia crearDeclaracionesAudiencia(DeclaracionesAudiencia obj) 
    {
        List lista = null;
        try {
            DeclaracionesAudienciaDao dao = new DeclaracionesAudienciaDao();
            conn = conexion.conectarComparendos();
            int id = Funciones.obtenerId(conn, "GEN_DECLARACIONES_AUDIENCIA", "GEN_DECLARACIONES_AUDIENCIA", myMotor);
            obj.setID_DECLARACIONES_AUDIENCIA(id);
            dao.create(conn, obj);
            //verificar existencia
            obj = new DeclaracionesAudiencia();
            obj.setID_DECLARACIONES_AUDIENCIA(id);
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (DeclaracionesAudiencia)lista.get(0);
            }
            else {
                obj.setID_DECLARACIONES_AUDIENCIA(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_DECLARACIONES_AUDIENCIA(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
    
    public VehiculoAccidente crearVehiculoAccidente(VehiculoAccidente obj) 
    {
        List lista = null;
        try {
            VehiculoAccidenteDao dao = new VehiculoAccidenteDao();
            conn = conexion.conectarComparendos();
            int id = Funciones.obtenerId(conn, "GEN_VEHICULOS_ACCIDENTE", "GEN_VEHICULOS_ACCIDENTE", myMotor);
            obj.setID_VEHICULOS_ACCIDENTE(id);
            dao.create(conn, obj);
            //verificar existencia
            obj = new VehiculoAccidente();
            obj.setID_VEHICULOS_ACCIDENTE(id);
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (VehiculoAccidente)lista.get(0);
            }
            else {
                obj.setID_VEHICULOS_ACCIDENTE(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_VEHICULOS_ACCIDENTE(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
    
    public ComparendoAccidente crearComparendoAccidente(ComparendoAccidente obj) 
    {
        List lista = null;
        try {
            ComparendoAccidenteDao dao = new ComparendoAccidenteDao();
            conn = conexion.conectarComparendos();
            int id = Funciones.obtenerId(conn, "GEN_COMPARENDOS_ACCIDENTE", "GEN_COMPARENDOS_ACCIDENTE", myMotor);
            obj.setID_COMPARENDOS_ACCIDENTE(id);
            dao.create(conn, obj);
            //verificar existencia
            obj = new ComparendoAccidente();
            obj.setID_COMPARENDOS_ACCIDENTE(id);
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (ComparendoAccidente)lista.get(0);
            }
            else {
                obj.setID_COMPARENDOS_ACCIDENTE(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_COMPARENDOS_ACCIDENTE(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
    
    public Accidente crearAccidente(Accidente obj) {
            List lista = null;
    try {
        AccidenteDao dao = new AccidenteDao();
        conn = conexion.conectarComparendos();
        int id = Funciones.obtenerId(conn, "GEN_ID_ACCIDENTES", "GEN_ID_ACCIDENTES", myMotor);
        obj.setID_ACCIDENTES(id);
        dao.create(conn, obj);
        //verificar existencia
        obj = new Accidente();
        obj.setID_ACCIDENTES(id);
        lista = dao.searchMatching(conn, obj);
        if (lista != null && lista.size() > 0) {
            obj = (Accidente)lista.get(0);
        }
        else {
            obj.setID_ACCIDENTES(-1);
        }
    } catch (Exception e) {
        e.printStackTrace();
        obj.setID_ACCIDENTES(-1);
    } finally {
        conexion.cerrarCx();
    }
    return obj;
    }

    public boolean editarImplicado(Implicado obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
            ImplicadoDao dao = new ImplicadoDao();
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
    
    public boolean editarVehiculoAccidente(VehiculoAccidente obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
            VehiculoAccidenteDao dao = new VehiculoAccidenteDao();
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

    public boolean editarComparendoAccidente(ComparendoAccidente obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
            ComparendoAccidenteDao dao = new ComparendoAccidenteDao();
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
    
    public boolean editarAccidente(Accidente obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
            AccidenteDao dao = new AccidenteDao();
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
    
    public Implicado buscarPrimeroImplicado(Implicado obj) {
        List lista = null;
        try {
            ImplicadoDao dao = new ImplicadoDao();
            conn = conexion.conectarComparendos();
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Implicado)lista.get(0);
            }
            else {
                obj.setID_IMPLICADOS(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_IMPLICADOS(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }
    
    public VehiculoAccidente buscarPrimeroVechiculoAccidente(VehiculoAccidente obj) {
        List lista = null;
        try {
            VehiculoAccidenteDao dao = new VehiculoAccidenteDao();
            conn = conexion.conectarComparendos();
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (VehiculoAccidente)lista.get(0);
            }
            else {
                obj.setID_VEHICULOS_ACCIDENTE(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_VEHICULOS_ACCIDENTE(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }

    public ComparendoAccidente buscarPrimeroComparendoAccidente(ComparendoAccidente obj) {
        List lista = null;
        try {
            ComparendoAccidenteDao dao = new ComparendoAccidenteDao();
            conn = conexion.conectarComparendos();
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (ComparendoAccidente)lista.get(0);
            }
            else {
                obj.setID_COMPARENDOS_ACCIDENTE(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_COMPARENDOS_ACCIDENTE(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }

    public List buscarImplicados(Implicado obj) {
        List lista = null;
        try {
            ImplicadoDao dao = new ImplicadoDao();
            conn = conexion.conectarComparendos();
            obj.setID_IMPLICADOS(obj.getID_IMPLICADOS());
            lista = dao.searchMatching(conn, obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
    public List buscarVechiculosAccidentes(VehiculoAccidente obj) {
        List lista = null;
        try {
            VehiculoAccidenteDao dao = new VehiculoAccidenteDao();
            conn = conexion.conectarComparendos();
            lista = dao.searchMatching(conn, obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
    public List consultarFalloAudiencia(FalloAudiencia obj) {
        List lista = null;
        try {
            FalloAudienciaDao dao = new FalloAudienciaDao();
            conn = conexion.conectarComparendos();
            lista = dao.searchMatching(conn, obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
    public List consultarAccidentesRangoFechas(String fecha1, String fecha2) {
        List lista = null;
        try {
            AccidenteDao dao = new AccidenteDao();
            conn = conexion.conectarComparendos();
            lista = dao.buscarRangoRangoFechas(conn,fecha1, fecha2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
    public List consultarAccidentes(Accidente obj) {
        List lista = null;
        try {
            AccidenteDao dao = new AccidenteDao();
            conn = conexion.conectarComparendos();
            lista = dao.searchMatching(conn, obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
    public List consultarCitasAudiencia(CitasAudiencia obj) {
        List lista = null;
        try {
            CitasAudienciaDao dao = new CitasAudienciaDao();
            conn = conexion.conectarComparendos();
            lista = dao.searchMatching(conn, obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
    public List consultarDeclaracionesAccidente(DeclaracionesAudiencia obj) {
        List lista = null;
        try {
            DeclaracionesAudienciaDao dao = new DeclaracionesAudienciaDao();
            conn = conexion.conectarComparendos();
            lista = dao.searchMatching(conn, obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
    public List buscarComparendosAccidentes(ComparendoAccidente obj) {
        List lista = null;
        try {
            ComparendoAccidenteDao dao = new ComparendoAccidenteDao();
            conn = conexion.conectarComparendos();
            lista = dao.searchMatching(conn, obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
	
    public List listarImplicados() {
        List lista = null;
        try {
            ImplicadoDao dao = new ImplicadoDao();
            conn = conexion.conectarComparendos();
            lista = dao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
    public List listarAccesoriaAccidente(AccesoriaAccidente valueObject) {
        List lista = null;
        try {
            AccesoriaAccidenteDao dao = new AccesoriaAccidenteDao();
            conn = conexion.conectarComparendos();
            lista = dao.loadAll(conn, valueObject);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
    public List listarVechiculosAccidentes() {
        List lista = null;
        try {
            VehiculoAccidenteDao dao = new VehiculoAccidenteDao();
            conn = conexion.conectarComparendos();
            lista = dao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List listarComparendoAccidentes() {
        List lista = null;
        try {
            ComparendoAccidenteDao dao = new ComparendoAccidenteDao();
            conn = conexion.conectarComparendos();
            lista = dao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public boolean eliminarImplicados(Implicado obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
            ImplicadoDao dao = new ImplicadoDao();
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
    
    public boolean eliminarFalloAudiencia(FalloAudiencia obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
            FalloAudienciaDao dao = new FalloAudienciaDao();
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
    
    public boolean eliminarCitasAudiencia(CitasAudiencia obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
            CitasAudienciaDao dao = new CitasAudienciaDao();
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
    
    public boolean eliminarDeclaracionesAudiencia(DeclaracionesAudiencia obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
            DeclaracionesAudienciaDao dao = new DeclaracionesAudienciaDao();
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
    
    public boolean eliminarVehiculoAccidente(VehiculoAccidente obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
            VehiculoAccidenteDao dao = new VehiculoAccidenteDao();
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
    
    public boolean eliminarComparendoAccidente(ComparendoAccidente obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
            ComparendoAccidenteDao dao = new ComparendoAccidenteDao();
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

