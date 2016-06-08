package modelo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.sql.DataSource;
import seguridad.Crypto;
import utilidades.Funciones;


public class Conexion {

    public Connection conn = null;
    private String myMotor= "";
    private String server = "";
    private String rutaWSini = "/WSTransito.ini";
    Funciones myFnc;
    
    public Conexion ()
    {
        myFnc = new Funciones();
        try
        {
            server = Funciones.leer_ini("/WSTransito.ini", "SERVER");            
        }catch(Exception exce)
        {
            
        }
        
        if(server == null || server.equals(""))
        {
            try
            {
                server = Funciones.leer_ini("C:\\WSTransito.ini", "SERVER");            
            }catch(Exception exce)
            {

            }
        }
        
        
        try
        {
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");            
        }catch(Exception exce)
        {
            
        }
        
        if(myMotor == null || myMotor.equals(""))
        try
        {
            myMotor = Funciones.leer_ini("C:\\WSTransito.ini", "MOTOR");            
        }catch(Exception exce)
        {
            
        }
        
//        if(myMotor.equals(""))
            //myMotor = "ORACLE";
        
//        if(server.equals(""))
            //server = "WINDOWS";
        
        myMotor = myMotor.toUpperCase();
        server = server.toUpperCase();
        
        System.out.println("SERVIDOR="+server);
        System.out.println("MOTOR="+myMotor);
        
    }
        
    public Connection conectar() {
        try {
            DataSource ds = null;

            int i = 0;
            do {
                conn = conectarDb(ds,myMotor);
                if (i > 0) {
                    System.out.println("Error conectando a la base de datos: intentos cumplidos -> " + i);
                    try {
                        this.wait(1000);
                    } catch (Exception exp) {
                    }
                }
                i += 1;
            } while (conn == null && i < 5);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error conectando");
        }
        return conn;
    }

    public Connection conectarComparendos() {        
        
        try {
            DataSource ds=null;
            
            conn = conectarDbComp(ds,myMotor);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    
    public void commit() {
        try {
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public boolean cerrarCx() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Connection obtenerConnection() {
        return conn;
    }

    private Connection conectarDb(DataSource dataSource, String MOTOR) {
        Connection connection = null;
        
        for (int i = 0; i < 4; i++) {
            try {
                    try
                    {
                        if(myMotor.equals("FIREBIRD"))
                        {
                            Class.forName("org.firebirdsql.jdbc.FBDriver");
                            if(server.equals("LINUX"))
                                connection = DriverManager.getConnection("jdbc:firebirdsql:" + Crypto.descifrar("S3rV1n7e5A1205!", "/siot/abd/cabdsTP.bin", "/siot/abd/cabdsTP.tmp"),"SYSDBA", Crypto.descifrar("S3rV1n7e5A1205!", "/siot/abd/cabdsc.bin", "/siot/abd/cabdsc.tmp"));
                            else
                                connection = DriverManager.getConnection("jdbc:firebirdsql:" + Crypto.descifrar("S3rV1n7e5A1205!", "d:\\cabdsTP.bin", "d:\\cabdsTP.tmp"),"SYSDBA", Crypto.descifrar("S3rV1n7e5A1205!", "d:\\cabdsc.bin", "d:\\cabdsc.tmp"));
                        }
                        else
                        {
                            Class.forName("oracle.jdbc.driver.OracleDriver");
                            if(server.equals("LINUX"))
                                connection = DriverManager.getConnection("jdbc:oracle:thin:"+Crypto.descifrar("S3rV1n7e5A1205!", "/siot/abd/cabdsTP.bin", "/siot/abd/cabdsTP.tmp"),"DBUNSIOT",Crypto.descifrar("S3rV1n7e5A1205!", "/siot/abd/cabdsc.bin", "/siot/abd/cabdsc.tmp"));
                                //connection = DriverManager.getConnection("jdbc:oracle:thin:"+Crypto.descifrar("S3rV1n7e5A1205!", "/siot/abd/cabdsTP.bin", "/siot/abd/cabdsTP.tmp"),"BDSIOT",Crypto.descifrar("S3rV1n7e5A1205!", "/siot/abd/cabdsc.bin", "/siot/abd/cabdsc.tmp"));
                            else
                                connection = DriverManager.getConnection("jdbc:oracle:thin:"+Crypto.descifrar("S3rV1n7e5A1205!", "d:\\cabdsTP.bin", "d:\\cabdsTP.tmp"),"DBUNSIOT",Crypto.descifrar("S3rV1n7e5A1205!", "d:\\cabdsc.bin", "d:\\cabdsc.tmp"));
                                //connection = DriverManager.getConnection("jdbc:oracle:thin:"+Crypto.descifrar("S3rV1n7e5A1205!", "d:\\cabdsTP.bin", "d:\\cabdsTP.tmp"),"BDSIOT",Crypto.descifrar("S3rV1n7e5A1205!", "d:\\cabdsc.bin", "d:\\cabdsc.tmp"));
                        }
                    }    
                    catch (ClassNotFoundException e) {
                        System.out.println("ERROR CONEXION BASE DE DATOS " + e.getMessage());
                        e.printStackTrace();
                    }
                    return connection;
            } catch (SQLException e) {
                System.out.println("ERROR CONEXION BASE DE DATOS " + e.getMessage());
                e.printStackTrace();
            }
        }
        return null;
    }

    private Connection conectarDbComp(DataSource dataSource, String MOTOR) {
        Connection connection = null;
        for (int i = 0; i < 4; i++) {
            try {
                    try 
                    {
                        if(myMotor.equals("FIREBIRD"))
                        {
                            Class.forName("org.firebirdsql.jdbc.FBDriver");
                            if(server.equals("LINUX"))
                                connection = DriverManager.getConnection("jdbc:firebirdsql:" + Crypto.descifrar("S3rV1n7e5A1205!", "/siot/abd/cabdsCO.bin", "/siot/abd/cabdsCO.tmp"),"SYSDBA", Crypto.descifrar("S3rV1n7e5A1205!", "/siot/abd/cabdsc.bin", "/siot/abd/cabdsc.tmp"));
                            else
                                connection = DriverManager.getConnection("jdbc:firebirdsql:" + Crypto.descifrar("S3rV1n7e5A1205!", "d:\\cabdsCO.bin", "d:\\cabdsCO.tmp"),"SYSDBA", Crypto.descifrar("S3rV1n7e5A1205!", "d:\\cabdsc.bin", "d:\\cabdsc.tmp"));
                        }
                        else
                        {
                            Class.forName("oracle.jdbc.driver.OracleDriver");
                            if(server.equals("LINUX"))
                                connection = DriverManager.getConnection("jdbc:oracle:thin:"+Crypto.descifrar("S3rV1n7e5A1205!", "/siot/abd/cabdsCO.bin", "/siot/abd/cabdsCO.tmp"),"DBUNSIOT",Crypto.descifrar("S3rV1n7e5A1205!", "/siot/abd/cabdsc.bin", "/siot/abd/cabdsc.tmp"));
                                //connection = DriverManager.getConnection("jdbc:oracle:thin:"+Crypto.descifrar("S3rV1n7e5A1205!", "/siot/abd/cabdsCO.bin", "/siot/abd/cabdsCO.tmp"),"BDSIOT",Crypto.descifrar("S3rV1n7e5A1205!", "/siot/abd/cabdsc.bin", "/siot/abd/cabdsc.tmp"));
                            else
                                connection = DriverManager.getConnection("jdbc:oracle:thin:"+Crypto.descifrar("S3rV1n7e5A1205!", "d:\\cabdsCO.bin", "d:\\cabdsCO.tmp"),"DBUNSIOT",Crypto.descifrar("S3rV1n7e5A1205!", "d:\\cabdsc.bin", "d:\\cabdsc.tmp"));
                                //connection = DriverManager.getConnection("jdbc:oracle:thin:"+Crypto.descifrar("S3rV1n7e5A1205!", "d:\\cabdsCO.bin", "d:\\cabdsCO.tmp"),"BDSIOT",Crypto.descifrar("S3rV1n7e5A1205!", "d:\\cabdsc.bin", "d:\\cabdsc.tmp"));
                        }
                    }
                    catch (ClassNotFoundException e) {
                        System.out.println(" ERROR CONEXION BASE DE DATOS COMPARENDOS " + e.getMessage());
                        e.printStackTrace();
                    }
                return connection;
            } catch (SQLException e) {
                System.out.println(" ERROR CONEXION BASE DE DATOS COMPARENDOS " + e.getMessage());
                e.printStackTrace();
            }
        }
        return null;
    }

}


