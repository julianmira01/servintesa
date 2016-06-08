package utilidades;

import com.sun.istack.ByteArrayDataSource;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.activation.DataHandler;
import javax.activation.DataSource;

import org.apache.axis2.databinding.types.HexBinary;

import servicios.generales.ServiciosConfiguraciones;


public class Archivo {

    String ip;
    String tipoDedo;
    String stream;
    String rutaAbsoluta;
    File file;
    byte[] arreglo;
    HexBinary dato;

    public HexBinary getDato() {
        return dato;
    }

    public void setDato(HexBinary dato) {
        this.dato = dato;
    }

    public String parseInputArrayByte(InputStream itStrm) {
        String str = itStrm.toString();
        byte[] b3 = str.getBytes();
        return Base64.encode(b3);
    }

    public static void main(String[] args) {
        Archivo a = new Archivo();
        System.out.println(a.parseInputStreamToBase64(null));
    }

    public String parseInputStreamToBase64(InputStream itStrm) {
        /*
	  try {
		  itStrm = new FileInputStream("D:\\desarrollo\\webService\\Soporte Runt\\liquidacion.pdf");
	  } catch (FileNotFoundException e) {
		  e.printStackTrace();
	  }*/
        byte[] b3 = null;
        try {
            b3 = new byte[itStrm.available()];
            itStrm.read(b3);
        } catch (IOException e) {
            e.printStackTrace();
        }
        parseBase64ToFile(Base64.encode(b3), "");
        return Base64.encode(b3);
    }


    public String crearPdf(InputStream itStrm, String carpeta) {
        byte[] b3 = null;
        try {
            b3 = new byte[itStrm.available()];
            itStrm.read(b3);
        } catch (IOException e) {
            e.printStackTrace();
        }
        parseBase64ToFile(Base64.encode(b3), carpeta);
        return Base64.encode(b3);
    }

    public String crearPdf(HexBinary itStrm, String carpeta) {
        byte[] b3 = null;
        b3 = itStrm.getBytes();
        parseBase64ToFile(Base64.encode(b3), carpeta);
        return Base64.encode(b3);
    }

    public DataHandler getDataHandler() {
        InputStream itStrm = null;
        try {
            itStrm = new FileInputStream("D:\\desarrollo\\webService\\Soporte Runt\\liquidacion.pdf");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] b3 = null;
        try {
            b3 = new byte[itStrm.available()];
            itStrm.read(b3);
        } catch (IOException e) {
            e.printStackTrace();
        }
        DataSource dataSource = new ByteArrayDataSource(b3, "application/pdf");
        DataHandler dataHandler = new DataHandler(dataSource);
        return dataHandler;
    }

    public void parseBase64ToFile(String base, String carpeta) {
        FileOutputStream fos;
        System.out.println("iamgen " + base);
        byte[] arreglo = Base64.decode(base);
        try {
            //fos = new FileOutputStream("D:\\desarrollo\\webService\\Soporte Runt\\liquidacionJava.pdf");
            ServiciosConfiguraciones serviciosConfiguraciones = new ServiciosConfiguraciones();
            fos = new FileOutputStream(serviciosConfiguraciones.directorioPersonas() + "\\" + carpeta);
            //fos = new FileOutputStream("D:\\TRANSITO\\transitoRunt\\Model\\classes\\documentosGenerados\\" + carpeta);
            fos.write(arreglo);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void crearImagenFromByteArray(byte[] arreglo, String carpeta) {
        FileOutputStream fos;

        try {
            //fos = new FileOutputStream("D:\\desarrollo\\webService\\Soporte Runt\\liquidacionJava.pdf");
            ServiciosConfiguraciones serviciosConfiguraciones = new ServiciosConfiguraciones();
            fos = new FileOutputStream(serviciosConfiguraciones.directorioPersonas() + "\\" + carpeta);
            //fos = new FileOutputStream("D:\\TRANSITO\\transitoRunt\\Model\\classes\\documentosGenerados\\" + carpeta);
            fos.write(arreglo);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private byte[] obtenerByteArchivo() {
        byte[] bytes = null;
        InputStream in = null;
        try {
            in = new FileInputStream(file);
            bytes = new byte[(int)file.length()];
            in.read(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bytes;
    }

    private void stringByte64() {
        arreglo = Base64.decode(stream);
        stringHexBynary();
    }

    private void stringHexBynary() {
        try {
            //			dato = new HexBinary(stream);
            //stringByte64();
            dato = new HexBinary(arreglo);
        } catch (Exception e) {
        }
    }

    private String HexBinaryBase64(HexBinary data) {
        return Base64.encode(data.getBytes());
    }

    public Archivo() {
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getRutaAbsoluta() {
        return rutaAbsoluta;
    }

    public void setRutaAbsoluta(String rutaAbsoluta) {
        this.rutaAbsoluta = rutaAbsoluta;
        setFile(new File(rutaAbsoluta));
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
        setArreglo(obtenerByteArchivo());
    }

    public byte[] getArreglo() {
        return arreglo;
    }

    public void setArreglo(byte[] arreglo) {
        this.arreglo = arreglo;
    }

    public String getTipoDedo() {
        return tipoDedo;
    }

    public void setTipoDedo(String tipoDedo) {
        this.tipoDedo = tipoDedo;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
        stringByte64();
    }

}

