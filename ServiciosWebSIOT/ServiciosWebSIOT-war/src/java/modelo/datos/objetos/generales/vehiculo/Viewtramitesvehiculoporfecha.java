package modelo.datos.objetos.generales.vehiculo;

import java.io.Serializable;

import java.util.Date;


public class Viewtramitesvehiculoporfecha implements Cloneable, Serializable {
    private int ID_TRAMITEINTERNO;
    private String CAPACIDADTON;
    private String PLACA;
    private String ANULADA;
    private Date FECHA;
    private String ID_LICTRANSITO;
    private int ID_TRAMITEVEH;
    private double NROCONSIGNACION;
    private String NIT;
    private int ID_CVEHICULO;
    private int ID_VEHICULO;
    private int ID_SERVICIO;
    private int ID_COLOR;
    private int ID_COMBUSTIBLE;
    private double NUMCONSIGNACIONVEHICULO;
    private String DESCRIPCION;
    private int ID_MODALIDADSERVICIO;
    private int ID_TCARROCERIA;
    private int GEN_IDTRANSITO;
    private String CAPACIDAD;
    private String REPORTAMINISTERIO;
    private double NUMRECIBO_LIQUIDACION;
    private Date FECHA_EXP;
    private int GEN_IDLICTRANSITO;
    private int GEN_HISTORIAVEHICULO;

    public Viewtramitesvehiculoporfecha() {

    }

    public Viewtramitesvehiculoporfecha(int ID_TRAMITEINTERNOIn) {

        this.ID_TRAMITEINTERNO = ID_TRAMITEINTERNOIn;
    }


    public int getID_TRAMITEINTERNO() {
        return this.ID_TRAMITEINTERNO;
    }

    public void setID_TRAMITEINTERNO(int ID_TRAMITEINTERNOIn) {
        this.ID_TRAMITEINTERNO = ID_TRAMITEINTERNOIn;
    }

    public String getCAPACIDADTON() {
        return this.CAPACIDADTON;
    }

    public void setCAPACIDADTON(String CAPACIDADTONIn) {
        this.CAPACIDADTON = CAPACIDADTONIn;
    }

    public String getPLACA() {
        return this.PLACA;
    }

    public void setPLACA(String PLACAIn) {
        this.PLACA = PLACAIn;
    }

    public String getANULADA() {
        return this.ANULADA;
    }

    public void setANULADA(String ANULADAIn) {
        this.ANULADA = ANULADAIn;
    }

    public Date getFECHA() {
        return this.FECHA;
    }

    public void setFECHA(Date FECHAIn) {
        this.FECHA = FECHAIn;
    }

    public String getID_LICTRANSITO() {
        return this.ID_LICTRANSITO;
    }

    public void setID_LICTRANSITO(String ID_LICTRANSITOIn) {
        this.ID_LICTRANSITO = ID_LICTRANSITOIn;
    }

    public int getID_TRAMITEVEH() {
        return this.ID_TRAMITEVEH;
    }

    public void setID_TRAMITEVEH(int ID_TRAMITEVEHIn) {
        this.ID_TRAMITEVEH = ID_TRAMITEVEHIn;
    }

    public double getNROCONSIGNACION() {
        return this.NROCONSIGNACION;
    }

    public void setNROCONSIGNACION(double NROCONSIGNACIONIn) {
        this.NROCONSIGNACION = NROCONSIGNACIONIn;
    }

    public String getNIT() {
        return this.NIT;
    }

    public void setNIT(String NITIn) {
        this.NIT = NITIn;
    }

    public int getID_CVEHICULO() {
        return this.ID_CVEHICULO;
    }

    public void setID_CVEHICULO(int ID_CVEHICULOIn) {
        this.ID_CVEHICULO = ID_CVEHICULOIn;
    }

    public int getID_VEHICULO() {
        return this.ID_VEHICULO;
    }

    public void setID_VEHICULO(int ID_VEHICULOIn) {
        this.ID_VEHICULO = ID_VEHICULOIn;
    }

    public int getID_SERVICIO() {
        return this.ID_SERVICIO;
    }

    public void setID_SERVICIO(int ID_SERVICIOIn) {
        this.ID_SERVICIO = ID_SERVICIOIn;
    }

    public int getID_COLOR() {
        return this.ID_COLOR;
    }

    public void setID_COLOR(int ID_COLORIn) {
        this.ID_COLOR = ID_COLORIn;
    }

    public int getID_COMBUSTIBLE() {
        return this.ID_COMBUSTIBLE;
    }

    public void setID_COMBUSTIBLE(int ID_COMBUSTIBLEIn) {
        this.ID_COMBUSTIBLE = ID_COMBUSTIBLEIn;
    }

    public double getNUMCONSIGNACIONVEHICULO() {
        return this.NUMCONSIGNACIONVEHICULO;
    }

    public void setNUMCONSIGNACIONVEHICULO(double NUMCONSIGNACIONVEHICULOIn) {
        this.NUMCONSIGNACIONVEHICULO = NUMCONSIGNACIONVEHICULOIn;
    }

    public String getDESCRIPCION() {
        return this.DESCRIPCION;
    }

    public void setDESCRIPCION(String DESCRIPCIONIn) {
        this.DESCRIPCION = DESCRIPCIONIn;
    }

    public int getID_MODALIDADSERVICIO() {
        return this.ID_MODALIDADSERVICIO;
    }

    public void setID_MODALIDADSERVICIO(int ID_MODALIDADSERVICIOIn) {
        this.ID_MODALIDADSERVICIO = ID_MODALIDADSERVICIOIn;
    }

    public int getID_TCARROCERIA() {
        return this.ID_TCARROCERIA;
    }

    public void setID_TCARROCERIA(int ID_TCARROCERIAIn) {
        this.ID_TCARROCERIA = ID_TCARROCERIAIn;
    }

    public int getGEN_IDTRANSITO() {
        return this.GEN_IDTRANSITO;
    }

    public void setGEN_IDTRANSITO(int GEN_IDTRANSITOIn) {
        this.GEN_IDTRANSITO = GEN_IDTRANSITOIn;
    }

    public String getCAPACIDAD() {
        return this.CAPACIDAD;
    }

    public void setCAPACIDAD(String CAPACIDADIn) {
        this.CAPACIDAD = CAPACIDADIn;
    }

    public String getREPORTAMINISTERIO() {
        return this.REPORTAMINISTERIO;
    }

    public void setREPORTAMINISTERIO(String REPORTAMINISTERIOIn) {
        this.REPORTAMINISTERIO = REPORTAMINISTERIOIn;
    }

    public double getNUMRECIBO_LIQUIDACION() {
        return this.NUMRECIBO_LIQUIDACION;
    }

    public void setNUMRECIBO_LIQUIDACION(double NUMRECIBO_LIQUIDACIONIn) {
        this.NUMRECIBO_LIQUIDACION = NUMRECIBO_LIQUIDACIONIn;
    }

    public Date getFECHA_EXP() {
        return this.FECHA_EXP;
    }

    public void setFECHA_EXP(Date FECHA_EXPIn) {
        this.FECHA_EXP = FECHA_EXPIn;
    }

    public int getGEN_IDLICTRANSITO() {
        return GEN_IDLICTRANSITO;
    }

    public void setGEN_IDLICTRANSITO(int GEN_IDLICTRANSITO) {
        this.GEN_IDLICTRANSITO = GEN_IDLICTRANSITO;
    }

    public int getGEN_HISTORIAVEHICULO() {
        return GEN_HISTORIAVEHICULO;
    }

    public void setGEN_HISTORIAVEHICULO(int GEN_HISTORIAVEHICULO) {
        this.GEN_HISTORIAVEHICULO = GEN_HISTORIAVEHICULO;
    }
}
