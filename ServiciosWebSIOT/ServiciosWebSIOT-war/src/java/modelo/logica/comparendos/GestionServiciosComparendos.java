package modelo.logica.comparendos;

import java.sql.Connection;

import java.util.ArrayList;
import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.comparendos.comparenderas.ComparenderasDao;
import modelo.datos.dao.comparendos.comparenderas.DetalleComparenderaDao;
import modelo.datos.dao.comparendos.comparenderas.RangosdeComparendosCompDao;
import modelo.datos.dao.comparendos.comparenderas.ViewComparenderasDao;
import modelo.datos.dao.comparendos.comparenderas.ViewComparendosInfractorDao;
import modelo.datos.dao.comparendos.generales.ComparendoCompDao;
import modelo.datos.dao.comparendos.liquidacion.tarifas.LVigenciasCompDao;
import modelo.datos.objetos.comparendos.comparenderas.Comparenderas;
import modelo.datos.objetos.comparendos.comparenderas.DetalleComparendera;
import modelo.datos.objetos.comparendos.comparenderas.RangosdeComparendosComp;
import modelo.datos.objetos.comparendos.comparenderas.ViewComparenderas;
import modelo.datos.objetos.comparendos.comparenderas.ViewComparendosInfractor;
import modelo.datos.objetos.comparendos.generales.ComparendoComp;
import modelo.datos.objetos.comparendos.liquidacion.tarifas.LVigenciasComp;
import modelo.datos.objetos.generales.AuditoriaSystem;

import utilidades.Auditoria;
import utilidades.Funciones;


public class GestionServiciosComparendos {
    Conexion conexion;
    Connection conn;
    String myMotor;

    public GestionServiciosComparendos() {
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

    public List getLTvigencias(LVigenciasComp lvigenciacomp) {
        List lista = null;
        LVigenciasCompDao myLVigenciasCompDao = new LVigenciasCompDao();
        try {
            conn = conexion.conectarComparendos();
            lista = (ArrayList)myLVigenciasCompDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public LVigenciasComp getLVigenciasId(LVigenciasComp lvigenciacomp) {
        LVigenciasCompDao myLVigenciasCompDao = new LVigenciasCompDao();
        try {
            conn = conexion.conectarComparendos();
            myLVigenciasCompDao.load(conn, lvigenciacomp);
        } catch (Exception e) {
            e.printStackTrace();
            ;
            lvigenciacomp.setLTV_ID(-1);
        } finally {
            conexion.cerrarCx();
        }
        return lvigenciacomp;
    }

    public List getLVigencias(LVigenciasComp lvigenciacomp) {
        List lista;
        lista = null;
        try {
            conn = conexion.conectarComparendos();
            LVigenciasCompDao myLVigenciasCompDao = new LVigenciasCompDao();
            lista = myLVigenciasCompDao.searchMatching(conn, lvigenciacomp);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public boolean crearLVigencias(LVigenciasComp lvigenciacomp) {
        boolean resultado;
        resultado = false;
        LVigenciasCompDao myLVigenciasCompDao = new LVigenciasCompDao();
        int id = 0;

        try {
            conn = conexion.conectarComparendos();
            myMotor = myMotor.toUpperCase();
            id = Funciones.obtenerId(conn, "LT_VIGENCIAS_GEN", "GEN_LT_VIGENCIAS", myMotor);
            lvigenciacomp.setLTV_ID(id);
            myLVigenciasCompDao.create(conn, lvigenciacomp);
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myLVigenciasCompDao = null;
        }
        return resultado;
    }

    public boolean editarLVigencias(LVigenciasComp lvigenciacomp) {
        boolean resultado;
        resultado = false;
        LVigenciasCompDao myLVigenciasCompDao = new LVigenciasCompDao();
        try {
            conn = conexion.conectarComparendos();
            myLVigenciasCompDao.save(conn, lvigenciacomp);
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myLVigenciasCompDao = null;
        }
        return resultado;
    }

    public List getRangosComparendos(RangosdeComparendosComp rangosdecomparendos) {
        List lista;
        lista = null;
        try {
            conn = conexion.conectarComparendos();
            RangosdeComparendosCompDao myRangosdeComparendosCompDao = new RangosdeComparendosCompDao();
            lista = myRangosdeComparendosCompDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getTComparenderas() {
        List lista = null;
        ComparenderasDao myComparenderasDao = new ComparenderasDao();
        try {
            conn = conexion.conectarComparendos();
            lista = myComparenderasDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public Comparenderas getComparenderaPorId(Comparenderas comparenderas) {
        ComparenderasDao myComparenderasDao = new ComparenderasDao();
        try {
            conn = conexion.conectarComparendos();
            myComparenderasDao.load(conn, comparenderas);
        } catch (Exception e) {
            e.printStackTrace();
            ;
            comparenderas.setID(-1);
        } finally {
            conexion.cerrarCx();
        }
        return comparenderas;
    }
    
    public Comparenderas getComparendera(Comparenderas comparenderas) {
        ComparenderasDao myComparenderasDao = new ComparenderasDao();
        List lista = null;
        try {
            conn = conexion.conectarComparendos();
            lista = myComparenderasDao.searchMatching(conn, comparenderas);
            
            if(lista!=null && lista.size()>0)
            {
             comparenderas = (Comparenderas)lista.get(0);
            }
            else
            {
             comparenderas.setID(-1);    
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
            comparenderas.setID(-1);
        } finally {
            conexion.cerrarCx();
        }
        return comparenderas;
    }
    

    public List getSComparenderas(Comparenderas comparenderas) {
        List lista;
        lista = null;
        try {
            conn = conexion.conectarComparendos();
            ComparenderasDao myComparenderasDao = new ComparenderasDao();
            lista = myComparenderasDao.searchMatching(conn, comparenderas);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public Comparenderas crearComparendera(Comparenderas comparenderas, int idUsuario, String myIp, String myHost) {
        Comparenderas lacomparendera = new Comparenderas();
        boolean resultado;
        resultado = false;
        ComparenderasDao myComparenderasDao = new ComparenderasDao();
        int id = 0;
        try {
            conn = conexion.conectarComparendos();
            myMotor = myMotor.toUpperCase();
            id = Funciones.obtenerId(conn, "GEN_COMPARENDERAS", "GEN_COMPARENDERAS", myMotor);
            comparenderas.setID(id);
            myComparenderasDao.create(conn, comparenderas);
            lacomparendera = comparenderas;
            resultado = true;
            //auditar insert
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("COMPARENDERAS");
            myAuditSx.setCAMPOCLAVE("ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(comparenderas.getID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, comparenderas, 0);

        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
            lacomparendera = null;
        } finally {
            conexion.cerrarCx();
            myComparenderasDao = null;
        }
        return lacomparendera;
    }

    public boolean editarComparendera(Comparenderas comparenderas, int idUsuario, String myIp, String myHost) {
        boolean resultado;
        resultado = false;
        ComparenderasDao myComparenderasDao = new ComparenderasDao();
        try {
            conn = conexion.conectarComparendos();
            //auditar edicion
            Comparenderas ant = new Comparenderas();
            ant.setID(comparenderas.getID());
            myComparenderasDao.load(conn, ant);
            myComparenderasDao.save(conn, comparenderas);
            resultado = true;
            //auditar edicion
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("COMPARENDERAS");
            myAuditSx.setCAMPOCLAVE("ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(comparenderas.getID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEdicion(conn, myAuditSx, ant, comparenderas, myIp, myHost, 0);

        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myComparenderasDao = null;
        }
        return resultado;
    }

    public boolean eliminarComparendera(Comparenderas comparenderas, int idUsuario, String myIp, String myHost) {
        boolean resultado;
        resultado = false;
        ComparenderasDao myComparenderasDao = new ComparenderasDao();
        try {
            conn = conexion.conectarComparendos();
            //auditar eliminar
            myComparenderasDao.load(conn, comparenderas);
            myComparenderasDao.delete(conn, comparenderas);
            resultado = true;
            //auditar eliminar
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("COMPARENDERAS");
            myAuditSx.setCAMPOCLAVE("ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(comparenderas.getID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEliminacion(conn, myAuditSx, comparenderas, 0);

        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myComparenderasDao = null;
        }
        return resultado;
    }

    public List getTRangosdeComparendosComp() {
        List lista = null;
        RangosdeComparendosCompDao myRangosdeComparendosCompDao = new RangosdeComparendosCompDao();
        try {
            conn = conexion.conectarComparendos();
            lista = myRangosdeComparendosCompDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public RangosdeComparendosComp getRangosdeComparendosCompPorId(RangosdeComparendosComp rangosdecomparendos) {
        RangosdeComparendosCompDao myRangosdeComparendosCompDao = new RangosdeComparendosCompDao();
        try {
            conn = conexion.conectarComparendos();
            myRangosdeComparendosCompDao.load(conn, rangosdecomparendos);
        } catch (Exception e) {
            e.printStackTrace();
            ;
            rangosdecomparendos.setID_RANGOCOMPARENDO(-1);
        } finally {
            conexion.cerrarCx();
        }
        return rangosdecomparendos;
    }

    public List getSRangosdeComparendosComp(RangosdeComparendosComp rangosdecomparendos) {
        List lista;
        lista = null;
        try {
            conn = conexion.conectarComparendos();
            RangosdeComparendosCompDao myRangosdeComparendosCompDao = new RangosdeComparendosCompDao();
            lista = myRangosdeComparendosCompDao.searchMatching(conn, rangosdecomparendos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public boolean crearRangosdeComparendosComp(RangosdeComparendosComp rangosdecomparendos, int idUsuario,
                                                String myIp, String myHost) {
        boolean resultado;
        resultado = false;
        RangosdeComparendosCompDao myRangosdeComparendosCompDao = new RangosdeComparendosCompDao();
        int id = 0;
        try {
            conn = conexion.conectarComparendos();
            myMotor = myMotor.toUpperCase();
            id = Funciones.obtenerId(conn, "GEN_RANGOSDECOMPARENDOS", "GEN_RANGOSDECOMPARENDOS", myMotor);
            rangosdecomparendos.setID_RANGOCOMPARENDO(id);
            myRangosdeComparendosCompDao.create(conn, rangosdecomparendos);
            resultado = true;
            //auditar insert
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("RANGOSDECOMPARENDOS");
            myAuditSx.setCAMPOCLAVE("ID_RANGOCOMPARENDO");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(rangosdecomparendos.getID_RANGOCOMPARENDO()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, rangosdecomparendos, 0);

        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myRangosdeComparendosCompDao = null;
        }
        return resultado;
    }

    public boolean editarRangosdeComparendosComp(RangosdeComparendosComp rangosdecomparendos, int idUsuario,
                                                 String myIp, String myHost) {
        boolean resultado;
        resultado = false;
        RangosdeComparendosCompDao myRangosdeComparendosCompDao = new RangosdeComparendosCompDao();
        try {
            conn = conexion.conectarComparendos();
            //auditar edicion
            RangosdeComparendosComp ant = new RangosdeComparendosComp();
            ant.setID_RANGOCOMPARENDO(rangosdecomparendos.getID_RANGOCOMPARENDO());
            myRangosdeComparendosCompDao.load(conn, ant);
            myRangosdeComparendosCompDao.save(conn, rangosdecomparendos);
            resultado = true;
            //auditar edicion
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("RANGOSDECOMPARENDOS");
            myAuditSx.setCAMPOCLAVE("ID_RANGOCOMPARENDO");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(rangosdecomparendos.getID_RANGOCOMPARENDO()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEdicion(conn, myAuditSx, ant, rangosdecomparendos, myIp, myHost, 0);

        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myRangosdeComparendosCompDao = null;
        }
        return resultado;
    }

    public boolean eliminarRangosdeComparendosComp(RangosdeComparendosComp rangosdecomparendos, int idUsuario,
                                                   String myIp, String myHost) {
        boolean resultado;
        resultado = false;
        RangosdeComparendosCompDao myRangosdeComparendosCompDao = new RangosdeComparendosCompDao();
        try {
            conn = conexion.conectarComparendos();
            //auditar eliminar
            myRangosdeComparendosCompDao.load(conn, rangosdecomparendos);
            myRangosdeComparendosCompDao.delete(conn, rangosdecomparendos);
            resultado = true;
            //auditar eliminar
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("RANGOSDECOMPARENDOS");
            myAuditSx.setCAMPOCLAVE("ID_RANGOCOMPARENDO");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(rangosdecomparendos.getID_RANGOCOMPARENDO()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEliminacion(conn, myAuditSx, rangosdecomparendos, 0);

        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myRangosdeComparendosCompDao = null;
        }
        return resultado;
    }

    public List getTDetalleComparendera() {
        List lista = null;
        DetalleComparenderaDao myDetalleComparenderaDao = new DetalleComparenderaDao();
        try {
            conn = conexion.conectarComparendos();
            lista = myDetalleComparenderaDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public DetalleComparendera getDetalleComparenderaPorId(DetalleComparendera detallecomparendera) {
        DetalleComparenderaDao myDetalleComparenderaDao = new DetalleComparenderaDao();
        try {
            conn = conexion.conectarComparendos();
            myDetalleComparenderaDao.load(conn, detallecomparendera);
        } catch (Exception e) {
            e.printStackTrace();
            ;
            detallecomparendera.setIDDETCOMPARENDERA(-1);
        } finally {
            conexion.cerrarCx();
        }
        return detallecomparendera;
    }

    public List getSDetalleComparendera(DetalleComparendera detallecomparendera) {
        List lista;
        lista = null;
        try {
            conn = conexion.conectarComparendos();
            DetalleComparenderaDao myDetalleComparenderaDao = new DetalleComparenderaDao();
            lista = myDetalleComparenderaDao.searchMatching(conn, detallecomparendera);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public boolean crearDetalleComparendera(DetalleComparendera detallecomparendera, int idUsuario, String myIp,
                                            String myHost) {
        boolean resultado;
        resultado = false;
        DetalleComparenderaDao myDetalleComparenderaDao = new DetalleComparenderaDao();
        int id = 0;
        try {
            conn = conexion.conectarComparendos();
            myMotor = myMotor.toUpperCase();
            id = Funciones.obtenerId(conn, "GEN_DETALLECOMPARENDERA", "GEN_DETALLECOMPARENDERA", myMotor);
            detallecomparendera.setIDDETCOMPARENDERA(id);
            myDetalleComparenderaDao.create(conn, detallecomparendera);
            resultado = true;
            //auditar insert
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("DETALLECOMPARENDERA");
            myAuditSx.setCAMPOCLAVE("IDDETCOMPARENDERA");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(detallecomparendera.getIDDETCOMPARENDERA()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, detallecomparendera, 0);

        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myDetalleComparenderaDao = null;
        }
        return resultado;
    }

    public boolean editarDetalleComparendera(DetalleComparendera detallecomparendera, int idUsuario, String myIp,
                                             String myHost) {
        boolean resultado;
        resultado = false;
        DetalleComparenderaDao myDetalleComparenderaDao = new DetalleComparenderaDao();
        Funciones funciones = new Funciones();
        try {
            conn = conexion.conectarComparendos();
            //auditar edicion
            DetalleComparendera ant = new DetalleComparendera();
            ant.setIDDETCOMPARENDERA(detallecomparendera.getIDDETCOMPARENDERA());
            myDetalleComparenderaDao.load(conn, ant);
            myDetalleComparenderaDao.save(conn, detallecomparendera);
            resultado = true;
            //auditar edicion
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("DETALLECOMPARENDERA");
            myAuditSx.setCAMPOCLAVE("IDDETCOMPARENDERA");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(detallecomparendera.getIDDETCOMPARENDERA()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEdicion(conn, myAuditSx, ant, detallecomparendera, myIp, myHost, 0);

        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myDetalleComparenderaDao = null;
        }
        return resultado;
    }

    public DetalleComparendera getOneDetalleComparendera(DetalleComparendera detalle) {
        List lista = null;
        DetalleComparenderaDao myDetalleComparenderaDao = new DetalleComparenderaDao();
        Funciones funciones = new Funciones();
        try {
            conn = conexion.conectarComparendos();
            lista = myDetalleComparenderaDao.searchMatching(conn, detalle);
            if (lista != null && lista.size() > 0)
                detalle = (DetalleComparendera)lista.get(0);
            else
                detalle = null;
        } catch (Exception e) {
            e.printStackTrace();
            lista = null;
            detalle = null;
        } finally {
            conexion.cerrarCx();
        }
        return detalle;
    }

    public void actualizarEstadoComparendo(String nrocom, String estado, int idUsuario, String myIp, String myHost) {
        DetalleComparendera tmp = new DetalleComparendera();
        tmp.setNROCOMPARENDO(nrocom);
        tmp = getOneDetalleComparendera(tmp);
        if (tmp != null) {
            tmp.setESTADOCOMP(estado);
            editarDetalleComparendera(tmp, idUsuario, myIp, myHost);
        }
    }

    public boolean comparendoDisponioble(String nrocom) {
        boolean resultado = false;
        DetalleComparendera tmp = new DetalleComparendera();
        tmp.setNROCOMPARENDO(nrocom);
        tmp = getOneDetalleComparendera(tmp);
        System.out.println(1);
        if (tmp == null) {
            resultado = false;
        } else {
            if (tmp.getESTADOCOMP().equals("T"))
                resultado = false;
            else
                resultado = true;
        }
        return resultado;
    }
    
    public int getConsecutivoInmovilizacion() {
        int maxConsecutivo = 0;        
        ComparendoCompDao comparendoDao = new ComparendoCompDao();
        try {
            conn = conexion.conectarComparendos();
            maxConsecutivo = comparendoDao.getMaxConsecutivoInmovilizacion(conn);            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return maxConsecutivo;
    }
    
    public boolean tieneComparendosActivos(String identificacion) {
        boolean resultado = false;
        ComparendoCompDao comparendoDao = new ComparendoCompDao();
        try {
            conn = conexion.conectarComparendos();
            resultado = comparendoDao.tieneComparendosActivos(conn, identificacion);
        } catch (Exception e) {
            resultado = false;
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }


    
    

    public boolean anularComparendo(DetalleComparendera detallecomparendera, int idUsuario, String myIp,
                                    String myHost) {
        boolean resultado;
        resultado = false;
        DetalleComparenderaDao myDetalleComparenderaDao = new DetalleComparenderaDao();
        Funciones funciones = new Funciones();
        try {
            conn = conexion.conectarComparendos();
            //auditar edicion
            DetalleComparendera ant = new DetalleComparendera();
            ant.setIDDETCOMPARENDERA(detallecomparendera.getIDDETCOMPARENDERA());
            myDetalleComparenderaDao.load(conn, ant);
            String fec = funciones.getFechaSistema(conn,myMotor);
            String hor = funciones.getHoraSistemaString(conn);
            detallecomparendera.setFECHAANULACION(fec);
            detallecomparendera.setHORAANULACION(hor);
            myDetalleComparenderaDao.save(conn, detallecomparendera);
            resultado = true;
            //auditar edicion
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("DETALLECOMPARENDERA");
            myAuditSx.setCAMPOCLAVE("IDDETCOMPARENDERA");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(detallecomparendera.getIDDETCOMPARENDERA()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEdicion(conn, myAuditSx, ant, detallecomparendera, myIp, myHost, 0);

        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myDetalleComparenderaDao = null;
        }
        return resultado;
    }

    public boolean eliminarDetalleComparendera(DetalleComparendera detallecomparendera, int idUsuario, String myIp,
                                               String myHost) {
        boolean resultado;
        resultado = false;
        DetalleComparenderaDao myDetalleComparenderaDao = new DetalleComparenderaDao();
        try {
            conn = conexion.conectarComparendos();
            //auditar eliminar
            myDetalleComparenderaDao.load(conn, detallecomparendera);
            myDetalleComparenderaDao.delete(conn, detallecomparendera);
            resultado = true;
            //auditar eliminar
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("DETALLECOMPARENDERA");
            myAuditSx.setCAMPOCLAVE("IDDETCOMPARENDERA");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(detallecomparendera.getIDDETCOMPARENDERA()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEliminacion(conn, myAuditSx, detallecomparendera, 0);

        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myDetalleComparenderaDao = null;
        }
        return resultado;
    }

    public List getTViewComparenderas() {
        List lista = null;
        ViewComparenderasDao myViewComparenderasDao = new ViewComparenderasDao();
        try {
            conn = conexion.conectarComparendos();
            lista = myViewComparenderasDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getSViewComparenderas(ViewComparenderas viewcomparendera) {
        List lista;
        lista = null;
        try {
            conn = conexion.conectarComparendos();
            ViewComparenderasDao myViewComparenderasDao = new ViewComparenderasDao();
            lista = myViewComparenderasDao.searchMatching(conn, viewcomparendera);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getSViewComparendosInfractor(ViewComparendosInfractor viewcomparendosinfractor) {
        List lista;
        lista = null;
        try {
            conn = conexion.conectarComparendos();
            ViewComparendosInfractorDao myViewComparendosInfractorDao = new ViewComparendosInfractorDao();
            lista = myViewComparendosInfractorDao.searchMatching(conn, viewcomparendosinfractor);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
    
    
    
}
