package utilidades;

import java.sql.Connection;

import java.util.List;

import modelo.datos.dao.generales.AuditoriaSystemDao;
import modelo.datos.objetos.generales.AuditoriaSystem;


public class Auditoria {
    
    //Conexion conexion;
    //Connection conn;
    String myMotor;
    
    public Auditoria() {
        super();
        //conexion = new Conexion();
        myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
    }
    
    public void auditarInsersion(Connection conn, AuditoriaSystem myAudiSx,Object myObj,int modulo)
    {
        String objStr="";
         Class claseoriginal = myObj.getClass();
         Object tmp;
        try {
            tmp = claseoriginal.newInstance();
            tmp = myObj;
            objStr = tmp.toString();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
                        
        //String objStr=myObj.toString();
        
        String[] segmentos = objStr.split(": ") ;
        objStr="";
        for(int i=0;i<segmentos.length;i++)
        {
            if(segmentos[i].contains(" = "))
            {
                objStr+=segmentos[i];
                objStr+=" ";
            }
        }
        myAudiSx.setDESCRIPOPERACION("Se inserto el registro con las siguientes caracteristicas: " + objStr);
        myAudiSx.setTIPOPERACION("I");
        insertarAuditoriaSistem(conn, myAudiSx,modulo);
    }
    
    public void auditarEdicion(Connection conn, AuditoriaSystem myAudiSx,Object myObjAnterior, Object myObjNuevo,String ip,String equipo,int modulo)
    {
        String dif = compararObjetos(myObjAnterior, myObjNuevo);
        if (!dif.equals("")) {
            myAudiSx.setIP(ip);
            myAudiSx.setNOMBREEQUIPO(equipo);
            myAudiSx.setDESCRIPOPERACION("Se cambio un registro de la siguiente manera: " + dif);
            myAudiSx.setTIPOPERACION("E");
            insertarAuditoriaSistem(conn, myAudiSx,modulo);
        }
    }
    
    public void auditarEliminacion(Connection conn, AuditoriaSystem myAudiSx,Object myObj,int modulo)
    {
        
        String objStr="";
         Class claseoriginal = myObj.getClass();
         Object tmp;
        try {
            tmp = claseoriginal.newInstance();
            objStr = tmp.toString();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        
        //String objStr=myObj.toString();
        
        
        String[] segmentos = objStr.split(": ") ;
        objStr="";
        for(int i=0;i<segmentos.length;i++)
        {
            if(segmentos[i].contains(" = "))
            {
                objStr+=segmentos[i];
            }
        }
        myAudiSx.setDESCRIPOPERACION("Se elimino un registro con las siguientes caracteristicas: \n" + objStr);
        myAudiSx.setTIPOPERACION("B");
        insertarAuditoriaSistem(conn, myAudiSx,modulo);
    }
    
    public void auditarOtraOp(Connection conn, AuditoriaSystem myAudiSx,int modulo)
    {
        
        if(myAudiSx.getDESCRIPOPERACION()==null || myAudiSx.getDESCRIPOPERACION().equals(""))
        myAudiSx.setDESCRIPOPERACION("Operaci-*-n Gen-*-rica Auditada");
        
        
        insertarAuditoriaSistem(conn, myAudiSx,modulo);
    }
    
    public void insertarAuditoriaSistem(Connection conn, AuditoriaSystem myAudiSx,int modulo)
    {
        int id;
        List lista=null;
        Funciones fnc=new Funciones();  
        try{
            /*if(modulo==1)
                conn=conexion.conectarComparendos();
            else
                conn = conexion.conectar();*/
            AuditoriaSystemDao myAudiSxDao = new AuditoriaSystemDao();
            myMotor=myMotor.toUpperCase();
            id=Funciones.obtenerId(conn, "GEN_AUDITORIASYSTEM", "GEN_AUDITORIASYSTEM", myMotor);
            myAudiSx.setFECHAOPERACION(Funciones.getFechaSistema(conn,myMotor));
            myAudiSx.setHORAOPERACION(Funciones.getHoraSistema().toString());         
            myAudiSx.setID_AUDSYSTEM(id);
            myAudiSxDao.create(conn, myAudiSx,myMotor);
         }
         catch(Exception e){
          e.printStackTrace();
        }
        finally{
          //conexion.cerrarCx();
        }
    }
    
    public static String compararObjetos(Object obj1,Object obj2)
    {
        String dif="";
        String str1="";
        String str2="";
        
        Class claseoriginal1 = obj1.getClass();
        Class claseoriginal2 = obj2.getClass();
         Object tmp1,tmp2;
        try {
            tmp1 = claseoriginal1.newInstance();
            str1 = tmp1.toString();
            
            tmp2 = claseoriginal2.newInstance();
            str2 = tmp2.toString();
            
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        
                
        //str1=obj1.toString();
        //str2=obj2.toString();
            
        
        
        
        
        String[] campos1=str1.split("\\n");
        String[] campos2=str2.split("\\n");
        for(int i=0;i<campos1.length;i++)
        {
            if(campos1[i].contains(" = "))
            {
                if(!compararAtributos(campos1[i], campos2[i]))
                {
                    dif+=" antes "+campos1[i]+" ahora "+ campos2[i];
                }
            }
        }
        return dif;
    }
    
    public static boolean compararAtributos(String atr1,String atr2)
    {
        boolean iguales = true;
        String tmp1=(atr1.split(" ="))[1];
        String tmp2=(atr2.split(" ="))[1];
        if(!tmp1.equals(tmp2))
            iguales=false;
        if((tmp1.contains("null")&&tmp2.equals(""))||(tmp1.equals("")&&tmp2.contains("null")))
            iguales=true;
        if((tmp1.contains("null")&&tmp2.equals(" "))||(tmp1.equals(" ")&&tmp2.contains("null")))
            iguales=true;
        return iguales;
    }
    
}
