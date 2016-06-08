package modelo.datos.objetos.comparendos.generales;

import java.io.*;

public class Viewestadoinfraccomp implements Cloneable, Serializable {
    private int ID_COMPARENDO;
    private int ID_VEHICULOCOMP;
    private int ID_INFRACTOR;
    private String NUMEROCOMPARENDO;
    private String FECHACOMPARENDO;
    private String HORACOMPARENDO;
    private String PLACA;
    private int ID_INFRACCIONCOMPARENDO;
    private int ID_INFRACCION;
    private String INFRACCION;
    private String COD_INFRACCION;
    private String NUEVO_CODIGO_INFRACCION;
    private double NUM_SALARIOS_MINIMOS;
    private int ID_ESTADO_COMPARENDO;
    private String COD_ESTADO_COMPARENDO;
    private String ESTADO_COMPARENDO;

    public Viewestadoinfraccomp() {

    }

    public Viewestadoinfraccomp(int ID_COMPARENDOIn) {

        this.ID_COMPARENDO = ID_COMPARENDOIn;
    }


    public int getID_COMPARENDO() {
        return this.ID_COMPARENDO;
    }

    public void setID_COMPARENDO(int ID_COMPARENDOIn) {
        this.ID_COMPARENDO = ID_COMPARENDOIn;
    }

    public int getID_VEHICULOCOMP() {
        return this.ID_VEHICULOCOMP;
    }

    public void setID_VEHICULOCOMP(int ID_VEHICULOCOMPIn) {
        this.ID_VEHICULOCOMP = ID_VEHICULOCOMPIn;
    }

    public int getID_INFRACTOR() {
        return this.ID_INFRACTOR;
    }

    public void setID_INFRACTOR(int ID_INFRACTORIn) {
        this.ID_INFRACTOR = ID_INFRACTORIn;
    }

    public String getNUMEROCOMPARENDO() {
        return this.NUMEROCOMPARENDO;
    }

    public void setNUMEROCOMPARENDO(String NUMEROCOMPARENDOIn) {
        this.NUMEROCOMPARENDO = NUMEROCOMPARENDOIn;
    }

    public String getFECHACOMPARENDO() {
        return this.FECHACOMPARENDO;
    }

    public void setFECHACOMPARENDO(String FECHACOMPARENDOIn) {
        this.FECHACOMPARENDO = FECHACOMPARENDOIn;
    }

    public String getHORACOMPARENDO() {
        return this.HORACOMPARENDO;
    }

    public void setHORACOMPARENDO(String HORACOMPARENDOIn) {
        this.HORACOMPARENDO = HORACOMPARENDOIn;
    }

    public String getPLACA() {
        return this.PLACA;
    }

    public void setPLACA(String PLACAIn) {
        this.PLACA = PLACAIn;
    }

    public int getID_INFRACCIONCOMPARENDO() {
        return this.ID_INFRACCIONCOMPARENDO;
    }

    public void setID_INFRACCIONCOMPARENDO(int ID_INFRACCIONCOMPARENDOIn) {
        this.ID_INFRACCIONCOMPARENDO = ID_INFRACCIONCOMPARENDOIn;
    }

    public int getID_INFRACCION() {
        return this.ID_INFRACCION;
    }

    public void setID_INFRACCION(int ID_INFRACCIONIn) {
        this.ID_INFRACCION = ID_INFRACCIONIn;
    }

    public String getINFRACCION() {
        return this.INFRACCION;
    }

    public void setINFRACCION(String INFRACCIONIn) {
        this.INFRACCION = INFRACCIONIn;
    }

    public String getCOD_INFRACCION() {
        return this.COD_INFRACCION;
    }

    public void setCOD_INFRACCION(String COD_INFRACCIONIn) {
        this.COD_INFRACCION = COD_INFRACCIONIn;
    }

    public String getNUEVO_CODIGO_INFRACCION() {
        return this.NUEVO_CODIGO_INFRACCION;
    }

    public void setNUEVO_CODIGO_INFRACCION(String NUEVO_CODIGO_INFRACCIONIn) {
        this.NUEVO_CODIGO_INFRACCION = NUEVO_CODIGO_INFRACCIONIn;
    }

    public double getNUM_SALARIOS_MINIMOS() {
        return this.NUM_SALARIOS_MINIMOS;
    }

    public void setNUM_SALARIOS_MINIMOS(double NUM_SALARIOS_MINIMOSIn) {
        this.NUM_SALARIOS_MINIMOS = NUM_SALARIOS_MINIMOSIn;
    }

    public int getID_ESTADO_COMPARENDO() {
        return this.ID_ESTADO_COMPARENDO;
    }

    public void setID_ESTADO_COMPARENDO(int ID_ESTADO_COMPARENDOIn) {
        this.ID_ESTADO_COMPARENDO = ID_ESTADO_COMPARENDOIn;
    }

    public String getCOD_ESTADO_COMPARENDO() {
        return this.COD_ESTADO_COMPARENDO;
    }

    public void setCOD_ESTADO_COMPARENDO(String COD_ESTADO_COMPARENDOIn) {
        this.COD_ESTADO_COMPARENDO = COD_ESTADO_COMPARENDOIn;
    }

    public String getESTADO_COMPARENDO() {
        return this.ESTADO_COMPARENDO;
    }

    public void setESTADO_COMPARENDO(String ESTADO_COMPARENDOIn) {
        this.ESTADO_COMPARENDO = ESTADO_COMPARENDOIn;
    }

    public String toString() {
        StringBuffer out = new StringBuffer();
        out.append("ID_COMPARENDO: " + this.ID_COMPARENDO);
        out.append("ID_VEHICULOCOMP: " + this.ID_VEHICULOCOMP);
        out.append("ID_INFRACTOR: " + this.ID_INFRACTOR);
        out.append("NUMEROCOMPARENDO: " + this.NUMEROCOMPARENDO);
        out.append("FECHACOMPARENDO: " + this.FECHACOMPARENDO);
        out.append("HORACOMPARENDO: " + this.HORACOMPARENDO);
        out.append("PLACA: " + this.PLACA);
        out.append("ID_INFRACCIONCOMPARENDO: " + this.ID_INFRACCIONCOMPARENDO);
        out.append("ID_INFRACCION: " + this.ID_INFRACCION);
        out.append("INFRACCION: " + this.INFRACCION);
        out.append("COD_INFRACCION: " + this.COD_INFRACCION);
        out.append("NUEVO_CODIGO_INFRACCION: " + this.NUEVO_CODIGO_INFRACCION);
        out.append("NUM_SALARIOS_MINIMOS: " + this.NUM_SALARIOS_MINIMOS);
        out.append("ID_ESTADO_COMPARENDO: " + this.ID_ESTADO_COMPARENDO);
        out.append("COD_ESTADO_COMPARENDO: " + this.COD_ESTADO_COMPARENDO);
        out.append("ESTADO_COMPARENDO: " + this.ESTADO_COMPARENDO);
        return out.toString();
    }
}
