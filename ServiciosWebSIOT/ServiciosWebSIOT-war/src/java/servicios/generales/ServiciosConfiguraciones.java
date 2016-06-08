
package servicios.generales;

import java.sql.Connection;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import modelo.conexion.Conexion;

import utilidades.Funciones;
import seguridad.Crypto;

@WebService
public class ServiciosConfiguraciones {
    public ServiciosConfiguraciones() {
        super();
    }
    
    public boolean verificarConfigBD() {
        try{
        Conexion conn = new Conexion();
        Connection conectar = conn.conectar();
        if(conectar.isClosed())
            return false;
        else
        {
            conn.cerrarCx();
            return true;
        }
        }catch(Exception exce){return false;}
    }
    
    public boolean UsaRunt() {
        String usaRunt ="";
        try{
            usaRunt = Funciones.leer_ini("/WSTransito.ini", "RUNT");
        }catch(Exception exce){}
        if(usaRunt.equals(""))
        try{
            usaRunt = Funciones.leer_ini("c:\\WSTransito.ini", "RUNT");
        }catch(Exception exce){}
        
        if (usaRunt.equals("SI"))
            return true;
        else return false;
    }
    
    public String directorioFacturasPlantillas() {
        String directorio ="";
        try{
            directorio = Funciones.leer_ini("/WSTransito.ini", "FACTURAS_PLANTILLAS");
            if(directorio.equals("") || directorio.equals("/"))
                directorio+="/";
        }catch(Exception exce){}
        
        if(directorio.equals("") || directorio.equals("/"))
        {
            try{
                directorio = Funciones.leer_ini("c:\\WSTransito.ini", "FACTURAS_PLANTILLAS");
                if(directorio.equals("") || directorio.equals("/"))
                    directorio+="\\";
            }catch(Exception exce){}
        }
             
        return directorio;
    }
    
    public String directorioFacturasTransito() {
        String directorio ="";
        try{
            directorio = Funciones.leer_ini("/WSTransito.ini", "FACTURAS_TRANSITO");
            if(directorio.equals("") || directorio.equals("/"))
                directorio+="/";
        }catch(Exception exce){}
        if(directorio.equals("") || directorio.equals("/"))
        try{
            directorio = Funciones.leer_ini("c:\\WSTransito.ini", "FACTURAS_TRANSITO");
            if(directorio.equals("") || directorio.equals("/"))
                directorio+="\\";
        }catch(Exception exce){}
            
        return directorio;
    }
    
    public String directorioFacturasRunt() {
        String directorio ="";
        try{
            directorio = Funciones.leer_ini("/WSTransito.ini", "FACTURAS_RUNT");
            if(directorio.equals("") || directorio.equals("/"))
                directorio+="/";
        }catch(Exception exce){}
        System.out.println("dri.1:"+directorio);
        if(directorio.equals("") || directorio.equals("/"))
        try{
            directorio = Funciones.leer_ini("c:\\WSTransito.ini", "FACTURAS_RUNT");
            if(directorio.equals("") || directorio.equals("/"))
                directorio+="\\";
        }catch(Exception exce){}
            System.out.println("dri.2:"+directorio);
        return directorio;
    }
    
    public String directorioFacturasComparendo() {
        String directorio ="";
        try{
            directorio = Funciones.leer_ini("/WSTransito.ini", "FACTURAS_COMPARENDOS");
            if(directorio.equals("") || directorio.equals("/"))
                directorio+="/";
        }catch(Exception exce){}
        if(directorio.equals("") || directorio.equals("/"))
        try{
            directorio = Funciones.leer_ini("c:\\WSTransito.ini", "FACTURAS_COMPARENDOS");
            if(directorio.equals("") || directorio.equals("/"))
                directorio+="\\";
        }catch(Exception exce){}
            
        return directorio;
    }
    
    public String directorioReportesArqueo() {
        String directorio ="";
        try{
            directorio = Funciones.leer_ini("/WSTransito.ini", "REPORTES_ARQUEO");
            if(directorio.equals("") || directorio.equals("/"))
                directorio+="/";
        }catch(Exception exce){}
        if(directorio.equals("") || directorio.equals("/"))
        try{
            directorio = Funciones.leer_ini("c:\\WSTransito.ini", "REPORTES_ARQUEO");
            if(directorio.equals("") || directorio.equals("/"))
                directorio+="\\";
        }catch(Exception exce){}
            
        return directorio;
    }
    
    public String directorioResoluciones() {
        String directorio ="";
        try{
            directorio = Funciones.leer_ini("/WSTransito.ini", "RESOLUCIONES");
            if(directorio.equals("") || directorio.equals("/"))
                directorio+="/";
        }catch(Exception exce){}
        if(directorio.equals("") || directorio.equals("/"))
        try{
            directorio = Funciones.leer_ini("c:\\WSTransito.ini", "RESOLUCIONES");
            if(directorio.equals("") || directorio.equals("/"))
                directorio+="\\";
        }catch(Exception exce){}
            
        return directorio;
    }
    
    public String directorioPersonas() {
        String directorio ="";
        try{
            directorio = Funciones.leer_ini("/WSTransito.ini", "DIRECTORIO_PERSONAS");
            if(directorio.equals("") || directorio.equals("/"))
                directorio+="/";
        }catch(Exception exce){}
        if(directorio.equals("") || directorio.equals("/"))
        try{
            directorio = Funciones.leer_ini("c:\\WSTransito.ini", "DIRECTORIO_PERSONAS");
            if(directorio.equals("") || directorio.equals("/"))
                directorio+="\\";
        }catch(Exception exce){}
            
        return directorio;
    }
    
    public String directorioPersonasFirma() {
        String directorio ="";
        try{
            directorio = Funciones.leer_ini("/WSTransito.ini", "DIRECTORIO_PERSONAS_FIRMA");
            if(directorio.equals("") || directorio.equals("/"))
                directorio+="/";
        }catch(Exception exce){}
        if(directorio.equals("") || directorio.equals("/"))
        try{
            directorio = Funciones.leer_ini("c:\\WSTransito.ini", "DIRECTORIO_PERSONAS_FIRMA");
            if(directorio.equals("") || directorio.equals("/"))
                directorio+="\\";
        }catch(Exception exce){}
            
        return directorio;
    }
    
    public String directorioPersonasFoto() {
                String directorio ="";
        try{
            directorio = Funciones.leer_ini("/WSTransito.ini", "DIRECTORIO_PERSONAS_FOTO");
            if(directorio.equals("") || directorio.equals("/"))
                directorio+="/";
        }catch(Exception exce){}
        if(directorio.equals("") || directorio.equals("/"))
        try{
            directorio = Funciones.leer_ini("c:\\WSTransito.ini", "DIRECTORIO_PERSONAS_FOTO");
            if(directorio.equals("") || directorio.equals("/"))
                directorio+="\\";
        }catch(Exception exce){}
            
        return directorio;
    }
    
    public String directorioPersonasHuella() {
        String directorio ="";
        try{
            directorio = Funciones.leer_ini("/WSTransito.ini", "DIRECTORIO_PERSONAS_HUELLA");
        }catch(Exception exce){}
        if(directorio.equals("") || directorio.equals("/"))
        try{
            directorio = Funciones.leer_ini("c:\\WSTransito.ini", "DIRECTORIO_PERSONAS_HUELLA");
        }catch(Exception exce){}

        return directorio;
    }
    @WebMethod
    public String actualizarRegistro_ini(String etiqueta, String nuevoValor) {
        String directorio ="";
        try{
            directorio = Funciones.actualizar_ini("/WSTransito.ini",etiqueta, nuevoValor);
        }catch(Exception exce){}
        
        System.out.println("DIRECTORIO: "+directorio);
        
        if(directorio.equals("") || directorio.equals("/"))
        try{
            directorio = Funciones.actualizar_ini("c:\\WSTransito.ini", etiqueta, nuevoValor);
        }catch(Exception exce){}

        return directorio;
    }
    
    public List directoriosFacturas() {
        List directorio = new ArrayList();
        directorio.add(directorioFacturasPlantillas());
        directorio.add(directorioFacturasTransito());
        directorio.add(directorioFacturasRunt());
        return directorio;
    }
    
    public String directorioCertificados() {
        String directorio ="";
        try{
            directorio = Funciones.leer_ini("/WSTransito.ini", "CERTIFICADOS");
        }catch(Exception exce){}
        if(directorio.equals("") || directorio.equals("/"))
        try{
            directorio = Funciones.leer_ini("c:\\WSTransito.ini", "CERTIFICADOS");
        }catch(Exception exce){}
        
        return directorio;
    }
    
    public String leerRegistroIni(String registroName) {
        String valor ="";
        try{
            valor = Funciones.leer_ini("/WSTransito.ini", registroName);
        }catch(Exception exce){}
        
        if(valor.equals(""))
        try{
            valor = Funciones.leer_ini("c:\\WSTransito.ini", registroName);
        }catch(Exception exce){}
        System.out.println("VALOR="+valor);
        return valor;
    }
    
    public int redondeoValorUnidad() {
        String valor ="";
        try{
            valor = Funciones.leer_ini("/WSTransito.ini", "REDONDEO_VALOR_UNIDAD");
        }catch(Exception exce){}
        if(valor.equals(""))
        try{
            valor = Funciones.leer_ini("c:\\WSTransito.ini", "REDONDEO_VALOR_UNIDAD");
        }catch(Exception exce){}
        return Integer.parseInt(valor);
    }
    
    public String usoRedondeo() {
        String valor ="";
        try{
            valor = Funciones.leer_ini("/WSTransito.ini", "USO_REDONDEO");
        }catch(Exception exce){}
        if(valor.equals(""))
        try{
            valor = Funciones.leer_ini("c:\\WSTransito.ini", "USO_REDONDEO");
        }catch(Exception exce){}
        return valor;
    }
    
    public String[] ipDelServidor() {
        return Funciones.getIpServidor();
    }
    
    public String[] ipServidorDocumentos() {
        return Funciones.getIpServidor();
    }
    
    public String encriptar(String variable, String ruta) {
            return Crypto.cifrar("S3rV1n7e5A1205!",variable, ruta);
        }
        
    public String desencriptar(String ruta) {
        return Crypto.descifrar("S3rV1n7e5A1205!", ruta,ruta+".tmp");
    }
}
