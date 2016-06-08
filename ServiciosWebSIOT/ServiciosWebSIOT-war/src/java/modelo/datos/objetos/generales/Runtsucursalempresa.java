package modelo.datos.objetos.generales;

import java.io.Serializable;

public class Runtsucursalempresa implements Cloneable, Serializable {
    private int ID_RUNTSUCURSAL;
    private String RAZON_SOCIAL;
    private String SIGLA;
    private String CELULAR;
    private int ID_SUCURSAL;
    private int EMPRESA;
    private int ID_REPRESENTANTE;
    private String EMAIL;
    private int ID_TIPOSOCIEDAD;

    public Runtsucursalempresa() {

    }

    public Runtsucursalempresa(int ID_RUNTSUCURSALIn) {

        this.ID_RUNTSUCURSAL = ID_RUNTSUCURSALIn;
    }


    public int getID_RUNTSUCURSAL() {
        return this.ID_RUNTSUCURSAL;
    }

    public void setID_RUNTSUCURSAL(int ID_RUNTSUCURSALIn) {
        this.ID_RUNTSUCURSAL = ID_RUNTSUCURSALIn;
    }

    public String getRAZON_SOCIAL() {
        return this.RAZON_SOCIAL;
    }

    public void setRAZON_SOCIAL(String RAZON_SOCIALIn) {
        this.RAZON_SOCIAL = RAZON_SOCIALIn;
    }

    public String getSIGLA() {
        return this.SIGLA;
    }

    public void setSIGLA(String SIGLAIn) {
        this.SIGLA = SIGLAIn;
    }

    public String getCELULAR() {
        return this.CELULAR;
    }

    public void setCELULAR(String CELULARIn) {
        this.CELULAR = CELULARIn;
    }

    public int getID_SUCURSAL() {
        return this.ID_SUCURSAL;
    }

    public void setID_SUCURSAL(int ID_SUCURSALIn) {
        this.ID_SUCURSAL = ID_SUCURSALIn;
    }

    public int getEMPRESA() {
        return this.EMPRESA;
    }

    public void setEMPRESA(int EMPRESAIn) {
        this.EMPRESA = EMPRESAIn;
    }

    public int getID_REPRESENTANTE() {
        return this.ID_REPRESENTANTE;
    }

    public void setID_REPRESENTANTE(int ID_REPRESENTANTEIn) {
        this.ID_REPRESENTANTE = ID_REPRESENTANTEIn;
    }

    public String getEMAIL() {
        return this.EMAIL;
    }

    public void setEMAIL(String EMAILIn) {
        this.EMAIL = EMAILIn;
    }

    public int getID_TIPOSOCIEDAD() {
        return this.ID_TIPOSOCIEDAD;
    }

    public void setID_TIPOSOCIEDAD(int ID_TIPOSOCIEDADIn) {
        this.ID_TIPOSOCIEDAD = ID_TIPOSOCIEDADIn;
    }
}
