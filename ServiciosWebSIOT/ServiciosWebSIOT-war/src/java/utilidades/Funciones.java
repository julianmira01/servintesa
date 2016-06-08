package utilidades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.io.OutputStream;

import java.net.InetAddress;
import java.net.UnknownHostException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import modelo.conexion.Conexion;

import modelo.datos.dao.accesorias.GetTimeHourDao;
import modelo.datos.objetos.accesorias.GetTimeHour;
import modelo.datos.objetos.generales.Item;

public class Funciones {

    private static String rutaWSini = "/WSTransito.ini"; //transito Medellin
   // private static String rutaini="/WSTransitoPopayan.ini"; //transito Popayan

    private static String myMotor = "";
    
    private static String server ="";

    public Funciones() {
        super();
        
        try{
            server = Funciones.leer_ini("/WSTransito.ini", "SERVER");
        }catch(Exception exce){}
        
        if(server.equals(""))
        try{
            server = Funciones.leer_ini("c:\\WSTransito.ini", "SERVER");
        }catch(Exception exce){}
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        
        myMotor = myMotor.toUpperCase();
    }

    public static void main(String[] args) {
        String[] host = Funciones.getIpServidor();
        System.out.println(host[0]);
        System.out.println(host[1]);

        String fecha1 = "2012-05-16";
        String fecha2 = "06/17/2013";
        String fecha11 = "2012-05-16 15:16:00";
        String fecha21 = "06/17/2013 15:16:00";
        System.out.println(fecha1 + " > " + Funciones.cambiarFormatoFecha1(fecha1));
        System.out.println(fecha11 + " > " + Funciones.cambiarFormatoFechaHora1(fecha11));
        System.out.println(fecha2 + " > " + Funciones.cambiarFormatoFecha2(fecha2));
        System.out.println(fecha21 + " > " + Funciones.cambiarFormatoFechaHora2(fecha21));


    }

    public static boolean validarRuta(String ruta) {
        boolean res = false;
        File myArchivo = new File(ruta);
        if (myArchivo.exists()) {
            res = true;
        } else {
            res = myArchivo.mkdirs();
        }
        return res;
    }

    public static String convFechaSQLS(java.sql.Date d) { //fecha de sql a string
        Calendar cal = null;
        String str_date = "";
        try {
            DateFormat formatter;
            Date date;
            date = new Date(d.getTime());
            //formatter = new SimpleDateFormat("yyyy/MM/dd");
            formatter = new SimpleDateFormat("yyyy-MM-dd");
            str_date = (String)formatter.format(date);
        } catch (Exception e) {
            System.out.println("Exception :" + e);
            e.printStackTrace();
        }
        return str_date;

    }


    public static java.sql.Date convFechaSSQL(String d) { //fecha de string a sql date
        Calendar cal = null;
        java.sql.Date myFecha;
        String myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
            myMotor = Funciones.leer_ini("C:\\WSTransito.ini", "MOTOR");
        
        SimpleDateFormat formatoDelTexto = null;
        try {

            //if (myMotor.equals("FIREBIRD"))
            //  formatoDelTexto = new SimpleDateFormat("MM/dd/yyyy");
            //else if (myMotor.equals("ORACLE"))
            //  formatoDelTexto = new SimpleDateFormat("dd/MM/yy");

            formatoDelTexto = new SimpleDateFormat("MM/dd/yyyy");

            //SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
            String strFecha = d;
            //d = d.replace('/', '-');
            Date fecha = null;
            //System.out.println("La fecha a cambiar es :"+strFecha);
            fecha = formatoDelTexto.parse(strFecha);
            //System.out.println("La fecha a modificada es :"+fecha.toString());
            myFecha = new java.sql.Date(fecha.getTime());
            //System.out.println("La fecha a modificada es :"+myFecha.toString());
            return myFecha;
        } catch (Exception e) {
            System.out.println("Exception :" + e);
            //e.printStackTrace();
            return convFechaSSQL2(d);
        }
    }
    
    public static java.sql.Date convFechaSSQL(String d, String formatoTexto) { 
        Calendar cal = null;
        java.sql.Date myFecha;
        
        SimpleDateFormat formatoDelTexto = null;
        
        System.out.println("formato de fecha: " + formatoTexto);
        
        try {

            if(formatoTexto == null || formatoTexto == "")
                formatoDelTexto = new SimpleDateFormat("MM/dd/yyyy");
            else formatoDelTexto = new SimpleDateFormat(formatoTexto);
                       
            String strFecha = d;
            Date fecha = null;
            fecha = formatoDelTexto.parse(strFecha);

            myFecha = new java.sql.Date(fecha.getTime());
    
            return myFecha;
            
        } catch (Exception e) {
            System.out.println("Exception :" + e);
            //e.printStackTrace();
            return null;
        }
    }
    
   
   
      
    //Convierte del formato MM/dd/yyyy al formato apropiado seg-*-n la conexi-*-n a la BD
  public static String convFechaFormatoMotor(String fecha) {
      String myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
            myMotor = Funciones.leer_ini("C:\\WSTransito.ini", "MOTOR");    
      
      try {
          String[] fechaPartes = fecha.split("/");
          String fechaSegunMotor = "";
              
          String MM = fechaPartes[0];
          String dd = fechaPartes[1];
          String yyyy = fechaPartes[2];
          
          if (myMotor.equals("FIREBIRD"))
            //MM/dd/yyyy
            fechaSegunMotor = MM + "/" + dd + "/" + yyyy;
          else if (myMotor.equals("ORACLE"))
            //dd/MM/yyyy
            fechaSegunMotor = dd + "/" + MM + "/" + yyyy;          
          
          return fechaSegunMotor;
      } catch (Exception e) {
          System.out.println("Exception :" + e);
          //e.printStackTrace();
          return "";
      }
  }
  
  public static java.sql.Date convFechaDTMotor(String fecha) {
      String myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
            myMotor = Funciones.leer_ini("C:\\WSTransito.ini", "MOTOR");
        
      SimpleDateFormat formatoDelTexto = new SimpleDateFormat("MM/dd/yyyy");
      Date myFecha;
      java.sql.Date myFecha2;
      
      try {        
          
           myFecha = formatoDelTexto.parse(fecha);
            //System.out.println("La fecha a modificada es :"+fecha.toString());
           myFecha2 = new java.sql.Date(myFecha.getTime());
            
          return myFecha2;
          
      } catch (Exception e) {
          System.out.println("Exception :" + e);
          //e.printStackTrace();
          return null;
      }
  }

    public static java.sql.Date convFechaSSQLGuiones(String d) { //fecha de string a sql date
        Calendar cal = null;
        java.sql.Date myFecha;
        try {
            SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
            //SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
            String strFecha = d;
            //d = d.replace('/', '-');
            Date fecha = null;
            //System.out.println("La fecha a cambiar es :"+strFecha);
            fecha = formatoDelTexto.parse(strFecha);
            //System.out.println("La fecha a modificada es :"+fecha.toString());
            myFecha = new java.sql.Date(fecha.getTime());
            //System.out.println("La fecha a modificada es :"+myFecha.toString());
            return myFecha;
        } catch (Exception e) {
            System.out.println("Exception :" + e);
            //e.printStackTrace();
            return convFechaSSQL2(d);
        }
    }


    public static java.sql.Date convFechaSSQL2(String d) { //fecha de string a sql date
        Calendar cal = null;
        java.sql.Date myFecha;
        try {
            SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
            String strFecha = d;
            //d = d.replace('/', '-');
            Date fecha = null;
            //System.out.println("La fecha a cambiar es :"+strFecha);
            fecha = formatoDelTexto.parse(strFecha);
            //System.out.println("La fecha a modificada es :"+fecha.toString());
            myFecha = new java.sql.Date(fecha.getTime());
            //System.out.println("La fecha a modificada es :"+myFecha.toString());
            return myFecha;
        } catch (Exception e) {
            System.out.println("Exception :" + e);
            e.printStackTrace();
        }
        return null;
    }


    public static java.sql.Date convFechaHoraSSQL(String d) { //fecha de string a sql date
        Calendar cal = null;
        java.sql.Date myFecha;
        try {
            //SimpleDateFormat formatoDelTexto = new SimpleDateFormat("MM/dd/yyyy");
            SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String strFecha = d;
            d = d.replace('/', '-');
            Date fecha = null;
            fecha = formatoDelTexto.parse(strFecha);
            myFecha = new java.sql.Date(fecha.getTime());
            return myFecha;
        } catch (Exception e) {
            System.out.println("Exception :" + e);
            e.printStackTrace();
        }
        return null;
    }

    public static java.sql.Date convFechaSSQLInv(String d) { //fecha de string a sql date
        Calendar cal = null;
        java.sql.Date myFecha;
        try {
            //SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
            String strFecha = d;
            d = d.replace('/', '-');
            Date fecha = null;
            //System.out.println("La fecha a cambiar es :"+strFecha);
            fecha = formatoDelTexto.parse(strFecha);
            //System.out.println("La fecha a modificada es :"+fecha.toString());
            myFecha = new java.sql.Date(fecha.getTime());
            //System.out.println("La fecha a modificada es :"+myFecha.toString());
            return myFecha;

        } catch (Exception e) {
            System.out.println("Exception :" + e);
            e.printStackTrace();
            return null;
        }
    }

    public static java.sql.Date convFechaCD(Calendar d) { // fecha de calendar a date
        java.sql.Date date = null;
        try {
            SimpleDateFormat formatter;
            //formatter = new SimpleDateFormat("MM/dd/YYYY");
            formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = new java.sql.Date(d.getTime().getTime());

            date.valueOf(formatter.format(date));
        } catch (Exception e) {
            System.out.println("Exception :" + e);
            e.printStackTrace();
        }
        return date;
    }


    public static Calendar convFechaDC(java.sql.Date d) { // fecha de date a calendar
        Calendar cal = null;
        try {
            DateFormat formatter;
            cal = Calendar.getInstance();
            Date dato = new Date(d.getTime());
            cal.setTime(dato);
        } catch (Exception e) {
            System.out.println("Exception :" + e);
            e.printStackTrace();
        }
        return cal;

    }


    public static Date convFechaSQLD(java.sql.Date d) { // de sql date a date
        Date dato = null;
        try {
            dato = new Date(d.getTime());

        } catch (Exception e) {
            System.out.println("Exception :" + e);
            e.printStackTrace();
        }
        return dato;

    }

    public static java.sql.Date convFecha(Date d) { // fecha de date a sql date
        java.sql.Date date = null;
        try {
            DateFormat formatter;
            date = new java.sql.Date(d.getTime());
        } catch (Exception e) {
            System.out.println("Exception :" + e);
            e.printStackTrace();
        }
        return date;

    }
    
    public static String convertirFechaSOAP(String fecha1)
    {
        System.out.println(fecha1);
        Calendar calendar = Calendar.getInstance();
                
        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a",Locale.US);
        try{
            Funciones funciones = new Funciones();
            
            Date d  = sdf.parse(fecha1);// sdf.parse(fecha1);
            calendar.setTime(d);
            }catch(Exception exce)
            {
            System.out.println(exce.getStackTrace());            
            }
        
        String fecha2 = org.apache.axis2.databinding.utils.ConverterUtil.convertToString(calendar);
        System.out.println(fecha2);
        return fecha2;
    }
    
    public static Calendar convFechaSC(String d) { //fecha de string a sql calendar
        Calendar cal = null;
        if (d != null && d != "") {
            try {
                String str_date = "11-June-07";
                str_date = d;
                DateFormat formatter;
                Date date;
                //formatter = new SimpleDateFormat("MM/dd/yyyy");
                formatter = new SimpleDateFormat("yyyy-MM-dd");
                date = (Date)formatter.parse(str_date);
                cal = Calendar.getInstance();
                cal.setTime(date);
                return cal;
            } catch (Exception e) {
                System.out.println("Exception :" + e);
                e.printStackTrace();
            }
            return null;
        } else
            return null;

    }

    public static Calendar convFechaTiempo(String d) { //fecha de string a sql calendar
        Calendar cal = null;
        try {
            String str_date = "11-June-07";
            str_date = d;
            DateFormat formatter=null;
            Date date;
            //formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            if (myMotor.equals("FIREBIRD"))
                formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            else if (myMotor.equals("ORACLE"))
                //formatter = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
            formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date = (Date)formatter.parse(str_date);
            cal = Calendar.getInstance();
            cal.setTime(date);
            return cal;
        } catch (Exception e) {
            System.out.println("Exception :" + e);
            e.printStackTrace();
        }
        return null;
    }
    
    public static Calendar convFechaTiempoSolofecha(String d) { //fecha de string a sql calendar
        Calendar cal = null;
        try {
            String str_date = "11-June-07";
            str_date = d;
            DateFormat formatter=null;
            Date date;
            //formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            if (myMotor.equals("FIREBIRD"))
                formatter = new SimpleDateFormat("yyyy-MM-dd");
            else if (myMotor.equals("ORACLE"))
                //formatter = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
            formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date = (Date)formatter.parse(str_date);
            cal = Calendar.getInstance();
            cal.setTime(date);
            return cal;
        } catch (Exception e) {
            System.out.println("Exception :" + e);
            e.printStackTrace();
        }
        return null;
    }
    
    

    public static java.sql.Time convTimeSSQL(String d) { //fecha de string a sql date
        Calendar cal = null;
        try {
            String str_date;
            str_date = d;
            DateFormat formatter;
            Date date;
            Time mytime;
            formatter = new SimpleDateFormat("HH:mm:ss");
            mytime = (Time)formatter.parse(str_date);
            return mytime;
        } catch (Exception e) {
            System.out.println("Exception :" + e);
            e.printStackTrace();
        }
        return null;

    }
    
    public static void escribirArchivo(String url, String valor) {
            try {
                File archivo = new File(url);
                BufferedWriter bw;
                bw = new BufferedWriter(new FileWriter(archivo));
                bw.flush();
                bw.append(valor);
                bw.close();
                
            } catch (Exception e) {
                System.out.println("error al leer el archivo .ini:" + e.getMessage());
                e.printStackTrace();
            }
        }
        
        public static String leerArchivo(String url) {
            String valor = "";
            try {
                File archivo = new File (url);
                FileReader fr = new FileReader (archivo);
                BufferedReader br = new BufferedReader(fr);
                String linea = br.readLine();
                valor += linea;
                br.close();
                fr.close();
                
            } catch (Exception e) {
                System.out.println("error al leer el archivo .ini:" + e.getMessage());
                e.printStackTrace();
                return "";
            }
            return valor;
        }


    public static String convByteArrayToString(byte[] dat) {
        //String s1 = Base64.encode(dat);
        String s1 = new String(dat);
        return s1;
    }

    public static boolean esEntero(String n) {
        int resultado;
        try {
            resultado = Integer.parseInt(n);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public static boolean esDouble(String n) {
        double resultado;
        try {
            resultado = Double.valueOf(n).doubleValue();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public static boolean idEsValido(int n) {
        if (n > 0)
            return true;
        return false;
    }

    public static boolean EnteroesNulo(int n) {
        String cad;
        try {
            cad = String.valueOf(n);
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public static boolean FloatEsNulo(Float n) {
        String cad;
        try {
            cad = String.valueOf(n);
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public static boolean DoubleEsNulo(Double n) {
        String cad;
        try {
            cad = String.valueOf(n);
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public static boolean esFecha(String d) { //fecha de string a sql date
        Calendar cal = null;
        if (d == null || d.equals(""))
            return false;
        try {
            String str_date;
            str_date = d;
            DateFormat formatter;
            Date date;
            formatter = new SimpleDateFormat("MM/dd/yyyy");
            //formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = (Date)formatter.parse(str_date);
            System.out.println(date.toString());
            cal = Calendar.getInstance();
            cal.setTime(date);
            convFechaCD(cal);
            return true;
        } catch (ParseException e) {
            System.out.println("Exception :" + e);
            //e.printStackTrace();
            return esFecha2(d);
        } catch (NullPointerException e) {
            return false;
        }
    }

    public static boolean esFecha2(String d) { //fecha de string a sql date
        Calendar cal = null;
        if (d == null || d.equals(""))
            return false;
        try {
            String str_date;
            str_date = d;
            DateFormat formatter;
            Date date;
            formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = (Date)formatter.parse(str_date);
            System.out.println(date.toString());
            cal = Calendar.getInstance();
            cal.setTime(date);
            convFechaCD(cal);
            return true;
        } catch (ParseException e) {
            System.out.println("Exception :" + e);
            e.printStackTrace();
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public static boolean esFechaHora(String d) { //fecha de string a sql date
        Calendar cal = null;
        try {
            String str_date;
            str_date = d;
            DateFormat formatter = null;
            Date date;
            //formatter = new SimpleDateFormat("MM/dd/yyyy");
            String myMotor = "";
        
            try{
                myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
            }catch(Exception exce){}
            if(myMotor.equals(""))
                myMotor = Funciones.leer_ini("C:\\WSTransito.ini", "MOTOR");

            if (myMotor.equals("FIREBIRD"))
                formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            else if (myMotor.equals("ORACLE"))
                formatter = new SimpleDateFormat("dd/MM/yy hh:mm:ss aa");

            date = (Date)formatter.parse(str_date);
            System.out.println(date.toString());
            cal = Calendar.getInstance();
            cal.setTime(date);
            convFechaCD(cal);
            return true;
        } catch (ParseException e) {
            System.out.println("Exception :" + e);
            e.printStackTrace();
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public static boolean esTime(String d) { //es time?
        Calendar cal = null;
        try {
            String str_date;
            str_date = d;
            DateFormat formatter;
            Date date;
            formatter = new SimpleDateFormat("HH:mm:ss");
            date = (Date)formatter.parse(str_date);
            cal = Calendar.getInstance();
            cal.setTime(date);
            convFechaCD(cal);
            return true;
        } catch (ParseException e) {
            System.out.println("Exception :" + e);
            e.printStackTrace();
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }


    public static boolean contarCadena(String s, int max) {
        try {
            if (s.length() <= max && s.length() > 0)
                return true;
            else
                return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static String getFechaSistema(Connection cx, String motor) {
        /*Date fechaActual = new Date();
        //SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        */
        String retorno = "";

        //if (motor.equals("FIREBIRD"))
            retorno = getFechaSistema2("MM/dd/yyyy", cx);
        //else if (motor.equals("ORACLE"))
            //retorno = getFechaSistema2("dd/MM/yy", cx);


        return retorno;
    }
    
    public static String getFechaSistemaFab(Connection cx, String motor) {
        /*Date fechaActual = new Date();
        //SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        */
        String retorno = "";

        if (motor.equals("FIREBIRD"))
            retorno = getFechaSistema2("MM/dd/yyyy", cx);
        else if (motor.equals("ORACLE"))
            retorno = getFechaSistema2("dd/MM/yy", cx);


        return retorno;
    }
    
    public static String getFechaSistemaSegunMotor(Connection cx, String motor) {
        /*Date fechaActual = new Date();
        //SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        */
        String retorno = "";

        if (motor.equals("FIREBIRD"))
            retorno = getFechaSistema2("MM/dd/yyyy", cx);
        else if (motor.equals("ORACLE"))
            retorno = getFechaSistema2("dd/MM/yyyy", cx);


        return retorno;
    }
    

    public static String getFechaSistema2(String formato, Connection cx) {
        Conexion conexion = null;
        Connection conn;
        String myMotor;
        boolean ban = false;

        try {
            if (cx == null) {
                ban = true;
                conexion = new Conexion();
                myMotor = "";
        
                try{
                    myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
                }catch(Exception exce){}
                if(myMotor.equals(""))
                    myMotor = Funciones.leer_ini("C:\\WSTransito.ini", "MOTOR");
                conn = conexion.conectar();
            } else
                conn = cx;
            GetTimeHourDao myDao = new GetTimeHourDao();
            GetTimeHour tmp = new GetTimeHour();

            myDao.load(conn, tmp);
            formato = formato.replace("dd", completarCeros(String.valueOf(tmp.getDIA()), 2));
            formato = formato.replace("MMMM", getMes(tmp.getMES()));
            formato = formato.replace("MM", completarCeros(String.valueOf(tmp.getMES()), 2));
            formato = formato.replace("yyyy", String.valueOf(tmp.getANIO()));
            formato = formato.replace("hh", completarCeros(String.valueOf(tmp.getHORA()), 2));
            formato = formato.replace("mm", completarCeros(String.valueOf(tmp.getMINUTO()), 2));
            formato = formato.replace("ss", completarCeros(String.valueOf(tmp.getSEGUNDO()), 2));
            String aniodosdigitos = String.valueOf(tmp.getANIO());
            aniodosdigitos = aniodosdigitos.substring(2);
            formato = formato.replace("yy", aniodosdigitos);


        } catch (Exception e) {
            e.printStackTrace();
            return "";


        } finally {
            if (ban)
                conexion.cerrarCx();
        }

        System.out.println(formato);

        return formato;
    }

    private static String getMes(int i) {
        switch (i) {
        case (1):
            return "Enero";
        case (2):
            return "Febrero";
        case (3):
            return "Marzo";
        case (4):
            return "Abril";
        case (5):
            return "Mayo";
        case (6):
            return "Junio";
        case (7):
            return "Julio";
        case (8):
            return "Agosto";
        case (9):
            return "Septiembre";
        case (10):
            return "Octubre";
        case (11):
            return "Noviembre";
        case (12):
            return "Diciembre";
        default:
            return "";
        }
    }

    public static String convFormatoFecha(String fecha, String formato) {
        String[] res;
        String anio;
        String mes;
        String dia;
        if (fecha.contains(" "))
            fecha = fecha.substring(0, fecha.indexOf(" ") - 1);
        res = fecha.split("-");
        anio = res[0];
        mes = res[1];
        dia = res[2];
        formato = formato.replace("dd", completarCeros(dia, 2));
        formato = formato.replace("MM", completarCeros(mes, 2));
        formato = formato.replace("yyyy", anio);
        return formato;
    }

    private static String completarCeros(String cad, int cant) {
        int i;
        for (i = cad.length(); i < cant; i++)
            cad = "0" + cad;
        return cad;
    }


    public static String getFechaHoraSistema(String motor) {


        Date fechaActual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        if (motor.equals("FIREBIRD"))
            formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        else if (motor.equals("ORACLE"))
            formato = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        
        System.out.println(fechaActual);
        System.out.println(formato.toString());
        String cadenaFecha = formato.format(fechaActual);
        return cadenaFecha;
    }

    public static String getVigenciaActual() {
        Date fechaActual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy");
        String cadenaFecha = formato.format(fechaActual);
        return cadenaFecha;
    }

    public static String getFechaSistemaTexto() {
        Date fechaActual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("EEEEEEEE dd 'de' MMMMMMMMM 'de' yyyy");
        String cadenaFecha = formato.format(fechaActual);
        return cadenaFecha;
    }

    public static String getFechaSistemaCortaTexto(String motor) {
        String cadenaFecha = "";

        if (motor.equals("FIREBIRD")) {
            Date fechaActual = new Date();
            SimpleDateFormat formato = new SimpleDateFormat("MM/dd/yyyy");
            cadenaFecha = formato.format(fechaActual);
        } else if (motor.equals("ORACLE")) {
            Date fechaActual = new Date();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy");
            cadenaFecha = formato.format(fechaActual);
        }


        return cadenaFecha;
    }

    public static int obtenerId(Connection conn, String genFirebird, String secOracle,
                                String myMotor) throws SQLException {
        int id;
        if (!myMotor.equals("ORACLE"))
            id = getId_FB(conn, genFirebird);
        else
            //id = getId_Oracle(conn, secOracle);
            id = getId_Oracle(conn, genFirebird);
        return id;
    }


    public static int getId_FB(Connection conn, String generador) throws SQLException {

        String sql = "SELECT GEN_ID(" + generador + ",1) FROM TRANSITO";
        PreparedStatement stmt = null;
        ResultSet result = null;
        int allRows = 0;
        try {
            stmt = conn.prepareStatement(sql);
            result = stmt.executeQuery();

            if (result.next())
                allRows = result.getInt(1) + 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (result != null)
                result.close();
            if (stmt != null)
                stmt.close();
        }
        return allRows;
    }

    public static int getId_Oracle(Connection conn, String secuencia) throws SQLException {

        String sql = "SELECT " + secuencia + ".nextval FROM dual";
        //String sql = "SELECT GEN_ID("+generador+",1) FROM TRANSITO";
        PreparedStatement stmt = null;
        ResultSet result = null;
        int allRows = 0;
        try {
            stmt = conn.prepareStatement(sql);
            result = stmt.executeQuery();
            if (result.next())
                allRows = result.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (result != null)
                result.close();
            if (stmt != null)
                stmt.close();
        }
        return allRows;
    }

    public static Time getHoraSistema() {
        Calendar calendario = Calendar.getInstance();
        int hora = calendario.get(Calendar.HOUR_OF_DAY);
        int minutos = calendario.get(Calendar.MINUTE);
        int segundos = calendario.get(Calendar.SECOND);
        return (new Time(hora, minutos, segundos));
    }

    public static String getHoraSistemaString(Connection cx) {
        /*Time tmp;
        Calendar calendario = Calendar.getInstance();
        int hora = calendario.get(Calendar.HOUR_OF_DAY);
        int minutos = calendario.get(Calendar.MINUTE);
        int segundos = calendario.get(Calendar.SECOND);
        tmp = new Time(hora, minutos, segundos);
        return tmp.toString();*/
        String tmp = getFechaSistema2("hh:mm:ss", cx);
        return tmp;
    }

    public static Calendar stringToCalendar(String str_date) {
        try {
            DateFormat formatter;
            Date date;
            formatter = new SimpleDateFormat("HH:mm:ss");
            date = (Date)formatter.parse(str_date);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            return cal;
        } catch (ParseException e) {
            System.out.println("Exception :" + e);
            e.printStackTrace();
        }
        return Calendar.getInstance();
    }

    public static Time calendarToTime(Calendar calendario) {
        int hora = calendario.get(Calendar.HOUR_OF_DAY);
        int minutos = calendario.get(Calendar.MINUTE);
        int segundos = calendario.get(Calendar.SECOND);
        return (new Time(hora, minutos, segundos));
    }

    public boolean menorOIgual(String tmp1, String tmp2) {
        boolean menorOIgual = true;
        int igual = 0;
        if (tmp1.length() < tmp2.length())
            return false;
        if (tmp1.length() > tmp2.length())
            return false;

        int peso = 1;
        int limite = tmp1.length() - 1;
        int valortmp1 = 0, valortmp2 = 0;
        for (int i = limite; i >= 0; i--) {

            valortmp1 += tmp1.charAt(i) * peso;
            valortmp2 += tmp2.charAt(i) * peso;

            peso = peso * 100;
        }

        if (valortmp2 >= valortmp1)
            menorOIgual = true;
        else
            menorOIgual = false;

        return menorOIgual;
    }

    public char[] convertirStringToChar(String palabra) {
        char[] arrayLetras = new char[palabra.length()];
        for (int i = 0; i < palabra.length(); i++)
            arrayLetras[i] = palabra.charAt(i);
        return arrayLetras;
    }

    public String convertirCharToString(char[] tmp) {
        String cadena = "";
        for (int i = 0; i < tmp.length; i++) {
            cadena += tmp[i];
        }
        return cadena;
    }

    public String incrementar(char[] tmp) {
        for (int i = tmp.length - 1; i >= 0; i--) {
            if (tmp[i] != 'Z') {
                tmp[i]++;
                break;
            } else {
                tmp[i] = 'A';
                incrementarAnterior(tmp, i);
                break;
            }
        }
        return convertirCharToString(tmp);
    }

    public char[] incrementarAnterior(char[] tmp, int i) {
        if (i > 0) {
            if (tmp[i - 1] != 'Z') {
                tmp[i - 1]++;
            } else {
                tmp[i - 1] = 'A';
                tmp = incrementarAnterior(tmp, i - 1);
            }
        }
        return tmp;
    }

    public static boolean verificarSqlEntrante(String sql) {
        sql = sql.toUpperCase();
        if (sql.contains("GRANT") || sql.contains("INSERT") || sql.contains("DELETE"))
            return false;
        if (sql.contains("DROP") || sql.contains("UPDATE") || sql.contains("USUARIO") || sql.contains(";") ||
            sql.contains("--"))
            return false;
        return true;
    }

    public static boolean verificarSqlEntranteReporte(String sql) {
        sql = sql.toUpperCase();
        if (sql.contains("GRANT") || sql.contains("INSERT") || sql.contains("DELETE"))
            return false;
        if (sql.contains("DROP") || sql.contains("UPDATE") || sql.contains(";") || sql.contains("--"))
            return false;
        return true;
    }

    public static boolean verificarSqlEntrante2(String sql) {
        sql = sql.toUpperCase();
        if (sql.contains("GRANT") || sql.contains("DELETE"))
            return false;
        if (sql.contains("DROP") || sql.contains("USUARIO") || sql.contains(";") || sql.contains("--"))
            return false;
        return true;
    }

    public String getDiferenciaFechas(String fechastring) {
        String fechacompleta = "";
        int anios = 0, totalmeses = 0, meses = 0;
        Date fechaprueba = convFechaSSQLInv(fechastring);
        String myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
            myMotor = Funciones.leer_ini("C:\\WSTransito.ini", "MOTOR");

        anios = getDateDiffInYears(fechaprueba, convFechaSSQLInv(getFechaSistema(null, myMotor)));
        totalmeses = getDateDiffInMonths(fechaprueba, convFechaSSQLInv(getFechaSistema(null, myMotor)));
        meses = totalmeses - (anios * 12);
        fechacompleta = anios + " A-*-OS " + meses + " MESES ";

        return fechacompleta;
    }

    public static int getDateDiffInYears(Date startDate, Date endDate) {
        return getDateDiffInMonths(startDate, endDate) / 12;
    }

    public static int getDateDiffInMonths(Date startDate, Date endDate) {
        Calendar startCal = Calendar.getInstance();
        Calendar endCal = Calendar.getInstance();
        int startYear = -1, startMonth = -1;
        int endYear = -1, endMonth = -1;
        int months = 0;
        int factor = 1;

        if (startDate.after(endDate)) {
            factor = -1;
            startCal.setTime(endDate);
            endCal.setTime(startDate);
        } else {
            startCal.setTime(startDate);
            endCal.setTime(endDate);
        }

        startYear = startCal.get(Calendar.YEAR);
        startMonth = startCal.get(Calendar.MONTH) + 1;
        endYear = endCal.get(Calendar.YEAR);
        endMonth = endCal.get(Calendar.MONTH) + 1;

        if (startYear == endYear) {
            months = endMonth - startMonth;
        } else {
            months = 12 - startMonth;
            months += endMonth;
            --endYear;
            if (endYear - startYear > 0) {
                months += (endYear - startYear) * 12;
            }
        }
        months *= factor;
        return months;
    }

    public static String leer_ini(String url, String etiqueta) {

        String valor ="";
        try {
            Properties p = new Properties();
            p.load(new FileInputStream(url));
            valor = p.getProperty(etiqueta);
            p.clear();
        } catch (Exception e) {
            //System.out.println(e);
            //e.printStackTrace();
        }
        return valor;
    }

    public static String actualizar_ini(String url, String etiqueta, String nuevoValor) {
        String valor = "";
        valor = "";
        try {
            Properties p = new Properties();

            p.load(new FileInputStream(url));
            p.setProperty(etiqueta, nuevoValor); //(etiqueta,nuevoValor);
            p.save(new FileOutputStream(url), "");
            p.clear();
        } catch (Exception e) {
            System.out.println("error al leer el archivo .ini:" + e.getMessage());
            e.printStackTrace();
            return "";
        }
        return valor;
    }

    public static boolean trabajaConRunt(List par) {

        for (int i = 0; i < par.size(); i++) {
            Item item = (Item)par.get(i);
            if (item.getAtributo().equals("runt")) {
                if (item.getValor().equals("1")) {
                    return true;
                } else if (item.getValor().equals("0"))
                    return false;
            }
        }
        return true;
    }

    public static String obtenerValor(List lista, String atributo) {
        for (int i = 0; i < lista.size(); i++) {
            Item item = (Item)lista.get(i);
            if (item.getAtributo().equals(atributo)) {
                return item.getValor();
            }
        }
        return "";
    }

    public static String formatoFecha(Calendar fecha, String formatoFin) {
        int dia;
        int mes;
        int anno;

        Calendar tmp;
        System.out.println(fecha.toString());
        try {
            SimpleDateFormat ffin = new SimpleDateFormat(formatoFin);
            dia = fecha.DAY_OF_MONTH;
            System.out.println(dia);
            mes = fecha.MONTH;
            System.out.println(mes);
            anno = fecha.YEAR;
            System.out.println(anno);
            tmp = new GregorianCalendar(anno, mes, dia);
            return ffin.format(tmp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List leerListaFromBinario(String nombreArchivo) {
        ArrayList myArreglo = new ArrayList();
        Object tmp;
        try {
            FileInputStream fi = new FileInputStream(nombreArchivo);
            ObjectInputStream is = new ObjectInputStream(fi);
            //while(is.available()>0)
            tmp = is.readObject();
            while (tmp != null) {
                myArreglo.add(tmp);
                try {
                    tmp = is.readObject();
                } catch (Exception ee) {
                    tmp = null;
                }
            }
            //System.out.println("Disponibles "+is.available());
            is.close();
            fi.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return myArreglo;
    }


    public static void escribirListaToArchivoBinario(String nombreArchivo, List tmp) {
        try {
            FileOutputStream fo = new FileOutputStream(nombreArchivo);
            //FileOutputStream fo = new FileOutputStream(nombreArchivo,true);
            ObjectOutputStream os = new ObjectOutputStream(fo);
            for (int i = 0; i < tmp.size(); i++) {
                os.writeObject(tmp.get(i));
            }
            os.close();
            fo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void obecjtToArchivoBinario(String nombreArchivo, Object tmp) {
        try {
            FileOutputStream fo = new FileOutputStream(nombreArchivo);
            //FileOutputStream fo = new FileOutputStream(nombreArchivo,true);
            ObjectOutputStream os = new ObjectOutputStream(fo);
            os.writeObject(tmp);
            os.close();
            fo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object leerObjectFromBinario(String nombreArchivo) {

        Object tmp = new Object();
        try {
            FileInputStream fi = new FileInputStream(nombreArchivo);
            ObjectInputStream is = new ObjectInputStream(fi);
            //while(is.available()>0)
            tmp = is.readObject();
            is.close();
            fi.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tmp;
    }

    /**
     * Convierte la fecha desde el formato yyyy-MM-dd al formato MM/dd/yyyy
     * @param fecha
     * @return
     */
    public static String cambiarFormatoFecha1(String fecha) {
        String[] fechaArray;
        String res="";
       
        if(myMotor.equals("FIREBIRD"))
        {
          fechaArray = fecha.split("-");
          res = fechaArray[1] + "/" + fechaArray[2] + "/" + fechaArray[0];
        }
        else if(myMotor.equals("ORACLE"))
        {
           String fechaclean=fecha.replaceAll("\\d\\d:\\d\\d:\\d\\d", "");
           fechaArray = fechaclean.split("-");
           res = fechaArray[2] + "/" + fechaArray[1] + "/" + fechaArray[0];   
        }
        
        System.out.println("cambiarFormatoFecha1 " + res);
                
        return res;
    }

    /**
     * Convierte la fecha desde el formato yyyy-MM-dd HH:mm:ss al formato MM/dd/yyyy HH:mm:ss
     * @param fecha
     * @return
     */
    public static String cambiarFormatoFechaHora1(String fecha) {
        String[] fechaArray;
        String[] horaArray;
        String res;
        fechaArray = fecha.split("-");
        horaArray = fechaArray[2].split(" ");
        fechaArray[2] = horaArray[0];
        res = fechaArray[1] + "/" + fechaArray[2] + "/" + fechaArray[0] + " " + horaArray[1];
        return res;
    }

    /**
     * Convierte la fecha desde el formato MM/dd/yyyy al formato yyyy-MM-dd
     * @param fecha
     * @return
     */
    public static String cambiarFormatoFecha2(String fecha) {
        String[] fechaArray;
        String res;
        fechaArray = fecha.split("/");
        res = fechaArray[2] + "-" + fechaArray[0] + "-" + fechaArray[1];
        return res;
    }

    /**
     * Convierte la fecha desde el formato MM/dd/yyyy HH:mm:ss al formato yyyy-MM-dd HH:mm:ss
     * @param fecha
     * @return
     */
    public static String cambiarFormatoFechaHora2(String fecha) {
        String[] fechaArray;
        String[] horaArray;
        String res;
        fechaArray = fecha.split("/");
        horaArray = fechaArray[2].split(" ");
        fechaArray[2] = horaArray[0];
        res = fechaArray[2] + "-" + fechaArray[0] + "-" + fechaArray[1] + " " + horaArray[1];
        return res;
    }

    public static Timestamp fechaToTimestamp1(String fecha) {
        try {
            System.out.println(fecha);
            String[] fechaArray;
            String[] horaArray;
            fechaArray = fecha.split("-");
            horaArray = fechaArray[2].split(" ");
            fechaArray[2] = horaArray[0];
            Timestamp ts = null;

            if (horaArray.length > 1) {
                horaArray = horaArray[1].split(":");
                ts =
 new Timestamp(Integer.parseInt(fechaArray[0]) - 1900, Integer.parseInt(fechaArray[1]) - 1, Integer.parseInt(fechaArray[2]),
               Integer.parseInt(horaArray[0]), Integer.parseInt(horaArray[1]), 0, 0);
            } else {
                ts =
 new Timestamp(Integer.parseInt(fechaArray[0]) - 1900, Integer.parseInt(fechaArray[1]) - 1, Integer.parseInt(fechaArray[2]),
               0, 0, 0, 0);
            }
            return ts;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Timestamp fechaToTimestamp2(String fecha) {
        try {
            String[] fechaArray;
            String[] horaArray;
            fechaArray = fecha.split("/");
            horaArray = fechaArray[2].split(" ");
            fechaArray[2] = horaArray[0];
            Timestamp ts = null;

            if (horaArray.length > 1) {
                horaArray = horaArray[1].split(":");
                ts =
 new Timestamp(Integer.parseInt(fechaArray[2]) - 1900, Integer.parseInt(fechaArray[0]) - 1, Integer.parseInt(fechaArray[1]),
               Integer.parseInt(horaArray[0]), Integer.parseInt(horaArray[1]), 0, 0);
            } else {
                ts =
 new Timestamp(Integer.parseInt(fechaArray[2]) - 1900, Integer.parseInt(fechaArray[0]) - 1, Integer.parseInt(fechaArray[1]),
               0, 0, 0, 0);
            }
            return ts;
        } catch (Exception e) {
            return null;
        }
    }

    public static Timestamp fechaToTimestamp3(String fecha) {
        try {
            String[] fechaArray;
            String[] horaArray;
            fechaArray = fecha.split("/");
            horaArray = fechaArray[2].split(" ");
            fechaArray[2] = horaArray[0];
            Timestamp ts = null;

            if (horaArray.length > 1) {
                horaArray = horaArray[1].split(":");
                ts =
 new Timestamp(Integer.parseInt(fechaArray[2]) - 1900, Integer.parseInt(fechaArray[1]) - 1, Integer.parseInt(fechaArray[0]),
               Integer.parseInt(horaArray[0]), Integer.parseInt(horaArray[1]), 0, 0);
            } else {
                ts =
 new Timestamp(Integer.parseInt(fechaArray[2]) - 1900, Integer.parseInt(fechaArray[1]) - 1, Integer.parseInt(fechaArray[0]),
               0, 0, 0, 0);
            }
            return ts;
        } catch (Exception e) {
            return null;
        }
    }

    public static String[] getIpServidor() {
        String[] host = new String[2];
        try {
            InetAddress addr = InetAddress.getLocalHost();
            // host name
            host[0] = addr.getHostName();
            host[1] = addr.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return host;
    }
    
    public static java.sql.Timestamp convertirStringTimestamp(String cadenafecha, String formato) {
            try {
                SimpleDateFormat format = new SimpleDateFormat(formato);
                Date fecha = null;
                fecha = format.parse(cadenafecha);
                java.sql.Timestamp result = new java.sql.Timestamp(fecha.getTime());
                return result;
            } catch (Exception exp) {
                exp.printStackTrace();
                return null;
            }


        }
    
    public boolean escribirArchivo(byte[] fileBytes, String archivoDestino){ 
       boolean correcto = false; 
       try { 
         OutputStream out = new FileOutputStream(archivoDestino); 
         out.write(fileBytes); 
         out.close();         
         correcto = true; 
       } catch (Exception e) { 
         System.out.println(e.getStackTrace()); 
       }         
         return correcto;

    }
    
    public String convertirCalendarString(Calendar cal,String formato)
    {
        String result="";
        
        if(!formato.equals(null) && !formato.equals(""))
        {
        SimpleDateFormat formater= new SimpleDateFormat(formato);
        result = formater.format(cal.getTime());
        }
        return result;
    }


   
}
