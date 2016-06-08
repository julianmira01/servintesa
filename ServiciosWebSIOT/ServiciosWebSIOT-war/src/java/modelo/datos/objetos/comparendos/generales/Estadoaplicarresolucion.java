package modelo.datos.objetos.comparendos.generales;

import java.io.*;

public class Estadoaplicarresolucion implements Cloneable, Serializable {
    private int ID_ESTADOCOMP_RESOLUCION;
    private int ID_ESTADOCOMPARENDO;
    private int ID_TIPORESOLUCION;

    public Estadoaplicarresolucion() {

    }

    public Estadoaplicarresolucion(int ID_ESTADOCOMP_RESOLUCIONIn) {

        this.ID_ESTADOCOMP_RESOLUCION = ID_ESTADOCOMP_RESOLUCIONIn;
    }


    public int getID_ESTADOCOMP_RESOLUCION() {
        return this.ID_ESTADOCOMP_RESOLUCION;
    }

    public void setID_ESTADOCOMP_RESOLUCION(int ID_ESTADOCOMP_RESOLUCIONIn) {
        this.ID_ESTADOCOMP_RESOLUCION = ID_ESTADOCOMP_RESOLUCIONIn;
    }

    public int getID_ESTADOCOMPARENDO() {
        return this.ID_ESTADOCOMPARENDO;
    }

    public void setID_ESTADOCOMPARENDO(int ID_ESTADOCOMPARENDOIn) {
        this.ID_ESTADOCOMPARENDO = ID_ESTADOCOMPARENDOIn;
    }

    public int getID_TIPORESOLUCION() {
        return this.ID_TIPORESOLUCION;
    }

    public void setID_TIPORESOLUCION(int ID_TIPORESOLUCIONIn) {
        this.ID_TIPORESOLUCION = ID_TIPORESOLUCIONIn;
    }

    public String toString() {
        StringBuffer out = new StringBuffer();
        out.append("ID_ESTADOCOMP_RESOLUCION: " + this.ID_ESTADOCOMP_RESOLUCION);
        out.append("ID_ESTADOCOMPARENDO: " + this.ID_ESTADOCOMPARENDO);
        out.append("ID_TIPORESOLUCION: " + this.ID_TIPORESOLUCION);
        return out.toString();
    }
}
