package modelo.datos.objetos.generales;

import java.io.*;

public class Auditoriatramite implements Cloneable, Serializable {
	 private String NOMBRE;
         private String APELLIDO;
         private int ID;
	 private String USUARIO;
         private int TARGET_TRAMITE;
	 private String PLACA_VEHICULO;
	 private String CEDULA_PERSONA;
	 private String TRAMITE;
	 private String FECHA;
	 private String HORA;
	 private int ACCION;
	 private String INFO_ADICIONAL;

	public Auditoriatramite(){

	}

	public Auditoriatramite(int IDIn) {

		this.ID = IDIn; 
	}


	public int getID() {
		return this.ID;
	}

	public void  setID(int IDIn) {
		this.ID = IDIn;
	}

	public int getTARGET_TRAMITE() {
		return this.TARGET_TRAMITE;
	}

	public void  setTARGET_TRAMITE(int TARGET_TRAMITEIn) {
		this.TARGET_TRAMITE = TARGET_TRAMITEIn;
	}

	public String getPLACA_VEHICULO() {
		return this.PLACA_VEHICULO;
	}

	public void  setPLACA_VEHICULO(String PLACA_VEHICULOIn) {
		this.PLACA_VEHICULO = PLACA_VEHICULOIn;
	}

	public String getCEDULA_PERSONA() {
		return this.CEDULA_PERSONA;
	}

	public void  setCEDULA_PERSONA(String CEDULA_PERSONAIn) {
		this.CEDULA_PERSONA = CEDULA_PERSONAIn;
	}

	public String getTRAMITE() {
		return this.TRAMITE;
	}

	public void  setTRAMITE(String TRAMITEIn) {
		this.TRAMITE = TRAMITEIn;
	}

	public String getFECHA() {
		return this.FECHA;
	}

	public void  setFECHA(String FECHAIn) {
		this.FECHA = FECHAIn;
	}

	public String getHORA() {
		return this.HORA;
	}

	public void  setHORA(String HORAIn) {
		this.HORA = HORAIn;
	}

	public int getACCION() {
		return this.ACCION;
	}

	public void  setACCION(int ACCIONIn) {
		this.ACCION = ACCIONIn;
	}

	public String getINFO_ADICIONAL() {
		return this.INFO_ADICIONAL;
	}

	public void  setINFO_ADICIONAL(String INFO_ADICIONALIn) {
		this.INFO_ADICIONAL = INFO_ADICIONALIn;
	}

	public String toString() {
		StringBuffer out = new StringBuffer();
		out.append("ID: "+this.ID);
		out.append("TARGET_TRAMITE: "+this.TARGET_TRAMITE);
		out.append("PLACA_VEHICULO: "+this.PLACA_VEHICULO);
		out.append("CEDULA_PERSONA: "+this.CEDULA_PERSONA);
		out.append("TRAMITE: "+this.TRAMITE);
		out.append("FECHA: "+this.FECHA);
		out.append("HORA: "+this.HORA);
		out.append("ACCION: "+this.ACCION);
		out.append("INFO_ADICIONAL: "+this.INFO_ADICIONAL);
		return out.toString();
	}

    public String getUSUARIO() {
        return USUARIO;
    }

    public void setUSUARIO(String USUARIO) {
        this.USUARIO = USUARIO;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getAPELLIDO() {
        return APELLIDO;
    }

    public void setAPELLIDO(String APELLIDO) {
        this.APELLIDO = APELLIDO;
    }
}
