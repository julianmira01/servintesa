package utilidades;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;
import java.util.Date;

public class SerializarObjetos <T> {
    
    String carpeta;
    
    public SerializarObjetos() {
        super();
        carpeta = "FaltantesRunt";
    }
    
    public void saveObjeto(T obj) throws FileNotFoundException, IOException {
            Date fecha = new Date();
            String file = fecha.toString();
            String tmpClase = obj.getClass().getName(); 
            String clase = tmpClase;
            
            tmpClase = tmpClase.replace(".", "_");
            System.out.println("CCCCCCCCCCCCCCCCCCCCLLLLLLLLLLLLLLLLLLLLLLLLAAAAAAAAAAAAAAAAAAAAAAASSSSSSSSSSSSSSSSSSSSSEEEEEEEEEEEEEEEEE = " + tmpClase);
            String[] lstClases = tmpClase.split("_");
            
            if (lstClases != null && lstClases.length > 0)
            {
                clase = lstClases[lstClases.length - 1];    
                System.out.println("CCCCCCCCCCCCCCCCCCCCLLLLLLLLLLLLLLLLLLLLLLLLAAAAAAAAAAAAAAAAAAAAAAASSSSSSSSSSSSSSSSSSSSSEEEEEEEEEEEEEEEEE2222222222222222222222222222222222222222222222 = " + clase);
            }
            
            file = file.replace(":", "-");
            file = clase + "_" + file; 
            FileOutputStream fos = new FileOutputStream(carpeta + "\\" + file + ".runt");
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(obj);
            out.close();
            fos.close();
            //ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
            //ObjectOutputStream out = new ObjectOutputStream(byteArray);
            //out.writeObject(obj);
            //byte[] u = byteArray.toByteArray();
        }
    
    public T obtenerObjeto(String archivo) throws FileNotFoundException, IOException, ClassNotFoundException {
            FileInputStream fis = new FileInputStream(carpeta + archivo);
            ObjectInputStream in = new ObjectInputStream(fis);
            T obj = (T)in.readObject();
            in.close();
            fis.close();
            return obj;
        }
    
    public String[] getArchivos(String clase) {
            ArrayList listaObjetos = new ArrayList();
            File directorio = new File(carpeta);
            String[] listaDirectorio = directorio.list();
            String archivo;
            if (listaDirectorio != null && listaDirectorio.length > 0) 
            {
                if (clase != null && clase.length() > 0) {
                    ArrayList lista = new ArrayList();
                    for (int i = 0; i< listaDirectorio.length; i++) {
                        if (getClase(listaDirectorio[i]).equals(clase))
                            lista.add(listaDirectorio[i]);
                    }
                    if (lista.isEmpty())
                        return null;
                    else
                        return (String[])lista.toArray();
                }
                else
                    return listaDirectorio;
            }
            return null;
                //for (int i = 0; i < listaDirectorio.length; i++)
                 //   archivo = listaDirectorio[0];
                  //  Vehiculo tmpVehi = srz.obtenerObjeto(archivo);
        }
    
    
    public void deleteArchivo(String archivo) {
            File f = new File(carpeta + "\\" + archivo);
            f.delete(); 
        }
    
    public String getClase(String archivo) {
            String[] campos = archivo.split("_");
            return campos[0];
        }
}
