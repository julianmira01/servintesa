package modelo.logica.facturacion;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.facturacion.CamposCodBarFacDao;
import modelo.datos.objetos.facturacion.CamposCodBarFac;

import utilidades.Funciones;


public class GestionServiciosFacturacion {
    Conexion conexion;
    Connection conn;
    String myMotor;

    public GestionServiciosFacturacion() {
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

    public List getAllCampos() {
        List lista = null;
        CamposCodBarFacDao myDao = new CamposCodBarFacDao();
        try {
            conn = conexion.conectar();
            lista = myDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            conexion.cerrarCx();
            myDao = null;
        }
        return lista;
    }

   /* public String getPrefijo(CamposCodBarFac campoActual) {
        String respuesta = "";
        if (campoActual != null && campoActual.getPREFIJO() != "" && 
            campoActual.getPREFIJO() != null && campoActual.getPREFIJO().toLowerCase() != "null") {
            respuesta = "(" + campoActual.getPREFIJO() + ")";
        }
        return respuesta;
    }*/
    
    public String getPrefijo(CamposCodBarFac campoActual) {
        String respuesta = "";
        if (campoActual != null && campoActual.getPREFIJO() != "" && 
            campoActual.getPREFIJO() != null && campoActual.getPREFIJO().toLowerCase() != "null") {
            respuesta = "(" + campoActual.getPREFIJO() + ")";
        }
        return respuesta;
    }

    public String generarCodigoBarras(String identificacionCliente, String numFactura, String valorFactura,
                                      String fechaAAAAMMDD) {
        String CodigoBarras = "##########";
        try
        {
            CodigoBarras = "";
            System.out.println("Generando codigo de barras para: [codCliente]" + identificacionCliente +
                               " [numFactura]" + numFactura + " [valorFactura]" + valorFactura + " [fecha]" + fechaAAAAMMDD);
            List listaCampos = getAllCampos();
            CamposCodBarFac campoActual = new CamposCodBarFac();
            if (listaCampos != null && listaCampos.size() > 0) {
                campoActual = (CamposCodBarFac)listaCampos.get(0);
                CodigoBarras = getPrefijo(campoActual);
                CodigoBarras += completarValor(campoActual.getVALOR(), campoActual.getLONGITUD());
                campoActual = (CamposCodBarFac)listaCampos.get(1);
                CodigoBarras += getPrefijo(campoActual);
                CodigoBarras += completarValor(identificacionCliente, campoActual.getLONGITUD());
                campoActual = (CamposCodBarFac)listaCampos.get(2);
                CodigoBarras += getPrefijo(campoActual);
                CodigoBarras += completarValor(numFactura, campoActual.getLONGITUD());
                campoActual = (CamposCodBarFac)listaCampos.get(3);
                CodigoBarras += getPrefijo(campoActual);
                CodigoBarras += completarValor(valorFactura, campoActual.getLONGITUD());
                campoActual = (CamposCodBarFac)listaCampos.get(3);
                CodigoBarras += getPrefijo(campoActual);
                CodigoBarras += completarValor(fechaAAAAMMDD, campoActual.getLONGITUD());
            }
        }
        catch(Exception exp) {
            exp.printStackTrace();
        }
        System.out.println("Codigo de barras versi-*-n 1: " + CodigoBarras);
        return CodigoBarras;
    }
    
    public String generarCodigoBarras2(String identificacionCliente, String numFactura, String valorFactura,
                                      String fechaAAAAMMDD) {
        String CodigoBarras = "";
        
        try
        {
            CodigoBarras = "";
            
            System.out.println("Generando codigo de barras para: [codCliente]" + identificacionCliente +
                               " [numFactura]" + numFactura + " [valorFactura]" + valorFactura + " [fecha]" + fechaAAAAMMDD);
            List listaCampos = getAllCampos();
            
            CamposCodBarFac campoActual = new CamposCodBarFac();
            
            if (listaCampos != null && listaCampos.size() > 0) {
                campoActual = (CamposCodBarFac)listaCampos.get(0);
                CodigoBarras = getPrefijo(campoActual);
                CodigoBarras += completarValor(campoActual.getVALOR(), campoActual.getLONGITUD());
                campoActual = (CamposCodBarFac)listaCampos.get(1);
                CodigoBarras += getPrefijo(campoActual);
                CodigoBarras += completarValor(numFactura, campoActual.getLONGITUD());
                campoActual = (CamposCodBarFac)listaCampos.get(2);
                //int codigoAscii = 128;
                //CodigoBarras += (char)codigoAscii;
                CodigoBarras += getPrefijo(campoActual);
                //CodigoBarras += new String(new char[] { 29 });
                CodigoBarras += completarValor(valorFactura, campoActual.getLONGITUD());
                //CodigoBarras += (char)codigoAscii;
                campoActual = (CamposCodBarFac)listaCampos.get(3);
                CodigoBarras += getPrefijo(campoActual);
                CodigoBarras += completarValor(fechaAAAAMMDD, campoActual.getLONGITUD());
            }
        }
        catch(Exception exp) {
            exp.printStackTrace();
        }
        System.out.println("C-*-digo de barras versi-*-n 2: " + CodigoBarras);
        return CodigoBarras;
    }

    public String completarValor(String valorActual, int longitud) {
        int i;
        int faltantes = Math.abs(longitud - valorActual.length());
        if (valorActual.length() < longitud) {
            for (i = 0; i < faltantes; i++) {
                valorActual = "0" + valorActual;
            }
        } else 
        {
            valorActual = valorActual.substring(faltantes, longitud);
        }
        return valorActual;
    }


}
