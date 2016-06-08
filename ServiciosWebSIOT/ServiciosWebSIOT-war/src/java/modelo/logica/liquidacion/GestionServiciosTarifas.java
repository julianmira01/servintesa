package modelo.logica.liquidacion;

import java.sql.Connection;

import java.util.ArrayList;
import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.liquidacion.tarifas.LVigenciasDao;
import modelo.datos.dao.liquidacion.tarifas.LconceptosCobroDao;
import modelo.datos.dao.liquidacion.tarifas.LtarifasDao;
import modelo.datos.dao.liquidacion.tarifas.LtarifasDetDao;
import modelo.datos.dao.liquidacion.tarifas.LtipoConceptoDao;
import modelo.datos.dao.liquidacion.tarifas.ViewDetalleTarifaDao;
import modelo.datos.dao.tramites.TramiteinternoDao;
import modelo.datos.objetos.generales.AuditoriaSystem;
import modelo.datos.objetos.liquidacion.tarifas.LVigencias;
import modelo.datos.objetos.liquidacion.tarifas.LconceptosCobro;
import modelo.datos.objetos.liquidacion.tarifas.Ltarifas;
import modelo.datos.objetos.liquidacion.tarifas.LtarifasDet;
import modelo.datos.objetos.liquidacion.tarifas.LtipoConcepto;
import modelo.datos.objetos.liquidacion.tarifas.ViewDetalleTarifa;
import modelo.datos.objetos.tramites.Tramiteinterno;

import utilidades.Auditoria;
import utilidades.Funciones;


public class GestionServiciosTarifas {

    Conexion conexion;
    Connection conn;
    String myMotor;

    public GestionServiciosTarifas() {
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
    }

    public boolean crearTarifas(Ltarifas ltarifas, int idUsuario, String myIp, String myHost) {
        boolean resultado;
        resultado = false;
        LtarifasDao myLtarifasDao = new LtarifasDao();
        //Campos para la auditoria
        Auditoria myAuditoria;
        AuditoriaSystem myAuditSx;
        //--Campos para la auditoria
        int id = 0;

        try {
            conn = conexion.conectar();
            id = Funciones.obtenerId(conn, "GEN_L_TARIFAS_LT_ID", "GEN_L_TARIFAS", myMotor);
            ltarifas.setLT_ID(id);
            myLtarifasDao.create(conn, ltarifas);
            //Pasos para la auditoria
            myAuditoria = new Auditoria();
            myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("L_TARIFAS");
            myAuditSx.setCAMPOCLAVE("LT_ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(id));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, ltarifas, 0);
            //-- para la auditoria
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myLtarifasDao = null;
        }
        return resultado;
    }

    public boolean editarTarifa(Ltarifas ltarifas, int idUsuario, String myIp, String myHost) {
        boolean resultado;
        resultado = false;
        List lista;
        //Campos para la auditoria
        Ltarifas anterior;
        Auditoria myAuditoria;
        AuditoriaSystem myAuditSx;
        //--Campos para la auditoria
        LtarifasDao myLtarifasDao = new LtarifasDao();
        try {
            conn = conexion.conectar();
            //Pasos previos Auditoria
            anterior = new Ltarifas();
            anterior.setLT_ID(ltarifas.getLT_ID());
            lista = myLtarifasDao.searchMatching(conn, anterior);
            if (lista != null && lista.size() > 0) {
                anterior = (Ltarifas)lista.get(0);
            } else {
                anterior = null;
            }
            //Pasos previos para auditoria
            myLtarifasDao.save(conn, ltarifas);
            //Pasos para la auditoria
            myAuditoria = new Auditoria();
            myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("L_TARIFAS");
            myAuditSx.setCAMPOCLAVE("LT_ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(ltarifas.getLT_ID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEdicion(conn, myAuditSx, anterior, ltarifas, myIp, myHost, 0);
            //-- para la auditoria
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myLtarifasDao = null;
        }
        return resultado;
    }

    public List getLtarifas(Ltarifas ltarifas) {
        List lista;
        lista = null;
        try {
            conn = conexion.conectar();
            LtarifasDao myLtarifasDao = new LtarifasDao();
            lista = myLtarifasDao.searchMatching(conn, ltarifas);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getLtarifasPorVigencia(Ltarifas ltarifas, int vigenciaInicial, int vigenciaFinal) {
        List lista;
        lista = null;
        try {
            conn = conexion.conectar();
            LtarifasDao myLtarifasDao = new LtarifasDao();
            lista = myLtarifasDao.buscarPorVigencia(conn, ltarifas, vigenciaInicial, vigenciaFinal);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getLTtarifas() {
        List lista;
        lista = null;
        try {
            conn = conexion.conectar();
            LtarifasDao myLtarifasDao = new LtarifasDao();
            lista = myLtarifasDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public boolean eliminarTarifas(Ltarifas ltarifas, int idUsuario, String myIp, String myHost) {
        boolean resultado;
        resultado = false;
        List lista;
        //Campos para la auditoria
        Ltarifas anterior;
        Auditoria myAuditoria;
        AuditoriaSystem myAuditSx;
        //--Campos para la auditoria
        LtarifasDao myLtarifasDao = new LtarifasDao();
        try {
            conn = conexion.conectar();
            //Pasos previos Auditoria
            anterior = new Ltarifas();
            anterior.setLT_ID(ltarifas.getLT_ID());
            lista = myLtarifasDao.searchMatching(conn, anterior);
            if (lista != null && lista.size() > 0) {
                anterior = (Ltarifas)lista.get(0);
            } else {
                anterior = null;
            }
            //Pasos previos para auditoria
            myLtarifasDao.delete(conn, ltarifas);
            //Pasos para la auditoria
            myAuditoria = new Auditoria();
            myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("L_TARIFAS");
            myAuditSx.setCAMPOCLAVE("LT_ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(ltarifas.getLT_ID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEliminacion(conn, myAuditSx, anterior, 0);
            //-- para la auditoria
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myLtarifasDao = null;
        }
        return resultado;
    }

    public List getTramitesInternos(Tramiteinterno tramiteinterno) {
        List lista = null;
        TramiteinternoDao myTramiteinternoDao = new TramiteinternoDao();
        try {
            conn = conexion.conectar();
            lista = (ArrayList)myTramiteinternoDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public boolean crearConceptos(LconceptosCobro lconceptoscobro) {
        boolean resultado;
        resultado = false;
        LconceptosCobroDao myLconceptosCobroDao = new LconceptosCobroDao();
        int id = 0;

        try {
            conn = conexion.conectar();
            id = Funciones.obtenerId(conn, "GEN_L_CONCEPTOSCOBRO_LCC_ID", "GEN_L_CONCEPTOSCOBRO", myMotor);
            lconceptoscobro.setLCC_ID(id);
            myLconceptosCobroDao.create(conn, lconceptoscobro);
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myLconceptosCobroDao = null;
        }
        return resultado;
    }

    public List getLconceptos() {
        List lista = null;
        LconceptosCobroDao myLconceptosCobroDao = new LconceptosCobroDao();
        try {
            conn = conexion.conectar();
            lista = (ArrayList)myLconceptosCobroDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public LconceptosCobro getLconceptosId(LconceptosCobro lconceptoscobro) {
        LconceptosCobroDao myLconceptosCobroDao = new LconceptosCobroDao();
        try {
            conn = conexion.conectar();
            myLconceptosCobroDao.load(conn, lconceptoscobro);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lconceptoscobro;
    }

    public List getLTconceptos(LconceptosCobro lconceptoscobro) {
        List lista;
        lista = null;
        try {
            conn = conexion.conectar();
            LconceptosCobroDao myLconceptosCobroDao = new LconceptosCobroDao();
            lista = myLconceptosCobroDao.searchMatching(conn, lconceptoscobro);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getLtipoConceptos(LtipoConcepto ltipoconcepto) {
        List lista = null;
        LtipoConceptoDao myLtipoConceptoDao = new LtipoConceptoDao();
        try {
            conn = conexion.conectar();
            lista = (ArrayList)myLtipoConceptoDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public boolean crearDetTarifas(LtarifasDet ltarifasdet, int idUsuario, String myIp, String myHost) {
        boolean resultado;
        resultado = false;
        LtarifasDetDao myLtarifasDetDao = new LtarifasDetDao();
        int id = 0;

        try {
            conn = conexion.conectar();
            id = Funciones.obtenerId(conn, "GEN_L_TARIFASDET_LTD_ID", "GEN_L_TARIFASDET", myMotor);
            ltarifasdet.setLTD_ID(id);
            myLtarifasDetDao.create(conn, ltarifasdet);
            resultado = true;
            //auditar insert
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("L_TARIFASDET");
            myAuditSx.setCAMPOCLAVE("LTD_ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(ltarifasdet.getLTD_ID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, ltarifasdet, 0);

        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myLtarifasDetDao = null;
        }
        return resultado;
    }

    public boolean editarDetTarifa(LtarifasDet ltarifasdet, int idUsuario, String myIp, String myHost) {
        boolean resultado;
        resultado = false;
        LtarifasDetDao myLtarifasDetDao = new LtarifasDetDao();
        try {
            conn = conexion.conectar();
            //auditar edicion
            LtarifasDet ant = new LtarifasDet();
            ant.setLTD_ID(ltarifasdet.getLTD_ID());
            myLtarifasDetDao.load(conn, ant);
            myLtarifasDetDao.save(conn, ltarifasdet);
            resultado = true;
            //auditar edicion
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("L_TARIFASDET");
            myAuditSx.setCAMPOCLAVE("LTD_ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(ltarifasdet.getLTD_ID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEdicion(conn, myAuditSx, ant, ltarifasdet, myIp, myHost, 0);

        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myLtarifasDetDao = null;
        }
        return resultado;
    }

    public boolean eliminarDetTarifa(LtarifasDet ltarifasdet, int idUsuario, String myIp, String myHost) {
        boolean resultado;
        resultado = false;
        LtarifasDetDao myLtarifasDetDao = new LtarifasDetDao();
        try {
            conn = conexion.conectar();
            myLtarifasDetDao.delete(conn, ltarifasdet);
            resultado = true;
            //auditar eliminar
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("L_TARIFASDET");
            myAuditSx.setCAMPOCLAVE("LTD_ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(ltarifasdet.getLTD_ID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEliminacion(conn, myAuditSx, ltarifasdet, 0);

        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myLtarifasDetDao = null;
        }
        return resultado;
    }

    public List getLtarifasDet(ViewDetalleTarifa viewdetalletarifa) {
        List lista;
        lista = null;
        try {
            conn = conexion.conectar();
            ViewDetalleTarifaDao myViewDetalleTarifaDao = new ViewDetalleTarifaDao();
            lista = myViewDetalleTarifaDao.searchMatching(conn, viewdetalletarifa);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public ViewDetalleTarifa getLtarifaDetId(ViewDetalleTarifa viewdetalletarifa) {
        ViewDetalleTarifaDao myViewDetalleTarifaDao = new ViewDetalleTarifaDao();
        try {
            conn = conexion.conectar();
            myViewDetalleTarifaDao.load(conn, viewdetalletarifa);
        } catch (Exception e) {
            e.printStackTrace();
            ;
            viewdetalletarifa.setLCC_ID(-1);
        } finally {
            conexion.cerrarCx();
        }
        return viewdetalletarifa;
    }

    public List getLTvigencias(LVigencias lvigencia) {
        List lista = null;
        LVigenciasDao myLVigenciasDao = new LVigenciasDao();
        try {
            conn = conexion.conectar();
            lista = (ArrayList)myLVigenciasDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public LVigencias getLVigenciasId(LVigencias lvigencia) {
        LVigenciasDao myLVigenciasDao = new LVigenciasDao();
        try {
            conn = conexion.conectar();
            myLVigenciasDao.load(conn, lvigencia);
        } catch (Exception e) {
            e.printStackTrace();
            ;
            lvigencia.setLTV_ID(-1);
        } finally {
            conexion.cerrarCx();
        }
        return lvigencia;
    }

    public List getLVigencias(LVigencias lvigencia) {
        List lista;
        lista = null;
        try {
            conn = conexion.conectar();
            LVigenciasDao myLVigenciasDao = new LVigenciasDao();
            lista = myLVigenciasDao.searchMatching(conn, lvigencia);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }


    public boolean crearLVigencias(LVigencias lvigencia, int idUsuario, String myIp, String myHost) {
        boolean resultado;
        resultado = false;
        LVigenciasDao myLVigenciasDao = new LVigenciasDao();
        int id = 0;

        try {
            conn = conexion.conectar();
            id = Funciones.obtenerId(conn, "LT_VIGENCIAS_GEN", "GEN_LT_VIGENCIAS", myMotor);
            lvigencia.setLTV_ID(id);
            myLVigenciasDao.create(conn, lvigencia);
            resultado = true;
            //auditar insert
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("LT_VIGENCIAS");
            myAuditSx.setCAMPOCLAVE("LTV_ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(lvigencia.getLTV_ID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, lvigencia, 0);

        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myLVigenciasDao = null;
        }
        return resultado;
    }


    public boolean crearLVigenciasConReplica(LVigencias lvigencia, int numvigenciaant, int idUsuario, String myIp,
                                             String myHost) {
        boolean resultado;
        resultado = false;
        LVigenciasDao myLVigenciasDao = new LVigenciasDao();
        int id = 0;

        try {
            conn = conexion.conectar();
            id = Funciones.obtenerId(conn, "LT_VIGENCIAS_GEN", "GEN_LT_VIGENCIAS", myMotor);
            lvigencia.setLTV_ID(id);
            myLVigenciasDao.create(conn, lvigencia);
            resultado = true;


            //Aqui crear tarifas y conceptos de la vigencia con respecto a la anterior
            List result = null;

            LVigencias vigenciaant = new LVigencias();
            vigenciaant.setLTV_VIGENCIA(numvigenciaant);
            vigenciaant.setLTV_TIPO(lvigencia.getLTV_TIPO());
            result = myLVigenciasDao.searchMatching(conn, vigenciaant);
            if (result != null && result.size() > 0) {
                LtarifasDao myLTarifasdao = new LtarifasDao();
                LtarifasDetDao myLTarifasdetdato = new LtarifasDetDao();
                Ltarifas myLTarifas = new Ltarifas();
                LtarifasDet myLTarifasdet = new LtarifasDet();

                vigenciaant = (LVigencias)result.get(0); //Obteniendo vigencia base para replica
                List listatarifas = null;
                myLTarifas.setLT_VIGENCIA(vigenciaant.getLTV_VIGENCIA());
                myLTarifas.setLT_TIPO(vigenciaant.getLTV_TIPO());

                listatarifas =
                        myLTarifasdao.searchMatching(conn, myLTarifas); //Obteniendo tarifas de vigencia anterior
                
                
                if (listatarifas != null && listatarifas.size() > 0) {
                    for (int i = 0; i < listatarifas.size(); i++) {
                        Ltarifas temptarifa = new Ltarifas();
                        temptarifa = (Ltarifas)listatarifas.get(i);  
                        int idviejo = temptarifa.getLT_ID();
                        List listadettarifa = null;
                         //Obteniendo detalle de la tarifa
                         myLTarifasdet = new LtarifasDet();
                         myLTarifasdet.setLTD_LT_ID(idviejo);
                        myLTarifasdet.setLTD_DESCONTABLE(-1);
                        listadettarifa = myLTarifasdetdato.searchMatching(conn, myLTarifasdet);
                                                     
                                                                                         
                        temptarifa.setLT_VIGENCIA(lvigencia.getLTV_VIGENCIA());//Asignando a nueva vigencia creada
                        int idnuevo = Funciones.obtenerId(conn, "GEN_L_TARIFAS_LT_ID", "GEN_L_TARIFAS", myMotor);
                        temptarifa.setLT_ID(idnuevo);       
                        String nombretarifa = "";
                        nombretarifa = temptarifa.getLT_NOMBRE();
                        nombretarifa = nombretarifa.replaceAll(String.valueOf(numvigenciaant),String.valueOf(temptarifa.getLT_VIGENCIA()));
                        temptarifa.setLT_NOMBRE(nombretarifa);                       
                        myLTarifasdao.create(conn, temptarifa);
                          if(listadettarifa!=null && listadettarifa.size()>0)
                          {
                            for(int j=0;j<listadettarifa.size();j++)
                            {
                               myLTarifasdet = (LtarifasDet)listadettarifa.get(j);           
                               myLTarifasdet.setLTD_ID(Funciones.obtenerId(conn, "GEN_L_TARIFASDET_LTD_ID", "GEN_L_TARIFASDET", myMotor));  
                               myLTarifasdet.setLTD_LT_ID(idnuevo);   
                               myLTarifasdetdato.create(conn, myLTarifasdet);                             
                            }
                                                            
                          }
                                                                         
                                                              
                    }
                }


            }


            //***********************************************************************
            //auditar insert
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("LT_VIGENCIAS");
            myAuditSx.setCAMPOCLAVE("LTV_ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(lvigencia.getLTV_ID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, lvigencia, 0);


        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myLVigenciasDao = null;
        }
        return resultado;
    }

    public boolean editarLVigencias(LVigencias lvigencia, int idUsuario, String myIp, String myHost) {
        boolean resultado;
        resultado = false;
        LVigenciasDao myLVigenciasDao = new LVigenciasDao();
        try {
            conn = conexion.conectar();
            //auditar edicion
            LVigencias ant = new LVigencias();
            ant.setLTV_ID(lvigencia.getLTV_ID());
            myLVigenciasDao.load(conn, ant);
            myLVigenciasDao.save(conn, lvigencia);
            resultado = true;
            //auditar edicion
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("LT_VIGENCIAS");
            myAuditSx.setCAMPOCLAVE("LTV_ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(lvigencia.getLTV_ID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEdicion(conn, myAuditSx, ant, lvigencia, myIp, myHost, 0);

        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myLVigenciasDao = null;
        }
        return resultado;
    }

}
