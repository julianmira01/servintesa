package modelo.datos.objetos.comparendos.generales;

import java.io.*;

public class Procesos implements Cloneable, Serializable {
    private int ID_PROCESO;
    private String NOMBRE;

    public Procesos() {

    }

    public Procesos(int ID_PROCESOIn) {

        this.ID_PROCESO = ID_PROCESOIn;
    }


    public int getID_PROCESO() {
        return this.ID_PROCESO;
    }

    public void setID_PROCESO(int ID_PROCESOIn) {
        this.ID_PROCESO = ID_PROCESOIn;
    }

    public String getNOMBRE() {
        return this.NOMBRE;
    }

    public void setNOMBRE(String NOMBREIn) {
        this.NOMBRE = NOMBREIn;
    }

    public String toString() {
        StringBuffer out = new StringBuffer();
        out.append("ID_PROCESO: " + this.ID_PROCESO);
        out.append("NOMBRE: " + this.NOMBRE);
        return out.toString();
    }
}
