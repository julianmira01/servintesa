package modelo.logica.generales.vehiculo;

import java.sql.Connection;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.generales.LicenciaDeTransitoDao;
import modelo.datos.dao.generales.vehiculo.VehiculoDao;
import modelo.datos.dao.generales.vehiculo.VehiculoNovedadDao;
import modelo.datos.objetos.comparendos.generales.VehiculosComp;
import modelo.datos.objetos.generales.AuditoriaSystem;
import modelo.datos.objetos.generales.LicenciaDeTransito;
import modelo.datos.objetos.generales.vehiculo.Vehiculo;
import modelo.datos.objetos.generales.vehiculo.VehiculoNovedad;

import modelo.logica.comparendos.generales.GestionServiciosGeneralesComp;

import modelo.logica.generales.GestionServiciosLicenciaDeTransito;

import modelo.logica.generales.GestionServiciosLicenciaDeTransito;


import utilidades.Auditoria;
import utilidades.Funciones;
import utilidades.SerializarObjetos;


public class GestionServiciosVehiculosLocal {

    Conexion conexion;
    Connection conn;
    VehiculoDao vehiculoDao;
    String myMotor;

    public GestionServiciosVehiculosLocal() {
        super();
        crearObjetos();
    }

    public void crearObjetos() {
        conexion = new Conexion();
        vehiculoDao = new VehiculoDao();
        myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
    }

    public Vehiculo getVehiculo(Vehiculo vehiculo) {
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)vehiculoDao.searchMatching(conn, vehiculo);
            if (lista != null && lista.size() > 0) {
                vehiculo = (Vehiculo)lista.get(0);
            } else {
                vehiculo.setID_VEHICULO(-1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conexion.cerrarCx();
        }
        return vehiculo;
    }
    
    public String getClaseRuntVehiculo(Vehiculo vehiculo) {
        
        String clasev = "";
        try {
            conn = conexion.conectar();
            VehiculoDao mydao = new VehiculoDao();
            clasev=mydao.obtenerClaseRUNTVehiculo(conn, vehiculo.getPLACA());
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conexion.cerrarCx();
        }
        return clasev;
    }

    public Vehiculo crearVehiculo(Vehiculo vehiculo, int idUsuario, String myIp, String myHost) {
        List lista = null;
        int id = 0;
        //Campos para la auditoria
        Auditoria myAuditoria;
        AuditoriaSystem myAuditSx;
        //--Campos para la auditoria
        try {
            conn = conexion.conectar();
            id = Funciones.obtenerId(conn, "GEN_VEHICULO", "GEN_VEHICULO", myMotor);
            vehiculo.setID_VEHICULO(id);
            vehiculoDao.create(conn, vehiculo);
            //Pasos para la auditoria
            myAuditoria = new Auditoria();
            myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("VEHICULO");
            myAuditSx.setCAMPOCLAVE("ID_VEHICULO");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(id));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, vehiculo, 0);
            //-- para la auditoria
            vehiculo = new Vehiculo();
            vehiculo.setID_VEHICULO(id);
            lista = vehiculoDao.searchMatching(conn, vehiculo);
            if (lista != null && lista.size() > 0) {
                vehiculo = (Vehiculo)lista.get(0);
            } else {
                vehiculo.setID_VEHICULO(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            vehiculo.setID_VEHICULO(-1);

        } finally {
            conexion.cerrarCx();
        }
        return vehiculo;
    }

    public Vehiculo activarVehiculo(Vehiculo vehiculo, int idUsuario, String myIp, String myHost) {
        List lista = null;
        int id = 0;
        //Campos para la auditoria
        Auditoria myAuditoria;
        AuditoriaSystem myAuditSx;
        //--Campos para la auditoria
        try {
            conn = conexion.conectar();
            id = vehiculo.getID_VEHICULO();
            vehiculoDao.activar(conn, vehiculo);
            //Pasos para la auditoria
            myAuditoria = new Auditoria();
            myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("VEHICULO");
            myAuditSx.setCAMPOCLAVE("ID_VEHICULO");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(id));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditSx.setDESCRIPOPERACION("Activacion de Vehiculo");
            myAuditSx.setTIPOPERACION("E");
            myAuditoria.auditarOtraOp(conn, myAuditSx, 0);
            //-- para la auditoria

            vehiculo = new Vehiculo();
            vehiculo.setID_VEHICULO(id);
            lista = vehiculoDao.searchMatching(conn, vehiculo);
            if (lista != null && lista.size() > 0) {
                vehiculo = (Vehiculo)lista.get(0);
            } else {
                vehiculo.setID_VEHICULO(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            vehiculo.setID_VEHICULO(-1);

        } finally {
            conexion.cerrarCx();
        }
        return vehiculo;
    }

    public boolean auditarLiberarPlaca(Vehiculo obj, int idUsuario, String myIp, String myHost) {
        boolean res = false;
        try {
            conn = conexion.conectar();
            //auditar otro
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("VEHICULO");
            myAuditSx.setCAMPOCLAVE("ID_VEHICULO");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(obj.getID_VEHICULO()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditSx.setDESCRIPOPERACION(" Liberar placa " + obj.getPLACA() + " ");
            myAuditSx.setTIPOPERACION("LIBER");
            myAuditoria.auditarOtraOp(conn, myAuditSx, 0);
                res = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public boolean eliminarVehiculo(Vehiculo vehiculo, int idUsuario, String myIp, String myHost) {
        boolean res = false;
        List lista;
        //Campos para la auditoria
        Vehiculo anterior;
        Auditoria myAuditoria;
        AuditoriaSystem myAuditSx;
        //--Campos para la auditoria
        try {
            conn = conexion.conectar();
            LicenciaDeTransito myLicencia = new LicenciaDeTransito();
            myLicencia.setID_VEHICULO(vehiculo.getID_VEHICULO());
            LicenciaDeTransitoDao myLicenciaDao = new LicenciaDeTransitoDao();
            lista = myLicenciaDao.searchMatching(conn, myLicencia);
            if (lista == null || lista.size() <= 0) {
                anterior = new Vehiculo();
                anterior.setID_VEHICULO(vehiculo.getID_VEHICULO());
                lista = vehiculoDao.searchMatching(conn, anterior);
                if (lista != null && lista.size() > 0) {
                    anterior = (Vehiculo)lista.get(0);
                    //Pasos para la auditoria
                    myAuditoria = new Auditoria();
                    myAuditSx = new AuditoriaSystem();
                    myAuditSx.setTABLAAFECTADA("VEHICULO");
                    myAuditSx.setCAMPOCLAVE("ID_VEHICULO");
                    myAuditSx.setVLRCAMPOCLAVE(String.valueOf(anterior.getID_VEHICULO()));
                    myAuditSx.setID_USUARIO(idUsuario);
                    myAuditSx.setIP(myIp);
                    myAuditSx.setNOMBREEQUIPO(myHost);
                    myAuditoria.auditarEliminacion(conn, myAuditSx, anterior, 0);
                    //-- para la auditoria
                }
                vehiculoDao.delete(conn, vehiculo);
                res = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public boolean validarVehiculoExisteBaseDatos(Vehiculo vehiculo) {
        List lista = null;
        boolean resultado;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)vehiculoDao.validarVehiculoExisteBaseDatos(conn, vehiculo);
            if (lista != null && lista.size() > 0) {
                vehiculo = (Vehiculo)lista.get(0);
                resultado = true;
            } else {
                resultado = false;

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            resultado = false;
        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }

    public boolean validarVehiculoActivo(Vehiculo vehiculo) {

        boolean resultado = false;
        try {
            conn = conexion.conectar();
            vehiculoDao.load(conn, vehiculo);
            if (vehiculo.getID_MOTIVOCANCELACION() != null && !vehiculo.getID_MOTIVOCANCELACION().equals("") &&
                vehiculo.getID_MOTIVOCANCELACION().toLowerCase() != "null")
                resultado = false;
            else
                resultado = true;

        } catch (Exception e) {
            System.out.println(e.getMessage());

        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }
  


    public boolean actualizarVehiculo(Vehiculo vehiculo, int idUsuario, String myIp, String myHost) {

        boolean resultado = false;
        List lista;
        //Campos para la auditoria
        Vehiculo anterior;
        Auditoria myAuditoria;
        AuditoriaSystem myAuditSx;
        //--Campos para la auditoria
        try {
            conn = conexion.conectar();
            //Pasos previos Auditoria
            anterior = new Vehiculo();
            anterior.setID_VEHICULO(vehiculo.getID_VEHICULO());
            lista = vehiculoDao.searchMatching(conn, anterior);
            if (lista != null && lista.size() > 0) {
                anterior = (Vehiculo)lista.get(0);
            } else {
                anterior = null;
            }
            //Pasos previos para auditoria
            vehiculoDao.save(conn, vehiculo);
        
        //SerializarObjetos srz_obj = new SerializarObjetos<Vehiculo>();
        //srz_obj.saveObjeto(vehiculo);

        
//ACTUALIZAR VEH-*-CULO EN COMPARENDOS
//INICIO ACTUALIZAR VEH-*-CULO COMPARENDO
            GestionServiciosGeneralesComp gestionServiciosGeneralesComp = new GestionServiciosGeneralesComp();
            VehiculosComp vehiculoComp = new VehiculosComp();
            
          int tipoServicio = Integer.parseInt(vehiculo.getID_SERVICIO());
          if (tipoServicio == 2) // SI EL TIPO DE SERVICIO ES P-*-BLICO
          {
            if(vehiculo.getID_EMPSERVIPUBLICO()!=null)
              vehiculoComp.setID_EMPRESA(Integer.parseInt(vehiculo.getID_EMPSERVIPUBLICO()));

            //Valores quemados, cambiar (si es posible esto en el futuro)
            //Homologar radio Acci-*-n del veh-*-culo en Tpte Principal con el de comparendos
            int idRuntRadioAccion = 0;
            if(vehiculo.getID_RUNTRADIOACCION()!=null)
              idRuntRadioAccion = Integer.parseInt(vehiculo.getID_RUNTRADIOACCION());
            if (idRuntRadioAccion == 2)
              vehiculoComp.setID_RADIOACCION(1);
            else if (idRuntRadioAccion == 1)
              vehiculoComp.setID_RADIOACCION(2);

            //Valores quemados, cambiar (si es posible esto en el futuro)
            //Homologar Modalidad del veh-*-culo en Tpte Principal con la de comparendos
            int idModalidad = 0;
            if(vehiculo.getID_MODALIDADSERVICIO()!=null)
              idModalidad = Integer.parseInt(vehiculo.getID_MODALIDADSERVICIO());
            switch (idModalidad)
            {
              case 2:
                vehiculoComp.setID_MODALIDADTRANSPORTE(1);
                break;
              case 3:
                vehiculoComp.setID_MODALIDADTRANSPORTE(2);
                break;
              case 4:
                vehiculoComp.setID_MODALIDADTRANSPORTE(3);
                break;
            }

            vehiculoComp.setTARJETAOPERACION(vehiculo.getTARJETAOPERACION());
          }
          else
          {
            vehiculoComp.setID_EMPRESA(-1);
            vehiculoComp.setID_RADIOACCION(-1);
            vehiculoComp.setID_MODALIDADTRANSPORTE(-1);
            vehiculoComp.setTARJETAOPERACION(null);
          }

          //Este campo no tiene homologaci-*-n con veh-*-culo de principal
          vehiculoComp.setID_TIPOTRANSPORTEPASAJERO(-1);

          if (vehiculo.getIDORG_EXPIDE() != null)
            vehiculoComp.setID_ORGTRANSITODEMATRICULA(Integer.parseInt(vehiculo.getIDORG_EXPIDE()));

          if (vehiculo.getID_SERVICIO() != null)
            vehiculoComp.setID_SERVICIO(Integer.parseInt(vehiculo.getID_SERVICIO()));            

          if (vehiculo.getID_CVEHICULO() != null)                                        
            vehiculoComp.setID_CVEHICULO(Integer.parseInt(vehiculo.getID_CVEHICULO()));

          //Buscar la Licencia m-*-s reciente del Veh-*-culo
          GestionServiciosLicenciaDeTransito myGestionLicenciaDeTransito = new GestionServiciosLicenciaDeTransito();
          LicenciaDeTransito tmpLicencia = new LicenciaDeTransito();
          tmpLicencia.setID_VEHICULO(vehiculo.getID_VEHICULO());
          tmpLicencia = myGestionLicenciaDeTransito.getLicenciaDeTransito(tmpLicencia);

          if (tmpLicencia != null && tmpLicencia.getGEN_IDTRANSITO() > 0)
          {
            vehiculoComp.setNROLICENCIA(tmpLicencia.getID_LICTRANSITO());
          }

          vehiculoComp.setPLACA(vehiculo.getPLACA());
          
          gestionServiciosGeneralesComp.actualizarVehiculoComp(vehiculoComp, 0, "", "");
//FIN ACTUALIZAR VEH-*-CULO COMPARENDO
            
            
            
            //Pasos para la auditoria
            myAuditoria = new Auditoria();
            myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("VEHICULO");
            myAuditSx.setCAMPOCLAVE("ID_VEHICULO");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(vehiculo.getID_VEHICULO()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEdicion(conn, myAuditSx, anterior, vehiculo, myIp, myHost, 0);
            //-- para la auditoria
            resultado = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.out.println("Prueba depuracion");
            resultado = false;

        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }

    public boolean actualizarTrasladoCuenta(Vehiculo vehiculo, int idUsuario, String myIp, String myHost) {

        boolean resultado = false;
        List lista;
        //Campos para la auditoria
        Vehiculo anterior;
        Auditoria myAuditoria;
        AuditoriaSystem myAuditSx;
        //--Campos para la auditoria
        try {
            conn = conexion.conectar();
            //Pasos previos Auditoria
            anterior = new Vehiculo();
            anterior.setID_VEHICULO(vehiculo.getID_VEHICULO());
            lista = vehiculoDao.searchMatching(conn, anterior);
            if (lista != null && lista.size() > 0) {
                anterior = (Vehiculo)lista.get(0);
            } else {
                anterior = null;
            }
            //Pasos previos para auditoria
            vehiculoDao.actualizarTrasladoCuenta(conn, vehiculo);
            //Pasos para la auditoria
            myAuditoria = new Auditoria();
            myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("VEHICULO");
            myAuditSx.setCAMPOCLAVE("ID_VEHICULO");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(vehiculo.getID_VEHICULO()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEdicion(conn, myAuditSx, anterior, vehiculo, myIp, myHost, 0);
            //-- para la auditoria
            resultado = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            resultado = false;

        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }

    public boolean crearVehiculoNov(Vehiculo vehiculo) {
        int id;
        boolean resultado = false;
        try {
            conn = conexion.conectar();
            id = Funciones.obtenerId(conn, "GENVEHICULONOV", "GEN_VEHICULONOV", myMotor);
            VehiculoNovedadDao myDao = new VehiculoNovedadDao();
            myDao.create(conn, vehiculo, id);
            resultado = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            resultado = false;

        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }

    public boolean eliminarVehiculoNov(VehiculoNovedad vehiculoNov) {

        boolean resultado = false;
        try {
            conn = conexion.conectar();
            VehiculoNovedadDao myDao = new VehiculoNovedadDao();
            myDao.delete(conn, vehiculoNov);
            resultado = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            resultado = false;

        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }

    public boolean actualizarVehiculoNov(VehiculoNovedad vehiculoNov) {

        boolean resultado = false;
        try {
            conn = conexion.conectar();
            VehiculoNovedadDao myDao = new VehiculoNovedadDao();
            myDao.save(conn, vehiculoNov);
            resultado = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            resultado = false;

        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }

    public List getVehiculoNov(VehiculoNovedad vehiculoNov) {
        List lista = null;
        try {
            conn = conexion.conectar();
            VehiculoNovedadDao myDao = new VehiculoNovedadDao();
            lista = myDao.searchMatching(conn, vehiculoNov);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
}
