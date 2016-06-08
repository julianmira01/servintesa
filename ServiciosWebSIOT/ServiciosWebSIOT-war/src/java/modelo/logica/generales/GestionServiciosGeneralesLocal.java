package modelo.logica.generales;



import java.sql.Connection;

import java.util.ArrayList;
import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.generales.PersonaDao;
import modelo.datos.dao.generales.RuntCombustibleModificadoDao;
import modelo.datos.dao.generales.RuntMedidaCautelarModificadaDao;
import modelo.datos.dao.generales.RuntModificarAutomotorDao;
import modelo.datos.dao.generales.RuntPrendaModificadaDao;
import modelo.datos.dao.generales.RuntPropietarioModificadoDao;
import modelo.datos.dao.generales.RuntRTMModificadaDao;
import modelo.datos.dao.generales.RuntSoatModificadoDao;
import modelo.datos.dao.generales.VehiculoRadicadoCtaDao;
import modelo.datos.dao.generales.vehiculo.RuntVehiculoModificadoDao;
import modelo.datos.objetos.generales.Empresa;
import modelo.datos.objetos.generales.Persona;
import modelo.datos.objetos.generales.RuntCombustibleModificado;
import modelo.datos.objetos.generales.RuntMedidaCautelarModificada;
import modelo.datos.objetos.generales.RuntModificarAutomotor;
import modelo.datos.objetos.generales.RuntPrendaModificada;
import modelo.datos.objetos.generales.RuntPropietarioModificado;
import modelo.datos.objetos.generales.RuntRTMModificada;
import modelo.datos.objetos.generales.RuntSoatModificado;
import modelo.datos.objetos.generales.VehiculoRadicadoCta;
import modelo.datos.objetos.generales.propietarioDeVehiculo.PropietarioDeVehiculo;
import modelo.datos.objetos.generales.vehiculo.RuntVehiculoModificado;
import modelo.datos.objetos.generales.vehiculo.Vehiculo;
import modelo.datos.objetos.medidasCautelares.J_Pendiente;

import modelo.logica.generales.vehiculo.GestionServiciosVehiculosLocal;

import utilidades.Funciones;


public class GestionServiciosGeneralesLocal {

    Conexion conexion;
    Connection conn;
    String myMotor;
    //VehiculoDao vehiculoDao;

    // EmpresaDao empresaDao;
    //  GestionServiciosGeneralesRunt gestionServiciosgeneralesRunt;
    //SucursalDao sucursalDao;
    //   RepresentanteLegalDao representanteLegalDao;

    public GestionServiciosGeneralesLocal() {
        super();
        crearObjetos();
    }

    public void crearObjetos() {
        conexion = new Conexion();
        myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        //    vehiculoDao=new VehiculoDao();

        //    gestionServiciosgeneralesRunt=new GestionServiciosGeneralesRunt();
        //   empresaDao=new EmpresaDao();
        //        sucursalDao=new SucursalDao();
        //     representanteLegalDao=new RepresentanteLegalDao();
    }


    /*   public Vehiculo getVehiculo(Vehiculo vehiculo) {
        List lista = null;
        try {
            conn = conexion.conectar();
                lista = (ArrayList)vehiculoDao.searchMatching(conn, vehiculo);
            if(lista!=null && lista.size()>0){
                vehiculo=(Vehiculo)lista.get(0);
            }
            else {
              vehiculo.setID_VEHICULO(-1);
            }
        } catch (Exception e) {
System.out.println(e.getMessage());
        } finally {
            conexion.cerrarCx();
        }
        return vehiculo;
    }*/

    public Persona getPersona(Persona persona) {
        List lista = null;
        PersonaDao personaDao = new PersonaDao();
        try {
            // gestionServiciosgeneralesRunt.getPersona(persona);
            conn = conexion.conectar();
            lista = (ArrayList)personaDao.searchMatching(conn, persona);
            if (lista != null && lista.size() > 0) {
                persona = (Persona)lista.get(0);
            } else {
                persona.setID_PERSONAS(-1);
            }

        } catch (Exception e) {

        } finally {
            conexion.cerrarCx();
        }
        return persona;
    }

    /*public boolean guardarTemporal(AutomotorDTO automotorDTO) throws Exception {
        try{
        boolean resultado = true;
        int idModificarAuto = 0;
        int idVehiculoModificado = 0;
        int i;
        RuntCombustibleModificado combustibleM = new RuntCombustibleModificado();
        conversionGenerales convgenerales = new conversionGenerales();
        RuntVehiculoModificado vehiculoModificado = new RuntVehiculoModificado();
        RuntModificarAutomotor modificarAutomotor = new RuntModificarAutomotor();
        RuntMedidaCautelarModificada medidaCautelarM = new RuntMedidaCautelarModificada();
        RuntPrendaModificada prendaM = new RuntPrendaModificada();
        RuntPropietarioModificado propietarioM = new RuntPropietarioModificado();
        RuntSoatModificado soatM = new RuntSoatModificado();
        RuntRTMModificada rtmM = new RuntRTMModificada();
        modificarAutomotor.setFECHA(Funciones.getFechaSistema(conn, myMotor));
        modificarAutomotor.setHORA(Funciones.getHoraSistemaString(conn));
        //modificarAutomotor.setID_OPERACION(ID_OPERACIONIn);
        //modificarAutomotor.setID_USUARIO(ID_USUARIOIn);
        modificarAutomotor.setPLACA(automotorDTO.getIdentificador().getNumeroPlaca());

        idModificarAuto = crearModificarAutomotor(modificarAutomotor);

        if (idModificarAuto != -1) {
            vehiculoModificado =
                    convgenerales.consultaVehiTovehiculoModificado(automotorDTO.getIdentificador(), automotorDTO.getInformacion(),
                                                                   automotorDTO.getTipoServicio(),
                                                                   automotorDTO.getClase(), automotorDTO.getMarca(),
                                                                   automotorDTO.getCilindraje(),
                                                                   automotorDTO.getModelo());
            vehiculoModificado.setID_RUNTMODIFICACION(idModificarAuto);
            idVehiculoModificado = crearVehiculoModificado(vehiculoModificado);
            int cantCombustible;
            try {
                cantCombustible = automotorDTO.getCombustibles().length;
            } catch (Exception e) {
                cantCombustible = 0;
            }
            for (i = 0; i < cantCombustible; i++) {
                combustibleM = convgenerales.combustiblesDTOToCombustibleModif(automotorDTO.getCombustibles()[i]);
                combustibleM.setID_RUNTMODIFICACION(idVehiculoModificado);
                //if (resultado)
                resultado = crearCombustibleModificado(combustibleM);
            }
            System.out.println(resultado);
            int cantSoat;
            try {
                cantSoat = automotorDTO.getSoat().length;
            } catch (Exception e) {
                cantSoat = 0;
            }

            for (i = 0; i < cantSoat; i++) {
                soatM = convgenerales.soatDTOToSoatModificado(automotorDTO.getSoat()[i]);
                soatM.setID_RUNTMODIFICACION(idVehiculoModificado);
                // if (resultado)
                resultado = crearSoatModificado(soatM);
            }
            System.out.println(resultado);
            int cantRtm;
            try {
                cantRtm = automotorDTO.getRevisionTecnoMecanica().length;
            } catch (Exception e) {
                cantRtm = 0;
            }
            System.out.println("rtm");
            for (i = 0; i < cantRtm; i++) {
                rtmM = convgenerales.rtmDTOToRtmModificada(automotorDTO.getRevisionTecnoMecanica()[i]);
                rtmM.setID_RUNTMODIFICACION(idVehiculoModificado);
                // if (resultado)
                resultado = crearRTMModificada(rtmM);
            }
            System.out.println(resultado);
            System.out.println("propietarios");
            for (i = 0; i < automotorDTO.getPropietarios().length; i++) {
                propietarioM = convgenerales.propietarioDTOToPropietarioModif(automotorDTO.getPropietarios()[i]);
                propietarioM.setID_RUNTMODIFICACION(idVehiculoModificado);
                // if (resultado)
                resultado = crearPropietarioModificado(propietarioM);
            }
            System.out.println(resultado);
            System.out.println("medidas cautelares");
            int cantMedidas;
            try {
                cantMedidas = automotorDTO.getMedidasCautelares().length;
            } catch (Exception e) {
                cantMedidas = 0;
            }
            for (i = 0; i < cantMedidas; i++) {
                try {
                    medidaCautelarM =
                        convgenerales.medidaCautelarDTOToMedidaCautelarModif(automotorDTO.getMedidasCautelares()[i]);
                } catch (Exception e) {
                }
                medidaCautelarM.setID_RUNTMODIFICACION(idVehiculoModificado);
                //if (resultado)
                resultado = crearMedidaCautelarModificada(medidaCautelarM);
            }
            System.out.println(resultado);
            System.out.println("prendas");
            int cantPrendas;
            try {
                cantPrendas = automotorDTO.getPrendas().length;
            } catch (Exception e) {
                cantPrendas = 0;
            }
            System.out.println(cantPrendas);
            for (i = 0; i < cantPrendas; i++) {
                prendaM = convgenerales.prendaAutomotorDTOToPrendaModificada(automotorDTO.getPrendas()[i]);
                prendaM.setID_RUNTMODIFICACION(idVehiculoModificado);
                //if (resultado)
                resultado = crearPrendaModificada(prendaM);
            }
        } else
            resultado = false;

        if (!resultado)
            eliminarVehiculoConsultado(idModificarAuto, idVehiculoModificado);


        return resultado;
        }catch(Exception e){throw new Exception(e.getMessage());} 
    }*/

    public RuntVehiculoModificado existeVehiculoModificado(RuntVehiculoModificado vehiculoModificado) {
        RuntVehiculoModificadoDao vehiculoModificadoDao = new RuntVehiculoModificadoDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)vehiculoModificadoDao.searchMatching(conn, vehiculoModificado);
            if (lista.size() > 0)
                vehiculoModificado = (RuntVehiculoModificado)lista.get(0);
            else
                vehiculoModificado = null;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return vehiculoModificado;

    }


    public int crearVehiculoModificado(RuntVehiculoModificado vehiculoModificado) {
        int resultado = -1;
        RuntVehiculoModificadoDao runtvehiculomodificadoDao = new RuntVehiculoModificadoDao();
        int id;
        try {
            conn = conexion.conectar();
            id = Funciones.obtenerId(conn, "GEN_VEHICULOMODIFICADO", "GEN_VEHICULOMODIFICADO", myMotor);
            vehiculoModificado.setID_VEHICULOMODIF(id);
            runtvehiculomodificadoDao.create(conn, vehiculoModificado);
            resultado = vehiculoModificado.getID_VEHICULOMODIF();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }

    public boolean actualizarVehiculoModificado(RuntVehiculoModificado vehiculoModificado) {
        boolean resultado = true;
        RuntVehiculoModificadoDao runtvehiculomodificadoDao = new RuntVehiculoModificadoDao();
        try {
            conn = conexion.conectar();
            runtvehiculomodificadoDao.save(conn, vehiculoModificado);
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;

        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }

    public boolean eliminarVehiculoModificado(int id) {
        boolean resultado = true;
        RuntVehiculoModificado vehiculoModificado = new RuntVehiculoModificado();
        vehiculoModificado.setID_VEHICULOMODIF(id);
        RuntVehiculoModificadoDao runtvehiculomodificadoDao = new RuntVehiculoModificadoDao();
        try {
            conn = conexion.conectar();
            runtvehiculomodificadoDao.delete(conn, vehiculoModificado);
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;

        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }

    public int crearModificarAutomotor(RuntModificarAutomotor modificarAutomotor) {
        int resultado = -1;
        RuntModificarAutomotorDao modificarautomotorDao = new RuntModificarAutomotorDao();
        int id;
        try {
            conn = conexion.conectar();
            id = Funciones.obtenerId(conn, "GEN_RUNTMODIFICARAUTOMOTOR", "GEN_RUNTMODIFICARAUTOMOTOR", myMotor);
            modificarAutomotor.setID_MODIFICARRUNT(id);
            modificarautomotorDao.create(conn, modificarAutomotor);
            resultado = modificarAutomotor.getID_MODIFICARRUNT();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }

    public boolean actualizarModificarAutomotor(RuntModificarAutomotor modificarAutomotor) {
        boolean resultado = true;
        RuntModificarAutomotorDao modificarautomotorDao = new RuntModificarAutomotorDao();
        try {
            conn = conexion.conectar();
            modificarautomotorDao.save(conn, modificarAutomotor);
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;

        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }

    public boolean eliminarVehiculoConsultado(int idv, int idm) {
        boolean resultado = false;
        eliminarModificarAutomotor(idm);
        eliminarVehiculoModificado(idv);

        return resultado;
    }

    public RuntModificarAutomotor consultarModificacion(RuntModificarAutomotor modificarAutomotor) {
        List lista = null;
        RuntModificarAutomotorDao modificarautomotorDao = new RuntModificarAutomotorDao();
        try {
            conn = conexion.conectar();
            lista = modificarautomotorDao.searchMatching(conn, modificarAutomotor);
            if (lista != null && lista.size() > 0)
                modificarAutomotor = (RuntModificarAutomotor)lista.get(0);
            else
                modificarAutomotor = null;
        } catch (Exception e) {
            e.printStackTrace();
            modificarAutomotor = null;

        } finally {
            conexion.cerrarCx();
        }
        return modificarAutomotor;
    }

    public boolean eliminarModificarAutomotor(int id) {
        boolean resultado = true;
        RuntModificarAutomotor modificarAutomotor = new RuntModificarAutomotor();
        modificarAutomotor.setID_MODIFICARRUNT(id);
        RuntModificarAutomotorDao modificarautomotorDao = new RuntModificarAutomotorDao();
        try {
            conn = conexion.conectar();
            modificarautomotorDao.delete(conn, modificarAutomotor);
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;

        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }

    public boolean crearCombustibleModificado(RuntCombustibleModificado combustibleModificado) {
        boolean resultado = true;
        RuntCombustibleModificadoDao combustibleModificadoDao = new RuntCombustibleModificadoDao();
        int id;
        try {
            conn = conexion.conectar();
            id = Funciones.obtenerId(conn, "GEN_COMBUSTIBLEMODIFICADO", "GEN_COMBUSTIBLEMODIFICADO", myMotor);
            System.out.println(id);
            combustibleModificado.setID_RUNTCOMBMODIFICADO(id);
            combustibleModificadoDao.create(conn, combustibleModificado);
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;

        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }

    public boolean actualizarCombustibleModificado(RuntCombustibleModificado combustibleModificado) {
        boolean resultado = true;
        RuntCombustibleModificadoDao combustibleModificadoDao = new RuntCombustibleModificadoDao();
        try {
            conn = conexion.conectar();
            combustibleModificadoDao.save(conn, combustibleModificado);
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;

        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }

    public boolean eliminarCombustibleModificado(RuntCombustibleModificado combustibleModificado) {
        boolean resultado = true;
        RuntCombustibleModificadoDao combustibleModificadoDao = new RuntCombustibleModificadoDao();
        try {
            conn = conexion.conectar();
            combustibleModificadoDao.delete(conn, combustibleModificado);
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;

        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }

    public boolean crearPrendaModificada(RuntPrendaModificada prendaModificada) {
        boolean resultado = true;
        RuntPrendaModificadaDao prendaModificadaDao = new RuntPrendaModificadaDao();
        int id;
        System.out.println("creando prenda");
        try {
            conn = conexion.conectar();
            id = Funciones.obtenerId(conn, "GEN_PRENDAMODIFICADA", "GEN_PRENDAMODIFICADA", myMotor);
            prendaModificada.setID_PRENDAMODIFICADA(id);
            prendaModificadaDao.create(conn, prendaModificada);
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;

        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }

    public boolean actualizarPrendaModificada(RuntPrendaModificada prendaModificada) {
        boolean resultado = true;
        RuntPrendaModificadaDao prendaModificadaDao = new RuntPrendaModificadaDao();
        try {
            conn = conexion.conectar();
            prendaModificadaDao.save(conn, prendaModificada);
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;

        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }

    public boolean eliminarPrendaModificada(RuntPrendaModificada prendaModificada) {
        boolean resultado = true;
        RuntPrendaModificadaDao prendaModificadaDao = new RuntPrendaModificadaDao();
        try {
            conn = conexion.conectar();
            prendaModificadaDao.delete(conn, prendaModificada);
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;

        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }

    public boolean crearMedidaCautelarModificada(RuntMedidaCautelarModificada medidaCautelarModificada) {
        boolean resultado = true;
        RuntMedidaCautelarModificadaDao medidaCautelarModificadaDao = new RuntMedidaCautelarModificadaDao();
        int id;
        try {
            conn = conexion.conectar();
            id = Funciones.obtenerId(conn, "GEN_MEDCAUTELARMODIFICADA", "GEN_MEDCAUTELARMODIFICADA", myMotor);
            medidaCautelarModificada.setID_MEDCAUTELARMODIF(id);
            medidaCautelarModificadaDao.create(conn, medidaCautelarModificada);
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;

        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }

    public boolean actualizarMedidaCautelarModificada(RuntMedidaCautelarModificada medidaCautelarModificada) {
        boolean resultado = true;
        RuntMedidaCautelarModificadaDao medidaCautelarModificadaDao = new RuntMedidaCautelarModificadaDao();
        try {
            conn = conexion.conectar();
            medidaCautelarModificadaDao.save(conn, medidaCautelarModificada);
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;

        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }

    public boolean eliminarMedidaCautelarModificada(RuntMedidaCautelarModificada medidaCautelarModificada) {
        boolean resultado = true;
        RuntMedidaCautelarModificadaDao medidaCautelarModificadaDao = new RuntMedidaCautelarModificadaDao();
        try {
            conn = conexion.conectar();
            medidaCautelarModificadaDao.delete(conn, medidaCautelarModificada);
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;

        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }

    public boolean crearPropietarioModificado(RuntPropietarioModificado propietarioModificado) {
        boolean resultado = true;
        RuntPropietarioModificadoDao propietarioModificadaDao = new RuntPropietarioModificadoDao();
        int id;
        try {
            conn = conexion.conectar();
            id = Funciones.obtenerId(conn, "GEN_PROPIETARIOMODIF", "GEN_PROPIETARIOMODIF", myMotor);
            propietarioModificado.setID_PROPIETARIOMODIF(id);
            propietarioModificadaDao.create(conn, propietarioModificado);
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;

        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }

    public boolean actualizarPropietarioModificado(RuntPropietarioModificado propietarioModificado) {
        boolean resultado = true;
        RuntPropietarioModificadoDao propietarioModificadaDao = new RuntPropietarioModificadoDao();
        try {
            conn = conexion.conectar();
            propietarioModificadaDao.save(conn, propietarioModificado);
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;

        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }

    public boolean eliminarPropietarioModificado(RuntPropietarioModificado propietarioModificado) {
        boolean resultado = true;
        RuntPropietarioModificadoDao propietarioModificadaDao = new RuntPropietarioModificadoDao();
        try {
            conn = conexion.conectar();
            propietarioModificadaDao.delete(conn, propietarioModificado);
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;

        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }

    public boolean crearSoatModificado(RuntSoatModificado soatModificado) {
        boolean resultado = true;
        RuntSoatModificadoDao soatModificadoDao = new RuntSoatModificadoDao();
        int id;
        try {
            conn = conexion.conectar();
            id = Funciones.obtenerId(conn, "GEN_ID_RUNTSOATMODIFICADO", "GEN_RUNTSOATMODIFICADO", myMotor);
            soatModificado.setID_RUNTSOATMODIFICADO(id);
            soatModificadoDao.create(conn, soatModificado);
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;

        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }

    public boolean actualizarSoatModificado(RuntSoatModificado soatModificado) {
        boolean resultado = true;
        RuntSoatModificadoDao soatModificadoDao = new RuntSoatModificadoDao();
        try {
            conn = conexion.conectar();
            soatModificadoDao.save(conn, soatModificado);
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;

        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }

    public boolean eliminarSoatModificado(RuntSoatModificado soatModificado) {
        boolean resultado = true;
        RuntSoatModificadoDao soatModificadoDao = new RuntSoatModificadoDao();
        try {
            conn = conexion.conectar();
            soatModificadoDao.delete(conn, soatModificado);
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;

        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }

    public boolean crearRTMModificada(RuntRTMModificada rtmModificada) {
        boolean resultado = true;
        RuntRTMModificadaDao rtmModificadaDao = new RuntRTMModificadaDao();
        int id;
        try {
            conn = conexion.conectar();
            id = Funciones.obtenerId(conn, "GEN_ID_RUNTRTMMODIFICADA", "GEN_RUNTRTMMODIFICADA", myMotor);
            rtmModificada.setID_RUNTRTMMODIFICADA(id);
            rtmModificadaDao.create(conn, rtmModificada);
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;

        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }

    public boolean actualizarRTMModificada(RuntRTMModificada rtmModificada) {
        boolean resultado = true;
        RuntRTMModificadaDao rtmModificadaDao = new RuntRTMModificadaDao();
        try {
            conn = conexion.conectar();
            rtmModificadaDao.save(conn, rtmModificada);
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;

        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }

    public boolean eliminarRTMModificada(RuntRTMModificada rtmModificada) {
        boolean resultado = true;
        RuntRTMModificadaDao rtmModificadaDao = new RuntRTMModificadaDao();
        try {
            conn = conexion.conectar();
            rtmModificadaDao.delete(conn, rtmModificada);
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;

        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }

    public RuntVehiculoModificado getVehiculoModificado(RuntVehiculoModificado vehiculoModificado) {
        List lista = null;
        RuntVehiculoModificadoDao runtvehiculomodificadoDao = new RuntVehiculoModificadoDao();
        try {
            conn = conexion.conectar();
            lista = runtvehiculomodificadoDao.searchMatching(conn, vehiculoModificado);
            if (lista.size() > 0)
                vehiculoModificado = (RuntVehiculoModificado)lista.get(0);
        } catch (Exception e) {
            e.printStackTrace();


        } finally {
            conexion.cerrarCx();
        }
        return vehiculoModificado;
    }

    public List getCombustiblesModificado(RuntCombustibleModificado combustibleModificado) {
        List lista = null;
        RuntCombustibleModificadoDao combustibleModificadoDao = new RuntCombustibleModificadoDao();
        try {
            conn = conexion.conectar();
            lista = combustibleModificadoDao.searchMatching(conn, combustibleModificado);
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getPropietariosModificado(RuntPropietarioModificado propietarioModificado) {
        List lista = null;
        RuntPropietarioModificadoDao propietarioModificadaDao = new RuntPropietarioModificadoDao();
        try {
            conn = conexion.conectar();
            lista = propietarioModificadaDao.searchMatching(conn, propietarioModificado);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getPrendaModificada(RuntPrendaModificada prendaModificada) {
        List lista = null;
        RuntPrendaModificadaDao prendaModificadaDao = new RuntPrendaModificadaDao();
        try {
            conn = conexion.conectar();
            lista = prendaModificadaDao.searchMatching(conn, prendaModificada);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getMedidasCautelaresModificada(RuntMedidaCautelarModificada medidaCautelarModificada) {
        List lista = null;
        RuntMedidaCautelarModificadaDao medidaCautelarModificadaDao = new RuntMedidaCautelarModificadaDao();
        try {
            conn = conexion.conectar();
            lista = medidaCautelarModificadaDao.searchMatching(conn, medidaCautelarModificada);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getSoatModificado(RuntSoatModificado soatModificado) {
        List lista = null;
        RuntSoatModificadoDao soatModificadoDao = new RuntSoatModificadoDao();
        try {
            conn = conexion.conectar();
            lista = soatModificadoDao.searchMatching(conn, soatModificado);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getRTMModificada(RuntRTMModificada rtmModificada) {
        List lista = null;
        RuntRTMModificadaDao rtmModificadaDao = new RuntRTMModificadaDao();
        try {
            conn = conexion.conectar();
            lista = rtmModificadaDao.searchMatching(conn, rtmModificada);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public String getFechaServidor() {
        Funciones funciones = new Funciones();

        return funciones.getFechaSistema(null, myMotor);
    }

    public String getFechaHoraServidor() {
        Funciones funciones = new Funciones();
        return funciones.getFechaHoraSistema(myMotor);
    }

    public RuntSoatModificado getSoatModificadoActivo(RuntSoatModificado soatModificado) {
        RuntSoatModificadoDao soatModificadoDao = new RuntSoatModificadoDao();
        try {
            conn = conexion.conectar();
            soatModificadoDao.getActivo(conn, soatModificado);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return soatModificado;
    }

    public RuntCombustibleModificado getCombustiblesModificadoActivo(RuntCombustibleModificado combustibleModificado) {
        List lista = null;
        RuntCombustibleModificadoDao combustibleModificadoDao = new RuntCombustibleModificadoDao();
        combustibleModificado.setESTADO("ACTIVO");
        try {
            conn = conexion.conectar();
            lista = combustibleModificadoDao.searchMatching(conn, combustibleModificado);
            if (lista != null && lista.size() > 0)
                combustibleModificado = (RuntCombustibleModificado)lista.get(0);
            else
                combustibleModificado.setID_RUNTCOMBMODIFICADO(-1);
        } catch (Exception e) {
            e.printStackTrace();


        } finally {
            conexion.cerrarCx();
        }
        return combustibleModificado;
    }


    /*public boolean copyVehiculoModToLocal(RuntVehiculoModificado vehiculoModificado) throws Exception {
        try{
        int i;
        conversionGenerales conversionesgenerales = new conversionGenerales();
        GestionServiciosVehiculosLocal gestionServiciosVehiculosLoc = new GestionServiciosVehiculosLocal();

        List propietariosM = null;
        RuntPropietarioModificado propietarioModificado = new RuntPropietarioModificado();
        RuntMedidaCautelarModificada medidaCautelarM = new RuntMedidaCautelarModificada();
        Vehiculo vehiculo = new Vehiculo();

        J_Pendiente medidaC = new J_Pendiente();
        boolean resultado = false;
        vehiculo = conversionesgenerales.vehiculoModToVehiculo(vehiculoModificado);
        vehiculo = gestionServiciosVehiculosLoc.crearVehiculo(vehiculo, -1, "127.0.0.1", "Servidor");
        propietarioModificado.setID_RUNTMODIFICACION(vehiculoModificado.getID_VEHICULOMODIF());
        propietariosM = getPropietariosModificado(propietarioModificado);
        for (i = 0; i < propietariosM.size(); i++) {
            propietarioModificado = (RuntPropietarioModificado)propietariosM.get(i);
            try{
            setPropietarioVehiculo(propietarioModificado, vehiculo);
            }catch(Exception e){throw new Exception(e.getMessage());}
        }


        return resultado;
        }catch(Exception e){throw new Exception(e.getMessage());} 
    }


    public void setPropietarioVehiculo(RuntPropietarioModificado propietarioModificado, Vehiculo vehiculo) throws Exception {
        PropietarioDeVehiculo propietarioVehiculo = new PropietarioDeVehiculo();
        GestionServiciosEmpresasLocal gestionEmpresas = new GestionServiciosEmpresasLocal();
        GestionServiciosPersonasLocal gestionPersonas = new GestionServiciosPersonasLocal();
        conversionGenerales conversionesgenerales = new conversionGenerales();
        Persona persona = new Persona();
        Empresa empresa = new Empresa();
        propietarioVehiculo.setPLACA(vehiculo.getPLACA());
        propietarioVehiculo.setFECHA(propietarioModificado.getFECHAINICIOPROPIEDAD());
        propietarioVehiculo.setESTADO(String.valueOf(propietarioModificado.getID_ESTADO()));
        //propietarioVehiculo.setID_VEHICULO(vehiculo.getID_VEHICULO());
        propietarioVehiculo.setID_TIPOPROPIEDAD(propietarioModificado.getID_TIPOPROPIEDAD());
        propietarioVehiculo.setPORCENTAJEPROPIEDAD(propietarioModificado.getPORCENTAJEPROPIEDAD());
        propietarioVehiculo.setPROINDIVISO(propietarioModificado.getPROINDIVISO());
        propietarioVehiculo.setFECHAFINPROPIEDAD(propietarioModificado.getFECHAFINPROPIEDAD());
        if (propietarioModificado.getTIPOPERSONAPROPIETARIO() == "PERSONA NATURAL") {
            persona.setID_DOCTO(propietarioModificado.getID_DOCTOPROPIETARIO());
            persona.setIDENTIFICACION(propietarioModificado.getNRODOCTOPROPIETARIO());
            try{
            persona = gestionPersonas.getPersona(persona);
            }catch(Exception e){throw new Exception (e.getMessage());}
            if (persona.getID_PERSONAS() == -1) {
                persona = null;
                persona = new Persona();
                persona = conversionesgenerales.propietarioModToPersona(propietarioModificado);
                try{
                persona = gestionPersonas.crearPersona(persona);
                }catch(Exception e){throw new Exception(e.getMessage()); }
            }
            propietarioVehiculo.setID_PROPIETARIO(persona.getID_PERSONAS());
            propietarioVehiculo.setEMPPER("PER");
        }
        if (propietarioModificado.getTIPOPERSONAPROPIETARIO() == "PERSONA JURIDICA") {
            empresa.setID_DOCTO(propietarioModificado.getID_DOCTOPROPIETARIO());
            empresa.setNIT(propietarioModificado.getNRODOCTOPROPIETARIO());
            empresa = gestionEmpresas.getEmpresaPorId(empresa);
            if (empresa.getID_EMPRESA() == -1) {
                empresa = null;
                empresa = new Empresa();
                empresa = conversionesgenerales.propietariomodToEmpresa(propietarioModificado);
                empresa = gestionEmpresas.crearEmpresa(empresa);
            }
            propietarioVehiculo.setID_PROPIETARIO(empresa.getID_EMPRESA());
            propietarioVehiculo.setEMPPER("EMP");
        }
    }*/


    public VehiculoRadicadoCta getRadicadoCuentaVehiculo(VehiculoRadicadoCta myVehiRadiCta) {
        List lista;
        try {
            conn = conexion.conectar();
            VehiculoRadicadoCtaDao myVehiRadiCtaDao = new VehiculoRadicadoCtaDao();
            lista = myVehiRadiCtaDao.searchMatching(conn, myVehiRadiCta);
            if (lista != null && lista.size() > 0)
                myVehiRadiCta = (VehiculoRadicadoCta)lista.get(0);
            else
                myVehiRadiCta = null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        } finally {
            conexion.cerrarCx();
        }
        return myVehiRadiCta;
    }


    public boolean actualizarRadicadoCuentaVehiculo(VehiculoRadicadoCta myVehiRadiCta) {
        boolean result = false;
        try {
            conn = conexion.conectar();
            VehiculoRadicadoCtaDao myVehiRadiCtaDao = new VehiculoRadicadoCtaDao();
            myVehiRadiCtaDao.save(conn, myVehiRadiCta);
            result = true;

        } catch (Exception e) {
            e.printStackTrace();
            result = false;

        } finally {
            conexion.cerrarCx();
        }
        return result;
    }


    public VehiculoRadicadoCta crearRadicadoCuentaVehiculo(VehiculoRadicadoCta myVehiRadiCta) {
        int id;
        List lista;
        try {
            conn = conexion.conectar();
            VehiculoRadicadoCtaDao myVehiRadiCtaDao = new VehiculoRadicadoCtaDao();
            id = Funciones.obtenerId(conn, "GEN_VEHRADCTA", "GEN_VEHRADCTA", myMotor);
            myVehiRadiCta.setID_VEHRADCTA(id);
            myVehiRadiCta.setFECHAREG(Funciones.getHoraSistemaString(conn));
            myVehiRadiCta.setHORAREG(Funciones.getHoraSistemaString(conn));
            myVehiRadiCtaDao.create(conn, myVehiRadiCta);
            myVehiRadiCta = new VehiculoRadicadoCta();
            myVehiRadiCta.setID_VEHRADCTA(id);
            lista = myVehiRadiCtaDao.searchMatching(conn, myVehiRadiCta);
            if (lista != null && lista.size() > 0)
                myVehiRadiCta = (VehiculoRadicadoCta)lista.get(0);
            else
                myVehiRadiCta = null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        } finally {
            conexion.cerrarCx();
        }
        return myVehiRadiCta;
    }

}
