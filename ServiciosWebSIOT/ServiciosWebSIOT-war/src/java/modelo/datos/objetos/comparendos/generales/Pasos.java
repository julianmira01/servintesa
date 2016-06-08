package modelo.datos.objetos.comparendos.generales;

import java.io.*;

public class Pasos implements Cloneable, Serializable {
    private int ID_PASO;
    private int ID_PROCESO;
    private int ID_PASOPADRE;
    private int IDTIPORESOLUCION;
    private int ID_TIPODOCGENERAR;
    private String NOMBRE;
    private String FORMULARIO;
    private double PORCENTAJEAVANCE;

    public Pasos() {

    }

    public Pasos(int ID_PASOIn) {

        this.ID_PASO = ID_PASOIn;
    }


    public int getID_PASO() {
        return this.ID_PASO;
    }

    public void setID_PASO(int ID_PASOIn) {
        this.ID_PASO = ID_PASOIn;
    }

    public int getID_PROCESO() {
        return this.ID_PROCESO;
    }

    public void setID_PROCESO(int ID_PROCESOIn) {
        this.ID_PROCESO = ID_PROCESOIn;
    }

    public int getID_PASOPADRE() {
        return this.ID_PASOPADRE;
    }

    public void setID_PASOPADRE(int ID_PASOPADREIn) {
        this.ID_PASOPADRE = ID_PASOPADREIn;
    }

    public int getIDTIPORESOLUCION() {
        return this.IDTIPORESOLUCION;
    }

    public void setIDTIPORESOLUCION(int IDTIPORESOLUCIONIn) {
        this.IDTIPORESOLUCION = IDTIPORESOLUCIONIn;
    }

    public int getID_TIPODOCGENERAR() {
        return this.ID_TIPODOCGENERAR;
    }

    public void setID_TIPODOCGENERAR(int ID_TIPODOCGENERARIn) {
        this.ID_TIPODOCGENERAR = ID_TIPODOCGENERARIn;
    }

    public String getNOMBRE() {
        return this.NOMBRE;
    }

    public void setNOMBRE(String NOMBREIn) {
        this.NOMBRE = NOMBREIn;
    }

    public String getFORMULARIO() {
        return this.FORMULARIO;
    }

    public void setFORMULARIO(String FORMULARIOIn) {
        this.FORMULARIO = FORMULARIOIn;
    }

    public double getPORCENTAJEAVANCE() {
        return this.PORCENTAJEAVANCE;
    }

    public void setPORCENTAJEAVANCE(double PORCENTAJEAVANCEIn) {
        this.PORCENTAJEAVANCE = PORCENTAJEAVANCEIn;
    }

    public String toString() {
        StringBuffer out = new StringBuffer();
        out.append("ID_PASO: " + this.ID_PASO);
        out.append("ID_PROCESO: " + this.ID_PROCESO);
        out.append("ID_PASOPADRE: " + this.ID_PASOPADRE);
        out.append("IDTIPORESOLUCION: " + this.IDTIPORESOLUCION);
        out.append("ID_TIPODOCGENERAR: " + this.ID_TIPODOCGENERAR);
        out.append("NOMBRE: " + this.NOMBRE);
        out.append("FORMULARIO: " + this.FORMULARIO);
        out.append("PORCENTAJEAVANCE: " + this.PORCENTAJEAVANCE);
        return out.toString();
    }
}
