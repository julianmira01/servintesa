package modelo.logica.generales;

import modelo.datos.objetos.generales.Persona;

import org.apache.axis2.databinding.types.HexBinary;

import utilidades.Archivo;


public class GestionBiometricos {

    boolean selH = false, selF = false, selFir = false;

    Archivo imagen;
    Persona persona;
    HexBinary dedo1, dedo2;
    int ndedo1, ndedo2;
    String rutafi = "../datosImagenes/fotos/";
    String rutahi = "../datosImagenes/huellas/";
    String rutafiri = "../datosImagenes/firmas/";
    String rutaf;
    String rutah;
    String rutafir;


    public GestionBiometricos() {
        super();
        crearObjetos();
    }

    public void crearObjetos() {
        imagen = new Archivo();

    }

    /*public String capturaGeneral() {
        String[] datosHuella = null;

        if (selH) {

            imagen.parseBase64ToFile(datosHuella[1], "huellas\\" + persona.getIDENTIFICACION().trim() + ".jpg");
            // System.out.println("Ole huella"+ole);
            persona.setTOKENHUELLA(datosHuella[0]);
            persona.setCODBIDIMENSIONAL(datosHuella[5]);
            byte[] d1 = Base64.decode(datosHuella[1]);
            byte[] d2 = Base64.decode(datosHuella[2]);
            ndedo1 = Integer.parseInt(datosHuella[3]);
            ndedo2 = Integer.parseInt(datosHuella[4]);
            dedo1 = new HexBinary(d1);
            dedo2 = new HexBinary(d2);
        }
        ///////////////////
        if (selFir) {
            imagen.parseBase64ToFile(datosHuella[6], "firmas\\" + persona.getIDENTIFICACION().trim() + ".jpg");
            //////////////////
            persona.setFIRMA(datosHuella[6]);
            rutafir = rutafiri + persona.getIDENTIFICACION().trim() + ".jpg";
        }
        if (selF) {
            imagen.parseBase64ToFile(datosHuella[7], "fotos\\" + persona.getIDENTIFICACION().trim() + ".jpg");
            persona.setFOTO(datosHuella[7]);
            rutaf = rutafi + persona.getIDENTIFICACION().trim() + ".jpg";
        }


        return "quieto";
    }*/


}
