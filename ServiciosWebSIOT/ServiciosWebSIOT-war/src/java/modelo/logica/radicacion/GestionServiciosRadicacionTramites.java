package modelo.logica.radicacion;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.generales.propietarioDeVehiculo.ViewPropietariosDao;
import modelo.datos.dao.generales.vehiculo.VehiculoDao;
import modelo.datos.dao.liquidacion.FacturaDao;
import modelo.datos.dao.liquidacion.ViewDetFacturaDao;
import modelo.datos.dao.liquidacion.ViewDetalleFacturaDao;
import modelo.datos.dao.radicacion.CitaDao;
import modelo.datos.dao.radicacion.DetCitaDao;
import modelo.datos.dao.radicacion.RadRequisitoGralDao;
import modelo.datos.dao.radicacion.RadTramitesRevisadosDao;
import modelo.datos.dao.radicacion.RadicadoDeVehiculosDao;
import modelo.datos.dao.radicacion.RuntTipoEntregaSolDao;
import modelo.datos.dao.radicacion.TramiteDependenciaDao;
import modelo.datos.dao.radicacion.TramitesPorDependenciaDao;
import modelo.datos.dao.radicacion.TramitesVehiculosRadicadosDao;
import modelo.datos.dao.rangos.DetPlacaGeneradaDao;
import modelo.datos.objetos.generales.AuditoriaSystem;
import modelo.datos.objetos.generales.Auditoriatramite;
import modelo.datos.objetos.generales.Persona;
import modelo.datos.objetos.generales.Usuarios;
import modelo.datos.objetos.generales.propietarioDeVehiculo.ViewPropietarios;
import modelo.datos.objetos.generales.vehiculo.Vehiculo;
import modelo.datos.objetos.generales.vistas.DetalleprocersarView;
import modelo.datos.objetos.liquidacion.Factura;
import modelo.datos.objetos.liquidacion.ViewDetFactura;
import modelo.datos.objetos.liquidacion.ViewDetalleFactura;
import modelo.datos.objetos.radicacion.Cita;
import modelo.datos.objetos.radicacion.DetCita;
import modelo.datos.objetos.radicacion.RadRequisitoGral;
import modelo.datos.objetos.radicacion.RadTramitesRevisados;
import modelo.datos.objetos.radicacion.RadicadoDeVehiculos;
import modelo.datos.objetos.radicacion.RuntTipoEntregaSol;
import modelo.datos.objetos.radicacion.TramiteDependencia;
import modelo.datos.objetos.radicacion.TramitesPorDependencia;
import modelo.datos.objetos.radicacion.TramitesVehiculosRadicados;
import modelo.datos.objetos.rangos.DetPlacaGenerada;
import modelo.datos.objetos.generales.Transito;

import modelo.logica.generales.GestionAuditoriaTramite;
import modelo.logica.generales.GestionViewGeneralesLocal;
import modelo.logica.generales.vehiculo.GestionServiciosVehiculosLocal;
import modelo.logica.usuarios.GestionServiciosUsuarios;
import modelo.logica.generales.GestionServiciosTransitoLocal;

import servicios.generales.ServiciosPersonas;

import utilidades.Auditoria;
import utilidades.Funciones;


public class GestionServiciosRadicacionTramites {
    //VehiculoDao vehiculoDao;
    Conexion conexion;
    Connection conn;
    String myMotor;

    public GestionServiciosRadicacionTramites() {
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
        //vehiculoDao=new VehiculoDao();
        //crearObjetos();
    }

    public List getFacturas(Factura myFactura) {
        List mylista;
        mylista = null;
        try {
            conn = conexion.conectar();
            FacturaDao myFacturaDao = new FacturaDao();
            mylista = myFacturaDao.searchMatching(conn, myFactura);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return mylista;
    }

    public boolean validarFactura(RadicadoDeVehiculos myRadicado) {
        boolean retorno = false;
        List mylista;
        mylista = null;
        try {
            conn = conexion.conectar();
            RadicadoDeVehiculosDao myRadicadoDao = new RadicadoDeVehiculosDao();
            mylista = myRadicadoDao.searchMatching(conn, myRadicado);
            if (mylista != null && mylista.size() > 0) {
                retorno = false;
            } else
                retorno = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return retorno;
    }


    public List getRadicadoDeVehiculos(RadicadoDeVehiculos myRadicado) {
        List mylista;
        mylista = null;
        try {
            conn = conexion.conectar();
            RadicadoDeVehiculosDao myRadicadoDao = new RadicadoDeVehiculosDao();
            mylista = myRadicadoDao.searchMatching(conn, myRadicado);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return mylista;
    }

    public List getTramiteVehiculoRadicado(TramitesVehiculosRadicados myTramVehiRad) {
        List mylista;
        mylista = null;
        try {
            conn = conexion.conectar();
            TramitesVehiculosRadicadosDao myTramVehiRadDao = new TramitesVehiculosRadicadosDao();
            mylista = myTramVehiRadDao.searchMatching(conn, myTramVehiRad);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return mylista;
    }

    public List getTramitePorDependencia(TramitesPorDependencia myTraPorDep, int modulo) {
        List mylista;
        mylista = null;
        try {
            if (modulo == 0)
                conn = conexion.conectar();
            else
                conn = conexion.conectarComparendos();
            TramitesPorDependenciaDao myTramPorDepDao = new TramitesPorDependenciaDao();
            mylista = myTramPorDepDao.searchMatching(conn, myTraPorDep);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return mylista;
    }

    public boolean saveIdCitaRadicado(RadicadoDeVehiculos myRadicado) {
        boolean resultado = false;

        try {
            conn = conexion.conectar();
            RadicadoDeVehiculosDao myRadicadoDao = new RadicadoDeVehiculosDao();
            myRadicadoDao.saveIdCita(conn, myRadicado);
            resultado = true;

        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }


    public RadicadoDeVehiculos insertarRadicadoDeVehiculos(RadicadoDeVehiculos myRadicado, int idUsuario, String myIp,
                                                           String myHost) {
        GestionServiciosTransitoLocal gestiontransito = new GestionServiciosTransitoLocal();
        Transito mytransito = gestiontransito.getTransito();
                
                
        int id;
        int num;
        List lista;
        //String numRad = "RA";
        String numRad = mytransito.getPREFIJORADICACION();
        //Al unir se debe llamar al obtener prefijo de Radicacion
        //Campos para la auditoria
        Auditoria myAuditoria;
        AuditoriaSystem myAuditSx;
        //--Campos para la auditoria
        try {
            conn = conexion.conectar();
            RadicadoDeVehiculosDao myRadicadoDao = new RadicadoDeVehiculosDao();
            id =
 Funciones.obtenerId(conn, "GEN_RADICADOVEHICULO", "GEN_RADICADOVEHICULO", myMotor); //obtiene el consecutivo del id
            myRadicado.setID_RADICADOVEH(id);
            //num = myRadicadoDao.getNumRadicado(conn, myMotor); //obtiene el consecutivo del numrad
            num = Funciones.obtenerId(conn, "GEN_RADICADOVEHICULO", "GEN_RADICADOVEHICULO", myMotor);
            
            numRad = numRad + String.valueOf(num); //concatena para completar el numRAD
            myRadicado.setNUMRADICACION(numRad);
            myRadicado.setFECHA_EXP(Funciones.getFechaSistema(conn,myMotor)); //Fija la fecha del sx
            myRadicado.setHORARECEPCION(Funciones.getHoraSistemaString(conn)); //Fija la hora del Sx
            myRadicado.setTIPORADICACION("V");
            myRadicadoDao.create(conn, myRadicado);
            //Pasos para la auditoria
            myAuditoria = new Auditoria();
            myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("RADICADODEVEHICULOS");
            myAuditSx.setCAMPOCLAVE("ID_RADICADOVEH");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(id));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, myRadicado, 0);
            //-- para la auditoria
            myRadicado = new RadicadoDeVehiculos();
            myRadicado.setID_RADICADOVEH(id);
            lista = myRadicadoDao.searchMatching(conn, myRadicado);
            if (lista != null && lista.size() > 0) {
                myRadicado = (RadicadoDeVehiculos)lista.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return myRadicado;
    }

    public TramitesVehiculosRadicados insertarTramiteVehiculoRadicado(TramitesVehiculosRadicados myTramVehi) {
        int id;
        int num;
        List lista;
        String numRad = "RA"; //Al unir se debe llamar al obtener prefijo de Radicacion
        try {
            conn = conexion.conectar();
            TramitesVehiculosRadicadosDao myTramVehiDao = new TramitesVehiculosRadicadosDao();
            id = Funciones.obtenerId(conn, "GEN_TRAMVEHICULORADICADO", "GEN_TRAMVEHICULORADICADO", myMotor);
            myTramVehi.setID_TRAMVEHRADICADO(id);
            myTramVehiDao.create(conn, myTramVehi);
            myTramVehi = new TramitesVehiculosRadicados();
            myTramVehi.setID_TRAMVEHRADICADO(id);
            lista = myTramVehiDao.searchMatching(conn, myTramVehi);
            if (lista != null && lista.size() > 0) {
                myTramVehi = (TramitesVehiculosRadicados)lista.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return myTramVehi;
    }

    public RadRequisitoGral insertarRadRequisitoGral(RadRequisitoGral myRadReqGral) {
        int id;
        int num;
        List lista;
        String numRad = "RA"; //Al unir se debe llamar al obtener prefijo de Radicacion
        try {
            conn = conexion.conectar();
            RadRequisitoGralDao myRadReqGralDao = new RadRequisitoGralDao();
            id = Funciones.obtenerId(conn, "GEN_RADREQUISITOGRAL", "GEN_RADREQUISITOGRAL", myMotor);
            myRadReqGral.setID_RADREQGENERAL(id);
            myRadReqGralDao.create(conn, myRadReqGral);
            myRadReqGral = new RadRequisitoGral();
            myRadReqGral.setID_RADREQGENERAL(id);
            lista = myRadReqGralDao.searchMatching(conn, myRadReqGral);
            if (lista != null && lista.size() > 0) {
                myRadReqGral = (RadRequisitoGral)lista.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return myRadReqGral;
    }

    public List getRadRequisitoGral(RadRequisitoGral myRadReqGral) {
        List mylista;
        mylista = null;
        try {
            conn = conexion.conectar();
            RadRequisitoGralDao myRadReqGralDao = new RadRequisitoGralDao();
            mylista = myRadReqGralDao.searchMatching(conn, myRadReqGral);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return mylista;
    }

    public RadRequisitoGral cambiarEstadoRadRequisitoGral(RadRequisitoGral myRadReqGral, int idUsuario, String myIp,
                                                          String myHost) {
        int id;
        List lista;
        try {
            conn = conexion.conectar();
            RadRequisitoGralDao myRadReqGralDao = new RadRequisitoGralDao();
            //auditar edicion
            RadRequisitoGral ant = new RadRequisitoGral();
            ant.setID_RADREQGENERAL(myRadReqGral.getID_RADREQGENERAL());
            myRadReqGralDao.load(conn, ant);
            id = myRadReqGral.getID_RADREQGENERAL();
            myRadReqGralDao.cambiarEstado(conn, myRadReqGral);
            myRadReqGral = new RadRequisitoGral();
            myRadReqGral.setID_RADREQGENERAL(id);
            lista = myRadReqGralDao.searchMatching(conn, myRadReqGral);
            if (lista != null && lista.size() > 0) {
                myRadReqGral = (RadRequisitoGral)lista.get(0);
            }
            //auditar edicion
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("RADREQUISITOGRAL");
            myAuditSx.setCAMPOCLAVE("ID_RADREQGENERAL");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(myRadReqGral.getID_RADREQGENERAL()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEdicion(conn, myAuditSx, ant, myRadReqGral, myIp, myHost, 0);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return myRadReqGral;
    }

    public RadRequisitoGral cambiarObservacionRadRequisitoGral(RadRequisitoGral myRadReqGral) {
        int id;
        List lista;
        try {
            conn = conexion.conectar();
            RadRequisitoGralDao myRadReqGralDao = new RadRequisitoGralDao();
            id = myRadReqGral.getID_RADREQGENERAL();
            myRadReqGralDao.cambiarObservacion(conn, myRadReqGral);
            myRadReqGral = new RadRequisitoGral();
            myRadReqGral.setID_RADREQGENERAL(id);
            lista = myRadReqGralDao.searchMatching(conn, myRadReqGral);
            if (lista != null && lista.size() > 0) {
                myRadReqGral = (RadRequisitoGral)lista.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return myRadReqGral;
    }

    public RadTramitesRevisados cambiarEstadoRadTramitesRev(RadTramitesRevisados myRadTramRev) {
        int id;
        List lista;
        try {
            conn = conexion.conectar();
            RadTramitesRevisadosDao myRadTramRevDao = new RadTramitesRevisadosDao();
            id = myRadTramRev.getID_RADTRAMREVISADO();
            myRadTramRevDao.cambiarEstado(conn, myRadTramRev);
            myRadTramRev = new RadTramitesRevisados();
            myRadTramRev.setID_RADTRAMREVISADO(id);
            lista = myRadTramRevDao.searchMatching(conn, myRadTramRev);
            if (lista != null && lista.size() > 0) {
                myRadTramRev = (RadTramitesRevisados)lista.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return myRadTramRev;
    }

    public RadTramitesRevisados cambiarObservacionRadTramitesRev(RadTramitesRevisados myRadTramRev) {
        int id;
        List lista;
        try {
            conn = conexion.conectar();
            RadTramitesRevisadosDao myRadTramRevDao = new RadTramitesRevisadosDao();
            id = myRadTramRev.getID_RADTRAMREVISADO();
            myRadTramRevDao.cambiarObservacion(conn, myRadTramRev);
            myRadTramRev = new RadTramitesRevisados();
            myRadTramRev.setID_RADTRAMREVISADO(id);
            lista = myRadTramRevDao.searchMatching(conn, myRadTramRev);
            if (lista != null && lista.size() > 0) {
                myRadTramRev = (RadTramitesRevisados)lista.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return myRadTramRev;
    }

    public TramiteDependencia insertarTramiteDependencia(TramiteDependencia myTramPorDep, int modulo) {
        TramiteDependencia myTemp;
        myTemp = new TramiteDependencia();
        int id;
        int num;
        List lista;
        String numRad = "RA"; //Al unir se debe llamar al obtener prefijo de Radicacion
        try {
            if (modulo == 0)
                conn = conexion.conectar();
            else
                conn = conexion.conectarComparendos();
            TramiteDependenciaDao myTramPorDepDao = new TramiteDependenciaDao();
            myTemp.setID_TRAMITEINTERNO(myTramPorDep.getID_TRAMITEINTERNO());
            myTemp.setID_DEPENDENCIA(myTramPorDep.getID_DEPENDENCIA());
            lista = myTramPorDepDao.searchMatching(conn, myTemp);
            if (lista == null || lista.size() == 0) {
                id = Funciones.obtenerId(conn, "GEN_TRAMITEDEPENDENCIA", "GEN_TRAMITEDEPENDENCIA", myMotor);
                myTramPorDep.setID_TRAMITEDEPEN(id);
                myTramPorDepDao.create(conn, myTramPorDep);
                myTramPorDep = new TramiteDependencia();
                myTramPorDep.setID_TRAMITEDEPEN(id);
                lista = myTramPorDepDao.searchMatching(conn, myTramPorDep);
                if (lista != null && lista.size() > 0) {
                    myTramPorDep = (TramiteDependencia)lista.get(0);
                } else
                    return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return myTramPorDep;
    }

    public void eliminarTramiteDependencia(TramiteDependencia myTramDep, int modulo) {
        try {
            if (modulo == 0)
                conn = conexion.conectar();
            else
                conn = conexion.conectarComparendos();
            TramiteDependenciaDao myTramPorDepDao = new TramiteDependenciaDao();
            myTramPorDepDao.delete(conn, myTramDep);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
    }

    public RadicadoDeVehiculos anularRadicadoDeVehiculos(RadicadoDeVehiculos myRadicado, int idUsuario, String myIp,
                                                         String myHost) {
        List lista;
        //Campos para la auditoria
        Auditoria myAuditoria;
        AuditoriaSystem myAuditSx;
        //--Campos para la auditoria
        try {
            conn = conexion.conectar();
            RadicadoDeVehiculosDao myRadicadoDao = new RadicadoDeVehiculosDao();
            myRadicado.setFECHAANULA(Funciones.getFechaSistema(conn,myMotor)); //Fija la fecha del sx
            myRadicado.setHORAANULA(Funciones.getHoraSistemaString(conn)); //Fija la hora del Sx
            myRadicado.setESTADO("AN"); //Pone el estado anulado
            myRadicadoDao.anular(conn, myRadicado);
            //Pasos para la auditoria
            myAuditoria = new Auditoria();
            myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("RADICADODEVEHICULOS");
            myAuditSx.setCAMPOCLAVE("ID_RADICADOVEH");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(myRadicado.getID_RADICADOVEH()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditSx.setDESCRIPOPERACION("Anulacion de Radicado");
            myAuditSx.setTIPOPERACION("E");
            myAuditoria.auditarOtraOp(conn, myAuditSx, 0);
            //-- para la auditoria
            lista = myRadicadoDao.searchMatching(conn, myRadicado);
            if (lista != null && lista.size() > 0) {
                myRadicado = (RadicadoDeVehiculos)lista.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return myRadicado;
    }

    public RadicadoDeVehiculos aprobarRadicadoDeVehiculos(RadicadoDeVehiculos myRadicado, int idUsuario, String myIp,
                                                          String myHost) {
        List lista;
        //Campos para la auditoria
        Auditoria myAuditoria;
        AuditoriaSystem myAuditSx;
        //--Campos para la auditoria
        try {
            conn = conexion.conectar();
            RadicadoDeVehiculosDao myRadicadoDao = new RadicadoDeVehiculosDao();
            myRadicado.setFECHAREVISA(Funciones.getFechaSistema(conn,myMotor)); //Fija la fecha del sx
            myRadicado.setHORAREVISA(Funciones.getHoraSistemaString(conn)); //Fija la hora del Sx
            myRadicado.setESTADO("AP"); //Pone el estado aprobado
            myRadicadoDao.aprobar(conn, myRadicado);
            //Pasos para la auditoria
            myAuditoria = new Auditoria();
            myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("RADICADODEVEHICULOS");
            myAuditSx.setCAMPOCLAVE("ID_RADICADOVEH");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(myRadicado.getID_RADICADOVEH()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditSx.setDESCRIPOPERACION("Aprobacion de Radicado");
            myAuditSx.setTIPOPERACION("E");
            myAuditoria.auditarOtraOp(conn, myAuditSx, 0);
            //-- para la auditoria
            lista = myRadicadoDao.searchMatching(conn, myRadicado);
            if (lista != null && lista.size() > 0) {
                myRadicado = (RadicadoDeVehiculos)lista.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return myRadicado;
    }

    public RadicadoDeVehiculos terminarRadicadoDeVehiculos(RadicadoDeVehiculos myRadicado, int idUsuario, String myIp,
                                                           String myHost) {
        List lista;
        //Campos para la auditoria
        Auditoria myAuditoria;
        AuditoriaSystem myAuditSx;
        //--Campos para la auditori
        try {
            conn = conexion.conectar();
            RadicadoDeVehiculosDao myRadicadoDao = new RadicadoDeVehiculosDao();
            myRadicado.setFECHATERMINACION(Funciones.getFechaSistema(conn,myMotor)); //Fija la fecha del sx
            myRadicado.setHORATERMINACION(Funciones.getHoraSistemaString(conn)); //Fija la hora del Sx
            myRadicado.setESTADO("TER"); //Pone el estado terminado
            myRadicadoDao.terminar(conn, myRadicado);
            //Pasos para la auditoria
            myAuditoria = new Auditoria();
            myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("RADICADODEVEHICULOS");
            myAuditSx.setCAMPOCLAVE("ID_RADICADOVEH");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(myRadicado.getID_RADICADOVEH()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditSx.setDESCRIPOPERACION("Terminacion de Radicado");
            myAuditSx.setTIPOPERACION("E");
            myAuditoria.auditarOtraOp(conn, myAuditSx, 0);
            //-- para la auditoria
            lista = myRadicadoDao.searchMatching(conn, myRadicado);
            if (lista != null && lista.size() > 0) {
                myRadicado = (RadicadoDeVehiculos)lista.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return myRadicado;
    }

    public RadicadoDeVehiculos fijarCitaRadicadoDeVehiculos(RadicadoDeVehiculos myRadicado) {
        List lista;
        try {
            conn = conexion.conectar();
            RadicadoDeVehiculosDao myRadicadoDao = new RadicadoDeVehiculosDao();
            myRadicadoDao.ponerCita(conn, myRadicado);
            lista = myRadicadoDao.searchMatching(conn, myRadicado);
            if (lista != null && lista.size() > 0) {
                myRadicado = (RadicadoDeVehiculos)lista.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return myRadicado;
    }

    public void pruebaInsersionRadicado() {
        int id;
        RadicadoDeVehiculos myRadicado;
        myRadicado = new RadicadoDeVehiculos();
        java.util.Date fecha = new java.util.Date();
        myRadicado.setHORARECEPCION("08:10:35");
        myRadicado.setESTADO("RA");
        myRadicado.setID_VEHICULO(24768);
        myRadicado.setID_USUARIO(215);
        myRadicado.setID_PERSONA(111472);
        myRadicado.setID_FACTURA(132455);
        myRadicado.setID_CITA(1);
        try {
            conn = conexion.conectar();
            myRadicado.setFECHA_EXP(Funciones.getFechaSistema(conn,myMotor));
            myRadicado.setFECHAANULA(Funciones.getFechaSistema(conn,myMotor));
            RadicadoDeVehiculosDao myRadicadoDao = new RadicadoDeVehiculosDao();
            id = Funciones.obtenerId(conn, "GEN_RADICADOVEHICULO", "GEN_RADICADOVEHICULO", myMotor);
            myRadicado.setID_RADICADOVEH(id);
            myRadicadoDao.create(conn, myRadicado);
            System.out.println("Insertado");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
    }

    public String getFecha() {
        Funciones myfuncion = new Funciones();
        String myMotor;
        myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        return myfuncion.getFechaSistema(null,myMotor);
    }

    public Cita insertarCita(Cita myCita, int idUsuario, String myIp, String myHost, int modulo) {
        int id;
        int num;
        List lista;
        //Campos para la auditoria
        Auditoria myAuditoria;
        AuditoriaSystem myAuditSx;
        //--Campos para la auditoria
        try {
            if (modulo == 0)
                conn = conexion.conectar();
            else
                conn = conexion.conectarComparendos();
            CitaDao myCitaDao = new CitaDao();
            id = Funciones.obtenerId(conn, "GEN_CITA", "GEN_CITA", myMotor);
            myCita.setID_CITA(id);
            myCita.setFECHAREG(Funciones.getFechaSistema(conn,myMotor));
            myCita.setFECHACITA(Funciones.getFechaSistema(conn,myMotor));
            myCita.setHORAREG(Funciones.getHoraSistemaString(conn));
            myCita.setNUMEROCITA(myCitaDao.obtenerNumeroCita(conn, myCita));
            System.out.println("Fecha Numero " + myCita.getNUMEROCITA());
            myCitaDao.create(conn, myCita);
            //Pasos para la auditoria
            myAuditoria = new Auditoria();
            myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("CITA");
            myAuditSx.setCAMPOCLAVE("ID_CITA");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(id));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, myCita, 0);
            //-- para la auditoria
            myCita = new Cita();
            myCita.setID_CITA(id);
            lista = myCitaDao.searchMatching(conn, myCita);
            if (lista != null && lista.size() > 0) {
                myCita = (Cita)lista.get(0);
                System.out.println("Fecha Inscripcion " + myCita.getFECHAREG());
                System.out.println("Fecha Cita " + myCita.getFECHACITA());
            } else
                return null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return myCita;
    }


    public Cita reasignarCita(Cita myCita, int idUsuario, String myIp, String myHost, int modulo) {
        int id;
        List lista;
        //Campos para la auditoria
        Auditoria myAuditoria;
        AuditoriaSystem myAuditSx;
        //--Campos para la auditoria
        try {
            if (modulo == 0)
                conn = conexion.conectar();
            else
                conn = conexion.conectarComparendos();
            CitaDao myCitaDao = new CitaDao();
            myCita.setFECHATRASLADA(Funciones.getFechaSistema(conn,myMotor));
            myCita.setESTADO("REASIGNADA");
            myCitaDao.reasignarCita(conn, myCita);
            //Pasos para la auditoria
            myAuditoria = new Auditoria();
            myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("CITA");
            myAuditSx.setCAMPOCLAVE("ID_CITA");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(myCita.getID_CITA()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditSx.setDESCRIPOPERACION("Reasignacion de Cita");
            myAuditSx.setTIPOPERACION("E");
            myAuditoria.auditarOtraOp(conn, myAuditSx, 0);
            //-- para la auditoria
            id = myCita.getID_CITA();
            myCita = new Cita();
            myCita.setID_CITA(id);
            lista = myCitaDao.searchMatching(conn, myCita);
            if (lista != null && lista.size() > 0) {
                myCita = (Cita)lista.get(0);
            } else
                return null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return myCita;
    }

    public Cita atenderCita(Cita myCita, String parametrosObservaciones, int idUsuario, String myIp, String myHost, int modulo) {
        int id;
        List lista;
        //Campos para la auditoria
        Auditoria myAuditoria;
        AuditoriaSystem myAuditSx;
        //--Campos para la auditoria
        try {
            if (modulo == 0)
                conn = conexion.conectar();
            else
                conn = conexion.conectarComparendos();
            CitaDao myCitaDao = new CitaDao();
            if (myCita.getID_CITA() != 0) {

                myCita.setESTADO("ATENCION");
                myCita.setFECHAREG(Funciones.getFechaSistema(conn,myMotor));
                myCitaDao.save(conn, myCita);


                //Pasos para la auditoria
                myAuditoria = new Auditoria();
                myAuditSx = new AuditoriaSystem();
                myAuditSx.setTABLAAFECTADA("CITA");
                myAuditSx.setCAMPOCLAVE("ID_CITA");
                myAuditSx.setVLRCAMPOCLAVE(String.valueOf(myCita.getID_CITA()));
                myAuditSx.setID_USUARIO(idUsuario);
                myAuditSx.setIP(myIp);
                myAuditSx.setNOMBREEQUIPO(myHost);
                myAuditSx.setDESCRIPOPERACION("INICIA ATENCION DE CITA");
                myAuditSx.setTIPOPERACION("E");
                myAuditoria.auditarOtraOp(conn, myAuditSx, 0);
                //-- para la auditoria
                id = myCita.getID_CITA();
                myCita = new Cita();
                myCita.setID_CITA(id);
                lista = myCitaDao.searchMatching(conn, myCita);
                if (lista != null && lista.size() > 0) {
                    myCita = (Cita)lista.get(0);
                } else
                    return null;

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return myCita;
    }
    
    public Cita terminarCita(Cita myCita, int idUsuario, String myIp, String myHost, int modulo) {
        int id;
        List lista;
        //Campos para la auditoria
        Auditoria myAuditoria;
        AuditoriaSystem myAuditSx;
        //--Campos para la auditoria
        try {
            if (modulo == 0)
                conn = conexion.conectar();
            else
                conn = conexion.conectarComparendos();
            CitaDao myCitaDao = new CitaDao();
            if (myCita.getID_CITA() != 0) {

                myCita.setESTADO("TERMINADA");
                myCita.setFECHATERMINA(Funciones.getFechaSistema(conn,myMotor));
                myCitaDao.terminarCita(conn, myCita);


                //Pasos para la auditoria
                myAuditoria = new Auditoria();
                myAuditSx = new AuditoriaSystem();
                myAuditSx.setTABLAAFECTADA("CITA");
                myAuditSx.setCAMPOCLAVE("ID_CITA");
                myAuditSx.setVLRCAMPOCLAVE(String.valueOf(myCita.getID_CITA()));
                myAuditSx.setID_USUARIO(idUsuario);
                myAuditSx.setIP(myIp);
                myAuditSx.setNOMBREEQUIPO(myHost);
                myAuditSx.setDESCRIPOPERACION("Terminacion de Cita");
                myAuditSx.setTIPOPERACION("E");
                myAuditoria.auditarOtraOp(conn, myAuditSx, 0);
                //-- para la auditoria
                id = myCita.getID_CITA();
                myCita = new Cita();
                myCita.setID_CITA(id);
                lista = myCitaDao.searchMatching(conn, myCita);
                if (lista != null && lista.size() > 0) {
                    myCita = (Cita)lista.get(0);
                } else
                    return null;

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return myCita;
    }
    
    public Cita cancelarCita(Cita myCita, int idUsuario, String myIp, String myHost, int modulo) {
        int id;
        List lista;
        //Campos para la auditoria
        Auditoria myAuditoria;
        AuditoriaSystem myAuditSx;
        //--Campos para la auditoria
        try {
            if (modulo == 0)
                conn = conexion.conectar();
            else
                conn = conexion.conectarComparendos();
            CitaDao myCitaDao = new CitaDao();
            if (myCita.getID_CITA() != 0) {

                myCita.setESTADO("CANELADA");
                myCita.setFECHATERMINA(Funciones.getFechaSistema(conn,myMotor));
                myCitaDao.terminarCita(conn, myCita);


                //Pasos para la auditoria
                myAuditoria = new Auditoria();
                myAuditSx = new AuditoriaSystem();
                myAuditSx.setTABLAAFECTADA("CITA");
                myAuditSx.setCAMPOCLAVE("ID_CITA");
                myAuditSx.setVLRCAMPOCLAVE(String.valueOf(myCita.getID_CITA()));
                myAuditSx.setID_USUARIO(idUsuario);
                myAuditSx.setIP(myIp);
                myAuditSx.setNOMBREEQUIPO(myHost);
                myAuditSx.setDESCRIPOPERACION("Cancelacion Cita de Cita");
                myAuditSx.setTIPOPERACION("E");
                myAuditoria.auditarOtraOp(conn, myAuditSx, 0);
                //-- para la auditoria
                id = myCita.getID_CITA();
                myCita = new Cita();
                myCita.setID_CITA(id);
                lista = myCitaDao.searchMatching(conn, myCita);
                if (lista != null && lista.size() > 0) {
                    myCita = (Cita)lista.get(0);
                } else
                    return null;

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return myCita;
    }

    public Cita anularCita(Cita myCita, int idUsuario, String myIp, String myHost, int modulo) {
        List lista;
        int id;
        //Campos para la auditoria
        Auditoria myAuditoria;
        AuditoriaSystem myAuditSx;
        //--Campos para la auditoria
        try {
            if (modulo == 0)
                conn = conexion.conectar();
            else
                conn = conexion.conectarComparendos();
            CitaDao myCitaDao = new CitaDao();
            myCita.setESTADO("ANULADA");
            myCita.setFECHAANULA(Funciones.getFechaSistema(conn,myMotor));
            myCitaDao.anularCita(conn, myCita);
            //Pasos para la auditoria
            myAuditoria = new Auditoria();
            myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("CITA");
            myAuditSx.setCAMPOCLAVE("ID_CITA");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(myCita.getID_CITA()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditSx.setDESCRIPOPERACION("Anulacion de Cita");
            myAuditSx.setTIPOPERACION("E");
            myAuditoria.auditarOtraOp(conn, myAuditSx, 0);
            //-- para la auditoria
            id = myCita.getID_CITA();
            myCita = new Cita();
            myCita.setID_CITA(id);
            lista = myCitaDao.searchMatching(conn, myCita);
            if (lista != null && lista.size() > 0) {
                myCita = (Cita)lista.get(0);
            } else
                return null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return myCita;
    }

    public List getCita(Cita myCita, int modulo) {
        List mylista;
        mylista = null;
        try {
            if (modulo == 0)
                conn = conexion.conectar();
            else
                conn = conexion.conectarComparendos();
            CitaDao myCitaDao = new CitaDao();
            mylista = myCitaDao.searchMatching(conn, myCita);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return mylista;
    }

    public Cita ponerObservacionCita(Cita myCita, int modulo) {
        List lista;
        try {
            if (modulo == 0)
                conn = conexion.conectar();
            else
                conn = conexion.conectarComparendos();
            CitaDao myCitaDao = new CitaDao();
            myCitaDao.observacionCita(conn, myCita);
            lista = myCitaDao.searchMatching(conn, myCita);
            if (lista != null && lista.size() > 0) {
                myCita = (Cita)lista.get(0);
            } else
                return null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return myCita;
    }

    public DetCita insertarDetCita(DetCita myDetCita, int modulo) {
        DetCita myTemp;
        myTemp = new DetCita();
        int id;
        int num;
        List lista;
        String numRad = "RA"; //Al unir se debe llamar al obtener prefijo de Radicacion
        try {
            if (modulo == 0)
                conn = conexion.conectar();
            else
                conn = conexion.conectarComparendos();
            DetCitaDao myDetCitaDao = new DetCitaDao();
            myTemp.setID_CITA(myDetCita.getID_CITA());
            myTemp.setIDTRAMITEINTERNO(myDetCita.getIDTRAMITEINTERNO());
            lista = myDetCitaDao.searchMatching(conn, myTemp);
            if (lista == null || lista.size() == 0) {
                id = Funciones.obtenerId(conn, "GEN_DETCITA", "GEN_DETCITA", myMotor);
                myDetCita.setID_DETCITA(id);
                myDetCita.setFECHAASIGNA(Funciones.getFechaSistema(conn,myMotor));
                myDetCita.setHORAASIGNA(Funciones.getHoraSistemaString(conn));
                myDetCitaDao.create(conn, myDetCita);
                myDetCita = new DetCita();
                myDetCita.setID_DETCITA(id);
                lista = myDetCitaDao.searchMatching(conn, myDetCita);
                if (lista != null && lista.size() > 0) {
                    myDetCita = (DetCita)lista.get(0);
                } else
                    return null;
            } else
                return null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return myDetCita;
    }


    public List getDetCita(DetCita myDetCita, int modulo) {
        List mylista;
        mylista = null;
        try {
            if (modulo == 0)
                conn = conexion.conectar();
            else
                conn = conexion.conectarComparendos();
            DetCitaDao myDetCitaDao = new DetCitaDao();
            mylista = myDetCitaDao.searchMatching(conn, myDetCita);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return mylista;
    }

    public void eliminarDetCita(DetCita myDetCita, int modulo) {
        try {
            if (modulo == 0)
                conn = conexion.conectar();
            else
                conn = conexion.conectarComparendos();
            DetCitaDao myDetCitaDao = new DetCitaDao();
            myDetCitaDao.delete(conn, myDetCita);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
    }

    public boolean editarFactura(Factura factura) {
        boolean resultado;
        resultado = false;
        FacturaDao myFacturaDao = new FacturaDao();
        try {
            conn = conexion.conectar();
            myFacturaDao.save(conn, factura);
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myFacturaDao = null;
        }
        return resultado;
    }
    
    public boolean editarFacturaIdArqueo(Factura factura) {
        boolean resultado;
        resultado = false;
        FacturaDao myFacturaDao = new FacturaDao();
        try {
            conn = conexion.conectar();
            myFacturaDao.saveIdArqueo(conn, factura);
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myFacturaDao = null;
        }
        return resultado;
    }
    

    public boolean anularFactura(Factura factura, int idUsuario, String myIp, String myHost) {
        List lista = null;
        List listausuarios = null;
        boolean resultado;
        resultado = false;
        Factura anterior = new Factura();
        //Campos para la auditoria
        Auditoria myAuditoria;
        AuditoriaSystem myAuditSx;
        //--Campos para la auditoria
        FacturaDao myFacturaDao = new FacturaDao();
        try {
            conn = conexion.conectar();
            //Pasos para la auditoria
            anterior.setLF_ID(factura.getLF_ID());
            lista = myFacturaDao.searchMatching(conn, anterior);
            if (lista != null && lista.size() > 0) {
                anterior = (Factura)lista.get(0);
            }
            if (anterior != null && anterior.getLF_ESTADO() == 1) {
                factura.setLF_ESTADO(4);
                factura.setLF_FECHAANULA(Funciones.getFechaSistema(conn,myMotor));
                factura.setLF_HORAANULA(Funciones.getHoraSistemaString(conn));
                factura.setLF_ID_USUARIOANULA(idUsuario);
                
                /*
                myAuditoria = new Auditoria();
                myAuditSx = new AuditoriaSystem();
                myAuditSx.setTABLAAFECTADA("L_FACTURAS");
                myAuditSx.setCAMPOCLAVE("LF_ID");
                myAuditSx.setVLRCAMPOCLAVE(String.valueOf(factura.getLF_ID()));
                myAuditSx.setID_USUARIO(idUsuario);
                myAuditSx.setIP(myIp);
                myAuditSx.setNOMBREEQUIPO(myHost);
                myAuditoria.auditarOtraOp(conn, myAuditSx, 0);
                //-- para la auditoria
                */
                myFacturaDao.anular(conn, factura);


                resultado = true;

                //AUDITORIA TRAMITE **********************************
                GestionAuditoriaTramite mygestionauditoriatramite = new GestionAuditoriaTramite();
                GestionServiciosUsuarios mygestionusuario = new GestionServiciosUsuarios();
                Auditoriatramite objAuditoriaTramite = new Auditoriatramite();
                Usuarios objusuario = new Usuarios();
                objusuario.setID_USUARIO(idUsuario);
                listausuarios = mygestionusuario.getUsuarios(objusuario, 0);
                if (listausuarios != null && listausuarios.size() > 0)
                    objAuditoriaTramite.setUSUARIO(((Usuarios)listausuarios.get(0)).getLOGIN());
                if (factura.getLF_V_ID() > 0) {
                    objAuditoriaTramite.setTARGET_TRAMITE(2);
                    Vehiculo objvehiculo = new Vehiculo();
                    GestionServiciosVehiculosLocal gestionVehiculos = new GestionServiciosVehiculosLocal();
                    objvehiculo.setID_VEHICULO(factura.getLF_V_ID());
                    objvehiculo = gestionVehiculos.getVehiculo(objvehiculo);
                    objAuditoriaTramite.setPLACA_VEHICULO(objvehiculo.getPLACA());

                }

                if (factura.getLF_ID_PERSONA() > 0) {
                    objAuditoriaTramite.setTARGET_TRAMITE(1);
                    ServiciosPersonas serviciopers = new ServiciosPersonas();
                    Persona pers = new Persona();
                    pers.setID_PERSONAS(factura.getLF_ID_PERSONA());
                    pers = serviciopers.getPersona(pers);
                    if (pers != null)
                        objAuditoriaTramite.setCEDULA_PERSONA(pers.getIDENTIFICACION());

                }
                GestionViewGeneralesLocal mygestiongenerales = new GestionViewGeneralesLocal();
                DetalleprocersarView detalle = new DetalleprocersarView();
                detalle.setLF_ID(factura.getLF_ID());
                List listadetalle = null;
                listadetalle = mygestiongenerales.getDetalleProcesar(detalle);
                if (listadetalle != null && listadetalle.size() > 0) {
                    String tramites = "";
                    for (int i = 0; i < listadetalle.size(); i++) {
                        tramites += ((DetalleprocersarView)listadetalle.get(i)).getDESCTRAMITE() + ",";
                    }
                    objAuditoriaTramite.setTRAMITE(tramites);
                }

                String fecha = Funciones.getFechaSistemaCortaTexto(myMotor);
                objAuditoriaTramite.setFECHA(fecha);

                objAuditoriaTramite.setHORA(Funciones.getHoraSistema().toString());
                objAuditoriaTramite.setACCION(2);
                String datosadicionales = "";
                if (factura.getLF_NOTA() != null)
                    datosadicionales = factura.getLF_NOTA();

                objAuditoriaTramite.setINFO_ADICIONAL("Factura Nro:" + factura.getLF_NUMERO() + " Host:" + myHost +
                                                      " Direccion IP:" + myIp + ". " + datosadicionales);

                mygestionauditoriatramite.crearAuditoriatramite(objAuditoriaTramite);
                //FIN AUDITORIA TRAMITE ****************************************************

            } else {
                resultado = false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myFacturaDao = null;
        }
        return resultado;
    }


    public boolean procesaFactura(Factura factura, int idUsuario, String myIp, String myHost) {
        List lista = null;
        List listausuarios = null;
        boolean resultado;
        resultado = false;
        Factura anterior = new Factura();
        //Campos para la auditoria
        Auditoria myAuditoria;
        AuditoriaSystem myAuditSx;
        //--Campos para la auditoria
        FacturaDao myFacturaDao = new FacturaDao();
        try {
            conn = conexion.conectar();
            //Pasos para la auditoria
            anterior.setLF_ID(factura.getLF_ID());
            lista = myFacturaDao.searchMatching(conn, anterior);
            if (lista != null && lista.size() > 0) {
                anterior = (Factura)lista.get(0);
            }
            if (anterior != null && anterior.getLF_ESTADO() == 2) {

                factura.setLF_ESTADO(3);
                factura.setLF_FECHA_PAGO(Funciones.getFechaSistema(conn,myMotor));
                /*
                myAuditoria = new Auditoria();
                myAuditSx = new AuditoriaSystem();
                myAuditSx.setTABLAAFECTADA("L_FACTURAS");
                myAuditSx.setCAMPOCLAVE("LF_ID");
                myAuditSx.setVLRCAMPOCLAVE(String.valueOf(factura.getLF_ID()));
                myAuditSx.setID_USUARIO(idUsuario);
                myAuditSx.setIP(myIp);
                myAuditSx.setNOMBREEQUIPO(myHost);
                myAuditSx.setDESCRIPOPERACION("Terminacion o procesamiento de Factura");
                myAuditSx.setTIPOPERACION("A");
                myAuditoria.auditarOtraOp(conn, myAuditSx, 0);
                */

                conn = conexion.conectar();
                //-- para la auditoria
                myFacturaDao.terminar(conn, factura);
                //AUDITORIA TRAMITE **************************************************
                GestionAuditoriaTramite mygestionauditoriatramite = new GestionAuditoriaTramite();
                GestionServiciosUsuarios mygestionusuario = new GestionServiciosUsuarios();
                Auditoriatramite objAuditoriaTramite = new Auditoriatramite();
                Usuarios objusuario = new Usuarios();
                objusuario.setID_USUARIO(idUsuario);
                listausuarios = mygestionusuario.getUsuarios(objusuario, 0);
                if (listausuarios != null && listausuarios.size() > 0)
                    objAuditoriaTramite.setUSUARIO(((Usuarios)listausuarios.get(0)).getLOGIN());

                Factura fact = factura;

                if (fact.getLF_V_ID() > 0) {
                    objAuditoriaTramite.setTARGET_TRAMITE(2);
                    Vehiculo objvehiculo = new Vehiculo();
                    GestionServiciosVehiculosLocal gestionVehiculos = new GestionServiciosVehiculosLocal();
                    objvehiculo.setID_VEHICULO(fact.getLF_V_ID());
                    objvehiculo = gestionVehiculos.getVehiculo(objvehiculo);
                    objAuditoriaTramite.setPLACA_VEHICULO(objvehiculo.getPLACA());


                }
                if (fact.getLF_ID_PERSONA() > 0) {

                    objAuditoriaTramite.setTARGET_TRAMITE(1);

                    ServiciosPersonas serviciopers = new ServiciosPersonas();
                    Persona pers = new Persona();
                    pers.setID_PERSONAS(fact.getLF_ID_PERSONA());
                    pers = serviciopers.getPersona(pers);
                    if (pers != null)
                        objAuditoriaTramite.setCEDULA_PERSONA(pers.getIDENTIFICACION());

                }

                GestionViewGeneralesLocal mygestiongenerales = new GestionViewGeneralesLocal();
                DetalleprocersarView detalle = new DetalleprocersarView();
                detalle.setLF_ID(fact.getLF_ID());
                List listadetalle = null;
                listadetalle = mygestiongenerales.getDetalleProcesar(detalle);
                if (listadetalle != null && listadetalle.size() > 0) {
                    String tramites = "";
                    for (int i = 0; i < listadetalle.size(); i++) {
                        tramites += ((DetalleprocersarView)listadetalle.get(i)).getDESCTRAMITE() + ",";
                    }
                    objAuditoriaTramite.setTRAMITE(tramites);

                }


                String fecha = Funciones.getFechaSistemaCortaTexto(myMotor);
                objAuditoriaTramite.setFECHA(fecha);

                objAuditoriaTramite.setHORA(Funciones.getHoraSistema().toString());
                objAuditoriaTramite.setACCION(4);

                String datosadicionales = "";
                if (fact.getLF_NOTA() != null)
                    datosadicionales = fact.getLF_NOTA();

                objAuditoriaTramite.setINFO_ADICIONAL("Factura Nro:" + fact.getLF_NUMERO() + " Host:" + myHost +
                                                      " Direccion IP:" + myIp + ". " + datosadicionales);
                mygestionauditoriatramite.crearAuditoriatramite(objAuditoriaTramite);


                //FIN AUDITORIA TRAMITE **********************************************


                //Procesamiento factura amiga, si la hay
                String numfacturaamiga = getNumeroFacturaAmiga(factura);
                if (numfacturaamiga != null) {
                    Factura FacturaAmiga = new Factura();
                    FacturaAmiga.setLF_NUMERO(numfacturaamiga);
                    conn = conexion.conectar();
                    lista = null;
                    lista = myFacturaDao.searchMatching(conn, FacturaAmiga);
                    if (lista != null && lista.size() > 0) {
                        FacturaAmiga = (Factura)lista.get(0);
                    }
                    if (FacturaAmiga != null && FacturaAmiga.getLF_ESTADO() == 2) {

                        FacturaAmiga.setLF_ESTADO(3);
                        FacturaAmiga.setLF_FECHA_PAGO(Funciones.getFechaSistema(conn,myMotor));
                        FacturaAmiga.setLF_FECHA_TRAMITE(factura.getLF_FECHA_TRAMITE());
                        /*
                        myAuditoria = new Auditoria();
                        myAuditSx = new AuditoriaSystem();
                        myAuditSx.setTABLAAFECTADA("L_FACTURAS");
                        myAuditSx.setCAMPOCLAVE("LF_ID");
                        myAuditSx.setVLRCAMPOCLAVE(String.valueOf(FacturaAmiga.getLF_ID()));
                        myAuditSx.setID_USUARIO(idUsuario);
                        myAuditSx.setIP(myIp);
                        myAuditSx.setNOMBREEQUIPO(myHost);
                        myAuditSx.setDESCRIPOPERACION("Terminacion o procesamiento de Factura Amiga");
                        myAuditSx.setTIPOPERACION("A");
                        myAuditoria.auditarOtraOp(conn, myAuditSx, 0);
                        */

                        conn = conexion.conectar();
                        myFacturaDao.terminar(conn, FacturaAmiga);
                    }

                }

                resultado = true;
            } else {
                resultado = false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }


    public boolean eliminarFacturasMatriculaInicial(Factura facturaprincipal, Factura facturaamiga) {
        int idvehiculo = 0;
        String placa = "";
        FacturaDao myFacturaDao = new FacturaDao();
        ViewPropietariosDao myViewpropietarioDao = new ViewPropietariosDao();
        ViewPropietarios myViewPropietario = new ViewPropietarios();
        VehiculoDao myVehiculoDao = new VehiculoDao();
        DetPlacaGeneradaDao myDetPlacaGeneradaDao = new DetPlacaGeneradaDao();
        DetPlacaGenerada myDetPlacaGenerada = new DetPlacaGenerada();
        List lista = null;
        conn = conexion.conectar();

        try {

            //Eliminando Facturas
            if (facturaprincipal != null) {
                idvehiculo = facturaprincipal.getLF_V_ID();
                //myFacturaDao.delete(conn, facturaprincipal);
                myFacturaDao.setNullIdVehiculo(conn, facturaprincipal);
            }
            if (facturaamiga != null) {
                //myFacturaDao.delete(conn, facturaamiga);
                myFacturaDao.setNullIdVehiculo(conn, facturaamiga);
            }
            //Eliminando propietario de vehiculo
            myViewPropietario.setID_VEHICULO(String.valueOf(idvehiculo));
            myViewpropietarioDao.deletePropietario(conn, myViewPropietario);

            //Eliminando Vehiculo
            Vehiculo myVehiculo = new Vehiculo();
            myVehiculo.setID_VEHICULO(idvehiculo);
            lista = myVehiculoDao.searchMatching(conn, myVehiculo);
            if (lista != null && lista.size() > 0) {
                myVehiculo = (Vehiculo)lista.get(0);
                placa = myVehiculo.getPLACA();
                myVehiculoDao.delete(conn, myVehiculo);
            }
            myDetPlacaGenerada.setPLACAGEN(placa);
            lista = null;
            lista = myDetPlacaGeneradaDao.searchMatching(conn, myDetPlacaGenerada);
            if (lista != null && lista.size() > 0) {
                myDetPlacaGenerada = (DetPlacaGenerada)lista.get(0);
                myDetPlacaGenerada.setASIGNADA("F");
                myDetPlacaGeneradaDao.cambiarAsignacion(conn, myDetPlacaGenerada);
            }


        } catch (Exception exp) {
            return false;
        }


        return true;
    }


    public String getNumeroFacturaAmiga(Factura factura) {
        String nota = factura.getLF_NOTA();

        if (nota != null) {
            if (nota.contains("LIQUIDACION DOBLE")) {
                nota = nota.substring(0, nota.length() - 1);
                int start = nota.lastIndexOf(":") + 1;
                int end = nota.lastIndexOf(".");
                String recibo = nota.substring(start, end);
                return recibo;
            }
        }

        return null;
    }


    public List buscarItemsFactura(ViewDetFactura viewdetfactura) {
        List lista;
        lista = null;
        try {
            conn = conexion.conectar();
            ViewDetFacturaDao myViewDetFacturaDao = new ViewDetFacturaDao();
            lista = myViewDetFacturaDao.searchMatching(conn, viewdetfactura);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List buscarDetItemsFactura(ViewDetalleFactura viewdetallefactura) {
        List lista;
        lista = null;
        try {
            conn = conexion.conectar();
            ViewDetalleFacturaDao myViewDetalleFacturaDao = new ViewDetalleFacturaDao();
            lista = myViewDetalleFacturaDao.searchMatching(conn, viewdetallefactura);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getLiquidacionImpuestos(ViewDetalleFactura viewdetallefactura) {
        List lista;
        lista = null;
        try {
            conn = conexion.conectar();
            ViewDetalleFacturaDao myViewDetalleFacturaDao = new ViewDetalleFacturaDao();
            lista = myViewDetalleFacturaDao.getImpuestos(conn, viewdetallefactura);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public boolean pagarFactura(Factura factura) {
        boolean resultado;
        resultado = false;
        FacturaDao myFacturaDao = new FacturaDao();
        try {
            conn = conexion.conectar();
            factura.setLF_FECHA_PAGO(Funciones.getFechaHoraSistema(myMotor));
            myFacturaDao.pagarFactura(conn, factura,myMotor);
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myFacturaDao = null;
        }
        return resultado;
    }

    public List getTipoEntregaSol(RuntTipoEntregaSol tipoentregasol) {
        List lista;
        lista = null;
        try {
            conn = conexion.conectar();
            RuntTipoEntregaSolDao myRuntTipoEntregaSolDao = new RuntTipoEntregaSolDao();
            lista = myRuntTipoEntregaSolDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public RadTramitesRevisados insertarRadTramitesRevisados(RadTramitesRevisados myRadTramRev) {
        List lista;
        int id;
        try {
            conn = conexion.conectar();
            RadTramitesRevisadosDao myRadTramRevDao = new RadTramitesRevisadosDao();
            id = Funciones.obtenerId(conn, "GEN_TRAMITESREVISADOS", "GEN_TRAMITESREVISADOS", myMotor);
            myRadTramRev.setID_RADTRAMREVISADO(id);
            myRadTramRevDao.create(conn, myRadTramRev);
            myRadTramRev = new RadTramitesRevisados();
            myRadTramRev.setID_RADTRAMREVISADO(id);
            lista = myRadTramRevDao.searchMatching(conn, myRadTramRev);
            if (lista != null && lista.size() > 0) {
                myRadTramRev = (RadTramitesRevisados)lista.get(0);
            } else
                return null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return myRadTramRev;
    }

    public List getRadTramitesRevisados(RadTramitesRevisados myRadTramRev) {
        List lista;
        lista = null;
        try {
            conn = conexion.conectar();
            RadTramitesRevisadosDao myRadTramRevDao = new RadTramitesRevisadosDao();
            lista = myRadTramRevDao.searchMatching(conn, myRadTramRev);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public boolean setCargadoRunt(String estado, int idFactura) {
        boolean res = false;
        FacturaDao myDao = new FacturaDao();
        Factura factura = new Factura();
        factura.setCARGADO(estado);
        factura.setLF_ID(idFactura);
        try {
            conn = conexion.conectar();
            myDao.setEstadoRunt(conn, factura);
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

}
