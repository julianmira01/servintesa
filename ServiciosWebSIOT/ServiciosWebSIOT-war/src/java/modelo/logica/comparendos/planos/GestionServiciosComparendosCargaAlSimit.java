package modelo.logica.comparendos.planos;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.comparendos.planos.ComparendosCargaAlSimitDao;
import modelo.datos.objetos.comparendos.planos.ComparendosCargaAlSimit;
import modelo.datos.objetos.generales.AuditoriaSystem;

import utilidades.Auditoria;
import utilidades.Funciones;


public class GestionServiciosComparendosCargaAlSimit {
    Conexion conexion;
    Connection conn;
    ComparendosCargaAlSimitDao comparendosCargaAlSimitDao;
    String myMotor;

    public GestionServiciosComparendosCargaAlSimit() {
        super();
        crearObjetos();
    }

    public void crearObjetos() {
        conexion = new Conexion();
        comparendosCargaAlSimitDao = new ComparendosCargaAlSimitDao();
        myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        
    }

    public List getComparendosCargasAlSimit(ComparendosCargaAlSimit comparendosCargaAlSimit) {
        List lista = null;
        try {
            conn = conexion.conectarComparendos();
            lista = comparendosCargaAlSimitDao.searchMatching(conn, comparendosCargaAlSimit);
        } catch (Exception e) {
            lista = null;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public ComparendosCargaAlSimit crearComparendosCargaAlSimit(ComparendosCargaAlSimit comparendosCargaAlSimit,
                                                                int idUsuario, String myIp, String myHost) {
        List lista = null;
        int id = 0;
        try {
            conn = conexion.conectarComparendos();
            id = Funciones.obtenerId(conn, "GEN_COMPARENDOS_CARGAALSIMIT", "GEN_COMPARENDOS_CARGAALSIMIT", myMotor);
            comparendosCargaAlSimit.setID_COMPARENDOCARGA(id);
            comparendosCargaAlSimitDao.create(conn, comparendosCargaAlSimit);
            lista = comparendosCargaAlSimitDao.searchMatching(conn, comparendosCargaAlSimit);
            if (lista != null && lista.size() > 0) {
                comparendosCargaAlSimit = (ComparendosCargaAlSimit)lista.get(0);
            }
            //auditar insert
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("COMPARENDOS_CARGAALSIMIT");
            myAuditSx.setCAMPOCLAVE("ID_COMPARENDOCARGA");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(comparendosCargaAlSimit.getID_COMPARENDOCARGA()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, comparendosCargaAlSimit, 0);

        } catch (Exception e) {
            e.printStackTrace();
            comparendosCargaAlSimit.setID_COMPARENDOCARGA(-1);

        } finally {
            conexion.cerrarCx();
        }
        return comparendosCargaAlSimit;
    }

    public boolean editComparendosCargaAlSimit(ComparendosCargaAlSimit comparendosCargaAlSimit, int idUsuario,
                                               String myIp, String myHost) {
        boolean respuesta = false;
        try {
            conn = conexion.conectarComparendos();
            //auditar edicion
            ComparendosCargaAlSimit ant = new ComparendosCargaAlSimit();
            ant.setID_COMPARENDOCARGA(comparendosCargaAlSimit.getID_COMPARENDOCARGA());
            comparendosCargaAlSimitDao.load(conn, ant);
            comparendosCargaAlSimitDao.save(conn, comparendosCargaAlSimit);
            respuesta = true;
            //auditar edicion
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("COMPARENDOS_CARGAALSIMIT");
            myAuditSx.setCAMPOCLAVE("ID_COMPARENDOCARGA");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(comparendosCargaAlSimit.getID_COMPARENDOCARGA()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEdicion(conn, myAuditSx, ant, comparendosCargaAlSimit, myIp, myHost, 0);

        } catch (Exception e) {
            respuesta = false;
        } finally {
            conexion.cerrarCx();
        }
        return respuesta;
    }

    public List allComparendosCargasAlSimit(ComparendosCargaAlSimit comparendosCargaAlSimit) {
        List lista = null;
        try {
            conn = conexion.conectarComparendos();
            lista = comparendosCargaAlSimitDao.loadAll(conn);
        } catch (Exception e) {
            lista = null;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public Integer getCantidadCompEnviadosPorCarga(ComparendosCargaAlSimit comparendosCargaAlSimit) {
        Integer resultado = 0;
        try {
            conn = conexion.conectarComparendos();
            resultado = comparendosCargaAlSimitDao.getCantidadCompEnviadosPorCarga(conn, comparendosCargaAlSimit);
        } catch (Exception e) {
            resultado = -1;
        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }

    public Integer getCantidadArchivosAprobadosPorCarga(ComparendosCargaAlSimit comparendosCargaAlSimit) {
        Integer resultado = 0;
        try {
            conn = conexion.conectarComparendos();
            resultado = comparendosCargaAlSimitDao.getCantidadArchivosAprobadosPorCarga(conn, comparendosCargaAlSimit);
        } catch (Exception e) {
            resultado = -1;
        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }

    public boolean marcarComparendosQueSiSubieron(ComparendosCargaAlSimit comparendosCargaAlSimit) {
        boolean respuesta = false;
        try {
            conn = conexion.conectarComparendos();
            comparendosCargaAlSimitDao.marcarComparendosQueSiSubieron(conn, comparendosCargaAlSimit);
            respuesta = true;
        } catch (Exception e) {
            respuesta = false;
        } finally {
            conexion.cerrarCx();
        }
        return respuesta;
    }

    public boolean marcarComparendosQueNoSubieron(ComparendosCargaAlSimit comparendosCargaAlSimit) {
        boolean respuesta = false;
        try {
            conn = conexion.conectarComparendos();
            comparendosCargaAlSimitDao.marcarComparendosQueNoSubieron(conn, comparendosCargaAlSimit);
            respuesta = true;
        } catch (Exception e) {
            respuesta = false;
        } finally {
            conexion.cerrarCx();
        }
        return respuesta;
    }

    public boolean clarearComparendosCargados(ComparendosCargaAlSimit comparendosCargaAlSimit, int idUsuario, String myIp, String myHost) {
        boolean respuesta = false;
        try {
            conn = conexion.conectarComparendos();
            //auditar edicion
            ComparendosCargaAlSimit ant = new ComparendosCargaAlSimit();
            ant.setID_PLANOSSIMIT(comparendosCargaAlSimit.getID_PLANOSSIMIT());
            comparendosCargaAlSimitDao.load(conn, ant);
            comparendosCargaAlSimitDao.clarearComparendosCargados(conn, comparendosCargaAlSimit);
            respuesta = true;
            //auditar edicion
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("comparendos_cargaalsimit");
            myAuditSx.setCAMPOCLAVE("id_planossimit");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(comparendosCargaAlSimit.getID_PLANOSSIMIT()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEdicion(conn, myAuditSx, ant, comparendosCargaAlSimit, myIp, myHost, 0);

        } catch (Exception e) {
            respuesta = false;
        } finally {
            conexion.cerrarCx();
        }
        return respuesta;
    }

}
