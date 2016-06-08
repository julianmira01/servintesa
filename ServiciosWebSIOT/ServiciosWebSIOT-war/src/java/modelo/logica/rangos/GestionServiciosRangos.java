package modelo.logica.rangos;

import java.sql.Connection;
import java.sql.SQLException;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.rangos.DetPlacaGeneradaDao;
import modelo.datos.dao.rangos.DetRangoLicenciaDao;
import modelo.datos.dao.rangos.RangosDeplacasDao;
import modelo.datos.dao.rangos.RangosLicenciasDao;
import modelo.datos.objetos.generales.AuditoriaSystem;
import modelo.datos.objetos.generales.Usuarios;
import modelo.datos.objetos.rangos.DetPlacaGenerada;
import modelo.datos.objetos.rangos.DetRangoLicencia;
import modelo.datos.objetos.rangos.RangosDeplacas;
import modelo.datos.objetos.rangos.RangosLicencias;

import utilidades.Auditoria;
import utilidades.Funciones;


public class GestionServiciosRangos {
    //VehiculoDao vehiculoDao;
    Conexion conexion;
    Connection conn;
    String myMotor;

    public GestionServiciosRangos() {
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

    public List getRangoDePlaca(RangosDeplacas myRangoPlaca) {
        List mylista;
        mylista = null;
        try {
            conn = conexion.conectar();
            RangosDeplacasDao myRangoPlacaDao = new RangosDeplacasDao();
            mylista = myRangoPlacaDao.searchMatching(conn, myRangoPlaca);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return mylista;
    }

    public RangosDeplacas getRangoDePlacaActivo(RangosDeplacas myRangoPlaca) {
        List mylista;
        mylista = null;
        RangosDeplacas tmp = new RangosDeplacas();
        try {
            conn = conexion.conectar();
            RangosDeplacasDao myRangoPlacaDao = new RangosDeplacasDao();
            mylista = myRangoPlacaDao.searchActivos(conn, myRangoPlaca);
            if (mylista != null && mylista.size() > 0)
                tmp = (RangosDeplacas)mylista.get(0);
            else
                tmp.setID_RANGODEPLACA(-1);
        } catch (Exception e) {
            e.printStackTrace();
            tmp.setID_RANGODEPLACA(-1);
        } finally {
            conexion.cerrarCx();
        }
        return tmp;
    }

    public List getRangoDePlacaActivoAll(RangosDeplacas myRangoPlaca) {
        List mylista;
        mylista = null;
        RangosDeplacas tmp = new RangosDeplacas();
        try {
            conn = conexion.conectar();
            RangosDeplacasDao myRangoPlacaDao = new RangosDeplacasDao();
            mylista = myRangoPlacaDao.searchActivos(conn, myRangoPlaca);
        } catch (Exception e) {
            e.printStackTrace();
            mylista = null;
        } finally {
            conexion.cerrarCx();
        }
        return mylista;
    }

    
    public List getRangoDePlacaActivoSinMotos(RangosDeplacas myRangoPlaca) {
        List mylista;
        mylista = null;
        RangosDeplacas tmp = new RangosDeplacas();
        try {
            conn = conexion.conectar();
            RangosDeplacasDao myRangoPlacaDao = new RangosDeplacasDao();
            mylista = myRangoPlacaDao.searchActivosSinMotos(conn, myRangoPlaca);
        } catch (Exception e) {
            e.printStackTrace();
            mylista = null;
        } finally {
            conexion.cerrarCx();
        }
        return mylista;
    }


    public List getRangosDePlacas() {
        List mylista;
        mylista = null;
        try {
            conn = conexion.conectar();
            RangosDeplacasDao myRangoPlacaDao = new RangosDeplacasDao();
            mylista = myRangoPlacaDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return mylista;
    }
    
    public List getRangosDePlacasRemolquesSemiremolques() {
        List mylista;
        mylista = null;
        try {
            conn = conexion.conectar();
            RangosDeplacasDao myRangoPlacaDao = new RangosDeplacasDao();
            mylista = myRangoPlacaDao.loadAllRemolquesSemiremolques(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return mylista;
    }
    
    
    public List getRangosDePlacasMaquinarias() {
        List mylista;
        mylista = null;
        try {
            conn = conexion.conectar();
            RangosDeplacasDao myRangoPlacaDao = new RangosDeplacasDao();
            mylista = myRangoPlacaDao.loadAllMaquinaria(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return mylista;
    }

    public RangosDeplacas insertarRangoDePlacas(RangosDeplacas myRango, String tipovehiculo, Usuarios myusuario,
                                                String host, String ip) {
        boolean valido = false;
        int id;
        int num;
        List lista = null;
        Funciones fnc = new Funciones();
        try {
            conn = conexion.conectar();
            RangosDeplacasDao myRangoPlacaDao = new RangosDeplacasDao();
            if (fnc.menorOIgual(myRango.getLETRA(), myRango.getLETRAFINAL())) {
                if (myRango.getLETRA().equals(myRango.getLETRAFINAL())) {
                    if (myRango.getR_INICIAL() <= myRango.getR_FINAL()) {
                        valido = true;
                    }
                } else {
                    valido = true;
                }
                if (valido) {
                    id = Funciones.obtenerId(conn, "GEN_RANGODEPLACAS", "GEN_RANGODEPLACAS", myMotor);
                    myRango.setID_RANGODEPLACA(id);
                    myRango.setULTIMA_ASIG(-1);
                    myRangoPlacaDao.create(conn, myRango); //crea el rango de placa
                    myRango = new RangosDeplacas();
                    myRango.setID_RANGODEPLACA(id);
                    lista = myRangoPlacaDao.searchMatching(conn, myRango);
                }
            }
            conexion.cerrarCx();
            if (lista != null && lista.size() > 0) {

                myRango = (RangosDeplacas)lista.get(0);
                myRango.setDISPONIBLES(generarPlacas(myRango, tipovehiculo));
                conn = conexion.conectar();
                myRangoPlacaDao.actualizarDisponibles(conn, myRango);
                //************** Aqui auditoria ********
                id = myRango.getID_RANGODEPLACA();
                Auditoria myAuditoria;
                AuditoriaSystem myAuditSx;
                myAuditoria = new Auditoria();
                myAuditSx = new AuditoriaSystem();
                myAuditSx.setTABLAAFECTADA("RANGOSDEPLACAS");
                myAuditSx.setCAMPOCLAVE("ID_RANGODEPLACA");
                myAuditSx.setVLRCAMPOCLAVE(String.valueOf(id));
                myAuditSx.setID_USUARIO(myusuario.getID_USUARIO());
                myAuditSx.setIP(ip);
                myAuditSx.setNOMBREEQUIPO(host);

                myAuditoria.auditarInsersion(conn, myAuditSx, myRango, 0);


                //**************************************
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return myRango;
    }
    
    
    public RangosDeplacas insertarRangoDePlacasRemolquesSemiremolques(RangosDeplacas myRango, String tipovehiculo, Usuarios myusuario,
                                                String host, String ip) {
        boolean valido = false;
        int id;
        int num;
        List lista = null;
        Funciones fnc = new Funciones();
        try {
            conn = conexion.conectar();
            RangosDeplacasDao myRangoPlacaDao = new RangosDeplacasDao();
            if (fnc.menorOIgual(myRango.getLETRA(), myRango.getLETRAFINAL())) {
                if (myRango.getLETRA().equals(myRango.getLETRAFINAL())) {
                    if (myRango.getR_INICIAL() <= myRango.getR_FINAL()) {
                        valido = true;
                    }
                } else {
                    valido = true;
                }
                if (valido) {
                    id = Funciones.obtenerId(conn, "GEN_RANGODEPLACAS", "GEN_RANGODEPLACAS", myMotor);
                    myRango.setID_RANGODEPLACA(id);
                    myRango.setULTIMA_ASIG(-1);
                    myRangoPlacaDao.create(conn, myRango); //crea el rango de placa
                    myRango = new RangosDeplacas();
                    myRango.setID_RANGODEPLACA(id);
                    lista = myRangoPlacaDao.searchMatching(conn, myRango);
                }
            }
            conexion.cerrarCx();
            if (lista != null && lista.size() > 0) {

                myRango = (RangosDeplacas)lista.get(0);
                myRango.setDISPONIBLES(generarPlacasRemolquesSemiremolques(myRango, tipovehiculo));
                conn = conexion.conectar();
                myRangoPlacaDao.actualizarDisponibles(conn, myRango);
                //************** Aqui auditoria ********
                id = myRango.getID_RANGODEPLACA();
                Auditoria myAuditoria;
                AuditoriaSystem myAuditSx;
                myAuditoria = new Auditoria();
                myAuditSx = new AuditoriaSystem();
                myAuditSx.setTABLAAFECTADA("RANGOSDEPLACAS");
                myAuditSx.setCAMPOCLAVE("ID_RANGODEPLACA");
                myAuditSx.setVLRCAMPOCLAVE(String.valueOf(id));
                myAuditSx.setID_USUARIO(myusuario.getID_USUARIO());
                myAuditSx.setIP(ip);
                myAuditSx.setNOMBREEQUIPO(host);

                myAuditoria.auditarInsersion(conn, myAuditSx, myRango, 0);


                //**************************************
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return myRango;
    }


    public RangosDeplacas insertarRangoDePlacasMaquinaria(RangosDeplacas myRango, String tipovehiculo, Usuarios myusuario,
                                                String host, String ip) {
        boolean valido = false;
        int id;
        int num;
        List lista = null;
        Funciones fnc = new Funciones();
        try {
            conn = conexion.conectar();
            RangosDeplacasDao myRangoPlacaDao = new RangosDeplacasDao();
            if (fnc.menorOIgual(myRango.getLETRA(), myRango.getLETRAFINAL())) {
                if (myRango.getLETRA().equals(myRango.getLETRAFINAL())) {
                    if (myRango.getR_INICIAL() <= myRango.getR_FINAL()) {
                        valido = true;
                    }
                } else {
                    valido = true;
                }
                if (valido) {
                    id = Funciones.obtenerId(conn, "GEN_RANGODEPLACAS", "GEN_RANGODEPLACAS", myMotor);
                    myRango.setID_RANGODEPLACA(id);
                    myRango.setULTIMA_ASIG(-1);
                    myRangoPlacaDao.create(conn, myRango); //crea el rango de placa
                    myRango = new RangosDeplacas();
                    myRango.setID_RANGODEPLACA(id);
                    lista = myRangoPlacaDao.searchMatching(conn, myRango);
                }
            }
            conexion.cerrarCx();
            if (lista != null && lista.size() > 0) {

                myRango = (RangosDeplacas)lista.get(0);
                myRango.setDISPONIBLES(generarPlacasMaquinaria(myRango, tipovehiculo));
                conn = conexion.conectar();
                myRangoPlacaDao.actualizarDisponibles(conn, myRango);
                //************** Aqui auditoria ********
                id = myRango.getID_RANGODEPLACA();
                Auditoria myAuditoria;
                AuditoriaSystem myAuditSx;
                myAuditoria = new Auditoria();
                myAuditSx = new AuditoriaSystem();
                myAuditSx.setTABLAAFECTADA("RANGOSDEPLACAS");
                myAuditSx.setCAMPOCLAVE("ID_RANGODEPLACA");
                myAuditSx.setVLRCAMPOCLAVE(String.valueOf(id));
                myAuditSx.setID_USUARIO(myusuario.getID_USUARIO());
                myAuditSx.setIP(ip);
                myAuditSx.setNOMBREEQUIPO(host);

                myAuditoria.auditarInsersion(conn, myAuditSx, myRango, 0);


                //**************************************
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return myRango;
    }
    

    public RangosDeplacas editarRangoDePlacas(RangosDeplacas myRango, Usuarios myusuario, String host, String ip) {
        int id;
        int num;
        List lista;
        try {
            conn = conexion.conectar();
            RangosDeplacasDao myRangoPlacaDao = new RangosDeplacasDao();
            RangosDeplacas rango_old = myRango;
            myRangoPlacaDao.cambiaDatosRadicacion(conn, myRango);
            id = myRango.getID_RANGODEPLACA();
            myRango = new RangosDeplacas();
            myRango.setID_RANGODEPLACA(id);
            lista = myRangoPlacaDao.searchMatching(conn, myRango);
            if (lista != null && lista.size() > 0) {
                myRango = (RangosDeplacas)lista.get(0);
                RangosDeplacas rango_new = myRango;

                //************** Aqui auditoria ********
                id = myRango.getID_RANGODEPLACA();
                Auditoria myAuditoria;
                AuditoriaSystem myAuditSx;
                myAuditoria = new Auditoria();
                myAuditSx = new AuditoriaSystem();
                myAuditSx.setTABLAAFECTADA("RANGOSDEPLACAS");
                myAuditSx.setCAMPOCLAVE("ID_RANGODEPLACA");
                myAuditSx.setVLRCAMPOCLAVE(String.valueOf(id));
                myAuditSx.setID_USUARIO(myusuario.getID_USUARIO());
                myAuditSx.setIP(ip);
                myAuditSx.setNOMBREEQUIPO(host);
                myAuditoria.auditarEdicion(conn, myAuditSx, rango_old, rango_new, ip, host, 0);

                //**************************************


            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return myRango;
    }


    public int generarPlacas(RangosDeplacas myRango, String tipoVehiculo) throws SQLException {
        int cantidad = 0;
        DetPlacaGenerada myDetPlaca;
        myDetPlaca = new DetPlacaGenerada();
        String superior = myRango.getLETRAFINAL(); //fija el tope
        String tmp = myRango.getLETRA(); //fija el valor inicial
        int max = 999;
        int min;
        int id;
        char[] arreglo;
        Funciones fnc;
        fnc = new Funciones();
        min = myRango.getR_INICIAL(); // fija el minimo numerico
        DetPlacaGeneradaDao myDetPlacaDao = new DetPlacaGeneradaDao();

        if (myRango.getID_CVEHICULO() == 10) {
            max = 99;
        }
        if (tipoVehiculo.equalsIgnoreCase("motocicleta"))
            max = 99;


        while (fnc.menorOIgual(tmp, superior)) {
            conn = conexion.conectar();
            if (tmp.equals(superior)) {
                max = myRango.getR_FINAL();
            }
            for (int i = min; i <= max; i++) {
                id = Funciones.obtenerId(conn, "GEN_DETPLACAGEN", "GEN_DETPLACAGEN", myMotor);
                myDetPlaca.setIDDET_PLACAGEN(id);
                myDetPlaca.setIDRANGOPLACA(myRango.getID_RANGODEPLACA());
                myDetPlaca.setASIGNADA("F");

                if (tipoVehiculo.equalsIgnoreCase("motocicleta")) {
                    String numeroplaca = numeroToString(i);
                    numeroplaca = numeroplaca.substring(numeroplaca.length() - 2, numeroplaca.length());

                    if (myRango.getSUFIJO_PLACA() != null)
                        myDetPlaca.setPLACAGEN(tmp + numeroplaca + myRango.getSUFIJO_PLACA());
                    else
                        myDetPlaca.setPLACAGEN(tmp + numeroplaca);
                


                } else if (tipoVehiculo.equalsIgnoreCase("motocarro")) {
                    myDetPlaca.setPLACAGEN(numeroToString(i) + tmp);
                } else {
                    myDetPlaca.setPLACAGEN(tmp + numeroToString(i));
                }

                myDetPlacaDao.create(conn, myDetPlaca);
                //System.out.println("placa: "+tmp+myDetPlaca.getPLACAGEN());
                cantidad++;
            }
            min = 0;
            System.out.println("Va en : " + tmp);
            arreglo = fnc.convertirStringToChar(tmp);

            if (!tmp.equals("ZZZ"))
                tmp = fnc.incrementar(arreglo);
            else {
                conexion.cerrarCx();
                break;
            }

            conexion.cerrarCx();
        }
        System.out.println("Se generaron: " + cantidad);
        return cantidad;
    }
    
    
    public int generarPlacasRemolquesSemiremolques(RangosDeplacas myRango, String tipoVehiculo) throws SQLException {
        int cantidad = 0;
        DetPlacaGenerada myDetPlaca;
        myDetPlaca = new DetPlacaGenerada();
        String superior = myRango.getLETRAFINAL(); //fija el tope
        String tmp = myRango.getLETRA(); //fija el valor inicial
        int max = 99999;
        int min;
        int id;
        char[] arreglo;
        Funciones fnc;
        fnc = new Funciones();
        min = myRango.getR_INICIAL(); // fija el minimo numerico
        DetPlacaGeneradaDao myDetPlacaDao = new DetPlacaGeneradaDao();

        while (fnc.menorOIgual(tmp, superior)) {
            conn = conexion.conectar();
            if (tmp.equals(superior)) {
                max = myRango.getR_FINAL();
            }
            
            for (int i = min; i <= max; i++) {
                id = Funciones.obtenerId(conn, "GEN_DETPLACAGEN", "GEN_DETPLACAGEN", myMotor);
                myDetPlaca.setIDDET_PLACAGEN(id);
                myDetPlaca.setIDRANGOPLACA(myRango.getID_RANGODEPLACA());
                myDetPlaca.setASIGNADA("F");

                myDetPlaca.setPLACAGEN(tmp + numeroToStringRemolquesSemiremolques(i));
                
                DetPlacaGenerada tmpPlaca;
                tmpPlaca = new DetPlacaGenerada();
                tmpPlaca.setPLACAGEN(myDetPlaca.getPLACAGEN());
                List lstPlacas = myDetPlacaDao.searchMatching(conn, tmpPlaca);
                
                if (lstPlacas != null && lstPlacas.size() > 0)
                {
                    cantidad--;
                    System.out.println("La placa " + myDetPlaca.getPLACAGEN() + " ya existe en la base de datos por lo tanto no se creo.");
                }
                else
                    myDetPlacaDao.createRemolquesSemiremolques(conn, myDetPlaca);
                //System.out.println("placa: "+tmp+myDetPlaca.getPLACAGEN());
                cantidad++;
            }
            min = 0;
            System.out.println("Va en : " + tmp);
            arreglo = fnc.convertirStringToChar(tmp);

            if (!tmp.equals("ZZZ"))
                tmp = fnc.incrementar(arreglo);
            else {
                conexion.cerrarCx();
                break;
            }

            conexion.cerrarCx();
        }
        System.out.println("Se generaron: " + cantidad);
        return cantidad;
    }

    public int generarPlacasMaquinaria(RangosDeplacas myRango, String tipoVehiculo) throws SQLException {
        int cantidad = 0;
        DetPlacaGenerada myDetPlaca;
        myDetPlaca = new DetPlacaGenerada();
        String superior = myRango.getLETRAFINAL(); //fija el tope
        String tmp = myRango.getLETRA(); //fija el valor inicial
        int max = 999999;
        int min;
        int id;
        char[] arreglo;
        Funciones fnc;
        fnc = new Funciones();
        min = myRango.getR_INICIAL(); // fija el minimo numerico
        DetPlacaGeneradaDao myDetPlacaDao = new DetPlacaGeneradaDao();

        while (fnc.menorOIgual(tmp, superior)) {
            conn = conexion.conectar();
            if (tmp.equals(superior)) {
                max = myRango.getR_FINAL();
            }
            
            for (int i = min; i <= max; i++) {
                id = Funciones.obtenerId(conn, "GEN_DETPLACAGEN", "GEN_DETPLACAGEN", myMotor);
                myDetPlaca.setIDDET_PLACAGEN(id);
                myDetPlaca.setIDRANGOPLACA(myRango.getID_RANGODEPLACA());
                myDetPlaca.setASIGNADA("F");

                myDetPlaca.setPLACAGEN(tmp + numeroToStringMaquinaria(i));
                
                DetPlacaGenerada tmpPlaca;
                tmpPlaca = new DetPlacaGenerada();
                tmpPlaca.setPLACAGEN(myDetPlaca.getPLACAGEN());
                List lstPlacas = myDetPlacaDao.searchMatching(conn, tmpPlaca);
                
                if (lstPlacas != null && lstPlacas.size() > 0)
                {
                    cantidad--;
                    System.out.println("La placa " + myDetPlaca.getPLACAGEN() + " ya existe en la base de datos por lo tanto no se creo.");
                }
                else
                    myDetPlacaDao.createRemolquesSemiremolques(conn, myDetPlaca);
                //System.out.println("placa: "+tmp+myDetPlaca.getPLACAGEN());
                cantidad++;
            }
            min = 0;
            System.out.println("Va en : " + tmp);
            arreglo = fnc.convertirStringToChar(tmp);

            if (!tmp.equals("ZZZ"))
                tmp = fnc.incrementar(arreglo);
            else {
                conexion.cerrarCx();
                break;
            }

            conexion.cerrarCx();
        }
        System.out.println("Se generaron: " + cantidad);
        return cantidad;
    }

    public String numeroToString(int numero) {
        String myNumero = "";
        if (numero / 10 == 0) {
            myNumero = "0" + myNumero;
        }
        if (numero / 100 == 0) {
            myNumero = "0" + myNumero;
        }
        myNumero = myNumero + String.valueOf(numero);
        return myNumero;
    }

    public String numeroToStringRemolquesSemiremolques(int numero) {
        String myNumero = "";
        try {
            String strNum = Integer.toString(numero);
            if (strNum.length() == 1)
                myNumero = "0000";
            
            if (strNum.length() == 2)
                myNumero = "000"; 
            
            if (strNum.length() == 3)
                myNumero = "00";
            
            if (strNum.length() == 4)
                myNumero = "0";

            if (strNum.length() > 4)
                myNumero = ""; 
            
            myNumero = myNumero + strNum;
            return myNumero;    
        }
        catch (Exception exp) {
            myNumero = "00001";
            System.out.println(exp.getStackTrace());
            return myNumero;
        }
    }
    
    public String numeroToStringMaquinaria(int numero) {
        String myNumero = "";
        try {
            String strNum = Integer.toString(numero);
            if (strNum.length() == 1)
                myNumero = "00000";
            
            if (strNum.length() == 2)
                myNumero = "0000"; 
            
            if (strNum.length() == 3)
                myNumero = "000";
            
            if (strNum.length() == 4)
                myNumero = "00";
            
            if (strNum.length() == 5)
                myNumero = "0";

            if (strNum.length() > 5)
                myNumero = ""; 
            
            myNumero = myNumero + strNum;
            return myNumero;    
        }
        catch (Exception exp) {
            myNumero = "00001";
            System.out.println(exp.getStackTrace());
            return myNumero;
        }
    }

    public void insertarDetPlacaGenerada(DetPlacaGenerada myDetPlacaGen) {
        int id;
        int num;
        try {
            conn = conexion.conectar();
            DetPlacaGeneradaDao myDetPlacaGenDao = new DetPlacaGeneradaDao();
            id = Funciones.obtenerId(conn, "GEN_DETPLACAGEN", "GEN_DETPLACAGEN", myMotor);
            myDetPlacaGen.setIDDET_PLACAGEN(id);
            myDetPlacaGen.setASIGNADA("F");
            myDetPlacaGenDao.create(conn, myDetPlacaGen);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
    }
    
    public boolean editarDetPlacaGenerada(DetPlacaGenerada myDetPlacaGen)
    {
      boolean result=false;    
      try
      {
          conn = conexion.conectar();
          DetPlacaGeneradaDao myDetPlacaGenDao = new DetPlacaGeneradaDao();
          myDetPlacaGenDao.save(conn, myDetPlacaGen);
          result = true;
      }
      catch(Exception exp)
      {
        exp.printStackTrace();
        result=false;
      }
        
        
      return result;
    }
    

    public List getDetPlacaGenerada(DetPlacaGenerada myDetPlacaGen) {
        List lista = null;
        try {
            conn = conexion.conectar();
            DetPlacaGeneradaDao myDetPlacaGenDao = new DetPlacaGeneradaDao();
            lista = myDetPlacaGenDao.searchMatching(conn, myDetPlacaGen);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
    
    

    public String getPlaca(int id) {
        String res = "";
        try {
            conn = conexion.conectar();
            DetPlacaGenerada myDetPlacaGen = new DetPlacaGenerada();
            myDetPlacaGen.setIDDET_PLACAGEN(id);
            DetPlacaGeneradaDao myDetPlacaGenDao = new DetPlacaGeneradaDao();
            myDetPlacaGenDao.load(conn, myDetPlacaGen);
            res = myDetPlacaGen.getPLACAGEN();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public List getRangosLicencias() {
        List mylista;
        mylista = null;
        try {
            conn = conexion.conectar();
            RangosLicenciasDao myRangoLicenciaDao = new RangosLicenciasDao();
            mylista = myRangoLicenciaDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return mylista;
    }

    public List getRangoLicencia(RangosLicencias myRangoLicencia) {
        List mylista;
        mylista = null;
        try {
            conn = conexion.conectar();
            RangosLicenciasDao myRangoLicenciaDao = new RangosLicenciasDao();
            mylista = myRangoLicenciaDao.searchMatching(conn, myRangoLicencia);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return mylista;
    }

    public RangosLicencias insertarRangoLicencias(RangosLicencias myRango) {
        int id;
        int num;
        List lista;
        try {
            conn = conexion.conectar();
            RangosLicenciasDao myRangoDao = new RangosLicenciasDao();
            id = Funciones.obtenerId(conn, "GEN_RANGOSDELICENCIA", "GEN_RANGOSDELICENCIA", myMotor);
            myRango.setID_RANGO(id);
            myRango.setULT_ASIGNADA(-1);
            myRangoDao.create(conn, myRango);
            myRango = new RangosLicencias();
            myRango.setID_RANGO(id);
            lista = myRangoDao.searchMatching(conn, myRango);
            if (lista != null && lista.size() > 0) {
                myRango = (RangosLicencias)lista.get(0);
                myRango.setDISPONIBLES(generarLicencias(myRango));
                myRangoDao.actualizarDisponibles(conn, myRango);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return myRango;
    }

    public RangosLicencias editarRangoLicencias(RangosLicencias myRango) {
        int id;
        int num;
        List lista;
        try {
            conn = conexion.conectar();
            RangosLicenciasDao myRangoDao = new RangosLicenciasDao();
            myRangoDao.cambiaDatosRadicacion(conn, myRango);
            id = myRango.getID_RANGO();
            myRango = new RangosLicencias();
            myRango.setID_RANGO(id);
            lista = myRangoDao.searchMatching(conn, myRango);
            if (lista != null && lista.size() > 0) {
                myRango = (RangosLicencias)lista.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return myRango;
    }

    public int generarLicencias(RangosLicencias myRango) throws SQLException {
        int cantidad = 0;
        DetRangoLicencia myDet;
        myDet = new DetRangoLicencia();
        int id;
        Funciones fnc;
        fnc = new Funciones();
        DetRangoLicenciaDao myDetDao = new DetRangoLicenciaDao();
        for (int i = myRango.getR_INICIAL(); i <= myRango.getR_FINAL(); i++) {
            id = Funciones.obtenerId(conn, "GEN_DETRANGOLICENCIA", "GEN_DETRANGOLICENCIA", myMotor);
            myDet.setIDDET_RANGOLIC(id);
            myDet.setIDRANGO_LIC(myRango.getID_RANGO());
            myDet.setASIGNADO("F");
            myDet.setNUMESP_VENAL(numeroToString(i));
            myDetDao.create(conn, myDet);
            cantidad++;
        }
        System.out.println("Se generaron: " + cantidad);
        return cantidad;
    }

    public boolean registrarPlaca(int idPlaca) {
        boolean res = false;
        List lista = null;
        try {
            conn = conexion.conectar();
            DetPlacaGenerada placa = new DetPlacaGenerada();
            DetPlacaGeneradaDao placaDao = new DetPlacaGeneradaDao();
            placa.setIDDET_PLACAGEN(idPlaca);
            lista = placaDao.searchMatching(conn, placa);
            if (lista != null && lista.size() > 0) {
                placa = (DetPlacaGenerada)lista.get(0);
                placa.setASIGNADA("T");
                placaDao.save(conn, placa);
                RangosDeplacas rango = new RangosDeplacas();
                RangosDeplacasDao rangoDao = new RangosDeplacasDao();
                rango.setID_RANGODEPLACA(placa.getIDRANGOPLACA());
                lista = null;
                lista = rangoDao.searchMatching(conn, rango);
                if (lista != null && lista.size() > 0) {
                    rango = (RangosDeplacas)lista.get(0);
                    rango.setDISPONIBLES(rango.getDISPONIBLES() - 1);
                    rangoDao.save(conn, rango);
                    res = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public boolean liberarPlaca(int idPlaca) {
        boolean res = false;
        List lista = null;
        try {
            conn = conexion.conectar();
            DetPlacaGenerada placa = new DetPlacaGenerada();
            DetPlacaGeneradaDao placaDao = new DetPlacaGeneradaDao();
            placa.setIDDET_PLACAGEN(idPlaca);
            lista = placaDao.searchMatching(conn, placa);
            if (lista != null && lista.size() > 0) {
                placa = (DetPlacaGenerada)lista.get(0);
                placa.setASIGNADA("F");
                placaDao.save(conn, placa);
                RangosDeplacas rango = new RangosDeplacas();
                RangosDeplacasDao rangoDao = new RangosDeplacasDao();
                rango.setID_RANGODEPLACA(placa.getIDRANGOPLACA());
                lista = null;
                lista = rangoDao.searchMatching(conn, rango);
                if (lista != null && lista.size() > 0) {
                    rango = (RangosDeplacas)lista.get(0);
                    rango.setDISPONIBLES(rango.getDISPONIBLES() + 1);
                    rangoDao.save(conn, rango);
                    res = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public boolean eliminarRango(RangosDeplacas rango, Usuarios myusuario, String host, String ip) {
        List listaPlacasUsadas = null;
        try {
            conn = conexion.conectar();
            DetPlacaGeneradaDao detplacaDao = new DetPlacaGeneradaDao();
            DetPlacaGenerada tmpplaca = new DetPlacaGenerada();
            tmpplaca.setIDRANGOPLACA(rango.getID_RANGODEPLACA());
            tmpplaca.setASIGNADA("T");
            listaPlacasUsadas = detplacaDao.searchMatching(conn, tmpplaca);
            if (listaPlacasUsadas.size() > 0) {
                return false;
            } else {
                List listaplacasborrar = null;
                RangosDeplacasDao rangoPlacaDao = new RangosDeplacasDao();
                DetPlacaGenerada placabaseborrar = new DetPlacaGenerada();
                placabaseborrar.setIDRANGOPLACA(rango.getID_RANGODEPLACA());
                listaplacasborrar = detplacaDao.searchMatching(conn, placabaseborrar);
                //Borrando placas del rango ********************************
                for (int i = 0; i < listaplacasborrar.size(); i++) {
                    detplacaDao.delete(conn, (DetPlacaGenerada)listaplacasborrar.get(i));
                }
                //**********************************************************

                rangoPlacaDao.delete(conn, rango);

                //************** Aqui auditoria ********
                int id = rango.getID_RANGODEPLACA();
                Auditoria myAuditoria;
                AuditoriaSystem myAuditSx;
                myAuditoria = new Auditoria();
                myAuditSx = new AuditoriaSystem();
                myAuditSx.setTABLAAFECTADA("RANGOSDEPLACAS");
                myAuditSx.setCAMPOCLAVE("ID_RANGODEPLACA");
                myAuditSx.setVLRCAMPOCLAVE(String.valueOf(id));
                myAuditSx.setID_USUARIO(myusuario.getID_USUARIO());
                myAuditSx.setIP(ip);
                myAuditSx.setNOMBREEQUIPO(host);

                myAuditoria.auditarEliminacion(conn, myAuditSx, rango, 0);

                //**************************************


                return true;
            }


        } catch (Exception e) {
            return false;
        }


    }


}
