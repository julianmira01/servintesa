package modelo.logica.documentos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import modelo.conexion.Conexion;

import modelo.datos.dao.comparendos.generales.TransitoCompDao;
import modelo.datos.dao.documentos.PlantillaDao;
import modelo.datos.dao.documentos.SqlPlantillaDao;
import modelo.datos.dao.documentos.digitales.ElementoDigitalDao;
import modelo.datos.dao.documentos.digitales.ElementoTipoDocumentoDao;
import modelo.datos.dao.documentos.digitales.TipoDocumentoDao;
import modelo.datos.dao.documentos.digitales.ViewElementoIndicesDao;
import modelo.datos.dao.resoluciones.ResolucionInfraccionesCompDao;
import modelo.datos.dao.resoluciones.ResolucionesComparendoCompDao;
import modelo.datos.dao.resoluciones.TipoResolucionCompDao;
import modelo.datos.dao.resoluciones.ViewResolucionesInfractorCompDao;
import modelo.datos.objetos.comparendos.generales.TransitoComp;
import modelo.datos.objetos.documentos.DatosMetaDatos;
import modelo.datos.objetos.documentos.Plantilla;
import modelo.datos.objetos.documentos.SqlPlantilla;
import modelo.datos.objetos.documentos.digitales.ElementoDigital;
import modelo.datos.objetos.documentos.digitales.ElementoTipoDocumento;
import modelo.datos.objetos.documentos.digitales.TipoDocumento;
import modelo.datos.objetos.documentos.digitales.ViewElementoIndices;
import modelo.datos.objetos.generales.AuditoriaSystem;
import modelo.datos.objetos.resoluciones.ResolucionInfraccionesComp;
import modelo.datos.objetos.resoluciones.ResolucionesComparendoComp;
import modelo.datos.objetos.resoluciones.TipoResolucionComp;
import modelo.datos.objetos.resoluciones.ViewResolucionesInfractorComp;

import modelo.datos.dao.resoluciones.ViewnumerosresolucionDao;
import modelo.datos.objetos.resoluciones.Viewnumerosresolucion;

import modelo.datos.dao.resoluciones.VigenciasDao;
import modelo.datos.objetos.resoluciones.Vigencias;
import modelo.datos.dao.resoluciones.NumerosresoluciondispDao;
import modelo.datos.objetos.resoluciones.Numerosresoluciondisp;


import modelo.datos.objetos.resoluciones.Docsresoluciones;
import modelo.datos.dao.resoluciones.DocsresolucionesDao;

import modelo.datos.objetos.documentos.Tipodocgenerar;
import modelo.datos.dao.documentos.TipodocgenerarDao;

import utilidades.Auditoria;
import utilidades.Funciones;

public class GestionServiciosDocumentos {
    Conexion conexion;
    Connection conn;
    String myMotor;

    public GestionServiciosDocumentos() {
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

    /**
     * Busca los registros que coincidan con los datos enviados
     * @param Viewnumerosresolucion obj
     * @return Retorna la lista de los registros que coinciden
   */  
    public int obtenerNumResolucion(int numero, int modulo) {
        boolean secuencial = false;
        
        TransitoComp myTransito = new TransitoComp();
        Funciones fnc = new Funciones();
        TransitoCompDao myTranCompDao = new TransitoCompDao();
        
        ResolucionesComparendoCompDao myresCompDao = new ResolucionesComparendoCompDao();
        ResolucionesComparendoComp myResComp = new ResolucionesComparendoComp(); //Se crea un obj para usar en la busqueda del numero
        
        System.out.println("antes de buscar: " + numero);
        
        try {
            if (modulo == 0)
                conn = conexion.conectar();
            else
                conn = conexion.conectarComparendos();
            
            if (numero <= 0) //Si el numero recibido es menor o igual a 0
            {
                myTransito = (TransitoComp)(myTranCompDao.loadAll(conn)).get(0);
                numero = myTransito.getNRORESOLUCION();
                secuencial = true;
                System.out.println("numero de la baseDD: " + numero);
            }
            myResComp.setNUMERO(String.valueOf(numero));
            while (myresCompDao.countNumber(conn, myResComp) >
                   0) //Si el numero ya existe se incrementa y se vuelve a buscar
            {
                numero++;
                myResComp.setNUMERO(String.valueOf(numero));
            }
            System.out.println("finalizo la busqueda: " + numero);
            if (secuencial) {
                myTransito.setNRORESOLUCION(numero + 1);
                myTranCompDao.actualizarNroResolucion(conn, myTransito);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return numero;        
    }

    public ResolucionesComparendoComp insertarResolucionComparendo(ResolucionesComparendoComp myResComp, int idUsuario,
                                                                   String myIp, String myHost) {
        int id;
        List lista = null;
        Funciones fnc = new Funciones();
        try {
            conn = conexion.conectarComparendos();
            ResolucionesComparendoCompDao myResCompDao = new ResolucionesComparendoCompDao();
            myMotor = myMotor.toUpperCase();
            id = Funciones.obtenerId(conn, "GEN_RESOLUCIONCOMPARENDO", "GEN_RESOLUCIONCOMPARENDO", myMotor);
            
            myResComp.setID(id);
            myResComp.setFECHAREGISTRO(Funciones.getFechaSistema(conn,myMotor));
            
            myResCompDao.create(conn, myResComp);
            myResComp = new ResolucionesComparendoComp();
            myResComp.setID(id);
            lista = myResCompDao.searchMatching(conn, myResComp);
            if (lista != null && lista.size() > 0) {
                myResComp = (ResolucionesComparendoComp)lista.get(0);
            }
            //auditar insert
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("RESOLUCIONESCOMPARENDO");
            myAuditSx.setCAMPOCLAVE("ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(myResComp.getID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, myResComp, 0);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return myResComp;
    }

    public ResolucionInfraccionesComp insertarResolucionInfracciones(ResolucionInfraccionesComp myResInf,
                                                                     int idUsuario, String myIp, String myHost) {
        int id;
        List lista = null;
        Funciones fnc = new Funciones();
        try {
            conn = conexion.conectarComparendos();
            ResolucionInfraccionesCompDao myResInfDao = new ResolucionInfraccionesCompDao();
            myMotor = myMotor.toUpperCase();
            id = Funciones.obtenerId(conn, "GENRESOLUCIONINFRACCIONES", "GEN_RESOLUCIONINFRACCIONES", myMotor);
            myResInf.setID(id);
            myResInfDao.create(conn, myResInf);
            myResInf = new ResolucionInfraccionesComp();
            myResInf.setID(id);
            lista = myResInfDao.searchMatching(conn, myResInf);
            if (lista != null && lista.size() > 0) {
                myResInf = (ResolucionInfraccionesComp)lista.get(0);
            }
            //auditar insert
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("RESOLUCIONINFRACCIONES");
            myAuditSx.setCAMPOCLAVE("ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(myResInf.getID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, myResInf, 0);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return myResInf;
    }
    
  public ResolucionInfraccionesComp buscarPrimeroResolucionInfracciones(ResolucionInfraccionesComp obj) {
     List lista = null;
     try {
      
        ResolucionInfraccionesCompDao dao = new ResolucionInfraccionesCompDao();
         
       //conn = conexion.conectar();
       conn = conexion.conectarComparendos();         
         
         lista = dao.searchMatching(conn, obj);
         if (lista != null && lista.size() > 0) {
             obj = (ResolucionInfraccionesComp)lista.get(0);
         }
         else {
            obj.setID(-1);
         }
     } catch (Exception e) {
         e.printStackTrace();
         obj.setID(-1);
     } finally {
         conexion.cerrarCx();
     }
     return obj;
  }
    

    public boolean validarNumeroResolucion(String numResol, int modulo) {
        boolean valido = false;
        int id;
        List lista = null;
        try {
            if (modulo == 0)
                conn = conexion.conectar();
            else
                conn = conexion.conectarComparendos();
            
            ResolucionesComparendoComp myResComp = new ResolucionesComparendoComp();
            ResolucionesComparendoCompDao myResCompDao = new ResolucionesComparendoCompDao();
            myResComp.setNUMERO(numResol);            
            lista = myResCompDao.searchMatching(conn, myResComp);
            if (lista != null && lista.size() > 0) {
                valido = false;
            } else
                valido = true;
        } catch (Exception e) {
            e.printStackTrace();
            valido = false;
        } finally {
            conexion.cerrarCx();
        }
        return valido;
    }

    public TipoResolucionComp insertarTipoResolucion(TipoResolucionComp myTipoResol, int modulo) {
        int id;
        List lista = null;
        Funciones fnc = new Funciones();
        try {
            if (modulo == 0)
                conn = conexion.conectar();
            else
                conn = conexion.conectarComparendos();
            TipoResolucionCompDao myTipoResolDao = new TipoResolucionCompDao();
            if (!myMotor.equals("ORACLE"))
                id = Funciones.getId_FB(conn, "GEN_TIPORESOLUCION");
            else
                id = Funciones.getId_Oracle(conn, "GEN_TIPORESOLUCION");
            myTipoResol.setIDTIPORESOLUCION(id);
            myTipoResolDao.create(conn, myTipoResol);
            myTipoResol = new TipoResolucionComp();
            myTipoResol.setIDTIPORESOLUCION(id);
            lista = myTipoResolDao.searchMatching(conn, myTipoResol);
            if (lista != null && lista.size() > 0) {
                myTipoResol = (TipoResolucionComp)lista.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return myTipoResol;
    }

    public List getTipoResolucion(int modulo) {
        List mylista;
        mylista = null;
        try {
            if (modulo == 0)
                conn = conexion.conectar();
            else
                conn = conexion.conectarComparendos();
            TipoResolucionCompDao myTipoResCompDao = new TipoResolucionCompDao();
            mylista = myTipoResCompDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return mylista;
    }

    public List getPlantillas(int modulo) {
        List mylista;
        mylista = null;
        try {
            if (modulo == 0)
                conn = conexion.conectar();
            else
                conn = conexion.conectarComparendos();
            PlantillaDao myPlantillaDao = new PlantillaDao();
            mylista = myPlantillaDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return mylista;
    }

    public List getPlantillas(Plantilla myPlantilla, int modulo) {
        List mylista;
        mylista = null;
        try {
            if (modulo == 0)
                conn = conexion.conectar();
            else
                conn = conexion.conectarComparendos();
            PlantillaDao myPlantillaDao = new PlantillaDao();
            mylista = myPlantillaDao.searchMatching(conn, myPlantilla);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return mylista;
    }

    public List getTipoResolucion(TipoResolucionComp myTipoRes, int modulo) {
        List myLista;
        myLista = null;
        try {
            if (modulo == 0)
                conn = conexion.conectar();
            else
                conn = conexion.conectarComparendos();
            TipoResolucionCompDao myTipoResDao = new TipoResolucionCompDao();
            myLista = myTipoResDao.searchMatching(conn, myTipoRes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return myLista;
    }

    public List getSqlPlantillas(SqlPlantilla mySqlPlantilla, int modulo) {
        List mylista;
        mylista = null;
        try {
            if (modulo == 0)
                conn = conexion.conectar();
            else
                conn = conexion.conectarComparendos();
            SqlPlantillaDao mySqlPlantillaDao = new SqlPlantillaDao();
            mylista = mySqlPlantillaDao.searchMatching(conn, mySqlPlantilla);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return mylista;
    }

    public Plantilla insertarPlantilla(Plantilla myPlantilla, int modulo) {
        int id;
        List lista = null;
        Funciones fnc = new Funciones();
        try {
            if (modulo == 0)
                conn = conexion.conectar();
            else
                conn = conexion.conectarComparendos();
            PlantillaDao myPlantillaDao = new PlantillaDao();
            if (!myMotor.equals("ORACLE"))
                id = Funciones.getId_FB(conn, "GEN_PLANTILLA");
            else
                id = Funciones.getId_Oracle(conn, "GEN_PLANTILLA");
            myPlantilla.setID(id);
            myPlantillaDao.create(conn, myPlantilla);
            myPlantilla = new Plantilla();
            myPlantilla.setID(id);
            lista = myPlantillaDao.searchMatching(conn, myPlantilla);
            if (lista != null && lista.size() > 0) {
                myPlantilla = (Plantilla)lista.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return myPlantilla;
    }

    public boolean eliminarPlantilla(Plantilla Plantilla, int modulo) {
        int id;
        List lista = null;
        boolean eliminado = true;
        try {
            if (modulo == 0)
                conn = conexion.conectar();
            else
                conn = conexion.conectarComparendos();
            PlantillaDao PlantillaDao = new PlantillaDao();
            id = Plantilla.getID();
            PlantillaDao.delete(conn, Plantilla);
            Plantilla = new Plantilla();
            Plantilla.setID(id);
            lista = PlantillaDao.searchMatching(conn, Plantilla);
            if (lista != null && lista.size() > 0) {
                eliminado = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return eliminado;
    }

    public Plantilla actualizarPlantilla(Plantilla myPlantilla, int modulo) {
        int id;
        List lista = null;
        Funciones fnc = new Funciones();
        try {
            if (modulo == 0)
                conn = conexion.conectar();
            else
                conn = conexion.conectarComparendos();
            PlantillaDao myPlantillaDao = new PlantillaDao();
            id = myPlantilla.getID();
            myPlantillaDao.save(conn, myPlantilla);
            myPlantilla = new Plantilla();
            myPlantilla.setID(id);
            lista = myPlantillaDao.searchMatching(conn, myPlantilla);
            if (lista != null && lista.size() > 0) {
                myPlantilla = (Plantilla)lista.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return myPlantilla;
    }

    public Plantilla procesarPlantilla(Plantilla myPlantilla, List myParametros, int modulo) {
        int id;
        List consultas = null;
        List mylista;
        Boolean param = false;
        mylista = null;
        List resultados = null;
        SqlPlantilla mySqlPlan;
        try {
            if (modulo == 0)
                conn = conexion.conectar();
            else
                conn = conexion.conectarComparendos();
            SqlPlantilla mySqlPlantilla = new SqlPlantilla();
            mySqlPlantilla.setIDPLANTILLA(myPlantilla.getID());
            SqlPlantillaDao mySqlPlantillaDao = new SqlPlantillaDao();
            consultas = mySqlPlantillaDao.searchMatching(conn, mySqlPlantilla);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        if (consultas != null && consultas.size() == myParametros.size()) {
            String query;
            String filtro;
            for (int i = 0; i < consultas.size(); i++) {
                mySqlPlan = (SqlPlantilla)consultas.get(i);
                query = mySqlPlan.getQUERY();
                filtro = (String)myParametros.get(i);
                if (filtro != "") {
                    if (query.contains("WHERE")){
                      if (!filtro.contains("AND")) {
                          filtro = " AND " + filtro + " ";
                      }
                    }else{
                      filtro = " WHERE " + filtro + " ";
                    }
                }
                query += filtro;
                mySqlPlan.setQUERY(query);
                consultas.set(i, mySqlPlan);
            }
            param = true;
        }
        if (param) {
            String sql;
            for (int i = 0; i < consultas.size(); i++) {
                if (modulo == 0)
                    conn = conexion.conectar();
                else
                    conn = conexion.conectarComparendos();
                mySqlPlan = (SqlPlantilla)consultas.get(i);
                sql = mySqlPlan.getQUERY();
                //System.out.println("query: "+sql);
                PlantillaDao myPlantDao = new PlantillaDao();
                try {
                    resultados =
                            myPlantDao.ejecutarConsulta(conn, sql); //Ejecuta cada una de las consultas definidas en la platilla
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                conexion.cerrarCx();
                myPlantilla =
                        reemplazarVariables(myPlantilla, resultados); //Busca y reemplaza los resultados de la consulta en la plantilla
            }
        }
        return myPlantilla;
    }

    public Plantilla procesarPlantillaValores(Plantilla myPlant, List valores) {
        int id;
        List mylista;
        Boolean param = false;
        List resultados;
        resultados = new ArrayList();
        if (valores != null && valores.size() > 0) {
            DatosMetaDatos myDato;
            String info;
            String[] campos;
            for (int i = 0; i < valores.size(); i++) {
                myDato = new DatosMetaDatos();
                info = (String)valores.get(i);
                campos = info.split(" = ");
                if (campos.length > 1) {
                    myDato.setMeta(campos[0]);
                    myDato.setInfo(campos[1]);
                    resultados.add(myDato);
                }
            }
            if (resultados.size() > 0)
                myPlant = reemplazarVariables(myPlant, resultados);
        }
        return myPlant;
    }

    public Plantilla reemplazarVariables(Plantilla myPlant, List result) {
        //System.out.println("reemplazando ");
        DatosMetaDatos myDato;
        String cont;
        for (int i = 0; i < result.size(); i++) {
            myDato = (DatosMetaDatos)result.get(i);
            cont = myPlant.getCONTENIDO();
            cont = buscaReemplaza(cont, myDato);
            //System.out.println("El contenido es: "+cont);
            myPlant.setCONTENIDO(cont);
        }
        cont = buscaReemplazaGenerales(myPlant.getCONTENIDO());
        myPlant.setCONTENIDO(cont);
        cont = buscaReemplazaGenerales(myPlant.getENCABEZADO());
        myPlant.setENCABEZADO(cont);
        return myPlant;
    }

    public String buscaReemplaza(String cadena, DatosMetaDatos myDato) {
        String contenido = "";
        String trozos[];
        String tmp;
        trozos = cadena.split("\\*"); //divide la cadena por los asteriscos
        boolean encontrado;
        for (int i = 0; i < trozos.length; i++) {
            //System.out.println("El contenido es: "+contenido);
            encontrado = false;
            tmp = trozos[i];
            //System.out.println("Estamos en el ciclo : "+i);
            if (i % 2 != 0) {
                //System.out.println("El campo es: "+myDato.getMeta());
                //System.out.println("El trozo es: "+tmp);
                if (tmp.equals(myDato.getMeta())) {
                    //System.out.println("El campo es: "+myDato.getMeta());
                    //System.out.println("El trozo es: "+tmp);
                    encontrado = true;
                    tmp = myDato.getInfo();
                    if (tmp.isEmpty() || tmp == "")
                        tmp = "no registra";
                    //System.out.println("El trozo es: "+tmp);
                }
                if (encontrado)
                    contenido += tmp;
                else
                    contenido += "*" + tmp + "*";
            } else {
                contenido += tmp;
            }
        }
        return contenido;
    }

    public String buscaReemplazaGenerales(String cadena) {
        String contenido = "";
        String trozos[];
        String tmp;
        trozos = cadena.split("\\*"); //divide la cadena por los asteriscos
        boolean encontrado;
        for (int i = 0; i < trozos.length; i++) {
            encontrado = false;
            tmp = trozos[i];
            if (i % 2 != 0) {
                tmp = tmp.toUpperCase();
                if (tmp.equals("FECHA")) {
                    tmp = Funciones.getFechaSistemaTexto();
                    encontrado = true;
                }
                if (tmp.equals("HORA")) {
                    tmp = Funciones.getHoraSistemaString(null);
                    encontrado = true;
                }
                if (encontrado)
                    contenido += tmp;
                else
                    contenido += "*" + tmp + "*";
            } else {
                contenido += tmp;
            }
        }
        return contenido;
    }



    public SqlPlantilla insertarSqlPlantilla(SqlPlantilla mySqlPlantilla, int modulo) {
        int id;
        List lista = null;
        if (!Funciones.verificarSqlEntrante(mySqlPlantilla.getQUERY()))
            return null;
        Funciones fnc = new Funciones();
        try {
            if (modulo == 0)
                conn = conexion.conectar();
            else
                conn = conexion.conectarComparendos();
            SqlPlantillaDao mySqlPlantillaDao = new SqlPlantillaDao();
            if (!myMotor.equals("ORACLE"))
                id = Funciones.getId_FB(conn, "GEN_SQLPLANTILLA");
            else
                id = Funciones.getId_Oracle(conn, "GEN_SQLPLANTILLA");
            mySqlPlantilla.setID(id);
            mySqlPlantillaDao.create(conn, mySqlPlantilla);
            mySqlPlantilla = new SqlPlantilla();
            mySqlPlantilla.setID(id);
            lista = mySqlPlantillaDao.searchMatching(conn, mySqlPlantilla);
            if (lista != null && lista.size() > 0) {
                mySqlPlantilla = (SqlPlantilla)lista.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return mySqlPlantilla;
    }

    public List verificarConsulta(String query, int modulo) {
        
        System.out.println("M-*-todo verificarConsulta");
        
        List mylista;
        mylista = null;
        if (!Funciones.verificarSqlEntrante(query))
            return mylista;
        try {
            if (modulo == 0)
                conn = conexion.conectar();
            else
                conn = conexion.conectarComparendos();
            
            PlantillaDao myPlantillaDao = new PlantillaDao();
            //mylista = myPlantillaDao.verificarConsulta(conn, query);
            mylista = myPlantillaDao.verificarConsulta(conn, query, myMotor);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return mylista;
    }

   

    public SqlPlantilla actualizarSqlPlantilla(SqlPlantilla mySqlPlantilla, int modulo) {
        int id;
        List lista = null;
        Funciones fnc = new Funciones();
        if (!Funciones.verificarSqlEntrante(mySqlPlantilla.getQUERY()))
            return null;
        try {
            if (modulo == 0)
                conn = conexion.conectar();
            else
                conn = conexion.conectarComparendos();
            SqlPlantillaDao mySqlPlantillaDao = new SqlPlantillaDao();
            id = mySqlPlantilla.getID();
            mySqlPlantillaDao.save(conn, mySqlPlantilla);
            mySqlPlantilla = new SqlPlantilla();
            mySqlPlantilla.setID(id);
            lista = mySqlPlantillaDao.searchMatching(conn, mySqlPlantilla);
            if (lista != null && lista.size() > 0) {
                mySqlPlantilla = (SqlPlantilla)lista.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return mySqlPlantilla;
    }

    public boolean eliminarSqlPlantilla(SqlPlantilla mySqlPlantilla, int modulo) {
        int id;
        List lista = null;
        boolean eliminado = true;
        try {
            if (modulo == 0)
                conn = conexion.conectar();
            else
                conn = conexion.conectarComparendos();
            SqlPlantillaDao mySqlPlantillaDao = new SqlPlantillaDao();
            id = mySqlPlantilla.getID();
            mySqlPlantillaDao.delete(conn, mySqlPlantilla);
            mySqlPlantilla = new SqlPlantilla();
            mySqlPlantilla.setID(id);
            lista = mySqlPlantillaDao.searchMatching(conn, mySqlPlantilla);
            if (lista != null && lista.size() > 0) {
                eliminado = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return eliminado;
    }

    public List executeQuery(String sql, int modulo) {

        List lista = null;
        if (!Funciones.verificarSqlEntrante(sql))
            return null;
        Funciones fnc = new Funciones();
        try {
            //conn = conexion.conectarComparendos();
            if (modulo == 0)
                conn = conexion.conectar();
            else
                conn = conexion.conectarComparendos();
            PlantillaDao myDao = new PlantillaDao();
            //lista = myDao.getData(conn, sql);
            lista = myDao.getData(conn, sql, myMotor);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
    public Object[][] executeQueryComp(String sql) 
    {

        Object[][] lista = null;
        Funciones fnc = new Funciones();
        try {
           
            conn = conexion.conectarComparendos();
            PlantillaDao myDao = new PlantillaDao();
            
            lista = myDao.ejecutarQuerty(conn, sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
    public Object[][] executeQueryPrincipal(String sql) 
    {

        Object[][] lista = null;
        Funciones fnc = new Funciones();
        try {
           
            conn = conexion.conectarComparendos();
            PlantillaDao myDao = new PlantillaDao();
            
            lista = myDao.ejecutarQuerty(conn, sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    
    
    public void subirArchivo(byte[] myArchivo, String nombre) {
        OutputStream out;
        try {
            System.out.println("nombre: " + nombre);
            String ruta = nombre;
            int posicionFinal = nombre.lastIndexOf("\\");
            if (posicionFinal < 0)
                posicionFinal = nombre.lastIndexOf("/");
            if (posicionFinal >= 0) {
                ruta = nombre.substring(0, posicionFinal);
            }

            if (Funciones.validarRuta(ruta)) {
                out = new FileOutputStream(nombre);
                out.write(myArchivo);
                out.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public byte[] obtenerArchivo(String nombre) {
        InputStream input;
        byte[] myArchivo = null;
        byte[] tmp = new byte[1000];
        int leidos;
        try {
            //nombre= "D:\\\\tmp\\"+nombre;
            System.out.println("nombre: " + nombre);
            input = new FileInputStream(nombre);
            leidos = input.read(tmp);
            while (leidos >= 0) {
                myArchivo = unirArrayBytes(myArchivo, tmp, leidos);
                tmp = new byte[1000];
                leidos = input.read(tmp);
            }
            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return myArchivo;
    }

    public byte[] unirArrayBytes(byte[] principal, byte[] agregar, int nuevos) {
        if (nuevos > 0) {
            byte[] tmp;
            if (principal == null || principal.length == 0)
                return agregar;
            tmp = new byte[principal.length + nuevos];
            for (int i = 0; i < principal.length; i++) {
                tmp[i] = principal[i];
            }
            for (int i = principal.length; i < principal.length + nuevos; i++) {
                tmp[i] = agregar[i - principal.length];
            }
            return tmp;
        }
        return principal;
    }

    public List getTElementoDigital(ElementoDigital elementodigital) {
        List lista;
        lista = null;
        try {
            conexion = new Conexion();
            conn = conexion.conectar();
            ElementoDigitalDao myElementoDigitalDao = new ElementoDigitalDao();
            lista = myElementoDigitalDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getSViewElementoIndices(ViewElementoIndices viewelementoindices) {
        List lista;
        lista = null;
        try {
            conexion = new Conexion();
            conn = conexion.conectar();
            ViewElementoIndicesDao myViewElementoIndicesDao = new ViewElementoIndicesDao();
            lista = myViewElementoIndicesDao.searchMatching(conn, viewelementoindices);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getTTipoDocumento(TipoDocumento tipodocumento) {
        List lista;
        lista = null;
        try {
            conexion = new Conexion();
            conn = conexion.conectar();
            TipoDocumentoDao myTipoDocumentoDao = new TipoDocumentoDao();
            lista = myTipoDocumentoDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public boolean crearElementoTipoDocumento(ElementoTipoDocumento elementotipodocumento) {
        boolean resultado;
        resultado = false;
        ElementoTipoDocumentoDao myElementoTipoDocumentoDao = new ElementoTipoDocumentoDao();
        int id = 0;

        try {
            conn = conexion.conectar();
            if (!myMotor.equals("ORACLE"))
                id = Funciones.getId_FB(conn, "GEN_ELEMENTO_TIPODOCUMENTO");
            else
                id = Funciones.getId_Oracle(conn, "GEN_ELEMENTO_TIPODOCUMENTO");
            elementotipodocumento.setID_ELEMENTO_TIPODOCUMENTO(id);
            myElementoTipoDocumentoDao.create(conn, elementotipodocumento);
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myElementoTipoDocumentoDao = null;
        }
        return resultado;
    }

    public List getSElementoTipoDocument(ElementoTipoDocumento elementotipodocumento) {
        List lista;
        lista = null;
        try {
            conexion = new Conexion();
            conn = conexion.conectar();
            ElementoTipoDocumentoDao myElementoTipoDocumentoDao = new ElementoTipoDocumentoDao();
            lista = myElementoTipoDocumentoDao.searchMatching(conn, elementotipodocumento);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
        public List getResolucionInfracciones(ResolucionInfraccionesComp myResInf) {
        List mylista;
        mylista = null;
        try {
            conn = conexion.conectarComparendos();
            ResolucionInfraccionesCompDao myResInfrDao = new ResolucionInfraccionesCompDao();
            mylista = myResInfrDao.searchMatching(conn, myResInf);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return mylista;
    }
    
    public List getResolucionesInfractor(ViewResolucionesInfractorComp myResInfr) {
        List mylista;
        mylista = null;
        try {
            conn = conexion.conectarComparendos();
            ViewResolucionesInfractorCompDao myResInfrDao = new ViewResolucionesInfractorCompDao();
            mylista = myResInfrDao.searchMatching(conn, myResInfr);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return mylista;
    }

    public List getResolucionesInfractor(ViewResolucionesInfractorComp myResInfr, String fechaIni, String fechaFin) {
        List mylista;
        mylista = null;
        try {
            conn = conexion.conectarComparendos();
            ViewResolucionesInfractorCompDao myResInfrDao = new ViewResolucionesInfractorCompDao();
            mylista = myResInfrDao.searchMatchingFiltro(conn, myResInfr,  fechaIni, fechaFin);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return mylista;
    }

    public void pruebaDocumento() {

    }
 
    public List ejecutarSqlReporte(String sql, int modulo) {
        List lista = new ArrayList();
        if (!Funciones.verificarSqlEntranteReporte(sql)) {
            lista.add("Error");
        } else {
            //Funciones fnc = new Funciones();
            try {
                if (modulo == 0)
                    conn = conexion.conectar();
                else
                    conn = conexion.conectarComparendos();
                PlantillaDao myDao = new PlantillaDao();
                lista = myDao.getDataReporte(conn, sql);
            } catch (Exception e) {
                lista.add(e.getMessage());
                e.printStackTrace();
            } finally {
                conexion.cerrarCx();
            }
        }
        return lista;
    }

    //*************************** DOCS RESOLUCIONES *********************************************
    //*******************************************************************************************
    //*******************************************************************************************
    //*******************************************************************************************
    /**
     * Inserta nuevo registro en la tabla
     * @param Docsresoluciones obj
     * @return Retorna el mismo objeto pero con la llave primaria configurada
     */
    public Docsresoluciones crearDocsresoluciones(Docsresoluciones obj) {
        List lista = null;
        try {
            DocsresolucionesDao dao = new DocsresolucionesDao();
            conn = conexion.conectar();
            int id = Funciones.obtenerId(conn, "GEN_DOCSRESOLUCIONES", "GEN_DOCSRESOLUCIONES", myMotor);
            obj.setID_DOCSRESOLUCIONES(id);
            dao.create(conn, obj);
            //verificar existencia
            obj = new Docsresoluciones();
            obj.setID_DOCSRESOLUCIONES(id);
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Docsresoluciones)lista.get(0);
            } else {
                obj.setID_DOCSRESOLUCIONES(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setID_DOCSRESOLUCIONES(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
    }

    /**
     * Edita un registro en la tabla
     * @param Docsresoluciones obj
     * @return boolean indicando si se realizo o no la actualizacion
     */
    public boolean editarDocsresoluciones(Docsresoluciones obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
            DocsresolucionesDao dao = new DocsresolucionesDao();
            conn = conexion.conectar();
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

    /**
     * Busca los registros que coincidan con los datos enviados
     * @param Docsresoluciones obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List buscarDocsresoluciones(Docsresoluciones obj) {
        List lista = null;
        try {
            DocsresolucionesDao dao = new DocsresolucionesDao();
            conn = conexion.conectar();
            lista = dao.searchMatching(conn, obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    /**
     * Consulta todos los registros de la tabla
     * @param Docsresoluciones obj
     * @return Retorna la lista de los registros en la tabla
     */
    public List listarDocsresoluciones() {
        List lista = null;
        try {
            DocsresolucionesDao dao = new DocsresolucionesDao();
            conn = conexion.conectar();
            lista = dao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public boolean eliminarDocsresoluciones(Docsresoluciones obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
            DocsresolucionesDao dao = new DocsresolucionesDao();
            conn = conexion.conectar();
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


    //************************ FIN DOCS RESOLUCIONES ********************************************
    //*******************************************************************************************
    //*******************************************************************************************
    //*******************************************************************************************
    
    //*************************** TIPODOCGENERAR  ***********************************************
    //*******************************************************************************************
    //*******************************************************************************************
    //*******************************************************************************************
    /**
    * Inserta nuevo registro en la tabla
    * @param Tipodocgenerar obj
    * @return Retorna el mismo objeto pero con la llave primaria configurada
    */
    public Tipodocgenerar crearTipodocgenerar(Tipodocgenerar obj) {
                    List lista = null;
            try {
                TipodocgenerarDao dao = new TipodocgenerarDao();
                conn = conexion.conectar();
                int id = Funciones.obtenerId(conn, "GEN_TIPODOCGENERAR", "GEN_TIPODOCGENERAR",myMotor);
                obj.setID_TIPODOCGENERAR(id);
                dao.create(conn, obj);
                //verificar existencia
                obj = new Tipodocgenerar();
                obj.setID_TIPODOCGENERAR(id);
                lista = dao.searchMatching(conn, obj);
                if (lista != null && lista.size() > 0) {
                    obj = (Tipodocgenerar)lista.get(0);
                }
                else {
                    obj.setID_TIPODOCGENERAR(-1);
                }
            } catch (Exception e) {
                e.printStackTrace();
                obj.setID_TIPODOCGENERAR(-1);
            } finally {
                conexion.cerrarCx();
            }
            return obj;
        }
    
    /**
         * Edita un registro en la tabla
         * @param Tipodocgenerar obj
         * @return boolean indicando si se realizo o no la actualizacion
         */
        public boolean editarTipodocgenerar(Tipodocgenerar obj) {
            boolean resultado;
            resultado = false;
            int id = 0;
            try {
                            TipodocgenerarDao dao = new TipodocgenerarDao();
                conn = conexion.conectar();
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
    
    
    /**
         * Busca los registros que coincidan con los datos enviados
         * @param Tipodocgenerar obj
         * @return Retorna la lista de los registros que coinciden
         */
        public List buscarTipodocgenerar(Tipodocgenerar obj) {
            List lista = null;
            try {
                            TipodocgenerarDao dao = new TipodocgenerarDao();
                conn = conexion.conectar();
                lista = dao.searchMatching(conn, obj);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                conexion.cerrarCx();
            }
            return lista;
        }
    
    /**
         * Consulta todos los registros de la tabla
         * @param Tipodocgenerar obj
         * @return Retorna la lista de los registros en la tabla
         */
        public List listarTipodocgenerar() {
            List lista = null;
            try {
                            TipodocgenerarDao dao = new TipodocgenerarDao();
                conn = conexion.conectar();
                lista = dao.loadAll(conn);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                conexion.cerrarCx();
            }
            return lista;
        }
    
    /**
         * Elimina un registro de la tabla
         * @param Tipodocgenerar obj
         * @return Retorna un boolean indicando si se realizo o no la operacion
         */
        public boolean eliminarTipodocgenerar(Tipodocgenerar obj) {
            boolean resultado;
            resultado = false;
            int id = 0;
            try {
                            TipodocgenerarDao dao = new TipodocgenerarDao();
                conn = conexion.conectar();
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
    
        
    //*************************** FIN TIPODOCGENERAR  *******************************************
    //*******************************************************************************************
    //*******************************************************************************************
    //*******************************************************************************************
    
                    
    
    
  
  
  
    //*************************** INICIO N-*-MEROS RESOLUCI-*-N Y VIGENCIAS  *******************************************
    //*******************************************************************************************
    //*******************************************************************************************
    //*******************************************************************************************
  
  //NUEVOS 16-ENE-2013    
    //VIEW N-*-MEROS RESOLUCI-*-N
    /**
     * Busca los registros que coincidan con los datos enviados
     * @param Viewnumerosresolucion obj
     * @return Retorna la lista de los registros que coinciden
     */
    public List buscarViewnumerosresolucion(Viewnumerosresolucion obj) {
        List lista = null;
        try {
      ViewnumerosresolucionDao dao = new ViewnumerosresolucionDao();
            
            //conn = conexion.conectar();
            conn = conexion.conectarComparendos();
            
            lista = dao.searchMatching(conn, obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
    /**
     * Consulta todos los registros de la tabla
     * @param Viewnumerosresolucion obj
     * @return Retorna la lista de los registros en la tabla
     */
    public List listarViewnumerosresolucion() {
        List lista = null;
        try {
      ViewnumerosresolucionDao dao = new ViewnumerosresolucionDao();
          
          //conn = conexion.conectar();
          conn = conexion.conectarComparendos();
            
            lista = dao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
  /**
       * Retorna el siguiente n-*-mero de resoluci-*-n disponible para la vigencia determinada
       * @param int idVigencia
       * @return Retorna el n-*-mero de resoluci-*-n disponible
       */
      public Numerosresoluciondisp getNextNumeroResolucion(int idVigencia){
          
          Numerosresoluciondisp objNextNumeroResolucion = new Numerosresoluciondisp();
          
          try
          {
              NumerosresoluciondispDao daoNumerosResolucion = new NumerosresoluciondispDao();
              
              //conn = conexion.conectar();
              conn = conexion.conectarComparendos();
              
              //Buscar si hay un n-*-mero de resoluci-*-n disponible
              objNextNumeroResolucion = daoNumerosResolucion.getPrimeroDisponible(conn, idVigencia);
              
              //Si no hay un n-*-mero disponible, CREARLO
              if(objNextNumeroResolucion == null)
              {
                //Determinar cu-*-l es el n-*-mero siguiente
                int nextNumResolucion = -1;
                
                //Obtener el -*-ltimo n-*-mero utilizado
                Numerosresoluciondisp objUltNumeroResolucion = daoNumerosResolucion.getUltimoUtilizado(conn, idVigencia);
                
                //Si hay n-*-meros utilizados, el siguiente n-*-mero es el -*-ltimo + uno
                if(objUltNumeroResolucion != null) {
                    nextNumResolucion = objUltNumeroResolucion.getNUMERO() + 1;
                }
                //Si no se ha utilizado ning-*-n n-*-mero, el siguiente es el configurado en la vigencia como primero
                else
                {                  
                  Vigencias objVigencia = new Vigencias();
                  objVigencia.setID_VIGENCIA(idVigencia);
                  objVigencia = this.buscarPrimeroVigencias(objVigencia);
                  
                  if(objVigencia!=null){
                      nextNumResolucion = objVigencia.getNUM_RESOLUCION_INICIO();
                  }
                }
                
                //Crear el nuevo n-*-mero
                Numerosresoluciondisp objNuevoNumeroResolucion = new Numerosresoluciondisp();                
                int idNuevoNumero = Funciones.obtenerId(conn, "GEN_NUMEROS_RESOLUCION_DISP", "GEN_NUMEROSRESOLUCIONDISP", myMotor);                
                objNuevoNumeroResolucion.setID_NUM_RES_DISP(idNuevoNumero);
                objNuevoNumeroResolucion.setDISPONIBLE(0);
                objNuevoNumeroResolucion.setID_VIGENCIA(idVigencia);
                objNuevoNumeroResolucion.setNUMERO(nextNumResolucion);
                daoNumerosResolucion.create(conn, objNuevoNumeroResolucion);
                
                //El nuevo n-*-mero es el n-*-mero disponible
                objNextNumeroResolucion = objNuevoNumeroResolucion;
              }
              //Si no es nulo, est-*- disponible - cambiar a NO Disponible para usarlo en la resoluci-*-n actual
              else
              {
                  //Ahora no estar-*- disponible
                  objNextNumeroResolucion.setDISPONIBLE(0);
                  this.editarNumerosresoluciondisp(objNextNumeroResolucion);
              }
              
          } catch (Exception e) {
              e.printStackTrace();
          } finally {
              conexion.cerrarCx();
          }
          
          return objNextNumeroResolucion;
      }
  
    public Numerosresoluciondisp getNextNumeroResolucionTRANSITO(int idVigencia, int modulo){
        
        Numerosresoluciondisp objNextNumeroResolucion = new Numerosresoluciondisp();
        
        try
        {
            NumerosresoluciondispDao daoNumerosResolucion = new NumerosresoluciondispDao();
            //if(modulo==0){
                conn = conexion.conectar();
            //}else{
              //  conn = conexion.conectarComparendos();
            //}
            //Buscar si hay un n-*-mero de resoluci-*-n disponible
            objNextNumeroResolucion = daoNumerosResolucion.getPrimeroDisponible(conn, idVigencia);
            
            //Si no hay un n-*-mero disponible, CREARLO
            if(objNextNumeroResolucion == null)
            {
              //Determinar cu-*-l es el n-*-mero siguiente
              int nextNumResolucion = -1;
              
              //Obtener el -*-ltimo n-*-mero utilizado
              Numerosresoluciondisp objUltNumeroResolucion = daoNumerosResolucion.getUltimoUtilizado(conn, idVigencia);
              System.out.println(objUltNumeroResolucion);
              //Si hay n-*-meros utilizados, el siguiente n-*-mero es el -*-ltimo + uno
              if(objUltNumeroResolucion != null) {
                  nextNumResolucion = objUltNumeroResolucion.getNUMERO() + 1;
              }
              //Si no se ha utilizado ning-*-n n-*-mero, el siguiente es el configurado en la vigencia como primero
              else
              {                  
                Vigencias objVigencia = new Vigencias();
                objVigencia.setID_VIGENCIA(idVigencia);
                objVigencia = this.buscarPrimeroVigencias(objVigencia);
                
                if(objVigencia!=null){
                    nextNumResolucion = objVigencia.getNUM_RESOLUCION_INICIO();
                }
              }
              
              //Crear el nuevo n-*-mero
              Numerosresoluciondisp objNuevoNumeroResolucion = new Numerosresoluciondisp();
              conn = conexion.conectar();
              int idNuevoNumero = Funciones.obtenerId(conn, "GEN_NUMEROS_RESOLUCION_DISP", "GEN_NUMEROSRESOLUCIONDISP", myMotor);                
              objNuevoNumeroResolucion.setID_NUM_RES_DISP(idNuevoNumero);
              objNuevoNumeroResolucion.setDISPONIBLE(0);
              objNuevoNumeroResolucion.setID_VIGENCIA(idVigencia);
              objNuevoNumeroResolucion.setNUMERO(nextNumResolucion);
              daoNumerosResolucion.create(conn, objNuevoNumeroResolucion);
              
              //El nuevo n-*-mero es el n-*-mero disponible
              objNextNumeroResolucion = objNuevoNumeroResolucion;
            }
            //Si no es nulo, est-*- disponible - cambiar a NO Disponible para usarlo en la resoluci-*-n actual
            else
            {
                //Ahora no estar-*- disponible
                objNextNumeroResolucion.setDISPONIBLE(0);
                this.editarNumerosresoluciondisp(objNextNumeroResolucion);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        
        return objNextNumeroResolucion;
    }
    
    //VIGENCIAS
    /**
       * Inserta nuevo registro en la tabla
       * @param Vigencias obj
       * @return Retorna el mismo objeto pero con la llave primaria configurada
       */
    public Vigencias crearVigencias(Vigencias obj) {
      List lista = null;
          try {
              VigenciasDao dao = new VigenciasDao();
            
            //conn = conexion.conectar();
            conn = conexion.conectarComparendos();
              
              int id = Funciones.obtenerId(conn, "GEN_VIGENCIAS", "GEN_VIGENCIAS", myMotor);
              obj.setID_VIGENCIA(id);
              dao.create(conn, obj);
              //verificar existencia
              obj = new Vigencias();
              obj.setID_VIGENCIA(id);
              lista = dao.searchMatching(conn, obj);
              if (lista != null && lista.size() > 0) {
                  obj = (Vigencias)lista.get(0);
              }
              else {
                  obj.setID_VIGENCIA(-1);
              }
          } catch (Exception e) {
              e.printStackTrace();
              obj.setID_VIGENCIA(-1);
          } finally {
              conexion.cerrarCx();
          }
          return obj;
      }
    
    /**
       * Edita un registro en la tabla
       * @param Vigencias obj
       * @return boolean indicando si se realizo o no la actualizacion
       */
    public boolean editarVigencias(Vigencias obj) {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
      VigenciasDao dao = new VigenciasDao();
            
          //conn = conexion.conectar();
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
    
    /**
    * Busca el primer registro que coincida con los datos enviados
    * @param Vigencias obj
    * @return Retorna el mismo objeto pero con los datos consultados
    */
    public Vigencias buscarPrimeroVigencias(Vigencias obj) {
    List lista = null;
    try {
    VigenciasDao dao = new VigenciasDao();
      
      //conn = conexion.conectar();
      conn = conexion.conectar();
      
      lista = dao.searchMatching(conn, obj);
      if (lista != null && lista.size() > 0) {
          obj = (Vigencias)lista.get(0);
      }
      else {
    obj.setID_VIGENCIA(-1);
      }
    } catch (Exception e) {
      e.printStackTrace();
      obj.setID_VIGENCIA(-1);
    } finally {
      conexion.cerrarCx();
    }
    return obj;
    }
    
    /**
    * Busca los registros que coincidan con los datos enviados
    * @param Vigencias obj
    * @return Retorna la lista de los registros que coinciden
    */
    public List buscarVigencias(Vigencias obj) {
    List lista = null;
    try {
    VigenciasDao dao = new VigenciasDao();
      
      //conn = conexion.conectar();
      conn = conexion.conectarComparendos();
      
      lista = dao.searchMatching(conn, obj);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      conexion.cerrarCx();
    }
    return lista;
    }
    
    /**
    * Consulta todos los registros de la tabla
    * @param Vigencias obj
    * @return Retorna la lista de los registros en la tabla
    */
    public List listarVigencias() {
    List lista = null;
    try {
    VigenciasDao dao = new VigenciasDao();
      
      conn = conexion.conectar();
      //conn = conexion.conectarComparendos();
      
      lista = dao.loadAll(conn);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      conexion.cerrarCx();
    }
    return lista;
    }
    
    /**
    * Elimina un registro de la tabla
    * @param Vigencias obj
    * @return Retorna un boolean indicando si se realizo o no la operacion
    */
    public boolean eliminarVigencias(Vigencias obj) {
    boolean resultado;
    resultado = false;
    int id = 0;
    try {
    VigenciasDao dao = new VigenciasDao();
      
      //conn = conexion.conectar();
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
    
    //NUMEROS RESOLUCIONES
    /**
    * Inserta nuevo registro en la tabla
    * @param Numerosresoluciondisp obj
    * @return Retorna el mismo objeto pero con la llave primaria configurada
    */
    public Numerosresoluciondisp crearNumerosresoluciondisp(Numerosresoluciondisp obj) {
    List lista = null;
     try {
         NumerosresoluciondispDao dao = new NumerosresoluciondispDao();
         
       //conn = conexion.conectar();
       conn = conexion.conectarComparendos();
         
         int id = Funciones.obtenerId(conn, "GEN_NUMEROS_RESOLUCION_DISP", "GEN_NUMEROSRESOLUCIONDISP", myMotor);
         obj.setID_NUM_RES_DISP(id);
         dao.create(conn, obj);
         //verificar existencia
         obj = new Numerosresoluciondisp();
         obj.setID_NUM_RES_DISP(id);
         lista = dao.searchMatching(conn, obj);
         if (lista != null && lista.size() > 0) {
             obj = (Numerosresoluciondisp)lista.get(0);
         }
         else {
             obj.setID_NUM_RES_DISP(-1);
         }
     } catch (Exception e) {
         e.printStackTrace();
         obj.setID_NUM_RES_DISP(-1);
     } finally {
         conexion.cerrarCx();
     }
     return obj;
    }
    
    /**
    * Edita un registro en la tabla
    * @param Numerosresoluciondisp obj
    * @return boolean indicando si se realizo o no la actualizacion
    */
    public boolean editarNumerosresoluciondisp(Numerosresoluciondisp obj) {
     boolean resultado;
     resultado = false;
     int id = 0;
     try {
    NumerosresoluciondispDao dao = new NumerosresoluciondispDao();
         
       //conn = conexion.conectar();
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
    
    /**
    * Busca el primer registro que coincida con los datos enviados
    * @param Numerosresoluciondisp obj
    * @return Retorna el mismo objeto pero con los datos consultados
    */
    public Numerosresoluciondisp buscarPrimeroNumerosresoluciondisp(Numerosresoluciondisp obj) {
     List lista = null;
     try {
    NumerosresoluciondispDao dao = new NumerosresoluciondispDao();
         
       //conn = conexion.conectar();
       conn = conexion.conectarComparendos();         
         
         lista = dao.searchMatching(conn, obj);
         if (lista != null && lista.size() > 0) {
             obj = (Numerosresoluciondisp)lista.get(0);
         }
         else {
     obj.setID_NUM_RES_DISP(-1);
         }
     } catch (Exception e) {
         e.printStackTrace();
         obj.setID_NUM_RES_DISP(-1);
     } finally {
         conexion.cerrarCx();
     }
     return obj;
    }
    
    /**
    * Busca los registros que coincidan con los datos enviados
    * @param Numerosresoluciondisp obj
    * @return Retorna la lista de los registros que coinciden
    */
    public List buscarNumerosresoluciondisp(Numerosresoluciondisp obj) {
     List lista = null;
     try {
    NumerosresoluciondispDao dao = new NumerosresoluciondispDao();
         
       //conn = conexion.conectar();
       conn = conexion.conectarComparendos();
         
         lista = dao.searchMatching(conn, obj);
     } catch (Exception e) {
         e.printStackTrace();
     } finally {
         conexion.cerrarCx();
     }
     return lista;
    }
    
    /**
    * Consulta todos los registros de la tabla
    * @param Numerosresoluciondisp obj
    * @return Retorna la lista de los registros en la tabla
    */
    public List listarNumerosresoluciondisp() {
     List lista = null;
     try {
    NumerosresoluciondispDao dao = new NumerosresoluciondispDao();
         
       //conn = conexion.conectar();
       conn = conexion.conectarComparendos();
         
         lista = dao.loadAll(conn);
     } catch (Exception e) {
         e.printStackTrace();
     } finally {
         conexion.cerrarCx();
     }
     return lista;
    }
    
    /**
    * Elimina un registro de la tabla
    * @param Numerosresoluciondisp obj
    * @return Retorna un boolean indicando si se realizo o no la operacion
    */
    public boolean eliminarNumerosresoluciondisp(Numerosresoluciondisp obj) {
     boolean resultado;
     resultado = false;
     int id = 0;
     try {
    NumerosresoluciondispDao dao = new NumerosresoluciondispDao();
         
       //conn = conexion.conectar();
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
    
    public ResolucionesComparendoComp buscarResolucionComparendoComp(ResolucionesComparendoComp obj) {
       List lista = null;
       try {
        
          ResolucionesComparendoCompDao dao = new ResolucionesComparendoCompDao();
           
         //conn = conexion.conectar();
         conn = conexion.conectarComparendos();         
           
           lista = dao.searchMatching(conn, obj);
           if (lista != null && lista.size() > 0) {
               obj = (ResolucionesComparendoComp)lista.get(0);
           }
           else {
              obj.setID(-1);
           }
       } catch (Exception e) {
           e.printStackTrace();
           obj.setID(-1);
       } finally {
           conexion.cerrarCx();
       }
       return obj;
    }
    
    
    public boolean actualizarResolucionComparendo(ResolucionesComparendoComp obj) {
        boolean resultado = false;
        List lista = null;
        Funciones fnc = new Funciones();
        try {
            conn = conexion.conectarComparendos();
            PlantillaDao myPlantillaDao = new PlantillaDao();
            ResolucionesComparendoCompDao resolucionesComparendoDao = new ResolucionesComparendoCompDao();
            resolucionesComparendoDao.save(conn, obj);
            resultado = true;
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXYYYYYYYYYYYYYYYYYYYZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ resultado:" + resultado);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXYYYYYYYYYYYYYYYYYYYZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ error:" + e.getMessage());
            resultado = false;
        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }
  //*************************** FIN N-*-MEROS RESOLUCI-*-N Y VIGENCIAS  *******************************************
  //*******************************************************************************************
  //*******************************************************************************************
  //*******************************************************************************************
}
