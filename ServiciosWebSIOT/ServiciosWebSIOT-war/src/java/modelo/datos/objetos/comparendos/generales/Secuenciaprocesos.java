package modelo.datos.objetos.comparendos.generales;

import java.io.*;

public class Secuenciaprocesos implements Cloneable, Serializable {
    private int ID_SECUENCIAPROCESOS;
    private int ID_PROCESOPADRE;
    private int ID_PROCESOHIJO;
    private int ID_ESTADOINICIAL;
    private int ID_ESTADOFINAL;
    private int OPCIONAL;
    private String CONDICION;

    public Secuenciaprocesos() {

    }

    public Secuenciaprocesos(int ID_SECUENCIAPROCESOSIn) {

        this.ID_SECUENCIAPROCESOS = ID_SECUENCIAPROCESOSIn;
    }


    public int getID_SECUENCIAPROCESOS() {
        return this.ID_SECUENCIAPROCESOS;
    }

    public void setID_SECUENCIAPROCESOS(int ID_SECUENCIAPROCESOSIn) {
        this.ID_SECUENCIAPROCESOS = ID_SECUENCIAPROCESOSIn;
    }

    public int getID_PROCESOPADRE() {
        return this.ID_PROCESOPADRE;
    }

    public void setID_PROCESOPADRE(int ID_PROCESOPADREIn) {
        this.ID_PROCESOPADRE = ID_PROCESOPADREIn;
    }

    public int getID_PROCESOHIJO() {
        return this.ID_PROCESOHIJO;
    }

    public void setID_PROCESOHIJO(int ID_PROCESOHIJOIn) {
        this.ID_PROCESOHIJO = ID_PROCESOHIJOIn;
    }

    public int getID_ESTADOINICIAL() {
        return this.ID_ESTADOINICIAL;
    }

    public void setID_ESTADOINICIAL(int ID_ESTADOINICIALIn) {
        this.ID_ESTADOINICIAL = ID_ESTADOINICIALIn;
    }

    public int getID_ESTADOFINAL() {
        return this.ID_ESTADOFINAL;
    }

    public void setID_ESTADOFINAL(int ID_ESTADOFINALIn) {
        this.ID_ESTADOFINAL = ID_ESTADOFINALIn;
    }

    public int getOPCIONAL() {
        return this.OPCIONAL;
    }

    public void setOPCIONAL(int OPCIONALIn) {
        this.OPCIONAL = OPCIONALIn;
    }

    public String getCONDICION() {
        return this.CONDICION;
    }

    public void setCONDICION(String CONDICIONIn) {
        this.CONDICION = CONDICIONIn;
    }

    public String toString() {
        StringBuffer out = new StringBuffer();
        out.append("ID_SECUENCIAPROCESOS: " + this.ID_SECUENCIAPROCESOS);
        out.append("ID_PROCESOPADRE: " + this.ID_PROCESOPADRE);
        out.append("ID_PROCESOHIJO: " + this.ID_PROCESOHIJO);
        out.append("ID_ESTADOINICIAL: " + this.ID_ESTADOINICIAL);
        out.append("ID_ESTADOFINAL: " + this.ID_ESTADOFINAL);
        out.append("OPCIONAL: " + this.OPCIONAL);
        out.append("CONDICION: " + this.CONDICION);
        return out.toString();
    }
}
