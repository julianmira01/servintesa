package modelo.logica.transportepublico;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.transportepublico.cupos.CuposTaxisTransDao;
import modelo.datos.dao.transportepublico.cupos.DetalleRangoCupoTransDao;
import modelo.datos.dao.transportepublico.cupos.EmpresasdeServicioTransDao;
import modelo.datos.dao.transportepublico.cupos.HistoricoCupoTransDao;
import modelo.datos.dao.transportepublico.cupos.InventarioCuposTransDao;
import modelo.datos.dao.transportepublico.cupos.RangoCuposVehiculoPublicoTransDao;
import modelo.datos.dao.transportepublico.cupos.TipoVehiculoTransDao;
import modelo.datos.dao.transportepublico.cupos.ViewCuposDao;
import modelo.datos.dao.transportepublico.cupos.ViewPropietariosCupoTransDao;
import modelo.datos.dao.transportepublico.cupos.ViewTarjetasCupoTransDao;
import modelo.datos.dao.transportepublico.cupos.ViewVehiculosActivosEmpresaDao;
import modelo.datos.dao.transportepublico.cupos.ViewVidaUtilVehiculoTransDao;
import modelo.datos.dao.transportepublico.tramites.ViewDatosCupoTransDao;
import modelo.datos.dao.transportepublico.tramites.ViewResolucionesDao;
import modelo.datos.objetos.transportepublico.cupos.CuposTaxisTrans;
import modelo.datos.objetos.transportepublico.cupos.DetalleRangoCupoTrans;
import modelo.datos.objetos.transportepublico.cupos.EmpresasdeServicioTrans;
import modelo.datos.objetos.transportepublico.cupos.HistoricoCupoTrans;
import modelo.datos.objetos.transportepublico.cupos.InventarioCuposTrans;
import modelo.datos.objetos.transportepublico.cupos.RangoCuposVehiculoPublicoTrans;
import modelo.datos.objetos.transportepublico.cupos.TipoVehiculoTrans;
import modelo.datos.objetos.transportepublico.cupos.ViewCupos;
import modelo.datos.objetos.transportepublico.cupos.ViewPropietariosCupoTrans;
import modelo.datos.objetos.transportepublico.cupos.ViewTarjetasCupoTrans;
import modelo.datos.objetos.transportepublico.cupos.ViewVehiculosActivosEmpresa;
import modelo.datos.objetos.transportepublico.cupos.ViewVidaUtilVehiculoTrans;
import modelo.datos.objetos.transportepublico.tramites.ViewDatosCupoTrans;
import modelo.datos.objetos.transportepublico.tramites.ViewResoluciones;

import modelo.datos.objetos.transportepublico.cupos.Viewinventariorangos;
import modelo.datos.dao.transportepublico.cupos.ViewinventariorangosDao;
import modelo.datos.objetos.transportepublico.cupos.Viewinventariocupos;
import modelo.datos.dao.transportepublico.cupos.ViewinventariocuposDao;


import utilidades.Funciones;


public class GestionServiciosCuposTrans {
    Conexion conexion;
    Connection conn;
    String myMotor;

    public GestionServiciosCuposTrans() {
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
    
    public List getViewinventariocupos(Viewinventariocupos obj) {
            List lista = null;
            try {
                ViewinventariocuposDao dao = new ViewinventariocuposDao();
                conexion = new Conexion();
                conn = conexion.conectar();
                lista = dao.searchMatchingSinRest(conn, obj);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                conexion.cerrarCx();
            }
            return lista;
        }
    

    public List getViewinventariorangos(Viewinventariorangos obj) {
        List lista = null;
        try {
            ViewinventariorangosDao dao = new ViewinventariorangosDao();
            conexion = new Conexion();
            conn = conexion.conectar();
            lista = dao.searchMatchingSinRest(conn, obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }


    public List getTEmpresasServicio(EmpresasdeServicioTrans empresasdeserviciotrans) {
        List lista;
        lista = null;
        try {
            conexion = new Conexion();
            conn = conexion.conectar();
            EmpresasdeServicioTransDao myEmpresasdeServicioTransDao = new EmpresasdeServicioTransDao();
            lista = myEmpresasdeServicioTransDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getEmpresaServicio(EmpresasdeServicioTrans empresasdeserviciotrans) {
        List lista;
        lista = null;
        try {
            conexion = new Conexion();
            conn = conexion.conectar();
            
            EmpresasdeServicioTransDao myEmpresasdeServicioTransDao = new EmpresasdeServicioTransDao();
            lista = myEmpresasdeServicioTransDao.searchMatching(conn, empresasdeserviciotrans);
            /*if(lista!=null&&lista.size()>0)
            {
                empresasdeserviciotrans=(EmpresasdeServicioTrans)lista.get(0);
            }
            else
            {
                empresasdeserviciotrans=null;
            }*/
        } catch (Exception e) {
            e.printStackTrace();
            empresasdeserviciotrans = null;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getTipoVehiculoTrans(TipoVehiculoTrans tipovehiculotrans) {
        List lista;
        lista = null;
        try {
            conexion = new Conexion();
            conn = conexion.conectar();
            TipoVehiculoTransDao myTipoVehiculoTransDao = new TipoVehiculoTransDao();
            lista = myTipoVehiculoTransDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List buscarTipoVehiculoTrans(TipoVehiculoTrans tipovehiculotrans) {
        List lista;
        lista = null;
        try {
            conexion = new Conexion();
            conn = conexion.conectar();
            TipoVehiculoTransDao myTipoVehiculoTransDao = new TipoVehiculoTransDao();
            lista = myTipoVehiculoTransDao.searchMatching(conn, tipovehiculotrans);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getSTipoVehiculoTrans(TipoVehiculoTrans tipovehiculotrans) {
        List lista;
        lista = null;
        try {
            conexion = new Conexion();
            conn = conexion.conectar();
            TipoVehiculoTransDao myTipoVehiculoTransDao = new TipoVehiculoTransDao();
            lista = myTipoVehiculoTransDao.searchMatching(conn, tipovehiculotrans);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public TipoVehiculoTrans getTipoVehiculoTransPorId(TipoVehiculoTrans tipovehiculotrans) {
        TipoVehiculoTransDao myTipoVehiculoTransDao = new TipoVehiculoTransDao();
        try {
            conexion = new Conexion();
            conn = conexion.conectar();
            myTipoVehiculoTransDao.load(conn, tipovehiculotrans);
        } catch (Exception e) {
            e.printStackTrace();
            ;
            tipovehiculotrans.setID(-1);
        } finally {
            conexion.cerrarCx();
        }
        return tipovehiculotrans;
    }

    public List getDiferentesTaxis() {
        List lista;
        lista = null;
        try {
            conexion = new Conexion();
            conn = conexion.conectar();
            TipoVehiculoTransDao myTipoVehiculoTransDao = new TipoVehiculoTransDao();
            lista = myTipoVehiculoTransDao.loadDiferentesTaxis(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getSInventarioCupos(InventarioCuposTrans inventariocupos) {
        List lista;
        lista = null;
        try {
            conexion = new Conexion();
            conn = conexion.conectar();
            InventarioCuposTransDao myInventarioCuposTransDao = new InventarioCuposTransDao();
            lista = myInventarioCuposTransDao.searchMatching(conn, inventariocupos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getSInventarioCuposEmpresa(DetalleRangoCupoTrans detallerangocupo) {
        List lista;
        lista = null;
        try {
            conexion = new Conexion();
            conn = conexion.conectar();
            DetalleRangoCupoTransDao myDetalleRangoCupoTransDao = new DetalleRangoCupoTransDao();
            lista = myDetalleRangoCupoTransDao.searchMatching(conn, detallerangocupo);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        
        return lista;
    }
    
    public boolean validarRangoInventarioCupoEmpresa(int rangoinicial, int rangofinal, int idTipoVeh){
        
        boolean val = false;
        
        try{
            conexion = new Conexion();
            conn = conexion.conectar();
             
            if(rangoinicial > rangofinal)
               return false;
            else{                                   
                    DetalleRangoCupoTransDao myDetalleRangoCupoTransDao = new DetalleRangoCupoTransDao();    
                    val = myDetalleRangoCupoTransDao.validarRangoInventarioCupoEmpresa(conn,rangoinicial,rangofinal,idTipoVeh);
                }
            }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally {
            conexion.cerrarCx();
        }
             
        return val;   
    }

    public List getSRangoCuposVehiculo(RangoCuposVehiculoPublicoTrans rangocuposvehiculo) {
        List lista;
        lista = null;
        try {
            conexion = new Conexion();
            conn = conexion.conectar();
            RangoCuposVehiculoPublicoTransDao myRangoCuposVehiculoPublicoTransDao =
                new RangoCuposVehiculoPublicoTransDao();
            lista = myRangoCuposVehiculoPublicoTransDao.searchMatching(conn, rangocuposvehiculo);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public boolean crearCupos(InventarioCuposTrans inventariocupos) {
        boolean resultado;
        resultado = false;
        InventarioCuposTransDao myInventarioCuposTransDao = new InventarioCuposTransDao();
        int id = 0;

        try {
            conexion = new Conexion();
            conn = conexion.conectar();
            id = Funciones.obtenerId(conn, "GEN_INVENTARIOCUPOS", "GEN_INVENTARIOCUPOS", myMotor);
            inventariocupos.setID_INVENTARIOCUPO(id);
            myInventarioCuposTransDao.create(conn, inventariocupos);
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myInventarioCuposTransDao = null;
        }
        return resultado;
    }

    public int crearCuposEmpresa(RangoCuposVehiculoPublicoTrans rangocuposvehiculo) {
        boolean resultado;
        resultado = false;
        RangoCuposVehiculoPublicoTransDao myRangoCuposVehiculoPublicoTransDao =
            new RangoCuposVehiculoPublicoTransDao();
        int id = 0;
        String fechahor = "", hor = "";
        try {
            conexion = new Conexion();
            conn = conexion.conectar();
            id = Funciones.obtenerId(conn, "GEN_T_RANGOCUPOSVEHPUBLICO", "GEN_T_RANGOCUPOSVEHPUBLICO", myMotor);
            hor = Funciones.getHoraSistemaString(conn);
            fechahor = Funciones.getFechaSistema(conn,myMotor) + " " + hor;
            rangocuposvehiculo.setID_RANGOCUPO(id);
            //rangocuposvehiculo.setFECHAREGISTROCUPO(fechahor);
            myRangoCuposVehiculoPublicoTransDao.create(conn, rangocuposvehiculo);
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
            id = 0;
        } finally {
            conexion.cerrarCx();
            myRangoCuposVehiculoPublicoTransDao = null;
        }
        return id;
    }

    public boolean crearDetalleCuposEmpresa(DetalleRangoCupoTrans detallerangocupo) {
        boolean resultado;
        resultado = false;
        DetalleRangoCupoTransDao myDetalleRangoCupoTransDao = new DetalleRangoCupoTransDao();
        int id = 0;
        try {
            conexion = new Conexion();
            conn = conexion.conectar();
            id = Funciones.obtenerId(conn, "GEN_T_DETALLERANGOCUPO", "GEN_T_DETALLERANGOCUPO", myMotor);
            detallerangocupo.setIDDETALLERANGO(id);
            myDetalleRangoCupoTransDao.create(conn, detallerangocupo);
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myDetalleRangoCupoTransDao = null;
        }
        return resultado;
    }

    public boolean editarCupos(InventarioCuposTrans inventariocupos) {
        boolean resultado;
        resultado = false;
        InventarioCuposTransDao myInventarioCuposTransDao = new InventarioCuposTransDao();
        try {
            conexion = new Conexion();
            conn = conexion.conectar();
            myInventarioCuposTransDao.save(conn, inventariocupos);
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myInventarioCuposTransDao = null;
        }
        return resultado;
    }

    public List getSCupos(CuposTaxisTrans cupostaxistrans) {
        List lista;
        lista = null;
        try {
            conexion = new Conexion();
            conn = conexion.conectar();
            CuposTaxisTransDao myCuposTaxisTransDao = new CuposTaxisTransDao();
            lista = myCuposTaxisTransDao.searchMatching(conn, cupostaxistrans);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getSCuposAsignados(CuposTaxisTrans cupostaxistrans) {
        List lista;
        lista = null;
        try {
            conexion = new Conexion();
            conn = conexion.conectar();
            CuposTaxisTransDao myCuposTaxisTransDao = new CuposTaxisTransDao();
            lista = myCuposTaxisTransDao.searchMatchingAdicional(conn, cupostaxistrans, "TT_ID_VEHICULO IS NOT NULL");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public CuposTaxisTrans getCuposTaxisTransPorId(CuposTaxisTrans cupostaxistrans) {
        List lista = null;
        CuposTaxisTransDao myCuposTaxisTransDao = new CuposTaxisTransDao();
        try {
            conexion = new Conexion();
            conn = conexion.conectar();
            
            lista = myCuposTaxisTransDao.searchMatching(conn, cupostaxistrans);
            
            if (lista != null && lista.size() > 0) {
                cupostaxistrans = (CuposTaxisTrans)lista.get(0);
            } else {
                cupostaxistrans = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            cupostaxistrans.setTT_IDCUPOTAXI(-1);
        } finally {
            conexion.cerrarCx();
        }
        
        return cupostaxistrans;
    }

    public CuposTaxisTrans getOneCuposTaxis(CuposTaxisTrans cupostaxistrans) {
        
        List lista = null;
        CuposTaxisTrans tmp = new CuposTaxisTrans();
        CuposTaxisTransDao myCuposTaxisTransDao = new CuposTaxisTransDao();
                
        try {
                conexion = new Conexion();               
                conn = conexion.conectar();
                        
                lista = myCuposTaxisTransDao.searchMatching(conn, cupostaxistrans);
                       
                if (lista != null && lista.size() > 0)
                    tmp = (CuposTaxisTrans)lista.get(0);
                else
                    tmp.setTT_IDCUPOTAXI(-1);          
        } 
        catch (Exception e) {
            e.printStackTrace();
            
            cupostaxistrans.setTT_IDCUPOTAXI(-1);
        }
        finally {
            conexion.cerrarCx();
        }
        
        return tmp;
    }

    public List getTCupos() {
        List lista;
        lista = null;
        try {
            conexion = new Conexion();
            conn = conexion.conectar();
            CuposTaxisTransDao myCuposTaxisTransDao = new CuposTaxisTransDao();
            lista = myCuposTaxisTransDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public int crearCuposTaxis(CuposTaxisTrans cupostaxis) {
        boolean resultado;
        resultado = false;
        CuposTaxisTransDao myCuposTaxisTransDao = new CuposTaxisTransDao();
        int id = 0;

        try {
            conexion = new Conexion();
            conn = conexion.conectar();
            id = Funciones.obtenerId(conn, "GEN_TTCUPOTAXI", "GEN_TTCUPOTAXI", myMotor);
            cupostaxis.setTT_IDCUPOTAXI(id);
            myCuposTaxisTransDao.create(conn, cupostaxis);
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
            id = 0;
        } finally {
            conexion.cerrarCx();
            myCuposTaxisTransDao = null;
        }
        return id;
    }

    public boolean editarCuposTaxis(CuposTaxisTrans cupostaxis) {
        boolean resultado;
        resultado = false;
        CuposTaxisTransDao myCuposTaxisTransDao = new CuposTaxisTransDao();
        try {
            conexion = new Conexion();
            conn = conexion.conectar();

            myCuposTaxisTransDao.save(conn, cupostaxis);
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myCuposTaxisTransDao = null;
        }
        return resultado;
    }

    public boolean cambiarEmpresaCuposTaxis(CuposTaxisTrans cupostaxis) {
        List mylista;
        boolean resultado;
        resultado = false;
        InventarioCuposTrans myInvCupTrans = new InventarioCuposTrans();
        myInvCupTrans.setNROCUPO(String.valueOf(cupostaxis.getTT_NUMCUPO()));
        myInvCupTrans.setID_TIPOVEHICULO(Integer.parseInt(cupostaxis.getTT_TIPOVEH()));
        CuposTaxisTransDao myCuposTaxisTransDao = new CuposTaxisTransDao();
        InventarioCuposTransDao myInvCupTransDao = new InventarioCuposTransDao();
        try {
            conexion = new Conexion();
            conn = conexion.conectar();
            mylista = myInvCupTransDao.searchMatching(conn, myInvCupTrans);
            if (mylista != null && mylista.size() > 0) {
                myInvCupTrans = (InventarioCuposTrans)mylista.get(0);
                myInvCupTrans.setID_EMPRESAASIGNADA(cupostaxis.getTT_IDEMPRESA());
                myInvCupTransDao.save(conn, myInvCupTrans);
            }
            myCuposTaxisTransDao.save(conn, cupostaxis);
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myCuposTaxisTransDao = null;
        }
        return resultado;
    }

    public List getDetalleRangoCupos(DetalleRangoCupoTrans detallerangocupo) {
        List resultado = null;
        DetalleRangoCupoTransDao myDetalleRangoCupoTransDao = new DetalleRangoCupoTransDao();
        try {
            conexion = new Conexion();
            conn = conexion.conectar();
            resultado = myDetalleRangoCupoTransDao.searchMatching(conn, detallerangocupo);

        } catch (Exception e) {
            e.printStackTrace();
            resultado = null;
        } finally {
            conexion.cerrarCx();
            myDetalleRangoCupoTransDao = null;
        }
        return resultado;
    }


    public boolean editarDetalleRangoCupos(DetalleRangoCupoTrans detallerangocupo) {
        boolean resultado;
        resultado = false;
        DetalleRangoCupoTransDao myDetalleRangoCupoTransDao = new DetalleRangoCupoTransDao();
        try {
            conexion = new Conexion();
            conn = conexion.conectar();
            myDetalleRangoCupoTransDao.save(conn, detallerangocupo);
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myDetalleRangoCupoTransDao = null;
        }
        return resultado;
    }

    public List getSVehiculosActivosEmpresa(ViewVehiculosActivosEmpresa viewvehiculosactivos) {
        List lista;
        lista = null;
        try {
            conexion = new Conexion();
            conn = conexion.conectar();
            ViewVehiculosActivosEmpresaDao myViewVehiculosActivosEmpresaDao = new ViewVehiculosActivosEmpresaDao();
            lista = myViewVehiculosActivosEmpresaDao.searchMatching(conn, viewvehiculosactivos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public boolean crearHistoricoCuposTaxis(HistoricoCupoTrans historicocupotrans) {
        boolean resultado;
        resultado = false;
        HistoricoCupoTransDao myHistoricoCupoTransDao = new HistoricoCupoTransDao();
        int id = 0;
        String fechareg = "";

        try {
            conexion = new Conexion();
            conn = conexion.conectar();
            id = Funciones.obtenerId(conn, "GEN_TT_HISTORICOCUPO", "GEN_TT_HISTORICOCUPO", myMotor);
            historicocupotrans.setID(id);
            fechareg = Funciones.getFechaSistema(conn,myMotor);
            historicocupotrans.setFECHAREGISTRO(fechareg);
            myHistoricoCupoTransDao.create(conn, historicocupotrans);
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myHistoricoCupoTransDao = null;
        }
        return resultado;
    }

    public List getSHistoricoCuposTaxis(HistoricoCupoTrans historicocupotrans) {
        List lista;
        lista = null;
        try {
            conexion = new Conexion();
            conn = conexion.conectar();
            HistoricoCupoTransDao myHistoricoCupoTransDao = new HistoricoCupoTransDao();
            lista = myHistoricoCupoTransDao.searchMatching(conn, historicocupotrans);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getSViewCupos(ViewCupos viewcupos) {
        List lista;
        lista = null;
        try {
            conexion = new Conexion();
            conn = conexion.conectar();
            ViewCuposDao myViewCuposDao = new ViewCuposDao();
            lista = myViewCuposDao.searchMatching(conn, viewcupos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getSViewResoluciones(ViewResoluciones viewresoluciones) {
        List lista;
        lista = null;
        try {
            conexion = new Conexion();
            conn = conexion.conectar();
            ViewResolucionesDao myViewResolucionesDao = new ViewResolucionesDao();
            lista = myViewResolucionesDao.searchMatching(conn, viewresoluciones);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getSViewDatosCupo(ViewDatosCupoTrans viewdatoscupotrans) {
        List lista;
        lista = null;
        try {
            conexion = new Conexion();
            conn = conexion.conectar();
            ViewDatosCupoTransDao myViewDatosCupoTransDao = new ViewDatosCupoTransDao();
            lista = myViewDatosCupoTransDao.searchMatching(conn, viewdatoscupotrans);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getSViewPropietariosCupo(ViewPropietariosCupoTrans viewpropietarioscupotrans) {
        List lista;
        lista = null;
        try {
            conexion = new Conexion();
            conn = conexion.conectar();
            ViewPropietariosCupoTransDao myViewPropietariosCupoTransDao = new ViewPropietariosCupoTransDao();
            lista = myViewPropietariosCupoTransDao.searchMatching(conn, viewpropietarioscupotrans);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getSViewTarjetasCupo(ViewTarjetasCupoTrans viewtarjetascupotrans) {
        List lista;
        lista = null;
        try {
            conexion = new Conexion();
            conn = conexion.conectar();
            ViewTarjetasCupoTransDao myViewTarjetasCupoTransDao = new ViewTarjetasCupoTransDao();
            lista = myViewTarjetasCupoTransDao.searchMatching(conn, viewtarjetascupotrans);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getSViewVidaUtilVehiculo(ViewVidaUtilVehiculoTrans viewvidautilvehiculotrans) {
        Funciones funciones = new Funciones();
        List lista;
        lista = null;
        try {
            conexion = new Conexion();
            conn = conexion.conectar();
            ViewVidaUtilVehiculoTransDao myViewVidaUtilVehiculoTransDao = new ViewVidaUtilVehiculoTransDao();
            lista = myViewVidaUtilVehiculoTransDao.searchMatching(conn, viewvidautilvehiculotrans);
        } catch (Exception e) {
            e.printStackTrace();
            lista = null;
            return lista;
        } finally {
            conexion.cerrarCx();
        }

        if (lista != null && lista.size() > 0) {
            ViewVidaUtilVehiculoTrans lvidautil = new ViewVidaUtilVehiculoTrans();

            for (int q = 0; q < lista.size(); q++) {
                String lafecha = "";
                lvidautil = (ViewVidaUtilVehiculoTrans)lista.get(q);

                String[] arrayFecha = lvidautil.getFECHAREGISTROVEHI().split("-");
                lafecha = arrayFecha[2] + "/" + arrayFecha[1] + "/" + arrayFecha[0];

                lvidautil.setDVIDAUTIL(funciones.getDiferenciaFechas(lafecha));
                lista.set(q, lvidautil);
                /*
                ViewVidaUtilVehiculoTrans myvista = new ViewVidaUtilVehiculoTrans();

                myvista.setIDVEHICULO(lvidautil.getIDVEHICULO());
                myvista.setANUMEROCUPO(lvidautil.getANUMEROCUPO());
                myvista.setCPLACA(lvidautil.getCPLACA());
                myvista.setFECHAREGISTROVEHI(lvidautil.getFECHAREGISTROVEHI());
                myvista.setTIPODEVEHICULO(lvidautil.getTIPODEVEHICULO());
                myvista.setNITEMPRESA(lvidautil.getNITEMPRESA());
                myvista.setBEMPRESAASOCIADA(lvidautil.getBEMPRESAASOCIADA());

                String[] arrayFecha = lvidautil.getFECHAREGISTROVEHI().split("-");
                lafecha=arrayFecha[2]+"/"+arrayFecha[1]+"/"+arrayFecha[0];

                myvista.setDVIDAUTIL(funciones.getDiferenciaFechas(lafecha));

                nuevalista.add(myvista);*/
            }
        }

        return lista;
    }

    public EmpresasdeServicioTrans crearEmpresasdeServicioTrans(EmpresasdeServicioTrans empresaserviciotrans) {

        EmpresasdeServicioTransDao mydao = new EmpresasdeServicioTransDao();
        List lista = null;
        int id;
        try {
            conexion = new Conexion();
            conn = conexion.conectar();
            Funciones myfunc = new Funciones();
            id = myfunc.obtenerId(conn, "GEN_EMPSERVICIOS", "EMPSERVICIOS", myMotor);
            //id = myfunc.getId_FB(conn, "GEN_EMPSERVICIOS");
            empresaserviciotrans.setID_EMPSERVICIO(id);
            mydao.create(conn, empresaserviciotrans);

            EmpresasdeServicioTrans empresatemp = new EmpresasdeServicioTrans();
            empresatemp.setID_EMPSERVICIO(id);
            empresatemp.setDIGVERIF(-2); //en esta consulta no tener en cuenta el valor del DIGVERIF
            
            lista = mydao.searchMatching(conn, empresatemp);
            
            if (lista != null && lista.size() > 0)
                empresaserviciotrans = (EmpresasdeServicioTrans)lista.get(0);
            else
                empresaserviciotrans.setID_EMPSERVICIO(-1);

        } catch (Exception e) {
            e.printStackTrace();
            empresaserviciotrans.setID_EMPSERVICIO(-1);
        } finally {
            conexion.cerrarCx();
            mydao = null;
        }
        return empresaserviciotrans;
    }

    public boolean editarEmpresasdeServicioTrans(EmpresasdeServicioTrans empresaserviciotrans) {
        EmpresasdeServicioTransDao mydao = new EmpresasdeServicioTransDao();
        boolean result = false;
        try {
            conexion = new Conexion();
            conn = conexion.conectar();
            mydao.save(conn, empresaserviciotrans);
            result = true;

        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        } finally {
            conexion.cerrarCx();
            mydao = null;
        }
        return result;
    }

    public boolean eliminarEmpresasdeServicioTrans(EmpresasdeServicioTrans empresaserviciotrans) {
        EmpresasdeServicioTransDao mydao = new EmpresasdeServicioTransDao();
        boolean result = false;
        try {
            conexion = new Conexion();
            conn = conexion.conectar();
            mydao.delete(conn, empresaserviciotrans);
            result = true;

        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        } finally {
            conexion.cerrarCx();
            mydao = null;
        }
        return result;
    }

}
