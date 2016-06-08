package modelo.logica.generales;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.avaluos.AvaluoAnioDao;
import modelo.datos.dao.avaluos.AvaluoCargaDao;
import modelo.datos.dao.avaluos.AvaluoMotosDao;
import modelo.datos.dao.avaluos.AvaluoVehiculoDao;
import modelo.datos.dao.avaluos.CarroceriaMinDao;
import modelo.datos.dao.avaluos.ClExcepCargaDao;
import modelo.datos.dao.avaluos.ClGrupoCargaDao;
import modelo.datos.dao.avaluos.ClGrupoCargaPasDao;
import modelo.datos.dao.avaluos.ClGrupoMotoDao;
import modelo.datos.dao.avaluos.ClGrupoPasDao;
import modelo.datos.dao.avaluos.ClMotoCilindDao;
import modelo.datos.dao.avaluos.ClaseVehiculoAvaluoDao;
import modelo.datos.dao.avaluos.ExepAvaluoDao;
import modelo.datos.dao.avaluos.ViewCLGrupoCargaPasDao;
import modelo.datos.dao.avaluos.ViewClGrupoMotoDao;
import modelo.datos.objetos.avaluos.Avaluo;
import modelo.datos.objetos.avaluos.AvaluoAnio;
import modelo.datos.objetos.avaluos.AvaluoCarga;
import modelo.datos.objetos.avaluos.AvaluoMotos;
import modelo.datos.objetos.avaluos.AvaluoVehiculo;
import modelo.datos.objetos.avaluos.CarroceriaMin;
import modelo.datos.objetos.avaluos.ClExcepCarga;
import modelo.datos.objetos.avaluos.ClGrupoCarga;
import modelo.datos.objetos.avaluos.ClGrupoCargaPas;
import modelo.datos.objetos.avaluos.ClGrupoMoto;
import modelo.datos.objetos.avaluos.ClGrupoPas;
import modelo.datos.objetos.avaluos.ClMotoCilind;
import modelo.datos.objetos.avaluos.ClaseVehiculoAvaluo;
import modelo.datos.objetos.avaluos.ExepAvaluo;
import modelo.datos.objetos.avaluos.ViewCLGrupoCargaPas;
import modelo.datos.objetos.avaluos.ViewClGrupoMoto;
import modelo.datos.objetos.generales.vehiculo.Vehiculo;

import modelo.logica.generales.vehiculo.GestionServiciosVehiculosLocal;

import utilidades.Funciones;


public class GestionServiciosAvaluos {
    Conexion conexion;
    Connection conn;
    String myMotor;

    public GestionServiciosAvaluos() {
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
    }

    public boolean crearAvaluoVehiculo(AvaluoVehiculo avaluoVehiculo) {
        boolean res = false;
        int id = 0;
        try {
            conn = conexion.conectar();
            AvaluoVehiculoDao myDao = new AvaluoVehiculoDao();
            id = Funciones.obtenerId(conn, "GEN_ID_AVALUO_VEHICULO", "GEN_AVALUOVEHICULO", myMotor);
            avaluoVehiculo.setID_AVALUO_VEHICULO(id);
            myDao.create(conn, avaluoVehiculo);
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public boolean eliminarAvaluoVehiculo(AvaluoVehiculo avaluoVehiculo) {
        boolean res = false;
        try {
            conn = conexion.conectar();
            AvaluoVehiculoDao myDao = new AvaluoVehiculoDao();
            myDao.delete(conn, avaluoVehiculo);
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public boolean actualizarAvaluoVehiculo(AvaluoVehiculo avaluoVehiculo) {
        boolean res = false;
        try {
            conn = conexion.conectar();
            AvaluoVehiculoDao myDao = new AvaluoVehiculoDao();
            myDao.save(conn, avaluoVehiculo);
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public List searchAvaluoVehiculo(AvaluoVehiculo avaluoVehiculo) {
        List lista = null;
        try {
            conn = conexion.conectar();
            AvaluoVehiculoDao myDao = new AvaluoVehiculoDao();
            lista = myDao.searchMatching(conn, avaluoVehiculo);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List listarAvaluoVehiculo() {
        List lista = null;
        try {
            conn = conexion.conectar();
            AvaluoVehiculoDao myDao = new AvaluoVehiculoDao();
            lista = myDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }


    public double getAvaluo(Avaluo avaluo, String grupo) {
        double res = 0;
        String mpx;
        String param = "";
        List excepciones = null;
        int minanio;
        System.out.println("Clase de vehiculo: " + avaluo.getTipoVehiculo());
        minanio = getMinAnnio(avaluo.getVigencia());
        //if(avaluo.getModelo() == Integer.parseInt(Funciones.getFechaSistema2("yyyy", null))) {
        if (avaluo.getModelo() == avaluo.getVigencia()&& avaluo.getModelo()>minanio){
            Vehiculo veh = new Vehiculo();
            veh.setID_VEHICULO(avaluo.getIdVehiculo());
            GestionServiciosVehiculosLocal gestionVehiculos = new GestionServiciosVehiculosLocal();
            veh = gestionVehiculos.getVehiculo(veh);
            try {
                res = Double.parseDouble(veh.getVLRFACTURA());
            }catch(Exception e){res = 0;}
        }
        else
        {
            if (avaluo.getModelo()< minanio)
                avaluo.setModelo(minanio);
            if (avaluo.getTipoVehiculo() != null && avaluo.getTipoVehiculo().equals("A")) {
                AvaluoVehiculo avaluoVehiculo = new AvaluoVehiculo();
                avaluoVehiculo.setCILINDRAJE(avaluo.getCilindraje());
                avaluoVehiculo.setID_LINEA(avaluo.getId_linea());
                avaluoVehiculo.setID_MARCA(avaluo.getId_marca());
                avaluoVehiculo.setMODELO(avaluo.getModelo());
                avaluoVehiculo.setVIGENCIA(avaluo.getVigencia());
                res = obtenerAvaluoVehiculo(avaluoVehiculo);
                
                if (res == 0) {
                    avaluoVehiculo.setCILINDRAJE(0);
                    avaluoVehiculo.setID_LINEA(avaluo.getId_linea());
                    avaluoVehiculo.setID_MARCA(avaluo.getId_marca());
                    avaluoVehiculo.setMODELO(avaluo.getModelo());
                    avaluoVehiculo.setVIGENCIA(avaluo.getVigencia());
                    res = obtenerAvaluoVehiculo(avaluoVehiculo);
                }
    
                excepciones = getExcepciones(avaluoVehiculo.getVIGENCIA(), avaluo.getIdTipoVehiculo());
                
    
            }
            if (avaluo.getTipoVehiculo() != null && avaluo.getTipoVehiculo().equals("M")) {
                AvaluoMotos avaluoMoto = new AvaluoMotos();
                avaluoMoto.setGRUPO(grupo);//getGrupoMoto(avaluo.getId_marca(), avaluo.getCilindraje(), avaluo.getVigencia()));
                avaluoMoto.setMODELO(avaluo.getModelo());
                avaluoMoto.setVIGENCIA(avaluo.getVigencia());
                res = obtenerAvaluoMotos(avaluoMoto);
                excepciones = getExcepciones(avaluoMoto.getVIGENCIA(), avaluo.getIdTipoVehiculo());
    
            }
            if (avaluo.getTipoVehiculo() != null && avaluo.getTipoVehiculo().equals("C")) {
                System.out.println("Carga / Pasajeros");
                AvaluoCarga avaluoCarga = new AvaluoCarga();
                avaluoCarga.setMODELO(avaluo.getModelo());
                avaluoCarga.setVIGENCIA(avaluo.getVigencia());
                res = obtenerAvaluoCarga(avaluoCarga);
                excepciones = getExcepciones(avaluoCarga.getVIGENCIA(), avaluo.getIdTipoVehiculo());
    
                if (res == 0)
                {
                    AvaluoCarga avaluoCarga2 = new AvaluoCarga();
                    avaluoCarga2.setMODELO(avaluo.getModelo());
                    avaluoCarga2.setVIGENCIA(avaluo.getVigencia());
                    avaluoCarga2.setGRUPO(getGrupoCarga(avaluo, 'C'));
                    res = obtenerAvaluoCarga(avaluoCarga2);
                    excepciones = getExcepciones(avaluoCarga2.getVIGENCIA(), avaluo.getIdTipoVehiculo());
    
                }
            }
            
            if (excepciones != null)
            {
                mpx = getValorParametro(excepciones, "CIUDAD", Integer.toString(avaluo.getCod_ciudad()));
                if (mpx != "") {
                    res = recalcular(res, mpx);
                }
                mpx = "";
                if (avaluo.isBlindado()) {
                    mpx = getValorParametro(excepciones, "BLINDADO", "TRUE");
                    if (mpx != "") {
                        res = recalcular(res, mpx);
                    }
                }
            }
            //res *=1000;
        }

        return res;
    }

    
    public int getMinAnnio(int vigencia){
        AvaluoAnio avaluoAnio = new AvaluoAnio();
        int res = 0;
        List lista = null;
        try {
            conn = conexion.conectar();
            AvaluoAnioDao myDao = new AvaluoAnioDao();
            avaluoAnio.setVIGENCIA(vigencia);
            lista = myDao.searchMatching(conn, avaluoAnio);
            if (lista != null && lista.size() > 0) {
                avaluoAnio = (AvaluoAnio)lista.get(0);
                res = avaluoAnio.getMODELO();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public double recalcular(double res, String mpx) {
        double tmp;
        tmp = res;
        char op;
        op = mpx.charAt(0);
        try {
            if (op == '+')
                res = res + Double.parseDouble(mpx.substring(1));
            if (op == '-')
                res = res - Double.parseDouble(mpx.substring(1));
            if (op == '*')
                res = res * Double.parseDouble(mpx.substring(1));
            if (op == '/')
                res = res / Double.parseDouble(mpx.substring(1));

            tmp = res;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tmp;
    }

    public String getValorParametro(List lista, String excepcion, String parametro) {
        String res = "";
        int i;
        ExepAvaluo tmp = new ExepAvaluo();
        for (i = 0; i < lista.size(); i++) {
            tmp = (ExepAvaluo)lista.get(i);
            if (tmp.getEXCEPCION().equals(excepcion) && tmp.getPARAMETRO().equals(parametro))
                res = tmp.getVALOR();
        }

        return res;
    }

    public String getGrupoMoto(int marca, int cilindraje, int vigencia) {
        String res = "";
        res = getGrupoMarcaMoto(marca, vigencia);
        res = res + getGrupoCilindrajeMoto(cilindraje, vigencia);

        return res;
    }

    public String getGrupoMarcaMoto(int marca, int vigencia) {
        String res = "";
        List lista = null;
        try {
            conn = conexion.conectar();
            ClGrupoMotoDao myDao = new ClGrupoMotoDao();
            ClGrupoMoto tmp = new ClGrupoMoto();
            tmp.setID_MARCA(marca);
            tmp.setVIGENCIA(vigencia);
            lista = myDao.searchMatching(conn, tmp);
            if (lista != null && lista.size() > 0) {
                tmp = (ClGrupoMoto)lista.get(0);
                res = tmp.getGRUPO();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }

        return res;
    }

    public String getGrupoCilindrajeMoto(int cilindraje, int vigencia) {
        String res = "";
        List lista = null;
        try {
            conn = conexion.conectar();
            ClMotoCilind tmp = new ClMotoCilind();
            tmp.setVIGENCIA(vigencia);
            tmp.setCILINMAX(cilindraje);
            tmp.setCILINMIN(cilindraje);
            ClMotoCilindDao myDao = new ClMotoCilindDao();
            lista = myDao.searchMatching(conn, tmp);
            if (lista != null && lista.size() > 0) {
                tmp = (ClMotoCilind)lista.get(0);
                res = tmp.getGRUPO();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }

        return res;
    }

    public String getGrupoCarga(Avaluo avaluo, char tipo) {
        String res = "";
        res = getGrupoCargaExcep(avaluo, tipo);
        if (res == "") {
            res = getGrupoMarcaCarga(avaluo, tipo);
            res = res + getGrupoCargaPas(avaluo, tipo);
        }

        return res;
    }

    public String getGrupoMarcaCarga(Avaluo avaluo, char tipo) {
        String res = "";
        List lista = null;
        try {
            conn = conexion.conectar();
            ClGrupoCargaPas tmp = new ClGrupoCargaPas();
            ClGrupoCargaPasDao myDao = new ClGrupoCargaPasDao();
            tmp.setID_CLASE(avaluo.getIdTipoVehiculo());
            tmp.setID_MARCA(avaluo.getId_marca());
            tmp.setID_TIPOCARROCERIA(avaluo.getId_carroceria());
            tmp.setTIPO(String.valueOf(tipo));
            tmp.setVIGENCIA(avaluo.getVigencia());
            //tmp.setMODELO(avaluo.getModelo());
            //tmp.setID_LINEA(avaluo.getId_linea());
            //tmp.setTONDESDE(avaluo.getCCarga());
            //tmp.setTONHASTA(avaluo.getCCarga());
            lista = myDao.searchMatching(conn, tmp);
            if (lista != null && lista.size() > 0) {
                tmp = (ClGrupoCargaPas)lista.get(0);
                res = tmp.getGRUPO();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }


        return res;
    }

    public String getGrupoCargaPas(Avaluo avaluo, char tipo) {
        String res = "";
        List lista;
        if (tipo == 'P') {
            try {
                conn = conexion.conectar();
                lista = null;
                ClGrupoPas cargaPas = new ClGrupoPas();
                ClGrupoPasDao cargaPasDao = new ClGrupoPasDao();
                cargaPas.setCATESP((avaluo.getIdTipoVehiculo()));
                cargaPas.setVIGENCIA(avaluo.getVigencia());
                cargaPas.setSILLASDESDE(avaluo.getCPas());
                cargaPas.setSILLASHASTA(avaluo.getCPas());
                lista = cargaPasDao.searchMatching(conn, cargaPas);
                if (lista != null && lista.size() > 0) {
                    cargaPas = (ClGrupoPas)lista.get(0);
                    res = cargaPas.getGRUPO();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                conexion.cerrarCx();
            }
        }
        if (tipo == 'C') {
            try {
                conn = conexion.conectar();
                ClGrupoCarga carga = new ClGrupoCarga();
                ClGrupoCargaDao cargaDao = new ClGrupoCargaDao();
                carga.setTONDESDE(avaluo.getCCarga());
                carga.setTONHASTA(avaluo.getCCarga());
                carga.setVIGENCIA(avaluo.getVigencia());
                lista = cargaDao.searchMatching(conn, carga);
                if (lista != null && lista.size() > 0) {
                    carga = (ClGrupoCarga)lista.get(0);
                    res = carga.getGRUPO();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                conexion.cerrarCx();
            }
        }
        return res;
    }

    public String getGrupoCargaExcep(Avaluo avaluo, char tipo) {
        String res = "";
        List lista = null;
        try {
            conn = conexion.conectar();
            ClExcepCargaDao myDao = new ClExcepCargaDao();
            ClExcepCarga tmp = new ClExcepCarga();
            tmp.setCILINDRAJE(avaluo.getCilindraje());
            tmp.setID_LINEA(avaluo.getId_linea());
            tmp.setID_MARCA(avaluo.getId_marca());
            lista = myDao.searchMatching(conn, tmp);
            if (lista != null && lista.size() > 0) {
                tmp = (ClExcepCarga)lista.get(0);
                res = tmp.getGRUPO();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public double obtenerAvaluoVehiculo(AvaluoVehiculo avaluoVehiculo) {
        List lista = null;
        List excepciones = null;
        AvaluoVehiculo tmp = new AvaluoVehiculo();
        double res = 0;
        try {
            conn = conexion.conectar();
            AvaluoVehiculoDao myDao = new AvaluoVehiculoDao();
            lista = myDao.searchMatching(conn, avaluoVehiculo);
            if (lista != null && lista.size() > 0) {
                if (lista.size() == 1) {
                    tmp = (AvaluoVehiculo)lista.get(0);
                    res = tmp.getAVALUO();
                } else {
                    for (int i = 0; i < lista.size(); i++) {
                        tmp = (AvaluoVehiculo)lista.get(0);
                        if (res == 0)
                            res = tmp.getAVALUO();
                        else if (tmp.getAVALUO() < res)
                            res = tmp.getAVALUO();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public boolean crearAvaluoCarga(AvaluoCarga avaluoCarga) {
        boolean res = false;
        int id;
        try {
            conn = conexion.conectar();
            AvaluoCargaDao myDao = new AvaluoCargaDao();
            id = Funciones.obtenerId(conn, "GEN_ID_AVALUO_CARGA", "GEN_AVALUOCARGA", myMotor);
            avaluoCarga.setID_AVALUO_CARGA(id);
            myDao.create(conn, avaluoCarga);
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public boolean eliminarAvaluoCarga(AvaluoCarga avaluoCarga) {
        boolean res = false;
        try {
            conn = conexion.conectar();
            AvaluoCargaDao myDao = new AvaluoCargaDao();
            myDao.delete(conn, avaluoCarga);
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public boolean actualizarAvaluoCarga(AvaluoCarga avaluoCarga) {
        boolean res = false;
        try {
            conn = conexion.conectar();
            AvaluoCargaDao myDao = new AvaluoCargaDao();
            myDao.save(conn, avaluoCarga);
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public List searchAvaluoCarga(AvaluoCarga avaluoCarga) {
        List lista = null;
        try {
            conn = conexion.conectar();
            AvaluoCargaDao myDao = new AvaluoCargaDao();
            lista = myDao.searchMatching(conn, avaluoCarga);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List listarAvaluoCarga() {
        List lista = null;
        try {
            conn = conexion.conectar();
            AvaluoCargaDao myDao = new AvaluoCargaDao();
            lista = myDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public double obtenerAvaluoCarga(AvaluoCarga avaluoCarga) {
        List lista = null;
        double res = 0;
        AvaluoCarga tmp = new AvaluoCarga();
        try {
            conn = conexion.conectar();
            AvaluoCargaDao myDao = new AvaluoCargaDao();
            lista = myDao.searchMatching(conn, avaluoCarga);
            if (lista != null && lista.size() > 0) {
                if (lista.size() == 1) {
                    tmp = (AvaluoCarga)lista.get(0);
                    res = tmp.getAVALUO();
                } else {
                    for (int i = 0; i < lista.size(); i++) {
                        tmp = (AvaluoCarga)lista.get(0);
                        if (res == 0)
                            res = tmp.getAVALUO();
                        else if (tmp.getAVALUO() < res)
                            res = tmp.getAVALUO();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public boolean crearAvaluoMotos(AvaluoMotos avaluoMoto) {
        boolean res = false;
        int id;
        try {
            conn = conexion.conectar();
            AvaluoMotosDao myDao = new AvaluoMotosDao();
            id = Funciones.obtenerId(conn, "GEN_ID_AVALUO_MOTOS", "GEN_AVALUOMOTOS", myMotor);
            avaluoMoto.setID_AVALUO_MOTOS(id);
            myDao.create(conn, avaluoMoto);
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public boolean eliminarAvaluoMotos(AvaluoMotos avaluoMoto) {
        boolean res = false;
        try {
            conn = conexion.conectar();
            AvaluoMotosDao myDao = new AvaluoMotosDao();
            myDao.delete(conn, avaluoMoto);
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public boolean actualizarAvaluoMotos(AvaluoMotos avaluoMoto) {
        boolean res = false;
        try {
            conn = conexion.conectar();
            AvaluoMotosDao myDao = new AvaluoMotosDao();
            myDao.save(conn, avaluoMoto);
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public List searchAvaluoMotos(AvaluoMotos avaluoMoto) {
        List lista = null;
        try {
            conn = conexion.conectar();
            AvaluoMotosDao myDao = new AvaluoMotosDao();
            lista = myDao.searchMatching(conn, avaluoMoto);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List listarAvaluoMotos() {
        List lista = null;
        try {
            conn = conexion.conectar();
            AvaluoMotosDao myDao = new AvaluoMotosDao();
            lista = myDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public double obtenerAvaluoMotos(AvaluoMotos avaluoMoto) {
        List lista = null;
        AvaluoMotos tmp = new AvaluoMotos();
        double res = 0;
        try {
            conn = conexion.conectar();
            AvaluoMotosDao myDao = new AvaluoMotosDao();
            lista = myDao.searchMatching(conn, avaluoMoto);
            if (lista != null && lista.size() > 0) {
                if (lista.size() == 1) {
                    tmp = (AvaluoMotos)lista.get(0);
                    res = tmp.getAVALUO();
                } else {
                    for (int i = 0; i < lista.size(); i++) {
                        tmp = (AvaluoMotos)lista.get(0);
                        if (res == 0)
                            res = tmp.getAVALUO();
                        else if (tmp.getAVALUO() < res)
                            res = tmp.getAVALUO();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public List getExcepciones(int vigencia, int tipoveh) {
        List lista = null;
        try {
            ExepAvaluo excepAvaluo = new ExepAvaluo();
            excepAvaluo.setVIGENCIA(vigencia);
            excepAvaluo.setID_TIPO_VEHICULO(tipoveh);
            conn = conexion.conectar();
            ExepAvaluoDao myDao = new ExepAvaluoDao();
            lista = myDao.searchMatching(conn, excepAvaluo);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getAllExcepcionAvaluo() {
        List lista = null;
        try {
            conn = conexion.conectar();
            ExepAvaluoDao myDao = new ExepAvaluoDao();
            lista = myDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public boolean crearExcepcionAvaluo(ExepAvaluo exepAvaluo) {
        boolean res = false;
        int id;
        try {
            conn = conexion.conectar();
            id = Funciones.obtenerId(conn, "GEN_ID_EXCEP_AVALUO", "GEN_EXCEPAVALUO", myMotor);
            exepAvaluo.setID_EXCEP_AVALUO(id);
            ExepAvaluoDao myDao = new ExepAvaluoDao();
            myDao.create(conn, exepAvaluo);
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public boolean eliminarExcepcionAvaluo(ExepAvaluo exepAvaluo) {
        boolean res = false;
        try {
            conn = conexion.conectar();
            ExepAvaluoDao myDao = new ExepAvaluoDao();
            myDao.delete(conn, exepAvaluo);
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public List getTipoVehiculoAvaluo() {
        List lista = null;
        try {
            conn = conexion.conectar();
            ClaseVehiculoAvaluoDao myDao = new ClaseVehiculoAvaluoDao();
            lista = myDao.loadAll(conn);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List searchTipoVehiculoAvaluo(ClaseVehiculoAvaluo claseVehiculoAvaluo) {
        List lista = null;
        try {
            conn = conexion.conectar();
            ClaseVehiculoAvaluoDao myDao = new ClaseVehiculoAvaluoDao();
            lista = myDao.searchMatching(conn, claseVehiculoAvaluo);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public ClaseVehiculoAvaluo getOneTipoVehiculoAvaluo(ClaseVehiculoAvaluo claseVehiculoAvaluo) {
        List lista = null;
        ClaseVehiculoAvaluo tmp = new ClaseVehiculoAvaluo();
        try {
            conn = conexion.conectar();
            ClaseVehiculoAvaluoDao myDao = new ClaseVehiculoAvaluoDao();
            lista = myDao.loadAll(conn);
            if (lista != null && lista.size() > 0)
                tmp = (ClaseVehiculoAvaluo)lista.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return tmp;
    }

    public boolean crearClGrupoMoto(ClGrupoMoto clGrupoMoto) {
        boolean res = false;
        int id;
        try {
            conn = conexion.conectar();
            ClGrupoMotoDao myDao = new ClGrupoMotoDao();
            id = Funciones.obtenerId(conn, "GEN_ID_CL_GRMOTO", "GEN_CL_GRMOTO", myMotor);
            clGrupoMoto.setID_CL_GRMOTO(id);
            myDao.create(conn, clGrupoMoto);
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public boolean eliminarClGrupoMoto(ClGrupoMoto clGrupoMoto) {
        boolean res = false;
        try {
            conn = conexion.conectar();
            ClGrupoMotoDao myDao = new ClGrupoMotoDao();
            myDao.delete(conn, clGrupoMoto);
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public List getClGrupoMoto() {
        List lista = null;
        try {
            conn = conexion.conectar();
            ClGrupoMotoDao myDao = new ClGrupoMotoDao();
            lista = myDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getViewClGrupoMoto(ViewClGrupoMoto tmp) {
        List lista = null;
        try {
            conn = conexion.conectar();
            ViewClGrupoMotoDao myDao = new ViewClGrupoMotoDao();
            if (tmp == null)
                lista = myDao.loadAll(conn);
            else
                lista = myDao.searchMatching(conn, tmp);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public boolean crearClMotoCilindraje(ClMotoCilind clMotoCilindraje) {
        boolean res = false;
        int id;
        try {
            conn = conexion.conectar();
            ClMotoCilindDao myDao = new ClMotoCilindDao();
            id = Funciones.obtenerId(conn, "GEN_ID_CL_MOTOCIL", "GEN_CL_MOTOCIL", myMotor);
            clMotoCilindraje.setID_CL_MOTOCIL(id);
            myDao.create(conn, clMotoCilindraje);
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public boolean eliminarClMotoCilindraje(ClMotoCilind clMotoCilindraje) {
        boolean res = false;
        try {
            conn = conexion.conectar();
            ClMotoCilindDao myDao = new ClMotoCilindDao();
            myDao.delete(conn, clMotoCilindraje);
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public List bucarClGrupoMoto(ClGrupoMoto clGrupoMoto) {
        List res = null;
        try {
            conn = conexion.conectar();
            ClGrupoMotoDao myDao = new ClGrupoMotoDao();
            res = myDao.searchMatching(conn, clGrupoMoto);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public List listarClGrupoMoto() {
        List res = null;
        try {
            conn = conexion.conectar();
            ClGrupoMotoDao myDao = new ClGrupoMotoDao();
            res = myDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public List listarClVigenciasGrupoMoto() {
        List res = null;
        try {
            conn = conexion.conectar();
            ClGrupoMotoDao myDao = new ClGrupoMotoDao();
            res = myDao.loadAllVigencias(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }




    public List getClMotoCilindraje() {
        List lista = null;
        try {
            conn = conexion.conectar();
            ClMotoCilindDao myDao = new ClMotoCilindDao();
            lista = myDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List buscarClMotoCilindraje(ClMotoCilind clMotoCilindraje) {
        List lista = null;
        try {
            conn = conexion.conectar();
            ClMotoCilindDao myDao = new ClMotoCilindDao();
            lista = myDao.searchMatching(conn, clMotoCilindraje);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getExcepCarga() {
        List lista = null;
        try {
            conn = conexion.conectar();
            ClExcepCargaDao myDao = new ClExcepCargaDao();
            lista = myDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public boolean crearExcepCarga(ClExcepCarga excepCarga) {
        boolean res = false;
        int id;
        try {
            conn = conexion.conectar();

            ClExcepCargaDao myDao = new ClExcepCargaDao();
            id = Funciones.obtenerId(conn, "GEN_ID_CLEXCEPCARGA", "GEN_CLEXCEPCARGA", myMotor);
            excepCarga.setID_CLEXCEPCARGA(id);
            myDao.create(conn, excepCarga);
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public boolean eliminarExcepCarga(ClExcepCarga excepCarga) {
        boolean res = false;
        try {
            conn = conexion.conectar();
            ClExcepCargaDao myDao = new ClExcepCargaDao();
            myDao.delete(conn, excepCarga);
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public boolean crearRangoCarga(ClGrupoCarga clGrupoCarga) {
        boolean res = false;
        int id;
        try {
            conn = conexion.conectar();
            ClGrupoCargaDao myDao = new ClGrupoCargaDao();
            id = Funciones.obtenerId(conn, "GEN_ID_CLGRUPOCARGA", "GEN_CLGRUPOCARGA", myMotor);
            clGrupoCarga.setID_CLGRUPOCARGA(id);
            myDao.create(conn, clGrupoCarga);
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public boolean eliminarRangoCarga(ClGrupoCarga clGrupoCarga) {
        boolean res = false;
        try {
            conn = conexion.conectar();
            ClGrupoCargaDao myDao = new ClGrupoCargaDao();
            myDao.delete(conn, clGrupoCarga);
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public List getRangoCarga() {
        List lista = null;
        try {
            conn = conexion.conectar();
            ClGrupoCargaDao myDao = new ClGrupoCargaDao();
            lista = myDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public boolean crearRangoPasajeros(ClGrupoPas clGrupoPas) {
        boolean res = false;
        int id;
        try {
            conn = conexion.conectar();
            ClGrupoPasDao myDao = new ClGrupoPasDao();
            id = Funciones.obtenerId(conn, "GEN_ID_CLGRUPOPAS", "GEN_CLGRUPOPAS", myMotor);
            clGrupoPas.setID_CLGRUPOPAS(id);
            myDao.create(conn, clGrupoPas);
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public boolean eliminarRangoPasajeros(ClGrupoPas clGrupoPas) {
        boolean res = false;
        try {
            conn = conexion.conectar();
            ClGrupoPasDao myDao = new ClGrupoPasDao();
            myDao.delete(conn, clGrupoPas);
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public List getRangoPasajeros() {
        List lista = null;
        try {
            conn = conexion.conectar();
            ClGrupoPasDao myDao = new ClGrupoPasDao();
            lista = myDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getViewGrupoPas(ViewCLGrupoCargaPas tmp) {
        List lista = null;
        try {
            conn = conexion.conectar();
            ViewCLGrupoCargaPasDao myDao = new ViewCLGrupoCargaPasDao();
            if (tmp == null)
                lista = myDao.loadAll(conn);
            else
                lista = myDao.searchMatching(conn, tmp);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public boolean crearGrupoCargaPas(ClGrupoCargaPas clGrupoCargaPas) {
        boolean res = false;
        int id;
        try {
            conn = conexion.conectar();
            ClGrupoCargaPasDao myDao = new ClGrupoCargaPasDao();
            id = Funciones.obtenerId(conn, "GEN_ID_CLGRUPOCARGAPAS", "GEN_CLGRUPOCARGAPAS", myMotor);
            clGrupoCargaPas.setID_CLGRUPOCARGAPAS(id);
            myDao.create(conn, clGrupoCargaPas);
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public boolean eliminarGrupoCargaPas(ClGrupoCargaPas clGrupoCargaPas) {
        boolean res = false;
        try {
            conn = conexion.conectar();
            ClGrupoCargaPasDao myDao = new ClGrupoCargaPasDao();
            myDao.delete(conn, clGrupoCargaPas);
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public List getGrupoCargaPas() {
        List lista = null;
        try {
            conn = conexion.conectar();
            ClGrupoCargaPasDao myDao = new ClGrupoCargaPasDao();
            lista = myDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getVigencias(String tipo) {
        List lista = null;
        if (tipo.equals("A")) {
            try {
                conn = conexion.conectar();
                AvaluoVehiculoDao daoV = new AvaluoVehiculoDao();
                lista = daoV.getVigencias(conn);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                conexion.cerrarCx();
            }
        }
        if (tipo.equals("C") || tipo.equals("P")) {
            try {
                conn = conexion.conectar();
                AvaluoCargaDao daoV = new AvaluoCargaDao();
                lista = daoV.getVigencias(conn);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                conexion.cerrarCx();
            }
        }
        if (tipo.equals("M")) {
            try {
                conn = conexion.conectar();
                AvaluoMotosDao daoV = new AvaluoMotosDao();
                lista = daoV.getVigencias(conn);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                conexion.cerrarCx();
            }
        }
        return lista;
    }

    public List getCarroceria(CarroceriaMin carroceriaMin) {
        List lista = null;
        try {
            conn = conexion.conectar();
            CarroceriaMinDao myDao = new CarroceriaMinDao();
            lista = myDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

}
