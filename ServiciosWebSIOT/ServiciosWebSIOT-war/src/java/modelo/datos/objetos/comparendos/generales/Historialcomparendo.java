package modelo.datos.objetos.comparendos.generales;

import java.io.*;

public class Historialcomparendo implements Cloneable, Serializable {
    private int ID_HISTORIALCOMPARENDO;
    private int ID_INFRACCIONCOMPARENDO;
    private int ID_PASO;
    private int ID_DOCSRESOLUCIONES;
    private int ID_DOCSACTAS;
    private double AVANCEPROCESO;
    private int ID_USUARIO;
    private String FECHA;
    private String HORA;
    private String IP;
    private String NOMBREEQUIPO;

    public Historialcomparendo() {

    }

    public Historialcomparendo(int ID_HISTORIALCOMPARENDOIn) {

        this.ID_HISTORIALCOMPARENDO = ID_HISTORIALCOMPARENDOIn;
    }


    public int getID_HISTORIALCOMPARENDO() {
        return this.ID_HISTORIALCOMPARENDO;
    }

    public void setID_HISTORIALCOMPARENDO(int ID_HISTORIALCOMPARENDOIn) {
        this.ID_HISTORIALCOMPARENDO = ID_HISTORIALCOMPARENDOIn;
    }

    public int getID_INFRACCIONCOMPARENDO() {
        return this.ID_INFRACCIONCOMPARENDO;
    }

    public void setID_INFRACCIONCOMPARENDO(int ID_INFRACCIONCOMPARENDOIn) {
        this.ID_INFRACCIONCOMPARENDO = ID_INFRACCIONCOMPARENDOIn;
    }

    public int getID_PASO() {
        return this.ID_PASO;
    }

    public void setID_PASO(int ID_PASOIn) {
        this.ID_PASO = ID_PASOIn;
    }

    public int getID_DOCSRESOLUCIONES() {
        return this.ID_DOCSRESOLUCIONES;
    }

    public void setID_DOCSRESOLUCIONES(int ID_DOCSRESOLUCIONESIn) {
        this.ID_DOCSRESOLUCIONES = ID_DOCSRESOLUCIONESIn;
    }

    public int getID_DOCSACTAS() {
        return this.ID_DOCSACTAS;
    }

    public void setID_DOCSACTAS(int ID_DOCSACTASIn) {
        this.ID_DOCSACTAS = ID_DOCSACTASIn;
    }

    public double getAVANCEPROCESO() {
        return this.AVANCEPROCESO;
    }

    public void setAVANCEPROCESO(double AVANCEPROCESOIn) {
        this.AVANCEPROCESO = AVANCEPROCESOIn;
    }

    public int getID_USUARIO() {
        return this.ID_USUARIO;
    }

    public void setID_USUARIO(int ID_USUARIOIn) {
        this.ID_USUARIO = ID_USUARIOIn;
    }

    public String getFECHA() {
        return this.FECHA;
    }

    public void setFECHA(String FECHAIn) {
        this.FECHA = FECHAIn;
    }

    public String getHORA() {
        return this.HORA;
    }

    public void setHORA(String HORAIn) {
        this.HORA = HORAIn;
    }

    public String getIP() {
        return this.IP;
    }

    public void setIP(String IPIn) {
        this.IP = IPIn;
    }

    public String getNOMBREEQUIPO() {
        return this.NOMBREEQUIPO;
    }

    public void setNOMBREEQUIPO(String NOMBREEQUIPOIn) {
        this.NOMBREEQUIPO = NOMBREEQUIPOIn;
    }

    public String toString() {
        StringBuffer out = new StringBuffer();
        out.append("ID_HISTORIALCOMPARENDO: " + this.ID_HISTORIALCOMPARENDO);
        out.append("ID_INFRACCIONCOMPARENDO: " + this.ID_INFRACCIONCOMPARENDO);
        out.append("ID_PASO: " + this.ID_PASO);
        out.append("ID_DOCSRESOLUCIONES: " + this.ID_DOCSRESOLUCIONES);
        out.append("ID_DOCSACTAS: " + this.ID_DOCSACTAS);
        out.append("AVANCEPROCESO: " + this.AVANCEPROCESO);
        out.append("ID_USUARIO: " + this.ID_USUARIO);
        out.append("FECHA: " + this.FECHA);
        out.append("HORA: " + this.HORA);
        out.append("IP: " + this.IP);
        out.append("NOMBREEQUIPO: " + this.NOMBREEQUIPO);
        return out.toString();
    }
}
