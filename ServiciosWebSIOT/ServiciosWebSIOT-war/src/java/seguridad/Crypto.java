package seguridad;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import java.io.OutputStream;

import java.sql.Connection;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;

import javax.crypto.spec.DESKeySpec;

import modelo.conexion.Conexion;

import utilidades.Funciones;

public class Crypto {
    public Crypto() {
        super();
    }
    
    public static void main(String[] args)
    {
        //-------//
        //QUIMBAYA PRUEBAS DANIEL
        cifrar("S3rV1n7e5A1205!","127.0.0.1:D:\\\\BASES\\\\PRODUCCION\\\\QUIMBAYA\\\\BASESINTRATOK.GDB","d:\\cabdsTP.bin");
        cifrar("S3rV1n7e5A1205!","127.0.0.1:D:\\\\BASES\\\\PRODUCCION\\\\QUIMBAYA\\\\BASECOMPARENDO.GDB","d:\\cabdsCO.bin");
        cifrar("S3rV1n7e5A1205!","SYSDBA","d:\\cabdsl.bin");
        cifrar("S3rV1n7e5A1205!","masterkey","d:\\cabdsc.bin");
        
        //-------//
        //CIRCACIA PRUEBAS
        //cifrar("S3rV1n7e5A1205!","127.0.0.1/3050:E:\\\\BASES PRUEBAS\\\\CIRCASIA\\\\\\BASESINTRATOK.GDB","d:\\cabdsTP.bin");
        //cifrar("S3rV1n7e5A1205!","127.0.0.1/3050:E:\\\\BASES PRUEBAS\\\\CIRCASIA\\\\\\BASECOMPARENDO.GDB","d:\\cabdsCO.bin");
     
        
        //-------//
        //FIREBIRD QUIMBAYA PRUEBAS MV LINUX 210
        //cifrar("S3rV1n7e5A1205!","192.168.0.202:D:\\\\BASES\\\\PRODUCCION\\\\QUIMBAYA\\\\BASESINTRATOK.GDB","d:\\cabdsTP.bin");
        //cifrar("S3rV1n7e5A1205!","192.168.0.202:D:\\\\BASES\\\\PRODUCCION\\\\QUIMBAYA\\\\BASECOMPARENDO.GDB","d:\\cabdsCO.bin");
        //cifrar("S3rV1n7e5A1205!","SYSDBA","d:\\cabdsl.bin");
        //cifrar("S3rV1n7e5A1205!","masterkey","d:\\cabdsc.bin");
        
        //CAUCASIA ORACLE PRODUCCON OK
        /*cifrar("S3rV1n7e5A1205!","@192.168.1.75:1521/xe","d:\\cabdsTP.bin");
        cifrar("S3rV1n7e5A1205!","@192.168.1.75:1521/xe","d:\\cabdsCO.bin");
        cifrar("S3rV1n7e5A1205!","192.168.1.75","d:\\cabdsl.bin");
        cifrar("S3rV1n7e5A1205!","Servinte2016*","d:\\cabdsc.bin");*/
        
       
        
        
         //-------//
        //FIREBIRD QUIMBAYA PRUEBAS REMOTO
        //cifrar("S3rV1n7e5A1205!","sw-siot.com/3050:D:\\\\BASES\\\\PRODUCCION\\\\QUIMBAYA\\\\\\BASESINTRATOK.GDB","d:\\cabdsTP.bin");
        //cifrar("S3rV1n7e5A1205!","sw-siot.com/3050:/siot/bd/BASECOMPARENDO.GDB","d:\\cabdsCO.bin");
        
        /*cifrar("S3rV1n7e5A1205!","127.0.0.1/3050:D:\\\\BASES\\\\PRODUCCION\\\\QUIMBAYA\\\\\\BASESINTRATOK.GDB","d:\\cabdsTP.bin");
        cifrar("S3rV1n7e5A1205!","127.0.0.1/3050:D:\\\\BASES\\\\PRODUCCION\\\\QUIMBAYA\\\\\\BASESINTRATOK.GDB","d:\\cabdsCO.bin");*/
        
        
        
        //-------//
        //FLORIDA
        //cifrar("S3rV1n7e5A1205!","127.0.0.1/3050:F:\\\\BASESSIOT\\\\\\BASESINTRATOK.GDB","d:\\cabdsTP.bin");
        //cifrar("S3rV1n7e5A1205!","127.0.0.1/3050:F:\\\\BASESSIOT\\\\\\BASECOMPARENDO.GDB","d:\\cabdsCO.bin");
        
        //-------//
        //SERVINTESA
        //cifrar("S3rV1n7e5A1205!","192.168.88.230/3050:F:\\\\BASESSIOT\\\\\\BASESINTRATOK.GDB","d:\\cabdsTP.bin");
        //cifrar("S3rV1n7e5A1205!","192.168.88.230/3050:F:\\\\BASESSIOT\\\\\\BASECOMPARENDO.GDB","d:\\cabdsCO.bin");
        
        //cifrar("S3rV1n7e5A1205!","SYSDBA","d:\\cabdsl.bin");
        //cifrar("S3rV1n7e5A1205!","Servintesa*_2014","d:\\cabdsc.bin");
        //Pass Florida
        
        //-------//
        
        //-------//
        //SERVINTESA PRUEBAS DANIEL LOCAL ORACLE 
        /*cifrar("S3rV1n7e5A1205!","@127.0.0.1:1521/xe","d:\\cabdsTP.bin");
        cifrar("S3rV1n7e5A1205!","@127.0.0.1:1521/xe","d:\\cabdsCO.bin");
        cifrar("S3rV1n7e5A1205!","usrSIOT","d:\\cabdsl.bin");
        cifrar("S3rV1n7e5A1205!","Cll4816s24*","d:\\cabdsc.bin");*/
        
        //BD ORACLE CAUCASIA
        /*cifrar("S3rV1n7e5A1205!","@192.168.1.75:1521/xe","d:\\cabdsTP.bin");
        cifrar("S3rV1n7e5A1205!","@192.168.1.75:1521/xe","d:\\cabdsCO.bin");
        cifrar("S3rV1n7e5A1205!","DBUNSIOT","d:\\cabdsl.bin");
        cifrar("S3rV1n7e5A1205!","Servinte2016*","d:\\cabdsc.bin");*/
        
        
         //DESARROLLO DANIEL ORACLE OK
/*        cifrar("S3rV1n7e5A1205!","@127.0.0.1:1521/xe","d:\\cabdsTP.bin");
        cifrar("S3rV1n7e5A1205!","@127.0.0.1:1521/xe","d:\\cabdsCO.bin");
        cifrar("S3rV1n7e5A1205!","USRSIOT","d:\\cabdsl.bin");
        cifrar("S3rV1n7e5A1205!","Servinte2016*","d:\\cabdsc.bin");*/
        
        System.out.println(descifrar("S3rV1n7e5A1205!","D:\\cabdsTP.bin","d:\\cabdsTP.tmp"));
        System.out.println(descifrar("S3rV1n7e5A1205!","D:\\cabdsCO.bin","d:\\cabdsCO.tmp"));
        System.out.println(descifrar("S3rV1n7e5A1205!","D:\\cabdsl.bin","d:\\cabdsl.tmp"));
        System.out.println(descifrar("S3rV1n7e5A1205!","D:\\cabdsc.bin","d:\\cabdsc.tmp"));
        
        Conexion con = new Conexion();
        con.conectar();
        con.conectarComparendos();
        con.cerrarCx();
    }
    
    public static String cifrar(String password, String variableEncriptar, String rutaSalida)
    {
        String variableCifada = "";
        String rutaTemporal = "D:\\cabds.tmp";
        Funciones.escribirArchivo(rutaTemporal,variableEncriptar);
        try{
            SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
            DESKeySpec kspec = new DESKeySpec(password.getBytes());
            SecretKey ks = skf.generateSecret(kspec);
    
            /* PASO 2: Crear cifrador */
            Cipher cifrador = Cipher.getInstance("DES/ECB/PKCS5Padding");
            // Algoritmo DES
            // Modo : ECB (Electronic Code Book)
            // Relleno : PKCS5Padding
            //
            
            /* PASO 3a: Inicializar cifrador en modo CIFRADO */
            cifrador.init(Cipher.ENCRYPT_MODE, ks);
                
            /* Leer fichero de 1k en 1k y pasar fragmentos leidos al cifrador */
            byte[] buffer = new byte[1000];
            byte[] bufferCifrado;

            FileInputStream in = new FileInputStream(rutaTemporal);
            FileOutputStream out = new FileOutputStream(rutaSalida);
            
            int bytesLeidos = in.read(buffer, 0, 1000);
            while (bytesLeidos != -1) { // Mientras no se llegue al final del fichero
                    bufferCifrado = cifrador.update(buffer, 0, bytesLeidos); // Pasa texto claro leido al cifrador
                    out.write(bufferCifrado); // Escribir texto cifrado
                    bytesLeidos = in.read(buffer, 0, 1000);
            }
            bufferCifrado = cifrador.doFinal(); // Completar cifrado (puede devolver texto)
            out.write(bufferCifrado); 
            
            in.close();
            out.close();
            
            File file = new File(rutaTemporal);
            file.delete();
            
            variableCifada = Funciones.leerArchivo(rutaSalida);
            
            //File file2 = new File(rutaSalida);
            //file2.delete();
        }catch(Exception exce){}
        return variableCifada.replace("?", "");
    }
        
    public static String descifrar(String password, String rutaSalida,  String rutaTemporal)
    {
        String variableDescifada = "";

        //Funciones.escribirArchivo(rutaTemporal,variableDesencriptar);
            try{
                SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
                DESKeySpec kspec = new DESKeySpec(password.getBytes());
                SecretKey ks = skf.generateSecret(kspec);
            
                /* PASO 2: Crear cifrador */
                Cipher cifrador = Cipher.getInstance("DES/ECB/PKCS5Padding");
                // Algoritmo DES
                // Modo : ECB (Electronic Code Book)
                // Relleno : PKCS5Padding
                //
            
            cifrador.init(Cipher.DECRYPT_MODE, ks);

            FileInputStream in = new FileInputStream(rutaSalida);
            FileOutputStream out = new FileOutputStream(rutaTemporal);
            byte[] buffer = new byte[1000];
            byte[] bufferPlano;
            
            int bytesLeidos = in.read(buffer, 0, 1000);
            while (bytesLeidos != -1) { // Mientras no se llegue al final del fichero
                    bufferPlano = cifrador.update(buffer, 0, bytesLeidos); // Pasa texto claro leido al cifrador
                    out.write(bufferPlano);
                    bytesLeidos = in.read(buffer, 0, 1000);
            }
            bufferPlano = cifrador.doFinal(); // Completar descifrado (puede devolver texto)
            out.write(bufferPlano);
            
            in.close();
            out.close();
            
            variableDescifada = Funciones.leerArchivo(rutaTemporal);
                
            File file = new File(rutaTemporal);
            file.delete();
            
            
            
            //File file2 = new File(rutaSalida);
            //file2.delete();
        }catch(Exception exce){
            exce.printStackTrace();
        }

        return variableDescifada;
    }
}
