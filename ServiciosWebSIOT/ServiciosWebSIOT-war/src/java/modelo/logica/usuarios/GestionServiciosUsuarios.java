package modelo.logica.usuarios;

import java.io.BufferedReader;
import java.io.DataInputStream;

import java.security.NoSuchAlgorithmException;

import java.sql.Connection;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.Writer;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

import modelo.conexion.Conexion;

import modelo.datos.dao.generales.UsuariosDao;
import modelo.datos.dao.usuarios.PerfilOpcionDao;
import modelo.datos.dao.usuarios.PerfilesDao;
import modelo.datos.objetos.clavesutilizadas.Clavesutilizadas;
import modelo.datos.objetos.generales.AuditoriaSystem;
import modelo.datos.objetos.generales.Usuarios;
import modelo.datos.objetos.historico_claves.Historicoclaves;
import modelo.datos.objetos.usuarios.PerfilOpcion;
import modelo.datos.objetos.usuarios.Perfiles;

import modelo.logica.clavesutilizadas.GestionClavesutilizadas;

import modelo.logica.historico_claves.GestionHistoricoclaves;
import seguridad.Crypto;

import utilidades.Auditoria;
import utilidades.Funciones;
import utilidades.Seguridad;


public class GestionServiciosUsuarios {
    //VehiculoDao vehiculoDao;
    Conexion conexion;
    Connection conn;
    String myMotor;
    String server = "";
    String rutaWSini = "";
    
    public GestionServiciosUsuarios() {
        super();
        conexion = new Conexion();
        Funciones myFnc = new Funciones();
        try
        {
            server = Funciones.leer_ini("/WSTransito.ini", "SERVER");
            rutaWSini = "/WSTransito.ini";
            
        }catch(Exception exce)
        {
            server = Funciones.leer_ini("C:\\WSTransito.ini", "SERVER");
            rutaWSini ="C:\\WSTransito.ini";
        }
        
        try
        {
            myMotor = Funciones.leer_ini(rutaWSini, "MOTOR");
            
        }catch(Exception exce)
        {
            myMotor = Funciones.leer_ini("C:\\WSTransito.ini", "MOTOR");
        }
        myMotor = myMotor.toUpperCase();
    }
    
    public List getUsuarios(Usuarios usuario,int modulo) throws Exception {
        UsuariosDao MyUsuarioDao= new UsuariosDao();
        List lista = null;
        try {
            if(modulo==0)
                    conn= conexion.conectar();
            else
                conn = conexion.conectarComparendos();
            lista = (ArrayList)MyUsuarioDao.buscarUsuarios(conn, usuario);
        } catch (SQLException e) {
        System.out.println("error peter="+e.getMessage());
        }catch(Exception e){throw new Exception(e.getMessage());} finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
    public List getUsuarios(int modulo) throws Exception {
        UsuariosDao MyUsuarioDao= new UsuariosDao();
        List lista = null;
        try {
            if(modulo==0)
                conn= conexion.conectar();
            else
                conn = conexion.conectarComparendos();

                lista = MyUsuarioDao.cargarTodos(conn);
        } catch (SQLException e) {
        System.out.println("error peter="+e.getMessage());
        }catch(Exception e){throw new Exception(e.getMessage());} finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
    
    public List getPerfiles(int modulo)
    {
          List mylista;
          mylista = null;
          try
      {
          if(modulo==0)
              conn= conexion.conectar();
          else
              conn = conexion.conectarComparendos();
        PerfilesDao myPerfilDao = new PerfilesDao();
        mylista = myPerfilDao.loadAll(conn);
      }
      catch (Exception e){
        e.printStackTrace();
      }
      finally{
        conexion.cerrarCx();
      }
      return mylista;
    }    
    
    public Perfiles insertarPerfil(Perfiles myPerfil,int modulo)
    {
        Perfiles myValidador;
        int id;
        List lista=null;
        Funciones fnc = new Funciones();
        myValidador = new Perfiles();
        myValidador.setPERFIL(myPerfil.getPERFIL());
        
        try{
            if(modulo==0)
                conn= conexion.conectar();
            else
                conn = conexion.conectarComparendos();
            
            PerfilesDao myPerfilDao = new PerfilesDao();
            lista = myPerfilDao.searchMatching(conn, myValidador);
            
            if(lista != null&& lista.size() >0 )
            {
                return null;
            }
            
            lista=null;
            
            myMotor = myMotor.toUpperCase();
            
            id = Funciones.obtenerId(conn, "GEN_PERFILES", "GEN_PERFILES", myMotor);
            myPerfil.setID_PERFIL(id);
            myPerfilDao.create(conn, myPerfil);
            
            myPerfil = new Perfiles();
            myPerfil.setID_PERFIL(id);
            
            lista=myPerfilDao.searchMatching(conn, myPerfil);
            
            if(lista != null && lista.size() > 0)
            {
                myPerfil = (Perfiles)lista.get(0);
            }
         }
         catch(Exception e){
          e.printStackTrace();
        }
        finally{
          conexion.cerrarCx();
        }
        return myPerfil;
    }
    
    public Usuarios insertarUsuario(Usuarios myUsuario,int idUsuario,String myIp,String myHost,int modulo)
    {
        int id;
        List lista=null;
        Funciones fnc=new Funciones();
        Usuarios tmp = new Usuarios();
        //Campos para la auditoria
        Auditoria myAuditoria;
        AuditoriaSystem myAuditSx;
        //--Campos para la auditoria
        try{
            if(modulo==0)
                 conn= conexion.conectar();
            else
                 conn = conexion.conectarComparendos();
            UsuariosDao myUsuarioDao = new UsuariosDao();
            //Se valida que no este en uso el login
            tmp.setLOGIN(myUsuario.getLOGIN());
            lista=myUsuarioDao.searchMatching(conn, tmp);
            if(lista!=null && lista.size()>0)
            {
                tmp.setID_USUARIO(0);
                tmp.setLOGIN("");
                return tmp;
            }
            else
            {
                id=Funciones.obtenerId(conn, "GEN_USUARIOS", "GEN_USUARIOS", myMotor);
                myUsuario.setID_USUARIO(id);
                myUsuario.setFECHAINGRESO(Funciones.getFechaSistema(conn,myMotor));
                myUsuario.setESTADO("A");
                //myUsuario.setCLAVE(Seguridad.getHash(myUsuario.getCLAVE()));
                //myUsuario.setCLAVE(Seguridad.getHash(myUsuario.getCLAVE()));
                myUsuario.setFECHA_CLAVE(Funciones.getFechaSistema(conn,myMotor));
                //Pasos para la auditoria
                myAuditoria = new Auditoria();
                myAuditSx= new AuditoriaSystem();
                myAuditSx.setTABLAAFECTADA("USUARIOS");
                myAuditSx.setCAMPOCLAVE("ID_USUARIO");
                myAuditSx.setVLRCAMPOCLAVE(String.valueOf(id));
                myAuditSx.setID_USUARIO(idUsuario);
                myAuditSx.setIP(myIp);
                myAuditSx.setNOMBREEQUIPO(myHost);
                myAuditoria.auditarInsersion(conn,myAuditSx, myUsuario,0);
                //-- para la auditoria
                myUsuarioDao.create(conn, myUsuario);
                myUsuario= new Usuarios();
                myUsuario.setID_USUARIO(id);
                lista=myUsuarioDao.searchMatching(conn, myUsuario);
                if(lista!=null && lista.size()>0)
                {
                    myUsuario=(Usuarios)lista.get(0);
                    myUsuario.setCLAVE("");
                }
            }
         }
         catch(Exception e){
          e.printStackTrace();
        }
        finally{
          conexion.cerrarCx();
        }
        return myUsuario;
    }
    
    public void cerrarSesion(int idUsuario)throws Exception
    {
        String dirSesiones = "";
        try{
            dirSesiones = Funciones.leer_ini("/WSTransito.ini", "DIR_SESIONES");
        }catch(Exception exce){}
        
        if(dirSesiones.equals(""))
            dirSesiones = Funciones.leer_ini("c:\\WSTransito.ini", "DIR_SESIONES");
        
        File archivo = new File(dirSesiones);
        if(!archivo.exists())
        {
            try{
            archivo.createNewFile();
            }catch(Exception e){throw new Exception ("No se puede crear el directorio"+dirSesiones);};
        }
        File archivoSession = new File(dirSesiones+idUsuario+".session");
        if(archivoSession.exists())
        {
            archivoSession.delete();
        }
    }
    
    public boolean validarSesionActiva(Usuarios idUsuario,String ipAddress)throws Exception
    {
        String dirSesiones = "";
        String separador ="";
        try{
            dirSesiones = Funciones.leer_ini("/WSTransito.ini", "DIR_SESIONES");
            separador ="/";
        }catch(Exception exce){}
        
        if(dirSesiones.equals("")||dirSesiones.equals("/")||dirSesiones.equals("\\"))
        {
            dirSesiones = Funciones.leer_ini("C:\\WSTransito.ini", "DIR_SESIONES");
            separador ="\\";
        }
        
        if(dirSesiones.equals("") || dirSesiones.equals("/"))
            dirSesiones = "C:\\siot\\sesiones\\";

        if(!dirSesiones.endsWith("\\") && !dirSesiones.endsWith("/"))
            dirSesiones += separador;
        
        System.out.println("DIRECTORIO DE SESIONES = " +dirSesiones);
        
        try
        {
        File archivo = new File(dirSesiones);
        if(!archivo.exists())
        {
            try{
            archivo.createNewFile();
            }catch(Exception e){ System.out.println(e);  e.printStackTrace(); throw new Exception ("No se puede crear el directorio"+dirSesiones);};
        }
        
            File archivoSession = new File(dirSesiones+idUsuario.getID_USUARIO()+".session");
        if(archivoSession.exists())
        {
            FileInputStream reader = new FileInputStream (archivoSession.getPath());
            DataInputStream entrada = new DataInputStream(reader);
            BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
            String cadenaSession = buffer.readLine();
            //cadenaSession = Crypto.descifrar("S3rV1n7e5A1205!", archivoSession.getPath(), archivoSession.getPath()+"crypto");
            String[] listaValores = cadenaSession.split("#");
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            //servicios integrales
            //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            reader.close();
            Date fechaAnterior = formatter.parse(listaValores[3]);
            String direccionIP = listaValores[2];
            Date fechaActual = new Date();
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(fechaAnterior);
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(fechaActual);
            long diferenciaMinutos = ((cal2.getTimeInMillis() - cal1.getTimeInMillis())*60000)*60;
            int maxMInutosSesion = 0;
            
            try{
                maxMInutosSesion = Integer.valueOf(Funciones.leer_ini("/WsTransito.ini", "TIEMPO_SESION_MINUTOS"));
            }catch(Exception exce){}
            if(maxMInutosSesion == 0)
            try{
                maxMInutosSesion = Integer.valueOf(Funciones.leer_ini("c:\\WsTransito.ini", "TIEMPO_SESION_MINUTOS"));
            }catch(Exception exce){}
            
            
            if(diferenciaMinutos >= maxMInutosSesion)
            {
                if(ipAddress.equals(direccionIP))
                    return true;
                else 
                {
                    return false;
                }
            }
            else
            {
                cerrarSesion(idUsuario.getID_USUARIO());
                return false;
            }
        }
        else
        {
            return false;
        }
        }catch(Exception exce)
        {
            return false;
        }
    }
    
    public boolean iniciarSesion(Usuarios idUsuario,String ipAddress)throws Exception
    {
        
        String dirSesiones = "";
        String separador ="";
        try{
            dirSesiones = Funciones.leer_ini("/WSTransito.ini", "DIR_SESIONES");
            separador ="/";
        }catch(Exception exce){}
        
        if(dirSesiones.equals("")||dirSesiones.equals("/")||dirSesiones.equals("\\"))
        {
            dirSesiones = Funciones.leer_ini("C:\\WSTransito.ini", "DIR_SESIONES");
            separador ="\\";
        }
        
        if(dirSesiones.equals("") || dirSesiones.equals("/"))
            dirSesiones = "C:\\siot\\sesiones\\";

        if(!dirSesiones.endsWith("\\") && !dirSesiones.endsWith("/"))
            dirSesiones += separador;
        
        System.out.println("DIRECTORIO DE SESIONES = " +dirSesiones);
        
        try
        {
        File archivo = new File(dirSesiones);
        if(!archivo.exists())
        {
            try{
            archivo.createNewFile();
            }catch(Exception e){ System.out.println(e);  e.printStackTrace(); throw new Exception ("No se puede crear el directorio"+dirSesiones);};
        }
        
            File archivoSession = new File(dirSesiones+idUsuario.getID_USUARIO()+".session");
        if(archivoSession.exists())
        {
            FileInputStream reader = new FileInputStream (archivoSession.getPath());
            DataInputStream entrada = new DataInputStream(reader);
            BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
            String cadenaSession = buffer.readLine();
            //cadenaSession = Crypto.descifrar("S3rV1n7e5A1205!", archivoSession.getPath(), archivoSession.getPath()+"crypto");
            String[] listaValores = cadenaSession.split("#");
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            //servicios integrales
            //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            reader.close();
            Date fechaAnterior = formatter.parse(listaValores[3]);
            String direccionIP = listaValores[2];
            Date fechaActual = new Date();
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(fechaAnterior);
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(fechaActual);
            long diferenciaMinutos = ((cal2.getTimeInMillis() - cal1.getTimeInMillis())*60000)*60;
            int maxMInutosSesion = 0;
            
            try{
                maxMInutosSesion = Integer.valueOf(Funciones.leer_ini("/WsTransito.ini", "TIEMPO_SESION_MINUTOS"));
            }catch(Exception exce){}
            if(maxMInutosSesion == 0)
            try{
                maxMInutosSesion = Integer.valueOf(Funciones.leer_ini("c:\\WsTransito.ini", "TIEMPO_SESION_MINUTOS"));
            }catch(Exception exce){}
            
            
            if(diferenciaMinutos >= maxMInutosSesion)
            {
                if(ipAddress.equals(direccionIP))
                    return true;
                else 
                {
                    //cerrarSesion(idUsuario);
                    throw new Exception ("El usuario ya se encuentra autenticado en otra maquina");
                }
            }
            else
            {
                cerrarSesion(idUsuario.getID_USUARIO());
                throw new Exception ("Su sesion a caducado");
            }
        }
        else
        {
            archivoSession.createNewFile();
            FileWriter writer = new FileWriter(archivoSession.getPath());
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            //servicios integrales
            //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String cadenaSession = idUsuario.getID_USUARIO()+ "#"+ idUsuario.getLOGIN() +"#"+ipAddress+"#"+formatter.format(new Date());
            
            //cadenaSession = Crypto.cifrar("S3rV1n7e5A1205!",cadenaSession,archivoSession.getPath()+"cripto");
            writer.write(cadenaSession);
            writer.close();
            
            return true;
        }
        }catch(Exception exce)
        {
            System.out.println(exce.getMessage());
            exce.printStackTrace();
            throw new Exception (exce.getMessage());
        }
    }
    
    public Usuarios validarUsuario(Usuarios myUsuario, int modulo, String ipAdress) throws Exception {
        List lista=null;
        String login;
        login=myUsuario.getLOGIN();
        login=login.replace("'", "");
        login=login.replace("\"", "");
        login=login.replace("-", "");
        login=login.replace("%", "");
        login=login.replace("&", "");
        login=login.replace("#", "");
        myUsuario.setLOGIN(login);
        try{
            if(modulo==0)
                conn= conexion.conectar();
            else
                conn = conexion.conectarComparendos();
            UsuariosDao myUsuarioDao = new UsuariosDao();
            //Se valida que no este en uso el login
            myUsuario.setCLAVE(myUsuario.getCLAVE());
            lista=myUsuarioDao.searchMatching(conn, myUsuario);
            if(lista!=null && lista.size()>0)
            {
                myUsuario=(Usuarios)lista.get(0);
                if(!iniciarSesion(myUsuario,ipAdress))
                {
                   myUsuario = null; 
                }
            }
            else
            {
                myUsuario=null;
            }
         }
         catch(Exception e){
          e.printStackTrace();
          throw new Exception(e.getMessage());
        }
        finally{
          conexion.cerrarCx();
        }
        return myUsuario;
    }
    
    public int cambiarInicio(Usuarios myUsuario,String Mycadena,int modulo)
        {
            List lista=null;
            int cambio=2; //0 si se hizo el cambio, 1 si la clave ya se habia utilizado, 2 en caso de no encontrar el usuario, 3 si hay una excepxion
            Usuarios tmp = new Usuarios();
            tmp.setLOGIN(myUsuario.getLOGIN());      
            try{
                
                if(modulo==0)
                    conn= conexion.conectar();
                else
                    conn = conexion.conectarComparendos();
                UsuariosDao myUsuarioDao = new UsuariosDao();
                lista=myUsuarioDao.searchMatching(conn, tmp);
                if(lista == null)
                {
                    //tmp.setCLAVE(Seguridad.getHash(Mycadena)); //Aki toca aplicar el hash
                    tmp.setCLAVE(Mycadena);
                    lista=myUsuarioDao.searchMatching(conn, tmp);
                }
                if(lista!=null && lista.size()>0)//Si encontro al usuario
                {
                    tmp = (Usuarios)lista.get(0);
                    Clavesutilizadas tmpclavesutilizadas = new Clavesutilizadas();
                    tmpclavesutilizadas.setID_USUARIO(tmp.getID_USUARIO());
                    tmpclavesutilizadas.setCLAVE(myUsuario.getCLAVE());
                    GestionClavesutilizadas tmpGestionClavesUtilizadas = new GestionClavesutilizadas();
                    List lstClaves = tmpGestionClavesUtilizadas.buscarClavesutilizadas(tmpclavesutilizadas);
                    if (lstClaves != null && lstClaves.size() > 0) //Si la nueva clave esta ya a sido utilizada
                        cambio = 1;
                    else
                    {
                        if(!myUsuario.getCLAVE().equals(""))
                        {
                            //Aki toca aplicar el hash
                            //myUsuario.setCLAVE(Seguridad.getHash(myUsuario.getCLAVE()));
                            myUsuario.setFECHA_CLAVE(Funciones.getFechaSistemaFab(conn, myMotor));
                            myUsuario.setID_USUARIO(tmp.getID_USUARIO());
                            myUsuarioDao.actualizarClave(conn, myUsuario); //Se actualiza la clave
                            
                            tmpclavesutilizadas.setCLAVE(myUsuario.getCLAVE());
                            tmpGestionClavesUtilizadas.crearClavesutilizadas(tmpclavesutilizadas); //Se crea el registro de la nueva clave
                            
                            Historicoclaves tmpHistoricoclaves = new Historicoclaves();
                            tmpHistoricoclaves.setID_USUARIO(tmpclavesutilizadas.getID_USUARIO());
                            //tmpHistoricoclaves.setCLAVE(tmpclavesutilizadas.getCLAVE());
                            GestionHistoricoclaves tmpGestionHistoricoclaves = new GestionHistoricoclaves();
                            List lsthistorico = tmpGestionHistoricoclaves.buscarHistoricoclaves(tmpHistoricoclaves);
                            if (lsthistorico != null && lsthistorico.size() > 0)
                            {
                                tmpHistoricoclaves = (Historicoclaves)lsthistorico.get(0);
                                tmpHistoricoclaves.setCLAVE(myUsuario.getCLAVE());
                                tmpGestionHistoricoclaves.editarHistoricoclaves(tmpHistoricoclaves);
                            }
                            cambio = 0;
                        }
                        else
                            cambio=2;                 
                    }
                }
                else
                {
                   cambio=2; 
                }
             }
             catch(Exception e){
              e.printStackTrace();
              cambio = 3;
            }
            finally{
              conexion.cerrarCx();
            }
            return cambio;
        }
        
        public Usuarios actualizarUsuario(Usuarios myUsuario,int idUsuario,String myIp,String myHost, int modulo, boolean actualizarFechaClave)
        {
            List lista=null;
            int id;
            String estado;
            //Campos para la auditoria
            Auditoria myAuditoria;
            AuditoriaSystem myAuditSx;
            Usuarios anterior;
            //--Campos para la auditoria
            try{
                if(modulo==0)
                    conn= conexion.conectar();
                else
                    conn = conexion.conectarComparendos();
                UsuariosDao myUsuarioDao = new UsuariosDao();
                //Se valida que no este en uso el login
                anterior = new Usuarios();
                anterior.setID_USUARIO(myUsuario.getID_USUARIO());
                lista=myUsuarioDao.searchMatching(conn, anterior);
                if(lista!=null && lista.size()>0)
                {
                    anterior=(Usuarios)lista.get(0);
                }
                else
                {
                    anterior=null;
                }
                estado=myUsuario.getESTADO();
                if(estado.equals("R"))
                    myUsuario.setFECHARETIRO(Funciones.getFechaSistema(conn,myMotor));
                 if(actualizarFechaClave)
                    myUsuario.setFECHA_CLAVE(Funciones.getFechaSistema(conn, myMotor));
                 myUsuarioDao.actualizarDatos(conn, myUsuario);
                 //Pasos para la auditoria
                 myAuditoria = new Auditoria();
                 myAuditSx= new AuditoriaSystem();
                 myAuditSx.setTABLAAFECTADA("USUARIOS");
                 myAuditSx.setCAMPOCLAVE("ID_USUARIO");
                 myAuditSx.setVLRCAMPOCLAVE(String.valueOf(myUsuario.getID_USUARIO()));
                 myAuditSx.setID_USUARIO(idUsuario);
                 myAuditSx.setIP(myIp);
                 myAuditSx.setNOMBREEQUIPO(myHost);
                 System.out.println("Antes de Auditoria");
                 myAuditoria.auditarEdicion(conn,myAuditSx,anterior,myUsuario,myIp,myHost,0);
                 //-- para la auditoria
                id=myUsuario.getID_USUARIO();
                myUsuario = new Usuarios();
                myUsuario.setID_USUARIO(id);
                
                lista=myUsuarioDao.searchMatching(conn, myUsuario);
                if(lista!=null && lista.size()>0)
                {
                    myUsuario=(Usuarios)lista.get(0);
                    myUsuario.setCLAVE("");
                }
                else
                {
                   myUsuario=null;
                }
             }
             catch(Exception e){
              e.printStackTrace();
            }
            finally{
              conexion.cerrarCx();
            }
            return myUsuario;
        }
  
    public List getOpcionesPerfil(PerfilOpcion myPerOpc,int modulo)
    {
          List mylista;
          mylista = null;
          try
      {
          if(modulo==0)
              conn= conexion.conectar();
          else
              conn = conexion.conectarComparendos();
        PerfilOpcionDao myPerOpcDao = new PerfilOpcionDao();
        mylista = myPerOpcDao.searchMatching(conn, myPerOpc);
      }
      catch (Exception e){
        e.printStackTrace();
      }
      finally{
        conexion.cerrarCx();
      }
      return mylista;
    }
    
    public PerfilOpcion insertarPerfilOpcion(PerfilOpcion myPerOpc, int modulo)
    {
        int id;
        List lista=null;
        Funciones fnc=new Funciones();
        try{
            if(modulo==0)
                conn= conexion.conectar();
            else
                conn = conexion.conectarComparendos();
            PerfilOpcionDao myPerOpcDao = new PerfilOpcionDao();
            myMotor=myMotor.toUpperCase();
            id=Funciones.obtenerId(conn, "GENPERFIL_OPCION", "GEN_PERFILOPCION", myMotor);
            myPerOpc.setID_PERFIL_OPCION(id);
            myPerOpcDao.create(conn, myPerOpc);
            myPerOpc=new PerfilOpcion();
            myPerOpc.setID_PERFIL_OPCION(id);
            lista=myPerOpcDao.searchMatching(conn, myPerOpc);
            if(lista!=null && lista.size()>0)
            {
                myPerOpc=(PerfilOpcion)lista.get(0);
            }
         }
         catch(Exception e){
          e.printStackTrace();
        }
        finally{
          conexion.cerrarCx();
        }
        return myPerOpc;
    }
    
    public void eliminarPerfilOpcion(PerfilOpcion myPerOpc, int modulo){
        PerfilOpcionDao myPerOpcDao = new PerfilOpcionDao();        
        try
        {
            if(modulo==0)
                conn= conexion.conectar();
            else
                conn = conexion.conectarComparendos();
            myPerOpcDao.delete(conn, myPerOpc);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
            conexion.cerrarCx();
        }
    }
    
    public void imprimirHash()
    {
        try {
            System.out.println("el hash 123 es: " + Seguridad.getHash("123"));
        } catch (NoSuchAlgorithmException e) {
            System.out.println("el codigo del error es:"+e);
        }
    }
        
    public Usuarios validarUsuario(Usuarios usuarios, int i) {
        return null;
    }
}